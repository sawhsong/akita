/**************************************************************************************************
 * Framework Generated Javascript Source
 * - SysSiteRunningTestList.js
 *************************************************************************************************/
$(function() {
	/*!
	 * event
	 */
	$("#btnStartChecking").click(function() {
		doSearch();
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
				url:"/sys/sysItSupport/sysSiteRunningTest/doSearch.do",
				dataType:"html",
				data:{},
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
				var responseCode = ds.getValue(i, "ResponseCode");

				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "Name")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").addChild(new UiAnchor().setText(ds.getValue(i, "Url")).setScript("openUrl('"+ds.getValue(i, "Url")+"')")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "Description")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(responseCode));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "Status")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "Time")));

				if (!commonJs.startsWith(responseCode, "2")) {
					gridTr.setStyle("background:#f8d7da");
				}

				html += gridTr.toHtmlString();
			}
		} else {
			var gridTr = new UiGridTr();

			gridTr.addChild(new UiGridTd().addClassName("Ct").setAttribute("colspan:6").setText(com.message.I001));
			html += gridTr.toHtmlString();
		}

		$("#tblGridBody").append($(html));
		setGridTable(result.totalResultRows);

		commonJs.hideProcMessageOnElement("divScrollablePanel");
	};

	setGridTable = function(totalResultRows) {
		$("#tblGrid").freezeHeader({
			attachTo:$("#divDataArea"),
			pagingArea:$("#divPagingArea"),
			isPageable:false,
			displayRowCount:true,
			totalResultRows:totalResultRows,
			script:"doSearch"
		});
	};

	openUrl = function(url) {
		window.open(url, "_blank");
	};

	/*!
	 * load event (document / window)
	 */
	$(window).load(function() {
//		doSearch();
	});
});