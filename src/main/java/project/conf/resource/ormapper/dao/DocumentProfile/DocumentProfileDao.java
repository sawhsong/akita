/**************************************************************************************************
 * Framework Generated DAO Source
 * - DOCUMENT_PROFILE - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.DocumentProfile;

import zebra.base.IDao;
import zebra.data.DataSet;

public interface DocumentProfileDao extends IDao {
	public DataSet getProfileForSelectbox() throws Exception;
	public String getProfileHtmlStringForSelectbox(String attributes) throws Exception;
}