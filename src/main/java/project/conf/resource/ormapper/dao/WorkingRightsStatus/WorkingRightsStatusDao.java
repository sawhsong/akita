/**************************************************************************************************
 * Framework Generated DAO Source
 * - WORKING_RIGHTS_STATUS - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.WorkingRightsStatus;

import zebra.base.IDao;
import zebra.data.DataSet;
import zebra.data.QueryAdvisor;

public interface WorkingRightsStatusDao extends IDao {
	public DataSet getWorkingRightsStatusListByPersonId(QueryAdvisor queryAdvisor, String personId) throws Exception;
}