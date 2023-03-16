<%/************************************************************************************************
* Description
* - 
************************************************************************************************/%>
<%/************************************************************************************************
* Declare objects & variables
************************************************************************************************/%>
<%
	SysUser sysUserHeaderPage = (SysUser)session.getAttribute("SysUser");
	String authGroupIdHeaderPage = sysUserHeaderPage.getAuthGroupId();
	String defaultStartUrlHeaderPage = sysUserHeaderPage.getDefaultStartUrl();
	String userNameHeaderPage = sysUserHeaderPage.getUserName();
	String userIdHeaderPage = sysUserHeaderPage.getUserId();
	String languageCodeHeaderPage = CommonUtil.upperCase((String)session.getAttribute("langCode"));
	String selectedHeaderMenuHeaderPage = (String)session.getAttribute("headerMenuId");

	DataSet dsThemeTypeHeaderPage = CommonCodeManager.getCodeDataSetByCodeType("USER_THEME_TYPE");
	DataSet dsMenuHeaderPage = MenuManager.getMenu(authGroupIdHeaderPage, "", "1", "1");
	DataSet dsQuickMenuHeaderPage = MenuManager.getQuickMenu();
	DataSet dsFavoriteMenuHeaderPage = (DataSet)session.getAttribute("FavoriteMenuDataSet");

	boolean hasQuickMenuAccessHeaderPage = (dsMenuHeaderPage.getRowIndex("PATH", "QM") >= 0) ? true : false;
	String quickMenuNameHeaderPage = dsQuickMenuHeaderPage.getValue("MENU_NAME_"+languageCodeHeaderPage);
	String quickMenuIconHeaderPage = dsQuickMenuHeaderPage.getValue("MENU_ICON");

	String dataSourceNamesHeaderPage[] = CommonUtil.split(ConfigUtil.getProperty("jdbc.multipleDatasource"), ConfigUtil.getProperty("delimiter.data"));
	String databaseHeaderPage = CommonUtil.nvl((String)session.getAttribute("DatabaseQuickSearch"), dataSourceNamesHeaderPage[0]);
	String personNumberHeaderPage = CommonUtil.nvl((String)session.getAttribute("PersonNumberForAdminTool"));
	String personInfoHeaderPage = "";
	if (CommonUtil.isNotBlank(personNumberHeaderPage)) {personInfoHeaderPage = (String)session.getAttribute("PersonFullNameForAdminTool")+" ("+personNumberHeaderPage+")";}
	String organisationIdHeaderPage = CommonUtil.nvl((String)session.getAttribute("OrganisationIdForAdminTool"));
	String organisationInfoHeaderPage = "";
	if (CommonUtil.isNotBlank(organisationIdHeaderPage)) {organisationInfoHeaderPage = (String)session.getAttribute("OrganisationNameForAdminTool")+" ("+organisationIdHeaderPage+")";}
	String assignmentIdHeaderPage = CommonUtil.nvl((String)session.getAttribute("AssignmentIdForAdminTool"));
	String assignmentInfoHeaderPage = "";
	if (CommonUtil.isNotBlank(assignmentIdHeaderPage)) {assignmentInfoHeaderPage = (String)session.getAttribute("AssignmentNumberForAdminTool");}
%>
<%/************************************************************************************************
* Stylesheet & Javascript
************************************************************************************************/%>
<style type="text/css">
.sessionDesc {float:left;}
</style>
<script type="text/javascript">
var popupUserProfile, popupQuickMenu, popupFavoriteMenu;
var hasQuickMenuAccessHeaderPage = "<%=hasQuickMenuAccessHeaderPage%>";
var authGroupIdHeaderPage = "<%=authGroupIdHeaderPage%>";

