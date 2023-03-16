/**************************************************************************************************
 * Framework Generated HDAOImpl Source
 * - WC_WA_CODE_RATE_D - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.WcWaCodeRateD;

import project.common.extend.BaseHDao;
import project.conf.resource.ormapper.dto.oracle.WcWaCodeRateD;
import zebra.data.QueryAdvisor;

public class WcWaCodeRateDHDaoImpl extends BaseHDao implements WcWaCodeRateDDao {
	public WcWaCodeRateD getWcWaCodeRateDByWcWaCodeRateId(String wcWaCodeRateId) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		queryAdvisor.addWhereClause("code_rate_id = '"+wcWaCodeRateId+"'");
		queryAdvisor.addWhereClause("is_active = 'Y'");
		return (WcWaCodeRateD)selectAllToDto(queryAdvisor, new WcWaCodeRateD());
	}
}