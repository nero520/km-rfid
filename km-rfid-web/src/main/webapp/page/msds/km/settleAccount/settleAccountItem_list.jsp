<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<head>
<%@include file="/page/msds/common/commonjs.jsp" %>
</head>
<body>
	<input type="hidden" id="settleSn" name="settleSn" value="${settleAccountEntity.settleSn}">
	<div class="divClass">
		<table class="mini-toolbar"
			style="padding:2px;border-top:0;border-left:0;border-right:0;width:100%;">
			<tr>
				<td style="text-align:right;width: 100px">对账单号：</td>
				<td style="width: 230px">${settleAccount.settleSn}</td>
				<td style="text-align:right;width: 100">状态：</td>
				<td>${settleAccount.settleStateName}</td>
			</tr>
			<tr>
				<td style="text-align:right;">起止时间：</td>
				<td>${settleAccount.startDate}</td>
				<td style="text-align:right;">应结算金额：</td>
				<td>${settleAccount.settleAllAmount}</td>
			</tr>
		</table>
	</div>
	<div class="mini-fit">
		<div id="datagrid_settleAccountItem" class="mini-datagrid" display="block"
			 borderStyle="border:0;" style="width: 100%;height:100%"
			url="${ctx}/settleAccount/findSettleAccountItemList.action" idField="id"
			allowAlternating="true" sortField="settleSn" sortOrder="asc" multiSelect="true" 
			allowCellWrap="true" allowHeaderWrap="false" fitColumns="true">
			<div property="columns">
				<div field="orderSn"			headerAlign="center" width="150">订单号</div>
				<div field="orderCreateDate"	headerAlign="center" width="150">下单时间</div>
				<div field="serviceTime"		headerAlign="center">服务日期</div>
				<div field="serivceFinishDate"	headerAlign="center" width="150">服务完成时间</div>
				<div field="orderState"			headerAlign="center" type="comboboxcolumn">订单状态
					<input property="editor" class="mini-combobox" data="orderState" /></div>
				<div field="serviceName"		headerAlign="center" width="190px">服务项目</div>
				<div field="price"				headerAlign="center" dataType="currency">套餐总价</div>
				<div field="license"			headerAlign="center">车牌号码</div>
				<div field="modelGroupName"		headerAlign="center" width="150">车型</div>
				<div field="contact"			headerAlign="center">车主姓名</div>
				<div field="phone"				headerAlign="center">联系电话</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="<%=ctx%>/page/msds/km/settleAccount/settleAccountItem_list.js"></script>
</html>