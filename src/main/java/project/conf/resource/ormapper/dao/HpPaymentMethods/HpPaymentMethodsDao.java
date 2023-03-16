/**************************************************************************************************
 * Framework Generated DAO Source
 * - HP_PAYMENT_METHODS - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.HpPaymentMethods;

import zebra.base.IDao;
import zebra.data.DataSet;
import zebra.data.QueryAdvisor;

public interface HpPaymentMethodsDao extends IDao {
	public DataSet getPaymentMethodForAutoCompletion(QueryAdvisor queryAdvisor) throws Exception;
}