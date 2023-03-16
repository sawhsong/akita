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
		}
	});

	$("#btnSave").click(function() {
		if (!commonJs.doValidate("fmDefault")) {
			return;
		}

		commonJs.doSimpleProcess({
			url:"/common/commonFunction/getPrivateKey.do",
			noForm:true,
			onSuccess:function(result) {
				var dataSet = result.dataSet, key = dataSet.getValue(0, "key"), parsedKey = CryptoJS.enc.Base64.parse(key);
				var encOldPass = "", encNewPass, encConfPass;

				encOldPass = CryptoJS.AES.encrypt($("#oldPassword").val(), parsedKey, {
					mode: CryptoJS.mode.ECB,
					padding: CryptoJS.pad.Pkcs7
				});

				encNewPass = CryptoJS.AES.encrypt($("#newPassword").val(), parsedKey, {
					mode: CryptoJS.mode.ECB,
					padding: CryptoJS.pad.Pkcs7
				});

				encConfPass = CryptoJS.AES.encrypt($("#confirmPassword").val(), parsedKey, {
					mode: CryptoJS.mode.ECB,
					padding: CryptoJS.pad.Pkcs7
				});

				$("#oldPassword").val(encOldPass);
				$("#newPassword").val(encNewPass);
				$("#confirmPassword").val(encConfPass);

				doChangePassword();
			}
		});
	});

	/*!
	 * process
	 */
	doChangePassword = function() {
		commonJs.doSave({
			url:"/common/commonFunction/doChangePassword.do",
			data:{loginId:loginId},
			onSuccess:function(result) {
				parent.popup.close();
				parent.parent.commonJs.doSubmit({form:$("form:eq(0)"), action:"/login/logout.do"});
			}
		});
	};

	/*!
	 * load event (document / window)
	 */
	$(window).load(function() {
		$("[name=oldPassword]").focus();
	});
});