/**************************************************************************************************
 * Framework Generated Javascript Source
 * - SysUserUpdatePop.js
 *************************************************************************************************/
$(function() {
	/*!
	 * event
	 */
	$("#btnSave").click(function(event) {
		if (commonJs.doValidate("fmDefault")) {
			commonJs.confirm({
				contents:com.message.Q001,
				buttons:[{
					caption:com.caption.yes,
					callback:function() {
						parent.exeActionContextMenu({
							mode:mode,
							authGroupToUpdate:commonJs.getCheckedValueFromRadio("authGroupToUpdate"),
							userType:commonJs.getCheckedValueFromRadio("userType"),
							userStatus:commonJs.getCheckedValueFromRadio("userStatus"),
							activeStatus:commonJs.getCheckedValueFromRadio("activeStatus")
						});

						parent.popup.close();
					}
				}, {
					caption:com.caption.no,
					callback:function() {
					}
				}]
			});
		}
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
	setAuthorityGroupSelectbox = function() {
		commonJs.doSearch({
			url:"/sys/sysAdmin/sysUser/getAuthorityGroup.do",
			noForm:true,
			onSuccess:function(result) {
				var ds = result.dataSet;
				var html = "";

				for (var i=0; i<ds.getRowCnt(); i++) {
					var groupId = ds.getValue(i, "GROUP_ID"), groupName = ds.getValue(i, "GROUP_NAME"), isChecked = false;
					if (groupId == defaultAuthGroup) {
						isChecked = true;
					}
					html += commonJs.getUiRadio({name:"authGroupToUpdate", value:groupId, text:groupName, displayType:"block", isCustomised:true, isSelected:isChecked});
				}

				$("#tdAuthGroup").html(html);
			}
		});
	};

	showSectionByMode = function() {
		var divId = "";

		$("#divDataArea > div").each(function(index) {
			divId = "div"+mode;

			if ($(this).attr("id") == divId) {
				$(this).css("display", "block");
			} else {
				$(this).css("display", "none");
			}
		});
	};

	/*!
	 * load event (document / window)
	 */
	$(window).load(function() {
		setAuthorityGroupSelectbox();
		showSectionByMode();
	});
});