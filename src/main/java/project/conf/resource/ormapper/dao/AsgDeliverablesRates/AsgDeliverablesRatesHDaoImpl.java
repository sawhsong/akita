/**************************************************************************************************
 * Framework Generated HDAOImpl Source
 * - ASG_DELIVERABLES_RATES - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.AsgDeliverablesRates;

import project.common.extend.BaseHDao;
import zebra.data.DataSet;
import zebra.data.QueryAdvisor;
import zebra.util.ConfigUtil;

public class AsgDeliverablesRatesHDaoImpl extends BaseHDao implements AsgDeliverablesRatesDao {
	public DataSet getDataSetByAssignmentId(String assignmentId) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		String dateFormat = ConfigUtil.getProperty("format.date.java");
		String dateTimeFormat = ConfigUtil.getProperty("format.dateTime.db.au");

		queryAdvisor.addVariable("dateFormat", dateFormat);
		queryAdvisor.addVariable("dateTimeFormat", dateTimeFormat);
		queryAdvisor.addVariable("assignmentId", assignmentId);
		return selectAsDataSet(queryAdvisor, "query.AsgDeliverablesRates.getDataSetByAssignmentId");
	}
}