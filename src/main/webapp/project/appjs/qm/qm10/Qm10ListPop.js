/**************************************************************************************************
 * Framework Generated Javascript Source
 * - Qm10ListPop.js
 *************************************************************************************************/
$(function() {
	/*!
	 * event
	 */
	$("#btnSave").click(function(event) {
		if (!commonJs.doValidate("fmDefault")) {
			return;
		}

		commonJs.doSave({
			url:"/qm/10/exeSave.do",
			showPostMessage:false,
			onSuccess:function(result) {
				parent.$("#divDbInfo").html("Database : "+$("#dataSource").val());
				parent.popupQuickMenu.close();
			}
		});
	});

	$("#dataSource").change(function() {
		if (!commonJs.isEmpty($("#dataSource").val())) {
			$("#btnSave").trigger("click");
		}
	});

	$("#btnClose").click(function(event) {
		parent.popupQuickMenu.close();
	});

	$(document).keypress(function(event) {
		if (event.which == 13) {
			var element = event.target;
		}
	});

	/*!
	 * process
	 */

	/*!
	 * load event (document / window)
	 */
	$(window).load(function() {
	});
});