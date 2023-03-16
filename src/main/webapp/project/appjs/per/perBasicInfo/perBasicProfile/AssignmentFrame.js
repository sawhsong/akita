/**************************************************************************************************
 * Framework Generated Javascript Source
 * - AssignmentFrame.js
 *************************************************************************************************/
jsconfig.put("scrollablePanelHeightAdjust", 76);

var gridAction = [{
	name:"Edit",
	img:"fa-edit",
	fun:function() {}
}, {
	name:"Delete",
	img:"fa-times",
	fun:function() {}
}];

var isDeliverableRateLoaded = false;

$(function() {
	/*!
	 * event
	 */
	$("#icnAsgStartDate").click(function(event) {
		commonJs.openCalendar(event, "asgStartDate");
	});

	$("#icnAsgEndDate").click(function(event) {
		commonJs.openCalendar(event, "asgEndDate");
	});

	$("#tabPrtWorkcover li a").click(function(event) {
		event.preventDefault();
		changeTabSelectionInFrame($(this), "PrtWorkcover");
	});

	$("#tabTsExpDeli li a").click(function(event) {
		event.preventDefault();
		changeTabSelectionInFrame($(this), "TsExpDeli");

		var text = commonJs.removeString($(this).text(), [" ", "/", "&nbsp;"])
		if (text == "Deliverables") {
			if ($("[name=useDeliverable]").prop("checked")) {
				getDeliverableRateList();
			}
		}
	});

	$("[name=useTimesheet]").click(function(event) {
		if ($(this).prop("checked")) {
			$("#divTimesheetD").show();
		} else {
			$("#divTimesheetD").hide();
		}
	});

	$("[name=useExpense]").click(function(event) {
		if ($(this).prop("checked")) {
			$("#divExpenseD").show();
		} else {
			$("#divExpenseD").hide();
		}
	});

	$("[name=useDeliverable]").click(function(event) {
		if ($(this).prop("checked")) {
			$("#divDeliverableD").show();
			getDeliverableRateList();
		} else {
			$("#divDeliverableD").hide();
		}
	});

	$("#timsheetApprover1").change(function(event) {
		commonJs.doSimpleProcess({
			url:"/per/perBasicInfo/perBasicProfile/getApproverEmail.do",
			noForm:true,
			data:{approverId:$(this).val()},
			callback:function(result) {
				var ds = result.dataSet;
				$("#timesheetApprover1Email").val(ds.getValue(0, "EMAIL"));
			}
		});
	});
	$("#timsheetApprover2").change(function(event) {
		commonJs.doSimpleProcess({
			url:"/per/perBasicInfo/perBasicProfile/getApproverEmail.do",
			noForm:true,
			data:{approverId:$(this).val()},
			callback:function(result) {
				var ds = result.dataSet;
				$("#timesheetApprover2Email").val(ds.getValue(0, "EMAIL"));
			}
		});
	});
	$("#timsheetApprover3").change(function(event) {
		commonJs.doSimpleProcess({
			url:"/per/perBasicInfo/perBasicProfile/getApproverEmail.do",
			noForm:true,
			data:{approverId:$(this).val()},
			callback:function(result) {
				var ds = result.dataSet;
				$("#timesheetApprover3Email").val(ds.getValue(0, "EMAIL"));
			}
		});
	});
	$("#timesheetNotiToPerson").change(function(event) {
		commonJs.doSimpleProcess({
			url:"/per/perBasicInfo/perBasicProfile/getApproverEmail.do",
			noForm:true,
			data:{approverId:$(this).val()},
			callback:function(result) {
				var ds = result.dataSet;
				$("#timesheetNotiToPersonEmail").val(ds.getValue(0, "EMAIL"));
			}
		});
	});

	$("#expenseApprover1").change(function(event) {
		commonJs.doSimpleProcess({
			url:"/per/perBasicInfo/perBasicProfile/getApproverEmail.do",
			noForm:true,
			data:{approverId:$(this).val()},
			callback:function(result) {
				var ds = result.dataSet;
				$("#expenseApprover1Email").val(ds.getValue(0, "EMAIL"));
			}
		});
	});
	$("#expenseApprover2").change(function(event) {
		commonJs.doSimpleProcess({
			url:"/per/perBasicInfo/perBasicProfile/getApproverEmail.do",
			noForm:true,
			data:{approverId:$(this).val()},
			callback:function(result) {
				var ds = result.dataSet;
				$("#expenseApprover2Email").val(ds.getValue(0, "EMAIL"));
			}
		});
	});
	$("#expenseApprover3").change(function(event) {
		commonJs.doSimpleProcess({
			url:"/per/perBasicInfo/perBasicProfile/getApproverEmail.do",
			noForm:true,
			data:{approverId:$(this).val()},
			callback:function(result) {
				var ds = result.dataSet;
				$("#expenseApprover3Email").val(ds.getValue(0, "EMAIL"));
			}
		});
	});
	$("#expenseNotiToPerson").change(function(event) {
		commonJs.doSimpleProcess({
			url:"/per/perBasicInfo/perBasicProfile/getApproverEmail.do",
			noForm:true,
			data:{approverId:$(this).val()},
			callback:function(result) {
				var ds = result.dataSet;
				$("#expenseNotiToPersonEmail").val(ds.getValue(0, "EMAIL"));
			}
		});
	});

	$("#deliverableApprover1").change(function(event) {
		commonJs.doSimpleProcess({
			url:"/per/perBasicInfo/perBasicProfile/getApproverEmail.do",
			noForm:true,
			data:{approverId:$(this).val()},
			callback:function(result) {
				var ds = result.dataSet;
				$("#deliverableApprover1Email").val(ds.getValue(0, "EMAIL"));
			}
		});
	});
	$("#deliverableApprover2").change(function(event) {
		commonJs.doSimpleProcess({
			url:"/per/perBasicInfo/perBasicProfile/getApproverEmail.do",
			noForm:true,
			data:{approverId:$(this).val()},
			callback:function(result) {
				var ds = result.dataSet;
				$("#deliverableApprover2Email").val(ds.getValue(0, "EMAIL"));
			}
		});
	});
	$("#deliverableApprover3").change(function(event) {
		commonJs.doSimpleProcess({
			url:"/per/perBasicInfo/perBasicProfile/getApproverEmail.do",
			noForm:true,
			data:{approverId:$(this).val()},
			callback:function(result) {
				var ds = result.dataSet;
				$("#deliverableApprover3Email").val(ds.getValue(0, "EMAIL"));
			}
		});
	});
	$("#deliverableNotiToPerson").change(function(event) {
		commonJs.doSimpleProcess({
			url:"/per/perBasicInfo/perBasicProfile/getApproverEmail.do",
			noForm:true,
			data:{approverId:$(this).val()},
			callback:function(result) {
				var ds = result.dataSet;
				$("#deliverableNotiToPersonEmail").val(ds.getValue(0, "EMAIL"));
			}
		});
	});

	$("#timsheetNotiToOrg").change(function(event) {
		setNotiToPersonList("Timesheet");
	});

	$("#expenseNotiToOrg").change(function(event) {
		setNotiToPersonList("Expense");
	});

	$("#deliverableNotiToOrg").change(function(event) {
		setNotiToPersonList("Deliverable");
	});

	/*!
	 * process
	 */
	showProcMessage = function() {
		commonJs.showProcMessageOnElement("divGridHolderPrtDocument");
		commonJs.showProcMessageOnElement("divAsgRate");
		commonJs.showProcMessageOnElement("divGridHolderDeliverableRate");
	};

	hideProcMessage = function() {
		commonJs.hideProcMessageOnElement("divGridHolderPrtDocument");
		commonJs.hideProcMessageOnElement("divAsgRate");
		commonJs.hideProcMessageOnElement("divGridHolderDeliverableRate");
	};

	setWrapperSize = function() {
//		$("#divFrameDataAreaWrapper").height($("#divScrollablePanelFrame").height()-86);
	};

	setNotiToPersonList = function(sectionName) {
		if (!commonJs.isEmpty(sectionName)) {
			var personElementId, orgElementId;

			if (sectionName == "Timesheet") {personElementId = "timesheetNotiToPerson"; orgElementId = "timsheetNotiToOrg";}
			else if (sectionName == "Expense") {personElementId = "expenseNotiToPerson"; orgElementId = "expenseNotiToOrg";}
			else if (sectionName == "Deliverable") {personElementId = "deliverableNotiToPerson"; orgElementId = "deliverableNotiToOrg";}

			$("#"+personElementId+" option").each(function(index) {
				$(this).remove();
			});

			commonJs.doSimpleProcess({
				url:"/per/perBasicInfo/perBasicProfile/getNotiToPersonList.do",
				noForm:true,
				data:{organisationId:$("#"+orgElementId).val()},
				callback:function(result) {
					var ds = result.dataSet;

					$("#"+personElementId).append("<option value=\"\">==Select==</option>");
					for (var i=0; i<ds.getRowCnt(); i++) {
						$("#"+personElementId).append("<option value=\""+ds.getValue(i, "PERSON_ID")+"\">"+ds.getValue(i, "FULL_NAME")+"</option>");
					}
//					$("#"+personElementId).selectpicker("refresh");
					commonJs.refreshBootstrapSelectbox(personElementId);
				}
			});
		}
	};

	changeTabSelectionInFrame = function(object, tabCategory, event) {
		var $parentUl = $(object).closest("ul");
		var $parentLi = $(object).closest("li");

		if ($parentLi.attr("class").indexOf("disabled") != -1) {return;}

		$parentUl.find("li").each(function(index) {
			var thisSelected = $(this).has($(object)).length;

			if (thisSelected <= 0) {
				if ($(this).attr("class").indexOf("disabled") != -1) {
				} else {
					$(this).removeClass("active");
					if ($("#div"+tabCategory+index).length > 0) {
						$("#div"+tabCategory+index).stop().animate({opacity:"hide"}, jsconfig.get("effectDuration"));
					}
				}
			}

			if (thisSelected > 0) {
				if ($(this).attr("class").indexOf("disabled") != -1) {
				} else {
					$(this).addClass("active");
					if ($("#div"+tabCategory+index).length > 0) {
						$("#div"+tabCategory+index).stop().delay(100).animate({opacity:"show"}, jsconfig.get("effectDuration"));
					}
				}
			}
		});
	};

	setAutoCompletion = function() {
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

		commonJs.setAutoComplete($("#asgEuOrgName"), {
			method:"getOrgByNameOrId",
			label:"org_name_with_org_id",
			value:"organisation_id",
			minLength:2,
			focus: function(event, ui) {
				$("#asgEuOrgId").val(ui.item.value);
				$("#asgEuOrgName").val(ui.item.label);
				return false;
			},
			change:function(event, ui) {
				if (commonJs.isEmpty($("#asgEuOrgName").val())) {
					$("#asgEuOrgId").val("");
					$("#asgEuOrgName").val("");
				}
			},
			select:function(event, ui) {
				$("#asgEuOrgId").val(ui.item.value);
				$("#asgEuOrgName").val(ui.item.label);
				return false;
			}
		});

		commonJs.setAutoComplete($("#asgEuOrgContactName"), {
			method:"getPersonByNameOrPersonNumber",
			label:"full_name_with_person_number",
			value:"person_id",
			minLength:2,
			focus: function(event, ui) {
				$("#asgEuOrgContactId").val(ui.item.value);
				$("#asgEuOrgContactName").val(ui.item.label);
				return false;
			},
			change:function(event, ui) {
				if (commonJs.isEmpty($("#asgEuOrgContactName").val())) {
					$("#asgEuOrgContactId").val("");
					$("#asgEuOrgContactName").val("");
				}
			},
			select:function(event, ui) {
				$("#asgEuOrgContactId").val(ui.item.value);
				$("#asgEuOrgContactName").val(ui.item.label);
				return false;
			}
		});

		commonJs.setAutoComplete($("#asgReferenceNo3Name"), {
			method:"getBillingOrgByNameOrId",
			label:"org_name_with_org_id",
			value:"organisation_id",
			minLength:2,
			focus: function(event, ui) {
				$("#asgReferenceNo3Id").val(ui.item.value);
				$("#asgReferenceNo3Name").val(ui.item.label);
				return false;
			},
			change:function(event, ui) {
				if (commonJs.isEmpty($("#asgReferenceNo3Name").val())) {
					$("#asgReferenceNo3Id").val("");
					$("#asgReferenceNo3Name").val("");
				}
			},
			select:function(event, ui) {
				$("#asgReferenceNo3Id").val(ui.item.value);
				$("#asgReferenceNo3Name").val(ui.item.label);
				return false;
			}
		});

		commonJs.setAutoComplete($("#asgReferenceNo2Name"), {
			method:"getOrgByNameOrId",
			label:"org_name_with_org_id",
			value:"organisation_id",
			minLength:2,
			focus: function(event, ui) {
				$("#asgReferenceNo2Id").val(ui.item.value);
				$("#asgReferenceNo2Name").val(ui.item.label);
				return false;
			},
			change:function(event, ui) {
				if (commonJs.isEmpty($("#asgReferenceNo2Name").val())) {
					$("#asgReferenceNo2Id").val("");
					$("#asgReferenceNo2Name").val("");
				}
			},
			select:function(event, ui) {
				$("#asgReferenceNo2Id").val(ui.item.value);
				$("#asgReferenceNo2Name").val(ui.item.label);
				return false;
			}
		});

		commonJs.setAutoComplete($("#asgReferenceNo1Name"), {
			method:"getOrgByNameOrId",
			label:"org_name_with_org_id",
			value:"organisation_id",
			minLength:2,
			focus: function(event, ui) {
				$("#asgReferenceNo1Id").val(ui.item.value);
				$("#asgReferenceNo1Name").val(ui.item.label);
				return false;
			},
			change:function(event, ui) {
				if (commonJs.isEmpty($("#asgReferenceNo1Name").val())) {
					$("#asgReferenceNo1Id").val("");
					$("#asgReferenceNo1Name").val("");
				}
			},
			select:function(event, ui) {
				$("#asgReferenceNo1Id").val(ui.item.value);
				$("#asgReferenceNo1Name").val(ui.item.label);
				return false;
			}
		});

		commonJs.setAutoComplete($("#asgCostCentre"), {
			method:"getCostCentre",
			label:"cost_centre_name",
			value:"cost_centre_id",
			minLength:2,
			focus: function(event, ui) {
				$("#asgCostCentre").val(ui.item.label);
				return false;
			},
			select:function(event, ui) {
				$("#asgCostCentre").val(ui.item.label);
				return false;
			}
		});

		commonJs.setAutoComplete($("#asgBillingCodeName"), {
			method:"getBillingCodeByCodeOrId",
			label:"display_column",
			value:"billing_code_id",
			minLength:2,
			focus: function(event, ui) {
				$("#asgBillingCodeId").val(ui.item.value);
				$("#asgBillingCodeName").val(ui.item.label);
				return false;
			},
			change:function(event, ui) {
				if (commonJs.isEmpty($("#asgBillingCodeName").val())) {
					$("#asgBillingCodeId").val("");
					$("#asgBillingCodeName").val("");
				}
			},
			select:function(event, ui) {
				$("#asgBillingCodeId").val(ui.item.value);
				$("#asgBillingCodeName").val(ui.item.label);
				return false;
			}
		});

		commonJs.setAutoComplete($("#asgPaymentMethodName"), {
			method:"getPaymentMethodByCodeOrId",
			label:"display_column_short",
			value:"pay_method_id",
			minLength:2,
			focus: function(event, ui) {
				$("#asgPaymentMethodId").val(ui.item.value);
				$("#asgPaymentMethodName").val(ui.item.label);
				return false;
			},
			change:function(event, ui) {
				if (commonJs.isEmpty($("#asgPaymentMethodName").val())) {
					$("#asgPaymentMethodId").val("");
					$("#asgPaymentMethodName").val("");
				}
			},
			select:function(event, ui) {
				$("#asgPaymentMethodId").val(ui.item.value);
				$("#asgPaymentMethodName").val(ui.item.label);
				return false;
			}
		});
	};

	getPrtDocumentList = function() {
		if (!commonJs.isEmpty(prtDocumentId)) {
			commonJs.doSimpleProcess({
				url:"/per/perBasicInfo/perBasicProfile/getPrtDocumentList.do",
				noForm:true,
				data:{prtDocumentId:prtDocumentId},
				callback:function(result) {
					var ds = result.dataSet;
					renderPrtDocumentList(ds);
				}
			});
		}
	};
	renderPrtDocumentList = function(ds) {
		var html = "";

		searchResultDataCount = ds.getRowCnt();
		$("#tbodyPrtDocument").html("");

		if (ds.getRowCnt() > 0) {
			for (var i=0; i<ds.getRowCnt(); i++) {
				var gridTr = new UiGridTr();

				gridTr.addChild(new UiGridTd().addClassName("Lt").addChild(new UiAnchor().setText(ds.getValue(i, "DOCUMENT_NAME")).setScript("getPrtDocumentDetail('"+ds.getValue(i, "DOCUMENT_ID")+"')")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "CREATED_BY_NAME")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "CREATION_DATE_FORMAT")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "EXPIRY_DATE_FORMAT")));

				html += gridTr.toHtmlString();
			}
		} else {
			var gridTr = new UiGridTr();

			gridTr.addChild(new UiGridTd().addClassName("Ct").setAttribute("colspan:4").setText(com.message.I001));
			html += gridTr.toHtmlString();
		}

		$("#tbodyPrtDocument").append($(html));
	};
	getPrtDocumentDetail = function(documentId) {
		commonJs.alert("Detail : "+documentId);
	};

	getAssignmentRateList = function() {
		commonJs.doSimpleProcess({
			url:"/per/perBasicInfo/perBasicProfile/getAssignmentRateList.do",
			noForm:true,
			data:{assignmentId:assignmentId},
			callback:function(result) {
				var ds = result.dataSet;
				setTimeout(function() {
					renderAssignmentRateList(ds);
				}, 500);
			}
		});
	};
	renderAssignmentRateList = function(ds) {
		var html = "";

		searchResultDataCount = ds.getRowCnt();
		$("#tbodyAsgRates").html("");

		if (ds.getRowCnt() > 0) {
			for (var i=0; i<ds.getRowCnt(); i++) {
				var gridTr = new UiGridTr();

				var iconAction = new UiIcon();
				iconAction.setName("icnActionForAsgRate").setUseFor("action").addAttribute("assignmentRateId:"+ds.getValue(i, "ASSIGNMENT_RATE_ID")).setScript("doActionForAsgRate(this)");
				gridTr.addChild(new UiGridTd().addClassName("Ct").addChild(iconAction));

				gridTr.addChild(new UiGridTd().addClassName("Rt").setText(commonJs.getNumberMask(ds.getValue(i, "AMOUNT"), "#,##0.00")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "PERIOD_MEANING")));
				gridTr.addChild(new UiGridTd().addClassName("Rt").setText(commonJs.getNumberMask(ds.getValue(i, "UNITS"), "#,##0.00")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "ELEMENT_NAME")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "ALTERNATE_NAME")));
				gridTr.addChild(new UiGridTd().addClassName("Rt").setText(commonJs.getNumberMask(ds.getValue(i, "CHARGE_RATE"), "#,##0.00")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "CHARGE_PERIOD_MEANING")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "PREFERRED")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "DISPLAY_ON_TIMESHEET")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "DISPLAY_ON_EXPENSE")));
				gridTr.addChild(new UiGridTd().addClassName("Rt").setText(ds.getValue(i, "TAXABLE_PERCENTAGE")+" %"));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "GST_YN")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "RECURRING_RATE")));

				html += gridTr.toHtmlString();
			}
		} else {
			var gridTr = new UiGridTr();

			gridTr.addChild(new UiGridTd().addClassName("Ct").setAttribute("colspan:14").setText(com.message.I001));
			html += gridTr.toHtmlString();
		}

		$("#tbodyAsgRates").append($(html));

		$("#tblAsgRates").freezeHeader({
			attachTo:$("#divGridHolderAsgRates"),
			attachToHeight:200,
			scrollWrapper:$("#divScrollablePanelFrame"),
			isPageable:false
		});

		$("[name=icnActionForAsgRate]").each(function(index) {
			$(this).contextMenu(gridAction);
		});
	};
	doActionForAsgRate = function(img) {
		var assignmentRateId = $(img).attr("assignmentRateId");

		gridAction[0].fun = function() {editAssignmentRate(assignmentRateId);};
		gridAction[1].fun = function() {deleteAssignmentRate(assignmentRateId);};

		$(img).contextMenu(gridAction, {
			classPrefix:com.constants.ctxClassPrefixGrid,
			displayAround:"trigger",
			position:"bottom",
			horAdjust:0,
			verAdjust:2
		});
	};
	editAssignmentRate = function(assignmentRateId) {
		commonJs.alert("Edit Assignment Rate : "+assignmentRateId);
	};
	deleteAssignmentRate = function(assignmentRateId) {
		commonJs.alert("Delete Assignment Rate : "+assignmentRateId);
	};

	getDeliverableRateList = function() {
		if (isDeliverableRateLoaded) {
			return false;
		}

		commonJs.doSimpleProcess({
			url:"/per/perBasicInfo/perBasicProfile/getDeliverableRateList.do",
			noForm:true,
			data:{assignmentId:assignmentId},
			callback:function(result) {
				var ds = result.dataSet;
				setTimeout(function() {
					renderDeliverableRateList(ds);
				}, 500);
			}
		});
	};
	renderDeliverableRateList = function(ds) {
		var html = "";

		searchResultDataCount = ds.getRowCnt();
		$("#tbodyDeliverableRate").html("");

		if (ds.getRowCnt() > 0) {
			for (var i=0; i<ds.getRowCnt(); i++) {
				var gridTr = new UiGridTr();

				var iconAction = new UiIcon();
				iconAction.setName("icnActionForDeliverableRate").setUseFor("action").addAttribute("deliverableRateId:"+ds.getValue(i, "ASG_DELIVERABLES_RATES_ID")).setScript("doActionForDeliverableRate(this)");
				gridTr.addChild(new UiGridTd().addClassName("Ct").addChild(iconAction));

				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "ELEMENT_NAME")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "ALTERNATE_NAME")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "DESCRIPTION")));
				gridTr.addChild(new UiGridTd().addClassName("Rt").setText(commonJs.getNumberMask(ds.getValue(i, "AMOUNT"), "#,##0.00")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "DUE_DATE_FORMAT")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "DISPLAY_ON_DELIVERABLES")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "STATUS_MEANING")));

				html += gridTr.toHtmlString();
			}
		} else {
			var gridTr = new UiGridTr();

			gridTr.addChild(new UiGridTd().addClassName("Ct").setAttribute("colspan:8").setText(com.message.I001));
			html += gridTr.toHtmlString();
		}

		$("#tbodyDeliverableRate").append($(html));

		$("#tblDeliverableRate").freezeHeader({
			attachTo:$("#divGridHolderDeliverableRate"),
			attachToHeight:220,
			scrollWrapper:$("#divScrollablePanelFrame"),
			isPageable:false
		});

		$("[name=icnActionForDeliverableRate]").each(function(index) {
			$(this).contextMenu(gridAction);
		});

		isDeliverableRateLoaded = true;
	};
	doActionForDeliverableRate = function(img) {
		var deliverableRateId = $(img).attr("deliverableRateId");

		gridAction[0].fun = function() {editDeliverableRate(deliverableRateId);};
		gridAction[1].fun = function() {deleteDeliverableRate(deliverableRateId);};

		$(img).contextMenu(gridAction, {
			classPrefix:com.constants.ctxClassPrefixGrid,
			displayAround:"trigger",
			position:"bottom",
			horAdjust:0,
			verAdjust:2
		});
	};
	editDeliverableRate = function(deliverableRateId) {
		commonJs.alert("Edit Deliverable Rate : "+deliverableRateId);
	};
	deleteDeliverableRate = function(deliverableRateId) {
		commonJs.alert("Delete Deliverable Rate : "+deliverableRateId);
	};

	toggleDisplayTimesheet = function() {
		var use = $("[name=useTimesheet]").prop("checked");
		if (use) {
			$("#divTimesheetD").show();
		} else {
			$("#divTimesheetD").hide();
		}
	};

	toggleDisplayExpense = function() {
		var use = $("[name=useExpense]").prop("checked");
		if (use) {
			$("#divExpenseD").show();
		} else {
			$("#divExpenseD").hide();
		}
	};

	toggleDisplayDeliverable = function() {
		var use = $("[name=useDeliverable]").prop("checked");
		if (use) {
			$("#divDeliverableD").show();
		} else {
			$("#divDeliverableD").hide();
		}
	};

	loadTimesheetNotiToPerson = function() {
		var notiToOrgId = $("#timsheetNotiToOrg").val();
		if (!commonJs.isEmpty(notiToOrgId)) {
			setNotiToPersonList("Timesheet");
		}
	};

	loadExpenseNotiToPerson = function() {
		var notiToOrgId = $("#expenseNotiToOrg").val();
		if (!commonJs.isEmpty(notiToOrgId)) {
			setNotiToPersonList("Expense");
		}
	};

	loadDeliverableNotiToPerson = function() {
		var notiToOrgId = $("#deliverableNotiToOrg").val();
		if (!commonJs.isEmpty(notiToOrgId)) {
			setNotiToPersonList("Deliverable");
		}
	};

	/*
	 * ! load event (document / window)
	 */
	$(window).load(function() {
		showProcMessage();

		commonJs.setAccordion({
			containerClass:"accordion",
			multipleExpand:true,
			expandAll:true,
			icons:null
		});

		setWrapperSize();

		commonJs.setFieldDateMask("asgStartDate");
		commonJs.setFieldDateMask("asgEndDate");
		setAutoCompletion();

		getPrtDocumentList();
		getAssignmentRateList();

		toggleDisplayTimesheet();
		toggleDisplayExpense();
		toggleDisplayDeliverable();

		setTimeout(function() {
			loadTimesheetNotiToPerson();
			loadExpenseNotiToPerson();
			loadDeliverableNotiToPerson();

			hideProcMessage();
		}, 400);

		parent.parent.commonJs.hideProcMessageOnElement("divFrame");
	});
});