/**************************************************************************************************
 * Framework Generated Javascript Source
 * - NextActionsFrame.js
 *************************************************************************************************/
var searchResultDataCount = 0;
jsconfig.put("scrollablePanelHeightAdjust", 20);

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

	$("#actionStatus").change(function() {
		doSearch();
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
				url:"/per/perBasicInfo/perBasicProfile/getNextActionsList.do",
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
				iconAction.setName("icnAction").setUseFor("action").addAttribute("nextActionId:"+ds.getValue(i, "NEXT_ACTION_ID")).setScript("doAction(this)");
				gridTr.addChild(new UiGridTd().addClassName("Ct").addChild(iconAction));

				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "ASSIGNED_PERSON_NAME")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "ACTION_TYPE_MEANING")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "FOR_PERSON_NAME")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(commonJs.abbreviate(ds.getValue(i, "FOR_ORGANISATION_NAME"), 30)));
				gridTr.addChild(new UiGridTd().addClassName("Lt").addChild(new UiAnchor().setText(commonJs.abbreviate(ds.getValue(i, "DESCRIPTION"), 70)).setScript("getDetail('"+ds.getValue(i, "NEXT_ACTION_ID")+"')")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "ACTION_DATE")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "ACTION_TIME")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "ACTION_STATUS_MEANING")));

				html += gridTr.toHtmlString();
			}
		} else {
			var gridTr = new UiGridTr();

			gridTr.addChild(new UiGridTd().addClassName("Ct").setAttribute("colspan:9").setText(com.message.I001));
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
		var nextActionId = $(img).attr("nextActionId");

		ctxMenu.commonSimpleAction[0].fun = function() {alert("Edit : "+nextActionId);};
		ctxMenu.commonSimpleAction[1].fun = function() {alert("Delete : "+nextActionId);};

		$(img).contextMenu(ctxMenu.commonSimpleAction, {
			classPrefix:com.constants.ctxClassPrefixGrid,
			displayAround:"trigger",
			position:"bottom",
			horAdjust:0,
			verAdjust:2
		});
	};

	getDetail = function(nextActionId) {
		commonJs.alert("Edit : "+nextActionId);
	};

	/*!
	 * load event (document / window)
	 */
	$(window).load(function() {
		doSearch();
	});
});