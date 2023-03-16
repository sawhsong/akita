/**************************************************************************************************
 * Framework Generated Javascript Source
 * - Qm20ListPop.js
 *************************************************************************************************/
var dateFormat = jsconfig.get("dateFormatJs");
jsconfig.put("scrollablePanelHeightAdjust", -14);

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

	$("#icnEmpOrgSearch").click(function(event) {
		popupLookup = commonJs.openPopup({
			popupId:"EmpOrgLookup",
			url:"/common/lookup/getDefault.do",
			data:{
				lookupType:"EmploymentOrg",
				keyFieldId:"empOrgId",
				valueFieldId:"empOrgName",
				popupName:"parent.popupLookup",
				docTypeToSetValue:"page",
				lookupValue:$("#empOrgName").val()
			},
			header:per.per0202.header.popEmpOrgLookup,
			width:880,
			height:680
		});
	});

	$("#personEquals").blur(function() {
		if (commonJs.isEmpty($(this).val())) {
			$("#personId").val("");
		}
	});

	$("#empOrgName").blur(function() {
		if (commonJs.isEmpty($(this).val())) {
			$("#empOrgId").val("");
		}
	});

	$(document).keydown(function(event) {
		var code = event.keyCode || event.which, element = event.target;

		if (code == 13) {
			if ($(element).is("[name=personLike]") && !commonJs.isEmpty($("#personLike").val())) {
				doSearch();
			}

			if ($(element).is("[name=personIdLike]") && !commonJs.isEmpty($("#personIdLike").val())) {
				doSearch();
			}
		}

		if (code == 9) {
			if ($(element).is("[name=empOrgName]") && !commonJs.isEmpty($("#empOrgName").val())) {
				$("#icnEmpOrgSearch").trigger("click");
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

	doSave = function(keyValues) {
		commonJs.doSave({
			url:"/qm/20/exeSave.do",
			noForm:true,
			showPostMessage:false,
			data:{keyValues:keyValues},
			onSuccess:function(result) {
				var ds = result.dataSet;

				commonJs.copyToClipboard(ds.getValue(0, "PERSON_NUMBER"));
				parent.$("#divPersonInfo").html("&nbsp;/&nbsp;Person : "+ds.getValue(0, "FULL_NAME")+" ("+ds.getValue(0, "PERSON_NUMBER")+")");
				parent.popupQuickMenu.close();
			}
		});
	};

	doSearch = function() {
		commonJs.showProcMessageOnElement("divScrollablePanelPopup");

		commonJs.doSearch({
			url:"/qm/20/getList.do",
			onSuccess:renderGridData
		});
	};

	renderGridData = function(result) {
		var ds = result.dataSet, html = "";

		$("#tblGridBody").html("");

		if (ds.getRowCnt() > 0) {
			for (var i=0; i<ds.getRowCnt(); i++) {
				var gridTr = new UiGridTr();

				var iconAction = new UiIcon();
				iconAction.setName("icnAction").setUseFor("action").addAttribute("keyValues:"+ds.getValue(i, "PERSON_ID")+"_"+ds.getValue(i, "USER_ID")).setScript("doAction(this)");
				gridTr.addChild(new UiGridTd().addClassName("Ct").addChild(iconAction));

				gridTr.addChild(new UiGridTd().addClassName("Ct").addChild(new UiRadio().setName("rdoForSave").setValue(ds.getValue(i, "PERSON_ID")+"_"+ds.getValue(i, "USER_ID"))));
				gridTr.addChild(new UiGridTd().addClassName("Ct").addChild(new UiAnchor().setText(ds.getValue(i, "PERSON_ID")).setScript("doSave('"+ds.getValue(i, "PERSON_ID")+"_"+ds.getValue(i, "USER_ID")+"')")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").addChild(new UiAnchor().setText(ds.getValue(i, "PERSON_NUMBER")).setScript("doSave('"+ds.getValue(i, "PERSON_ID")+"_"+ds.getValue(i, "USER_ID")+"')")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").addChild(new UiAnchor().setText(ds.getValue(i, "SURNAME")).setScript("doSave('"+ds.getValue(i, "PERSON_ID")+"_"+ds.getValue(i, "USER_ID")+"')")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").addChild(new UiAnchor().setText(ds.getValue(i, "FIRST_NAME")).setScript("doSave('"+ds.getValue(i, "PERSON_ID")+"_"+ds.getValue(i, "USER_ID")+"')")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "MOBILE")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "USER_NAME")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "USER_EMAIL")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "PAYSLIP_EMAIL")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(commonJs.getDateTimeMask(ds.getValue(i, "MEMBER_SINCE"), dateFormat)));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(commonJs.getDateTimeMask(ds.getValue(i, "DATE_OF_BIRTH"), dateFormat)));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(commonJs.abbreviate(ds.getValue(i, "PERSON_TYPE"), 50)));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(commonJs.abbreviate(ds.getValue(i, "EMP_ORG_NAME"), 50)));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "PORTAL_SECURITY_ROLE")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(commonJs.abbreviate(ds.getValue(i, "CURR_BILLING_ORG_NAME"), 50)));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "ASG_COUNT")));
				gridTr.addChild(new UiGridTd().addClassName("Rt").setText(ds.getValue(i, "PAYMENT_COUNT")));

				html += gridTr.toHtmlString();
			}
		} else {
			var gridTr = new UiGridTr();

			gridTr.addChild(new UiGridTd().addClassName("Ct").setAttribute("colspan:19").setText(com.message.I001));
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
		var keyValues = $(img).attr("keyValues");

		$("input:radio[name=rdoForSave]").each(function(index) {
			if (!$(this).is(":disabled") && $(this).val() == keyValues) {
				if (!$(this).is(":checked")) {
					$(this).click();
				}
			} else {
				if ($(this).is(":checked")) {
					$(this).click();
				}
			}
		});

		ctxMenu.commonQmAction[0].fun = function() {doSave(keyValues);};

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
		commonJs.setAutoComplete($("#personEquals"), {
			method:"getPersonByNameOrPersonNumber",
			label:"full_name_with_person_number",
			value:"person_id",
			minLength:3,
			focus: function(event, ui) {
				$("#personId").val(ui.item.value);
				$("#personEquals").val(ui.item.label);
				return false;
			},
			change:function(event, ui) {
				if (commonJs.isEmpty($("#personEquals").val())) {
					$("#personId").val("");
					$("#personEquals").val("");
				}
			},
			select:function(event, ui) {
				$("#personId").val(ui.item.value);
				$("#personEquals").val(ui.item.label);
				doSearch();
				return false;
			}
		});

		commonJs.setAutoComplete($("#empOrgName"), {
			method:"getOrgByName",
			label:"org_name_with_org_id",
			value:"organisation_id",
			minLength:2,
			focus: function(event, ui) {
				$("#empOrgId").val(ui.item.value);
				$("#empOrgName").val(ui.item.label);
				return false;
			},
			change:function(event, ui) {
				if (commonJs.isEmpty($("#empOrgName").val())) {
					$("#empOrgId").val("");
					$("#empOrgName").val("");
				}
			},
			select:function(event, ui) {
				$("#empOrgId").val(ui.item.value);
				$("#empOrgName").val(ui.item.label);
				doSearch();
				return false;
			}
		});
	});
});