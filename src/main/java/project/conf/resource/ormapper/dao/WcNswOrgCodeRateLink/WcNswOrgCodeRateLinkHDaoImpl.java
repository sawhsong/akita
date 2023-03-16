/**************************************************************************************************
 * Framework Generated HDAOImpl Source
 * - WC_NSW_ORG_CODE_RATE_LINK - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.WcNswOrgCodeRateLink;

import project.common.extend.BaseHDao;
import project.conf.resource.ormapper.dto.oracle.WcNswOrgCodeRateLink;
import zebra.data.QueryAdvisor;

public class WcNswOrgCodeRateLinkHDaoImpl extends BaseHDao implements WcNswOrgCodeRateLinkDao {
	public WcNswOrgCodeRateLink getWcNswOrgCodeRateLinkById(String wcNswOrgCodeRateLinkId) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		queryAdvisor.addWhereClause("link_id = '"+wcNswOrgCodeRateLinkId+"'");
		queryAdvisor.addWhereClause("is_active = 'Y'");
		return (WcNswOrgCodeRateLink)selectAllToDto(queryAdvisor, new WcNswOrgCodeRateLink());
	}
}