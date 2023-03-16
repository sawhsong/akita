/**************************************************************************************************
 * Framework Generated Javascript Source
 * - PreviewPayslipSTRCTIFrame.js
 *************************************************************************************************/
$(function() {
	/*!
	 * event
	 */

	/*!
	 * process
	 */
	getSTRCTIEarnings = function() {
		commonJs.showProcMessageOnElement("divEarningRcti");

		commonJs.doSimpleProcess({
			url:"/common/payment/getICRCTITaxableSupplies.do",
			noForm:true,
			data:{paymentId:paymentId},
			callback:function(result) {
				var ds = result.dataSet;
				setTimeout(function() {
					renderEarningRctiGridTable(ds);
				}, 500);
			}
		});
	};
	renderEarningRctiGridTable = function(ds) {
		var html = "";

		$("#tbodyEarningRcti").html("");

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

		$("#tbodyEarningRcti").append($(html));

		commonJs.hideProcMessageOnElement("divEarningRcti");
	};

	getSTRCTIValues = function() {
		commonJs.showProcMessageOnElement("divValuesRcti");

		commonJs.doSimpleProcess({
			url:"/common/payment/getICRemittanceValues.do",
			noForm:true,
			data:{paymentId:paymentId},
			callback:function(result) {
				var ds = result.dataSet;
				setTimeout(function() {
					renderValuesRcti(ds);
				}, 500);
			}
		});
	};
	renderValuesRcti = function(ds) {
		var subTot = commonJs.toNumber(ds.getValue(0, "SubTotal")), gst = commonJs.toNumber(ds.getValue(0, "GST"));
		$("#tdSubTotalRcti").html(commonJs.getNumberMask(ds.getValue(0, "SubTotal"), "#,##0.00"));
		$("#tdGSTRcti").html(commonJs.getNumberMask(ds.getValue(0, "GST"), "#,##0.00"));
		$("#tdTotalRcti").html(commonJs.getNumberMask((subTot + gst), "#,##0.00"));

		commonJs.hideProcMessageOnElement("divValuesRcti");
	};

	getSTNRCTIBankDetails = function() {
		commonJs.showProcMessageOnElement("divBankDetailNRcti");

		commonJs.doSimpleProcess({
			url:"/common/payment/getBankDetails.do",
			noForm:true,
			data:{paymentId:paymentId},
			callback:function(result) {
				var ds = result.dataSet;
				setTimeout(function() {
					renderBankDetailNRctiGridTable(ds);
				}, 500);
			}
		});
	};
	renderBankDetailNRctiGridTable = function(ds) {
		var html = "";

		$("#tbodyBankDetailNRcti").html("");

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

		$("#tbodyBankDetailNRcti").append($(html));

		commonJs.hideProcMessageOnElement("divBankDetailNRcti");
	};

	getSTNRCTIEarnings = function() {
		commonJs.showProcMessageOnElement("divEarningNRcti");

		commonJs.doSimpleProcess({
			url:"/common/payment/getSTRemittanceEarnings.do",
			noForm:true,
			data:{paymentId:paymentId},
			callback:function(result) {
				var ds = result.dataSet;
				setTimeout(function() {
					renderEarningNRctiGridTable(ds);
				}, 500);
			}
		});
	};
	renderEarningNRctiGridTable = function(ds) {
		var html = "";

		$("#tbodyEarningNRcti").html("");

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

		$("#tbodyEarningNRcti").append($(html));

		commonJs.hideProcMessageOnElement("divEarningNRcti");
	};

	getSTNRCTIValues = function() {
		commonJs.showProcMessageOnElement("divValuesNRcti");

		commonJs.doSimpleProcess({
			url:"/common/payment/getSTRemittanceValues.do",
			noForm:true,
			data:{paymentId:paymentId},
			callback:function(result) {
				var ds = result.dataSet;
				setTimeout(function() {
					renderValuesNRcti(ds);
				}, 500);
			}
		});
	};
	renderValuesNRcti = function(ds) {
		$("#tdSubTotalNRcti").html(commonJs.getNumberMask(ds.getValue(0, "SubTotal"), "#,##0.00"));
		$("#tdGSTNRcti").html(commonJs.getNumberMask(ds.getValue(0, "GST") * -1, "#,##0.00"));
		$("#tdSuperNRcti").html(commonJs.getNumberMask(ds.getValue(0, "Superannuation") * -1, "#,##0.00"));
		$("#tdSuperSalSacNRcti").html(commonJs.getNumberMask(ds.getValue(0, "SuperSalSac") * -1, "#,##0.00"));
		$("#tdPAYGNRcti").html(commonJs.getNumberMask(ds.getValue(0, "PAYG") * -1, "#,##0.00"));
		$("#tdOtherTaxationNRcti").html(commonJs.getNumberMask(ds.getValue(0, "OtherTaxation") * -1, "#,##0.00"));
		$("#tdTotalNRcti").html(commonJs.getNumberMask(ds.getValue(0, "Total"), "#,##0.00"));

		commonJs.hideProcMessageOnElement("divValuesNRcti");
	};

	/*
	 * ! load event (document / window)
	 */
	$(window).load(function() {
		setTimeout(function() {
			getSTRCTIEarnings();
			getSTRCTIValues();
			getSTNRCTIBankDetails();
			getSTNRCTIEarnings();
			getSTNRCTIValues();
		}, 100);
	});
});