/**************************************************************************************************
 * Framework Generated HDAOImpl Source
 * - WC_SA_INDUSTRY_RATE_D - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.WcSaIndustryRateD;

import project.common.extend.BaseHDao;
import project.conf.resource.ormapper.dto.oracle.WcSaIndustryRateD;
import zebra.data.QueryAdvisor;

public class WcSaIndustryRateDHDaoImpl extends BaseHDao implements WcSaIndustryRateDDao {
	public WcSaIndustryRateD getWcSaIndustryRateDByWcSaIndustryRateId(String wcSaIndustryRateId) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		queryAdvisor.addWhereClause("industry_rate_id = '"+wcSaIndustryRateId+"'");
		queryAdvisor.addWhereClause("is_active = 'Y'");
		return (WcSaIndustryRateD)selectAllToDto(queryAdvisor, new WcSaIndustryRateD());
	}
}