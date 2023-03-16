/**************************************************************************************************
 * Framework Generated DTO Source
 * - HP_PAYMENT_METHODS - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dto.oracle;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;

import zebra.data.DataSet;
import zebra.util.CommonUtil;
import project.common.extend.BaseDto;

@SuppressWarnings("unused")
public class HpPaymentMethods extends BaseDto implements Serializable {
	/**
	 * Columns
	 */
	private double payMethodId;
	private String PAY_METHOD_ID;
	private double createdBy;
	private String CREATED_BY;
	private Date creationDate;
	private String CREATION_DATE;
	private double lastUpdatedBy;
	private String LAST_UPDATED_BY;
	private Date lastUpdateDate;
	private String LAST_UPDATE_DATE;
	private String accountName;
	private String ACCOUNT_NAME;
	private String accountNumber;
	private String ACCOUNT_NUMBER;
	private String accountType;
	private String ACCOUNT_TYPE;
	private String apcaIdentificationNo;
	private String APCA_IDENTIFICATION_NO;
	private String bankBranch;
	private String BANK_BRANCH;
	private String bankName;
	private String BANK_NAME;
	private String bsbNumber;
	private String BSB_NUMBER;
	private double businessGroupId;
	private String BUSINESS_GROUP_ID;
	private Date fromDate;
	private String FROM_DATE;
	private String name;
	private String NAME;
	private String nameOfUser;
	private String NAME_OF_USER;
	private String paymentType;
	private String PAYMENT_TYPE;
	private double selfDebit;
	private String SELF_DEBIT;
	private Date toDate;
	private String TO_DATE;
	private String userFinancialInst;
	private String USER_FINANCIAL_INST;
	private String insertUserName;
	private String INSERT_USER_NAME;
	private String updateUserName;
	private String UPDATE_USER_NAME;

	/**
	 * Constructor
	 */
	@SuppressWarnings("rawtypes")
	public HpPaymentMethods() throws Exception {
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
		setFrwVarPrimaryKey("PAY_METHOD_ID");
		setFrwVarDateColumn("CREATION_DATE,LAST_UPDATE_DATE,FROM_DATE,TO_DATE");
		setFrwVarNumberColumn("PAY_METHOD_ID,CREATED_BY,LAST_UPDATED_BY,BUSINESS_GROUP_ID,SELF_DEBIT");
		setFrwVarClobColumn("");
		setFrwVarDefaultColumn("SELF_DEBIT");
		setFrwVarDefaultValue("0");
		setDefaultValue();
	}

	/**
	 * Accessors
	 */
	public double getPayMethodId() {
		return payMethodId;
	}

	public void setPayMethodId(double payMethodId) throws Exception {
		this.payMethodId = payMethodId;
		setValueFromAccessor("PAY_METHOD_ID", CommonUtil.toString(payMethodId));
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

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) throws Exception {
		this.accountName = accountName;
		setValueFromAccessor("ACCOUNT_NAME", accountName);
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) throws Exception {
		this.accountNumber = accountNumber;
		setValueFromAccessor("ACCOUNT_NUMBER", accountNumber);
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) throws Exception {
		this.accountType = accountType;
		setValueFromAccessor("ACCOUNT_TYPE", accountType);
	}

	public String getApcaIdentificationNo() {
		return apcaIdentificationNo;
	}

	public void setApcaIdentificationNo(String apcaIdentificationNo) throws Exception {
		this.apcaIdentificationNo = apcaIdentificationNo;
		setValueFromAccessor("APCA_IDENTIFICATION_NO", apcaIdentificationNo);
	}

	public String getBankBranch() {
		return bankBranch;
	}

	public void setBankBranch(String bankBranch) throws Exception {
		this.bankBranch = bankBranch;
		setValueFromAccessor("BANK_BRANCH", bankBranch);
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) throws Exception {
		this.bankName = bankName;
		setValueFromAccessor("BANK_NAME", bankName);
	}

	public String getBsbNumber() {
		return bsbNumber;
	}

	public void setBsbNumber(String bsbNumber) throws Exception {
		this.bsbNumber = bsbNumber;
		setValueFromAccessor("BSB_NUMBER", bsbNumber);
	}

	public double getBusinessGroupId() {
		return businessGroupId;
	}

	public void setBusinessGroupId(double businessGroupId) throws Exception {
		this.businessGroupId = businessGroupId;
		setValueFromAccessor("BUSINESS_GROUP_ID", CommonUtil.toString(businessGroupId));
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) throws Exception {
		this.fromDate = fromDate;
		setValueFromAccessor("FROM_DATE", CommonUtil.toString(fromDate));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws Exception {
		this.name = name;
		setValueFromAccessor("NAME", name);
	}

	public String getNameOfUser() {
		return nameOfUser;
	}

	public void setNameOfUser(String nameOfUser) throws Exception {
		this.nameOfUser = nameOfUser;
		setValueFromAccessor("NAME_OF_USER", nameOfUser);
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) throws Exception {
		this.paymentType = paymentType;
		setValueFromAccessor("PAYMENT_TYPE", paymentType);
	}

	public double getSelfDebit() {
		return selfDebit;
	}

	public void setSelfDebit(double selfDebit) throws Exception {
		this.selfDebit = selfDebit;
		setValueFromAccessor("SELF_DEBIT", CommonUtil.toString(selfDebit));
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) throws Exception {
		this.toDate = toDate;
		setValueFromAccessor("TO_DATE", CommonUtil.toString(toDate));
	}

	public String getUserFinancialInst() {
		return userFinancialInst;
	}

	public void setUserFinancialInst(String userFinancialInst) throws Exception {
		this.userFinancialInst = userFinancialInst;
		setValueFromAccessor("USER_FINANCIAL_INST", userFinancialInst);
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

		str += "payMethodId : "+payMethodId+"\n";
		str += "createdBy : "+createdBy+"\n";
		str += "creationDate : "+creationDate+"\n";
		str += "lastUpdatedBy : "+lastUpdatedBy+"\n";
		str += "lastUpdateDate : "+lastUpdateDate+"\n";
		str += "accountName : "+accountName+"\n";
		str += "accountNumber : "+accountNumber+"\n";
		str += "accountType : "+accountType+"\n";
		str += "apcaIdentificationNo : "+apcaIdentificationNo+"\n";
		str += "bankBranch : "+bankBranch+"\n";
		str += "bankName : "+bankName+"\n";
		str += "bsbNumber : "+bsbNumber+"\n";
		str += "businessGroupId : "+businessGroupId+"\n";
		str += "fromDate : "+fromDate+"\n";
		str += "name : "+name+"\n";
		str += "nameOfUser : "+nameOfUser+"\n";
		str += "paymentType : "+paymentType+"\n";
		str += "selfDebit : "+selfDebit+"\n";
		str += "toDate : "+toDate+"\n";
		str += "userFinancialInst : "+userFinancialInst+"\n";
		str += "insertUserName : "+insertUserName+"\n";
		str += "updateUserName : "+updateUserName+"\n";

		return str;
	}

	/**
	 * toXmlString
	 */
	public String toXmlString() {
		String str = "";

		str += "<column name=\"payMethodId\" value=\""+payMethodId+"\">";
		str += "<column name=\"createdBy\" value=\""+createdBy+"\">";
		str += "<column name=\"creationDate\" value=\""+creationDate+"\">";
		str += "<column name=\"lastUpdatedBy\" value=\""+lastUpdatedBy+"\">";
		str += "<column name=\"lastUpdateDate\" value=\""+lastUpdateDate+"\">";
		str += "<column name=\"accountName\" value=\""+accountName+"\">";
		str += "<column name=\"accountNumber\" value=\""+accountNumber+"\">";
		str += "<column name=\"accountType\" value=\""+accountType+"\">";
		str += "<column name=\"apcaIdentificationNo\" value=\""+apcaIdentificationNo+"\">";
		str += "<column name=\"bankBranch\" value=\""+bankBranch+"\">";
		str += "<column name=\"bankName\" value=\""+bankName+"\">";
		str += "<column name=\"bsbNumber\" value=\""+bsbNumber+"\">";
		str += "<column name=\"businessGroupId\" value=\""+businessGroupId+"\">";
		str += "<column name=\"fromDate\" value=\""+fromDate+"\">";
		str += "<column name=\"name\" value=\""+name+"\">";
		str += "<column name=\"nameOfUser\" value=\""+nameOfUser+"\">";
		str += "<column name=\"paymentType\" value=\""+paymentType+"\">";
		str += "<column name=\"selfDebit\" value=\""+selfDebit+"\">";
		str += "<column name=\"toDate\" value=\""+toDate+"\">";
		str += "<column name=\"userFinancialInst\" value=\""+userFinancialInst+"\">";
		str += "<column name=\"insertUserName\" value=\""+insertUserName+"\">";
		str += "<column name=\"updateUserName\" value=\""+updateUserName+"\">";

		return str;
	}

	/**
	 * toJsonString
	 */
	public String toJsonString() {
		String str = "";

		str += "\"payMethodId\":\""+payMethodId+"\", ";
		str += "\"createdBy\":\""+createdBy+"\", ";
		str += "\"creationDate\":\""+creationDate+"\", ";
		str += "\"lastUpdatedBy\":\""+lastUpdatedBy+"\", ";
		str += "\"lastUpdateDate\":\""+lastUpdateDate+"\", ";
		str += "\"accountName\":\""+accountName+"\", ";
		str += "\"accountNumber\":\""+accountNumber+"\", ";
		str += "\"accountType\":\""+accountType+"\", ";
		str += "\"apcaIdentificationNo\":\""+apcaIdentificationNo+"\", ";
		str += "\"bankBranch\":\""+bankBranch+"\", ";
		str += "\"bankName\":\""+bankName+"\", ";
		str += "\"bsbNumber\":\""+bsbNumber+"\", ";
		str += "\"businessGroupId\":\""+businessGroupId+"\", ";
		str += "\"fromDate\":\""+fromDate+"\", ";
		str += "\"name\":\""+name+"\", ";
		str += "\"nameOfUser\":\""+nameOfUser+"\", ";
		str += "\"paymentType\":\""+paymentType+"\", ";
		str += "\"selfDebit\":\""+selfDebit+"\", ";
		str += "\"toDate\":\""+toDate+"\", ";
		str += "\"userFinancialInst\":\""+userFinancialInst+"\", ";
		str += "\"insertUserName\":\""+insertUserName+"\", ";
		str += "\"updateUserName\":\""+updateUserName+"\"";

		return str;
	}
}