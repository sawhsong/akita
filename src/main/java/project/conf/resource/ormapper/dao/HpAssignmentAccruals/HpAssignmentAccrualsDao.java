/**************************************************************************************************
 * Framework Generated DAO Source
 * - HP_ASSIGNMENT_ACCRUALS - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.HpAssignmentAccruals;

import zebra.base.IDao;
import zebra.data.DataSet;
import zebra.data.QueryAdvisor;

public interface HpAssignmentAccrualsDao extends IDao {
	public DataSet getLeaveAccrualsByAssignmentIdForPreview(QueryAdvisor queryAdvisor, String assignmentId) throws Exception;
	public DataSet getLeaveAccrualsByAssignmentIdForPreview(String assignmentId) throws Exception;
}