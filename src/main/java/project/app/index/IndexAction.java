/**************************************************************************************************
 * Project
 * Description
 * - Project Main Index
 *************************************************************************************************/
package project.app.index;

import org.springframework.beans.factory.annotation.Autowired;

import project.common.extend.BaseAction;

public class IndexAction extends BaseAction {
	@Autowired
	private IndexBiz biz;

	public String index() throws Exception {
		biz.index(paramEntity);
		return SUCCESS;
	}

	public String dashboard() throws Exception {
		biz.dashboard(paramEntity);
		return "dashboard";
	}

	public String getNoticeList() throws Exception {
		try {
			biz.getNoticeList(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getFreeBoardList() throws Exception {
		try {
			biz.getFreeBoardList(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}
}