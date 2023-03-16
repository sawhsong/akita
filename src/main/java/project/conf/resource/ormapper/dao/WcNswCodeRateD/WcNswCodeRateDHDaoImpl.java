/**************************************************************************************************
 * Framework Generated HDAOImpl Source
 * - WC_NSW_CODE_RATE_D - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.WcNswCodeRateD;

import project.common.extend.BaseHDao;
import project.conf.resource.ormapper.dto.oracle.WcNswCodeRateD;
import zebra.data.QueryAdvisor;

public class WcNswCodeRateDHDaoImpl extends BaseHDao implements WcNswCodeRateDDao {
	public WcNswCodeRateD getWcNswCodeRateDByWcNswCodeRateId(String wcNswCodeRateId) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		queryAdvisor.addWhereClause("code_rate_id = '"+wcNswCodeRateId+"'");
		queryAdvisor.addWhereClause("is_active = 'Y'");
		return (WcNswCodeRateD)selectAllToDto(queryAdvisor, new WcNswCodeRateD());
	}
}