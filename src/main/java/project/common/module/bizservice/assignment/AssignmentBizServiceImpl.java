package project.common.module.bizservice.assignment;

import org.springframework.beans.factory.annotation.Autowired;

import project.conf.resource.ormapper.dao.AsgDeliverablesRates.AsgDeliverablesRatesDao;
import project.conf.resource.ormapper.dao.HpAssignmentRates.HpAssignmentRatesDao;
import project.conf.resource.ormapper.dao.HpAssignmentsD.HpAssignmentsDDao;
import project.conf.resource.ormapper.dao.HpOrganisationD.HpOrganisationDDao;
import project.conf.resource.ormapper.dao.HpPersonD.HpPersonDDao;
import project.conf.resource.ormapper.dao.PrtAssignmentSetup.PrtAssignmentSetupDao;
import project.conf.resource.ormapper.dto.oracle.HpAssignmentsD;
import project.conf.resource.ormapper.dto.oracle.HpPersonD;
import zebra.data.DataSet;
import zebra.data.QueryAdvisor;
import zebra.example.common.extend.BaseBiz;
import zebra.util.CommonUtil;

public class AssignmentBizServiceImpl extends BaseBiz implements AssignmentBizService {
	@Autowired
	private HpAssignmentsDDao hpAssignmentsDDao;
	@Autowired
	private HpPersonDDao hpPersonDDao;
	@Autowired
	private HpOrganisationDDao hpOrganisationDDao;
	@Autowired
	private PrtAssignmentSetupDao prtAssignmentSetupDao;
	@Autowired
	private HpAssignmentRatesDao hpAssignmentRatesDao;
	@Autowired
	private AsgDeliverablesRatesDao asgDeliverablesRatesDao;

	public DataSet getAssignmentList(QueryAdvisor queryAdvisor) throws Exception {
		DataSet ds = new DataSet();

		hpAssignmentsDDao.setDataSourceName((String)queryAdvisor.getObject("dataSource"));
		ds = hpAssignmentsDDao.getAssignmentList(queryAdvisor);
		return ds;
	}

	public HpAssignmentsD getAssignmentByAssignmentId(QueryAdvisor queryAdvisor, String assignmentId) throws Exception {
		hpAssignmentsDDao.setDataSourceName((String)queryAdvisor.getObject("dataSource"));
		return hpAssignmentsDDao.getByAssignmentId(assignmentId);
	}

	public DataSet getAssignmentAsDataSetByAssignmentId(QueryAdvisor queryAdvisor, String assignmentId) throws Exception {
		hpAssignmentsDDao.setDataSourceName((String)queryAdvisor.getObject("dataSource"));
		return hpAssignmentsDDao.getDataSetByAssignmentId(assignmentId);
	}

	public DataSet getPayrollTaxDataSetByAssignmentId(QueryAdvisor queryAdvisor, String assignmentId) throws Exception {
		prtAssignmentSetupDao.setDataSourceName((String)queryAdvisor.getObject("dataSource"));
		return prtAssignmentSetupDao.getLatestDataSetByAssignmentId(assignmentId);
	}

	public DataSet getAssignmentRatesDataSetByAssignmentId(QueryAdvisor queryAdvisor, String assignmentId) throws Exception {
		hpAssignmentRatesDao.setDataSourceName((String)queryAdvisor.getObject("dataSource"));
		return hpAssignmentRatesDao.getDataSetByAssignmentId(assignmentId);
	}

	public DataSet getDeliverableRatesDataSetByAssignmentId(QueryAdvisor queryAdvisor, String assignmentId) throws Exception {
		asgDeliverablesRatesDao.setDataSourceName((String)queryAdvisor.getObject("dataSource"));
		return asgDeliverablesRatesDao.getDataSetByAssignmentId(assignmentId);
	}

