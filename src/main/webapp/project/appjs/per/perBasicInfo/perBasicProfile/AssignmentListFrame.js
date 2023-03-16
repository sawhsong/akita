/**************************************************************************************************
 * Framework Generated Javascript Source
 * - AssignmentListFrame.js
 *************************************************************************************************/
jsconfig.put("scrollablePanelHeightAdjust", 72);
var searchResultDataCount = 0;
var gridAction = [{
	name:"Copy Assignment",
	img:"fa-clipboard",
	fun:function() {}
}, {
	name:"Delete Assignment",
	img:"fa-times",
	fun:function() {}
}, {
	name:"Edit Assignment",
	img:"fa-edit",
	fun:function() {}
}];

$(function() {
	/*!
	 * event
	 */
	$("#btnSearch").click(function(event) {
		doSearch();
	});

	/*!
	 * process
	 */
	editAssignment = function(assignmentId) {
		parent.assignmentId = assignmentId;
		parent.enableTabs("Assignments");
		parent.$("#tabCategoryAssignments li:eq(1) a").trigger("click");
	};

	doSearch = function() {
		commonJs.showProcMessageOnElement("divScrollablePanelFrame");

		commonJs.doSearch({
			url:"/per/perBasicInfo/perBasicProfile/getAssignmentDataList.do",
			dataType:"html",
			data:{personId:personId},
			callback:renderGridData
		});
	};

	renderGridData = function(result) {
		var ds = result.dataSet;
		var html = "";

		$("#tblGridBody").html("");

		if (ds.getRowCnt() > 0) {
			for (var i=0; i<ds.getRowCnt(); i++) {
				var gridTr = new UiGridTr();

				var iconAction = new UiIcon();
				iconAction.setName("icnAction").setUseFor("action").addAttribute("assignmentId:"+ds.getValue(i, "ASSIGNMENT_ID")).setScript("doAction(this)");
				gridTr.addChild(new UiGridTd().addClassName("Ct").addChild(iconAction));

				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "ASSIGNMENT_ID")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").addChild(new UiAnchor().setText(ds.getValue(i, "ASSIGNMENT_NUMBER")).setScript("editAssignment('"+ds.getValue(i, "ASSIGNMENT_ID")+"')")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(commonJs.abbreviate(ds.getValue(i, "PERSON_NAME"), 50)));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "ASG_ACTIVE")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "PREFERRED")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "ASG_START_DATE_FORMAT")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "ASG_END_DATE_FORMAT")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(commonJs.abbreviate(ds.getValue(i, "BILLING_ORGANISATION_NAME"), 70)));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(commonJs.abbreviate(ds.getValue(i, "EU_ORGANISATION_NAME"), 50)));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "HAS_PRT")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "HAS_WC")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "LAST_INVOICE_DATE")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "LAST_PAID_DATE")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "WORKING_STATE_MEANING")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "PAYMENT_METHOD_NAME")));

				html += gridTr.toHtmlString();
			}
		} else {
			var gridTr = new UiGridTr();

			gridTr.addChild(new UiGridTd().addClassName("Ct").setAttribute("colspan:16").setText(com.message.I001));
			html += gridTr.toHtmlString();
		}

		$("#tblGridBody").append($(html));

		$("#tblGrid").freezeHeader({
			attachTo:$("#divGridWrapper"),
			pagingArea:$("#divPagingArea"),
			isPageable:true,
			isFilter:false,
			filterColumn:[],
			totalResultRows:result.totalResultRows,
			script:"doSearch"
		});

		$("[name=icnAction]").each(function(index) {
			$(this).contextMenu(gridAction);
		});

		commonJs.hideProcMessageOnElement("divScrollablePanelFrame");
	};

	doAction = function(img) {
		var assignmentId = $(img).attr("assignmentId");

		gridAction[0].fun = function() {alert("Copy Assignment : "+assignmentId);};
		gridAction[1].fun = function() {alert("Delete Assignment : "+assignmentId);};
		gridAction[2].fun = function() {editAssignment(assignmentId);};

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