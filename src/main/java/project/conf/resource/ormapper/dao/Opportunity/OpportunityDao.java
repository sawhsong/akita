/**************************************************************************************************
 * Framework Generated DAO Source
 * - OPPORTUNITY - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.Opportunity;

import project.conf.resource.ormapper.dto.oracle.Opportunity;
import zebra.base.IDao;
import zebra.data.DataSet;
import zebra.data.QueryAdvisor;

public interface OpportunityDao extends IDao {
	public Opportunity getOpportunityByOpportunityId(String opportunityId) throws Exception;
	public DataSet getOpportunityDataSetByOpportunityId(String opportunityId) throws Exception;
	public DataSet getOpportunityListByPersonId(QueryAdvisor queryAdvisor, String personId) throws Exception;
	public DataSet getOpportunityDocumentDataSetByOpportunityId(String opportunityId) throws Exception;
	public int shiftAccount(String organisationIds[], String shiftToId) throws Exception;
}