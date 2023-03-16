/**************************************************************************************************
 * project
 * Description - SysDbSessionMonitor - Databse Session Monitor
 *	- Generated by Source Generator
 *************************************************************************************************/
package project.app.sys.sysItSupport.sysDbSessionMonitor;

import org.springframework.beans.factory.annotation.Autowired;

import project.common.extend.BaseAction;

public class SysDbSessionMonitorAction extends BaseAction {
	@Autowired
	private SysDbSessionMonitorBiz biz;

	public String getDefault() throws Exception {
		biz.getDefault(paramEntity);
		return "list";
	}

	public String doSearch() throws Exception {
		try {
			biz.doSearch(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getSql() throws Exception {
		biz.getSql(paramEntity);
		return "sqlText";
	}

	public String getSqlText() throws Exception {
		try {
			biz.getSqlText(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String exeKillSessions() throws Exception {
		try {
			biz.exeKillSessions(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}
}