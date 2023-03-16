package project.common.module.commonlookup;

import zebra.data.ParamEntity;

public interface CommonLookupBiz {
	public ParamEntity getDefault(ParamEntity paramEntity) throws Exception;
	public ParamEntity getCommonCodeForSelectbox(ParamEntity paramEntity) throws Exception;
	public ParamEntity getEmploymentOrganisationLookup(ParamEntity paramEntity) throws Exception;
	public ParamEntity getEsEmployeeLookup(ParamEntity paramEntity) throws Exception;
}