/**************************************************************************************************
 * Framework Generated Javascript Source
 * - SysMenuAuthList.js
 *************************************************************************************************/
var popup = null;
var searchResultDataCount = 0;
var langCode = commonJs.upperCase(jsconfig.get("langCode"));
var delimiter = jsconfig.get("dataDelimiter");

$(function() {
	/*!
	 * event
	 */
	$("#btnSave").click(function(event) {
		if (!commonJs.doValidate("fmDefault")) {
			return;
		}

		commonJs.doSave({
			url:"/sys/sysAdmin/sysMenuAuth/doSave.do",
			onSuccess:function() {
				doSearch();
			}
		});
	});

	$("#icnCheck").click(function(event) {
		commonJs.toggleCheckboxes("chkToAssign");
	});

	$("#authGroup").change(function() {
		$("#authGroupDesc").val($("#authGroup option:selected").attr("desc"));
		setCheckbox();
	});

	$(document).keypress(function(event) {
		if (event.which == 13) {
			var element = event.target;
		}
	});

	/*!
	 * process
	 */
	doSearch = function() {
		commonJs.showProcMessageOnElement("divScrollablePanel");

		if (commonJs.doValidate($("#fmDefault"))) {
			commonJs.doSearch({
				url:"/sys/sysAdmin/sysMenuAuth/getList.do",
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
				var gridTr = new UiGridTr();
				var menuPath = dataSet.getValue(i, "PATH");
				var menuId = dataSet.getValue(i, "MENU_ID");
				var menuName = dataSet.getValue(i, "MENU_NAME_"+langCode);
				var groupId = dataSet.getValue(i, "GROUP_ID");
				var space = "", style = "", paramValue = "";
				var iLevel = parseInt(dataSet.getValue(i, "LEVEL")) - 1;

				style = (iLevel == 0 || iLevel == 1) ? "font-weight:bold;" : "";
				for (var j=0; j<iLevel; j++) {
					space += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
				}

				paramValue = dataSet.getValue(i, "LEVEL")+delimiter+menuPath;
				gridTr.setClassName("noBorderHor");

				var uiChk = new UiCheckbox();
				uiChk.setName("chkToAssign").setValue(menuId).addAttribute("paramValue:"+paramValue).addAttribute("groupId:"+groupId);
				gridTr.addChild(new UiGridTd().addClassName("Ct").addChild(uiChk));

				gridTr.addChild(new UiGridTd().addClassName("Lt").setStyle(style).setText(space+menuId));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(menuName));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(dataSet.getValue(i, "MENU_URL")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(dataSet.getValue(i, "SORT_ORDER")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(dataSet.getValue(i, "DESCRIPTION")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(dataSet.getValue(i, "IS_ACTIVE")));

				html += gridTr.toHtmlString();
			}
		} else {
			var gridTr = new UiGridTr();

			gridTr.addChild(new UiGridTd().addClassName("Ct").setAttribute("colspan:7").setText(com.message.I001));
			html += gridTr.toHtmlString();
		}

		$("#tblGridBody").append($(html));

		$("#tblGrid").freezeHeader({
			attachTo:$("#divDataArea"),
			pagingArea:$("#divPagingArea"),
			isPageable:false,
			totalResultRows:result.totalResultRows,
			script:"doSearch"
		});

		commonJs.bindToggleTrBackgroundWithCheckbox($("[name=chkToAssign]"));
		commonJs.hideProcMessageOnElement("divScrollablePanel");
		bindCheckboxEvent($("[name=chkToAssign]"));

		setCheckbox();
	};

	setCheckbox = function() {
		var selectedAuthGroup = $("#authGroup").val(), groupId = "";

		if (commonJs.isEmpty(selectedAuthGroup)) {
			$("[name=chkToAssign]").each(function(index) {
				$(this).prop("checked", false);
				$(this).parents("tr").removeClass("checkedTr");
			});
			return;
		}

		$("[name=chkToAssign]").each(function(index) {
			var groupIds, hasAuth = false;

			groupId = $(this).attr("groupId");
			if (commonJs.isNotBlank(groupId)) {
				groupIds = groupId.split(delimiter);

				for (var id of groupIds) {
					if (id == selectedAuthGroup) {
						hasAuth = true;
						break;
					}
				}

				if (hasAuth) {
					$(this).prop("checked", true);
					$(this).parents("tr").addClass("checkedTr");
				} else {
					$(this).prop("checked", false);
					$(this).parents("tr").removeClass("checkedTr");
				}
			}
		});
	};

	hasChildChecked = function(paramLevel, paramMenuId) {
		var rtn = false;

		$("[name=chkToAssign]:checked").each(function(index) {
			var val = $(this).attr("paramValue");
			var valItems = val.split(delimiter);
			var level = valItems[0];
			var paths = valItems[1].split("/");

			if (paramLevel == "2") {
				if (level > paramLevel && paths[0] == paramMenuId || level == paramLevel && paths[0] == paramMenuId) {
					rtn = true;
				}
			}

			if (paramLevel == "3") {
				if (level == paramLevel && paths[1] == paramMenuId) {
					rtn = true;
				}
			}
		});
		return rtn;
	};

	bindCheckboxEvent = function(jqObject) {
		$(jqObject).each(function(index) {
			$(this).bind("click", function() {
				var thisChecked = $(this).prop("checked"), thisMenuId = $(this).val(), thisValue = $(this).attr("paramValue");
				var thisValueItems = thisValue.split(delimiter);
				var thisLevel = thisValueItems[0];
				var thisPaths = thisValueItems[1].split("/");

				$(jqObject).each(function(index) {
					var val = $(this).attr("paramValue");
					var valItems = val.split(delimiter);
					var level = valItems[0];
					var paths = valItems[1].split("/");

					if (thisValue != val) {
						if (thisLevel == "1") {
							if (level > thisLevel && thisMenuId == paths[0]) {
								$(this).prop("checked", thisChecked);
							}
						}

						if (thisLevel == "2") {
							if (thisChecked) {
								if ((level > thisLevel && thisMenuId == paths[1]) || (level < thisLevel && thisPaths[0] == paths[0])) {
									$(this).prop("checked", thisChecked);
								}
							} else {
								if (level > thisLevel && thisMenuId == paths[1]) {
									$(this).prop("checked", thisChecked);
								}
							}
						}

						if (thisLevel == "3") {
							if (thisChecked) {
								if ((level == "1" && thisPaths[0] == paths[0]) || (level == "2" && thisPaths[1] == paths[1])) {
									$(this).prop("checked", thisChecked);
								}
							}
						}
					}
				});

				if (!thisChecked && thisLevel == "2") {
					if (!hasChildChecked(thisLevel, thisPaths[0])) {
						$(jqObject).each(function(index) {
							var val = $(this).attr("paramValue");
							var valItems = val.split(delimiter);
							var level = valItems[0];
							var paths = valItems[1].split("/");

							if (paths[0] == thisPaths[0]) {
								$(this).prop("checked", false);
								return false;
							}
						});
					}
				}

				if (!thisChecked && thisLevel == "3") {
					if (!hasChildChecked(thisLevel, thisPaths[1])) {
						$(jqObject).each(function(index) {
							var val = $(this).attr("paramValue");
							var valItems = val.split(delimiter);
							var level = valItems[0];
							var paths = valItems[1].split("/");

							if (paths[1] == thisPaths[1]) {
								$(this).prop("checked", false);
								return false;
							}
						});
					}

					if (!hasChildChecked(2, thisPaths[0])) {
						$(jqObject).each(function(index) {
							var val = $(this).attr("paramValue");
							var valItems = val.split(delimiter);
							var level = valItems[0];
							var paths = valItems[1].split("/");

							if (paths[0] == thisPaths[0]) {
								$(this).prop("checked", false);
								return false;
							}
						});
					}
				}

				$(jqObject).each(function(index) {
					if ($(this).is(":checked")) {
						$(this).parents("tr").addClass("checkedTr");
					} else {
						$(this).parents("tr").removeClass("checkedTr");
					}
				});
			});
		});
	};

	/*!
	 * load event (document / window)
	 */
	$(window).load(function() {
		doSearch();
	});
});