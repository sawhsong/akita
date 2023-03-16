/**
 * domainDictionaryDetailPop.js
 */
$(function() {
	/*!
	 * event
	 */
	$("#btnEdit").click(function(event) {
		doProcessByButton({mode:"Update"});
	});

	$("#btnDelete").click(function(event) {
		doProcessByButton({mode:"Delete"});
	});

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
	doProcessByButton = function(param) {
		var actionString = "";
		var params = {};

		if (param.mode == "Update") {
			actionString = "/zebra/framework/domaindictionary/getUpdate.do";
		} else if (param.mode == "Delete") {
			actionString = "/zebra/framework/domaindictionary/exeDelete.do";
		}

		params = {
			form:"fmDefault",
			action:actionString,
			data:{
				mode:param.mode,
				domainId:domainId
			}
		};

		if (param.mode == "Update") {
			parent.popup.resizeTo(0, 84);
		}

		if (param.mode == "Delete") {
			commonJs.doDelete({
				url:"/zebra/framework/domaindictionary/exeDelete.do",
				data:{domainId:params.data.domainId},
				callback:function() {
					parent.popup.close();
					parent.doSearch();
				}
			});
		} else {
			commonJs.doSimpleProcessForPage(params);
		}
	};

	/*!
	 * load event (document / window)
	 */
	$(window).load(function() {
	});
});