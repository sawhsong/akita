/**************************************************************************************************
 * Framework Generated HDAOImpl Source
 * - WC_SA_ORG_CODE_RATE_LINK - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.WcSaOrgCodeRateLink;

import project.common.extend.BaseHDao;
import project.conf.resource.ormapper.dto.oracle.WcSaOrgCodeRateLink;
import zebra.data.QueryAdvisor;

public class WcSaOrgCodeRateLinkHDaoImpl extends BaseHDao implements WcSaOrgCodeRateLinkDao {
	public WcSaOrgCodeRateLink getWcSaOrgCodeRateLinkById(String wcSaOrgCodeRateLinkId) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		queryAdvisor.addWhereClause("link_id = '"+wcSaOrgCodeRateLinkId+"'");
		queryAdvisor.addWhereClause("is_active = 'Y'");
		return (WcSaOrgCodeRateLink)selectAllToDto(queryAdvisor, new WcSaOrgCodeRateLink());
	}
}