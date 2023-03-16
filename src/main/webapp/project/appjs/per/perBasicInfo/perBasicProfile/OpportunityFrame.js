/**************************************************************************************************
 * Framework Generated Javascript Source
 * - OpportunityFrame.js
 *************************************************************************************************/
jsconfig.put("scrollablePanelHeightAdjust", 40);

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
				url:"/per/perBasicInfo/perBasicProfile/getOpportunityList.do",
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
				iconAction.setName("icnAction").setUseFor("action").addAttribute("opportunityId:"+ds.getValue(i, "OPPORTUNITY_ID")).addAttribute("status:"+ds.getValue(i, "STATUS")).setScript("doAction(this)");
				gridTr.addChild(new UiGridTd().addClassName("Ct").addChild(iconAction));

				gridTr.addChild(new UiGridTd().addClassName("Ct").addChild(new UiAnchor().setText(ds.getValue(i, "OPPORTUNITY_ID")).setScript("getDetail('"+ds.getValue(i, "OPPORTUNITY_ID")+"', '"+ds.getValue(i, "STATUS")+"')")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "CREATION_DATE")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "STATUS")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(commonJs.abbreviate(ds.getValue(i, "BILLING_ORG_NAME"), 56)));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(commonJs.abbreviate(ds.getValue(i, "END_USER_ORG_NAME"), 56)));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "CRM_NAME")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "CSM_NAME")));

				html += gridTr.toHtmlString();
			}
		} else {
			var gridTr = new UiGridTr();

			gridTr.addChild(new UiGridTd().addClassName("Ct").setAttribute("colspan:8").setText(com.message.I001));
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
		var opportunityId = $(img).attr("opportunityId");
		var status = $(img).attr("status");

		ctxMenu.commonSimpleAction[0].fun = function() {getDetail(opportunityId, status);};
		ctxMenu.commonSimpleAction[1].fun = function() {commonJs.alert("opportunityId : "+opportunityId+", status : "+status);};

		$(img).contextMenu(ctxMenu.commonSimpleAction, {
			classPrefix:com.constants.ctxClassPrefixGrid,
			displayAround:"trigger",
			position:"bottom",
			horAdjust:0,
			verAdjust:2
		});
	};

	getDetail = function(opportunityId, status) {
		var popupId = "", url = "";
		var width = 0, height = 0;

		if (status == "Open") {
			popupId = "Edit Opportunity";
			url = "/per/perBasicInfo/perBasicProfile/getEditOpportunity.do";
			width = 1700, height = 900;
		} else {
			popupId = "Opportunity Details";
			url = "/per/perBasicInfo/perBasicProfile/getOpportunityDetail.do";
			width = 1700, height = 900;
		}

		parent.popup = parent.commonJs.openPopup({
			popupId:popupId,
			url:url,
			data:{opportunityId:opportunityId},
			header:popupId,
			width:width,
			height:height
		});
	};

	/*!
	 * load event (document / window)
	 */
	$(window).load(function() {
		doSearch();
	});
});