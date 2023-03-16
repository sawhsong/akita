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
	String email = dsRequest.getValue("email");
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
.form-control {padding:6px 12px;}
.panelHolder {margin:0px auto;width:100%;text-align:center;}
.panel {margin-top:20px;display:inline-block;width:90%;}
.panel-body {padding:25px 25px 20px 25px;}
.addonIcon {width:16px;}
.input-group {padding-bottom:4px;}
.buttonDiv {padding-top:18px;padding-bottom:0px;}
</style>
<script type="text/javascript" src="<mc:cp key="commonModuleViewPageJsName"/>"></script>
<script type="text/javascript">
var loginId = "<%=loginId%>", email = "<%=email%>";
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
			<div class="input-group">
				<div class="input-group-addon"><ui:icon className="fa-user fa-lg addonIcon" status="display" title="Login Id"/></div>
				<ui:text name="loginId" value="<%=loginId%>" className="form-control" placeHolder="page.com.loginId" checkName="page.com.loginId" options="mandatory"/>
			</div>
			<div class="input-group">
				<div class="input-group-addon"><ui:icon className="fa-envelope fa-lg addonIcon" status="display" title="Email"/></div>
				<ui:text name="email" value="<%=email%>" className="form-control" placeHolder="page.com.email" checkName="page.com.email" options="mandatory" option="email"/>
			</div>
			<div class="buttonDiv">
				<ui:button id="btnReset" type="primary" caption="button.com.emailNewPassword" iconClass="fa-send" buttonStyle="padding-top:8px;width:100%;height:40px;font-size:14px;"/>
			</div>
		</div>
	</div>
</div>
</form>
</body>
</html>