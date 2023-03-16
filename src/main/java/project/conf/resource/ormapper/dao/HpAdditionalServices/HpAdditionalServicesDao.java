/**************************************************************************************************
 * Framework Generated DAO Source
 * - HP_ADDITIONAL_SERVICES - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.HpAdditionalServices;

import zebra.base.IDao;
import zebra.data.DataSet;
import zebra.data.QueryAdvisor;

public interface HpAdditionalServicesDao extends IDao {
	public DataSet getAdditionalServiceByPersonId(QueryAdvisor queryAdvisor, String personId) throws Exception;
}