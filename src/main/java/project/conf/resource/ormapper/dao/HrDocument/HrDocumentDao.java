/**************************************************************************************************
 * Framework Generated DAO Source
 * - HR_DOCUMENT - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.HrDocument;

import zebra.base.IDao;
import zebra.data.DataSet;
import zebra.data.QueryAdvisor;

public interface HrDocumentDao extends IDao {
	public DataSet getDataSetByDocumentId(String documentId) throws Exception;
	public DataSet getPersonOutstandingDocumentByPersonId(QueryAdvisor queryAdvisor, String personId) throws Exception;
	public DataSet getPersonReceivedDocumentByPersonId(QueryAdvisor queryAdvisor, String personId) throws Exception;
}