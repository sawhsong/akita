package project.common.module.commonfunction;

import zebra.data.ParamEntity;

public interface CommonFunctionBiz {
	public ParamEntity getPrivateKey(ParamEntity paramEntity) throws Exception;
	public ParamEntity getResetPassword(ParamEntity paramEntity) throws Exception;
	public ParamEntity doResetPassword(ParamEntity paramEntity) throws Exception;
	public ParamEntity getUserProfile(ParamEntity paramEntity) throws Exception;
	public ParamEntity doUpdateUserProfile(ParamEntity paramEntity) throws Exception;
	public ParamEntity hasAuthKey(ParamEntity paramEntity) throws Exception;
	public ParamEntity getAuthenticationSecretKey(ParamEntity paramEntity) throws Exception;
	public ParamEntity getChangePassword(ParamEntity paramEntity) throws Exception;
	public ParamEntity doChangePassword(ParamEntity paramEntity) throws Exception;
	public ParamEntity saveFavoriteMenu(ParamEntity paramEntity) throws Exception;
	public ParamEntity getFavoriteMenu(ParamEntity paramEntity) throws Exception;
	public ParamEntity getFavoriteMenuList(ParamEntity paramEntity) throws Exception;
	public ParamEntity doDeleteFavoriteMenu(ParamEntity paramEntity) throws Exception;
}