/**************************************************************************************************
 * Framework Generated HDAOImpl Source
 * - WC_VIC_ORG_CODE_RATE_LINK - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.WcVicOrgCodeRateLink;

import project.common.extend.BaseHDao;
import project.conf.resource.ormapper.dto.oracle.WcVicOrgCodeRateLink;
import zebra.data.QueryAdvisor;

public class WcVicOrgCodeRateLinkHDaoImpl extends BaseHDao implements WcVicOrgCodeRateLinkDao {
	public WcVicOrgCodeRateLink getWcVicOrgCodeRateLinkById(String wcVicOrgCodeRateLinkId) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		queryAdvisor.addWhereClause("link_id = '"+wcVicOrgCodeRateLinkId+"'");
		queryAdvisor.addWhereClause("is_active = 'Y'");
		return (WcVicOrgCodeRateLink)selectAllToDto(queryAdvisor, new WcVicOrgCodeRateLink());
	}
}