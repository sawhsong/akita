package zebra.example.app.framework.checkdto;

import java.io.File;
import java.lang.reflect.Field;

import org.springframework.beans.factory.annotation.Autowired;

import zebra.config.MemoryBean;
import zebra.data.DataSet;
import zebra.data.ParamEntity;
import zebra.data.QueryAdvisor;
import zebra.example.common.extend.BaseBiz;
import zebra.example.conf.resource.ormapper.dao.Dummy.DummyDao;
import zebra.exception.FrameworkException;
import zebra.util.CommonUtil;
import zebra.util.ConfigUtil;

public class CheckDtoBizImpl extends BaseBiz implements CheckDtoBiz {
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

	public ParamEntity getList(ParamEntity paramEntity) throws Exception {
		DataSet requestDataSet = paramEntity.getRequestDataSet();
		QueryAdvisor queryAdvisor = paramEntity.getQueryAdvisor();
		String defaultDbUser = ConfigUtil.getProperty("jdbc.user.name");
		String dataSource = CommonUtil.nvl(requestDataSet.getValue("dataSource"), defaultDbUser);
		DataSet tableList, dtoList;

		try {
			queryAdvisor.setRequestDataSet(requestDataSet);

			if (!CommonUtil.equalsIgnoreCase(dataSource, defaultDbUser)) {
				dummyDao.setDataSourceName(dataSource);
				tableList = dummyDao.getTableListDataSetByCriteriaForAdditionalDataSource(queryAdvisor);
			} else {
				dummyDao.resetDataSourceName();
				tableList = dummyDao.getTableListDataSetByCriteria(queryAdvisor);
			}

			dtoList = getDtoList(requestDataSet);
			setDataSetValues(tableList, dtoList, requestDataSet);

			paramEntity.setAjaxResponseDataSet(tableList);
			paramEntity.setTotalResultRows(queryAdvisor.getTotalResultRows());
			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}

		return paramEntity;
	}

