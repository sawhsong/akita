/**************************************************************************************************
 * Framework Generated DTO Source
 * - HP_INVOICE - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dto.oracle;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;

import zebra.data.DataSet;
import zebra.util.CommonUtil;
import project.common.extend.BaseDto;

@SuppressWarnings("unused")
public class HpInvoice extends BaseDto implements Serializable {
	/**
	 * Columns
	 */
	private double invoiceId;
	private String INVOICE_ID;
	private double businessGroupId;
	private String BUSINESS_GROUP_ID;
	private double createdBy;
	private String CREATED_BY;
	private Date creationDate;
	private String CREATION_DATE;
	private Date invoiceDate;
	private String INVOICE_DATE;
	private String invoiceNumber;
	private String INVOICE_NUMBER;
	private String invoiceType;
	private String INVOICE_TYPE;
	private double lastUpdatedBy;
	private String LAST_UPDATED_BY;
	private Date lastUpdateDate;
	private String LAST_UPDATE_DATE;
	private double payToOrganisationId;
	private String PAY_TO_ORGANISATION_ID;
	private double assignmentProcessId;
	private String ASSIGNMENT_PROCESS_ID;
	private double billingCodeId;
	private String BILLING_CODE_ID;
	private Date closeDate;
	private String CLOSE_DATE;
	private double commentId;
	private String COMMENT_ID;
	private Date conPeriodEndDate;
	private String CON_PERIOD_END_DATE;
	private Date conPeriodStartDate;
	private String CON_PERIOD_START_DATE;
	private double gstAmount;
	private String GST_AMOUNT;
	private double gstPer;
	private String GST_PER;
	private double invoiceAmount;
	private String INVOICE_AMOUNT;
	private String invoicePayrollNotes;
	private String INVOICE_PAYROLL_NOTES;
	private String invCrStatus;
	private String INV_CR_STATUS;
	private String mailToAddress;
	private String MAIL_TO_ADDRESS;
	private String mailToAttention;
	private String MAIL_TO_ATTENTION;
	private String mailToCountry;
	private String MAIL_TO_COUNTRY;
	private double mailToOrganisationId;
	private String MAIL_TO_ORGANISATION_ID;
	private double mailToPersonId;
	private String MAIL_TO_PERSON_ID;
	private String mailToPostCode;
	private String MAIL_TO_POST_CODE;
	private String mailToState;
	private String MAIL_TO_STATE;
	private String mailToSuburb;
	private String MAIL_TO_SUBURB;
	private String paymentTerms;
	private String PAYMENT_TERMS;
	private String payToAddress;
	private String PAY_TO_ADDRESS;
	private String payToCountry;
	private String PAY_TO_COUNTRY;
	private String payToFax;
	private String PAY_TO_FAX;
	private String payToPostCode;
	private String PAY_TO_POST_CODE;
	private String payToState;
	private String PAY_TO_STATE;
	private String payToSuburb;
	private String PAY_TO_SUBURB;
	private String payToTelephone;
	private String PAY_TO_TELEPHONE;
	private double periodId;
	private String PERIOD_ID;
	private double personId;
	private String PERSON_ID;
	private String poNumber;
	private String PO_NUMBER;
	private String source;
	private String SOURCE;
	private double sourceId;
	private String SOURCE_ID;
	private String status;
	private String STATUS;
	private String insertUserName;
	private String INSERT_USER_NAME;
	private String updateUserName;
	private String UPDATE_USER_NAME;

	/**
	 * Constructor
	 */
	@SuppressWarnings("rawtypes")
	public HpInvoice() throws Exception {
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
		setFrwVarPrimaryKey("INVOICE_ID");
		setFrwVarDateColumn("CREATION_DATE,INVOICE_DATE,LAST_UPDATE_DATE,CLOSE_DATE,CON_PERIOD_END_DATE,CON_PERIOD_START_DATE");
		setFrwVarNumberColumn("INVOICE_ID,BUSINESS_GROUP_ID,CREATED_BY,LAST_UPDATED_BY,PAY_TO_ORGANISATION_ID,ASSIGNMENT_PROCESS_ID,BILLING_CODE_ID,COMMENT_ID,GST_AMOUNT,GST_PER,INVOICE_AMOUNT,MAIL_TO_ORGANISATION_ID,MAIL_TO_PERSON_ID,PERIOD_ID,PERSON_ID,SOURCE_ID");
		setFrwVarClobColumn("");
		setFrwVarDefaultColumn("GST_AMOUNT,INV_CR_STATUS");
		setFrwVarDefaultValue("0,A");
		setDefaultValue();
	}

	/**
	 * Accessors
	 */
	public double getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(double invoiceId) throws Exception {
		this.invoiceId = invoiceId;
		setValueFromAccessor("INVOICE_ID", CommonUtil.toString(invoiceId));
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

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) throws Exception {
		this.invoiceDate = invoiceDate;
		setValueFromAccessor("INVOICE_DATE", CommonUtil.toString(invoiceDate));
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) throws Exception {
		this.invoiceNumber = invoiceNumber;
		setValueFromAccessor("INVOICE_NUMBER", invoiceNumber);
	}

	public String getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(String invoiceType) throws Exception {
		this.invoiceType = invoiceType;
		setValueFromAccessor("INVOICE_TYPE", invoiceType);
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

	public double getPayToOrganisationId() {
		return payToOrganisationId;
	}

	public void setPayToOrganisationId(double payToOrganisationId) throws Exception {
		this.payToOrganisationId = payToOrganisationId;
		setValueFromAccessor("PAY_TO_ORGANISATION_ID", CommonUtil.toString(payToOrganisationId));
	}

	public double getAssignmentProcessId() {
		return assignmentProcessId;
	}

	public void setAssignmentProcessId(double assignmentProcessId) throws Exception {
		this.assignmentProcessId = assignmentProcessId;
		setValueFromAccessor("ASSIGNMENT_PROCESS_ID", CommonUtil.toString(assignmentProcessId));
	}

	public double getBillingCodeId() {
		return billingCodeId;
	}

	public void setBillingCodeId(double billingCodeId) throws Exception {
		this.billingCodeId = billingCodeId;
		setValueFromAccessor("BILLING_CODE_ID", CommonUtil.toString(billingCodeId));
	}

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) throws Exception {
		this.closeDate = closeDate;
		setValueFromAccessor("CLOSE_DATE", CommonUtil.toString(closeDate));
	}

	public double getCommentId() {
		return commentId;
	}

	public void setCommentId(double commentId) throws Exception {
		this.commentId = commentId;
		setValueFromAccessor("COMMENT_ID", CommonUtil.toString(commentId));
	}

	public Date getConPeriodEndDate() {
		return conPeriodEndDate;
	}

	public void setConPeriodEndDate(Date conPeriodEndDate) throws Exception {
		this.conPeriodEndDate = conPeriodEndDate;
		setValueFromAccessor("CON_PERIOD_END_DATE", CommonUtil.toString(conPeriodEndDate));
	}

	public Date getConPeriodStartDate() {
		return conPeriodStartDate;
	}

	public void setConPeriodStartDate(Date conPeriodStartDate) throws Exception {
		this.conPeriodStartDate = conPeriodStartDate;
		setValueFromAccessor("CON_PERIOD_START_DATE", CommonUtil.toString(conPeriodStartDate));
	}

	public double getGstAmount() {
		return gstAmount;
	}

	public void setGstAmount(double gstAmount) throws Exception {
		this.gstAmount = gstAmount;
		setValueFromAccessor("GST_AMOUNT", CommonUtil.toString(gstAmount));
	}

	public double getGstPer() {
		return gstPer;
	}

	public void setGstPer(double gstPer) throws Exception {
		this.gstPer = gstPer;
		setValueFromAccessor("GST_PER", CommonUtil.toString(gstPer));
	}

	public double getInvoiceAmount() {
		return invoiceAmount;
	}

	public void setInvoiceAmount(double invoiceAmount) throws Exception {
		this.invoiceAmount = invoiceAmount;
		setValueFromAccessor("INVOICE_AMOUNT", CommonUtil.toString(invoiceAmount));
	}

	public String getInvoicePayrollNotes() {
		return invoicePayrollNotes;
	}

	public void setInvoicePayrollNotes(String invoicePayrollNotes) throws Exception {
		this.invoicePayrollNotes = invoicePayrollNotes;
		setValueFromAccessor("INVOICE_PAYROLL_NOTES", invoicePayrollNotes);
	}

	public String getInvCrStatus() {
		return invCrStatus;
	}

	public void setInvCrStatus(String invCrStatus) throws Exception {
		this.invCrStatus = invCrStatus;
		setValueFromAccessor("INV_CR_STATUS", invCrStatus);
	}

	public String getMailToAddress() {
		return mailToAddress;
	}

	public void setMailToAddress(String mailToAddress) throws Exception {
		this.mailToAddress = mailToAddress;
		setValueFromAccessor("MAIL_TO_ADDRESS", mailToAddress);
	}

	public String getMailToAttention() {
		return mailToAttention;
	}

	public void setMailToAttention(String mailToAttention) throws Exception {
		this.mailToAttention = mailToAttention;
		setValueFromAccessor("MAIL_TO_ATTENTION", mailToAttention);
	}

	public String getMailToCountry() {
		return mailToCountry;
	}

	public void setMailToCountry(String mailToCountry) throws Exception {
		this.mailToCountry = mailToCountry;
		setValueFromAccessor("MAIL_TO_COUNTRY", mailToCountry);
	}

	public double getMailToOrganisationId() {
		return mailToOrganisationId;
	}

	public void setMailToOrganisationId(double mailToOrganisationId) throws Exception {
		this.mailToOrganisationId = mailToOrganisationId;
		setValueFromAccessor("MAIL_TO_ORGANISATION_ID", CommonUtil.toString(mailToOrganisationId));
	}

	public double getMailToPersonId() {
		return mailToPersonId;
	}

	public void setMailToPersonId(double mailToPersonId) throws Exception {
		this.mailToPersonId = mailToPersonId;
		setValueFromAccessor("MAIL_TO_PERSON_ID", CommonUtil.toString(mailToPersonId));
	}

	public String getMailToPostCode() {
		return mailToPostCode;
	}

	public void setMailToPostCode(String mailToPostCode) throws Exception {
		this.mailToPostCode = mailToPostCode;
		setValueFromAccessor("MAIL_TO_POST_CODE", mailToPostCode);
	}

	public String getMailToState() {
		return mailToState;
	}

	public void setMailToState(String mailToState) throws Exception {
		this.mailToState = mailToState;
		setValueFromAccessor("MAIL_TO_STATE", mailToState);
	}

	public String getMailToSuburb() {
		return mailToSuburb;
	}

	public void setMailToSuburb(String mailToSuburb) throws Exception {
		this.mailToSuburb = mailToSuburb;
		setValueFromAccessor("MAIL_TO_SUBURB", mailToSuburb);
	}

	public String getPaymentTerms() {
		return paymentTerms;
	}

	public void setPaymentTerms(String paymentTerms) throws Exception {
		this.paymentTerms = paymentTerms;
		setValueFromAccessor("PAYMENT_TERMS", paymentTerms);
	}

	public String getPayToAddress() {
		return payToAddress;
	}

	public void setPayToAddress(String payToAddress) throws Exception {
		this.payToAddress = payToAddress;
		setValueFromAccessor("PAY_TO_ADDRESS", payToAddress);
	}

	public String getPayToCountry() {
		return payToCountry;
	}

	public void setPayToCountry(String payToCountry) throws Exception {
		this.payToCountry = payToCountry;
		setValueFromAccessor("PAY_TO_COUNTRY", payToCountry);
	}

	public String getPayToFax() {
		return payToFax;
	}

	public void setPayToFax(String payToFax) throws Exception {
		this.payToFax = payToFax;
		setValueFromAccessor("PAY_TO_FAX", payToFax);
	}

	public String getPayToPostCode() {
		return payToPostCode;
	}

	public void setPayToPostCode(String payToPostCode) throws Exception {
		this.payToPostCode = payToPostCode;
		setValueFromAccessor("PAY_TO_POST_CODE", payToPostCode);
	}

	public String getPayToState() {
		return payToState;
	}

	public void setPayToState(String payToState) throws Exception {
		this.payToState = payToState;
		setValueFromAccessor("PAY_TO_STATE", payToState);
	}

	public String getPayToSuburb() {
		return payToSuburb;
	}

	public void setPayToSuburb(String payToSuburb) throws Exception {
		this.payToSuburb = payToSuburb;
		setValueFromAccessor("PAY_TO_SUBURB", payToSuburb);
	}

	public String getPayToTelephone() {
		return payToTelephone;
	}

	public void setPayToTelephone(String payToTelephone) throws Exception {
		this.payToTelephone = payToTelephone;
		setValueFromAccessor("PAY_TO_TELEPHONE", payToTelephone);
	}

	public double getPeriodId() {
		return periodId;
	}

	public void setPeriodId(double periodId) throws Exception {
		this.periodId = periodId;
		setValueFromAccessor("PERIOD_ID", CommonUtil.toString(periodId));
	}

	public double getPersonId() {
		return personId;
	}

	public void setPersonId(double personId) throws Exception {
		this.personId = personId;
		setValueFromAccessor("PERSON_ID", CommonUtil.toString(personId));
	}

	public String getPoNumber() {
		return poNumber;
	}

	public void setPoNumber(String poNumber) throws Exception {
		this.poNumber = poNumber;
		setValueFromAccessor("PO_NUMBER", poNumber);
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) throws Exception {
		this.source = source;
		setValueFromAccessor("SOURCE", source);
	}

	public double getSourceId() {
		return sourceId;
	}

	public void setSourceId(double sourceId) throws Exception {
		this.sourceId = sourceId;
		setValueFromAccessor("SOURCE_ID", CommonUtil.toString(sourceId));
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) throws Exception {
		this.status = status;
		setValueFromAccessor("STATUS", status);
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

		if (CommonUtil.isIn(columnName, CommonUtil.split(getFrwVarNumberColumn(), ","))) {
			dataType = "Number";
		} else if (CommonUtil.isIn(columnName, CommonUtil.split(getFrwVarDateColumn(), ","))) {
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

		str += "invoiceId : "+invoiceId+"\n";
		str += "businessGroupId : "+businessGroupId+"\n";
		str += "createdBy : "+createdBy+"\n";
		str += "creationDate : "+creationDate+"\n";
		str += "invoiceDate : "+invoiceDate+"\n";
		str += "invoiceNumber : "+invoiceNumber+"\n";
		str += "invoiceType : "+invoiceType+"\n";
		str += "lastUpdatedBy : "+lastUpdatedBy+"\n";
		str += "lastUpdateDate : "+lastUpdateDate+"\n";
		str += "payToOrganisationId : "+payToOrganisationId+"\n";
		str += "assignmentProcessId : "+assignmentProcessId+"\n";
		str += "billingCodeId : "+billingCodeId+"\n";
		str += "closeDate : "+closeDate+"\n";
		str += "commentId : "+commentId+"\n";
		str += "conPeriodEndDate : "+conPeriodEndDate+"\n";
		str += "conPeriodStartDate : "+conPeriodStartDate+"\n";
		str += "gstAmount : "+gstAmount+"\n";
		str += "gstPer : "+gstPer+"\n";
		str += "invoiceAmount : "+invoiceAmount+"\n";
		str += "invoicePayrollNotes : "+invoicePayrollNotes+"\n";
		str += "invCrStatus : "+invCrStatus+"\n";
		str += "mailToAddress : "+mailToAddress+"\n";
		str += "mailToAttention : "+mailToAttention+"\n";
		str += "mailToCountry : "+mailToCountry+"\n";
		str += "mailToOrganisationId : "+mailToOrganisationId+"\n";
		str += "mailToPersonId : "+mailToPersonId+"\n";
		str += "mailToPostCode : "+mailToPostCode+"\n";
		str += "mailToState : "+mailToState+"\n";
		str += "mailToSuburb : "+mailToSuburb+"\n";
		str += "paymentTerms : "+paymentTerms+"\n";
		str += "payToAddress : "+payToAddress+"\n";
		str += "payToCountry : "+payToCountry+"\n";
		str += "payToFax : "+payToFax+"\n";
		str += "payToPostCode : "+payToPostCode+"\n";
		str += "payToState : "+payToState+"\n";
		str += "payToSuburb : "+payToSuburb+"\n";
		str += "payToTelephone : "+payToTelephone+"\n";
		str += "periodId : "+periodId+"\n";
		str += "personId : "+personId+"\n";
		str += "poNumber : "+poNumber+"\n";
		str += "source : "+source+"\n";
		str += "sourceId : "+sourceId+"\n";
		str += "status : "+status+"\n";
		str += "insertUserName : "+insertUserName+"\n";
		str += "updateUserName : "+updateUserName+"\n";

		return str;
	}

	/**
	 * toXmlString
	 */
	public String toXmlString() {
		String str = "";

		str += "<column name=\"invoiceId\" value=\""+invoiceId+"\">";
		str += "<column name=\"businessGroupId\" value=\""+businessGroupId+"\">";
		str += "<column name=\"createdBy\" value=\""+createdBy+"\">";
		str += "<column name=\"creationDate\" value=\""+creationDate+"\">";
		str += "<column name=\"invoiceDate\" value=\""+invoiceDate+"\">";
		str += "<column name=\"invoiceNumber\" value=\""+invoiceNumber+"\">";
		str += "<column name=\"invoiceType\" value=\""+invoiceType+"\">";
		str += "<column name=\"lastUpdatedBy\" value=\""+lastUpdatedBy+"\">";
		str += "<column name=\"lastUpdateDate\" value=\""+lastUpdateDate+"\">";
		str += "<column name=\"payToOrganisationId\" value=\""+payToOrganisationId+"\">";
		str += "<column name=\"assignmentProcessId\" value=\""+assignmentProcessId+"\">";
		str += "<column name=\"billingCodeId\" value=\""+billingCodeId+"\">";
		str += "<column name=\"closeDate\" value=\""+closeDate+"\">";
		str += "<column name=\"commentId\" value=\""+commentId+"\">";
		str += "<column name=\"conPeriodEndDate\" value=\""+conPeriodEndDate+"\">";
		str += "<column name=\"conPeriodStartDate\" value=\""+conPeriodStartDate+"\">";
		str += "<column name=\"gstAmount\" value=\""+gstAmount+"\">";
		str += "<column name=\"gstPer\" value=\""+gstPer+"\">";
		str += "<column name=\"invoiceAmount\" value=\""+invoiceAmount+"\">";
		str += "<column name=\"invoicePayrollNotes\" value=\""+invoicePayrollNotes+"\">";
		str += "<column name=\"invCrStatus\" value=\""+invCrStatus+"\">";
		str += "<column name=\"mailToAddress\" value=\""+mailToAddress+"\">";
		str += "<column name=\"mailToAttention\" value=\""+mailToAttention+"\">";
		str += "<column name=\"mailToCountry\" value=\""+mailToCountry+"\">";
		str += "<column name=\"mailToOrganisationId\" value=\""+mailToOrganisationId+"\">";
		str += "<column name=\"mailToPersonId\" value=\""+mailToPersonId+"\">";
		str += "<column name=\"mailToPostCode\" value=\""+mailToPostCode+"\">";
		str += "<column name=\"mailToState\" value=\""+mailToState+"\">";
		str += "<column name=\"mailToSuburb\" value=\""+mailToSuburb+"\">";
		str += "<column name=\"paymentTerms\" value=\""+paymentTerms+"\">";
		str += "<column name=\"payToAddress\" value=\""+payToAddress+"\">";
		str += "<column name=\"payToCountry\" value=\""+payToCountry+"\">";
		str += "<column name=\"payToFax\" value=\""+payToFax+"\">";
		str += "<column name=\"payToPostCode\" value=\""+payToPostCode+"\">";
		str += "<column name=\"payToState\" value=\""+payToState+"\">";
		str += "<column name=\"payToSuburb\" value=\""+payToSuburb+"\">";
		str += "<column name=\"payToTelephone\" value=\""+payToTelephone+"\">";
		str += "<column name=\"periodId\" value=\""+periodId+"\">";
		str += "<column name=\"personId\" value=\""+personId+"\">";
		str += "<column name=\"poNumber\" value=\""+poNumber+"\">";
		str += "<column name=\"source\" value=\""+source+"\">";
		str += "<column name=\"sourceId\" value=\""+sourceId+"\">";
		str += "<column name=\"status\" value=\""+status+"\">";
		str += "<column name=\"insertUserName\" value=\""+insertUserName+"\">";
		str += "<column name=\"updateUserName\" value=\""+updateUserName+"\">";

		return str;
	}

	/**
	 * toJsonString
	 */
	public String toJsonString() {
		String str = "";

		str += "\"invoiceId\":\""+invoiceId+"\", ";
		str += "\"businessGroupId\":\""+businessGroupId+"\", ";
		str += "\"createdBy\":\""+createdBy+"\", ";
		str += "\"creationDate\":\""+creationDate+"\", ";
		str += "\"invoiceDate\":\""+invoiceDate+"\", ";
		str += "\"invoiceNumber\":\""+invoiceNumber+"\", ";
		str += "\"invoiceType\":\""+invoiceType+"\", ";
		str += "\"lastUpdatedBy\":\""+lastUpdatedBy+"\", ";
		str += "\"lastUpdateDate\":\""+lastUpdateDate+"\", ";
		str += "\"payToOrganisationId\":\""+payToOrganisationId+"\", ";
		str += "\"assignmentProcessId\":\""+assignmentProcessId+"\", ";
		str += "\"billingCodeId\":\""+billingCodeId+"\", ";
		str += "\"closeDate\":\""+closeDate+"\", ";
		str += "\"commentId\":\""+commentId+"\", ";
		str += "\"conPeriodEndDate\":\""+conPeriodEndDate+"\", ";
		str += "\"conPeriodStartDate\":\""+conPeriodStartDate+"\", ";
		str += "\"gstAmount\":\""+gstAmount+"\", ";
		str += "\"gstPer\":\""+gstPer+"\", ";
		str += "\"invoiceAmount\":\""+invoiceAmount+"\", ";
		str += "\"invoicePayrollNotes\":\""+invoicePayrollNotes+"\", ";
		str += "\"invCrStatus\":\""+invCrStatus+"\", ";
		str += "\"mailToAddress\":\""+mailToAddress+"\", ";
		str += "\"mailToAttention\":\""+mailToAttention+"\", ";
		str += "\"mailToCountry\":\""+mailToCountry+"\", ";
		str += "\"mailToOrganisationId\":\""+mailToOrganisationId+"\", ";
		str += "\"mailToPersonId\":\""+mailToPersonId+"\", ";
		str += "\"mailToPostCode\":\""+mailToPostCode+"\", ";
		str += "\"mailToState\":\""+mailToState+"\", ";
		str += "\"mailToSuburb\":\""+mailToSuburb+"\", ";
		str += "\"paymentTerms\":\""+paymentTerms+"\", ";
		str += "\"payToAddress\":\""+payToAddress+"\", ";
		str += "\"payToCountry\":\""+payToCountry+"\", ";
		str += "\"payToFax\":\""+payToFax+"\", ";
		str += "\"payToPostCode\":\""+payToPostCode+"\", ";
		str += "\"payToState\":\""+payToState+"\", ";
		str += "\"payToSuburb\":\""+payToSuburb+"\", ";
		str += "\"payToTelephone\":\""+payToTelephone+"\", ";
		str += "\"periodId\":\""+periodId+"\", ";
		str += "\"personId\":\""+personId+"\", ";
		str += "\"poNumber\":\""+poNumber+"\", ";
		str += "\"source\":\""+source+"\", ";
		str += "\"sourceId\":\""+sourceId+"\", ";
		str += "\"status\":\""+status+"\", ";
		str += "\"insertUserName\":\""+insertUserName+"\", ";
		str += "\"updateUserName\":\""+updateUserName+"\"";

		return str;
	}
}