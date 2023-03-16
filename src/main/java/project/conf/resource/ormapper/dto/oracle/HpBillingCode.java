/**************************************************************************************************
 * Framework Generated DTO Source
 * - HP_BILLING_CODE - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dto.oracle;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;

import zebra.data.DataSet;
import zebra.util.CommonUtil;
import project.common.extend.BaseDto;

@SuppressWarnings("unused")
public class HpBillingCode extends BaseDto implements Serializable {
	/**
	 * Columns
	 */
	private double billingCodeId;
	private String BILLING_CODE_ID;
	private double businessGroupId;
	private String BUSINESS_GROUP_ID;
	private double createdBy;
	private String CREATED_BY;
	private Date creationDate;
	private String CREATION_DATE;
	private double lastUpdatedBy;
	private String LAST_UPDATED_BY;
	private Date lastUpdateDate;
	private String LAST_UPDATE_DATE;
	private double billingOrganizationId;
	private String BILLING_ORGANIZATION_ID;
	private String active;
	private String ACTIVE;
	private String attention;
	private String ATTENTION;
	private String autoTimesheetReminder;
	private String AUTO_TIMESHEET_REMINDER;
	private String billingCode;
	private String BILLING_CODE;
	private String cashOnDelivery;
	private String CASH_ON_DELIVERY;
	private String customerEmailCode;
	private String CUSTOMER_EMAIL_CODE;
	private String description;
	private String DESCRIPTION;
	private String displayComments;
	private String DISPLAY_COMMENTS;
	private double empOrganizationId;
	private String EMP_ORGANIZATION_ID;
	private Date firstInvoiceDueDate;
	private String FIRST_INVOICE_DUE_DATE;
	private Date firstInvPeriodEndDate;
	private String FIRST_INV_PERIOD_END_DATE;
	private Date firstPeriodEndDate;
	private String FIRST_PERIOD_END_DATE;
	private Date firstTimesheetTimeDueDate;
	private String FIRST_TIMESHEET_TIME_DUE_DATE;
	private String invoiceCycle;
	private String INVOICE_CYCLE;
	private String invoiceRecipientEmail;
	private String INVOICE_RECIPIENT_EMAIL;
	private String invoiceSendMode;
	private String INVOICE_SEND_MODE;
	private String invoiceTimeDue;
	private String INVOICE_TIME_DUE;
	private String invoiceType;
	private String INVOICE_TYPE;
	private String invoiceWithTimesheet;
	private String INVOICE_WITH_TIMESHEET;
	private double invDateOffset;
	private String INV_DATE_OFFSET;
	private double invTemplateId;
	private String INV_TEMPLATE_ID;
	private Date newSaleDate;
	private String NEW_SALE_DATE;
	private String paymentCycle;
	private String PAYMENT_CYCLE;
	private double payslipTemplateId;
	private String PAYSLIP_TEMPLATE_ID;
	private double payDateOffset;
	private String PAY_DATE_OFFSET;
	private String periodsCreationType;
	private String PERIODS_CREATION_TYPE;
	private double rctiTemplateId;
	private String RCTI_TEMPLATE_ID;
	private double relationshipConsultantId;
	private String RELATIONSHIP_CONSULTANT_ID;
	private double remittanceAdviceTemplateId;
	private String REMITTANCE_ADVICE_TEMPLATE_ID;
	private String terms;
	private String TERMS;
	private String termsDayType;
	private String TERMS_DAY_TYPE;
	private String termsOffsetType;
	private String TERMS_OFFSET_TYPE;
	private String timesheetCycle;
	private String TIMESHEET_CYCLE;
	private double timeSheetCycleOffset;
	private String TIME_SHEET_CYCLE_OFFSET;
	private String timeSheetTimeDue;
	private String TIME_SHEET_TIME_DUE;
	private String insertUserName;
	private String INSERT_USER_NAME;
	private String updateUserName;
	private String UPDATE_USER_NAME;

	/**
	 * Constructor
	 */
	@SuppressWarnings("rawtypes")
	public HpBillingCode() throws Exception {
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
		setFrwVarPrimaryKey("BILLING_CODE_ID");
		setFrwVarDateColumn("CREATION_DATE,LAST_UPDATE_DATE,FIRST_INVOICE_DUE_DATE,FIRST_INV_PERIOD_END_DATE,FIRST_PERIOD_END_DATE,FIRST_TIMESHEET_TIME_DUE_DATE,NEW_SALE_DATE");
		setFrwVarNumberColumn("BILLING_CODE_ID,BUSINESS_GROUP_ID,CREATED_BY,LAST_UPDATED_BY,BILLING_ORGANIZATION_ID,EMP_ORGANIZATION_ID,INV_DATE_OFFSET,INV_TEMPLATE_ID,PAYSLIP_TEMPLATE_ID,PAY_DATE_OFFSET,RCTI_TEMPLATE_ID,RELATIONSHIP_CONSULTANT_ID,REMITTANCE_ADVICE_TEMPLATE_ID,TIME_SHEET_CYCLE_OFFSET");
		setFrwVarClobColumn("");
		setFrwVarDefaultColumn("");
		setFrwVarDefaultValue("");
		setDefaultValue();
	}

	/**
	 * Accessors
	 */
	public double getBillingCodeId() {
		return billingCodeId;
	}

	public void setBillingCodeId(double billingCodeId) throws Exception {
		this.billingCodeId = billingCodeId;
		setValueFromAccessor("BILLING_CODE_ID", CommonUtil.toString(billingCodeId));
	}

	public double getBusinessGroupId() {
		return businessGroupId;
	}

	public void setBusinessGroupId(double businessGroupId) throws Exception {
		this.businessGroupId = businessGroupId;
		setValueFromAccessor("BUSINESS_GROUP_ID", CommonUtil.toString(businessGroupId));
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

	public double getBillingOrganizationId() {
		return billingOrganizationId;
	}

	public void setBillingOrganizationId(double billingOrganizationId) throws Exception {
		this.billingOrganizationId = billingOrganizationId;
		setValueFromAccessor("BILLING_ORGANIZATION_ID", CommonUtil.toString(billingOrganizationId));
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) throws Exception {
		this.active = active;
		setValueFromAccessor("ACTIVE", active);
	}

	public String getAttention() {
		return attention;
	}

	public void setAttention(String attention) throws Exception {
		this.attention = attention;
		setValueFromAccessor("ATTENTION", attention);
	}

	public String getAutoTimesheetReminder() {
		return autoTimesheetReminder;
	}

	public void setAutoTimesheetReminder(String autoTimesheetReminder) throws Exception {
		this.autoTimesheetReminder = autoTimesheetReminder;
		setValueFromAccessor("AUTO_TIMESHEET_REMINDER", autoTimesheetReminder);
	}

	public String getBillingCode() {
		return billingCode;
	}

	public void setBillingCode(String billingCode) throws Exception {
		this.billingCode = billingCode;
		setValueFromAccessor("BILLING_CODE", billingCode);
	}

	public String getCashOnDelivery() {
		return cashOnDelivery;
	}

	public void setCashOnDelivery(String cashOnDelivery) throws Exception {
		this.cashOnDelivery = cashOnDelivery;
		setValueFromAccessor("CASH_ON_DELIVERY", cashOnDelivery);
	}

	public String getCustomerEmailCode() {
		return customerEmailCode;
	}

	public void setCustomerEmailCode(String customerEmailCode) throws Exception {
		this.customerEmailCode = customerEmailCode;
		setValueFromAccessor("CUSTOMER_EMAIL_CODE", customerEmailCode);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) throws Exception {
		this.description = description;
		setValueFromAccessor("DESCRIPTION", description);
	}

	public String getDisplayComments() {
		return displayComments;
	}

	public void setDisplayComments(String displayComments) throws Exception {
		this.displayComments = displayComments;
		setValueFromAccessor("DISPLAY_COMMENTS", displayComments);
	}

	public double getEmpOrganizationId() {
		return empOrganizationId;
	}

	public void setEmpOrganizationId(double empOrganizationId) throws Exception {
		this.empOrganizationId = empOrganizationId;
		setValueFromAccessor("EMP_ORGANIZATION_ID", CommonUtil.toString(empOrganizationId));
	}

	public Date getFirstInvoiceDueDate() {
		return firstInvoiceDueDate;
	}

	public void setFirstInvoiceDueDate(Date firstInvoiceDueDate) throws Exception {
		this.firstInvoiceDueDate = firstInvoiceDueDate;
		setValueFromAccessor("FIRST_INVOICE_DUE_DATE", CommonUtil.toString(firstInvoiceDueDate));
	}

	public Date getFirstInvPeriodEndDate() {
		return firstInvPeriodEndDate;
	}

	public void setFirstInvPeriodEndDate(Date firstInvPeriodEndDate) throws Exception {
		this.firstInvPeriodEndDate = firstInvPeriodEndDate;
		setValueFromAccessor("FIRST_INV_PERIOD_END_DATE", CommonUtil.toString(firstInvPeriodEndDate));
	}

	public Date getFirstPeriodEndDate() {
		return firstPeriodEndDate;
	}

	public void setFirstPeriodEndDate(Date firstPeriodEndDate) throws Exception {
		this.firstPeriodEndDate = firstPeriodEndDate;
		setValueFromAccessor("FIRST_PERIOD_END_DATE", CommonUtil.toString(firstPeriodEndDate));
	}

	public Date getFirstTimesheetTimeDueDate() {
		return firstTimesheetTimeDueDate;
	}

	public void setFirstTimesheetTimeDueDate(Date firstTimesheetTimeDueDate) throws Exception {
		this.firstTimesheetTimeDueDate = firstTimesheetTimeDueDate;
		setValueFromAccessor("FIRST_TIMESHEET_TIME_DUE_DATE", CommonUtil.toString(firstTimesheetTimeDueDate));
	}

	public String getInvoiceCycle() {
		return invoiceCycle;
	}

	public void setInvoiceCycle(String invoiceCycle) throws Exception {
		this.invoiceCycle = invoiceCycle;
		setValueFromAccessor("INVOICE_CYCLE", invoiceCycle);
	}

	public String getInvoiceRecipientEmail() {
		return invoiceRecipientEmail;
	}

	public void setInvoiceRecipientEmail(String invoiceRecipientEmail) throws Exception {
		this.invoiceRecipientEmail = invoiceRecipientEmail;
		setValueFromAccessor("INVOICE_RECIPIENT_EMAIL", invoiceRecipientEmail);
	}

	public String getInvoiceSendMode() {
		return invoiceSendMode;
	}

	public void setInvoiceSendMode(String invoiceSendMode) throws Exception {
		this.invoiceSendMode = invoiceSendMode;
		setValueFromAccessor("INVOICE_SEND_MODE", invoiceSendMode);
	}

	public String getInvoiceTimeDue() {
		return invoiceTimeDue;
	}

	public void setInvoiceTimeDue(String invoiceTimeDue) throws Exception {
		this.invoiceTimeDue = invoiceTimeDue;
		setValueFromAccessor("INVOICE_TIME_DUE", invoiceTimeDue);
	}

	public String getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(String invoiceType) throws Exception {
		this.invoiceType = invoiceType;
		setValueFromAccessor("INVOICE_TYPE", invoiceType);
	}

	public String getInvoiceWithTimesheet() {
		return invoiceWithTimesheet;
	}

	public void setInvoiceWithTimesheet(String invoiceWithTimesheet) throws Exception {
		this.invoiceWithTimesheet = invoiceWithTimesheet;
		setValueFromAccessor("INVOICE_WITH_TIMESHEET", invoiceWithTimesheet);
	}

	public double getInvDateOffset() {
		return invDateOffset;
	}

	public void setInvDateOffset(double invDateOffset) throws Exception {
		this.invDateOffset = invDateOffset;
		setValueFromAccessor("INV_DATE_OFFSET", CommonUtil.toString(invDateOffset));
	}

	public double getInvTemplateId() {
		return invTemplateId;
	}

	public void setInvTemplateId(double invTemplateId) throws Exception {
		this.invTemplateId = invTemplateId;
		setValueFromAccessor("INV_TEMPLATE_ID", CommonUtil.toString(invTemplateId));
	}

	public Date getNewSaleDate() {
		return newSaleDate;
	}

	public void setNewSaleDate(Date newSaleDate) throws Exception {
		this.newSaleDate = newSaleDate;
		setValueFromAccessor("NEW_SALE_DATE", CommonUtil.toString(newSaleDate));
	}

	public String getPaymentCycle() {
		return paymentCycle;
	}

	public void setPaymentCycle(String paymentCycle) throws Exception {
		this.paymentCycle = paymentCycle;
		setValueFromAccessor("PAYMENT_CYCLE", paymentCycle);
	}

	public double getPayslipTemplateId() {
		return payslipTemplateId;
	}

	public void setPayslipTemplateId(double payslipTemplateId) throws Exception {
		this.payslipTemplateId = payslipTemplateId;
		setValueFromAccessor("PAYSLIP_TEMPLATE_ID", CommonUtil.toString(payslipTemplateId));
	}

	public double getPayDateOffset() {
		return payDateOffset;
	}

	public void setPayDateOffset(double payDateOffset) throws Exception {
		this.payDateOffset = payDateOffset;
		setValueFromAccessor("PAY_DATE_OFFSET", CommonUtil.toString(payDateOffset));
	}

	public String getPeriodsCreationType() {
		return periodsCreationType;
	}

	public void setPeriodsCreationType(String periodsCreationType) throws Exception {
		this.periodsCreationType = periodsCreationType;
		setValueFromAccessor("PERIODS_CREATION_TYPE", periodsCreationType);
	}

	public double getRctiTemplateId() {
		return rctiTemplateId;
	}

	public void setRctiTemplateId(double rctiTemplateId) throws Exception {
		this.rctiTemplateId = rctiTemplateId;
		setValueFromAccessor("RCTI_TEMPLATE_ID", CommonUtil.toString(rctiTemplateId));
	}

	public double getRelationshipConsultantId() {
		return relationshipConsultantId;
	}

	public void setRelationshipConsultantId(double relationshipConsultantId) throws Exception {
		this.relationshipConsultantId = relationshipConsultantId;
		setValueFromAccessor("RELATIONSHIP_CONSULTANT_ID", CommonUtil.toString(relationshipConsultantId));
	}

	public double getRemittanceAdviceTemplateId() {
		return remittanceAdviceTemplateId;
	}

	public void setRemittanceAdviceTemplateId(double remittanceAdviceTemplateId) throws Exception {
		this.remittanceAdviceTemplateId = remittanceAdviceTemplateId;
		setValueFromAccessor("REMITTANCE_ADVICE_TEMPLATE_ID", CommonUtil.toString(remittanceAdviceTemplateId));
	}

	public String getTerms() {
		return terms;
	}

	public void setTerms(String terms) throws Exception {
		this.terms = terms;
		setValueFromAccessor("TERMS", terms);
	}

	public String getTermsDayType() {
		return termsDayType;
	}

	public void setTermsDayType(String termsDayType) throws Exception {
		this.termsDayType = termsDayType;
		setValueFromAccessor("TERMS_DAY_TYPE", termsDayType);
	}

	public String getTermsOffsetType() {
		return termsOffsetType;
	}

	public void setTermsOffsetType(String termsOffsetType) throws Exception {
		this.termsOffsetType = termsOffsetType;
		setValueFromAccessor("TERMS_OFFSET_TYPE", termsOffsetType);
	}

	public String getTimesheetCycle() {
		return timesheetCycle;
	}

	public void setTimesheetCycle(String timesheetCycle) throws Exception {
		this.timesheetCycle = timesheetCycle;
		setValueFromAccessor("TIMESHEET_CYCLE", timesheetCycle);
	}

	public double getTimeSheetCycleOffset() {
		return timeSheetCycleOffset;
	}

	public void setTimeSheetCycleOffset(double timeSheetCycleOffset) throws Exception {
		this.timeSheetCycleOffset = timeSheetCycleOffset;
		setValueFromAccessor("TIME_SHEET_CYCLE_OFFSET", CommonUtil.toString(timeSheetCycleOffset));
	}

	public String getTimeSheetTimeDue() {
		return timeSheetTimeDue;
	}

	public void setTimeSheetTimeDue(String timeSheetTimeDue) throws Exception {
		this.timeSheetTimeDue = timeSheetTimeDue;
		setValueFromAccessor("TIME_SHEET_TIME_DUE", timeSheetTimeDue);
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

		str += "billingCodeId : "+billingCodeId+"\n";
		str += "businessGroupId : "+businessGroupId+"\n";
		str += "createdBy : "+createdBy+"\n";
		str += "creationDate : "+creationDate+"\n";
		str += "lastUpdatedBy : "+lastUpdatedBy+"\n";
		str += "lastUpdateDate : "+lastUpdateDate+"\n";
		str += "billingOrganizationId : "+billingOrganizationId+"\n";
		str += "active : "+active+"\n";
		str += "attention : "+attention+"\n";
		str += "autoTimesheetReminder : "+autoTimesheetReminder+"\n";
		str += "billingCode : "+billingCode+"\n";
		str += "cashOnDelivery : "+cashOnDelivery+"\n";
		str += "customerEmailCode : "+customerEmailCode+"\n";
		str += "description : "+description+"\n";
		str += "displayComments : "+displayComments+"\n";
		str += "empOrganizationId : "+empOrganizationId+"\n";
		str += "firstInvoiceDueDate : "+firstInvoiceDueDate+"\n";
		str += "firstInvPeriodEndDate : "+firstInvPeriodEndDate+"\n";
		str += "firstPeriodEndDate : "+firstPeriodEndDate+"\n";
		str += "firstTimesheetTimeDueDate : "+firstTimesheetTimeDueDate+"\n";
		str += "invoiceCycle : "+invoiceCycle+"\n";
		str += "invoiceRecipientEmail : "+invoiceRecipientEmail+"\n";
		str += "invoiceSendMode : "+invoiceSendMode+"\n";
		str += "invoiceTimeDue : "+invoiceTimeDue+"\n";
		str += "invoiceType : "+invoiceType+"\n";
		str += "invoiceWithTimesheet : "+invoiceWithTimesheet+"\n";
		str += "invDateOffset : "+invDateOffset+"\n";
		str += "invTemplateId : "+invTemplateId+"\n";
		str += "newSaleDate : "+newSaleDate+"\n";
		str += "paymentCycle : "+paymentCycle+"\n";
		str += "payslipTemplateId : "+payslipTemplateId+"\n";
		str += "payDateOffset : "+payDateOffset+"\n";
		str += "periodsCreationType : "+periodsCreationType+"\n";
		str += "rctiTemplateId : "+rctiTemplateId+"\n";
		str += "relationshipConsultantId : "+relationshipConsultantId+"\n";
		str += "remittanceAdviceTemplateId : "+remittanceAdviceTemplateId+"\n";
		str += "terms : "+terms+"\n";
		str += "termsDayType : "+termsDayType+"\n";
		str += "termsOffsetType : "+termsOffsetType+"\n";
		str += "timesheetCycle : "+timesheetCycle+"\n";
		str += "timeSheetCycleOffset : "+timeSheetCycleOffset+"\n";
		str += "timeSheetTimeDue : "+timeSheetTimeDue+"\n";
		str += "insertUserName : "+insertUserName+"\n";
		str += "updateUserName : "+updateUserName+"\n";

		return str;
	}

	/**
	 * toXmlString
	 */
	public String toXmlString() {
		String str = "";

		str += "<column name=\"billingCodeId\" value=\""+billingCodeId+"\">";
		str += "<column name=\"businessGroupId\" value=\""+businessGroupId+"\">";
		str += "<column name=\"createdBy\" value=\""+createdBy+"\">";
		str += "<column name=\"creationDate\" value=\""+creationDate+"\">";
		str += "<column name=\"lastUpdatedBy\" value=\""+lastUpdatedBy+"\">";
		str += "<column name=\"lastUpdateDate\" value=\""+lastUpdateDate+"\">";
		str += "<column name=\"billingOrganizationId\" value=\""+billingOrganizationId+"\">";
		str += "<column name=\"active\" value=\""+active+"\">";
		str += "<column name=\"attention\" value=\""+attention+"\">";
		str += "<column name=\"autoTimesheetReminder\" value=\""+autoTimesheetReminder+"\">";
		str += "<column name=\"billingCode\" value=\""+billingCode+"\">";
		str += "<column name=\"cashOnDelivery\" value=\""+cashOnDelivery+"\">";
		str += "<column name=\"customerEmailCode\" value=\""+customerEmailCode+"\">";
		str += "<column name=\"description\" value=\""+description+"\">";
		str += "<column name=\"displayComments\" value=\""+displayComments+"\">";
		str += "<column name=\"empOrganizationId\" value=\""+empOrganizationId+"\">";
		str += "<column name=\"firstInvoiceDueDate\" value=\""+firstInvoiceDueDate+"\">";
		str += "<column name=\"firstInvPeriodEndDate\" value=\""+firstInvPeriodEndDate+"\">";
		str += "<column name=\"firstPeriodEndDate\" value=\""+firstPeriodEndDate+"\">";
		str += "<column name=\"firstTimesheetTimeDueDate\" value=\""+firstTimesheetTimeDueDate+"\">";
		str += "<column name=\"invoiceCycle\" value=\""+invoiceCycle+"\">";
		str += "<column name=\"invoiceRecipientEmail\" value=\""+invoiceRecipientEmail+"\">";
		str += "<column name=\"invoiceSendMode\" value=\""+invoiceSendMode+"\">";
		str += "<column name=\"invoiceTimeDue\" value=\""+invoiceTimeDue+"\">";
		str += "<column name=\"invoiceType\" value=\""+invoiceType+"\">";
		str += "<column name=\"invoiceWithTimesheet\" value=\""+invoiceWithTimesheet+"\">";
		str += "<column name=\"invDateOffset\" value=\""+invDateOffset+"\">";
		str += "<column name=\"invTemplateId\" value=\""+invTemplateId+"\">";
		str += "<column name=\"newSaleDate\" value=\""+newSaleDate+"\">";
		str += "<column name=\"paymentCycle\" value=\""+paymentCycle+"\">";
		str += "<column name=\"payslipTemplateId\" value=\""+payslipTemplateId+"\">";
		str += "<column name=\"payDateOffset\" value=\""+payDateOffset+"\">";
		str += "<column name=\"periodsCreationType\" value=\""+periodsCreationType+"\">";
		str += "<column name=\"rctiTemplateId\" value=\""+rctiTemplateId+"\">";
		str += "<column name=\"relationshipConsultantId\" value=\""+relationshipConsultantId+"\">";
		str += "<column name=\"remittanceAdviceTemplateId\" value=\""+remittanceAdviceTemplateId+"\">";
		str += "<column name=\"terms\" value=\""+terms+"\">";
		str += "<column name=\"termsDayType\" value=\""+termsDayType+"\">";
		str += "<column name=\"termsOffsetType\" value=\""+termsOffsetType+"\">";
		str += "<column name=\"timesheetCycle\" value=\""+timesheetCycle+"\">";
		str += "<column name=\"timeSheetCycleOffset\" value=\""+timeSheetCycleOffset+"\">";
		str += "<column name=\"timeSheetTimeDue\" value=\""+timeSheetTimeDue+"\">";
		str += "<column name=\"insertUserName\" value=\""+insertUserName+"\">";
		str += "<column name=\"updateUserName\" value=\""+updateUserName+"\">";

		return str;
	}

	/**
	 * toJsonString
	 */
	public String toJsonString() {
		String str = "";

		str += "\"billingCodeId\":\""+billingCodeId+"\", ";
		str += "\"businessGroupId\":\""+businessGroupId+"\", ";
		str += "\"createdBy\":\""+createdBy+"\", ";
		str += "\"creationDate\":\""+creationDate+"\", ";
		str += "\"lastUpdatedBy\":\""+lastUpdatedBy+"\", ";
		str += "\"lastUpdateDate\":\""+lastUpdateDate+"\", ";
		str += "\"billingOrganizationId\":\""+billingOrganizationId+"\", ";
		str += "\"active\":\""+active+"\", ";
		str += "\"attention\":\""+attention+"\", ";
		str += "\"autoTimesheetReminder\":\""+autoTimesheetReminder+"\", ";
		str += "\"billingCode\":\""+billingCode+"\", ";
		str += "\"cashOnDelivery\":\""+cashOnDelivery+"\", ";
		str += "\"customerEmailCode\":\""+customerEmailCode+"\", ";
		str += "\"description\":\""+description+"\", ";
		str += "\"displayComments\":\""+displayComments+"\", ";
		str += "\"empOrganizationId\":\""+empOrganizationId+"\", ";
		str += "\"firstInvoiceDueDate\":\""+firstInvoiceDueDate+"\", ";
		str += "\"firstInvPeriodEndDate\":\""+firstInvPeriodEndDate+"\", ";
		str += "\"firstPeriodEndDate\":\""+firstPeriodEndDate+"\", ";
		str += "\"firstTimesheetTimeDueDate\":\""+firstTimesheetTimeDueDate+"\", ";
		str += "\"invoiceCycle\":\""+invoiceCycle+"\", ";
		str += "\"invoiceRecipientEmail\":\""+invoiceRecipientEmail+"\", ";
		str += "\"invoiceSendMode\":\""+invoiceSendMode+"\", ";
		str += "\"invoiceTimeDue\":\""+invoiceTimeDue+"\", ";
		str += "\"invoiceType\":\""+invoiceType+"\", ";
		str += "\"invoiceWithTimesheet\":\""+invoiceWithTimesheet+"\", ";
		str += "\"invDateOffset\":\""+invDateOffset+"\", ";
		str += "\"invTemplateId\":\""+invTemplateId+"\", ";
		str += "\"newSaleDate\":\""+newSaleDate+"\", ";
		str += "\"paymentCycle\":\""+paymentCycle+"\", ";
		str += "\"payslipTemplateId\":\""+payslipTemplateId+"\", ";
		str += "\"payDateOffset\":\""+payDateOffset+"\", ";
		str += "\"periodsCreationType\":\""+periodsCreationType+"\", ";
		str += "\"rctiTemplateId\":\""+rctiTemplateId+"\", ";
		str += "\"relationshipConsultantId\":\""+relationshipConsultantId+"\", ";
		str += "\"remittanceAdviceTemplateId\":\""+remittanceAdviceTemplateId+"\", ";
		str += "\"terms\":\""+terms+"\", ";
		str += "\"termsDayType\":\""+termsDayType+"\", ";
		str += "\"termsOffsetType\":\""+termsOffsetType+"\", ";
		str += "\"timesheetCycle\":\""+timesheetCycle+"\", ";
		str += "\"timeSheetCycleOffset\":\""+timeSheetCycleOffset+"\", ";
		str += "\"timeSheetTimeDue\":\""+timeSheetTimeDue+"\", ";
		str += "\"insertUserName\":\""+insertUserName+"\", ";
		str += "\"updateUserName\":\""+updateUserName+"\"";

		return str;
	}
}