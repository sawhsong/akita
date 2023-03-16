/**************************************************************************************************
 * Framework Generated HDAOImpl Source
 * - HP_NEXT_ACTIONS - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.HpNextActions;

import project.common.extend.BaseHDao;
import zebra.data.DataSet;
import zebra.data.QueryAdvisor;
import zebra.util.ConfigUtil;

public class HpNextActionsHDaoImpl extends BaseHDao implements HpNextActionsDao {
	public DataSet getNextActionsForNextActionsListByPersonId(QueryAdvisor queryAdvisor, String personId) throws Exception {
		DataSet dsRequest = queryAdvisor.getRequestDataSet();
		String dateFormat = ConfigUtil.getProperty("format.date.java");
		String actionStatus = dsRequest.getValue("actionStatus");

		queryAdvisor.addVariable("dateFormat", dateFormat);
		queryAdvisor.addVariable("personId", personId);
		queryAdvisor.addAutoFillCriteria(actionStatus, "hna.action_status = '"+actionStatus+"'");

		return selectAsDataSet(queryAdvisor, "query.HpNextActions.getNextActionsForNextActionsListByPersonId");
	}
}