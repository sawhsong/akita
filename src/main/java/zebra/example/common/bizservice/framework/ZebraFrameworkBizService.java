package zebra.example.common.bizservice.framework;

import zebra.data.DataSet;

public interface ZebraFrameworkBizService {
	/*!
	 * DTO Generator
	 */
	public boolean generateDto(String systemType, DataSet requestDataSet, DataSet tableInfoDataSet) throws Exception;
	public boolean generateHibernateDtoConfig(String systemType, DataSet requestDataSet, DataSet tableInfoDataSet) throws Exception;
	public boolean generateMybatisDtoMapper(String systemType, DataSet requestDataSet, DataSet tableInfoDataSet) throws Exception;
	public boolean generateMybatisDtoMapperXml(String systemType, DataSet requestDataSet, DataSet tableInfoDataSet) throws Exception;
	public boolean generateDao(String systemType, DataSet requestDataSet, DataSet tableInfoDataSet) throws Exception;
	public boolean generateHDaoImpl(String systemType, DataSet requestDataSet, DataSet tableInfoDataSet) throws Exception;
	public boolean generateDaoImpl(String systemType, DataSet requestDataSet, DataSet tableInfoDataSet) throws Exception;
	public boolean generateDaoMapper(String systemType, DataSet requestDataSet, DataSet tableInfoDataSet) throws Exception;
	public boolean generateDaoSpringConfig(String systemType, DataSet requestDataSet, DataSet tableInfoDataSet) throws Exception;
	public boolean generateHibernateQuery(String systemType, DataSet requestDataSet, DataSet tableInfoDataSet) throws Exception;
	public boolean generateMybatisQuery(String systemType, DataSet requestDataSet, DataSet tableInfoDataSet) throws Exception;
	public void deleteDto(String dtoName) throws Exception;
	public void deleteHibernateDtoConfig(String dtoName) throws Exception;
	public void deleteMybatisDtoMapper(String dtoName) throws Exception;
	public void deleteMybatisDtoMapperXml(String dtoName) throws Exception;
	public void deleteDao(String dtoName) throws Exception;
	public void deleteHDaoImpl(String dtoName) throws Exception;
	public void deleteDaoImpl(String dtoName) throws Exception;
	public void deleteDaoMapper(String dtoName) throws Exception;
	public void deleteDaoPackage(String dtoName) throws Exception;
	public void deleteHibernateQuery(String dtoName) throws Exception;
	public void deleteMybatisQuery(String dtoName) throws Exception;
	public void deleteDaoSpringConfig(String dtoName) throws Exception;

	/*!
	 * Source Generator
	 */
	public boolean createJavaActionN(DataSet requestDataSet) throws Exception;
	public boolean createJavaBizN(DataSet requestDataSet) throws Exception;
	public boolean createJavaBizImplN(DataSet requestDataSet) throws Exception;
	public boolean createJspListN(DataSet requestDataSet) throws Exception;
	public boolean createJspDetailN(DataSet requestDataSet) throws Exception;
	public boolean createJspEditN(DataSet requestDataSet) throws Exception;
	public boolean createJspInsertN(DataSet requestDataSet) throws Exception;
	public boolean createJspUpdateN(DataSet requestDataSet) throws Exception;
	public boolean createConfSpringN(DataSet requestDataSet) throws Exception;
	public boolean createConfStrutsN(DataSet requestDataSet) throws Exception;
	public boolean createMessageFileN(DataSet requestDataSet) throws Exception;

	public boolean createJavaActionC(DataSet requestDataSet) throws Exception;
	public boolean createJavaBizC(DataSet requestDataSet) throws Exception;
	public boolean createJavaBizImplC(DataSet requestDataSet) throws Exception;
	public boolean createJspListC(DataSet requestDataSet) throws Exception;
	public boolean createJspDetailC(DataSet requestDataSet) throws Exception;
	public boolean createJspEditC(DataSet requestDataSet) throws Exception;
	public boolean createJspInsertC(DataSet requestDataSet) throws Exception;
	public boolean createJspUpdateC(DataSet requestDataSet) throws Exception;
	public boolean createConfSpringC(DataSet requestDataSet) throws Exception;
	public boolean createConfStrutsC(DataSet requestDataSet) throws Exception;
	public boolean createMessageFileC(DataSet requestDataSet) throws Exception;

	/*!
	 * Table Creation Script
	 */
	public DataSet getScriptFileDataSet(DataSet requestDataSet) throws Exception;
	public DataSet getScriptFileDetailDataSet(String fileName) throws Exception;
	public int generateScriptFile(DataSet requestDataSet, DataSet tableDetailDataSet) throws Exception;
	public int updateScriptFile(DataSet requestDataSet, DataSet tableDetailDataSet) throws Exception;
	public int deleteTableCreationScriptFile(String fileName) throws Exception;
	public int deleteTableCreationScriptFiles(String fileNames[]) throws Exception;

	/*!
	 * Data Migration
	 */
	public int generateDDLScriptFileForDataMigration(String sourceDb, String targetDb, String tableName) throws Exception;
	public int createTableForDataMigration(String sourceDb, String targetDb, String tableName) throws Exception;
	public int insertDataForDataMigration(String sourceDb, String targetDb, String tableName) throws Exception;

	/*!
	 * Common for this service
	 */
}