/**************************************************************************************************
 * Framework Generated DAO Source
 * - HP_ADDRESS_CONTACT_D - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.HpAddressContactD;

import project.conf.resource.ormapper.dto.oracle.HpAddressContactD;
import zebra.base.IDao;

public interface HpAddressContactDDao extends IDao {
	public HpAddressContactD getAddressContactByPersonId(String personId) throws Exception;
	public String getPreferredEmailByPersonId(String personId) throws Exception;
}