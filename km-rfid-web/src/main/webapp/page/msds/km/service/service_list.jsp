<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<head>
<%@include file="/page/msds/common/commonjs.jsp" %>
</head>
<body>
	<div class="mini-toolbar"
		style="padding:2px;border-top:0;border-left:0;border-right:0;">
		<table id = "form" style="width:100%;">
			<tr>
				<td style="text-align:right;padding-top: 8px;">服务编码：</td>
				<td style="text-align:left;padding-top: 8px;"><input  id = "serviceCode" name = "serviceCode" class="mini-textbox"></td>
				<td style="text-align:right;padding-top: 8px;">服务名称：</td>
				<td style="text-align:left;padding-top: 8px;"><input  id = "serviceName" name = "serviceName" class="mini-textbox"></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align:right;padding-top: 8px;">
				<a class="mini-button" onclick="resetSearch('#form')" style="width:60px">重 置</a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a class="mini-button" onclick="search()" style="width:60px">查 询</a>
				</td>
			</tr>
			<tr>
				<td ><a class="mini-button"
					iconCls="icon-add" onclick="add()">增加</a><a class="mini-button"
					iconCls="icon-remove" onclick="remove()">删除</a></td>
			</tr>
		</table>
	</div>
	<div class="mini-fit">
		<div id="datagrid_service" class="mini-datagrid"
			style="width:100%;height:100%;" borderStyle="border:0;"
			url="${ctx}/service/findLikedatalist.action" idField="id"
			allowAlternating="true" sortField="id" sortOrder="desc"
			onrowdblclick="rowdblclick" multiSelect="true" >
			<div property="columns">
				<div type="checkcolumn"></div>
					<div field="serviceCode"headerAlign="center" allowSort="true">服务编码</div>
					<div field="serviceName"headerAlign="center" allowSort="true">服务名称</div>
					<div field="categoryName"headerAlign="center" allowSort="true">服务分类名称</div>
					<!-- <div field="state"headerAlign="center" allowSort="true">服务状态</div> -->
					<div field="describe"headerAlign="center" allowSort="true" >描述</div>
					<div field="username"headerAlign="center" allowSort="true">操作人</div>
					<div field="createDate" dateFormat="yyyy-MM-dd H:mm:ss" headerAlign="center" allowSort="true">创建时间</div>
					<div field="modifyDate" dateFormat="yyyy-MM-dd H:mm:ss" headerAlign="center" allowSort="true">修改时间</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="<%=ctx%>/page/msds/km/service/service_list.js"></script>
</html>