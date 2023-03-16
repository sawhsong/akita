package project.common.module.datahelper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import project.common.extend.BaseBiz;
import project.conf.resource.ormapper.dao.HpOrganisationD.HpOrganisationDDao;
import project.conf.resource.ormapper.dao.HpPersonD.HpPersonDDao;
import project.conf.resource.ormapper.dao.ProjectDummy.ProjectDummyDao;
import project.conf.resource.ormapper.dao.SysAuthGroup.SysAuthGroupDao;
import project.conf.resource.ormapper.dao.SysUser.SysUserDao;
import project.conf.resource.ormapper.dto.oracle.HpOrganisationD;
import project.conf.resource.ormapper.dto.oracle.HpPersonD;
import project.conf.resource.ormapper.dto.oracle.SysAuthGroup;
import project.conf.resource.ormapper.dto.oracle.SysUser;
import zebra.data.DataSet;
import zebra.data.QueryAdvisor;
import zebra.util.CommonUtil;

public class DataHelper extends BaseBiz {
	@SuppressWarnings("unused")
	private static Logger logger = LogManager.getLogger(DataHelper.class);
	private static ProjectDummyDao dummyDao;
	private static SysUserDao sysUserDao;
	private static SysAuthGroupDao sysAuthGroupDao;
	private static HpPersonDDao hpPersonDDao;
	private static HpOrganisationDDao hpOrganisationDDao;

	public static ProjectDummyDao getDummyDao() {
		return dummyDao;
	}

	public static void setDummyDao(ProjectDummyDao dummyDao) {
		DataHelper.dummyDao = dummyDao;
	}

	public static SysUserDao getSysUserDao() {
		return sysUserDao;
	}

	public static void setSysUserDao(SysUserDao sysUserDao) {
		DataHelper.sysUserDao = sysUserDao;
	}

	public static SysAuthGroupDao getSysAuthGroupDao() {
		return sysAuthGroupDao;
	}

	public static void setSysAuthGroupDao(SysAuthGroupDao sysAuthGroupDao) {
		DataHelper.sysAuthGroupDao = sysAuthGroupDao;
	}

	public static HpPersonDDao getHpPersonDDao() {
		return hpPersonDDao;
	}

	public static void setHpPersonDDao(HpPersonDDao hpPersonDDao) {
		DataHelper.hpPersonDDao = hpPersonDDao;
	}

	public static HpOrganisationDDao getHpOrganisationDDao() {
		return hpOrganisationDDao;
	}

	public static void setHpOrganisationDDao(HpOrganisationDDao hpOrganisationDDao) {
		DataHelper.hpOrganisationDDao = hpOrganisationDDao;
	}

	/*!
	 * Dummy
	 */

	/*!
	 * SysUser
	 */
	public static SysUser getUserByUserId(String userId) throws Exception {
		if (CommonUtil.isBlank(userId)) {return new SysUser();}
		return sysUserDao.getUserByUserId(userId);
	}

	public static String getUserNameById(String userId) throws Exception {
		if (CommonUtil.isBlank(userId)) {return "";}
		return getUserByUserId(userId).getUserName();
	}

	/*!
	 * HpPersonD
	 */
	public static HpPersonD getHpPersonDById(String personId) throws Exception {
		if (CommonUtil.isBlank(personId)) {return new HpPersonD();}
		return hpPersonDDao.getPersonByPersonId(personId);
	}

	public static String getPersonFullNameById(String personId) throws Exception {
		if (CommonUtil.isBlank(personId)) {return "";}
		return getHpPersonDById(personId).getFullName();
	}

	/*!
	 * HpOrganisationD
	 */
	public static HpOrganisationD getHpOrganisationDById(String organisationId) throws Exception {
		if (CommonUtil.isBlank(organisationId)) {return new HpOrganisationD();}
		return hpOrganisationDDao.getOrganisationByOrganisationId(organisationId);
	}

	public static String getOrganisationNameById(String organisationId) throws Exception {
		if (CommonUtil.isBlank(organisationId)) {return "";}
		return getHpOrganisationDById(organisationId).getOrganisationName();
	}

	/*!
	 * SysAuthGroup
	 */
	public static DataSet getAuthGroupDataSetById(String authGroupId) throws Exception {
		if (CommonUtil.isBlank(authGroupId)) {return new DataSet();}

		QueryAdvisor qa = new QueryAdvisor();
		qa.addVariable("authGroupId", authGroupId);
		return sysAuthGroupDao.getAuthGroupDataSetById(qa);
	}

	public static SysAuthGroup getSysAuthGroupById(String authGroupId) throws Exception {
		SysAuthGroup sysAuthGroup = new SysAuthGroup();

		if (CommonUtil.isBlank(authGroupId)) {return sysAuthGroup;}

		sysAuthGroup.setValues(getAuthGroupDataSetById(authGroupId));
		return sysAuthGroup;
	}

	public static String getAuthGroupNameById(String authGroupId) throws Exception {
		if (CommonUtil.isBlank(authGroupId)) {return "";}

		DataSet ds = getAuthGroupDataSetById(authGroupId);
		return CommonUtil.nvl(ds.getValue("GROUP_NAME"));
	}
}