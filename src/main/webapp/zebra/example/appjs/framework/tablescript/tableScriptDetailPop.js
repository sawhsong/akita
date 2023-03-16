/**
 * tableScriptDetailPop.js
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
			actionString = "/zebra/framework/tablescript/getUpdate.do";
		} else if (param.mode == "Delete") {
			actionString = "/zebra/framework/tablescript/exeDelete.do";
		}

		params = {
			form:"fmDefault",
			action:actionString,
			data:{
				mode:param.mode,
				fileName:fileName
			}
		};

		if (param.mode == "Delete") {
			commonJs.doDelete({
				url:params.action,
				data:{fileName:params.data.fileName},
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
		setTimeout(function() {
			$("#tblGrid").freezeHeader({
				attachTo:$("#divDataArea")
			});
		}, 500);
	});
});