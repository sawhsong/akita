/**************************************************************************************************
 * Framework Generated Javascript Source
 * - SysMenuEditPop.js
 *************************************************************************************************/
jsconfig.put("scrollablePanelHeightAdjust", 24);

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
		setFieldValue();
	});

	$("#level1").change(function(event) {
		setLevel2Selectbox();
		setFieldValue();
	});

	$("#level2").change(function(event) {
		setFieldValue();
	});

	$("#menuId").blur(function(event) {
		if (commonJs.isNotBlank($(this).val())) {
			var menuLevel = $("#menuLevel").val();
			var level1MenuId = $("#level1").val();
			var level2MenuId = $("#level2").val();

			if (menuLevel == 1) {
			} else if (menuLevel == 2) {
				$("#menuUrl").val("/"+level1MenuId.toLowerCase()+"/"+$(this).val());
			} else if (menuLevel == 3) {
				if (!commonJs.isEmpty(level2MenuId)) {
					$("#menuUrl").val("/"+level1MenuId.toLowerCase()+"/"+level2MenuId+"/"+$(this).val()+"/"+"getDefault.do");
				}
			}
		}
	});

	$("#btnSave").click(function(event) {
		if (!commonJs.doValidate("fmDefault")) {return;}
		if (!doValidate()) {return;}

		commonJs.enableObject($("#menuId"));

		commonJs.doSave({
			url:"/sys/sysAdmin/sysMenu/doSave.do",
			data:{selectedMenuId:menuId},
			onSuccess:function() {
				parent.popup.close();
				parent.doSearch();
			}
		});
	});

	$("#btnDelete").click(function(event) {
		if ($(this).attr("disabled")) {
			return;
		}

		doDelete();
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
		commonJs.setSelectpickerValue("level2", menuPath.split("-")[1]);
	};

	setFieldValue = function() {
		var menuLevel = $("#menuLevel").val();
		var level1MenuId = $("#level1").val();
		var level2MenuId = $("#level2").val();
		var sortOrder = getSortOrder(menuLevel);

		$("#menuId").val("");
		$("#menuUrl").val("");
		$("#sortOrder").val("");

		if (menuLevel == 1) {
			$("#menuId").css({"text-transform":"uppercase"});
			$("#menuUrl").val("#");
			$("#sortOrder").val(sortOrder);
		} else if (menuLevel == 2) {
			$("#menuId").removeAttr("style");
			$("#menuUrl").val("/"+level1MenuId.toLowerCase()+"/");
			$("#sortOrder").val(sortOrder);
		} else if (menuLevel == 3) {
			if (!commonJs.isEmpty(level2MenuId)) {
				$("#menuUrl").val("/"+level1MenuId.toLowerCase()+"/"+level2MenuId+"/");
			}
			$("#menuId").removeAttr("style");
			$("#sortOrder").val(sortOrder);
		}
	};

	getSortOrder = function() {
		var menuLevel = $("#menuLevel").val();
		var level1MenuId = $("#level1").val();
		var level2MenuId = $("#level2").val();
		var sortOrder = 0;

		for (var i=0; i<dsMenu.getRowCnt(); i++) {
			if (menuLevel == 1) {
				if (menuLevel == dsMenu.getValue(i, "LEVEL")) {
					sortOrder = dsMenu.getValue(i, "SORT_ORDER");
				}
			} else if (menuLevel == 2) {
				if (menuLevel == dsMenu.getValue(i, "LEVEL") && level1MenuId == dsMenu.getValue(i, "ROOT")) {
					sortOrder = dsMenu.getValue(i, "SORT_ORDER");
				}
			} else if (menuLevel == 3) {
				if (menuLevel == dsMenu.getValue(i, "LEVEL") && level2MenuId == dsMenu.getValue(i, "PARENT_MENU_ID")) {
					sortOrder = dsMenu.getValue(i, "SORT_ORDER");
				}
			}
		}

		if (sortOrder == 0) {
			for (var i=0; i<dsMenu.getRowCnt(); i++) {
				if (menuLevel == 1) {
				} else if (menuLevel == 2) {
					if (dsMenu.getValue(i, "LEVEL") == "1" && level1MenuId == dsMenu.getValue(i, "MENU_ID")) {
						sortOrder = dsMenu.getValue(i, "SORT_ORDER");
					}
				} else if (menuLevel == 3) {
					if (dsMenu.getValue(i, "LEVEL") == "2" && level2MenuId == dsMenu.getValue(i, "MENU_ID")) {
						sortOrder = dsMenu.getValue(i, "SORT_ORDER");
					}
				}
			}
		}

		return sortOrder;
	};

	doValidate = function() {
		var menuLevel = $("#menuLevel").val();
		var menuUrl = $("#menuUrl").val();
		var sortOrder = $("#sortOrder").val();

		if (menuLevel == 1 && menuUrl != "#") {
			return commonJs.doValidatorMessage($("#menuUrl"), "notValid");
		}

		if (sortOrder.length != 6) {
			return commonJs.doValidatorMessage($("#sortOrder"), "notValid");
		}

		return true;
	};

	doDelete = function() {
		commonJs.doDelete({
			url:"/sys/sysAdmin/sysMenu/doDelete.do",
			data:{menuId:menuId},
			onSuccess:function() {
				parent.popup.close();
				parent.doSearch();
			}
		});
	};

	setButton = function() {
		if (commonJs.isBlank(menuId) || !commonJs.toBoolean(deletable)) {
			commonJs.disableObject($("#btnDelete"));
		}
	};

	setDetailData = function() {
		if (commonJs.isNotBlank(menuId)) {
			commonJs.setSelectpickerValue("menuLevel", menuLevel);

			if (!commonJs.startsWith(menuPath, "QM")) {
				if (menuLevel == "1") {
				} else {
					commonJs.setSelectpickerValue("level1", menuPath.split("-")[0]);
				}

				$("#menuLevel").trigger("change");
			}

			commonJs.disableObject($("#menuLevel"));
			commonJs.disableObject($("#level1"));
			commonJs.disableObject($("#level2"));
			commonJs.disableObject($("#menuId"));

			commonJs.doSimpleProcess({
				url:"/sys/sysAdmin/sysMenu/getDetailData.do",
				data:{menuId:menuId},
				onSuccess:function(result) {
					var ds = result.dataSet;

					$("[name=menuId]").val(ds.getValue(0, "MENU_ID"));
					$("[name=menuUrl]").val(ds.getValue(0, "MENU_URL"));
					$("[name=menuName]").val(ds.getValue(0, "MENU_NAME_EN"));
					$("[name=description]").val(ds.getValue(0, "DESCRIPTION"));
					$("[name=sortOrder]").val(ds.getValue(0, "SORT_ORDER"));
					commonJs.setRadioValue("isActive", ds.getValue(0, "IS_ACTIVE"));
				}
			});
		}

		setTimeout(() => commonJs.hideProcMessageOnElement("divScrollablePanelPopup"), 400);
	};

	/*!
	 * load event (document / window)
	 */
	$(window).load(function() {
		commonJs.showProcMessageOnElement("divScrollablePanelPopup");

		setLevel2Selectbox();
		setFieldValue();
		parent.popup.setHeader("New / Edit by Name");

		setTimeout(function() {
			setButton();
			setDetailData();
		}, 100);
	});
});