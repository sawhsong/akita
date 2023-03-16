/**************************************************************************************************
 * Framework Generated Javascript Source
 * - SysItSupportAssignmentList.js
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

	$("#icnCheck").click(function(event) {
		commonJs.toggleCheckboxes("chkForAction");
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
	});

	$(document).keypress(function(event) {
		var code = event.keyCode || event.which, element = event.target;
		if (code == 13) {
			if ($(element).is("[name=asgId]")) {
				doSearch();
			}
		}
	});

	/*!
	 * context menus
	 */
	setActionButtonContextMenu = function() {
		var ctxMenu = [{
			name:"Unlock PRT",
			img:"fa-unlock-alt",
			fun:function() {openPopup({mode:"UnlockPrt"});}
		}, {
			name:"Update Working State",
			img:"fa-map",
			fun:function() {openPopup({mode:"UpdateWorkingState"});}
		}, {
			name:"Update End User",
			img:"fa-building",
			fun:function() {openPopup({mode:"UpdateEndUser"});}
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
				url:"/sys/sysItSupport/sysItSupportAssignment/getList.do",
				dataType:"html",
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

				gridTr.addChild(new UiGridTd().addClassName("Ct").addChild(new UiCheckbox().setName("chkForAction").setValue(ds.getValue(i, "ASSIGNMENT_ID"))));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "ASSIGNMENT_NUMBER")));
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

			gridTr.addChild(new UiGridTd().addClassName("Ct").setAttribute("colspan:15").setText(com.message.I001));
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

		commonJs.bindToggleTrBackgroundWithCheckbox($("[name=chkForAction]"));
		commonJs.hideProcMessageOnElement("divScrollablePanel");
	};

	getDetail = function(assignmentId) {
		openPopup({mode:"Detail", assignmentId:assignmentId});
	};

	openPopup = function(param) {
		var url = "", header = com.header.popHeaderDetail, width = 0, height = 0;

		if (commonJs.getCountChecked("chkForAction") == 0) {
			commonJs.warn(com.message.I902);
			return;
		}

		if (param.mode == "Detail") {
			url = "/sys/sysItSupport/sysItSupportAssignment/getDetail.do";
			width = 1900, height = 990;
		} else if (param.mode == "UnlockPrt") {
			url = "/sys/sysItSupport/sysItSupportAssignment/getUnlockPrt.do";
			width = 1900, height = 600;
		} else if (param.mode == "UpdateWorkingState") {
			url = "/sys/sysItSupport/sysItSupportAssignment/getUpdateWorkingState.do";
			width = 1000, height = 500;
		} else if (param.mode == "UpdateEndUser") {
			url = "/sys/sysItSupport/sysItSupportAssignment/getUpdateEndUser.do";
			width = 1100, height = 500;
		}

		var popParam = {
			popupId:"sysItSupportAssignment"+param.mode,
			url:url,
			data:{
				mode:param.mode,
				chkForAction:commonJs.getCheckedValueFromCheckbox($("[name=chkForAction]"))
			},
			header:param.mode,
			blind:true,
			width:width,
			height:height
		};

		popup = commonJs.openPopup(popParam);
	};

	exeExport = function(menuObject) {
		if (searchResultDataCount <= 0) {
			commonJs.warn(com.message.I001);
			return;
		}

		commonJs.doExport({
			url:"/sys/sysItSupport/sysItSupportAssignment/exeExport.do",
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