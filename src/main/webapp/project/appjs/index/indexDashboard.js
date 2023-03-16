/**
 * indexDashboard.js
 */
jsconfig.put("noWest", true);
jsconfig.put("scrollablePanelHeightAdjust", 14);

window.chartColors = {
	red:"rgb(255, 99, 132)",
	orange:"rgb(255, 159, 64)",
	yellow:"rgb(255, 205, 86)",
	green:"rgb(75, 192, 192)",
	blue:"rgb(54, 162, 235)",
	purple:"rgb(153, 102, 255)",
	grey:"rgb(201, 203, 207)"
};

(function(global) {
	var MONTHS = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
	var COLORS = ["#4dc9f6", "#f67019", "#f53794", "#537bc4", "#acc236", "#166a8f", "#00a950", "#58595b", "#8549ba"];
	var Samples = global.Samples || (global.Samples = {});
	var Color = global.Color;

	Samples.utils = {
		srand: function(seed) {
			this._seed = seed;
		},

		rand: function(min, max) {
			var seed = this._seed;
			min = min === undefined ? 0 : min;
			max = max === undefined ? 1 : max;
			this._seed = (seed * 9301 + 49297) % 233280;
			return min + (this._seed / 233280) * (max - min);
		},

		numbers: function(config) {
			var cfg = config || {};
			var min = cfg.min || 0;
			var max = cfg.max || 1;
			var from = cfg.from || [];
			var count = cfg.count || 8;
			var decimals = cfg.decimals || 8;
			var continuity = cfg.continuity || 1;
			var dfactor = Math.pow(10, decimals) || 0;
			var data = [];
			var i, value;

			for (i = 0; i < count; ++i) {
				value = (from[i] || 0) + this.rand(min, max);
				if (this.rand() <= continuity) {
					data.push(Math.round(dfactor * value) / dfactor);
				} else {
					data.push(null);
				}
			}

			return data;
		},

		labels: function(config) {
			var cfg = config || {};
			var min = cfg.min || 0;
			var max = cfg.max || 100;
			var count = cfg.count || 8;
			var step = (max - min) / count;
			var decimals = cfg.decimals || 8;
			var dfactor = Math.pow(10, decimals) || 0;
			var prefix = cfg.prefix || "";
			var values = [];
			var i;

			for (i = min; i < max; i += step) {
				values.push(prefix + Math.round(dfactor * i) / dfactor);
			}

			return values;
		},

		months: function(config) {
			var cfg = config || {};
			var count = cfg.count || 12;
			var section = cfg.section;
			var values = [];
			var i, value;

			for (i = 0; i < count; ++i) {
				value = MONTHS[Math.ceil(i) % 12];
				values.push(value.substring(0, section));
			}

			return values;
		},

		color: function(index) {
			return COLORS[index % COLORS.length];
		},

		transparentize: function(color, opacity) {
			var alpha = opacity === undefined ? 0.5 : 1 - opacity;
			return Color(color).alpha(alpha).rgbString();
		}
	};

	window.randomScalingFactor = function() {
		return Math.round(Samples.utils.rand(-100, 100));
	};

	Samples.utils.srand(Date.now());
}(this));

var chartData = {
	labels: ["January", "February", "March", "April", "May", "June", "July"],
	datasets: [{
		type: "line",
		label: "Dataset 1",
		borderColor: window.chartColors.blue,
		borderWidth: 2,
		fill: false,
		data: [
			randomScalingFactor(),
			randomScalingFactor(),
			randomScalingFactor(),
			randomScalingFactor(),
			randomScalingFactor(),
			randomScalingFactor(),
			randomScalingFactor()
		]
	}, {
		type: "bar",
		label: "Dataset 2",
		backgroundColor: window.chartColors.red,
		data: [
			randomScalingFactor(),
			randomScalingFactor(),
			randomScalingFactor(),
			randomScalingFactor(),
			randomScalingFactor(),
			randomScalingFactor(),
			randomScalingFactor()
		]
	}, {
		type: "bar",
		label: "Dataset 3",
		backgroundColor: window.chartColors.green,
		data: [
			randomScalingFactor(),
			randomScalingFactor(),
			randomScalingFactor(),
			randomScalingFactor(),
			randomScalingFactor(),
			randomScalingFactor(),
			randomScalingFactor()
		]
	}]
};

var randomScalingFactor = function() {
	return Math.round(Math.random() * 100);
};

var config = {
	type: 'pie',
	data: {
		datasets: [{
			data: [
				randomScalingFactor(),
				randomScalingFactor(),
				randomScalingFactor(),
				randomScalingFactor(),
				randomScalingFactor(),
			],
			backgroundColor: [
				window.chartColors.red,
				window.chartColors.orange,
				window.chartColors.yellow,
				window.chartColors.green,
				window.chartColors.blue,
			],
			label: 'Dataset 1'
		}],
		labels: [
			'Red',
			'Orange',
			'Yellow',
			'Green',
			'Blue'
		]
	},
	options: {
		responsive: true
	}
};

