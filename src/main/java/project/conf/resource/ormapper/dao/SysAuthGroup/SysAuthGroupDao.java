package project.conf.resource.ormapper.dao.SysAuthGroup;

import project.conf.resource.ormapper.dto.oracle.SysAuthGroup;
import zebra.base.IDao;
import zebra.data.DataSet;
import zebra.data.QueryAdvisor;

public interface SysAuthGroupDao extends IDao {
	/**
	 * Save SysAuthGroup record
	 */
	public int save(String groupId, SysAuthGroup sysAuthGroup) throws Exception;
	/**
	 * Create a new SysAuthGroup record
	 */
	public int insert(SysAuthGroup sysAuthGroup) throws Exception;
	/**
	 * Update SysAuthGroup by Id
	 */
	public int update(String groupId, SysAuthGroup sysAuthGroup) throws Exception;
	/**
	 * Delete SysAuthGroup record by Id array
	 */
	public int delete(String[] groupIds) throws Exception;
	/**
	 * Delete SysAuthGroup record by Id
	 */
	public int delete(String groupId) throws Exception;
	/**
	 * Get AuthGroup DataSet by Id - used by DataHelper
	 */
	public DataSet getAuthGroupDataSetById(QueryAdvisor queryAdvisor) throws Exception;
	/**
	 * Get AuthGroup DataSet by search crigeria
	 */
	public DataSet getAuthGroupDataSetBySearchCriteria(QueryAdvisor queryAdvisor) throws Exception;
	/**
	 * Get SysAuthGroup by Id
	 */
	public SysAuthGroup getAuthGroupById(String groupId) throws Exception;
	/**
	 * Get all AuthGroup DataSet with no condition
	 */
	public DataSet getAllAuthGroupDataSet(QueryAdvisor queryAdvisor) throws Exception;
}