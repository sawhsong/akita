/**************************************************************************************************
 * Framework Generated HDAOImpl Source
 * - HP_ORGANISATION_D - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.HpOrganisationD;

import project.common.extend.BaseHDao;
import project.conf.resource.ormapper.dto.oracle.HpOrganisationD;
import zebra.data.DataSet;
import zebra.data.QueryAdvisor;
import zebra.util.CommonUtil;
import zebra.util.ConfigUtil;

public class HpOrganisationDHDaoImpl extends BaseHDao implements HpOrganisationDDao {
	public int updateColumns(String organisationId, HpOrganisationD hpOrganisationD) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		queryAdvisor.addWhereClause("organisation_id = '"+organisationId+"'");
		return updateColumns(queryAdvisor, hpOrganisationD);
	}

	public int updateColumns(String organisationIds[], HpOrganisationD hpOrganisationD) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		String ids = "";

		for (String id : organisationIds) {
			ids += (CommonUtil.isBlank(ids)) ? "'"+id+"'" : ", "+"'"+id+"'";
		}
		queryAdvisor.addWhereClause("organisation_id in ("+ids+")");
		return updateColumns(queryAdvisor, hpOrganisationD);
	}

	public HpOrganisationD getOrganisationByOrganisationId(String organisationId) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		queryAdvisor.addWhereClause("organisation_id = '"+organisationId+"'");
		return (HpOrganisationD)selectAllToDto(queryAdvisor, new HpOrganisationD());
	}

	public DataSet getDataSetByOrganisationIds(String... organisationIds) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		String dateFormat = ConfigUtil.getProperty("format.date.java");
		String ids = "";

		for (String id : organisationIds) {
			ids += (CommonUtil.isBlank(ids)) ? "'"+id+"'" : ", "+"'"+id+"'";
		}
		queryAdvisor.addVariable("organisationIds", ids);
		queryAdvisor.addVariable("dateFormat", dateFormat);
		queryAdvisor.addOrderByClause("organisation_name");

		return selectAsDataSet(queryAdvisor, "query.HpOrganisationD.getDataSetByOrganisationIds");
	}

	public DataSet getOrganisationDataSetByCriteria(QueryAdvisor queryAdvisor) throws Exception {
		DataSet requestDataSet = queryAdvisor.getRequestDataSet();
		String orgId = requestDataSet.getValue("orgId");
		String orgLike = CommonUtil.lowerCase(requestDataSet.getValue("orgLike"));
		String tmpOrgLike = CommonUtil.removeString(orgLike, "*", ",");
		String orgType = requestDataSet.getValue("orgType");
		String cscId = requestDataSet.getValue("cscId");
		String crmId = requestDataSet.getValue("crmId");
		String orgState = requestDataSet.getValue("orgState");
		String orgCountry = requestDataSet.getValue("orgCountryName");

		queryAdvisor.addAutoFillCriteria(orgId, "organisation_id = '"+orgId+"'");
		if (CommonUtil.isNumeric(tmpOrgLike)) {
			queryAdvisor.addAutoFillCriteria(orgLike, "organisation_id "+CommonUtil.getSearchCriteriaWhereClauseString(orgLike));
		} else {
			queryAdvisor.addAutoFillCriteria(orgLike, "lower(organisation_name) "+CommonUtil.getSearchCriteriaWhereClauseString(orgLike));
		}
		queryAdvisor.addAutoFillCriteria(orgType, "organisation_type = '"+orgType+"'");
		queryAdvisor.addAutoFillCriteria(cscId, "es_payroll_consultant = '"+cscId+"'");
		queryAdvisor.addAutoFillCriteria(crmId, "es_account_manager = '"+crmId+"'");
		queryAdvisor.addAutoFillCriteria(orgState, "state = '"+orgState+"'");
		queryAdvisor.addAutoFillCriteria(orgCountry, "country = '"+orgCountry+"'");

		queryAdvisor.addOrderByClause("organisation_name");

		return selectAsDataSet(queryAdvisor, "query.HpOrganisationD.getOrganisationDataSetByCriteria");
	}

	public DataSet getOrganisationDataSetForQuickMenu(QueryAdvisor queryAdvisor) throws Exception {
		DataSet requestDataSet = queryAdvisor.getRequestDataSet();
		String orgId = requestDataSet.getValue("orgId");
		String orgLike = CommonUtil.lowerCase(requestDataSet.getValue("orgLike"));
		String tmpOrgLike = CommonUtil.removeString(orgLike, "*", ",");
		String orgType = requestDataSet.getValue("orgType");
		String cscId = requestDataSet.getValue("cscId");
		String crmId = requestDataSet.getValue("crmId");
		String orgState = requestDataSet.getValue("orgState");
		String orgCountry = requestDataSet.getValue("orgCountryName");

		queryAdvisor.addAutoFillCriteria(orgId, "organisation_id = '"+orgId+"'");
		if (CommonUtil.isNumeric(tmpOrgLike)) {
			queryAdvisor.addAutoFillCriteria(orgLike, "organisation_id "+CommonUtil.getSearchCriteriaWhereClauseString(orgLike));
		} else {
			queryAdvisor.addAutoFillCriteria(orgLike, "lower(organisation_name) "+CommonUtil.getSearchCriteriaWhereClauseString(orgLike));
		}
		queryAdvisor.addAutoFillCriteria(orgType, "organisation_type = '"+orgType+"'");
		queryAdvisor.addAutoFillCriteria(cscId, "es_payroll_consultant = '"+cscId+"'");
		queryAdvisor.addAutoFillCriteria(crmId, "es_account_manager = '"+crmId+"'");
		queryAdvisor.addAutoFillCriteria(orgState, "state = '"+orgState+"'");
		queryAdvisor.addAutoFillCriteria(orgCountry, "country = '"+orgCountry+"'");

		queryAdvisor.addOrderByClause("organisation_name");

		return selectAsDataSet(queryAdvisor, "query.HpOrganisationD.getOrganisationDataSetForQuickMenu");
	}

	public DataSet getOrgInfoDataSetForAutoCompletion(QueryAdvisor queryAdvisor) throws Exception {
		return selectAsDataSet(queryAdvisor, "query.HpOrganisationD.getOrgInfoDataSetForAutoCompletion");
	}

	public DataSet getBillingOrgByNameForAutoCompletion(QueryAdvisor queryAdvisor) throws Exception {
		return selectAsDataSet(queryAdvisor, "query.HpOrganisationD.getBillingOrgByNameForAutoCompletion");
	}

	public DataSet getOrgNameDataSetForAutoCompletion(QueryAdvisor queryAdvisor) throws Exception {
		return selectAsDataSet(queryAdvisor, "query.HpOrganisationD.getOrgNameDataSetForAutoCompletion");
	}

	public DataSet getAbnDataSetForAutoCompletion(QueryAdvisor queryAdvisor) throws Exception {
		return selectAsDataSet(queryAdvisor, "query.HpOrganisationD.getOrgNameDataSetForAutoCompletion");
	}

	public DataSet getEmploymentOrganisationLookup(QueryAdvisor queryAdvisor) throws Exception {
		return selectAsDataSet(queryAdvisor, "query.HpOrganisationD.getEmploymentOrganisationLookup");
	}
}