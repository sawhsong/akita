package project.conf.resource.ormapper.dao.SysUser;

import project.common.extend.BaseHDao;
import project.common.module.commoncode.CommonCodeManager;
import project.conf.resource.ormapper.dto.oracle.SysUser;
import zebra.base.Dto;
import zebra.data.DataSet;
import zebra.data.QueryAdvisor;
import zebra.util.CommonUtil;
import zebra.util.ConfigUtil;

public class SysUserHDaoImpl extends BaseHDao implements SysUserDao {
	public int insert(Dto dto) throws Exception {
		int result = -1;
//		result = insertWithSQLQuery(dto);
		result = insertWithDto(dto);
		result = encryptPasswordByUserId(((SysUser)dto).getUserId());
		return result;
	}

	public int update(String userId, Dto dto) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		queryAdvisor.addWhereClause("user_id = '"+userId+"'");
		return updateColumns(queryAdvisor, dto);
	}

	public int resetPasswordByLoginId(String loginId, String randomString) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		SysUser sysUser = new SysUser();
		int result = -1;

		sysUser = getUserByLoginId(loginId);

		sysUser.setLoginPassword(randomString);
		sysUser.addUpdateColumnFromField();

		queryAdvisor.addWhereClause("is_active = 'Y'");
		queryAdvisor.addWhereClause("user_status = '"+CommonCodeManager.getCodeByConstants("USER_STATUS_NU")+"'");
		queryAdvisor.addWhereClause("login_id = '"+loginId+"'");

		result = updateColumns(queryAdvisor, sysUser);
		result = encryptPasswordByLoginId(loginId);

		return result;
	}

	public int changePasswordByLoginId(String loginId, String newPassword) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		SysUser sysUser = new SysUser();
		int result = -1;

		sysUser = getUserByLoginId(loginId);

		sysUser.setLoginPassword(newPassword);
		sysUser.addUpdateColumnFromField();

		queryAdvisor.addWhereClause("login_id = '"+loginId+"'");

		result = updateColumns(queryAdvisor, sysUser);
		result = encryptPasswordByLoginId(loginId);

		return result;
	}

	public int updateAuthGroupIdByAuthGroupIds(String authGroupIds[], String toCode) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		String idsForDel = "";
		int result = 0;
		SysUser sysUser = new SysUser();

		if (!(authGroupIds == null || authGroupIds.length == 0)) {
			for (int i=0; i<authGroupIds.length; i++) {
				idsForDel += CommonUtil.isBlank(idsForDel) ? "'"+authGroupIds[i]+"'" : ",'"+authGroupIds[i]+"'";
			}
			queryAdvisor.addWhereClause("auth_group_id in ("+idsForDel+")");
			sysUser.addUpdateColumn("AUTH_GROUP_ID", toCode);
			result = updateColumns(queryAdvisor, sysUser);
		}
		return result;
	}

	public int updateAuthGroupIdByAuthGroupId(String authGroupId, String toCode) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		SysUser sysUser = new SysUser();

		queryAdvisor.addWhereClause("auth_group_id = '"+authGroupId+"'");
		sysUser.addUpdateColumn("AUTH_GROUP_ID", toCode);
		return updateColumns(queryAdvisor, sysUser);
	}

	public int updateByUserIds(String userIds[], SysUser sysUser) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		String idsForUpdate = "";
		int result = 0;

		if (!(userIds == null || userIds.length == 0)) {
			for (int i=0; i<userIds.length; i++) {
				idsForUpdate += CommonUtil.isBlank(idsForUpdate) ? "'"+userIds[i]+"'" : ",'"+userIds[i]+"'";
			}
			queryAdvisor.addWhereClause("user_id in ("+idsForUpdate+")");
			result = updateColumns(queryAdvisor, sysUser);
		}
		return result;
	}

	public int delete(String userIds[]) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		int result = 0;
		String idsForDel = "";

		if (!(userIds == null || userIds.length == 0)) {
			for (int i=0; i<userIds.length; i++) {
				idsForDel += CommonUtil.isBlank(idsForDel) ? "'"+userIds[i]+"'" : ",'"+userIds[i]+"'";
			}
			queryAdvisor.addWhereClause("user_id in ("+idsForDel+")");
			result = deleteWithSQLQuery(queryAdvisor, new SysUser());
		}
		return result;
	}

	public int delete(String userId) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		queryAdvisor.addWhereClause("user_id = '"+userId+"'");
		return deleteWithSQLQuery(queryAdvisor, new SysUser());
	}

	public DataSet getUserInfoDataSetByLoginId(String loginId) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();

		queryAdvisor.addWhereClause("is_active = 'Y'");
		queryAdvisor.addWhereClause("user_status = '"+CommonCodeManager.getCodeByConstants("USER_STATUS_NU")+"'");
		queryAdvisor.addWhereClause("login_id = '"+loginId+"'");

		return selectAllAsDataSet(queryAdvisor, new SysUser());
	}

	public DataSet getUserInfoDataSetByLoginIdAndEmail(String loginId, String email) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();

		queryAdvisor.addWhereClause("is_active = 'Y'");
		queryAdvisor.addWhereClause("user_status = '"+CommonCodeManager.getCodeByConstants("USER_STATUS_NU")+"'");
		queryAdvisor.addWhereClause("login_id = '"+loginId+"'");
		queryAdvisor.addWhereClause("lower(email) = lower('"+email+"')");

		return selectAllAsDataSet(queryAdvisor, new SysUser());
	}

	public DataSet getUserDataSetBySearchCriteria(QueryAdvisor queryAdvisor) throws Exception {
		DataSet requestDataSet = queryAdvisor.getRequestDataSet();
		String loginId = requestDataSet.getValue("loginId");
		String userName = requestDataSet.getValue("userName");
		String authGroup = requestDataSet.getValue("authGroup");
		String userType = requestDataSet.getValue("userType");
		String userStatus = requestDataSet.getValue("userStatus");
		String isActive = requestDataSet.getValue("isActive");
		String dateFormat = ConfigUtil.getProperty("format.date.java");
		String langCode = (String)queryAdvisor.getObject("langCode");

		queryAdvisor.addAutoFillCriteria(loginId, "lower(login_id) like lower('"+loginId+"%')");
		queryAdvisor.addAutoFillCriteria(userName, "lower(user_name) like lower('"+userName+"%')");
		queryAdvisor.addAutoFillCriteria(authGroup, "auth_group_id = '"+authGroup+"'");
		queryAdvisor.addAutoFillCriteria(userType, "user_type = '"+userType+"'");
		queryAdvisor.addAutoFillCriteria(userStatus, "user_status = '"+userStatus+"'");
		queryAdvisor.addAutoFillCriteria(isActive, "is_active = '"+isActive+"'");
		queryAdvisor.addVariable("dateFormat", dateFormat);
		queryAdvisor.addVariable("langCode", langCode);
		queryAdvisor.addOrderByClause("user_name, login_id");

		return selectAsDataSet(queryAdvisor, "query.SysUser.getUserDataSetBySearchCriteria");
	}

	public DataSet getUserNameDataSetForAutoCompletion(QueryAdvisor queryAdvisor) throws Exception {
		DataSet requestDataSet = queryAdvisor.getRequestDataSet();
		String inputValue = requestDataSet.getValue("inputValue");

		queryAdvisor.addAutoFillCriteria(inputValue, "lower(user_name) like lower('"+inputValue+"%')");
		queryAdvisor.addOrderByClause("user_name");
		return selectAsDataSet(queryAdvisor, "query.SysUser.getUserNameDataSetForAutoCompletion");
	}

	public SysUser getUserByLoginId(String loginId) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();

		queryAdvisor.addWhereClause("login_id = '"+loginId+"'");

		return (SysUser)selectAllToDto(queryAdvisor, new SysUser());
	}

	public SysUser getUserByUserId(String userId) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();

		queryAdvisor.addWhereClause("user_id = '"+userId+"'");

		return (SysUser)selectAllToDto(queryAdvisor, new SysUser());
	}

	public SysUser getUserByLoginIdAndPassword(String loginId, String password) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		boolean useDBCrypto = CommonUtil.toBoolean(ConfigUtil.getProperty("login.useDBCrypto"));

		queryAdvisor.addWhereClause("login_id = '"+loginId+"'");

		if (useDBCrypto) {
			queryAdvisor.addWhereClause("login_password = crypto.crypto_enc('"+password+"')");
		} else {
			queryAdvisor.addWhereClause("login_password = '"+password+"'");
		}

		return (SysUser)selectAllToDto(queryAdvisor, new SysUser());
	}

	public SysUser getActiveUserByLoginIdAndPassword(String loginId, String password) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		boolean useDBCrypto = CommonUtil.toBoolean(ConfigUtil.getProperty("login.useDBCrypto"));

		queryAdvisor.addWhereClause("login_id = '"+loginId+"'");
		queryAdvisor.addWhereClause("user_status = '"+CommonCodeManager.getCodeByConstants("USER_STATUS_NU")+"'");
		queryAdvisor.addWhereClause("is_active = '"+CommonCodeManager.getCodeByConstants("IS_ACTIVE_Y")+"'");

		if (useDBCrypto) {
			queryAdvisor.addWhereClause("login_password = crypto.crypto_enc('"+password+"')");
		} else {
			queryAdvisor.addWhereClause("login_password = '"+password+"'");
		}

		return (SysUser)selectAllToDto(queryAdvisor, new SysUser());
	}

	private int encryptPasswordByLoginId(String loginId) throws Exception {
		return executeSql("update sys_user set login_password = crypto.crypto_enc(login_password) where login_id = '"+loginId+"'");
	}

	private int encryptPasswordByUserId(String userId) throws Exception {
		return executeSql("update sys_user set login_password = crypto.crypto_enc(login_password) where user_id = '"+userId+"'");
	}
}