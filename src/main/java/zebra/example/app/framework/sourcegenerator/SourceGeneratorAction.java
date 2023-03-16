package zebra.example.app.framework.sourcegenerator;

import org.springframework.beans.factory.annotation.Autowired;

import zebra.example.common.extend.BaseAction;
import zebra.util.CommonUtil;
import zebra.util.ConfigUtil;

public class SourceGeneratorAction extends BaseAction {
	@Autowired
	private SourceGeneratorBiz biz;

	public String getDefault() throws Exception {
		biz.getDefault(paramEntity);
		if (CommonUtil.equalsIgnoreCase(ConfigUtil.getProperty("type.menuCreationType"), "Name")) {
			return "listN";
		} else {
			return "listC";
		}
	}

	public String getList() throws Exception {
		try {
			biz.getList(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getGeneratorInfo() throws Exception {
		biz.getGeneratorInfo(paramEntity);
		return "info";
	}

	public String exeGenerate() throws Exception {
		try {
			if (CommonUtil.equalsIgnoreCase(ConfigUtil.getProperty("type.menuCreationType"), "Name")) {
				biz.exeGenerateN(paramEntity);
			} else {
				biz.exeGenerateC(paramEntity);
			}
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}
}