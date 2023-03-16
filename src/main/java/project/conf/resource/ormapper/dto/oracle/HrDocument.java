/**************************************************************************************************
 * Framework Generated DTO Source
 * - HR_DOCUMENT - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dto.oracle;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;

import zebra.data.DataSet;
import zebra.util.CommonUtil;
import project.common.extend.BaseDto;

@SuppressWarnings("unused")
public class HrDocument extends BaseDto implements Serializable {
	/**
	 * Columns
	 */
	private double documentId;
	private String DOCUMENT_ID;
	private String approveRejectComments;
	private String APPROVE_REJECT_COMMENTS;
	private double assignedTo;
	private String ASSIGNED_TO;
	private double businessGroupId;
	private String BUSINESS_GROUP_ID;
	private double createdBy;
	private String CREATED_BY;
	private Date creationDate;
	private String CREATION_DATE;
	private String description;
	private String DESCRIPTION;
	private String documentFileName;
	private String DOCUMENT_FILE_NAME;
	private String documentName;
	private String DOCUMENT_NAME;
	private String documentSource;
	private String DOCUMENT_SOURCE;
	private String documentSubType;
	private String DOCUMENT_SUB_TYPE;
	private String documentType;
	private String DOCUMENT_TYPE;
	private Date dueDate;
	private String DUE_DATE;
	private Date expiryDate;
	private String EXPIRY_DATE;
	private String financialYear;
	private String FINANCIAL_YEAR;
	private Date followUpDate;
	private String FOLLOW_UP_DATE;
	private String isActive;
	private String IS_ACTIVE;
	private String isAvailableInPortal;
	private String IS_AVAILABLE_IN_PORTAL;
	private double lastUpdatedBy;
	private String LAST_UPDATED_BY;
	private Date lastUpdateDate;
	private String LAST_UPDATE_DATE;
	private double masterDocumentId;
	private String MASTER_DOCUMENT_ID;
	private double organisationId;
	private String ORGANISATION_ID;
	private double personId;
	private String PERSON_ID;
	private double profileDId;
	private String PROFILE_D_ID;
	private double receivedBy;
	private String RECEIVED_BY;
	private Date receivedDate;
	private String RECEIVED_DATE;
	private String receiveComments;
	private String RECEIVE_COMMENTS;
	private double sentBy;
	private String SENT_BY;
	private Date sentDate;
	private String SENT_DATE;
	private String status;
	private String STATUS;
	private String statusDetail;
	private String STATUS_DETAIL;
	private String insertUserName;
	private String INSERT_USER_NAME;
	private String updateUserName;
	private String UPDATE_USER_NAME;

	/**
	 * Constructor
	 */
	@SuppressWarnings("rawtypes")
	public HrDocument() throws Exception {
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
		setFrwVarPrimaryKey("DOCUMENT_ID");
		setFrwVarDateColumn("CREATION_DATE,DUE_DATE,EXPIRY_DATE,FOLLOW_UP_DATE,LAST_UPDATE_DATE,RECEIVED_DATE,SENT_DATE");
		setFrwVarNumberColumn("DOCUMENT_ID,ASSIGNED_TO,BUSINESS_GROUP_ID,CREATED_BY,LAST_UPDATED_BY,MASTER_DOCUMENT_ID,ORGANISATION_ID,PERSON_ID,PROFILE_D_ID,RECEIVED_BY,SENT_BY");
		setFrwVarClobColumn("");
		setFrwVarDefaultColumn("");
		setFrwVarDefaultValue("");
		setDefaultValue();
	}

	/**
	 * Accessors
	 */
	public double getDocumentId() {
		return documentId;
	}

	public void setDocumentId(double documentId) throws Exception {
		this.documentId = documentId;
		setValueFromAccessor("DOCUMENT_ID", CommonUtil.toString(documentId));
	}

	public String getApproveRejectComments() {
		return approveRejectComments;
	}

	public void setApproveRejectComments(String approveRejectComments) throws Exception {
		this.approveRejectComments = approveRejectComments;
		setValueFromAccessor("APPROVE_REJECT_COMMENTS", approveRejectComments);
	}

	public double getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(double assignedTo) throws Exception {
		this.assignedTo = assignedTo;
		setValueFromAccessor("ASSIGNED_TO", CommonUtil.toString(assignedTo));
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) throws Exception {
		this.description = description;
		setValueFromAccessor("DESCRIPTION", description);
	}

	public String getDocumentFileName() {
		return documentFileName;
	}

	public void setDocumentFileName(String documentFileName) throws Exception {
		this.documentFileName = documentFileName;
		setValueFromAccessor("DOCUMENT_FILE_NAME", documentFileName);
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) throws Exception {
		this.documentName = documentName;
		setValueFromAccessor("DOCUMENT_NAME", documentName);
	}

	public String getDocumentSource() {
		return documentSource;
	}

	public void setDocumentSource(String documentSource) throws Exception {
		this.documentSource = documentSource;
		setValueFromAccessor("DOCUMENT_SOURCE", documentSource);
	}

	public String getDocumentSubType() {
		return documentSubType;
	}

	public void setDocumentSubType(String documentSubType) throws Exception {
		this.documentSubType = documentSubType;
		setValueFromAccessor("DOCUMENT_SUB_TYPE", documentSubType);
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) throws Exception {
		this.documentType = documentType;
		setValueFromAccessor("DOCUMENT_TYPE", documentType);
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) throws Exception {
		this.dueDate = dueDate;
		setValueFromAccessor("DUE_DATE", CommonUtil.toString(dueDate));
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) throws Exception {
		this.expiryDate = expiryDate;
		setValueFromAccessor("EXPIRY_DATE", CommonUtil.toString(expiryDate));
	}

	public String getFinancialYear() {
		return financialYear;
	}

	public void setFinancialYear(String financialYear) throws Exception {
		this.financialYear = financialYear;
		setValueFromAccessor("FINANCIAL_YEAR", financialYear);
	}

	public Date getFollowUpDate() {
		return followUpDate;
	}

	public void setFollowUpDate(Date followUpDate) throws Exception {
		this.followUpDate = followUpDate;
		setValueFromAccessor("FOLLOW_UP_DATE", CommonUtil.toString(followUpDate));
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) throws Exception {
		this.isActive = isActive;
		setValueFromAccessor("IS_ACTIVE", isActive);
	}

	public String getIsAvailableInPortal() {
		return isAvailableInPortal;
	}

	public void setIsAvailableInPortal(String isAvailableInPortal) throws Exception {
		this.isAvailableInPortal = isAvailableInPortal;
		setValueFromAccessor("IS_AVAILABLE_IN_PORTAL", isAvailableInPortal);
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

	public double getMasterDocumentId() {
		return masterDocumentId;
	}

	public void setMasterDocumentId(double masterDocumentId) throws Exception {
		this.masterDocumentId = masterDocumentId;
		setValueFromAccessor("MASTER_DOCUMENT_ID", CommonUtil.toString(masterDocumentId));
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

	public double getProfileDId() {
		return profileDId;
	}

	public void setProfileDId(double profileDId) throws Exception {
		this.profileDId = profileDId;
		setValueFromAccessor("PROFILE_D_ID", CommonUtil.toString(profileDId));
	}

	public double getReceivedBy() {
		return receivedBy;
	}

	public void setReceivedBy(double receivedBy) throws Exception {
		this.receivedBy = receivedBy;
		setValueFromAccessor("RECEIVED_BY", CommonUtil.toString(receivedBy));
	}

	public Date getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(Date receivedDate) throws Exception {
		this.receivedDate = receivedDate;
		setValueFromAccessor("RECEIVED_DATE", CommonUtil.toString(receivedDate));
	}

	public String getReceiveComments() {
		return receiveComments;
	}

	public void setReceiveComments(String receiveComments) throws Exception {
		this.receiveComments = receiveComments;
		setValueFromAccessor("RECEIVE_COMMENTS", receiveComments);
	}

	public double getSentBy() {
		return sentBy;
	}

	public void setSentBy(double sentBy) throws Exception {
		this.sentBy = sentBy;
		setValueFromAccessor("SENT_BY", CommonUtil.toString(sentBy));
	}

	public Date getSentDate() {
		return sentDate;
	}

	public void setSentDate(Date sentDate) throws Exception {
		this.sentDate = sentDate;
		setValueFromAccessor("SENT_DATE", CommonUtil.toString(sentDate));
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) throws Exception {
		this.status = status;
		setValueFromAccessor("STATUS", status);
	}

	public String getStatusDetail() {
		return statusDetail;
	}

	public void setStatusDetail(String statusDetail) throws Exception {
		this.statusDetail = statusDetail;
		setValueFromAccessor("STATUS_DETAIL", statusDetail);
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

		str += "documentId : "+documentId+"\n";
		str += "approveRejectComments : "+approveRejectComments+"\n";
		str += "assignedTo : "+assignedTo+"\n";
		str += "businessGroupId : "+businessGroupId+"\n";
		str += "createdBy : "+createdBy+"\n";
		str += "creationDate : "+creationDate+"\n";
		str += "description : "+description+"\n";
		str += "documentFileName : "+documentFileName+"\n";
		str += "documentName : "+documentName+"\n";
		str += "documentSource : "+documentSource+"\n";
		str += "documentSubType : "+documentSubType+"\n";
		str += "documentType : "+documentType+"\n";
		str += "dueDate : "+dueDate+"\n";
		str += "expiryDate : "+expiryDate+"\n";
		str += "financialYear : "+financialYear+"\n";
		str += "followUpDate : "+followUpDate+"\n";
		str += "isActive : "+isActive+"\n";
		str += "isAvailableInPortal : "+isAvailableInPortal+"\n";
		str += "lastUpdatedBy : "+lastUpdatedBy+"\n";
		str += "lastUpdateDate : "+lastUpdateDate+"\n";
		str += "masterDocumentId : "+masterDocumentId+"\n";
		str += "organisationId : "+organisationId+"\n";
		str += "personId : "+personId+"\n";
		str += "profileDId : "+profileDId+"\n";
		str += "receivedBy : "+receivedBy+"\n";
		str += "receivedDate : "+receivedDate+"\n";
		str += "receiveComments : "+receiveComments+"\n";
		str += "sentBy : "+sentBy+"\n";
		str += "sentDate : "+sentDate+"\n";
		str += "status : "+status+"\n";
		str += "statusDetail : "+statusDetail+"\n";
		str += "insertUserName : "+insertUserName+"\n";
		str += "updateUserName : "+updateUserName+"\n";

		return str;
	}

	/**
	 * toXmlString
	 */
	public String toXmlString() {
		String str = "";

		str += "<column name=\"documentId\" value=\""+documentId+"\">";
		str += "<column name=\"approveRejectComments\" value=\""+approveRejectComments+"\">";
		str += "<column name=\"assignedTo\" value=\""+assignedTo+"\">";
		str += "<column name=\"businessGroupId\" value=\""+businessGroupId+"\">";
		str += "<column name=\"createdBy\" value=\""+createdBy+"\">";
		str += "<column name=\"creationDate\" value=\""+creationDate+"\">";
		str += "<column name=\"description\" value=\""+description+"\">";
		str += "<column name=\"documentFileName\" value=\""+documentFileName+"\">";
		str += "<column name=\"documentName\" value=\""+documentName+"\">";
		str += "<column name=\"documentSource\" value=\""+documentSource+"\">";
		str += "<column name=\"documentSubType\" value=\""+documentSubType+"\">";
		str += "<column name=\"documentType\" value=\""+documentType+"\">";
		str += "<column name=\"dueDate\" value=\""+dueDate+"\">";
		str += "<column name=\"expiryDate\" value=\""+expiryDate+"\">";
		str += "<column name=\"financialYear\" value=\""+financialYear+"\">";
		str += "<column name=\"followUpDate\" value=\""+followUpDate+"\">";
		str += "<column name=\"isActive\" value=\""+isActive+"\">";
		str += "<column name=\"isAvailableInPortal\" value=\""+isAvailableInPortal+"\">";
		str += "<column name=\"lastUpdatedBy\" value=\""+lastUpdatedBy+"\">";
		str += "<column name=\"lastUpdateDate\" value=\""+lastUpdateDate+"\">";
		str += "<column name=\"masterDocumentId\" value=\""+masterDocumentId+"\">";
		str += "<column name=\"organisationId\" value=\""+organisationId+"\">";
		str += "<column name=\"personId\" value=\""+personId+"\">";
		str += "<column name=\"profileDId\" value=\""+profileDId+"\">";
		str += "<column name=\"receivedBy\" value=\""+receivedBy+"\">";
		str += "<column name=\"receivedDate\" value=\""+receivedDate+"\">";
		str += "<column name=\"receiveComments\" value=\""+receiveComments+"\">";
		str += "<column name=\"sentBy\" value=\""+sentBy+"\">";
		str += "<column name=\"sentDate\" value=\""+sentDate+"\">";
		str += "<column name=\"status\" value=\""+status+"\">";
		str += "<column name=\"statusDetail\" value=\""+statusDetail+"\">";
		str += "<column name=\"insertUserName\" value=\""+insertUserName+"\">";
		str += "<column name=\"updateUserName\" value=\""+updateUserName+"\">";

		return str;
	}

	/**
	 * toJsonString
	 */
	public String toJsonString() {
		String str = "";

		str += "\"documentId\":\""+documentId+"\", ";
		str += "\"approveRejectComments\":\""+approveRejectComments+"\", ";
		str += "\"assignedTo\":\""+assignedTo+"\", ";
		str += "\"businessGroupId\":\""+businessGroupId+"\", ";
		str += "\"createdBy\":\""+createdBy+"\", ";
		str += "\"creationDate\":\""+creationDate+"\", ";
		str += "\"description\":\""+description+"\", ";
		str += "\"documentFileName\":\""+documentFileName+"\", ";
		str += "\"documentName\":\""+documentName+"\", ";
		str += "\"documentSource\":\""+documentSource+"\", ";
		str += "\"documentSubType\":\""+documentSubType+"\", ";
		str += "\"documentType\":\""+documentType+"\", ";
		str += "\"dueDate\":\""+dueDate+"\", ";
		str += "\"expiryDate\":\""+expiryDate+"\", ";
		str += "\"financialYear\":\""+financialYear+"\", ";
		str += "\"followUpDate\":\""+followUpDate+"\", ";
		str += "\"isActive\":\""+isActive+"\", ";
		str += "\"isAvailableInPortal\":\""+isAvailableInPortal+"\", ";
		str += "\"lastUpdatedBy\":\""+lastUpdatedBy+"\", ";
		str += "\"lastUpdateDate\":\""+lastUpdateDate+"\", ";
		str += "\"masterDocumentId\":\""+masterDocumentId+"\", ";
		str += "\"organisationId\":\""+organisationId+"\", ";
		str += "\"personId\":\""+personId+"\", ";
		str += "\"profileDId\":\""+profileDId+"\", ";
		str += "\"receivedBy\":\""+receivedBy+"\", ";
		str += "\"receivedDate\":\""+receivedDate+"\", ";
		str += "\"receiveComments\":\""+receiveComments+"\", ";
		str += "\"sentBy\":\""+sentBy+"\", ";
		str += "\"sentDate\":\""+sentDate+"\", ";
		str += "\"status\":\""+status+"\", ";
		str += "\"statusDetail\":\""+statusDetail+"\", ";
		str += "\"insertUserName\":\""+insertUserName+"\", ";
		str += "\"updateUserName\":\""+updateUserName+"\"";

		return str;
	}
}