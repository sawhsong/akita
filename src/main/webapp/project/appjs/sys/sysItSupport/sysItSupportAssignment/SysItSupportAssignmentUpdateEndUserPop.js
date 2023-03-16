/**************************************************************************************************
 * Framework Generated Javascript Source
 * - SysItSupportAssignmentUpdateEndUserPop.js
 *************************************************************************************************/
$(function() {
	/*!
	 * event
	 */
	$("#icnCheck").click(function(event) {
		commonJs.toggleCheckboxes("chkForAction");
	});

	$("#btnEdit").click(function(event) {
		if (!commonJs.doValidate("fmDefault")) {
			return;
		}

		if (commonJs.getCountChecked("chkForAction") == 0) {
			commonJs.warn(com.message.I902);
			return;
		}

		commonJs.doSave({
			url:"/sys/sysItSupport/sysItSupportAssignment/doUpdateEndUser.do",
			callback:function() {
				parent.popup.close();
				parent.doSearch();
			}
		});
	});

	$("#btnClose").click(function(event) {
		parent.popup.close();
	});

	$(document).keypress(function(event) {
		if (event.which == 13) {
		}
	});

	/*!
	 * process
	 */

	/*!
	 * load event (document / window)
	 */
	$(window).load(function() {
		commonJs.setAutoComplete($("#endUserToName"), {
			method:"getOrgByNameOrId",
			label:"org_name_with_org_id",
			value:"organisation_id",
			minLength:2,
			focus: function(event, ui) {
				$("#endUserToId").val(ui.item.value);
				$("#endUserToName").val(ui.item.label);
				return false;
			},
			change:function(event, ui) {
				if (commonJs.isEmpty($("#endUserToName").val())) {
					$("#endUserToId").val("");
					$("#endUserToName").val("");
				}
			},
			select:function(event, ui) {
				$("#endUserToId").val(ui.item.value);
				$("#endUserToName").val(ui.item.label);
				return false;
			}
		});

		setTimeout(function() {
			$("#tblGrid").freezeHeader({
				attachTo:$("#divDataArea")
			});

			$("#icnCheck").trigger("click");
			commonJs.bindToggleTrBackgroundWithCheckbox($("[name=chkForAction]"));
		}, 400);
	});
});