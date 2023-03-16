/**
 * ResetPasswordPop.js
 */
var popup = null;

$(function() {
	/*!
	 * event
	 */
	$(document).keypress(function(event) {
		if (event.which == 13) {
			var element = event.target;

			if ($(element).is("[name=loginId]") || $(element).is("[name=email]")) {
				doProcess();
			}
		}
	});

	$("#btnReset").click(function() {
		doProcess();
	});

	/*!
	 * process
	 */
	doProcess = function() {
		if (!commonJs.doValidate("fmDefault")) {
			return;
		}

		commonJs.doSimpleProcess({
			url:"/common/commonFunction/doResetPassword.do",
			onSuccess:function(result) {
				commonJs.openDialog({
					type:com.message.I000,
					contents:result.message,
					blind:true,
					buttons:[{
						caption:com.caption.ok,
						callback:function() {
							parent.popup.close();
						}
					}]
				});
			},
			onError:function(result) {
				commonJs.openDialog({
					type:com.message.E000,
					contents:result.message,
					blind:true,
					buttons:[{
						caption:com.caption.ok,
						callback:function() {
							parent.popup.close();
						}
					}]
				});
			}
		});
	};

	/*!
	 * load event (document / window)
	 */
	$(window).load(function() {
		$("[name=loginId]").focus();
	});
});