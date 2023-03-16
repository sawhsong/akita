/**************************************************************************************************
 * Framework Generated Javascript Source
 * - BasicProfileFrame.js
 *************************************************************************************************/
$(function() {
	/*!
	 * event
	 */
	$("#icnMsaExecutionDate").click(function(event) {
		commonJs.openCalendar(event, "msaExecutionDate");
	});

	$("#btnDownloadCommunication").click(function() {
		var val = commonJs.htmlToString($("#communicationHistory").html());
		val = commonJs.replace(val, "<strong>", "");
		val = commonJs.replace(val, "</strong>", "");
		commonJs.downloadContentAsFile("CommunicationHistory.txt", val);
	});

	/*!
	 * process
	 */
	setFieldMask = function() {
		commonJs.setFieldDateMask("msaExecutionDate");
		commonJs.setFieldNumberMask("abn", "99-999-999-999");
		commonJs.setFieldNumberMask("acn", "999-999-999");
	};

	doBlurEvent = function($jqObj) {
		var id = $jqObj.attr("id"), name = commonJs.replace(id, "Name", "Id");
		var nameForTest = ["jurisdictionName", "authorizedPersonName", "esBdManagerName", "esAccountManagerName", "esExecRelationshipName",
			"esPayrollConsultantName", "esCustomerAdministratorName", "entityStaffContactName"];
		var nameFieldValue = $jqObj.val();

		if (commonJs.isIn(id, nameForTest) && commonJs.isEmpty(nameFieldValue)) {
			$("#"+name).val("");
		}
	};

	setAutoComplete = function() {
		commonJs.setAutoComplete($("#jurisdictionName"), {
			method:"getCountryName",
			label:"country_name",
			value:"country_name",
			minLength:2,
			focus: function(event, ui) {
				$("#jurisdictionId").val(ui.item.value);
				$("#jurisdictionName").val(ui.item.label);
				return false;
			},
			change:function(event, ui) {
				if (commonJs.isEmpty($("#jurisdictionName").val())) {
					$("#jurisdictionId").val("");
					$("#jurisdictionName").val("");
				}
			},
			select:function(event, ui) {
				$("#jurisdictionId").val(ui.item.value);
				$("#jurisdictionName").val(ui.item.label);
				return false;
			}
		});

		commonJs.setAutoComplete($("#authorizedPersonName"), {
			method:"getPersonByNameOrPersonNumber",
			label:"full_name_with_person_number",
			value:"person_id",
			minLength:2,
			focus: function(event, ui) {
				$("#authorizedPersonId").val(ui.item.value);
				$("#authorizedPersonName").val(ui.item.label);
				return false;
			},
			change:function(event, ui) {
				if (commonJs.isEmpty($("#authorizedPersonName").val())) {
					$("#authorizedPersonId").val("");
					$("#authorizedPersonName").val("");
				}
			},
			select:function(event, ui) {
				$("#authorizedPersonId").val(ui.item.value);
				$("#authorizedPersonName").val(ui.item.label);
				return false;
			}
		});

		commonJs.setAutoComplete($("#esBdManagerName"), {
			method:"getEsEmployeeByNameOrPersonNumber",
			label:"full_name_with_person_number",
			value:"person_id",
			minLength:2,
			focus: function(event, ui) {
				$("#esBdManagerId").val(ui.item.value);
				$("#esBdManagerName").val(ui.item.label);
				return false;
			},
			change:function(event, ui) {
				if (commonJs.isEmpty($("#esBdManagerName").val())) {
					$("#esBdManagerId").val("");
					$("#esBdManagerName").val("");
				}
			},
			select:function(event, ui) {
				$("#esBdManagerId").val(ui.item.value);
				$("#esBdManagerName").val(ui.item.label);
				return false;
			}
		});

		commonJs.setAutoComplete($("#esAccountManagerName"), {
			method:"getEsEmployeeByNameOrPersonNumber",
			label:"full_name_with_person_number",
			value:"person_id",
			minLength:2,
			focus: function(event, ui) {
				$("#esAccountManagerId").val(ui.item.value);
				$("#esAccountManagerName").val(ui.item.label);
				return false;
			},
			change:function(event, ui) {
				if (commonJs.isEmpty($("#esAccountManagerName").val())) {
					$("#esAccountManagerId").val("");
					$("#esAccountManagerName").val("");
				}
			},
			select:function(event, ui) {
				$("#esAccountManagerId").val(ui.item.value);
				$("#esAccountManagerName").val(ui.item.label);
				return false;
			}
		});

		commonJs.setAutoComplete($("#esExecRelationshipName"), {
			method:"getEsEmployeeByNameOrPersonNumber",
			label:"full_name_with_person_number",
			value:"person_id",
			minLength:2,
			focus: function(event, ui) {
				$("#esExecRelationshipId").val(ui.item.value);
				$("#esExecRelationshipName").val(ui.item.label);
				return false;
			},
			change:function(event, ui) {
				if (commonJs.isEmpty($("#esExecRelationshipName").val())) {
					$("#esExecRelationshipId").val("");
					$("#esExecRelationshipName").val("");
				}
			},
			select:function(event, ui) {
				$("#esExecRelationshipId").val(ui.item.value);
				$("#esExecRelationshipName").val(ui.item.label);
				return false;
			}
		});

		commonJs.setAutoComplete($("#esPayrollConsultantName"), {
			method:"getEsEmployeeByNameOrPersonNumber",
			label:"full_name_with_person_number",
			value:"person_id",
			minLength:2,
			focus: function(event, ui) {
				$("#esPayrollConsultantId").val(ui.item.value);
				$("#esPayrollConsultantName").val(ui.item.label);
				return false;
			},
			change:function(event, ui) {
				if (commonJs.isEmpty($("#esPayrollConsultantName").val())) {
					$("#esPayrollConsultantId").val("");
					$("#esPayrollConsultantName").val("");
				}
			},
			select:function(event, ui) {
				$("#esPayrollConsultantId").val(ui.item.value);
				$("#esPayrollConsultantName").val(ui.item.label);
				return false;
			}
		});

		commonJs.setAutoComplete($("#esCustomerAdministratorName"), {
			method:"getEsEmployeeByNameOrPersonNumber",
			label:"full_name_with_person_number",
			value:"person_id",
			minLength:2,
			focus: function(event, ui) {
				$("#esCustomerAdministratorId").val(ui.item.value);
				$("#esCustomerAdministratorName").val(ui.item.label);
				return false;
			},
			change:function(event, ui) {
				if (commonJs.isEmpty($("#esCustomerAdministratorName").val())) {
					$("#esCustomerAdministratorId").val("");
					$("#esCustomerAdministratorName").val("");
				}
			},
			select:function(event, ui) {
				$("#esCustomerAdministratorId").val(ui.item.value);
				$("#esCustomerAdministratorName").val(ui.item.label);
				return false;
			}
		});

		commonJs.setAutoComplete($("#entityStaffContactName"), {
			method:"getEsEmployeeByNameOrPersonNumber",
			label:"full_name_with_person_number",
			value:"person_id",
			minLength:2,
			focus: function(event, ui) {
				$("#entityStaffContactId").val(ui.item.value);
				$("#entityStaffContactName").val(ui.item.label);
				return false;
			},
			change:function(event, ui) {
				if (commonJs.isEmpty($("#entityStaffContactName").val())) {
					$("#entityStaffContactId").val("");
					$("#entityStaffContactName").val("");
				}
			},
			select:function(event, ui) {
				$("#entityStaffContactId").val(ui.item.value);
				$("#entityStaffContactName").val(ui.item.label);
				return false;
			}
		});
	};

	getOrganisationDetail = function() {
		commonJs.showProcMessageOnElement("divLeft");
		commonJs.showProcMessageOnElement("divCustomerDetails");
		commonJs.showProcMessageOnElement("divRelationshipInternalDetails");

		commonJs.doSimpleProcess({
			url:"/org/orgBasicInfo/orgBasicProfile/getOrganisationDetail.do",
			noForm:true,
			data:{organisationId:organisationId},
			callback:function(result) {
				var ds = result.dataSet;
				setFieldOrganisationDetailValues(ds);
			}
		});
	};

	setFieldOrganisationDetailValues = function(ds) {
		var role = !commonJs.isBlank(ds.getValue(0, "ROLE")) ? ds.getValue(0, "ROLE").split(",") : "";
		var relationship = !commonJs.isBlank(ds.getValue(0, "RELATIONSHIP")) ? ds.getValue(0, "RELATIONSHIP").split(",") : "";
		var product = !commonJs.isBlank(ds.getValue(0, "PRODUCT")) ? ds.getValue(0, "PRODUCT").split(",") : "";

		try {
			$("#organisationId").val(ds.getValue(0, "ORGANISATION_ID"));
			$("#organisationName").val(ds.getValue(0, "ORGANISATION_NAME"));
			$("#jurisdictionId").val(ds.getValue(0, "JURISDICTION"));
			$("#jurisdictionName").val(ds.getValue(0, "JURISDICTION"));
			$("#abn").val(commonJs.getFormatString(ds.getValue(0, "ABN"), "??-???-???-???"));
			$("#acn").val(commonJs.getFormatString(ds.getValue(0, "ACN"), "???-???-???"));
			commonJs.setRadioValue("gstReg", ds.getValue(0, "GST_REG"));
			$("#gstNumber").val(ds.getValue(0, "GST_NUMBER"));
			$("#authorizedPersonId").val(ds.getValue(0, "AUTHORIZED_PERSON"));
			$("#authorizedPersonName").val(!commonJs.isBlank(ds.getValue(0, "AUTHORIZED_PERSON_NAME")) ? ds.getValue(0, "AUTHORIZED_PERSON_NAME")+" ("+ds.getValue(0, "AUTHORIZED_PERSON_NUMBER")+")" : "");
			$("#stpBmsId").val(ds.getValue(0, "STP_BMS_ID"));
			$("#branchNumber").val(ds.getValue(0, "BRANCH_NUMBER"));
			$("#msaExecutionDate").val(ds.getValue(0, "MSA_EXECUTION_DATE_FORMAT"));
			$("#esBdManagerId").val(ds.getValue(0, "ES_BD_MANAGER"));
			$("#esBdManagerName").val(!commonJs.isBlank(ds.getValue(0, "ES_BD_MANAGER_NAME")) ? ds.getValue(0, "ES_BD_MANAGER_NAME")+" ("+ds.getValue(0, "ES_BD_MANAGER_NUMBER")+")" : "");
			$("#esAccountManagerId").val(ds.getValue(0, "ES_ACCOUNT_MANAGER"));
			$("#esAccountManagerName").val(!commonJs.isBlank(ds.getValue(0, "ES_ACCOUNT_MANAGER_NAME")) ? ds.getValue(0, "ES_ACCOUNT_MANAGER_NAME")+" ("+ds.getValue(0, "ES_ACCOUNT_MANAGER_NUMBER")+")" : "");
			$("#esExecRelationshipId").val(ds.getValue(0, "ES_EXEC_RELATIONSHIP"));
			$("#esExecRelationshipName").val(!commonJs.isBlank(ds.getValue(0, "ES_EXEC_RELATIONSHIP_NAME")) ? ds.getValue(0, "ES_EXEC_RELATIONSHIP_NAME")+" ("+ds.getValue(0, "ES_EXEC_RELATIONSHIP_NUMBER")+")" : "");
			$("#esPayrollConsultantId").val(ds.getValue(0, "ES_PAYROLL_CONSULTANT"));
			$("#esPayrollConsultantName").val(!commonJs.isBlank(ds.getValue(0, "ES_PAYROLL_CONSULTANT_NAME")) ? ds.getValue(0, "ES_PAYROLL_CONSULTANT_NAME")+" ("+ds.getValue(0, "ES_PAYROLL_CONSULTANT_NUMBER")+")" : "");
			$("#esCustomerAdministratorId").val(ds.getValue(0, "ES_CUSTOMER_ADMINISTRATOR"));
			$("#esCustomerAdministratorName").val(!commonJs.isBlank(ds.getValue(0, "ES_CUSTOMER_ADMINISTRATOR_NAME")) ? ds.getValue(0, "ES_CUSTOMER_ADMINISTRATOR_NAME")+" ("+ds.getValue(0, "ES_CUSTOMER_ADMINISTRATOR_NUMBER")+")" : "");
			$("#entityStaffContactId").val(ds.getValue(0, "ENTITY_STAFF_CONTACT"));
			$("#entityStaffContactName").val(!commonJs.isBlank(ds.getValue(0, "ENTITY_STAFF_CONTACT_NAME")) ? ds.getValue(0, "ENTITY_STAFF_CONTACT_NAME")+" ("+ds.getValue(0, "ENTITY_STAFF_CONTACT_NUMBER")+")" : "");
			$("#organisationOverview").val(ds.getValue(0, "ORGANISATION_OVERVIEW"));

			$("#taxInvoiceAcceptanceType").selectpicker("val", ds.getValue(0, "TAX_INVOICE_ACCEPTANCE_TYPE"));
			$("#taxInvoiceAcceptanceType").selectpicker("refresh");

			$("#customerType").selectpicker("val", ds.getValue(0, "CUSTOMER_TYPE"));
			$("#customerType").selectpicker("refresh");

			$("#customerCategory").selectpicker("val", ds.getValue(0, "CUSTOMER_CATEGORY"));
			$("#customerCategory").selectpicker("refresh");

			$("#swimLane").selectpicker("val", ds.getValue(0, "SWIM_LANE"));
			$("#swimLane").selectpicker("refresh");

			if (!commonJs.isBlank(role)) {
				$("#role").selectpicker("val", role);
				$("#role").selectpicker("refresh");
			}

			if (!commonJs.isBlank(role)) {
				$("#relationship").selectpicker("val", relationship);
				$("#relationship").selectpicker("refresh");
			}

			if (!commonJs.isBlank(role)) {
				$("#product").selectpicker("val", product);
				$("#product").selectpicker("refresh");
			}

			setTimeout(function() {
				commonJs.hideProcMessageOnElement("divLeft");
				commonJs.hideProcMessageOnElement("divCustomerDetails");
				commonJs.hideProcMessageOnElement("divRelationshipInternalDetails");
			}, 400);
		} catch(e) {}
	};

	getCommunicationHistory = function() {
		commonJs.showProcMessageOnElement("divCommunicationHistory");

		commonJs.doSimpleProcess({
			url:"/org/orgBasicInfo/orgBasicProfile/getCommunicationHistory.do",
			noForm:true,
			dataType:"html",
			data:{organisationId:organisationId},
			callback:function(result) {
				var ds = result.dataSet;
				setCommunicationHistoryFieldValues(ds);
			}
		});
	};

	setCommunicationHistoryFieldValues = function(ds) {
		$("#communicationHistory").html(commonJs.stringToHtml(ds.getValue(0, "HTML")));

		setTimeout(() => commonJs.hideProcMessageOnElement("divCommunicationHistory"), 800);
	};

	/*
	 * ! load event (document / window)
	 */
	$(window).load(function() {
		commonJs.setAccordion({
			containerClass:"accordion",
			multipleExpand:true,
			expandAll:true
		});

		setFieldMask();
		setAutoComplete();

		$("input[type=text]").blur(function(event) {
			doBlurEvent($(this));
		});

		setTimeout(() => getOrganisationDetail(), 400);
		setTimeout(() => getCommunicationHistory(), 800);
	});
});