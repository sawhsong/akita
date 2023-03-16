/**************************************************************************************************
 * Framework Generated DAO Source
 * - HP_BALANCE_LINES - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.HpBalanceLines;

import zebra.base.IDao;
import zebra.data.DataSet;
import zebra.data.QueryAdvisor;

public interface HpBalanceLinesDao extends IDao {
	public DataSet getByElementId(QueryAdvisor queryAdvisor, String paymentId, String elementId) throws Exception;
	public DataSet getByElementId(String paymentId, String elementId) throws Exception;
	public DataSet getByElementIds(QueryAdvisor queryAdvisor, String paymentId, String... elementIds) throws Exception;
	public DataSet getByElementIds(String paymentId, String... elementIds) throws Exception;
}