package project.common.module.bizservice.payment;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import project.conf.resource.ormapper.dao.HpAsgProcesses.HpAsgProcessesDao;
import project.conf.resource.ormapper.dao.HpAssignmentAccruals.HpAssignmentAccrualsDao;
import project.conf.resource.ormapper.dao.HpAssignmentPayments.HpAssignmentPaymentsDao;
import project.conf.resource.ormapper.dao.HpBalanceLines.HpBalanceLinesDao;
import project.conf.resource.ormapper.dao.Payment.PaymentDao;
import project.conf.resource.ormapper.dao.PaymentElement.PaymentElementDao;
import project.conf.resource.ormapper.dto.oracle.Payment;
import project.conf.resource.ormapper.dto.oracle.PaymentElement;
import zebra.data.DataSet;
import zebra.data.QueryAdvisor;
import zebra.example.common.extend.BaseBiz;

public class PaymentBizServiceImpl extends BaseBiz implements PaymentBizService {
	@Autowired
	private HpAsgProcessesDao hpAsgProcessesDao;
	@Autowired
	private PaymentDao paymentDao;
	@Autowired
	private PaymentElementDao paymentElementDao;
	@Autowired
	private HpBalanceLinesDao hpBalanceLinesDao;
	@Autowired
	private HpAssignmentPaymentsDao hpAssignmentPaymentsDao;
	@Autowired
	private HpAssignmentAccrualsDao hpAssignmentAccrualsDao;

	public Payment getPayment(QueryAdvisor queryAdvisor, String paymentId) throws Exception {
		paymentDao.setDataSourceName((String)queryAdvisor.getObject("dataSource"));
		return paymentDao.getPayment(queryAdvisor, paymentId);
	}

	public PaymentElement getPaymentElementByElementId(QueryAdvisor queryAdvisor, String paymentId, String elementId) throws Exception {
		paymentElementDao.setDataSourceName((String)queryAdvisor.getObject("dataSource"));
		return paymentElementDao.getPaymentElementByElementId(queryAdvisor, paymentId, elementId);
	}

	public DataSet getPayslipListByPersonId(QueryAdvisor queryAdvisor, String personId) throws Exception {
		hpAsgProcessesDao.setDataSourceName((String)queryAdvisor.getObject("dataSource"));
		return hpAsgProcessesDao.getPayslipListByPersonId(queryAdvisor, personId);
	}

	public DataSet getPayslipMasterByPaymentId(QueryAdvisor queryAdvisor, String paymentId) throws Exception {
		paymentDao.setDataSourceName((String)queryAdvisor.getObject("dataSource"));
		return paymentDao.getPayslipMasterByPaymentId(queryAdvisor, paymentId);
	}

	public DataSet getBalanceLinesByElementId(QueryAdvisor queryAdvisor, String paymentId, String elementId) throws Exception {
		hpBalanceLinesDao.setDataSourceName((String)queryAdvisor.getObject("dataSource"));
		return hpBalanceLinesDao.getByElementId(queryAdvisor, paymentId, elementId);
	}

	public DataSet getBalanceLinesByElementIds(QueryAdvisor queryAdvisor, String paymentId, String... elementIds) throws Exception {
		hpBalanceLinesDao.setDataSourceName((String)queryAdvisor.getObject("dataSource"));
		return hpBalanceLinesDao.getByElementIds(queryAdvisor, paymentId, elementIds);
	}

	public DataSet getYtdAllByPersonIdForPreview(QueryAdvisor queryAdvisor, String personId, Date paymentDate, String... ytdTypes) throws Exception {
		paymentDao.setDataSourceName((String)queryAdvisor.getObject("dataSource"));
		return paymentDao.getYtdAllByPersonIdForPreview(queryAdvisor, personId, paymentDate, ytdTypes);
	}

	public DataSet getYtdByElementIdForPreview(QueryAdvisor queryAdvisor, String personId, Date paymentDate, String elementId) throws Exception {
		paymentDao.setDataSourceName((String)queryAdvisor.getObject("dataSource"));
		return paymentDao.getYtdByElementIdForPreview(queryAdvisor, personId, paymentDate, elementId);
	}

	public DataSet getEarningsByPaymentIdForPreview(QueryAdvisor queryAdvisor, String paymentId) throws Exception {
		paymentDao.setDataSourceName((String)queryAdvisor.getObject("dataSource"));
		return paymentDao.getEarningsByPaymentIdForPreview(queryAdvisor, paymentId);
	}

	public DataSet getEarningsForSTRemittanceByPaymentIdForPreview(QueryAdvisor queryAdvisor, String paymentId) throws Exception {
		paymentDao.setDataSourceName((String)queryAdvisor.getObject("dataSource"));
		return paymentDao.getEarningsForSTRemittanceByPaymentIdForPreview(queryAdvisor, paymentId);
	}

	public DataSet getDeductionsByPaymentIdForPreview(QueryAdvisor queryAdvisor, String paymentId) throws Exception {
		paymentDao.setDataSourceName((String)queryAdvisor.getObject("dataSource"));
		return paymentDao.getDeductionsByPaymentIdForPreview(queryAdvisor, paymentId);
	}

	public DataSet getYtdDeductionForPreview(QueryAdvisor queryAdvisor, String personId, Date paymentDate) throws Exception {
		paymentDao.setDataSourceName((String)queryAdvisor.getObject("dataSource"));
		return paymentDao.getYtdAllByPersonIdForPreview(queryAdvisor, personId, paymentDate, "Deduction");
	}

	public DataSet getPaymentAllByPaymentIdForPreview(QueryAdvisor queryAdvisor, String paymentId, String... paymentTypes) throws Exception {
		paymentDao.setDataSourceName((String)queryAdvisor.getObject("dataSource"));
		return paymentDao.getPaymentAllByPaymentIdForPreview(queryAdvisor, paymentId, paymentTypes);
	}

	public DataSet getBankDetailsByPaymentIdForPreview(QueryAdvisor queryAdvisor, String paymentId) throws Exception {
		hpAssignmentPaymentsDao.setDataSourceName((String)queryAdvisor.getObject("dataSource"));
		return hpAssignmentPaymentsDao.getBankDetailsByPaymentIdForPreview(queryAdvisor, paymentId);
	}

	public DataSet getLeaveAccrualsByAssignmentIdForPreview(QueryAdvisor queryAdvisor, String assignmentId) throws Exception {
		hpAssignmentAccrualsDao.setDataSourceName((String)queryAdvisor.getObject("dataSource"));
		return hpAssignmentAccrualsDao.getLeaveAccrualsByAssignmentIdForPreview(queryAdvisor, assignmentId);
	}

	public DataSet getCashPaymentsByPaymentIdForPreview(QueryAdvisor queryAdvisor, String paymentId) throws Exception {
		paymentDao.setDataSourceName((String)queryAdvisor.getObject("dataSource"));
		return paymentDao.getCashPaymentsByPaymentIdForPreview(queryAdvisor, paymentId);
	}

	public DataSet getDeductionsBCTIByPaymentIdForPreview(QueryAdvisor queryAdvisor, String paymentId) throws Exception {
		paymentDao.setDataSourceName((String)queryAdvisor.getObject("dataSource"));
		return paymentDao.getDeductionsBCTIByPaymentIdForPreview(queryAdvisor, paymentId);
	}
}