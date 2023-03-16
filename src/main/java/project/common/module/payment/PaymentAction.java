package project.common.module.payment;

import org.springframework.beans.factory.annotation.Autowired;

import project.common.extend.BaseAction;
import zebra.data.DataSet;

public class PaymentAction extends BaseAction {
	@Autowired
	private PaymentBiz biz;

	public String getDefault() throws Exception {
		DataSet requestDataSet = paramEntity.getRequestDataSet();
		String actionName = requestDataSet.getValue("actionName");

		biz.getDefault(paramEntity);
		return actionName;
	}

	public String getPageByTemplate() throws Exception {
		DataSet requestDataSet = paramEntity.getRequestDataSet();
		String templateType = requestDataSet.getValue("templateType");

		biz.getPageByTemplate(paramEntity);
		return templateType;
	}

	public String getEarnings() throws Exception {
		try {
			biz.getEarnings(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getDeductions() throws Exception {
		try {
			biz.getDeductions(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getPayAdvice() throws Exception {
		try {
			biz.getPayAdvice(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getPaymentType() throws Exception {
		try {
			biz.getPaymentType(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getBankDetails() throws Exception {
		try {
			biz.getBankDetails(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getLeaveAccruals() throws Exception {
		try {
			biz.getLeaveAccruals(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getICRCTITaxableSupplies() throws Exception {
		try {
			biz.getICRCTITaxableSupplies(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getICRCTIValues() throws Exception {
		try {
			biz.getICRCTIValues(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getICRemittanceEarnings() throws Exception {
		try {
			biz.getICRemittanceEarnings(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getICRemittanceValues() throws Exception {
		try {
			biz.getICRemittanceValues(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getSTRemittanceEarnings() throws Exception {
		try {
			biz.getSTRemittanceEarnings(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getSTRemittanceValues() throws Exception {
		try {
			biz.getSTRemittanceValues(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getBCTITaxableSupplies() throws Exception {
		try {
			biz.getBCTITaxableSupplies(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getBCTIValues() throws Exception {
		try {
			biz.getICRCTIValues(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}
}