package project.common.module.autocompletion;

import zebra.data.ParamEntity;

public interface AutoCompletionBiz {
	public ParamEntity getCommonCodeType(ParamEntity paramEntity) throws Exception;
	public ParamEntity getUserId(ParamEntity paramEntity) throws Exception;
	public ParamEntity getLoginId(ParamEntity paramEntity) throws Exception;
	public ParamEntity getUserName(ParamEntity paramEntity) throws Exception;
	public ParamEntity getCurrencyCode(ParamEntity paramEntity) throws Exception;
	public ParamEntity getCountryName(ParamEntity paramEntity) throws Exception;
	public ParamEntity getOrgById(ParamEntity paramEntity) throws Exception;
	public ParamEntity getOrgByName(ParamEntity paramEntity) throws Exception;
	public ParamEntity getOrgByNameOrId(ParamEntity paramEntity) throws Exception;
	public ParamEntity getBillingOrgByName(ParamEntity paramEntity) throws Exception;
	public ParamEntity getBillingOrgByNameOrId(ParamEntity paramEntity) throws Exception;
	public ParamEntity getOrgName(ParamEntity paramEntity) throws Exception;
	public ParamEntity getAbn(ParamEntity paramEntity) throws Exception;
	public ParamEntity getPersonNumber(ParamEntity paramEntity) throws Exception;
	public ParamEntity getPersonName(ParamEntity paramEntity) throws Exception;
	public ParamEntity getPersonByPersonNumber(ParamEntity paramEntity) throws Exception;
	public ParamEntity getPersonByName(ParamEntity paramEntity) throws Exception;
	public ParamEntity getPersonByNameOrPersonNumber(ParamEntity paramEntity) throws Exception;
	public ParamEntity getEsEmployeeByPersonNumber(ParamEntity paramEntity) throws Exception;
	public ParamEntity getEsEmployeeByName(ParamEntity paramEntity) throws Exception;
	public ParamEntity getEsEmployeeByNameOrPersonNumber(ParamEntity paramEntity) throws Exception;
	public ParamEntity getBillingCodeById(ParamEntity paramEntity) throws Exception;
	public ParamEntity getBillingCodeByCode(ParamEntity paramEntity) throws Exception;
	public ParamEntity getBillingCodeByCodeOrId(ParamEntity paramEntity) throws Exception;
	public ParamEntity getCostCentre(ParamEntity paramEntity) throws Exception;
	public ParamEntity getPaymentMethodByCodeOrId(ParamEntity paramEntity) throws Exception;
}