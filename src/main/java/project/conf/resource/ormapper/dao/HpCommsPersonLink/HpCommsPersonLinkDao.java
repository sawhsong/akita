/**************************************************************************************************
 * Framework Generated DAO Source
 * - HP_COMMS_PERSON_LINK - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.HpCommsPersonLink;

import zebra.base.IDao;
import zebra.data.DataSet;

public interface HpCommsPersonLinkDao extends IDao {
	// Organisaion - ContactHistory
	public DataSet getDataSetByContactId(String contactId) throws Exception;
}