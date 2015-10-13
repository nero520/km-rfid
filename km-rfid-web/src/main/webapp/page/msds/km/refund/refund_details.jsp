<%@page import="com.msds.km.vo.RefundList"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<head>
<%@include file="/page/msds/common/commonjs.jsp" %>
<style type="text/css">
	td{
		width: 25%;height: 50%;
	}
</style>
</head>
<body>

	<div class="mini-fit" style="background: url('${ctx}/js/miniui/themes/blue/images/toolbar/toolbar.gif') repeat-x scroll 0 0 #f0f0f0;border: 1px solid #99bce8">
	<div class="contentView" >
		<h3>退款详情</h3>
		<div id="editform" class="tableClass">
			<input class="mini-hidden" name="id" id="id" value="${refund.id}"/>
			<input class="mini-hidden" name="refundSn" id="refundSn" value="${refund.refundSn}"/>
			<input class="mini-hidden" name="orderSn" id="orderSn" value="${refund.orderSn}"/>
			<table style="width:100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td style="text-align:right;">退款单编号：</td>
					<td>${refund.refundSn}</td>
					<td style="text-align:right;">退款单创建时间：</td>
					<td><fmt:formatDate value="${refund.nowDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
				</tr>
				<tr>
					<td style="text-align:right;">退款状态：</td>
					<td id="refundState"><%=  EnumUtil.getEnumName(((RefundList)request.getAttribute("refund")).getState(),"RefundStateEnum") %>
					</td>
						<td style="text-align:right;">退款流水号：</td>
					<td>${refund.payCode}</td> 
				</tr>  
					<tr>
					<td style="text-align:right;">订单编号：</td>
					<td>${refund.orderSn} </td>
					<td style="text-align:right;">预约服务：</td>
					<td>${refund.serviceName}</td> 
				</tr>
				<tr>
					<td style="text-align:right;">订单状态：</td>
					<td><%=  EnumUtil.getEnumName(Integer.valueOf(((RefundList)request.getAttribute("refund")).getOrderState()),"OrderStateEnum") %></td>
						<td style="text-align:right;">订单金额：</td>
					<td><fmt:formatNumber value="${refund.price}" pattern="0.00"/></td>
				</tr>
				<tr>
					<td style="text-align:right;">支付流水号：</td>
					<td>${refund.paymentSerialNumber}</td>
						<td style="text-align:right;">车型号：</td>
					<td>${refund.modelGroupName}</td> 
				</tr> 
				<tr>
					<td style="text-align:right;">车主姓名：</td>
					<td>${refund.name}</td>
						<td style="text-align:right;">车主手机号：</td>
					<td>${refund.phone}</td>
				</tr>
				<tr>
						<td style="text-align:right;">车牌号：</td>
					<td>${refund.license}</td>
					<td></td>
					<td></td>
				</tr>
			</table>
		</div>
		<h3>操作日志</h3>
		<div id="datagrid_refundLog" class="mini-datagrid"  showPager="false" 
			height="20%" borderStyle="border:0;"
			url="${ctx}/refundLog/dataList.action" idField="id" sortField="id" sortOrder="asc">
			<div property="columns">
					<div field="operator"headerAlign="center" allowSort="true">操作人</div>
					<div field="createDate" dateFormat="yyyy-MM-dd H:mm:ss" headerAlign="center" allowSort="true">操作时间</div>
					<div  field="state"headerAlign="center" allowSort="true" type="comboboxcolumn">操作备注
					<input property="editor" class="mini-combobox" data="refundState" /></div>
			</div>
		</div>
	</div>
	<!-- <div style="text-align: center; margin-top: 30px;" ><a class="mini-button" onclick="goBack()">返回</a></div> -->
</div>
	
</body>
<script type="text/javascript">

mini.parse();

var grid_Log = mini.get("datagrid_refundLog");
var refundSn = mini.get("refundSn").getValue();
var orderSn = mini.get("orderSn").getValue();
var paramsLog = {refundSn:refundSn,orderSn:orderSn};
console.info(paramsLog);
grid_Log.load(paramsLog);

function goBack() {
	parent.removeTab();
}
grid_Log.on("drawcell", function (e) {
	var record = e.record,
		column = e.column,
		field  = e.field,
		value  = e.value;
	 
	//设置列属性
	column.headerAlign="center";
	column.align="center";
		 
})
</script>
<script type="text/javascript" src="<%=ctx%>/page/msds/km/refund/refund_edit.js"></script>
</html>