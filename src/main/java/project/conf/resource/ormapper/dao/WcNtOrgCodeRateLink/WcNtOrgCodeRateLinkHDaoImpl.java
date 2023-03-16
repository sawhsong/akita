/**************************************************************************************************
 * Framework Generated HDAOImpl Source
 * - WC_NT_ORG_CODE_RATE_LINK - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.WcNtOrgCodeRateLink;

import project.common.extend.BaseHDao;
import project.conf.resource.ormapper.dto.oracle.WcNtOrgCodeRateLink;
import zebra.data.QueryAdvisor;

public class WcNtOrgCodeRateLinkHDaoImpl extends BaseHDao implements WcNtOrgCodeRateLinkDao {
	public WcNtOrgCodeRateLink getWcNtOrgCodeRateLinkById(String wcNtOrgCodeRateLinkId) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		queryAdvisor.addWhereClause("link_id = '"+wcNtOrgCodeRateLinkId+"'");
		queryAdvisor.addWhereClause("is_active = 'Y'");
		return (WcNtOrgCodeRateLink)selectAllToDto(queryAdvisor, new WcNtOrgCodeRateLink());
	}
}