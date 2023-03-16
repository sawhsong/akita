/**
 * EmploymentOrganisationLookupPop.js
 */
var searchResultDataCount = 0;

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

		setTimeout(function() {
			commonJs.ajaxSubmit({
				url:"/common/lookup/getEmploymentOrganisationLookup.do",
				dataType:"json",
				formId:"fmDefault",
				success:function(data, textStatus) {
					var result = commonJs.parseAjaxResult(data, textStatus, "json");

					if (result.isSuccess == true || result.isSuccess == "true") {
						renderDataGridTable(result);
					} else {
						commonJs.error(result.message);
						commonJs.hideProcMessageOnElement("divScrollablePanelPopup");
					}
				}
			});
		}, 200);
	};

	renderDataGridTable = function(result) {
		var ds = result.dataSet, html = "";

		searchResultDataCount = ds.getRowCnt();
		$("#tblGridBody").html("");

		if (ds.getRowCnt() > 0) {
			for (var i=0; i<ds.getRowCnt(); i++) {
				var gridTr = new UiGridTr();

				gridTr.addChild(new UiGridTd().addClassName("Ct").addChild(new UiAnchor().setText(ds.getValue(i, "ORGANISATION_ID")).setScript("setValue('"+ds.getValue(i, "ORGANISATION_ID")+"', '"+ds.getValue(i, "ORGANISATION_NAME")+"')")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").addChild(new UiAnchor().setText(commonJs.abbreviate(ds.getValue(i, "ORGANISATION_NAME"), 60)).setScript("setValue('"+ds.getValue(i, "ORGANISATION_ID")+"', '"+ds.getValue(i, "ORGANISATION_NAME")+"')")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "ABN")));

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
		$(valueField).val(name+" ("+id+")");

		popupObject.close();
	};

	/*!
	 * load event (document / window)
	 */
	$(window).load(function() {
		$("#empOrgName").val(lookupValue);
		$("#empOrgName").focus();

		commonJs.setAutoComplete($("#empOrgName"), {
			method:"getOrgByNameOrId",
			label:"org_name_with_org_id",
			value:"organisation_name",
			focus: function(event, ui) {
				$("#empOrgName").val(ui.item.label);
				return false;
			},
			select:function(event, ui) {
				doSearch();
			}
		});

		commonJs.setAutoComplete($("#abn"), {
			method:"getAbn",
			label:"abn",
			value:"abn",
			focus: function(event, ui) {
				$("#abn").val(ui.item.label);
				return false;
			},
			select:function(event, ui) {
				doSearch();
			}
		});

		doSearch();
	});
});