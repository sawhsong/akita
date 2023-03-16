package project.common.module.bizservice.workcover;

import zebra.data.QueryAdvisor;

public interface WorkcoverBizService {
	public String getWcCodeRateId(QueryAdvisor queryAdvisor) throws Exception;
	public String getWcCodeRateName(QueryAdvisor queryAdvisor) throws Exception;
	public String getWcWicAnzic(QueryAdvisor queryAdvisor) throws Exception;
	public double getWcPercentage(QueryAdvisor queryAdvisor) throws Exception;
	public String getWcStartDate(QueryAdvisor queryAdvisor) throws Exception;
	public String getWcEndDate(QueryAdvisor queryAdvisor) throws Exception;
	public String getWorkingState(QueryAdvisor queryAdvisor) throws Exception;
	public String getWorkingStateMeaning(QueryAdvisor queryAdvisor) throws Exception;
}