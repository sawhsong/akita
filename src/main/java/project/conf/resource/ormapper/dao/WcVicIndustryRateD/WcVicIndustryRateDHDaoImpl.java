/**************************************************************************************************
 * Framework Generated HDAOImpl Source
 * - WC_VIC_INDUSTRY_RATE_D - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.WcVicIndustryRateD;

import project.common.extend.BaseHDao;
import project.conf.resource.ormapper.dto.oracle.WcVicIndustryRateD;
import zebra.data.QueryAdvisor;

public class WcVicIndustryRateDHDaoImpl extends BaseHDao implements WcVicIndustryRateDDao {
	public WcVicIndustryRateD getWcVicIndustryRateDByWcVicIndustryRateId(String wcVicIndustryRateId) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		queryAdvisor.addWhereClause("industry_rate_id = '"+wcVicIndustryRateId+"'");
		queryAdvisor.addWhereClause("is_active = 'Y'");
		return (WcVicIndustryRateD)selectAllToDto(queryAdvisor, new WcVicIndustryRateD());
	}
}