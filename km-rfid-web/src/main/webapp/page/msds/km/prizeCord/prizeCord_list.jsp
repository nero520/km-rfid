<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<head>
<%@include file="/page/msds/common/commonjs.jsp"%>
</head>
<body>
	<div class="mini-toolbar"
		style="padding: 2px; border-top: 0; border-left: 0; border-right: 0;">
		<table style="width: 100%;">
			<tr>
				<td style="width: 100%;"><a class="mini-button"
					iconCls="icon-add" onclick="add()">增加</a><a class="mini-button"
					iconCls="icon-remove" onclick="remove()">删除</a></td>
				<td style="white-space: nowrap;"><input id="searchField"
					class="mini-combobox" style="width: 75px;" value="phone"
					data="[{'id':'phone','text':'手机'},{'id':'sn','text':'优惠码'},{'id':'activitySn','text':'活动编号'},{'id':'expiryDate','text':'失效日期'},{'id':'state','text':'状态'},{'id':'license','text':'车牌号'},{'id':'model','text':'车型'},{'id':'openid','text':'openid'},{'id':'operator','text':'操作人'},{'id':'createDate','text':'创建时间'},{'id':'modifyDate','text':'修改时间'}]" />
					<input id="key" class="mini-textbox" emptyText="请输入"
					style="width: 150px;" onenter="onKeyEnter" /> <a
					class="mini-button" onclick="search()">查询</a></td>
			</tr>
		</table>
	</div>
	<div class="mini-fit">
		<div id="datagrid_prizeCord" class="mini-datagrid"
			style="width: 100%; height: 100%;" borderStyle="border:0;"
			url="${ctx}/prizeCord/dataList.action" idField="id"
			allowAlternating="true" sortField="id" sortOrder="desc"
			onrowdblclick="rowdblclick" multiSelect="true">
			<div property="columns">
				<div type="checkcolumn"></div>
				<div field="sn" headerAlign="center" allowSort="true">优惠码</div>
				<div field="activitySn" headerAlign="center" allowSort="true">活动编号</div>
				<div field="expiryDate" dateFormat="yyyy-MM-dd H:mm:ss"
					headerAlign="center" allowSort="true">失效日期</div>
				<div field="state" headerAlign="center" allowSort="true"
					type="comboboxcolumn">
					状态<input property="editor" class="mini-combobox"
						data="prizeCordState" />
				</div>
				<div field="phone" headerAlign="center" allowSort="true">手机</div>
				<div field="license" headerAlign="center" allowSort="true">车牌号</div>
				<div field="model" headerAlign="center" allowSort="true">车型</div>
				<div field="openid" headerAlign="center" allowSort="true">openid</div>
				<div field="operator" headerAlign="center" allowSort="true">操作人</div>
				<div field="createDate" dateFormat="yyyy-MM-dd H:mm:ss"
					headerAlign="center" allowSort="true">创建时间</div>
				<div field="modifyDate" dateFormat="yyyy-MM-dd H:mm:ss"
					headerAlign="center" allowSort="true">修改时间</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript"
	src="<%=ctx%>/page/msds/km/prizeCord/prizeCord_list.js"></script>
</html>