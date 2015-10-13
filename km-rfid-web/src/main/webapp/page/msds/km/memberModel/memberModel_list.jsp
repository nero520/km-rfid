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
				data="[{'id':'id','text':'ID'},{'id':'memberId','text':'会员id'},{'id':'modelId','text':'车型ID'},{'id':'modelGroupName','text':'车型组合名称(品牌车系排量年份)'},{'id':'defaultFlag','text':'是否默认'},{'id':'region','text':'所属区域'},{'id':'license','text':'车牌号'},{'id':'mileage','text':'里程数'},{'id':'buyDate','text':'创建日期'},{'id':'vin','text':'车架号'},{'id':'createDate','text':'创建时间'},{'id':'modifyDate','text':'修改时间'}]" />
				<input id="key"	class="mini-textbox" emptyText="请输入" style="width:150px;"
					onenter="onKeyEnter" /> <a class="mini-button" onclick="search()">查询</a>
				</td>
			</tr>
		</table>
	</div>
	<div class="mini-fit">
		<div id="datagrid_memberModel" class="mini-datagrid"
			style="width:100%;height:100%;" borderStyle="border:0;"
			url="${ctx}/memberModel/dataList.action" idField="id"
			allowAlternating="true" sortField="id" sortOrder="desc"
			onrowdblclick="rowdblclick" multiSelect="true">
			<div property="columns">
				<div type="checkcolumn"></div>
					<div field="memberId"headerAlign="center" allowSort="true">会员id</div>
					<div field="modelId"headerAlign="center" allowSort="true">车型ID</div>
					<div field="modelGroupName"headerAlign="center" allowSort="true">车型组合名称(品牌车系排量年份)</div>
					<div field="defaultFlag"headerAlign="center" allowSort="true">是否默认</div>
					<div field="region"headerAlign="center" allowSort="true">所属区域</div>
					<div field="license"headerAlign="center" allowSort="true">车牌号</div>
					<div field="mileage"headerAlign="center" allowSort="true">里程数</div>
					<div field="buyDate" dateFormat="yyyy-MM-dd" headerAlign="center" allowSort="true">创建日期</div>
					<div field="vin"headerAlign="center" allowSort="true">车架号</div>
					<div field="createDate" dateFormat="yyyy-MM-dd H:mm:ss" headerAlign="center" allowSort="true">创建时间</div>
					<div field="modifyDate" dateFormat="yyyy-MM-dd H:mm:ss" headerAlign="center" allowSort="true">修改时间</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="<%=ctx%>/page/msds/km/memberModel/memberModel_list.js"></script>
</html>