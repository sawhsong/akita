/**************************************************************************************************
 * Framework Generated DAO Source
 * - OPPORTUNITY_ASSIGNMENT_DETAILS - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.OpportunityAssignmentDetails;

import project.conf.resource.ormapper.dto.oracle.OpportunityAssignmentDetails;
import zebra.base.IDao;
import zebra.data.DataSet;

public interface OpportunityAssignmentDetailsDao extends IDao {
	public OpportunityAssignmentDetails getOppAsgDetailsByOpportunityId(String opportunityId) throws Exception;
	public DataSet getOppAsgDetailsDataSetByOpportunityId(String opportunityId) throws Exception;
}