package project.app.login;

import zebra.data.ParamEntity;

public interface LoginBiz {
	public ParamEntity index(ParamEntity paramEntity) throws Exception;
	public ParamEntity exeLogin(ParamEntity paramEntity) throws Exception;
	public ParamEntity exeRequestRegister(ParamEntity paramEntity) throws Exception;
	public ParamEntity setSessionValuesForAdminTool(ParamEntity paramEntity) throws Exception;
	public ParamEntity doAuthentication(ParamEntity paramEntity) throws Exception;
}