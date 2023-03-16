/**************************************************************************************************
 * Framework Generated DTO Source
 * - HP_ASSIGNMENTS_D - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dto.oracle;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;

import zebra.data.DataSet;
import zebra.util.CommonUtil;
import project.common.extend.BaseDto;

@SuppressWarnings("unused")
public class HpAssignmentsD extends BaseDto implements Serializable {
	/**
	 * Columns
	 */
	private double assignmentId;
	private String ASSIGNMENT_ID;
	private Date fromDate;
	private String FROM_DATE;
	private Date toDate;
	private String TO_DATE;
	private double createdBy;
	private String CREATED_BY;
	private Date creationDate;
	private String CREATION_DATE;
	private double lastUpdatedBy;
	private String LAST_UPDATED_BY;
	private Date lastUpdateDate;
	private String LAST_UPDATE_DATE;
	private double personId;
	private String PERSON_ID;
	private double billingOrganisationId;
	private String BILLING_ORGANISATION_ID;
	private double euOrganisationId;
	private String EU_ORGANISATION_ID;
	private String approvedExpenses;
	private String APPROVED_EXPENSES;
	private String asgActive;
	private String ASG_ACTIVE;
	private Date assignmentEndDate;
	private String ASSIGNMENT_END_DATE;
	private String assignmentNumber;
	private String ASSIGNMENT_NUMBER;
	private Date assignmentStartDate;
	private String ASSIGNMENT_START_DATE;
	private String attribute1;
	private String ATTRIBUTE1;
	private String attribute10;
	private String ATTRIBUTE10;
	private String attribute9;
	private String ATTRIBUTE9;
	private String automaticInvoice;
	private String AUTOMATIC_INVOICE;
	private String basicSalary;
	private String BASIC_SALARY;
	private String billingCode;
	private String BILLING_CODE;
	private double billingCodeId;
	private String BILLING_CODE_ID;
	private double billingOrganisationPersonId;
	private String BILLING_ORGANISATION_PERSON_ID;
	private double businessGroupId;
	private String BUSINESS_GROUP_ID;
	private String comments;
	private String COMMENTS;
	private String costCentre;
	private String COST_CENTRE;
	private String createdAs;
	private String CREATED_AS;
	private double deliverablesApprover1;
	private String DELIVERABLES_APPROVER_1;
	private double deliverablesApprover2;
	private String DELIVERABLES_APPROVER_2;
	private double deliverablesApprover3;
	private String DELIVERABLES_APPROVER_3;
	private double deliverablesApprNotiToId;
	private String DELIVERABLES_APPR_NOTI_TO_ID;
	private double deliverablesApprNotiToOrg;
	private String DELIVERABLES_APPR_NOTI_TO_ORG;
	private String deliverablesName;
	private String DELIVERABLES_NAME;
	private double element1;
	private String ELEMENT_1;
	private double element2;
	private String ELEMENT_2;
	private double element3;
	private String ELEMENT_3;
	private double element4;
	private String ELEMENT_4;
	private double element5;
	private String ELEMENT_5;
	private String engagementContractType;
	private String ENGAGEMENT_CONTRACT_TYPE;
	private String equipmentDetails;
	private String EQUIPMENT_DETAILS;
	private String equipmentRequiredYn;
	private String EQUIPMENT_REQUIRED_YN;
	private double etsApprovalNotificationTo;
	private String ETS_APPROVAL_NOTIFICATION_TO;
	private double etsApprovalNotiTo2;
	private String ETS_APPROVAL_NOTI_TO_2;
	private double euContactPersonId;
	private String EU_CONTACT_PERSON_ID;
	private double expenseApprovalNotiToId;
	private String EXPENSE_APPROVAL_NOTI_TO_ID;
	private double expenseApprovalNotiToOrg;
	private String EXPENSE_APPROVAL_NOTI_TO_ORG;
	private double expenseApprover1;
	private String EXPENSE_APPROVER_1;
	private double expenseApprover2;
	private String EXPENSE_APPROVER_2;
	private double expenseApprover3;
	private String EXPENSE_APPROVER_3;
	private String expenseName;
	private String EXPENSE_NAME;
	private String gstExempt;
	private String GST_EXEMPT;
	private String invoiceRecipientEmail;
	private String INVOICE_RECIPIENT_EMAIL;
	private String isBulkApproval;
	private String IS_BULK_APPROVAL;
	private String isBulkApprovalDeliverables;
	private String IS_BULK_APPROVAL_DELIVERABLES;
	private String isBulkApprovalExpense;
	private String IS_BULK_APPROVAL_EXPENSE;
	private String isDaily;
	private String IS_DAILY;
	private String isStartEndTime;
	private String IS_START_END_TIME;
	private String jobTitle;
	private String JOB_TITLE;
	private String modernAwardDescription;
	private String MODERN_AWARD_DESCRIPTION;
	private double modernAwardId;
	private String MODERN_AWARD_ID;
	private String payrollNotes;
	private String PAYROLL_NOTES;
	private String payslipEmail;
	private String PAYSLIP_EMAIL;
	private String payArrangement;
	private String PAY_ARRANGEMENT;
	private double payMethodId;
	private String PAY_METHOD_ID;
	private String preferred;
	private String PREFERRED;
	private String prtStatus;
	private String PRT_STATUS;
	private double rate;
	private String RATE;
	private double rate1;
	private String RATE1;
	private double rate2;
	private String RATE2;
	private double rate3;
	private String RATE3;
	private double rate4;
	private String RATE4;
	private double rate5;
	private String RATE5;
	private String referenceAPo;
	private String REFERENCE_A_PO;
	private String referenceB;
	private String REFERENCE_B;
	private String referenceC;
	private String REFERENCE_C;
	private String referenceD;
	private String REFERENCE_D;
	private String referenceNo1;
	private String REFERENCE_NO_1;
	private String referenceNo2;
	private String REFERENCE_NO_2;
	private String referenceNo3;
	private String REFERENCE_NO_3;
	private String restraintOfTrade;
	private String RESTRAINT_OF_TRADE;
	private String serviceDescription;
	private String SERVICE_DESCRIPTION;
	private String specialConditions;
	private String SPECIAL_CONDITIONS;
	private String terminationNotice;
	private String TERMINATION_NOTICE;
	private String terminationNoticeUnit;
	private String TERMINATION_NOTICE_UNIT;
	private double timecardApprovalId;
	private String TIMECARD_APPROVAL_ID;
	private String timecardApprovalRateHidden;
	private String TIMECARD_APPROVAL_RATE_HIDDEN;
	private String timecardLayout;
	private String TIMECARD_LAYOUT;
	private String timecardRequired;
	private String TIMECARD_REQUIRED;
	private double timecardSecondaryApprovalId;
	private String TIMECARD_SECONDARY_APPROVAL_ID;
	private double timecardTertiaryApprovalId;
	private String TIMECARD_TERTIARY_APPROVAL_ID;
	private String timesheetName;
	private String TIMESHEET_NAME;
	private String timesheetUnits;
	private String TIMESHEET_UNITS;
	private String unit;
	private String UNIT;
	private String useAwardCalculation;
	private String USE_AWARD_CALCULATION;
	private String useDeliverables;
	private String USE_DELIVERABLES;
	private String useExpense;
	private String USE_EXPENSE;
	private String wcOrganisationTypeFlag;
	private String WC_ORGANISATION_TYPE_FLAG;
	private double wcOrgCodeRateLinkId;
	private String WC_ORG_CODE_RATE_LINK_ID;
	private String workingState;
	private String WORKING_STATE;
	private String workEndTime;
	private String WORK_END_TIME;
	private String workStartTime;
	private String WORK_START_TIME;
	private String insertUserName;
	private String INSERT_USER_NAME;
	private String updateUserName;
	private String UPDATE_USER_NAME;

	/**
	 * Constructor
	 */
	@SuppressWarnings("rawtypes")
	public HpAssignmentsD() throws Exception {
		Class cls = getClass();
		Field field[] = cls.getDeclaredFields();

		for (int i=0; i<field.length; i++) {
			if (field[i].getType().isInstance(dataSet) || field[i].getType().isInstance(updateColumnsDataSet) || field[i].getName().equals("updateColumnsDataSetHeader") ||
				field[i].getName().equals("FRW_VAR_PRIMARY_KEY") || field[i].getName().equals("FRW_VAR_DATE_COLUMN") ||
				field[i].getName().equals("FRW_VAR_NUMBER_COLUMN") || field[i].getName().equals("FRW_VAR_CLOB_COLUMN") ||
				field[i].getName().equals("FRW_VAR_DEFAULT_COLUMN") || field[i].getName().equals("FRW_VAR_DEFAULT_VALUE") ||
				!CommonUtil.isUpperCaseWithNumeric(CommonUtil.remove(field[i].getName(), "_"))) {
				continue;
			}

			dataSet.addName(field[i].getName());
		}

		dataSet.addRow();
		updateColumnsDataSet.addName(updateColumnsDataSetHeader);
		setFrwVarPrimaryKey("ASSIGNMENT_ID,FROM_DATE,TO_DATE");
		setFrwVarDateColumn("FROM_DATE,TO_DATE,CREATION_DATE,LAST_UPDATE_DATE,ASSIGNMENT_END_DATE,ASSIGNMENT_START_DATE");
		setFrwVarNumberColumn("ASSIGNMENT_ID,CREATED_BY,LAST_UPDATED_BY,PERSON_ID,BILLING_ORGANISATION_ID,EU_ORGANISATION_ID,BILLING_CODE_ID,BILLING_ORGANISATION_PERSON_ID,BUSINESS_GROUP_ID,DELIVERABLES_APPROVER_1,DELIVERABLES_APPROVER_2,DELIVERABLES_APPROVER_3,DELIVERABLES_APPR_NOTI_TO_ID,DELIVERABLES_APPR_NOTI_TO_ORG,ELEMENT_1,ELEMENT_2,ELEMENT_3,ELEMENT_4,ELEMENT_5,ETS_APPROVAL_NOTIFICATION_TO,ETS_APPROVAL_NOTI_TO_2,EU_CONTACT_PERSON_ID,EXPENSE_APPROVAL_NOTI_TO_ID,EXPENSE_APPROVAL_NOTI_TO_ORG,EXPENSE_APPROVER_1,EXPENSE_APPROVER_2,EXPENSE_APPROVER_3,MODERN_AWARD_ID,PAY_METHOD_ID,RATE,RATE1,RATE2,RATE3,RATE4,RATE5,TIMECARD_APPROVAL_ID,TIMECARD_SECONDARY_APPROVAL_ID,TIMECARD_TERTIARY_APPROVAL_ID,WC_ORG_CODE_RATE_LINK_ID");
		setFrwVarClobColumn("");
		setFrwVarDefaultColumn("ASG_ACTIVE");
		setFrwVarDefaultValue("Y");
		setDefaultValue();
	}

	/**
	 * Accessors
	 */
	public double getAssignmentId() {
		return assignmentId;
	}

	public void setAssignmentId(double assignmentId) throws Exception {
		this.assignmentId = assignmentId;
		setValueFromAccessor("ASSIGNMENT_ID", CommonUtil.toString(assignmentId));
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) throws Exception {
		this.fromDate = fromDate;
		setValueFromAccessor("FROM_DATE", CommonUtil.toString(fromDate));
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) throws Exception {
		this.toDate = toDate;
		setValueFromAccessor("TO_DATE", CommonUtil.toString(toDate));
	}

	public double getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(double createdBy) throws Exception {
		this.createdBy = createdBy;
		setValueFromAccessor("CREATED_BY", CommonUtil.toString(createdBy));
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) throws Exception {
		this.creationDate = creationDate;
		setValueFromAccessor("CREATION_DATE", CommonUtil.toString(creationDate));
	}

	public double getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(double lastUpdatedBy) throws Exception {
		this.lastUpdatedBy = lastUpdatedBy;
		setValueFromAccessor("LAST_UPDATED_BY", CommonUtil.toString(lastUpdatedBy));
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) throws Exception {
		this.lastUpdateDate = lastUpdateDate;
		setValueFromAccessor("LAST_UPDATE_DATE", CommonUtil.toString(lastUpdateDate));
	}

	public double getPersonId() {
		return personId;
	}

	public void setPersonId(double personId) throws Exception {
		this.personId = personId;
		setValueFromAccessor("PERSON_ID", CommonUtil.toString(personId));
	}

	public double getBillingOrganisationId() {
		return billingOrganisationId;
	}

	public void setBillingOrganisationId(double billingOrganisationId) throws Exception {
		this.billingOrganisationId = billingOrganisationId;
		setValueFromAccessor("BILLING_ORGANISATION_ID", CommonUtil.toString(billingOrganisationId));
	}

	public double getEuOrganisationId() {
		return euOrganisationId;
	}

	public void setEuOrganisationId(double euOrganisationId) throws Exception {
		this.euOrganisationId = euOrganisationId;
		setValueFromAccessor("EU_ORGANISATION_ID", CommonUtil.toString(euOrganisationId));
	}

	public String getApprovedExpenses() {
		return approvedExpenses;
	}

	public void setApprovedExpenses(String approvedExpenses) throws Exception {
		this.approvedExpenses = approvedExpenses;
		setValueFromAccessor("APPROVED_EXPENSES", approvedExpenses);
	}

	public String getAsgActive() {
		return asgActive;
	}

	public void setAsgActive(String asgActive) throws Exception {
		this.asgActive = asgActive;
		setValueFromAccessor("ASG_ACTIVE", asgActive);
	}

	public Date getAssignmentEndDate() {
		return assignmentEndDate;
	}

	public void setAssignmentEndDate(Date assignmentEndDate) throws Exception {
		this.assignmentEndDate = assignmentEndDate;
		setValueFromAccessor("ASSIGNMENT_END_DATE", CommonUtil.toString(assignmentEndDate));
	}

	public String getAssignmentNumber() {
		return assignmentNumber;
	}

	public void setAssignmentNumber(String assignmentNumber) throws Exception {
		this.assignmentNumber = assignmentNumber;
		setValueFromAccessor("ASSIGNMENT_NUMBER", assignmentNumber);
	}

	public Date getAssignmentStartDate() {
		return assignmentStartDate;
	}

	public void setAssignmentStartDate(Date assignmentStartDate) throws Exception {
		this.assignmentStartDate = assignmentStartDate;
		setValueFromAccessor("ASSIGNMENT_START_DATE", CommonUtil.toString(assignmentStartDate));
	}

	public String getAttribute1() {
		return attribute1;
	}

	public void setAttribute1(String attribute1) throws Exception {
		this.attribute1 = attribute1;
		setValueFromAccessor("ATTRIBUTE1", attribute1);
	}

	public String getAttribute10() {
		return attribute10;
	}

	public void setAttribute10(String attribute10) throws Exception {
		this.attribute10 = attribute10;
		setValueFromAccessor("ATTRIBUTE10", attribute10);
	}

	public String getAttribute9() {
		return attribute9;
	}

	public void setAttribute9(String attribute9) throws Exception {
		this.attribute9 = attribute9;
		setValueFromAccessor("ATTRIBUTE9", attribute9);
	}

	public String getAutomaticInvoice() {
		return automaticInvoice;
	}

	public void setAutomaticInvoice(String automaticInvoice) throws Exception {
		this.automaticInvoice = automaticInvoice;
		setValueFromAccessor("AUTOMATIC_INVOICE", automaticInvoice);
	}

	public String getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(String basicSalary) throws Exception {
		this.basicSalary = basicSalary;
		setValueFromAccessor("BASIC_SALARY", basicSalary);
	}

	public String getBillingCode() {
		return billingCode;
	}

	public void setBillingCode(String billingCode) throws Exception {
		this.billingCode = billingCode;
		setValueFromAccessor("BILLING_CODE", billingCode);
	}

	public double getBillingCodeId() {
		return billingCodeId;
	}

	public void setBillingCodeId(double billingCodeId) throws Exception {
		this.billingCodeId = billingCodeId;
		setValueFromAccessor("BILLING_CODE_ID", CommonUtil.toString(billingCodeId));
	}

	public double getBillingOrganisationPersonId() {
		return billingOrganisationPersonId;
	}

	public void setBillingOrganisationPersonId(double billingOrganisationPersonId) throws Exception {
		this.billingOrganisationPersonId = billingOrganisationPersonId;
		setValueFromAccessor("BILLING_ORGANISATION_PERSON_ID", CommonUtil.toString(billingOrganisationPersonId));
	}

	public double getBusinessGroupId() {
		return businessGroupId;
	}

	public void setBusinessGroupId(double businessGroupId) throws Exception {
		this.businessGroupId = businessGroupId;
		setValueFromAccessor("BUSINESS_GROUP_ID", CommonUtil.toString(businessGroupId));
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) throws Exception {
		this.comments = comments;
		setValueFromAccessor("COMMENTS", comments);
	}

	public String getCostCentre() {
		return costCentre;
	}

	public void setCostCentre(String costCentre) throws Exception {
		this.costCentre = costCentre;
		setValueFromAccessor("COST_CENTRE", costCentre);
	}

	public String getCreatedAs() {
		return createdAs;
	}

	public void setCreatedAs(String createdAs) throws Exception {
		this.createdAs = createdAs;
		setValueFromAccessor("CREATED_AS", createdAs);
	}

	public double getDeliverablesApprover1() {
		return deliverablesApprover1;
	}

	public void setDeliverablesApprover1(double deliverablesApprover1) throws Exception {
		this.deliverablesApprover1 = deliverablesApprover1;
		setValueFromAccessor("DELIVERABLES_APPROVER_1", CommonUtil.toString(deliverablesApprover1));
	}

	public double getDeliverablesApprover2() {
		return deliverablesApprover2;
	}

	public void setDeliverablesApprover2(double deliverablesApprover2) throws Exception {
		this.deliverablesApprover2 = deliverablesApprover2;
		setValueFromAccessor("DELIVERABLES_APPROVER_2", CommonUtil.toString(deliverablesApprover2));
	}

	public double getDeliverablesApprover3() {
		return deliverablesApprover3;
	}

	public void setDeliverablesApprover3(double deliverablesApprover3) throws Exception {
		this.deliverablesApprover3 = deliverablesApprover3;
		setValueFromAccessor("DELIVERABLES_APPROVER_3", CommonUtil.toString(deliverablesApprover3));
	}

	public double getDeliverablesApprNotiToId() {
		return deliverablesApprNotiToId;
	}

	public void setDeliverablesApprNotiToId(double deliverablesApprNotiToId) throws Exception {
		this.deliverablesApprNotiToId = deliverablesApprNotiToId;
		setValueFromAccessor("DELIVERABLES_APPR_NOTI_TO_ID", CommonUtil.toString(deliverablesApprNotiToId));
	}

	public double getDeliverablesApprNotiToOrg() {
		return deliverablesApprNotiToOrg;
	}

	public void setDeliverablesApprNotiToOrg(double deliverablesApprNotiToOrg) throws Exception {
		this.deliverablesApprNotiToOrg = deliverablesApprNotiToOrg;
		setValueFromAccessor("DELIVERABLES_APPR_NOTI_TO_ORG", CommonUtil.toString(deliverablesApprNotiToOrg));
	}

	public String getDeliverablesName() {
		return deliverablesName;
	}

	public void setDeliverablesName(String deliverablesName) throws Exception {
		this.deliverablesName = deliverablesName;
		setValueFromAccessor("DELIVERABLES_NAME", deliverablesName);
	}

	public double getElement1() {
		return element1;
	}

	public void setElement1(double element1) throws Exception {
		this.element1 = element1;
		setValueFromAccessor("ELEMENT_1", CommonUtil.toString(element1));
	}

	public double getElement2() {
		return element2;
	}

	public void setElement2(double element2) throws Exception {
		this.element2 = element2;
		setValueFromAccessor("ELEMENT_2", CommonUtil.toString(element2));
	}

	public double getElement3() {
		return element3;
	}

	public void setElement3(double element3) throws Exception {
		this.element3 = element3;
		setValueFromAccessor("ELEMENT_3", CommonUtil.toString(element3));
	}

	public double getElement4() {
		return element4;
	}

	public void setElement4(double element4) throws Exception {
		this.element4 = element4;
		setValueFromAccessor("ELEMENT_4", CommonUtil.toString(element4));
	}

	public double getElement5() {
		return element5;
	}

	public void setElement5(double element5) throws Exception {
		this.element5 = element5;
		setValueFromAccessor("ELEMENT_5", CommonUtil.toString(element5));
	}

	public String getEngagementContractType() {
		return engagementContractType;
	}

	public void setEngagementContractType(String engagementContractType) throws Exception {
		this.engagementContractType = engagementContractType;
		setValueFromAccessor("ENGAGEMENT_CONTRACT_TYPE", engagementContractType);
	}

	public String getEquipmentDetails() {
		return equipmentDetails;
	}

	public void setEquipmentDetails(String equipmentDetails) throws Exception {
		this.equipmentDetails = equipmentDetails;
		setValueFromAccessor("EQUIPMENT_DETAILS", equipmentDetails);
	}

	public String getEquipmentRequiredYn() {
		return equipmentRequiredYn;
	}

	public void setEquipmentRequiredYn(String equipmentRequiredYn) throws Exception {
		this.equipmentRequiredYn = equipmentRequiredYn;
		setValueFromAccessor("EQUIPMENT_REQUIRED_YN", equipmentRequiredYn);
	}

	public double getEtsApprovalNotificationTo() {
		return etsApprovalNotificationTo;
	}

	public void setEtsApprovalNotificationTo(double etsApprovalNotificationTo) throws Exception {
		this.etsApprovalNotificationTo = etsApprovalNotificationTo;
		setValueFromAccessor("ETS_APPROVAL_NOTIFICATION_TO", CommonUtil.toString(etsApprovalNotificationTo));
	}

	public double getEtsApprovalNotiTo2() {
		return etsApprovalNotiTo2;
	}

	public void setEtsApprovalNotiTo2(double etsApprovalNotiTo2) throws Exception {
		this.etsApprovalNotiTo2 = etsApprovalNotiTo2;
		setValueFromAccessor("ETS_APPROVAL_NOTI_TO_2", CommonUtil.toString(etsApprovalNotiTo2));
	}

	public double getEuContactPersonId() {
		return euContactPersonId;
	}

	public void setEuContactPersonId(double euContactPersonId) throws Exception {
		this.euContactPersonId = euContactPersonId;
		setValueFromAccessor("EU_CONTACT_PERSON_ID", CommonUtil.toString(euContactPersonId));
	}

	public double getExpenseApprovalNotiToId() {
		return expenseApprovalNotiToId;
	}

	public void setExpenseApprovalNotiToId(double expenseApprovalNotiToId) throws Exception {
		this.expenseApprovalNotiToId = expenseApprovalNotiToId;
		setValueFromAccessor("EXPENSE_APPROVAL_NOTI_TO_ID", CommonUtil.toString(expenseApprovalNotiToId));
	}

	public double getExpenseApprovalNotiToOrg() {
		return expenseApprovalNotiToOrg;
	}

	public void setExpenseApprovalNotiToOrg(double expenseApprovalNotiToOrg) throws Exception {
		this.expenseApprovalNotiToOrg = expenseApprovalNotiToOrg;
		setValueFromAccessor("EXPENSE_APPROVAL_NOTI_TO_ORG", CommonUtil.toString(expenseApprovalNotiToOrg));
	}

	public double getExpenseApprover1() {
		return expenseApprover1;
	}

	public void setExpenseApprover1(double expenseApprover1) throws Exception {
		this.expenseApprover1 = expenseApprover1;
		setValueFromAccessor("EXPENSE_APPROVER_1", CommonUtil.toString(expenseApprover1));
	}

	public double getExpenseApprover2() {
		return expenseApprover2;
	}

	public void setExpenseApprover2(double expenseApprover2) throws Exception {
		this.expenseApprover2 = expenseApprover2;
		setValueFromAccessor("EXPENSE_APPROVER_2", CommonUtil.toString(expenseApprover2));
	}

	public double getExpenseApprover3() {
		return expenseApprover3;
	}

	public void setExpenseApprover3(double expenseApprover3) throws Exception {
		this.expenseApprover3 = expenseApprover3;
		setValueFromAccessor("EXPENSE_APPROVER_3", CommonUtil.toString(expenseApprover3));
	}

	public String getExpenseName() {
		return expenseName;
	}

	public void setExpenseName(String expenseName) throws Exception {
		this.expenseName = expenseName;
		setValueFromAccessor("EXPENSE_NAME", expenseName);
	}

	public String getGstExempt() {
		return gstExempt;
	}

	public void setGstExempt(String gstExempt) throws Exception {
		this.gstExempt = gstExempt;
		setValueFromAccessor("GST_EXEMPT", gstExempt);
	}

	public String getInvoiceRecipientEmail() {
		return invoiceRecipientEmail;
	}

	public void setInvoiceRecipientEmail(String invoiceRecipientEmail) throws Exception {
		this.invoiceRecipientEmail = invoiceRecipientEmail;
		setValueFromAccessor("INVOICE_RECIPIENT_EMAIL", invoiceRecipientEmail);
	}

	public String getIsBulkApproval() {
		return isBulkApproval;
	}

	public void setIsBulkApproval(String isBulkApproval) throws Exception {
		this.isBulkApproval = isBulkApproval;
		setValueFromAccessor("IS_BULK_APPROVAL", isBulkApproval);
	}

	public String getIsBulkApprovalDeliverables() {
		return isBulkApprovalDeliverables;
	}

	public void setIsBulkApprovalDeliverables(String isBulkApprovalDeliverables) throws Exception {
		this.isBulkApprovalDeliverables = isBulkApprovalDeliverables;
		setValueFromAccessor("IS_BULK_APPROVAL_DELIVERABLES", isBulkApprovalDeliverables);
	}

	public String getIsBulkApprovalExpense() {
		return isBulkApprovalExpense;
	}

	public void setIsBulkApprovalExpense(String isBulkApprovalExpense) throws Exception {
		this.isBulkApprovalExpense = isBulkApprovalExpense;
		setValueFromAccessor("IS_BULK_APPROVAL_EXPENSE", isBulkApprovalExpense);
	}

	public String getIsDaily() {
		return isDaily;
	}

	public void setIsDaily(String isDaily) throws Exception {
		this.isDaily = isDaily;
		setValueFromAccessor("IS_DAILY", isDaily);
	}

	public String getIsStartEndTime() {
		return isStartEndTime;
	}

	public void setIsStartEndTime(String isStartEndTime) throws Exception {
		this.isStartEndTime = isStartEndTime;
		setValueFromAccessor("IS_START_END_TIME", isStartEndTime);
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) throws Exception {
		this.jobTitle = jobTitle;
		setValueFromAccessor("JOB_TITLE", jobTitle);
	}

	public String getModernAwardDescription() {
		return modernAwardDescription;
	}

	public void setModernAwardDescription(String modernAwardDescription) throws Exception {
		this.modernAwardDescription = modernAwardDescription;
		setValueFromAccessor("MODERN_AWARD_DESCRIPTION", modernAwardDescription);
	}

	public double getModernAwardId() {
		return modernAwardId;
	}

	public void setModernAwardId(double modernAwardId) throws Exception {
		this.modernAwardId = modernAwardId;
		setValueFromAccessor("MODERN_AWARD_ID", CommonUtil.toString(modernAwardId));
	}

	public String getPayrollNotes() {
		return payrollNotes;
	}

	public void setPayrollNotes(String payrollNotes) throws Exception {
		this.payrollNotes = payrollNotes;
		setValueFromAccessor("PAYROLL_NOTES", payrollNotes);
	}

	public String getPayslipEmail() {
		return payslipEmail;
	}

	public void setPayslipEmail(String payslipEmail) throws Exception {
		this.payslipEmail = payslipEmail;
		setValueFromAccessor("PAYSLIP_EMAIL", payslipEmail);
	}

	public String getPayArrangement() {
		return payArrangement;
	}

	public void setPayArrangement(String payArrangement) throws Exception {
		this.payArrangement = payArrangement;
		setValueFromAccessor("PAY_ARRANGEMENT", payArrangement);
	}

	public double getPayMethodId() {
		return payMethodId;
	}

	public void setPayMethodId(double payMethodId) throws Exception {
		this.payMethodId = payMethodId;
		setValueFromAccessor("PAY_METHOD_ID", CommonUtil.toString(payMethodId));
	}

	public String getPreferred() {
		return preferred;
	}

	public void setPreferred(String preferred) throws Exception {
		this.preferred = preferred;
		setValueFromAccessor("PREFERRED", preferred);
	}

	public String getPrtStatus() {
		return prtStatus;
	}

	public void setPrtStatus(String prtStatus) throws Exception {
		this.prtStatus = prtStatus;
		setValueFromAccessor("PRT_STATUS", prtStatus);
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) throws Exception {
		this.rate = rate;
		setValueFromAccessor("RATE", CommonUtil.toString(rate));
	}

	public double getRate1() {
		return rate1;
	}

	public void setRate1(double rate1) throws Exception {
		this.rate1 = rate1;
		setValueFromAccessor("RATE1", CommonUtil.toString(rate1));
	}

	public double getRate2() {
		return rate2;
	}

	public void setRate2(double rate2) throws Exception {
		this.rate2 = rate2;
		setValueFromAccessor("RATE2", CommonUtil.toString(rate2));
	}

	public double getRate3() {
		return rate3;
	}

	public void setRate3(double rate3) throws Exception {
		this.rate3 = rate3;
		setValueFromAccessor("RATE3", CommonUtil.toString(rate3));
	}

	public double getRate4() {
		return rate4;
	}

	public void setRate4(double rate4) throws Exception {
		this.rate4 = rate4;
		setValueFromAccessor("RATE4", CommonUtil.toString(rate4));
	}

	public double getRate5() {
		return rate5;
	}

	public void setRate5(double rate5) throws Exception {
		this.rate5 = rate5;
		setValueFromAccessor("RATE5", CommonUtil.toString(rate5));
	}

	public String getReferenceAPo() {
		return referenceAPo;
	}

	public void setReferenceAPo(String referenceAPo) throws Exception {
		this.referenceAPo = referenceAPo;
		setValueFromAccessor("REFERENCE_A_PO", referenceAPo);
	}

	public String getReferenceB() {
		return referenceB;
	}

	public void setReferenceB(String referenceB) throws Exception {
		this.referenceB = referenceB;
		setValueFromAccessor("REFERENCE_B", referenceB);
	}

	public String getReferenceC() {
		return referenceC;
	}

	public void setReferenceC(String referenceC) throws Exception {
		this.referenceC = referenceC;
		setValueFromAccessor("REFERENCE_C", referenceC);
	}

	public String getReferenceD() {
		return referenceD;
	}

	public void setReferenceD(String referenceD) throws Exception {
		this.referenceD = referenceD;
		setValueFromAccessor("REFERENCE_D", referenceD);
	}

	public String getReferenceNo1() {
		return referenceNo1;
	}

	public void setReferenceNo1(String referenceNo1) throws Exception {
		this.referenceNo1 = referenceNo1;
		setValueFromAccessor("REFERENCE_NO_1", referenceNo1);
	}

	public String getReferenceNo2() {
		return referenceNo2;
	}

	public void setReferenceNo2(String referenceNo2) throws Exception {
		this.referenceNo2 = referenceNo2;
		setValueFromAccessor("REFERENCE_NO_2", referenceNo2);
	}

	public String getReferenceNo3() {
		return referenceNo3;
	}

	public void setReferenceNo3(String referenceNo3) throws Exception {
		this.referenceNo3 = referenceNo3;
		setValueFromAccessor("REFERENCE_NO_3", referenceNo3);
	}

	public String getRestraintOfTrade() {
		return restraintOfTrade;
	}

	public void setRestraintOfTrade(String restraintOfTrade) throws Exception {
		this.restraintOfTrade = restraintOfTrade;
		setValueFromAccessor("RESTRAINT_OF_TRADE", restraintOfTrade);
	}

	public String getServiceDescription() {
		return serviceDescription;
	}

	public void setServiceDescription(String serviceDescription) throws Exception {
		this.serviceDescription = serviceDescription;
		setValueFromAccessor("SERVICE_DESCRIPTION", serviceDescription);
	}

	public String getSpecialConditions() {
		return specialConditions;
	}

	public void setSpecialConditions(String specialConditions) throws Exception {
		this.specialConditions = specialConditions;
		setValueFromAccessor("SPECIAL_CONDITIONS", specialConditions);
	}

	public String getTerminationNotice() {
		return terminationNotice;
	}

	public void setTerminationNotice(String terminationNotice) throws Exception {
		this.terminationNotice = terminationNotice;
		setValueFromAccessor("TERMINATION_NOTICE", terminationNotice);
	}

	public String getTerminationNoticeUnit() {
		return terminationNoticeUnit;
	}

	public void setTerminationNoticeUnit(String terminationNoticeUnit) throws Exception {
		this.terminationNoticeUnit = terminationNoticeUnit;
		setValueFromAccessor("TERMINATION_NOTICE_UNIT", terminationNoticeUnit);
	}

	public double getTimecardApprovalId() {
		return timecardApprovalId;
	}

	public void setTimecardApprovalId(double timecardApprovalId) throws Exception {
		this.timecardApprovalId = timecardApprovalId;
		setValueFromAccessor("TIMECARD_APPROVAL_ID", CommonUtil.toString(timecardApprovalId));
	}

	public String getTimecardApprovalRateHidden() {
		return timecardApprovalRateHidden;
	}

	public void setTimecardApprovalRateHidden(String timecardApprovalRateHidden) throws Exception {
		this.timecardApprovalRateHidden = timecardApprovalRateHidden;
		setValueFromAccessor("TIMECARD_APPROVAL_RATE_HIDDEN", timecardApprovalRateHidden);
	}

	public String getTimecardLayout() {
		return timecardLayout;
	}

	public void setTimecardLayout(String timecardLayout) throws Exception {
		this.timecardLayout = timecardLayout;
		setValueFromAccessor("TIMECARD_LAYOUT", timecardLayout);
	}

	public String getTimecardRequired() {
		return timecardRequired;
	}

	public void setTimecardRequired(String timecardRequired) throws Exception {
		this.timecardRequired = timecardRequired;
		setValueFromAccessor("TIMECARD_REQUIRED", timecardRequired);
	}

	public double getTimecardSecondaryApprovalId() {
		return timecardSecondaryApprovalId;
	}

	public void setTimecardSecondaryApprovalId(double timecardSecondaryApprovalId) throws Exception {
		this.timecardSecondaryApprovalId = timecardSecondaryApprovalId;
		setValueFromAccessor("TIMECARD_SECONDARY_APPROVAL_ID", CommonUtil.toString(timecardSecondaryApprovalId));
	}

	public double getTimecardTertiaryApprovalId() {
		return timecardTertiaryApprovalId;
	}

	public void setTimecardTertiaryApprovalId(double timecardTertiaryApprovalId) throws Exception {
		this.timecardTertiaryApprovalId = timecardTertiaryApprovalId;
		setValueFromAccessor("TIMECARD_TERTIARY_APPROVAL_ID", CommonUtil.toString(timecardTertiaryApprovalId));
	}

	public String getTimesheetName() {
		return timesheetName;
	}

	public void setTimesheetName(String timesheetName) throws Exception {
		this.timesheetName = timesheetName;
		setValueFromAccessor("TIMESHEET_NAME", timesheetName);
	}

	public String getTimesheetUnits() {
		return timesheetUnits;
	}

	public void setTimesheetUnits(String timesheetUnits) throws Exception {
		this.timesheetUnits = timesheetUnits;
		setValueFromAccessor("TIMESHEET_UNITS", timesheetUnits);
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) throws Exception {
		this.unit = unit;
		setValueFromAccessor("UNIT", unit);
	}

	public String getUseAwardCalculation() {
		return useAwardCalculation;
	}

	public void setUseAwardCalculation(String useAwardCalculation) throws Exception {
		this.useAwardCalculation = useAwardCalculation;
		setValueFromAccessor("USE_AWARD_CALCULATION", useAwardCalculation);
	}

	public String getUseDeliverables() {
		return useDeliverables;
	}

	public void setUseDeliverables(String useDeliverables) throws Exception {
		this.useDeliverables = useDeliverables;
		setValueFromAccessor("USE_DELIVERABLES", useDeliverables);
	}

	public String getUseExpense() {
		return useExpense;
	}

	public void setUseExpense(String useExpense) throws Exception {
		this.useExpense = useExpense;
		setValueFromAccessor("USE_EXPENSE", useExpense);
	}

	public String getWcOrganisationTypeFlag() {
		return wcOrganisationTypeFlag;
	}

	public void setWcOrganisationTypeFlag(String wcOrganisationTypeFlag) throws Exception {
		this.wcOrganisationTypeFlag = wcOrganisationTypeFlag;
		setValueFromAccessor("WC_ORGANISATION_TYPE_FLAG", wcOrganisationTypeFlag);
	}

	public double getWcOrgCodeRateLinkId() {
		return wcOrgCodeRateLinkId;
	}

	public void setWcOrgCodeRateLinkId(double wcOrgCodeRateLinkId) throws Exception {
		this.wcOrgCodeRateLinkId = wcOrgCodeRateLinkId;
		setValueFromAccessor("WC_ORG_CODE_RATE_LINK_ID", CommonUtil.toString(wcOrgCodeRateLinkId));
	}

	public String getWorkingState() {
		return workingState;
	}

	public void setWorkingState(String workingState) throws Exception {
		this.workingState = workingState;
		setValueFromAccessor("WORKING_STATE", workingState);
	}

	public String getWorkEndTime() {
		return workEndTime;
	}

	public void setWorkEndTime(String workEndTime) throws Exception {
		this.workEndTime = workEndTime;
		setValueFromAccessor("WORK_END_TIME", workEndTime);
	}

	public String getWorkStartTime() {
		return workStartTime;
	}

	public void setWorkStartTime(String workStartTime) throws Exception {
		this.workStartTime = workStartTime;
		setValueFromAccessor("WORK_START_TIME", workStartTime);
	}

	public String getInsertUserName() {
		return insertUserName;
	}

	public void setInsertUserName(String insertUserName) throws Exception {
		this.insertUserName = insertUserName;
		setValueFromAccessor("INSERT_USER_NAME", insertUserName);
	}

	public String getUpdateUserName() {
		return updateUserName;
	}

	public void setUpdateUserName(String updateUserName) throws Exception {
		this.updateUserName = updateUserName;
		setValueFromAccessor("UPDATE_USER_NAME", updateUserName);
	}

	/**
	 * Hibernate Methods - If the primary key is composed of multiple columns
	 */
	public boolean equals(Object object) {
		if (!(object instanceof HpAssignmentsD)) {
			return false;
		}
		return true;
	}

	public int hashCode() {
		return 1;
	}

	/**
	 * Framework Methods
	 */
	public void setDefaultValue() throws Exception {
		String columns[] = CommonUtil.split(getFrwVarDefaultColumn(), ",");
		String values[] = CommonUtil.split(getFrwVarDefaultValue(), ",");

		if (CommonUtil.isNotEmpty(columns)) {
			for (int i=0; i<columns.length; i++) {
				setValue(columns[i], values[i]);
			}
		}
	}

	@SuppressWarnings("rawtypes")
	public void setValue(String columnName, String value) throws Exception {
		Class cls = getClass();
		Field field[] = cls.getDeclaredFields();

		dataSet.setValue(dataSet.getRowCnt()-1, columnName, value);
		for (int i=0; i<field.length; i++) {
			if (field[i].getName().equals(CommonUtil.toCamelCaseStartLowerCase(columnName))) {
				if (CommonUtil.isIn(columnName, CommonUtil.split(getFrwVarNumberColumn(), ","))) {
					field[i].set(this, CommonUtil.toDouble(value));
				} else if (CommonUtil.isIn(columnName, CommonUtil.split(getFrwVarDateColumn(), ","))) {
					if (CommonUtil.equalsIgnoreCase(value, "SYSDATE") || CommonUtil.containsIgnoreCase(value, "SYSDATE")) {
						field[i].set(this, CommonUtil.toDate(CommonUtil.getSysdate()));
					} else {
						field[i].set(this, CommonUtil.toDate(value));
					}
				} else {
					field[i].set(this, value);
				}
			}
		}
	}

	public void setValues(DataSet dataSet) throws Exception {
		for (int i=0; i<dataSet.getColumnCnt(); i++) {
			setValue(dataSet.getName(i), dataSet.getValue(i));
		}
	}

	public void setValues(DataSet dataSet, int rowIndex) throws Exception {
		for (int i=0; i<dataSet.getColumnCnt(); i++) {
			setValue(dataSet.getName(i), dataSet.getValue(rowIndex, i));
		}
	}

	private void setValueFromAccessor(String columnName, String value) throws Exception {
		dataSet.setValue(dataSet.getRowCnt()-1, columnName, value);
	}

	public void setConvertedTypeValue(String columnName, String value) throws Exception {
		String numberColumn = "", dateColumn = "";

		numberColumn = getFrwVarNumberColumn();
		dateColumn = getFrwVarDateColumn();

		setValue(columnName, value);

		numberColumn += (CommonUtil.isEmpty(numberColumn)) ? CommonUtil.upperCase(columnName) : "," + CommonUtil.upperCase(columnName);
		dateColumn = CommonUtil.replace(dateColumn, columnName, "");

		setFrwVarNumberColumn(numberColumn);
		setFrwVarDateColumn(dateColumn);
	}

	public String getValue(String columnName) throws Exception {
		return dataSet.getValue(dataSet.getRowCnt()-1, columnName);
	}

	public void addUpdateColumn(String columnName, String columnValue) throws Exception {
		String dataType = "";

		if (CommonUtil.isInIgnoreCase(columnName, CommonUtil.split(getFrwVarNumberColumn(), ","))) {
			dataType = "Number";
		} else if (CommonUtil.isInIgnoreCase(columnName, CommonUtil.split(getFrwVarDateColumn(), ","))) {
			dataType = "Date";
		} else {
			dataType = "String";
		}

		addUpdateColumn(columnName, columnValue, dataType);
	}

	/**
	 * dataType : String / Number / Date
	 */
	public void addUpdateColumn(String columnName, String columnValue, String dataType) throws Exception {
		updateColumnsDataSet.addRow();
		updateColumnsDataSet.setValue(updateColumnsDataSet.getRowCnt()-1, "COLUMN_NAME", columnName);
		updateColumnsDataSet.setValue(updateColumnsDataSet.getRowCnt()-1, "COLUMN_VALUE", columnValue);
		updateColumnsDataSet.setValue(updateColumnsDataSet.getRowCnt()-1, "DATA_TYPE", CommonUtil.nvl(dataType, "String"));
	}

	public void addUpdateColumnFromField() throws Exception {
		for (int i=0; i<dataSet.getColumnCnt(); i++) {
			if (CommonUtil.isNotBlank(dataSet.getValue(i))) {
				if (CommonUtil.equalsIgnoreCase(dataSet.getName(i), "INSERT_DATE") && CommonUtil.equalsIgnoreCase(dataSet.getValue(i), "SYSDATE")) {
					continue;
				}
				addUpdateColumn(dataSet.getName(i), dataSet.getValue(i));
			}
		}
	}

	/**
	 * toString
	 */
	public String toString() {
		String str = "";

		str += "assignmentId : "+assignmentId+"\n";
		str += "fromDate : "+fromDate+"\n";
		str += "toDate : "+toDate+"\n";
		str += "createdBy : "+createdBy+"\n";
		str += "creationDate : "+creationDate+"\n";
		str += "lastUpdatedBy : "+lastUpdatedBy+"\n";
		str += "lastUpdateDate : "+lastUpdateDate+"\n";
		str += "personId : "+personId+"\n";
		str += "billingOrganisationId : "+billingOrganisationId+"\n";
		str += "euOrganisationId : "+euOrganisationId+"\n";
		str += "approvedExpenses : "+approvedExpenses+"\n";
		str += "asgActive : "+asgActive+"\n";
		str += "assignmentEndDate : "+assignmentEndDate+"\n";
		str += "assignmentNumber : "+assignmentNumber+"\n";
		str += "assignmentStartDate : "+assignmentStartDate+"\n";
		str += "attribute1 : "+attribute1+"\n";
		str += "attribute10 : "+attribute10+"\n";
		str += "attribute9 : "+attribute9+"\n";
		str += "automaticInvoice : "+automaticInvoice+"\n";
		str += "basicSalary : "+basicSalary+"\n";
		str += "billingCode : "+billingCode+"\n";
		str += "billingCodeId : "+billingCodeId+"\n";
		str += "billingOrganisationPersonId : "+billingOrganisationPersonId+"\n";
		str += "businessGroupId : "+businessGroupId+"\n";
		str += "comments : "+comments+"\n";
		str += "costCentre : "+costCentre+"\n";
		str += "createdAs : "+createdAs+"\n";
		str += "deliverablesApprover1 : "+deliverablesApprover1+"\n";
		str += "deliverablesApprover2 : "+deliverablesApprover2+"\n";
		str += "deliverablesApprover3 : "+deliverablesApprover3+"\n";
		str += "deliverablesApprNotiToId : "+deliverablesApprNotiToId+"\n";
		str += "deliverablesApprNotiToOrg : "+deliverablesApprNotiToOrg+"\n";
		str += "deliverablesName : "+deliverablesName+"\n";
		str += "element1 : "+element1+"\n";
		str += "element2 : "+element2+"\n";
		str += "element3 : "+element3+"\n";
		str += "element4 : "+element4+"\n";
		str += "element5 : "+element5+"\n";
		str += "engagementContractType : "+engagementContractType+"\n";
		str += "equipmentDetails : "+equipmentDetails+"\n";
		str += "equipmentRequiredYn : "+equipmentRequiredYn+"\n";
		str += "etsApprovalNotificationTo : "+etsApprovalNotificationTo+"\n";
		str += "etsApprovalNotiTo2 : "+etsApprovalNotiTo2+"\n";
		str += "euContactPersonId : "+euContactPersonId+"\n";
		str += "expenseApprovalNotiToId : "+expenseApprovalNotiToId+"\n";
		str += "expenseApprovalNotiToOrg : "+expenseApprovalNotiToOrg+"\n";
		str += "expenseApprover1 : "+expenseApprover1+"\n";
		str += "expenseApprover2 : "+expenseApprover2+"\n";
		str += "expenseApprover3 : "+expenseApprover3+"\n";
		str += "expenseName : "+expenseName+"\n";
		str += "gstExempt : "+gstExempt+"\n";
		str += "invoiceRecipientEmail : "+invoiceRecipientEmail+"\n";
		str += "isBulkApproval : "+isBulkApproval+"\n";
		str += "isBulkApprovalDeliverables : "+isBulkApprovalDeliverables+"\n";
		str += "isBulkApprovalExpense : "+isBulkApprovalExpense+"\n";
		str += "isDaily : "+isDaily+"\n";
		str += "isStartEndTime : "+isStartEndTime+"\n";
		str += "jobTitle : "+jobTitle+"\n";
		str += "modernAwardDescription : "+modernAwardDescription+"\n";
		str += "modernAwardId : "+modernAwardId+"\n";
		str += "payrollNotes : "+payrollNotes+"\n";
		str += "payslipEmail : "+payslipEmail+"\n";
		str += "payArrangement : "+payArrangement+"\n";
		str += "payMethodId : "+payMethodId+"\n";
		str += "preferred : "+preferred+"\n";
		str += "prtStatus : "+prtStatus+"\n";
		str += "rate : "+rate+"\n";
		str += "rate1 : "+rate1+"\n";
		str += "rate2 : "+rate2+"\n";
		str += "rate3 : "+rate3+"\n";
		str += "rate4 : "+rate4+"\n";
		str += "rate5 : "+rate5+"\n";
		str += "referenceAPo : "+referenceAPo+"\n";
		str += "referenceB : "+referenceB+"\n";
		str += "referenceC : "+referenceC+"\n";
		str += "referenceD : "+referenceD+"\n";
		str += "referenceNo1 : "+referenceNo1+"\n";
		str += "referenceNo2 : "+referenceNo2+"\n";
		str += "referenceNo3 : "+referenceNo3+"\n";
		str += "restraintOfTrade : "+restraintOfTrade+"\n";
		str += "serviceDescription : "+serviceDescription+"\n";
		str += "specialConditions : "+specialConditions+"\n";
		str += "terminationNotice : "+terminationNotice+"\n";
		str += "terminationNoticeUnit : "+terminationNoticeUnit+"\n";
		str += "timecardApprovalId : "+timecardApprovalId+"\n";
		str += "timecardApprovalRateHidden : "+timecardApprovalRateHidden+"\n";
		str += "timecardLayout : "+timecardLayout+"\n";
		str += "timecardRequired : "+timecardRequired+"\n";
		str += "timecardSecondaryApprovalId : "+timecardSecondaryApprovalId+"\n";
		str += "timecardTertiaryApprovalId : "+timecardTertiaryApprovalId+"\n";
		str += "timesheetName : "+timesheetName+"\n";
		str += "timesheetUnits : "+timesheetUnits+"\n";
		str += "unit : "+unit+"\n";
		str += "useAwardCalculation : "+useAwardCalculation+"\n";
		str += "useDeliverables : "+useDeliverables+"\n";
		str += "useExpense : "+useExpense+"\n";
		str += "wcOrganisationTypeFlag : "+wcOrganisationTypeFlag+"\n";
		str += "wcOrgCodeRateLinkId : "+wcOrgCodeRateLinkId+"\n";
		str += "workingState : "+workingState+"\n";
		str += "workEndTime : "+workEndTime+"\n";
		str += "workStartTime : "+workStartTime+"\n";
		str += "insertUserName : "+insertUserName+"\n";
		str += "updateUserName : "+updateUserName+"\n";

		return str;
	}

	/**
	 * toXmlString
	 */
	public String toXmlString() {
		String str = "";

		str += "<column name=\"assignmentId\" value=\""+assignmentId+"\">";
		str += "<column name=\"fromDate\" value=\""+fromDate+"\">";
		str += "<column name=\"toDate\" value=\""+toDate+"\">";
		str += "<column name=\"createdBy\" value=\""+createdBy+"\">";
		str += "<column name=\"creationDate\" value=\""+creationDate+"\">";
		str += "<column name=\"lastUpdatedBy\" value=\""+lastUpdatedBy+"\">";
		str += "<column name=\"lastUpdateDate\" value=\""+lastUpdateDate+"\">";
		str += "<column name=\"personId\" value=\""+personId+"\">";
		str += "<column name=\"billingOrganisationId\" value=\""+billingOrganisationId+"\">";
		str += "<column name=\"euOrganisationId\" value=\""+euOrganisationId+"\">";
		str += "<column name=\"approvedExpenses\" value=\""+approvedExpenses+"\">";
		str += "<column name=\"asgActive\" value=\""+asgActive+"\">";
		str += "<column name=\"assignmentEndDate\" value=\""+assignmentEndDate+"\">";
		str += "<column name=\"assignmentNumber\" value=\""+assignmentNumber+"\">";
		str += "<column name=\"assignmentStartDate\" value=\""+assignmentStartDate+"\">";
		str += "<column name=\"attribute1\" value=\""+attribute1+"\">";
		str += "<column name=\"attribute10\" value=\""+attribute10+"\">";
		str += "<column name=\"attribute9\" value=\""+attribute9+"\">";
		str += "<column name=\"automaticInvoice\" value=\""+automaticInvoice+"\">";
		str += "<column name=\"basicSalary\" value=\""+basicSalary+"\">";
		str += "<column name=\"billingCode\" value=\""+billingCode+"\">";
		str += "<column name=\"billingCodeId\" value=\""+billingCodeId+"\">";
		str += "<column name=\"billingOrganisationPersonId\" value=\""+billingOrganisationPersonId+"\">";
		str += "<column name=\"businessGroupId\" value=\""+businessGroupId+"\">";
		str += "<column name=\"comments\" value=\""+comments+"\">";
		str += "<column name=\"costCentre\" value=\""+costCentre+"\">";
		str += "<column name=\"createdAs\" value=\""+createdAs+"\">";
		str += "<column name=\"deliverablesApprover1\" value=\""+deliverablesApprover1+"\">";
		str += "<column name=\"deliverablesApprover2\" value=\""+deliverablesApprover2+"\">";
		str += "<column name=\"deliverablesApprover3\" value=\""+deliverablesApprover3+"\">";
		str += "<column name=\"deliverablesApprNotiToId\" value=\""+deliverablesApprNotiToId+"\">";
		str += "<column name=\"deliverablesApprNotiToOrg\" value=\""+deliverablesApprNotiToOrg+"\">";
		str += "<column name=\"deliverablesName\" value=\""+deliverablesName+"\">";
		str += "<column name=\"element1\" value=\""+element1+"\">";
		str += "<column name=\"element2\" value=\""+element2+"\">";
		str += "<column name=\"element3\" value=\""+element3+"\">";
		str += "<column name=\"element4\" value=\""+element4+"\">";
		str += "<column name=\"element5\" value=\""+element5+"\">";
		str += "<column name=\"engagementContractType\" value=\""+engagementContractType+"\">";
		str += "<column name=\"equipmentDetails\" value=\""+equipmentDetails+"\">";
		str += "<column name=\"equipmentRequiredYn\" value=\""+equipmentRequiredYn+"\">";
		str += "<column name=\"etsApprovalNotificationTo\" value=\""+etsApprovalNotificationTo+"\">";
		str += "<column name=\"etsApprovalNotiTo2\" value=\""+etsApprovalNotiTo2+"\">";
		str += "<column name=\"euContactPersonId\" value=\""+euContactPersonId+"\">";
		str += "<column name=\"expenseApprovalNotiToId\" value=\""+expenseApprovalNotiToId+"\">";
		str += "<column name=\"expenseApprovalNotiToOrg\" value=\""+expenseApprovalNotiToOrg+"\">";
		str += "<column name=\"expenseApprover1\" value=\""+expenseApprover1+"\">";
		str += "<column name=\"expenseApprover2\" value=\""+expenseApprover2+"\">";
		str += "<column name=\"expenseApprover3\" value=\""+expenseApprover3+"\">";
		str += "<column name=\"expenseName\" value=\""+expenseName+"\">";
		str += "<column name=\"gstExempt\" value=\""+gstExempt+"\">";
		str += "<column name=\"invoiceRecipientEmail\" value=\""+invoiceRecipientEmail+"\">";
		str += "<column name=\"isBulkApproval\" value=\""+isBulkApproval+"\">";
		str += "<column name=\"isBulkApprovalDeliverables\" value=\""+isBulkApprovalDeliverables+"\">";
		str += "<column name=\"isBulkApprovalExpense\" value=\""+isBulkApprovalExpense+"\">";
		str += "<column name=\"isDaily\" value=\""+isDaily+"\">";
		str += "<column name=\"isStartEndTime\" value=\""+isStartEndTime+"\">";
		str += "<column name=\"jobTitle\" value=\""+jobTitle+"\">";
		str += "<column name=\"modernAwardDescription\" value=\""+modernAwardDescription+"\">";
		str += "<column name=\"modernAwardId\" value=\""+modernAwardId+"\">";
		str += "<column name=\"payrollNotes\" value=\""+payrollNotes+"\">";
		str += "<column name=\"payslipEmail\" value=\""+payslipEmail+"\">";
		str += "<column name=\"payArrangement\" value=\""+payArrangement+"\">";
		str += "<column name=\"payMethodId\" value=\""+payMethodId+"\">";
		str += "<column name=\"preferred\" value=\""+preferred+"\">";
		str += "<column name=\"prtStatus\" value=\""+prtStatus+"\">";
		str += "<column name=\"rate\" value=\""+rate+"\">";
		str += "<column name=\"rate1\" value=\""+rate1+"\">";
		str += "<column name=\"rate2\" value=\""+rate2+"\">";
		str += "<column name=\"rate3\" value=\""+rate3+"\">";
		str += "<column name=\"rate4\" value=\""+rate4+"\">";
		str += "<column name=\"rate5\" value=\""+rate5+"\">";
		str += "<column name=\"referenceAPo\" value=\""+referenceAPo+"\">";
		str += "<column name=\"referenceB\" value=\""+referenceB+"\">";
		str += "<column name=\"referenceC\" value=\""+referenceC+"\">";
		str += "<column name=\"referenceD\" value=\""+referenceD+"\">";
		str += "<column name=\"referenceNo1\" value=\""+referenceNo1+"\">";
		str += "<column name=\"referenceNo2\" value=\""+referenceNo2+"\">";
		str += "<column name=\"referenceNo3\" value=\""+referenceNo3+"\">";
		str += "<column name=\"restraintOfTrade\" value=\""+restraintOfTrade+"\">";
		str += "<column name=\"serviceDescription\" value=\""+serviceDescription+"\">";
		str += "<column name=\"specialConditions\" value=\""+specialConditions+"\">";
		str += "<column name=\"terminationNotice\" value=\""+terminationNotice+"\">";
		str += "<column name=\"terminationNoticeUnit\" value=\""+terminationNoticeUnit+"\">";
		str += "<column name=\"timecardApprovalId\" value=\""+timecardApprovalId+"\">";
		str += "<column name=\"timecardApprovalRateHidden\" value=\""+timecardApprovalRateHidden+"\">";
		str += "<column name=\"timecardLayout\" value=\""+timecardLayout+"\">";
		str += "<column name=\"timecardRequired\" value=\""+timecardRequired+"\">";
		str += "<column name=\"timecardSecondaryApprovalId\" value=\""+timecardSecondaryApprovalId+"\">";
		str += "<column name=\"timecardTertiaryApprovalId\" value=\""+timecardTertiaryApprovalId+"\">";
		str += "<column name=\"timesheetName\" value=\""+timesheetName+"\">";
		str += "<column name=\"timesheetUnits\" value=\""+timesheetUnits+"\">";
		str += "<column name=\"unit\" value=\""+unit+"\">";
		str += "<column name=\"useAwardCalculation\" value=\""+useAwardCalculation+"\">";
		str += "<column name=\"useDeliverables\" value=\""+useDeliverables+"\">";
		str += "<column name=\"useExpense\" value=\""+useExpense+"\">";
		str += "<column name=\"wcOrganisationTypeFlag\" value=\""+wcOrganisationTypeFlag+"\">";
		str += "<column name=\"wcOrgCodeRateLinkId\" value=\""+wcOrgCodeRateLinkId+"\">";
		str += "<column name=\"workingState\" value=\""+workingState+"\">";
		str += "<column name=\"workEndTime\" value=\""+workEndTime+"\">";
		str += "<column name=\"workStartTime\" value=\""+workStartTime+"\">";
		str += "<column name=\"insertUserName\" value=\""+insertUserName+"\">";
		str += "<column name=\"updateUserName\" value=\""+updateUserName+"\">";

		return str;
	}

	/**
	 * toJsonString
	 */
	public String toJsonString() {
		String str = "";

		str += "\"assignmentId\":\""+assignmentId+"\", ";
		str += "\"fromDate\":\""+fromDate+"\", ";
		str += "\"toDate\":\""+toDate+"\", ";
		str += "\"createdBy\":\""+createdBy+"\", ";
		str += "\"creationDate\":\""+creationDate+"\", ";
		str += "\"lastUpdatedBy\":\""+lastUpdatedBy+"\", ";
		str += "\"lastUpdateDate\":\""+lastUpdateDate+"\", ";
		str += "\"personId\":\""+personId+"\", ";
		str += "\"billingOrganisationId\":\""+billingOrganisationId+"\", ";
		str += "\"euOrganisationId\":\""+euOrganisationId+"\", ";
		str += "\"approvedExpenses\":\""+approvedExpenses+"\", ";
		str += "\"asgActive\":\""+asgActive+"\", ";
		str += "\"assignmentEndDate\":\""+assignmentEndDate+"\", ";
		str += "\"assignmentNumber\":\""+assignmentNumber+"\", ";
		str += "\"assignmentStartDate\":\""+assignmentStartDate+"\", ";
		str += "\"attribute1\":\""+attribute1+"\", ";
		str += "\"attribute10\":\""+attribute10+"\", ";
		str += "\"attribute9\":\""+attribute9+"\", ";
		str += "\"automaticInvoice\":\""+automaticInvoice+"\", ";
		str += "\"basicSalary\":\""+basicSalary+"\", ";
		str += "\"billingCode\":\""+billingCode+"\", ";
		str += "\"billingCodeId\":\""+billingCodeId+"\", ";
		str += "\"billingOrganisationPersonId\":\""+billingOrganisationPersonId+"\", ";
		str += "\"businessGroupId\":\""+businessGroupId+"\", ";
		str += "\"comments\":\""+comments+"\", ";
		str += "\"costCentre\":\""+costCentre+"\", ";
		str += "\"createdAs\":\""+createdAs+"\", ";
		str += "\"deliverablesApprover1\":\""+deliverablesApprover1+"\", ";
		str += "\"deliverablesApprover2\":\""+deliverablesApprover2+"\", ";
		str += "\"deliverablesApprover3\":\""+deliverablesApprover3+"\", ";
		str += "\"deliverablesApprNotiToId\":\""+deliverablesApprNotiToId+"\", ";
		str += "\"deliverablesApprNotiToOrg\":\""+deliverablesApprNotiToOrg+"\", ";
		str += "\"deliverablesName\":\""+deliverablesName+"\", ";
		str += "\"element1\":\""+element1+"\", ";
		str += "\"element2\":\""+element2+"\", ";
		str += "\"element3\":\""+element3+"\", ";
		str += "\"element4\":\""+element4+"\", ";
		str += "\"element5\":\""+element5+"\", ";
		str += "\"engagementContractType\":\""+engagementContractType+"\", ";
		str += "\"equipmentDetails\":\""+equipmentDetails+"\", ";
		str += "\"equipmentRequiredYn\":\""+equipmentRequiredYn+"\", ";
		str += "\"etsApprovalNotificationTo\":\""+etsApprovalNotificationTo+"\", ";
		str += "\"etsApprovalNotiTo2\":\""+etsApprovalNotiTo2+"\", ";
		str += "\"euContactPersonId\":\""+euContactPersonId+"\", ";
		str += "\"expenseApprovalNotiToId\":\""+expenseApprovalNotiToId+"\", ";
		str += "\"expenseApprovalNotiToOrg\":\""+expenseApprovalNotiToOrg+"\", ";
		str += "\"expenseApprover1\":\""+expenseApprover1+"\", ";
		str += "\"expenseApprover2\":\""+expenseApprover2+"\", ";
		str += "\"expenseApprover3\":\""+expenseApprover3+"\", ";
		str += "\"expenseName\":\""+expenseName+"\", ";
		str += "\"gstExempt\":\""+gstExempt+"\", ";
		str += "\"invoiceRecipientEmail\":\""+invoiceRecipientEmail+"\", ";
		str += "\"isBulkApproval\":\""+isBulkApproval+"\", ";
		str += "\"isBulkApprovalDeliverables\":\""+isBulkApprovalDeliverables+"\", ";
		str += "\"isBulkApprovalExpense\":\""+isBulkApprovalExpense+"\", ";
		str += "\"isDaily\":\""+isDaily+"\", ";
		str += "\"isStartEndTime\":\""+isStartEndTime+"\", ";
		str += "\"jobTitle\":\""+jobTitle+"\", ";
		str += "\"modernAwardDescription\":\""+modernAwardDescription+"\", ";
		str += "\"modernAwardId\":\""+modernAwardId+"\", ";
		str += "\"payrollNotes\":\""+payrollNotes+"\", ";
		str += "\"payslipEmail\":\""+payslipEmail+"\", ";
		str += "\"payArrangement\":\""+payArrangement+"\", ";
		str += "\"payMethodId\":\""+payMethodId+"\", ";
		str += "\"preferred\":\""+preferred+"\", ";
		str += "\"prtStatus\":\""+prtStatus+"\", ";
		str += "\"rate\":\""+rate+"\", ";
		str += "\"rate1\":\""+rate1+"\", ";
		str += "\"rate2\":\""+rate2+"\", ";
		str += "\"rate3\":\""+rate3+"\", ";
		str += "\"rate4\":\""+rate4+"\", ";
		str += "\"rate5\":\""+rate5+"\", ";
		str += "\"referenceAPo\":\""+referenceAPo+"\", ";
		str += "\"referenceB\":\""+referenceB+"\", ";
		str += "\"referenceC\":\""+referenceC+"\", ";
		str += "\"referenceD\":\""+referenceD+"\", ";
		str += "\"referenceNo1\":\""+referenceNo1+"\", ";
		str += "\"referenceNo2\":\""+referenceNo2+"\", ";
		str += "\"referenceNo3\":\""+referenceNo3+"\", ";
		str += "\"restraintOfTrade\":\""+restraintOfTrade+"\", ";
		str += "\"serviceDescription\":\""+serviceDescription+"\", ";
		str += "\"specialConditions\":\""+specialConditions+"\", ";
		str += "\"terminationNotice\":\""+terminationNotice+"\", ";
		str += "\"terminationNoticeUnit\":\""+terminationNoticeUnit+"\", ";
		str += "\"timecardApprovalId\":\""+timecardApprovalId+"\", ";
		str += "\"timecardApprovalRateHidden\":\""+timecardApprovalRateHidden+"\", ";
		str += "\"timecardLayout\":\""+timecardLayout+"\", ";
		str += "\"timecardRequired\":\""+timecardRequired+"\", ";
		str += "\"timecardSecondaryApprovalId\":\""+timecardSecondaryApprovalId+"\", ";
		str += "\"timecardTertiaryApprovalId\":\""+timecardTertiaryApprovalId+"\", ";
		str += "\"timesheetName\":\""+timesheetName+"\", ";
		str += "\"timesheetUnits\":\""+timesheetUnits+"\", ";
		str += "\"unit\":\""+unit+"\", ";
		str += "\"useAwardCalculation\":\""+useAwardCalculation+"\", ";
		str += "\"useDeliverables\":\""+useDeliverables+"\", ";
		str += "\"useExpense\":\""+useExpense+"\", ";
		str += "\"wcOrganisationTypeFlag\":\""+wcOrganisationTypeFlag+"\", ";
		str += "\"wcOrgCodeRateLinkId\":\""+wcOrgCodeRateLinkId+"\", ";
		str += "\"workingState\":\""+workingState+"\", ";
		str += "\"workEndTime\":\""+workEndTime+"\", ";
		str += "\"workStartTime\":\""+workStartTime+"\", ";
		str += "\"insertUserName\":\""+insertUserName+"\", ";
		str += "\"updateUserName\":\""+updateUserName+"\"";

		return str;
	}
}