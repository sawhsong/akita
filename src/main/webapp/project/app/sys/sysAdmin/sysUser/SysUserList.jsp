<%/************************************************************************************************
* Description - SysUser - User
*	- Generated by Source Generator
************************************************************************************************/%>
<%@ include file="/shared/page/incCommon.jsp"%>
<%/************************************************************************************************
* Declare objects & variables
************************************************************************************************/%>
<%
	ParamEntity pe = (ParamEntity)request.getAttribute("paramEntity");
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
			<ui:button id="btnNew" caption="button.com.new"/>
			<ui:button id="btnDelete" caption="button.com.delete"/>
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
			<col width="10%"/>
			<col width="23%"/>
			<col width="10%"/>
			<col width="23%"/>
			<col width="10%"/>
			<col width="*"/>
		</colgroup>
		<tr>
			<th class="thSearch rt">User Name</th>
			<td class="tdSearch"><ui:text name="userName"/></td>
			<th class="thSearch rt">Login Id</th>
			<td class="tdSearch"><ui:text name="loginId"/></td>
			<th class="thSearch rt">Authority Group</th>
			<td class="tdSearch"><ui:select name="authGroup" hasCaption="true"> </ui:select></td>
		</tr>
		<tr>
			<th class="thSearch rt">User Type</th>
			<td class="tdSearch"><ui:ccselect name="userType" codeType="USER_TYPE" caption="==Select=="/></td>
			<th class="thSearch rt">User Status</th>
			<td class="tdSearch"><ui:ccselect name="userStatus" codeType="USER_STATUS" caption="==Select=="/></td>
			<th class="thSearch rt">Is Active</th>
			<td class="tdSearch"><ui:ccselect name="isActive" codeType="IS_ACTIVE" caption="==Select=="/></td>
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
	<table id="tblGrid" class="tblGrid sort autosort">
		<colgroup>
			<col width="2%"/>
			<col width="2%"/>
			<col width="11%"/>
			<col width="11%"/>
			<col width="20%"/>
			<col width="8%"/>
			<col width="8%"/>
			<col width="*"/>
			<col width="5%"/>
			<col width="7%"/>
		</colgroup>
		<thead>
			<tr>
				<th class="thGrid"><ui:icon useFor="actionHeaderGrid"/></th>
				<th class="thGrid"><ui:icon id="icnCheck" useFor="checkGrid"/></th>
				<th class="thGrid sortable:alphanumeric">User Name</th>
				<th class="thGrid sortable:alphanumeric">Login Id</th>
				<th class="thGrid sortable:alphanumeric">Authority Group</th>
				<th class="thGrid sortable:alphanumeric">User Type</th>
				<th class="thGrid sortable:alphanumeric">User Status</th>
				<th class="thGrid">Email</th>
				<th class="thGrid">Is Active</th>
				<th class="thGrid sortable:date">Updated Date</th>
			</tr>
		</thead>
		<tbody id="tblGridBody">
			<tr>
				<td class="tdGrid Ct" colspan="10"><mc:msg key="I002"/></td>
			</tr>
		</tbody>
	</table>
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