package project.common.module.autocompletion;

import org.springframework.beans.factory.annotation.Autowired;

import project.common.extend.BaseAction;

public class AutoCompletionAction extends BaseAction {
	@Autowired
	private AutoCompletionBiz biz;

	/*!
	 * Sys, User, CommonCode, Login, Country, Currency
	 */
	public String getCommonCodeType() throws Exception {
		try {
			biz.getCommonCodeType(paramEntity);
		} catch (Exception ex) {
			return "ajaxResponse";
		} finally {
			setRequestAttribute("paramEntity", paramEntity);
		}
		return "ajaxResponse";
	}

	public String getUserId() throws Exception {
		try {
			biz.getUserId(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getLoginId() throws Exception {
		try {
			biz.getLoginId(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getUserName() throws Exception {
		try {
			biz.getUserName(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getCurrencyCode() throws Exception {
		try {
			biz.getCurrencyCode(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getCountryName() throws Exception {
		try {
			biz.getCountryName(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	/*!
	 * Org
	 */
	public String getOrgById() throws Exception {
		try {
			biz.getOrgById(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getOrgByName() throws Exception {
		try {
			biz.getOrgByName(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getOrgByNameOrId() throws Exception {
		try {
			biz.getOrgByNameOrId(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getBillingOrgByName() throws Exception {
		try {
			biz.getBillingOrgByName(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getBillingOrgByNameOrId() throws Exception {
		try {
			biz.getBillingOrgByNameOrId(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getOrgName() throws Exception {
		try {
			biz.getOrgName(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getAbn() throws Exception {
		try {
			biz.getAbn(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	/*!
	 * Person, Employee
	 */
	public String getPersonNumber() throws Exception {
		try {
			biz.getPersonNumber(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getPersonName() throws Exception {
		try {
			biz.getPersonName(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getPersonByPersonNumber() throws Exception {
		try {
			biz.getPersonByPersonNumber(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getPersonByName() throws Exception {
		try {
			biz.getPersonByName(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getPersonByNameOrPersonNumber() throws Exception {
		try {
			biz.getPersonByNameOrPersonNumber(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getEsEmployeeByPersonNumber() throws Exception {
		try {
			biz.getEsEmployeeByPersonNumber(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getEsEmployeeByName() throws Exception {
		try {
			biz.getEsEmployeeByName(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getEsEmployeeByNameOrPersonNumber() throws Exception {
		try {
			biz.getEsEmployeeByNameOrPersonNumber(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	/*!
	 * Billing Code
	 */
	public String getBillingCodeById() throws Exception {
		try {
			biz.getBillingCodeById(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getBillingCodeByCode() throws Exception {
		try {
			biz.getBillingCodeByCode(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getBillingCodeByCodeOrId() throws Exception {
		try {
			biz.getBillingCodeByCodeOrId(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	/*!
	 * Assignment
	 */
	public String getCostCentre() throws Exception {
		try {
			biz.getCostCentre(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getPaymentMethodByCodeOrId() throws Exception {
		try {
			biz.getPaymentMethodByCodeOrId(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}
}