/**************************************************************************************************
 * Framework Generated Javascript Source
 * - PreviewPayslipICRCTIFrame.js
 *************************************************************************************************/
$(function() {
	/*!
	 * event
	 */

	/*!
	 * process
	 */
	getICRCTITaxableSupplies = function() {
		commonJs.showProcMessageOnElement("divEarning");

		commonJs.doSimpleProcess({
			url:"/common/payment/getICRCTITaxableSupplies.do",
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
			var name = commonJs.nvl(ds.getValue(0, "ALTERNATE_NAME"), ds.getValue(0, "ELEMENT_REPORTING_NAME"));
			var gridTr = new UiGridTr();
			var units = commonJs.toNumber(ds.getValue(0, "UNITS")) == 0 ? "1" : ds.getValue(0, "UNITS");

			gridTr.addChild(new UiGridTd().addClassName("Lt").setText(name));
			gridTr.addChild(new UiGridTd().addClassName("Rt").setText(commonJs.getNumberMask(units, "#,##0.00")));
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

	getICRCTIValues = function() {
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
		$("#tdDeductions").html(commonJs.getNumberMask(ds.getValue(0, "Deduction"), "#,##0.00"));
		$("#tdSubTotal").html(commonJs.getNumberMask(ds.getValue(0, "SubTotal"), "#,##0.00"));
		$("#tdGST").html(commonJs.getNumberMask(ds.getValue(0, "GST"), "#,##0.00"));
		$("#tdTotal").html(commonJs.getNumberMask(ds.getValue(0, "Total"), "#,##0.00"));

		commonJs.hideProcMessageOnElement("divICRCTIValues");
	};

	/*
	 * ! load event (document / window)
	 */
	$(window).load(function() {
		setTimeout(function() {
			getICRCTITaxableSupplies();
			getICRCTIValues();
		}, 100);
	});
});