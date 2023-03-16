<%/************************************************************************************************
* Description - PerBasicProfile - Person Profile (Old Type)
*	- Generated by Source Generator
************************************************************************************************/%>
<%@ include file="/shared/page/incCommon.jsp"%>
<%/************************************************************************************************
* Declare objects & variables
************************************************************************************************/%>
<%
	ParamEntity paramEntity = (ParamEntity)request.getAttribute("paramEntity");
	DataSet dsRequest = paramEntity.getRequestDataSet();
	HpPersonD person = (HpPersonD)session.getAttribute("HpPersonDQuickSearch");
	String personId = dsRequest.getValue("personId");
%>
<%/************************************************************************************************
* HTML
************************************************************************************************/%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<link rel="icon" type="image/png" href="<mc:cp key="imgIcon"/>/faviconPerci.png">
<%/************************************************************************************************
* Stylesheet & Javascript
************************************************************************************************/%>
<%@ include file="/shared/page/incCssJs.jsp"%>
<style type="text/css">
</style>
<script type="text/javascript" src="<mc:cp key="viewPageJsName"/>"></script>
<script type="text/javascript">
var personId = "<%=personId%>";
</script>
</head>
<%/************************************************************************************************
* Page & Header
************************************************************************************************/%>
<body class="bodyFrame">
<form id="fmDefault" name="fmDefault" method="post" action="">
<div id="divFrameWindowHolder">
<div id="divFixedPanelFrame">
<%/************************************************************************************************
* Real Contents - fixed panel(tab, button, search, information)
************************************************************************************************/%>
<div id="divTabArea"></div>
<div id="divButtonArea" class="areaContainerFrame">
	<div id="divButtonAreaLeft"></div>
	<div id="divButtonAreaRight">
		<ui:buttonGroup id="buttonGroup">
			<ui:button id="btnSendPayslips" caption="Send Payslips" iconClass="fa-paper-plane"/>
			<ui:button id="btnSearch" caption="button.com.search"/>
		</ui:buttonGroup>
	</div>
</div>
<div id="divInformArea" class="areaContainerFrame">
	<div id="divPersonHeader" class="alert alert-info personInfoHeader"><%=person.getFullName()%> (<%=person.getPersonNumber()%>) <%=person.getPersonType()%></div>
</div>
<div id="divSearchCriteriaArea"></div>
<%/************************************************************************************************
* End of fixed panel
************************************************************************************************/%>
<div class="breaker"></div>
</div>
<div id="divScrollablePanelFrame">
<%/************************************************************************************************
* Real Contents - scrollable panel(data, paging)
************************************************************************************************/%>
<div id="divDataArea" class="areaContainerFrame">
	<div id="divGridWrapper">
		<table id="tblGrid" class="tblGrid sort autosort" style="width:2700px">
			<colgroup>
				<col width="2%"/>
				<col width="11%"/>
				<col width="4%"/>
				<col width="4%"/>
				<col width="4%"/>
				<col width="6%"/>
				<col width="5%"/>
				<col width="4%"/>
				<col width="6%"/>
				<col width="16%"/>
				<col width="*"/>
				<col width="9%"/>
				<col width="5%"/>
				<col width="8%"/>
			</colgroup>
			<thead>
				<tr>
					<th class="thGrid"><ui:icon id="icnCheck" useFor="checkGrid" title="Select To Send"/></th>
					<th class="thGrid">Assignment Number</th>
					<th class="thGrid">Period Start</th>
					<th class="thGrid">Period End</th>
					<th class="thGrid">Date Paid</th>
					<th class="thGrid">Consulting Revenue</th>
					<th class="thGrid">Gross Taxable</th>
					<th class="thGrid">PAYG Tax</th>
					<th class="thGrid">Transfered Amount</th>
					<th class="thGrid">Employer Name</th>
					<th class="thGrid">Billing Organisation Name</th>
					<th class="thGrid">Payslip Template</th>
					<th class="thGrid">Payroll Type</th>
					<th class="thGrid">Tax Inv Acceptance Type</th>
				</tr>
			</thead>
			<tbody id="tblGridBody">
				<tr>
					<td class="tdGrid Ct" colspan="14"><mc:msg key="I002"/></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<div id="divPagingArea" class="areaContainerFrame"></div>
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