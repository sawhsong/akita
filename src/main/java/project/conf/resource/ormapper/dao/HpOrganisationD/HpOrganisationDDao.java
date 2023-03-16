/**************************************************************************************************
 * Framework Generated DAO Source
 * - HP_ORGANISATION_D - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.HpOrganisationD;

import project.conf.resource.ormapper.dto.oracle.HpOrganisationD;
import zebra.base.IDao;
import zebra.data.DataSet;
import zebra.data.QueryAdvisor;

public interface HpOrganisationDDao extends IDao {
	public int updateColumns(String organisationId, HpOrganisationD hpOrganisationD) throws Exception;
	public int updateColumns(String organisationIds[], HpOrganisationD hpOrganisationD) throws Exception;
	public HpOrganisationD getOrganisationByOrganisationId(String organisationId) throws Exception;
	public DataSet getDataSetByOrganisationIds(String... organisationIds) throws Exception;
	public DataSet getOrganisationDataSetByCriteria(QueryAdvisor queryAdvisor) throws Exception;
	public DataSet getOrganisationDataSetForQuickMenu(QueryAdvisor queryAdvisor) throws Exception;
	public DataSet getOrgInfoDataSetForAutoCompletion(QueryAdvisor queryAdvisor) throws Exception;
	public DataSet getBillingOrgByNameForAutoCompletion(QueryAdvisor queryAdvisor) throws Exception;
	public DataSet getOrgNameDataSetForAutoCompletion(QueryAdvisor queryAdvisor) throws Exception;
	public DataSet getAbnDataSetForAutoCompletion(QueryAdvisor queryAdvisor) throws Exception;
	public DataSet getEmploymentOrganisationLookup(QueryAdvisor queryAdvisor) throws Exception;
}