$(function() {
	/*!
	 * event
	 */
	$("h3 span .icnEn").click(function(event) {
		var id = $(this).attr("id");

		if (id == "icnRefreshABCNews") {loadAbcNewsFeed();}
		if (id == "icnRefreshNotice") {doSearchNotice();}
		if (id == "icnRefreshChart1") {loadChart1();}
		if (id == "icnRefreshSbsComAu") {loadSbsComAuFeed();}
		if (id == "icnRefreshFreeBoard") {doSearchFreeBoard();}
		if (id == "icnRefreshChart2") {loadChart2();}

		event.preventDefault();
		event.stopPropagation();
	});

	/*!
	 * process
	 */
	goDetail = function(type, id) {
		if (type == "Notice") {
			goMenu("BBS", "Bulletin Board", "#", "BBS0202", "Announcement", "/bbs/0202/getDefault.do");
		} else if (type == "FreeBoard") {
			goMenu("BBS", "Bulletin Board", "#", "BBS0204", "Free Board", "/bbs/0204/getDefault.do");
		}
	};

	goMenu = function(headerMenuId, headerMenuName, headerMenuUrl, leftMenuId, leftMenuName, leftMenuUrl) {
		$("#hdnHeaderMenuId").val(headerMenuId);
		$("#hdnHeaderMenuName").val(headerMenuName);
		$("#hdnHeaderMenuUrl").val(headerMenuUrl);
		$("#hdnLeftMenuId").val(leftMenuId);
		$("#hdnLeftMenuName").val(leftMenuName);
		$("#hdnLeftMenuUrl").val(leftMenuUrl);

		commonJs.doSubmit({form:$("form:eq(0)"), action:leftMenuUrl});
	};

	openNewsArticle = function(linkUrl) {
		var win = window.open(linkUrl, "_blank");
		win.focus();
	};

	doSearchNotice = function() {
		commonJs.showProcMessageOnElement("divNotice");
		commonJs.doSearch({
			url:"/index/getNoticeList.do",
			callback:function(result) {
				var ds = result.dataSet;
				var html = "";

				$("#tbodyGridNotice").html("");

				if (ds.getRowCnt() > 0) {
					for (var i=0; i<ds.getRowCnt(); i++) {
						var gridTr = new UiGridTr();

						gridTr.setClassName("noBorderAll");

						gridTr.addChild(new UiGridTd().addClassName("Lt").addChild(new UiAnchor().setText(ds.getValue(i, "ARTICLE_SUBJECT")).setScript("goDetail('Notice', '"+ds.getValue(i, "ARTICLE_ID")+"')")));
						gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "WRITER_NAME")));
						gridTr.addChild(new UiGridTd().addClassName("Rt").setText(commonJs.nvl(ds.getValue(i, "UPDATE_DATE"), ds.getValue(i, "INSERT_DATE"))));

						html += gridTr.toHtmlString();
					}
				} else {
					var gridTr = new UiGridTr();

					gridTr.setClassName("noBorderAll noStripe");

					gridTr.addChild(new UiGridTd().addClassName("Ct").setAttribute("colspan:3").setText(com.message.I001));
					html += gridTr.toHtmlString();
				}

				$("#tbodyGridNotice").append($(html));

				commonJs.hideProcMessageOnElement("divNotice");
			}
		});
	};

	doSearchFreeBoard = function() {
		commonJs.showProcMessageOnElement("divFreeBoard");
		commonJs.doSearch({
			url:"/index/getFreeBoardList.do",
			callback:function(result) {
				var ds = result.dataSet;
				var html = "";

				$("#tbodyGridFreeBoard").html("");

				if (ds.getRowCnt() > 0) {
					for (var i=0; i<ds.getRowCnt(); i++) {
						var gridTr = new UiGridTr();

						gridTr.setClassName("noBorderAll");

						gridTr.addChild(new UiGridTd().addClassName("Lt").addChild(new UiAnchor().setText(ds.getValue(i, "ARTICLE_SUBJECT")).setScript("goDetail('FreeBoard', '"+ds.getValue(i, "ARTICLE_ID")+"')")));
						gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "WRITER_NAME")));
						gridTr.addChild(new UiGridTd().addClassName("Rt").setText(commonJs.nvl(ds.getValue(i, "UPDATE_DATE"), ds.getValue(i, "INSERT_DATE"))));

						html += gridTr.toHtmlString();
					}
				} else {
					var gridTr = new UiGridTr();

					gridTr.setClassName("noBorderAll noStripe");

					gridTr.addChild(new UiGridTd().addClassName("Ct").setAttribute("colspan:3").setText(com.message.I001));
					html += gridTr.toHtmlString();
				}

				$("#tbodyGridFreeBoard").append($(html));

				commonJs.hideProcMessageOnElement("divFreeBoard");
			}
		});
	};

	loadChart1 = function() {
		commonJs.showProcMessageOnElement("divChart1");

		$("#divChart1").html("");
		$("#divChart1").html("<canvas id=\"cvChart1\" style=\"width:100%;height:360px;\"></canvas>");

		setTimeout(function() {
			var ctx = $("#cvChart1")[0].getContext("2d");
			window.myMixedChart = new Chart(ctx, {
				type: "bar",
				data: chartData,
				options: {
					responsive: true,
					title: {
						display: true,
						text: "Combo Bar Line Chart"
					},
					tooltips: {
						mode: "index",
						intersect: true
					}
				}
			});

			commonJs.hideProcMessageOnElement("divChart1");
		}, 1000);
	};

	loadChart2 = function() {
		commonJs.showProcMessageOnElement("divChart2");

		$("#divChart2").html("");
		$("#divChart2").html("<canvas id=\"cvChart2\" style=\"width:100%;height:360px;\"></canvas>");

		setTimeout(function() {
			var ctx = $("#cvChart2")[0].getContext("2d");
			window.myPie = new Chart(ctx, config);

			commonJs.hideProcMessageOnElement("divChart2");
		}, 1000);
	};

	loadAbcNewsFeed = function() {
		commonJs.showProcMessageOnElement("divABCNews");
		commonJs.doSearch({
			url:"/common/feed/getRssAbcJustin.do",
			noForm:true,
			data:{
				url:"https://www.abc.net.au/news/feed/51120/rss.xml",
				countOfRows:10
			},
			onSuccess:function(result) {
				var ds = result.dataSet;
				var html = "";

				$("#tbodyGridABCNews").html("");

				for (var i=0; i<ds.getRowCnt(); i++) {
					var gridTr = new UiGridTr();

					gridTr.setClassName("noBorderVer noStripe");

					gridTr.addChild(new UiGridTd().addClassName("Lt noEllipsis").addChild(new UiAnchor().setText(ds.getValue(i, "header")).setScript("openNewsArticle('"+ds.getValue(i, "link")+"')").setStyle("font-weight:bold;font-size:1.2em;vertical-align:top"))
																				.addTextAfterChild("<br/><br/>"+ds.getValue(i, "contents")+"<br/><br/>"+ds.getValue(i, "date")));
					gridTr.addChild(new UiGridTd().addClassName("Rt noEllipsis").addChild(new UiImage().setSrc(ds.getValue(i, "img")).setStyle("width:100%;height:80px;border-radius:8px;").setScript("openNewsArticle('"+ds.getValue(i, "link")+"')"))).setStyle("vertical-align:top;")

					html += gridTr.toHtmlString();
				}

				$("#tbodyGridABCNews").append(html);

				commonJs.hideProcMessageOnElement("divABCNews");
			}
		});
	};

	loadSbsComAuFeed = function() {
		commonJs.showProcMessageOnElement("divSbsComAu");
		commonJs.doSearch({
			url:"/common/feed/getRssSbsComAuNews.do",
			noForm:true,
			data:{
				url:"https://www.sbs.com.au/news/feed",
				countOfRows:10
			},
			onSuccess:function(result) {
				var ds = result.dataSet;
				var html = "";

				$("#tbodyGridSbsComAu").html("");

				for (var i=0; i<ds.getRowCnt(); i++) {
					var gridTr = new UiGridTr();

					gridTr.setClassName("noBorderVer noStripe");

					gridTr.addChild(new UiGridTd().addClassName("Lt noEllipsis").addChild(new UiAnchor().setText(ds.getValue(i, "header")).setScript("openNewsArticle('"+ds.getValue(i, "link")+"')").setStyle("font-weight:bold;font-size:1.2em;vertical-align:top;"))
																				.addTextAfterChild("<br/><br/>"+ds.getValue(i, "contents")+"<br/><br/>"+ds.getValue(i, "date")));
					gridTr.addChild(new UiGridTd().addClassName("Rt noEllipsis").addChild(new UiImage().setSrc(ds.getValue(i, "img")).setStyle("width:100%;height:80px;border-radius:8px;").setScript("openNewsArticle('"+ds.getValue(i, "link")+"')")).setStyle("vertical-align:top;"))

					html += gridTr.toHtmlString();
				}

				$("#tbodyGridSbsComAu").html(html);

				commonJs.hideProcMessageOnElement("divSbsComAu");
			}
		});
	};

	/*!
	 * load event (document / window)
	 */
	$(window).load(function() {
		commonJs.setAccordion({
			containerClass:"accordion",
			multipleExpand:true,
			expandAll:true
		});

		loadAbcNewsFeed();
		loadSbsComAuFeed();
		doSearchNotice();
		doSearchFreeBoard();
		loadChart1();
		loadChart2();
	});
});