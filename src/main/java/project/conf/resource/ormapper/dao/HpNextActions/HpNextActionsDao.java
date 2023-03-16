/**************************************************************************************************
 * Framework Generated DAO Source
 * - HP_NEXT_ACTIONS - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.HpNextActions;

import zebra.base.IDao;
import zebra.data.DataSet;
import zebra.data.QueryAdvisor;

public interface HpNextActionsDao extends IDao {
	public DataSet getNextActionsForNextActionsListByPersonId(QueryAdvisor queryAdvisor, String personId) throws Exception;
}