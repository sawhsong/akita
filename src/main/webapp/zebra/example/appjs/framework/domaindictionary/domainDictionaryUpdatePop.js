/**
 * domainDictionaryUpdatePop.js
 */
$(function() {
	/*!
	 * event
	 */
	$("#btnSave").click(function(event) {
		if (!commonJs.doValidate("fmDefault")) {
			return;
		}

		if ($("#dataType").val() == "VARCHAR2" && commonJs.isEmpty($("#dataLength").val())) {
			commonJs.openDialog({
				type:com.message.W000,
				contents:"Data Length" + com.message.mandatory,
				buttons:[{
					caption:com.caption.ok,
					callback:function() {
						commonJs.getBootstrapSelectbox("dataLength").addClass("error");
						return;
					}
				}]
			});

			return;
		}

		commonJs.doSave({
			url:"/zebra/framework/domaindictionary/exeUpdate.do",
			data:{
				domainId:domainId
			},
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
		parent.popup.setHeader(framework.header.popHeaderEdit);
	});
});