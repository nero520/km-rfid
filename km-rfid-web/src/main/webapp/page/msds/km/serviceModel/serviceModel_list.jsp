<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<head>
<%@include file="/page/msds/common/commonjs.jsp" %>
</head>
<body>
	<div class="mini-toolbar"
		style="padding:2px;border-top:0;border-left:0;border-right:0;">
		<table style="width:100%;">
			<tr>
				<td style="width:100%;"><a class="mini-button"
					iconCls="icon-add" onclick="add()">增加</a><a class="mini-button"
					iconCls="icon-remove" onclick="remove()">删除</a></td>
				<td style="white-space:nowrap;">
				<!-- <input id="searchField" class="mini-combobox" style="width:75px;" value="id"
				data="[{'id':'id','text':'ID'},{'id':'serviceCode','text':'服务ID'},{'id':'modelId','text':'车型ID'},{'id':'mileage','text':'里程数范围'},{'id':'laborcostJson','text':'工时费集合'},{'id':'price','text':'总价'},{'id':'operator','text':'操作人'},{'id':'createDate','text':'创建时间'},{'id':'modifyDate','text':'修改时间'}]" />
				<input id="key"	class="mini-textbox" emptyText="请输入" style="width:150px;"
					onenter="onKeyEnter" /> <a class="mini-button" onclick="search()">查询</a> -->
					<input id="searchField" class="mini-combobox" style="width:75px;" value="id"
				data="[{'id':'serviceCode','text':'服务ID'}]"  emptyText="请选择" />
				<input id="key"	class="mini-textbox" emptyText="请输入" style="width:150px;"
					onenter="onKeyEnter" /> <a class="mini-button" onclick="search()">查询</a>
				</td>
			</tr>
		</table>
	</div>
	<div class="mini-fit">
		<div id="datagrid_serviceModel" class="mini-datagrid"
			style="width:100%;height:100%;" borderStyle="border:0;"
			url="${ctx}/serviceModel/dataList.action" idField="id"
			allowAlternating="true" sortField="id" sortOrder="desc"
			onrowdblclick="rowdblclick" multiSelect="true" emptyText="全部">
			<div property="columns">
				<div type="checkcolumn"></div>
					<div field="serviceCode" headerAlign="center" allowSort="true">服务ID</div>
					<div field="serviceName" headerAlign="center" allowSort="true" >服务名称</div>
					<div field="modelName"headerAlign="center" allowSort="true" >车型</div>
					<div field="mileage"headerAlign="center" allowSort="true">里程数范围</div>
					<!-- <div field="laborcostJson"headerAlign="center" allowSort="true">工时费集合</div> -->
					<div field="price"headerAlign="center" allowSort="true">总价</div>
					<div field="userName"headerAlign="center" allowSort="true">操作人</div>
					<div field="createDate" dateFormat="yyyy-MM-dd H:mm:ss" headerAlign="center" allowSort="true">创建时间</div>
					<div field="modifyDate" dateFormat="yyyy-MM-dd H:mm:ss" headerAlign="center" allowSort="true">修改时间</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="<%=ctx%>/page/msds/km/serviceModel/serviceModel_list.js"></script>
</html>