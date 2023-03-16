/**************************************************************************************************
 * Framework Generated DTO Source
 * - HP_ADDRESS_CONTACT_D - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dto.oracle;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;

import zebra.data.DataSet;
import zebra.util.CommonUtil;
import project.common.extend.BaseDto;

@SuppressWarnings("unused")
public class HpAddressContactD extends BaseDto implements Serializable {
	/**
	 * Columns
	 */
	private double addressId;
	private String ADDRESS_ID;
	private double personId;
	private String PERSON_ID;
	private double createdBy;
	private String CREATED_BY;
	private Date creationDate;
	private String CREATION_DATE;
	private Date fromDate;
	private String FROM_DATE;
	private double lastUpdatedBy;
	private String LAST_UPDATED_BY;
	private Date lastUpdateDate;
	private String LAST_UPDATE_DATE;
	private Date toDate;
	private String TO_DATE;
	private double businessGroupId;
	private String BUSINESS_GROUP_ID;
	private String emailHome;
	private String EMAIL_HOME;
	private String emailWork;
	private String EMAIL_WORK;
	private String emerContactAddressLine;
	private String EMER_CONTACT_ADDRESS_LINE;
	private String emerContactCountry;
	private String EMER_CONTACT_COUNTRY;
	private String emerContactEmail;
	private String EMER_CONTACT_EMAIL;
	private String emerContactName;
	private String EMER_CONTACT_NAME;
	private String emerContactPhone;
	private String EMER_CONTACT_PHONE;
	private String emerContactPostCode;
	private String EMER_CONTACT_POST_CODE;
	private String emerContactRelationship;
	private String EMER_CONTACT_RELATIONSHIP;
	private String emerContactState;
	private String EMER_CONTACT_STATE;
	private String emerContactSuburb;
	private String EMER_CONTACT_SUBURB;
	private String exclFrmBulkEmail;
	private String EXCL_FRM_BULK_EMAIL;
	private String executiveRelation;
	private String EXECUTIVE_RELATION;
	private String faxHome;
	private String FAX_HOME;
	private String faxWork;
	private String FAX_WORK;
	private String homeAddressLine;
	private String HOME_ADDRESS_LINE;
	private String homeCountry;
	private String HOME_COUNTRY;
	private String homePostCode;
	private String HOME_POST_CODE;
	private String homeState;
	private String HOME_STATE;
	private String homeSuburb;
	private String HOME_SUBURB;
	private String operationalRelation;
	private String OPERATIONAL_RELATION;
	private String otherAddressLine;
	private String OTHER_ADDRESS_LINE;
	private String otherCountry;
	private String OTHER_COUNTRY;
	private String otherPostCode;
	private String OTHER_POST_CODE;
	private String otherState;
	private String OTHER_STATE;
	private String otherSuburb;
	private String OTHER_SUBURB;
	private String preferred;
	private String PREFERRED;
	private String telephoneHome;
	private String TELEPHONE_HOME;
	private String telephoneMobile;
	private String TELEPHONE_MOBILE;
	private String telephoneWork;
	private String TELEPHONE_WORK;
	private String insertUserName;
	private String INSERT_USER_NAME;
	private String updateUserName;
	private String UPDATE_USER_NAME;

	/**
	 * Constructor
	 */
	@SuppressWarnings("rawtypes")
	public HpAddressContactD() throws Exception {
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
		setFrwVarPrimaryKey("ADDRESS_ID");
		setFrwVarDateColumn("CREATION_DATE,FROM_DATE,LAST_UPDATE_DATE,TO_DATE");
		setFrwVarNumberColumn("ADDRESS_ID,PERSON_ID,CREATED_BY,LAST_UPDATED_BY,BUSINESS_GROUP_ID");
		setFrwVarClobColumn("");
		setFrwVarDefaultColumn("");
		setFrwVarDefaultValue("");
		setDefaultValue();
	}

	/**
	 * Accessors
	 */
	public double getAddressId() {
		return addressId;
	}

	public void setAddressId(double addressId) throws Exception {
		this.addressId = addressId;
		setValueFromAccessor("ADDRESS_ID", CommonUtil.toString(addressId));
	}

	public double getPersonId() {
		return personId;
	}

	public void setPersonId(double personId) throws Exception {
		this.personId = personId;
		setValueFromAccessor("PERSON_ID", CommonUtil.toString(personId));
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

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) throws Exception {
		this.fromDate = fromDate;
		setValueFromAccessor("FROM_DATE", CommonUtil.toString(fromDate));
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

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) throws Exception {
		this.toDate = toDate;
		setValueFromAccessor("TO_DATE", CommonUtil.toString(toDate));
	}

	public double getBusinessGroupId() {
		return businessGroupId;
	}

	public void setBusinessGroupId(double businessGroupId) throws Exception {
		this.businessGroupId = businessGroupId;
		setValueFromAccessor("BUSINESS_GROUP_ID", CommonUtil.toString(businessGroupId));
	}

	public String getEmailHome() {
		return emailHome;
	}

	public void setEmailHome(String emailHome) throws Exception {
		this.emailHome = emailHome;
		setValueFromAccessor("EMAIL_HOME", emailHome);
	}

	public String getEmailWork() {
		return emailWork;
	}

	public void setEmailWork(String emailWork) throws Exception {
		this.emailWork = emailWork;
		setValueFromAccessor("EMAIL_WORK", emailWork);
	}

	public String getEmerContactAddressLine() {
		return emerContactAddressLine;
	}

	public void setEmerContactAddressLine(String emerContactAddressLine) throws Exception {
		this.emerContactAddressLine = emerContactAddressLine;
		setValueFromAccessor("EMER_CONTACT_ADDRESS_LINE", emerContactAddressLine);
	}

	public String getEmerContactCountry() {
		return emerContactCountry;
	}

	public void setEmerContactCountry(String emerContactCountry) throws Exception {
		this.emerContactCountry = emerContactCountry;
		setValueFromAccessor("EMER_CONTACT_COUNTRY", emerContactCountry);
	}

	public String getEmerContactEmail() {
		return emerContactEmail;
	}

	public void setEmerContactEmail(String emerContactEmail) throws Exception {
		this.emerContactEmail = emerContactEmail;
		setValueFromAccessor("EMER_CONTACT_EMAIL", emerContactEmail);
	}

	public String getEmerContactName() {
		return emerContactName;
	}

	public void setEmerContactName(String emerContactName) throws Exception {
		this.emerContactName = emerContactName;
		setValueFromAccessor("EMER_CONTACT_NAME", emerContactName);
	}

	public String getEmerContactPhone() {
		return emerContactPhone;
	}

	public void setEmerContactPhone(String emerContactPhone) throws Exception {
		this.emerContactPhone = emerContactPhone;
		setValueFromAccessor("EMER_CONTACT_PHONE", emerContactPhone);
	}

	public String getEmerContactPostCode() {
		return emerContactPostCode;
	}

	public void setEmerContactPostCode(String emerContactPostCode) throws Exception {
		this.emerContactPostCode = emerContactPostCode;
		setValueFromAccessor("EMER_CONTACT_POST_CODE", emerContactPostCode);
	}

	public String getEmerContactRelationship() {
		return emerContactRelationship;
	}

	public void setEmerContactRelationship(String emerContactRelationship) throws Exception {
		this.emerContactRelationship = emerContactRelationship;
		setValueFromAccessor("EMER_CONTACT_RELATIONSHIP", emerContactRelationship);
	}

	public String getEmerContactState() {
		return emerContactState;
	}

	public void setEmerContactState(String emerContactState) throws Exception {
		this.emerContactState = emerContactState;
		setValueFromAccessor("EMER_CONTACT_STATE", emerContactState);
	}

	public String getEmerContactSuburb() {
		return emerContactSuburb;
	}

	public void setEmerContactSuburb(String emerContactSuburb) throws Exception {
		this.emerContactSuburb = emerContactSuburb;
		setValueFromAccessor("EMER_CONTACT_SUBURB", emerContactSuburb);
	}

	public String getExclFrmBulkEmail() {
		return exclFrmBulkEmail;
	}

	public void setExclFrmBulkEmail(String exclFrmBulkEmail) throws Exception {
		this.exclFrmBulkEmail = exclFrmBulkEmail;
		setValueFromAccessor("EXCL_FRM_BULK_EMAIL", exclFrmBulkEmail);
	}

	public String getExecutiveRelation() {
		return executiveRelation;
	}

	public void setExecutiveRelation(String executiveRelation) throws Exception {
		this.executiveRelation = executiveRelation;
		setValueFromAccessor("EXECUTIVE_RELATION", executiveRelation);
	}

	public String getFaxHome() {
		return faxHome;
	}

	public void setFaxHome(String faxHome) throws Exception {
		this.faxHome = faxHome;
		setValueFromAccessor("FAX_HOME", faxHome);
	}

	public String getFaxWork() {
		return faxWork;
	}

	public void setFaxWork(String faxWork) throws Exception {
		this.faxWork = faxWork;
		setValueFromAccessor("FAX_WORK", faxWork);
	}

	public String getHomeAddressLine() {
		return homeAddressLine;
	}

	public void setHomeAddressLine(String homeAddressLine) throws Exception {
		this.homeAddressLine = homeAddressLine;
		setValueFromAccessor("HOME_ADDRESS_LINE", homeAddressLine);
	}

	public String getHomeCountry() {
		return homeCountry;
	}

	public void setHomeCountry(String homeCountry) throws Exception {
		this.homeCountry = homeCountry;
		setValueFromAccessor("HOME_COUNTRY", homeCountry);
	}

	public String getHomePostCode() {
		return homePostCode;
	}

	public void setHomePostCode(String homePostCode) throws Exception {
		this.homePostCode = homePostCode;
		setValueFromAccessor("HOME_POST_CODE", homePostCode);
	}

	public String getHomeState() {
		return homeState;
	}

	public void setHomeState(String homeState) throws Exception {
		this.homeState = homeState;
		setValueFromAccessor("HOME_STATE", homeState);
	}

	public String getHomeSuburb() {
		return homeSuburb;
	}

	public void setHomeSuburb(String homeSuburb) throws Exception {
		this.homeSuburb = homeSuburb;
		setValueFromAccessor("HOME_SUBURB", homeSuburb);
	}

	public String getOperationalRelation() {
		return operationalRelation;
	}

	public void setOperationalRelation(String operationalRelation) throws Exception {
		this.operationalRelation = operationalRelation;
		setValueFromAccessor("OPERATIONAL_RELATION", operationalRelation);
	}

	public String getOtherAddressLine() {
		return otherAddressLine;
	}

	public void setOtherAddressLine(String otherAddressLine) throws Exception {
		this.otherAddressLine = otherAddressLine;
		setValueFromAccessor("OTHER_ADDRESS_LINE", otherAddressLine);
	}

	public String getOtherCountry() {
		return otherCountry;
	}

	public void setOtherCountry(String otherCountry) throws Exception {
		this.otherCountry = otherCountry;
		setValueFromAccessor("OTHER_COUNTRY", otherCountry);
	}

	public String getOtherPostCode() {
		return otherPostCode;
	}

	public void setOtherPostCode(String otherPostCode) throws Exception {
		this.otherPostCode = otherPostCode;
		setValueFromAccessor("OTHER_POST_CODE", otherPostCode);
	}

	public String getOtherState() {
		return otherState;
	}

	public void setOtherState(String otherState) throws Exception {
		this.otherState = otherState;
		setValueFromAccessor("OTHER_STATE", otherState);
	}

	public String getOtherSuburb() {
		return otherSuburb;
	}

	public void setOtherSuburb(String otherSuburb) throws Exception {
		this.otherSuburb = otherSuburb;
		setValueFromAccessor("OTHER_SUBURB", otherSuburb);
	}

	public String getPreferred() {
		return preferred;
	}

	public void setPreferred(String preferred) throws Exception {
		this.preferred = preferred;
		setValueFromAccessor("PREFERRED", preferred);
	}

	public String getTelephoneHome() {
		return telephoneHome;
	}

	public void setTelephoneHome(String telephoneHome) throws Exception {
		this.telephoneHome = telephoneHome;
		setValueFromAccessor("TELEPHONE_HOME", telephoneHome);
	}

	public String getTelephoneMobile() {
		return telephoneMobile;
	}

	public void setTelephoneMobile(String telephoneMobile) throws Exception {
		this.telephoneMobile = telephoneMobile;
		setValueFromAccessor("TELEPHONE_MOBILE", telephoneMobile);
	}

	public String getTelephoneWork() {
		return telephoneWork;
	}

	public void setTelephoneWork(String telephoneWork) throws Exception {
		this.telephoneWork = telephoneWork;
		setValueFromAccessor("TELEPHONE_WORK", telephoneWork);
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

		str += "addressId : "+addressId+"\n";
		str += "personId : "+personId+"\n";
		str += "createdBy : "+createdBy+"\n";
		str += "creationDate : "+creationDate+"\n";
		str += "fromDate : "+fromDate+"\n";
		str += "lastUpdatedBy : "+lastUpdatedBy+"\n";
		str += "lastUpdateDate : "+lastUpdateDate+"\n";
		str += "toDate : "+toDate+"\n";
		str += "businessGroupId : "+businessGroupId+"\n";
		str += "emailHome : "+emailHome+"\n";
		str += "emailWork : "+emailWork+"\n";
		str += "emerContactAddressLine : "+emerContactAddressLine+"\n";
		str += "emerContactCountry : "+emerContactCountry+"\n";
		str += "emerContactEmail : "+emerContactEmail+"\n";
		str += "emerContactName : "+emerContactName+"\n";
		str += "emerContactPhone : "+emerContactPhone+"\n";
		str += "emerContactPostCode : "+emerContactPostCode+"\n";
		str += "emerContactRelationship : "+emerContactRelationship+"\n";
		str += "emerContactState : "+emerContactState+"\n";
		str += "emerContactSuburb : "+emerContactSuburb+"\n";
		str += "exclFrmBulkEmail : "+exclFrmBulkEmail+"\n";
		str += "executiveRelation : "+executiveRelation+"\n";
		str += "faxHome : "+faxHome+"\n";
		str += "faxWork : "+faxWork+"\n";
		str += "homeAddressLine : "+homeAddressLine+"\n";
		str += "homeCountry : "+homeCountry+"\n";
		str += "homePostCode : "+homePostCode+"\n";
		str += "homeState : "+homeState+"\n";
		str += "homeSuburb : "+homeSuburb+"\n";
		str += "operationalRelation : "+operationalRelation+"\n";
		str += "otherAddressLine : "+otherAddressLine+"\n";
		str += "otherCountry : "+otherCountry+"\n";
		str += "otherPostCode : "+otherPostCode+"\n";
		str += "otherState : "+otherState+"\n";
		str += "otherSuburb : "+otherSuburb+"\n";
		str += "preferred : "+preferred+"\n";
		str += "telephoneHome : "+telephoneHome+"\n";
		str += "telephoneMobile : "+telephoneMobile+"\n";
		str += "telephoneWork : "+telephoneWork+"\n";
		str += "insertUserName : "+insertUserName+"\n";
		str += "updateUserName : "+updateUserName+"\n";

		return str;
	}

	/**
	 * toXmlString
	 */
	public String toXmlString() {
		String str = "";

		str += "<column name=\"addressId\" value=\""+addressId+"\">";
		str += "<column name=\"personId\" value=\""+personId+"\">";
		str += "<column name=\"createdBy\" value=\""+createdBy+"\">";
		str += "<column name=\"creationDate\" value=\""+creationDate+"\">";
		str += "<column name=\"fromDate\" value=\""+fromDate+"\">";
		str += "<column name=\"lastUpdatedBy\" value=\""+lastUpdatedBy+"\">";
		str += "<column name=\"lastUpdateDate\" value=\""+lastUpdateDate+"\">";
		str += "<column name=\"toDate\" value=\""+toDate+"\">";
		str += "<column name=\"businessGroupId\" value=\""+businessGroupId+"\">";
		str += "<column name=\"emailHome\" value=\""+emailHome+"\">";
		str += "<column name=\"emailWork\" value=\""+emailWork+"\">";
		str += "<column name=\"emerContactAddressLine\" value=\""+emerContactAddressLine+"\">";
		str += "<column name=\"emerContactCountry\" value=\""+emerContactCountry+"\">";
		str += "<column name=\"emerContactEmail\" value=\""+emerContactEmail+"\">";
		str += "<column name=\"emerContactName\" value=\""+emerContactName+"\">";
		str += "<column name=\"emerContactPhone\" value=\""+emerContactPhone+"\">";
		str += "<column name=\"emerContactPostCode\" value=\""+emerContactPostCode+"\">";
		str += "<column name=\"emerContactRelationship\" value=\""+emerContactRelationship+"\">";
		str += "<column name=\"emerContactState\" value=\""+emerContactState+"\">";
		str += "<column name=\"emerContactSuburb\" value=\""+emerContactSuburb+"\">";
		str += "<column name=\"exclFrmBulkEmail\" value=\""+exclFrmBulkEmail+"\">";
		str += "<column name=\"executiveRelation\" value=\""+executiveRelation+"\">";
		str += "<column name=\"faxHome\" value=\""+faxHome+"\">";
		str += "<column name=\"faxWork\" value=\""+faxWork+"\">";
		str += "<column name=\"homeAddressLine\" value=\""+homeAddressLine+"\">";
		str += "<column name=\"homeCountry\" value=\""+homeCountry+"\">";
		str += "<column name=\"homePostCode\" value=\""+homePostCode+"\">";
		str += "<column name=\"homeState\" value=\""+homeState+"\">";
		str += "<column name=\"homeSuburb\" value=\""+homeSuburb+"\">";
		str += "<column name=\"operationalRelation\" value=\""+operationalRelation+"\">";
		str += "<column name=\"otherAddressLine\" value=\""+otherAddressLine+"\">";
		str += "<column name=\"otherCountry\" value=\""+otherCountry+"\">";
		str += "<column name=\"otherPostCode\" value=\""+otherPostCode+"\">";
		str += "<column name=\"otherState\" value=\""+otherState+"\">";
		str += "<column name=\"otherSuburb\" value=\""+otherSuburb+"\">";
		str += "<column name=\"preferred\" value=\""+preferred+"\">";
		str += "<column name=\"telephoneHome\" value=\""+telephoneHome+"\">";
		str += "<column name=\"telephoneMobile\" value=\""+telephoneMobile+"\">";
		str += "<column name=\"telephoneWork\" value=\""+telephoneWork+"\">";
		str += "<column name=\"insertUserName\" value=\""+insertUserName+"\">";
		str += "<column name=\"updateUserName\" value=\""+updateUserName+"\">";

		return str;
	}

	/**
	 * toJsonString
	 */
	public String toJsonString() {
		String str = "";

		str += "\"addressId\":\""+addressId+"\", ";
		str += "\"personId\":\""+personId+"\", ";
		str += "\"createdBy\":\""+createdBy+"\", ";
		str += "\"creationDate\":\""+creationDate+"\", ";
		str += "\"fromDate\":\""+fromDate+"\", ";
		str += "\"lastUpdatedBy\":\""+lastUpdatedBy+"\", ";
		str += "\"lastUpdateDate\":\""+lastUpdateDate+"\", ";
		str += "\"toDate\":\""+toDate+"\", ";
		str += "\"businessGroupId\":\""+businessGroupId+"\", ";
		str += "\"emailHome\":\""+emailHome+"\", ";
		str += "\"emailWork\":\""+emailWork+"\", ";
		str += "\"emerContactAddressLine\":\""+emerContactAddressLine+"\", ";
		str += "\"emerContactCountry\":\""+emerContactCountry+"\", ";
		str += "\"emerContactEmail\":\""+emerContactEmail+"\", ";
		str += "\"emerContactName\":\""+emerContactName+"\", ";
		str += "\"emerContactPhone\":\""+emerContactPhone+"\", ";
		str += "\"emerContactPostCode\":\""+emerContactPostCode+"\", ";
		str += "\"emerContactRelationship\":\""+emerContactRelationship+"\", ";
		str += "\"emerContactState\":\""+emerContactState+"\", ";
		str += "\"emerContactSuburb\":\""+emerContactSuburb+"\", ";
		str += "\"exclFrmBulkEmail\":\""+exclFrmBulkEmail+"\", ";
		str += "\"executiveRelation\":\""+executiveRelation+"\", ";
		str += "\"faxHome\":\""+faxHome+"\", ";
		str += "\"faxWork\":\""+faxWork+"\", ";
		str += "\"homeAddressLine\":\""+homeAddressLine+"\", ";
		str += "\"homeCountry\":\""+homeCountry+"\", ";
		str += "\"homePostCode\":\""+homePostCode+"\", ";
		str += "\"homeState\":\""+homeState+"\", ";
		str += "\"homeSuburb\":\""+homeSuburb+"\", ";
		str += "\"operationalRelation\":\""+operationalRelation+"\", ";
		str += "\"otherAddressLine\":\""+otherAddressLine+"\", ";
		str += "\"otherCountry\":\""+otherCountry+"\", ";
		str += "\"otherPostCode\":\""+otherPostCode+"\", ";
		str += "\"otherState\":\""+otherState+"\", ";
		str += "\"otherSuburb\":\""+otherSuburb+"\", ";
		str += "\"preferred\":\""+preferred+"\", ";
		str += "\"telephoneHome\":\""+telephoneHome+"\", ";
		str += "\"telephoneMobile\":\""+telephoneMobile+"\", ";
		str += "\"telephoneWork\":\""+telephoneWork+"\", ";
		str += "\"insertUserName\":\""+insertUserName+"\", ";
		str += "\"updateUserName\":\""+updateUserName+"\"";

		return str;
	}
}