/**
 * commonCodeUpdatePop.js
 */
var delimiter = jsconfig.get("dataDelimiter");

$(function() {
	/*!
	 * event
	 */
	$("#btnSave").click(function(event) {
		$("#liDummy").find(":input").each(function(index) {
			$(this).removeAttr("mandatory");
			$(this).removeAttr("option");
		});

		if (!commonJs.doValidate("fmDefault")) {
			return;
		}

		$("#ulCommonCodeDetailHolder").find(".dummyDetail").each(function(groupIndex) {
			$(this).find(":input").each(function(index) {
				var id = $(this).attr("id"), name = $(this).attr("name");

				if (!commonJs.isEmpty(id)) {id = (id.indexOf(delimiter) != -1) ? id.substring(0, id.indexOf(delimiter)) : id;}
				else {id = "";}

				if (!commonJs.isEmpty(name)) {name = (name.indexOf(delimiter) != -1) ? name.substring(0, name.indexOf(delimiter)) : name;}
				else {name = "";}

				$(this).attr("id", id+delimiter+groupIndex).attr("name", name+delimiter+groupIndex);
			});
		});

		var detailLength = $("#ulCommonCodeDetailHolder .dummyDetail").length;
		commonJs.doSave({
			url:"/zebra/framework/commoncode/doSave.do",
			data:{detailLength:detailLength},
//			showPostMessage:false,
			callback:function() {
				parent.popup.close();
				parent.doSearch();
			}
		});
	});

	$("#btnClose").click(function(event) {
		parent.popup.close();
	});

	$("#btnAdd").click(function(event) {
		var elem = $("#liDummy").clone(), elemId = $(elem).attr("id");

		$(elem).css("display", "block").appendTo($("#ulCommonCodeDetailHolder"));

		$("#ulCommonCodeDetailHolder").find(".dummyDetail").each(function(groupIndex) {
			$(this).attr("index", groupIndex).attr("id", elemId+delimiter+groupIndex);

			$(this).find("i").each(function(index) {
				var id = $(this).attr("id"), id = (id.indexOf(delimiter) != -1) ? id.substring(0, id.indexOf(delimiter)) : id;
				$(this).attr("index", groupIndex).attr("id", id+delimiter+groupIndex);
			});

			$(this).find(".dragHandler").each(function(index) {
				var id = $(this).attr("id"), id = (id.indexOf(delimiter) != -1) ? id.substring(0, id.indexOf(delimiter)) : id;
				$(this).attr("index", groupIndex).attr("id", id+delimiter+groupIndex);
			});

			$(this).find(".deleteButton").each(function(index) {
				var id = $(this).attr("id"), id = (id.indexOf(delimiter) != -1) ? id.substring(0, id.indexOf(delimiter)) : id;
				$(this).attr("index", groupIndex).attr("id", id+delimiter+groupIndex);
			});

			$(this).find("input").each(function(index) {
				var id = $(this).attr("id"), name = $(this).attr("name");

				if (!commonJs.isEmpty(id)) {id = (id.indexOf(delimiter) != -1) ? id.substring(0, id.indexOf(delimiter)) : id;}
				else {id = "";}

				if (!commonJs.isEmpty(name)) {name = (name.indexOf(delimiter) != -1) ? name.substring(0, name.indexOf(delimiter)) : name;}
				else {name = "";}

				$(this).attr("id", id+delimiter+groupIndex).attr("name", name+delimiter+groupIndex);

				if (groupIndex == ($("#ulCommonCodeDetailHolder .dummyDetail").length - 1)) {
					if (name.indexOf("isActiveDetail") != -1) {
						if ($(this).val() == "Y") {$(this).prop("checked", true);}
					}

					if (name.indexOf("sortOrderDetail") != -1) {
						$(this).val(commonJs.lpad((groupIndex+1), 3, "0"));
					}
				}
			});
		});

		$("#tblGrid").freezeHeader({
			attachTo:$("#divDataArea")
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
	setSortable = function() {
		$("#ulCommonCodeDetailHolder").sortable({
			axis:"y",
			handle:".dragHandler",
			stop:function() {
				$("#ulCommonCodeDetailHolder").find(".dummyDetail").each(function(groupIndex) {
					$(this).find("input").each(function(index) {
						var id = $(this).attr("id"), name = $(this).attr("name");

						$(this).attr("id", id+delimiter+groupIndex).attr("name", name+delimiter+groupIndex);

						if (name.indexOf("sortOrderDetail") != -1) {
							$(this).val(commonJs.lpad((groupIndex+1), 3, "0"));
						}
					});
				});
			}
		});

		$("#ulCommonCodeDetailHolder").disableSelection();
	};

	setMasterData = function() {
		if (commonJs.isNotBlank(codeType)) {
			commonJs.showProcMessageOnElement("divInformArea");

			commonJs.doSimpleProcess({
				url:"/zebra/framework/commoncode/getMasterData.do",
				data:{codeType:codeType},
				onSuccess:function(result) {
					var dataSet = result.dataSet, masterRow = dataSet.getRowIndex("COMMON_CODE", "0000000000");

					$("[name=codeTypeMaster]").val(dataSet.getValue(masterRow, "CODE_TYPE"));
					$("[name=codeMeaningMaster]").val(dataSet.getValue(masterRow, "CODE_MEANING"));
					commonJs.setCheckboxValue("isActiveMaster", dataSet.getValue(masterRow, "IS_ACTIVE"));
					$("[name=descriptionMaster]").val(dataSet.getValue(masterRow, "DESCRIPTION_EN"));
				}
			});

			setTimeout(() => commonJs.hideProcMessageOnElement("divInformArea"), 400);
		} else {
			commonJs.enableObject($("[name=codeTypeMaster]"));
		}
	};

	setDetailData = function() {
		if (commonJs.isNotBlank(codeType)) {
			commonJs.showProcMessageOnElement("divScrollablePanelPopup");

			commonJs.doSimpleProcess({
				url:"/zebra/framework/commoncode/getDetailData.do",
				data:{codeType:codeType},
				onSuccess:function(result) {
					var dataSet = result.dataSet, masterRow = dataSet.getRowIndex("COMMON_CODE", "0000000000");

					for (var i=0; i<dataSet.getRowCnt(); i++) {
						var rowIdx = 0;

						if (i == masterRow) {continue;}

						$("#btnAdd").trigger("click");
						rowIdx = delimiter+(i-1);

						$("[name=commonCodeDetail"+rowIdx+"]").val(dataSet.getValue(i, "COMMON_CODE"));
						$("[name=codeMeaningDetail"+rowIdx+"]").val(dataSet.getValue(i, "CODE_MEANING"));
						commonJs.setCheckboxValue("isActiveDetail"+rowIdx, dataSet.getValue(i, "IS_ACTIVE"));
						$("[name=descriptionDetail"+rowIdx+"]").val(dataSet.getValue(i, "DESCRIPTION_EN"));
						$("[name=sortOrderDetail"+rowIdx+"]").val(dataSet.getValue(i, "SORT_ORDER"));
					}
				}
			});

			setTimeout(() => commonJs.hideProcMessageOnElement("divScrollablePanelPopup"), 400);
		}
	};

	/*!
	 * load event (document / window)
	 */
	$(document).click(function(event) {
		var obj = event.target;

		if ($(obj).hasClass("deleteButton") || ($(obj).is("i") && $(obj).parent("th").hasClass("deleteButton"))) {
			$("#ulCommonCodeDetailHolder").find(".dummyDetail").each(function(index) {
				if ($(this).attr("index") == $(obj).attr("index")) {
					$(this).remove();

					$("#tblGrid").freezeHeader({
						attachTo:$("#divDataArea")
					});
				}
			});

			$("#ulCommonCodeDetailHolder").find(".dummyDetail").each(function(groupIndex) {
				$(this).find("input[type=text]").each(function(index) {
					var name = $(this).attr("name");
					if (name.indexOf("sortOrderDetail") != -1) {
						$(this).val(commonJs.lpad((groupIndex+1), 3, "0"));
					}
				});
			});
		}
	});

	$(window).load(function() {
		setSortable();

		$("#tblGrid").freezeHeader({
			attachTo:$("#divDataArea")
		});

		setTimeout(function() {
			setMasterData();
			setDetailData();
		}, 200);
	});
});