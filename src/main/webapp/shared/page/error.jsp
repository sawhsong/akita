<%/************************************************************************************************
* Description
* - 
************************************************************************************************/%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"%>
<%@ page import="org.apache.logging.log4j.*, java.util.*, java.io.*, zebra.util.WebUtil, zebra.util.CommonUtil"%>
<%
if (CommonUtil.toBoolean(request.getHeader("isAjaxCallForFramework"))) {
	out.println((String)request.getAttribute("javax.servlet.error.message"));
} else {
	Integer statusCode = (Integer)request.getAttribute("javax.servlet.error.status_code");
	String errorMessage = (String)request.getAttribute("javax.servlet.error.message");
	if (CommonUtil.isNotBlank(errorMessage)) {
		Logger logger = LogManager.getLogger(getClass());
		logger.error("[Exception] [Error Code : "+statusCode+"] => "+errorMessage);
	}
%>
<%/************************************************************************************************
* HTML
************************************************************************************************/%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<link rel="icon" href="data:;base64,iVBORw0KGgo=">
<head>
<title>Error</title>
<%/************************************************************************************************
* Stylesheet & Javascript
************************************************************************************************/%>
<script type="text/javascript" src="/shared/resource/js/jquery/jquery-2.1.4.js"></script>
<style type="text/css">
body {
	padding:10px 10px;
	font:12px/1.2 "Verdana", "Malgun Gothic", "Sans-serif";
}
.errorCodeBox {
	margin:0px auto;
	padding:10px 0px 10px 0px;
	font-weight:bold;
	color:#CD0A0A;
	width:200px;
}
.errorIcon {
	margin:7px 12px 0px 14px;
	float:left;
}
.errorTitle {
	line-height:1.5;
}
.errorMessageBox {
	margin:0px auto;
	padding:10px 0px 10px 0px;
	text-align:center;
	color:#CD0A0A;
	width:95%;
	line-height:1.5;
}
.errorMessage {}
.buttonBox {
	margin:0px auto;
	padding:10px 0px 10px 0px;
	text-align:center;
	font-weight:bold;
}
.button {
	display:inline-block;
	outline:none;
	cursor:pointer;
	text-align:center;
	text-decoration:none;
	font:12px/100% Arial, Helvetica, sans-serif;
	font-weight:bold;
	padding:.4em .8em;
	text-shadow:0 1px 1px rgba(0,0,0,.3);
	border-radius:.3em;
	box-shadow:0 1px 2px rgba(0,0,0,.2);
}
.button:hover {
	text-decoration:none;
}
.button:active {
	position:relative;
	top:1px;
}
.red {
	color:#ffffff;
	border:solid 1px #980c10;
	background:#d81b21;
	background:-webkit-gradient(linear, left top, left bottom, from(#ed1c24), to(#aa1317));
	background:-moz-linear-gradient(top,  #ed1c24,  #aa1317);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#ed1c24', endColorstr='#aa1317');
}
.red:hover {
	background:#b61318;
	background:-webkit-gradient(linear, left top, left bottom, from(#c9151b), to(#a11115));
	background:-moz-linear-gradient(top,  #c9151b,  #a11115);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#c9151b', endColorstr='#a11115');
}
.red:active {
	color:#ffffff;
	background:-webkit-gradient(linear, left top, left bottom, from(#aa1317), to(#ed1c24));
	background:-moz-linear-gradient(top,  #aa1317,  #ed1c24);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#aa1317', endColorstr='#ed1c24');
}
</style>
<script type="text/javascript">
$(function() {
	clickButton = function() {
		history.go(-1);
	};
});
</script>
</head>
<%/************************************************************************************************
* Page & Header
************************************************************************************************/%>
<body>
<form id="fmDefault" name="fmDefault" method="post" action="">
<div id="errorPage">
<%/************************************************************************************************
* Real Contents
************************************************************************************************/%>
<div class="errorCodeBox">
	<div class="errorIcon"><img src="/shared/resource/image/icon/error.png"/></div>
	<div class="errorTitle">
		Exception occurred !<br/>
		[Error Code : ${requestScope["javax.servlet.error.status_code"]}]
	</div>
</div>
<div class="errorMessageBox">
	<div class="errorMessage">
		Error Message : ${requestScope["javax.servlet.error.message"]}
	</div>
</div>
<div class="buttonBox">
	<a class="button red" onclick="clickButton()">Back</a>
</div>
<%/************************************************************************************************
* Right & Footer
************************************************************************************************/%>
<%/************************************************************************************************
* Additional Elements
************************************************************************************************/%>
</div>
</form>
<%/************************************************************************************************
* Additional Form
************************************************************************************************/%>
</body>
</html>
<%
}
%>