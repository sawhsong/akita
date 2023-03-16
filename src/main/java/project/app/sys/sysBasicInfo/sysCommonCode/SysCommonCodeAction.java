/**************************************************************************************************
 * project
 * Description - SysCommonCode - Common Code
 *	- Generated by Source Generator
 *************************************************************************************************/
package project.app.sys.sysBasicInfo.sysCommonCode;

import org.springframework.beans.factory.annotation.Autowired;

import project.common.extend.BaseAction;
import project.common.module.commoncode.CommonCodeManager;

public class SysCommonCodeAction extends BaseAction {
	@Autowired
	private SysCommonCodeBiz biz;

	public String getDefault() throws Exception {
		biz.getDefault(paramEntity);
		return "list";
	}

	public String getList() throws Exception {
		try {
			biz.getList(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", this.paramEntity);
		return "ajaxResponse";
	}

	public String getEdit() throws Exception {
		biz.getEdit(paramEntity);
		return "edit";
	}

	public String getMasterData() throws Exception {
		try {
			biz.getMasterData(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", this.paramEntity);
		return "ajaxResponse";
	}

	public String getDetailData() throws Exception {
		try {
			biz.getDetailData(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", this.paramEntity);
		return "ajaxResponse";
	}

	public String doSave() throws Exception {
		try {
			biz.doSave(paramEntity);
			CommonCodeManager.reload();
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", this.paramEntity);
		return "ajaxResponse";
	}

	public String doDelete() throws Exception {
		try {
			biz.doDelete(paramEntity);
			CommonCodeManager.reload();
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", this.paramEntity);
		return "ajaxResponse";
	}

	public String doExport() throws Exception {
		biz.doExport(paramEntity);
		setRequestAttribute("paramEntity", paramEntity);
		return "export";
	}
}