/**************************************************************************************************
 * Framework Generated HDAOImpl Source
 * - WC_TAS_CODE_RATE_D - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.WcTasCodeRateD;

import project.common.extend.BaseHDao;
import project.conf.resource.ormapper.dto.oracle.WcTasCodeRateD;
import zebra.data.QueryAdvisor;

public class WcTasCodeRateDHDaoImpl extends BaseHDao implements WcTasCodeRateDDao {
	public WcTasCodeRateD getWcTasCodeRateDByWcTasCodeRateId(String wcTasCodeRateId) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		queryAdvisor.addWhereClause("code_rate_id = '"+wcTasCodeRateId+"'");
		queryAdvisor.addWhereClause("is_active = 'Y'");
		return (WcTasCodeRateD)selectAllToDto(queryAdvisor, new WcTasCodeRateD());
	}
}