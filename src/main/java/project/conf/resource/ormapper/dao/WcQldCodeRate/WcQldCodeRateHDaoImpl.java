/**************************************************************************************************
 * Framework Generated HDAOImpl Source
 * - WC_QLD_CODE_RATE - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.WcQldCodeRate;

import project.common.extend.BaseHDao;
import project.conf.resource.ormapper.dto.oracle.WcQldCodeRate;
import zebra.data.QueryAdvisor;

public class WcQldCodeRateHDaoImpl extends BaseHDao implements WcQldCodeRateDao {
	public WcQldCodeRate getWcQldCodeRateById(String wcQldCodeRateId) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		queryAdvisor.addWhereClause("code_rate_id = '"+wcQldCodeRateId+"'");
		queryAdvisor.addWhereClause("is_active = 'Y'");
		return (WcQldCodeRate)selectAllToDto(queryAdvisor, new WcQldCodeRate());
	}
}