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
				data="[{'id':'id','text':'ID'},{'id':'createDate','text':'创建时间'},{'id':'modifyDate','text':'修改时间'},{'id':'epcNo','text':'epc号'},{'id':'userId','text':'用户ID'},{'id':'state','text':'状态：0.失效；1.有效'}]" />
				<input id="key"	class="mini-textbox" emptyText="请输入" style="width:150px;"
					onenter="onKeyEnter" /> <a class="mini-button" onclick="search()">查询</a>
				</td>
			</tr>
		</table>
	</div>
	<div class="mini-fit">
		<div id="datagrid_rfid" class="mini-datagrid"
			style="width:100%;height:100%;" borderStyle="border:0;"
			url="${ctx}/rfid/dataList.action" idField="id"
			allowAlternating="true" sortField="id" sortOrder="desc"
			onrowdblclick="rowdblclick" multiSelect="true">
			<div property="columns">
				<div type="checkcolumn"></div>
					<div field="createDate" dateFormat="yyyy-MM-dd H:mm:ss" headerAlign="center" allowSort="true">创建时间</div>
					<div field="modifyDate" dateFormat="yyyy-MM-dd H:mm:ss" headerAlign="center" allowSort="true">修改时间</div>
					<div field="epcNo"headerAlign="center" allowSort="true">epc号</div>
					<div field="userId"headerAlign="center" allowSort="true">用户ID</div>
					<div field="state"headerAlign="center" allowSort="true">状态</div>
					<div name="action"  headerAlign="center" width="150">操作</div>
			</div>
		
		</div>
	</div>
</body>
<script type="text/javascript" src="<%=ctx%>/page/msds/km/rfid/rfid_list.js"></script>
</html>