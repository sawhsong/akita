<%/************************************************************************************************
* Description - SysUser - User
*	- Generated by Source Generator
************************************************************************************************/%>
<%@ include file="/shared/page/incCommon.jsp"%>
<%/************************************************************************************************
* Declare objects & variables
************************************************************************************************/%>
<%
	ParamEntity paramEntity = (ParamEntity)request.getAttribute("paramEntity");
	DataSet requestDataSet = (DataSet)paramEntity.getRequestDataSet();
	DataSet authGroupDataSet = (DataSet)paramEntity.getObject("authGroupDataSet");
	String mode = requestDataSet.getValue("mode");
	String defaultAuthGroup = "Z";
	String defaultUserType = CommonCodeManager.getCodeByConstants("USER_TYPE_EXTERNAL");
	String defaultUserStatus = CommonCodeManager.getCodeByConstants("USER_STATUS_NU");
	String defaultActive = CommonCodeManager.getCodeByConstants("IS_ACTIVE_Y");

	pageContext.setAttribute("defaultUserType", defaultUserType);
	pageContext.setAttribute("defaultUserStatus", defaultUserStatus);
	pageContext.setAttribute("defaultActive", defaultActive);
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
var mode = "<%=mode%>";
var defaultAuthGroup = "<%=defaultAuthGroup%>";
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
			<ui:button id="btnSave" caption="button.com.save"/>
			<ui:button id="btnClose" caption="button.com.close"/>
		</ui:buttonGroup>
	</div>
</div>
<div id="divSearchCriteriaArea"></div>
<div id="divInformArea"></div>
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
	<div id="divUpdateAuthGroup">
		<table class="tblEdit">
			<caption class="captionEdit">Update Authority Group to :</caption>
			<tr>
				<td class="tdEdit" id="tdAuthGroup"></td>
			</tr>
		</table>
	</div>
	<div id="divUpdateUserType">
		<table class="tblEdit">
			<caption class="captionEdit">Update User Type to :</caption>
			<tr>
				<td class="tdEdit">
					<ui:ccradio name="userType" codeType="USER_TYPE" selectedValue="${defaultUserType}" displayType="block" isCustomised="true"/>
				</td>
			</tr>
		</table>
	</div>
	<div id="divUpdateUserStatus">
		<table class="tblEdit">
			<caption class="captionEdit">Update User Status to :</caption>
			<tr>
				<td class="tdEdit">
					<ui:ccradio name="userStatus" codeType="USER_STATUS" selectedValue="${defaultUserStatus}" displayType="block" isCustomised="true"/>
				</td>
			</tr>
		</table>
	</div>
	<div id="divUpdateActiveStatus">
		<table class="tblEdit">
			<caption class="captionEdit">Update Active Status to :</caption>
			<tr>
				<td class="tdEdit">
					<ui:ccradio name="activeStatus" codeType="IS_ACTIVE" selectedValue="${defaultActive}" displayType="block" isCustomised="true"/>
				</td>
			</tr>
		</table>
	</div>
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