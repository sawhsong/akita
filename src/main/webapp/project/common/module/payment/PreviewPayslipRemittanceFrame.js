/**************************************************************************************************
 * Framework Generated Javascript Source
 * - PreviewPayslipRemittanceFrame.js
 *************************************************************************************************/
$(function() {
	/*!
	 * event
	 */

	/*!
	 * process
	 */
	getEarnings = function() {
		if (isConsultingRevenue == "Y") {
			commonJs.showProcMessageOnElement("divEarning");

			commonJs.doSimpleProcess({
				url:"/common/payment/getEarnings.do",
				noForm:true,
				data:{paymentId:paymentId},
				callback:function(result) {
					var ds = result.dataSet;
					setTimeout(function() {
						renderEarningGridTable(ds);
					}, 500);
				}
			});
		} else {
			$("divEarning").hide();
		}
	};
	renderEarningGridTable = function(ds) {
		var html = "";

		$("#tbodyEarning").html("");

		if (ds.getRowCnt() > 0) {
			var name = commonJs.nvl(ds.getValue(0, "ALTERNATE_NAME"), ds.getValue(0, "ELEMENT_REPORTING_NAME"));
			var gridTr = new UiGridTr();

			gridTr.addChild(new UiGridTd().addClassName("Lt").setText(name));
			gridTr.addChild(new UiGridTd().addClassName("Rt").setText(commonJs.getNumberMask(ds.getValue(0, "UNITS"), "#,##0.00")));
			gridTr.addChild(new UiGridTd().addClassName("Rt").setText(commonJs.getNumberMask(ds.getValue(0, "RATE"), "#,##0.00")));
			gridTr.addChild(new UiGridTd().addClassName("Rt").setText(commonJs.getNumberMask(ds.getValue(0, "CALCULATED_AMOUNT"), "#,##0.00")));

			html += gridTr.addClassName("noStripe").toHtmlString();
		} else {
			var gridTr = new UiGridTr();

			gridTr.addClassName("noStripe").addChild(new UiGridTd().addClassName("Ct").setAttribute("colspan:4").setText(com.message.I001));
			html += gridTr.toHtmlString();
		}

		$("#tbodyEarning").append($(html));

		commonJs.hideProcMessageOnElement("divEarning");
	};

	getDeductions = function() {
		if (isDeduction == "Y") {
			commonJs.showProcMessageOnElement("divDeduction");

			commonJs.doSimpleProcess({
				url:"/common/payment/getDeductions.do",
				noForm:true,
				data:{
					personId:personId,
					paymentId:paymentId,
					paymentDate:paymentDate
				},
				callback:function(result) {
					var ds = result.dataSet;
					setTimeout(function() {
						renderDeductionGridTable(ds);
					}, 500);
				}
			});
		} else {
			$("divDeduction").hide();
		}
	};
	renderDeductionGridTable = function(ds) {
		var html = "";

		$("#tbodyDeduction").html("");

		if (ds.getRowCnt() > 0) {
			for (var i=0; i<ds.getRowCnt(); i++) {
				var name = commonJs.nvl(ds.getValue(i, "ALTERNATE_NAME"), ds.getValue(i, "ELEMENT_REPORTING_NAME"));
				var gridTr = new UiGridTr();

				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(name));
				gridTr.addChild(new UiGridTd().addClassName("Rt").setText(commonJs.getNumberMask(ds.getValue(i, "CALCULATED_AMOUNT"), "#,##0.00")));
				gridTr.addChild(new UiGridTd().addClassName("Rt").setText(commonJs.getNumberMask(ds.getValue(i, "YTD_VALUE"), "#,##0.00")));

				html += gridTr.addClassName("noStripe").toHtmlString();
			}
		} else {
			var gridTr = new UiGridTr();

			gridTr.addClassName("noStripe").addChild(new UiGridTd().addClassName("Ct").setAttribute("colspan:3").setText(com.message.I001));
			html += gridTr.toHtmlString();
		}

		$("#tbodyDeduction").append($(html));

		commonJs.hideProcMessageOnElement("divDeduction");
	};

	getPayAdvice = function() {
		if (isDeduction == "Y") {
			commonJs.showProcMessageOnElement("divPayAdvice");

			commonJs.doSimpleProcess({
				url:"/common/payment/getPayAdvice.do",
				noForm:true,
				data:{
					personId:personId,
					paymentId:paymentId,
					paymentDate:paymentDate
				},
				callback:function(result) {
					var ds = result.dataSet;
					setTimeout(function() {
						renderPayAdviceGridTable(ds);
					}, 500);
				}
			});
		} else {
			$("divPayAdvice").hide();
		}
	};
	renderPayAdviceGridTable = function(ds) {
		var html = "";

		$("#tbodyPayAdvice").html("");

		if (ds.getRowCnt() > 0) {
			for (var i=0; i<ds.getRowCnt(); i++) {
				var gridTr = new UiGridTr();

				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "PAY_ADVICE_NAME")));
				gridTr.addChild(new UiGridTd().addClassName("Rt").setText(commonJs.getNumberMask(ds.getValue(i, "THIS_PERIOD"), "#,##0.00")));
				gridTr.addChild(new UiGridTd().addClassName("Rt").setText(commonJs.getNumberMask(ds.getValue(i, "YTD"), "#,##0.00")));

				html += gridTr.addClassName("noStripe").toHtmlString();
			}
		} else {
			var gridTr = new UiGridTr();

			gridTr.addClassName("noStripe").addChild(new UiGridTd().addClassName("Ct").setAttribute("colspan:3").setText(com.message.I001));
			html += gridTr.toHtmlString();
		}

		$("#tbodyPayAdvice").append($(html));

		commonJs.hideProcMessageOnElement("divPayAdvice");
	};

	getPaymentType = function() {
		if (isDeduction == "Y") {
			commonJs.showProcMessageOnElement("divPaymentType");

			commonJs.doSimpleProcess({
				url:"/common/payment/getPaymentType.do",
				noForm:true,
				data:{
					personId:personId,
					paymentId:paymentId,
					paymentDate:paymentDate
				},
				callback:function(result) {
					var ds = result.dataSet;
					setTimeout(function() {
						renderPaymentTypeGridTable(ds);
					}, 500);
				}
			});
		} else {
			$("divPaymentType").hide();
		}
	};
	renderPaymentTypeGridTable = function(ds) {
		var html = "";

		$("#tbodyPaymentType").html("");

		if (ds.getRowCnt() > 0) {
			for (var i=0; i<ds.getRowCnt(); i++) {
				var gridTr = new UiGridTr();

				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "PAYMENT_TYPE_NAME")));
				gridTr.addChild(new UiGridTd().addClassName("Rt").setText(commonJs.getNumberMask(ds.getValue(i, "THIS_PERIOD"), "#,##0.00")));
				gridTr.addChild(new UiGridTd().addClassName("Rt").setText(commonJs.getNumberMask(ds.getValue(i, "YTD"), "#,##0.00")));

				html += gridTr.addClassName("noStripe").toHtmlString();
			}
		} else {
			var gridTr = new UiGridTr();

			gridTr.addClassName("noStripe").addChild(new UiGridTd().addClassName("Ct").setAttribute("colspan:3").setText(com.message.I001));
			html += gridTr.toHtmlString();
		}

		$("#tbodyPaymentType").append($(html));

		commonJs.hideProcMessageOnElement("divPaymentType");
	};

	getBankDetails = function() {
		if (isDeduction == "Y") {
			commonJs.showProcMessageOnElement("divBankDetail");

			commonJs.doSimpleProcess({
				url:"/common/payment/getBankDetails.do",
				noForm:true,
				data:{paymentId:paymentId},
				callback:function(result) {
					var ds = result.dataSet;
					setTimeout(function() {
						renderBankDetailsGridTable(ds);
					}, 500);
				}
			});
		} else {
			$("divBankDetail").hide();
		}
	};
	renderBankDetailsGridTable = function(ds) {
		var html = "";

		$("#tbodyBankDetail").html("");

		if (ds.getRowCnt() > 0) {
			for (var i=0; i<ds.getRowCnt(); i++) {
				var gridTr = new UiGridTr();

				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "BANK_NAME")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "BSB")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(ds.getValue(i, "ACCOUNT_NUMBER")));
				gridTr.addChild(new UiGridTd().addClassName("Rt").setText(commonJs.getNumberMask(ds.getValue(i, "AMOUNT"), "#,##0.00")));

				html += gridTr.addClassName("noStripe").toHtmlString();
			}
		} else {
			var gridTr = new UiGridTr();

			gridTr.addClassName("noStripe").addChild(new UiGridTd().addClassName("Ct").setAttribute("colspan:4").setText(com.message.I001));
			html += gridTr.toHtmlString();
		}

		$("#tbodyBankDetail").append($(html));

		commonJs.hideProcMessageOnElement("divBankDetail");
	};

	getLeaveAccruals = function() {
		if (isDeduction == "Y") {
			commonJs.showProcMessageOnElement("divLeaveAccrual");

			commonJs.doSimpleProcess({
				url:"/common/payment/getLeaveAccruals.do",
				noForm:true,
				data:{assignmentId:assignmentId},
				callback:function(result) {
					var ds = result.dataSet;
					setTimeout(function() {
						renderLeaveAccrualsGridTable(ds);
					}, 500);
				}
			});
		} else {
			$("divLeaveAccrual").hide();
		}
	};
	renderLeaveAccrualsGridTable = function(ds) {
		var html = "";

		$("#tbodyLeaveAccrual").html("");

		if (ds.getRowCnt() > 0) {
			for (var i=0; i<ds.getRowCnt(); i++) {
				var gridTr = new UiGridTr();

				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "DISPLAY_NAME")));
				gridTr.addChild(new UiGridTd().addClassName("Rt").setText(commonJs.getNumberMask(ds.getValue(i, "UNITS"), "#,##0.00")));

				html += gridTr.addClassName("noStripe").toHtmlString();
			}
		} else {
			var gridTr = new UiGridTr();

			gridTr.addClassName("noStripe").addChild(new UiGridTd().addClassName("Ct").setAttribute("colspan:2").setText(com.message.I001));
			html += gridTr.toHtmlString();
		}

		$("#tbodyLeaveAccrual").append($(html));

		commonJs.hideProcMessageOnElement("divLeaveAccrual");
	};

	/*
	 * ! load event (document / window)
	 */
	$(window).load(function() {
		commonJs.showProcMessage(com.message.loading);

		setTimeout(function() {
			getEarnings();
			getDeductions();
			getPayAdvice();
			getPaymentType();
			getBankDetails();
			getLeaveAccruals();

			commonJs.hideProcMessage();
		}, 100);
	});
});