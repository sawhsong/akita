<%/************************************************************************************************
* Description
* - Layout order(Normal page)
*	#divHeaderHolder
*	#divBodyHolder
*		#divBodyLeft
*		#divBodyCenter - Each 'Area' in Body Center must set this class('areaContainer') when it has its contents
*			#divFixedPanel
*				#divLocationPathArea
*				#divTabArea
*				#divButtonArea(Left & Right)
*				#divSearchCriteriaArea
*				#divInformArea
*				#breaker
*			#divScrollablePanel
*				#divDataArea
*				#divPagingArea
*		#divBodyRight
*	#divFooterHolder
************************************************************************************************/%>
<%@ include file="/shared/page/incCommon.jsp"%>
<%/************************************************************************************************
* Declare objects & variables
************************************************************************************************/%>
<%
	ParamEntity paramEntity = (ParamEntity)request.getAttribute("paramEntity");
	DataSet resultDataSet = (DataSet)paramEntity.getObject("resultDataSet");
%>
<%/************************************************************************************************
* HTML
************************************************************************************************/%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<link rel="icon" type="image/png" href="<mc:cp key="imgIcon"/>/faviconPerci.png">
<title><mc:msg key="main.system.title"/></title>
<%/************************************************************************************************
* Stylesheet & Javascript
************************************************************************************************/%>
<%@ include file="/shared/page/incCssJs.jsp"%>
<style type="text/css">
/* #divWrapper {padding:5px;} */
/* #hNotice.ui-state-default {background-color:#DFF0D8;padding-top:10px;padding-bottom:10px;} */
/* #hNotice.ui-accordion-header.ui-state-active {background:#DFF0D8;padding-top:10px;padding-bottom:10px;} */
/* #hFreeBoard.ui-state-default {background-color:#DFF0D8;padding-top:10px;padding-bottom:10px;} */
/* #hFreeBoard.ui-accordion-header.ui-state-active {background:#DFF0D8;padding-top:10px;padding-bottom:10px;} */
/* #hChart1.ui-state-default {background-color:#5BC0DE;padding-top:10px;padding-bottom:10px;color:#ffffff;} */
/* #hChart1.ui-accordion-header.ui-state-active {background:#5BC0DE;padding-top:10px;padding-bottom:10px;color:#ffffff;} */
/* #hChart2.ui-state-default {background-color:#5BC0DE;padding-top:10px;padding-bottom:10px;color:#ffffff;} */
/* #hChart2.ui-accordion-header.ui-state-active {background:#5BC0DE;padding-top:10px;padding-bottom:10px;color:#ffffff;} */
</style>
<script type="text/javascript" src="<mc:cp key="viewPageJsName"/>"></script>
<script type="text/javascript">
</script>
</head>
<%/************************************************************************************************
* Page & Header
************************************************************************************************/%>
<body>
<form id="fmDefault" name="fmDefault" method="post" action="">
<div id="divHeaderHolder" class="ui-layout-north"><%@ include file="/project/common/include/header.jsp"%></div>
<div id="divBodyHolder" class="ui-layout-center">
<div id="divBodyLeft" class="ui-layout-west"><%@ include file="/project/common/include/bodyLeft.jsp"%></div>
<div id="divBodyCenter" class="ui-layout-center">
<div id="divFixedPanel">
<div id="divLocationPathArea"><%@ include file="/project/common/include/bodyLocationPathArea.jsp"%></div>
<%/************************************************************************************************
* Real Contents - fixed panel(tab, button, search, information)
************************************************************************************************/%>
<div id="divTabArea"></div>
<div id="divButtonArea">
	<div id="divButtonAreaLeft"></div>
	<div id="divButtonAreaRight"></div>
