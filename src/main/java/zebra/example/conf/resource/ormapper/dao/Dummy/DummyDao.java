package zebra.example.conf.resource.ormapper.dao.Dummy;

import zebra.base.IDao;
import zebra.data.DataSet;
import zebra.data.QueryAdvisor;

public interface DummyDao extends IDao {
	/*!
	 * Key
	 */
	public DataSet getIdBySequenceName(String sequeceName) throws Exception;

	public DataSet getTableListDataSetByCriteria(QueryAdvisor queryAdvisor) throws Exception;
	public DataSet getTableListDataSetByCriteriaForAdditionalDataSource(QueryAdvisor queryAdvisor) throws Exception;
	public DataSet getTableDetailDataSet() throws Exception;
	public DataSet getTableDetailDataSetForAdditionalDataSource() throws Exception;
	public DataSet getTableDetailDataSetByTableName(String tableName) throws Exception;
	public DataSet getTableDetailDataSetByTableNameForAdditionalDataSource(String tableName) throws Exception;
	public DataSet getDataSetBySQLQuery(String sqlQuery) throws Exception;
	public DataSet getTableNameDataSetByTableName(String tableName) throws Exception;
	public int getTotalRowCountByTableName(String tableName) throws Exception;
	public int getTotalRowCountByTableNameForAdditionalDataSource(String tableName) throws Exception;

	public int exeGenerateTable(String sql) throws Exception;
	public int runScript(String sql) throws Exception;

	public boolean isTableCreated(String tableName) throws Exception;
	public boolean isTableCreatedForAdditionalDataSource(String tableName) throws Exception;
	public boolean isDbLinkCreated(String dbLinkName) throws Exception;
}