/**************************************************************************************************
 * Framework Generated DAO Source
 * - SYS_FAVORITE_MENU - Favorite menu by user
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.SysFavoriteMenu;

import zebra.base.Dto;
import zebra.base.IDao;
import zebra.data.DataSet;

public interface SysFavoriteMenuDao extends IDao {
	public int insert(Dto dto) throws Exception;
	public int delete(String userId, String[] menuIds) throws Exception;
	public DataSet getDataSetByUserId(String userId) throws Exception;
}