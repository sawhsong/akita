/**************************************************************************************************
 * Framework Generated DAO Source
 * - HP_ASSIGNMENT_RATES - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.HpAssignmentRates;

import zebra.base.IDao;
import zebra.data.DataSet;

public interface HpAssignmentRatesDao extends IDao {
	public DataSet getDataSetByAssignmentId(String assignmentId) throws Exception;
}