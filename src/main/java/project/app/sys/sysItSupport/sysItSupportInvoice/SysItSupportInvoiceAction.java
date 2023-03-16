/**************************************************************************************************
 * project
 * Description - SysItSupportInvoice - Invoice
 *	- Generated by Source Generator
 *************************************************************************************************/
package project.app.sys.sysItSupport.sysItSupportInvoice;

import org.springframework.beans.factory.annotation.Autowired;

import project.common.extend.BaseAction;

public class SysItSupportInvoiceAction extends BaseAction {
	@Autowired
	private SysItSupportInvoiceBiz biz;

	public String getDefault() throws Exception {
		biz.getDefault(paramEntity);
		return "list";
	}

	public String getList() throws Exception {
		try {
			biz.getList(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getDetail() throws Exception {
		biz.getDetail(paramEntity);
		return "detail";
	}

	public String getUpdateInvoiceStatus() throws Exception {
		biz.getUpdateInvoiceStatus(paramEntity);
		return "updateStatus";
	}

	public String getUpdateInvoiceSubTotal() throws Exception {
		biz.getUpdateInvoiceSubTotal(paramEntity);
		return "updateInvoiceSubTotal";
	}

	public String doUpdateInvoiceStatus() throws Exception {
		try {
			biz.doUpdateInvoiceStatus(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String doUpdateInvoiceSubTotal() throws Exception {
		try {
			biz.doUpdateInvoiceSubTotal(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String doCalculateAmount() throws Exception {
		try {
			biz.doCalculateAmount(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String exeExport() throws Exception {
		biz.exeExport(paramEntity);
		setRequestAttribute("paramEntity", paramEntity);
		return "export";
	}
}