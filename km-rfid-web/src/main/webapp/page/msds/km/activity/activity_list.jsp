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
					class="mini-combobox" style="width: 75px;" value="title"
					data="[{'id':'sn','text':'活动sn'},{'id':'title','text':'活动名称'},{'id':'description','text':'活动描述'},{'id':'prize','text':'奖品'},{'id':'count','text':'总数'},{'id':'quantity','text':'数量'},{'id':'state','text':'状态'},{'id':'startTime','text':'开始时间'},{'id':'endTime','text':'结束时间'},{'id':'operator','text':'操作人'},{'id':'createDate','text':'创建时间'},{'id':'modifyDate','text':'修改时间'}]" />
					<input id="key" class="mini-textbox" emptyText="请输入"
					style="width: 150px;" onenter="onKeyEnter" /> <a
					class="mini-button" onclick="search()">查询</a></td>
			</tr>
		</table>
	</div>
	<div class="mini-fit">
		<div id="datagrid_activity" class="mini-datagrid"
			style="width: 100%; height: 100%;" borderStyle="border:0;"
			url="${ctx}/activity/dataList.action" idField="id"
			allowAlternating="true" sortField="id" sortOrder="desc"
			onrowdblclick="rowdblclick" multiSelect="true">
			<div property="columns">
				<div type="checkcolumn"></div>
				<div field="sn" headerAlign="center" allowSort="true">活动sn</div>
				<div field="title" headerAlign="center" allowSort="true">活动名称</div>
				<div field="description" headerAlign="center" allowSort="true">活动描述</div>
				<div field="prize" headerAlign="center" allowSort="true">奖品</div>
				<div field="count" headerAlign="center" allowSort="true">总数</div>
				<div field="quantity" headerAlign="center" allowSort="true">数量</div>
				<div field="state" headerAlign="center" allowSort="true"
					type="comboboxcolumn">
					状态 <input property="editor" class="mini-combobox"
						data="activityState" />
				</div>
				<div field="startTime" dateFormat="yyyy-MM-dd H:mm:ss"
					headerAlign="center" allowSort="true">开始时间</div>
				<div field="endTime" dateFormat="yyyy-MM-dd H:mm:ss"
					headerAlign="center" allowSort="true">结束时间</div>
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
	src="<%=ctx%>/page/msds/km/activity/activity_list.js"></script>
</html>