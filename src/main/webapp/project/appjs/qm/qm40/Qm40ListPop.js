/**************************************************************************************************
 * Framework Generated Javascript Source
 * - Qm40ListPop.js
 *************************************************************************************************/
var dateFormat = jsconfig.get("dateFormatJs");

$(function() {
	/*!
	 * event
	 */
	$("#btnSave").click(function(event) {
		if (!commonJs.doValidate("fmDefault")) {
			return;
		}

		var val = commonJs.getCheckedValueFromRadio("rdoForSave");

		if (commonJs.isEmpty(val)) {
			commonJs.warn(com.message.I902);
			return;
		}

		doSave(val);
	});

	$("#btnSearch").click(function(event) {
		doSearch();
	});

	$("#btnClear").click(function(event) {
		commonJs.clearSearchCriteria();
	});

	$("#btnClose").click(function(event) {
		parent.popupQuickMenu.close();
	});

	$("#personName").blur(function() {
		if (commonJs.isEmpty($(this).val())) {
			$("#personId").val("");
		}
	});

	$("#billingCode").blur(function() {
		if (commonJs.isEmpty($(this).val())) {
			$("#billingCodeId").val("");
		}
	});

	$("#billingOrgName").blur(function() {
		if (commonJs.isEmpty($(this).val())) {
			$("#billingOrgId").val("");
		}
	});

	$(document).keydown(function(event) {
		var code = event.keyCode || event.which, element = event.target;

		if (code == 13) {
			if ($(element).is("[name=asgId]")) {
				doSearch();
			}
		}
	});

	/*!
	 * process
	 */
	setGridTable = function(totalResultRows) {
		$("#tblGrid").freezeHeader({
			attachTo:$("#divGridWrapper"),
			pagingArea:$("#divPagingArea"),
			isPageable:true,
			pagingAlign:"center",
			totalResultRows:totalResultRows,
			script:"doSearch"
		});
	};

	doSave = function(assignmentId) {
		commonJs.doSave({
			url:"/qm/40/exeSave.do",
			data:{assignmentId:assignmentId},
			noForm:true,
			showPostMessage:false,
			onSuccess:function(result) {
				var ds = result.dataSet;
				commonJs.copyToClipboard(ds.getValue(0, "ASSIGNMENT_ID"));

				parent.$("#divAsgInfo").html("&nbsp;/&nbsp;Asg : "+ds.getValue(0, "ASSIGNMENT_NUMBER"));
				parent.popupQuickMenu.close();
			}
		});
	};

	doSearch = function() {
		commonJs.showProcMessageOnElement("divScrollablePanelPopup");

		if (commonJs.doValidate($("#fmDefault"))) {
			commonJs.doSearch({
				url:"/qm/40/getList.do",
				dataType:"html",
				onSuccess:renderGridData
			});
		}
	};

	renderGridData = function(result) {
		var ds = result.dataSet, html = "";

		$("#tblGridBody").html("");

		if (ds.getRowCnt() > 0) {
			for (var i=0; i<ds.getRowCnt(); i++) {
				var gridTr = new UiGridTr();

				var iconAction = new UiIcon();
				iconAction.setName("icnAction").setUseFor("action").addAttribute("assignmentId:"+ds.getValue(i, "ASSIGNMENT_ID")).setScript("doAction(this)");
				gridTr.addChild(new UiGridTd().addClassName("Ct").addChild(iconAction));

				gridTr.addChild(new UiGridTd().addClassName("Ct").addChild(new UiRadio().setName("rdoForSave").setValue(ds.getValue(i, "ASSIGNMENT_ID"))));
				gridTr.addChild(new UiGridTd().addClassName("Lt").addChild(new UiAnchor().setText(ds.getValue(i, "ASSIGNMENT_NUMBER")).setScript("doSave('"+ds.getValue(i, "ASSIGNMENT_ID")+"')")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "PERSON_NAME")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "HAS_PRT")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "HAS_WC")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "LAST_INVOICE_DATE")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "LAST_PAID_DATE")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "WORKING_STATE")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "ASG_START_DATE_FORMAT")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "ASG_END_DATE_FORMAT")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "BILLING_ORGANISATION_NAME")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "EU_ORGANISATION_NAME")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "ASG_ACTIVE")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "PREFERRED")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "PAYMENT_METHOD_NAME")));

				html += gridTr.toHtmlString();
			}
		} else {
			var gridTr = new UiGridTr();

			gridTr.addChild(new UiGridTd().addClassName("Ct").setAttribute("colspan:16").setText(com.message.I001));
			html += gridTr.toHtmlString();
		}

		$("#tblGridBody").append($(html));
		setGridTable(result.totalResultRows);

		$("[name=icnAction]").each(function(index) {
			$(this).contextMenu(ctxMenu.commonQmAction);
		});

		commonJs.bindToggleTrBackgoundWithRadiobox($("[name=rdoForSave]"));
		commonJs.hideProcMessageOnElement("divScrollablePanelPopup");
	};

	doAction = function(img) {
		var asgId = $(img).attr("assignmentId");

		$("input:radio[name=rdoForSave]").each(function(index) {
			if (!$(this).is(":disabled") && $(this).val() == asgId) {
				if (!$(this).is(":checked")) {
					$(this).click();
				}
			} else {
				if ($(this).is(":checked")) {
					$(this).click();
				}
			}
		});

		ctxMenu.commonQmAction[0].fun = function() {doSave(asgId);};

		$(img).contextMenu(ctxMenu.commonQmAction, {
			classPrefix:com.constants.ctxClassPrefixGrid,
			displayAround:"trigger",
			position:"bottom",
			horAdjust:0,
			verAdjust:2
		});
	};

	/*!
	 * load event (document / window)
	 */
	$(window).load(function() {
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

		commonJs.setAutoComplete($("#billingCode"), {
			method:"getBillingCodeByCodeOrId",
			label:"display_column",
			value:"billing_code_id",
			minLength:2,
			focus: function(event, ui) {
				$("#billingCodeId").val(ui.item.value);
				$("#billingCode").val(ui.item.label);
				return false;
			},
			change:function(event, ui) {
				if (commonJs.isEmpty($("#billingCode").val())) {
					$("#billingCodeId").val("");
					$("#billingCode").val("");
				}
			},
			select:function(event, ui) {
				$("#billingCodeId").val(ui.item.value);
				$("#billingCode").val(ui.item.label);
				doSearch();
				return false;
			}
		});

		commonJs.setAutoComplete($("#billingOrgName"), {
			method:"getBillingOrgByNameOrId",
			label:"org_name_with_org_id",
			value:"organisation_id",
			minLength:2,
			position:{
				my:"right top",
				at:"right bottom",
				collision:"fit flip"
			},
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