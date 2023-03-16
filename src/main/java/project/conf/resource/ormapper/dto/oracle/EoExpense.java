/**************************************************************************************************
 * Framework Generated DTO Source
 * - EO_EXPENSE - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dto.oracle;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;

import zebra.data.DataSet;
import zebra.util.CommonUtil;
import project.common.extend.BaseDto;

@SuppressWarnings("unused")
public class EoExpense extends BaseDto implements Serializable {
	/**
	 * Columns
	 */
	private double eoExpenseId;
	private String EO_EXPENSE_ID;
	private double approverId;
	private String APPROVER_ID;
	private double assignmentId;
	private String ASSIGNMENT_ID;
	private String approveRejectComments;
	private String APPROVE_REJECT_COMMENTS;
	private Date approveRejectDateTime;
	private String APPROVE_REJECT_DATE_TIME;
	private String approveRejectIp;
	private String APPROVE_REJECT_IP;
	private double approveRejectPersonId;
	private String APPROVE_REJECT_PERSON_ID;
	private double createdBy;
	private String CREATED_BY;
	private Date creationDate;
	private String CREATION_DATE;
	private String description;
	private String DESCRIPTION;
	private double lastUpdatedBy;
	private String LAST_UPDATED_BY;
	private Date lastUpdateDate;
	private String LAST_UPDATE_DATE;
	private String status;
	private String STATUS;
	private Date submitDateTime;
	private String SUBMIT_DATE_TIME;
	private String insertUserName;
	private String INSERT_USER_NAME;
	private String updateUserName;
	private String UPDATE_USER_NAME;

	/**
	 * Constructor
	 */
	@SuppressWarnings("rawtypes")
	public EoExpense() throws Exception {
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
		setFrwVarPrimaryKey("EO_EXPENSE_ID");
		setFrwVarDateColumn("APPROVE_REJECT_DATE_TIME,CREATION_DATE,LAST_UPDATE_DATE,SUBMIT_DATE_TIME");
		setFrwVarNumberColumn("EO_EXPENSE_ID,APPROVER_ID,ASSIGNMENT_ID,APPROVE_REJECT_PERSON_ID,CREATED_BY,LAST_UPDATED_BY");
		setFrwVarClobColumn("");
		setFrwVarDefaultColumn("");
		setFrwVarDefaultValue("");
		setDefaultValue();
	}

	/**
	 * Accessors
	 */
	public double getEoExpenseId() {
		return eoExpenseId;
	}

	public void setEoExpenseId(double eoExpenseId) throws Exception {
		this.eoExpenseId = eoExpenseId;
		setValueFromAccessor("EO_EXPENSE_ID", CommonUtil.toString(eoExpenseId));
	}

	public double getApproverId() {
		return approverId;
	}

	public void setApproverId(double approverId) throws Exception {
		this.approverId = approverId;
		setValueFromAccessor("APPROVER_ID", CommonUtil.toString(approverId));
	}

	public double getAssignmentId() {
		return assignmentId;
	}

	public void setAssignmentId(double assignmentId) throws Exception {
		this.assignmentId = assignmentId;
		setValueFromAccessor("ASSIGNMENT_ID", CommonUtil.toString(assignmentId));
	}

	public String getApproveRejectComments() {
		return approveRejectComments;
	}

	public void setApproveRejectComments(String approveRejectComments) throws Exception {
		this.approveRejectComments = approveRejectComments;
		setValueFromAccessor("APPROVE_REJECT_COMMENTS", approveRejectComments);
	}

	public Date getApproveRejectDateTime() {
		return approveRejectDateTime;
	}

	public void setApproveRejectDateTime(Date approveRejectDateTime) throws Exception {
		this.approveRejectDateTime = approveRejectDateTime;
		setValueFromAccessor("APPROVE_REJECT_DATE_TIME", CommonUtil.toString(approveRejectDateTime));
	}

	public String getApproveRejectIp() {
		return approveRejectIp;
	}

	public void setApproveRejectIp(String approveRejectIp) throws Exception {
		this.approveRejectIp = approveRejectIp;
		setValueFromAccessor("APPROVE_REJECT_IP", approveRejectIp);
	}

	public double getApproveRejectPersonId() {
		return approveRejectPersonId;
	}

	public void setApproveRejectPersonId(double approveRejectPersonId) throws Exception {
		this.approveRejectPersonId = approveRejectPersonId;
		setValueFromAccessor("APPROVE_REJECT_PERSON_ID", CommonUtil.toString(approveRejectPersonId));
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) throws Exception {
		this.description = description;
		setValueFromAccessor("DESCRIPTION", description);
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) throws Exception {
		this.status = status;
		setValueFromAccessor("STATUS", status);
	}

	public Date getSubmitDateTime() {
		return submitDateTime;
	}

	public void setSubmitDateTime(Date submitDateTime) throws Exception {
		this.submitDateTime = submitDateTime;
		setValueFromAccessor("SUBMIT_DATE_TIME", CommonUtil.toString(submitDateTime));
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

		str += "eoExpenseId : "+eoExpenseId+"\n";
		str += "approverId : "+approverId+"\n";
		str += "assignmentId : "+assignmentId+"\n";
		str += "approveRejectComments : "+approveRejectComments+"\n";
		str += "approveRejectDateTime : "+approveRejectDateTime+"\n";
		str += "approveRejectIp : "+approveRejectIp+"\n";
		str += "approveRejectPersonId : "+approveRejectPersonId+"\n";
		str += "createdBy : "+createdBy+"\n";
		str += "creationDate : "+creationDate+"\n";
		str += "description : "+description+"\n";
		str += "lastUpdatedBy : "+lastUpdatedBy+"\n";
		str += "lastUpdateDate : "+lastUpdateDate+"\n";
		str += "status : "+status+"\n";
		str += "submitDateTime : "+submitDateTime+"\n";
		str += "insertUserName : "+insertUserName+"\n";
		str += "updateUserName : "+updateUserName+"\n";

		return str;
	}

	/**
	 * toXmlString
	 */
	public String toXmlString() {
		String str = "";

		str += "<column name=\"eoExpenseId\" value=\""+eoExpenseId+"\">";
		str += "<column name=\"approverId\" value=\""+approverId+"\">";
		str += "<column name=\"assignmentId\" value=\""+assignmentId+"\">";
		str += "<column name=\"approveRejectComments\" value=\""+approveRejectComments+"\">";
		str += "<column name=\"approveRejectDateTime\" value=\""+approveRejectDateTime+"\">";
		str += "<column name=\"approveRejectIp\" value=\""+approveRejectIp+"\">";
		str += "<column name=\"approveRejectPersonId\" value=\""+approveRejectPersonId+"\">";
		str += "<column name=\"createdBy\" value=\""+createdBy+"\">";
		str += "<column name=\"creationDate\" value=\""+creationDate+"\">";
		str += "<column name=\"description\" value=\""+description+"\">";
		str += "<column name=\"lastUpdatedBy\" value=\""+lastUpdatedBy+"\">";
		str += "<column name=\"lastUpdateDate\" value=\""+lastUpdateDate+"\">";
		str += "<column name=\"status\" value=\""+status+"\">";
		str += "<column name=\"submitDateTime\" value=\""+submitDateTime+"\">";
		str += "<column name=\"insertUserName\" value=\""+insertUserName+"\">";
		str += "<column name=\"updateUserName\" value=\""+updateUserName+"\">";

		return str;
	}

	/**
	 * toJsonString
	 */
	public String toJsonString() {
		String str = "";

		str += "\"eoExpenseId\":\""+eoExpenseId+"\", ";
		str += "\"approverId\":\""+approverId+"\", ";
		str += "\"assignmentId\":\""+assignmentId+"\", ";
		str += "\"approveRejectComments\":\""+approveRejectComments+"\", ";
		str += "\"approveRejectDateTime\":\""+approveRejectDateTime+"\", ";
		str += "\"approveRejectIp\":\""+approveRejectIp+"\", ";
		str += "\"approveRejectPersonId\":\""+approveRejectPersonId+"\", ";
		str += "\"createdBy\":\""+createdBy+"\", ";
		str += "\"creationDate\":\""+creationDate+"\", ";
		str += "\"description\":\""+description+"\", ";
		str += "\"lastUpdatedBy\":\""+lastUpdatedBy+"\", ";
		str += "\"lastUpdateDate\":\""+lastUpdateDate+"\", ";
		str += "\"status\":\""+status+"\", ";
		str += "\"submitDateTime\":\""+submitDateTime+"\", ";
		str += "\"insertUserName\":\""+insertUserName+"\", ";
		str += "\"updateUserName\":\""+updateUserName+"\"";

		return str;
	}
}