/**
 * dataMigrationDetailPop.js
 */
$(function() {
	/*!
	 * event
	 */
	$("#btnClose").click(function(event) {
		parent.popup.close();
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
	$(window).ready(function() {
		setTimeout(function() {
			$("#tblGrid").freezeHeader({
				attachTo:$("#divDataArea")
			});
		}, 500);
	});
});