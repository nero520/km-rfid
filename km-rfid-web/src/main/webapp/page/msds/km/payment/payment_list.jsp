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
				data="[{'id':'id','text':'ID'},{'id':'sn','text':'支付编号'},{'id':'orderSn','text':'订单编号'},{'id':'amount','text':'付款金额'},{'id':'fee','text':'支付手续费'},{'id':'status','text':'状态'},{'id':'paymentDate','text':'付款日期'},{'id':'paymentSerialNumber','text':'支付流水号'},{'id':'paymentMethod','text':'支付方式'},{'id':'paymentPluginId','text':'支付插件id'},{'id':'expire','text':'到期时间'},{'id':'method','text':'方式'},{'id':'account','text':'收款账号'},{'id':'bank','text':'收款银行'},{'id':'payer','text':'付款人'},{'id':'memo','text':'备注'},{'id':'payType','text':'支付来源'},{'id':'createDate','text':'创建时间'},{'id':'modifyDate','text':'修改时间'}]" />
				<input id="key"	class="mini-textbox" emptyText="请输入" style="width:150px;"
					onenter="onKeyEnter" /> <a class="mini-button" onclick="search()">查询</a>
				</td>
			</tr>
		</table>
	</div>
	<div class="mini-fit">
		<div id="datagrid_payment" class="mini-datagrid"
			style="width:100%;height:100%;" borderStyle="border:0;"
			url="${ctx}/payment/dataList.action" idField="id"
			allowAlternating="true" sortField="id" sortOrder="desc"
			onrowdblclick="rowdblclick" multiSelect="true">
			<div property="columns">
				<div type="checkcolumn"></div>
					<div field="sn"headerAlign="center" allowSort="true">支付编号</div>
					<div field="orderSn"headerAlign="center" allowSort="true">订单编号</div>
					<div field="amount"headerAlign="center" allowSort="true">付款金额</div>
					<div field="fee"headerAlign="center" allowSort="true">支付手续费</div>
					<div field="status"headerAlign="center" allowSort="true">状态</div>
					<div field="paymentDate" dateFormat="yyyy-MM-dd H:mm:ss" headerAlign="center" allowSort="true">付款日期</div>
					<div field="paymentSerialNumber"headerAlign="center" allowSort="true">支付流水号</div>
					<div field="paymentMethod"headerAlign="center" allowSort="true">支付方式</div>
					<div field="paymentPluginId"headerAlign="center" allowSort="true">支付插件id</div>
					<div field="expire" dateFormat="yyyy-MM-dd H:mm:ss" headerAlign="center" allowSort="true">到期时间</div>
					<div field="method"headerAlign="center" allowSort="true">方式</div>
					<div field="account"headerAlign="center" allowSort="true">收款账号</div>
					<div field="bank"headerAlign="center" allowSort="true">收款银行</div>
					<div field="payer"headerAlign="center" allowSort="true">付款人</div>
					<div field="memo"headerAlign="center" allowSort="true">备注</div>
					<div field="payType"headerAlign="center" allowSort="true">支付来源</div>
					<div field="createDate" dateFormat="yyyy-MM-dd H:mm:ss" headerAlign="center" allowSort="true">创建时间</div>
					<div field="modifyDate" dateFormat="yyyy-MM-dd H:mm:ss" headerAlign="center" allowSort="true">修改时间</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="<%=ctx%>/page/msds/km/payment/payment_list.js"></script>
</html>