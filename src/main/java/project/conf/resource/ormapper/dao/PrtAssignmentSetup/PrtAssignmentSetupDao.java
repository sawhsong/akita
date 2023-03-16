/**************************************************************************************************
 * Framework Generated DAO Source
 * - PRT_ASSIGNMENT_SETUP - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.PrtAssignmentSetup;

import zebra.base.IDao;
import zebra.data.DataSet;

public interface PrtAssignmentSetupDao extends IDao {
	public DataSet getByAssignmentId(String assignmentId) throws Exception;
	public DataSet getByAssignmentIdsForUnlockPrt(String assignmentIds[]) throws Exception;
	public DataSet getLatestDataSetByAssignmentId(String assignmentId) throws Exception;
	public int deleteByAssignmentId(String assignmentId) throws Exception;
	public int deleteByAssignmentIds(String assignmentIds[]) throws Exception;
}