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
				<input id="searchField" class="mini-combobox" style="width:75px;" value="id"
				data="[{'id':'id','text':'ID'},{'id':'createDate','text':'创建时间'},{'id':'modifyDate','text':'修改时间'},{'id':'orders','text':'区域排序'},{'id':'fullName','text':'区域全称'},{'id':'name','text':'名称'},{'id':'treePath','text':'树'},{'id':'parent','text':'父ID'},{'id':'parentAreaCode','text':'父区域代码'},{'id':'areaCode','text':'区域代码'},{'id':'level','text':'等级'},{'id':'regionType','text':'1（省直辖市）2（地级市）3（区县）4（乡镇）'}]" />
				<input id="key"	class="mini-textbox" emptyText="请输入" style="width:150px;"
					onenter="onKeyEnter" /> <a class="mini-button" onclick="search()">查询</a>
				</td>
			</tr>
		</table>
	</div>
	<div class="mini-fit">
		<div id="datagrid_area" class="mini-datagrid"
			style="width:100%;height:100%;" borderStyle="border:0;"
			url="${ctx}/area/dataList.action" idField="id"
			allowAlternating="true" sortField="id" sortOrder="desc"
			onrowdblclick="rowdblclick" multiSelect="true">
			<div property="columns">
				<div type="checkcolumn"></div>
					<div field="createDate" dateFormat="yyyy-MM-dd H:mm:ss" headerAlign="center" allowSort="true">创建时间</div>
					<div field="modifyDate" dateFormat="yyyy-MM-dd H:mm:ss" headerAlign="center" allowSort="true">修改时间</div>
					<div field="orders"headerAlign="center" allowSort="true">区域排序</div>
					<div field="fullName"headerAlign="center" allowSort="true">区域全称</div>
					<div field="name"headerAlign="center" allowSort="true">名称</div>
					<div field="treePath"headerAlign="center" allowSort="true">树</div>
					<div field="parent"headerAlign="center" allowSort="true">父ID</div>
					<div field="parentAreaCode"headerAlign="center" allowSort="true">父区域代码</div>
					<div field="areaCode"headerAlign="center" allowSort="true">区域代码</div>
					<div field="level"headerAlign="center" allowSort="true">等级</div>
					<div field="regionType"headerAlign="center" allowSort="true">1（省直辖市）2（地级市）3（区县）4（乡镇）</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="<%=ctx%>/page/msds/km/area/area_list.js"></script>
</html>