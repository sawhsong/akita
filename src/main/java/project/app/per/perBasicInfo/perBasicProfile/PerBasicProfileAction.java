/**************************************************************************************************
 * project
 * Description - PerBasicProfile - Person Profile (Old Type)
 *	- Generated by Source Generator
 *************************************************************************************************/
package project.app.per.perBasicInfo.perBasicProfile;

import org.springframework.beans.factory.annotation.Autowired;

import project.common.extend.BaseAction;
import project.conf.resource.ormapper.dto.oracle.HpPersonD;
import zebra.data.DataSet;
import zebra.util.CommonUtil;

public class PerBasicProfileAction extends BaseAction {
	@Autowired
	private PerBasicProfileBiz biz;

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

	public String getPersonFrameContainer() throws Exception {
		biz.getPersonFrameContainer(paramEntity);

		if (paramEntity.isSuccess()) {
			HpPersonD hpPersonD = (HpPersonD)paramEntity.getObject("hpPersonD");

			session.setAttribute("PersonIdForAdminTool", CommonUtil.toStringForId(hpPersonD.getPersonId()));
			session.setAttribute("PersonNumberForAdminTool", hpPersonD.getPersonNumber());
			session.setAttribute("PersonFullNameForAdminTool", hpPersonD.getFullName());
			session.setAttribute("HpPersonDForAdminTool", hpPersonD);

			session.setAttribute("PersonIdQuickSearch", CommonUtil.toStringForId(hpPersonD.getPersonId()));
			session.setAttribute("PersonNumberQuickSearch", hpPersonD.getPersonNumber());
			session.setAttribute("PersonFullNameQuickSearch", hpPersonD.getFullName());
			session.setAttribute("HpPersonDQuickSearch", hpPersonD);
		}
		return "frameContainer";
	}

	public String getPersonal() throws Exception {
		biz.getPersonal(paramEntity);
		return "personal";
	}

	public String getPersonDetail() throws Exception {
		try {
			biz.getPersonDetail(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getPersonalComment() throws Exception {
		try {
			biz.getPersonalComment(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getCommsHistory() throws Exception {
		try {
			biz.getCommsHistory(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getContact() throws Exception {
		biz.getContact(paramEntity);
		return "contact";
	}

	public String getDocumentOutstanding() throws Exception {
		biz.getDocumentOutstanding(paramEntity);
		return "documentOutstanding";
	}

	public String getDocumentOutstandingList() throws Exception {
		try {
			biz.getDocumentOutstandingList(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getDocumentReceived() throws Exception {
		biz.getDocumentReceived(paramEntity);
		return "documentReceived";
	}

	public String getDocumentReceivedList() throws Exception {
		try {
			biz.getDocumentReceivedList(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getAdditionalService() throws Exception {
		biz.getAdditionalService(paramEntity);
		return "additionalService";
	}

	public String getAdditionalServiceList() throws Exception {
		try {
			biz.getAdditionalServiceList(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getCommunication() throws Exception {
		biz.getCommunication(paramEntity);
		return "communication";
	}

	public String getCommunicationList() throws Exception {
		try {
			biz.getCommunicationList(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getNextActions() throws Exception {
		biz.getNextActions(paramEntity);
		return "nextActions";
	}

	public String getNextActionsList() throws Exception {
		try {
			biz.getNextActionsList(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getGeneral() throws Exception {
		biz.getGeneral(paramEntity);
		return "general";
	}

	public String getGeneralInfo() throws Exception {
		try {
			biz.getGeneralInfo(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getWorkingRightsStatusList() throws Exception {
		try {
			biz.getWorkingRightsStatusList(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getScheduledPayrollNotiList() throws Exception {
		try {
			biz.getScheduledPayrollNotiList(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getOpportunities() throws Exception {
		biz.getOpportunity(paramEntity);
		return "opportunity";
	}

	public String getOpportunityList() throws Exception {
		try {
			biz.getOpportunityList(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getEditOpportunity() throws Exception {
		biz.getEditOpportunity(paramEntity);
		return "editOpportunity";
	}

	public String getOpportunityDetail() throws Exception {
		biz.getOpportunityDetail(paramEntity);
		return "opportunityDetail";
	}

	public String getOpportunityDocuments() throws Exception {
		try {
			biz.getOpportunityDocuments(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getAssignmentList() throws Exception {
		biz.getAssignmentList(paramEntity);
		return "assignmentList";
	}

	public String getAssignmentDataList() throws Exception {
		try {
			biz.getAssignmentDataList(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getAssignment() throws Exception {
		biz.getAssignment(paramEntity);

		if (paramEntity.isSuccess()) {
			DataSet dsRequest = paramEntity.getRequestDataSet();

			session.setAttribute("AssignmentIdForAdminTool", dsRequest.getValue("assignmentId"));

			session.setAttribute("AssignmentIdQuickSearch", dsRequest.getValue("assignmentId"));
		}
		return "assignment";
	}

	public String getPrtDocumentList() throws Exception {
		try {
			biz.getPrtDocumentList(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getAssignmentRateList() throws Exception {
		try {
			biz.getAssignmentRateList(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getDeliverableRateList() throws Exception {
		try {
			biz.getDeliverableRateList(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getApproverEmail() throws Exception {
		try {
			biz.getApproverEmail(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getNotiToPersonList() throws Exception {
		try {
			biz.getNotiToPersonList(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getPayslips() throws Exception {
		biz.getPayslips(paramEntity);
		return "payslips";
	}

	public String getPayslipList() throws Exception {
		try {
			biz.getPayslipList(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getSuperannuation() throws Exception {
		biz.getSuperannuation(paramEntity);
		return "superannuation";
	}
}