/**************************************************************************************************
 * Framework Generated HDAOImpl Source
 * - OPPORTUNITY_ASSIGNMENT_DETAILS - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.OpportunityAssignmentDetails;

import project.common.extend.BaseHDao;
import project.conf.resource.ormapper.dto.oracle.OpportunityAssignmentDetails;
import zebra.data.DataSet;
import zebra.data.QueryAdvisor;
import zebra.util.ConfigUtil;

public class OpportunityAssignmentDetailsHDaoImpl extends BaseHDao implements OpportunityAssignmentDetailsDao {
	public OpportunityAssignmentDetails getOppAsgDetailsByOpportunityId(String opportunityId) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		queryAdvisor.addWhereClause("opportunity_id = '"+opportunityId+"'");
		return (OpportunityAssignmentDetails)selectAllToDto(queryAdvisor, new OpportunityAssignmentDetails());
	}

	public DataSet getOppAsgDetailsDataSetByOpportunityId(String opportunityId) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		String dateFormat = ConfigUtil.getProperty("format.date.java");

		queryAdvisor.addVariable("dateFormat", dateFormat);
		queryAdvisor.addVariable("opportunityId", opportunityId);

		return selectAsDataSet(queryAdvisor, "query.OpportunityAssignmentDetails.getOppAsgDetailsDataSetByOpportunityId");
	}
}