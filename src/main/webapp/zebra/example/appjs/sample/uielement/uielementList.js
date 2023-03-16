/**
 * uielementList.js
 */
var popup1, popup2, cal;

$(function() {
	jsconfig.put("customFileObject", "N");

	$("#btnAddFileSelection").click(function(event) {
		commonJs.addFileSelectObject({
			appendToId:"divAttachedFile",
			rowBreak:false
		});
	});

	$("#btnPopupWindowExample1").click(function() {
		popup1 = commonJs.openPopup({
			popupId:"PopupWindowExample",
			effect:"fade",
			oncloseCallback:function() {
//				alert("oncloseCallback");
			},
			width:"60%",
			height:900
		});
	});

	$("#icnFromDate").click(function(event) {
		commonJs.openCalendar(event, "txtFromDate", {
			weekNumber:false
		});
	});

	$("#icnToDate").click(function(event) {
		var options = {
			displayTime:true,
			statusBar:true,
			weekNumber:true,
			effect:"fade",
			returnBoxes:[{time:"txtToTime"}, {DoW:"txtToDay"}, {Week:"txtToWeek"}],
			oncloseCallback:function() {doCloseCalendar();}
		};
		commonJs.openCalendar(event, "txtToDate", options);
	});

	doCloseCalendar = function() {
//		alert("doCloseCalendar");
	};

	$("#btnPopupDialogExample1").click(function() {
		popup1 = commonJs.openDialog({
			type:"Confirm",
			contents:"Are you sure to save the data?\nAre you sure to save the data?\nAre you sure to save the data?\nAre you sure to save the data?\nAre you sure to save the data?\nAre you sure to save the data?\n",
			effect:"fade",
//			heightAdjust:1,
			buttons:[{
				caption:com.caption.yes,
				callback:function() {
					alert("Yes clicked.");
				}
			}, {
				caption:com.caption.no,
				callback:function() {
//					alert("No clicked.");
				}
			}],
			blind:true
		});
	});

	$("#btnPrintLog").click(function() {
		commonJs.printLog({message:"This is a Log Test."});
		commonJs.printLog({message:"btnTypeButton has been clicked."});
	});

	$("#btnTestEmail").click(function() {
		testEmail();
	});

	testEmail = function() {
		commonJs.ajaxSubmit({
			url:"/zebra/sample/uielement/testEmail.do",
			dataType:"json",
			formId:"fmDefault",
			success:function(data, textStatus) {
				var result = commonJs.parseAjaxResult(data, textStatus, "json");

				if (result.isSuccess == true || result.isSuccess == "true") {
					commonJs.openDialog({
						type:com.message.I000,
						contents:result.dataSet.toString(),
						blind:true,
						buttons:[{
							caption:com.caption.ok,
							callback:function() {
							}
						}]
					});
				} else {
					commonJs.error(result.message);
				}
			}
		});
	};

	$("#icnJQueryDatePicker").click(function(event) {
//		commonJs.openCalendar(event, "fromDate");
		$("#txtJQueryDatePicker").datepicker("show");
	});

	var menu = [{
		name : "Context Menu 1",
		img:"fa-list-alt",
		fun : function() {alert("Context Menu 1");}
	}, {
		name:"Context Menu 1 - 1 Disabled",
		disable:true
	}, {
		name : "Context Menu 2",
		img:"fa-edit",
		subMenu : [ {
			name : "Context Menu 2 - Sub Menu 1",
			img:"fa-gears",
			fun : function() {
				alert("Context Menu 2 - Sub Menu 1")
			}
		}, {
			name : "Context Menu 2 - Sub Menu 2",
			img:"fa-gears",
			subMenu : [ {
				name : "Context Menu 2 - Sub Menu 2 - Sub 1",
				img:"fa-file-pdf-o",
				fun : function() {
					alert("Context Menu 2 - Sub Menu 2 - Sub 1");
				}
			}, {
				name : "Context Menu 2 - Sub Menu 2 - Sub 2",
				img:"fa-file-pdf-o",
				fun : function() {
					alert("Context Menu 2 - Sub Menu 2 - Sub 2");
				}
			} ]
		} ]
	}, {
		name : "Context Menu 3",
		img:"fa-edit",
		subMenu : [ {
			name : "Context Menu 3 - Sub Menu 1",
			img:"fa-gears",
			fun : function() {
				alert("Context Menu 3 - Sub Menu 1");
			}
		}, {
			name : "Context Menu 3 - Sub Menu 2",
			img:"fa-gears",
			fun : function() {
				alert("Context Menu 3 - Sub Menu 2");
			}
		} ]
	}];

	$(window).load(function() {
		var spinner = $( "#txtSpinner" ).spinner();

		commonJs.changeTabSelection($("#tabCategory li:eq(1) a"));

		$("#tblFixedHeaderTable2").freezeHeader({
			attachTo:$("#divDataGrid"),
			attachToHeight:300,
			pagingArea:$("#divPagingArea"),
			isPageable:false,
			isFilter:false,
			filterColumn:[1, 2, 3],
			script:"doSearch"
		});

		commonJs.setAccordion({
			containerClass:"accordionFormElements",
			expandAll:false,
//			active:4
		});

		commonJs.setAccordion({
			containerClass:"accordionMiscellaneous",
			expandAll:false,
			active:0,
			multipleExpand:false,
			activate:function(event, ui) {
				var currHeader, currContent;

				if (ui.newHeader[0]) {
					currHeader = ui.newHeader;
					currContent = currHeader.next(".ui-accordion-content");
				} else {
					currHeader = ui.oldHeader;
					currContent = currHeader.next(".ui-accordion-content");
				}

//				commonJs.alert($(currHeader).prop("innerText"));
			}
		});

		$.nony.fileElement.modifyFileSelectObject($("#fileModified"));

		commonJs.setFieldDateMask("txtFromDate");
		commonJs.setFieldDateMask("txtToDate");

		$("#txtJQueryDatePicker").datepicker({
			numberOfMonths:3,
			shwAnim:"fadeIn",
			dateFormat:"dd-mm-yy",
			onSelect:function(date, obj) {
				alert(date);
				alert($(obj).attr("id"));
			}
		});

		$("#divJQueryInlineDatePicker").datepicker({
			numberOfMonths:3,
			dateFormat:"dd-mm-yy",
			onSelect:function(date, obj) {
				alert(date);
				alert($(obj).attr("id"));
			}
		});

		$("#slider").imageSlider({
			width:1000,
			height:500,
			autoSlide:false,
			arrowTheme:1,
			thumbnail:true
		});

		$("#btnAnchor").contextMenu(menu, {
			classPrefix:"iw",
			borderRadius : "3px",
			displayAround : "trigger",
			position : "bottom",
			horAdjust : 0,
			verAdjust : 0
		});

		$("#btnCtxIw").contextMenu(menu, {
			classPrefix:"iw",
			borderRadius : "3px",
			displayAround : "trigger",
			position : "bottom",
			horAdjust : 0,
			verAdjust : 0
		});

		$("#btnCtxActionButton").contextMenu(menu, {
			classPrefix:"actionButton",
			borderRadius : "3px",
			displayAround : "trigger",
			position : "bottom",
			horAdjust : 0,
			verAdjust : 0
		});

		$("#btnCtxActionInGrid").contextMenu(menu, {
			classPrefix:"actionInGrid",
			borderRadius : "3px",
			displayAround : "trigger",
			position : "bottom",
			horAdjust : 0,
			verAdjust : 0
		});

		$("#btnCtxTheme").contextMenu(menu, {
			classPrefix:"theme",
			borderRadius : "3px",
			displayAround : "trigger",
			position : "bottom",
			horAdjust : 0,
			verAdjust : 0
		});

		$("#btnCtxHeader").contextMenu(menu, {
			classPrefix:"header",
			borderRadius : "3px",
			displayAround : "trigger",
			position : "bottom",
			horAdjust : 0,
			verAdjust : 0
		});

		$("#tdRadioFromJs").html(commonJs.getUiRadio({
			name:"radioFromJs",
			value:"1",
			text:"Group Name",
			displayType:"block",
			isCustomised:true
		}));
	});

//	$(function() {
//		$("[name=chkCustomBlock]").change(function() {}).trigger("change");
//		$("[name=chkCustomInline]").change(function() {}).trigger("change");
//		$("[name=rdoCustomBlock]").change(function() {}).trigger("change");
//		$("[name=rdoCustomInline]").change(function() {}).trigger("change");
//	});

	$("#btnGetCustomCheckboxValue").click(function() {
		var checkValue = "";
		$("[name=chkCustomInline]").each(function(index) {
			if ($(this).is(":checked")) {
				checkValue += (commonJs.isEmpty(checkValue)) ? $(this).val() : ", "+$(this).val();
			}
		});
		alert(checkValue);
	});

	$("#btnGetCustomRadioValue").click(function() {
		var checkValue = "";
		$("[name=rdoCustomInline]").each(function(index) {
			if ($(this).is(":checked")) {
				checkValue += (commonJs.isEmpty(checkValue)) ? $(this).val() : ", "+$(this).val();
			}
		});
		alert(checkValue);
	});
});