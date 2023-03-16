/**************************************************************************************************
 * project
 * Description - Qm30 - Find Organisation
 *	- Generated by Source Generator
 *************************************************************************************************/
package project.app.qm.qm30;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import project.common.extend.BaseBiz;
import project.conf.resource.ormapper.dao.HpOrganisationD.HpOrganisationDDao;
import project.conf.resource.ormapper.dto.oracle.HpOrganisationD;
import zebra.data.DataSet;
import zebra.data.ParamEntity;
import zebra.data.QueryAdvisor;
import zebra.exception.FrameworkException;
import zebra.util.CommonUtil;
import zebra.util.ConfigUtil;

public class Qm30BizImpl extends BaseBiz implements Qm30Biz {
	@Autowired
	private HpOrganisationDDao hpOrganisationDDao;

	public ParamEntity getDefault(ParamEntity paramEntity) throws Exception {
		try {
			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}

	public ParamEntity getList(ParamEntity paramEntity) throws Exception {
		DataSet requestDataSet = paramEntity.getRequestDataSet();
		QueryAdvisor queryAdvisor = paramEntity.getQueryAdvisor();
		HttpSession session = paramEntity.getSession();
		String dataSource = CommonUtil.nvl((String)session.getAttribute("DatabaseQuickSearch"), ConfigUtil.getProperty("jdbc.user.name"));

		try {
			hpOrganisationDDao.setDataSourceName(dataSource);

			queryAdvisor.setRequestDataSet(requestDataSet);
			queryAdvisor.setPagination(true);

			paramEntity.setAjaxResponseDataSet(hpOrganisationDDao.getOrganisationDataSetForQuickMenu(queryAdvisor));
			paramEntity.setTotalResultRows(queryAdvisor.getTotalResultRows());
			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}

	public ParamEntity exeSave(ParamEntity paramEntity) throws Exception {
		DataSet requestDataSet = paramEntity.getRequestDataSet();
		HttpSession session = paramEntity.getSession();
		String dataSource = CommonUtil.nvl((String)session.getAttribute("DatabaseQuickSearch"), ConfigUtil.getProperty("jdbc.user.name"));
		String orgId = requestDataSet.getValue("orgId");
		HpOrganisationD hpOrganisationD = new HpOrganisationD();

		try {
			hpOrganisationDDao.setDataSourceName(dataSource);

			hpOrganisationD = hpOrganisationDDao.getOrganisationByOrganisationId(orgId);

			paramEntity.setObject("hpOrganisationD", hpOrganisationD);
			paramEntity.setAjaxResponseDataSet(hpOrganisationD.getDataSet());
			paramEntity.setSuccess(true);
			paramEntity.setMessage("I801", getMessage("I801", paramEntity));
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}
}