/**************************************************************************************************
 * project
 * Description - OrgBasicProfile - Organisation Profile (Old Type)
 *	- Generated by Source Generator
 *************************************************************************************************/
package project.app.org.orgBasicInfo.orgBasicProfile;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import project.common.extend.BaseBiz;
import project.conf.resource.ormapper.dao.HpCommsOrgLink.HpCommsOrgLinkDao;
import project.conf.resource.ormapper.dao.HpCommsPersonLink.HpCommsPersonLinkDao;
import project.conf.resource.ormapper.dao.HpContactHistory.HpContactHistoryDao;
import project.conf.resource.ormapper.dao.HpOrganisationD.HpOrganisationDDao;
import project.conf.resource.ormapper.dao.HpPersonD.HpPersonDDao;
import project.conf.resource.ormapper.dto.oracle.HpOrganisationD;
import zebra.data.DataSet;
import zebra.data.ParamEntity;
import zebra.data.QueryAdvisor;
import zebra.exception.FrameworkException;
import zebra.util.CommonUtil;
import zebra.util.ConfigUtil;

public class OrgBasicProfileBizImpl extends BaseBiz implements OrgBasicProfileBiz {
	@Autowired
	private HpOrganisationDDao hpOrganisationDDao;
	@Autowired
	private HpPersonDDao hpPersonDDao;
	@Autowired
	private HpContactHistoryDao hpContactHistoryDao;
	@Autowired
	private HpCommsPersonLinkDao hpCommsPersonLinkDao;
	@Autowired
	private HpCommsOrgLinkDao hpCommsOrgLinkDao;

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

