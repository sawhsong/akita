/**************************************************************************************************
 * Framework Generated Javascript Source
 * - Per0202SuperannuationFrame.js
 *************************************************************************************************/
$(function() {
	/*!
	 * event
	 */

	/*!
	 * process
	 */
	setBlind = function() {
		commonJs.showProcMessageOnElement("divLeft");
		commonJs.showProcMessageOnElement("divRight");

		setTimeout(function() {
			commonJs.hideProcMessageOnElement("divLeft");
			commonJs.hideProcMessageOnElement("divRight");
		}, 1000);
	};

	setWrapperSize = function() {
		$("#divDataArea").height(722);
		$("#divFrameDataAreaWrapper").height($("#divScrollablePanelFrame").height());
	};

	setRadioCheckValues = function() {
		try {
			$("[name=preferredEmail]").filter("[value="+preferredEmail+"]").attr("checked", true);
			$("[name=excludeFromBulkEmail]").filter("[value="+excludeFromBulkEmail+"]").attr("checked", true);
			$("[name=executiveRelationship]").filter("[value="+executiveRelationship+"]").attr("checked", true);
			$("[name=operationalRelationship]").filter("[value="+operationalRelationship+"]").attr("checked", true);
		} catch(e) {}
	};

	/*
	 * ! load event (document / window)
	 */
	$(window).load(function() {
//		commonJs.setAccordion({
//			containerClass:"accordion",
//			multipleExpand:true,
//			expandAll:true,
//			icons:null
//		});
//
//		setRadioCheckValues();
//		setBlind();
//		setWrapperSize();
	});
});