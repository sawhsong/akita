/**************************************************************************************************
 * Framework Generated Javascript Source
 * - SysPerciSourceGeneratorInfoPop.js
 *************************************************************************************************/
$(function() {
	/*!
	 * event
	 */
	$("#btnClose").click(function(event) {
		parent.popupInfo.close();
	});

	$("#btnGenerate").click(function(event) {
		if (!commonJs.doValidate("fmDefault")) {
			return;
		}

		commonJs.confirm({
			contents:com.message.Q901,
			width:300,
			height:150,
			buttons:[{
				caption:com.caption.yes,
				callback:function() {
					exeGenerate($("#fmDefault").serializeArray());
				}
			}, {
				caption:com.caption.no,
				callback:function() {
				}
			}]
		});
	});

	$(document).keypress(function(event) {
		if (event.which == 13) {
			var element = event.target;
		}
	});

	/*!
	 * process
	 */
	exeGenerate = function(paramDataArray) {
		var paramData = {};
		$.each(paramDataArray, function(i, param) {
			paramData[param.name] = param.value;
		});
		paramData.dataSource = dataSource;

		popupProcess = parent.commonJs.openPopup({
			popupId:"ProcessInformation",
			header:"Process Result",
			width:600,
			height:400,
			blind:false,
			onLoad:function() {
				parent.$("input[name=chkForGenerate]:checked").each(function(index) {
					var $this = $(this);

					setTimeout(function() {
						paramData.tableName = $this.val();

						commonJs.ajaxSubmit({
							url:"/sys/sysItSupport/sysPerciSourceGenerator/exeGenerate.do",
							dataType:"json",
							data:paramData,
							blind:false,
							success:function(data, textStatus) {
								var result = commonJs.parseAjaxResult(data, textStatus, "json");

								if (commonJs.toBoolean(result.isSuccess)) {
									popupProcess.addContents(com.message.I802+" : "+paramData.tableName);

									if ((index+1) == parent.commonJs.getCountChecked("chkForGenerate")) {
										parent.commonJs.openDialog({
											type:com.message.I000,
											contents:com.message.I801,
											modal:true,
											width:300,
											buttons:[{
												caption:com.caption.ok, callback:function() {
													try {
														parent.popupInfo.close();
														popupProcess.close();
													} catch(ex) {
													}
												}
											}]
										});
									}
								} else {
									popupProcess.addContents(com.message.E801+" : "+paramData.tableName);
									popupProcess.addContents("[Error Message : "+data.message+"]");
								}
							}
						});
					}, index * 100);
				});
			}
		});
	};

	/*!
	 * load event (document / window)
	 */
	$(window).load(function() {
	});
});