/**************************************************************************************************
 * Framework Generated DAO Source
 * - ASG_DELIVERABLES_RATES - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.AsgDeliverablesRates;

import zebra.base.IDao;
import zebra.data.DataSet;

public interface AsgDeliverablesRatesDao extends IDao {
	public DataSet getDataSetByAssignmentId(String assignmentId) throws Exception;
}