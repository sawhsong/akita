/**************************************************************************************************
 * Framework Generated DAO Source
 * - PAYMENT - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.Payment;

import java.util.Date;

import project.conf.resource.ormapper.dto.oracle.Payment;
import zebra.base.IDao;
import zebra.data.DataSet;
import zebra.data.QueryAdvisor;

public interface PaymentDao extends IDao {
	public Payment getPayment(QueryAdvisor queryAdvisor, String paymentId) throws Exception;
	public Payment getPayment(String paymentId) throws Exception;

	public DataSet getPayslipMasterByPaymentId(QueryAdvisor queryAdvisor, String paymentId) throws Exception;
	public DataSet getPayslipMasterByPaymentId(String payrollType, String paymentId) throws Exception;

	public DataSet getYtdAllByPersonIdForPreview(QueryAdvisor queryAdvisor, String personId, Date paymentDate, String... ytdTypes) throws Exception;
	public DataSet getYtdAllByPersonIdForPreview(String personId, Date paymentDate, String... ytdTypes) throws Exception;
	public DataSet getYtdByElementIdForPreview(QueryAdvisor queryAdvisor, String personId, Date paymentDate, String... elementIds) throws Exception;
	public DataSet getYtdByElementIdForPreview(String personId, Date paymentDate, String... elementIds) throws Exception;

	public DataSet getPaymentAllByPaymentIdForPreview(QueryAdvisor queryAdvisor, String paymentId, String... paymentTypes) throws Exception;
	public DataSet getPaymentAllByPaymentIdForPreview(String paymentId, String... paymentTypes) throws Exception;
	public DataSet getPaymentByElementIdForPreview(QueryAdvisor queryAdvisor, String paymentId, String... elementIds) throws Exception;
	public DataSet getPaymentByElementIdForPreview(String paymentId, String... elementIds) throws Exception;

	public DataSet getEarningsByPaymentIdForPreview(QueryAdvisor queryAdvisor, String paymentId) throws Exception;
	public DataSet getEarningsByPaymentIdForPreview(String paymentId) throws Exception;
	public DataSet getEarningsForSTRemittanceByPaymentIdForPreview(QueryAdvisor queryAdvisor, String paymentId) throws Exception;
	public DataSet getEarningsForSTRemittanceByPaymentIdForPreview(String paymentId) throws Exception;

	public DataSet getDeductionsByPaymentIdForPreview(QueryAdvisor queryAdvisor, String paymentId) throws Exception;
	public DataSet getDeductionsByPaymentIdForPreview(String paymentId) throws Exception;

	public DataSet getCashPaymentsByPaymentIdForPreview(QueryAdvisor queryAdvisor, String paymentId) throws Exception;
	public DataSet getCashPaymentsByPaymentIdForPreview(String paymentId) throws Exception;

	public DataSet getDeductionsBCTIByPaymentIdForPreview(QueryAdvisor queryAdvisor, String paymentId) throws Exception;
	public DataSet getDeductionsBCTIByPaymentIdForPreview(String paymentId) throws Exception;
}