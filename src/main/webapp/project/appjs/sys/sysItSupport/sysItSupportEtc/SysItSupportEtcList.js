/**************************************************************************************************
 * Framework Generated Javascript Source
 * - SysItSupportEtcList.js
 *************************************************************************************************/
var popup = null;

$(function() {
	/*!
	 * event
	 */
	$("#selectedShiftOrg").change(() => countShiftOrgSelect());

	$("#btnClearOrg").click(function(event) {
		$(document).find("#divOrg").find(":input").each(function() {
			if ($(this).prop("type") == "checkbox" || $(this).prop("type") == "radio") {
				$(this).attr("checked", false);
			} else {
				$(this).val("");
			}
		});
	});

	$("#btnClearBillingCodeCreationType").click(function(event) {
		$(document).find("#divBillingCode").find(":input").each(function() {
			if ($(this).prop("type") == "checkbox" || $(this).prop("type") == "radio") {
				$(this).attr("checked", false);
			} else {
				$(this).val("");
			}
		});

		$("#billingCodeCreationTypeFrom").val("");
		commonJs.refreshBootstrapSelectbox("billingCodeCreationTypeFrom");
		$("#billingCodeCreationTypeTo").val("");
		commonJs.refreshBootstrapSelectbox("billingCodeCreationTypeTo");
	});

	$("#btnClearAccntShift").click(function(event) {
		$(document).find("#divAccountShift").find(":input").each(function() {
			if ($(this).prop("type") == "checkbox" || $(this).prop("type") == "radio") {
//				$(this).attr("checked", false);
			} else {
				$(this).val("");
			}
		});

		$("#selectedShiftOrg option").each(function(index) {
			$(this).remove();
		});
		commonJs.refreshBootstrapSelectbox("selectedShiftOrg");

		countShiftOrgSelect();
	});

	$("#btnClearEoExpenseStatus").click(function(event) {
		$(document).find("#divEoExpenseStatus").find(":input").each(function() {
			if ($(this).prop("type") == "checkbox" || $(this).prop("type") == "radio") {
				$(this).attr("checked", false);
			} else {
				$(this).val("");
			}
		});

		$("#eoExpenseStatusTo").val("TU");
		commonJs.refreshBootstrapSelectbox("eoExpenseStatusTo");
	});

	$("#btnSaveOrg").click(function(event) {
		if (!commonJs.doValidate($("#orgNameTo"))) {
			return false;
		}

		commonJs.doSave({
			url:"/sys/sysItSupport/sysItSupportEtc/doSaveOrg.do",
			data:{},
			onSuccess:function() {
				commonJs.showProcMessageOnElement("divOrg");
				setOrgInfo();
				setTimeout(function() {
					commonJs.hideProcMessageOnElement("divOrg");
				}, 500);
			}
		});
	});

	$("#btnSaveBillingCodeCreationType").click(function(event) {
		if (!commonJs.doValidate($("#billingCodeCreationTypeTo"))) {
			return false;
		}

		commonJs.doSave({
			url:"/sys/sysItSupport/sysItSupportEtc/doSaveBillingCodeCreationType.do",
			data:{},
			onSuccess:function() {
				commonJs.showProcMessageOnElement("divBillingCode");
				setBillingCodeInfo();
				setTimeout(function() {
					commonJs.hideProcMessageOnElement("divBillingCode");
				}, 500);
			}
		});
	});

	$("#btnSaveAccntShift").click(function(event) {
		if (!commonJs.doValidate($("#selectedShiftOrg")) || !commonJs.doValidate($("#shiftToName"))) {
			return false;
		}
		
		commonJs.doSave({
			url:"/sys/sysItSupport/sysItSupportEtc/doSaveAccntShift.do",
			data:{},
			onSuccess:function() {
				commonJs.showProcMessageOnElement("divAccountShift");
				setTimeout(function() {
					$("#btnClearAccntShift").trigger("click");
					commonJs.hideProcMessageOnElement("divAccountShift");
				}, 500);
			}
		});
	});

	$("#btnSaveEoExpenseStatus").click(function(event) {
		if (!commonJs.doValidate($("#eoExpenseStatusTo"))) {
			return false;
		}

		commonJs.doSave({
			url:"/sys/sysItSupport/sysItSupportEtc/doUpdateEoExpenseStatus.do",
			data:{},
			onSuccess:function() {
				commonJs.showProcMessageOnElement("divEoExpenseStatus");

				setTimeout(function() {
					$("#btnClearEoExpenseStatus").trigger("click");
					commonJs.hideProcMessageOnElement("divEoExpenseStatus");
				}, 500);
			}
		});
	});

	$("#btnAddShiftOrg").click(function(event) {
		addShiftOrg();
	});

	$("#orgName").blur(function() {
		if (commonJs.isEmpty($(this).val())) {
			$("#orgId").val("");
			setOrgInfo();
		}
	});

	$("#billingCode").blur(function() {
		if (commonJs.isEmpty($(this).val())) {
			$("#billingCodeId").val("");
			setBillingCodeInfo();
		}
	});

	$("#shiftToName").blur(function() {
		if (commonJs.isEmpty($(this).val())) {
			$("#shiftToId").val("");
		}
	});

	/*!
	 * context menus
	 */

	/*!
	 * process
	 */
	setOrgInfo = function() {
		var val = $("#orgId").val();
		if (commonJs.isEmpty(val)) {
			$("#orgIdToDisplay").val("");
			$("#orgNameTo").val("");
			$("#abnTo").val("");
			$("#acnTo").val("");
		} else {
			commonJs.doSimpleProcess({
				url:"/sys/sysItSupport/sysItSupportEtc/getOrgInfo.do",
				data:{organisationId:val},
				noForm:true,
				onSuccess:function(result) {
					var ds = result.dataSet;
					$("#orgIdToDisplay").val(val);
					$("#orgNameTo").val(ds.getValue(0, "organisationName"));
					$("#abnTo").val(ds.getValue(0, "abn"));
					$("#acnTo").val(ds.getValue(0, "acn"));
				}
			});
		}
	};

	setBillingCodeInfo = function() {
		var val = $("#billingCodeId").val();
		if (commonJs.isEmpty(val)) {
			$("#billingCodeCreationTypeFrom").val("");
			commonJs.refreshBootstrapSelectbox("billingCodeCreationTypeFrom");
			$("#billingCodeCreationTypeTo").val("");
			commonJs.refreshBootstrapSelectbox("billingCodeCreationTypeTo");
		} else {
			commonJs.doSimpleProcess({
				url:"/sys/sysItSupport/sysItSupportEtc/getBillingCodeInfo.do",
				data:{billingCodeId:val},
				noForm:true,
				onSuccess:function(result) {
					var ds = result.dataSet;

					$("#billingCodeIdToDisplay").val(ds.getValue(0, "billingCodeId"));
					$("#billingCodeToDisplay").val(ds.getValue(0, "billingCode"));

					$("#billingCodeCreationTypeFrom").val(ds.getValue(0, "periodsCreationType"));
					commonJs.refreshBootstrapSelectbox("billingCodeCreationTypeFrom");
					$("#billingCodeCreationTypeTo").val(ds.getValue(0, "periodsCreationType"));
					commonJs.refreshBootstrapSelectbox("billingCodeCreationTypeTo");
				}
			});
		}
	};

	addShiftOrg = function() {
		var orgId = $("#shiftOrgId").val();
		var orgName = $("#shiftOrgName").val();

		if (!commonJs.isEmpty(orgId)) {
			var isSelected = false;

			$("#selectedShiftOrg option").each(function(index) {
				if ($(this).val() == orgId) {isSelected = true;}
			});

			if (!isSelected) {
				$("#selectedShiftOrg").append("<option value=\""+orgId+"\" selected>"+orgName+"</option>");
				$("#selectedShiftOrg").selectpicker("refresh");
			}

			$("#shiftOrgId").val("");
			$("#shiftOrgName").val("");

			countShiftOrgSelect();
		}
	};

	countShiftOrgSelect = function() {
		var selLength = $("#selectedShiftOrg :selected").length;

		if (selLength > 0) {
			$("#orgCntAdded").html("Number of Organisation selected : "+$("#selectedShiftOrg :selected").length);
		} else {
			$("#orgCntAdded").html("");
		}
	};

	/*!
	 * load event (document / window)
	 */
	$(window).load(function() {
		commonJs.setAccordion({
			containerClass:"accordionContainer",
			expandAll:true,
			active:0,
			icons:null,
			multipleExpand:true,
			animate:100
		});

		commonJs.setAutoComplete($("#orgName"), {
			method:"getOrgByNameOrId",
			label:"org_name_with_org_id",
			value:"organisation_id",
			minLength:3,
			focus: function(event, ui) {
				$("#orgId").val(ui.item.value);
				$("#orgIdToDisplay").val(ui.item.value);
				$("#orgName").val(ui.item.label);
				return false;
			},
			change:function(event, ui) {
				if (commonJs.isEmpty($("#orgName").val())) {
					$("#orgId").val("");
					$("#orgIdToDisplay").val("");
					$("#orgName").val("");
				}
			},
			select:function(event, ui) {
				$("#orgId").val(ui.item.value);
				$("#orgIdToDisplay").val(ui.item.value);
				$("#orgName").val(ui.item.label);
				setOrgInfo();
				return false;
			}
		});

		commonJs.setAutoComplete($("#billingCode"), {
			method:"getBillingCodeByCodeOrId",
			label:"display_column",
			value:"billing_code_id",
			minLength:2,
			focus: function(event, ui) {
				$("#billingCodeId").val(ui.item.value);
				$("#billingCodeIdToDisplay").val(ui.item.value);
				$("#billingCode").val(ui.item.label);
				$("#billingCodeToDisplay").val(ui.item.label);
				return false;
			},
			change:function(event, ui) {
				if (commonJs.isEmpty($("#billingCode").val())) {
					$("#billingCodeId").val("");
					$("#billingCodeIdToDisplay").val("");
					$("#billingCode").val("");
					$("#billingCodeToDisplay").val("");
				}
			},
			select:function(event, ui) {
				$("#billingCodeId").val(ui.item.value);
				$("#billingCodeIdToDisplay").val(ui.item.value);
				$("#billingCode").val(ui.item.label);
				$("#billingCodeToDisplay").val(ui.item.label);
				setBillingCodeInfo();
				return false;
			}
		});

		commonJs.setAutoComplete($("#shiftOrgName"), {
			method:"getOrgByNameOrId",
			label:"org_name_with_org_id",
			value:"organisation_id",
			minLength:3,
			focus: function(event, ui) {
				$("#shiftOrgId").val(ui.item.value);
				$("#shiftOrgName").val(ui.item.label);
				return false;
			},
			change:function(event, ui) {
				if (commonJs.isEmpty($("#shiftOrgName").val())) {
					$("#shiftOrgId").val("");
					$("#shiftOrgName").val("");
				}
			},
			select:function(event, ui) {
				$("#shiftOrgId").val(ui.item.value);
				$("#shiftOrgName").val(ui.item.label);
				addShiftOrg();
				return false;
			}
		});

		commonJs.setAutoComplete($("#shiftToName"), {
			method:"getEsEmployeeByNameOrPersonNumber",
			label:"full_name_with_person_number",
			value:"person_id",
			minLength:2,
			focus: function(event, ui) {
				$("#shiftToId").val(ui.item.value);
				$("#shiftToName").val(ui.item.label);
				return false;
			},
			change:function(event, ui) {
				if (commonJs.isEmpty($("#shiftToName").val())) {
					$("#shiftToId").val("");
					$("#shiftToName").val("");
				}
			},
			select:function(event, ui) {
				$("#shiftToId").val(ui.item.value);
				$("#shiftToName").val(ui.item.label);
				return false;
			}
		});

		commonJs.setFieldNumberMask("abnTo", "99-999-999-999");
		commonJs.setFieldNumberMask("acnTo", "999-999-999");
	});
});