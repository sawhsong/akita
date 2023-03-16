package zebra.example.app.framework.commoncode;

import org.springframework.beans.factory.annotation.Autowired;

import zebra.example.common.extend.BaseAction;
import zebra.example.common.module.commoncode.ZebraCommonCodeManager;

public class CommonCodeAction extends BaseAction {
	@Autowired
	private CommonCodeBiz biz;

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
			ZebraCommonCodeManager.reload();
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", this.paramEntity);
		return "ajaxResponse";
	}

	public String doDelete() throws Exception {
		try {
			biz.doDelete(paramEntity);
			ZebraCommonCodeManager.reload();
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