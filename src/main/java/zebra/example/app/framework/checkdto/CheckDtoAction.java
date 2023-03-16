package zebra.example.app.framework.checkdto;

import org.springframework.beans.factory.annotation.Autowired;

import zebra.example.common.extend.BaseAction;

public class CheckDtoAction extends BaseAction {
	@Autowired
	private CheckDtoBiz biz;

	public String getDefault() throws Exception {
		biz.getDefault(paramEntity);
		return "list";
	}

	public String getList() throws Exception {
		try {
			biz.getList(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getColumns() throws Exception {
		try {
			biz.getColumns(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}
}