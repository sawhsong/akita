/**************************************************************************************************
 * Framework Generated HDAOImpl Source
 * - HP_INVOICE - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.HpInvoice;

import project.common.extend.BaseHDao;
import project.conf.resource.ormapper.dto.oracle.HpInvoice;
import zebra.data.DataSet;
import zebra.data.QueryAdvisor;

public class HpInvoiceHDaoImpl extends BaseHDao implements HpInvoiceDao {
	public int updateInvoiceByColumn(QueryAdvisor queryAdvisor, HpInvoice hpInvoice) throws Exception {
		return updateColumns(queryAdvisor, hpInvoice);
	}

	public DataSet getInvoiceList(QueryAdvisor queryAdvisor) throws Exception {
		return selectAsDataSet(queryAdvisor, "query.HpInvoice.getInvoiceList");
	}

	public HpInvoice getByInvoiceId(String invoiceId) throws Exception {
		QueryAdvisor qa = new QueryAdvisor();
		qa.addWhereClause("invoice_id = '"+invoiceId+"'");
		return (HpInvoice)selectAllToDto(qa, new HpInvoice());
	}
}