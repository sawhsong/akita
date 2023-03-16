/**
 * domainDictionaryList.js
 */
var popup = null;
var searchResultDataCount = 0;

$(function() {
	/*!
	 * event
	 */
	$("#btnNew").click(function(event) {
		openPopup({mode:"New"});
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

			if ($(element).is("[name=searchWord]")) {
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
				url:"/zebra/framework/domaindictionary/getList.do",
				callback:renderDataGridTable
			});
		}
	};

	renderDataGridTable = function(result) {
		var dataSet = result.dataSet;
		var html = "";
		var dateFormat = jsconfig.get("dateFormatJs");

		searchResultDataCount = dataSet.getRowCnt();

		$("#tblGridBody").html("");

		if (dataSet.getRowCnt() > 0) {
			for (var i=0; i<dataSet.getRowCnt(); i++) {
				var uiGridTr = new UiGridTr();

				var uiIcon = new UiIcon();
				uiIcon.setName("icnAction").setUseFor("action").addAttribute("domainId:"+dataSet.getValue(i, "DOMAIN_ID")).setScript("doAction(this)");
				uiGridTr.addChild(new UiGridTd().addClassName("Ct").addChild(uiIcon));

				var uiChk = new UiCheckbox();
				uiChk.setName("chkForDel").setValue(dataSet.getValue(i, "DOMAIN_ID"));
				uiGridTr.addChild(new UiGridTd().addClassName("Ct").addChild(uiChk));

				var uiAnc = new UiAnchor();
				uiAnc.setText(dataSet.getValue(i, "DOMAIN_NAME")).setScript("getDetail('"+dataSet.getValue(i, "DOMAIN_ID")+"')");
				uiGridTr.addChild(new UiGridTd().addClassName("Lt").addChild(uiAnc));

				uiGridTr.addChild(new UiGridTd().addClassName("Lt").setText(dataSet.getValue(i, "NAME_ABBREVIATION")));
				uiGridTr.addChild(new UiGridTd().addClassName("Ct").setText(dataSet.getValue(i, "DATA_TYPE")));
				uiGridTr.addChild(new UiGridTd().addClassName("Rt").setText(dataSet.getValue(i, "DATA_LENGTH")));
				uiGridTr.addChild(new UiGridTd().addClassName("Lt").setText(commonJs.htmlToString(dataSet.getValue(i, "DESCRIPTION"))));
				uiGridTr.addChild(new UiGridTd().addClassName("Ct").setText(commonJs.getDateTimeMask(dataSet.getValue(i, "LAST_UPDATE"), dateFormat)));

				html += uiGridTr.toHtmlString();
			}
		} else {
			var uiGridTr = new UiGridTr();

			uiGridTr.addChild(new UiGridTd().addClassName("Ct").setAttribute("colspan:8").setText(com.message.I001));
			html += uiGridTr.toHtmlString();
		}

		$("#tblGridBody").append($(html));

		$("#tblGrid").freezeHeader({
			attachTo:$("#divDataArea"),
			pagingArea:$("#divPagingArea"),
			isPageable:true,
			isFilter:false,
			filterColumn:[1, 2, 3, 4, 5, 6],
			totalResultRows:result.totalResultRows,
			script:"doSearch"
		});

		$("[name=icnAction]").each(function(index) {
			$(this).contextMenu(ctxMenu.commonAction);
		});

		commonJs.bindToggleTrBackgroundWithCheckbox($("[name=chkForDel]"));
		commonJs.hideProcMessageOnElement("divScrollablePanel");
	};

	getDetail = function(domainId) {
		openPopup({mode:"Detail", domainId:domainId});
	};

	openPopup = function(param) {
		var url = "", header = "";
		var height = 436;

		if (param.mode == "Detail") {
			url = "/zebra/framework/domaindictionary/getDetail.do";
			header = framework.header.popHeaderDetail;
		} else if (param.mode == "New") {
			url = "/zebra/framework/domaindictionary/getInsert.do";
			header = framework.header.popHeaderEdit;
		} else if (param.mode == "Edit") {
			url = "/zebra/framework/domaindictionary/getUpdate.do";
			header = framework.header.popHeaderEdit;
			height = 518;
		}

		var popParam = {
			popupId:"domainDictionary"+param.mode,
			url:url,
			data:{
				mode:param.mode,
				domainId:commonJs.nvl(param.domainId, "")
			},
			header:header,
			blind:true,
			width:780,
			height:height
		};

		popup = commonJs.openPopup(popParam);
	};

	doDelete = function() {
		if (commonJs.getCountChecked("chkForDel") == 0) {
			commonJs.warn(com.message.I902);
			return;
		}

		commonJs.doDelete({
			url:"/zebra/framework/domaindictionary/exeDelete.do",
			callback:doSearch
		});
	};

	doAction = function(img) {
		var domainId = $(img).attr("domainId");

		$("input:checkbox[name=chkForDel]").each(function(index) {
			if (!$(this).is(":disabled") && $(this).val() == domainId) {
				if (!$(this).is(":checked")) {
					$(this).click();
				}
			} else {
				if ($(this).is(":checked")) {
					$(this).click();
				}
			}
		});

		ctxMenu.commonAction[0].fun = function() {getDetail(domainId);};
		ctxMenu.commonAction[1].fun = function() {openPopup({mode:"Edit", domainId:domainId});};
		ctxMenu.commonAction[2].fun = function() {doDelete();};

		$(img).contextMenu(ctxMenu.commonAction, {
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
			url:"/zebra/framework/domaindictionary/exeExport.do",
			data:commonJs.serialiseObject($("#divSearchCriteriaArea")),
			menuObject:menuObject
		});
	};

	/*!
	 * load event (document / window)
	 */
	$(window).load(function() {
		$("[name=icnAction]").each(function(index) {
			$(this).contextMenu(ctxMenu.commonAction);
		});

		commonJs.setAutoComplete($("#searchWord"), {
			url:"/zebra/common/autoCompletion/",
			method:"getDomainDictionaryName",
			label:"domain_name",
			value:"domain_name",
			select:function(event, ui) {
				doSearch();
			}
		});

		commonJs.setExportButtonContextMenu($("#btnExport"));

		doSearch();
	});
});