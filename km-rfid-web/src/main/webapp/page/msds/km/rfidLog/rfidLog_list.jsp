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
				data="[{'id':'id','text':'ID'},{'id':'createDate','text':'创建时间'},{'id':'modifyDate','text':'修改时间'},{'id':'epcNo','text':'epc号'},{'id':'proviceId','text':'省ID'},{'id':'cityId','text':'市ID'},{'id':'streetId','text':'街道ID'},{'id':'fullArea','text':'地址全称'}]" />
				<input id="key"	class="mini-textbox" emptyText="请输入" style="width:150px;"
					onenter="onKeyEnter" /> <a class="mini-button" onclick="search()">查询</a>
				</td>
			</tr>
		</table>
	</div>
	<div class="mini-fit">
		<div id="datagrid_rfidLog" class="mini-datagrid"
			style="width:100%;height:100%;" borderStyle="border:0;"
			url="${ctx}/rfidLog/dataList.action" idField="id"
			allowAlternating="true" sortField="id" sortOrder="desc"
			onrowdblclick="rowdblclick" multiSelect="true">
			<div property="columns">
				<div type="checkcolumn"></div>
					<div field="createDate" dateFormat="yyyy-MM-dd H:mm:ss" headerAlign="center" allowSort="true">创建时间</div>
					<div field="modifyDate" dateFormat="yyyy-MM-dd H:mm:ss" headerAlign="center" allowSort="true">修改时间</div>
					<div field="epcNo"headerAlign="center" allowSort="true">epc号</div>
					<div field="proviceId"headerAlign="center" allowSort="true">省ID</div>
					<div field="cityId"headerAlign="center" allowSort="true">市ID</div>
					<div field="streetId"headerAlign="center" allowSort="true">街道ID</div>
					<div field="fullArea"headerAlign="center" allowSort="true">地址全称</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="<%=ctx%>/page/msds/km/rfidLog/rfidLog_list.js"></script>
</html>