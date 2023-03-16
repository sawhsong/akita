/**************************************************************************************************
 * Framework Generated Javascript Source
 * - SysDbSessionMonitorSqlTextPop.js
 *************************************************************************************************/
$(function() {
	/*!
	 * event
	 */
	$("#btnClose").click(function(event) {
		parent.popup.close();
	});

	/*!
	 * process
	 */
	getSqlText = function() {
		commonJs.showProcMessageOnElement("divScrollablePanelPopup");

		commonJs.doSearch({
			url:"/sys/sysItSupport/sysDbSessionMonitor/getSqlText.do",
			dataType:"html",
			data:{
				dataSource:dataSource,
				sqlId:sqlId
			},
			callback:renderData
		});
	};

	renderData = function(result) {
		var ds = result.dataSet;

		$("#tdLastActiveTime").html(ds.getValue(0, "LAST_ACTIVE_TIME_FORMAT"));
		$("#tdFirstLoadTime").html(ds.getValue(0, "FIRST_LOAD_TIME_FORMAT"));
		$("#tdLastLoadTime").html(ds.getValue(0, "LAST_LOAD_TIME_FORMAT"));
		$("#divSqlText").html(commonJs.stringToHtml(ds.getValue(0, "SQL_TEXT")));
		$("#divSqlFullText").html(commonJs.stringToHtml(ds.getValue(0, "SQL_FULL_TEXT")));

		commonJs.hideProcMessageOnElement("divScrollablePanelPopup");
	};

	/*!
	 * load event (document / window)
	 */
	$(window).load(function() {
		getSqlText();
	});
});