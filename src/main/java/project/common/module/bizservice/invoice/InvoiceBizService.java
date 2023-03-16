package project.common.module.bizservice.invoice;

import project.conf.resource.ormapper.dto.oracle.HpInvoice;
import zebra.data.DataSet;
import zebra.data.QueryAdvisor;

public interface InvoiceBizService {
	public DataSet getInvoiceList(QueryAdvisor queryAdvisor) throws Exception;
	public HpInvoice getInvoiceByInvoiceId(QueryAdvisor queryAdvisor, String invoiceId) throws Exception;
	public int updateStatus(QueryAdvisor queryAdvisor, String invoiceIds[], String toStatus) throws Exception;
	public int updateInvoiceSubTotal(QueryAdvisor queryAdvisor, String invoiceId, String toGstAmount) throws Exception;
}