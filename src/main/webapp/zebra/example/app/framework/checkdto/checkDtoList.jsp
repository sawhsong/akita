<%/************************************************************************************************
* Description
* - 
************************************************************************************************/%>
<%@ include file="/shared/page/incCommon.jsp"%>
<%/************************************************************************************************
* Declare objects & variables
************************************************************************************************/%>
<%
	ParamEntity paramEntity = (ParamEntity)request.getAttribute("paramEntity");
	DataSet datasourceDataSet = (DataSet)paramEntity.getObject("datasourceDataSet");
	String dataSourceNames[] = CommonUtil.split(ConfigUtil.getProperty("jdbc.multipleDatasource"), ConfigUtil.getProperty("delimiter.data"));
	String dataSourceToCheck = dataSourceNames[1];
%>
<%/************************************************************************************************
* HTML
************************************************************************************************/%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<link rel="icon" type="image/png" href="<mc:cp key="imgIcon"/>/zebraFavicon.png">
<title><mc:msg key="fwk.main.system.title"/></title>
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
<div id="divHeaderHolder" class="ui-layout-north"><%@ include file="/zebra/example/common/include/header.jsp"%></div>
<div id="divBodyHolder" class="ui-layout-center">
<div id="divBodyLeft" class="ui-layout-west"><%@ include file="/zebra/example/common/include/bodyLeft.jsp"%></div>
<div id="divBodyCenter" class="ui-layout-center">
<div id="divFixedPanel">
<div id="divLocationPathArea"><%@ include file="/zebra/example/common/include/bodyLocationPathArea.jsp"%></div>
<%/************************************************************************************************
* Real Contents - fixed panel(tab, button, search, information)
************************************************************************************************/%>
<div id="divTabArea"></div>
<div id="divButtonArea" class="areaContainer">
	<div id="divButtonAreaLeft"></div>
	<div id="divButtonAreaRight">
		<ui:buttonGroup id="buttonGroup">
			<ui:button id="btnGenerate" caption="button.com.generate"/>
			<ui:button id="btnSearch" caption="button.com.search"/>
			<ui:button id="btnClear" caption="button.com.clear"/>
		</ui:buttonGroup>
	</div>
</div>
<div id="divSearchCriteriaArea" class="areaContainer">
	<div class="panel panel-default">
		<div class="panel-body">
			<table class="tblDefault">
				<tr>
					<td class="tdDefault">
						<label for="dataSourceToCheck" class="lblEn hor">Data Source To Check</label>
						<%=datasourceDataSet.getAsHtmlStringForSelectbox("VALUE", "NAME", dataSourceToCheck, "==Select==", "id:dataSourceToCheck;name:dataSourceToCheck;class:bootstrapSelect")%>
					</td>
				</tr>
			</table>
		</div>
	</div>
</div>
<div id="divInformArea"></div>
<%/************************************************************************************************
* End of fixed panel
************************************************************************************************/%>
<div class="breaker"></div>
</div>
<div id="divScrollablePanel">
<%/************************************************************************************************
* Real Contents - scrollable panel(data, paging)
************************************************************************************************/%>
<div id="divDataArea" class="areaContainer">
	<div id="divSource" style="float:left;width:70%;">
		<div id="divSourceDataTable">
			<table id="tblSourceData" class="tblGrid sort autosort">
				<colgroup>
					<col width="3%"/>
					<col width="3%"/>
					<col width="23%"/>
					<col width="21%"/>
					<col width="*"/>
					<col width="8%"/>
				</colgroup>
				<thead>
					<tr>
						<th class="thGrid"><ui:icon useFor="actionHeaderGrid"/></th>
						<th class="thGrid"><i id="icnActionCheck" class="fa fa-check-square-o fa-lg icnEn"></i></th>
						<th class="thGrid sortable:alphanumeric">Table Name</th>
						<th class="thGrid sortable:alphanumeric">DTO Name</th>
						<th class="thGrid">Table Description</th>
						<th class="thGrid sortable:alphanumeric">Is Different</th>
					</tr>
				</thead>
				<tbody id="tblSourceDataBody">
					<tr>
						<td class="tdGrid Ct" colspan="6"><mc:msg key="I002"/></td>
					</tr>
				</tbody>
			</table>
		</div>
		<div id="divSourceDataPagingArea"></div>
	</div>
	<div id="divTarget" style="float:right;width:29%;">
		<div id="divTargetDataTable">
			<table id="tblColumns" class="tblGrid sort autosort">
				<colgroup>
					<col width="50%"/>
					<col width="*"/>
				</colgroup>
				<thead>
					<tr>
						<th class="thGrid sortable:alphanumeric">Table Columns</th>
						<th class="thGrid sortable:alphanumeric">DTO Columns</th>
					</tr>
				</thead>
				<tbody id="tblColumnsBody">
					<tr>
						<td class="tdGrid Ct" colspan="2"><mc:msg key="I002"/></td>
					</tr>
				</tbody>
			</table>
		</div>
		<div id="divTargetDataPagingArea"></div>
	</div>
</div>
<%/************************************************************************************************
* Right & Footer
************************************************************************************************/%>
</div>
</div>
<div id="divBodyRight" class="ui-layout-east"><%@ include file="/zebra/example/common/include/bodyRight.jsp"%></div>
</div>
<div id="divFooterHolder" class="ui-layout-south"><%@ include file="/zebra/example/common/include/footer.jsp"%></div>
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