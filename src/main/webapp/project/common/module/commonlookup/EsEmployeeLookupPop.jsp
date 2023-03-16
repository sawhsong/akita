<%/************************************************************************************************
* Description - ES Employee Lookup
************************************************************************************************/%>
<%@ include file="/shared/page/incCommon.jsp"%>
<%/************************************************************************************************
* Declare objects & variables
************************************************************************************************/%>
<%
	ParamEntity paramEntity = (ParamEntity)request.getAttribute("paramEntity");
	DataSet requestDataSet = (DataSet)paramEntity.getRequestDataSet();
	String keyFieldId = requestDataSet.getValue("keyFieldId");
	String valueFieldId = requestDataSet.getValue("valueFieldId");
	String docTypeToSetValue = requestDataSet.getValue("docTypeToSetValue");
	String popupName = requestDataSet.getValue("popupName");
	String lookupValue = requestDataSet.getValue("lookupValue");
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
<script type="text/javascript" src="<mc:cp key="commonModuleViewPageJsName"/>"></script>
<script type="text/javascript">
var keyFieldId = "<%=keyFieldId%>";
var valueFieldId = "<%=valueFieldId%>";
var popupObject = eval("<%=popupName%>");
var docTypeToSetValue = "<%=docTypeToSetValue%>";
var lookupValue = "<%=lookupValue%>";
</script>
</head>
<%/************************************************************************************************
* Page & Header
************************************************************************************************/%>
<body>
<form id="fmDefault" name="fmDefault" method="post" action="">
<div id="divPopupWindowHolder">
<div id="divFixedPanelPopup">
<div id="divLocationPathArea"><%@ include file="/project/common/include/bodyLocationPathArea.jsp"%></div>
<%/************************************************************************************************
* Real Contents - fixed panel(tab, button, search, information)
************************************************************************************************/%>
<div id="divTabArea"></div>
<div id="divButtonArea" class="areaContainerPopup">
	<div id="divButtonAreaLeft"></div>
	<div id="divButtonAreaRight">
		<ui:buttonGroup id="buttonGroup">
			<ui:button id="btnSearch" caption="button.com.search" iconClass="fa-search"/>
			<ui:button id="btnClear" caption="button.com.clear" iconClass="fa-refresh"/>
			<ui:button id="btnClose" caption="button.com.close" iconClass="fa-times"/>
		</ui:buttonGroup>
	</div>
</div>
<div id="divSearchCriteriaArea" class="areaContainerPopup">
	<table class="tblSearch">
		<caption><mc:msg key="page.com.searchCriteria"/></caption>
		<colgroup>
			<col width="50%"/>
			<col width="50%"/>
		</colgroup>
		<tr>
			<td class="tdSearch">
				<label for="personNumber" class="lblEn hor"><mc:msg key="esEmployeeLookup.search.personNumber"/></label>
				<ui:text name="personNumber" style="width:250px"/>
			</td>
			<td class="tdSearch">
				<label for="personName" class="lblEn hor"><mc:msg key="esEmployeeLookup.search.personName"/></label>
				<ui:text name="personName" style="width:250px"/>
			</td>
		</tr>
	</table>
</div>
<div id="divInformArea"></div>
<%/************************************************************************************************
* End of fixed panel
************************************************************************************************/%>
<div class="breaker"></div>
</div>
<div id="divScrollablePanelPopup">
<%/************************************************************************************************
* Real Contents - scrollable panel(data, paging)
************************************************************************************************/%>
<div id="divDataArea" class="areaContainerPopup">
	<table id="tblGrid" class="tblGrid sort">
		<colgroup>
			<col width="14%"/>
			<col width="35%"/>
			<col width="*"/>
		</colgroup>
		<thead>
			<tr>
				<th class="thGrid Ct"><mc:msg key="esEmployeeLookup.grid.personNumber"/></th>
				<th class="thGrid"><mc:msg key="esEmployeeLookup.grid.personName"/></th>
				<th class="thGrid"><mc:msg key="esEmployeeLookup.grid.title"/></th>
			</tr>
		</thead>
		<tbody id="tblGridBody">
			<tr>
				<td class="tdGrid Ct" colspan="3"><mc:msg key="I002"/></td>
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