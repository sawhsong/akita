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
	DataSet dsRequest = (DataSet)paramEntity.getRequestDataSet();
	DataSet dsOpp = (DataSet)paramEntity.getObject("dsOpp");
	DataSet dsAsg = (DataSet)paramEntity.getObject("dsAsg");
	String numberFormat = "#,##0.00";
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
var opportunityId = "<%=dsRequest.getValue("opportunityId")%>";
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
			<ui:button id="btnClose" caption="button.com.close"/>
		</ui:buttonGroup>
	</div>
</div>
<div id="divSearchCriteriaArea"></div>
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
	<div class="accordion">
		<div class="accordionGroup">
			<h3>Opportunity / Assignment Details</h3>
			<div id="divOppAsgDetails" class="accordionContents">
				<div style="width:49%;float:left">
					<table id="tblOpportunity" class="tblEdit">
						<caption class="captionEdit">Opportunity Details</caption>
						<colgroup>
							<col width="30%"/>
							<col width="*"/>
						</colgroup>
						<tbody>
							<tr>
								<th class="thEdit rt">Opportunity Id</th>
								<td class="tdEdit"><%=dsOpp.getValue("OPPORTUNITY_ID")%></td>
							</tr>
							<tr>
								<th class="thEdit rt">Opportunity Type</th>
								<td class="tdEdit"><%=dsOpp.getValue("OPPORTUNITY_TYPE_MEANING")%></td>
							</tr>
							<tr>
								<th class="thEdit rt">Customer Relationship Manager</th>
								<td class="tdEdit"><%=dsOpp.getValue("CRM_NAME")%></td>
							</tr>
							<tr>
								<th class="thEdit rt">Customer Support Manager</th>
								<td class="tdEdit"><%=dsOpp.getValue("CSM_NAME")%></td>
							</tr>
							<tr>
								<th class="thEdit rt">Date Created</th>
								<td class="tdEdit"><%=dsOpp.getValue("CREATION_DATE_FORMAT")%></td>
							</tr>
							<tr>
								<th class="thEdit rt">Status</th>
								<td class="tdEdit"><%=dsOpp.getValue("STATUS")%></td>
							</tr>
							<tr>
								<th class="thEdit rt">Closed As</th>
								<td class="tdEdit"><%=dsOpp.getValue("CLOSE_AS_MEANING")%></td>
							</tr>
							<tr>
								<th class="thEdit rt">Closed By</th>
								<td class="tdEdit"><%=dsOpp.getValue("CLOSE_BY_NAME")%></td>
							</tr>
							<tr>
								<th class="thEdit rt">Closed Date</th>
								<td class="tdEdit"><%=dsOpp.getValue("CLOSE_DATE_FORMAT")%></td>
							</tr>
							<tr>
								<th class="thEdit rt">Customer Reference Number</th>
								<td class="tdEdit"><%=dsOpp.getValue("CUSTOMER_REFERENCE_NUMBER")%></td>
							</tr>
							<tr>
								<th class="thEdit rt">Customer Reference Description</th>
								<td class="tdEdit"><%=dsOpp.getValue("CUSTOMER_REFERENCE_DESCRIPTION")%></td>
							</tr>
							<tr>
								<th class="thEdit rt">Estimated Revenue</th>
								<td class="tdEdit"><%=CommonUtil.getNumberMask(dsOpp.getValue("ESTIMATED_REVENUE"), numberFormat)%></td>
							</tr>
							<tr>
								<th class="thEdit rt">Closing Notes</th>
								<td class="tdEdit"><%=dsOpp.getValue("CLOSE_NOTES")%></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div style="width:50%;float:right">
					<table id="tblAssignment" class="tblEdit">
						<caption class="captionEdit">Assignment Details</caption>
						<colgroup>
							<col width="30%"/>
							<col width="*"/>
						</colgroup>
						<tbody>
							<tr>
								<th class="thEdit rt">Assignment Start Date</th>
								<td class="tdEdit"><%=dsAsg.getValue("ASSIGNMENT_START_DATE_FORMAT")%></td>
							</tr>
							<tr>
								<th class="thEdit rt">Assignment End Date</th>
								<td class="tdEdit"><%=dsAsg.getValue("ASSIGNMENT_END_DATE_FORMAT")%></td>
							</tr>
							<tr>
								<th class="thEdit rt">Billing Organisation</th>
								<td class="tdEdit"><%=dsAsg.getValue("BILLING_ORG_NAME")%> (<%=dsAsg.getValue("BILLING_ORG")%>)</td>
							</tr>
							<tr>
								<th class="thEdit rt">End User Organisation</th>
								<td class="tdEdit"><%=dsAsg.getValue("END_USER_ORG_NAME")%> (<%=dsAsg.getValue("END_USER_ORG")%>)</td>
							</tr>
							<tr>
								<th class="thEdit rt">IPro Rate</th>
								<td class="tdEdit"><%=CommonUtil.getNumberMask(dsAsg.getValue("RATE"), numberFormat)%></td>
							</tr>
							<tr>
								<th class="thEdit rt">Unit</th>
								<td class="tdEdit"><%=dsAsg.getValue("UNIT_MEANING")%></td>
							</tr>
							<tr>
								<th class="thEdit rt">Management Fee Comments</th>
								<td class="tdEdit"><%=dsAsg.getValue("MANAGEMENT_FEE_COMMENTS")%></td>
							</tr>
							<tr>
								<th class="thEdit rt">Special Conditions</th>
								<td class="tdEdit"><%=dsAsg.getValue("SPECIAL_CONDITIONS")%></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div class="breaker"></div>
	<div class="accordion">
		<div class="accordionGroup">
			<h3>Opportunity Documents</h3>
			<div id="divOpportunityDocument" class="accordionContents">
				<div id="divGridHolderOpportunityDocument" class="accordionContents">
					<table id="tblOpportunityDocument" class="tblGrid sort autosort">
						<colgroup>
							<col width="6%"></col>
							<col width="12%"></col>
							<col width="21%"></col>
							<col width="22%"></col>
							<col width="*"></col>
							<col width="5%"></col>
						</colgroup>
						<thead>
							<tr>
								<th class="thGrid">Document Id</th>
								<th class="thGrid">Document Type</th>
								<th class="thGrid">Document Sub Type</th>
								<th class="thGrid">Description</th>
								<th class="thGrid">File Name</th>
								<th class="thGrid">Upload Date</th>
							</tr>
						</thead>
						<tbody id="tbodyOpportunityDocument">
							<tr>
								<td class="tdGrid Ct" colspan="6"><mc:msg key="I002"/></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
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