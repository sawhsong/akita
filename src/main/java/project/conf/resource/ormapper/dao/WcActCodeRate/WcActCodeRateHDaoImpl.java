/**************************************************************************************************
 * Framework Generated HDAOImpl Source
 * - WC_ACT_CODE_RATE - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.WcActCodeRate;

import project.common.extend.BaseHDao;
import project.conf.resource.ormapper.dto.oracle.WcActCodeRate;
import zebra.data.QueryAdvisor;

public class WcActCodeRateHDaoImpl extends BaseHDao implements WcActCodeRateDao {
	public WcActCodeRate getWcActCodeRateById(String wcActCodeRateId) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		queryAdvisor.addWhereClause("code_rate_id = '"+wcActCodeRateId+"'");
		queryAdvisor.addWhereClause("is_active = 'Y'");
		return (WcActCodeRate)selectAllToDto(queryAdvisor, new WcActCodeRate());
	}
}