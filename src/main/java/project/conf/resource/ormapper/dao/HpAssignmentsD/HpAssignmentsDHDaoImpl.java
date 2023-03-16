/**************************************************************************************************
 * Framework Generated HDAOImpl Source
 * - HP_ASSIGNMENTS_D - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.HpAssignmentsD;

import project.common.extend.BaseHDao;
import project.conf.resource.ormapper.dto.oracle.HpAssignmentsD;
import zebra.data.DataSet;
import zebra.data.QueryAdvisor;
import zebra.util.ConfigUtil;

public class HpAssignmentsDHDaoImpl extends BaseHDao implements HpAssignmentsDDao {
	public DataSet getCostCentreForAutoCompletion(QueryAdvisor queryAdvisor) throws Exception {
		return selectAsDataSet(queryAdvisor, "query.HpAssignmentsD.getCostCentreForAutoCompletion");
	}

	public int updateAssignmentByColumn(QueryAdvisor queryAdvisor, HpAssignmentsD hpAssignmentsD) throws Exception {
		return updateColumns(queryAdvisor, hpAssignmentsD);
	}

	public DataSet getAssignmentList(QueryAdvisor queryAdvisor) throws Exception {
		return selectAsDataSet(queryAdvisor, "query.HpAssignmentsD.getAssignmentList");
	}

	public HpAssignmentsD getByAssignmentId(String assignmentId) throws Exception {
		QueryAdvisor qa = new QueryAdvisor();
		qa.addWhereClause("assignment_id = '"+assignmentId+"'");
		return (HpAssignmentsD)selectAllToDto(qa, new HpAssignmentsD());
	}

	public DataSet getDataSetByAssignmentId(String assignmentId) throws Exception {
		QueryAdvisor qa = new QueryAdvisor();

		qa.addVariable("dateFormat", ConfigUtil.getProperty("format.date.java"));
		qa.addVariable("assignmentId", assignmentId);

		return selectAsDataSet(qa, "query.HpAssignmentsD.getDataSetByAssignmentId");
	}

	public DataSet getManagementFeeAndPayrollTaxByAssignmentId(String assignmentId) throws Exception {
		QueryAdvisor qa = new QueryAdvisor();

		qa.addVariable("assignmentId", assignmentId);

		return selectAsDataSet(qa, "query.HpAssignmentsD.getManagementFeeAndPayrollTaxByAssignmentId");
	}
}