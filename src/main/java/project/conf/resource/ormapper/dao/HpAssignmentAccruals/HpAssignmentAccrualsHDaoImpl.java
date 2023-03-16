/**************************************************************************************************
 * Framework Generated HDAOImpl Source
 * - HP_ASSIGNMENT_ACCRUALS - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.HpAssignmentAccruals;

import project.common.extend.BaseHDao;
import zebra.data.DataSet;
import zebra.data.QueryAdvisor;

public class HpAssignmentAccrualsHDaoImpl extends BaseHDao implements HpAssignmentAccrualsDao {
	public DataSet getLeaveAccrualsByAssignmentIdForPreview(QueryAdvisor queryAdvisor, String assignmentId) throws Exception {
		queryAdvisor.addVariable("assignmentId", assignmentId);

		return selectAsDataSet(queryAdvisor, "query.HpAssignmentAccruals.getLeaveAccrualsByAssignmentIdForPreview");
	}

	public DataSet getLeaveAccrualsByAssignmentIdForPreview(String assignmentId) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();

		queryAdvisor.addVariable("assignmentId", assignmentId);

		return selectAsDataSet(queryAdvisor, "query.HpAssignmentAccruals.getLeaveAccrualsByAssignmentIdForPreview");
	}
}