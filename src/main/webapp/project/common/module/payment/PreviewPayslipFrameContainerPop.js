/**
 * PreviewPayslipFrameContainerPop.js
 */
var templateType = "";

$(function() {
	/*!
	 * event
	 */
	$("#btnClose").click(function(event) {
		parent.parent.popup.close();
	});

	/*!
	 * process
	 */
	setIframeSize = function() {
		$("#ifFrame").css("height", $("#divScrollablePanelPopup").height() - 6);
	};

	loadPage = function() {
		var actionString = "", paramString = "";

		if ("ICRCTI" == commonJs.upperCase(payrollType) || "ICNRCTI" == commonJs.upperCase(payrollType)) {
			templateType = ("RCTI" == commonJs.upperCase(taxInvoiceAcceptanceType)) ? "ICRCTI" : "ICRemittance";
		} else if ("STG" == commonJs.upperCase(payrollType) || "STNG" == commonJs.upperCase(payrollType)) {
			templateType = ("RCTI" == commonJs.upperCase(taxInvoiceAcceptanceType)) ? "STRCTI" : "STRemittance";
		} else if ("BCTI" == commonJs.upperCase(payrollType)) {
			templateType = ("BCTI" == commonJs.upperCase(taxInvoiceAcceptanceType)) ? "BCTI" : "ICRemittance";
		} else {
			templateType = "Remittance";
		}

		paramString = "templateType="+templateType+"&personId="+personId+"&paymentId="+paymentId+"&assignmentId="+assignmentId+"&payrollType="+payrollType+"&taxInvoiceAcceptanceType="+taxInvoiceAcceptanceType;
		actionString = "/common/payment/getPageByTemplate.do?"+paramString;
		setFrame(actionString);
	};

	setFrame = function(actionString) {
		$("#ifFrame").attr("src", actionString);
	};

	/*!
	 * load event (document / window)
	 */
	$(window).load(function() {
		setTimeout(function() {
			setIframeSize();
			loadPage();
		}, 500);
	});
});