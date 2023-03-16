package project.app.login;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Hex;
import org.springframework.beans.factory.annotation.Autowired;

import de.taimos.totp.TOTP;
import project.common.extend.BaseBiz;
import project.common.module.commoncode.CommonCodeManager;
import project.common.module.key.KeyManager;
import project.conf.resource.ormapper.dao.SysUser.SysUserDao;
import project.conf.resource.ormapper.dto.oracle.SysUser;
import zebra.crypto.CryptoUtil;
import zebra.data.DataSet;
import zebra.data.ParamEntity;
import zebra.exception.FrameworkException;
import zebra.util.CommonUtil;
import zebra.util.ConfigUtil;

public class LoginBizImpl extends BaseBiz implements LoginBiz {
	@Autowired
	private SysUserDao sysUserDao;
	@Autowired
	private LoginMessageSender loginMessageSender;

	public ParamEntity index(ParamEntity paramEntity) throws Exception {
		HttpServletRequest request = paramEntity.getRequest();
		HttpSession session = paramEntity.getSession();
		String language = request.getLocale().getLanguage();

		try {
			session.setAttribute("langCode", language);
			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}

	public ParamEntity exeRequestRegister(ParamEntity paramEntity) throws Exception {
		DataSet requestDataSet = paramEntity.getRequestDataSet();
		SysUser sysUser = new SysUser();
		String loginId = requestDataSet.getValue("loginId");
		String email = requestDataSet.getValue("email");
		String isSendEmail = CommonUtil.nvl(requestDataSet.getValue("sendEmail"), "N");
		String photoPathName = ConfigUtil.getProperty("path.image.photo")+"/"+"DefaultUser_128_Black.png";
		String pass = CryptoUtil.decryptInput(requestDataSet.getValue("password"), CryptoUtil.encodeKey(ConfigUtil.getProperty("etc.crypto.key")));
		String confPass = CryptoUtil.decryptInput(requestDataSet.getValue("passwordConfirm"), CryptoUtil.encodeKey(ConfigUtil.getProperty("etc.crypto.key")));
		int result = -1;

		try {
			// Check if pass and confirm pass are matching
			if (!CommonUtil.equals(pass, confPass)) {
				throw new FrameworkException("E915", getMessage("E915", paramEntity));
			}

			// Check if the user already exists with the login id and password
			sysUser = sysUserDao.getUserByLoginIdAndPassword(loginId, pass);
			if (!(sysUser == null || CommonUtil.isEmpty(sysUser.getUserId()))) {
				throw new FrameworkException("E912", getMessage("E912", paramEntity));
			}

			// Sets SysUser object and save it
			sysUser = new SysUser();
			sysUser.setUserId(KeyManager.getId("SYS_USER_S"));
			sysUser.setUserName(requestDataSet.getValue("userName"));
			sysUser.setLoginId(requestDataSet.getValue("loginId"));
			sysUser.setLoginPassword(pass);
			sysUser.setAuthGroupId("Z");
			sysUser.setLanguage(ConfigUtil.getProperty("etc.default.language"));
			sysUser.setThemeType(ConfigUtil.getProperty("view.theme.default"));
			sysUser.setMaxRowPerPage(CommonUtil.toDouble(CommonUtil.split(ConfigUtil.getProperty("view.data.maxRowsPerPage"), ConfigUtil.getProperty("delimiter.data"))[2]));
			sysUser.setPageNumPerPage(CommonUtil.toDouble(CommonUtil.split(ConfigUtil.getProperty("view.data.pageNumsPerPage"), ConfigUtil.getProperty("delimiter.data"))[0]));
			sysUser.setUserType(CommonCodeManager.getCodeByConstants("USER_TYPE_INTERNAL"));
			sysUser.setEmail(email);
			sysUser.setUserStatus(CommonCodeManager.getCodeByConstants("USER_STATUS_RR"));
			sysUser.setPhotoPath(photoPathName);
			sysUser.setDefaultStartUrl("/index/dashboard.do");
			sysUser.setIsActive(CommonCodeManager.getCodeByConstants("IS_ACTIVE_N"));
			sysUser.setAuthenticationSecretKey(CommonUtil.getAuthenticationSecretKey());
			sysUser.setPersonId("0");
			sysUser.setInsertUserId("0");
			sysUser.setInsertDate(CommonUtil.getSysdateAsDate());

			result = sysUserDao.insert(sysUser);
			if (result <= 0) {
				throw new FrameworkException("E801", getMessage("E801", paramEntity));
			}

			// Sends email to the user
			if (CommonUtil.equals(isSendEmail, "Y")) {
				loginMessageSender.sendRequestRegisterMessage(sysUser, email);
			}

			paramEntity.setSuccess(true);
			paramEntity.setMessage("I801", getMessage("I801", paramEntity));
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}

	public ParamEntity exeLogin(ParamEntity paramEntity) throws Exception {
		DataSet requestDataSet = paramEntity.getRequestDataSet();
		SysUser sysUser = new SysUser();
		String loginId = requestDataSet.getValue("loginId");
		String password = requestDataSet.getValue("password");
		String loginAuthEmailKey = ConfigUtil.getProperty("login.auth.emailKey");
		String email = "", authKey = "";

		try {
			// Check with LoginID
			sysUser = sysUserDao.getUserByLoginId(loginId);
			if (sysUser == null || CommonUtil.isBlank(sysUser.getUserId())) {
				throw new FrameworkException("E907", getMessage("E907", paramEntity));
			}

			// Check with LoginID and Password
			sysUser = sysUserDao.getUserByLoginIdAndPassword(loginId, CryptoUtil.decryptInput(password, CryptoUtil.encodeKey(ConfigUtil.getProperty("etc.crypto.key"))));
			if (sysUser == null || CommonUtil.isBlank(sysUser.getUserId())) {
				throw new FrameworkException("E908", getMessage("E908", paramEntity));
			}

			// Check if isActive with LoginID and Password
			sysUser = sysUserDao.getActiveUserByLoginIdAndPassword(loginId, CryptoUtil.decryptInput(password, CryptoUtil.encodeKey(ConfigUtil.getProperty("etc.crypto.key"))));
			if (sysUser == null || CommonUtil.isBlank(sysUser.getUserId())) {
				throw new FrameworkException("E916", getMessage("E916", paramEntity));
			}

			paramEntity.setObject("sysUser", sysUser);

			if (CommonUtil.toBoolean(loginAuthEmailKey)) {
				Random random = new Random();

				email = sysUser.getEmail();
				authKey = CommonUtil.leftPad(CommonUtil.toString(random.nextInt(999999)), 6, "0");
				paramEntity.setObject("authenticationKey", authKey);
				loginMessageSender.sendAuthKey(sysUser, email, authKey);
			}

			paramEntity.setSuccess(true);
			paramEntity.setMessage("I903", getMessage("I903", paramEntity));
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}

	public ParamEntity setSessionValuesForAdminTool(ParamEntity paramEntity) throws Exception {
		DataSet requestDataSet = paramEntity.getRequestDataSet();
		String database = requestDataSet.getValue("databaseAdminTool");
		DataSet resultDataSet = new DataSet();

		try {
			resultDataSet.addName(new String[] {"database"});
			resultDataSet.addRow();
			resultDataSet.setValue("database", database);

			paramEntity.setAjaxResponseDataSet(resultDataSet);
			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}

	public ParamEntity doAuthentication(ParamEntity paramEntity) throws Exception {
		String secretKey = "";
		HttpSession session = paramEntity.getSession();
		DataSet requestDataSet = paramEntity.getRequestDataSet();
		DataSet resultDataSet = new DataSet();
		Base32 base32 = new Base32();
		byte[] bytes;
		String mode = requestDataSet.getValue("mode");
		String inputCode = requestDataSet.getValue("inputCode");
		String isAuthenticated = "", hexKey = "", authCode = "";

		try {
			if (CommonUtil.equalsIgnoreCase(mode, "google2fa")) {
				SysUser sysUser = (SysUser)session.getAttribute("SysUser");
				secretKey = sysUser.getAuthenticationSecretKey();

				if (CommonUtil.isBlank(secretKey)) {
					throw new FrameworkException("E913", getMessage("E913", paramEntity));
				}

				bytes = base32.decode(secretKey);
				hexKey = Hex.encodeHexString(bytes);
				authCode = TOTP.getOTP(hexKey);
				isAuthenticated = CommonUtil.equals(inputCode, authCode) ? "true" : "false";
				paramEntity.setObject("authenticationKey", authCode);
			} else if (CommonUtil.equalsIgnoreCase(mode, "emailKey")) {
				authCode = (String)session.getAttribute("AuthenticationKey");
				isAuthenticated = CommonUtil.equals(inputCode, authCode) ? "true" : "false";
			} else {
				isAuthenticated = "true";
			}

			resultDataSet.addColumn("isAuthenticated", isAuthenticated);

			paramEntity.setObject("isAuthenticated", isAuthenticated);
			paramEntity.setAjaxResponseDataSet(resultDataSet);
			paramEntity.setSuccess(true);

			return paramEntity;
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
	}
}