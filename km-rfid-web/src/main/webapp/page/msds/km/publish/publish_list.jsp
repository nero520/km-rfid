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
				data="[{'id':'id','text':'ID'},{'id':'type','text':'类型(首页轮播图、更多期待)'},{'id':'display','text':'描述'},{'id':'link','text':'跳转地址'},{'id':'img','text':'图片地址'},{'id':'os','text':'平台'},{'id':'sort','text':'排序'},{'id':'enabled','text':'是否启用（1启用0禁用）'},{'id':'createDate','text':'创建时间'},{'id':'modifyDate','text':'修改时间'}]" />
				<input id="key"	class="mini-textbox" emptyText="请输入" style="width:150px;"
					onenter="onKeyEnter" /> <a class="mini-button" onclick="search()">查询</a>
				</td>
			</tr>
		</table>
	</div>
	<div class="mini-fit">
		<div id="datagrid_publish" class="mini-datagrid"
			style="width:100%;height:100%;" borderStyle="border:0;"
			url="${ctx}/publish/dataList.action" idField="id"
			allowAlternating="true" sortField="id" sortOrder="desc"
			onrowdblclick="rowdblclick" multiSelect="true">
			<div property="columns">
				<div type="checkcolumn"></div>
					<div field="type"headerAlign="center" allowSort="true">类型(首页轮播图、更多期待)</div>
					<div field="display"headerAlign="center" allowSort="true">描述</div>
					<div field="link"headerAlign="center" allowSort="true">跳转地址</div>
					<div field="img"headerAlign="center" allowSort="true">图片地址</div>
					<div field="os"headerAlign="center" allowSort="true">平台</div>
					<div field="sort"headerAlign="center" allowSort="true">排序</div>
					<div field="enabled"headerAlign="center" allowSort="true">是否启用（1启用0禁用）</div>
					<div field="createDate" dateFormat="yyyy-MM-dd H:mm:ss" headerAlign="center" allowSort="true">创建时间</div>
					<div field="modifyDate" dateFormat="yyyy-MM-dd H:mm:ss" headerAlign="center" allowSort="true">修改时间</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="<%=ctx%>/page/msds/km/publish/publish_list.js"></script>
</html>