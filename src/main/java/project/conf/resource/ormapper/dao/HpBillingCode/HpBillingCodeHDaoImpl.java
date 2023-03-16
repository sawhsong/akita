/**************************************************************************************************
 * Framework Generated HDAOImpl Source
 * - HP_BILLING_CODE - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.HpBillingCode;

import project.common.extend.BaseHDao;
import project.conf.resource.ormapper.dto.oracle.HpBillingCode;
import zebra.data.DataSet;
import zebra.data.QueryAdvisor;

public class HpBillingCodeHDaoImpl extends BaseHDao implements HpBillingCodeDao {
	public int updateColumns(String billingCodeId, HpBillingCode hpBillingCode) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		queryAdvisor.addWhereClause("billing_code_id = '"+billingCodeId+"'");
		return updateColumns(queryAdvisor, hpBillingCode);
	}

	public HpBillingCode getBillingCodeByBillingCodeId(String billingCodeId) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		queryAdvisor.addWhereClause("billing_code_id = '"+billingCodeId+"'");
		return (HpBillingCode)selectAllToDto(queryAdvisor, new HpBillingCode());
	}

	public DataSet getBillingCodeByIdForAutoCompletion(QueryAdvisor queryAdvisor) throws Exception {
		return selectAsDataSet(queryAdvisor, "query.HpBillingCode.getBillingCodeByCodeForAutoCompletion");
	}

	public DataSet getBillingCodeByCodeForAutoCompletion(QueryAdvisor queryAdvisor) throws Exception {
		return selectAsDataSet(queryAdvisor, "query.HpBillingCode.getBillingCodeByCodeForAutoCompletion");
	}
}