			paramEntity.setAjaxResponseDataSet(hpOrganisationDDao.getOrganisationDataSetByCriteria(queryAdvisor));
			paramEntity.setTotalResultRows(queryAdvisor.getTotalResultRows());
			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}

	public ParamEntity getOrganisationDetailFrameContainer(ParamEntity paramEntity) throws Exception {
		DataSet dsRequest = paramEntity.getRequestDataSet();
		String organisationId = dsRequest.getValue("organisationId");
		HpOrganisationD hpOrganisationD;
		HttpSession session = paramEntity.getSession();
		String dataSource = CommonUtil.nvl((String)session.getAttribute("DatabaseQuickSearch"), ConfigUtil.getProperty("jdbc.user.name"));

		try {
			hpOrganisationDDao.setDataSourceName(dataSource);

			hpOrganisationD = hpOrganisationDDao.getOrganisationByOrganisationId(organisationId);

			paramEntity.setObject("hpOrganisationD", hpOrganisationD);
			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}

	public ParamEntity getOrganisation(ParamEntity paramEntity) throws Exception {
		DataSet dsRequest = paramEntity.getRequestDataSet();
		String organisationId = dsRequest.getValue("organisationId");
		HpOrganisationD hpOrganisationD;
		HttpSession session = paramEntity.getSession();
		String dataSource = CommonUtil.nvl((String)session.getAttribute("DatabaseQuickSearch"), ConfigUtil.getProperty("jdbc.user.name"));

		try {
			hpOrganisationDDao.setDataSourceName(dataSource);
			hpOrganisationD = hpOrganisationDDao.getOrganisationByOrganisationId(organisationId);

			paramEntity.setObject("hpOrganisationD", hpOrganisationD);
			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}

	public ParamEntity getOrganisationDetail(ParamEntity paramEntity) throws Exception {
		DataSet requestDataSet = paramEntity.getRequestDataSet();
		String organisationId = requestDataSet.getValue("organisationId");
		DataSet organisationDataSet;
		HttpSession session = paramEntity.getSession();
		String dataSource = CommonUtil.nvl((String)session.getAttribute("DatabaseQuickSearch"), ConfigUtil.getProperty("jdbc.user.name"));

		try {
			hpOrganisationDDao.setDataSourceName(dataSource);
			hpPersonDDao.setDataSourceName(dataSource);

			organisationDataSet = hpOrganisationDDao.getDataSetByOrganisationIds(organisationId);

			paramEntity.setAjaxResponseDataSet(organisationDataSet);
			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}

	public ParamEntity getCommunicationHistory(ParamEntity paramEntity) throws Exception {
		DataSet dsRequest = paramEntity.getRequestDataSet();
		String organisationId = dsRequest.getValue("organisationId");
		DataSet ds, commsHistory = new DataSet(), dsPersonLink, dsOrgLink;
		String html = "", contactIds = "";
		String lineBreak = "\n----------------------------------------------------------------------------------------------------------------------------------------------\n";
		HttpSession session = paramEntity.getSession();
		String dataSource = CommonUtil.nvl((String)session.getAttribute("DatabaseQuickSearch"), ConfigUtil.getProperty("jdbc.user.name"));

		try {
			hpContactHistoryDao.setDataSourceName(dataSource);

			ds = hpContactHistoryDao.getDataSetForOrgCommsHistoryByOrganisationId(organisationId);
			if (ds.getRowCnt() > 0) {
				for (int i=0; i<ds.getRowCnt(); i++) {
					contactIds += CommonUtil.isBlank(contactIds) ? "'"+ds.getValue(i, "CONTACT_ID")+"'" : ", "+"'"+ds.getValue(i, "CONTACT_ID")+"'";
				}

				hpCommsPersonLinkDao.setDataSourceName(dataSource);
				hpCommsOrgLinkDao.setDataSourceName(dataSource);
				dsPersonLink = hpCommsPersonLinkDao.getDataSetByContactId(contactIds);
				dsOrgLink = hpCommsOrgLinkDao.getDataSetByContactId(contactIds);

				for (int i=0; i<ds.getRowCnt(); i++) {
					String orgName = "", personName = "";
					String contactDate = ds.getValue(i, "CONTACT_DATE");
					String contactId = ds.getValue(i, "CONTACT_ID");

					html += "<strong>"+contactDate + " " + CommonUtil.nvl(ds.getValue(i, "CONTACT_TIME")) + " - " + ds.getValue(i, "ENTITY_EMPLOYEE_NAME") + " - ";
					html += ds.getValue(i, "ACTIVITY_TYPE_MEANING") + " - " + ds.getValue(i, "CONTACT_TYPE_MEANING") + " - ";

					for (int j=0; j<dsPersonLink.getRowCnt(); j++) {
						if (CommonUtil.equals(contactId, dsPersonLink.getValue(j, "CONTACT_ID"))) {
							if (CommonUtil.equalsIgnoreCase(dsPersonLink.getValue(j, "IS_PRIMARY"), "Y")) {
								personName += (CommonUtil.isBlank(personName)) ? dsPersonLink.getValue(j, "PERSON_NAME") : " - " + dsPersonLink.getValue(j, "PERSON_NAME");
								break;
							}
						}
					}
					for (int j=0; j<dsPersonLink.getRowCnt(); j++) {
						if (CommonUtil.equals(contactId, dsPersonLink.getValue(j, "CONTACT_ID"))) {
							if (CommonUtil.equalsIgnoreCase(dsPersonLink.getValue(j, "IS_PRIMARY"), "N")) {
								personName += (CommonUtil.isBlank(personName)) ? dsPersonLink.getValue(j, "PERSON_NAME") : " - " + dsPersonLink.getValue(j, "PERSON_NAME");
							}
						}
					}
					html += personName + " - ";
					for (int j=0; j<dsOrgLink.getRowCnt(); j++) {
						if (CommonUtil.equals(contactId, dsOrgLink.getValue(j, "CONTACT_ID"))) {
							if (CommonUtil.equalsIgnoreCase(dsOrgLink.getValue(j, "IS_PRIMARY"), "Y")) {
								orgName += (CommonUtil.isBlank(orgName)) ? dsOrgLink.getValue(j, "ORGANISATION_NAME") : " - " + dsOrgLink.getValue(j, "ORGANISATION_NAME");
								break;
							}
						}
					}
					for (int j=0; j<dsOrgLink.getRowCnt(); j++) {
						if (CommonUtil.equals(contactId, dsOrgLink.getValue(j, "CONTACT_ID"))) {
							if (CommonUtil.equalsIgnoreCase(dsOrgLink.getValue(j, "IS_PRIMARY"), "N")) {
								orgName += (CommonUtil.isBlank(orgName)) ? dsOrgLink.getValue(j, "ORGANISATION_NAME") : " - " + dsOrgLink.getValue(j, "ORGANISATION_NAME");
							}
						}
					}
					html += orgName;
					html += "</strong>"+lineBreak+ds.getValue(i, "COMMENTS")+lineBreak+"\n";
				}
			}

			commsHistory.addColumn("HTML", html);
			paramEntity.setAjaxResponseDataSet(commsHistory);
			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}
}