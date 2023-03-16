/**************************************************************************************************
 * Framework Generated HDAOImpl Source
 * - HP_ASSIGNMENT_RATES - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.HpAssignmentRates;

import project.common.extend.BaseHDao;
import zebra.data.DataSet;
import zebra.data.QueryAdvisor;
import zebra.util.ConfigUtil;

public class HpAssignmentRatesHDaoImpl extends BaseHDao implements HpAssignmentRatesDao {
	public DataSet getDataSetByAssignmentId(String assignmentId) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		String dateFormat = ConfigUtil.getProperty("format.date.java");

		queryAdvisor.addVariable("dateFormat", dateFormat);
		queryAdvisor.addVariable("assignmentId", assignmentId);
		return selectAsDataSet(queryAdvisor, "query.HpAssignmentRates.getDataSetByAssignmentId");
	}
}