/**************************************************************************************************
 * Framework Generated DTO Source
 * - HP_ASG_PROCESSES - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dto.oracle;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;

import zebra.data.DataSet;
import zebra.util.CommonUtil;
import project.common.extend.BaseDto;

@SuppressWarnings("unused")
public class HpAsgProcesses extends BaseDto implements Serializable {
	/**
	 * Columns
	 */
	private double assignmentProcessId;
	private String ASSIGNMENT_PROCESS_ID;
	private double assignmentId;
	private String ASSIGNMENT_ID;
	private double createdBy;
	private String CREATED_BY;
	private Date creationDate;
	private String CREATION_DATE;
	private double lastUpdatedBy;
	private String LAST_UPDATED_BY;
	private Date lastUpdateDate;
	private String LAST_UPDATE_DATE;
	private double payrollProcessId;
	private String PAYROLL_PROCESS_ID;
	private String actionLog;
	private String ACTION_LOG;
	private String assignmentPayrollNotes;
	private String ASSIGNMENT_PAYROLL_NOTES;
	private String confirmCommentsStatus;
	private String CONFIRM_COMMENTS_STATUS;
	private double invoiceId;
	private String INVOICE_ID;
	private double paymentId;
	private String PAYMENT_ID;
	private String payrollNotes;
	private String PAYROLL_NOTES;
	private String processStatus;
	private String PROCESS_STATUS;
	private String scheduledPayrollNotes;
	private String SCHEDULED_PAYROLL_NOTES;
	private String vendorInvoiceNo;
	private String VENDOR_INVOICE_NO;
	private String insertUserName;
	private String INSERT_USER_NAME;
	private String updateUserName;
	private String UPDATE_USER_NAME;

	/**
	 * Constructor
	 */
	@SuppressWarnings("rawtypes")
	public HpAsgProcesses() throws Exception {
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
		setFrwVarPrimaryKey("ASSIGNMENT_PROCESS_ID");
		setFrwVarDateColumn("CREATION_DATE,LAST_UPDATE_DATE");
		setFrwVarNumberColumn("ASSIGNMENT_PROCESS_ID,ASSIGNMENT_ID,CREATED_BY,LAST_UPDATED_BY,PAYROLL_PROCESS_ID,INVOICE_ID,PAYMENT_ID");
		setFrwVarClobColumn("");
		setFrwVarDefaultColumn("");
		setFrwVarDefaultValue("");
		setDefaultValue();
	}

	/**
	 * Accessors
	 */
	public double getAssignmentProcessId() {
		return assignmentProcessId;
	}

	public void setAssignmentProcessId(double assignmentProcessId) throws Exception {
		this.assignmentProcessId = assignmentProcessId;
		setValueFromAccessor("ASSIGNMENT_PROCESS_ID", CommonUtil.toString(assignmentProcessId));
	}

	public double getAssignmentId() {
		return assignmentId;
	}

	public void setAssignmentId(double assignmentId) throws Exception {
		this.assignmentId = assignmentId;
		setValueFromAccessor("ASSIGNMENT_ID", CommonUtil.toString(assignmentId));
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

	public double getPayrollProcessId() {
		return payrollProcessId;
	}

	public void setPayrollProcessId(double payrollProcessId) throws Exception {
		this.payrollProcessId = payrollProcessId;
		setValueFromAccessor("PAYROLL_PROCESS_ID", CommonUtil.toString(payrollProcessId));
	}

	public String getActionLog() {
		return actionLog;
	}

	public void setActionLog(String actionLog) throws Exception {
		this.actionLog = actionLog;
		setValueFromAccessor("ACTION_LOG", actionLog);
	}

	public String getAssignmentPayrollNotes() {
		return assignmentPayrollNotes;
	}

	public void setAssignmentPayrollNotes(String assignmentPayrollNotes) throws Exception {
		this.assignmentPayrollNotes = assignmentPayrollNotes;
		setValueFromAccessor("ASSIGNMENT_PAYROLL_NOTES", assignmentPayrollNotes);
	}

	public String getConfirmCommentsStatus() {
		return confirmCommentsStatus;
	}

	public void setConfirmCommentsStatus(String confirmCommentsStatus) throws Exception {
		this.confirmCommentsStatus = confirmCommentsStatus;
		setValueFromAccessor("CONFIRM_COMMENTS_STATUS", confirmCommentsStatus);
	}

	public double getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(double invoiceId) throws Exception {
		this.invoiceId = invoiceId;
		setValueFromAccessor("INVOICE_ID", CommonUtil.toString(invoiceId));
	}

	public double getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(double paymentId) throws Exception {
		this.paymentId = paymentId;
		setValueFromAccessor("PAYMENT_ID", CommonUtil.toString(paymentId));
	}

	public String getPayrollNotes() {
		return payrollNotes;
	}

	public void setPayrollNotes(String payrollNotes) throws Exception {
		this.payrollNotes = payrollNotes;
		setValueFromAccessor("PAYROLL_NOTES", payrollNotes);
	}

	public String getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(String processStatus) throws Exception {
		this.processStatus = processStatus;
		setValueFromAccessor("PROCESS_STATUS", processStatus);
	}

	public String getScheduledPayrollNotes() {
		return scheduledPayrollNotes;
	}

	public void setScheduledPayrollNotes(String scheduledPayrollNotes) throws Exception {
		this.scheduledPayrollNotes = scheduledPayrollNotes;
		setValueFromAccessor("SCHEDULED_PAYROLL_NOTES", scheduledPayrollNotes);
	}

	public String getVendorInvoiceNo() {
		return vendorInvoiceNo;
	}

	public void setVendorInvoiceNo(String vendorInvoiceNo) throws Exception {
		this.vendorInvoiceNo = vendorInvoiceNo;
		setValueFromAccessor("VENDOR_INVOICE_NO", vendorInvoiceNo);
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

		str += "assignmentProcessId : "+assignmentProcessId+"\n";
		str += "assignmentId : "+assignmentId+"\n";
		str += "createdBy : "+createdBy+"\n";
		str += "creationDate : "+creationDate+"\n";
		str += "lastUpdatedBy : "+lastUpdatedBy+"\n";
		str += "lastUpdateDate : "+lastUpdateDate+"\n";
		str += "payrollProcessId : "+payrollProcessId+"\n";
		str += "actionLog : "+actionLog+"\n";
		str += "assignmentPayrollNotes : "+assignmentPayrollNotes+"\n";
		str += "confirmCommentsStatus : "+confirmCommentsStatus+"\n";
		str += "invoiceId : "+invoiceId+"\n";
		str += "paymentId : "+paymentId+"\n";
		str += "payrollNotes : "+payrollNotes+"\n";
		str += "processStatus : "+processStatus+"\n";
		str += "scheduledPayrollNotes : "+scheduledPayrollNotes+"\n";
		str += "vendorInvoiceNo : "+vendorInvoiceNo+"\n";
		str += "insertUserName : "+insertUserName+"\n";
		str += "updateUserName : "+updateUserName+"\n";

		return str;
	}

	/**
	 * toXmlString
	 */
	public String toXmlString() {
		String str = "";

		str += "<column name=\"assignmentProcessId\" value=\""+assignmentProcessId+"\">";
		str += "<column name=\"assignmentId\" value=\""+assignmentId+"\">";
		str += "<column name=\"createdBy\" value=\""+createdBy+"\">";
		str += "<column name=\"creationDate\" value=\""+creationDate+"\">";
		str += "<column name=\"lastUpdatedBy\" value=\""+lastUpdatedBy+"\">";
		str += "<column name=\"lastUpdateDate\" value=\""+lastUpdateDate+"\">";
		str += "<column name=\"payrollProcessId\" value=\""+payrollProcessId+"\">";
		str += "<column name=\"actionLog\" value=\""+actionLog+"\">";
		str += "<column name=\"assignmentPayrollNotes\" value=\""+assignmentPayrollNotes+"\">";
		str += "<column name=\"confirmCommentsStatus\" value=\""+confirmCommentsStatus+"\">";
		str += "<column name=\"invoiceId\" value=\""+invoiceId+"\">";
		str += "<column name=\"paymentId\" value=\""+paymentId+"\">";
		str += "<column name=\"payrollNotes\" value=\""+payrollNotes+"\">";
		str += "<column name=\"processStatus\" value=\""+processStatus+"\">";
		str += "<column name=\"scheduledPayrollNotes\" value=\""+scheduledPayrollNotes+"\">";
		str += "<column name=\"vendorInvoiceNo\" value=\""+vendorInvoiceNo+"\">";
		str += "<column name=\"insertUserName\" value=\""+insertUserName+"\">";
		str += "<column name=\"updateUserName\" value=\""+updateUserName+"\">";

		return str;
	}

	/**
	 * toJsonString
	 */
	public String toJsonString() {
		String str = "";

		str += "\"assignmentProcessId\":\""+assignmentProcessId+"\", ";
		str += "\"assignmentId\":\""+assignmentId+"\", ";
		str += "\"createdBy\":\""+createdBy+"\", ";
		str += "\"creationDate\":\""+creationDate+"\", ";
		str += "\"lastUpdatedBy\":\""+lastUpdatedBy+"\", ";
		str += "\"lastUpdateDate\":\""+lastUpdateDate+"\", ";
		str += "\"payrollProcessId\":\""+payrollProcessId+"\", ";
		str += "\"actionLog\":\""+actionLog+"\", ";
		str += "\"assignmentPayrollNotes\":\""+assignmentPayrollNotes+"\", ";
		str += "\"confirmCommentsStatus\":\""+confirmCommentsStatus+"\", ";
		str += "\"invoiceId\":\""+invoiceId+"\", ";
		str += "\"paymentId\":\""+paymentId+"\", ";
		str += "\"payrollNotes\":\""+payrollNotes+"\", ";
		str += "\"processStatus\":\""+processStatus+"\", ";
		str += "\"scheduledPayrollNotes\":\""+scheduledPayrollNotes+"\", ";
		str += "\"vendorInvoiceNo\":\""+vendorInvoiceNo+"\", ";
		str += "\"insertUserName\":\""+insertUserName+"\", ";
		str += "\"updateUserName\":\""+updateUserName+"\"";

		return str;
	}
}