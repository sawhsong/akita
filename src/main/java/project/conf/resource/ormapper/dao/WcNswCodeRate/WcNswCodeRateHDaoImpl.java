/**************************************************************************************************
 * Framework Generated HDAOImpl Source
 * - WC_NSW_CODE_RATE - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.WcNswCodeRate;

import project.common.extend.BaseHDao;
import project.conf.resource.ormapper.dto.oracle.WcNswCodeRate;
import zebra.data.QueryAdvisor;

public class WcNswCodeRateHDaoImpl extends BaseHDao implements WcNswCodeRateDao {
	public WcNswCodeRate getWcNswCodeRateById(String wcNswCodeRateId) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		queryAdvisor.addWhereClause("code_rate_id = '"+wcNswCodeRateId+"'");
		queryAdvisor.addWhereClause("is_active = 'Y'");
		return (WcNswCodeRate)selectAllToDto(queryAdvisor, new WcNswCodeRate());
	}
}