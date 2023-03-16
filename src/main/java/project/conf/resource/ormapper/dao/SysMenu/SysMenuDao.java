package project.conf.resource.ormapper.dao.SysMenu;

import project.conf.resource.ormapper.dto.oracle.SysMenu;
import zebra.base.IDao;
import zebra.data.DataSet;
import zebra.data.QueryAdvisor;

public interface SysMenuDao extends IDao {
	/**
	 * Create new SysMenu entry
	 */
	public int insert(SysMenu sysMenu) throws Exception;
	/**
	 * Update SysMenu by Id
	 */
	public int update(String sysMenuId, SysMenu sysMenu) throws Exception;
	/**
	 * Update menu sort order
	 */
	public int updateSortOrder(String sysMenuId, SysMenu sysMenu) throws Exception;
	/**
	 * Delete SysMenu record by Id array
	 */
	public int delete(String[] sysMenuIds) throws Exception;
	/**
	 * Delete SysMenu record by Id
	 */
	public int delete(String sysMenuId) throws Exception;
	/**
	 * Being used by MenuManager
	 */
	public DataSet getAllActiveMenu() throws Exception;
	/**
	 * Being used by MenuManager
	 */
	public DataSet getAllActiveQuickMenu() throws Exception;
	/**
	 * Get all active menu by criteria except QuickMenu - used by SourceGenerator
	 */
	public DataSet getAllActiveMenuDataSetBySearchCriteria(QueryAdvisor queryAdvisor) throws Exception;
	/**
	 * Get all menu dataset by criteria
	 */
	public DataSet getMenuDataSetBySearchCriteria(QueryAdvisor queryAdvisor) throws Exception;
	/**
	 * Get SysMenu by Id
	 */
	public SysMenu getMenuById(String menuId) throws Exception;
	/**
	 * Get Menu DataSet by Id
	 */
	public DataSet getMenuDataSetById(String menuId) throws Exception;
}