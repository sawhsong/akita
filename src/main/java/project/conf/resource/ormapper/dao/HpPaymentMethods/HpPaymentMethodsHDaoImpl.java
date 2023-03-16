/**************************************************************************************************
 * Framework Generated HDAOImpl Source
 * - HP_PAYMENT_METHODS - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.HpPaymentMethods;

import project.common.extend.BaseHDao;
import zebra.data.DataSet;
import zebra.data.QueryAdvisor;

public class HpPaymentMethodsHDaoImpl extends BaseHDao implements HpPaymentMethodsDao {
	public DataSet getPaymentMethodForAutoCompletion(QueryAdvisor queryAdvisor) throws Exception {
		return selectAsDataSet(queryAdvisor, "query.HpPaymentMethods.getPaymentMethodForAutoCompletion");
	}
}