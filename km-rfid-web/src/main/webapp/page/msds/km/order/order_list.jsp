<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<head>
<%@include file="/page/msds/common/commonjs.jsp" %>
</head>
<body>
	<div class="mini-toolbar"
		style="padding:2px;border-top:0;border-left:0;border-right:0;">
		<form id="form1" method="post" class="divClass">
		<table style="width:100%;">
			<tr>
				<td style="text-align:right;">订单编号：</td>
				<td><input  id = "orderSn" name = "orderSn" class="mini-textbox"></td>
				<td style="text-align:right;">车牌号：</td>
				<td><input  id="license" name = "license" class="mini-textbox"></td>
				<td style="text-align:right;">下单时间：</td>
				<td><input  id="afterDate" name = "afterDate" class="mini-datepicker" maxDate="mini.get('nowDate').getValue()">－
				<input  id="nowDate" name = "nowDate" class="mini-datepicker" minDate="mini.get('afterDate').getValue()"></td>
			</tr>
			<tr>		
				<td style="text-align:right;">车主手机号：</td>
				<td><input  id="phone" name = "phone" class="mini-textbox"></td>
				<td style="text-align:right;">状态：</td>
				<td><input id="searchState" class="mini-combobox" style="width:125px;" valueField="id" value="0"data="orderStateSelect" />
				</td>
			</tr>
			<tr>
				<td colspan="6" style="text-align:center;padding-top: 15px;">
				<a class="mini-button" onclick="resetSearch('#form')" style="width:60px">重 置</a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a class="mini-button" onclick="search()" style="width:60px">查 询</a>
				</td>
			</tr>
		</table>
		</form>
	</div>
	<div class="mini-fit">
		<div id="datagrid_order" class="mini-datagrid" display="block"
			 borderStyle="border:0;" style="width: 100%;height:100%;"
			url="${ctx}/order/findOrderList.action" idField="id"
			allowAlternating="true" sortField="id" sortOrder="desc"  multiSelect="true" allowCellWrap="false" allowHeaderWrap = "false">
			<div property="columns">
					<div field="orderSn"headerAlign="center" allowSort="true" width="120">订单编号</div>
					<div field="phone"headerAlign="center" allowSort="true">车主手机号</div>
					<div field="serviceName"headerAlign="center" allowSort="true">预约服务</div>
					<div field="license"headerAlign="center" allowSort="true">车牌号</div>
					<div field="serviceTime" dateFormat="yyyy-MM-dd HH:mm:ss" headerAlign="center" allowSort="true" width="150">预约时间</div>
					<div field="orderState"headerAlign="center" allowSort="true" type="comboboxcolumn">订单状态
					<input property="editor" class="mini-combobox" data="orderState" /></div>
					<div field="price"headerAlign="center" allowSort="true" dataType="currency" >金额</div>
					<div name="action"  headerAlign="center" width="150">操作</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="<%=ctx%>/page/msds/km/order/order_list.js"></script>
</html>