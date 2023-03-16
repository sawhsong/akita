/**
 * dtoGeneratorList.js
 */
var popupDetail = null;
var popupInfo = null;
var searchResultDataCount = 0;
var gridAction = [{
	name:"Table Detail",
	img:"fa-list-alt",
	fun:function() {}
}, {
	name:"Generate",
	img:"fa-gears",
	fun:function() {}
}, {
	name:"Delete",
	img:"fa-trash",
	fun:function() {}
}];

$(function() {
	/*!
	 * event
	 */
	$("#btnGenerate").click(function(event) {
		if (commonJs.getCountChecked("chkForGenerate") == 0) {
			commonJs.warn(com.message.I902);
			return;
		}

		popupInfo = commonJs.openPopup({
			popupId:"DTOGeneratorInfo",
			url:"/zebra/framework/dtogenerator/getGeneratorInfo.do",
			header:framework.header.popHeaderGenerator,
			data:{dataSource:$("#dataSource").val()},
			blind:true,
			width:1000,
			height:556
		});
	});

	$("#btnDelete").click(function(event) {
		doDelete();
	});

	$("#btnSearch").click(function(event) {
		exeSearch();
	});

	$("#dataSource").change(function(event) {
		exeSearch();
	});

	$("#btnClear").click(function(event) {
		commonJs.clearSearchCriteria();
	});

	$("#icnCheck").click(function(event) {
		commonJs.toggleCheckboxes("chkForGenerate");
	});

	$(document).keypress(function(event) {
		if (event.which == 13) {
			var element = event.target;

			if ($(element).is("[name=tableName]")) {
				exeSearch();
				event.preventDefault();
			}
		}
	});

	/*!
	 * process
	 */
	exeSearch = function() {
		commonJs.showProcMessageOnElement("divScrollablePanel");

		if (commonJs.doValidate($("#fmDefault"))) {
			commonJs.doSearch({
				url:"/zebra/framework/dtogenerator/getList.do",
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
				uiIcon.setName("icnAction").setUseFor("action").addAttribute("tableName:"+dataSet.getValue(i, "TABLE_NAME")).setScript("doAction(this)");
				uiGridTr.addChild(new UiGridTd().addClassName("Ct").addChild(uiIcon));

				var uiChk = new UiCheckbox();
				uiChk.setName("chkForGenerate").setValue(dataSet.getValue(i, "TABLE_NAME"));
				uiGridTr.addChild(new UiGridTd().addClassName("Ct").addChild(uiChk));

				var uiAnc = new UiAnchor();
				uiAnc.setText(dataSet.getValue(i, "TABLE_NAME")).setScript("getDetail('"+dataSet.getValue(i, "TABLE_NAME")+"')");
				uiGridTr.addChild(new UiGridTd().addClassName("Lt").addChild(uiAnc));

				uiGridTr.addChild(new UiGridTd().addClassName("Lt").setText(dataSet.getValue(i, "DTO_NAME")));
				uiGridTr.addChild(new UiGridTd().addClassName("Lt").setText(dataSet.getValue(i, "COMMENTS")));

				html += uiGridTr.toHtmlString();
			}
		} else {
			new UiGridTr().addChild(new UiGridTd().addClassName("Ct").setAttribute("colspan:5").setText(com.message.I001));
			html += uiGridTr.toHtmlString();
		}

		$("#tblGridBody").append($(html));

		$("#tblGrid").freezeHeader({
			attachTo:$("#divDataArea"),
			pagingArea:$("#divPagingArea"),
			isPageable:false,
			displayRowCount:true,
			totalResultRows:result.totalResultRows,
			script:"exeSearch"
		});

		$("[name=icnAction]").each(function(index) {
			$(this).contextMenu(gridAction);
		});

		commonJs.bindToggleTrBackgroundWithCheckbox($("[name=chkForGenerate]"));
		commonJs.hideProcMessageOnElement("divScrollablePanel");
	};

	getDetail = function(tableName) {
		popupDetail = commonJs.openPopup({
			popupId:"TableDetail",
			url:"/zebra/framework/dtogenerator/getDetail.do",
			data:{
				tableName:tableName,
				dataSource:$("#dataSource").val()
			},
			header:framework.header.popHeaderTableInfo,
			width:1300,
			height:800
		});
	};

	doDelete = function() {
		if (commonJs.getCountChecked("chkForGenerate") == 0) {
			commonJs.warn(com.message.I902);
			return;
		}

		popupInfo = commonJs.openPopup({
			popupId:"DTOGeneratorInfo",
			url:"/zebra/framework/dtogenerator/getGeneratorInfo.do",
			header:framework.header.popHeaderGenerator,
			data:{dataSource:$("#dataSource").val()},
			blind:true,
			width:1000,
			height:542
		});
	};

	doAction = function(img) {
		var tableName = $(img).attr("tableName");
		var dataSource = $("#dataSource").val();

		$("input:checkbox[name=chkForGenerate]").each(function(index) {
			if (!$(this).is(":disabled") && $(this).val() == tableName) {
				if (!$(this).is(":checked")) {
					if (!$(this).is(":checked")) {
						$(this).click();
					}
				}
			} else {
				if ($(this).is(":checked")) {
					$(this).click();
				}
			}
		});

		gridAction[0].fun = function() {getDetail(tableName);};
		gridAction[1].fun = function() {$("#btnGenerate").trigger("click");};
		gridAction[2].fun = function() {$("#btnDelete").trigger("click");};

		$(img).contextMenu(gridAction, {
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
		exeSearch();
	});
});