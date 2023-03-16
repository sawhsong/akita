/**************************************************************************************************
 * Framework Generated HDAOImpl Source
 * - SYS_FAVORITE_MENU - Favorite menu by user
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.SysFavoriteMenu;

import project.common.extend.BaseHDao;
import project.conf.resource.ormapper.dto.oracle.SysFavoriteMenu;
import zebra.base.Dto;
import zebra.data.DataSet;
import zebra.data.QueryAdvisor;
import zebra.util.CommonUtil;

public class SysFavoriteMenuHDaoImpl extends BaseHDao implements SysFavoriteMenuDao {
	public int insert(Dto dto) throws Exception {
		return insertWithSQLQuery(dto);
	}

	public int delete(String userId, String[] menuIds) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		String ids = "";

		for (String id : menuIds) {
			ids += CommonUtil.isBlank(ids) ? "'"+id+"'" : ", "+"'"+id+"'";
		}

		queryAdvisor.addWhereClause("user_id = '"+userId+"'");
		queryAdvisor.addWhereClause("menu_id in ("+ids+")");
		return deleteWithSQLQuery(queryAdvisor, new SysFavoriteMenu());
	}

	public DataSet getDataSetByUserId(String userId) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();

		queryAdvisor.addVariable("userId", userId);

		return selectAsDataSet(queryAdvisor, "query.SysFavoriteMenu.getDataSetByUserId");
	}
}