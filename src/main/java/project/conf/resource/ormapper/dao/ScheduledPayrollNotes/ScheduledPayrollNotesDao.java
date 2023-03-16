/**************************************************************************************************
 * Framework Generated DAO Source
 * - SCHEDULED_PAYROLL_NOTES - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.ScheduledPayrollNotes;

import zebra.base.IDao;
import zebra.data.DataSet;
import zebra.data.QueryAdvisor;

public interface ScheduledPayrollNotesDao extends IDao {
	public DataSet getScheduledPayrollNotiListByPersonId(QueryAdvisor queryAdvisor, String personId) throws Exception;
}