	public ParamEntity getColumns(ParamEntity paramEntity) throws Exception {
		DataSet requestDataSet = paramEntity.getRequestDataSet();
		String defaultDbUser = ConfigUtil.getProperty("jdbc.user.name");
		String dataSource = CommonUtil.nvl(requestDataSet.getValue("dataSource"), defaultDbUser);
		String tableName = requestDataSet.getValue("tableName");
		String className = requestDataSet.getValue("className");
		DataSet tableDetail, dtoDetail = new DataSet(new String[] {"COLUMN_NAME", "IS_CHECKED"}), columnList = new DataSet(new String[] {"TABLE_COLUMN", "DTO_COLUMN"});

		try {
			Class<?> cls = Class.forName(className);
			Field fields[] = cls.getDeclaredFields();

			if (!CommonUtil.equalsIgnoreCase(dataSource, defaultDbUser)) {
				dummyDao.setDataSourceName(dataSource);
				tableDetail = dummyDao.getTableDetailDataSetByTableNameForAdditionalDataSource(tableName);
			} else {
				dummyDao.resetDataSourceName();
				tableDetail = dummyDao.getTableDetailDataSetByTableName(tableName);
			}

			for (Field field : fields) {
				String fieldName = field.getName();
				if (CommonUtil.isUpperCaseWithNumeric(CommonUtil.remove(fieldName, "_"))) {
					dtoDetail.addRow();
					dtoDetail.setValue(dtoDetail.getRowCnt()-1, "COLUMN_NAME", fieldName);
				}
			}

			for (int i=0; i<tableDetail.getRowCnt(); i++) {
				String colName = tableDetail.getValue(i, "COLUMN_NAME");

				columnList.addRow();
				columnList.setValue(columnList.getRowCnt()-1, "TABLE_COLUMN", colName);

				for (int j=0; j<dtoDetail.getRowCnt(); j++) {
					String dtoColName = dtoDetail.getValue(j, "COLUMN_NAME");
					if (CommonUtil.equals(colName, dtoColName)) {
						dtoDetail.setValue(j, "IS_CHECKED", "Y");
						columnList.setValue(columnList.getRowCnt()-1, "DTO_COLUMN", CommonUtil.toCamelCaseStartLowerCase(dtoColName));
						break;
					}
				}
			}

			for (int i=0; i<dtoDetail.getRowCnt(); i++) {
				String isChecked = dtoDetail.getValue(i, "IS_CHECKED");
				if (!CommonUtil.equals(isChecked, "Y")) {
					columnList.addRow();
					columnList.setValue(columnList.getRowCnt()-1, "DTO_COLUMN", CommonUtil.toCamelCaseStartLowerCase(dtoDetail.getValue(i, "COLUMN_NAME")));
				}
			}

			paramEntity.setAjaxResponseDataSet(columnList);
			paramEntity.setTotalResultRows(columnList.getRowCnt());
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

	private DataSet getDtoList(DataSet requestDataSet) throws Exception {
		DataSet ds = new DataSet(new String[] {"dtoName", "className"});
		String defaultDbUser = ConfigUtil.getProperty("jdbc.user.name");
		String dataSource = CommonUtil.nvl(requestDataSet.getValue("dataSource"), defaultDbUser);
		String pathSeparator = System.getProperty("file.separator");
		String compilePath = "/target/alpaca";
		String rootPath = CommonUtil.remove((String)MemoryBean.get("applicationRealPath"), compilePath);
		String pathToRemove = CommonUtil.replace(rootPath+"src/main/java/", "/", pathSeparator);
		String dbVendor = CommonUtil.lowerCase(ConfigUtil.getProperty("db.vendor"));
		String dtoProject = CommonUtil.replace(ConfigUtil.getProperty("path.common.dtoProject"), "#DB_VENDOR#", dbVendor);
		String dtoFramework = CommonUtil.replace(ConfigUtil.getProperty("path.common.dtoFwk"), "#DB_VENDOR#", dbVendor);
		String path = "";
		File files[];

		if (!CommonUtil.equalsIgnoreCase(dataSource, defaultDbUser)) {
			path = rootPath + dtoProject;
		} else {
			path = rootPath + dtoFramework;

			files = new File(path).listFiles();
			for (File file : files) {
				String dtoName = CommonUtil.removeString(file.getName(), ".java");
				String className = CommonUtil.replace(CommonUtil.removeString(file.getPath(), pathToRemove, ".java"), pathSeparator, ".");

				if (!CommonUtil.contains(dtoName, "Dummy")) {
					ds.addRow();
					ds.setValue(ds.getRowCnt()-1, "dtoName", dtoName);
					ds.setValue(ds.getRowCnt()-1, "className", className);
				}
			}

			path = rootPath + dtoProject;
		}

		files = new File(path).listFiles();
		for (File file : files) {
			String dtoName = CommonUtil.removeString(file.getName(), ".java");
			String className = CommonUtil.replace(CommonUtil.removeString(file.getPath(), pathToRemove, ".java"), pathSeparator, ".");

			if (!CommonUtil.contains(dtoName, "Dummy")) {
				ds.addRow();
				ds.setValue(ds.getRowCnt()-1, "dtoName", dtoName);
				ds.setValue(ds.getRowCnt()-1, "className", className);
			}
		}

		return ds;
	}

	private void setDataSetValues(DataSet tableList, DataSet dtoList, DataSet requestDataSet) throws Exception {
		String defaultDbUser = ConfigUtil.getProperty("jdbc.user.name");
		String dataSource = CommonUtil.nvl(requestDataSet.getValue("dataSource"), defaultDbUser);
		DataSet tableDetail;

		tableList.addColumn("DTO_NAME");
		tableList.addColumn("CLASS_NAME");
		tableList.addColumn("IS_DIFFERENT");

		for (int i=0; i<tableList.getRowCnt(); i++) {
			String tableName = tableList.getValue(i, "TABLE_NAME");
			String tableNameCamelCase = CommonUtil.toCamelCase(tableName);

			for (int j=0; j<dtoList.getRowCnt(); j++) {
				String dtoName = dtoList.getValue(j, "dtoName");
				if (CommonUtil.equals(tableNameCamelCase, dtoName)) {
					tableList.setValue(i, "DTO_NAME", dtoName);
					tableList.setValue(i, "CLASS_NAME", dtoList.getValue(j, "className"));
					break;
				}
			}
		}

		if (!CommonUtil.equalsIgnoreCase(dataSource, defaultDbUser)) {
			dummyDao.setDataSourceName(dataSource);
			tableDetail = dummyDao.getTableDetailDataSetForAdditionalDataSource();
		} else {
			dummyDao.resetDataSourceName();
			tableDetail = dummyDao.getTableDetailDataSet();
		}

		for (int i=0; i<tableList.getRowCnt(); i++) {
			String tableName = tableList.getValue(i, "TABLE_NAME");
			String className = tableList.getValue(i, "CLASS_NAME");

			if (CommonUtil.isNotBlank(className)) {
				int tblIndex = tableDetail.getRowIndex("TABLE_NAME", tableName);

				for (int j=tblIndex; j<tableDetail.getRowCnt(); j++) {
					if (CommonUtil.equals(tableName, tableDetail.getValue(j, "TABLE_NAME"))) {
						String colName = tableDetail.getValue(j, "COLUMN_NAME");
						Class<?> cls = Class.forName(className);
						Field fields[] = cls.getDeclaredFields();
						boolean isExist = false;

						for (Field field : fields) {
							if (CommonUtil.equals(colName, field.getName())) {
								isExist = true;
								break;
							}
						}

						if (!isExist) {
							tableList.setValue(i, "IS_DIFFERENT", "Y");
							break;
						} else {
							tableList.setValue(i, "IS_DIFFERENT", "N");
						}
					} else {
						break;
					}
				}
			}
		}
	}
}