/**************************************************************************************************
 * Framework Generated Javascript Source
 * - PersonalFrame.js
 *************************************************************************************************/
$(function() {
	/*!
	 * event
	 */
	$("#icnDateOfBirth").click(function(event) {
		commonJs.openCalendar(event, "dateOfBirth");
	});

	$("#icnFirstContact").click(function(event) {
		commonJs.openCalendar(event, "firstContact");
	});

	$("#employmentCompanyOrgName").blur(function() {
		if (commonJs.isEmpty($(this).val())) {
			$("#employmentCompanyOrgId").val("");
		}
	});

	$("#referralName").blur(function() {
		if (commonJs.isEmpty($(this).val())) {
			$("#referralId").val("");
		}
	});

	$("#referralOrganisationName").blur(function() {
		if (commonJs.isEmpty($(this).val())) {
			$("#referralOrganisationId").val("");
		}
	});

	$("#btnDownloadComms").click(function() {
		var val = commonJs.htmlToString($("#commsHistory").html());
		val = commonJs.replace(val, "<strong>", "");
		val = commonJs.replace(val, "</strong>", "");
		commonJs.downloadContentAsFile("CommunicationHistory.txt", val);
	});

	/*!
	 * process
	 */
	setEditor = function() {
//		$("#personalComment").ckeditor({
//			height:246,
//			toolbar:com.constants.toolbarSimple
//		});
	};

	setWrapperSize = function() {
//commonJs.printLog({message:"divFrameWindowHolder : "+$("#divFrameWindowHolder").height()});
//commonJs.printLog({message:"divFixedPanelFrame : "+$("#divFixedPanelFrame").height()});
//commonJs.printLog({message:"divScrollablePanelFrame : "+$("#divScrollablePanelFrame").height()});
//		$("#divDataArea").height(722); // divFrameWindowHolder - divFixedPanelFrame - additional height
//		$("#divFrameDataAreaWrapper").height($("#divScrollablePanelFrame").height());
	};

	setFieldPersonDetailValues = function(ds) {
		var person = ds.getRowAsDto();
		var personType = commonJs.upperCase(person.personType).split(",");
		try {
			$("#personNumber").val(person.personNumber);
			commonJs.setRadioValue("prefix", person.prefix);
			$("#surname").val(person.surname);
			$("#firstName").val(person.firstName);
			$("#middleName").val(person.middleName);
			$("#preferredName").val(person.preferredName);
			$("#dateOfBirth").val(person.dateOfBirth);
			$("#firstContact").val(person.firstContact);
			commonJs.setRadioValue("maritalStatus", person.maritalStatus);
			commonJs.setRadioValue("gender", person.gender);
			commonJs.setRadioValue("isAorTsi", commonJs.nvl(person.isAOrTsi, "N"));
			$("#employmentCompanyOrgId").val(person.employmentCompanyOrgId);
			$("#employmentCompanyOrgName").val(person.employmentCompanyOrgName);
			$("#title").val(person.title);
			$("#referralId").val(person.referralId);
			$("#referralName").val(person.referralName);
			$("#referralOrganisationId").val(person.referralOrganisationId);
			$("#referralOrganisationName").val(person.referralOrganisationName);
		} catch(e) {}

		setTimeout(function() {
			setPersonType(personType);
		}, 500);
	};

	setPersonType = function(personType) {
		$("#personType").selectpicker("val", personType);
		$("#personType").selectpicker("refresh");
	};

	setPersonalCommentFieldValues = function(ds) {
//		$("#personalComment").val(ds.getValue(0, "DESCRIPTION"));
		$("#personalComment").html(commonJs.stringToHtml(ds.getValue(0, "DESCRIPTION")));
	};

	setCommsHistoryFieldValues = function(ds) {
		var html = "";

//		for (var i=0; i<ds.getRowCnt(); i++) {
//			html += commonJs.htmlToString(ds.getValue(i, "CON_DATE"))+"\n";
//			html += "------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n";
//			html += commonJs.htmlToString(ds.getValue(i, "COMMENTS"))+"\n";
//			html += "------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n\n";
//		}
//
//		$("#commsHistory").val(html);

		for (var i=0; i<ds.getRowCnt(); i++) {
			html += "<strong>"+commonJs.stringToHtml(ds.getValue(i, "CON_DATE"))+"</strong>"+"<br/>";
			html += "------------------------------------------------------------------------------------------------------------------------------------------------------------------------<br/>";
			html += commonJs.stringToHtml(ds.getValue(i, "COMMENTS"))+"<br/>";
			html += "------------------------------------------------------------------------------------------------------------------------------------------------------------------------<br/><br/>";
		}
		$("#commsHistory").html(html);
	};

	getPersonDetail = function() {
		commonJs.doSimpleProcess({
			url:"/per/perBasicInfo/perBasicProfile/getPersonDetail.do",
			noForm:true,
			data:{personId:personId},
			callback:function(result) {
				var ds = result.dataSet;
				setFieldPersonDetailValues(ds);
			}
		});
	};

	getPersonalComment = function() {
		commonJs.doSimpleProcess({
			url:"/per/perBasicInfo/perBasicProfile/getPersonalComment.do",
			dataType:"html",
			noForm:true,
			data:{personId:personId},
			callback:function(result) {
				var ds = result.dataSet;
				setPersonalCommentFieldValues(ds);
			}
		});
	};

	getCommsHistory = function() {
		commonJs.doSimpleProcess({
			url:"/per/perBasicInfo/perBasicProfile/getCommsHistory.do",
			noForm:true,
			dataType:"html",
			data:{personId:personId},
			callback:function(result) {
				var ds = result.dataSet;
				setCommsHistoryFieldValues(ds);
			}
		});
	};

	showProcMessage = function() {
		commonJs.showProcMessageOnElement("divPersonDetails");
		commonJs.showProcMessageOnElement("divPersonalComment");
		commonJs.showProcMessageOnElement("divCommsHistory");
	};

	hideProcMessage = function() {
		commonJs.hideProcMessageOnElement("divPersonDetails");
		commonJs.hideProcMessageOnElement("divPersonalComment");
		commonJs.hideProcMessageOnElement("divCommsHistory");
	};

	/*
	 * ! load event (document / window)
	 */
	$(window).load(function() {
		commonJs.setFieldDateMask("dateOfBirth");
		commonJs.setFieldDateMask("firstContact");
		setEditor();
		showProcMessage();

		commonJs.setAccordion({
			containerClass:"accordion",
			multipleExpand:true,
			expandAll:true
		});

		commonJs.setAutoComplete($("#employmentCompanyOrgName"), {
			method:"getOrgByNameOrId",
			label:"org_name_with_org_id",
			value:"organisation_id",
			minLength:2,
			focus: function(event, ui) {
				$("#employmentCompanyOrgId").val(ui.item.value);
				$("#employmentCompanyOrgName").val(ui.item.label);
				return false;
			},
			change:function(event, ui) {
				if (commonJs.isEmpty($("#employmentCompanyOrgName").val())) {
					$("#employmentCompanyOrgId").val("");
					$("#employmentCompanyOrgName").val("");
				}
			},
			select:function(event, ui) {
				$("#employmentCompanyOrgId").val(ui.item.value);
				$("#employmentCompanyOrgName").val(ui.item.label);
				return false;
			}
		});

		commonJs.setAutoComplete($("#referralName"), {
			method:"getPersonByNameOrPersonNumber",
			label:"full_name_with_person_number",
			value:"person_id",
			minLength:2,
			focus: function(event, ui) {
				$("#referralId").val(ui.item.value);
				$("#referralName").val(ui.item.label);
				return false;
			},
			change:function(event, ui) {
				if (commonJs.isEmpty($("#referralName").val())) {
					$("#referralId").val("");
					$("#referralName").val("");
				}
			},
			select:function(event, ui) {
				$("#referralId").val(ui.item.value);
				$("#referralName").val(ui.item.label);
				return false;
			}
		});

		commonJs.setAutoComplete($("#referralOrganisationName"), {
			method:"getOrgByNameOrId",
			label:"org_name_with_org_id",
			value:"organisation_id",
			minLength:2,
			focus: function(event, ui) {
				$("#referralOrganisationId").val(ui.item.value);
				$("#referralOrganisationName").val(ui.item.label);
				return false;
			},
			change:function(event, ui) {
				if (commonJs.isEmpty($("#referralOrganisationName").val())) {
					$("#referralOrganisationId").val("");
					$("#referralOrganisationName").val("");
				}
			},
			select:function(event, ui) {
				$("#referralOrganisationId").val(ui.item.value);
				$("#referralOrganisationName").val(ui.item.label);
				return false;
			}
		});

		setWrapperSize();

		setTimeout(function() {
			getPersonDetail();
			getPersonalComment();
			getCommsHistory();

			hideProcMessage();
		}, 400);
	});
});