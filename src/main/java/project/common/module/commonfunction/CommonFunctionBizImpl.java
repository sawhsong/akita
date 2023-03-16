package project.common.module.commonfunction;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import project.common.extend.BaseBiz;
import project.common.module.menu.MenuManager;
import project.conf.resource.ormapper.dao.SysFavoriteMenu.SysFavoriteMenuDao;
import project.conf.resource.ormapper.dao.SysUser.SysUserDao;
import project.conf.resource.ormapper.dto.oracle.SysFavoriteMenu;
import project.conf.resource.ormapper.dto.oracle.SysUser;
import zebra.config.MemoryBean;
import zebra.crypto.CryptoUtil;
import zebra.data.DataSet;
import zebra.data.ParamEntity;
import zebra.exception.FrameworkException;
import zebra.util.CommonUtil;
import zebra.util.ConfigUtil;
import zebra.util.FileUtil;

public class CommonFunctionBizImpl extends BaseBiz implements CommonFunctionBiz {
	@Autowired
	private SysUserDao sysUserDao;
	@Autowired
	private SysFavoriteMenuDao sysFavoriteMenuDao;
	@Autowired
	private CommonFunctionMessageSender messageSender;

	public ParamEntity getPrivateKey(ParamEntity paramEntity) throws Exception {
		DataSet ds = new DataSet();

		try {
			ds.addColumn("key", CryptoUtil.encodeKey(ConfigUtil.getProperty("etc.crypto.key")));

			paramEntity.setAjaxResponseDataSet(ds);
			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}

	public ParamEntity getResetPassword(ParamEntity paramEntity) throws Exception {
		try {
			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}

	public ParamEntity doResetPassword(ParamEntity paramEntity) throws Exception {
		DataSet requestDataSet = paramEntity.getRequestDataSet();
		DataSet userDataSet = new DataSet();
		SysUser sysUser = new SysUser();
		String randomString = CommonUtil.getRandomAlphanumeric(12);
		String loginId = requestDataSet.getValue("loginId");
		String email = requestDataSet.getValue("email");
		int result = -1;

		try {
			// Check if the user exists
			userDataSet = sysUserDao.getUserInfoDataSetByLoginId(loginId);
			if (userDataSet.getRowCnt() <= 0) {
				throw new FrameworkException("E907", getMessage("E907", paramEntity));
			}

			// Check if the email is matching
			userDataSet = sysUserDao.getUserInfoDataSetByLoginIdAndEmail(loginId, email);
			if (userDataSet.getRowCnt() <= 0) {
				throw new FrameworkException("E914", getMessage("E914", paramEntity));
			}

			// Initailise the password
			result = sysUserDao.resetPasswordByLoginId(loginId, randomString);
			if (result <= 0) {
				throw new FrameworkException("E801", getMessage("E801", paramEntity));
			}

			// Select SysUser
			sysUser = sysUserDao.getUserByLoginId(loginId);

			messageSender.sendResetPasswordMessage(sysUser, randomString);

			paramEntity.setSuccess(true);
			paramEntity.setMessage("I805", getMessage("I805", paramEntity));
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}

	public ParamEntity getUserProfile(ParamEntity paramEntity) throws Exception {
		DataSet requestDataSet = paramEntity.getRequestDataSet();
		SysUser sysUser = new SysUser();
		String userId = requestDataSet.getValue("userId");
		String maxRowPerPage[], pageNumPerPage[];

		try {
			sysUser = sysUserDao.getUserByUserId(userId);

			maxRowPerPage = CommonUtil.split(ConfigUtil.getProperty("view.data.maxRowsPerPage"), ConfigUtil.getProperty("delimiter.data"));
			pageNumPerPage = CommonUtil.split(ConfigUtil.getProperty("view.data.pageNumsPerPage"), ConfigUtil.getProperty("delimiter.data"));

			paramEntity.setObject("sysUser", sysUser);
			paramEntity.setObject("maxRowPerPage", maxRowPerPage);
			paramEntity.setObject("pageNumPerPage", pageNumPerPage);
			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}

	public ParamEntity doUpdateUserProfile(ParamEntity paramEntity) throws Exception {
		DataSet requestDataSet = paramEntity.getRequestDataSet();
		DataSet dsFile = paramEntity.getRequestFileDataSet();
		String userId = requestDataSet.getValue("userId");
		String rootPath = (String)MemoryBean.get("applicationRealPath");
		String appSrcRootPath = (String)MemoryBean.get("applicationSrcPathWeb");
		String pathToSave = ConfigUtil.getProperty("path.image.photo");
		SysUser sysUser = new SysUser();
		HttpSession session = paramEntity.getSession();
		int result = -1;
		File files[], tempFile;

		try {
			sysUser = sysUserDao.getUserByUserId(userId);

			sysUser.setUserName(requestDataSet.getValue("userName"));
			sysUser.setLoginId(requestDataSet.getValue("loginId"));
			sysUser.setLanguage(requestDataSet.getValue("language"));
			sysUser.setThemeType(requestDataSet.getValue("themeType"));
			sysUser.setMaxRowPerPage(CommonUtil.toDouble(requestDataSet.getValue("maxRowsPerPage")));
			sysUser.setPageNumPerPage(CommonUtil.toDouble(requestDataSet.getValue("pageNumsPerPage")));
			sysUser.setEmail(requestDataSet.getValue("email"));
			sysUser.setAuthenticationSecretKey(requestDataSet.getValue("authenticationSecretKey"));
			sysUser.setUpdateUserId((String)session.getAttribute("UserId"));
			sysUser.setUpdateDate(CommonUtil.toDate(CommonUtil.getSysdate()));

			if (dsFile.getRowCnt() > 0) {
				String fileName = dsFile.getValue("NEW_NAME"), fullPath = "", copyToPath = "";

				fileName = userId+"_"+fileName;
				fullPath = rootPath+pathToSave+"/"+fileName;
				copyToPath = appSrcRootPath+pathToSave+"/"+fileName;

				files = new File(rootPath+pathToSave).listFiles();
				for (File file : files) {
					if (CommonUtil.startsWith(file.getName(), userId+"_")) {
						FileUtil.forceDelete(file);
						break;
					}
				}
				FileUtil.moveFile(dsFile, fullPath);

				try {
					tempFile = new File(appSrcRootPath+pathToSave);
					if (tempFile != null && tempFile.isDirectory()) {
						files = new File(appSrcRootPath+pathToSave).listFiles();
						for (File file : files) {
							if (CommonUtil.startsWith(file.getName(), userId+"_")) {
								FileUtil.forceDelete(file);
								break;
							}
						}
						FileUtil.copyFile(new File(fullPath), new File(copyToPath));
					}
				} catch (Exception e) {
				}

				sysUser.setPhotoPath(pathToSave+"/"+fileName);
			}

			sysUser.addUpdateColumnFromField();
			result = sysUserDao.update(userId, sysUser);
			if (result <= 0) {
				throw new FrameworkException("E801", getMessage("E801", paramEntity));
			}

			paramEntity.setSuccess(true);
			paramEntity.setMessage("I801", getMessage("I801", paramEntity));
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}

	public ParamEntity hasAuthKey(ParamEntity paramEntity) throws Exception {
		HttpSession session = paramEntity.getSession();
		DataSet resultDataSet = new DataSet();

		try {
			SysUser sysUser = (SysUser)session.getAttribute("SysUser");

			resultDataSet.addColumn("hasAuthKey", CommonUtil.isNotBlank(sysUser.getAuthenticationSecretKey()) ? "true" : "false");

			paramEntity.setAjaxResponseDataSet(resultDataSet);
			paramEntity.setSuccess(true);

			return paramEntity;
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
	}

	public ParamEntity getAuthenticationSecretKey(ParamEntity paramEntity) throws Exception {
		DataSet resultDataSet = new DataSet();

		try {
			resultDataSet.addColumn("authenticationSecretKey", CommonUtil.getAuthenticationSecretKey());

			paramEntity.setAjaxResponseDataSet(resultDataSet);
			paramEntity.setSuccess(true);

			return paramEntity;
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
	}

	public ParamEntity getChangePassword(ParamEntity paramEntity) throws Exception {
		try {
			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}

	public ParamEntity doChangePassword(ParamEntity paramEntity) throws Exception {
		DataSet requestDataSet = paramEntity.getRequestDataSet();
		SysUser sysUser = new SysUser();
		String loginId = requestDataSet.getValue("loginId");
		String oldPass = CryptoUtil.decryptInput(requestDataSet.getValue("oldPassword"), CryptoUtil.encodeKey(ConfigUtil.getProperty("etc.crypto.key")));
		String newPass = CryptoUtil.decryptInput(requestDataSet.getValue("newPassword"), CryptoUtil.encodeKey(ConfigUtil.getProperty("etc.crypto.key")));
		String confPass = CryptoUtil.decryptInput(requestDataSet.getValue("confirmPassword"), CryptoUtil.encodeKey(ConfigUtil.getProperty("etc.crypto.key")));
		int result = -1;

		try {
			// Check if new pass and confirm pass are matching
			if (!CommonUtil.equals(newPass, confPass)) {
				throw new FrameworkException("E915", getMessage("E915", paramEntity));
			}

			// Check with LoginID
			sysUser = sysUserDao.getUserByLoginId(loginId);
			if (sysUser == null || CommonUtil.isBlank(sysUser.getUserId())) {
				throw new FrameworkException("E907", getMessage("E907", paramEntity));
			}

			// Check with LoginID and Password
			sysUser = sysUserDao.getUserByLoginIdAndPassword(loginId, oldPass);
			if (sysUser == null || CommonUtil.isBlank(sysUser.getUserId())) {
				throw new FrameworkException("E916", getMessage("E916", paramEntity));
			}

			// Change password
			result = sysUserDao.changePasswordByLoginId(loginId, confPass);
			if (result <= 0) {
				throw new FrameworkException("E801", getMessage("E801", paramEntity));
			}

			paramEntity.setSuccess(true);
			paramEntity.setMessage("I804", getMessage("I804", paramEntity));
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}

	public ParamEntity saveFavoriteMenu(ParamEntity paramEntity) throws Exception {
		DataSet requestDataSet = paramEntity.getRequestDataSet();
		HttpSession session = paramEntity.getSession();
		String menuId = requestDataSet.getValue("menuId");
		String userId = (String)session.getAttribute("UserId");
		DataSet favoriteMenu = MenuManager.getFavoriteMenuDataSet(userId);
		SysFavoriteMenu sysFavoriteMenu = new SysFavoriteMenu();

		try {
			if (favoriteMenu.getRowIndex("LEFT_MENU_ID", menuId) < 0) {
				sysFavoriteMenu.setUserId(userId);
				sysFavoriteMenu.setMenuId(menuId);
				sysFavoriteMenu.setInsertUserId(userId);
				sysFavoriteMenu.setInsertDate(CommonUtil.getSysdateAsDate());

				sysFavoriteMenuDao.insert(sysFavoriteMenu);
			}

			paramEntity.setSuccess(true);
			paramEntity.setMessage("I801", getMessage("I801", paramEntity));
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}

	public ParamEntity getFavoriteMenu(ParamEntity paramEntity) throws Exception {
		try {
			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}

	public ParamEntity getFavoriteMenuList(ParamEntity paramEntity) throws Exception {
		HttpSession session = paramEntity.getSession();
		String userId = (String)session.getAttribute("UserId");

		try {
			paramEntity.setAjaxResponseDataSet(MenuManager.getFavoriteMenuDataSet(userId));
			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}

	public ParamEntity doDeleteFavoriteMenu(ParamEntity paramEntity) throws Exception {
		DataSet requestDataSet = paramEntity.getRequestDataSet();
		HttpSession session = paramEntity.getSession();
		String chkForDel = requestDataSet.getValue("chkForDel");
		String menuIds[] = CommonUtil.splitWithTrim(chkForDel, ConfigUtil.getProperty("delimiter.record"));
		String userId = (String)session.getAttribute("UserId");
		int result = 0;

		try {
			result = sysFavoriteMenuDao.delete(userId, menuIds);

			if (result <= 0) {
				throw new FrameworkException("E801", getMessage("E801", paramEntity));
			}

			paramEntity.setSuccess(true);
			paramEntity.setMessage("I801", getMessage("I801", paramEntity));
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}
}