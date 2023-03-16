/**************************************************************************************************
 * Framework Generated HDAOImpl Source
 * - WC_NT_CODE_RATE - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.WcNtCodeRate;

import project.common.extend.BaseHDao;
import project.conf.resource.ormapper.dto.oracle.WcNtCodeRate;
import zebra.data.QueryAdvisor;

public class WcNtCodeRateHDaoImpl extends BaseHDao implements WcNtCodeRateDao {
	public WcNtCodeRate getWcNtCodeRateById(String wcNtCodeRateId) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		queryAdvisor.addWhereClause("code_rate_id = '"+wcNtCodeRateId+"'");
		queryAdvisor.addWhereClause("is_active = 'Y'");
		return (WcNtCodeRate)selectAllToDto(queryAdvisor, new WcNtCodeRate());
	}
}