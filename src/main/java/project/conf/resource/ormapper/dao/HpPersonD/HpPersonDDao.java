/**************************************************************************************************
 * Framework Generated DAO Source
 * - HP_PERSON_D - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.HpPersonD;

import project.conf.resource.ormapper.dto.oracle.HpPersonD;
import zebra.base.IDao;
import zebra.data.DataSet;
import zebra.data.QueryAdvisor;

public interface HpPersonDDao extends IDao {
	public HpPersonD getPersonByPersonId(String personId) throws Exception;
	public DataSet getPersonDataSetByCriteria(QueryAdvisor queryAdvisor) throws Exception;
	public DataSet getPersonDataSetByPersonId(String personId) throws Exception;
	public DataSet getPersonDataSetForQuickMenu(QueryAdvisor queryAdvisor) throws Exception;
	public DataSet getPersonBasicInfoForAutoCompletion(QueryAdvisor queryAdvisor) throws Exception;
	public DataSet getEsEmployeeByNameForAutoCompletion(QueryAdvisor queryAdvisor) throws Exception;
	public DataSet getEsEmployeeLookup(QueryAdvisor queryAdvisor) throws Exception;
	public DataSet getEcmsGeneralInfoByPersonId(QueryAdvisor queryAdvisor, String personId) throws Exception;
	public DataSet getApproverDataSetByOrgIds(String... organisationIds) throws Exception;
	public int shiftAccountFromOpportunity(String organisationIds[], String shiftToId) throws Exception;
	public int shiftAccountFromAssignment(String organisationIds[], String shiftToId) throws Exception;
}