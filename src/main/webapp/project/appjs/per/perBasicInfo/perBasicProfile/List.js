/**************************************************************************************************
 * Framework Generated Javascript Source
 * - List.js
 *************************************************************************************************/
var popupLookup = null;
var searchResultDataCount = 0;
jsconfig.put("useJqTooltip", true);
jsconfig.put("scrollablePanelHeightAdjust", -20);

$(function() {
	/*!
	 * event
	 */
	$("#btnNew").click(function(event) {
		getPersonDetail("");
	});

	$("#btnSearch").click(function(event) {
		doSearch();
	});

	$("#btnClear").click(function(event) {
		commonJs.clearSearchCriteria();
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
			header:"Employment Organisation",
			width:880,
			height:680
		});
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
			attachTo:$("#divDataArea"),
			pagingArea:$("#divPagingArea"),
			isPageable:true,
			totalResultRows:totalResultRows,
			script:"doSearch"
		});
	};

	doSearch = function() {
		commonJs.showProcMessageOnElement("divScrollablePanel");

		if (commonJs.doValidate($("#fmDefault"))) {
			commonJs.doSearch({
				url:"/per/perBasicInfo/perBasicProfile/getList.do",
				dataType:"xml",
				onSuccess:renderGridData
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
				var asgCnt = commonJs.getNumberMask(ds.getValue(i, "NUMBER_OF_ASSIGNMENT"), "#,##0");
				var activeAsgCnt = commonJs.getNumberMask(ds.getValue(i, "NUMBER_OF_ACTIVE_ASSIGNMENT"), "#,##0");

				gridTr.addChild(new UiGridTd().addClassName("Ct").addChild(new UiAnchor().setText(ds.getValue(i, "PERSON_NUMBER")).setScript("getPersonDetail('"+ds.getValue(i, "PERSON_ID")+"')")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "SURNAME")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "FIRST_NAME")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "PERSON_TYPE")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "EMPLOYMENT_ORG_NAME")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "PAYSLIP_EMAIL")));
				gridTr.addChild(new UiGridTd().addClassName("Rt").setText(asgCnt+" ("+activeAsgCnt+")"));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "MOBILE")));

				html += gridTr.toHtmlString();
			}
		} else {
			var gridTr = new UiGridTr();

			gridTr.addChild(new UiGridTd().addClassName("Ct").setAttribute("colspan:8").setText(com.message.I001));
			html += gridTr.toHtmlString();
		}

		$("#tblGridBody").append($(html));
		setGridTable(result.totalResultRows);

		$("[name=icnAction]").each(function(index) {
			$(this).contextMenu(ctxMenu.boardAction);
		});

		commonJs.bindToggleTrBackgroundWithCheckbox($("[name=chkForDel]"));
		commonJs.hideProcMessageOnElement("divScrollablePanel");
	};

	getPersonDetail = function(personId) {
		$("#personId").val(personId);
		commonJs.doSimpleProcessForPage({
			action:"/per/perBasicInfo/perBasicProfile/getPersonFrameContainer.do"
		});
	};

	exeExport = function(menuObject) {
		$("[name=fileType]").remove();
		$("[name=dataRange]").remove();

		if (searchResultDataCount <= 0) {
			commonJs.warn(com.message.I001);
			return;
		}

		commonJs.error("Not ready yet!");
		return;

		commonJs.doExport({
			url:"/per/perBasicInfo/perBasicProfile/exeExport.do",
			data:commonJs.serialiseObject($("#divSearchCriteriaArea")),
			menuObject:menuObject
		});
	};

	/*!
	 * load event (document / window)
	 */
	$(window).load(function() {
		commonJs.setExportButtonContextMenu($("#btnExport"));
		commonJs.setEvent("blur", [$("#personEquals"), $("#empOrgName")], commonJs.clearValueOnBlur);

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
			method:"getOrgByNameOrId",
			label:"org_name_with_org_id",
			value:"organisation_id",
			minLength:2,
			focus: function(event, ui) {
				$("#empOrgId").val(ui.item.value);
				$("#orgName").val(ui.item.label);
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

		if (commonJs.isSearchCriteriaSelected()) {
			doSearch();
		}
	});
});