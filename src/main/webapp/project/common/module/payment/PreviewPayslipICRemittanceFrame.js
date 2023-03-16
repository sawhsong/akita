/**************************************************************************************************
 * Framework Generated Javascript Source
 * - PreviewPayslipICRemittanceFrame.js
 *************************************************************************************************/
$(function() {
	/*!
	 * event
	 */

	/*!
	 * process
	 */
	getBankDetails = function() {
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

	getICRemittanceEarnings = function() {
		commonJs.showProcMessageOnElement("divEarning");

		commonJs.doSimpleProcess({
			url:"/common/payment/getICRemittanceEarnings.do",
			noForm:true,
			data:{paymentId:paymentId},
			callback:function(result) {
				var ds = result.dataSet;
				setTimeout(function() {
					renderICRemittanceEarningsGridTable(ds);
				}, 500);
			}
		});
	};
	renderICRemittanceEarningsGridTable = function(ds) {
		var html = "";

		$("#tbodyEarning").html("");

		if (ds.getRowCnt() > 0) {
			var name = commonJs.nvl(ds.getValue(0, "ALTERNATE_NAME"), ds.getValue(0, "ELEMENT_REPORTING_NAME"));
			var gridTr = new UiGridTr();
			var units = commonJs.getNumberMask(commonJs.toNumber(ds.getValue(0, "UNITS")) == 0 ? "1" : ds.getValue(0, "UNITS"), "#,##0.00");
			var rate = commonJs.getNumberMask(ds.getValue(0, "RATE"), "#,##0.00");

			gridTr.addChild(new UiGridTd().addClassName("Lt").setText(name));
			gridTr.addChild(new UiGridTd().addClassName("Ct").setText(rate+" x "+units));
			gridTr.addChild(new UiGridTd().addClassName("Rt").setText(commonJs.getNumberMask(ds.getValue(0, "CALCULATED_AMOUNT"), "#,##0.00")));

			html += gridTr.addClassName("noStripe").toHtmlString();
		} else {
			var gridTr = new UiGridTr();

			gridTr.addClassName("noStripe").addChild(new UiGridTd().addClassName("Ct").setAttribute("colspan:3").setText(com.message.I001));
			html += gridTr.toHtmlString();
		}

		$("#tbodyEarning").append($(html));

		commonJs.hideProcMessageOnElement("divEarning");
	};

	getICRemittanceValues = function() {
		commonJs.showProcMessageOnElement("divICRemittanceValues");

		commonJs.doSimpleProcess({
			url:"/common/payment/getICRemittanceValues.do",
			noForm:true,
			data:{paymentId:paymentId},
			callback:function(result) {
				var ds = result.dataSet;
				setTimeout(function() {
					renderICRemittanceValues(ds);
				}, 500);
			}
		});
	};
	renderICRemittanceValues = function(ds) {
		$("#tdSubTotal").html(commonJs.getNumberMask(ds.getValue(0, "SubTotal"), "#,##0.00"));
		$("#tdGST").html(commonJs.getNumberMask(ds.getValue(0, "GST"), "#,##0.00"));
		$("#tdTotal").html(commonJs.getNumberMask(ds.getValue(0, "Total"), "#,##0.00"));

		commonJs.hideProcMessageOnElement("divICRemittanceValues");
	};

	/*
	 * ! load event (document / window)
	 */
	$(window).load(function() {
		setTimeout(function() {
			getBankDetails();
			getICRemittanceEarnings();
			getICRemittanceValues();
		}, 100);
	});
});