package zebra.example.conf.resource.ormapper.dao.Dummy;

import zebra.data.DataSet;
import zebra.data.QueryAdvisor;
import zebra.example.common.extend.BaseHDao;
import zebra.util.CommonUtil;

public class DummyHDaoImpl extends BaseHDao implements DummyDao {
	public DataSet getIdBySequenceName(String sequeceName) throws Exception {
		return selectAsDataSetBySQLQuery("select "+sequeceName+".nextval from dual");
	}

	public DataSet getTableListDataSetByCriteria(QueryAdvisor queryAdvisor) throws Exception {
		DataSet requestDataSet = queryAdvisor.getRequestDataSet();
		String tableName = requestDataSet.getValue("tableName");

		queryAdvisor.addAutoFillCriteria(tableName, "upper(table_name) like upper('%"+tableName+"%')");

		return selectAsDataSet(queryAdvisor, "query.zebra.Dummy.getTableListDataSetByCriteria");
	}

	public DataSet getTableListDataSetByCriteriaForAdditionalDataSource(QueryAdvisor queryAdvisor) throws Exception {
		DataSet requestDataSet = queryAdvisor.getRequestDataSet();
		String tableName = requestDataSet.getValue("tableName");

		queryAdvisor.addAutoFillCriteria(tableName, "upper(table_name) like upper('%"+tableName+"%')");

		return selectAsDataSet(queryAdvisor, "query.zebra.Dummy.getTableListDataSetByCriteriaForAdditionalDataSource");
	}

	public DataSet getTableDetailDataSet() throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		return selectAsDataSet(queryAdvisor, "query.zebra.Dummy.getTableDetailDataSet");
	}

	public DataSet getTableDetailDataSetForAdditionalDataSource() throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		return selectAsDataSet(queryAdvisor, "query.zebra.Dummy.getTableDetailDataSetForAdditionalDataSource");
	}

	public DataSet getTableDetailDataSetByTableName(String tableName) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		queryAdvisor.addVariable("table_name", tableName);
		return selectAsDataSet(queryAdvisor, "query.zebra.Dummy.getTableDetailDataSetByTableName");
	}

	public DataSet getTableDetailDataSetByTableNameForAdditionalDataSource(String tableName) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		queryAdvisor.addVariable("table_name", tableName);
		return selectAsDataSet(queryAdvisor, "query.zebra.Dummy.getTableDetailDataSetByTableNameForAdditionalDataSource");
	}

	public DataSet getDataSetBySQLQuery(String sqlQuery) throws Exception {
		return selectAsDataSetBySQLQuery(sqlQuery);
	}

	public DataSet getTableNameDataSetByTableName(String tableName) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();

		queryAdvisor.addAutoFillCriteria(tableName, "upper(table_name) like upper('%"+tableName+"%')");

		return selectAsDataSet(queryAdvisor, "query.zebra.Dummy.getTableNameDataSetByTableName");
	}

	public int getTotalRowCountByTableName(String tableName) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		queryAdvisor.addVariable("table_name", tableName);
		return CommonUtil.toInt(selectAsDataSet(queryAdvisor, "query.zebra.Dummy.getTotalRowCountByTableName").getValue(0, 0));
	}

	public int getTotalRowCountByTableNameForAdditionalDataSource(String tableName) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		queryAdvisor.addVariable("table_name", tableName);
		return CommonUtil.toInt(selectAsDataSet(queryAdvisor, "query.zebra.Dummy.getTotalRowCountByTableNameForAdditionalDataSource").getValue(0, 0));
	}

	public boolean isTableCreated(String tableName) throws Exception {
		try {
			getTotalRowCountByTableName(tableName);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isTableCreatedForAdditionalDataSource(String tableName) throws Exception {
		try {
			getTotalRowCountByTableNameForAdditionalDataSource(tableName);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isDbLinkCreated(String dbLinkName) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		DataSet ds;

		try {
			queryAdvisor.addVariable("dbLinkName", dbLinkName);
			ds = selectAsDataSet(queryAdvisor, "query.zebra.Dummy.getDatabaseLinkDataSet");

			if (ds != null && ds.getRowCnt() > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	public int exeGenerateTable(String sql) throws Exception {
		return executeSql(sql);
	}

	public int runScript(String sql) throws Exception {
		return executeSql(sql);
	}
}