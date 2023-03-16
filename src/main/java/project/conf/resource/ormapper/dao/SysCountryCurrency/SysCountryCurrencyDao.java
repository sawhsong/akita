package project.conf.resource.ormapper.dao.SysCountryCurrency;

import project.conf.resource.ormapper.dto.oracle.SysCountryCurrency;
import zebra.base.IDao;
import zebra.data.DataSet;
import zebra.data.QueryAdvisor;

public interface SysCountryCurrencyDao extends IDao {
	/**
	 * Save SysCountryCurrency record
	 */
	public int save(String countryCurrencyId, SysCountryCurrency sysCountryCurrency) throws Exception;
	/**
	 * Insert new SysCountryCurrency record
	 */
	public int insert(SysCountryCurrency sysCountryCurrency) throws Exception;
	/**
	 * Update new SysCountryCurrency record
	 */
	public int update(String countryCurrencyId, SysCountryCurrency sysCountryCurrency) throws Exception;
	/**
	 * Delete SysCountryCurrency record by Id array
	 */
	public int delete(String[] countryCurrencyIds) throws Exception;
	/**
	 * Delete SysCountryCurrency record by Id
	 */
	public int delete(String countryCurrencyId) throws Exception;
	/**
	 * Get CurrencyCode dataset by search criteria(AutoCompletion)
	 */
	public DataSet getCurrencyCodeDataSetForAutoCompletion(QueryAdvisor queryAdvisor) throws Exception;
	/**
	 * Get CountryName dataset by search criteria(AutoCompletion)
	 */
	public DataSet getCountryNameDataSetForAutoCompletion(QueryAdvisor queryAdvisor) throws Exception;
	/**
	 * Get CountryCurrency list dataset by search criteria in QueryAdvisor
	 */
	public DataSet getCountryCurrencyDataSetBySearchCriteria(QueryAdvisor queryAdvisor) throws Exception;
	/**
	 * Get SysCountryCurrency by Id
	 */
	public SysCountryCurrency getCountryCurrencyById(String countryCurrencyId) throws Exception;
	/**
	 * Get CountryCurrency list dataset by Id
	 */
	public DataSet getCountryCurrencyDataSetById(String countryCurrencyId) throws Exception;
}