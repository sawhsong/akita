/**************************************************************************************************
 * Framework Generated Javascript Source
 * - DocumentOutstandingFrame.js
 *************************************************************************************************/
var searchResultDataCount = 0;
var gridAction = [{
	name:"Manage Document",
	img:"fa-cogs",
	fun:function() {}
}, {
	name:"Receive Document",
	img:"fa-upload",
	fun:function() {}
}];

$(function() {
	/*!
	 * event
	 */
	$("#btnSearch").click(function(event) {
		doSearch();
	});

	showOpportunity = function(opportunityId) {
		alert(opportunityId);
	};

	showAssignment = function(assignmentId) {
		alert(assignmentId);
	};

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
				url:"/per/perBasicInfo/perBasicProfile/getDocumentOutstandingList.do",
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
				iconAction.setName("icnAction").setUseFor("action").addAttribute("documentId:"+ds.getValue(i, "DOCUMENT_ID")).setScript("doAction(this)");
				gridTr.addChild(new UiGridTd().addClassName("Ct").addChild(iconAction));

				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "DOCUMENT_NAME")).setAttribute("title:"+ds.getValue(i, "DOCUMENT_NAME")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "DOCUMENT_DESCRIPTION")).setAttribute("title:"+ds.getValue(i, "DOCUMENT_DESCRIPTION")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "DUE_DATE")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "ASSIGNED_TO_NAME")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "OPP_ASG_ID")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "TASK_FLOW")).setAttribute("title:"+ds.getValue(i, "TASK_FLOW")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "FOLLOW_UP_DATE")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "DOCUMENT_STATUS_MEANING")).setAttribute("title:"+ds.getValue(i, "DOCUMENT_STATUS_MEANING")));

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
			$(this).contextMenu(gridAction);
		});

		commonJs.hideProcMessageOnElement("divScrollablePanelFrame");
	};

	doAction = function(img) {
		var documentId = $(img).attr("documentId");

		gridAction[0].fun = function() {alert("Manage Document : "+documentId);};
		gridAction[1].fun = function() {alert("Receive Document : "+documentId);};

		$(img).contextMenu(gridAction, {
			classPrefix:com.constants.ctxClassPrefixGrid,
			displayAround:"trigger",
			position:"bottom",
			horAdjust:0,
			verAdjust:2
		});
	};

	/*!
	 * load event (document / window)
	 */
	$(window).load(function() {
		doSearch();
	});
});