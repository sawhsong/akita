/**************************************************************************************************
 * Framework Generated DAO Source
 * - HP_ASG_PROCESSES - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.HpAsgProcesses;

import zebra.base.IDao;
import zebra.data.DataSet;
import zebra.data.QueryAdvisor;

public interface HpAsgProcessesDao extends IDao {
	public DataSet getPayslipListByPersonId(QueryAdvisor queryAdvisor, String personId) throws Exception;
	public DataSet getPayslipListByPersonId(String personId) throws Exception;
}