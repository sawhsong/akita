/**************************************************************************************************
 * Framework Generated HDAOImpl Source
 * - HP_COMMS_ORG_LINK - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.HpCommsOrgLink;

import project.common.extend.BaseHDao;
import zebra.data.DataSet;
import zebra.data.QueryAdvisor;
import zebra.util.ConfigUtil;

public class HpCommsOrgLinkHDaoImpl extends BaseHDao implements HpCommsOrgLinkDao {
	public DataSet getDataSetByContactId(String contactId) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		String dateFormat = ConfigUtil.getProperty("format.date.java");

		queryAdvisor.addVariable("dateFormat", dateFormat);
		queryAdvisor.addVariable("contactId", contactId);

		return selectAsDataSet(queryAdvisor, "query.HpCommsOrgLink.getDataSetByContactId");
	}
}