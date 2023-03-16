package project.common.module.payment;

import zebra.data.ParamEntity;

public interface PaymentBiz {
	public ParamEntity getDefault(ParamEntity paramEntity) throws Exception;
	public ParamEntity getPageByTemplate(ParamEntity paramEntity) throws Exception;
	public ParamEntity getEarnings(ParamEntity paramEntity) throws Exception;
	public ParamEntity getDeductions(ParamEntity paramEntity) throws Exception;
	public ParamEntity getPayAdvice(ParamEntity paramEntity) throws Exception;
	public ParamEntity getPaymentType(ParamEntity paramEntity) throws Exception;
	public ParamEntity getBankDetails(ParamEntity paramEntity) throws Exception;
	public ParamEntity getLeaveAccruals(ParamEntity paramEntity) throws Exception;

	public ParamEntity getICRCTITaxableSupplies(ParamEntity paramEntity) throws Exception;
	public ParamEntity getICRCTIValues(ParamEntity paramEntity) throws Exception;

	public ParamEntity getICRemittanceEarnings(ParamEntity paramEntity) throws Exception;
	public ParamEntity getICRemittanceValues(ParamEntity paramEntity) throws Exception;

	public ParamEntity getSTRemittanceEarnings(ParamEntity paramEntity) throws Exception;
	public ParamEntity getSTRemittanceValues(ParamEntity paramEntity) throws Exception;

	public ParamEntity getBCTITaxableSupplies(ParamEntity paramEntity) throws Exception;
}