	public DataSet getNotiToOrganisations(QueryAdvisor queryAdvisor, String assignmentId) throws Exception {
		HpAssignmentsD hpAssignmentsD;
		HpPersonD hpPersonD;
		String dataSource = (String)queryAdvisor.getObject("dataSource");
		String personId, billingOrgId, euOrgId, empOrgId, refNo1, refNo2, refNo3;

		hpPersonDDao.setDataSourceName(dataSource);
		hpOrganisationDDao.setDataSourceName(dataSource);

		hpAssignmentsD = getAssignmentByAssignmentId(queryAdvisor, assignmentId);
		personId = CommonUtil.toStringForId(hpAssignmentsD.getPersonId());

		hpPersonD = hpPersonDDao.getPersonByPersonId(personId);

		billingOrgId = CommonUtil.toStringForId(hpAssignmentsD.getBillingOrganisationId());
		euOrgId = CommonUtil.toStringForId(hpAssignmentsD.getEuOrganisationId());
		empOrgId = CommonUtil.toStringForId(hpPersonD.getEmploymentCompanyOrgId());
		refNo1 = hpAssignmentsD.getReferenceNo1();
		refNo2 = hpAssignmentsD.getReferenceNo2();
		refNo3 = hpAssignmentsD.getReferenceNo3();

		return hpOrganisationDDao.getDataSetByOrganisationIds(billingOrgId, euOrgId, empOrgId, refNo1, refNo2, refNo3);
	}

	public String getManagementFeeByAssignmentId(QueryAdvisor queryAdvisor, String assignmentId) throws Exception {
		String dataSource = (String)queryAdvisor.getObject("dataSource");
		DataSet ds;
		double value = 0;

		hpAssignmentsDDao.setDataSourceName(dataSource);
		ds = hpAssignmentsDDao.getManagementFeeAndPayrollTaxByAssignmentId(assignmentId);

		for (int i=0; i<ds.getRowCnt(); i++) {
			if (CommonUtil.equals(ds.getValue(i, "MGT_FEE_PAYROLL_TAX_TYPE"), "ManagementFee")) {
				value += CommonUtil.toDouble(ds.getValue(i, "PERCENTAGE"));
			}
		}

		return CommonUtil.toString(value, "#,##0.00");
	}

	public String getPayrollTaxByAssignmentId(QueryAdvisor queryAdvisor, String assignmentId) throws Exception {
		String dataSource = (String)queryAdvisor.getObject("dataSource");
		DataSet ds;
		double value = 0;

		hpAssignmentsDDao.setDataSourceName(dataSource);
		ds = hpAssignmentsDDao.getManagementFeeAndPayrollTaxByAssignmentId(assignmentId);

		for (int i=0; i<ds.getRowCnt(); i++) {
			if (CommonUtil.equals(ds.getValue(i, "MGT_FEE_PAYROLL_TAX_TYPE"), "PayrollTax")) {
				value += CommonUtil.toDouble(ds.getValue(i, "PERCENTAGE"));
			}
		}

		return CommonUtil.toString(value, "#,##0.00");
	}

	public int updateWorkingState(QueryAdvisor queryAdvisor, String assignmentIds[], String toWorkingState) throws Exception {
		HpAssignmentsD hpAssignmentsD = new HpAssignmentsD();
		String ids = "";

		for (String id : assignmentIds) {
			ids += CommonUtil.isBlank(ids) ? "'"+id+"'" : ",'"+id+"'";
		}

		hpAssignmentsD.addUpdateColumn("working_state", toWorkingState);
		hpAssignmentsD.addUpdateColumn("last_updated_by", "1");
		hpAssignmentsD.addUpdateColumn("last_update_date", "sysdate", "Date");

		queryAdvisor.addWhereClause("assignment_id in ("+ids+")");

		hpAssignmentsDDao.setDataSourceName((String)queryAdvisor.getObject("dataSource"));

		return hpAssignmentsDDao.updateAssignmentByColumn(queryAdvisor, hpAssignmentsD);
	}

	public int updateEndUser(QueryAdvisor queryAdvisor, String assignmentIds[], String toEndUserId) throws Exception {
		HpAssignmentsD hpAssignmentsD = new HpAssignmentsD();
		String ids = "";

		for (String id : assignmentIds) {
			ids += CommonUtil.isBlank(ids) ? "'"+id+"'" : ",'"+id+"'";
		}

		hpAssignmentsD.addUpdateColumn("eu_organisation_id", toEndUserId);
		hpAssignmentsD.addUpdateColumn("last_updated_by", "1");
		hpAssignmentsD.addUpdateColumn("last_update_date", "sysdate", "Date");

		queryAdvisor.addWhereClause("assignment_id in ("+ids+")");

		hpAssignmentsDDao.setDataSourceName((String)queryAdvisor.getObject("dataSource"));

		return hpAssignmentsDDao.updateAssignmentByColumn(queryAdvisor, hpAssignmentsD);
	}
}