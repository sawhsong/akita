/**************************************************************************************************
 * project
 * Description - SysCommonCode - Common Code
 *	- Generated by Source Generator
 *************************************************************************************************/
package project.app.sys.sysBasicInfo.sysCommonCode;

import zebra.data.ParamEntity;

public interface SysCommonCodeBiz {
	public ParamEntity getDefault(ParamEntity paramEntity) throws Exception;
	public ParamEntity getList(ParamEntity paramEntity) throws Exception;
	public ParamEntity getEdit(ParamEntity paramEntity) throws Exception;
	public ParamEntity getMasterData(ParamEntity paramEntity) throws Exception;
	public ParamEntity getDetailData(ParamEntity paramEntity) throws Exception;
	public ParamEntity doSave(ParamEntity paramEntity) throws Exception;
	public ParamEntity doDelete(ParamEntity paramEntity) throws Exception;
	public ParamEntity doExport(ParamEntity paramEntity) throws Exception;
}