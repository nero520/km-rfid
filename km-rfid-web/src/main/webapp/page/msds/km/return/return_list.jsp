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
				data="[{'id':'id','text':'ID'},{'id':'returnSn','text':'退货单编号'},{'id':'orderSn','text':'订单编号'},{'id':'productJson','text':'商品对象JSON'},{'id':'directShopId','text':'直营店ID'},{'id':'companyId','text':'修理厂ID'},{'id':'status','text':'退货状态'},{'id':'remark','text':'退货备注'},{'id':'partsReturnSn','text':'配件退货单号'},{'id':'operator','text':'操作人'},{'id':'createDate','text':'创建时间'},{'id':'modifyDate','text':'修改时间'}]" />
				<input id="key"	class="mini-textbox" emptyText="请输入" style="width:150px;"
					onenter="onKeyEnter" /> <a class="mini-button" onclick="search()">查询</a>
				</td>
			</tr>
		</table>
	</div>
	<div class="mini-fit">
		<div id="datagrid_return" class="mini-datagrid"
			style="width:100%;height:100%;" borderStyle="border:0;"
			url="${ctx}/return/dataList.action" idField="id"
			allowAlternating="true" sortField="id" sortOrder="desc"
			onrowdblclick="rowdblclick" multiSelect="true">
			<div property="columns">
				<div type="checkcolumn"></div>
					<div field="returnSn"headerAlign="center" allowSort="true">退货单编号</div>
					<div field="orderSn"headerAlign="center" allowSort="true">订单编号</div>
					<div field="productJson"headerAlign="center" allowSort="true">商品对象JSON</div>
					<div field="directShopId"headerAlign="center" allowSort="true">直营店ID</div>
					<div field="companyId"headerAlign="center" allowSort="true">修理厂ID</div>
					<div field="status"headerAlign="center" allowSort="true">退货状态</div>
					<div field="remark"headerAlign="center" allowSort="true">退货备注</div>
					<div field="partsReturnSn"headerAlign="center" allowSort="true">配件退货单号</div>
					<div field="operator"headerAlign="center" allowSort="true">操作人</div>
					<div field="createDate" dateFormat="yyyy-MM-dd H:mm:ss" headerAlign="center" allowSort="true">创建时间</div>
					<div field="modifyDate" dateFormat="yyyy-MM-dd H:mm:ss" headerAlign="center" allowSort="true">修改时间</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="<%=ctx%>/page/msds/km/return/return_list.js"></script>
</html>