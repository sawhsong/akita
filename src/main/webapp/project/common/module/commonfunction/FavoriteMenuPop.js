/**
 * FavoriteMenuPop.js
 */
$(function() {
	/*!
	 * event
	 */
	$("#btnDelete").click(function(event) {
		doDelete();
	});

	$("#btnClose").click(function(event) {
		parent.popupFavoriteMenu.close();
	});

	$("#icnCheck").click(function(event) {
		commonJs.toggleCheckboxes("chkForDel");
	});

	/*!
	 * process
	 */
	doSearch = function() {
		commonJs.showProcMessageOnElement("divScrollablePanel");

		commonJs.doSearch({
			url:"/common/commonFunction/getFavoriteMenuList.do",
			data:{},
			onSuccess:renderGridData
		});
	};

	renderGridData = function(result) {
		var ds = result.dataSet, html = "";
		var languageCode = jsconfig.get("langCode").toUpperCase();

		$("#tblGridBody").html("");

		if (ds.getRowCnt() > 0) {
			for (var i=0; i<ds.getRowCnt(); i++) {
				var gridTr = new UiGridTr();

				gridTr.addChild(new UiGridTd().addClassName("Ct").addChild(new UiCheckbox().setName("chkForDel").setValue(ds.getValue(i, "LEFT_MENU_ID"))));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "LEFT_MENU_ID")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "LEFT_MENU_NAME_"+languageCode)));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "MENU_PATH_NAME_"+languageCode)));

				html += gridTr.toHtmlString();
			}
		} else {
			var gridTr = new UiGridTr();

			gridTr.addChild(new UiGridTd().addClassName("Ct").setAttribute("colspan:4").setText(com.message.I001));
			html += gridTr.toHtmlString();
		}

		$("#tblGridBody").append($(html));

		$("#tblGrid").freezeHeader({
			attachTo:$("#divDataArea"),
			pagingArea:$("#divPagingArea"),
			isPageable:false
		});

		commonJs.bindToggleTrBackgroundWithCheckbox($("[name=chkForDel]"));
		commonJs.hideProcMessageOnElement("divScrollablePanel");
	};

	doDelete = function() {
		if (commonJs.getCountChecked("chkForDel") == 0) {
			commonJs.warn(com.message.I902);
			return;
		}

		commonJs.doDelete({
			url:"/common/commonFunction/doDeleteFavoriteMenu.do",
			onSuccess:function() {
				$("#btnClose").trigger("click");
				parent.doMainMenu(parent.$("#hdnHeaderMenuId").val(), parent.$("#hdnHeaderMenuName").val(), parent.$("#hdnHeaderMenuUrl").val());
			}
		});
	};

	/*!
	 * load event (document / window)
	 */
	$(window).load(function() {
		doSearch();
	});
});