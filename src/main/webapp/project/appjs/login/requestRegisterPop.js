/**
 * requestRegisterPop.js
 */
var popup = null;

$(function() {
	/*!
	 * event
	 */
	$(document).keypress(function(event) {
		if (event.which == 13) {
		}
	});

	$("#btnRequest").click(function() {
		if (!commonJs.doValidate("fmDefault")) {
			return;
		}

		if ($("#password").val() != $("#passwordConfirm").val()) {
			commonJs.error(login.message.confirmPassword);
			return;
		}

		commonJs.doSimpleProcess({
			url:"/common/commonFunction/getPrivateKey.do",
			noForm:true,
			onSuccess:function(result) {
				var dataSet = result.dataSet, key = dataSet.getValue(0, "key"), parsedKey = CryptoJS.enc.Base64.parse(key);
				var encPass = "", encConfPass;

				encPass = CryptoJS.AES.encrypt($("#password").val(), parsedKey, {
					mode: CryptoJS.mode.ECB,
					padding: CryptoJS.pad.Pkcs7
				});

				encConfPass = CryptoJS.AES.encrypt($("#passwordConfirm").val(), parsedKey, {
					mode: CryptoJS.mode.ECB,
					padding: CryptoJS.pad.Pkcs7
				});

				$("#password").val(encPass);
				$("#passwordConfirm").val(encConfPass);

				doProcess();
			}
		});
	});

	/*!
	 * process
	 */
	doProcess = function() {
		commonJs.doSimpleProcess({
			url:"/login/exeRequestRegister.do",
			onSuccess:function(result) {
				popup = commonJs.openDialog({
					type:com.message.I000,
					contents:result.message,
					blind:true,
					width:300,
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
		$("[name=userName]").focus();
	});
});