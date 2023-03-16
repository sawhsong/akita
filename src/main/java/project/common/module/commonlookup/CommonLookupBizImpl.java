package project.common.module.commonlookup;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import project.common.extend.BaseBiz;
import project.common.module.commoncode.CommonCodeManager;
import project.conf.resource.ormapper.dao.HpOrganisationD.HpOrganisationDDao;
import project.conf.resource.ormapper.dao.HpPersonD.HpPersonDDao;
import zebra.data.DataSet;
import zebra.data.ParamEntity;
import zebra.data.QueryAdvisor;
import zebra.exception.FrameworkException;
import zebra.util.CommonUtil;
import zebra.util.ConfigUtil;

public class CommonLookupBizImpl extends BaseBiz implements CommonLookupBiz {
	@Autowired
	private HpOrganisationDDao hpOrganisationDDao;
	@Autowired
	private HpPersonDDao hpPersonDDao;

	public ParamEntity getDefault(ParamEntity paramEntity) throws Exception {
		try {
			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}

	public ParamEntity getCommonCodeForSelectbox(ParamEntity paramEntity) throws Exception {
		DataSet requestDataSet = paramEntity.getRequestDataSet();
		String codeType = requestDataSet.getValue("codeType");
		DataSet ds;

		try {
			ds = CommonCodeManager.getCodeDataSetByCodeType(codeType);
			paramEntity.setAjaxResponseDataSet(ds);
			paramEntity.setTotalResultRows(ds.getRowCnt());
			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}

	public ParamEntity getEmploymentOrganisationLookup(ParamEntity paramEntity) throws Exception {
		DataSet requestDataSet = paramEntity.getRequestDataSet();
		QueryAdvisor queryAdvisor = paramEntity.getQueryAdvisor();
		String empOrgName = requestDataSet.getValue("empOrgName");
		String abn = requestDataSet.getValue("abn");
		HttpSession session = paramEntity.getSession();
		String dataSource = CommonUtil.nvl((String)session.getAttribute("DatabaseQuickSearch"), ConfigUtil.getProperty("jdbc.user.name"));

		try {
			hpOrganisationDDao.setDataSourceName(dataSource);

			queryAdvisor.setPagination(true);

			queryAdvisor.addAutoFillCriteria(empOrgName, "lower(organisation_name) like lower('"+empOrgName+"%')");
			queryAdvisor.addAutoFillCriteria(abn, "abn like '%"+abn+"%'");
			queryAdvisor.addOrderByClause("organisation_name asc");

			paramEntity.setAjaxResponseDataSet(hpOrganisationDDao.getEmploymentOrganisationLookup(queryAdvisor));
			paramEntity.setTotalResultRows(queryAdvisor.getTotalResultRows());
			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}

	public ParamEntity getEsEmployeeLookup(ParamEntity paramEntity) throws Exception {
		DataSet requestDataSet = paramEntity.getRequestDataSet();
		QueryAdvisor queryAdvisor = paramEntity.getQueryAdvisor();
		String personNumber = requestDataSet.getValue("personNumber");
		String personName = requestDataSet.getValue("personName");

		HttpSession session = paramEntity.getSession();
		String dataSource = CommonUtil.nvl((String)session.getAttribute("DatabaseQuickSearch"), ConfigUtil.getProperty("jdbc.user.name"));

		try {
			hpPersonDDao.setDataSourceName(dataSource);

			queryAdvisor.setPagination(true);

			queryAdvisor.addAutoFillCriteria(personNumber, "person_number like '%"+personNumber+"%'");
			queryAdvisor.addAutoFillCriteria(personName, "lower(full_name) like lower('"+personName+"%')");
			queryAdvisor.addWhereClause("person_type = 'Entity Employee'");

			queryAdvisor.addOrderByClause("full_name asc");

			paramEntity.setAjaxResponseDataSet(hpPersonDDao.getEsEmployeeLookup(queryAdvisor));
			paramEntity.setTotalResultRows(queryAdvisor.getTotalResultRows());
			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}
}