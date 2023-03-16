/**************************************************************************************************
 * Framework Generated Javascript Source
 * - SysUserUpdatePop.js
 *************************************************************************************************/
$(function() {
	/*!
	 * event
	 */
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

	$("#btnSave").click(function(event) {
		var fileValue = $("#photoPath").val();

		if (commonJs.doValidate("fmDefault")) {
			if (!commonJs.isEmpty(fileValue)) {
				if (!commonJs.isUploadableImageFile($("#photoPath"), fileValue)) {
					return;
				}
			}

			commonJs.doSaveWithFileForPage({
				action:"/sys/sysAdmin/sysUser/exeUpdate.do"
			});
		}
	});

	$("#btnClose").click(function(event) {
		parent.popup.close();
	});

	$("#btnGetAuthenticationSecretKey").click(function(event) {
		if ("disabled" != $(this).attr("disabled")) {
			commonJs.doSearch({
				url:"/sys/sysAdmin/sysUser/getAuthenticationSecretKey.do",
				noForm:true,
				onSuccess:function(result) {
					var ds = result.dataSet;
					$("#authenticationSecretKey").val(ds.getValue(0, "authenticationSecretKey"));
				}
			});
		}
	});

	$(document).keypress(function(event) {
		if (event.which == 13) {
			var element = event.target;
		}
	});

	/*!
	 * process
	 */
	setAuthorityGroupSelectbox = function() {
		commonJs.doSearch({
			url:"/sys/sysAdmin/sysUser/getAuthorityGroup.do",
			noForm:true,
			onSuccess:function(result) {
				var ds = result.dataSet;
				for (var i=0; i<ds.getRowCnt(); i++) {
					$("#authGroup").append(commonJs.getUiSelectOption({
						value:ds.getValue(i, "GROUP_ID"),
						text:ds.getValue(i, "GROUP_NAME")
					}));
				}

				$("#authGroup").selectpicker("val", authGroupId);
				$("#authGroup").selectpicker("refresh");
			}
		});
	};

	setButtonStatus = function() {
		commonJs.doSearch({
			url:"/sys/sysAdmin/sysUser/hasAuthKey.do",
			noForm:true,
			data:{userId:$("#userId").val()},
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
		setAuthorityGroupSelectbox();
		setButtonStatus();
	});
});