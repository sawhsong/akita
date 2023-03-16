/**************************************************************************************************
 * Framework Generated HDAOImpl Source
 * - WC_QLD_ORG_CODE_RATE_LINK - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.WcQldOrgCodeRateLink;

import project.common.extend.BaseHDao;
import project.conf.resource.ormapper.dto.oracle.WcQldOrgCodeRateLink;
import zebra.data.QueryAdvisor;

public class WcQldOrgCodeRateLinkHDaoImpl extends BaseHDao implements WcQldOrgCodeRateLinkDao {
	public WcQldOrgCodeRateLink getWcQldOrgCodeRateLinkById(String wcQldOrgCodeRateLinkId) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		queryAdvisor.addWhereClause("link_id = '"+wcQldOrgCodeRateLinkId+"'");
		queryAdvisor.addWhereClause("is_active = 'Y'");
		return (WcQldOrgCodeRateLink)selectAllToDto(queryAdvisor, new WcQldOrgCodeRateLink());
	}
}