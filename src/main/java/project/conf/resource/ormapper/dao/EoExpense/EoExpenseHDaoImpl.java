/**************************************************************************************************
 * Framework Generated HDAOImpl Source
 * - EO_EXPENSE - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.EoExpense;

import project.common.extend.BaseHDao;
import project.conf.resource.ormapper.dto.oracle.EoExpense;
import zebra.data.QueryAdvisor;
import zebra.util.CommonUtil;

public class EoExpenseHDaoImpl extends BaseHDao implements EoExpenseDao {
	public int updateStatusByIds(String eoExpenseIds[], EoExpense eoExpense) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		String ids = "";

		for (String id : eoExpenseIds) {
			if (CommonUtil.isBlank(id)) {continue;}

			ids += (CommonUtil.isBlank(ids)) ? "'"+id+"'" : ", "+"'"+id+"'";
		}

		queryAdvisor.addWhereClause("eo_expense_id in ("+ids+")");
		return updateColumns(queryAdvisor, eoExpense);
	}
}