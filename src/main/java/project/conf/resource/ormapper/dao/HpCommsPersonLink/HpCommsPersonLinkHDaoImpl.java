/**************************************************************************************************
 * Framework Generated HDAOImpl Source
 * - HP_COMMS_PERSON_LINK - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.HpCommsPersonLink;

import project.common.extend.BaseHDao;
import zebra.data.DataSet;
import zebra.data.QueryAdvisor;
import zebra.util.ConfigUtil;

public class HpCommsPersonLinkHDaoImpl extends BaseHDao implements HpCommsPersonLinkDao {
	public DataSet getDataSetByContactId(String contactId) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		String dateFormat = ConfigUtil.getProperty("format.date.java");

		queryAdvisor.addVariable("dateFormat", dateFormat);
		queryAdvisor.addVariable("contactId", contactId);

		return selectAsDataSet(queryAdvisor, "query.HpCommsPersonLink.getDataSetByContactId");
	}
}