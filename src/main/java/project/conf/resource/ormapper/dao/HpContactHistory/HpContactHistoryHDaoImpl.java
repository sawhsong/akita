/**************************************************************************************************
 * Framework Generated HDAOImpl Source
 * - HP_CONTACT_HISTORY - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.HpContactHistory;

import project.common.extend.BaseHDao;
import zebra.data.DataSet;
import zebra.data.QueryAdvisor;
import zebra.util.ConfigUtil;

public class HpContactHistoryHDaoImpl extends BaseHDao implements HpContactHistoryDao {
	public DataSet getContactHistoryForPersonalInfoByPersonId(String personId) throws Exception {
		QueryAdvisor qa = new QueryAdvisor();
		String dateFormat = ConfigUtil.getProperty("format.date.java");

		qa.addVariable("dateFormat", dateFormat);
		qa.addVariable("personId", personId);

		return selectAsDataSet(qa, "query.HpContactHistory.getContactHistoryForPersonalInfoByPersonId");
	}

	public DataSet getContactHistoryForCommunicationListByPersonId(QueryAdvisor queryAdvisor, String personId) throws Exception {
		String dateFormat = ConfigUtil.getProperty("format.date.java");

		queryAdvisor.addVariable("dateFormat", dateFormat);
		queryAdvisor.addVariable("personId", personId);

		return selectAsDataSet(queryAdvisor, "query.HpContactHistory.getContactHistoryForCommunicationListByPersonId");
	}

	public DataSet getDataSetForOrgCommsHistoryByOrganisationId(String organisationId) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		String dateFormat = ConfigUtil.getProperty("format.date.java");

		queryAdvisor.addVariable("dateFormat", dateFormat);
		queryAdvisor.addVariable("organisationId", organisationId);
		queryAdvisor.addVariable("numberOfRows", "50");

		return selectAsDataSet(queryAdvisor, "query.HpContactHistory.getDataSetForOrgCommsHistoryByOrganisationId");
	}
}