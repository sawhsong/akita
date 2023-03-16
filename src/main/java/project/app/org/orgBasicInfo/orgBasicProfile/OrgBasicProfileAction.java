/**************************************************************************************************
 * project
 * Description - OrgBasicProfile - Organisation Profile (Old Type)
 *	- Generated by Source Generator
 *************************************************************************************************/
package project.app.org.orgBasicInfo.orgBasicProfile;

import org.springframework.beans.factory.annotation.Autowired;

import project.common.extend.BaseAction;
import project.conf.resource.ormapper.dto.oracle.HpOrganisationD;
import zebra.util.CommonUtil;

public class OrgBasicProfileAction extends BaseAction {
	@Autowired
	private OrgBasicProfileBiz biz;

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

	public String getOrganisationDetailFrameContainer() throws Exception {
		biz.getOrganisationDetailFrameContainer(paramEntity);

		if (paramEntity.isSuccess()) {
			HpOrganisationD hpOrganisationD = (HpOrganisationD)paramEntity.getObject("hpOrganisationD");

			session.setAttribute("OrganisationIdForAdminTool", CommonUtil.toStringForId(hpOrganisationD.getOrganisationId()));
			session.setAttribute("OrganisationNameForAdminTool", hpOrganisationD.getOrganisationName());
			session.setAttribute("HpOrganisationDForAdminTool", hpOrganisationD);

			session.setAttribute("OrganisationIdQuickSearch", CommonUtil.toStringForId(hpOrganisationD.getOrganisationId()));
			session.setAttribute("OrganisationNameQuickSearch", hpOrganisationD.getOrganisationName());
			session.setAttribute("HpOrganisationDQuickSearch", hpOrganisationD);
		}
		return "frameContainer";
	}

	public String getOrganisation() throws Exception {
		biz.getOrganisation(paramEntity);
		return "basicProfile";
	}

	public String getOrganisationDetail() throws Exception {
		try {
			biz.getOrganisationDetail(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getCommunicationHistory() throws Exception {
		try {
			biz.getCommunicationHistory(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}
}