$(function() {
	$("#aLogo").click(function(event) {
		$("#hdnHeaderMenuId").val("");
		$("#hdnHeaderMenuName").val("");
		$("#hdnHeaderMenuUrl").val("");
		$("#hdnLeftMenuId").val("");
		$("#hdnLeftMenuName").val("");
		$("#hdnLeftMenuUrl").val("");

		commonJs.doSubmit({form:$("form:eq(0)"), action:"<%=defaultStartUrlHeaderPage%>"});
	});

	$("#aFrameworkMenu").click(function() {
		$("#hdnHeaderMenuId").val("");
		$("#hdnHeaderMenuName").val("");
		$("#hdnHeaderMenuUrl").val("");
		$("#hdnLeftMenuId").val("");
		$("#hdnLeftMenuName").val("");
		$("#hdnLeftMenuUrl").val("");

		commonJs.doSubmit({form:$("form:eq(0)"), action:"/zebra/main/getDefault.do"});
	});

	$("#aQuickMenu").click(function() {
		$("#divQuickMenu").addClass("selected");
		$("#divQuickMenu").trigger("click");
		$("#divFavoriteMenu").removeClass("selected");
		$("#divLoggedInUser").removeClass("selected");
	});

	$("#aFavoriteMenu").click(function() {
		$("#divFavoriteMenu").addClass("selected");
		$("#divFavoriteMenu").trigger("click");
		$("#divQuickMenu").removeClass("selected");
		$("#divLoggedInUser").removeClass("selected");
	});

	$("#aLoggedInUser").click(function() {
		$("#divLoggedInUser").addClass("selected");
		$("#divLoggedInUser").trigger("click");
		$("#divQuickMenu").removeClass("selected");
		$("#divFavoriteMenu").removeClass("selected");
	});

	$("#aDeleteSessionDesc").click(function() {
		commonJs.ajaxSubmit({
			url:"/login/removeSessionValuesForAdminTool.do",
			dataType:"json",
			data:{
			},
			success:function(data, textStatus) {
				var result = commonJs.parseAjaxResult(data, textStatus, "json");
				if (result.isSuccess == true || result.isSuccess == "true") {
					$("#divDbInfo").html("Database : <%=dataSourceNamesHeaderPage[0]%>");
					$("#divPersonInfo").html("");
					$("#divOrgInfo").html("");
				} else {
					commonJs.error(result.message);
				}
			}
		});
	});

	doMainMenu = function(menuId, menuName, menuUrl) {
		if (menuUrl == "#") {
			menuUrl = "/index.do";
		}
		$("#hdnHeaderMenuId").val(menuId);
		$("#hdnHeaderMenuName").val(menuName);
		$("#hdnHeaderMenuUrl").val(menuUrl);
		$("#hdnLeftMenuId").val("");
		$("#hdnLeftMenuName").val("");
		$("#hdnLeftMenuUrl").val("");

		commonJs.doSubmit({form:$("form:eq(0)"), action:menuUrl});
	};

	setThemeSelectorContextMenu = function() {
		var theme = commonJs.getDataSetFromJavaDataSet("<%=dsThemeTypeHeaderPage.toStringForJs()%>");
		var themeMenu = [];

		for (var i=0; i<theme.getRowCnt(); i++) {
			var themeCode = commonJs.lowerCase(theme.getValue(i, "COMMON_CODE"));

			if (themeCode != "theme999") {
				themeMenu.push({
					name:theme.getValue(i, "DESCRIPTION_EN"),
					img:"<mc:cp key="imgIcon"/>/"+themeCode+".png",
					themeId:theme.getValue(i, "COMMON_CODE"),
					fun:function() {
						var index = $(this).index();

						commonJs.doSubmit({
							data:{
								themeId:themeMenu[index].themeId
							},
							action:"/index.do"
						});
					}
				});
			}
		}

		$("#aThemeSelector").contextMenu(themeMenu, {
			classPrefix:com.constants.ctxClassPrefixTheme,
			effectDuration:100,
			effect:"fade",
			borderRadius:"bottom 5px",
			displayAround:"trigger",
			position:"bottom",
			heightAdjust:5,
			horAdjust:-5,
			verAdjust:-3
		});
	};

	setFavoriteMenuContextMenu = function() {
		var favMenu = commonJs.getDataSetFromJavaDataSet("<%=dsFavoriteMenuHeaderPage.toStringForJs()%>");
		var languageCode = jsconfig.get("langCode").toUpperCase();
		var ctxMenu = [];

		ctxMenu.push({
			name:"Add To Favorite Menu",
			img:"fa-plus-square",
			fun:function() {
				var leftMenuId = $("[name=hdnLeftMenuId]").val();

				if (commonJs.isBlank(leftMenuId)) {
					commonJs.error("Please open left menu.");
				} else {
					if (favMenu.getRowIndex("LEFT_MENU_ID", leftMenuId) >= 0) {
						commonJs.warn("Menu item has already been added.");
					} else {
						commonJs.doSave({
							url:"/common/commonFunction/saveFavoriteMenu.do",
							noForm:true,
							data:{menuId:leftMenuId},
							onSuccess:function(result) {
								doLeftMenu($("[name=hdnLeftMenuId]").val(), $("[name=hdnLeftMenuName]").val(), $("[name=hdnLeftMenuUrl]").val());
							}
						});
					}
				}
			}
		});
		ctxMenu.push({
			name:"Delete Favorite Menu",
			img:"fa-trash",
			fun:function() {
				popupFavoriteMenu = commonJs.openPopup({
					popupId:"DeleteFavoriteMenu",
					url:"/common/commonFunction/getFavoriteMenu.do",
					data:{},
					header:"Favorite Menu",
					blind:false,
					draggable:true,
					width:900,
					height:500
				});
			}
		});

		for (var i=0; i<favMenu.getRowCnt(); i++) {
			if (i == 0) {
				ctxMenu.push({name:"breaker"});
			}

			ctxMenu.push({
				name:favMenu.getValue(i, "LEFT_MENU_NAME_"+languageCode),
				menuId:favMenu.getValue(i, "LEFT_MENU_ID"),
				menuUrl:favMenu.getValue(i, "LEFT_MENU_URL"),
				headerMenuName:favMenu.getValue(i, "HEADER_MENU_NAME_"+languageCode),
				headerMenuId:favMenu.getValue(i, "HEADER_MENU_ID"),
				headerMenuUrl:favMenu.getValue(i, "HEADER_MENU_URL"),
				fun:function() {
					var index = $(this).index();

					$("[name=hdnHeaderMenuId]").val(ctxMenu[index].headerMenuId);
					$("[name=hdnHeaderMenuName]").val(ctxMenu[index].headerMenuName);
					$("[name=hdnHeaderMenuUrl]").val(ctxMenu[index].headerMenuUrl);
					doLeftMenu(ctxMenu[index].menuId, ctxMenu[index].name, ctxMenu[index].menuUrl);
				}
			});
		}

		$("#divFavoriteMenu").contextMenu(ctxMenu, {
			classPrefix:com.constants.ctxClassPrefixHeader,
			effectDuration:100,
			effect:"fade",
			borderRadius:"bottom 3px",
			displayAround:"trigger",
			position:"bottom",
			onClose:function() {
				$("#divFavoriteMenu").removeClass("selected");
			}
		});
	};

	setQuickMenuContextMenu = function() {
		var quickMenu = commonJs.getDataSetFromJavaDataSet("<%=dsQuickMenuHeaderPage.toStringForJs()%>");
		var languageCode = jsconfig.get("langCode").toUpperCase();
		var ctxMenu = [];

		for (var i=0; i<quickMenu.getRowCnt(); i++) {
			if (quickMenu.getValue(i, "LEVEL") != "1") {
				ctxMenu.push({
					name:quickMenu.getValue(i, "MENU_NAME_"+languageCode),
					img:"<mc:cp key="imgThemeCom"/>/"+quickMenu.getValue(i, "MENU_ICON")+"_Black.png",
					menuId:quickMenu.getValue(i, "MENU_ID"),
					menuUrl:quickMenu.getValue(i, "MENU_URL"),
					fun:function() {
						var index = $(this).index();
						doQuickMenu(ctxMenu[index].name, ctxMenu[index].menuId, ctxMenu[index].menuUrl);
					}
				});
			}
		}

		$("#divQuickMenu").contextMenu(ctxMenu, {
			classPrefix:com.constants.ctxClassPrefixHeader,
			effectDuration:100,
			effect:"fade",
			borderRadius:"bottom 3px",
			displayAround:"trigger",
			position:"bottom",
			onClose:function() {
				$("#divQuickMenu").removeClass("selected");
			}
		});
	};

	setLoginUserContextMenu = function() {
		ctxMenu.loggedInUser[0].fun = function() {getMyProfile("<%=userIdHeaderPage%>");};
		ctxMenu.loggedInUser[1].fun = function() {logout();};
		$("#divLoggedInUser").contextMenu(ctxMenu.loggedInUser, {
			classPrefix:com.constants.ctxClassPrefixHeader,
			effectDuration:100,
			effect:"fade",
			borderRadius:"bottom 3px",
			displayAround:"trigger",
			position:"bottom",
			verAdjust:0,
			onClose:function() {
				$("#divLoggedInUser").removeClass("selected");
			}
		});
	};

	getMyProfile = function(userId) {
		popupUserProfile = commonJs.openPopup({
			popupId:"UserProfile",
			url:"/common/commonFunction/getUserProfile.do",
			data:{
				userId:userId
			},
			header:"User Profile Detail",
			blind:true,
			width:750,
			height:510
		});
	};

	doQuickMenu = function(menuName, menuId, menuUrl) {
		var width = 0, height = 0;

		if (menuId == "QM10") {
			width = 400, height = 238;
		} else if (menuId == "QM20") {
			width = 1700, height = 894;
		} else if (menuId == "QM30") {
			width = 1700, height = 894;
		} else if (menuId == "QM40") {
			width = 1700, height = 894;
		}

		popupQuickMenu = commonJs.openPopup({
			popupId:menuId,
			url:menuUrl,
			data:{
				menuId:menuId
			},
			header:menuName,
			blind:true,
			width:width,
			height:height
		});
	};

	logout = function() {
		commonJs.doSubmit({form:$("form:eq(0)"), action:"/login/logout.do"});
	};

	$(window).load(function() {
		setThemeSelectorContextMenu();
		setFavoriteMenuContextMenu();

		if (commonJs.toBoolean(hasQuickMenuAccessHeaderPage)) {
			setQuickMenuContextMenu();
		}

		setLoginUserContextMenu();
	});
});
</script>
<%/************************************************************************************************
* Real Contents
************************************************************************************************/%>
<div id="divHeaderLeft"></div>
<div id="divHeaderCenter">
	<div id="divGlobalMenuHeaderGroup">
		<div id="divGlobalMenuLeft">
			<div id="divLogoArea">
				<a id="aLogo">PERCI</a>
			</div>
		</div>
		<div id="divGlobalMenuRight">
			<div id="divGblMenuArea">
				<div id="divUsingUserAs" class="headerGblMenus" style="cursor:default;">
					<div id="divDbInfo" class="sessionDesc"><%if (CommonUtil.isNotBlank(databaseHeaderPage)) {%>Database : <%=databaseHeaderPage%><%}%></div>
					<div id="divPersonInfo" class="sessionDesc"><%if (CommonUtil.isNotBlank(personInfoHeaderPage)) {%> | Person : <%=personInfoHeaderPage%><%}%></div>
					<div id="divOrgInfo" class="sessionDesc"><%if (CommonUtil.isNotBlank(organisationInfoHeaderPage)) {%> | Org : <%=organisationInfoHeaderPage%><%}%></div>
					<div id="divAsgInfo" class="sessionDesc"><%if (CommonUtil.isNotBlank(assignmentInfoHeaderPage)) {%> | Asg : <%=assignmentInfoHeaderPage%><%}%></div>
				</div>
				<div class="divGblMenuBreak"></div>
				<div class="headerGblMenus" style="margin-top:-1px;"><a id="aDeleteSessionDesc" class="fa fa-trash fa-lg aEn" title="Delete all session values"></a></div>
				<div class="divGblMenuBreak"></div>
				<div id="divThemeSelector" class="headerGblMenus">
					<a id="aThemeSelector">${sessionScope.themeName}</a>
				</div>
