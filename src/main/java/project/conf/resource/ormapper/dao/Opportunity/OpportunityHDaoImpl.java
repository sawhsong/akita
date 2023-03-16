/**************************************************************************************************
 * Framework Generated HDAOImpl Source
 * - OPPORTUNITY - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.Opportunity;

import project.common.extend.BaseHDao;
import project.conf.resource.ormapper.dto.oracle.Opportunity;
import zebra.data.DataSet;
import zebra.data.QueryAdvisor;
import zebra.util.CommonUtil;
import zebra.util.ConfigUtil;

public class OpportunityHDaoImpl extends BaseHDao implements OpportunityDao {
	public Opportunity getOpportunityByOpportunityId(String opportunityId) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		queryAdvisor.addWhereClause("opportunity_id = '"+opportunityId+"'");
		return (Opportunity)selectAllToDto(queryAdvisor, new Opportunity());
	}

	public DataSet getOpportunityDataSetByOpportunityId(String opportunityId) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		String dateFormat = ConfigUtil.getProperty("format.date.java");

		queryAdvisor.addVariable("dateFormat", dateFormat);
		queryAdvisor.addVariable("opportunityId", opportunityId);

		return selectAsDataSet(queryAdvisor, "query.Opportunity.getOpportunityDataSetByOpportunityId");
	}

	public DataSet getOpportunityListByPersonId(QueryAdvisor queryAdvisor, String personId) throws Exception {
		String dateFormat = ConfigUtil.getProperty("format.date.java");

		queryAdvisor.addVariable("dateFormat", dateFormat);
		queryAdvisor.addVariable("personId", personId);

		return selectAsDataSet(queryAdvisor, "query.Opportunity.getOpportunityListByPersonId");
	}

	public DataSet getOpportunityDocumentDataSetByOpportunityId(String opportunityId) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		String dateFormat = ConfigUtil.getProperty("format.date.java");

		queryAdvisor.addVariable("dateFormat", dateFormat);
		queryAdvisor.addVariable("opportunityId", opportunityId);

		return selectAsDataSet(queryAdvisor, "query.Opportunity.getOpportunityDocumentDataSetByOpportunityId");
	}

	public int shiftAccount(String organisationIds[], String shiftToId) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		String ids = "";

		for (String id : organisationIds) {
			ids += (CommonUtil.isBlank(ids)) ? "'"+id+"'" : ", "+"'"+id+"'";
		}

		queryAdvisor.addVariable("shiftToId", shiftToId);
		queryAdvisor.addVariable("organisationIds", ids);

		return updateWithSQLQuery(queryAdvisor, "query.Opportunity.shiftAccount");
	}
}