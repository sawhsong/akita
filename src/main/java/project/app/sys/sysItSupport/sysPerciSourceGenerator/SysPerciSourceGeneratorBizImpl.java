/**************************************************************************************************
 * project
 * Description - SysPerciSourceGenerator - PERCI Source Generator
 *	- Generated by Source Generator
 *************************************************************************************************/
package project.app.sys.sysItSupport.sysPerciSourceGenerator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;

import project.common.extend.BaseBiz;
import project.conf.resource.ormapper.dao.ProjectDummy.ProjectDummyDao;
import zebra.data.DataSet;
import zebra.data.ParamEntity;
import zebra.data.QueryAdvisor;
import zebra.exception.FrameworkException;
import zebra.util.CommonUtil;
import zebra.util.ConfigUtil;
import zebra.util.FileUtil;

public class SysPerciSourceGeneratorBizImpl extends BaseBiz implements SysPerciSourceGeneratorBiz {
	@Autowired
	private ProjectDummyDao dummyDao;

	public ParamEntity getDefault(ParamEntity paramEntity) throws Exception {
		DataSet requestDataSet = paramEntity.getRequestDataSet();
		QueryAdvisor queryAdvisor = paramEntity.getQueryAdvisor();
		String dataSourceNames[] = CommonUtil.split(ConfigUtil.getProperty("jdbc.multipleDatasource"), ConfigUtil.getProperty("delimiter.data"));

		try {
			queryAdvisor.setRequestDataSet(requestDataSet);

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
		String defaultDataSourceUser = ConfigUtil.getProperty("jdbc.user.name");
		String dataSource = CommonUtil.nvl(requestDataSet.getValue("dataSource"), defaultDataSourceUser);

		try {
			queryAdvisor.setRequestDataSet(requestDataSet);
			queryAdvisor.setPagination(false);

			if (!CommonUtil.equalsIgnoreCase(dataSource, defaultDataSourceUser)) {
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
		String defaultDataSourceUser = ConfigUtil.getProperty("jdbc.user.name");
		String dataSource = CommonUtil.nvl(requestDataSet.getValue("dataSource"), defaultDataSourceUser);
		String tableName = requestDataSet.getValue("tableName");

		try {
			if (!CommonUtil.equalsIgnoreCase(dataSource, defaultDataSourceUser)) {
				dummyDao.setDataSourceName(dataSource);
				paramEntity.setObject("resultDataSet", dummyDao.getTableDetailDataSetByTableNameForAdditionalDataSource(tableName));
			} else {
				dummyDao.resetDataSourceName();
				paramEntity.setObject("resultDataSet", dummyDao.getTableDetailDataSetByTableName(tableName));
			}

			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}

		return paramEntity;
	}

	public ParamEntity getGeneratorInfo(ParamEntity paramEntity) throws Exception {
		try {
			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}

		return paramEntity;
	}

	public ParamEntity exeGenerate(ParamEntity paramEntity) throws Exception {
		DataSet dsRequest = paramEntity.getRequestDataSet();
		DataSet tableInfoDataSet;

		String tableName = dsRequest.getValue("tableName");
		String defaultDataSourceUser = ConfigUtil.getProperty("jdbc.user.name");
		String dataSource = CommonUtil.nvl(dsRequest.getValue("dataSource"), defaultDataSourceUser);

		boolean strategyBuilder = CommonUtil.toBoolean(CommonUtil.nvl(dsRequest.getValue("strategyBuilder"), "N"));
		boolean dao = CommonUtil.toBoolean(CommonUtil.nvl(dsRequest.getValue("dao"), "N"));
		boolean dtoAbstract = CommonUtil.toBoolean(CommonUtil.nvl(dsRequest.getValue("dtoAbstract"), "N"));
		boolean dtoFnd = CommonUtil.toBoolean(CommonUtil.nvl(dsRequest.getValue("dtoFnd"), "N"));

		try {
			if (!CommonUtil.equalsIgnoreCase(dataSource, defaultDataSourceUser)) {
				dummyDao.setDataSourceName(dataSource);
			} else {
				dummyDao.resetDataSourceName();
			}

			tableInfoDataSet = dummyDao.getTableDetailDataSetByTableName(tableName);

			if (strategyBuilder) {
				generateStrategyBuilder(dsRequest, tableInfoDataSet);
			}

			if (dao) {
				generateDao(dsRequest, tableInfoDataSet);
			}

			if (dtoAbstract) {
				generateAbs(dsRequest, tableInfoDataSet);
			}

			if (dtoFnd) {
				generateFnd(dsRequest, tableInfoDataSet);
			}

			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}

		return paramEntity;
	}

	public boolean generateStrategyBuilder(DataSet dsRequest, DataSet tableInfoDataSet) throws Exception {
		String packageName = CommonUtil.lowerCase(dsRequest.getValue("packageName"));
		String destinationFolder = dsRequest.getValue("destinationFolder");
		String tableName = dsRequest.getValue("tableName");

		String singleSourcePath = "C:/projectRepository/PerciSource/StrategyBuilderModule.src";
		String collectionSourcePath = "C:/projectRepository/PerciSource/CollectionStrategyBuilderModule.src";
		String targetPath = destinationFolder+"/config";
		String tempString, sourceString, packageString, fndPackage, daoPackage, primaryKey;

		BufferedReader bufferedReader = null;
		StringBuffer stringBuffer = null;
		OutputStreamWriter osWriter = null;

		File singleFile, collectionFile;

		try {
			FileUtil.createFolder(targetPath);

			if (!CommonUtil.contains(packageName, "com.es.")) {
				packageName = "com.es."+packageName;
			}

			packageString = packageName+".config";
			fndPackage = packageName+".dto.fnd";
			daoPackage = packageName+".dao";
			primaryKey = tableInfoDataSet.getValue(tableInfoDataSet.getRowIndex("CONSTRAINT_TYPE", "PK"), "COLUMN_NAME");

			/*!
			 * Single
			 */
			singleFile = new File(targetPath+"/"+CommonUtil.toCamelCase(tableName)+"StrategyBuilderModule.java");
			createEmptyFile(singleFile);

			bufferedReader = new BufferedReader(new FileReader(singleSourcePath));
			stringBuffer = new StringBuffer();
			while ((tempString = bufferedReader.readLine()) != null) {
				stringBuffer.append(tempString+"\n");
			}
			osWriter = new OutputStreamWriter(new FileOutputStream(singleFile, true), "utf-8");
			sourceString = CommonUtil.removeEnd(stringBuffer.toString(), "\n");

			sourceString = CommonUtil.replace(sourceString, "#PACKAGE_STRING#", packageString);
			sourceString = CommonUtil.replace(sourceString, "#TABLE_NAME_CAMELCASE#", CommonUtil.toCamelCaseStartUpperCase(tableName));
			sourceString = CommonUtil.replace(sourceString, "#FND_PACKAGE#", fndPackage);
			sourceString = CommonUtil.replace(sourceString, "#DAO_PACKAGE#", daoPackage);
			sourceString = CommonUtil.replace(sourceString, "#PRIMARY_KEY#", primaryKey);
			sourceString = CommonUtil.replace(sourceString, "#TABLE_NAME#", tableName);

			osWriter.write(sourceString);
			osWriter.flush();
			osWriter.close();
			bufferedReader.close();

			/*!
			 * Collection
			 */
			collectionFile = new File(targetPath+"/"+CommonUtil.toCamelCase(tableName)+"CollectionStrategyBuilderModule.java");
			createEmptyFile(collectionFile);

			bufferedReader = new BufferedReader(new FileReader(collectionSourcePath));
			stringBuffer = new StringBuffer();
			while ((tempString = bufferedReader.readLine()) != null) {
				stringBuffer.append(tempString+"\n");
			}
			osWriter = new OutputStreamWriter(new FileOutputStream(collectionFile, true), "utf-8");
			sourceString = CommonUtil.removeEnd(stringBuffer.toString(), "\n");

			sourceString = CommonUtil.replace(sourceString, "#PACKAGE_STRING#", packageString);
			sourceString = CommonUtil.replace(sourceString, "#TABLE_NAME_CAMELCASE#", CommonUtil.toCamelCaseStartUpperCase(tableName));
			sourceString = CommonUtil.replace(sourceString, "#FND_PACKAGE#", fndPackage);
			sourceString = CommonUtil.replace(sourceString, "#DAO_PACKAGE#", daoPackage);
			sourceString = CommonUtil.replace(sourceString, "#PRIMARY_KEY#", primaryKey);
			sourceString = CommonUtil.replace(sourceString, "#TABLE_NAME#", tableName);

			osWriter.write(sourceString);
			osWriter.flush();
			osWriter.close();
			bufferedReader.close();

			return true;
		} catch (Exception ex) {
			throw new FrameworkException(ex);
		}
	}

	public boolean generateDao(DataSet dsRequest, DataSet tableInfoDataSet) throws Exception {
		String packageName = CommonUtil.lowerCase(dsRequest.getValue("packageName"));
		String destinationFolder = dsRequest.getValue("destinationFolder");
		String tableName = dsRequest.getValue("tableName");

		String hbmSourcePath = "C:/projectRepository/PerciSource/Hbm.src";
		String singleSourcePath = "C:/projectRepository/PerciSource/DBHandler.src";
		String collectionSourcePath = "C:/projectRepository/PerciSource/CollectionDBHandler.src";
		String targetPath = destinationFolder+"/dao";
		String tempString, sourceString, packageString, fndPackage, primaryKeyColumn = "", columns = "";

		BufferedReader bufferedReader = null;
		StringBuffer stringBuffer = null;
		OutputStreamWriter osWriter = null;

		File hbmFile, singleFile, collectionFile;

		try {
			FileUtil.createFolder(targetPath);

			if (!CommonUtil.contains(packageName, "com.es.")) {
				packageName = "com.es."+packageName;
			}

			packageString = packageName+".dao";
			fndPackage = packageName+".dto.fnd";

			/*!
			 * HBM
			 */
			hbmFile = new File(targetPath+"/"+CommonUtil.toCamelCase(tableName)+".hbm.xml");
			createEmptyFile(hbmFile);

			bufferedReader = new BufferedReader(new FileReader(hbmSourcePath));
			stringBuffer = new StringBuffer();
			while ((tempString = bufferedReader.readLine()) != null) {
				stringBuffer.append(tempString+"\n");
			}
			osWriter = new OutputStreamWriter(new FileOutputStream(hbmFile, true), "utf-8");
			sourceString = CommonUtil.removeEnd(stringBuffer.toString(), "\n");

			for (int i=0; i<tableInfoDataSet.getRowCnt(); i++) {
				String dataType = tableInfoDataSet.getValue(i, "DATA_TYPE");
				String colName = tableInfoDataSet.getValue(i, "COLUMN_NAME");
				String colNameLowerCamelCase = CommonUtil.toCamelCaseStartLowerCase(tableInfoDataSet.getValue(i, "COLUMN_NAME"));

				if (CommonUtil.containsIgnoreCase(tableInfoDataSet.getValue(i, "CONSTRAINT_TYPE"), "PK")) {
					primaryKeyColumn += "<id name=\""+colNameLowerCamelCase+"\" column=\""+colName+"\" type=\"java.lang.Long\">\n";
					primaryKeyColumn += "\t\t\t<generator class=\"sequence-identity\">\n";
					primaryKeyColumn += "\t\t\t\t<param name=\"sequence\">"+tableName+"_S</param>\n";
					primaryKeyColumn += "\t\t\t</generator>\n";
					primaryKeyColumn += "\t\t</id>\n";
				} else {
					columns += (CommonUtil.isBlank(columns) ? "" : "\t\t");
					columns += "<property name=\""+colNameLowerCamelCase+"\" column=\""+colName+"\"";
					columns += " type=\""+getXmlTypeProperty(colName, dataType)+"\"";
					columns += "/>";
					columns += (i == tableInfoDataSet.getRowCnt()-1) ? "" : "\n";
				}
			}

			sourceString = CommonUtil.replace(sourceString, "#FND_PACKAGE#", fndPackage);
			sourceString = CommonUtil.replace(sourceString, "#TABLE_NAME_CAMELCASE#", CommonUtil.toCamelCaseStartUpperCase(tableName));
			sourceString = CommonUtil.replace(sourceString, "#TABLE_NAME#", tableName);
			sourceString = CommonUtil.replace(sourceString, "#PRIMARY_KEY_COLUMN#", primaryKeyColumn);
			sourceString = CommonUtil.replace(sourceString, "#COLUMNS#", columns);

			osWriter.write(sourceString);
			osWriter.flush();
			osWriter.close();
			bufferedReader.close();

			/*!
			 * Single
			 */
			singleFile = new File(targetPath+"/"+CommonUtil.toCamelCase(tableName)+"DBHandler.java");
			createEmptyFile(singleFile);

			bufferedReader = new BufferedReader(new FileReader(singleSourcePath));
			stringBuffer = new StringBuffer();
			while ((tempString = bufferedReader.readLine()) != null) {
				stringBuffer.append(tempString+"\n");
			}
			osWriter = new OutputStreamWriter(new FileOutputStream(singleFile, true), "utf-8");
			sourceString = CommonUtil.removeEnd(stringBuffer.toString(), "\n");

			sourceString = CommonUtil.replace(sourceString, "#PACKAGE_STRING#", packageString);
			sourceString = CommonUtil.replace(sourceString, "#FND_PACKAGE#", fndPackage);
			sourceString = CommonUtil.replace(sourceString, "#TABLE_NAME_CAMELCASE#", CommonUtil.toCamelCaseStartUpperCase(tableName));
			sourceString = CommonUtil.replace(sourceString, "#TABLE_NAME_CAMELCASE_STARTS_LOWER#", CommonUtil.toCamelCaseStartLowerCase(tableName));

			osWriter.write(sourceString);
			osWriter.flush();
			osWriter.close();
			bufferedReader.close();

			/*!
			 * Collection
			 */
			collectionFile = new File(targetPath+"/"+CommonUtil.toCamelCase(tableName)+"CollectionDBHandler.java");
			createEmptyFile(collectionFile);

			bufferedReader = new BufferedReader(new FileReader(collectionSourcePath));
			stringBuffer = new StringBuffer();
			while ((tempString = bufferedReader.readLine()) != null) {
				stringBuffer.append(tempString+"\n");
			}
			osWriter = new OutputStreamWriter(new FileOutputStream(collectionFile, true), "utf-8");
			sourceString = CommonUtil.removeEnd(stringBuffer.toString(), "\n");

			sourceString = CommonUtil.replace(sourceString, "#PACKAGE_STRING#", packageString);
			sourceString = CommonUtil.replace(sourceString, "#FND_PACKAGE#", fndPackage);
			sourceString = CommonUtil.replace(sourceString, "#TABLE_NAME_CAMELCASE#", CommonUtil.toCamelCaseStartUpperCase(tableName));

			osWriter.write(sourceString);
			osWriter.flush();
			osWriter.close();
			bufferedReader.close();

			return true;
		} catch (Exception ex) {
			throw new FrameworkException(ex);
		}
	}

	public boolean generateAbs(DataSet dsRequest, DataSet tableInfoDataSet) throws Exception {
		String packageName = CommonUtil.lowerCase(dsRequest.getValue("packageName"));
		String destinationFolder = dsRequest.getValue("destinationFolder");
		String tableName = dsRequest.getValue("tableName");

		String sourcePath = "C:/projectRepository/PerciSource/Abstract.src";
		String targetPath = destinationFolder+"/dto/abs";
		String tempString, sourceString, packageString, columns = "", accessors = "", setValues = "";

		BufferedReader bufferedReader = null;
		StringBuffer stringBuffer = null;
		OutputStreamWriter osWriter = null;

		File singleFile;

		try {
			FileUtil.createFolder(targetPath);

			if (!CommonUtil.contains(packageName, "com.es.")) {
				packageName = "com.es."+packageName;
			}

			packageString = packageName+".dto.abs";

			/*!
			 * Single
			 */
			singleFile = new File(targetPath+"/Abstract"+CommonUtil.toCamelCase(tableName)+".java");
			createEmptyFile(singleFile);

			bufferedReader = new BufferedReader(new FileReader(sourcePath));
			stringBuffer = new StringBuffer();
			while ((tempString = bufferedReader.readLine()) != null) {
				stringBuffer.append(tempString+"\n");
			}
			osWriter = new OutputStreamWriter(new FileOutputStream(singleFile, true), "utf-8");
			sourceString = CommonUtil.removeEnd(stringBuffer.toString(), "\n");

			for (int i=0; i<tableInfoDataSet.getRowCnt(); i++) {
				String dataType = tableInfoDataSet.getValue(i, "DATA_TYPE");
				String colName = tableInfoDataSet.getValue(i, "COLUMN_NAME");
				String convertedDataType = getDataTypeString(colName, dataType);
				String colNameUpperCamelCase = CommonUtil.toCamelCaseStartUpperCase(tableInfoDataSet.getValue(i, "COLUMN_NAME"));
				String colNameLowerCamelCase = CommonUtil.toCamelCaseStartLowerCase(tableInfoDataSet.getValue(i, "COLUMN_NAME"));

				columns += (CommonUtil.isBlank(columns) ? "" : "\t");
				columns += "private "+convertedDataType+" "+colNameLowerCamelCase+";\n";

				accessors += (CommonUtil.isBlank(accessors) ? "" : "\t");
				accessors += "public "+convertedDataType+" get"+colNameUpperCamelCase+"() {\n";
				accessors += "\t\treturn "+colNameLowerCamelCase+";\n";
				accessors += "\t}\n\n";
				accessors += "\tpublic void set"+colNameUpperCamelCase+"("+convertedDataType+" "+colNameLowerCamelCase+") {\n";
				accessors += "\t\tthis."+colNameLowerCamelCase+" = "+colNameLowerCamelCase+";\n";
				accessors += "\t}\n\n";

				setValues += (CommonUtil.isBlank(setValues) ? "" : "\t\t");
				setValues += "this."+colNameLowerCamelCase+" = source.get"+colNameUpperCamelCase+"();";
				if (i != (tableInfoDataSet.getRowCnt() - 1)) {
					setValues += "\n";
				}
			}

			sourceString = CommonUtil.replace(sourceString, "#PACKAGE_STRING#", packageString);
			sourceString = CommonUtil.replace(sourceString, "#TABLE_NAME_CAMELCASE#", CommonUtil.toCamelCaseStartUpperCase(tableName));
			sourceString = CommonUtil.replace(sourceString, "#COLUMNS#", columns);
			sourceString = CommonUtil.replace(sourceString, "#ACCESSORS#", accessors);
			sourceString = CommonUtil.replace(sourceString, "#SET_VALUES#", setValues);

			osWriter.write(sourceString);
			osWriter.flush();
			osWriter.close();
			bufferedReader.close();

			return true;
		} catch (Exception ex) {
			throw new FrameworkException(ex);
		}
	}

	public boolean generateFnd(DataSet dsRequest, DataSet tableInfoDataSet) throws Exception {
		String packageName = CommonUtil.lowerCase(dsRequest.getValue("packageName"));
		String destinationFolder = dsRequest.getValue("destinationFolder");
		String tableName = dsRequest.getValue("tableName");

		String singleSourcePath = "C:/projectRepository/PerciSource/SingleClass.src";
		String collectionSourcePath = "C:/projectRepository/PerciSource/CollectionClass.src";
		String targetPath = destinationFolder+"/dto/fnd";
		String tempString, sourceString, packageString, configPackage, absPackage = "", toString;

		BufferedReader bufferedReader = null;
		StringBuffer stringBuffer = null;
		OutputStreamWriter osWriter = null;

		File singleFile, collectionFile;

		try {
			FileUtil.createFolder(targetPath);

			if (!CommonUtil.contains(packageName, "com.es.")) {
				packageName = "com.es."+packageName;
			}

			packageString = packageName+".dto.fnd";
			configPackage = packageName+".config";
			absPackage = packageName+".dto.abs";

			/*!
			 * Single
			 */
			singleFile = new File(targetPath+"/"+CommonUtil.toCamelCase(tableName)+".java");
			createEmptyFile(singleFile);

			bufferedReader = new BufferedReader(new FileReader(singleSourcePath));
			stringBuffer = new StringBuffer();
			while ((tempString = bufferedReader.readLine()) != null) {
				stringBuffer.append(tempString+"\n");
			}
			osWriter = new OutputStreamWriter(new FileOutputStream(singleFile, true), "utf-8");
			sourceString = CommonUtil.removeEnd(stringBuffer.toString(), "\n");

			toString = "String str = \"\";\n\n";
			for (int i=0; i<tableInfoDataSet.getRowCnt(); i++) {
				String colNameUpperCamelCase = CommonUtil.toCamelCaseStartUpperCase(tableInfoDataSet.getValue(i, "COLUMN_NAME"));
				String colNameLowerCamelCase = CommonUtil.toCamelCaseStartLowerCase(tableInfoDataSet.getValue(i, "COLUMN_NAME"));

				toString += "\t\tstr += \""+colNameLowerCamelCase+" : \"+get"+colNameUpperCamelCase+"()+\"\\n\";\n";
			}
			toString += "\n\t\treturn str;";

			sourceString = CommonUtil.replace(sourceString, "#PACKAGE_STRING#", packageString);
			sourceString = CommonUtil.replace(sourceString, "#CONFIG_PACKAGE#", configPackage);
			sourceString = CommonUtil.replace(sourceString, "#ABS_PACKAGE#", absPackage);
			sourceString = CommonUtil.replace(sourceString, "#TABLE_NAME_CAMELCASE#", CommonUtil.toCamelCaseStartUpperCase(tableName));
			sourceString = CommonUtil.replace(sourceString, "#TO_STRING#", toString);

			osWriter.write(sourceString);
			osWriter.flush();
			osWriter.close();
			bufferedReader.close();

			/*!
			 * Collection
			 */
			collectionFile = new File(targetPath+"/"+CommonUtil.toCamelCase(tableName)+"Collection.java");
			createEmptyFile(collectionFile);

			bufferedReader = new BufferedReader(new FileReader(collectionSourcePath));
			stringBuffer = new StringBuffer();
			while ((tempString = bufferedReader.readLine()) != null) {
				stringBuffer.append(tempString+"\n");
			}
			osWriter = new OutputStreamWriter(new FileOutputStream(collectionFile, true), "utf-8");
			sourceString = CommonUtil.removeEnd(stringBuffer.toString(), "\n");

			sourceString = CommonUtil.replace(sourceString, "#PACKAGE_STRING#", packageString);
			sourceString = CommonUtil.replace(sourceString, "#CONFIG_PACKAGE#", configPackage);
			sourceString = CommonUtil.replace(sourceString, "#TABLE_NAME_CAMELCASE#", CommonUtil.toCamelCaseStartUpperCase(tableName));

			osWriter.write(sourceString);
			osWriter.flush();
			osWriter.close();
			bufferedReader.close();

			return true;
		} catch (Exception ex) {
			throw new FrameworkException(ex);
		}
	}

	/*!
	 * Private methods
	 */
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

	private void createEmptyFile(File file) throws Exception {
		if (file.exists()) {
			String path = file.getAbsolutePath();
			Path pathSrc = Paths.get(path);
			Path pathTarget = Paths.get(path+".bak");

			Files.move(pathSrc, pathTarget, StandardCopyOption.REPLACE_EXISTING);
		}

		file.createNewFile();
	}

	private String getXmlTypeProperty(String colName, String dataType) {
		if (CommonUtil.equalsIgnoreCase(dataType, "NUMBER")) {
			if (CommonUtil.contains(colName, "ID") || CommonUtil.equals(colName, "CREATED_BY") || CommonUtil.equals(colName, "LAST_UPDATED_BY")) {
				return "java.lang.Long";
			} else {
				return "java.lang.Double";
			}
		} else if (CommonUtil.equalsIgnoreCase(dataType, "DATE")) {
			return "java.util.Date";
		} else {
			return "java.lang.String";
		}
	}

	private String getDataTypeString(String colName, String dataType) {
		if (CommonUtil.equalsIgnoreCase(dataType, "NUMBER")) {
			if (CommonUtil.contains(colName, "ID") || CommonUtil.equals(colName, "CREATED_BY") || CommonUtil.equals(colName, "LAST_UPDATED_BY")) {
				return "Long";
			} else {
				return "Double";
			}
		} else if (CommonUtil.equalsIgnoreCase(dataType, "DATE")) {
			return "Date";
		} else {
			return "String";
		}
	}
}