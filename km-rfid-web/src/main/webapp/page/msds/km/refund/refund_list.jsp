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
					<td style="white-space:nowrap;text-align:right;" width="100">订单编号：</td>
					<td><input  id="orderSn" name = "orderSn" class="mini-textbox"></td>
					<td style="white-space:nowrap;text-align:right;" width="100">创建时间：</td>
					<td><input  id="afterDate" name = "afterDate" class="mini-datepicker" maxDate="mini.get('nowDate').getValue()">－
					<input  id="nowDate" name = "nowDate" class="mini-datepicker" minDate="mini.get('afterDate').getValue()"></td>
				</tr>
				<tr>
					<td style="white-space:nowrap;text-align:right;" width="100">客户手机号：</td>
					<td><input  id="phone" name = "phone" class="mini-textbox" ></td>
					<td style="white-space:nowrap;text-align:right;" width="100">车牌号：</td>
					<td><input  id="license" name = "license" class="mini-textbox" ></td>
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
	<div class="mini-fit">
		<div id="datagrid_refund" class="mini-datagrid"
			style="width:100%;height:100%;" borderStyle="border:0;"
			url="${ctx}/refund/dataList.action" idField="id"
			allowAlternating="true" sortField="refundSn" sortOrder="asc" allowHeaderWrap = "false" multiSelect="true" allowCellWrap="true" 
			 multiSelect="true">
			<div property="columns">
					<div field="refundSn"headerAlign="center" id="refundSn" width="130">退款单编号</div>
					<div field="orderSn"headerAlign="center" width="130">订单编号</div>
					<div field="phone"headerAlign="center">车主手机号</div>
					<div field="carInfo"headerAlign="center" width="150">车型</div>
					<div field="paymentSerialNumber"headerAlign="center" width="110">支付流水号</div>
					<div field="price"headerAlign="center" dataType="currency" width="70">退款金额</div>
					<div field="orderState"headerAlign="center" type="comboboxcolumn" width="60">订单状态
						<input property="editor" class="mini-combobox" data="orderState" /></div>
					<div field="state"headerAlign="center" type="comboboxcolumn" width="60">退款状态
						<input property="editor" class="mini-combobox" data="refundState" /></div>
					<div field="payCode"headerAlign="center">退款流水号</div>
					<div name="action"  headerAlign="center" width="130">操作</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="<%=ctx%>/page/msds/km/refund/refund_list.js"></script>
</html>