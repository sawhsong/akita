/**************************************************************************************************
 * Framework Generated HDAOImpl Source
 * - WC_TAS_CODE_RATE - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.WcTasCodeRate;

import project.common.extend.BaseHDao;
import project.conf.resource.ormapper.dto.oracle.WcTasCodeRate;
import zebra.data.QueryAdvisor;

public class WcTasCodeRateHDaoImpl extends BaseHDao implements WcTasCodeRateDao {
	public WcTasCodeRate getWcTasCodeRateById(String wcTasCodeRateId) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		queryAdvisor.addWhereClause("code_rate_id = '"+wcTasCodeRateId+"'");
		queryAdvisor.addWhereClause("is_active = 'Y'");
		return (WcTasCodeRate)selectAllToDto(queryAdvisor, new WcTasCodeRate());
	}
}