/**************************************************************************************************
 * Framework Generated Javascript Source
 * - SysPerciSourceGeneratorDetailPop.js
 *************************************************************************************************/
$(function() {
	/*!
	 * event
	 */
	$("#btnClose").click(function(event) {
		parent.popupDetail.close();
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
				attachTo:$("#divDataArea"),
				pagingArea:$("#divPagingArea")
			});
		}, 500);
	});
});