package zebra.example.app.framework.datamigration;

import org.springframework.beans.factory.annotation.Autowired;

import zebra.data.DataSet;
import zebra.data.ParamEntity;
import zebra.data.QueryAdvisor;
import zebra.example.common.bizservice.framework.ZebraFrameworkBizService;
import zebra.example.common.extend.BaseBiz;
import zebra.example.conf.resource.ormapper.dao.Dummy.DummyDao;
import zebra.exception.FrameworkException;
import zebra.util.CommonUtil;
import zebra.util.ConfigUtil;

public class DataMigrationBizImpl extends BaseBiz implements DataMigrationBiz {
	@Autowired
	private ZebraFrameworkBizService zebraFrameworkBizService;
	@Autowired
	private DummyDao dummyDao;

	public ParamEntity getDefault(ParamEntity paramEntity) throws Exception {
		String dataSourceNames[] = CommonUtil.split(ConfigUtil.getProperty("jdbc.multipleDatasource"), ConfigUtil.getProperty("delimiter.data"));

		try {
			paramEntity.setObject("datasourceDataSet", getDatasourceDataSet(dataSourceNames));
			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}

		return paramEntity;
	}

	public ParamEntity getTableList(ParamEntity paramEntity) throws Exception {
		DataSet requestDataSet = paramEntity.getRequestDataSet();
		QueryAdvisor queryAdvisor = paramEntity.getQueryAdvisor();
		String defaultDbUser = ConfigUtil.getProperty("jdbc.user.name");
		String dataSource = CommonUtil.nvl(requestDataSet.getValue("dataSource"), defaultDbUser);

		try {
			queryAdvisor.setRequestDataSet(requestDataSet);

			if (!CommonUtil.equalsIgnoreCase(dataSource, defaultDbUser)) {
				dummyDao.setDataSourceName(dataSource);
				paramEntity.setAjaxResponseDataSet(dummyDao.getTableListDataSetByCriteriaForAdditionalDataSource(queryAdvisor));
			} else {
				dummyDao.resetDataSourceName();
				paramEntity.setAjaxResponseDataSet(dummyDao.getTableListDataSetByCriteria(queryAdvisor));
			}

			paramEntity.setTotalResultRows(queryAdvisor.getTotalResultRows());
			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}

		return paramEntity;
	}

	public ParamEntity getDetail(ParamEntity paramEntity) throws Exception {
		DataSet requestDataSet = paramEntity.getRequestDataSet();
		String defaultDbUser = ConfigUtil.getProperty("jdbc.user.name");
		String dataSource = CommonUtil.nvl(requestDataSet.getValue("dataSource"), defaultDbUser);
		String tableName = requestDataSet.getValue("tableName");

		try {
			if (!CommonUtil.equalsIgnoreCase(dataSource, defaultDbUser)) {
				dummyDao.setDataSourceName(dataSource);
				paramEntity.setObject("resultDataSet", dummyDao.getTableDetailDataSetByTableNameForAdditionalDataSource(tableName));
				paramEntity.setObject("totalRowCount", dummyDao.getTotalRowCountByTableNameForAdditionalDataSource(tableName));
			} else {
				dummyDao.resetDataSourceName();
				paramEntity.setObject("resultDataSet", dummyDao.getTableDetailDataSetByTableName(tableName));
				paramEntity.setObject("totalRowCount", dummyDao.getTotalRowCountByTableName(tableName));
			}

			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}

	public ParamEntity doGenerateFile(ParamEntity paramEntity) throws Exception {
		DataSet requestDataSet = paramEntity.getRequestDataSet();
		String tableName = requestDataSet.getValue("tableName");
		String sourceDb = requestDataSet.getValue("sourceDb");
		String targetDb = requestDataSet.getValue("targetDb");

		try {
			zebraFrameworkBizService.generateDDLScriptFileForDataMigration(sourceDb, targetDb, tableName);

			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}

	public ParamEntity doCreateTable(ParamEntity paramEntity) throws Exception {
		DataSet requestDataSet = paramEntity.getRequestDataSet();
		String tableName = requestDataSet.getValue("tableName");
		String sourceDb = requestDataSet.getValue("sourceDb");
		String targetDb = requestDataSet.getValue("targetDb");

		try {
			zebraFrameworkBizService.createTableForDataMigration(sourceDb, targetDb, tableName);

			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}

	public ParamEntity doInsertData(ParamEntity paramEntity) throws Exception {
		DataSet requestDataSet = paramEntity.getRequestDataSet();
		String tableName = requestDataSet.getValue("tableName");
		String sourceDb = requestDataSet.getValue("sourceDb");
		String targetDb = requestDataSet.getValue("targetDb");

		try {
			zebraFrameworkBizService.insertDataForDataMigration(sourceDb, targetDb, tableName);

			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}

	private DataSet getDatasourceDataSet(String[] dataSourceNames) throws Exception {
		DataSet dataSourceDataSet = new DataSet();

		dataSourceDataSet.addName(new String[] {"VALUE", "NAME"});
		for (int i=0; i<dataSourceNames.length; i++) {
			dataSourceDataSet.addRow();
			dataSourceDataSet.setValue(i, "VALUE", dataSourceNames[i]);
			dataSourceDataSet.setValue(i, "NAME", dataSourceNames[i]);
		}

		return dataSourceDataSet;
	}
}