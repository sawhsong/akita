/**************************************************************************************************
 * Framework Generated DTO Source
 * - HP_ORGANISATION_D - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dto.oracle;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;

import zebra.data.DataSet;
import zebra.util.CommonUtil;
import project.common.extend.BaseDto;

@SuppressWarnings("unused")
public class HpOrganisationD extends BaseDto implements Serializable {
	/**
	 * Columns
	 */
	private double organisationId;
	private String ORGANISATION_ID;
	private double createdBy;
	private String CREATED_BY;
	private Date creationDate;
	private String CREATION_DATE;
	private double lastUpdatedBy;
	private String LAST_UPDATED_BY;
	private Date lastUpdateDate;
	private String LAST_UPDATE_DATE;
	private String abn;
	private String ABN;
	private String acceptRcti;
	private String ACCEPT_RCTI;
	private String acn;
	private String ACN;
	private String addressLine;
	private String ADDRESS_LINE;
	private String anzicCode;
	private String ANZIC_CODE;
	private double authorizedPerson;
	private String AUTHORIZED_PERSON;
	private String bankKeyWord;
	private String BANK_KEY_WORD;
	private String billingName;
	private String BILLING_NAME;
	private String branchNumber;
	private String BRANCH_NUMBER;
	private double businessGroupId;
	private String BUSINESS_GROUP_ID;
	private String country;
	private String COUNTRY;
	private Date csiExecutionDate;
	private String CSI_EXECUTION_DATE;
	private Date csiReviewDate;
	private String CSI_REVIEW_DATE;
	private String customerCategory;
	private String CUSTOMER_CATEGORY;
	private String customerStream;
	private String CUSTOMER_STREAM;
	private String customerType;
	private String CUSTOMER_TYPE;
	private String email;
	private String EMAIL;
	private double entityStaffContact;
	private String ENTITY_STAFF_CONTACT;
	private double esAccountManager;
	private String ES_ACCOUNT_MANAGER;
	private double esBdManager;
	private String ES_BD_MANAGER;
	private double esCsConsultant;
	private String ES_CS_CONSULTANT;
	private double esCustomerAdministrator;
	private String ES_CUSTOMER_ADMINISTRATOR;
	private double esExecRelationship;
	private String ES_EXEC_RELATIONSHIP;
	private double esMigrationAdministrator;
	private String ES_MIGRATION_ADMINISTRATOR;
	private double esMigrationConsultant;
	private String ES_MIGRATION_CONSULTANT;
	private double esPayrollConsultant;
	private String ES_PAYROLL_CONSULTANT;
	private String fax1;
	private String FAX1;
	private String fax2;
	private String FAX2;
	private Date firstContactDate;
	private String FIRST_CONTACT_DATE;
	private Date fromDate;
	private String FROM_DATE;
	private String gstNumber;
	private String GST_NUMBER;
	private String gstReg;
	private String GST_REG;
	private String history;
	private String HISTORY;
	private String jurisdiction;
	private String JURISDICTION;
	private double mainContact;
	private String MAIN_CONTACT;
	private String mobile;
	private String MOBILE;
	private Date msaEndDate;
	private String MSA_END_DATE;
	private Date msaExecutionDate;
	private String MSA_EXECUTION_DATE;
	private Date msaStartDate;
	private String MSA_START_DATE;
	private Date newFlagDate;
	private String NEW_FLAG_DATE;
	private String organisationName;
	private String ORGANISATION_NAME;
	private String organisationOverview;
	private String ORGANISATION_OVERVIEW;
	private String organisationType;
	private String ORGANISATION_TYPE;
	private String orgDormant;
	private String ORG_DORMANT;
	private String orgHierarchy;
	private String ORG_HIERARCHY;
	private String phone1;
	private String PHONE1;
	private String phone2;
	private String PHONE2;
	private String postalAddressLine;
	private String POSTAL_ADDRESS_LINE;
	private String postalCountry;
	private String POSTAL_COUNTRY;
	private String postalPostCode;
	private String POSTAL_POST_CODE;
	private String postalState;
	private String POSTAL_STATE;
	private String postalSuburb;
	private String POSTAL_SUBURB;
	private String postCode;
	private String POST_CODE;
	private String product;
	private String PRODUCT;
	private String referenceNo1;
	private String REFERENCE_NO_1;
	private String referenceNo2;
	private String REFERENCE_NO_2;
	private String referenceNo3;
	private String REFERENCE_NO_3;
	private String relationship;
	private String RELATIONSHIP;
	private String reportingLine;
	private String REPORTING_LINE;
	private String role;
	private String ROLE;
	private String specialRequirements;
	private String SPECIAL_REQUIREMENTS;
	private String sroNumber;
	private String SRO_NUMBER;
	private String state;
	private String STATE;
	private String stpBmsId;
	private String STP_BMS_ID;
	private String suburb;
	private String SUBURB;
	private String swimLane;
	private String SWIM_LANE;
	private String taxInvoiceAcceptanceType;
	private String TAX_INVOICE_ACCEPTANCE_TYPE;
	private String terminationNotice;
	private String TERMINATION_NOTICE;
	private Date toDate;
	private String TO_DATE;
	private String webAddress;
	private String WEB_ADDRESS;
	private String insertUserName;
	private String INSERT_USER_NAME;
	private String updateUserName;
	private String UPDATE_USER_NAME;

	/**
	 * Constructor
	 */
	@SuppressWarnings("rawtypes")
	public HpOrganisationD() throws Exception {
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
		setFrwVarPrimaryKey("ORGANISATION_ID");
		setFrwVarDateColumn("CREATION_DATE,LAST_UPDATE_DATE,CSI_EXECUTION_DATE,CSI_REVIEW_DATE,FIRST_CONTACT_DATE,FROM_DATE,MSA_END_DATE,MSA_EXECUTION_DATE,MSA_START_DATE,NEW_FLAG_DATE,TO_DATE");
		setFrwVarNumberColumn("ORGANISATION_ID,CREATED_BY,LAST_UPDATED_BY,AUTHORIZED_PERSON,BUSINESS_GROUP_ID,ENTITY_STAFF_CONTACT,ES_ACCOUNT_MANAGER,ES_BD_MANAGER,ES_CS_CONSULTANT,ES_CUSTOMER_ADMINISTRATOR,ES_EXEC_RELATIONSHIP,ES_MIGRATION_ADMINISTRATOR,ES_MIGRATION_CONSULTANT,ES_PAYROLL_CONSULTANT,MAIN_CONTACT");
		setFrwVarClobColumn("");
		setFrwVarDefaultColumn("");
		setFrwVarDefaultValue("");
		setDefaultValue();
	}

	/**
	 * Accessors
	 */
	public double getOrganisationId() {
		return organisationId;
	}

	public void setOrganisationId(double organisationId) throws Exception {
		this.organisationId = organisationId;
		setValueFromAccessor("ORGANISATION_ID", CommonUtil.toString(organisationId));
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

	public String getAbn() {
		return abn;
	}

	public void setAbn(String abn) throws Exception {
		this.abn = abn;
		setValueFromAccessor("ABN", abn);
	}

	public String getAcceptRcti() {
		return acceptRcti;
	}

	public void setAcceptRcti(String acceptRcti) throws Exception {
		this.acceptRcti = acceptRcti;
		setValueFromAccessor("ACCEPT_RCTI", acceptRcti);
	}

	public String getAcn() {
		return acn;
	}

	public void setAcn(String acn) throws Exception {
		this.acn = acn;
		setValueFromAccessor("ACN", acn);
	}

	public String getAddressLine() {
		return addressLine;
	}

	public void setAddressLine(String addressLine) throws Exception {
		this.addressLine = addressLine;
		setValueFromAccessor("ADDRESS_LINE", addressLine);
	}

	public String getAnzicCode() {
		return anzicCode;
	}

	public void setAnzicCode(String anzicCode) throws Exception {
		this.anzicCode = anzicCode;
		setValueFromAccessor("ANZIC_CODE", anzicCode);
	}

	public double getAuthorizedPerson() {
		return authorizedPerson;
	}

	public void setAuthorizedPerson(double authorizedPerson) throws Exception {
		this.authorizedPerson = authorizedPerson;
		setValueFromAccessor("AUTHORIZED_PERSON", CommonUtil.toString(authorizedPerson));
	}

	public String getBankKeyWord() {
		return bankKeyWord;
	}

	public void setBankKeyWord(String bankKeyWord) throws Exception {
		this.bankKeyWord = bankKeyWord;
		setValueFromAccessor("BANK_KEY_WORD", bankKeyWord);
	}

	public String getBillingName() {
		return billingName;
	}

	public void setBillingName(String billingName) throws Exception {
		this.billingName = billingName;
		setValueFromAccessor("BILLING_NAME", billingName);
	}

	public String getBranchNumber() {
		return branchNumber;
	}

	public void setBranchNumber(String branchNumber) throws Exception {
		this.branchNumber = branchNumber;
		setValueFromAccessor("BRANCH_NUMBER", branchNumber);
	}

	public double getBusinessGroupId() {
		return businessGroupId;
	}

	public void setBusinessGroupId(double businessGroupId) throws Exception {
		this.businessGroupId = businessGroupId;
		setValueFromAccessor("BUSINESS_GROUP_ID", CommonUtil.toString(businessGroupId));
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) throws Exception {
		this.country = country;
		setValueFromAccessor("COUNTRY", country);
	}

	public Date getCsiExecutionDate() {
		return csiExecutionDate;
	}

	public void setCsiExecutionDate(Date csiExecutionDate) throws Exception {
		this.csiExecutionDate = csiExecutionDate;
		setValueFromAccessor("CSI_EXECUTION_DATE", CommonUtil.toString(csiExecutionDate));
	}

	public Date getCsiReviewDate() {
		return csiReviewDate;
	}

	public void setCsiReviewDate(Date csiReviewDate) throws Exception {
		this.csiReviewDate = csiReviewDate;
		setValueFromAccessor("CSI_REVIEW_DATE", CommonUtil.toString(csiReviewDate));
	}

	public String getCustomerCategory() {
		return customerCategory;
	}

	public void setCustomerCategory(String customerCategory) throws Exception {
		this.customerCategory = customerCategory;
		setValueFromAccessor("CUSTOMER_CATEGORY", customerCategory);
	}

	public String getCustomerStream() {
		return customerStream;
	}

	public void setCustomerStream(String customerStream) throws Exception {
		this.customerStream = customerStream;
		setValueFromAccessor("CUSTOMER_STREAM", customerStream);
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) throws Exception {
		this.customerType = customerType;
		setValueFromAccessor("CUSTOMER_TYPE", customerType);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws Exception {
		this.email = email;
		setValueFromAccessor("EMAIL", email);
	}

	public double getEntityStaffContact() {
		return entityStaffContact;
	}

	public void setEntityStaffContact(double entityStaffContact) throws Exception {
		this.entityStaffContact = entityStaffContact;
		setValueFromAccessor("ENTITY_STAFF_CONTACT", CommonUtil.toString(entityStaffContact));
	}

	public double getEsAccountManager() {
		return esAccountManager;
	}

	public void setEsAccountManager(double esAccountManager) throws Exception {
		this.esAccountManager = esAccountManager;
		setValueFromAccessor("ES_ACCOUNT_MANAGER", CommonUtil.toString(esAccountManager));
	}

	public double getEsBdManager() {
		return esBdManager;
	}

	public void setEsBdManager(double esBdManager) throws Exception {
		this.esBdManager = esBdManager;
		setValueFromAccessor("ES_BD_MANAGER", CommonUtil.toString(esBdManager));
	}

	public double getEsCsConsultant() {
		return esCsConsultant;
	}

	public void setEsCsConsultant(double esCsConsultant) throws Exception {
		this.esCsConsultant = esCsConsultant;
		setValueFromAccessor("ES_CS_CONSULTANT", CommonUtil.toString(esCsConsultant));
	}

	public double getEsCustomerAdministrator() {
		return esCustomerAdministrator;
	}

	public void setEsCustomerAdministrator(double esCustomerAdministrator) throws Exception {
		this.esCustomerAdministrator = esCustomerAdministrator;
		setValueFromAccessor("ES_CUSTOMER_ADMINISTRATOR", CommonUtil.toString(esCustomerAdministrator));
	}

	public double getEsExecRelationship() {
		return esExecRelationship;
	}

	public void setEsExecRelationship(double esExecRelationship) throws Exception {
		this.esExecRelationship = esExecRelationship;
		setValueFromAccessor("ES_EXEC_RELATIONSHIP", CommonUtil.toString(esExecRelationship));
	}

	public double getEsMigrationAdministrator() {
		return esMigrationAdministrator;
	}

	public void setEsMigrationAdministrator(double esMigrationAdministrator) throws Exception {
		this.esMigrationAdministrator = esMigrationAdministrator;
		setValueFromAccessor("ES_MIGRATION_ADMINISTRATOR", CommonUtil.toString(esMigrationAdministrator));
	}

	public double getEsMigrationConsultant() {
		return esMigrationConsultant;
	}

	public void setEsMigrationConsultant(double esMigrationConsultant) throws Exception {
		this.esMigrationConsultant = esMigrationConsultant;
		setValueFromAccessor("ES_MIGRATION_CONSULTANT", CommonUtil.toString(esMigrationConsultant));
	}

	public double getEsPayrollConsultant() {
		return esPayrollConsultant;
	}

	public void setEsPayrollConsultant(double esPayrollConsultant) throws Exception {
		this.esPayrollConsultant = esPayrollConsultant;
		setValueFromAccessor("ES_PAYROLL_CONSULTANT", CommonUtil.toString(esPayrollConsultant));
	}

	public String getFax1() {
		return fax1;
	}

	public void setFax1(String fax1) throws Exception {
		this.fax1 = fax1;
		setValueFromAccessor("FAX1", fax1);
	}

	public String getFax2() {
		return fax2;
	}

	public void setFax2(String fax2) throws Exception {
		this.fax2 = fax2;
		setValueFromAccessor("FAX2", fax2);
	}

	public Date getFirstContactDate() {
		return firstContactDate;
	}

	public void setFirstContactDate(Date firstContactDate) throws Exception {
		this.firstContactDate = firstContactDate;
		setValueFromAccessor("FIRST_CONTACT_DATE", CommonUtil.toString(firstContactDate));
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) throws Exception {
		this.fromDate = fromDate;
		setValueFromAccessor("FROM_DATE", CommonUtil.toString(fromDate));
	}

	public String getGstNumber() {
		return gstNumber;
	}

	public void setGstNumber(String gstNumber) throws Exception {
		this.gstNumber = gstNumber;
		setValueFromAccessor("GST_NUMBER", gstNumber);
	}

	public String getGstReg() {
		return gstReg;
	}

	public void setGstReg(String gstReg) throws Exception {
		this.gstReg = gstReg;
		setValueFromAccessor("GST_REG", gstReg);
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) throws Exception {
		this.history = history;
		setValueFromAccessor("HISTORY", history);
	}

	public String getJurisdiction() {
		return jurisdiction;
	}

	public void setJurisdiction(String jurisdiction) throws Exception {
		this.jurisdiction = jurisdiction;
		setValueFromAccessor("JURISDICTION", jurisdiction);
	}

	public double getMainContact() {
		return mainContact;
	}

	public void setMainContact(double mainContact) throws Exception {
		this.mainContact = mainContact;
		setValueFromAccessor("MAIN_CONTACT", CommonUtil.toString(mainContact));
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) throws Exception {
		this.mobile = mobile;
		setValueFromAccessor("MOBILE", mobile);
	}

	public Date getMsaEndDate() {
		return msaEndDate;
	}

	public void setMsaEndDate(Date msaEndDate) throws Exception {
		this.msaEndDate = msaEndDate;
		setValueFromAccessor("MSA_END_DATE", CommonUtil.toString(msaEndDate));
	}

	public Date getMsaExecutionDate() {
		return msaExecutionDate;
	}

	public void setMsaExecutionDate(Date msaExecutionDate) throws Exception {
		this.msaExecutionDate = msaExecutionDate;
		setValueFromAccessor("MSA_EXECUTION_DATE", CommonUtil.toString(msaExecutionDate));
	}

	public Date getMsaStartDate() {
		return msaStartDate;
	}

	public void setMsaStartDate(Date msaStartDate) throws Exception {
		this.msaStartDate = msaStartDate;
		setValueFromAccessor("MSA_START_DATE", CommonUtil.toString(msaStartDate));
	}

	public Date getNewFlagDate() {
		return newFlagDate;
	}

	public void setNewFlagDate(Date newFlagDate) throws Exception {
		this.newFlagDate = newFlagDate;
		setValueFromAccessor("NEW_FLAG_DATE", CommonUtil.toString(newFlagDate));
	}

	public String getOrganisationName() {
		return organisationName;
	}

	public void setOrganisationName(String organisationName) throws Exception {
		this.organisationName = organisationName;
		setValueFromAccessor("ORGANISATION_NAME", organisationName);
	}

	public String getOrganisationOverview() {
		return organisationOverview;
	}

	public void setOrganisationOverview(String organisationOverview) throws Exception {
		this.organisationOverview = organisationOverview;
		setValueFromAccessor("ORGANISATION_OVERVIEW", organisationOverview);
	}

	public String getOrganisationType() {
		return organisationType;
	}

	public void setOrganisationType(String organisationType) throws Exception {
		this.organisationType = organisationType;
		setValueFromAccessor("ORGANISATION_TYPE", organisationType);
	}

	public String getOrgDormant() {
		return orgDormant;
	}

	public void setOrgDormant(String orgDormant) throws Exception {
		this.orgDormant = orgDormant;
		setValueFromAccessor("ORG_DORMANT", orgDormant);
	}

	public String getOrgHierarchy() {
		return orgHierarchy;
	}

	public void setOrgHierarchy(String orgHierarchy) throws Exception {
		this.orgHierarchy = orgHierarchy;
		setValueFromAccessor("ORG_HIERARCHY", orgHierarchy);
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) throws Exception {
		this.phone1 = phone1;
		setValueFromAccessor("PHONE1", phone1);
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) throws Exception {
		this.phone2 = phone2;
		setValueFromAccessor("PHONE2", phone2);
	}

	public String getPostalAddressLine() {
		return postalAddressLine;
	}

	public void setPostalAddressLine(String postalAddressLine) throws Exception {
		this.postalAddressLine = postalAddressLine;
		setValueFromAccessor("POSTAL_ADDRESS_LINE", postalAddressLine);
	}

	public String getPostalCountry() {
		return postalCountry;
	}

	public void setPostalCountry(String postalCountry) throws Exception {
		this.postalCountry = postalCountry;
		setValueFromAccessor("POSTAL_COUNTRY", postalCountry);
	}

	public String getPostalPostCode() {
		return postalPostCode;
	}

	public void setPostalPostCode(String postalPostCode) throws Exception {
		this.postalPostCode = postalPostCode;
		setValueFromAccessor("POSTAL_POST_CODE", postalPostCode);
	}

	public String getPostalState() {
		return postalState;
	}

	public void setPostalState(String postalState) throws Exception {
		this.postalState = postalState;
		setValueFromAccessor("POSTAL_STATE", postalState);
	}

	public String getPostalSuburb() {
		return postalSuburb;
	}

	public void setPostalSuburb(String postalSuburb) throws Exception {
		this.postalSuburb = postalSuburb;
		setValueFromAccessor("POSTAL_SUBURB", postalSuburb);
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) throws Exception {
		this.postCode = postCode;
		setValueFromAccessor("POST_CODE", postCode);
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) throws Exception {
		this.product = product;
		setValueFromAccessor("PRODUCT", product);
	}

	public String getReferenceNo1() {
		return referenceNo1;
	}

	public void setReferenceNo1(String referenceNo1) throws Exception {
		this.referenceNo1 = referenceNo1;
		setValueFromAccessor("REFERENCE_NO_1", referenceNo1);
	}

	public String getReferenceNo2() {
		return referenceNo2;
	}

	public void setReferenceNo2(String referenceNo2) throws Exception {
		this.referenceNo2 = referenceNo2;
		setValueFromAccessor("REFERENCE_NO_2", referenceNo2);
	}

	public String getReferenceNo3() {
		return referenceNo3;
	}

	public void setReferenceNo3(String referenceNo3) throws Exception {
		this.referenceNo3 = referenceNo3;
		setValueFromAccessor("REFERENCE_NO_3", referenceNo3);
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) throws Exception {
		this.relationship = relationship;
		setValueFromAccessor("RELATIONSHIP", relationship);
	}

	public String getReportingLine() {
		return reportingLine;
	}

	public void setReportingLine(String reportingLine) throws Exception {
		this.reportingLine = reportingLine;
		setValueFromAccessor("REPORTING_LINE", reportingLine);
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) throws Exception {
		this.role = role;
		setValueFromAccessor("ROLE", role);
	}

	public String getSpecialRequirements() {
		return specialRequirements;
	}

	public void setSpecialRequirements(String specialRequirements) throws Exception {
		this.specialRequirements = specialRequirements;
		setValueFromAccessor("SPECIAL_REQUIREMENTS", specialRequirements);
	}

	public String getSroNumber() {
		return sroNumber;
	}

	public void setSroNumber(String sroNumber) throws Exception {
		this.sroNumber = sroNumber;
		setValueFromAccessor("SRO_NUMBER", sroNumber);
	}

	public String getState() {
		return state;
	}

	public void setState(String state) throws Exception {
		this.state = state;
		setValueFromAccessor("STATE", state);
	}

	public String getStpBmsId() {
		return stpBmsId;
	}

	public void setStpBmsId(String stpBmsId) throws Exception {
		this.stpBmsId = stpBmsId;
		setValueFromAccessor("STP_BMS_ID", stpBmsId);
	}

	public String getSuburb() {
		return suburb;
	}

	public void setSuburb(String suburb) throws Exception {
		this.suburb = suburb;
		setValueFromAccessor("SUBURB", suburb);
	}

	public String getSwimLane() {
		return swimLane;
	}

	public void setSwimLane(String swimLane) throws Exception {
		this.swimLane = swimLane;
		setValueFromAccessor("SWIM_LANE", swimLane);
	}

	public String getTaxInvoiceAcceptanceType() {
		return taxInvoiceAcceptanceType;
	}

	public void setTaxInvoiceAcceptanceType(String taxInvoiceAcceptanceType) throws Exception {
		this.taxInvoiceAcceptanceType = taxInvoiceAcceptanceType;
		setValueFromAccessor("TAX_INVOICE_ACCEPTANCE_TYPE", taxInvoiceAcceptanceType);
	}

	public String getTerminationNotice() {
		return terminationNotice;
	}

	public void setTerminationNotice(String terminationNotice) throws Exception {
		this.terminationNotice = terminationNotice;
		setValueFromAccessor("TERMINATION_NOTICE", terminationNotice);
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) throws Exception {
		this.toDate = toDate;
		setValueFromAccessor("TO_DATE", CommonUtil.toString(toDate));
	}

	public String getWebAddress() {
		return webAddress;
	}

	public void setWebAddress(String webAddress) throws Exception {
		this.webAddress = webAddress;
		setValueFromAccessor("WEB_ADDRESS", webAddress);
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

		str += "organisationId : "+organisationId+"\n";
		str += "createdBy : "+createdBy+"\n";
		str += "creationDate : "+creationDate+"\n";
		str += "lastUpdatedBy : "+lastUpdatedBy+"\n";
		str += "lastUpdateDate : "+lastUpdateDate+"\n";
		str += "abn : "+abn+"\n";
		str += "acceptRcti : "+acceptRcti+"\n";
		str += "acn : "+acn+"\n";
		str += "addressLine : "+addressLine+"\n";
		str += "anzicCode : "+anzicCode+"\n";
		str += "authorizedPerson : "+authorizedPerson+"\n";
		str += "bankKeyWord : "+bankKeyWord+"\n";
		str += "billingName : "+billingName+"\n";
		str += "branchNumber : "+branchNumber+"\n";
		str += "businessGroupId : "+businessGroupId+"\n";
		str += "country : "+country+"\n";
		str += "csiExecutionDate : "+csiExecutionDate+"\n";
		str += "csiReviewDate : "+csiReviewDate+"\n";
		str += "customerCategory : "+customerCategory+"\n";
		str += "customerStream : "+customerStream+"\n";
		str += "customerType : "+customerType+"\n";
		str += "email : "+email+"\n";
		str += "entityStaffContact : "+entityStaffContact+"\n";
		str += "esAccountManager : "+esAccountManager+"\n";
		str += "esBdManager : "+esBdManager+"\n";
		str += "esCsConsultant : "+esCsConsultant+"\n";
		str += "esCustomerAdministrator : "+esCustomerAdministrator+"\n";
		str += "esExecRelationship : "+esExecRelationship+"\n";
		str += "esMigrationAdministrator : "+esMigrationAdministrator+"\n";
		str += "esMigrationConsultant : "+esMigrationConsultant+"\n";
		str += "esPayrollConsultant : "+esPayrollConsultant+"\n";
		str += "fax1 : "+fax1+"\n";
		str += "fax2 : "+fax2+"\n";
		str += "firstContactDate : "+firstContactDate+"\n";
		str += "fromDate : "+fromDate+"\n";
		str += "gstNumber : "+gstNumber+"\n";
		str += "gstReg : "+gstReg+"\n";
		str += "history : "+history+"\n";
		str += "jurisdiction : "+jurisdiction+"\n";
		str += "mainContact : "+mainContact+"\n";
		str += "mobile : "+mobile+"\n";
		str += "msaEndDate : "+msaEndDate+"\n";
		str += "msaExecutionDate : "+msaExecutionDate+"\n";
		str += "msaStartDate : "+msaStartDate+"\n";
		str += "newFlagDate : "+newFlagDate+"\n";
		str += "organisationName : "+organisationName+"\n";
		str += "organisationOverview : "+organisationOverview+"\n";
		str += "organisationType : "+organisationType+"\n";
		str += "orgDormant : "+orgDormant+"\n";
		str += "orgHierarchy : "+orgHierarchy+"\n";
		str += "phone1 : "+phone1+"\n";
		str += "phone2 : "+phone2+"\n";
		str += "postalAddressLine : "+postalAddressLine+"\n";
		str += "postalCountry : "+postalCountry+"\n";
		str += "postalPostCode : "+postalPostCode+"\n";
		str += "postalState : "+postalState+"\n";
		str += "postalSuburb : "+postalSuburb+"\n";
		str += "postCode : "+postCode+"\n";
		str += "product : "+product+"\n";
		str += "referenceNo1 : "+referenceNo1+"\n";
		str += "referenceNo2 : "+referenceNo2+"\n";
		str += "referenceNo3 : "+referenceNo3+"\n";
		str += "relationship : "+relationship+"\n";
		str += "reportingLine : "+reportingLine+"\n";
		str += "role : "+role+"\n";
		str += "specialRequirements : "+specialRequirements+"\n";
		str += "sroNumber : "+sroNumber+"\n";
		str += "state : "+state+"\n";
		str += "stpBmsId : "+stpBmsId+"\n";
		str += "suburb : "+suburb+"\n";
		str += "swimLane : "+swimLane+"\n";
		str += "taxInvoiceAcceptanceType : "+taxInvoiceAcceptanceType+"\n";
		str += "terminationNotice : "+terminationNotice+"\n";
		str += "toDate : "+toDate+"\n";
		str += "webAddress : "+webAddress+"\n";
		str += "insertUserName : "+insertUserName+"\n";
		str += "updateUserName : "+updateUserName+"\n";

		return str;
	}

	/**
	 * toXmlString
	 */
	public String toXmlString() {
		String str = "";

		str += "<column name=\"organisationId\" value=\""+organisationId+"\">";
		str += "<column name=\"createdBy\" value=\""+createdBy+"\">";
		str += "<column name=\"creationDate\" value=\""+creationDate+"\">";
		str += "<column name=\"lastUpdatedBy\" value=\""+lastUpdatedBy+"\">";
		str += "<column name=\"lastUpdateDate\" value=\""+lastUpdateDate+"\">";
		str += "<column name=\"abn\" value=\""+abn+"\">";
		str += "<column name=\"acceptRcti\" value=\""+acceptRcti+"\">";
		str += "<column name=\"acn\" value=\""+acn+"\">";
		str += "<column name=\"addressLine\" value=\""+addressLine+"\">";
		str += "<column name=\"anzicCode\" value=\""+anzicCode+"\">";
		str += "<column name=\"authorizedPerson\" value=\""+authorizedPerson+"\">";
		str += "<column name=\"bankKeyWord\" value=\""+bankKeyWord+"\">";
		str += "<column name=\"billingName\" value=\""+billingName+"\">";
		str += "<column name=\"branchNumber\" value=\""+branchNumber+"\">";
		str += "<column name=\"businessGroupId\" value=\""+businessGroupId+"\">";
		str += "<column name=\"country\" value=\""+country+"\">";
		str += "<column name=\"csiExecutionDate\" value=\""+csiExecutionDate+"\">";
		str += "<column name=\"csiReviewDate\" value=\""+csiReviewDate+"\">";
		str += "<column name=\"customerCategory\" value=\""+customerCategory+"\">";
		str += "<column name=\"customerStream\" value=\""+customerStream+"\">";
		str += "<column name=\"customerType\" value=\""+customerType+"\">";
		str += "<column name=\"email\" value=\""+email+"\">";
		str += "<column name=\"entityStaffContact\" value=\""+entityStaffContact+"\">";
		str += "<column name=\"esAccountManager\" value=\""+esAccountManager+"\">";
		str += "<column name=\"esBdManager\" value=\""+esBdManager+"\">";
		str += "<column name=\"esCsConsultant\" value=\""+esCsConsultant+"\">";
		str += "<column name=\"esCustomerAdministrator\" value=\""+esCustomerAdministrator+"\">";
		str += "<column name=\"esExecRelationship\" value=\""+esExecRelationship+"\">";
		str += "<column name=\"esMigrationAdministrator\" value=\""+esMigrationAdministrator+"\">";
		str += "<column name=\"esMigrationConsultant\" value=\""+esMigrationConsultant+"\">";
		str += "<column name=\"esPayrollConsultant\" value=\""+esPayrollConsultant+"\">";
		str += "<column name=\"fax1\" value=\""+fax1+"\">";
		str += "<column name=\"fax2\" value=\""+fax2+"\">";
		str += "<column name=\"firstContactDate\" value=\""+firstContactDate+"\">";
		str += "<column name=\"fromDate\" value=\""+fromDate+"\">";
		str += "<column name=\"gstNumber\" value=\""+gstNumber+"\">";
		str += "<column name=\"gstReg\" value=\""+gstReg+"\">";
		str += "<column name=\"history\" value=\""+history+"\">";
		str += "<column name=\"jurisdiction\" value=\""+jurisdiction+"\">";
		str += "<column name=\"mainContact\" value=\""+mainContact+"\">";
		str += "<column name=\"mobile\" value=\""+mobile+"\">";
		str += "<column name=\"msaEndDate\" value=\""+msaEndDate+"\">";
		str += "<column name=\"msaExecutionDate\" value=\""+msaExecutionDate+"\">";
		str += "<column name=\"msaStartDate\" value=\""+msaStartDate+"\">";
		str += "<column name=\"newFlagDate\" value=\""+newFlagDate+"\">";
		str += "<column name=\"organisationName\" value=\""+organisationName+"\">";
		str += "<column name=\"organisationOverview\" value=\""+organisationOverview+"\">";
		str += "<column name=\"organisationType\" value=\""+organisationType+"\">";
		str += "<column name=\"orgDormant\" value=\""+orgDormant+"\">";
		str += "<column name=\"orgHierarchy\" value=\""+orgHierarchy+"\">";
		str += "<column name=\"phone1\" value=\""+phone1+"\">";
		str += "<column name=\"phone2\" value=\""+phone2+"\">";
		str += "<column name=\"postalAddressLine\" value=\""+postalAddressLine+"\">";
		str += "<column name=\"postalCountry\" value=\""+postalCountry+"\">";
		str += "<column name=\"postalPostCode\" value=\""+postalPostCode+"\">";
		str += "<column name=\"postalState\" value=\""+postalState+"\">";
		str += "<column name=\"postalSuburb\" value=\""+postalSuburb+"\">";
		str += "<column name=\"postCode\" value=\""+postCode+"\">";
		str += "<column name=\"product\" value=\""+product+"\">";
		str += "<column name=\"referenceNo1\" value=\""+referenceNo1+"\">";
		str += "<column name=\"referenceNo2\" value=\""+referenceNo2+"\">";
		str += "<column name=\"referenceNo3\" value=\""+referenceNo3+"\">";
		str += "<column name=\"relationship\" value=\""+relationship+"\">";
		str += "<column name=\"reportingLine\" value=\""+reportingLine+"\">";
		str += "<column name=\"role\" value=\""+role+"\">";
		str += "<column name=\"specialRequirements\" value=\""+specialRequirements+"\">";
		str += "<column name=\"sroNumber\" value=\""+sroNumber+"\">";
		str += "<column name=\"state\" value=\""+state+"\">";
		str += "<column name=\"stpBmsId\" value=\""+stpBmsId+"\">";
		str += "<column name=\"suburb\" value=\""+suburb+"\">";
		str += "<column name=\"swimLane\" value=\""+swimLane+"\">";
		str += "<column name=\"taxInvoiceAcceptanceType\" value=\""+taxInvoiceAcceptanceType+"\">";
		str += "<column name=\"terminationNotice\" value=\""+terminationNotice+"\">";
		str += "<column name=\"toDate\" value=\""+toDate+"\">";
		str += "<column name=\"webAddress\" value=\""+webAddress+"\">";
		str += "<column name=\"insertUserName\" value=\""+insertUserName+"\">";
		str += "<column name=\"updateUserName\" value=\""+updateUserName+"\">";

		return str;
	}

	/**
	 * toJsonString
	 */
	public String toJsonString() {
		String str = "";

		str += "\"organisationId\":\""+organisationId+"\", ";
		str += "\"createdBy\":\""+createdBy+"\", ";
		str += "\"creationDate\":\""+creationDate+"\", ";
		str += "\"lastUpdatedBy\":\""+lastUpdatedBy+"\", ";
		str += "\"lastUpdateDate\":\""+lastUpdateDate+"\", ";
		str += "\"abn\":\""+abn+"\", ";
		str += "\"acceptRcti\":\""+acceptRcti+"\", ";
		str += "\"acn\":\""+acn+"\", ";
		str += "\"addressLine\":\""+addressLine+"\", ";
		str += "\"anzicCode\":\""+anzicCode+"\", ";
		str += "\"authorizedPerson\":\""+authorizedPerson+"\", ";
		str += "\"bankKeyWord\":\""+bankKeyWord+"\", ";
		str += "\"billingName\":\""+billingName+"\", ";
		str += "\"branchNumber\":\""+branchNumber+"\", ";
		str += "\"businessGroupId\":\""+businessGroupId+"\", ";
		str += "\"country\":\""+country+"\", ";
		str += "\"csiExecutionDate\":\""+csiExecutionDate+"\", ";
		str += "\"csiReviewDate\":\""+csiReviewDate+"\", ";
		str += "\"customerCategory\":\""+customerCategory+"\", ";
		str += "\"customerStream\":\""+customerStream+"\", ";
		str += "\"customerType\":\""+customerType+"\", ";
		str += "\"email\":\""+email+"\", ";
		str += "\"entityStaffContact\":\""+entityStaffContact+"\", ";
		str += "\"esAccountManager\":\""+esAccountManager+"\", ";
		str += "\"esBdManager\":\""+esBdManager+"\", ";
		str += "\"esCsConsultant\":\""+esCsConsultant+"\", ";
		str += "\"esCustomerAdministrator\":\""+esCustomerAdministrator+"\", ";
		str += "\"esExecRelationship\":\""+esExecRelationship+"\", ";
		str += "\"esMigrationAdministrator\":\""+esMigrationAdministrator+"\", ";
		str += "\"esMigrationConsultant\":\""+esMigrationConsultant+"\", ";
		str += "\"esPayrollConsultant\":\""+esPayrollConsultant+"\", ";
		str += "\"fax1\":\""+fax1+"\", ";
		str += "\"fax2\":\""+fax2+"\", ";
		str += "\"firstContactDate\":\""+firstContactDate+"\", ";
		str += "\"fromDate\":\""+fromDate+"\", ";
		str += "\"gstNumber\":\""+gstNumber+"\", ";
		str += "\"gstReg\":\""+gstReg+"\", ";
		str += "\"history\":\""+history+"\", ";
		str += "\"jurisdiction\":\""+jurisdiction+"\", ";
		str += "\"mainContact\":\""+mainContact+"\", ";
		str += "\"mobile\":\""+mobile+"\", ";
		str += "\"msaEndDate\":\""+msaEndDate+"\", ";
		str += "\"msaExecutionDate\":\""+msaExecutionDate+"\", ";
		str += "\"msaStartDate\":\""+msaStartDate+"\", ";
		str += "\"newFlagDate\":\""+newFlagDate+"\", ";
		str += "\"organisationName\":\""+organisationName+"\", ";
		str += "\"organisationOverview\":\""+organisationOverview+"\", ";
		str += "\"organisationType\":\""+organisationType+"\", ";
		str += "\"orgDormant\":\""+orgDormant+"\", ";
		str += "\"orgHierarchy\":\""+orgHierarchy+"\", ";
		str += "\"phone1\":\""+phone1+"\", ";
		str += "\"phone2\":\""+phone2+"\", ";
		str += "\"postalAddressLine\":\""+postalAddressLine+"\", ";
		str += "\"postalCountry\":\""+postalCountry+"\", ";
		str += "\"postalPostCode\":\""+postalPostCode+"\", ";
		str += "\"postalState\":\""+postalState+"\", ";
		str += "\"postalSuburb\":\""+postalSuburb+"\", ";
		str += "\"postCode\":\""+postCode+"\", ";
		str += "\"product\":\""+product+"\", ";
		str += "\"referenceNo1\":\""+referenceNo1+"\", ";
		str += "\"referenceNo2\":\""+referenceNo2+"\", ";
		str += "\"referenceNo3\":\""+referenceNo3+"\", ";
		str += "\"relationship\":\""+relationship+"\", ";
		str += "\"reportingLine\":\""+reportingLine+"\", ";
		str += "\"role\":\""+role+"\", ";
		str += "\"specialRequirements\":\""+specialRequirements+"\", ";
		str += "\"sroNumber\":\""+sroNumber+"\", ";
		str += "\"state\":\""+state+"\", ";
		str += "\"stpBmsId\":\""+stpBmsId+"\", ";
		str += "\"suburb\":\""+suburb+"\", ";
		str += "\"swimLane\":\""+swimLane+"\", ";
		str += "\"taxInvoiceAcceptanceType\":\""+taxInvoiceAcceptanceType+"\", ";
		str += "\"terminationNotice\":\""+terminationNotice+"\", ";
		str += "\"toDate\":\""+toDate+"\", ";
		str += "\"webAddress\":\""+webAddress+"\", ";
		str += "\"insertUserName\":\""+insertUserName+"\", ";
		str += "\"updateUserName\":\""+updateUserName+"\"";

		return str;
	}
}