/**
 * dataMigration.js
 */
var popup = null;

$(function() {
	/*!
	 * event
	 */
	$("#sourceDb").change(function(event) {
		$("#btnSearch").trigger("click");
	});

	$("#btnSearch").click(function(event) {
		doSourceDataSearch();
		doTargetDataSearch();
	});

	$("#icnCheckSourceData").click(function(event) {
		commonJs.toggleCheckboxes("chkSourceData");
	});

	$(document).keypress(function(event) {
		if (event.which == 13) {
			var element = event.target;
		}
	});

	/*!
	 * process
	 */
	setActionButtonContextMenu = function() {
		var ctxMenu = [{
			name:"Generate DDL File",
			img:"fa-file-text",
			fun:function() {doMigrationAction("generateFile");}
		}, {
			name:"Create Table",
			img:"fa-database",
			fun:function() {doMigrationAction("createTable");}
		}, {
			name:"Insert Data",
			img:"fa-upload",
			fun:function() {doMigrationAction("insertData");}
		}];

		$("#btnAction").contextMenu(ctxMenu, {
			classPrefix:com.constants.ctxClassPrefixButton,
			effectDuration:100,
			effect:"fade",
			borderRadius:"bottom 4px",
			displayAround:"trigger",
			position:"bottom"
		});
	};

	doSourceDataSearch = function() {
		commonJs.showProcMessageOnElement("tblSourceData");

		commonJs.doSearch({
			url:"/zebra/framework/datamigration/getTableList.do",
			data:{dataSource:$("#sourceDb").val()},
			callback:renderSourceDataTable
		});
	};

	renderSourceDataTable = function(result) {
		var dataSet = result.dataSet;
		var html = "";

		$("#tblSourceDataBody").html("");

		if (dataSet.getRowCnt() > 0) {
			for (var i=0; i<dataSet.getRowCnt(); i++) {
				var uiGridTr = new UiGridTr();

				var uiChk = new UiCheckbox();
				uiChk.setName("chkSourceData").setValue(dataSet.getValue(i, "TABLE_NAME"));
				uiGridTr.addChild(new UiGridTd().addClassName("Ct").addChild(uiChk));

				var uiAnc = new UiAnchor();
				uiAnc.setText(dataSet.getValue(i, "TABLE_NAME")).setScript("getDetail('"+$("#sourceDb").val()+"', '"+dataSet.getValue(i, "TABLE_NAME")+"')");
				uiGridTr.addChild(new UiGridTd().addClassName("Lt").addChild(uiAnc));

				uiGridTr.addChild(new UiGridTd().addClassName("Lt").setText(commonJs.abbreviate(dataSet.getValue(i, "COMMENTS"), 75)));

				html += uiGridTr.toHtmlString();
			}
		} else {
			var uiGridTr = new UiGridTr();

			uiGridTr.addChild(new UiGridTd().addClassName("Ct").setAttribute("colspan:3").setText(com.message.I001));
			html += uiGridTr.toHtmlString();
		}

		$("#tblSourceDataBody").append($(html));

		$("#tblSourceData").freezeHeader({
			attachTo:$("#divSourceDataTable"),
			pagingArea:$("#divSourceDataPagingArea"),
			displayRowCount:true,
			totalResultRows:result.totalResultRows
		});

		resizeListTable("tblSourceData");

		commonJs.bindToggleTrBackgroundWithCheckbox($("[name=chkSourceData]"));
		commonJs.hideProcMessageOnElement("tblSourceData");
	};

	doTargetDataSearch = function() {
		commonJs.showProcMessageOnElement("tblTargetData");

		commonJs.doSearch({
			url:"/zebra/framework/datamigration/getTableList.do",
			data:{dataSource:$("#targetDb").val()},
			callback:renderTargetDataTable
		});
	};

	renderTargetDataTable = function(result) {
		var dataSet = result.dataSet;
		var html = "";

		$("#tblTargetDataBody").html("");

		if (dataSet.getRowCnt() > 0) {
			for (var i=0; i<dataSet.getRowCnt(); i++) {
				var uiGridTr = new UiGridTr();

				var uiAnc = new UiAnchor();
				uiAnc.setText(dataSet.getValue(i, "TABLE_NAME")).setScript("getDetail('"+$("#targetDb").val()+"', '"+dataSet.getValue(i, "TABLE_NAME")+"')");
				uiGridTr.addChild(new UiGridTd().addClassName("Lt").addChild(uiAnc));

				uiGridTr.addChild(new UiGridTd().addClassName("Lt").setText(commonJs.abbreviate(dataSet.getValue(i, "COMMENTS"), 75)));

				html += uiGridTr.toHtmlString();
			}
		} else {
			var uiGridTr = new UiGridTr();

			uiGridTr.addChild(new UiGridTd().addClassName("Ct").setAttribute("colspan:2").setText(com.message.I001));
			html += uiGridTr.toHtmlString();
		}

		$("#tblTargetDataBody").append($(html));

		$("#tblTargetData").freezeHeader({
			attachTo:$("#divTargetDataTable"),
			pagingArea:$("#divTargetDataPagingArea"),
			displayRowCount:true,
			totalResultRows:result.totalResultRows
		});

		resizeListTable("tblTargetData");

		commonJs.hideProcMessageOnElement("tblTargetData");
	};

	getDetail = function(dataSource, tableName) {
		popup = commonJs.openPopup({
			popupId:"TableDetail",
			url:"/zebra/framework/datamigration/getDetail.do",
			data:{
				tableName:tableName,
				dataSource:dataSource
			},
			header:framework.header.popHeaderDetail,
			width:1300,
			height:800
		});
	};

	doMigrationAction = function(migrationType) {
		if (commonJs.getCountChecked("chkSourceData") == 0) {
			commonJs.warn(com.message.I902);
			return;
		}

		commonJs.confirm({
			contents:com.message.Q902,
			width:300,
			height:150,
			buttons:[{
				caption:com.caption.yes,
				callback:function() {
					doMigration(migrationType);
				}
			}, {
				caption:com.caption.no,
				callback:function() {
				}
			}]
		});
	};

	doMigration = function(migrationType) {
		var param = {};
		var actionCommand = "";

		param.sourceDb = $("#sourceDb").val();
		param.targetDb = $("#targetDb").val();

		if (migrationType == "generateFile") {
			actionCommand = "doGenerateFile";
		} else if (migrationType == "createTable") {
			actionCommand = "doCreateTable";
		} else if (migrationType == "insertData") {
			actionCommand = "doInsertData";
		}

		popup = commonJs.openPopup({
			popupId:"ProcessInformation",
			header:framework.header.popHeaderResult,
			width:500,
			height:300,
			blind:false,
			onLoad:function() {
				$("input[name=chkSourceData]:checked").each(function(index) {
					var $this = $(this);

					setTimeout(function() {
						param.tableName = $this.val();

						commonJs.doSimpleProcess({
							url:"/zebra/framework/datamigration/"+actionCommand+".do",
							data:param,
							noForm:true,
							blind:false,
							onSuccess:function(result) {
								popup.addContents(com.message.I802+" : "+param.tableName);

								if ((index+1) == commonJs.getCountChecked("chkSourceData")) {
									commonJs.openDialog({
										type:com.message.I000,
										contents:com.message.I801,
										modal:true,
										width:300,
										buttons:[{
											caption:com.caption.ok, callback:function() {
												try {
													popup.close();
													doTargetDataSearch();
												} catch(ex) {
												}
											}
										}]
									});
								}
							},
							onError:function(result) {
								popup.addContents(com.message.E801+" : "+param.tableName);
							}
						});
					}, index * 100);
				});
			}
		});
	};

	resizeListTable = function(tableId) {
		var attachToHeight, tableHeight;

		if (tableId == "tblSourceData") {
			attachToHeight = $("#divSourceDataTable").outerHeight();
			tableHeight = $("#tblSourceData").outerHeight();
			if (attachToHeight > tableHeight) {
				if ($("#systemGeneratedTableForFixedHeadertblSourceData").length > 0) {
					$("#systemGeneratedTableForFixedHeadertblSourceData").remove();
				}
			}
		} else if (tableId == "tblTargetData") {
			attachToHeight = $("#divTargetDataTable").outerHeight();
			tableHeight = $("#tblTargetData").outerHeight();
			if (attachToHeight > tableHeight) {
				if ($("#systemGeneratedTableForFixedHeadertblTargetData").length > 0) {
					$("#systemGeneratedTableForFixedHeadertblTargetData").remove();
				}
			}
		}
	}
	/*!
	 * load event (document / window)
	 */
	$(window).load(function() {
		setActionButtonContextMenu();
		doSourceDataSearch();
		doTargetDataSearch();
	});
});