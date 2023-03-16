/**************************************************************************************************
 * Framework Generated Javascript Source
 * - SysAuthGroupEditPop.js
 *************************************************************************************************/
$(function() {
	/*!
	 * event
	 */
	$("#btnSave").click(function(event) {
		if (!commonJs.doValidate("fmDefault")) {
			return;
		}

		commonJs.doSave({
			url:"/sys/sysAdmin/sysAuthGroup/doSave.do",
			data:{groupId:groupId},
			onSuccess:function() {
				parent.popup.close();
				parent.doSearch();
			}
		});
	});

	$("#btnDelete").click(function(event) {
		if ($(this).attr("disabled")) {
			return;
		}

		doDelete();
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
	setButton = function() {
		if (commonJs.isBlank(groupId)) {
			commonJs.disableObject($("#btnDelete"));
		}
	};

	doDelete = function() {
		commonJs.doDelete({
			url:"/sys/sysAdmin/sysAuthGroup/doDelete.do",
			data:{groupId:groupId},
			onSuccess:function() {
				parent.popup.close();
				parent.doSearch();
			}
		});
	};

	setDetailData = function() {
		if (commonJs.isNotBlank(groupId)) {
			commonJs.doSimpleProcess({
				url:"/sys/sysAdmin/sysAuthGroup/getDetailData.do",
				data:{groupId:groupId},
				onSuccess:function(result) {
					var ds = result.dataSet;
					var sysAuthGroup = ds.getRowAsDto(0);

					$("[name=groupName]").val(sysAuthGroup.groupName);
					$("[name=description]").val(sysAuthGroup.description);
					commonJs.setRadioValue("isActive", sysAuthGroup.isActive);
				}
			});
		}

		setTimeout(() => commonJs.hideProcMessageOnElement("divScrollablePanelPopup"), 200);
	};

	/*!
	 * load event (document / window)
	 */
	$(window).load(function() {
		commonJs.showProcMessageOnElement("divScrollablePanelPopup");

		setTimeout(function() {
			setButton();
			setDetailData();
		}, 100);
	});
});