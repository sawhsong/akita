/**************************************************************************************************
 * Framework Generated HDAOImpl Source
 * - HR_DOCUMENT - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.HrDocument;

import project.common.extend.BaseHDao;
import zebra.data.DataSet;
import zebra.data.QueryAdvisor;
import zebra.util.ConfigUtil;

public class HrDocumentHDaoImpl extends BaseHDao implements HrDocumentDao {
	public DataSet getDataSetByDocumentId(String documentId) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		String dateFormat = ConfigUtil.getProperty("format.date.java");

		queryAdvisor.addVariable("dateFormat", dateFormat);
		queryAdvisor.addVariable("documentId", documentId);

		return selectAsDataSet(queryAdvisor, "query.HrDocument.getDataSetByDocumentId");
	}

	public DataSet getPersonOutstandingDocumentByPersonId(QueryAdvisor queryAdvisor, String personId) throws Exception {
		String dateFormat = ConfigUtil.getProperty("format.date.java");

		queryAdvisor.addVariable("dateFormat", dateFormat);
		queryAdvisor.addVariable("personId", personId);

		return selectAsDataSet(queryAdvisor, "query.HrDocument.getPersonOutstandingDocumentByPersonId");
	}

	public DataSet getPersonReceivedDocumentByPersonId(QueryAdvisor queryAdvisor, String personId) throws Exception {
		DataSet dsRequest = queryAdvisor.getRequestDataSet();
		String status = dsRequest.getValue("status");
		String dateFormat = ConfigUtil.getProperty("format.date.java");

		queryAdvisor.addAutoFillCriteria(status, "hrd.is_active = '"+status+"'");
		queryAdvisor.addVariable("dateFormat", dateFormat);
		queryAdvisor.addVariable("personId", personId);

		return selectAsDataSet(queryAdvisor, "query.HrDocument.getPersonReceivedDocumentByPersonId");
	}
}