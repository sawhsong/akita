/**
 * tableScriptList.js
 */
var popup = null;
var searchResultDataCount = 0;
var dateFormat = jsconfig.get("dateFormatJs");

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

	$("#system").change(function(event) {
		doSearch();
	});

	$(document).keypress(function(event) {
		if (event.which == 13) {
			var element = event.target;

			if ($(element).is("[name=tableName]")) {
				doSearch();
				event.preventDefault();
			}
		}
	});

	/*!
	 * context menus
	 */

	/*!
	 * process
	 */
	doSearch = function() {
		commonJs.showProcMessageOnElement("divScrollablePanel");

		if (commonJs.doValidate($("#fmDefault"))) {
			commonJs.doSearch({
				url:"/zebra/framework/tablescript/getList.do",
				data:{},
				callback:renderDataGridTable
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
				var uiGridTr = new UiGridTr();

				var uiIcon = new UiIcon();
				uiIcon.setName("icnAction").setUseFor("action").addAttribute("fileName:"+dataSet.getValue(i, "FILE_NAME")).setScript("doAction(this)");
				uiGridTr.addChild(new UiGridTd().addClassName("Ct").addChild(uiIcon));

				var uiChk = new UiCheckbox();
				uiChk.setName("chkForDel").removeClassName("chkEn").setValue(dataSet.getValue(i, "FILE_NAME"));
				uiGridTr.addChild(new UiGridTd().addClassName("Ct").addChild(uiChk));

				var uiAnc = new UiAnchor();
				uiAnc.setText(dataSet.getValue(i, "TABLE_NAME")).setScript("getDetail('"+dataSet.getValue(i, "FILE_NAME")+"')");
				uiGridTr.addChild(new UiGridTd().addClassName("Lt").addChild(uiAnc));

				uiGridTr.addChild(new UiGridTd().addClassName("Lt").setText(commonJs.abbreviate(dataSet.getValue(i, "DESCRIPTION"), 90)));
				uiGridTr.addChild(new UiGridTd().addClassName("Lt").setText(dataSet.getValue(i, "FILE_NAME")));
				uiGridTr.addChild(new UiGridTd().addClassName("Rt").setText(dataSet.getValue(i, "FILE_SIZE")+" KB"));
				uiGridTr.addChild(new UiGridTd().addClassName("Ct").setText(dataSet.getValue(i, "UPDATE_DATE_TIME")));

				html += uiGridTr.toHtmlString();
			}
		} else {
			var uiGridTr = new UiGridTr();

			uiGridTr.addChild(new UiGridTd().addClassName("Ct").setAttribute("colspan:7").setText(com.message.I001));
			html += uiGridTr.toHtmlString();
		}

		$("#tblGridBody").append($(html));

		$("#tblGrid").freezeHeader({
			attachTo:$("#divDataArea"),
			pagingArea:$("#divPagingArea"),
			isPageable:false,
			totalResultRows:result.totalResultRows,
			script:"doSearch"
		});

		$("[name=icnAction]").each(function(index) {
			$(this).contextMenu(ctxMenu.commonAction);
		});

		commonJs.bindToggleTrBackgroundWithCheckbox($("[name=chkForDel]"));
		commonJs.hideProcMessageOnElement("divScrollablePanel");
	};

	getDetail = function(fileName) {
		openPopup({mode:"Detail", fileName:fileName});
	};

	openPopup = function(param) {
		var url = "", header = "";
		var height = 900;

		if (param.mode == "Detail") {
			url = "/zebra/framework/tablescript/getDetail.do";
			header = framework.header.popHeaderDetail;
		} else if (param.mode == "New") {
			url = "/zebra/framework/tablescript/getInsert.do";
			header = framework.header.popHeaderEdit;
		} else if (param.mode == "Edit") {
			url = "/zebra/framework/tablescript/getUpdate.do";
			header = framework.header.popHeaderEdit;
		}

		var popParam = {
			popupId:"tableScript"+param.mode,
			url:url,
			data:{
				mode:param.mode,
				fileName:commonJs.nvl(param.fileName, "")
			},
			header:header,
			blind:true,
			width:1700,
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
			url:"/zebra/framework/tablescript/exeDelete.do",
			callback:doSearch
		});
	};

	doAction = function(img) {
		var fileName = $(img).attr("fileName");

		$("input:checkbox[name=chkForDel]").each(function(index) {
			if (!$(this).is(":disabled") && $(this).val() == fileName) {
				if (!$(this).is(":checked")) {
					$(this).click();
				}
			} else {
				if ($(this).is(":checked")) {
					$(this).click();
				}
			}
		});

		ctxMenu.commonAction[0].fun = function() {getDetail(fileName);};
		ctxMenu.commonAction[1].fun = function() {openPopup({mode:"Edit", fileName:fileName});};
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

	/*!
	 * load event (document / window)
	 */
	$(window).load(function() {
		doSearch();
	});
});