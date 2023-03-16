/**
 * EsEmployeeLookupPop.js
 */
$(function() {
	/*!
	 * event
	 */
	$("#btnSearch").click(function(event) {
		doSearch();
	});

	$("#btnClear").click(function(event) {
		commonJs.clearSearchCriteria();
	});

	$("#btnClose").click(function(event) {
		popupObject.close();
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
		commonJs.showProcMessageOnElement("divScrollablePanelPopup");

		commonJs.doSearch({
			url:"/common/lookup/getEsEmployeeLookup.do",
			callback:renderDataGridTable
		});
	};

	renderDataGridTable = function(result) {
		var ds = result.dataSet, html = "";

		$("#tblGridBody").html("");

		if (ds.getRowCnt() > 0) {
			for (var i=0; i<ds.getRowCnt(); i++) {
				var gridTr = new UiGridTr();

				gridTr.addChild(new UiGridTd().addClassName("Ct").addChild(new UiAnchor().setText(ds.getValue(i, "PERSON_NUMBER")).setScript("setValue('"+ds.getValue(i, "PERSON_ID")+"', '"+ds.getValue(i, "FULL_NAME")+"')")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").addChild(new UiAnchor().setText(commonJs.abbreviate(ds.getValue(i, "FULL_NAME"), 60)).setScript("setValue('"+ds.getValue(i, "PERSON_ID")+"', '"+ds.getValue(i, "FULL_NAME")+"')")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "TITLE")));

				html += gridTr.toHtmlString();
			}
		} else {
			var gridTr = new UiGridTr();

			gridTr.addChild(new UiGridTd().addClassName("Ct").setAttribute("colspan:3").setText(com.message.I001));
			html += gridTr.toHtmlString();
		}

		$("#tblGridBody").append($(html));
		setGridTable(result.totalResultRows);

		commonJs.hideProcMessageOnElement("divScrollablePanelPopup");
	};

	setValue = function(id, name) {
		var keyField, valueField;

		if (docTypeToSetValue == "page") {
			keyField = parent.$("#"+keyFieldId);
			valueField = parent.$("#"+valueFieldId);
		}

		$(keyField).val(id);
		$(valueField).val(name);

		popupObject.close();
	};

	/*!
	 * load event (document / window)
	 */
	$(window).load(function() {
		$("#personName").val(lookupValue);
		$("#personName").focus();

		commonJs.setAutoComplete($("#personNumber"), {
			method:"getEsEmployeeByPersonNumber",
			label:"person_name_with_person_number",
			value:"person_number",
			focus: function(event, ui) {
				$("#personNumber").val(ui.item.value);
				return false;
			},
			select:function(event, ui) {
				$("#personNumber").val(ui.item.value);
				doSearch();
				return false;
			}
		});

		commonJs.setAutoComplete($("#personName"), {
			method:"getEsEmployeeByName",
			label:"person_name_with_person_number",
			value:"full_name",
			minLength:2,
			focus: function(event, ui) {
				$("#personName").val(ui.item.value);
				return false;
			},
			select:function(event, ui) {
				$("#personName").val(ui.item.value);
				doSearch();
				return false;
			}
		});

		doSearch();
	});
});