<%
				if (CommonUtil.equals(userIdHeaderPage, "0")) {
%>
				<div class="divGblMenuBreak"></div>
				<div id="divFrameworkMenu" class="headerGblMenus">
					<a id="aFrameworkMenu">Framework Menu</a>
				</div>
<%
				}
%>
			</div>
		</div>
	</div>
	<div id="divMainMenuHeaderGroup">
		<div id="divMainMenuAreaLeft">
<%
		for (int i=0; i<dsMenuHeaderPage.getRowCnt(); i++) {
			if (CommonUtil.equals(dsMenuHeaderPage.getValue(i, "LEVEL"), "1") && !CommonUtil.equals(dsMenuHeaderPage.getValue(i, "MENU_ID"), "QM")) {
				String menuId = dsMenuHeaderPage.getValue(i, "MENU_ID");
				String menuName = dsMenuHeaderPage.getValue(i, "MENU_NAME_"+languageCodeHeaderPage);
				String menuUrl = dsMenuHeaderPage.getValue(i, "MENU_URL");
				String icon = dsMenuHeaderPage.getValue(i, "MENU_ICON");
				String selected = (CommonUtil.equals(menuId, selectedHeaderMenuHeaderPage)) ? "Selected" : "";
%>
				<div id="div<%=menuId%>" class="headerMainMenus<%=selected%>" onclick="doMainMenu('<%=menuId%>', '<%=menuName%>', '<%=menuUrl%>')">
					<a style="background:url(<mc:cp key="imgThemeCom"/>/<%=icon%>_<mc:cp key="headMainMenuIconColor"/>.png) no-repeat 0px 0px"><%=menuName%></a>
				</div>
<%
			}
		}
