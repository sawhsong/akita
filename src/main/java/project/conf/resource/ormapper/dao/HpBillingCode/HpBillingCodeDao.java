/**************************************************************************************************
 * Framework Generated DAO Source
 * - HP_BILLING_CODE - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.HpBillingCode;

import project.conf.resource.ormapper.dto.oracle.HpBillingCode;
import zebra.base.IDao;
import zebra.data.DataSet;
import zebra.data.QueryAdvisor;

public interface HpBillingCodeDao extends IDao {
	public int updateColumns(String billingCodeId, HpBillingCode hpBillingCode) throws Exception;
	public HpBillingCode getBillingCodeByBillingCodeId(String billingCodeId) throws Exception;
	public DataSet getBillingCodeByIdForAutoCompletion(QueryAdvisor queryAdvisor) throws Exception;
	public DataSet getBillingCodeByCodeForAutoCompletion(QueryAdvisor queryAdvisor) throws Exception;
}