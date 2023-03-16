package project.conf.resource.ormapper.dao.SysUser;

import project.conf.resource.ormapper.dto.oracle.SysUser;
import zebra.base.Dto;
import zebra.base.IDao;
import zebra.data.DataSet;
import zebra.data.QueryAdvisor;

public interface SysUserDao extends IDao {
	public int insert(Dto dto) throws Exception;
	public int update(String userId, Dto dto) throws Exception;
	public int resetPasswordByLoginId(String loginId, String randomString) throws Exception;
	public int changePasswordByLoginId(String loginId, String newPassword) throws Exception;
	public int updateAuthGroupIdByAuthGroupIds(String authGroupIds[], String toCode) throws Exception;
	public int updateAuthGroupIdByAuthGroupId(String authGroupId, String toCode) throws Exception;
	public int updateByUserIds(String userIds[], SysUser sysUser) throws Exception;
	public int delete(String[] userIds) throws Exception;
	public int delete(String userId) throws Exception;
	public DataSet getUserInfoDataSetByLoginId(String loginId) throws Exception;
	public DataSet getUserInfoDataSetByLoginIdAndEmail(String loginId, String email) throws Exception;
	public DataSet getUserDataSetBySearchCriteria(QueryAdvisor queryAdvisor) throws Exception;
	public DataSet getUserNameDataSetForAutoCompletion(QueryAdvisor queryAdvisor) throws Exception;
	public SysUser getUserByLoginId(String loginId) throws Exception;
	public SysUser getUserByUserId(String userId) throws Exception;
	public SysUser getUserByLoginIdAndPassword(String loginId, String password) throws Exception;
	public SysUser getActiveUserByLoginIdAndPassword(String loginId, String password) throws Exception;
}