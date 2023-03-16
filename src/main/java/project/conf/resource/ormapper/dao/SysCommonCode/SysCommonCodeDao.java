package project.conf.resource.ormapper.dao.SysCommonCode;

import zebra.base.Dto;
import zebra.base.IDao;
import zebra.data.DataSet;
import zebra.data.QueryAdvisor;

public interface SysCommonCodeDao extends IDao {
	/**
	 * Get all active code type
	 */
	public DataSet getActiveCodeTypeDataSetLikeCodeType(String codeType) throws Exception;
	/**
	 * Insert new CommonCode record
	 */
	public int insert(Dto dto) throws Exception;
	/**
	 * Delete CommonCode record by CodeType array
	 */
	public int delete(String[] codeTypes) throws Exception;
	/**
	 * Delete CommonCode record by CodeType
	 */
	public int delete(String codeType) throws Exception;
	/**
	 * Get all active common code
	 */
	public DataSet getAllActiveCommonCode() throws Exception;
	/**
	 * Get all active code type
	 */
	public DataSet getActiveCodeTypeDataSet() throws Exception;
	/**
	 * Get all active common code list excluding code_type
	 */
	public DataSet getActiveCommonCodeDataSet(QueryAdvisor queryAdvisor) throws Exception;
	/**
	 * Get common code list by CommonCodeType
	 */
	public DataSet getCommonCodeDataSetByCodeType(String codeType) throws Exception;
}