package zebra.example.app.framework.datamigration;

import org.springframework.beans.factory.annotation.Autowired;

import zebra.example.common.extend.BaseAction;

public class DataMigrationAction extends BaseAction {
	@Autowired
	private DataMigrationBiz biz;

	public String getDefault() throws Exception {
		biz.getDefault(paramEntity);
		return "list";
	}

	public String getTableList() throws Exception {
		try {
			biz.getTableList(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getDetail() throws Exception {
		biz.getDetail(paramEntity);
		return "detail";
	}

	public String doGenerateFile() throws Exception {
		try {
			biz.doGenerateFile(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String doCreateTable() throws Exception {
		try {
			biz.doCreateTable(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String doInsertData() throws Exception {
		try {
			biz.doInsertData(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}
}