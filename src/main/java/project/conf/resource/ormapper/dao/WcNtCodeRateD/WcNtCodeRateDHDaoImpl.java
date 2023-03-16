/**************************************************************************************************
 * Framework Generated HDAOImpl Source
 * - WC_NT_CODE_RATE_D - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.WcNtCodeRateD;

import project.common.extend.BaseHDao;
import project.conf.resource.ormapper.dto.oracle.WcNtCodeRateD;
import zebra.data.QueryAdvisor;

public class WcNtCodeRateDHDaoImpl extends BaseHDao implements WcNtCodeRateDDao {
	public WcNtCodeRateD getWcNtCodeRateDByWcNtCodeRateId(String wcNtCodeRateId) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		queryAdvisor.addWhereClause("code_rate_id = '"+wcNtCodeRateId+"'");
		queryAdvisor.addWhereClause("is_active = 'Y'");
		return (WcNtCodeRateD)selectAllToDto(queryAdvisor, new WcNtCodeRateD());
	}
}