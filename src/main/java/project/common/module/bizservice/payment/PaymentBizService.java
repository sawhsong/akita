package project.common.module.bizservice.payment;

import java.util.Date;

import project.conf.resource.ormapper.dto.oracle.Payment;
import project.conf.resource.ormapper.dto.oracle.PaymentElement;
import zebra.data.DataSet;
import zebra.data.QueryAdvisor;

public interface PaymentBizService {
	public Payment getPayment(QueryAdvisor queryAdvisor, String paymentId) throws Exception;
	public PaymentElement getPaymentElementByElementId(QueryAdvisor queryAdvisor, String paymentId, String elementId) throws Exception;

	public DataSet getPayslipListByPersonId(QueryAdvisor queryAdvisor, String personId) throws Exception;
	public DataSet getPayslipMasterByPaymentId(QueryAdvisor queryAdvisor, String paymentId) throws Exception;
	public DataSet getBalanceLinesByElementId(QueryAdvisor queryAdvisor, String paymentId, String elementId) throws Exception;
	public DataSet getBalanceLinesByElementIds(QueryAdvisor queryAdvisor, String paymentId, String... elementIds) throws Exception;
	public DataSet getYtdAllByPersonIdForPreview(QueryAdvisor queryAdvisor, String personId, Date paymentDate, String... ytdTypes) throws Exception;
	public DataSet getYtdByElementIdForPreview(QueryAdvisor queryAdvisor, String personId, Date paymentDate, String elementId) throws Exception;
	public DataSet getEarningsByPaymentIdForPreview(QueryAdvisor queryAdvisor, String paymentId) throws Exception;
	public DataSet getEarningsForSTRemittanceByPaymentIdForPreview(QueryAdvisor queryAdvisor, String paymentId) throws Exception;
	public DataSet getDeductionsByPaymentIdForPreview(QueryAdvisor queryAdvisor, String paymentId) throws Exception;
	public DataSet getYtdDeductionForPreview(QueryAdvisor queryAdvisor, String personId, Date paymentDate) throws Exception;
	public DataSet getPaymentAllByPaymentIdForPreview(QueryAdvisor queryAdvisor, String paymentId, String... paymentTypes) throws Exception;
	public DataSet getBankDetailsByPaymentIdForPreview(QueryAdvisor queryAdvisor, String paymentId) throws Exception;
	public DataSet getLeaveAccrualsByAssignmentIdForPreview(QueryAdvisor queryAdvisor, String assignmentId) throws Exception;

	public DataSet getCashPaymentsByPaymentIdForPreview(QueryAdvisor queryAdvisor, String paymentId) throws Exception;

	public DataSet getDeductionsBCTIByPaymentIdForPreview(QueryAdvisor queryAdvisor, String paymentId) throws Exception;
}