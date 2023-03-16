<%/************************************************************************************************
* Description
* - Admin Tool Area
************************************************************************************************/%>
<%
	SysUser sysUserAdminToolArea = (SysUser)session.getAttribute("SysUser");
	String authGroupIdAdminToolArea = sysUserAdminToolArea.getAuthGroupId();
	boolean isVisibleAdminToolArea = CommonUtil.toBoolean((String)session.getAttribute("isVisibleAdminTool"));
	String dataSourceNamesAdminToolArea[] = CommonUtil.split(ConfigUtil.getProperty("jdbc.multipleDatasource"), ConfigUtil.getProperty("delimiter.data"));
	String databaseAdminToolArea = CommonUtil.nvl((String)session.getAttribute("DatabaseForAdminTool"), dataSourceNamesAdminToolArea[0]);
%>
<style type="text/css">
</style>
<script type="text/javascript">
$(function() {
	$("#btnReloadUserAdminTool").click(function() {
		setSessionValuesForAdminTool();
	});

	$("#btnReturnUserAdminTool").click(function() {
		removeSessionValuesForAdminTool();
	});

	$("#databaseAdminTool").change(function() {
		setSessionValuesForAdminTool();
	});

	setSessionValuesForAdminTool = function() {
		commonJs.ajaxSubmit({
			url:"/login/setSessionValuesForAdminTool.do",
			dataType:"json",
			data:{
				databaseAdminTool:$("#databaseAdminTool").val()
			},
			success:function(data, textStatus) {
				var result = commonJs.parseAjaxResult(data, textStatus, "json");
				if (result.isSuccess == true || result.isSuccess == "true") {
					var ds = result.dataSet;

					try {
						goMenu('${sessionScope.headerMenuId}', '${sessionScope.headerMenuName}', '${sessionScope.headerMenuUrl}', '${sessionScope.leftMenuId}', '${sessionScope.leftMenuName}', '${sessionScope.leftMenuUrl}');
					} catch(e) {}
				} else {
					commonJs.error(result.message);
				}
			}
		});
	};

	removeSessionValuesForAdminTool = function() {
		commonJs.ajaxSubmit({
			url:"/login/removeSessionValuesForAdminTool.do",
			dataType:"json",
			data:{userId:""},
			success:function(data, textStatus) {
				var result = commonJs.parseAjaxResult(data, textStatus, "json");
				if (result.isSuccess == true || result.isSuccess == "true") {
					$("#databaseAdminTool").val("<%=databaseAdminToolArea%>");

					try {
						goMenu('${sessionScope.headerMenuId}', '${sessionScope.headerMenuName}', '${sessionScope.headerMenuUrl}', '${sessionScope.leftMenuId}', '${sessionScope.leftMenuName}', '${sessionScope.leftMenuUrl}');
					} catch(e) {}
				} else {
					commonJs.error(result.message);
				}
			}
		});
	};

	$(window).load(function() {
	});
});
</script>

<%
if (CommonUtil.equalsIgnoreCase(authGroupIdAdminToolArea, "0") && isVisibleAdminToolArea) {
%>
<div id="divAdminToolContainer" class="adminToolContainer">
	<table class="tblAdminTool">
		<caption><mc:msg key="page.com.adminTool"/></caption>
		<tr>
			<td class="tdAdminTool">
				<table class="tblDefault withPadding">
					<colgroup>
						<col width="80%"/>
						<col width="*"/>
					</colgroup>
					<tr>
						<td class="tdDefault Lt">
							<label for="databaseAdminTool" class="lblEn hor"><mc:msg key="page.com.atDatabase"/></label>
							<div style="float:left;padding-right:4px;">
								<ui:select name="databaseAdminTool" className="hor">
<%
								for (int i=0; i<dataSourceNamesAdminToolArea.length; i++) {
									String selected = (CommonUtil.equalsIgnoreCase(dataSourceNamesAdminToolArea[i], databaseAdminToolArea)) ? "selected" : "";
%>
									<option value="<%=dataSourceNamesAdminToolArea[i]%>" <%=selected%>><%=dataSourceNamesAdminToolArea[i]%></option>
<%
								}
%>
								</ui:select>
							</div>
						</td>
						<td class="tdDefault Rt">
							<ui:buttonGroup id="buttonGroup">
								<ui:button id="btnReloadUserAdminTool" caption="button.com.reload" iconClass="fa-refresh"/>
								<ui:button id="btnReturnUserAdminTool" caption="button.com.return" iconClass="fa-history"/>
							</ui:buttonGroup>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</div>
<%
}
%>