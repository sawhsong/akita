/**************************************************************************************************
 * Framework Generated DTO Source
 * - HP_CONTACT_HISTORY - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dto.oracle;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;

import zebra.data.DataSet;
import zebra.util.CommonUtil;
import project.common.extend.BaseDto;

@SuppressWarnings("unused")
public class HpContactHistory extends BaseDto implements Serializable {
	/**
	 * Columns
	 */
	private double contactId;
	private String CONTACT_ID;
	private double createdBy;
	private String CREATED_BY;
	private Date creationDate;
	private String CREATION_DATE;
	private double lastUpdatedBy;
	private String LAST_UPDATED_BY;
	private Date lastUpdateDate;
	private String LAST_UPDATE_DATE;
	private String activityType;
	private String ACTIVITY_TYPE;
	private double businessGroupId;
	private String BUSINESS_GROUP_ID;
	private String comments;
	private String COMMENTS;
	private Date contactDate;
	private String CONTACT_DATE;
	private String contactTime;
	private String CONTACT_TIME;
	private String contactType;
	private String CONTACT_TYPE;
	private String copyToOrganisation;
	private String COPY_TO_ORGANISATION;
	private String copyToPerson;
	private String COPY_TO_PERSON;
	private double entityEmployeeId;
	private String ENTITY_EMPLOYEE_ID;
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
	public HpContactHistory() throws Exception {
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
		setFrwVarPrimaryKey("CONTACT_ID");
		setFrwVarDateColumn("CREATION_DATE,LAST_UPDATE_DATE,CONTACT_DATE");
		setFrwVarNumberColumn("CONTACT_ID,CREATED_BY,LAST_UPDATED_BY,BUSINESS_GROUP_ID,ENTITY_EMPLOYEE_ID,ORGANISATION_ID,PERSON_ID");
		setFrwVarClobColumn("");
		setFrwVarDefaultColumn("CONTACT_TIME");
		setFrwVarDefaultValue("00:00");
		setDefaultValue();
	}

	/**
	 * Accessors
	 */
	public double getContactId() {
		return contactId;
	}

	public void setContactId(double contactId) throws Exception {
		this.contactId = contactId;
		setValueFromAccessor("CONTACT_ID", CommonUtil.toString(contactId));
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

	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) throws Exception {
		this.activityType = activityType;
		setValueFromAccessor("ACTIVITY_TYPE", activityType);
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

	public Date getContactDate() {
		return contactDate;
	}

	public void setContactDate(Date contactDate) throws Exception {
		this.contactDate = contactDate;
		setValueFromAccessor("CONTACT_DATE", CommonUtil.toString(contactDate));
	}

	public String getContactTime() {
		return contactTime;
	}

	public void setContactTime(String contactTime) throws Exception {
		this.contactTime = contactTime;
		setValueFromAccessor("CONTACT_TIME", contactTime);
	}

	public String getContactType() {
		return contactType;
	}

	public void setContactType(String contactType) throws Exception {
		this.contactType = contactType;
		setValueFromAccessor("CONTACT_TYPE", contactType);
	}

	public String getCopyToOrganisation() {
		return copyToOrganisation;
	}

	public void setCopyToOrganisation(String copyToOrganisation) throws Exception {
		this.copyToOrganisation = copyToOrganisation;
		setValueFromAccessor("COPY_TO_ORGANISATION", copyToOrganisation);
	}

	public String getCopyToPerson() {
		return copyToPerson;
	}

	public void setCopyToPerson(String copyToPerson) throws Exception {
		this.copyToPerson = copyToPerson;
		setValueFromAccessor("COPY_TO_PERSON", copyToPerson);
	}

	public double getEntityEmployeeId() {
		return entityEmployeeId;
	}

	public void setEntityEmployeeId(double entityEmployeeId) throws Exception {
		this.entityEmployeeId = entityEmployeeId;
		setValueFromAccessor("ENTITY_EMPLOYEE_ID", CommonUtil.toString(entityEmployeeId));
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

		str += "contactId : "+contactId+"\n";
		str += "createdBy : "+createdBy+"\n";
		str += "creationDate : "+creationDate+"\n";
		str += "lastUpdatedBy : "+lastUpdatedBy+"\n";
		str += "lastUpdateDate : "+lastUpdateDate+"\n";
		str += "activityType : "+activityType+"\n";
		str += "businessGroupId : "+businessGroupId+"\n";
		str += "comments : "+comments+"\n";
		str += "contactDate : "+contactDate+"\n";
		str += "contactTime : "+contactTime+"\n";
		str += "contactType : "+contactType+"\n";
		str += "copyToOrganisation : "+copyToOrganisation+"\n";
		str += "copyToPerson : "+copyToPerson+"\n";
		str += "entityEmployeeId : "+entityEmployeeId+"\n";
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

		str += "<column name=\"contactId\" value=\""+contactId+"\">";
		str += "<column name=\"createdBy\" value=\""+createdBy+"\">";
		str += "<column name=\"creationDate\" value=\""+creationDate+"\">";
		str += "<column name=\"lastUpdatedBy\" value=\""+lastUpdatedBy+"\">";
		str += "<column name=\"lastUpdateDate\" value=\""+lastUpdateDate+"\">";
		str += "<column name=\"activityType\" value=\""+activityType+"\">";
		str += "<column name=\"businessGroupId\" value=\""+businessGroupId+"\">";
		str += "<column name=\"comments\" value=\""+comments+"\">";
		str += "<column name=\"contactDate\" value=\""+contactDate+"\">";
		str += "<column name=\"contactTime\" value=\""+contactTime+"\">";
		str += "<column name=\"contactType\" value=\""+contactType+"\">";
		str += "<column name=\"copyToOrganisation\" value=\""+copyToOrganisation+"\">";
		str += "<column name=\"copyToPerson\" value=\""+copyToPerson+"\">";
		str += "<column name=\"entityEmployeeId\" value=\""+entityEmployeeId+"\">";
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

		str += "\"contactId\":\""+contactId+"\", ";
		str += "\"createdBy\":\""+createdBy+"\", ";
		str += "\"creationDate\":\""+creationDate+"\", ";
		str += "\"lastUpdatedBy\":\""+lastUpdatedBy+"\", ";
		str += "\"lastUpdateDate\":\""+lastUpdateDate+"\", ";
		str += "\"activityType\":\""+activityType+"\", ";
		str += "\"businessGroupId\":\""+businessGroupId+"\", ";
		str += "\"comments\":\""+comments+"\", ";
		str += "\"contactDate\":\""+contactDate+"\", ";
		str += "\"contactTime\":\""+contactTime+"\", ";
		str += "\"contactType\":\""+contactType+"\", ";
		str += "\"copyToOrganisation\":\""+copyToOrganisation+"\", ";
		str += "\"copyToPerson\":\""+copyToPerson+"\", ";
		str += "\"entityEmployeeId\":\""+entityEmployeeId+"\", ";
		str += "\"organisationId\":\""+organisationId+"\", ";
		str += "\"personId\":\""+personId+"\", ";
		str += "\"insertUserName\":\""+insertUserName+"\", ";
		str += "\"updateUserName\":\""+updateUserName+"\"";

		return str;
	}
}