package project.conf.resource.ormapper.dao.SysBoardFile;

import project.conf.resource.ormapper.dto.oracle.SysBoard;
import project.conf.resource.ormapper.dto.oracle.SysBoardFile;
import zebra.base.IDao;
import zebra.data.DataSet;

public interface SysBoardFileDao extends IDao {
	/**
	 * Insert new SysBoardFile record
	 * @param sysBoard(SysBoard with all properties set)
	 * @param fileDataSet(RequestFileDataSet - generated by framework)
	 * @param isSaveFileFlag
	 * @return int
	 * @throws Exception
	 */
	public int insert(SysBoard sysBoard, DataSet fileDataSet, String isSaveFileFlag) throws Exception;
	/**
	 * Update SysBoardFile record(Insert new file record and delete file records with fileIds)
	 * @param sysBoard(SysBoard with all properties set)
	 * @param fileDataSet(RequestFileDataSet - generated by framework)
	 * @param isSaveFileFlag
	 * @param fileIds
	 * @return int
	 * @throws Exception
	 */
	public int update(SysBoard sysBoard, DataSet fileDataSet, String isSaveFileFlag, String[] fileIds) throws Exception;
	/**
	 * Delete SysBoardFile record by FileId array
	 * @param fileIds
	 * @return int
	 * @throws Exception
	 */
	public int delete(String[] fileIds) throws Exception;
	/**
	 * Delete SysBoardFile record by a FileId
	 * @param fileId
	 * @return
	 * @throws Exception
	 */
	public int delete(String fileId) throws Exception;
	/**
	 * Delete SysBoardFile record by a ArticleId
	 * @param articleId
	 * @return int
	 * @throws Exception
	 */
	public int deleteByArticleId(String articleId) throws Exception;
	/**
	 * Get SysBoardFile list DataSet by ArticleId
	 * @param articleId
	 * @return DataSet
	 * @throws Exception
	 */
	public DataSet getBoardFileListDataSetByArticleId(String articleId) throws Exception;
	/**
	 * Get SysBoardFile by FileId
	 * @param fileId
	 * @return SysBoardFile
	 * @throws Exception
	 */
	public SysBoardFile getBoardFileById(String fileId) throws Exception;
}