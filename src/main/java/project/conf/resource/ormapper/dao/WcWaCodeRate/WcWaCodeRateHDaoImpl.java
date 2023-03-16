/**************************************************************************************************
 * Framework Generated HDAOImpl Source
 * - WC_WA_CODE_RATE - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.WcWaCodeRate;

import project.common.extend.BaseHDao;
import project.conf.resource.ormapper.dto.oracle.WcWaCodeRate;
import zebra.data.QueryAdvisor;

public class WcWaCodeRateHDaoImpl extends BaseHDao implements WcWaCodeRateDao {
	public WcWaCodeRate getWcWaCodeRateById(String wcWaCodeRateId) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		queryAdvisor.addWhereClause("code_rate_id = '"+wcWaCodeRateId+"'");
		queryAdvisor.addWhereClause("is_active = 'Y'");
		return (WcWaCodeRate)selectAllToDto(queryAdvisor, new WcWaCodeRate());
	}
}