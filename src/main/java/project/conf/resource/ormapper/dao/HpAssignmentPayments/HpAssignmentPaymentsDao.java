/**************************************************************************************************
 * Framework Generated DAO Source
 * - HP_ASSIGNMENT_PAYMENTS - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.HpAssignmentPayments;

import zebra.base.IDao;
import zebra.data.DataSet;
import zebra.data.QueryAdvisor;

public interface HpAssignmentPaymentsDao extends IDao {
	public DataSet getBankDetailsByPaymentIdForPreview(QueryAdvisor queryAdvisor, String paymentId) throws Exception;
	public DataSet getBankDetailsByPaymentIdForPreview(String paymentId) throws Exception;
}