/**************************************************************************************************
 * Framework Generated Javascript Source
 * - PayslipsFrame.js
 *************************************************************************************************/
var searchResultDataCount = 0;
jsconfig.put("scrollablePanelHeightAdjust", 40);

$(function() {
	/*!
	 * event
	 */
	$("#btnSearch").click(function(event) {
		doSearch();
	});

	$("#icnCheck").click(function(event) {
		commonJs.toggleCheckboxes("chkToSend");
	});

	/*!
	 * process
	 */
	setGridTable = function(totalResultRows) {
		$("#tblGrid").freezeHeader({
			attachTo:$("#divGridWrapper"),
			pagingArea:$("#divPagingArea"),
			isPageable:true,
			totalResultRows:totalResultRows,
			script:"doSearch"
		});
	};

	doSearch = function() {
		commonJs.showProcMessageOnElement("divScrollablePanelFrame");

		if (commonJs.doValidate($("#fmDefault"))) {
			commonJs.doSearch({
				url:"/per/perBasicInfo/perBasicProfile/getPayslipList.do",
				dataType:"html",
				data:{personId:personId},
				callback:renderGridData
			});
		}
	};

	renderGridData = function(result) {
		var ds = result.dataSet, html = "";

		searchResultDataCount = ds.getRowCnt();
		$("#tblGridBody").html("");

		if (ds.getRowCnt() > 0) {
			for (var i=0; i<ds.getRowCnt(); i++) {
				var gridTr = new UiGridTr();

				gridTr.addChild(new UiGridTd().addClassName("Ct").addChild(new UiCheckbox().setName("chkToSend").setValue(ds.getValue(i, "PAYMENT_ID"))));
				gridTr.addChild(new UiGridTd().addClassName("Lt").addChild(new UiAnchor().setText(ds.getValue(i, "ASSIGNMENT_NUMBER")).setScript("previewPayslip('"+ds.getValue(i, "PAYMENT_ID")+"', '"+ds.getValue(i, "ASSIGNMENT_ID")+"', '"+ds.getValue(i, "PAYROLL_TYPE")+"', '"+ds.getValue(i, "TAX_INVOICE_ACCEPTANCE_TYPE")+"')")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "PERIOD_START_DATE")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "PERIOD_END_DATE")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "ACTUAL_PAY_DATE")));
				gridTr.addChild(new UiGridTd().addClassName("Rt").setText(commonJs.getNumberMask(ds.getValue(i, "TOTAL_CONSULTING_REVENUE"), "#,##0.00")));
				gridTr.addChild(new UiGridTd().addClassName("Rt").setText(commonJs.getNumberMask(ds.getValue(i, "GROSS_TAXABLE"), "#,##0.00")));
				gridTr.addChild(new UiGridTd().addClassName("Rt").setText(commonJs.getNumberMask(ds.getValue(i, "PAYG_TAX"), "#,##0.00")));
				gridTr.addChild(new UiGridTd().addClassName("Rt").setText(commonJs.getNumberMask(ds.getValue(i, "TRANSFERED_AMT"), "#,##0.00")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(commonJs.abbreviate(ds.getValue(i, "EMPLOYMENT_ORG_NAME"), 50)));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(commonJs.abbreviate(ds.getValue(i, "BILLING_ORG_NAME"), 50)));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "TEMPLATE_NAME")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "PAYROLL_TYPE_MEANING")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "TAX_INVOICE_ACCEPTANCE_TYPE_MEANING")));

				html += gridTr.toHtmlString();
			}
		} else {
			var gridTr = new UiGridTr();

			gridTr.addChild(new UiGridTd().addClassName("Ct").setAttribute("colspan:14").setText(com.message.I001));
			html += gridTr.toHtmlString();
		}

		$("#tblGridBody").append($(html));
		setGridTable(result.totalResultRows);

		commonJs.bindToggleTrBackgroundWithCheckbox($("[name=chkToSend]"));
		commonJs.hideProcMessageOnElement("divScrollablePanelFrame");
	};

	previewPayslip = function(paymentId, assignmentId, payrollType, taxInvoiceAcceptanceType) {
		parent.popup = parent.commonJs.openPopup({
			popupId:"PreviewPayslip",
			url:"/common/payment/getDefault.do",
			data:{
				actionName:"previewPayslip",
				personId:personId,
				paymentId:paymentId,
				assignmentId:assignmentId,
				payrollType:payrollType,
				taxInvoiceAcceptanceType:taxInvoiceAcceptanceType
			},
			header:"Preview Payslip",
			width:750,
			height:900
		});
	};

	/*!
	 * load event (document / window)
	 */
	$(window).load(function() {
		doSearch();
	});
});