/**************************************************************************************************
 * Framework Generated DTO Source
 * - HP_ASSIGNMENT_RATES - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dto.oracle;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;

import zebra.data.DataSet;
import zebra.util.CommonUtil;
import project.common.extend.BaseDto;

@SuppressWarnings("unused")
public class HpAssignmentRates extends BaseDto implements Serializable {
	/**
	 * Columns
	 */
	private double assignmentRateId;
	private String ASSIGNMENT_RATE_ID;
	private double amount;
	private String AMOUNT;
	private double units;
	private String UNITS;
	private String alternateName;
	private String ALTERNATE_NAME;
	private double assigmentId;
	private String ASSIGMENT_ID;
	private String chargePeriod;
	private String CHARGE_PERIOD;
	private double chargeRate;
	private String CHARGE_RATE;
	private String dayType;
	private String DAY_TYPE;
	private String displayOnExpense;
	private String DISPLAY_ON_EXPENSE;
	private String displayOnTimesheet;
	private String DISPLAY_ON_TIMESHEET;
	private double elementId;
	private String ELEMENT_ID;
	private String enableFlag;
	private String ENABLE_FLAG;
	private String endTime;
	private String END_TIME;
	private String gstExempt;
	private String GST_EXEMPT;
	private String overTimeEnd;
	private String OVER_TIME_END;
	private String overTimeStart;
	private String OVER_TIME_START;
	private String period;
	private String PERIOD;
	private String preferred;
	private String PREFERRED;
	private String rateName;
	private String RATE_NAME;
	private String recurringRate;
	private String RECURRING_RATE;
	private String startTime;
	private String START_TIME;
	private double taxablePercentage;
	private String TAXABLE_PERCENTAGE;
	private String useAward;
	private String USE_AWARD;
	private String insertUserName;
	private String INSERT_USER_NAME;
	private String updateUserName;
	private String UPDATE_USER_NAME;

	/**
	 * Constructor
	 */
	@SuppressWarnings("rawtypes")
	public HpAssignmentRates() throws Exception {
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
		setFrwVarPrimaryKey("ASSIGNMENT_RATE_ID");
		setFrwVarDateColumn("");
		setFrwVarNumberColumn("ASSIGNMENT_RATE_ID,AMOUNT,UNITS,ASSIGMENT_ID,CHARGE_RATE,ELEMENT_ID,TAXABLE_PERCENTAGE");
		setFrwVarClobColumn("");
		setFrwVarDefaultColumn("AMOUNT,UNITS");
		setFrwVarDefaultValue("0,0");
		setDefaultValue();
	}

	/**
	 * Accessors
	 */
	public double getAssignmentRateId() {
		return assignmentRateId;
	}

	public void setAssignmentRateId(double assignmentRateId) throws Exception {
		this.assignmentRateId = assignmentRateId;
		setValueFromAccessor("ASSIGNMENT_RATE_ID", CommonUtil.toString(assignmentRateId));
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) throws Exception {
		this.amount = amount;
		setValueFromAccessor("AMOUNT", CommonUtil.toString(amount));
	}

	public double getUnits() {
		return units;
	}

	public void setUnits(double units) throws Exception {
		this.units = units;
		setValueFromAccessor("UNITS", CommonUtil.toString(units));
	}

	public String getAlternateName() {
		return alternateName;
	}

	public void setAlternateName(String alternateName) throws Exception {
		this.alternateName = alternateName;
		setValueFromAccessor("ALTERNATE_NAME", alternateName);
	}

	public double getAssigmentId() {
		return assigmentId;
	}

	public void setAssigmentId(double assigmentId) throws Exception {
		this.assigmentId = assigmentId;
		setValueFromAccessor("ASSIGMENT_ID", CommonUtil.toString(assigmentId));
	}

	public String getChargePeriod() {
		return chargePeriod;
	}

	public void setChargePeriod(String chargePeriod) throws Exception {
		this.chargePeriod = chargePeriod;
		setValueFromAccessor("CHARGE_PERIOD", chargePeriod);
	}

	public double getChargeRate() {
		return chargeRate;
	}

	public void setChargeRate(double chargeRate) throws Exception {
		this.chargeRate = chargeRate;
		setValueFromAccessor("CHARGE_RATE", CommonUtil.toString(chargeRate));
	}

	public String getDayType() {
		return dayType;
	}

	public void setDayType(String dayType) throws Exception {
		this.dayType = dayType;
		setValueFromAccessor("DAY_TYPE", dayType);
	}

	public String getDisplayOnExpense() {
		return displayOnExpense;
	}

	public void setDisplayOnExpense(String displayOnExpense) throws Exception {
		this.displayOnExpense = displayOnExpense;
		setValueFromAccessor("DISPLAY_ON_EXPENSE", displayOnExpense);
	}

	public String getDisplayOnTimesheet() {
		return displayOnTimesheet;
	}

	public void setDisplayOnTimesheet(String displayOnTimesheet) throws Exception {
		this.displayOnTimesheet = displayOnTimesheet;
		setValueFromAccessor("DISPLAY_ON_TIMESHEET", displayOnTimesheet);
	}

	public double getElementId() {
		return elementId;
	}

	public void setElementId(double elementId) throws Exception {
		this.elementId = elementId;
		setValueFromAccessor("ELEMENT_ID", CommonUtil.toString(elementId));
	}

	public String getEnableFlag() {
		return enableFlag;
	}

	public void setEnableFlag(String enableFlag) throws Exception {
		this.enableFlag = enableFlag;
		setValueFromAccessor("ENABLE_FLAG", enableFlag);
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) throws Exception {
		this.endTime = endTime;
		setValueFromAccessor("END_TIME", endTime);
	}

	public String getGstExempt() {
		return gstExempt;
	}

	public void setGstExempt(String gstExempt) throws Exception {
		this.gstExempt = gstExempt;
		setValueFromAccessor("GST_EXEMPT", gstExempt);
	}

	public String getOverTimeEnd() {
		return overTimeEnd;
	}

	public void setOverTimeEnd(String overTimeEnd) throws Exception {
		this.overTimeEnd = overTimeEnd;
		setValueFromAccessor("OVER_TIME_END", overTimeEnd);
	}

	public String getOverTimeStart() {
		return overTimeStart;
	}

	public void setOverTimeStart(String overTimeStart) throws Exception {
		this.overTimeStart = overTimeStart;
		setValueFromAccessor("OVER_TIME_START", overTimeStart);
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) throws Exception {
		this.period = period;
		setValueFromAccessor("PERIOD", period);
	}

	public String getPreferred() {
		return preferred;
	}

	public void setPreferred(String preferred) throws Exception {
		this.preferred = preferred;
		setValueFromAccessor("PREFERRED", preferred);
	}

	public String getRateName() {
		return rateName;
	}

	public void setRateName(String rateName) throws Exception {
		this.rateName = rateName;
		setValueFromAccessor("RATE_NAME", rateName);
	}

	public String getRecurringRate() {
		return recurringRate;
	}

	public void setRecurringRate(String recurringRate) throws Exception {
		this.recurringRate = recurringRate;
		setValueFromAccessor("RECURRING_RATE", recurringRate);
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) throws Exception {
		this.startTime = startTime;
		setValueFromAccessor("START_TIME", startTime);
	}

	public double getTaxablePercentage() {
		return taxablePercentage;
	}

	public void setTaxablePercentage(double taxablePercentage) throws Exception {
		this.taxablePercentage = taxablePercentage;
		setValueFromAccessor("TAXABLE_PERCENTAGE", CommonUtil.toString(taxablePercentage));
	}

	public String getUseAward() {
		return useAward;
	}

	public void setUseAward(String useAward) throws Exception {
		this.useAward = useAward;
		setValueFromAccessor("USE_AWARD", useAward);
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

		str += "assignmentRateId : "+assignmentRateId+"\n";
		str += "amount : "+amount+"\n";
		str += "units : "+units+"\n";
		str += "alternateName : "+alternateName+"\n";
		str += "assigmentId : "+assigmentId+"\n";
		str += "chargePeriod : "+chargePeriod+"\n";
		str += "chargeRate : "+chargeRate+"\n";
		str += "dayType : "+dayType+"\n";
		str += "displayOnExpense : "+displayOnExpense+"\n";
		str += "displayOnTimesheet : "+displayOnTimesheet+"\n";
		str += "elementId : "+elementId+"\n";
		str += "enableFlag : "+enableFlag+"\n";
		str += "endTime : "+endTime+"\n";
		str += "gstExempt : "+gstExempt+"\n";
		str += "overTimeEnd : "+overTimeEnd+"\n";
		str += "overTimeStart : "+overTimeStart+"\n";
		str += "period : "+period+"\n";
		str += "preferred : "+preferred+"\n";
		str += "rateName : "+rateName+"\n";
		str += "recurringRate : "+recurringRate+"\n";
		str += "startTime : "+startTime+"\n";
		str += "taxablePercentage : "+taxablePercentage+"\n";
		str += "useAward : "+useAward+"\n";
		str += "insertUserName : "+insertUserName+"\n";
		str += "updateUserName : "+updateUserName+"\n";

		return str;
	}

	/**
	 * toXmlString
	 */
	public String toXmlString() {
		String str = "";

		str += "<column name=\"assignmentRateId\" value=\""+assignmentRateId+"\">";
		str += "<column name=\"amount\" value=\""+amount+"\">";
		str += "<column name=\"units\" value=\""+units+"\">";
		str += "<column name=\"alternateName\" value=\""+alternateName+"\">";
		str += "<column name=\"assigmentId\" value=\""+assigmentId+"\">";
		str += "<column name=\"chargePeriod\" value=\""+chargePeriod+"\">";
		str += "<column name=\"chargeRate\" value=\""+chargeRate+"\">";
		str += "<column name=\"dayType\" value=\""+dayType+"\">";
		str += "<column name=\"displayOnExpense\" value=\""+displayOnExpense+"\">";
		str += "<column name=\"displayOnTimesheet\" value=\""+displayOnTimesheet+"\">";
		str += "<column name=\"elementId\" value=\""+elementId+"\">";
		str += "<column name=\"enableFlag\" value=\""+enableFlag+"\">";
		str += "<column name=\"endTime\" value=\""+endTime+"\">";
		str += "<column name=\"gstExempt\" value=\""+gstExempt+"\">";
		str += "<column name=\"overTimeEnd\" value=\""+overTimeEnd+"\">";
		str += "<column name=\"overTimeStart\" value=\""+overTimeStart+"\">";
		str += "<column name=\"period\" value=\""+period+"\">";
		str += "<column name=\"preferred\" value=\""+preferred+"\">";
		str += "<column name=\"rateName\" value=\""+rateName+"\">";
		str += "<column name=\"recurringRate\" value=\""+recurringRate+"\">";
		str += "<column name=\"startTime\" value=\""+startTime+"\">";
		str += "<column name=\"taxablePercentage\" value=\""+taxablePercentage+"\">";
		str += "<column name=\"useAward\" value=\""+useAward+"\">";
		str += "<column name=\"insertUserName\" value=\""+insertUserName+"\">";
		str += "<column name=\"updateUserName\" value=\""+updateUserName+"\">";

		return str;
	}

	/**
	 * toJsonString
	 */
	public String toJsonString() {
		String str = "";

		str += "\"assignmentRateId\":\""+assignmentRateId+"\", ";
		str += "\"amount\":\""+amount+"\", ";
		str += "\"units\":\""+units+"\", ";
		str += "\"alternateName\":\""+alternateName+"\", ";
		str += "\"assigmentId\":\""+assigmentId+"\", ";
		str += "\"chargePeriod\":\""+chargePeriod+"\", ";
		str += "\"chargeRate\":\""+chargeRate+"\", ";
		str += "\"dayType\":\""+dayType+"\", ";
		str += "\"displayOnExpense\":\""+displayOnExpense+"\", ";
		str += "\"displayOnTimesheet\":\""+displayOnTimesheet+"\", ";
		str += "\"elementId\":\""+elementId+"\", ";
		str += "\"enableFlag\":\""+enableFlag+"\", ";
		str += "\"endTime\":\""+endTime+"\", ";
		str += "\"gstExempt\":\""+gstExempt+"\", ";
		str += "\"overTimeEnd\":\""+overTimeEnd+"\", ";
		str += "\"overTimeStart\":\""+overTimeStart+"\", ";
		str += "\"period\":\""+period+"\", ";
		str += "\"preferred\":\""+preferred+"\", ";
		str += "\"rateName\":\""+rateName+"\", ";
		str += "\"recurringRate\":\""+recurringRate+"\", ";
		str += "\"startTime\":\""+startTime+"\", ";
		str += "\"taxablePercentage\":\""+taxablePercentage+"\", ";
		str += "\"useAward\":\""+useAward+"\", ";
		str += "\"insertUserName\":\""+insertUserName+"\", ";
		str += "\"updateUserName\":\""+updateUserName+"\"";

		return str;
	}
}