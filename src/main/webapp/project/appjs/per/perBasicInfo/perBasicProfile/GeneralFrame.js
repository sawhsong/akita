/**************************************************************************************************
 * Framework Generated Javascript Source
 * - GeneralFrame.js
 *************************************************************************************************/
jsconfig.put("scrollablePanelHeightAdjust", 44);
$(function() {
	/*!
	 * event
	 */
	$("#icnMemberSince").click(function(event) {
		commonJs.openCalendar(event, "memberSince");
	});

	$("#icnResignationDate").click(function(event) {
		commonJs.openCalendar(event, "resignationDate");
	});

	$("#crmName").blur(function() {
		if (commonJs.isEmpty($(this).val())) {
			$("#crmId").val("");
		}
	});

	$("#csmName").blur(function() {
		if (commonJs.isEmpty($(this).val())) {
			$("#csmId").val("");
		}
	});

	$("#csaName").blur(function() {
		if (commonJs.isEmpty($(this).val())) {
			$("#csaId").val("");
		}
	});

	/*!
	 * process
	 */
	showProcMessage = function() {
		commonJs.showProcMessageOnElement("divGeneralInfo");
		commonJs.showProcMessageOnElement("divPaymentAdviceDelivery");
		commonJs.showProcMessageOnElement("divWorkingRightsStatus");
		commonJs.showProcMessageOnElement("divScheduledPayrollNoti");
	};

	hideProcMessage = function() {
		commonJs.hideProcMessageOnElement("divGeneralInfo");
		commonJs.hideProcMessageOnElement("divPaymentAdviceDelivery");
		commonJs.hideProcMessageOnElement("divWorkingRightsStatus");
		commonJs.hideProcMessageOnElement("divScheduledPayrollNoti");
	};

	setWrapperSize = function() {
//		$("#divFrameDataAreaWrapper").height($("#divScrollablePanelFrame").height()-42);
	};

	setAutoCompletion = function() {
		commonJs.setAutoComplete($("#crmName"), {
			method:"getPersonByNameOrPersonNumber",
			label:"full_name_with_person_number",
			value:"person_id",
			minLength:2,
			focus: function(event, ui) {
				$("#crmId").val(ui.item.value);
				$("#crmName").val(ui.item.label);
				return false;
			},
			change:function(event, ui) {
				if (commonJs.isEmpty($("#crmName").val())) {
					$("#crmId").val("");
					$("#crmName").val("");
				}
			},
			select:function(event, ui) {
				$("#crmId").val(ui.item.value);
				$("#crmName").val(ui.item.label);
				return false;
			}
		});

		commonJs.setAutoComplete($("#csmName"), {
			method:"getPersonByNameOrPersonNumber",
			label:"full_name_with_person_number",
			value:"person_id",
			minLength:2,
			focus: function(event, ui) {
				$("#csmId").val(ui.item.value);
				$("#csmName").val(ui.item.label);
				return false;
			},
			change:function(event, ui) {
				if (commonJs.isEmpty($("#csmName").val())) {
					$("#csmId").val("");
					$("#csmName").val("");
				}
			},
			select:function(event, ui) {
				$("#csmId").val(ui.item.value);
				$("#csmName").val(ui.item.label);
				return false;
			}
		});

		commonJs.setAutoComplete($("#csaName"), {
			method:"getPersonByNameOrPersonNumber",
			label:"full_name_with_person_number",
			value:"person_id",
			minLength:2,
			focus: function(event, ui) {
				$("#csaId").val(ui.item.value);
				$("#csaName").val(ui.item.label);
				return false;
			},
			change:function(event, ui) {
				if (commonJs.isEmpty($("#csaName").val())) {
					$("#csaId").val("");
					$("#csaName").val("");
				}
			},
			select:function(event, ui) {
				$("#csaId").val(ui.item.value);
				$("#csaName").val(ui.item.label);
				return false;
			}
		});
	};

	getGeneralInfo = function() {
		commonJs.doSimpleProcess({
			url:"/per/perBasicInfo/perBasicProfile/getGeneralInfo.do",
			noForm:true,
			data:{personId:personId},
			callback:function(result) {
				var ds = result.dataSet;
				setGeneralInfoValues(ds);
			}
		});
	};
	setGeneralInfoValues = function(ds) {
		try {
			$("#emeploymentCompany").val(ds.getValue(0, "EMPLOYMENT_COMPANY_NAME"));
			commonJs.setSelectpickerValue("serviceStatus", ds.getValue(0, "SERVICE_STATUS"));
			commonJs.setSelectpickerValue("serviceType", ds.getValue(0, "SERVICE_TYPE"));
			$("#memberSince").val(ds.getValue(0, "MEMBER_SINCE"));
			$("#resignationDate").val(ds.getValue(0, "RESIGNATION_DATE"));
			commonJs.setSelectpickerValue("resignationReason", ds.getValue(0, "RESIGNATION_REASON"));
			$("#resignationComments").val(ds.getValue(0, "RESIGNATION_COMMENT_DESC"));
			$("#referenceNo2").val(ds.getValue(0, "REFERENCE_NO_2"));
			$("#referenceNo3").val(ds.getValue(0, "REFERENCE_NO_3"));
			commonJs.setSelectpickerValue("employmentType", ds.getValue(0, "EMPLOYMENT_TYPE"));
			$("#crmId").val(ds.getValue(0, "CRM_ID"));
			$("#crmName").val(ds.getValue(0, "CRM_NAME"));
			$("#csmId").val(ds.getValue(0, "CSM_ID"));
			$("#csmName").val(ds.getValue(0, "CSM_NAME"));
			$("#csaId").val(ds.getValue(0, "CSA_ID"));
			$("#csaName").val(ds.getValue(0, "CSA_NAME"));
			commonJs.setSelectpickerValue("stateManagedBy", ds.getValue(0, "ECMS_PAYROLL_CONSULTANT_ID"));
			commonJs.setCheckboxValue("lafhaEligible", ds.getValue(0, "LAFHA_ELIGIBLE"));
			$("#lafhaAmount").val(commonJs.getNumberMask(ds.getValue(0, "LAFHA_AMOUNT"), "#,##0.00"));
			commonJs.setCheckboxValue("verified", ds.getValue(0, "IS_VERIFIED"));

			// Payment Advice Delivery
			$("#paymentAdviceDeliveryEmail").val(ds.getValue(0, "PAYSLIP_EMAIL"));
			commonJs.setCheckboxValue("paymentAdviceDeliverySendToEmail", ds.getValue(0, "EMAIL_YN"));
			commonJs.setCheckboxValue("paymentAdviceDeliverySendToEntityOnline", ds.getValue(0, "ONLINE_YN"));
			commonJs.setCheckboxValue("paymentAdviceDeliverySendToOther", ds.getValue(0, "OTHER_YN"));
			$("#paymentAdviceDeliveryDescription").val(ds.getValue(0, "OTH_DESC"));
		} catch(e) {}
	};

	getWorkingRightsStatus = function() {
		commonJs.showProcMessageOnElement("divGridHolderWorkingRightsStatus");

		commonJs.doSimpleProcess({
			url:"/per/perBasicInfo/perBasicProfile/getWorkingRightsStatusList.do",
			noForm:true,
			data:{personId:personId},
			callback:function(result) {
				var ds = result.dataSet;
				setWorkingRightsStatusGridTable(ds);
			}
		});
	};
	setWorkingRightsStatusGridTable = function(ds) {
		var html = "";

		searchResultDataCount = ds.getRowCnt();
		$("#tbodyWorkingRightsStatus").html("");

		if (ds.getRowCnt() > 0) {
			for (var i=0; i<ds.getRowCnt(); i++) {
				var gridTr = new UiGridTr();

				var iconAction = new UiIcon();
				iconAction.setName("icnActionWorkingRightsStatus").setUseFor("action").addAttribute("workingRightsStatusId:"+ds.getValue(i, "WORKING_RIGHTS_STATUS_ID")).setScript("doActionWorkingRightsStatus(this)");
				gridTr.addChild(new UiGridTd().addClassName("Ct").addChild(iconAction));

				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "IS_ACTIVE")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(commonJs.abbreviate(ds.getValue(i, "VISA_STATUS_MEANING")), 20));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(commonJs.abbreviate(commonJs.nvl(ds.getValue(i, "VISA_TYPE_MEANING"), ds.getValue(i, "PR_TYPE_MEANING")), 20)));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "DATE_ISSUED")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "EXPIRY_DATE")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(commonJs.abbreviate(ds.getValue(i, "ADDITIONAL_NOTES"), 40)));

				html += gridTr.toHtmlString();
			}
		} else {
			var gridTr = new UiGridTr();

			gridTr.addChild(new UiGridTd().addClassName("Ct").setAttribute("colspan:7").setText(com.message.I001));
			html += gridTr.toHtmlString();
		}

		$("#tbodyWorkingRightsStatus").append($(html));
		$("#tblWorkingRightsStatus").freezeHeader({
			attachTo:$("#divGridHolderWorkingRightsStatus"),
			attachToHeight:198,
			scrollWrapper:$("#divScrollablePanelFrame"),
			isPageable:false
		});

		$("[name=icnActionWorkingRightsStatus]").each(function(index) {
			$(this).contextMenu(ctxMenu.commonSimpleAction);
		});

		commonJs.hideProcMessageOnElement("divGridHolderWorkingRightsStatus");
	};

	getScheduledPayrollNoti = function() {
		commonJs.showProcMessageOnElement("divGridHolderScheduledPayrollNoti");

		commonJs.doSimpleProcess({
			url:"/per/perBasicInfo/perBasicProfile/getScheduledPayrollNotiList.do",
			noForm:true,
			data:{personId:personId},
			callback:function(result) {
				var ds = result.dataSet;
				setScheduledPayrollNotiGridTable(ds);
			}
		});
	};
	setScheduledPayrollNotiGridTable = function(ds) {
		var html = "";

		searchResultDataCount = ds.getRowCnt();
		$("#tbodyScheduledPayrollNoti").html("");

		if (ds.getRowCnt() > 0) {
			for (var i=0; i<ds.getRowCnt(); i++) {
				var gridTr = new UiGridTr();

				var iconAction = new UiIcon();
				iconAction.setName("icnActionScheduledPayrollNoti").setUseFor("action").addAttribute("notificationId:"+ds.getValue(i, "NOTIFICATION_ID")).setScript("doActionScheduledPayrollNoti(this)");
				gridTr.addChild(new UiGridTd().addClassName("Ct").addChild(iconAction));

				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "IS_ACTIVE")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "NOTIFICATION_TYPE_MEANING")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "NOTIFICATION_PERIOD_MEANING")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "START_DATE")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "END_DATE")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(commonJs.abbreviate(ds.getValue(i, "NOTIFICATION_TEXT"), 70)));

				html += gridTr.toHtmlString();
			}
		} else {
			var gridTr = new UiGridTr();

			gridTr.addChild(new UiGridTd().addClassName("Ct").setAttribute("colspan:7").setText(com.message.I001));
			html += gridTr.toHtmlString();
		}

		$("#tbodyScheduledPayrollNoti").append($(html));
		$("#tblScheduledPayrollNoti").freezeHeader({
			attachTo:$("#divGridHolderScheduledPayrollNoti"),
			attachToHeight:198,
			scrollWrapper:$("#divScrollablePanelFrame"),
			isPageable:false
		});

		$("[name=icnActionScheduledPayrollNoti]").each(function(index) {
			$(this).contextMenu(ctxMenu.commonSimpleAction);
		});

		commonJs.hideProcMessageOnElement("divGridHolderScheduledPayrollNoti");
	};

	doActionWorkingRightsStatus = function(img) {
		var workingRightsStatusId = $(img).attr("workingRightsStatusId");

		ctxMenu.commonSimpleAction[0].fun = function() {alert("Edit : "+workingRightsStatusId);};
		ctxMenu.commonSimpleAction[1].fun = function() {alert("Delete : "+workingRightsStatusId);};

		$(img).contextMenu(ctxMenu.commonSimpleAction, {
			classPrefix:com.constants.ctxClassPrefixGrid,
			displayAround:"trigger",
			position:"bottom",
			horAdjust:0,
			verAdjust:2
		});
	};

	doActionScheduledPayrollNoti = function(img) {
		var notificationId = $(img).attr("notificationId");

		ctxMenu.commonSimpleAction[0].fun = function() {alert("Edit : "+notificationId);};
		ctxMenu.commonSimpleAction[1].fun = function() {alert("Delete : "+notificationId);};

		$(img).contextMenu(ctxMenu.commonSimpleAction, {
			classPrefix:com.constants.ctxClassPrefixGrid,
			displayAround:"trigger",
			position:"bottom",
			horAdjust:0,
			verAdjust:2
		});
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

		commonJs.setFieldDateMask("memberSince");
		commonJs.setFieldDateMask("resignationDate");

		setWrapperSize();
		setAutoCompletion();

		setTimeout(function() {
			getGeneralInfo();
			getWorkingRightsStatus();
			getScheduledPayrollNoti();

			hideProcMessage();
		}, 300);
	});
});