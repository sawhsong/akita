/**************************************************************************************************
 * Framework Generated Javascript Source
 * - SysFreeBoardList.js
 *************************************************************************************************/
var popup = null;
var searchResultDataCount = 0;
var attchedFileContextMenu = [];

$(function() {
	/*!
	 * event
	 */
	$("#btnNew").click(function(event) {
		getInsert();
	});

	$("#btnDelete").click(function(event) {
		doDelete();
	});

	$("#btnSearch").click(function(event) {
		doSearch();
	});

	$("#btnClear").click(function(event) {
		commonJs.clearSearchCriteria();
	});

	$("#icnFromDate").click(function(event) {
		commonJs.openCalendar(event, "fromDate");
	});

	$("#icnToDate").click(function(event) {
		commonJs.openCalendar(event, "toDate");
	});

	$("#icnCheck").click(function(event) {
		commonJs.toggleCheckboxes("chkForDel");
	});

	$(document).keypress(function(event) {
		if (event.which == 13) {
			var element = event.target;

			if ($(element).is("[name=searchWord]") || $(element).is("[name=fromDate]") || $(element).is("[name=toDate]")) {
				doSearch();
			}
		}
	});

	/*!
	 * process
	 */
	doSearch = function() {
		commonJs.showProcMessageOnElement("divScrollablePanel");

		if (commonJs.doValidate($("#fmDefault"))) {
			commonJs.doSearch({
				url:"/sys/sysBbs/sysFreeBoard/getList.do",
				data:{},
				onSuccess:renderDataGridTable
			});
		}
	};

	renderDataGridTable = function(result) {
		var dataSet = result.dataSet;
		var html = "";

		searchResultDataCount = dataSet.getRowCnt();
		$("#tblGridBody").html("");

		if (dataSet.getRowCnt() > 0) {
			for (var i=0; i<dataSet.getRowCnt(); i++) {
				var space = "", iLength = 200;
				var iLevel = parseInt(dataSet.getValue(i, "LEVEL")) - 1;
				var gridTr = new UiGridTr();

				gridTr.setClassName("noBorderHor");

				var iconAction = new UiIcon();
				iconAction.setName("icnAction").setUseFor("action").addAttribute("articleId:"+dataSet.getValue(i, "ARTICLE_ID")).setScript("doAction(this)");
				gridTr.addChild(new UiGridTd().addClassName("Ct").addChild(iconAction));

				var uiChk = new UiCheckbox();
				uiChk.setName("chkForDel").setValue(dataSet.getValue(i, "ARTICLE_ID"));
				gridTr.addChild(new UiGridTd().addClassName("Ct").addChild(uiChk));

				if (iLevel > 0) {
					for (var j=0; j<iLevel; j++) {
						space += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
						iLength -= - 2;
					}
					space += "<i class=\"fa fa-comments\"></i>";
				} else {
					space += "<i class=\"fa fa-comment\"></i>";
				}

				var uiAnc = new UiAnchor();
				uiAnc.setText(commonJs.abbreviate(dataSet.getValue(i, "ARTICLE_SUBJECT"), iLength)).setScript("getDetail('"+dataSet.getValue(i, "ARTICLE_ID")+"')");
				gridTr.addChild(new UiGridTd().addClassName("Lt").addTextBeforeChild(space+"&nbsp;&nbsp;").addChild(uiAnc));

				var gridTd = new UiGridTd();
				gridTd.addClassName("Ct");
				if (dataSet.getValue(i, "FILE_CNT") > 0) {
					var iconAttachFile = new UiIcon();
					iconAttachFile.setName("icnAttachedFile").addClassName("glyphicon-paperclip").addAttribute("articleId:"+dataSet.getValue(i, "ARTICLE_ID")).setScript("getAttachedFile(this)");
					gridTd.addChild(iconAttachFile);
				}
				gridTr.addChild(gridTd);

				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(dataSet.getValue(i, "WRITER_NAME")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(dataSet.getValue(i, "CREATED_DATE")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(dataSet.getValue(i, "UPDATED_DATE")));
				gridTr.addChild(new UiGridTd().addClassName("Rt").setText(commonJs.getNumberMask(dataSet.getValue(i, "HIT_CNT"), "#,###")));

				html += gridTr.toHtmlString();
			}
		} else {
			var gridTr = new UiGridTr();

			gridTr.addChild(new UiGridTd().addClassName("Ct").setAttribute("colspan:8").setText(com.message.I001));
			html += gridTr.toHtmlString();
		}

		$("#tblGridBody").append($(html));

		$("#tblGrid").freezeHeader({
			attachTo:$("#divDataArea"),
			pagingArea:$("#divPagingArea"),
			isPageable:true,
			totalResultRows:result.totalResultRows,
			script:"doSearch"
		});

		$("[name=icnAttachedFile]").each(function(index) {
			$(this).contextMenu(attchedFileContextMenu);
		});

		$("[name=icnAction]").each(function(index) {
			$(this).contextMenu(ctxMenu.boardAction);
		});

		commonJs.bindToggleTrBackgroundWithCheckbox($("[name=chkForDel]"));
		commonJs.hideProcMessageOnElement("divScrollablePanel");
	};

	getInsert = function() {
		commonJs.doSimpleProcessForPage({
			action:"/sys/sysBbs/sysFreeBoard/getInsert.do"
		});
	};

	getDetail = function(articleId) {
		commonJs.doSimpleProcessForPage({
			action:"/sys/sysBbs/sysFreeBoard/getDetail.do",
			data:{
				articleId:articleId
			}
		});
	};

	doProcess = function(param) {
		var action = "";

		if (param.mode == "Edit") {
			action = "/sys/sysBbs/sysFreeBoard/getUpdate.do";
		} else if (param.mode == "Reply") {
			action = "/sys/sysBbs/sysFreeBoard/getInsert.do";
		}

		commonJs.doSimpleProcessForPage({
			action:action,
			data:{
				mode:param.mode,
				articleId:param.articleId
			}
		});
	};

	doDelete = function() {
		if (commonJs.getCountChecked("chkForDel") == 0) {
			commonJs.warn(com.message.I902);
			return;
		}

		commonJs.doDelete({
			url:"/sys/sysBbs/sysFreeBoard/exeDelete.do",
			onSuccess:doSearch
		});
	};

	doAction = function(img) {
		var articleId = $(img).attr("articleId");

		$("input:checkbox[name=chkForDel]").each(function(index) {
			if (!$(this).is(":disabled") && $(this).val() == articleId) {
				if (!$(this).is(":checked")) {
					$(this).click();
				}
			} else {
				if ($(this).is(":checked")) {
					$(this).click();
				}
			}
		});

		ctxMenu.boardAction[0].fun = function() {getDetail(articleId);};
		ctxMenu.boardAction[1].fun = function() {doProcess({mode:"Edit", articleId:articleId});};
		ctxMenu.boardAction[2].fun = function() {doProcess({mode:"Reply", articleId:articleId});};
		ctxMenu.boardAction[3].fun = function() {doDelete();};

		$(img).contextMenu(ctxMenu.boardAction, {
			classPrefix:com.constants.ctxClassPrefixGrid,
			displayAround:"trigger",
			position:"bottom",
			horAdjust:0,
			verAdjust:2
		});
	};

	getAttachedFile = function(img) {
		commonJs.doSimpleProcess({
			url:"/sys/sysBbs/sysFreeBoard/getAttachedFile.do",
			data:{articleId:$(img).attr("articleId")},
			callback:function(result) {
				var dataSet = result.dataSet;
				attchedFileContextMenu = [];

				for (var i=0; i<dataSet.getRowCnt(); i++) {
					var repositoryPath = dataSet.getValue(i, "REPOSITORY_PATH");
					var originalName = dataSet.getValue(i, "ORIGINAL_NAME");
					var newName = dataSet.getValue(i, "NEW_NAME");
					var fileIcon = dataSet.getValue(i, "FILE_ICON");
					var fileSize = (dataSet.getValue(i, "FILE_SIZE")/1024)+1;

					attchedFileContextMenu.push({
						name:originalName+" ("+commonJs.getNumberMask(fileSize, "0,0")+") KB",
						title:originalName,
						img:fileIcon,
						repositoryPath:repositoryPath,
						originalName:originalName,
						newName:newName,
						fun:function() {
							var index = $(this).index();

							downloadFile({
								repositoryPath:attchedFileContextMenu[index].repositoryPath,
								originalName:attchedFileContextMenu[index].originalName,
								newName:attchedFileContextMenu[index].newName
							});
						}
					});
				}

				$(img).contextMenu(attchedFileContextMenu, {
					classPrefix:com.constants.ctxClassPrefixGrid,
					displayAround:"trigger",
					position:"bottom",
					horAdjust:0,
					verAdjust:2,
					containment:$("#divScrollablePanel")
				});
			}
		});
	};

	downloadFile = function(param) {
		commonJs.doSimpleProcessForPage({
			action:"/download.do",
			data:{
				repositoryPath:param.repositoryPath,
				originalName:param.originalName,
				newName:param.newName
			}
		});
	};

	exeExport = function(menuObject) {
		$("[name=fileType]").remove();
		$("[name=dataRange]").remove();

		if (searchResultDataCount <= 0) {
			commonJs.warn(com.message.I001);
			return;
		}

		commonJs.doExport({
			url:"/sys/sysBbs/sysFreeBoard/exeExport.do",
			data:commonJs.serialiseObject($("#divSearchCriteriaArea")),
			menuObject:menuObject
		});
	};

	/*!
	 * load event (document / window)
	 */
	$(window).load(function() {
		commonJs.setFieldDateMask("fromDate");
		commonJs.setFieldDateMask("toDate");
		commonJs.setExportButtonContextMenu($("#btnExport"));
		doSearch();
	});
});