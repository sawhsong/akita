<%/************************************************************************************************
* Description - SysItSupportAssignment - Assignment
*	- Generated by Source Generator
************************************************************************************************/%>
<%@ include file="/shared/page/incCommon.jsp"%>
<%/************************************************************************************************
* Declare objects & variables
************************************************************************************************/%>
<%
	ParamEntity paramEntity = (ParamEntity)request.getAttribute("paramEntity");
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
<div id="divButtonArea" class="areaContainer">
	<div id="divButtonAreaLeft"></div>
	<div id="divButtonAreaRight">
		<ui:buttonGroup id="buttonGroup">
			<ui:button id="btnAction" caption="button.com.action"/>
			<ui:button id="btnSearch" caption="button.com.search"/>
			<ui:button id="btnClear" caption="button.com.clear"/>
			<ui:button id="btnExport" caption="button.com.export"/>
		</ui:buttonGroup>
	</div>
</div>
<div id="divSearchCriteriaArea" class="areaContainer">
	<table class="tblSearch">
		<caption><mc:msg key="page.com.searchCriteria"/></caption>
		<colgroup>
			<col width="7%"/>
			<col width="10%"/>
			<col width="6%"/>
			<col width="18%"/>
			<col width="7%"/>
			<col width="18%"/>
			<col width="10%"/>
			<col width="*"/>
		</colgroup>
		<tr>
			<th class="thSearch rt">Assignment Id</th>
			<td class="tdSearch"><ui:text name="asgId"/></td>
			<th class="thSearch rt">Person</th>
			<td class="tdSearch"><ui:hidden name="personId"/><ui:text name="personName"/></td>
			<th class="thSearch rt">Billing Code</th>
			<td class="tdSearch"><ui:hidden name="billingCodeId"/><ui:text name="billingCode"/></td>
			<th class="thSearch rt">Billing Organisation</th>
			<td class="tdSearch"><ui:hidden name="billingOrgId"/><ui:text name="billingOrgName"/></td>
		</tr>
	</table>
</div>
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
	<div id="divGridWrapper">
		<table id="tblGrid" class="tblGrid sort autosort" style="width:2500px;">
			<colgroup>
				<col width="2%"/>
				<col width="10%"/>
				<col width="12%"/>
				<col width="3%"/>
				<col width="3%"/>
				<col width="4%"/>
				<col width="4%"/>
				<col width="4%"/>
				<col width="5%"/>
				<col width="5%"/>
				<col width="*"/>
				<col width="14%"/>
				<col width="3%"/>
				<col width="4%"/>
				<col width="8%"/>
			</colgroup>
			<thead>
				<tr>
					<th class="thGrid"><ui:icon id="icnCheck" useFor="checkGrid"/></th>
					<th class="thGrid sortable:alphanumeric">Assignment Number</th>
					<th class="thGrid sortable:alphanumeric">Person Name</th>
					<th class="thGrid">Has PRT</th>
					<th class="thGrid">Has WC</th>
					<th class="thGrid caution">Last Invoiced</th>
					<th class="thGrid caution">Last Paid</th>
					<th class="thGrid">Working State</th>
					<th class="thGrid sortable:date">Asg Start Date</th>
					<th class="thGrid sortable:date">Asg End Date</th>
					<th class="thGrid sortable:alphanumeric">Billing Organisation</th>
					<th class="thGrid sortable:alphanumeric">End User Organisation</th>
					<th class="thGrid">Is Active</th>
					<th class="thGrid">Is Perferred</th>
					<th class="thGrid">Payment Method</th>
				</tr>
			</thead>
			<tbody id="tblGridBody">
				<tr>
					<td class="tdGrid Ct" colspan="15"><mc:msg key="I002"/></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<div id="divPagingArea" class="areaContainer"></div>
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