package project.common.module.bizservice.assignment;

import project.conf.resource.ormapper.dto.oracle.HpAssignmentsD;
import zebra.data.DataSet;
import zebra.data.QueryAdvisor;

public interface AssignmentBizService {
	public DataSet getAssignmentList(QueryAdvisor queryAdvisor) throws Exception;
	public HpAssignmentsD getAssignmentByAssignmentId(QueryAdvisor queryAdvisor, String assignmentId) throws Exception;
	public DataSet getAssignmentAsDataSetByAssignmentId(QueryAdvisor queryAdvisor, String assignmentId) throws Exception;
	public DataSet getPayrollTaxDataSetByAssignmentId(QueryAdvisor queryAdvisor, String assignmentId) throws Exception;
	public DataSet getAssignmentRatesDataSetByAssignmentId(QueryAdvisor queryAdvisor, String assignmentId) throws Exception;
	public DataSet getDeliverableRatesDataSetByAssignmentId(QueryAdvisor queryAdvisor, String assignmentId) throws Exception;
	public DataSet getNotiToOrganisations(QueryAdvisor queryAdvisor, String assignmentId) throws Exception;
	public String getManagementFeeByAssignmentId(QueryAdvisor queryAdvisor, String assignmentId) throws Exception;
	public String getPayrollTaxByAssignmentId(QueryAdvisor queryAdvisor, String assignmentId) throws Exception;
	public int updateWorkingState(QueryAdvisor queryAdvisor, String assignmentIds[], String toWorkingState) throws Exception;
	public int updateEndUser(QueryAdvisor queryAdvisor, String assignmentIds[], String toEndUserId) throws Exception;
}