/**************************************************************************************************
 * Framework Generated HDAOImpl Source
 * - HP_BALANCE_LINES - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.HpBalanceLines;

import project.common.extend.BaseHDao;
import project.conf.resource.ormapper.dto.oracle.HpBalanceLines;
import zebra.data.DataSet;
import zebra.data.QueryAdvisor;
import zebra.util.CommonUtil;

public class HpBalanceLinesHDaoImpl extends BaseHDao implements HpBalanceLinesDao {
	public DataSet getByElementId(QueryAdvisor queryAdvisor, String paymentId, String elementId) throws Exception {
		queryAdvisor.addWhereClause("payment_id = '"+paymentId+"'");
		queryAdvisor.addWhereClause("element_id = '"+elementId+"'");
		return selectAllAsDataSet(queryAdvisor, new HpBalanceLines());
	}

	public DataSet getByElementId(String paymentId, String elementId) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();

		queryAdvisor.addWhereClause("payment_id = '"+paymentId+"'");
		queryAdvisor.addWhereClause("element_id = '"+elementId+"'");
		return selectAllAsDataSet(queryAdvisor, new HpBalanceLines());
	}

	public DataSet getByElementIds(QueryAdvisor queryAdvisor, String paymentId, String... elementIds) throws Exception {
		queryAdvisor.addWhereClause("payment_id = '"+paymentId+"'");
		if (elementIds != null && elementIds.length > 0) {
			String str = "";
			for (String id : elementIds) {
				str += (CommonUtil.isBlank(str)) ? "'"+id+"'" : ", '"+id+"'";
			}
			queryAdvisor.addWhereClause("element_id in ("+str+")");
		}
		return selectAllAsDataSet(queryAdvisor, new HpBalanceLines());
	}

	public DataSet getByElementIds(String paymentId, String... elementIds) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();

		queryAdvisor.addWhereClause("payment_id = '"+paymentId+"'");
		if (elementIds != null && elementIds.length > 0) {
			String str = "";
			for (String id : elementIds) {
				str += (CommonUtil.isBlank(str)) ? "'"+id+"'" : ", '"+id+"'";
			}
			queryAdvisor.addWhereClause("element_id in ("+str+")");
		}
		return selectAllAsDataSet(queryAdvisor, new HpBalanceLines());
	}
}