/**************************************************************************************************
 * Framework Generated HDAOImpl Source
 * - WC_SA_INDUSTRY_RATE - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.WcSaIndustryRate;

import project.common.extend.BaseHDao;
import project.conf.resource.ormapper.dto.oracle.WcSaIndustryRate;
import zebra.data.QueryAdvisor;

public class WcSaIndustryRateHDaoImpl extends BaseHDao implements WcSaIndustryRateDao {
	public WcSaIndustryRate getWcSaIndustryRateById(String wcSaIndustryRateId) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		queryAdvisor.addWhereClause("industry_rate_id = '"+wcSaIndustryRateId+"'");
		queryAdvisor.addWhereClause("is_active = 'Y'");
		return (WcSaIndustryRate)selectAllToDto(queryAdvisor, new WcSaIndustryRate());
	}
}