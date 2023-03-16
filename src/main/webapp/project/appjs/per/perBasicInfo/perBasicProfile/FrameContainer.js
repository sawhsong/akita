/**************************************************************************************************
 * Framework Generated Javascript Source
 * - FrameContainer.js
 *************************************************************************************************/
var popup;

$(function() {
	/*!
	 * event
	 */
	$("#tabCategoryPersonDetail li a").click(function() {
		var index = $(this).parent().index(),
			action = commonJs.removeString($(this).text(), [" ", "/", "&nbsp;"]),
			actionString = "/per/perBasicInfo/perBasicProfile/get"+action+".do"+"?personId="+personId;

		hideSubTabs("PersonDetail");
		changeTabSelection($(this));

		if (action == "Document") {
			showSubTabs("Document");
			return;
		}

		if (action == "ECMS" || action == "EBO") {
			showSubTabs("EcmsEbo");
			return;
		}

		if (action == "Portal") {
			showSubTabs("Portal");
			return;
		}

		setFrame(actionString);
	});

	$("#tabCategoryDocument li a").click(function() {
		var index = $(this).parent().index(),
			action = commonJs.removeString($(this).text(), [" ", "/", "&nbsp;"]),
			actionString = "/per/perBasicInfo/perBasicProfile/getDocument"+action+".do"+"?personId="+personId;

		hideSubTabs("Document");
		changeTabSelection($(this));
		setFrame(actionString);
	});

	$("#tabCategoryEcmsEbo li a").click(function() {
		var index = $(this).parent().index(),
			action = commonJs.removeString($(this).text(), [" ", "/", "&nbsp;"]),
			actionString = "/per/perBasicInfo/perBasicProfile/get"+action+".do"+"?personId="+personId;

		hideSubTabs("EcmsEbo");
		changeTabSelection($(this));

		if (action == "Assignments") {
			showSubTabs("Assignments");
			return;
		}

		setFrame(actionString);
	});

	$("#tabCategoryAssignments li a").click(function() {
		var index = $(this).parent().index(),
			action = commonJs.removeString($(this).text(), [" ", "/", "&nbsp;"]),
			actionString = "/per/perBasicInfo/perBasicProfile/get"+action+".do"+"?personId="+personId+"&assignmentId="+assignmentId;

		assignmentId = "";

		hideSubTabs("Assignments");
		disableTabs("Assignments");
		changeTabSelection($(this));
		setFrame(actionString);
	});

	$("#tabCategoryPortal li a").click(function() {
		var index = $(this).parent().index(),
			action = commonJs.removeString($(this).text(), [" ", "/", "&nbsp;"]),
			actionString = "/per/perBasicInfo/perBasicProfile/get"+action+".do"+"?personId="+personId;

		hideSubTabs("Assignments");
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
		if (parentTabName == "Document") {
			$("#divTabAreaDocument").stop().animate({opacity:"show"}, jsconfig.get("effectDuration"));
			$("#tabCategoryDocument li:eq(0) a").trigger("click");
		} else if (parentTabName == "EcmsEbo") {
			$("#divTabAreaEcmsEbo").stop().animate({opacity:"show"}, jsconfig.get("effectDuration"));
			$("#tabCategoryEcmsEbo li:eq(0) a").trigger("click");
		} else if (parentTabName == "Portal") {
			$("#divTabAreaPortal").stop().animate({opacity:"show"}, jsconfig.get("effectDuration"));
			$("#tabCategoryPortal li:eq(0) a").trigger("click");
		} else if (parentTabName == "Assignments") {
			$("#divTabAreaAssignments").stop().animate({opacity:"show"}, jsconfig.get("effectDuration"));
			$("#tabCategoryAssignments li:eq(0) a").trigger("click");
		}
	};

	hideSubTabs = function(parentTabName) {
		if (parentTabName == "PersonDetail") {
			$("#divTabAreaDocument").stop().animate({opacity:"hide"}, jsconfig.get("effectDuration"));
			$("#divTabAreaEcmsEbo").stop().animate({opacity:"hide"}, jsconfig.get("effectDuration"));
			$("#divTabAreaPortal").stop().animate({opacity:"hide"}, jsconfig.get("effectDuration"));
			$("#divTabAreaAssignments").stop().animate({opacity:"hide"}, jsconfig.get("effectDuration"));
		} else if (parentTabName == "EcmsEbo") {
			$("#divTabAreaAssignments").stop().animate({opacity:"hide"}, jsconfig.get("effectDuration"));
		}
	};

	disableTabs = function(parentTabName) {
		if (parentTabName == "Assignments") {
			if (commonJs.isEmpty(assignmentId)) {
				$("#tabCategoryAssignments li").each(function(index) {
					if (index != 0) {
						$(this).removeClass("active").addClass("disabled").find("a").unbind("click");
					}
				});
			}
		}
	};

	enableTabs = function(parentTabName) {
		if (parentTabName == "Assignments") {
			if (!commonJs.isEmpty(assignmentId)) {
				$("#tabCategoryAssignments li").each(function(index) {
					if (index != 0) {
						$(this).removeClass("disabled").find("a").bind("click", bindClickAssignments);
					}
				});
			}
		}
	};

	bindClickAssignments = function() {
		var index = $(this).parent().index(),
		action = commonJs.removeString($(this).text(), [" ", "/", "&nbsp;"]),
		actionString = "/per/perBasicInfo/perBasicProfile/get"+action+".do"+"?personId="+personId+"&assignmentId="+assignmentId;

		hideSubTabs("Assignments");
		disableTabs("Assignments");
		changeTabSelection($(this));
		setFrame(actionString);
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

		if (commonJs.contains(actionString, "getAssignment.do")) {
			commonJs.showProcMessageOnElement("divFrame");
		}
	};

	/*!
	 * load event (document / window)
	 */
	$(window).load(function() {
		setIframeSize();
		$("#tabCategoryPersonDetail li:eq(0) a").trigger("click");
	});
});