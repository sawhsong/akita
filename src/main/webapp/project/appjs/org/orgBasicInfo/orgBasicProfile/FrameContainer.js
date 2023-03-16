/**************************************************************************************************
 * Framework Generated Javascript Source
 * - FramContainer.js
 *************************************************************************************************/
var popup;

$(function() {
	/*!
	 * event
	 */
	$("#tabCategoryOrganisationDetail li a").click(function() {
		var index = $(this).parent().index(),
			action = commonJs.removeString($(this).text(), [" ", "/", "&nbsp;"]),
			actionString = "/org/orgBasicInfo/orgBasicProfile/get"+action+".do"+"?organisationId="+organisationId;

		hideSubTabs("OrganisationDetail");
		changeTabSelection($(this));

		if (action == "ECMS" || action == "Workcover" || action == "PayrollTax" || action == "RateCard") {
			showSubTabs(action);
			return;
		}

		setFrame(actionString);
	});

	$("#tabCategoryEcms li a").click(function() {
		var index = $(this).parent().index(),
		action = commonJs.removeString($(this).text(), [" ", "/", "&nbsp;"]),
		actionString = "/org/orgBasicInfo/orgBasicProfile/getEcms"+action+".do"+"?organisationId="+organisationId;

		changeTabSelection($(this));
		setFrame(actionString);
	});

	$("#tabCategoryWorkcover li a").click(function() {
		var index = $(this).parent().index(),
		action = commonJs.removeString($(this).text(), [" ", "/", "&nbsp;"]),
		actionString = "/org/orgBasicInfo/orgBasicProfile/getWorkcover"+action+".do"+"?organisationId="+organisationId;

		changeTabSelection($(this));
		setFrame(actionString);
	});

	$("#tabCategoryPayrollTax li a").click(function() {
		var index = $(this).parent().index(),
		action = commonJs.removeString($(this).text(), [" ", "/", "&nbsp;"]),
		actionString = "/org/orgBasicInfo/orgBasicProfile/getPayrollTax"+action+".do"+"?organisationId="+organisationId;

		changeTabSelection($(this));
		setFrame(actionString);
	});

	$("#tabCategoryRateCard li a").click(function() {
		var index = $(this).parent().index(),
		action = commonJs.removeString($(this).text(), [" ", "/", "&nbsp;"]),
		actionString = "/org/orgBasicInfo/orgBasicProfile/getRateCard"+action+".do"+"?organisationId="+organisationId;

		changeTabSelection($(this));
		setFrame(actionString);
	});

	/*!
	 * process
	 */
	setIframeSize = function() {
		$("#ifFrame").css("height", $("#divScrollablePanel").height());
	};

	changeTabSelection = function(object) {
		var $parentUl = $(object).closest("ul");
		var $parentLi = $(object).closest("li");

		if ($parentLi.attr("class").indexOf("disabled") != -1) {return;}

		$parentUl.find("li").each(function(index) {
			var thisSelected = $(this).has($(object)).length;

			if (thisSelected <= 0) {
				if ($(this).attr("class").indexOf("disabled") != -1) {
				} else {
					$(this).removeClass("active");
				}
			}

			if (thisSelected > 0) {
				if ($(this).attr("class").indexOf("disabled") != -1) {
				} else {
					$(this).addClass("active");
				}
			}
		});
	};

	showSubTabs = function(parentTabName) {
		if (parentTabName == "ECMS") {
			$("#divTabAreaEcms").stop().animate({opacity:"show"}, jsconfig.get("effectDuration"));
			$("#tabCategoryEcms li:eq(0) a").trigger("click");
		} else if (parentTabName == "Workcover") {
			$("#divTabAreaWorkcover").stop().animate({opacity:"show"}, jsconfig.get("effectDuration"));
			$("#tabCategoryWorkcover li:eq(0) a").trigger("click");
		} else if (parentTabName == "PayrollTax") {
			$("#divTabAreaPayrollTax").stop().animate({opacity:"show"}, jsconfig.get("effectDuration"));
			$("#tabCategoryPayrollTax li:eq(0) a").trigger("click");
		} else if (parentTabName == "RateCard") {
			$("#divTabAreaRateCard").stop().animate({opacity:"show"}, jsconfig.get("effectDuration"));
			$("#tabCategoryRateCard li:eq(0) a").trigger("click");
		}
	};

	hideSubTabs = function(parentTabName) {
		if (parentTabName == "OrganisationDetail") {
			$("#divTabAreaEcms").stop().animate({opacity:"hide"}, jsconfig.get("effectDuration"));
			$("#divTabAreaWorkcover").stop().animate({opacity:"hide"}, jsconfig.get("effectDuration"));
			$("#divTabAreaPayrollTax").stop().animate({opacity:"hide"}, jsconfig.get("effectDuration"));
			$("#divTabAreaRateCard").stop().animate({opacity:"hide"}, jsconfig.get("effectDuration"));
		}
	};

	setFrame = function(actionString) {
		$("#ifFrame").attr("src", "");
		setTimeout(function() {
			$("#ifFrame").attr("src", actionString);
		}, 30); // important

		$("#divFrame").stop().animate({opacity:"hide"}, jsconfig.get("effectDuration"));
		setTimeout(function() {
			$("#divFrame").stop().animate({opacity:"show"}, jsconfig.get("effectDuration"));
		}, 100);
	};

	/*!
	 * load event (document / window)
	 */
	$(window).load(function() {
		setIframeSize();
		$("#tabCategoryOrganisationDetail li:eq(0) a").trigger("click");
	});
});