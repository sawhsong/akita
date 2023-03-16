/**************************************************************************************************
 * Framework Generated DAO Source
 * - EO_EXPENSE - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.EoExpense;

import project.conf.resource.ormapper.dto.oracle.EoExpense;
import zebra.base.IDao;

public interface EoExpenseDao extends IDao {
	public int updateStatusByIds(String eoExpenseIds[], EoExpense eoExpense) throws Exception;
}