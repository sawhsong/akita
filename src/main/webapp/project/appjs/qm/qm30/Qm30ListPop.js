/**************************************************************************************************
 * Framework Generated Javascript Source
 * - Qm30ListPop.js
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

	$("#icnCscSearch").click(function(event) {
		popupLookup = commonJs.openPopup({
			popupId:"ESEmployeeLookup",
			url:"/common/lookup/getDefault.do",
			data:{
				lookupType:"EsEmployee",
				keyFieldId:"cscId",
				valueFieldId:"cscName",
				popupName:"parent.popupLookup",
				docTypeToSetValue:"page",
				lookupValue:$("#cscName").val()
			},
			header:"ES Employee Lookup",
			width:880,
			height:680
		});
	});

	$("#icnCrmSearch").click(function(event) {
		popupLookup = commonJs.openPopup({
			popupId:"ESEmployeeLookup",
			url:"/common/lookup/getDefault.do",
			data:{
				lookupType:"EsEmployee",
				keyFieldId:"crmId",
				valueFieldId:"crmName",
				popupName:"parent.popupLookup",
				docTypeToSetValue:"page",
				lookupValue:$("#crmName").val()
			},
			header:"ES Employee Lookup",
			width:880,
			height:680
		});
	});

	$("#orgEquals").blur(function() {
		if (commonJs.isEmpty($(this).val())) {
			$("#orgId").val("");
		}
	});

	$("#cscName").blur(function() {
		if (commonJs.isEmpty($(this).val())) {
			$("#cscId").val("");
		}
	});

	$("#crmName").blur(function() {
		if (commonJs.isEmpty($(this).val())) {
			$("#crmId").val("");
		}
	});

	$(document).keydown(function(event) {
		var code = event.keyCode || event.which, element = event.target;

		if (code == 13) {
			if ($(element).is("[name=orgLike]") && !commonJs.isEmpty($("#orgLike").val())) {
				doSearch();
			}
		}

		if (code == 9) {
			if ($(element).is("[name=cscName]") && !commonJs.isEmpty($("#cscName").val())) {
				$("#icnCscSearch").trigger("click");
			} else if ($(element).is("[name=crmName]") && !commonJs.isEmpty($("#crmName").val())) {
				$("#icnCrmSearch").trigger("click");
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

	doSave = function(orgId) {
		commonJs.doSave({
			url:"/qm/30/exeSave.do",
			data:{orgId:orgId},
			noForm:true,
			showPostMessage:false,
			onSuccess:function(result) {
				var ds = result.dataSet;
				commonJs.copyToClipboard(ds.getValue(0, "ORGANISATION_ID"));

				parent.$("#divOrgInfo").html("&nbsp;/&nbsp;Org : "+commonJs.abbreviate(ds.getValue(0, "ORGANISATION_NAME"), 50)+" ("+ds.getValue(0, "ORGANISATION_ID")+")");
				parent.popupQuickMenu.close();
			}
		});
	};

	doSearch = function() {
		commonJs.showProcMessageOnElement("divScrollablePanelPopup");

		if (commonJs.doValidate($("#fmDefault"))) {
			commonJs.doSearch({
				url:"/qm/30/getList.do",
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
				iconAction.setName("icnAction").setUseFor("action").addAttribute("organisationId:"+ds.getValue(i, "ORGANISATION_ID")).setScript("doAction(this)");
				gridTr.addChild(new UiGridTd().addClassName("Ct").addChild(iconAction));

				gridTr.addChild(new UiGridTd().addClassName("Ct").addChild(new UiRadio().setName("rdoForSave").setValue(ds.getValue(i, "ORGANISATION_ID"))));
				gridTr.addChild(new UiGridTd().addClassName("Ct").addChild(new UiAnchor().setText(ds.getValue(i, "ORGANISATION_ID")).setScript("doSave('"+ds.getValue(i, "ORGANISATION_ID")+"')")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").addChild(new UiAnchor().setText(ds.getValue(i, "ORGANISATION_NAME")).setScript("doSave('"+ds.getValue(i, "ORGANISATION_ID")+"')")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "ORGANISATION_TYPE_MEANING")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "RELATIONSHIP")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "ABN")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "ACN")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "STATE_MEANING")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "COUNTRY")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "ADDRESS")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "FIRST_CONTACT_DATE")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "CSC_NAME")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "CDM_CRM_NAME")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "CDM_CSM_NAME")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "CAD_CSD_NAME")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "CSA_NAME")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "CUSTOMER_CATEGORY_MEANING")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "CUSTOMER_STREAM_MEANING")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "TAX_INVOICE_ACCEPTANCE_MEANING")));

				html += gridTr.toHtmlString();
			}
		} else {
			var gridTr = new UiGridTr();

			gridTr.addChild(new UiGridTd().addClassName("Ct").setAttribute("colspan:20").setText(com.message.I001));
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
		var orgId = $(img).attr("organisationId");

		$("input:radio[name=rdoForSave]").each(function(index) {
			if (!$(this).is(":disabled") && $(this).val() == orgId) {
				if (!$(this).is(":checked")) {
					$(this).click();
				}
			} else {
				if ($(this).is(":checked")) {
					$(this).click();
				}
			}
		});

		ctxMenu.commonQmAction[0].fun = function() {doSave(orgId);};

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
		commonJs.setAutoComplete($("#orgEquals"), {
			method:"getOrgByNameOrId",
			label:"org_name_with_org_id",
			value:"organisation_id",
			minLength:2,
			focus: function(event, ui) {
				$("#orgId").val(ui.item.value);
				$("#orgEquals").val(ui.item.label);
				return false;
			},
			change:function(event, ui) {
				if (commonJs.isEmpty($("#orgEquals").val())) {
					$("#orgId").val("");
					$("#orgEquals").val("");
				}
			},
			select:function(event, ui) {
				$("#orgId").val(ui.item.value);
				$("#orgEquals").val(ui.item.label);
				doSearch();
				return false;
			}
		});

		commonJs.setAutoComplete($("#cscName"), {
			method:"getEsEmployeeByNameOrPersonNumber",
			label:"full_name_with_person_number",
			value:"person_id",
			minLength:2,
			focus: function(event, ui) {
				$("#cscId").val(ui.item.value);
				$("#cscName").val(ui.item.label);
				return false;
			},
			change:function(event, ui) {
				if (commonJs.isEmpty($("#cscName").val())) {
					$("#cscId").val("");
					$("#cscName").val("");
				}
			},
			select:function(event, ui) {
				$("#cscId").val(ui.item.value);
				$("#cscName").val(ui.item.label);
				doSearch();
				return false;
			}
		});

		commonJs.setAutoComplete($("#crmName"), {
			method:"getEsEmployeeByNameOrPersonNumber",
			label:"full_name_with_person_number",
			value:"person_id",
			minLength:2,
			focus: function(event, ui) {
				$("#crmId").val(ui.item.value);
				$("#crmName").val(ui.item.label);
				return false;
			},
			change:function(event, ui) {
				if (commonJs.isEmpty($("#crmName").val())) {
					$("#crmId").val("");
					$("#crmName").val("");
				}
			},
			select:function(event, ui) {
				$("#crmId").val(ui.item.value);
				$("#crmName").val(ui.item.label);
				doSearch();
				return false;
			}
		});

		commonJs.setAutoComplete($("#orgCountryName"), {
			method:"getCountryName",
			label:"country_name",
			value:"country_name",
			minLength:2,
			focus: function(event, ui) {
				$("#orgCountryName").val(ui.item.value);
				return false;
			},
			select:function(event, ui) {
				$("#orgCountryName").val(ui.item.value);
				doSearch();
				return false;
			}
		});
	});
});