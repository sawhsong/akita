/**************************************************************************************************
 * Framework Generated Javascript Source
 * - OpportunityEditPop.js
 *************************************************************************************************/
$(function() {
	/*!
	 * event
	 */
	$("#btnClose").click(function(event) {
		parent.popup.close();
	});

	$("#icnOppDueDate").click(function(event) {
		commonJs.openCalendar(event, "oppDueDate");
	});

	$("#icnAsgStartDate").click(function(event) {
		commonJs.openCalendar(event, "asgStartDate");
	});

	$("#icnAsgEndDate").click(function(event) {
		commonJs.openCalendar(event, "asgEndDate");
	});

	$(document).keypress(function(event) {
		if (event.which == 13) {
			var element = event.target;
		}
	});

	/*!
	 * process
	 */
	showProcMessage = function() {
		commonJs.showProcMessageOnElement("divPersonDetails");
		commonJs.showProcMessageOnElement("divOpportunityDetails");
		commonJs.showProcMessageOnElement("divAsgTermWc");
		commonJs.showProcMessageOnElement("divDocuments");
	};

	hideProcMessage = function() {
		commonJs.hideProcMessageOnElement("divPersonDetails");
		commonJs.hideProcMessageOnElement("divOpportunityDetails");
		commonJs.hideProcMessageOnElement("divAsgTermWc");
		commonJs.hideProcMessageOnElement("divDocuments");
	};

	getOpportunityDocuments = function() {
		commonJs.showProcMessageOnElement("divDocuments");

		commonJs.doSimpleProcess({
			url:"/per/perBasicInfo/perBasicProfile/getOpportunityDocuments.do",
			noForm:true,
			data:{opportunityId:opportunityId},
			callback:function(result) {
				var ds = result.dataSet;
				renderOpportunityDocumentTable(ds);
			}
		});
	};
	renderOpportunityDocumentTable = function(ds) {
		var html = "";

		searchResultDataCount = ds.getRowCnt();
		$("#tbodyDocuments").html("");

		if (ds.getRowCnt() > 0) {
			for (var i=0; i<ds.getRowCnt(); i++) {
				var gridTr = new UiGridTr();

				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "DOCUMENT_ID")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").addChild(new UiAnchor().setText(ds.getValue(i, "DOCUMENT_NAME")).setScript("getDetail('"+ds.getValue(i, "DOCUMENT_ID")+"')")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "DESCRIPTION")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "ASSIGNED_TO_NAME")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "DUE_DATE_FORMAT")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "FOLLOW_UP_DATE_FORMAT")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "STATUS_MEANING")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "STATUS_DETAIL_MEANING")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "SENT_BY_NAME")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "SENT_DATE_FORMAT")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "RECEIVED_DATE_FORMAT")));

				html += gridTr.toHtmlString();
			}
		} else {
			var gridTr = new UiGridTr();

			gridTr.addChild(new UiGridTd().addClassName("Ct").setAttribute("colspan:11").setText(com.message.I001));
			html += gridTr.toHtmlString();
		}

		$("#tbodyDocuments").append($(html));
		$("#tblDocuments").freezeHeader({
			attachTo:$("#divGridHolderDocuments"),
			attachToHeight:280,
			scrollWrapper:$("#divFrameDataAreaWrapper"),
			isPageable:false
		});

		commonJs.hideProcMessageOnElement("divDocuments");
	};

	getDetail = function(documentId) {
		commonJs.alert("Detail : "+documentId);
	};

	/*!
	 * load event (document / window)
	 */
	$(window).load(function() {
		showProcMessage();
		commonJs.setFieldDateMask("oppDueDate");
		commonJs.setFieldDateMask("asgStartDate");
		commonJs.setFieldDateMask("asgEndDate");

		commonJs.setAccordion({
			containerClass:"accordion",
			multipleExpand:true,
			expandAll:true,
			icons:null
		});

		commonJs.setAutoComplete($("#personName"), {
			method:"getPersonByNameOrPersonNumber",
			label:"full_name_with_person_number",
			value:"person_id",
			minLength:2,
			focus: function(event, ui) {
				$("#personId").val(ui.item.value);
				$("#personName").val(ui.item.label);
				return false;
			},
			change:function(event, ui) {
				if (commonJs.isEmpty($("#personName").val())) {
					$("#personId").val("");
					$("#personName").val("");
				}
			},
			select:function(event, ui) {
				$("#personId").val(ui.item.value);
				$("#personName").val(ui.item.label);
				return false;
			}
		});

		commonJs.setAutoComplete($("#oppCrmName"), {
			method:"getEsEmployeeByNameOrPersonNumber",
			label:"full_name_with_person_number",
			value:"person_id",
			minLength:2,
			focus: function(event, ui) {
				$("#oppCrmId").val(ui.item.value);
				$("#oppCrmName").val(ui.item.label);
				return false;
			},
			change:function(event, ui) {
				if (commonJs.isEmpty($("#oppCrmName").val())) {
					$("#oppCrmId").val("");
					$("#oppCrmName").val("");
				}
			},
			select:function(event, ui) {
				$("#oppCrmId").val(ui.item.value);
				$("#oppCrmName").val(ui.item.label);
				return false;
			}
		});

		commonJs.setAutoComplete($("#oppCsmName"), {
			method:"getEsEmployeeByNameOrPersonNumber",
			label:"full_name_with_person_number",
			value:"person_id",
			minLength:2,
			focus: function(event, ui) {
				$("#oppCsmId").val(ui.item.value);
				$("#oppCsmName").val(ui.item.label);
				return false;
			},
			change:function(event, ui) {
				if (commonJs.isEmpty($("#oppCsmName").val())) {
					$("#oppCsmId").val("");
					$("#oppCsmName").val("");
				}
			},
			select:function(event, ui) {
				$("#oppCsmId").val(ui.item.value);
				$("#oppCsmName").val(ui.item.label);
				return false;
			}
		});

		commonJs.setAutoComplete($("#asgBillingOrgContactName"), {
			method:"getPersonByNameOrPersonNumber",
			label:"full_name_with_person_number",
			value:"person_id",
			minLength:2,
			focus: function(event, ui) {
				$("#asgBillingOrgContactId").val(ui.item.value);
				$("#asgBillingOrgContactName").val(ui.item.label);
				return false;
			},
			change:function(event, ui) {
				if (commonJs.isEmpty($("#asgBillingOrgContactName").val())) {
					$("#asgBillingOrgContactId").val("");
					$("#asgBillingOrgContactName").val("");
				}
			},
			select:function(event, ui) {
				$("#asgBillingOrgContactId").val(ui.item.value);
				$("#asgBillingOrgContactName").val(ui.item.label);
				return false;
			}
		});

		commonJs.setAutoComplete($("#asgBillingOrgName"), {
			method:"getBillingOrgByNameOrId",
			label:"org_name_with_org_id",
			value:"organisation_id",
			minLength:2,
			focus: function(event, ui) {
				$("#asgBillingOrgId").val(ui.item.value);
				$("#asgBillingOrgName").val(ui.item.label);
				return false;
			},
			change:function(event, ui) {
				if (commonJs.isEmpty($("#asgBillingOrgName").val())) {
					$("#asgBillingOrgId").val("");
					$("#asgBillingOrgName").val("");
				}
			},
			select:function(event, ui) {
				$("#asgBillingOrgId").val(ui.item.value);
				$("#asgBillingOrgName").val(ui.item.label);
				return false;
			}
		});

		commonJs.setAutoComplete($("#asgEndUserOrgName"), {
			method:"getOrgByNameOrId",
			label:"org_name_with_org_id",
			value:"organisation_id",
			minLength:2,
			focus: function(event, ui) {
				$("#asgEndUserOrgId").val(ui.item.value);
				$("#asgEndUserOrgName").val(ui.item.label);
				return false;
			},
			change:function(event, ui) {
				if (commonJs.isEmpty($("#asgEndUserOrgName").val())) {
					$("#asgEndUserOrgId").val("");
					$("#asgEndUserOrgName").val("");
				}
			},
			select:function(event, ui) {
				$("#asgEndUserOrgId").val(ui.item.value);
				$("#asgEndUserOrgName").val(ui.item.label);
				return false;
			}
		});

		$("#asgRate").number(true, 2);
		$("#asgManagementFee").number(true, 3);

		setTimeout(function() {
			getOpportunityDocuments();

			hideProcMessage();
		}, 400);
	});
});