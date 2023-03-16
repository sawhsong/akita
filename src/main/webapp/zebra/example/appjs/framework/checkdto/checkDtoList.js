/**
 * checkDto.js
 */
var popupDetail = null;
var popupInfo = null;
var gridAction = [{
	name:"Table Detail",
	img:"fa-list-alt",
	fun:function() {}
}, {
	name:"Compare Columns",
	img:"fa-balance-scale",
	fun:function() {}
}, {
	name:"Re-Generate",
	img:"fa-gears",
	fun:function() {}
}];

$(function() {
	/*!
	 * event
	 */
	$("#dataSourceToCheck").change(function(event) {
		$("#btnSearch").trigger("click");
	});

	$("#btnGenerate").click(function(event) {
		if (commonJs.getCountChecked("chkForGenerate") == 0) {
			commonJs.warn(com.message.I902);
			return;
		}

		popupInfo = commonJs.openPopup({
			popupId:"DTOGeneratorInfo",
			url:"/zebra/framework/dtogenerator/getGeneratorInfo.do",
			header:framework.header.popHeaderGenerator,
			data:{dataSource:$("#dataSourceToCheck").val()},
			blind:true,
			width:1000,
			height:556
		});
	});

	$("#btnSearch").click(function(event) {
		doSourceDataSearch();
	});

	$("#icnCheckSourceData").click(function(event) {
		commonJs.toggleCheckboxes("chkForGenerate");
	});

	$(document).keypress(function(event) {
		if (event.which == 13) {
			var element = event.target;
		}
	});

	/*!
	 * process
	 */
	doSourceDataSearch = function() {
		commonJs.showProcMessageOnElement("tblSourceData");

		initialiseListTable();

		commonJs.doSearch({
			url:"/zebra/framework/checkdto/getList.do",
			data:{dataSource:$("#dataSourceToCheck").val()},
			callback:renderSourceDataTable
		});
	};

	renderSourceDataTable = function(result) {
		var dataSet = result.dataSet;
		var html = "";

		$("#tblSourceDataBody").html("");

		if (dataSet.getRowCnt() > 0) {
			for (var i=0; i<dataSet.getRowCnt(); i++) {
				var uiGridTr = new UiGridTr();
				var tableName = dataSet.getValue(i, "TABLE_NAME");
				var dtoName = dataSet.getValue(i, "DTO_NAME");
				var className = dataSet.getValue(i, "CLASS_NAME");

				var uiIcon = new UiIcon();
				uiIcon.setName("icnAction").setUseFor("action").addAttribute("tableName:"+tableName).addAttribute("className:"+className).setScript("doAction(this)");
				uiGridTr.addChild(new UiGridTd().addClassName("Ct").addChild(uiIcon));

				var uiChk = new UiCheckbox();
				uiChk.setName("chkForGenerate").setValue(tableName);
				uiGridTr.addChild(new UiGridTd().addClassName("Ct").addChild(uiChk));

				uiGridTr.addChild(new UiGridTd().addClassName("Lt").addChild(new UiAnchor().setText(tableName).setScript("getTableDetail('"+tableName+"')")));
				uiGridTr.addChild(new UiGridTd().addClassName("Lt").addChild(new UiAnchor().setText(dtoName).setScript("getColumns('"+tableName+"', '"+className+"')")));

				uiGridTr.addChild(new UiGridTd().addClassName("Lt").setText(commonJs.abbreviate(dataSet.getValue(i, "COMMENTS"), 75)));
				uiGridTr.addChild(new UiGridTd().addClassName("Ct").setText(dataSet.getValue(i, "IS_DIFFERENT")));

				html += uiGridTr.toHtmlString();
			}
		} else {
			var uiGridTr = new UiGridTr();

			uiGridTr.addChild(new UiGridTd().addClassName("Ct").setAttribute("colspan:6").setText(com.message.I001));
			html += uiGridTr.toHtmlString();
		}

		$("#tblSourceDataBody").append($(html));

		$("#tblSourceData").freezeHeader({
			attachTo:$("#divSourceDataTable"),
			pagingArea:$("#divSourceDataPagingArea"),
			displayRowCount:true,
			totalResultRows:result.totalResultRows
		});

		$("[name=icnAction]").each(function(index) {
			$(this).contextMenu(gridAction);
		});

		resizeListTable("tblSourceData");

		commonJs.bindToggleTrBackgroundWithCheckbox($("[name=chkForGenerate]"));
		commonJs.hideProcMessageOnElement("tblSourceData");
	};

	getColumns = function(tableName, className) {
		commonJs.showProcMessageOnElement("tblColumns");

		commonJs.doSearch({
			url:"/zebra/framework/checkdto/getColumns.do",
			data:{
				tableName:tableName,
				className:className,
				dataSource:$("#dataSourceToCheck").val()
			},
			callback:renderColumns
		});
	};

	renderColumns = function(result) {
		var dataSet = result.dataSet;
		var html = "";

		$("#tblColumnsBody").html("");

		if (dataSet.getRowCnt() > 0) {
			for (var i=0; i<dataSet.getRowCnt(); i++) {
				var uiGridTr = new UiGridTr();

				uiGridTr.addChild(new UiGridTd().addClassName("Lt").setText(dataSet.getValue(i, "TABLE_COLUMN")));
				uiGridTr.addChild(new UiGridTd().addClassName("Lt").setText(dataSet.getValue(i, "DTO_COLUMN")));

				html += uiGridTr.toHtmlString();
			}
		} else {
			var uiGridTr = new UiGridTr();

			uiGridTr.addChild(new UiGridTd().addClassName("Ct").setAttribute("colspan:2").setText(com.message.I001));
			html += uiGridTr.toHtmlString();
		}

		$("#tblColumnsBody").append($(html));

		$("#tblColumns").freezeHeader({
			attachTo:$("#divTargetDataTable"),
			pagingArea:$("#divTargetDataPagingArea"),
			displayRowCount:true,
			totalResultRows:result.totalResultRows
		});

		resizeListTable("tblColumns");

		commonJs.hideProcMessageOnElement("tblColumns");
	};

	getTableDetail = function(tableName) {
		popupDetail = commonJs.openPopup({
			popupId:"TableDetail",
			url:"/zebra/framework/dtogenerator/getDetail.do",
			data:{
				tableName:tableName,
				dataSource:$("#dataSourceToCheck").val()
			},
			header:framework.header.popHeaderTableInfo,
			width:1300,
			height:800
		});
	};

	doAction = function(img) {
		var tableName = $(img).attr("tableName");
		var className = $(img).attr("className");
		var dataSource = $("#dataSourceToCheck").val();

		$("input:checkbox[name=chkForGenerate]").each(function(index) {
			if (!$(this).is(":disabled") && $(this).val() == tableName) {
				if (!$(this).is(":checked")) {
					$(this).click();
				}
			} else {
				if ($(this).is(":checked")) {
					$(this).click();
				}
			}
		});

		if (commonJs.isEmpty(className)) {
			gridAction[1].disable = true;
		} else {
			gridAction[1].disable = false;
		}

		gridAction[0].fun = function() {getTableDetail(tableName);};
		gridAction[1].fun = function() {getColumns(tableName, className);};
		gridAction[2].fun = function() {$("#btnGenerate").trigger("click");};

		$(img).contextMenu(gridAction, {
			classPrefix:com.constants.ctxClassPrefixGrid,
			displayAround:"trigger",
			position:"bottom",
			horAdjust:0,
			verAdjust:2,
			containment:$("#divScrollablePanel")
		});
	};

	initialiseListTable = function() {
		$("#tblColumnsBody").html("");
		$("#divTargetDataPagingArea").html("");
	}

	resizeListTable = function(tableId) {
		var attachToHeight, tableHeight;

		if (tableId == "tblSourceData") {
			attachToHeight = $("#divSourceDataTable").outerHeight();
			tableHeight = $("#tblSourceData").outerHeight();
			if (attachToHeight > tableHeight) {
				if ($("#systemGeneratedTableForFixedHeadertblSourceData").length > 0) {
					$("#systemGeneratedTableForFixedHeadertblSourceData").remove();
				}
			}
		} else if (tableId == "tblColumns") {
			attachToHeight = $("#divTargetDataTable").outerHeight();
			tableHeight = $("#tblColumns").outerHeight();
			if (attachToHeight > tableHeight) {
				if ($("#systemGeneratedTableForFixedHeadertblColumns").length > 0) {
					$("#systemGeneratedTableForFixedHeadertblColumns").remove();
				}
			}
		}
	}

	/*!
	 * load event (document / window)
	 */
	$(window).load(function() {
	});
});