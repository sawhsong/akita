/**************************************************************************************************
 * Framework Generated Javascript Source
 * - List.js
 *************************************************************************************************/
var popup = null;
var searchResultDataCount = 0;
var attchedFileContextMenu = [];

$(function() {
	/*!
	 * event
	 */
	$("#btnNew").click(function(event) {
	});

	$("#btnDelete").click(function(event) {
	});

	$("#btnSearch").click(function(event) {
		doSearch();
	});

	$("#btnClear").click(function(event) {
		commonJs.clearSearchCriteria();
	});

	$("#icnCheck").click(function(event) {
		commonJs.toggleCheckboxes("chkForDel");
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

	doSearch = function() {
		commonJs.showProcMessageOnElement("divScrollablePanel");

		if (commonJs.doValidate($("#fmDefault"))) {
			commonJs.doSearch({
				url:"/org/orgBasicInfo/orgBasicProfile/getList.do",
				dataType:"html",
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

				gridTr.addChild(new UiGridTd().addClassName("Ct").addChild(new UiCheckbox().setName("chkForDel").setValue(ds.getValue(i, "ORGANISATION_ID"))));
				gridTr.addChild(new UiGridTd().addClassName("Ct").addChild(new UiAnchor().setText(ds.getValue(i, "ORGANISATION_ID")).setScript("getDetail('"+ds.getValue(i, "ORGANISATION_ID")+"')")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").addChild(new UiAnchor().setText(ds.getValue(i, "ORGANISATION_NAME")).setScript("getDetail('"+ds.getValue(i, "ORGANISATION_ID")+"')")));
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

			gridTr.addChild(new UiGridTd().addClassName("Ct").setAttribute("colspan:19").setText(com.message.I001));
			html += gridTr.toHtmlString();
		}

		$("#tblGridBody").append($(html));
		setGridTable(result.totalResultRows);

		commonJs.bindToggleTrBackgroundWithCheckbox($("[name=chkForDel]"));
		commonJs.hideProcMessageOnElement("divScrollablePanel");
	};

	getDetail = function(organisationId) {
		commonJs.doSimpleProcessForPage({
			action:"/org/orgBasicInfo/orgBasicProfile/getOrganisationDetailFrameContainer.do",
			data:{organisationId:organisationId}
		});
	};


	doDelete = function() {
		if (commonJs.getCountChecked("chkForDel") == 0) {
			commonJs.warn(com.message.I902);
			return;
		}

		commonJs.doDelete({
			url:"/org/orgBasicInfo/orgBasicProfile/exeDelete.do",
			callback:doSearch
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
			url:"/org/orgBasicInfo/orgBasicProfile/exeExport.do",
			data:commonJs.serialiseObject($("#divSearchCriteriaArea")),
			menuObject:menuObject
		});
	};

	/*!
	 * load event (document / window)
	 */
	$(window).load(function() {
		commonJs.setExportButtonContextMenu($("#btnExport"));

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

		if (commonJs.isSearchCriteriaSelected()) {
			doSearch();
		}
	});
});