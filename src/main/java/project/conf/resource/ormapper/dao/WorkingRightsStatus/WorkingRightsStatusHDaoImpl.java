/**************************************************************************************************
 * Framework Generated HDAOImpl Source
 * - WORKING_RIGHTS_STATUS - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.WorkingRightsStatus;

import project.common.extend.BaseHDao;
import zebra.data.DataSet;
import zebra.data.QueryAdvisor;
import zebra.util.ConfigUtil;

public class WorkingRightsStatusHDaoImpl extends BaseHDao implements WorkingRightsStatusDao {
	public DataSet getWorkingRightsStatusListByPersonId(QueryAdvisor queryAdvisor, String personId) throws Exception {
		String dateFormat = ConfigUtil.getProperty("format.date.java");

		queryAdvisor.addVariable("dateFormat", dateFormat);
		queryAdvisor.addVariable("personId", personId);

		return selectAsDataSet(queryAdvisor, "query.WorkingRightsStatus.getWorkingRightsStatusListByPersonId");
	}
}