/**************************************************************************************************
 * Framework Generated Javascript Source
 * - SysDbSessionMonitorList.js
 *************************************************************************************************/
var popup;

$(function() {
	/*!
	 * event
	 */
	$("#btnStartChecking").click(function() {
		doSearch();
	});

	$("#btnKillSessions").click(function() {
		killSessions();
	});

	$("#icnCheck").click(function(event) {
		commonJs.toggleCheckboxes("chkToKill");
	});

	$("#dataSource").change(function() {
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
				url:"/sys/sysItSupport/sysDbSessionMonitor/doSearch.do",
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
				var status = ds.getValue(i, "STATUS"), osUser = ds.getValue(i, "OS_USER");
				var className = "chkEn", disabledStr = "";

				if (status != "INACTIVE" || !commonJs.startsWith(commonJs.upperCase(osUser), "PERCI")) {
					className = "chkDis";
					disabledStr = "disabled";
				}

				gridTr.addChild(new UiGridTd().addClassName("Ct").addChild(new UiCheckbox().setName("chkToKill").setClassName(className+" inTblGrid").addOptions(disabledStr).setValue(ds.getValue(i, "SID")+"_"+ds.getValue(i, "SERIAL_NO"))));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "SID")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "SERIAL_NO")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").addChild(new UiAnchor().setText(ds.getValue(i, "SQL_ID")).setScript("getSqlText('"+ds.getValue(i, "SQL_ID")+"')")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "COMMAND_NAME")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "USER_NAME")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "OS_USER")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "MACHINE")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "MODULE")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "STATUS")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "LOGON_TIME_FORMAT")));

				html += gridTr.toHtmlString();
			}
		} else {
			var gridTr = new UiGridTr();

			gridTr.addChild(new UiGridTd().addClassName("Ct").setAttribute("colspan:11").setText(com.message.I001));
			html += gridTr.toHtmlString();
		}

		$("#tblGridBody").append($(html));
		setGridTable(result.totalResultRows);

		commonJs.bindToggleTrBackgroundWithCheckbox($("[name=chkToKill]"));
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

	getSqlText = function(sqlId) {
		popup = commonJs.openPopup({
			popupId:"ViewSQL",
			url:"/sys/sysItSupport/sysDbSessionMonitor/getSql.do",
			data:{
				sqlId:sqlId,
				dataSource:$("#dataSource").val()
			},
			header:"View SQL",
			width:920,
			height:616
		});
	};

	killSessions = function() {
		if (commonJs.getCountChecked("chkToKill") == 0) {
			commonJs.warn(com.message.I902);
			return;
		}

		if (commonJs.doValidate("fmDefault")) {
			commonJs.doProcess({
				url:"/sys/sysItSupport/sysDbSessionMonitor/exeKillSessions.do",
				confirmMessage:"Are you sure to proceed?",
				callback:function(result) {
					var ds = result.dataSet;

					setTimeout(function() {
						doSearch();
					}, 300);
				}
			});
		}
	};

	/*!
	 * load event (document / window)
	 */
	$(window).load(function() {
	});
});