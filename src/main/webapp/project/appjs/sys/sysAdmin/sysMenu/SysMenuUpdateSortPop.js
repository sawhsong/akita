/**************************************************************************************************
 * Framework Generated Javascript Source
 * - SysMenuUpdateSortPop.js
 *************************************************************************************************/
var delimiter = jsconfig.get("dataDelimiter");

$(function() {
	/*!
	 * event
	 */
	$("#menuLevel").change(function(event) {
		var value = $(this).val();

		if (value == 2) {
			$("#divLevel1").show();
			$("#divLevel2").hide();
		} else if (value == 3) {
			$("#divLevel1").show();
			$("#divLevel2").show();
		} else {
			$("#divLevel1").hide();
			$("#divLevel2").hide();
		}

		setLevel2Selectbox();
		refreshDataArea();
	});

	$("#level1").change(function(event) {
		setLevel2Selectbox();
		refreshDataArea();
	});

	$("#level2").change(function(event) {
		refreshDataArea();
	});

	$("#btnSave").click(function(event) {
		commonJs.doSave({
			url:"/sys/sysAdmin/sysMenu/doUpdateSortOrder.do",
			data:{dataLength:$("#ulMenuHolder .dummyMenu").length},
			onSuccess:function() {
				parent.popup.close();
				parent.doSearch();
			}
		});
	});

	$("#btnClose").click(function(event) {
		parent.popup.close();
	});

	$(document).keypress(function(event) {
		if (event.which == 13) {
			var element = event.target;
		}
	});

	/*!
	 * process
	 */
	setLevel2Selectbox = function() {
		var level1MenuId = $("#level1").val();

		$("#level2 option").each(function(index) {
			$(this).remove();
		});

		for (var i=0; i<dsMenu2.getRowCnt(); i++) {
			var parentMenu = dsMenu2.getValue(i, "PARENT_MENU_ID");
			if (parentMenu == level1MenuId) {
				$("#level2").append(commonJs.getUiSelectOption({
					value:dsMenu2.getValue(i, "MENU_ID"),
					text:dsMenu2.getValue(i, "MENU_ID")
				}));
			}
		}

		$("#level2").selectpicker({container:"body"}).selectpicker("refresh").selectpicker("setStyle", "btn-default", "remove");
	};

	refreshDataArea = function() {
		var menuLevel = $("#menuLevel").val();
		var level1MenuId = $("#level1").val();
		var level2MenuId = $("#level2").val();

		$("#ulMenuHolder").empty();

		for (var i=0; i<dsMenu.getRowCnt(); i++) {
			if (dsMenu.getValue(i, "MENU_ID") == "QM") {
				continue;
			}

			if (menuLevel == 1) {
				if (dsMenu.getValue(i, "LEVEL") == 1) {
					renderElement(i);
				}
			} else if (menuLevel == 2) {
				if (dsMenu.getValue(i, "LEVEL") == 2 && dsMenu.getValue(i, "PARENT_MENU_ID") == level1MenuId) {
					renderElement(i);
				}
			} else if (menuLevel == 3) {
				if (dsMenu.getValue(i, "LEVEL") == 3 && dsMenu.getValue(i, "PARENT_MENU_ID") == level2MenuId) {
					renderElement(i);
				}
			}
		}

		$("#ulMenuHolder").find(".dummyMenu").each(function(groupIndex) {
			$(this).find("input[type=text]").each(function(index) {
				var id = $(this).attr("id"), name = $(this).attr("name");

				if (!commonJs.isEmpty(id)) {id = (id.indexOf(delimiter) != -1) ? id.substring(0, id.indexOf(delimiter)) : id;}
				else {id = "";}

				if (!commonJs.isEmpty(name)) {name = (name.indexOf(delimiter) != -1) ? name.substring(0, name.indexOf(delimiter)) : name;}
				else {name = "";}

				$(this).attr("id", id+delimiter+groupIndex).attr("name", name+delimiter+groupIndex);
			});
		});
	};

	renderElement = function(dsIndex) {
		var elem = $("#liDummy").clone();

		$(elem).css("display", "block").appendTo($("#ulMenuHolder"));
		$(elem).find("input[type=text]").each(function(index) {
			if ($(this).attr("id") == "menuId") {
				$(this).val(dsMenu.getValue(dsIndex, "MENU_ID"));
			}

			if ($(this).attr("id") == "menuName") {
				$(this).val(dsMenu.getValue(dsIndex, "MENU_NAME_EN"));
			}

			if ($(this).attr("id") == "sortOrder") {
				$(this).val(dsMenu.getValue(dsIndex, "SORT_ORDER"));
			}
		});
	};

	setSortable = function() {
		$("#ulMenuHolder").sortable({
			axis:"y",
			handle:".dragHandler",
			stop:function() {
				var menuLevel = $("#menuLevel").val();
				var level1MenuId = $("#level1").val();
				var level2MenuId = $("#level2").val();

				$("#ulMenuHolder").find(".dummyMenu").each(function(groupIndex) {
					$(this).find("input[type=text]").each(function(index) {
						var id = $(this).attr("id"), name = $(this).attr("name");

						if (!commonJs.isEmpty(id)) {id = (id.indexOf(delimiter) != -1) ? id.substring(0, id.indexOf(delimiter)) : id;}
						else {id = "";}

						if (!commonJs.isEmpty(name)) {name = (name.indexOf(delimiter) != -1) ? name.substring(0, name.indexOf(delimiter)) : name;}
						else {name = "";}

						$(this).attr("id", id+delimiter+groupIndex).attr("name", name+delimiter+groupIndex);

						if (name.indexOf("sortOrder") != -1) {
							if (menuLevel == 1) {
								$(this).val(commonJs.lpad((groupIndex+1), 2, "0")+"0000");
							} else if (menuLevel == 2) {
								var level1Sort = commonJs.nvl(dsMenu.getValue(dsMenu.getRowIndex("MENU_ID", level1MenuId), "SORT_ORDER"), "000000");

								level1Sort = level1Sort.substring(0, 2);
								$(this).val(level1Sort + commonJs.lpad((groupIndex+1), 2, "0")+"00");
							} else if (menuLevel == 3) {
								var level2Sort = commonJs.nvl(dsMenu.getValue(dsMenu.getRowIndex("MENU_ID", level2MenuId), "SORT_ORDER"), "000000");

								level2Sort = level2Sort.substring(0, 4);
								$(this).val(level2Sort + commonJs.lpad((groupIndex+1), 2, "0"));
							}
						}
					});
				});
			}
		});

		$("#ulMenuHolder").disableSelection();
	};

	/*!
	 * load event (document / window)
	 */
	$(window).load(function() {
		setLevel2Selectbox();
		refreshDataArea();
		setSortable();
	});
});