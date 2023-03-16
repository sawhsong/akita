/**************************************************************************************************
 * Framework Generated Javascript Source
 * - CommunicationFrame.js
 *************************************************************************************************/
var searchResultDataCount = 0;

$(function() {
	/*!
	 * event
	 */
	$("#btnSearch").click(function(event) {
		doSearch();
	});

	$("#btnClear").click(function(event) {
		commonJs.clearSearchCriteria();
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
		commonJs.showProcMessageOnElement("divScrollablePanelFrame");

		if (commonJs.doValidate($("#fmDefault"))) {
			commonJs.doSearch({
				url:"/per/perBasicInfo/perBasicProfile/getCommunicationList.do",
				dataType:"html",
				data:{personId:personId},
				callback:renderGridData
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

				var iconAction = new UiIcon();
				iconAction.setName("icnAction").setUseFor("action").addAttribute("contactId:"+ds.getValue(i, "CONTACT_ID")).setScript("doAction(this)");
				gridTr.addChild(new UiGridTd().addClassName("Ct").addChild(iconAction));

				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "CONTACT_TYPE_MEANING")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "ACTIVITY_TYPE_MEANING")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "CONTACT_DATE_TIME")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").addChild(new UiAnchor().setText(commonJs.abbreviate(ds.getValue(i, "COMMENTS"), 90)).setScript("getDetail('"+ds.getValue(i, "CONTACT_ID")+"')")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "ENTITY_EMPLOYEE_NAME")));

				html += gridTr.toHtmlString();
			}
		} else {
			var gridTr = new UiGridTr();

			gridTr.addChild(new UiGridTd().addClassName("Ct").setAttribute("colspan:6").setText(com.message.I001));
			html += gridTr.toHtmlString();
		}

		$("#tblGridBody").append($(html));
		setGridTable(result.totalResultRows);

		$("[name=icnAction]").each(function(index) {
			$(this).contextMenu(ctxMenu.commonSimpleAction);
		});

		commonJs.hideProcMessageOnElement("divScrollablePanelFrame");
	};

	doAction = function(img) {
		var contactId = $(img).attr("contactId");

		ctxMenu.commonSimpleAction[0].fun = function() {alert("Edit : "+contactId);};
		ctxMenu.commonSimpleAction[1].fun = function() {alert("Delete : "+contactId);};

		$(img).contextMenu(ctxMenu.commonSimpleAction, {
			classPrefix:com.constants.ctxClassPrefixGrid,
			displayAround:"trigger",
			position:"bottom",
			horAdjust:0,
			verAdjust:2
		});
	};

	getDetail = function(contactId) {
		commonJs.alert("Edit : "+contactId);
	};

	exeExport = function(menuObject) {
		$("[name=fileType]").remove();
		$("[name=dataRange]").remove();

		if (searchResultDataCount <= 0) {
			commonJs.warn(com.message.I001);
			return;
		}

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
		doSearch();
	});
});