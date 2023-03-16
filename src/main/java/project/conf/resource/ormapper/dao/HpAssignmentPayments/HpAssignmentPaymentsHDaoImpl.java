/**************************************************************************************************
 * Framework Generated HDAOImpl Source
 * - HP_ASSIGNMENT_PAYMENTS - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.HpAssignmentPayments;

import project.common.extend.BaseHDao;
import zebra.data.DataSet;
import zebra.data.QueryAdvisor;

public class HpAssignmentPaymentsHDaoImpl extends BaseHDao implements HpAssignmentPaymentsDao {
	public DataSet getBankDetailsByPaymentIdForPreview(QueryAdvisor queryAdvisor, String paymentId) throws Exception {
		queryAdvisor.addVariable("paymentId", paymentId);

		return selectAsDataSet(queryAdvisor, "query.HpAssignmentPayments.getBankDetailsByPaymentIdForPreview");
	}

	public DataSet getBankDetailsByPaymentIdForPreview(String paymentId) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();

		queryAdvisor.addVariable("paymentId", paymentId);

		return selectAsDataSet(queryAdvisor, "query.HpAssignmentPayments.getBankDetailsByPaymentIdForPreview");
	}
}