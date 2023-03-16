/**************************************************************************************************
 * Framework Generated DAO Source
 * - HP_COMMS_ORG_LINK - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.HpCommsOrgLink;

import zebra.base.IDao;
import zebra.data.DataSet;

public interface HpCommsOrgLinkDao extends IDao {
	// Organisaion - ContactHistory
	public DataSet getDataSetByContactId(String contactId) throws Exception;
}