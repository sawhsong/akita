<%/************************************************************************************************
* Description
* - Reset Password
************************************************************************************************/%>
<%@ include file="/shared/page/incCommon.jsp"%>
<%/************************************************************************************************
* Declare objects & variables
************************************************************************************************/%>
<%
	ParamEntity pe = (ParamEntity)request.getAttribute("paramEntity");
	DataSet dsRequest = (DataSet)pe.getRequestDataSet();
	String loginId = dsRequest.getValue("loginId");
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
.panelHolder {margin:0px auto;width:100%;text-align:center;}
.panel {margin-top:20px;display:inline-block;width:90%;}
.panel-body {padding:10px 15px 10px 15px;}
</style>
<script type="text/javascript" src="<mc:cp key="commonModuleViewPageJsName"/>"></script>
<script type="text/javascript">
var loginId = "<%=loginId%>";
</script>
</head>
<%/************************************************************************************************
* Page & Header
************************************************************************************************/%>
<body>
<form id="fmDefault" name="fmDefault" method="post" action="">
<div id="divPopupWindowHolder" class="panelHolder">
	<div class="panel panel-default">
		<div class="panel-body">
			<label for="oldPassword" class="lblEn hor">Old Password</label>
			<ui:password name="oldPassword" className="hor" checkName="Old Password" options="mandatory"/>
			<label for="newPassword" class="lblEn hor">New Password</label>
			<ui:password name="newPassword" className="hor" checkName="New Password" options="mandatory"/>
			<label for="confirmPassword" class="lblEn hor">Confirm Password</label>
			<ui:password name="confirmPassword" className="hor" checkName="Confirm Password" options="mandatory"/>
			<div class="verGap20"></div>
			<ui:button id="btnSave" type="primary" caption="button.com.save"/>
		</div>
	</div>
</div>
</form>
</body>
</html>