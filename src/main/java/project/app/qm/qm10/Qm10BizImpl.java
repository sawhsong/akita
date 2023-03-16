/**************************************************************************************************
 * project
 * Description - Qm10 - Select Database
 *	- Generated by Source Generator
 *************************************************************************************************/
package project.app.qm.qm10;

import project.common.extend.BaseBiz;
import zebra.data.ParamEntity;
import zebra.exception.FrameworkException;

public class Qm10BizImpl extends BaseBiz implements Qm10Biz {
	public ParamEntity getDefault(ParamEntity paramEntity) throws Exception {
		try {
			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}

	public ParamEntity exeSave(ParamEntity paramEntity) throws Exception {
		try {
			paramEntity.setSuccess(true);
			paramEntity.setMessage("I801", getMessage("I801", paramEntity));
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}
}