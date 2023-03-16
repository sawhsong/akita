/**************************************************************************************************
 * Framework Generated DAO Source
 * - HP_INVOICE - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.HpInvoice;

import project.conf.resource.ormapper.dto.oracle.HpInvoice;
import zebra.base.IDao;
import zebra.data.DataSet;
import zebra.data.QueryAdvisor;

public interface HpInvoiceDao extends IDao {
	public int updateInvoiceByColumn(QueryAdvisor queryAdvisor, HpInvoice hpInvoice) throws Exception;
	public DataSet getInvoiceList(QueryAdvisor queryAdvisor) throws Exception;
	public HpInvoice getByInvoiceId(String invoiceId) throws Exception;
}