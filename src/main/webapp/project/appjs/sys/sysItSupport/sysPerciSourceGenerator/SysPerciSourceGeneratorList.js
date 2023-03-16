/**************************************************************************************************
 * Framework Generated Javascript Source
 * - SysPerciSourceGeneratorList.js
 *************************************************************************************************/
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
			popupId:"GeneratorInfo",
			url:"/sys/sysItSupport/sysPerciSourceGenerator/getGeneratorInfo.do",
			header:"Source Code Generator",
			data:{dataSource:$("#dataSource").val()},
			blind:true,
			width:1000,
			height:508
		});
	});

	$("#btnSearch").click(function(event) {
		doSearch();
	});

	$("#dataSource").change(function(event) {
		doSearch();
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
				doSearch();
				event.preventDefault();
			}
		}
	});

	/*!
	 * process
	 */
	doSearch = function() {
		commonJs.showProcMessageOnElement("divScrollablePanel");

		commonJs.doSearch({
			url:"/sys/sysItSupport/sysPerciSourceGenerator/getList.do",
			dataType:"json",
			callback:renderDataGridTable
		});
	};

	renderDataGridTable = function(result) {
		var ds = result.dataSet;
		var html = "";

		searchResultDataCount = ds.getRowCnt();

		$("#tblGridBody").html("");

		if (ds.getRowCnt() > 0) {
			for (var i=0; i<ds.getRowCnt(); i++) {
				var gridTr = new UiGridTr();

				gridTr.addChild(new UiGridTd().addClassName("Ct").addChild(new UiIcon().setName("icnAction").setUseFor("action").addAttribute("tableName:"+ds.getValue(i, "TABLE_NAME")).setScript("doAction(this)")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").addChild(new UiCheckbox().setName("chkForGenerate").setValue(ds.getValue(i, "TABLE_NAME"))));
				gridTr.addChild(new UiGridTd().addClassName("Lt").addChild(new UiAnchor().setText(ds.getValue(i, "TABLE_NAME")).setScript("getDetail('"+ds.getValue(i, "TABLE_NAME")+"')")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "COMMENTS")));

				html += gridTr.toHtmlString();
			}
		} else {
			var gridTr = new UiGridTr();

			gridTr.addChild(new UiGridTd().addClassName("Ct").setAttribute("colspan:4").setText(com.message.I001));
			html += gridTr.toHtmlString();
		}

		$("#tblGridBody").append($(html));

		$("#tblGrid").freezeHeader({
			attachTo:$("#divDataArea"),
			pagingArea:$("#divPagingArea"),
			isPageable:false,
			displayRowCount:true,
			totalResultRows:result.totalResultRows,
			script:"doSearch"
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
			url:"/sys/sysItSupport/sysPerciSourceGenerator/getDetail.do",
			data:{
				tableName:tableName,
				dataSource:$("#dataSource").val()
			},
			header:"Table Details",
			width:1500,
			height:900
		});
	};

	doAction = function(img) {
		var tableName = $(img).attr("tableName");
		var dataSource = $("#dataSource").val();

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

		gridAction[0].fun = function() {getDetail(tableName);};
		gridAction[1].fun = function() {$("#btnGenerate").trigger("click");};

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
	});
});