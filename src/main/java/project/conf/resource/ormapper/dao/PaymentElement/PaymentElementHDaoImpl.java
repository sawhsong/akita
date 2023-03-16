/**************************************************************************************************
 * Framework Generated HDAOImpl Source
 * - PAYMENT_ELEMENT - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.PaymentElement;

import project.common.extend.BaseHDao;
import project.conf.resource.ormapper.dto.oracle.PaymentElement;
import zebra.data.DataSet;
import zebra.data.QueryAdvisor;
import zebra.util.CommonUtil;

public class PaymentElementHDaoImpl extends BaseHDao implements PaymentElementDao {
	public DataSet getPaymentElement(QueryAdvisor queryAdvisor, String paymentId) throws Exception {
		queryAdvisor.addWhereClause("payment_id = '"+paymentId+"'");
		return selectAllAsDataSet(queryAdvisor, new PaymentElement());
	}

	public DataSet getPaymentElement(String paymentId) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		queryAdvisor.addWhereClause("payment_id = '"+paymentId+"'");
		return selectAllAsDataSet(queryAdvisor, new PaymentElement());
	}

	public DataSet getPaymentElementByElementIds(QueryAdvisor queryAdvisor, String paymentId, String... elementIds) throws Exception {
		queryAdvisor.addWhereClause("payment_id = '"+paymentId+"'");
		if (elementIds != null && elementIds.length > 0) {
			String str = "";
			for (String id : elementIds) {
				str += (CommonUtil.isBlank(str)) ? "'"+id+"'" : ", '"+id+"'";
			}
			queryAdvisor.addWhereClause("element_id in ("+str+")");
		}
		return selectAllAsDataSet(queryAdvisor, new PaymentElement());
	}

	public DataSet getPaymentElementByElementIds(String paymentId, String... elementIds) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		queryAdvisor.addWhereClause("payment_id = '"+paymentId+"'");
		if (elementIds != null && elementIds.length > 0) {
			String str = "";
			for (String id : elementIds) {
				str += (CommonUtil.isBlank(str)) ? "'"+id+"'" : ", '"+id+"'";
			}
			queryAdvisor.addWhereClause("element_id in ("+str+")");
		}
		return selectAllAsDataSet(queryAdvisor, new PaymentElement());
	}

	public PaymentElement getPaymentElementByElementId(QueryAdvisor queryAdvisor, String paymentId, String elementId) throws Exception {
		queryAdvisor.addWhereClause("payment_id = '"+paymentId+"'");
		queryAdvisor.addWhereClause("element_id = '"+elementId+"'");
		return (PaymentElement)selectAllToDto(queryAdvisor, new PaymentElement());
	}

	public PaymentElement getPaymentElementByElementId(String paymentId, String elementId) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		queryAdvisor.addWhereClause("payment_id = '"+paymentId+"'");
		queryAdvisor.addWhereClause("element_id = '"+elementId+"'");
		return (PaymentElement)selectAllToDto(queryAdvisor, new PaymentElement());
	}
}