/**************************************************************************************************
 * Framework Generated HDAOImpl Source
 * - WC_VIC_INDUSTRY_RATE - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.WcVicIndustryRate;

import project.common.extend.BaseHDao;
import project.conf.resource.ormapper.dto.oracle.WcVicIndustryRate;
import zebra.data.QueryAdvisor;

public class WcVicIndustryRateHDaoImpl extends BaseHDao implements WcVicIndustryRateDao {
	public WcVicIndustryRate getWcVicIndustryRateById(String wcVicIndustryRateId) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		queryAdvisor.addWhereClause("industry_rate_id = '"+wcVicIndustryRateId+"'");
		queryAdvisor.addWhereClause("is_active = 'Y'");
		return (WcVicIndustryRate)selectAllToDto(queryAdvisor, new WcVicIndustryRate());
	}
}