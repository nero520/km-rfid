<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<head>
<%@include file="/page/msds/common/commonjs.jsp" %>
</head>
<body>
	<div class="mini-toolbar"
		style="padding:2px;border-top:0;border-left:0;border-right:0;">
		<form id="form" class="divClass">
		<table style="width:100%;">
			<tr>
				<td style="text-align:right;">修理厂名称：</td>
				<td><input class="mini-textbox" style="width:150px;" name="name" id="nameC"/></td>
				<td style="text-align:right;">修理厂用户名：</td>
				<td><input class="mini-textbox" style="width:150px;" name="username" id="usernameC"/></td>
			</tr>
			<tr>
				<td style="text-align:right;">修理厂电话：</td>
				<td><input class="mini-textbox" style="width:150px;" name="telephone" id="telephoneC"/></td>
				<td style="text-align:right;">注册时间：</td>
				<td style="white-space:nowrap;">
				<input  id="afterDateC" name = "afterDate" class="mini-datepicker" maxDate="mini.get('nowDate').getValue()">－
				<input  id="nowDateC" name = "nowDate" class="mini-datepicker" minDate="mini.get('afterDate').getValue()">
				</td>
			</tr>
			<tr>
				<td colspan="4" style="text-align:center;padding-top: 15px;">
				<a class="mini-button" onclick="resetSearch('#form')" style="width:60px">重 置</a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a class="mini-button" onclick="search()" style="width:60px">查 询</a>
				</td>
			</tr>
		</table>
		</form>
	</div>
	<div class="mini-toolbar"
		style="padding:2px;border-top:0;border-left:0;border-right:0;">
		<table style="width:100%;">
			<tr>
				<td style="width:100%;"><a class="mini-button"
					iconCls="icon-add" onclick="add()">增加</a>
					<a class="mini-button"
					iconCls="icon-edit" onclick="edit()">修改</a>
					<a class="mini-button"
					iconCls="icon-remove" onclick="remove()">删除</a></td>
			</tr>
		</table>
	</div>
	<div class="mini-fit">
		<div id="datagrid_company" class="mini-datagrid"
			style="width:100%;height:100%;" borderStyle="border:0;"
			url="${ctx}/company/likeDatalist.action" idField="id"
			allowAlternating="true" sortField="id" sortOrder="desc"
			onrowdblclick="rowdblclick" multiSelect="true">
			<div property="columns">
				<div type="checkcolumn"></div>
					<div field="username" headerAlign="center" allowSort="true">修理厂用户名</div>
					<div field="name" headerAlign="center" allowSort="true">修理厂名称</div>
					<div field="telephone" headerAlign="center" allowSort="true">修理厂电话</div>
					<div field="fullAddress" headerAlign="center" allowSort="true">地址</div>
					<div field="officeHours" headerAlign="center" allowSort="true" dateFormat="yyyy-MM-dd ">营业时间</div>
					<div field="createDate" headerAlign="center" allowSort="true" dateFormat="yyyy-MM-dd">注册时间</div>
					<div name="action"  headerAlign="center" width="120" >操作</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="<%=ctx%>/page/msds/km/company/company_list.js"></script>
</html>