</div>
<div id="divSearchCriteriaArea"></div>
<div id="divInformArea"></div>
<%/************************************************************************************************
* End of fixed panel
************************************************************************************************/%>
<div class="breaker"></div>
</div>
<div id="divScrollablePanel">
<%/************************************************************************************************
* Real Contents - scrollable panel(data, paging)
************************************************************************************************/%>
<div id="divDataArea" class="areaContainer">
<!-- 	<div id="divWrapper"> -->
		<div id="divLeft" class="accordion" style="width:50%;float:left">
			<div class="accordionGroup">
				<h3 id="hNotice">Notice
					<span id="spanHeaderNotice" style="float:right;">
						<ui:icon id="icnRefreshNotice" useFor="refresh" title="Refresh"/>
					</span>
				</h3>
				<div id="divNotice" class="accordionContents">
					<table id="tblGridNotice" class="tblGrid">
						<colgroup>
							<col width="*"/>
							<col width="15%"/>
							<col width="10%"/>
						</colgroup>
						<tbody id="tbodyGridNotice">
						</tbody>
					</table>
				</div>
			</div>
			<div class="accordionGroup">
				<h3 id="hChart1">Chart1
					<span id="spanHeaderChart1" style="float:right;">
						<ui:icon id="icnRefreshChart1" useFor="refresh" title="Refresh"/>
					</span>
				</h3>
				<div id="divChart1" class="accordionContents">
				</div>
			</div>
			<div class="accordionGroup">
				<h3 id="hABCNews">ABC News - JustIn
					<span id="spanHeaderABCNews" style="float:right;">
						<ui:icon id="icnRefreshABCNews" useFor="refresh" title="Refresh"/>
					</span>
				</h3>
				<div id="divABCNews" class="accordionContents" style="height:360px;">
					<table id="tblGridABCNews" class="tblGrid">
						<colgroup>
							<col width="*"/>
							<col width="20%"/>
						</colgroup>
						<tbody id="tbodyGridABCNews">
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div id="divRight" class="accordion" style="width:49%;float:right">
			<div class="accordionGroup">
				<h3 id="hFreeBoard">Free Board
					<span id="spanHeaderFreeBoard" style="float:right;">
						<ui:icon id="icnRefreshFreeBoard" useFor="refresh" title="Refresh"/>
					</span>
				</h3>
				<div id="divFreeBoard" class="accordionContents">
					<table id="tblGridFreeBoard" class="tblGrid">
						<colgroup>
							<col width="*"/>
							<col width="15%"/>
							<col width="10%"/>
						</colgroup>
						<tbody id="tbodyGridFreeBoard">
						</tbody>
					</table>
				</div>
			</div>
			<div class="accordionGroup">
				<h3 id="hChart2">Chart2
					<span id="spanHeaderChart2" style="float:right;">
						<ui:icon id="icnRefreshChart2" useFor="refresh" title="Refresh"/>
					</span>
				</h3>
				<div id="divChart2" class="accordionContents">
				</div>
			</div>
			<div class="accordionGroup">
				<h3 id="hNewsComAu">sbs.com.au - news
					<span id="spanHeaderSbsComAu" style="float:right;">
						<ui:icon id="icnRefreshSbsComAu" useFor="refresh" title="Refresh"/>
					</span>
				</h3>
				<div id="divSbsComAu" class="accordionContents" style="height:360px;">
					<table id="tblGridSbsComAu" class="tblGrid">
						<colgroup>
							<col width="*"/>
							<col width="20%"/>
						</colgroup>
						<tbody id="tbodyGridSbsComAu">
						</tbody>
					</table>
				</div>
			</div>
		</div>
<!-- 	</div> -->
</div>
<div id="divPagingArea"></div>
<%/************************************************************************************************
* Right & Footer
************************************************************************************************/%>
</div>
</div>
<div id="divBodyRight" class="ui-layout-east"><%@ include file="/project/common/include/bodyRight.jsp"%></div>
</div>
<div id="divFooterHolder" class="ui-layout-south"><%@ include file="/project/common/include/footer.jsp"%></div>
<%/************************************************************************************************
* Additional Elements
************************************************************************************************/%>
</form>
<%/************************************************************************************************
* Additional Form
************************************************************************************************/%>
<form id="fmHidden" name="fmHidden" method="post" action=""></form>
</body>
</html>