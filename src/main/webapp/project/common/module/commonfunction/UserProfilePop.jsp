<%/************************************************************************************************
* Description
* - UserProfile
************************************************************************************************/%>
<%@ include file="/shared/page/incCommon.jsp"%>
<%/************************************************************************************************
* Declare objects & variables
************************************************************************************************/%>
<%
	ParamEntity pe = (ParamEntity)request.getAttribute("paramEntity");
	DataSet dsRequest = (DataSet)pe.getRequestDataSet();
	SysUser sysUser = (SysUser)pe.getObject("sysUser");
	String maxRowPerPage[] = (String[])pe.getObject("maxRowPerPage");
	String pageNumPerPage[] = (String[])pe.getObject("pageNumPerPage");

	pageContext.setAttribute("maxRowPerPage", maxRowPerPage);
	pageContext.setAttribute("pageNumPerPage", pageNumPerPage);
%>
<%/************************************************************************************************
* HTML
************************************************************************************************/%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<link rel="icon" type="image/png" href="<mc:cp key="imgIcon"/>/faviconPerci.png">
<title><mc:msg key="main.system.title"/></title>
<%/************************************************************************************************
* Stylesheet & Javascript
************************************************************************************************/%>
<%@ include file="/shared/page/incCssJs.jsp"%>
<style type="text/css">
</style>
<script type="text/javascript" src="<mc:cp key="viewPageJsName"/>"></script>
<script type="text/javascript">
</script>
</head>
<%/************************************************************************************************
* Page & Header
************************************************************************************************/%>
<body>
<form id="fmDefault" name="fmDefault" method="post" action="">
<div id="divPopupWindowHolder">
<div id="divFixedPanelPopup">
<div id="divLocationPathArea"><%@ include file="/project/common/include/bodyLocationPathArea.jsp"%></div>
<%/************************************************************************************************
* Real Contents - fixed panel(tab, button, search, information)
************************************************************************************************/%>
<div id="divTabArea"></div>
<div id="divButtonArea" class="areaContainerPopup">
	<div id="divButtonAreaLeft"></div>
	<div id="divButtonAreaRight">
		<ui:buttonGroup id="buttonGroup">
			<ui:button id="btnChangePassword" caption="Change Password" iconClass="fa-lock fa-lg"/>
			<ui:button id="btnResetPassword" caption="Reset Password" iconClass="fa-lock fa-lg"/>
			<ui:button id="btnSave" caption="button.com.save"/>
			<ui:button id="btnClose" caption="button.com.close"/>
		</ui:buttonGroup>
	</div>
</div>
<div id="divSearchCriteriaArea"></div>
<div id="divInformArea">
</div>
<%/************************************************************************************************
* End of fixed panel
************************************************************************************************/%>
<div class="breaker"></div>
</div>
<div id="divScrollablePanelPopup">
<%/************************************************************************************************
* Real Contents - scrollable panel(data, paging)
************************************************************************************************/%>
<div id="divDataArea" class="areaContainerPopup">
	<div class="panel panel-default" style="width:120px;height:110px;">
		<div class="panel-body">
			<table class="tblDefault">
				<tr>
					<td class="tdDefaultCt">
						<img id="img<%=sysUser.getUserId()%>" src="<%=sysUser.getPhotoPath()%>" class="imgDis" style="width:100px;height:90px;" title="<%=sysUser.getUserName()%>"/>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<table class="tblEdit">
		<colgroup>
			<col width="22%"/>
			<col width="28%"/>
			<col width="22%"/>
			<col width="28%"/>
		</colgroup>
		<tr>
			<th class="thEdit rt">Change Photo</th>
			<td class="tdEdit" colspan="3"><ui:file name="filePhotoPath" style="width:540px;" checkName="Change Photo"/></td>
		</tr>
		<tr>
			<th class="thEdit rt">User Id</th>
			<td class="tdEdit"><ui:text name="userId" value="<%=sysUser.getUserId()%>" status="display"/></td>
			<th class="thEdit rt">Login Id</th>
			<td class="tdEdit"><ui:text name="loginId" value="<%=sysUser.getLoginId()%>" checkName="Login Id" options="mandatory"/></td>
		</tr>
		<tr>
			<th class="thEdit rt">User Name</th>
			<td class="tdEdit"><ui:text name="userName" value="<%=sysUser.getUserName()%>" checkName="User Name" options="mandatory"/></td>
			<th class="thEdit rt">Password</th>
			<td class="tdEdit"><ui:password name="loginPassword" value="************" status="display"/></td>
		</tr>
		<tr>
			<th class="thEdit rt">Language</th>
			<td class="tdEdit"><ui:ccselect name="language" selectedValue="<%=sysUser.getLanguage()%>" codeType="LANGUAGE_TYPE" options="mandatory"/></td>
			<th class="thEdit rt">Theme Type</th>
			<td class="tdEdit"><ui:ccselect name="themeType" selectedValue="<%=sysUser.getThemeType()%>" codeType="USER_THEME_TYPE" options="mandatory"/></td>
		</tr>
		<tr>
			<th class="thEdit rt">Data Rows Per Page</th>
			<td class="tdEdit">
				<select id="maxRowsPerPage" name="maxRowsPerPage" class="bootstrapSelect">
<%
				for (int i=0; i<maxRowPerPage.length; i++) {
					String selected = (CommonUtil.equals(maxRowPerPage[i], CommonUtil.toString(sysUser.getMaxRowPerPage(), "###"))) ? "selected" : "";
%>
					<option value="<%=maxRowPerPage[i]%>" <%=selected%>><%=maxRowPerPage[i]%></option>
<%
				}
%>
				</select>
			</td>
			<th class="thEdit rt">Page Count Per Page</th>
			<td class="tdEdit">
				<select id="pageNumsPerPage" name="pageNumsPerPage" class="bootstrapSelect">
<%
				for (int i=0; i<pageNumPerPage.length; i++) {
					String selected = (CommonUtil.equals(pageNumPerPage[i], CommonUtil.toString(sysUser.getPageNumPerPage(), "###"))) ? "selected" : "";
%>
					<option value="<%=pageNumPerPage[i]%>" <%=selected%>><%=pageNumPerPage[i]%></option>
<%
				}
%>
				</select>
			</td>
		</tr>
		<tr>
			<th class="thEdit rt">Authentication Key</th>
			<td class="tdEdit" colspan="3">
				<ui:text name="authenticationSecretKey" value="<%=sysUser.getAuthenticationSecretKey()%>" checkName="Authentication Key" className="hor" style="width:77%;"/>
				<ui:button id="btnGetAuthenticationSecretKey" caption="Generate Key" iconClass="fa-key"/>
			</td>
		</tr>
		<tr>
			<th class="thEdit rt">Email</th>
			<td class="tdEdit" colspan="3"><ui:text name="email" value="<%=sysUser.getEmail()%>" checkName="Email" options="mandatory" option="email"/></td>
		</tr>
	</table>
</div>
<div id="divPagingArea"></div>
<%/************************************************************************************************
* Right & Footer
************************************************************************************************/%>
</div>
</div>
<%/************************************************************************************************
* Additional Elements
************************************************************************************************/%>
</form>
<%/************************************************************************************************
* Additional Form
************************************************************************************************/%>
<form id="fmHidden" name="fmHidden" method="post" action=""></form>
</body>
</html>