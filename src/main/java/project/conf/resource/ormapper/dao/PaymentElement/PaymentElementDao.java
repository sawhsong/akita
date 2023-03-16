/**************************************************************************************************
 * Framework Generated DAO Source
 * - PAYMENT_ELEMENT - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.PaymentElement;

import project.conf.resource.ormapper.dto.oracle.PaymentElement;
import zebra.base.IDao;
import zebra.data.DataSet;
import zebra.data.QueryAdvisor;

public interface PaymentElementDao extends IDao {
	public DataSet getPaymentElement(QueryAdvisor queryAdvisor, String paymentId) throws Exception;
	public DataSet getPaymentElement(String paymentId) throws Exception;
	public DataSet getPaymentElementByElementIds(QueryAdvisor queryAdvisor, String paymentId, String... elementIds) throws Exception;
	public DataSet getPaymentElementByElementIds(String paymentId, String... elementIds) throws Exception;
	public PaymentElement getPaymentElementByElementId(QueryAdvisor queryAdvisor, String paymentId, String elementId) throws Exception;
	public PaymentElement getPaymentElementByElementId(String paymentId, String elementId) throws Exception;
}