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
	String profileHtmlString = (String)paramEntity.getObject("profileHtmlString");
	DataSet dsOpp = (DataSet)paramEntity.getObject("dsOpp");
	DataSet dsAsg = (DataSet)paramEntity.getObject("dsAsg");
	DataSet dsPerson = (DataSet)paramEntity.getObject("dsPerson");
	String fmt2 = "#,##0.00", fmt3 = "#,##0.000";
	String estimatedRevenue = "$"+CommonUtil.getNumberMask(dsOpp.getValue("ESTIMATED_REVENUE"), fmt2);
	String contractValue = "$"+CommonUtil.getNumberMask(dsAsg.getValue("CONTRACT_VALUE"), fmt2);
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
button.bootstrapSelect.dropdown-toggle {padding:3px 20px 2px 5px;}
.optmandatory:after {font-size:.8em;content:"\00a0 \273B";color:#000000;}
.tblEdit th {padding:2px 4px;}
.tblEdit td {padding:2px 2px;}
.tblGrid th, .tblGrid td {padding:5px 4px;}
.thEdit {padding:2px 4px;}
.tdEdit {padding:2px 2px;}
.txtEn, .txtDpl, .txtDis, .txaEn, .txaDis, .txaDpl {padding:4px 4px;}
.btn {padding:2px 10px;}
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
			<ui:button id="btnSave" caption="button.com.save"/>
			<ui:button id="btnCloseOpp" caption="Close Opportunity" iconClass="fa-legal"/>
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
	<div id="divFrameDataAreaWrapper">
		<div id="accordionPerson" class="accordion">
			<div class="accordionGroup">
				<h3 id="hPersonDetails">Person Details</h3>
				<div id="divPersonDetails" class="accordionContents">
					<table id="tblPersonDetail" class="tblEdit">
						<colgroup>
							<col width="8%"/>
							<col width="17%"/>
							<col width="8%"/>
							<col width="17%"/>
							<col width="8%"/>
							<col width="17%"/>
							<col width="8%"/>
							<col width="*"/>
						</colgroup>
						<tbody>
							<tr>
								<th class="thEdit rt mandatory">Person</th>
								<td class="tdEdit">
									<ui:text name="personName" status="display" options="mandatory" checkName="Person" value="<%=dsOpp.getValue(\"PERSON_NAME_WITH_NUMBER\")%>"/>
									<ui:hidden name="personId" value="<%=dsOpp.getValue(\"PERSON_ID\")%>"/>
								</td>
								<th class="thEdit rt">Person Type</th>
								<td class="tdEdit"><ui:text name="personType" status="display" value="<%=dsPerson.getValue(\"PERSON_TYPE\")%>"/></td>
								<th class="thEdit rt">Preferred Email</th>
								<td class="tdEdit"><ui:text name="preferredEmail" status="display" value="<%=dsPerson.getValue(\"PREFERRED_EMAIL\")%>"/></td>
								<th class="thEdit rt" rowspan="3">Personal Comments</th>
								<td class="tdEdit" rowspan="3"><ui:txa id="personalComments" name="personalComments" status="display" style="height:70px;" value="<%=dsPerson.getValue(\"PERSONAL_COMMENTS\")%>"/></td>
							</tr>
							<tr>
								<th class="thEdit rt">Service Status</th>
								<td class="tdEdit"><ui:text name="serviceStatus" status="display" value="<%=dsPerson.getValue(\"SERVICE_STATUS_MEANING\")%>"/></td>
								<th class="thEdit rt">Service Type</th>
								<td class="tdEdit"><ui:text name="serviceType" status="display" value="<%=dsPerson.getValue(\"SERVICE_TYPE_MEANING\")%>"/></td>
								<th class="thEdit rt">Mobile Number</th>
								<td class="tdEdit"><ui:text name="mobileNumber" status="display" value="<%=dsPerson.getValue(\"MOBILE_NUMBER\")%>"/></td>
							</tr>
							<tr>
								<th class="thEdit rt">Primary Approver</th>
								<td class="tdEdit"><ui:text name="primaryApprover" status="display" value="<%=dsPerson.getValue(\"PRIMARY_APPROVER_NAME\")%>"/></td>
								<th class="thEdit rt">Last Paid Date</th>
								<td class="tdEdit"><ui:text name="lastPaidDate" status="display" value="<%=dsPerson.getValue(\"LAST_PAID_DATE\")%>"/></td>
								<th class="thEdit rt"></th>
								<td class="tdEdit"></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div id="accordionOpportunity" class="accordion">
			<div class="accordionGroup">
				<h3 id="hOpportunityDetails">Opportunity Details</h3>
				<div id="divOpportunityDetails" class="accordionContents">
					<table id="tblOpportunityDetails" class="tblEdit">
						<colgroup>
							<col width="8%"/>
							<col width="17%"/>
							<col width="8%"/>
							<col width="17%"/>
							<col width="8%"/>
							<col width="17%"/>
							<col width="8%"/>
							<col width="*"/>
						</colgroup>
						<tbody>
							<tr>
								<th class="thEdit rt mandatory">Opportunity Id</th>
								<td class="tdEdit"><ui:text name="oppId" status="display" value="<%=dsOpp.getValue(\"OPPORTUNITY_ID\")%>"/></td>
								<th class="thEdit rt mandatory">Opportunity Type</th>
								<td class="tdEdit"><ui:ccselect name="oppType" codeType="OPPORTUNITY_TYPE" selectedValue="<%=dsOpp.getValue(\"OPPORTUNITY_TYPE_MEANING\")%>" options="mandatory" checkName="Opportunity Type"/></td>
								<th class="thEdit rt mandatory">CDM<br/>(Formerly CRM)</th>
								<td class="tdEdit"><ui:text name="oppCrmName" value="<%=dsOpp.getValue(\"CRM_NAME\")%>" options="mandatory" checkName="CRM"/><ui:hidden name="oppCrmId" value="<%=dsOpp.getValue(\"CUSTOMER_RELATIONSHIP_MGR_ID\")%>"/></td>
								<th class="thEdit rt mandatory">CDM<br/>(Formerly CSM)</th>
								<td class="tdEdit"><ui:text name="oppCsmName" value="<%=dsOpp.getValue(\"CSM_NAME\")%>" options="mandatory" checkName="CSM"/><ui:hidden name="oppCsmId" value="<%=dsOpp.getValue(\"CUSTOMER_SUPPORT_MGR_ID\")%>"/></td>
							</tr>
							<tr>
								<th class="thEdit rt">Due Date</th>
								<td class="tdEdit"><ui:text name="oppDueDate" className="Ct hor" style="width:96px" value="<%=dsOpp.getValue(\"DUE_DATE_FORMAT\")%>" option="date"/><ui:icon id="icnOppDueDate" className="fa-calendar hor"/></td>
								<th class="thEdit rt">Ref Number</th>
								<td class="tdEdit"><ui:text name="oppReferenceNumber" value="<%=dsOpp.getValue(\"CUSTOMER_REFERENCE_NUMBER\")%>"/></td>
								<th class="thEdit rt">Ref Description</th>
								<td class="tdEdit"><ui:text name="oppReferenceDescription" value="<%=dsOpp.getValue(\"CUSTOMER_REFERENCE_DESCRIPTION\")%>"/></td>
								<th class="thEdit rt">Status</th>
								<td class="tdEdit"><ui:text name="oppStatus" status="display" value="<%=dsOpp.getValue(\"STATUS\")%>"/></td>
							</tr>
							<tr>
								<th class="thEdit rt">Estimated Revenue</th>
								<td class="tdEdit"><ui:text name="oppEstimatedRevenue" status="display" value="<%=estimatedRevenue%>"/></td>
								<th class="thEdit rt">Created By</th>
								<td class="tdEdit"><ui:text name="oppCreatedBy" status="display" value="<%=dsOpp.getValue(\"CREATED_BY_NAME\")%>"/></td>
								<th class="thEdit rt">Created Date</th>
								<td class="tdEdit"><ui:text name="oppCreatedDate" status="display" value="<%=dsOpp.getValue(\"CREATION_DATE_FORMAT\")%>"/></td>
								<th class="thEdit rt">Updated Date</th>
								<td class="tdEdit"><ui:text name="oppUpdatedDate" status="display" value="<%=dsOpp.getValue(\"LAST_UPDATE_DATE_FORMAT\")%>"/></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div id="accordionAsgTermWc" class="accordion">
			<div class="accordionGroup">
				<h3 id="hAsgTermWc">Assignment / Terms / Workcover</h3>
				<div id="divAsgTermWc" class="accordionContents" style="height:198px;overflow:hidden;">
					<div id="divTabAreaAsgTermWc" class="divTabArea">
						<ui:tab id="tabAsgTermWc">
							<ui:tabList caption="Assignment Details" isActive="true" iconClass="fa-id-card" iconPosition="left"/>
							<ui:tabList caption="Terms" iconClass="fa-sliders" iconPosition="left"/>
							<ui:tabList caption="Workcover" iconClass="fa-medkit" iconPosition="left"/>
						</ui:tab>
					</div>
					<div id="div0" class="areaContainer" style="padding:2px 0px 2px 0px;">
						<table id="tblAssignmentDetail" class="tblEdit">
							<caption class="captionEdit">Assignment Details</caption>
							<colgroup>
								<col width="8%"/>
								<col width="17%"/>
								<col width="8%"/>
								<col width="17%"/>
								<col width="8%"/>
								<col width="17%"/>
								<col width="8%"/>
								<col width="*"/>
							</colgroup>
							<tbody>
								<tr>
									<th class="thEdit rt mandatory">Assignment<br/>Start / End Date</th>
									<td class="tdEdit">
										<ui:text name="asgStartDate" className="Ct hor" value="<%=dsAsg.getValue(\"ASSIGNMENT_START_DATE_FORMAT\")%>" style="width:90px" options="mandatory" option="date"/><ui:icon id="icnAsgStartDate" className="fa-calendar hor"/>
										<div class="horGap10" style="padding:6px 6px 0px 0px;">-</div>
										<ui:text name="asgEndDate" className="Ct hor" value="<%=dsAsg.getValue(\"ASSIGNMENT_END_DATE_FORMAT\")%>" style="width:90px" options="mandatory" option="date"/><ui:icon id="icnAsgEndDate" className="fa-calendar hor"/>
									</td>
									<th class="thEdit rt mandatory">Rate</th>
									<td class="tdEdit">
										<ui:text name="asgRate" value="<%=CommonUtil.getNumberMask(dsAsg.getValue(\"RATE\"), fmt2)%>" className="Rt hor numeric" style="width:96px"/>
										<div><ui:ccselect name="asgRateUnit" selectedValue="<%=dsAsg.getValue(\"UNIT\")%>" options="mandatory" codeType="PAY_BASIS"/></div>
									</td>
									<th class="thEdit rt mandatory">Job Title</th>
									<td class="tdEdit"><ui:text name="asgJobTitle" value="<%=dsAsg.getValue(\"JOB_TITLE\")%>" options="mandatory" checkName="Job Title"/></td>
									<th class="thEdit rt mandatory">Management Fee</th>
									<td class="tdEdit">
										<ui:text name="asgManagementFee" value="<%=CommonUtil.getNumberMask(dsAsg.getValue(\"MANAGEMENT_FEE\"), fmt3)%>" options="mandatory" checkName="Management Fee" className="Rt hor numeric" style="width:96px"/>
										<div><ui:ccselect name="asgManagementFeeUnit" selectedValue="<%=dsAsg.getValue(\"MANAGEMENT_FEE_TYPE\")%>" options="mandatory" codeType="AMOUNT_PERCENTAGE"/></div>
									</td>
								</tr>
								<tr>
									<th class="thEdit rt mandatory">Billing Org</th>
									<td class="tdEdit"><ui:text name="asgBillingOrgName" value="<%=dsAsg.getValue(\"BILLING_ORG_NAME\")%>" options="mandatory" checkName="Billing Org"/><ui:hidden name="asgBillingOrgId" value="<%=dsAsg.getValue(\"BILLING_ORG\")%>"/></td>
									<th class="thEdit rt optmandatory">Billing Org Contact</th>
									<td class="tdEdit"><ui:text name="asgBillingOrgContactName" value="<%=dsAsg.getValue(\"CONTACT_PERSON_NAME\")%>"/><ui:hidden name="asgBillingOrgContactId" value="<%=dsAsg.getValue(\"CONTACT_PERSON\")%>"/></td>
									<th class="thEdit rt">IPro To Be<br/>Paid upon</th>
									<td class="tdEdit"><ui:ccselect name="asgIproFeeUpon" selectedValue="<%=dsAsg.getValue(\"IPRO_FEE_UPON\")%>" caption="==Select==" codeType="IPRO_FEE_UPON"/></td>
									<th class="thEdit rt optmandatory">Payment Arrangement</th>
									<td class="tdEdit"><ui:ccselect name="asgPaymentArrangement" selectedValue="<%=dsAsg.getValue(\"PAYMENT_ARRANGMENT\")%>" caption="==Select==" codeType="PAYMENT_ARRANGMENT"/></td>
								</tr>
								<tr>
									<th class="thEdit rt">End User Type</th>
									<td class="tdEdit"><ui:ccselect name="asgEndUserType" selectedValue="<%=dsAsg.getValue(\"END_USER_TYPE\")%>" caption="==Select==" codeType="END_USER_TYPE"/></td>
									<th class="thEdit rt" rowspan="2">Description of Services</th>
									<td class="tdEdit" rowspan="2"><ui:txa id="asgDescriptionOfServices" name="asgDescriptionOfServices" value="<%=dsAsg.getValue(\"SERVICE_DESCRIPTION\")%>" style="height:49px;"/></td>
									<th class="thEdit rt" rowspan="2">Management Fee<br/>Comments</th>
									<td class="tdEdit" rowspan="2"><ui:txa id="asgManagementFeeComments" name="asgManagementFeeComments" value="<%=dsAsg.getValue(\"MANAGEMENT_FEE_COMMENTS\")%>" style="height:49px;"/></td>
									<th class="thEdit rt">Contract Value</th>
									<td class="tdEdit"><ui:text name="asgContractValue" status="display" value="<%=contractValue%>"/></td>
								</tr>
								<tr>
									<th class="thEdit rt mandatory">End User Org</th>
									<td class="tdEdit"><ui:text name="asgEndUserOrgName" value="<%=dsAsg.getValue(\"END_USER_ORG_NAME\")%>" options="mandatory" checkName="End User Org"/><ui:hidden name="asgEndUserOrgId" value="<%=dsAsg.getValue(\"END_USER_ORG\")%>"/></td>
									<th class="thEdit rt"></th>
									<td class="tdEdit"></td>
								</tr>
							</tbody>
						</table>
					</div>
					<div id="div1" style="display:none;padding:2px 0px 2px 0px;">
						<table id="tblTermsDetail" class="tblEdit">
							<caption class="captionEdit">Terms</caption>
							<colgroup>
								<col width="8%"/>
								<col width="17%"/>
								<col width="8%"/>
								<col width="17%"/>
								<col width="8%"/>
								<col width="17%"/>
								<col width="8%"/>
								<col width="*"/>
							</colgroup>
							<tbody>
								<tr>
									<th class="thEdit rt">Working Hours Basis</th>
									<td class="tdEdit"><ui:ccselect name="workingHoursBasis" selectedValue="<%=dsAsg.getValue(\"WORKING_HOURS_BASIS\")%>" caption="==Select==" codeType="WORKING_HOURS_BASIS"/></td>
									<th class="thEdit rt">Start Time</th>
									<td class="tdEdit">
										<div style="float:left;padding-top:2px;"><ui:ccselect name="startTimeHour" selectedValue="<%=dsAsg.getValue(\"WORK_START_HH\")%>" caption="==Select==" codeType="HOUR_CODE" className="dropdown" attribute="data-size:13;data-dropup-auto:false"/></div>
										<div style="float:left;padding:6px 6px 2px 6px;">:</div>
										<div style="float:left;padding-top:2px;"><ui:ccselect name="startTimeMin" selectedValue="<%=dsAsg.getValue(\"WORK_START_MM\")%>" caption="==Select==" codeType="MINUTE_CODE"/></div>
									</td>
									<th class="thEdit rt">End Time</th>
									<td class="tdEdit">
										<div style="float:left;padding-top:2px;"><ui:ccselect name="endTimeHour" selectedValue="<%=dsAsg.getValue(\"WORK_END_HH\")%>" caption="==Select==" codeType="HOUR_CODE" className="dropdown" attribute="data-size:13;data-dropup-auto:false"/></div>
										<div style="float:left;padding:6px 6px 2px 6px;">:</div>
										<div style="float:left;padding-top:2px;"><ui:ccselect name="endTimeMin" selectedValue="<%=dsAsg.getValue(\"WORK_END_MM\")%>" caption="==Select==" codeType="MINUTE_CODE"/></div>
									</td>
									<th class="thEdit rt optmandatory">Termination Notice</th>
									<td class="tdEdit">
										<div style="float:left;padding-top:2px;"><ui:ccselect name="terminationNotice" selectedValue="<%=dsAsg.getValue(\"TERMINATION_NOTICE\")%>" caption="==Select==" codeType="ASG_TERM_NOTICE" className="dropdown" attribute="data-size:13;data-dropup-auto:false"/></div>
										<div style="float:left;padding:6px 6px 2px 6px;"></div>
										<div style="float:left;padding-top:2px;"><ui:ccselect name="terminationNoticeUnit" selectedValue="<%=dsAsg.getValue(\"TERMINATION_NOTICE_UNIT\")%>" caption="==Select==" codeType="ASG_TERM_NOTICE_UNIT"/></div>
									</td>
								</tr>
								<tr>
									<th class="thEdit rt optmandatory">Equipment Required</th>
									<td class="tdEdit"><ui:ccradio name="equipmentRequired" codeType="SIMPLE_YN" selectedValue="<%=dsAsg.getValue(\"EQUIPMENT_REQUIRED_YN\")%>" isCustomised="true"/></td>
									<th class="thEdit rt" rowspan="2">Equipment</th>
									<td class="tdEdit" rowspan="2"><ui:txa id="equipment" name="equipment" value="<%=dsAsg.getValue(\"EQUIPMENT_DETAILS\")%>" style="height:46px;"/></td>
									<th class="thEdit rt" rowspan="2">Special Conditions</th>
									<td class="tdEdit" rowspan="2"><ui:txa id="specialConditions" name="specialConditions" value="<%=dsAsg.getValue(\"SPECIAL_CONDITIONS\")%>" style="height:46px;"/></td>
									<th class="thEdit rt" rowspan="2">Approved Expense</th>
									<td class="tdEdit" rowspan="2"><ui:txa id="approvedExpense" name="approvedExpense" value="<%=dsAsg.getValue(\"APPROVED_EXPENSES\")%>" style="height:46px;"/></td>
								</tr>
								<tr>
									<th class="thEdit rt">Restraint of Trade</th>
									<td class="tdEdit"><ui:text name="restraintOfTrade" value="<%=dsAsg.getValue(\"RESTRAINT_OF_TRADE\")%>"/></td>
								</tr>
							</tbody>
						</table>
					</div>
					<div id="div2" style="display:none;padding:2px 0px 2px 0px;">
						<table id="tblWorkcoverDetail" class="tblEdit">
							<caption class="captionEdit">Workcover</caption>
							<colgroup>
								<col width="8%"/>
								<col width="17%"/>
								<col width="8%"/>
								<col width="17%"/>
								<col width="8%"/>
								<col width="17%"/>
								<col width="8%"/>
								<col width="*"/>
							</colgroup>
							<tbody>
								<tr>
									<th class="thEdit rt">Workcover Code</th>
									<td class="tdEdit" colspan="7">
										<ui:text name="workcoverCode" className="hor" value="<%=dsAsg.getValue(\"WC_CODE_RATE_NAME\")%>" status="disabled" style="width:300px"/>
										<ui:button id="btnAddWorkcover" caption="Add" iconClass="fa-plus"/>
									</td>
								</tr>
								<tr>
									<th class="thEdit rt">WIC / ANZIC</th>
									<td class="tdEdit"><ui:text name="wicAnzic" value="<%=dsAsg.getValue(\"WC_WIC_ANZIC\")%>" status="disabled"/></td>
									<th class="thEdit rt">Working State</th>
									<td class="tdEdit"><ui:text name="workingState" value="<%=dsAsg.getValue(\"WC_WORKING_STATE_MEANING\")%>" status="disabled"/></td>
									<th class="thEdit rt">Percentage</th>
									<td class="tdEdit"><ui:text name="wcPercentage" value="<%=dsAsg.getValue(\"WC_PERCENTAGE\")%>" status="disabled"/></td>
									<th class="thEdit rt">Start / End Date</th>
									<td class="tdEdit">
										<ui:text name="wcStartDate" className="Ct hor" style="width:90px" value="<%=dsAsg.getValue(\"WC_START_DATE\")%>" status="disabled"/>
										<div class="horGap10" style="padding:6px 6px 0px 0px;">-</div>
										<ui:text name="wcEndDate" className="Ct hor" style="width:90px" value="<%=dsAsg.getValue(\"WC_END_DATE\")%>" status="disabled"/>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<div id="accordionDocuments" class="accordion">
			<div class="accordionGroup">
				<h3 id="hDocuments">Opportunity Documents</h3>
				<div id="divDocuments" class="accordionContents" style="overflow:hidden">
					<div class="divButtonArea">
						<div class="divButtonAreaRight">
							<ui:buttonGroup>
								<ui:button id="btnCreateFromTemplate" caption="Create From Template" iconClass="fa-window-restore"/>
								<ui:button id="btnManageDocument" caption="Manage Document" iconClass="fa-sliders"/>
								<ui:button id="btnAddAdHocDocument" caption="Add Ad Hoc Document" iconClass="fa-plus-circle"/>
							</ui:buttonGroup>
							<div style="margin-top:3px;padding:0px 4px 0px 4px;"><%=profileHtmlString%></div>
							<ui:button id="btnApplyProfile" caption="Apply" iconClass="fa-plug"/>
						</div>
					</div>
					<div class="verGap2"></div>
					<div id="divGridHolderDocuments" style="overflow:auto;">
						<table id="tblDocuments" class="tblGrid sort autosort">
							<colgroup>
								<col width="6%"></col>
								<col width="*"></col>
								<col width="12%"></col>
								<col width="10%"></col>
								<col width="5%"></col>
								<col width="6%"></col>
								<col width="8%"></col>
								<col width="11%"></col>
								<col width="10%"></col>
								<col width="5%"></col>
								<col width="6%"></col>
							</colgroup>
							<thead>
								<tr>
									<th class="thGrid">Document Id</th>
									<th class="thGrid">Document Name</th>
									<th class="thGrid">Detail</th>
									<th class="thGrid">Assigned To</th>
									<th class="thGrid">Due Date</th>
									<th class="thGrid">Follow Up Date</th>
									<th class="thGrid">Status</th>
									<th class="thGrid">Status Detail</th>
									<th class="thGrid">Sent By</th>
									<th class="thGrid">Sent Date</th>
									<th class="thGrid">Received Date</th>
								</tr>
							</thead>
							<tbody id="tbodyDocuments">
								<tr>
									<td class="tdGrid Ct" colspan="11"><mc:msg key="I002"/></td>
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