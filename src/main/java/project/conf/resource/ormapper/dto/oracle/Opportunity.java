/**************************************************************************************************
 * Framework Generated DTO Source
 * - OPPORTUNITY - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dto.oracle;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;

import zebra.data.DataSet;
import zebra.util.CommonUtil;
import project.common.extend.BaseDto;

@SuppressWarnings("unused")
public class Opportunity extends BaseDto implements Serializable {
	/**
	 * Columns
	 */
	private double opportunityId;
	private String OPPORTUNITY_ID;
	private double createdBy;
	private String CREATED_BY;
	private Date creationDate;
	private String CREATION_DATE;
	private double lastUpdatedBy;
	private String LAST_UPDATED_BY;
	private Date lastUpdateDate;
	private String LAST_UPDATE_DATE;
	private String opportunityType;
	private String OPPORTUNITY_TYPE;
	private double personId;
	private String PERSON_ID;
	private double assignedPersonId;
	private String ASSIGNED_PERSON_ID;
	private String closeAs;
	private String CLOSE_AS;
	private double closeBy;
	private String CLOSE_BY;
	private Date closeDate;
	private String CLOSE_DATE;
	private String closeNotes;
	private String CLOSE_NOTES;
	private String closeReason;
	private String CLOSE_REASON;
	private String comments;
	private String COMMENTS;
	private String customerReferenceDescription;
	private String CUSTOMER_REFERENCE_DESCRIPTION;
	private String customerReferenceNumber;
	private String CUSTOMER_REFERENCE_NUMBER;
	private double customerRelationshipMgrId;
	private String CUSTOMER_RELATIONSHIP_MGR_ID;
	private double customerSupportMgrId;
	private String CUSTOMER_SUPPORT_MGR_ID;
	private Date dueDate;
	private String DUE_DATE;
	private double estimatedRevenue;
	private String ESTIMATED_REVENUE;
	private String priority;
	private String PRIORITY;
	private String serviceStatus;
	private String SERVICE_STATUS;
	private String serviceType;
	private String SERVICE_TYPE;
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
	public Opportunity() throws Exception {
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
		setFrwVarPrimaryKey("OPPORTUNITY_ID");
		setFrwVarDateColumn("CREATION_DATE,LAST_UPDATE_DATE,CLOSE_DATE,DUE_DATE");
		setFrwVarNumberColumn("OPPORTUNITY_ID,CREATED_BY,LAST_UPDATED_BY,PERSON_ID,ASSIGNED_PERSON_ID,CLOSE_BY,CUSTOMER_RELATIONSHIP_MGR_ID,CUSTOMER_SUPPORT_MGR_ID,ESTIMATED_REVENUE");
		setFrwVarClobColumn("");
		setFrwVarDefaultColumn("");
		setFrwVarDefaultValue("");
		setDefaultValue();
	}

	/**
	 * Accessors
	 */
	public double getOpportunityId() {
		return opportunityId;
	}

	public void setOpportunityId(double opportunityId) throws Exception {
		this.opportunityId = opportunityId;
		setValueFromAccessor("OPPORTUNITY_ID", CommonUtil.toString(opportunityId));
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

	public String getOpportunityType() {
		return opportunityType;
	}

	public void setOpportunityType(String opportunityType) throws Exception {
		this.opportunityType = opportunityType;
		setValueFromAccessor("OPPORTUNITY_TYPE", opportunityType);
	}

	public double getPersonId() {
		return personId;
	}

	public void setPersonId(double personId) throws Exception {
		this.personId = personId;
		setValueFromAccessor("PERSON_ID", CommonUtil.toString(personId));
	}

	public double getAssignedPersonId() {
		return assignedPersonId;
	}

	public void setAssignedPersonId(double assignedPersonId) throws Exception {
		this.assignedPersonId = assignedPersonId;
		setValueFromAccessor("ASSIGNED_PERSON_ID", CommonUtil.toString(assignedPersonId));
	}

	public String getCloseAs() {
		return closeAs;
	}

	public void setCloseAs(String closeAs) throws Exception {
		this.closeAs = closeAs;
		setValueFromAccessor("CLOSE_AS", closeAs);
	}

	public double getCloseBy() {
		return closeBy;
	}

	public void setCloseBy(double closeBy) throws Exception {
		this.closeBy = closeBy;
		setValueFromAccessor("CLOSE_BY", CommonUtil.toString(closeBy));
	}

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) throws Exception {
		this.closeDate = closeDate;
		setValueFromAccessor("CLOSE_DATE", CommonUtil.toString(closeDate));
	}

	public String getCloseNotes() {
		return closeNotes;
	}

	public void setCloseNotes(String closeNotes) throws Exception {
		this.closeNotes = closeNotes;
		setValueFromAccessor("CLOSE_NOTES", closeNotes);
	}

	public String getCloseReason() {
		return closeReason;
	}

	public void setCloseReason(String closeReason) throws Exception {
		this.closeReason = closeReason;
		setValueFromAccessor("CLOSE_REASON", closeReason);
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) throws Exception {
		this.comments = comments;
		setValueFromAccessor("COMMENTS", comments);
	}

	public String getCustomerReferenceDescription() {
		return customerReferenceDescription;
	}

	public void setCustomerReferenceDescription(String customerReferenceDescription) throws Exception {
		this.customerReferenceDescription = customerReferenceDescription;
		setValueFromAccessor("CUSTOMER_REFERENCE_DESCRIPTION", customerReferenceDescription);
	}

	public String getCustomerReferenceNumber() {
		return customerReferenceNumber;
	}

	public void setCustomerReferenceNumber(String customerReferenceNumber) throws Exception {
		this.customerReferenceNumber = customerReferenceNumber;
		setValueFromAccessor("CUSTOMER_REFERENCE_NUMBER", customerReferenceNumber);
	}

	public double getCustomerRelationshipMgrId() {
		return customerRelationshipMgrId;
	}

	public void setCustomerRelationshipMgrId(double customerRelationshipMgrId) throws Exception {
		this.customerRelationshipMgrId = customerRelationshipMgrId;
		setValueFromAccessor("CUSTOMER_RELATIONSHIP_MGR_ID", CommonUtil.toString(customerRelationshipMgrId));
	}

	public double getCustomerSupportMgrId() {
		return customerSupportMgrId;
	}

	public void setCustomerSupportMgrId(double customerSupportMgrId) throws Exception {
		this.customerSupportMgrId = customerSupportMgrId;
		setValueFromAccessor("CUSTOMER_SUPPORT_MGR_ID", CommonUtil.toString(customerSupportMgrId));
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) throws Exception {
		this.dueDate = dueDate;
		setValueFromAccessor("DUE_DATE", CommonUtil.toString(dueDate));
	}

	public double getEstimatedRevenue() {
		return estimatedRevenue;
	}

	public void setEstimatedRevenue(double estimatedRevenue) throws Exception {
		this.estimatedRevenue = estimatedRevenue;
		setValueFromAccessor("ESTIMATED_REVENUE", CommonUtil.toString(estimatedRevenue));
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) throws Exception {
		this.priority = priority;
		setValueFromAccessor("PRIORITY", priority);
	}

	public String getServiceStatus() {
		return serviceStatus;
	}

	public void setServiceStatus(String serviceStatus) throws Exception {
		this.serviceStatus = serviceStatus;
		setValueFromAccessor("SERVICE_STATUS", serviceStatus);
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) throws Exception {
		this.serviceType = serviceType;
		setValueFromAccessor("SERVICE_TYPE", serviceType);
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

		str += "opportunityId : "+opportunityId+"\n";
		str += "createdBy : "+createdBy+"\n";
		str += "creationDate : "+creationDate+"\n";
		str += "lastUpdatedBy : "+lastUpdatedBy+"\n";
		str += "lastUpdateDate : "+lastUpdateDate+"\n";
		str += "opportunityType : "+opportunityType+"\n";
		str += "personId : "+personId+"\n";
		str += "assignedPersonId : "+assignedPersonId+"\n";
		str += "closeAs : "+closeAs+"\n";
		str += "closeBy : "+closeBy+"\n";
		str += "closeDate : "+closeDate+"\n";
		str += "closeNotes : "+closeNotes+"\n";
		str += "closeReason : "+closeReason+"\n";
		str += "comments : "+comments+"\n";
		str += "customerReferenceDescription : "+customerReferenceDescription+"\n";
		str += "customerReferenceNumber : "+customerReferenceNumber+"\n";
		str += "customerRelationshipMgrId : "+customerRelationshipMgrId+"\n";
		str += "customerSupportMgrId : "+customerSupportMgrId+"\n";
		str += "dueDate : "+dueDate+"\n";
		str += "estimatedRevenue : "+estimatedRevenue+"\n";
		str += "priority : "+priority+"\n";
		str += "serviceStatus : "+serviceStatus+"\n";
		str += "serviceType : "+serviceType+"\n";
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

		str += "<column name=\"opportunityId\" value=\""+opportunityId+"\">";
		str += "<column name=\"createdBy\" value=\""+createdBy+"\">";
		str += "<column name=\"creationDate\" value=\""+creationDate+"\">";
		str += "<column name=\"lastUpdatedBy\" value=\""+lastUpdatedBy+"\">";
		str += "<column name=\"lastUpdateDate\" value=\""+lastUpdateDate+"\">";
		str += "<column name=\"opportunityType\" value=\""+opportunityType+"\">";
		str += "<column name=\"personId\" value=\""+personId+"\">";
		str += "<column name=\"assignedPersonId\" value=\""+assignedPersonId+"\">";
		str += "<column name=\"closeAs\" value=\""+closeAs+"\">";
		str += "<column name=\"closeBy\" value=\""+closeBy+"\">";
		str += "<column name=\"closeDate\" value=\""+closeDate+"\">";
		str += "<column name=\"closeNotes\" value=\""+closeNotes+"\">";
		str += "<column name=\"closeReason\" value=\""+closeReason+"\">";
		str += "<column name=\"comments\" value=\""+comments+"\">";
		str += "<column name=\"customerReferenceDescription\" value=\""+customerReferenceDescription+"\">";
		str += "<column name=\"customerReferenceNumber\" value=\""+customerReferenceNumber+"\">";
		str += "<column name=\"customerRelationshipMgrId\" value=\""+customerRelationshipMgrId+"\">";
		str += "<column name=\"customerSupportMgrId\" value=\""+customerSupportMgrId+"\">";
		str += "<column name=\"dueDate\" value=\""+dueDate+"\">";
		str += "<column name=\"estimatedRevenue\" value=\""+estimatedRevenue+"\">";
		str += "<column name=\"priority\" value=\""+priority+"\">";
		str += "<column name=\"serviceStatus\" value=\""+serviceStatus+"\">";
		str += "<column name=\"serviceType\" value=\""+serviceType+"\">";
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

		str += "\"opportunityId\":\""+opportunityId+"\", ";
		str += "\"createdBy\":\""+createdBy+"\", ";
		str += "\"creationDate\":\""+creationDate+"\", ";
		str += "\"lastUpdatedBy\":\""+lastUpdatedBy+"\", ";
		str += "\"lastUpdateDate\":\""+lastUpdateDate+"\", ";
		str += "\"opportunityType\":\""+opportunityType+"\", ";
		str += "\"personId\":\""+personId+"\", ";
		str += "\"assignedPersonId\":\""+assignedPersonId+"\", ";
		str += "\"closeAs\":\""+closeAs+"\", ";
		str += "\"closeBy\":\""+closeBy+"\", ";
		str += "\"closeDate\":\""+closeDate+"\", ";
		str += "\"closeNotes\":\""+closeNotes+"\", ";
		str += "\"closeReason\":\""+closeReason+"\", ";
		str += "\"comments\":\""+comments+"\", ";
		str += "\"customerReferenceDescription\":\""+customerReferenceDescription+"\", ";
		str += "\"customerReferenceNumber\":\""+customerReferenceNumber+"\", ";
		str += "\"customerRelationshipMgrId\":\""+customerRelationshipMgrId+"\", ";
		str += "\"customerSupportMgrId\":\""+customerSupportMgrId+"\", ";
		str += "\"dueDate\":\""+dueDate+"\", ";
		str += "\"estimatedRevenue\":\""+estimatedRevenue+"\", ";
		str += "\"priority\":\""+priority+"\", ";
		str += "\"serviceStatus\":\""+serviceStatus+"\", ";
		str += "\"serviceType\":\""+serviceType+"\", ";
		str += "\"status\":\""+status+"\", ";
		str += "\"insertUserName\":\""+insertUserName+"\", ";
		str += "\"updateUserName\":\""+updateUserName+"\"";

		return str;
	}
}