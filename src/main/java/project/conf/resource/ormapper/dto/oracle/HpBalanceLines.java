/**************************************************************************************************
 * Framework Generated DTO Source
 * - HP_BALANCE_LINES - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dto.oracle;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;

import zebra.data.DataSet;
import zebra.util.CommonUtil;
import project.common.extend.BaseDto;

@SuppressWarnings("unused")
public class HpBalanceLines extends BaseDto implements Serializable {
	/**
	 * Columns
	 */
	private double assignmentActionId;
	private String ASSIGNMENT_ACTION_ID;
	private double balanceLineId;
	private String BALANCE_LINE_ID;
	private double balanceTypeId;
	private String BALANCE_TYPE_ID;
	private Date creationDate;
	private String CREATION_DATE;
	private String dbItemSuffix;
	private String DB_ITEM_SUFFIX;
	private double elementId;
	private String ELEMENT_ID;
	private String jurisdictionCode;
	private String JURISDICTION_CODE;
	private double mtd;
	private String MTD;
	private double paymentId;
	private String PAYMENT_ID;
	private double ptd;
	private String PTD;
	private double qtd;
	private String QTD;
	private String status;
	private String STATUS;
	private double taxBalanceId;
	private String TAX_BALANCE_ID;
	private double value;
	private String VALUE;
	private double ytd;
	private String YTD;
	private String insertUserName;
	private String INSERT_USER_NAME;
	private String updateUserName;
	private String UPDATE_USER_NAME;

	/**
	 * Constructor
	 */
	@SuppressWarnings("rawtypes")
	public HpBalanceLines() throws Exception {
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
		setFrwVarPrimaryKey("");
		setFrwVarDateColumn("CREATION_DATE");
		setFrwVarNumberColumn("ASSIGNMENT_ACTION_ID,BALANCE_LINE_ID,BALANCE_TYPE_ID,ELEMENT_ID,MTD,PAYMENT_ID,PTD,QTD,TAX_BALANCE_ID,VALUE,YTD");
		setFrwVarClobColumn("");
		setFrwVarDefaultColumn("");
		setFrwVarDefaultValue("");
		setDefaultValue();
	}

	/**
	 * Accessors
	 */
	public double getAssignmentActionId() {
		return assignmentActionId;
	}

	public void setAssignmentActionId(double assignmentActionId) throws Exception {
		this.assignmentActionId = assignmentActionId;
		setValueFromAccessor("ASSIGNMENT_ACTION_ID", CommonUtil.toString(assignmentActionId));
	}

	public double getBalanceLineId() {
		return balanceLineId;
	}

	public void setBalanceLineId(double balanceLineId) throws Exception {
		this.balanceLineId = balanceLineId;
		setValueFromAccessor("BALANCE_LINE_ID", CommonUtil.toString(balanceLineId));
	}

	public double getBalanceTypeId() {
		return balanceTypeId;
	}

	public void setBalanceTypeId(double balanceTypeId) throws Exception {
		this.balanceTypeId = balanceTypeId;
		setValueFromAccessor("BALANCE_TYPE_ID", CommonUtil.toString(balanceTypeId));
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) throws Exception {
		this.creationDate = creationDate;
		setValueFromAccessor("CREATION_DATE", CommonUtil.toString(creationDate));
	}

	public String getDbItemSuffix() {
		return dbItemSuffix;
	}

	public void setDbItemSuffix(String dbItemSuffix) throws Exception {
		this.dbItemSuffix = dbItemSuffix;
		setValueFromAccessor("DB_ITEM_SUFFIX", dbItemSuffix);
	}

	public double getElementId() {
		return elementId;
	}

	public void setElementId(double elementId) throws Exception {
		this.elementId = elementId;
		setValueFromAccessor("ELEMENT_ID", CommonUtil.toString(elementId));
	}

	public String getJurisdictionCode() {
		return jurisdictionCode;
	}

	public void setJurisdictionCode(String jurisdictionCode) throws Exception {
		this.jurisdictionCode = jurisdictionCode;
		setValueFromAccessor("JURISDICTION_CODE", jurisdictionCode);
	}

	public double getMtd() {
		return mtd;
	}

	public void setMtd(double mtd) throws Exception {
		this.mtd = mtd;
		setValueFromAccessor("MTD", CommonUtil.toString(mtd));
	}

	public double getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(double paymentId) throws Exception {
		this.paymentId = paymentId;
		setValueFromAccessor("PAYMENT_ID", CommonUtil.toString(paymentId));
	}

	public double getPtd() {
		return ptd;
	}

	public void setPtd(double ptd) throws Exception {
		this.ptd = ptd;
		setValueFromAccessor("PTD", CommonUtil.toString(ptd));
	}

	public double getQtd() {
		return qtd;
	}

	public void setQtd(double qtd) throws Exception {
		this.qtd = qtd;
		setValueFromAccessor("QTD", CommonUtil.toString(qtd));
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) throws Exception {
		this.status = status;
		setValueFromAccessor("STATUS", status);
	}

	public double getTaxBalanceId() {
		return taxBalanceId;
	}

	public void setTaxBalanceId(double taxBalanceId) throws Exception {
		this.taxBalanceId = taxBalanceId;
		setValueFromAccessor("TAX_BALANCE_ID", CommonUtil.toString(taxBalanceId));
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) throws Exception {
		this.value = value;
		setValueFromAccessor("VALUE", CommonUtil.toString(value));
	}

	public double getYtd() {
		return ytd;
	}

	public void setYtd(double ytd) throws Exception {
		this.ytd = ytd;
		setValueFromAccessor("YTD", CommonUtil.toString(ytd));
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

		str += "assignmentActionId : "+assignmentActionId+"\n";
		str += "balanceLineId : "+balanceLineId+"\n";
		str += "balanceTypeId : "+balanceTypeId+"\n";
		str += "creationDate : "+creationDate+"\n";
		str += "dbItemSuffix : "+dbItemSuffix+"\n";
		str += "elementId : "+elementId+"\n";
		str += "jurisdictionCode : "+jurisdictionCode+"\n";
		str += "mtd : "+mtd+"\n";
		str += "paymentId : "+paymentId+"\n";
		str += "ptd : "+ptd+"\n";
		str += "qtd : "+qtd+"\n";
		str += "status : "+status+"\n";
		str += "taxBalanceId : "+taxBalanceId+"\n";
		str += "value : "+value+"\n";
		str += "ytd : "+ytd+"\n";
		str += "insertUserName : "+insertUserName+"\n";
		str += "updateUserName : "+updateUserName+"\n";

		return str;
	}

	/**
	 * toXmlString
	 */
	public String toXmlString() {
		String str = "";

		str += "<column name=\"assignmentActionId\" value=\""+assignmentActionId+"\">";
		str += "<column name=\"balanceLineId\" value=\""+balanceLineId+"\">";
		str += "<column name=\"balanceTypeId\" value=\""+balanceTypeId+"\">";
		str += "<column name=\"creationDate\" value=\""+creationDate+"\">";
		str += "<column name=\"dbItemSuffix\" value=\""+dbItemSuffix+"\">";
		str += "<column name=\"elementId\" value=\""+elementId+"\">";
		str += "<column name=\"jurisdictionCode\" value=\""+jurisdictionCode+"\">";
		str += "<column name=\"mtd\" value=\""+mtd+"\">";
		str += "<column name=\"paymentId\" value=\""+paymentId+"\">";
		str += "<column name=\"ptd\" value=\""+ptd+"\">";
		str += "<column name=\"qtd\" value=\""+qtd+"\">";
		str += "<column name=\"status\" value=\""+status+"\">";
		str += "<column name=\"taxBalanceId\" value=\""+taxBalanceId+"\">";
		str += "<column name=\"value\" value=\""+value+"\">";
		str += "<column name=\"ytd\" value=\""+ytd+"\">";
		str += "<column name=\"insertUserName\" value=\""+insertUserName+"\">";
		str += "<column name=\"updateUserName\" value=\""+updateUserName+"\">";

		return str;
	}

	/**
	 * toJsonString
	 */
	public String toJsonString() {
		String str = "";

		str += "\"assignmentActionId\":\""+assignmentActionId+"\", ";
		str += "\"balanceLineId\":\""+balanceLineId+"\", ";
		str += "\"balanceTypeId\":\""+balanceTypeId+"\", ";
		str += "\"creationDate\":\""+creationDate+"\", ";
		str += "\"dbItemSuffix\":\""+dbItemSuffix+"\", ";
		str += "\"elementId\":\""+elementId+"\", ";
		str += "\"jurisdictionCode\":\""+jurisdictionCode+"\", ";
		str += "\"mtd\":\""+mtd+"\", ";
		str += "\"paymentId\":\""+paymentId+"\", ";
		str += "\"ptd\":\""+ptd+"\", ";
		str += "\"qtd\":\""+qtd+"\", ";
		str += "\"status\":\""+status+"\", ";
		str += "\"taxBalanceId\":\""+taxBalanceId+"\", ";
		str += "\"value\":\""+value+"\", ";
		str += "\"ytd\":\""+ytd+"\", ";
		str += "\"insertUserName\":\""+insertUserName+"\", ";
		str += "\"updateUserName\":\""+updateUserName+"\"";

		return str;
	}
}