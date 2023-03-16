/**************************************************************************************************
 * Framework Generated DTO Source
 * - OPPORTUNITY_ASSIGNMENT_DETAILS - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dto.oracle;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;

import zebra.data.DataSet;
import zebra.util.CommonUtil;
import project.common.extend.BaseDto;

@SuppressWarnings("unused")
public class OpportunityAssignmentDetails extends BaseDto implements Serializable {
	/**
	 * Columns
	 */
	private double opportunityAsgDetailsId;
	private String OPPORTUNITY_ASG_DETAILS_ID;
	private double opportunityId;
	private String OPPORTUNITY_ID;
	private double billingOrg;
	private String BILLING_ORG;
	private double endUserOrg;
	private String END_USER_ORG;
	private String approvedExpenses;
	private String APPROVED_EXPENSES;
	private Date assignmentEndDate;
	private String ASSIGNMENT_END_DATE;
	private Date assignmentStartDate;
	private String ASSIGNMENT_START_DATE;
	private double contactPerson;
	private String CONTACT_PERSON;
	private double contractValue;
	private String CONTRACT_VALUE;
	private String endUserType;
	private String END_USER_TYPE;
	private String engagementContractType;
	private String ENGAGEMENT_CONTRACT_TYPE;
	private String equipmentDetails;
	private String EQUIPMENT_DETAILS;
	private String equipmentRequiredYn;
	private String EQUIPMENT_REQUIRED_YN;
	private String iproFeeUpon;
	private String IPRO_FEE_UPON;
	private String jobTitle;
	private String JOB_TITLE;
	private double managementFee;
	private String MANAGEMENT_FEE;
	private String managementFeeComments;
	private String MANAGEMENT_FEE_COMMENTS;
	private String managementFeeType;
	private String MANAGEMENT_FEE_TYPE;
	private String modernAwardDescription;
	private String MODERN_AWARD_DESCRIPTION;
	private double modernAwardId;
	private String MODERN_AWARD_ID;
	private String paymentArrangment;
	private String PAYMENT_ARRANGMENT;
	private double payrollTaxResponsibilty;
	private String PAYROLL_TAX_RESPONSIBILTY;
	private double rate;
	private String RATE;
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
	private String unit;
	private String UNIT;
	private String wcOrganisationTypeFlag;
	private String WC_ORGANISATION_TYPE_FLAG;
	private double wcOrgCodeRateLinkId;
	private String WC_ORG_CODE_RATE_LINK_ID;
	private String wcWorkingState;
	private String WC_WORKING_STATE;
	private String workingHoursBasis;
	private String WORKING_HOURS_BASIS;
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
	public OpportunityAssignmentDetails() throws Exception {
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
		setFrwVarPrimaryKey("");
		setFrwVarDateColumn("ASSIGNMENT_END_DATE,ASSIGNMENT_START_DATE");
		setFrwVarNumberColumn("OPPORTUNITY_ASG_DETAILS_ID,OPPORTUNITY_ID,BILLING_ORG,END_USER_ORG,CONTACT_PERSON,CONTRACT_VALUE,MANAGEMENT_FEE,MODERN_AWARD_ID,PAYROLL_TAX_RESPONSIBILTY,RATE,WC_ORG_CODE_RATE_LINK_ID");
		setFrwVarClobColumn("");
		setFrwVarDefaultColumn("");
		setFrwVarDefaultValue("");
		setDefaultValue();
	}

	/**
	 * Accessors
	 */
	public double getOpportunityAsgDetailsId() {
		return opportunityAsgDetailsId;
	}

	public void setOpportunityAsgDetailsId(double opportunityAsgDetailsId) throws Exception {
		this.opportunityAsgDetailsId = opportunityAsgDetailsId;
		setValueFromAccessor("OPPORTUNITY_ASG_DETAILS_ID", CommonUtil.toString(opportunityAsgDetailsId));
	}

	public double getOpportunityId() {
		return opportunityId;
	}

	public void setOpportunityId(double opportunityId) throws Exception {
		this.opportunityId = opportunityId;
		setValueFromAccessor("OPPORTUNITY_ID", CommonUtil.toString(opportunityId));
	}

	public double getBillingOrg() {
		return billingOrg;
	}

	public void setBillingOrg(double billingOrg) throws Exception {
		this.billingOrg = billingOrg;
		setValueFromAccessor("BILLING_ORG", CommonUtil.toString(billingOrg));
	}

	public double getEndUserOrg() {
		return endUserOrg;
	}

	public void setEndUserOrg(double endUserOrg) throws Exception {
		this.endUserOrg = endUserOrg;
		setValueFromAccessor("END_USER_ORG", CommonUtil.toString(endUserOrg));
	}

	public String getApprovedExpenses() {
		return approvedExpenses;
	}

	public void setApprovedExpenses(String approvedExpenses) throws Exception {
		this.approvedExpenses = approvedExpenses;
		setValueFromAccessor("APPROVED_EXPENSES", approvedExpenses);
	}

	public Date getAssignmentEndDate() {
		return assignmentEndDate;
	}

	public void setAssignmentEndDate(Date assignmentEndDate) throws Exception {
		this.assignmentEndDate = assignmentEndDate;
		setValueFromAccessor("ASSIGNMENT_END_DATE", CommonUtil.toString(assignmentEndDate));
	}

	public Date getAssignmentStartDate() {
		return assignmentStartDate;
	}

	public void setAssignmentStartDate(Date assignmentStartDate) throws Exception {
		this.assignmentStartDate = assignmentStartDate;
		setValueFromAccessor("ASSIGNMENT_START_DATE", CommonUtil.toString(assignmentStartDate));
	}

	public double getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(double contactPerson) throws Exception {
		this.contactPerson = contactPerson;
		setValueFromAccessor("CONTACT_PERSON", CommonUtil.toString(contactPerson));
	}

	public double getContractValue() {
		return contractValue;
	}

	public void setContractValue(double contractValue) throws Exception {
		this.contractValue = contractValue;
		setValueFromAccessor("CONTRACT_VALUE", CommonUtil.toString(contractValue));
	}

	public String getEndUserType() {
		return endUserType;
	}

	public void setEndUserType(String endUserType) throws Exception {
		this.endUserType = endUserType;
		setValueFromAccessor("END_USER_TYPE", endUserType);
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

	public String getIproFeeUpon() {
		return iproFeeUpon;
	}

	public void setIproFeeUpon(String iproFeeUpon) throws Exception {
		this.iproFeeUpon = iproFeeUpon;
		setValueFromAccessor("IPRO_FEE_UPON", iproFeeUpon);
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) throws Exception {
		this.jobTitle = jobTitle;
		setValueFromAccessor("JOB_TITLE", jobTitle);
	}

	public double getManagementFee() {
		return managementFee;
	}

	public void setManagementFee(double managementFee) throws Exception {
		this.managementFee = managementFee;
		setValueFromAccessor("MANAGEMENT_FEE", CommonUtil.toString(managementFee));
	}

	public String getManagementFeeComments() {
		return managementFeeComments;
	}

	public void setManagementFeeComments(String managementFeeComments) throws Exception {
		this.managementFeeComments = managementFeeComments;
		setValueFromAccessor("MANAGEMENT_FEE_COMMENTS", managementFeeComments);
	}

	public String getManagementFeeType() {
		return managementFeeType;
	}

	public void setManagementFeeType(String managementFeeType) throws Exception {
		this.managementFeeType = managementFeeType;
		setValueFromAccessor("MANAGEMENT_FEE_TYPE", managementFeeType);
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

	public String getPaymentArrangment() {
		return paymentArrangment;
	}

	public void setPaymentArrangment(String paymentArrangment) throws Exception {
		this.paymentArrangment = paymentArrangment;
		setValueFromAccessor("PAYMENT_ARRANGMENT", paymentArrangment);
	}

	public double getPayrollTaxResponsibilty() {
		return payrollTaxResponsibilty;
	}

	public void setPayrollTaxResponsibilty(double payrollTaxResponsibilty) throws Exception {
		this.payrollTaxResponsibilty = payrollTaxResponsibilty;
		setValueFromAccessor("PAYROLL_TAX_RESPONSIBILTY", CommonUtil.toString(payrollTaxResponsibilty));
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) throws Exception {
		this.rate = rate;
		setValueFromAccessor("RATE", CommonUtil.toString(rate));
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

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) throws Exception {
		this.unit = unit;
		setValueFromAccessor("UNIT", unit);
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

	public String getWcWorkingState() {
		return wcWorkingState;
	}

	public void setWcWorkingState(String wcWorkingState) throws Exception {
		this.wcWorkingState = wcWorkingState;
		setValueFromAccessor("WC_WORKING_STATE", wcWorkingState);
	}

	public String getWorkingHoursBasis() {
		return workingHoursBasis;
	}

	public void setWorkingHoursBasis(String workingHoursBasis) throws Exception {
		this.workingHoursBasis = workingHoursBasis;
		setValueFromAccessor("WORKING_HOURS_BASIS", workingHoursBasis);
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

		str += "opportunityAsgDetailsId : "+opportunityAsgDetailsId+"\n";
		str += "opportunityId : "+opportunityId+"\n";
		str += "billingOrg : "+billingOrg+"\n";
		str += "endUserOrg : "+endUserOrg+"\n";
		str += "approvedExpenses : "+approvedExpenses+"\n";
		str += "assignmentEndDate : "+assignmentEndDate+"\n";
		str += "assignmentStartDate : "+assignmentStartDate+"\n";
		str += "contactPerson : "+contactPerson+"\n";
		str += "contractValue : "+contractValue+"\n";
		str += "endUserType : "+endUserType+"\n";
		str += "engagementContractType : "+engagementContractType+"\n";
		str += "equipmentDetails : "+equipmentDetails+"\n";
		str += "equipmentRequiredYn : "+equipmentRequiredYn+"\n";
		str += "iproFeeUpon : "+iproFeeUpon+"\n";
		str += "jobTitle : "+jobTitle+"\n";
		str += "managementFee : "+managementFee+"\n";
		str += "managementFeeComments : "+managementFeeComments+"\n";
		str += "managementFeeType : "+managementFeeType+"\n";
		str += "modernAwardDescription : "+modernAwardDescription+"\n";
		str += "modernAwardId : "+modernAwardId+"\n";
		str += "paymentArrangment : "+paymentArrangment+"\n";
		str += "payrollTaxResponsibilty : "+payrollTaxResponsibilty+"\n";
		str += "rate : "+rate+"\n";
		str += "restraintOfTrade : "+restraintOfTrade+"\n";
		str += "serviceDescription : "+serviceDescription+"\n";
		str += "specialConditions : "+specialConditions+"\n";
		str += "terminationNotice : "+terminationNotice+"\n";
		str += "terminationNoticeUnit : "+terminationNoticeUnit+"\n";
		str += "unit : "+unit+"\n";
		str += "wcOrganisationTypeFlag : "+wcOrganisationTypeFlag+"\n";
		str += "wcOrgCodeRateLinkId : "+wcOrgCodeRateLinkId+"\n";
		str += "wcWorkingState : "+wcWorkingState+"\n";
		str += "workingHoursBasis : "+workingHoursBasis+"\n";
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

		str += "<column name=\"opportunityAsgDetailsId\" value=\""+opportunityAsgDetailsId+"\">";
		str += "<column name=\"opportunityId\" value=\""+opportunityId+"\">";
		str += "<column name=\"billingOrg\" value=\""+billingOrg+"\">";
		str += "<column name=\"endUserOrg\" value=\""+endUserOrg+"\">";
		str += "<column name=\"approvedExpenses\" value=\""+approvedExpenses+"\">";
		str += "<column name=\"assignmentEndDate\" value=\""+assignmentEndDate+"\">";
		str += "<column name=\"assignmentStartDate\" value=\""+assignmentStartDate+"\">";
		str += "<column name=\"contactPerson\" value=\""+contactPerson+"\">";
		str += "<column name=\"contractValue\" value=\""+contractValue+"\">";
		str += "<column name=\"endUserType\" value=\""+endUserType+"\">";
		str += "<column name=\"engagementContractType\" value=\""+engagementContractType+"\">";
		str += "<column name=\"equipmentDetails\" value=\""+equipmentDetails+"\">";
		str += "<column name=\"equipmentRequiredYn\" value=\""+equipmentRequiredYn+"\">";
		str += "<column name=\"iproFeeUpon\" value=\""+iproFeeUpon+"\">";
		str += "<column name=\"jobTitle\" value=\""+jobTitle+"\">";
		str += "<column name=\"managementFee\" value=\""+managementFee+"\">";
		str += "<column name=\"managementFeeComments\" value=\""+managementFeeComments+"\">";
		str += "<column name=\"managementFeeType\" value=\""+managementFeeType+"\">";
		str += "<column name=\"modernAwardDescription\" value=\""+modernAwardDescription+"\">";
		str += "<column name=\"modernAwardId\" value=\""+modernAwardId+"\">";
		str += "<column name=\"paymentArrangment\" value=\""+paymentArrangment+"\">";
		str += "<column name=\"payrollTaxResponsibilty\" value=\""+payrollTaxResponsibilty+"\">";
		str += "<column name=\"rate\" value=\""+rate+"\">";
		str += "<column name=\"restraintOfTrade\" value=\""+restraintOfTrade+"\">";
		str += "<column name=\"serviceDescription\" value=\""+serviceDescription+"\">";
		str += "<column name=\"specialConditions\" value=\""+specialConditions+"\">";
		str += "<column name=\"terminationNotice\" value=\""+terminationNotice+"\">";
		str += "<column name=\"terminationNoticeUnit\" value=\""+terminationNoticeUnit+"\">";
		str += "<column name=\"unit\" value=\""+unit+"\">";
		str += "<column name=\"wcOrganisationTypeFlag\" value=\""+wcOrganisationTypeFlag+"\">";
		str += "<column name=\"wcOrgCodeRateLinkId\" value=\""+wcOrgCodeRateLinkId+"\">";
		str += "<column name=\"wcWorkingState\" value=\""+wcWorkingState+"\">";
		str += "<column name=\"workingHoursBasis\" value=\""+workingHoursBasis+"\">";
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

		str += "\"opportunityAsgDetailsId\":\""+opportunityAsgDetailsId+"\", ";
		str += "\"opportunityId\":\""+opportunityId+"\", ";
		str += "\"billingOrg\":\""+billingOrg+"\", ";
		str += "\"endUserOrg\":\""+endUserOrg+"\", ";
		str += "\"approvedExpenses\":\""+approvedExpenses+"\", ";
		str += "\"assignmentEndDate\":\""+assignmentEndDate+"\", ";
		str += "\"assignmentStartDate\":\""+assignmentStartDate+"\", ";
		str += "\"contactPerson\":\""+contactPerson+"\", ";
		str += "\"contractValue\":\""+contractValue+"\", ";
		str += "\"endUserType\":\""+endUserType+"\", ";
		str += "\"engagementContractType\":\""+engagementContractType+"\", ";
		str += "\"equipmentDetails\":\""+equipmentDetails+"\", ";
		str += "\"equipmentRequiredYn\":\""+equipmentRequiredYn+"\", ";
		str += "\"iproFeeUpon\":\""+iproFeeUpon+"\", ";
		str += "\"jobTitle\":\""+jobTitle+"\", ";
		str += "\"managementFee\":\""+managementFee+"\", ";
		str += "\"managementFeeComments\":\""+managementFeeComments+"\", ";
		str += "\"managementFeeType\":\""+managementFeeType+"\", ";
		str += "\"modernAwardDescription\":\""+modernAwardDescription+"\", ";
		str += "\"modernAwardId\":\""+modernAwardId+"\", ";
		str += "\"paymentArrangment\":\""+paymentArrangment+"\", ";
		str += "\"payrollTaxResponsibilty\":\""+payrollTaxResponsibilty+"\", ";
		str += "\"rate\":\""+rate+"\", ";
		str += "\"restraintOfTrade\":\""+restraintOfTrade+"\", ";
		str += "\"serviceDescription\":\""+serviceDescription+"\", ";
		str += "\"specialConditions\":\""+specialConditions+"\", ";
		str += "\"terminationNotice\":\""+terminationNotice+"\", ";
		str += "\"terminationNoticeUnit\":\""+terminationNoticeUnit+"\", ";
		str += "\"unit\":\""+unit+"\", ";
		str += "\"wcOrganisationTypeFlag\":\""+wcOrganisationTypeFlag+"\", ";
		str += "\"wcOrgCodeRateLinkId\":\""+wcOrgCodeRateLinkId+"\", ";
		str += "\"wcWorkingState\":\""+wcWorkingState+"\", ";
		str += "\"workingHoursBasis\":\""+workingHoursBasis+"\", ";
		str += "\"workEndTime\":\""+workEndTime+"\", ";
		str += "\"workStartTime\":\""+workStartTime+"\", ";
		str += "\"insertUserName\":\""+insertUserName+"\", ";
		str += "\"updateUserName\":\""+updateUserName+"\"";

		return str;
	}
}