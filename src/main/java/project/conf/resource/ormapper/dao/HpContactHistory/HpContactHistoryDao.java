/**************************************************************************************************
 * Framework Generated DAO Source
 * - HP_CONTACT_HISTORY - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.HpContactHistory;

import zebra.base.IDao;
import zebra.data.DataSet;
import zebra.data.QueryAdvisor;

public interface HpContactHistoryDao extends IDao {
	public DataSet getContactHistoryForPersonalInfoByPersonId(String personId) throws Exception;
	public DataSet getContactHistoryForCommunicationListByPersonId(QueryAdvisor queryAdvisor, String personId) throws Exception;

	// Organisaion - ContactHistory
	public DataSet getDataSetForOrgCommsHistoryByOrganisationId(String organisationId) throws Exception;
}