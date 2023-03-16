/**************************************************************************************************
 * Framework Generated HDAOImpl Source
 * - HP_ASG_PROCESSES - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.HpAsgProcesses;

import project.common.extend.BaseHDao;
import zebra.data.DataSet;
import zebra.data.QueryAdvisor;
import zebra.util.ConfigUtil;

public class HpAsgProcessesHDaoImpl extends BaseHDao implements HpAsgProcessesDao {
	public DataSet getPayslipListByPersonId(QueryAdvisor queryAdvisor, String personId) throws Exception {
		queryAdvisor.addVariable("dateFormat", ConfigUtil.getProperty("format.date.java"));
		queryAdvisor.addWhereClause("hpd.person_id = '"+personId+"'");

		return selectAsDataSet(queryAdvisor, "query.HpAsgProcesses.getPayslipListByPersonId");
	}

	public DataSet getPayslipListByPersonId(String personId) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();

		queryAdvisor.addVariable("dateFormat", ConfigUtil.getProperty("format.date.java"));
		queryAdvisor.addWhereClause("hpd.person_id = '"+personId+"'");

		return selectAsDataSet(queryAdvisor, "query.HpAsgProcesses.getPayslipListByPersonId");
	}
}