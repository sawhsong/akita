/**************************************************************************************************
 * Framework Generated HDAOImpl Source
 * - SCHEDULED_PAYROLL_NOTES - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.ScheduledPayrollNotes;

import project.common.extend.BaseHDao;
import zebra.data.DataSet;
import zebra.data.QueryAdvisor;
import zebra.util.ConfigUtil;

public class ScheduledPayrollNotesHDaoImpl extends BaseHDao implements ScheduledPayrollNotesDao {
	public DataSet getScheduledPayrollNotiListByPersonId(QueryAdvisor queryAdvisor, String personId) throws Exception {
		String dateFormat = ConfigUtil.getProperty("format.date.java");

		queryAdvisor.addVariable("dateFormat", dateFormat);
		queryAdvisor.addVariable("personId", personId);

		return selectAsDataSet(queryAdvisor, "query.ScheduledPayrollNotes.getScheduledPayrollNotiListByPersonId");
	}
}