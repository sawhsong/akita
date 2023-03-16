/**
 * UserProfilePop.js
 */
var popup;

$(function() {
	/*!
	 * event
	 */
	$("#btnSave").click(function(event) {
		var fileValue = $("#filePhotoPath").val();

		if (commonJs.doValidate("fmDefault")) {
			if (!commonJs.isEmpty(fileValue)) {
				if (!commonJs.isUploadableImageFile($("#filePhotoPath"), fileValue)) {
					return;
				}
			}

			commonJs.doSaveWithFileForPage({
				action:"/common/commonFunction/doUpdateUserProfile.do"
			});
		}
	});

	$("#btnChangePassword").click(function(event) {
		popup = commonJs.openPopup( {
			popupId:"ChangePassword",
			url:"/common/commonFunction/getChangePassword.do",
			data:{
				loginId:$("#loginId").val()
			},
			header:"Change Password",
			blind:false,
			draggable:false,
			width:350,
			height:324
		});
	});

	$("#btnResetPassword").click(function(event) {
		popup = commonJs.openPopup( {
			popupId:"ResetPassword",
			url:"/common/commonFunction/getResetPassword.do",
			data:{
				loginId:$("#loginId").val(),
				email:$("#email").val()
			},
			header:"Reset Password",
			blind:false,
			draggable:false,
			width:350,
			height:266
		});
	});

	$("#btnClose").click(function(event) {
		parent.popupUserProfile.close();
	});

	$("#btnGetAuthenticationSecretKey").click(function(event) {
		if ("disabled" != $(this).attr("disabled")) {
			commonJs.doSearch({
				url:"/common/commonFunction/getAuthenticationSecretKey.do",
				noForm:true,
				onSuccess:function(result) {
					var ds = result.dataSet;
					$("#authenticationSecretKey").val(ds.getValue(0, "authenticationSecretKey"));
				}
			});
		}
	});

	/*!
	 * process
	 */
	setButtonStatus = function() {
		commonJs.doSearch({
			url:"/common/commonFunction/hasAuthKey.do",
			noForm:true,
			onSuccess:function(result) {
				var ds = result.dataSet;
				var hasAuthKey = commonJs.toBoolean(ds.getValue(0, "hasAuthKey"));

				if (hasAuthKey) {
					$("#authenticationSecretKey").removeClass("txtEn").addClass("txtDis").attr("readonly", true);
					$("#btnGetAuthenticationSecretKey").attr("disabled", true);
				}
			}
		});
	};

	/*!
	 * load event (document / window)
	 */
	$(window).load(function() {
		setButtonStatus();
	});
});