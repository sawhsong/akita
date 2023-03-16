/**************************************************************************************************
 * Framework Generated DTO Source
 * - HP_NEXT_ACTIONS - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dto.oracle;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;

import zebra.data.DataSet;
import zebra.util.CommonUtil;
import project.common.extend.BaseDto;

@SuppressWarnings("unused")
public class HpNextActions extends BaseDto implements Serializable {
	/**
	 * Columns
	 */
	private double nextActionId;
	private String NEXT_ACTION_ID;
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
	private double actionClosedBy;
	private String ACTION_CLOSED_BY;
	private Date actionClosedDate;
	private String ACTION_CLOSED_DATE;
	private String actionComments;
	private String ACTION_COMMENTS;
	private Date actionDate;
	private String ACTION_DATE;
	private double actionDateChangedCount;
	private String ACTION_DATE_CHANGED_COUNT;
	private Date actionDateOriginal;
	private String ACTION_DATE_ORIGINAL;
	private String actionStatus;
	private String ACTION_STATUS;
	private String actionTime;
	private String ACTION_TIME;
	private String actionType;
	private String ACTION_TYPE;
	private double assignedPersonId;
	private String ASSIGNED_PERSON_ID;
	private double forOrganisation;
	private String FOR_ORGANISATION;
	private double forPerson;
	private String FOR_PERSON;
	private double organisationId;
	private String ORGANISATION_ID;
	private double personId;
	private String PERSON_ID;
	private String insertUserName;
	private String INSERT_USER_NAME;
	private String updateUserName;
	private String UPDATE_USER_NAME;

	/**
	 * Constructor
	 */
	@SuppressWarnings("rawtypes")
	public HpNextActions() throws Exception {
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
		setFrwVarPrimaryKey("NEXT_ACTION_ID");
		setFrwVarDateColumn("CREATION_DATE,LAST_UPDATE_DATE,ACTION_CLOSED_DATE,ACTION_DATE,ACTION_DATE_ORIGINAL");
		setFrwVarNumberColumn("NEXT_ACTION_ID,BUSINESS_GROUP_ID,CREATED_BY,LAST_UPDATED_BY,ACTION_CLOSED_BY,ACTION_DATE_CHANGED_COUNT,ASSIGNED_PERSON_ID,FOR_ORGANISATION,FOR_PERSON,ORGANISATION_ID,PERSON_ID");
		setFrwVarClobColumn("");
		setFrwVarDefaultColumn("");
		setFrwVarDefaultValue("");
		setDefaultValue();
	}

	/**
	 * Accessors
	 */
	public double getNextActionId() {
		return nextActionId;
	}

	public void setNextActionId(double nextActionId) throws Exception {
		this.nextActionId = nextActionId;
		setValueFromAccessor("NEXT_ACTION_ID", CommonUtil.toString(nextActionId));
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

	public double getActionClosedBy() {
		return actionClosedBy;
	}

	public void setActionClosedBy(double actionClosedBy) throws Exception {
		this.actionClosedBy = actionClosedBy;
		setValueFromAccessor("ACTION_CLOSED_BY", CommonUtil.toString(actionClosedBy));
	}

	public Date getActionClosedDate() {
		return actionClosedDate;
	}

	public void setActionClosedDate(Date actionClosedDate) throws Exception {
		this.actionClosedDate = actionClosedDate;
		setValueFromAccessor("ACTION_CLOSED_DATE", CommonUtil.toString(actionClosedDate));
	}

	public String getActionComments() {
		return actionComments;
	}

	public void setActionComments(String actionComments) throws Exception {
		this.actionComments = actionComments;
		setValueFromAccessor("ACTION_COMMENTS", actionComments);
	}

	public Date getActionDate() {
		return actionDate;
	}

	public void setActionDate(Date actionDate) throws Exception {
		this.actionDate = actionDate;
		setValueFromAccessor("ACTION_DATE", CommonUtil.toString(actionDate));
	}

	public double getActionDateChangedCount() {
		return actionDateChangedCount;
	}

	public void setActionDateChangedCount(double actionDateChangedCount) throws Exception {
		this.actionDateChangedCount = actionDateChangedCount;
		setValueFromAccessor("ACTION_DATE_CHANGED_COUNT", CommonUtil.toString(actionDateChangedCount));
	}

	public Date getActionDateOriginal() {
		return actionDateOriginal;
	}

	public void setActionDateOriginal(Date actionDateOriginal) throws Exception {
		this.actionDateOriginal = actionDateOriginal;
		setValueFromAccessor("ACTION_DATE_ORIGINAL", CommonUtil.toString(actionDateOriginal));
	}

	public String getActionStatus() {
		return actionStatus;
	}

	public void setActionStatus(String actionStatus) throws Exception {
		this.actionStatus = actionStatus;
		setValueFromAccessor("ACTION_STATUS", actionStatus);
	}

	public String getActionTime() {
		return actionTime;
	}

	public void setActionTime(String actionTime) throws Exception {
		this.actionTime = actionTime;
		setValueFromAccessor("ACTION_TIME", actionTime);
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) throws Exception {
		this.actionType = actionType;
		setValueFromAccessor("ACTION_TYPE", actionType);
	}

	public double getAssignedPersonId() {
		return assignedPersonId;
	}

	public void setAssignedPersonId(double assignedPersonId) throws Exception {
		this.assignedPersonId = assignedPersonId;
		setValueFromAccessor("ASSIGNED_PERSON_ID", CommonUtil.toString(assignedPersonId));
	}

	public double getForOrganisation() {
		return forOrganisation;
	}

	public void setForOrganisation(double forOrganisation) throws Exception {
		this.forOrganisation = forOrganisation;
		setValueFromAccessor("FOR_ORGANISATION", CommonUtil.toString(forOrganisation));
	}

	public double getForPerson() {
		return forPerson;
	}

	public void setForPerson(double forPerson) throws Exception {
		this.forPerson = forPerson;
		setValueFromAccessor("FOR_PERSON", CommonUtil.toString(forPerson));
	}

	public double getOrganisationId() {
		return organisationId;
	}

	public void setOrganisationId(double organisationId) throws Exception {
		this.organisationId = organisationId;
		setValueFromAccessor("ORGANISATION_ID", CommonUtil.toString(organisationId));
	}

	public double getPersonId() {
		return personId;
	}

	public void setPersonId(double personId) throws Exception {
		this.personId = personId;
		setValueFromAccessor("PERSON_ID", CommonUtil.toString(personId));
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

		str += "nextActionId : "+nextActionId+"\n";
		str += "businessGroupId : "+businessGroupId+"\n";
		str += "createdBy : "+createdBy+"\n";
		str += "creationDate : "+creationDate+"\n";
		str += "lastUpdatedBy : "+lastUpdatedBy+"\n";
		str += "lastUpdateDate : "+lastUpdateDate+"\n";
		str += "actionClosedBy : "+actionClosedBy+"\n";
		str += "actionClosedDate : "+actionClosedDate+"\n";
		str += "actionComments : "+actionComments+"\n";
		str += "actionDate : "+actionDate+"\n";
		str += "actionDateChangedCount : "+actionDateChangedCount+"\n";
		str += "actionDateOriginal : "+actionDateOriginal+"\n";
		str += "actionStatus : "+actionStatus+"\n";
		str += "actionTime : "+actionTime+"\n";
		str += "actionType : "+actionType+"\n";
		str += "assignedPersonId : "+assignedPersonId+"\n";
		str += "forOrganisation : "+forOrganisation+"\n";
		str += "forPerson : "+forPerson+"\n";
		str += "organisationId : "+organisationId+"\n";
		str += "personId : "+personId+"\n";
		str += "insertUserName : "+insertUserName+"\n";
		str += "updateUserName : "+updateUserName+"\n";

		return str;
	}

	/**
	 * toXmlString
	 */
	public String toXmlString() {
		String str = "";

		str += "<column name=\"nextActionId\" value=\""+nextActionId+"\">";
		str += "<column name=\"businessGroupId\" value=\""+businessGroupId+"\">";
		str += "<column name=\"createdBy\" value=\""+createdBy+"\">";
		str += "<column name=\"creationDate\" value=\""+creationDate+"\">";
		str += "<column name=\"lastUpdatedBy\" value=\""+lastUpdatedBy+"\">";
		str += "<column name=\"lastUpdateDate\" value=\""+lastUpdateDate+"\">";
		str += "<column name=\"actionClosedBy\" value=\""+actionClosedBy+"\">";
		str += "<column name=\"actionClosedDate\" value=\""+actionClosedDate+"\">";
		str += "<column name=\"actionComments\" value=\""+actionComments+"\">";
		str += "<column name=\"actionDate\" value=\""+actionDate+"\">";
		str += "<column name=\"actionDateChangedCount\" value=\""+actionDateChangedCount+"\">";
		str += "<column name=\"actionDateOriginal\" value=\""+actionDateOriginal+"\">";
		str += "<column name=\"actionStatus\" value=\""+actionStatus+"\">";
		str += "<column name=\"actionTime\" value=\""+actionTime+"\">";
		str += "<column name=\"actionType\" value=\""+actionType+"\">";
		str += "<column name=\"assignedPersonId\" value=\""+assignedPersonId+"\">";
		str += "<column name=\"forOrganisation\" value=\""+forOrganisation+"\">";
		str += "<column name=\"forPerson\" value=\""+forPerson+"\">";
		str += "<column name=\"organisationId\" value=\""+organisationId+"\">";
		str += "<column name=\"personId\" value=\""+personId+"\">";
		str += "<column name=\"insertUserName\" value=\""+insertUserName+"\">";
		str += "<column name=\"updateUserName\" value=\""+updateUserName+"\">";

		return str;
	}

	/**
	 * toJsonString
	 */
	public String toJsonString() {
		String str = "";

		str += "\"nextActionId\":\""+nextActionId+"\", ";
		str += "\"businessGroupId\":\""+businessGroupId+"\", ";
		str += "\"createdBy\":\""+createdBy+"\", ";
		str += "\"creationDate\":\""+creationDate+"\", ";
		str += "\"lastUpdatedBy\":\""+lastUpdatedBy+"\", ";
		str += "\"lastUpdateDate\":\""+lastUpdateDate+"\", ";
		str += "\"actionClosedBy\":\""+actionClosedBy+"\", ";
		str += "\"actionClosedDate\":\""+actionClosedDate+"\", ";
		str += "\"actionComments\":\""+actionComments+"\", ";
		str += "\"actionDate\":\""+actionDate+"\", ";
		str += "\"actionDateChangedCount\":\""+actionDateChangedCount+"\", ";
		str += "\"actionDateOriginal\":\""+actionDateOriginal+"\", ";
		str += "\"actionStatus\":\""+actionStatus+"\", ";
		str += "\"actionTime\":\""+actionTime+"\", ";
		str += "\"actionType\":\""+actionType+"\", ";
		str += "\"assignedPersonId\":\""+assignedPersonId+"\", ";
		str += "\"forOrganisation\":\""+forOrganisation+"\", ";
		str += "\"forPerson\":\""+forPerson+"\", ";
		str += "\"organisationId\":\""+organisationId+"\", ";
		str += "\"personId\":\""+personId+"\", ";
		str += "\"insertUserName\":\""+insertUserName+"\", ";
		str += "\"updateUserName\":\""+updateUserName+"\"";

		return str;
	}
}