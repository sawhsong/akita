/**************************************************************************************************
 * Framework Generated HDAOImpl Source
 * - SYS_USERS - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.SysUsers;

import project.common.extend.BaseHDao;
import project.conf.resource.ormapper.dto.oracle.SysUsers;
import zebra.data.QueryAdvisor;

public class SysUsersHDaoImpl extends BaseHDao implements SysUsersDao {
	public SysUsers getUserByUserId(String userId) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		queryAdvisor.addWhereClause("user_id = '"+userId+"'");
		return (SysUsers)selectAllToDto(queryAdvisor, new SysUsers());
	}
}