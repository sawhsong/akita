/**************************************************************************************************
 * Framework Generated HDAOImpl Source
 * - HP_ADDITIONAL_SERVICES - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.HpAdditionalServices;

import project.common.extend.BaseHDao;
import zebra.data.DataSet;
import zebra.data.QueryAdvisor;
import zebra.util.ConfigUtil;

public class HpAdditionalServicesHDaoImpl extends BaseHDao implements HpAdditionalServicesDao {
	public DataSet getAdditionalServiceByPersonId(QueryAdvisor queryAdvisor, String personId) throws Exception {
		String dateFormat = ConfigUtil.getProperty("format.date.java");

		queryAdvisor.addVariable("dateFormat", dateFormat);
		queryAdvisor.addVariable("personId", personId);

		return selectAsDataSet(queryAdvisor, "query.HpAdditionalServices.getAdditionalServiceByPersonId");
	}
}