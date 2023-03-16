/**
 * commonCodeList.js
 */
var popup = null;
var searchResultDataCount = 0;
var dateFormat = jsconfig.get("dateFormatJs");
var langCode = jsconfig.get("langCode").toUpperCase();

$(function() {
	/*!
	 * event
	 */
	$("#btnNew").click(function(event) {
		getEdit("");
	});

	$("#btnDelete").click(function(event) {
		doDelete();
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

	$(document).keypress(function(event) {
		if (event.which == 13) {
			var element = event.target;

			if ($(element).is("[name=commonCodeType]")) {
				doSearch();
			}
		}
	});

	/*!
	 * process
	 */
	doSearch = function() {
		commonJs.showProcMessageOnElement("divScrollablePanel");

		if (commonJs.doValidate($("#fmDefault"))) {
			commonJs.doSearch({
				url:"/zebra/framework/commoncode/getList.do",
				data:{},
				onSuccess:renderDataGridTable
			});
		}
	};

	renderDataGridTable = function(result) {
		var dataSet = result.dataSet;
		var html = "";

		searchResultDataCount = dataSet.getRowCnt();

		$("#tblGridBody").html("");

		if (dataSet.getRowCnt() > 0) {
			for (var i=0; i<dataSet.getRowCnt(); i++) {
				var isDefault = dataSet.getValue(i, "IS_DEFAULT");
				var className = "chkEn", disabledStr = "";
				var uiGridTr = new UiGridTr();

				if ("Y" == isDefault) {
					className = "chkDis";
					disabledStr = "disabled";
				}

				var uiIcon = new UiIcon();
				uiIcon.setName("icnAction").setUseFor("action").addAttribute("codeType:"+dataSet.getValue(i, "CODE_TYPE")).addAttribute("isDefault:"+isDefault).setScript("doAction(this)");
				uiGridTr.addChild(new UiGridTd().addClassName("Ct").addChild(uiIcon));

				var uiChk = new UiCheckbox();
				uiChk.setName("chkForDel").removeClassName("chkEn").addClassName(className).setValue(dataSet.getValue(i, "CODE_TYPE")).setOptions(disabledStr);
				uiGridTr.addChild(new UiGridTd().addClassName("Ct").addChild(uiChk));

				var uiAnc = new UiAnchor();
				uiAnc.setText(dataSet.getValue(i, "CODE_TYPE")).setScript("getEdit('"+dataSet.getValue(i, "CODE_TYPE")+"')");
				uiGridTr.addChild(new UiGridTd().addClassName("Lt").addChild(uiAnc));

				uiGridTr.addChild(new UiGridTd().addClassName("Lt").setText(dataSet.getValue(i, "CODE_MEANING")));
				uiGridTr.addChild(new UiGridTd().addClassName("Lt").setText(dataSet.getValue(i, "PROGRAM_CONSTANTS")));
				uiGridTr.addChild(new UiGridTd().addClassName("Lt").setText(dataSet.getValue(i, "DESCRIPTION_"+langCode)));

				uiGridTr.addChild(new UiGridTd().addClassName("Ct").setText(dataSet.getValue(i, "IS_ACTIVE")));
				uiGridTr.addChild(new UiGridTd().addClassName("Ct").setText(isDefault));
				uiGridTr.addChild(new UiGridTd().addClassName("Ct").setText(commonJs.getDateTimeMask(dataSet.getValue(i, "INSERT_DATE"), dateFormat)));
				uiGridTr.addChild(new UiGridTd().addClassName("Ct").setText(commonJs.getDateTimeMask(dataSet.getValue(i, "UPDATE_DATE"), dateFormat)));

				html += uiGridTr.toHtmlString();
			}
		} else {
			var uiGridTr = new UiGridTr();

			uiGridTr.addChild(new UiGridTd().addClassName("Ct").setAttribute("colspan:10").setText(com.message.I001));
			html += uiGridTr.toHtmlString();
		}

		$("#tblGridBody").append($(html));

		$("#tblGrid").freezeHeader({
			attachTo:$("#divDataArea"),
			pagingArea:$("#divPagingArea"),
			isPageable:true,
			totalResultRows:result.totalResultRows,
			script:"doSearch"
		});

		$("[name=icnAction]").each(function(index) {
			$(this).contextMenu(ctxMenu.commonSimpleAction);
		});

		commonJs.bindToggleTrBackgroundWithCheckbox($("[name=chkForDel]"));
		commonJs.hideProcMessageOnElement("divScrollablePanel");
	};

	getEdit = function(codeType) {
		popup = commonJs.openPopup({
			popupId:"commonCodeEdit",
			url:"/zebra/framework/commoncode/getEdit.do",
			data:{codeType:codeType},
			header:framework.header.popHeaderEdit,
			blind:true,
			width:1700,
			height:860
		});
	};

	doDelete = function() {
		if (commonJs.getCountChecked("chkForDel") == 0) {
			commonJs.warn(com.message.I902);
			return;
		}

		commonJs.doDelete({
			url:"/zebra/framework/commoncode/doDelete.do",
			onSuccess:doSearch
		});
	};

	doAction = function(img) {
		var codeType = $(img).attr("codeType");
		var isDefault = $(img).attr("isDefault");

		$("input:checkbox[name=chkForDel]").each(function(index) {
			if (!$(this).is(":disabled") && $(this).val() == codeType) {
				if (!$(this).is(":checked")) {
					$(this).click();
				}
			} else {
				if ($(this).is(":checked")) {
					$(this).click();
				}
			}
		});

		if (isDefault == "Y") {
			ctxMenu.commonSimpleAction[1].disable = true;
		} else {
			ctxMenu.commonSimpleAction[1].disable = false;
		}

		ctxMenu.commonSimpleAction[0].fun = function() {getEdit(codeType);};
		ctxMenu.commonSimpleAction[1].fun = function() {doDelete();};

		$(img).contextMenu(ctxMenu.commonSimpleAction, {
			classPrefix:com.constants.ctxClassPrefixGrid,
			displayAround:"trigger",
			position:"bottom",
			horAdjust:0,
			verAdjust:2,
			containment:$("#divScrollablePanel")
		});
	};

	exeExport = function(menuObject) {
		if (searchResultDataCount <= 0) {
			commonJs.warn(com.message.I001);
			return;
		}

		commonJs.doExport({
			url:"/zebra/framework/commoncode/doExport.do",
			data:commonJs.serialiseObject($("#divSearchCriteriaArea")),
			menuObject:menuObject
		});
	};

	/*!
	 * load event (document / window)
	 */
	$(window).load(function() {
		commonJs.setAutoComplete($("#commonCodeType"), {
			url:"/zebra/common/autoCompletion/",
			method:"getCommonCodeType",
			label:"code_meaning",
			value:"code_type",
			select:function(event, ui) {
				doSearch();
			}
		});

		commonJs.setExportButtonContextMenu($("#btnExport"));

		doSearch();
	});
});