/**************************************************************************************************
 * Framework Generated Javascript Source
 * - SysItSupportAssignmentUpdateWorkingStatePop.js
 *************************************************************************************************/
jsconfig.put("scrollablePanelHeightAdjust", 24);

$(function() {
	/*!
	 * event
	 */
	$("#icnCheck").click(function(event) {
		commonJs.toggleCheckboxes("chkForAction");
	});

	$("#btnEdit").click(function(event) {
		if (commonJs.getCountChecked("chkForAction") == 0) {
			commonJs.warn(com.message.I902);
			return;
		}

		commonJs.doSave({
			url:"/sys/sysItSupport/sysItSupportAssignment/doUpdateWorkingState.do",
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
		setTimeout(function() {
			$("#tblGrid").freezeHeader({
				attachTo:$("#divDataArea")
			});

			$("#icnCheck").trigger("click");
			commonJs.bindToggleTrBackgroundWithCheckbox($("[name=chkForAction]"));
		}, 400);
	});
});