/**************************************************************************************************
 * Framework Generated Javascript Source
 * - SysCountryCurrencyList.js
 *************************************************************************************************/
var popup = null;
var searchResultDataCount = 0;
var dateFormat = jsconfig.get("dateFormatJs");

$(function() {
	/*!
	 * event
	 */
	$("#btnNew").click(function(event) {
		getEdit("");
	});

	$("#btnDelete").click(function(event) {
		if ($(this).attr("disabled")) {
			return;
		}

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

			if ($(element).is("[name=currencyCode]") || $(element).is("[name=countryName]")) {
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
				url:"/sys/sysBasicInfo/sysCountryCurrency/getList.do",
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
				var gridTr = new UiGridTr();

				var iconAction = new UiIcon();
				iconAction.setName("icnAction").setUseFor("action").addAttribute("countryCurrencyId:"+dataSet.getValue(i, "COUNTRY_CURRENCY_ID")).setScript("doAction(this)");
				gridTr.addChild(new UiGridTd().addClassName("Ct").addChild(iconAction));

				var uiChk = new UiCheckbox();
				uiChk.setName("chkForDel").setValue(dataSet.getValue(i, "COUNTRY_CURRENCY_ID"));
				gridTr.addChild(new UiGridTd().addClassName("Ct").addChild(uiChk));

				var uiAnc = new UiAnchor();
				uiAnc.setText(commonJs.abbreviate(dataSet.getValue(i, "CURRENCY_NAME"), 80)).setScript("getEdit('"+dataSet.getValue(i, "COUNTRY_CURRENCY_ID")+"')");
				gridTr.addChild(new UiGridTd().addClassName("Lt").addChild(uiAnc));

				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(dataSet.getValue(i, "CURRENCY_ALPHABETIC_CODE")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(dataSet.getValue(i, "CURRENCY_SYMBOL")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(commonJs.abbreviate(dataSet.getValue(i, "COUNTRY_NAME"), 80)));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(dataSet.getValue(i, "COUNTRY_CODE_3")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(commonJs.getDateTimeMask(dataSet.getValue(i, "INSERT_DATE"), dateFormat)));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(commonJs.getDateTimeMask(dataSet.getValue(i, "UPDATE_DATE"), dateFormat)));

				html += gridTr.toHtmlString();
			}
		} else {
			var gridTr = new UiGridTr();

			gridTr.addChild(new UiGridTd().addClassName("Ct").setAttribute("colspan:9").setText(com.message.I001));
			html += gridTr.toHtmlString();
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

	getEdit = function(countryCurrencyId) {
		popup = commonJs.openPopup({
			popupId:"commonCodeEdit",
			url:"/sys/sysBasicInfo/sysCountryCurrency/getEdit.do",
			data:{countryCurrencyId:countryCurrencyId},
			header:com.header.popHeaderDetail,
			blind:true,
			width:950,
			height:378
		});
	};

	doDelete = function() {
		if (commonJs.getCountChecked("chkForDel") == 0) {
			commonJs.warn(com.message.I902);
			return;
		}

		commonJs.doDelete({
			url:"/sys/sysBasicInfo/sysCountryCurrency/doDelete.do",
			onSuccess:doSearch
		});
	};

	doAction = function(img) {
		var countryCurrencyId = $(img).attr("countryCurrencyId");

		$("input:checkbox[name=chkForDel]").each(function(index) {
			if (!$(this).is(":disabled") && $(this).val() == countryCurrencyId) {
				if (!$(this).is(":checked")) {
					$(this).click();
				}
			} else {
				if ($(this).is(":checked")) {
					$(this).click();
				}
			}
		});

		ctxMenu.commonSimpleAction[0].fun = function() {getEdit(countryCurrencyId);};
		ctxMenu.commonSimpleAction[1].fun = function() {doDelete();};

		$(img).contextMenu(ctxMenu.commonSimpleAction, {
			classPrefix:com.constants.ctxClassPrefixGrid,
			displayAround:"trigger",
			position:"bottom",
			horAdjust:0,
			verAdjust:2
		});
	};

	exeExport = function(menuObject) {
		if (searchResultDataCount <= 0) {
			commonJs.warn(com.message.I001);
			return;
		}

		commonJs.doExport({
			url:"/sys/sysBasicInfo/sysCountryCurrency/doExport.do",
			data:commonJs.serialiseObject($("#divSearchCriteriaArea")),
			menuObject:menuObject
		});
	};

	/*!
	 * load event (document / window)
	 */
	$(window).load(function() {
		commonJs.setAutoComplete($("#currencyCode"), {
			method:"getCurrencyCode",
			label:"currency_code",
			value:"currency_code",
			focus: function(event, ui) {
				$("#currencyCode").val(ui.item.label);
				return false;
			},
			select:function(event, ui) {
				doSearch();
			}
		});

		commonJs.setAutoComplete($("#countryName"), {
			method:"getCountryName",
			label:"country_name",
			value:"country_name",
			focus: function(event, ui) {
				$("#countryName").val(ui.item.label);
				return false;
			},
			select:function(event, ui) {
				doSearch();
			}
		});

		commonJs.setExportButtonContextMenu($("#btnExport"));
		doSearch();
	});
});