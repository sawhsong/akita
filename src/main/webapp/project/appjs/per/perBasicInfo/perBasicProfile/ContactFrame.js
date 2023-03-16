/**************************************************************************************************
 * Framework Generated Javascript Source
 * - ContactFrame.js
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
//		$("#divDataArea").height(722);
//		$("#divFrameDataAreaWrapper").height($("#divScrollablePanelFrame").height());
	};

	setRadioCheckValues = function() {
		try {
			commonJs.setRadioValue("preferredEmail", preferredEmail);
			commonJs.setRadioValue("excludeFromBulkEmail", excludeFromBulkEmail);
			commonJs.setRadioValue("executiveRelationship", executiveRelationship);
			commonJs.setRadioValue("operationalRelationship", operationalRelationship);
		} catch(e) {}
	};

	/*
	 * ! load event (document / window)
	 */
	$(window).load(function() {
		setBlind();

		commonJs.setAccordion({
			containerClass:"accordion",
			multipleExpand:true,
			expandAll:true
		});

		setRadioCheckValues();
		setWrapperSize();
	});
});