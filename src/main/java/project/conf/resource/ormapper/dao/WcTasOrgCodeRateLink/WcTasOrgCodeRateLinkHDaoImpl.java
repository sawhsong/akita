/**************************************************************************************************
 * Framework Generated HDAOImpl Source
 * - WC_TAS_ORG_CODE_RATE_LINK - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.WcTasOrgCodeRateLink;

import project.common.extend.BaseHDao;
import project.conf.resource.ormapper.dto.oracle.WcTasOrgCodeRateLink;
import zebra.data.QueryAdvisor;

public class WcTasOrgCodeRateLinkHDaoImpl extends BaseHDao implements WcTasOrgCodeRateLinkDao {
	public WcTasOrgCodeRateLink getWcTasOrgCodeRateLinkById(String wcTasOrgCodeRateLinkId) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		queryAdvisor.addWhereClause("link_id = '"+wcTasOrgCodeRateLinkId+"'");
		queryAdvisor.addWhereClause("is_active = 'Y'");
		return (WcTasOrgCodeRateLink)selectAllToDto(queryAdvisor, new WcTasOrgCodeRateLink());
	}
}