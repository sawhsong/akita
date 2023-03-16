/**************************************************************************************************
 * Framework Generated HDAOImpl Source
 * - WC_WA_ORG_CODE_RATE_LINK - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.WcWaOrgCodeRateLink;

import project.common.extend.BaseHDao;
import project.conf.resource.ormapper.dto.oracle.WcWaOrgCodeRateLink;
import zebra.data.QueryAdvisor;

public class WcWaOrgCodeRateLinkHDaoImpl extends BaseHDao implements WcWaOrgCodeRateLinkDao {
	public WcWaOrgCodeRateLink getWcWaOrgCodeRateLinkById(String wcWaOrgCodeRateLinkId) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		queryAdvisor.addWhereClause("link_id = '"+wcWaOrgCodeRateLinkId+"'");
		queryAdvisor.addWhereClause("is_active = 'Y'");
		return (WcWaOrgCodeRateLink)selectAllToDto(queryAdvisor, new WcWaOrgCodeRateLink());
	}
}