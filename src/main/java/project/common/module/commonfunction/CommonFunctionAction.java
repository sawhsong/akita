package project.common.module.commonfunction;

import org.springframework.beans.factory.annotation.Autowired;

import project.common.extend.BaseAction;
import project.common.module.menu.MenuManager;

public class CommonFunctionAction extends BaseAction {
	@Autowired
	private CommonFunctionBiz biz;

	/*!
	 * Common
	 */
	public String getPrivateKey() throws Exception {
		try {
			biz.getPrivateKey(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	/*!
	 * Reset Password
	 */
	public String getResetPassword() throws Exception {
		biz.getResetPassword(paramEntity);
		return "resetPassword";
	}

	public String doResetPassword() throws Exception {
		try {
			biz.doResetPassword(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	/*!
	 * User Profile
	 */
	public String getUserProfile() throws Exception {
		biz.getUserProfile(paramEntity);
		return "userProfile";
	}

	public String doUpdateUserProfile() throws Exception {
		try {
			biz.doUpdateUserProfile(paramEntity);

			if (paramEntity.isSuccess()) {
				paramEntity.setObject("messageCode", "I000");
				paramEntity.setObject("message", paramEntity.getMessage()+"<br/>"+getMessage("login.message.restart", paramEntity));
				paramEntity.setObject("action", "/login/logout.do");
			} else {
				paramEntity.setObject("script", "history.go(-1);");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());

			paramEntity.setObject("messageCode", "E000");
			paramEntity.setObject("message", ex.getMessage());
			paramEntity.setObject("script", "history.go(-1);");
		}

		return "pageHandler";
	}

	public String hasAuthKey() throws Exception {
		try {
			biz.hasAuthKey(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getAuthenticationSecretKey() throws Exception {
		try {
			biz.getAuthenticationSecretKey(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getChangePassword() throws Exception {
		biz.getChangePassword(paramEntity);
		return "changePassword";
	}

	public String doChangePassword() throws Exception {
		try {
			biz.doChangePassword(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	/*!
	 * Favorite Menu - Bookmarks
	 */
	public String saveFavoriteMenu() throws Exception {
		try {
			biz.saveFavoriteMenu(paramEntity);

			if (paramEntity.isSuccess()) {
				String userId = (String)session.getAttribute("UserId");

				session.setAttribute("FavoriteMenuDataSet", MenuManager.getFavoriteMenuDataSet(userId));
			}
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getFavoriteMenu() throws Exception {
		biz.getFavoriteMenu(paramEntity);
		return "favoriteMenu";
	}

	public String getFavoriteMenuList() throws Exception {
		try {
			biz.getFavoriteMenuList(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String doDeleteFavoriteMenu() throws Exception {
		try {
			biz.doDeleteFavoriteMenu(paramEntity);

			if (paramEntity.isSuccess()) {
				String userId = (String)session.getAttribute("UserId");

				session.setAttribute("FavoriteMenuDataSet", MenuManager.getFavoriteMenuDataSet(userId));
			}
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}
}