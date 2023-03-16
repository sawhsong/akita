/**************************************************************************************************
 * Framework Generated DAO Source
 * - SYS_USERS - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.SysUsers;

import project.conf.resource.ormapper.dto.oracle.SysUsers;
import zebra.base.IDao;

public interface SysUsersDao extends IDao {
	public SysUsers getUserByUserId(String userId) throws Exception;
}