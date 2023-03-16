/**************************************************************************************************
 * Framework Generated HDAOImpl Source
 * - HP_PERSON_D - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.HpPersonD;

import project.common.extend.BaseHDao;
import project.conf.resource.ormapper.dto.oracle.HpPersonD;
import zebra.data.DataSet;
import zebra.data.QueryAdvisor;
import zebra.util.CommonUtil;
import zebra.util.ConfigUtil;

public class HpPersonDHDaoImpl extends BaseHDao implements HpPersonDDao {
	public HpPersonD getPersonByPersonId(String personId) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		queryAdvisor.addWhereClause("person_id = '"+personId+"'");
		return (HpPersonD)selectAllToDto(queryAdvisor, new HpPersonD());
	}

	public DataSet getPersonDataSetByCriteria(QueryAdvisor queryAdvisor) throws Exception {
		DataSet requestDataSet = queryAdvisor.getRequestDataSet();
		String dateFormat = ConfigUtil.getProperty("format.date.java");
		String personId = requestDataSet.getValue("personId");
		String personLike = requestDataSet.getValue("personLike");
		String tmpPersonLike = CommonUtil.removeString(personLike, "*", ",");
		String personIdLike = requestDataSet.getValue("personIdLike");
		String email = requestDataSet.getValue("email");
		String empOrgId = requestDataSet.getValue("empOrgId");
		String mobile = CommonUtil.removeString(requestDataSet.getValue("mobile"), " ", "-");
		String personType = CommonUtil.lowerCase(requestDataSet.getValue("personType"));

		queryAdvisor.addAutoFillCriteria(personId, "person_id = '"+personId+"'");
		if (CommonUtil.isNumeric(tmpPersonLike)) {
			queryAdvisor.addAutoFillCriteria(personLike, "person_number "+CommonUtil.getSearchCriteriaWhereClauseString(personLike));
		} else {
			queryAdvisor.addAutoFillCriteria(personLike, "lower(full_name) "+CommonUtil.getSearchCriteriaWhereClauseString(personLike));
		}
		queryAdvisor.addAutoFillCriteria(personIdLike, "person_id "+CommonUtil.getSearchCriteriaWhereClauseString(personIdLike));
		queryAdvisor.addAutoFillCriteria(email, "payslip_email "+CommonUtil.getSearchCriteriaWhereClauseString(email));
		queryAdvisor.addAutoFillCriteria(empOrgId, "employment_company_org_id = '"+empOrgId+"'");
		queryAdvisor.addAutoFillCriteria(mobile, "person_id in (select person_id from hp_address_contact_d where telephone_mobile "+CommonUtil.getSearchCriteriaWhereClauseString(mobile)+")");
		if (CommonUtil.isNotBlank(personType)) {
			String delimiter = ConfigUtil.getProperty("delimiter.record");
			String personTypes[] = CommonUtil.split(CommonUtil.trimToEmpty(personType), delimiter);
			String personTypeWhere = "";
			for (int i=0; i<personTypes.length; i++) {
				personTypeWhere += (CommonUtil.isNotBlank(personTypeWhere)) ? ", '"+personTypes[i]+"'" : "'"+personTypes[i]+"'";
			}
			queryAdvisor.addAutoFillCriteria(personTypeWhere, "lower(person_type) in ("+personTypeWhere+")");
		}
		queryAdvisor.addVariable("dateFormat", dateFormat);
		queryAdvisor.addOrderByClause("full_name");

		return selectAsDataSet(queryAdvisor, "query.HpPersonD.getPersonDataSetByCriteria");
	}

	public DataSet getPersonDataSetByPersonId(String personId) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		String dateFormat = ConfigUtil.getProperty("format.date.java");

		queryAdvisor.addVariable("dateFormat", dateFormat);
		queryAdvisor.addVariable("personId", personId);

		return selectAsDataSet(queryAdvisor, "query.HpPersonD.getPersonDataSetByPersonId");
	}

	public DataSet getPersonDataSetForQuickMenu(QueryAdvisor queryAdvisor) throws Exception {
		DataSet requestDataSet = queryAdvisor.getRequestDataSet();
		String dateFormat = ConfigUtil.getProperty("format.date.java");
		String personId = requestDataSet.getValue("personId");
		String personLike = requestDataSet.getValue("personLike");
		String tmpPersonLike = CommonUtil.removeString(personLike, "*", ",");
		String personIdLike = requestDataSet.getValue("personIdLike");
		String email = requestDataSet.getValue("email");
		String empOrgId = requestDataSet.getValue("empOrgId");
		String mobile = CommonUtil.removeString(requestDataSet.getValue("mobile"), " ", "-");
		String personType = CommonUtil.lowerCase(requestDataSet.getValue("personType"));

		queryAdvisor.addAutoFillCriteria(personId, "per.person_id = '"+personId+"'");
		if (CommonUtil.isNumeric(tmpPersonLike)) {
			queryAdvisor.addAutoFillCriteria(personLike, "per.person_number "+CommonUtil.getSearchCriteriaWhereClauseString(personLike));
		} else {
			queryAdvisor.addAutoFillCriteria(personLike, "lower(per.full_name) "+CommonUtil.getSearchCriteriaWhereClauseString(personLike));
		}
		queryAdvisor.addAutoFillCriteria(personIdLike, "per.person_id "+CommonUtil.getSearchCriteriaWhereClauseString(personIdLike));
		queryAdvisor.addAutoFillCriteria(email, "per.payslip_email "+CommonUtil.getSearchCriteriaWhereClauseString(email));
		queryAdvisor.addAutoFillCriteria(empOrgId, "per.employment_company_org_id = '"+empOrgId+"'");
		queryAdvisor.addAutoFillCriteria(mobile, "per.person_id in (select person_id from hp_address_contact_d where telephone_mobile "+CommonUtil.getSearchCriteriaWhereClauseString(mobile)+")");
		if (CommonUtil.isNotBlank(personType)) {
			String delimiter = ConfigUtil.getProperty("delimiter.record");
			String personTypes[] = CommonUtil.split(CommonUtil.trimToEmpty(personType), delimiter);
			String personTypeWhere = "";
			for (int i=0; i<personTypes.length; i++) {
				personTypeWhere += (CommonUtil.isNotBlank(personTypeWhere)) ? ", '"+personTypes[i]+"'" : "'"+personTypes[i]+"'";
			}
			queryAdvisor.addAutoFillCriteria(personTypeWhere, "lower(per.person_type) in ("+personTypeWhere+")");
		}
		queryAdvisor.addVariable("dateFormat", dateFormat);
		queryAdvisor.addOrderByClause("per.surname, per.first_name");

		return selectAsDataSet(queryAdvisor, "query.HpPersonD.getPersonDataSetForQuickMenu");
	}

	public DataSet getPersonBasicInfoForAutoCompletion(QueryAdvisor queryAdvisor) throws Exception {
		return selectAsDataSet(queryAdvisor, "query.HpPersonD.getPersonNumberForAutoCompletion");
	}

	public DataSet getEsEmployeeByNameForAutoCompletion(QueryAdvisor queryAdvisor) throws Exception {
		return selectAsDataSet(queryAdvisor, "query.HpPersonD.getEsEmployeeByNameForAutoCompletion");
	}

	public DataSet getEsEmployeeLookup(QueryAdvisor queryAdvisor) throws Exception {
		return selectAsDataSet(queryAdvisor, "query.HpPersonD.getEsEmployeeLookup");
	}

	public DataSet getEcmsGeneralInfoByPersonId(QueryAdvisor queryAdvisor, String personId) throws Exception {
		String dateFormat = ConfigUtil.getProperty("format.date.java");

		queryAdvisor.addVariable("dateFormat", dateFormat);
		queryAdvisor.addVariable("personId", personId);

		return selectAsDataSet(queryAdvisor, "query.HpPersonD.getEcmsGeneralInfoByPersonId");
	}

	public DataSet getApproverDataSetByOrgIds(String... organisationIds) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		String ids = "";

		for (String id : organisationIds) {
			ids += (CommonUtil.isBlank(ids)) ? "'"+id+"'" : ", "+"'"+id+"'";
		}
		queryAdvisor.addVariable("organisationIds", ids);

		return selectAsDataSet(queryAdvisor, "query.HpPersonD.getApproverDataSetByOrgIds");
	}

	public int shiftAccountFromOpportunity(String organisationIds[], String shiftToId) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		String ids = "";

		for (String id : organisationIds) {
			ids += (CommonUtil.isBlank(ids)) ? "'"+id+"'" : ", "+"'"+id+"'";
		}

		queryAdvisor.addVariable("shiftToId", shiftToId);
		queryAdvisor.addVariable("organisationIds", ids);

		return updateWithSQLQuery(queryAdvisor, "query.HpPersonD.shiftAccountFromOpportunity");
	}

	public int shiftAccountFromAssignment(String organisationIds[], String shiftToId) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		String ids = "";

		for (String id : organisationIds) {
			ids += (CommonUtil.isBlank(ids)) ? "'"+id+"'" : ", "+"'"+id+"'";
		}

		queryAdvisor.addVariable("shiftToId", shiftToId);
		queryAdvisor.addVariable("organisationIds", ids);

		return updateWithSQLQuery(queryAdvisor, "query.HpPersonD.shiftAccountFromAssignment");
	}
}