%>
		</div>
		<div id="divMainMenuAreaRight">
			<div id="divFavoriteMenu" class="headerMainMenus">
				<a id="aFavoriteMenu" style="background:url(<mc:cp key="imgThemeCom"/>/icnStar_<mc:cp key="headMainMenuIconColor"/>.png) no-repeat 0px 50%;padding:4px 0px 4px 25px;">
					Bookmarks
				</a>
			</div>
<%
		if (hasQuickMenuAccessHeaderPage) {
%>
			<div id="divQuickMenu" class="headerMainMenus">
				<a id="aQuickMenu" style="background:url(<mc:cp key="imgThemeCom"/>/<%=quickMenuIconHeaderPage%>_<mc:cp key="headMainMenuIconColor"/>.png) no-repeat 0px 50%;padding:4px 0px 4px 25px;">
					<%=quickMenuNameHeaderPage%>
				</a>
			</div>
<%
		}
%>
			<div id="divLoggedInUser" class="headerMainMenus">
				<a id="aLoggedInUser"><%=userNameHeaderPage%></a>
			</div>
		</div>
	</div>
</div>
<div id="divHeaderRight"></div>
<%/************************************************************************************************
* Additional Elements
************************************************************************************************/%>
<input type="hidden" id="hdnHeaderMenuId" name="hdnHeaderMenuId" value="${sessionScope.headerMenuId}"/>
<input type="hidden" id="hdnHeaderMenuName" name="hdnHeaderMenuName" value="${sessionScope.headerMenuName}"/>
<input type="hidden" id="hdnHeaderMenuUrl" name="hdnHeaderMenuUrl" value="${sessionScope.headerMenuUrl}"/>