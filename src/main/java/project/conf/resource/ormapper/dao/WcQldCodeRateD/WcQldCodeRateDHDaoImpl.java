/**************************************************************************************************
 * Framework Generated HDAOImpl Source
 * - WC_QLD_CODE_RATE_D - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.WcQldCodeRateD;

import project.common.extend.BaseHDao;
import project.conf.resource.ormapper.dto.oracle.WcQldCodeRateD;
import zebra.data.QueryAdvisor;

public class WcQldCodeRateDHDaoImpl extends BaseHDao implements WcQldCodeRateDDao {
	public WcQldCodeRateD getWcQldCodeRateDByWcQldCodeRateId(String wcQldCodeRateId) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		queryAdvisor.addWhereClause("code_rate_id = '"+wcQldCodeRateId+"'");
		queryAdvisor.addWhereClause("is_active = 'Y'");
		return (WcQldCodeRateD)selectAllToDto(queryAdvisor, new WcQldCodeRateD());
	}
}