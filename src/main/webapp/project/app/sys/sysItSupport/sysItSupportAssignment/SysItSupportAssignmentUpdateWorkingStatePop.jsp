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
	DataSet requestDataSet = (DataSet)paramEntity.getRequestDataSet();
	DataSet asgDataSet = (DataSet)paramEntity.getObject("assignmentDataSet");
	String mode = requestDataSet.getValue("mode");
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
var mode = "<%=mode%>";
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
			<ui:button id="btnEdit" caption="button.com.save"/>
			<ui:button id="btnClose" caption="button.com.close"/>
		</ui:buttonGroup>
	</div>
</div>
<div id="divSearchCriteriaArea"></div>
<div id="divInformArea" class="areaContainerPopup">
	<table class="tblInform">
		<colgroup>
			<col width="19%"/>
			<col width="*"/>
		</colgroup>
		<tbody>
		<tr>
			<th class="thInform Rt">Update Working State To</th>
			<td class="tdInform"><ui:ccselect name="workingStateTo" codeType="STATES"/></td>
		</tr>
		</tbody>
	</table>
</div>
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
	<table id="tblGrid" class="tblGrid sort autosort">
		<colgroup>
				<col width="4%"/>
				<col width="11%"/>
				<col width="*"/>
				<col width="14%"/>
				<col width="12%"/>
				<col width="21%"/>
				<col width="9%"/>
			</colgroup>
		<thead id="tblGridHead">
			<tr>
				<th class="thGrid"><ui:icon id="icnCheck" useFor="checkGrid"/></th>
				<th class="thGrid">Assignment Id</th>
				<th class="thGrid">Assignment Number</th>
				<th class="thGrid">Last Invoice Date</th>
				<th class="thGrid">Last Paid Date</th>
				<th class="thGrid">Working State</th>
				<th class="thGrid">Is Active</th>
			</tr>
		</thead>
		<tbody id="tblGridBody">
<%
		if (asgDataSet.getRowCnt() > 0) {
			for (int i=0; i<asgDataSet.getRowCnt(); i++) {
%>
			<tr>
				<td class="tdGrid Ct"><input type="checkbox" name="chkForAction" class="chkEn inTblGrid" value="<%=asgDataSet.getValue(i, "ASSIGNMENT_ID")%>"/></td>
				<td class="tdGrid Ct"><%=asgDataSet.getValue(i, "ASSIGNMENT_ID")%></td>
				<td class="tdGrid Lt"><%=asgDataSet.getValue(i, "ASSIGNMENT_NUMBER")%></td>
				<td class="tdGrid Ct"><%=asgDataSet.getValue(i, "LAST_INVOICE_DATE")%></td>
				<td class="tdGrid Ct"><%=asgDataSet.getValue(i, "LAST_PAID_DATE")%></td>
				<td class="tdGrid Lt"><%=asgDataSet.getValue(i, "WORKING_STATE_MEANING")%></td>
				<td class="tdGrid Ct"><%=asgDataSet.getValue(i, "ASG_ACTIVE")%></td>
			</tr>
<%
			}
		} else {
%>
			<tr>
				<td class="tdGrid Ct" colspan="7"><mc:msg key="I001"/></td>
			</tr>
<%
		}
%>
		</tbody>
	</table>
</div>
<div id="divPagingArea"></div>
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