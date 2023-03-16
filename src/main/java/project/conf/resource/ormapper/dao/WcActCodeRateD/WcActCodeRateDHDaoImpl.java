/**************************************************************************************************
 * Framework Generated HDAOImpl Source
 * - WC_ACT_CODE_RATE_D - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.WcActCodeRateD;

import project.common.extend.BaseHDao;
import project.conf.resource.ormapper.dto.oracle.WcActCodeRateD;
import zebra.data.QueryAdvisor;

public class WcActCodeRateDHDaoImpl extends BaseHDao implements WcActCodeRateDDao {
	public WcActCodeRateD getWcActCodeRateDByWcActCodeRateId(String wcActCodeRateId) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		queryAdvisor.addWhereClause("code_rate_id = '"+wcActCodeRateId+"'");
		queryAdvisor.addWhereClause("is_active = 'Y'");
		return (WcActCodeRateD)selectAllToDto(queryAdvisor, new WcActCodeRateD());
	}
}