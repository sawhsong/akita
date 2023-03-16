/**************************************************************************************************
 * Framework Generated Javascript Source
 * - PreviewPayslipBCTIFrame.js
 *************************************************************************************************/
$(function() {
	/*!
	 * event
	 */

	/*!
	 * process
	 */
	getBCTITaxableSupplies = function() {
		commonJs.showProcMessageOnElement("divEarning");

		commonJs.doSimpleProcess({
			url:"/common/payment/getBCTITaxableSupplies.do",
			noForm:true,
			data:{paymentId:paymentId},
			callback:function(result) {
				var ds = result.dataSet;
				setTimeout(function() {
					renderEarningGridTable(ds);
				}, 500);
			}
		});
	};
	renderEarningGridTable = function(ds) {
		var html = "";

		$("#tbodyEarning").html("");

		if (ds.getRowCnt() > 0) {
			for (var i=0; i<ds.getRowCnt(); i++) {
				var name = commonJs.nvl(ds.getValue(i, "ALTERNATE_NAME"), ds.getValue(i, "ELEMENT_REPORTING_NAME"));
				var gridTr = new UiGridTr();
				var units = commonJs.toNumber(ds.getValue(i, "UNITS")) == 0 ? "1" : ds.getValue(i, "UNITS");

				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(name));
				gridTr.addChild(new UiGridTd().addClassName("Rt").setText(commonJs.getNumberMask(units, "#,##0.00")));
				gridTr.addChild(new UiGridTd().addClassName("Rt").setText(commonJs.getNumberMask(ds.getValue(i, "RATE"), "#,##0.00")));
				gridTr.addChild(new UiGridTd().addClassName("Rt").setText(commonJs.getNumberMask(ds.getValue(i, "CALCULATED_AMOUNT"), "#,##0.00")));

				html += gridTr.addClassName("noStripe").toHtmlString();
			}
		} else {
			var gridTr = new UiGridTr();

			gridTr.addClassName("noStripe").addChild(new UiGridTd().addClassName("Ct").setAttribute("colspan:4").setText(com.message.I001));
			html += gridTr.toHtmlString();
		}

		$("#tbodyEarning").append($(html));

		commonJs.hideProcMessageOnElement("divEarning");
	};

	getBCTIValues = function() {
		commonJs.showProcMessageOnElement("divICRCTIValues");

		commonJs.doSimpleProcess({
			url:"/common/payment/getICRCTIValues.do",
			noForm:true,
			data:{paymentId:paymentId},
			callback:function(result) {
				var ds = result.dataSet;
				setTimeout(function() {
					renderICRCTIValues(ds);
				}, 500);
			}
		});
	};
	renderICRCTIValues = function(ds) {
		$("#tdSubTotal").html(commonJs.getNumberMask(ds.getValue(0, "SubTotal"), "#,##0.00"));
		$("#tdGST").html(commonJs.getNumberMask(ds.getValue(0, "GST"), "#,##0.00"));
		$("#tdTotal").html(commonJs.getNumberMask(ds.getValue(0, "Total"), "#,##0.00"));

		commonJs.hideProcMessageOnElement("divICRCTIValues");
	};

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

	/*
	 * ! load event (document / window)
	 */
	$(window).load(function() {
		setTimeout(function() {
			getBCTITaxableSupplies();
			getBCTIValues();
			getBankDetails();
		}, 100);
	});
});