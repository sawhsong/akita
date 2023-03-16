package project.common.module.payment;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import project.common.extend.BaseBiz;
import project.common.module.bizservice.payment.PaymentBizService;
import project.conf.resource.ormapper.dto.oracle.Payment;
import project.conf.resource.ormapper.dto.oracle.PaymentElement;
import zebra.data.DataSet;
import zebra.data.ParamEntity;
import zebra.data.QueryAdvisor;
import zebra.exception.FrameworkException;
import zebra.util.CommonUtil;
import zebra.util.ConfigUtil;

public class PaymentBizImpl extends BaseBiz implements PaymentBiz {
	@Autowired
	private PaymentBizService paymentBS;

	public ParamEntity getDefault(ParamEntity paramEntity) throws Exception {
		try {
			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}

	public ParamEntity getPageByTemplate(ParamEntity paramEntity) throws Exception {
		DataSet dsRequest = paramEntity.getRequestDataSet();
		QueryAdvisor queryAdvisor = paramEntity.getQueryAdvisor();
		DataSet payslipMaster = new DataSet(), rctiMaster = new DataSet(), nrctiMaster = new DataSet();
		String payrollType = dsRequest.getValue("payrollType");
		String paymentId = dsRequest.getValue("paymentId");
		String taxInvoiceAcceptanceType = dsRequest.getValue("taxInvoiceAcceptanceType");
		HttpSession session = paramEntity.getSession();
		String dataSource = CommonUtil.nvl((String)session.getAttribute("DatabaseQuickSearch"), ConfigUtil.getProperty("jdbc.user.name"));

		try {
			queryAdvisor.setObject("dataSource", dataSource);

			if (CommonUtil.equals(payrollType, "STG") || CommonUtil.equals(payrollType, "STNG")) {
				if (CommonUtil.equals(taxInvoiceAcceptanceType, "RCTI")) {
					queryAdvisor.setObject("payrollType", "ICRCTI");
					rctiMaster = paymentBS.getPayslipMasterByPaymentId(queryAdvisor, paymentId);
					queryAdvisor.setObject("payrollType", "STNG");
					nrctiMaster = paymentBS.getPayslipMasterByPaymentId(queryAdvisor, paymentId);

					paramEntity.setObject("rctiMaster", rctiMaster);
					paramEntity.setObject("nrctiMaster", nrctiMaster);
				} else {
					queryAdvisor.setObject("payrollType", payrollType);
					payslipMaster = paymentBS.getPayslipMasterByPaymentId(queryAdvisor, paymentId);
					paramEntity.setObject("payslipMaster", payslipMaster);
				}
			} else {
				queryAdvisor.setObject("payrollType", payrollType);
				payslipMaster = paymentBS.getPayslipMasterByPaymentId(queryAdvisor, paymentId);
				paramEntity.setObject("payslipMaster", payslipMaster);
			}

			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}

	public ParamEntity getEarnings(ParamEntity paramEntity) throws Exception {
		DataSet dsRequest = paramEntity.getRequestDataSet();
		QueryAdvisor queryAdvisor = paramEntity.getQueryAdvisor();
		String paymentId = dsRequest.getValue("paymentId");
		HttpSession session = paramEntity.getSession();
		String dataSource = CommonUtil.nvl((String)session.getAttribute("DatabaseQuickSearch"), ConfigUtil.getProperty("jdbc.user.name"));

		try {
			queryAdvisor.setObject("dataSource", dataSource);

			paramEntity.setAjaxResponseDataSet(paymentBS.getEarningsByPaymentIdForPreview(queryAdvisor, paymentId));
			paramEntity.setTotalResultRows(queryAdvisor.getTotalResultRows());
			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}

	public ParamEntity getDeductions(ParamEntity paramEntity) throws Exception {
		DataSet dsRequest = paramEntity.getRequestDataSet();
		QueryAdvisor queryAdvisor = paramEntity.getQueryAdvisor();
		String dateFormat = ConfigUtil.getProperty("format.date.java");
		String personId = dsRequest.getValue("personId");
		String paymentId = dsRequest.getValue("paymentId");
		Date paymentDate = CommonUtil.toDate(dsRequest.getValue("paymentDate"), dateFormat);
		DataSet deduction, ytd;
		int deductionRowIndex = 0;
		HttpSession session = paramEntity.getSession();
		String dataSource = CommonUtil.nvl((String)session.getAttribute("DatabaseQuickSearch"), ConfigUtil.getProperty("jdbc.user.name"));

		try {
			queryAdvisor.setObject("dataSource", dataSource);

			deduction = paymentBS.getDeductionsByPaymentIdForPreview(queryAdvisor, paymentId);
			if (deduction.getRowCnt() > 0) {
				deduction.addColumn("YTD_VALUE");
			} else {
				deduction = new DataSet(new String[] {"ALTERNATE_NAME", "ELEMENT_REPORTING_NAME", "SHOW_ZERO_Y_N", "CALCULATED_AMOUNT", "YTD_VALUE"});
			}

			deductionRowIndex = deduction.getRowCnt();
			queryAdvisor.resetAll();
			ytd = paymentBS.getYtdDeductionForPreview(queryAdvisor, personId, paymentDate);
			ytd.addColumn("IS_PROCESSED");
			for (int i=0; i<ytd.getRowCnt(); i++) {
				if (deductionRowIndex > 0) {
					for (int j=0; j<deductionRowIndex; j++) {
						String elementId = deduction.getValue(j, "ELEMENT_ID");
						if (CommonUtil.equals(elementId, ytd.getValue(i, "ELEMENT_ID"))) {
							deduction.setValue(j, "YTD_VALUE", ytd.getValue(i, "VALUE"));
							ytd.setValue(i, "IS_PROCESSED", "Y");
						}
					}
				}
			}

			for (int i=0; i<ytd.getRowCnt(); i++) {
				boolean isProcessed = CommonUtil.toBoolean(ytd.getValue(i, "IS_PROCESSED"));
				if (!isProcessed) {
					deduction.addRow();
					deduction.setValue(deduction.getRowCnt()-1, "ALTERNATE_NAME", ytd.getValue(i, "REPORTING_NAME"));
					deduction.setValue(deduction.getRowCnt()-1, "ELEMENT_REPORTING_NAME", ytd.getValue(i, "REPORTING_NAME"));
					deduction.setValue(deduction.getRowCnt()-1, "SHOW_ZERO_Y_N", "Y");
					deduction.setValue(deduction.getRowCnt()-1, "CALCULATED_AMOUNT", "0");
					deduction.setValue(deduction.getRowCnt()-1, "YTD_VALUE", ytd.getValue(i, "VALUE"));
				}
			}

			paramEntity.setAjaxResponseDataSet(deduction);
			paramEntity.setTotalResultRows(queryAdvisor.getTotalResultRows());
			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}

	public ParamEntity getPayAdvice(ParamEntity paramEntity) throws Exception {
		DataSet dsRequest = paramEntity.getRequestDataSet();
		QueryAdvisor queryAdvisor = paramEntity.getQueryAdvisor();
		DataSet dsPayAdvice;
		HttpSession session = paramEntity.getSession();
		String dataSource = CommonUtil.nvl((String)session.getAttribute("DatabaseQuickSearch"), ConfigUtil.getProperty("jdbc.user.name"));

		try {
			queryAdvisor.setObject("dataSource", dataSource);

			dsPayAdvice = getPayAdviceDataSet(queryAdvisor, dsRequest);

			paramEntity.setAjaxResponseDataSet(dsPayAdvice);
			paramEntity.setTotalResultRows(dsPayAdvice.getRowCnt());
			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}

	public ParamEntity getPaymentType(ParamEntity paramEntity) throws Exception {
		DataSet dsRequest = paramEntity.getRequestDataSet();
		QueryAdvisor queryAdvisor = paramEntity.getQueryAdvisor();
		String dateFormat = ConfigUtil.getProperty("format.date.java");
		String personId = dsRequest.getValue("personId");
		String paymentId = dsRequest.getValue("paymentId");
		Date paymentDate = CommonUtil.toDate(dsRequest.getValue("paymentDate"), dateFormat);
		DataSet ds, dsYtd;
		DataSet dsPaymentType = new DataSet(new String[] {"PAYMENT_TYPE_NAME", "THIS_PERIOD", "YTD"});
		HttpSession session = paramEntity.getSession();
		String dataSource = CommonUtil.nvl((String)session.getAttribute("DatabaseQuickSearch"), ConfigUtil.getProperty("jdbc.user.name"));
		double earningYtd = 0, deductionYtd = 0;

		try {
			queryAdvisor.setObject("dataSource", dataSource);

			ds = paymentBS.getBalanceLinesByElementId(queryAdvisor, paymentId, "2");	// NET_BALANCE_ID
			queryAdvisor.resetAll();
			dsYtd = paymentBS.getYtdAllByPersonIdForPreview(queryAdvisor, personId, paymentDate, "Earnings", "Deduction", "Superannuation", "SuperSalSac", "PAYG", "OtherTaxation");

			// Net Wages
			dsPaymentType.addRow();
			dsPaymentType.setValue(dsPaymentType.getRowCnt()-1, "PAYMENT_TYPE_NAME", "Net Wages");
			dsPaymentType.setValue(dsPaymentType.getRowCnt()-1, "THIS_PERIOD", ds.getValue("VALUE"));
			for (int i=0; i<dsYtd.getRowCnt(); i++) {
				String name = dsYtd.getValue(i, "YTD_TYPE");
				if (CommonUtil.equalsIgnoreCase(name, "Earnings")) {
					earningYtd += CommonUtil.toDouble(dsYtd.getValue(i, "VALUE"));
				} else {
					deductionYtd += CommonUtil.toDouble(dsYtd.getValue(i, "VALUE"));
				}
			}
			dsPaymentType.setValue(dsPaymentType.getRowCnt()-1, "YTD", (earningYtd - deductionYtd));

			// PostTaxAddBacks
			queryAdvisor.resetAll();
			ds = paymentBS.getPaymentAllByPaymentIdForPreview(queryAdvisor, paymentId, "AddBack");
			if (ds.getRowCnt() > 0 ) {
				for (int i=0; i<ds.getRowCnt(); i++) {
					dsPaymentType.addRow();
					dsPaymentType.setValue(dsPaymentType.getRowCnt()-1, "PAYMENT_TYPE_NAME", CommonUtil.nvl(ds.getValue(i, "ELEMENT_REPORTING_NAME"), ds.getValue(i, "ALTERNATE_NAME")));
					dsPaymentType.setValue(dsPaymentType.getRowCnt()-1, "THIS_PERIOD", ds.getValue("CALCULATED_AMOUNT"));

					queryAdvisor.resetAll();
					dsYtd = paymentBS.getYtdByElementIdForPreview(queryAdvisor, personId, paymentDate, ds.getValue("ELEMENT_ID"));
					dsPaymentType.setValue(dsPaymentType.getRowCnt()-1, "YTD", dsYtd.getValue("VALUE"));
				}
			}

			queryAdvisor.resetAll();
			dsYtd = paymentBS.getYtdAllByPersonIdForPreview(queryAdvisor, personId, paymentDate, "AddBack");
			for (int i=0; i<dsYtd.getRowCnt(); i++) {
				if (ds.getRowCnt() > 0) {
					String elementId = dsYtd.getValue(i, "ELEMENT_ID");
					for (int j=0; j<ds.getRowCnt(); j++) {
						if (!CommonUtil.equals(elementId, ds.getValue(j, "ELEMENT_ID"))) {
							dsPaymentType.addRow();
							dsPaymentType.setValue(dsPaymentType.getRowCnt()-1, "PAYMENT_TYPE_NAME", CommonUtil.nvl(dsYtd.getValue(i, "REPORTING_NAME"), dsYtd.getValue(i, "ELEMENT_NAME")));
							dsPaymentType.setValue(dsPaymentType.getRowCnt()-1, "THIS_PERIOD", "0");
							dsPaymentType.setValue(dsPaymentType.getRowCnt()-1, "YTD", dsYtd.getValue(i, "VALUE"));
						}
					}
				} else {
					dsPaymentType.addRow();
					dsPaymentType.setValue(dsPaymentType.getRowCnt()-1, "PAYMENT_TYPE_NAME", CommonUtil.nvl(dsYtd.getValue(i, "REPORTING_NAME"), dsYtd.getValue(i, "ELEMENT_NAME")));
					dsPaymentType.setValue(dsPaymentType.getRowCnt()-1, "THIS_PERIOD", "0");
					dsPaymentType.setValue(dsPaymentType.getRowCnt()-1, "YTD", dsYtd.getValue(i, "VALUE"));
				}
			}

			// PostTaxDeductions
			queryAdvisor.resetAll();
			ds = paymentBS.getPaymentAllByPaymentIdForPreview(queryAdvisor, paymentId, "PostDeduction");
			if (ds.getRowCnt() > 0 ) {
				for (int i=0; i<ds.getRowCnt(); i++) {
					dsPaymentType.addRow();
					dsPaymentType.setValue(dsPaymentType.getRowCnt()-1, "PAYMENT_TYPE_NAME", CommonUtil.nvl(ds.getValue(i, "ELEMENT_REPORTING_NAME"), ds.getValue(i, "ALTERNATE_NAME")));
					dsPaymentType.setValue(dsPaymentType.getRowCnt()-1, "THIS_PERIOD", ds.getValue("CALCULATED_AMOUNT"));

					queryAdvisor.resetAll();
					dsYtd = paymentBS.getYtdByElementIdForPreview(queryAdvisor, personId, paymentDate, ds.getValue("ELEMENT_ID"));
					dsPaymentType.setValue(dsPaymentType.getRowCnt()-1, "YTD", dsYtd.getValue("VALUE"));
				}
			}

			queryAdvisor.resetAll();
			dsYtd = paymentBS.getYtdAllByPersonIdForPreview(queryAdvisor, personId, paymentDate, "PostDeduction");
			for (int i=0; i<dsYtd.getRowCnt(); i++) {
				if (ds.getRowCnt() > 0) {
					String elementId = dsYtd.getValue(i, "ELEMENT_ID");
					for (int j=0; j<ds.getRowCnt(); j++) {
						if (!CommonUtil.equals(elementId, ds.getValue(j, "ELEMENT_ID"))) {
							dsPaymentType.addRow();
							dsPaymentType.setValue(dsPaymentType.getRowCnt()-1, "PAYMENT_TYPE_NAME", CommonUtil.nvl(dsYtd.getValue(i, "REPORTING_NAME"), dsYtd.getValue(i, "ELEMENT_NAME")));
							dsPaymentType.setValue(dsPaymentType.getRowCnt()-1, "THIS_PERIOD", "0");
							dsPaymentType.setValue(dsPaymentType.getRowCnt()-1, "YTD", dsYtd.getValue(i, "VALUE"));
						}
					}
				} else {
					dsPaymentType.addRow();
					dsPaymentType.setValue(dsPaymentType.getRowCnt()-1, "PAYMENT_TYPE_NAME", CommonUtil.nvl(dsYtd.getValue(i, "REPORTING_NAME"), dsYtd.getValue(i, "ELEMENT_NAME")));
					dsPaymentType.setValue(dsPaymentType.getRowCnt()-1, "THIS_PERIOD", "0");
					dsPaymentType.setValue(dsPaymentType.getRowCnt()-1, "YTD", dsYtd.getValue(i, "VALUE"));
				}
			}

			paramEntity.setAjaxResponseDataSet(dsPaymentType);
			paramEntity.setTotalResultRows(dsPaymentType.getRowCnt());
			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}

	public ParamEntity getBankDetails(ParamEntity paramEntity) throws Exception {
		DataSet dsRequest = paramEntity.getRequestDataSet();
		QueryAdvisor queryAdvisor = paramEntity.getQueryAdvisor();
		String paymentId = dsRequest.getValue("paymentId");
		HttpSession session = paramEntity.getSession();
		String dataSource = CommonUtil.nvl((String)session.getAttribute("DatabaseQuickSearch"), ConfigUtil.getProperty("jdbc.user.name"));

		try {
			queryAdvisor.setObject("dataSource", dataSource);

			paramEntity.setAjaxResponseDataSet(paymentBS.getBankDetailsByPaymentIdForPreview(queryAdvisor, paymentId));
			paramEntity.setTotalResultRows(queryAdvisor.getTotalResultRows());
			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}

	public ParamEntity getLeaveAccruals(ParamEntity paramEntity) throws Exception {
		DataSet dsRequest = paramEntity.getRequestDataSet();
		QueryAdvisor queryAdvisor = paramEntity.getQueryAdvisor();
		String assignmentId = dsRequest.getValue("assignmentId");
		HttpSession session = paramEntity.getSession();
		String dataSource = CommonUtil.nvl((String)session.getAttribute("DatabaseQuickSearch"), ConfigUtil.getProperty("jdbc.user.name"));

		try {
			queryAdvisor.setObject("dataSource", dataSource);

			paramEntity.setAjaxResponseDataSet(paymentBS.getLeaveAccrualsByAssignmentIdForPreview(queryAdvisor, assignmentId));
			paramEntity.setTotalResultRows(queryAdvisor.getTotalResultRows());
			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}

	public ParamEntity getICRCTITaxableSupplies(ParamEntity paramEntity) throws Exception {
		DataSet dsRequest = paramEntity.getRequestDataSet();
		QueryAdvisor queryAdvisor = paramEntity.getQueryAdvisor();
		String paymentId = dsRequest.getValue("paymentId");
		DataSet ds, dsEarning, dsCash;
		HttpSession session = paramEntity.getSession();
		String dataSource = CommonUtil.nvl((String)session.getAttribute("DatabaseQuickSearch"), ConfigUtil.getProperty("jdbc.user.name"));

		try {
			queryAdvisor.setObject("dataSource", dataSource);

			dsEarning = paymentBS.getEarningsByPaymentIdForPreview(queryAdvisor, paymentId);
			queryAdvisor.resetAll();
			dsCash = paymentBS.getCashPaymentsByPaymentIdForPreview(queryAdvisor, paymentId);

			ds = dsEarning.copyDataSet();
			ds.merge(dsCash);

			paramEntity.setAjaxResponseDataSet(ds);
			paramEntity.setTotalResultRows(queryAdvisor.getTotalResultRows());
			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}

	public ParamEntity getICRCTIValues(ParamEntity paramEntity) throws Exception {
		DataSet dsRequest = paramEntity.getRequestDataSet();
		QueryAdvisor queryAdvisor = paramEntity.getQueryAdvisor();
		String paymentId = dsRequest.getValue("paymentId");
		Payment payment = new Payment();
		PaymentElement paymentElement = new PaymentElement();
		DataSet dsDeduction, ds = new DataSet();
		HttpSession session = paramEntity.getSession();
		String dataSource = CommonUtil.nvl((String)session.getAttribute("DatabaseQuickSearch"), ConfigUtil.getProperty("jdbc.user.name"));

		try {
			queryAdvisor.setObject("dataSource", dataSource);

			payment = paymentBS.getPayment(queryAdvisor, paymentId);
			queryAdvisor.resetAll();
			paymentElement = paymentBS.getPaymentElementByElementId(queryAdvisor, paymentId, "1575"); // GST Paid

			queryAdvisor.resetAll();
			dsDeduction = paymentBS.getPaymentAllByPaymentIdForPreview(queryAdvisor, paymentId, "PostDeduction");
			ds.addColumn("Deduction", CommonUtil.nvl(dsDeduction.getValue("CALCULATED_AMOUNT"), "0"));
			ds.addColumn("SubTotal", CommonUtil.toStringWithNoFormat(payment.getNetAmount() - paymentElement.getCalculatedAmount()));
			ds.addColumn("GST", CommonUtil.toStringWithNoFormat(paymentElement.getCalculatedAmount()));
			ds.addColumn("Total", CommonUtil.toStringWithNoFormat(payment.getNetAmount()));

			paramEntity.setAjaxResponseDataSet(ds);
			paramEntity.setTotalResultRows(ds.getRowCnt());
			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}

	public ParamEntity getICRemittanceEarnings(ParamEntity paramEntity) throws Exception {
		DataSet dsRequest = paramEntity.getRequestDataSet();
		QueryAdvisor queryAdvisor = paramEntity.getQueryAdvisor();
		String paymentId = dsRequest.getValue("paymentId");
		DataSet ds, dsEarning, dsCash, dsDeduction;
		HttpSession session = paramEntity.getSession();
		String dataSource = CommonUtil.nvl((String)session.getAttribute("DatabaseQuickSearch"), ConfigUtil.getProperty("jdbc.user.name"));

		try {
			queryAdvisor.setObject("dataSource", dataSource);

			dsEarning = paymentBS.getEarningsByPaymentIdForPreview(queryAdvisor, paymentId);
			queryAdvisor.resetAll();
			dsCash = paymentBS.getCashPaymentsByPaymentIdForPreview(queryAdvisor, paymentId);
			queryAdvisor.resetAll();
			dsDeduction = paymentBS.getPaymentAllByPaymentIdForPreview(queryAdvisor, paymentId, "OtherTaxation");

			ds = dsEarning.copyDataSet();
			ds.merge(dsCash);
			ds.merge(dsDeduction);

			paramEntity.setAjaxResponseDataSet(ds);
			paramEntity.setTotalResultRows(queryAdvisor.getTotalResultRows());
			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}

	public ParamEntity getICRemittanceValues(ParamEntity paramEntity) throws Exception {
		DataSet dsRequest = paramEntity.getRequestDataSet();
		QueryAdvisor queryAdvisor = paramEntity.getQueryAdvisor();
		String paymentId = dsRequest.getValue("paymentId");
		Payment payment = new Payment();
		PaymentElement paymentElement = new PaymentElement();
		DataSet dsEarning, dsCash, dsTax, ds = new DataSet();
		double earning = 0, cash = 0, tax = 0, subTotal = 0;
		HttpSession session = paramEntity.getSession();
		String dataSource = CommonUtil.nvl((String)session.getAttribute("DatabaseQuickSearch"), ConfigUtil.getProperty("jdbc.user.name"));

		try {
			queryAdvisor.setObject("dataSource", dataSource);

			dsEarning = paymentBS.getEarningsByPaymentIdForPreview(queryAdvisor, paymentId);
			queryAdvisor.resetAll();
			dsCash = paymentBS.getCashPaymentsByPaymentIdForPreview(queryAdvisor, paymentId);
			queryAdvisor.resetAll();
			dsTax = paymentBS.getBalanceLinesByElementIds(queryAdvisor, paymentId, "1612", "1614", "1616", "8833"); // PAYG_ID, HECS_ID, SSS_ID, RWHT_ID
			for (int i=0; i<dsTax.getRowCnt(); i++) {
				tax += CommonUtil.toDouble(dsTax.getValue(i, "VALUE"));
			}

			earning = CommonUtil.toDouble(dsEarning.getValue("CALCULATED_AMOUNT"));
			cash = CommonUtil.toDouble(dsCash.getValue("CALCULATED_AMOUNT"));
			subTotal = earning + cash - tax;

			queryAdvisor.resetAll();
			payment = paymentBS.getPayment(queryAdvisor, paymentId);
			queryAdvisor.resetAll();
			paymentElement = paymentBS.getPaymentElementByElementId(queryAdvisor, paymentId, "1575"); // GST Paid

			ds.addColumn("SubTotal", CommonUtil.toStringWithNoFormat(subTotal));
			ds.addColumn("GST", CommonUtil.toStringWithNoFormat(paymentElement.getCalculatedAmount()));
			ds.addColumn("Total", CommonUtil.toStringWithNoFormat(payment.getNetAmount()));

			paramEntity.setAjaxResponseDataSet(ds);
			paramEntity.setTotalResultRows(ds.getRowCnt());
			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}

	public ParamEntity getSTRemittanceEarnings(ParamEntity paramEntity) throws Exception {
		DataSet dsRequest = paramEntity.getRequestDataSet();
		QueryAdvisor queryAdvisor = paramEntity.getQueryAdvisor();
		String paymentId = dsRequest.getValue("paymentId");
		DataSet dsEarning;
		HttpSession session = paramEntity.getSession();
		String dataSource = CommonUtil.nvl((String)session.getAttribute("DatabaseQuickSearch"), ConfigUtil.getProperty("jdbc.user.name"));

		try {
			queryAdvisor.setObject("dataSource", dataSource);

			dsEarning = paymentBS.getEarningsForSTRemittanceByPaymentIdForPreview(queryAdvisor, paymentId);

			paramEntity.setAjaxResponseDataSet(dsEarning);
			paramEntity.setTotalResultRows(queryAdvisor.getTotalResultRows());
			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}

	public ParamEntity getSTRemittanceValues(ParamEntity paramEntity) throws Exception {
		DataSet dsRequest = paramEntity.getRequestDataSet();
		QueryAdvisor queryAdvisor = paramEntity.getQueryAdvisor();
		String paymentId = dsRequest.getValue("paymentId");
		Payment payment = new Payment();
		PaymentElement paymentElement = new PaymentElement();
		DataSet dsEarning, dsTax, dsOthers, ds = new DataSet();
		double earning = 0, tax = 0, subTotal = 0;
		HttpSession session = paramEntity.getSession();
		String dataSource = CommonUtil.nvl((String)session.getAttribute("DatabaseQuickSearch"), ConfigUtil.getProperty("jdbc.user.name"));

		try {
			queryAdvisor.setObject("dataSource", dataSource);

			dsEarning = paymentBS.getEarningsForSTRemittanceByPaymentIdForPreview(queryAdvisor, paymentId);
			queryAdvisor.resetAll();
			dsTax = paymentBS.getBalanceLinesByElementIds(queryAdvisor, paymentId, "1612", "1614", "1616", "8833"); // PAYG_ID, HECS_ID, SSS_ID, RWHT_ID
			for (int i=0; i<dsTax.getRowCnt(); i++) {
				tax += CommonUtil.toDouble(dsTax.getValue(i, "VALUE"));
			}

			earning = CommonUtil.toDouble(dsEarning.getValue("CALCULATED_AMOUNT"));
			subTotal = earning + tax;

			queryAdvisor.resetAll();
			dsOthers = paymentBS.getPaymentAllByPaymentIdForPreview(queryAdvisor, paymentId, "Superannuation", "SuperSalSac", "PAYG", "OtherTaxation");

			queryAdvisor.resetAll();
			payment = paymentBS.getPayment(queryAdvisor, paymentId);
			queryAdvisor.resetAll();
			paymentElement = paymentBS.getPaymentElementByElementId(queryAdvisor, paymentId, "1575"); // GST Paid

			ds.addColumn("SubTotal", CommonUtil.toStringWithNoFormat(subTotal));
			ds.addColumn("GST", CommonUtil.toStringWithNoFormat(paymentElement.getCalculatedAmount()));
			for (int i=0; i<dsOthers.getRowCnt(); i++) {
				ds.addColumn(dsOthers.getValue(i, "TYPE"), dsOthers.getValue(i, "CALCULATED_AMOUNT"));
			}
			ds.addColumn("Total", CommonUtil.toStringWithNoFormat(payment.getNetAmount()));

			paramEntity.setAjaxResponseDataSet(ds);
			paramEntity.setTotalResultRows(ds.getRowCnt());
			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}

	public ParamEntity getBCTITaxableSupplies(ParamEntity paramEntity) throws Exception {
		DataSet dsRequest = paramEntity.getRequestDataSet();
		QueryAdvisor queryAdvisor = paramEntity.getQueryAdvisor();
		String paymentId = dsRequest.getValue("paymentId");
		DataSet ds, dsEarning, dsCash, dsDeduction;
		HttpSession session = paramEntity.getSession();
		String dataSource = CommonUtil.nvl((String)session.getAttribute("DatabaseQuickSearch"), ConfigUtil.getProperty("jdbc.user.name"));

		try {
			queryAdvisor.setObject("dataSource", dataSource);

			dsEarning = paymentBS.getEarningsByPaymentIdForPreview(queryAdvisor, paymentId);
			queryAdvisor.resetAll();
			dsCash = paymentBS.getCashPaymentsByPaymentIdForPreview(queryAdvisor, paymentId);
			queryAdvisor.resetAll();
			dsDeduction = paymentBS.getDeductionsBCTIByPaymentIdForPreview(queryAdvisor, paymentId);

			ds = dsEarning.copyDataSet();
			ds.merge(dsCash);
			ds.merge(dsDeduction);

			paramEntity.setAjaxResponseDataSet(ds);
			paramEntity.setTotalResultRows(queryAdvisor.getTotalResultRows());
			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}

	/*!
	 * Private methods
	 */
	private DataSet getPayAdviceDataSet(QueryAdvisor queryAdvisor, DataSet dsRequest) throws Exception {
		String dateFormat = ConfigUtil.getProperty("format.date.java");
		String personId = dsRequest.getValue("personId");
		String paymentId = dsRequest.getValue("paymentId");
		Date paymentDate = CommonUtil.toDate(dsRequest.getValue("paymentDate"), dateFormat);
		DataSet dsPayAdvice = new DataSet(new String[] {"PAY_ADVICE_NAME", "THIS_PERIOD", "YTD"});
		DataSet dsThisPeriod, dsYtd;
		double earningThisPeriod = 0, deductionThisPeriod = 0, earningYtd = 0, deductionYtd = 0, dTemp = 0;

		// Total Package
		queryAdvisor.resetAll();
		dsPayAdvice.addRow();
		dsPayAdvice.setValue(dsPayAdvice.getRowCnt()-1, "PAY_ADVICE_NAME", "Total Package");
		dsThisPeriod = paymentBS.getPaymentAllByPaymentIdForPreview(queryAdvisor, paymentId, "Earnings", "Deduction");
		queryAdvisor.resetAll();
		dsYtd = paymentBS.getYtdAllByPersonIdForPreview(queryAdvisor, personId, paymentDate, "Earnings", "Deduction");

		for (int i=0; i<dsThisPeriod.getRowCnt(); i++) {
			String typeName = dsThisPeriod.getValue(i, "TYPE");
			if (CommonUtil.equalsIgnoreCase(typeName, "Earnings")) {
				earningThisPeriod += CommonUtil.toDouble(dsThisPeriod.getValue(i, "CALCULATED_AMOUNT"));
			} else if (CommonUtil.equalsIgnoreCase(typeName, "Deduction")) {
				deductionThisPeriod += CommonUtil.toDouble(dsThisPeriod.getValue(i, "CALCULATED_AMOUNT"));
			}
		}
		dsPayAdvice.setValue(dsPayAdvice.getRowCnt()-1, "THIS_PERIOD", (earningThisPeriod - deductionThisPeriod));

		for (int i=0; i<dsYtd.getRowCnt(); i++) {
			String typeName = dsYtd.getValue(i, "YTD_TYPE");
			if (CommonUtil.equalsIgnoreCase(typeName, "Earnings")) {
				earningYtd += CommonUtil.toDouble(dsYtd.getValue(i, "VALUE"));
			} else if (CommonUtil.equalsIgnoreCase(typeName, "Deduction")) {
				deductionYtd += CommonUtil.toDouble(dsYtd.getValue(i, "VALUE"));
			}
		}
		dsPayAdvice.setValue(dsPayAdvice.getRowCnt()-1, "YTD", (earningYtd - deductionYtd));

		// Superannuation
		queryAdvisor.resetAll();
		dsThisPeriod = paymentBS.getPaymentAllByPaymentIdForPreview(queryAdvisor, paymentId, "Superannuation");
		queryAdvisor.resetAll();
		dsYtd = paymentBS.getYtdAllByPersonIdForPreview(queryAdvisor, personId, paymentDate, "Superannuation");
		dTemp = CommonUtil.toDouble(dsThisPeriod.getValue("CALCULATED_AMOUNT")) + CommonUtil.toDouble(dsYtd.getValue("VALUE"));

		if (dTemp > 0) {
			dsPayAdvice.addRow();
			dsPayAdvice.setValue(dsPayAdvice.getRowCnt()-1, "PAY_ADVICE_NAME", "Superannuation ("+dsThisPeriod.getValue("SUPER_NAME")+")");
			dsPayAdvice.setValue(dsPayAdvice.getRowCnt()-1, "THIS_PERIOD", dsThisPeriod.getValue("CALCULATED_AMOUNT"));
			dsPayAdvice.setValue(dsPayAdvice.getRowCnt()-1, "YTD", dsYtd.getValue("VALUE"));
		}

		// SuperSalSac
		queryAdvisor.resetAll();
		dsThisPeriod = paymentBS.getPaymentAllByPaymentIdForPreview(queryAdvisor, paymentId, "SuperSalSac");
		queryAdvisor.resetAll();
		dsYtd = paymentBS.getYtdAllByPersonIdForPreview(queryAdvisor, personId, paymentDate, "SuperSalSac");
		dTemp = CommonUtil.toDouble(dsThisPeriod.getValue("CALCULATED_AMOUNT")) + CommonUtil.toDouble(dsYtd.getValue("VALUE"));

		if (dTemp > 0) {
			dsPayAdvice.addRow();
			dsPayAdvice.setValue(dsPayAdvice.getRowCnt()-1, "PAY_ADVICE_NAME", "Salary Sacrifice");
			dsPayAdvice.setValue(dsPayAdvice.getRowCnt()-1, "THIS_PERIOD", dsThisPeriod.getValue("CALCULATED_AMOUNT"));
			dsPayAdvice.setValue(dsPayAdvice.getRowCnt()-1, "YTD", dsYtd.getValue("VALUE"));
		}

		// Gross Income
		queryAdvisor.resetAll();
		earningThisPeriod = 0; deductionThisPeriod = 0; earningYtd = 0; deductionYtd = 0;
		for (int i=0; i<dsPayAdvice.getRowCnt(); i++) {
			String name = dsPayAdvice.getValue(i, "PAY_ADVICE_NAME");
			if (CommonUtil.equalsIgnoreCase(name, "Total Package")) {
				earningThisPeriod += CommonUtil.toDouble(dsPayAdvice.getValue(i, "THIS_PERIOD"));
			} else {
				deductionThisPeriod += CommonUtil.toDouble(dsPayAdvice.getValue(i, "THIS_PERIOD"));
			}
		}

		for (int i=0; i<dsPayAdvice.getRowCnt(); i++) {
			String name = dsPayAdvice.getValue(i, "PAY_ADVICE_NAME");
			if (CommonUtil.equalsIgnoreCase(name, "Total Package")) {
				earningYtd += CommonUtil.toDouble(dsPayAdvice.getValue(i, "YTD"));
			} else {
				deductionYtd += CommonUtil.toDouble(dsPayAdvice.getValue(i, "YTD"));
			}
		}

		if ((earningThisPeriod - deductionThisPeriod) != 0 || (earningYtd - deductionYtd) != 0) {
			dsPayAdvice.addRow();
			dsPayAdvice.setValue(dsPayAdvice.getRowCnt()-1, "PAY_ADVICE_NAME", "Gross Income");
			dsPayAdvice.setValue(dsPayAdvice.getRowCnt()-1, "THIS_PERIOD", (earningThisPeriod - deductionThisPeriod));
			dsPayAdvice.setValue(dsPayAdvice.getRowCnt()-1, "YTD", (earningYtd - deductionYtd));
		}

		// PAYG
		queryAdvisor.resetAll();
		dsThisPeriod = paymentBS.getPaymentAllByPaymentIdForPreview(queryAdvisor, paymentId, "PAYG");
		queryAdvisor.resetAll();
		dsYtd = paymentBS.getYtdAllByPersonIdForPreview(queryAdvisor, personId, paymentDate, "PAYG");
		dTemp = CommonUtil.toDouble(dsThisPeriod.getValue("CALCULATED_AMOUNT")) + CommonUtil.toDouble(dsYtd.getValue("VALUE"));

		if (dTemp > 0) {
			dsPayAdvice.addRow();
			dsPayAdvice.setValue(dsPayAdvice.getRowCnt()-1, "PAY_ADVICE_NAME", "PAYG Taxation");
			dsPayAdvice.setValue(dsPayAdvice.getRowCnt()-1, "THIS_PERIOD", dsThisPeriod.getValue("CALCULATED_AMOUNT"));
			dsPayAdvice.setValue(dsPayAdvice.getRowCnt()-1, "YTD", dsYtd.getValue("VALUE"));
		}

		// Other Taxation
		queryAdvisor.resetAll();
		dsThisPeriod = paymentBS.getPaymentAllByPaymentIdForPreview(queryAdvisor, paymentId, "OtherTaxation");
		queryAdvisor.resetAll();
		dsYtd = paymentBS.getYtdAllByPersonIdForPreview(queryAdvisor, personId, paymentDate, "OtherTaxation");
		dTemp = CommonUtil.toDouble(dsThisPeriod.getValue("CALCULATED_AMOUNT")) + CommonUtil.toDouble(dsYtd.getValue("VALUE"));

		if (dTemp > 0) {
			dsPayAdvice.addRow();
			dsPayAdvice.setValue(dsPayAdvice.getRowCnt()-1, "PAY_ADVICE_NAME", "Other Taxation");
			dsPayAdvice.setValue(dsPayAdvice.getRowCnt()-1, "THIS_PERIOD", dsThisPeriod.getValue("CALCULATED_AMOUNT"));
			dsPayAdvice.setValue(dsPayAdvice.getRowCnt()-1, "YTD", dsYtd.getValue("VALUE"));
		}

		return dsPayAdvice;
	}
}