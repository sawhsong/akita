/**************************************************************************************************
 * Framework Generated Javascript Source
 * - SysItSupportInvoiceList.js
 *************************************************************************************************/
var popup = null;
var searchResultDataCount = 0;

$(function() {
	/*!
	 * event
	 */
	$("#btnSearch").click(function(event) {
		doSearch();
	});

	$("#btnClear").click(function(event) {
		commonJs.clearSearchCriteria();
	});

	$("#icnDateFrom").click(function(event) {
		commonJs.openCalendar(event, "dateFrom");
	});

	$("#icnDateTo").click(function(event) {
		commonJs.openCalendar(event, "dateTo");
	});

	$("#icnCheck").click(function(event) {
		commonJs.toggleCheckboxes("chkForAction");
	});

	$("#personName").blur(function() {
		if (commonJs.isEmpty($(this).val())) {
			$("#personId").val("");
		}
	});

	$("#billingOrgName").blur(function() {
		if (commonJs.isEmpty($(this).val())) {
			$("#billingOrgId").val("");
		}
	});

	$(document).keydown(function(event) {
		var code = event.keyCode || event.which, element = event.target;
	});

	$(document).keypress(function(event) {
		var code = event.keyCode || event.which, element = event.target;
		if (code == 13) {
			if ($(element).is("[name=invoiceId]")) {
				doSearch();
			}
		}
	});

	/*!
	 * context menus
	 */
	setActionButtonContextMenu = function() {
		var ctxMenu = [{
			name:"Update Status",
			img:"fa-list-alt",
			fun:function() {openPopup({mode:"UpdateStatus"});}
		}, {
			name:"Update Invoice Sub Total",
			img:"fa-usd",
			fun:function() {openPopup({mode:"UpdateInvoiceSubTotal"});}
		}];

		$("#btnAction").contextMenu(ctxMenu, {
			classPrefix:com.constants.ctxClassPrefixButton,
			effectDuration:100,
			effect:"fade",
			borderRadius:"bottom 4px",
			displayAround:"trigger",
			position:"bottom"
		});
	};

	/*!
	 * process
	 */
	doSearch = function() {
		commonJs.showProcMessageOnElement("divScrollablePanel");

		if (commonJs.doValidate($("#fmDefault"))) {
			commonJs.doSearch({
				url:"/sys/sysItSupport/sysItSupportInvoice/getList.do",
				dataType:"xml",
				callback:renderDataGridTable
			});
		}
	};

	renderDataGridTable = function(result) {
		var ds = result.dataSet;
		var html = "";

		searchResultDataCount = ds.getRowCnt();
		$("#tblGridBody").html("");

		if (ds.getRowCnt() > 0) {
			for (var i=0; i<ds.getRowCnt(); i++) {
				var gridTr = new UiGridTr();

				gridTr.addChild(new UiGridTd().addClassName("Ct").addChild(new UiCheckbox().setName("chkForAction").setValue(ds.getValue(i, "INVOICE_ID"))));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "INVOICE_ID")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "INVOICE_NUMBER")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "PARENT_INVOICE_ID")));
				gridTr.addChild(new UiGridTd().addClassName("Rt").setText(commonJs.getNumberMask(ds.getValue(i, "CNT_GROUPING"), "#,##0")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "INVOICE_DATE")));
				gridTr.addChild(new UiGridTd().addClassName("Rt").setText(commonJs.getNumberMask(ds.getValue(i, "INVOICE_AMOUNT"), "#,##0.00")));
				gridTr.addChild(new UiGridTd().addClassName("Rt").setText(commonJs.getNumberMask(ds.getValue(i, "GST_AMOUNT"), "#,##0.00")));
				gridTr.addChild(new UiGridTd().addClassName("Rt").setText(commonJs.getNumberMask(commonJs.toNumber(ds.getValue(i, "INVOICE_AMOUNT"))-commonJs.toNumber(ds.getValue(i, "GST_AMOUNT")), "#,##0.00")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "INVOICE_TYPE")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "STATUS_MEANING")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(commonJs.abbreviate(ds.getValue(i, "PAY_TO_ORG_NAME"), 50)));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(commonJs.abbreviate(ds.getValue(i, "PERSON_NAME"), 50)));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "CON_PERIOD_START_DATE")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "CON_PERIOD_END_DATE")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "GENERATION_TYPE_MEANING")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "CREATION_DATE")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "CREATED_BY")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "LAST_UPDATE_DATE")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "LAST_UPDATED_BY")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "SOURCE")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "SOURCE_ID")));

				html += gridTr.toHtmlString();
			}
		} else {
			var gridTr = new UiGridTr();

			gridTr.addChild(new UiGridTd().addClassName("Ct").setAttribute("colspan:22").setText(com.message.I001));
			html += gridTr.toHtmlString();
		}

		$("#tblGridBody").append($(html));

		$("#tblGrid").freezeHeader({
			attachTo:$("#divGridWrapper"),
			pagingArea:$("#divPagingArea"),
			isPageable:true,
			totalResultRows:result.totalResultRows,
			script:"doSearch"
		});

		commonJs.bindToggleTrBackgoundWithRadiobox($("[name=rdoForAction]"));
		commonJs.hideProcMessageOnElement("divScrollablePanel");
	};

	getDetail = function(invoiceId) {
		openPopup({mode:"Detail", invoiceId:invoiceId});
	};

	openPopup = function(param) {
		var url = "", header = com.header.popHeaderEdit, width = 0, height = 0;

		if (commonJs.getCountChecked("chkForAction") == 0) {
			commonJs.warn(com.message.I902);
			return;
		}

		if (param.mode == "Detail") {
			url = "/sys/sysItSupport/sysItSupportInvoice/getDetail.do";
			width = 1900, height = 990;
		} else if (param.mode == "UpdateStatus") {
			url = "/sys/sysItSupport/sysItSupportInvoice/getUpdateInvoiceStatus.do";
			width = 1500, height = 700;
		} else if (param.mode == "UpdateInvoiceSubTotal") {
			if (commonJs.getCountChecked("chkForAction") > 1) {
				commonJs.openDialog({
					type:com.message.W000,
					width:360,
					contents:"You can select only one Invoice to update invoice sub total."
				});
				return;
			}

			url = "/sys/sysItSupport/sysItSupportInvoice/getUpdateInvoiceSubTotal.do";
			width = 700, height = 400;
		}

		var popParam = {
			popupId:"SysItSupportInvoice"+param.mode,
			url:url,
			data:{
				mode:param.mode,
				chkForAction:commonJs.getCheckedValueFromCheckbox($("[name=chkForAction]")),
				invoiceId:commonJs.getCheckedValueFromCheckbox($("[name=chkForAction]"))
			},
			header:header,
			blind:true,
			width:width,
			height:height
		};

		popup = commonJs.openPopup(popParam);
	};

	exeExport = function(menuObject) {
		$("[name=fileType]").remove();
		$("[name=dataRange]").remove();

		if (searchResultDataCount <= 0) {
			commonJs.warn(com.message.I001);
			return;
		}

		commonJs.doExport({
			url:"/sys/sysItSupport/sysItSupportInvoice/exeExport.do",
			data:commonJs.serialiseObject($("#divSearchCriteriaArea")),
			menuObject:menuObject
		});
	};

	/*!
	 * load event (document / window)
	 */
	$(window).load(function() {
		setActionButtonContextMenu();
		commonJs.setExportButtonContextMenu($("#btnExport"));

		commonJs.setFieldDateMask("dateFrom");
		commonJs.setFieldDateMask("dateTo");

		commonJs.setAutoComplete($("#personName"), {
			method:"getPersonByNameOrPersonNumber",
			label:"full_name_with_person_number",
			value:"person_id",
			minLength:2,
			focus: function(event, ui) {
				$("#personId").val(ui.item.value);
				$("#personName").val(ui.item.label);
				return false;
			},
			change:function(event, ui) {
				if (commonJs.isEmpty($("#personName").val())) {
					$("#personId").val("");
					$("#personName").val("");
				}
			},
			select:function(event, ui) {
				$("#personId").val(ui.item.value);
				$("#personName").val(ui.item.label);
				doSearch();
				return false;
			}
		});

		commonJs.setAutoComplete($("#billingOrgName"), {
			method:"getBillingOrgByNameOrId",
			label:"org_name_with_org_id",
			value:"organisation_id",
			minLength:2,
			focus: function(event, ui) {
				$("#billingOrgId").val(ui.item.value);
				$("#billingOrgName").val(ui.item.label);
				return false;
			},
			change:function(event, ui) {
				if (commonJs.isEmpty($("#billingOrgName").val())) {
					$("#billingOrgId").val("");
					$("#billingOrgName").val("");
				}
			},
			select:function(event, ui) {
				$("#billingOrgId").val(ui.item.value);
				$("#billingOrgName").val(ui.item.label);
				doSearch();
				return false;
			}
		});
	});
});