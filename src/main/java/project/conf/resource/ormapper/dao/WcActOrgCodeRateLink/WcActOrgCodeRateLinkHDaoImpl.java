/**************************************************************************************************
 * Framework Generated HDAOImpl Source
 * - WC_ACT_ORG_CODE_RATE_LINK - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.WcActOrgCodeRateLink;

import project.common.extend.BaseHDao;
import project.conf.resource.ormapper.dto.oracle.WcActOrgCodeRateLink;
import zebra.data.QueryAdvisor;

public class WcActOrgCodeRateLinkHDaoImpl extends BaseHDao implements WcActOrgCodeRateLinkDao {
	public WcActOrgCodeRateLink getWcActOrgCodeRateLinkById(String wcActOrgCodeRateLinkId) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		queryAdvisor.addWhereClause("link_id = '"+wcActOrgCodeRateLinkId+"'");
		queryAdvisor.addWhereClause("is_active = 'Y'");
		return (WcActOrgCodeRateLink)selectAllToDto(queryAdvisor, new WcActOrgCodeRateLink());
	}
}