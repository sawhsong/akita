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
			<ui:button id="btnSave" caption="button.com.save"/>
		</ui:buttonGroup>
	</div>
</div>
<div id="divSearchCriteriaArea"></div>
<div id="divInformArea" class="areaContainerFrame">
	<div id="divPersonHeader" class="alert alert-info personInfoHeader"><%=person.getFullName()%> (<%=person.getPersonNumber()%>) <%=person.getPersonType()%></div>
</div>
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
	<div id="divFrameDataAreaWrapper">
		<div id="divLeft" class="accordion" style="width:35%;float:left">
			<div class="accordionGroup">
				<h3 id="hGeneralInfo">General Info</h3>
				<div id="divGeneralInfo" class="accordionContents">
					<table id="tblGeneralInfo" class="tblEdit">
						<colgroup>
							<col width="45%"/>
							<col width="*"/>
						</colgroup>
						<tbody>
							<tr>
								<th class="thEdit rt">Employment Company</th>
								<td class="tdEdit"><ui:text name="emeploymentCompany" status="display"/></td>
							</tr>
							<tr>
								<th class="thEdit rt mandatory">Service Status</th>
								<td class="tdEdit"><ui:ccselect name="serviceStatus" codeType="SERVICE_STATUS" attribute="data-width:100%" options="mandatory" checkName="Service Status"/></td>
							</tr>
							<tr>
								<th class="thEdit rt mandatory">Service Type</th>
								<td class="tdEdit"><ui:ccselect name="serviceType" codeType="SERVICE_TYPE" attribute="data-width:100%" options="mandatory" checkName="Service Type"/></td>
							</tr>
							<tr>
								<th class="thEdit rt">Member Since</th>
								<td class="tdEdit"><ui:text name="memberSince" className="Ct hor" style="width:90px" option="date"/><ui:icon id="icnMemberSince" className="fa-calendar hor"/></td>
							</tr>
							<tr>
								<th class="thEdit rt">Resignation Date</th>
								<td class="tdEdit"><ui:text name="resignationDate" className="Ct hor" style="width:90px" option="date"/><ui:icon id="icnResignationDate" className="fa-calendar hor"/></td>
							</tr>
							<tr>
								<th class="thEdit rt">Resignation Reason</th>
								<td class="tdEdit"><ui:ccselect name="resignationReason" codeType="RESIGNATION_REASON" caption="-- Select --" attribute="data-width:100%;data-size:15;"/></td>
							</tr>
							<tr>
								<th class="thEdit rt">Resignation Comments</th>
								<td class="tdEdit"><ui:text name="resignationComments"/></td>
							</tr>
							<tr>
								<th class="thEdit rt">Reference No 2</th>
								<td class="tdEdit"><ui:text name="referenceNo2"/></td>
							</tr>
							<tr>
								<th class="thEdit rt">Reference No 3</th>
								<td class="tdEdit"><ui:text name="referenceNo3"/></td>
							</tr>
							<tr>
								<th class="thEdit rt">Employment Type</th>
								<td class="tdEdit"><ui:ccselect name="employmentType" codeType="EMPLOYMENT_TYPE" attribute="data-width:100%"/></td>
							</tr>
							<tr>
								<th class="thEdit rt mandatory">Customer Delivery Manager<br>(Formerly CRM)</th>
								<td class="tdEdit"><ui:hidden name="crmId"/><ui:text name="crmName"/></td>
							</tr>
							<tr>
								<th class="thEdit rt mandatory">Customer Delivery Manager<br>(Formerly CSM)</th>
								<td class="tdEdit"><ui:hidden name="csmId"/><ui:text name="csmName"/></td>
							</tr>
							<tr>
								<th class="thEdit rt mandatory">Customer Support Administrator<br>(Formerly Customer Administrator)</th>
								<td class="tdEdit"><ui:hidden name="csaId"/><ui:text name="csaName"/></td>
							</tr>
							<tr>
								<th class="thEdit rt mandatory">State Managed By</th>
								<td class="tdEdit"><ui:ccselect name="stateManagedBy" codeType="STATES" caption="-- Select --" attribute="data-width:100%"/></td>
							</tr>
							<tr>
								<th class="thEdit rt">LAFHA Eligible / Amount</th>
								<td class="tdEdit">
									<span style="float:left;padding-top:4px"><ui:check name="lafhaEligible" value="Y" text="LAFHA Eligible" isCustomised="true"/></span>
									&nbsp;&nbsp;&nbsp;
									<span style="float:left"><ui:text name="lafhaAmount" className="rt numeric" style="width:100px"/></span>
								</td>
							</tr>
							<tr>
								<th class="thEdit rt">Verified</th>
								<td class="tdEdit"><ui:check name="verified" value="Y" text="Verified" isCustomised="true"/></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div id="divRight" class="accordion" style="width:64%;float:right">
			<div class="accordionGroup">
				<h3 id="hPaymentAdviceDelivery">Payment Advice Delivery</h3>
				<div id="divPaymentAdviceDelivery" class="accordionContents">
					<table id="tblPaymentAdviceDelivery" class="tblEdit">
						<colgroup>
							<col width="12%"/>
							<col width="35%"/>
							<col width="12%"/>
							<col width="*"/>
						</colgroup>
						<tbody>
							<tr>
								<th class="thEdit rt">Email</th>
								<td class="tdEdit"><ui:text name="paymentAdviceDeliveryEmail"/></td>
								<th class="thEdit rt" rowspan="2">Description</th>
								<td class="tdEdit" rowspan="2"><ui:txa name="paymentAdviceDeliveryDescription" style="height:54px"/></td>
							</tr>
							<tr>
								<th class="thEdit rt">Send To</th>
								<td class="tdEdit">
									<ui:check name="paymentAdviceDeliverySendToEmail" value="Y" text="Email" isCustomised="true"/>
									<ui:check name="paymentAdviceDeliverySendToEntityOnline" value="Y" text="Entity Online" isCustomised="true"/>
									<ui:check name="paymentAdviceDeliverySendToOther" value="Y" text="Other" isCustomised="true"/>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="accordionGroup">
				<h3 id="hWorkingRightsStatus">Working Rights Status</h3>
				<div id="divWorkingRightsStatus" class="accordionContents">
					<div class="divButtonArea">
						<div class="divButtonAreaLeft"></div>
						<div class="divButtonAreaRight">
							<ui:buttonGroup>
								<ui:button id="btnAddWorkingRightsStatus" caption="button.com.add" iconClass="fa-plus-square"/>
							</ui:buttonGroup>
						</div>
					</div>
					<div class="verGap4"></div>
					<div id="divGridHolderWorkingRightsStatus" style="overflow:auto">
						<table id="tblWorkingRightsStatus" class="tblGrid sort autosort">
							<colgroup>
								<col width="3%"></col>
								<col width="6%"></col>
								<col width="22%"></col>
								<col width="16%"></col>
								<col width="10%"></col>
								<col width="10%"></col>
								<col width="*"></col>
							</colgroup>
							<thead>
								<tr>
									<th class="thGrid"><ui:icon useFor="actionHeaderGrid"/></th>
									<th class="thGrid">Active</th>
									<th class="thGrid">Working Rights</th>
									<th class="thGrid">Visa Status</th>
									<th class="thGrid">Date Issued</th>
									<th class="thGrid">Expiry Date</th>
									<th class="thGrid">Additional Note</th>
								</tr>
							</thead>
							<tbody id="tbodyWorkingRightsStatus">
								<tr>
									<td class="tdGrid Ct" colspan="7"><mc:msg key="I002"/></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="accordionGroup">
				<h3 id="hScheduledPayrollNoti">Scheduled Payroll Notifications</h3>
				<div id="divScheduledPayrollNoti" class="accordionContents">
					<div class="divButtonArea">
						<div class="divButtonAreaLeft"></div>
						<div class="divButtonAreaRight">
							<ui:buttonGroup>
								<ui:button id="btnAddScheduledPayrollNoti" caption="button.com.add" iconClass="fa-plus-square"/>
							</ui:buttonGroup>
						</div>
					</div>
					<div class="verGap4"></div>
					<div id="divGridHolderScheduledPayrollNoti" style="overflow:auto">
						<table id="tblScheduledPayrollNoti" class="tblGrid sort autosort">
							<colgroup>
								<col width="3%"></col>
								<col width="6%"></col>
								<col width="12%"></col>
								<col width="12%"></col>
								<col width="10%"></col>
								<col width="10%"></col>
								<col width="*"></col>
							</colgroup>
							<thead>
								<tr>
									<th class="thGrid"><ui:icon useFor="actionHeaderGrid"/></th>
									<th class="thGrid">Active</th>
									<th class="thGrid">Type</th>
									<th class="thGrid">Period</th>
									<th class="thGrid">Start</th>
									<th class="thGrid">End</th>
									<th class="thGrid">Text</th>
								</tr>
							</thead>
							<tbody id="tbodyScheduledPayrollNoti">
								<tr>
									<td class="tdGrid Ct" colspan="7"><mc:msg key="I002"/></td>
								</tr>
							</tbody>
						</table>
					</div>
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