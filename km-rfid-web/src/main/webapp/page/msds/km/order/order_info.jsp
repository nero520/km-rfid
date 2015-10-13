<%@page import="com.msds.km.vo.Order"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<head>
<%@include file="/page/msds/common/commonjs.jsp" %>
</head>
<body>

	<div class="mini-fit" style="background: url('${ctx}/js/miniui/themes/blue/images/toolbar/toolbar.gif') repeat-x scroll 0 0 #f0f0f0;border: 1px solid #99bce8">
	<div class="contentView" >
	<h3>订单详情</h3>
	<div id="editform" class="tableClass">
			<input class="mini-hidden" name="id"  value="${orderData.orderEntity.id}"/>
			<table style="width:100%" border="0" cellspacing="0" cellpadding="0">
				<tr >
					<td style="text-align:right;width:20%;">订单编号：</td>
					<td style="width:30%;">${orderData.orderEntity.orderSn }</td>
					<td style="text-align:right;">车主手机号：</td>
					<td>${orderData.orderEntity.phone } </td>
				</tr>
				<tr>
					<td style="text-align:right;">车牌号：</td>
					<td>${orderData.orderEntity.license }</td>
					<td style="text-align:right;">车主姓名：</td>
					<td>${orderData.orderEntity.contact}</td>
				</tr> 
 				<tr>
					<td style="text-align:right;">车型：</td>
					<td>${orderData.orderEntity.modelGroupName }</td>
					<td style="text-align:right;">预约服务：</td>
					<td>${orderData.orderEntity.serviceName}</td>
				</tr>
 				<tr>
					<td style="text-align:right;">服务时间：</td>
					<td><fmt:formatDate value="${orderData.orderEntity.serviceTime }" pattern="yyyy-MM-dd HH:mm:ss" /> </td>
					<td style="text-align:right;">下单时间：</td>
					<td><fmt:formatDate value="${orderData.orderEntity.createDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
				</tr>
				<tr>
					<td style="text-align:right;">订单状态：</td>
					<td id="orderState"><%=  EnumUtil.getEnumName(((Order)request.getAttribute("orderData")).getOrderEntity().getOrderState(),"OrderStateEnum") %></td>
					<td style="text-align:right;">订单金额：</td>
					<td><fmt:formatNumber value="${orderData.orderEntity.price }" pattern="0.00"/></td>
				</tr>  
				<tr>
					<td style="text-align:right;">修理厂名称：</td>
					<td>${orderData.companyEntity.name }</td>
 					<td style="text-align:right;">修理厂地址：</td>
					<td>${orderData.companyEntity.fullAddress}</td> 
				</tr>  
				
				<tr>
					<td style="text-align:right;">修理厂电话：</td>
					<td>${orderData.companyEntity.telephone }</td>
 					<td style="text-align:right;">修理厂营业时间：</td>
					<td>${orderData.companyEntity.officeHours}</td> 
				</tr>  
				<tr>
					<td style="text-align:right;">备注/描述：</td>
					<td id="partsState">${orderData.orderEntity.remark }</td>
					<td></td>
					<td id="partsState"></td>
				</tr> 
			</table>
	</div>
	<div class="tableClass" style="margin-top: 30px;">
		<table style="width:100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td style="width: 50%"><h3>费用项</h3></td>
				<td><h3>金额</h3></td>
			</tr>
				<tr>
				<td>配件：</td>
				<td>${orderData.orderEntity.productPrice}</td>
			</tr>
			<tr>
				<td>工时：</td>
				<td><fmt:formatNumber value="${orderData.workDateCount}" pattern="0.00"/></td>
			</tr>
			<tr>
				<td>折扣：</td>
				<td><fmt:formatNumber value="${orderData.orderEntity.discount}" pattern=""/></td>
			</tr>
			<tr>
				<td>总计：</td>
				<td><fmt:formatNumber value="${orderData.orderEntity.amount}" pattern="0.00"/></td>
			</tr>
		</table>
	</div>
	<h3>配件详情</h3>
	<div id="orderInfo1" class="mini-datagrid"  borderStyle="border:0;" height="20%" 
			url="${ctx}/order/findOrderProductList.action" idField="id"
			allowAlternating="true" sortField="id" sortOrder="desc" pageSize="50"
			 multiSelect="true" showPager="false"  allowCellWrap="true" allowHeaderWrap = "false">
			<div property="columns">
					<div field="supplierCode"headerAlign="center" allowSort="true">商品编码</div>
					<div field="productName"headerAlign="center" allowSort="true">商品名称</div>
					<div field="marketPrice"headerAlign="center" allowSort="true">零售价</div>
					<div field="productName"headerAlign="center" allowSort="true">商品分类</div>
					<div field="brandName"headerAlign="center" allowSort="true">品牌</div>
					<div field="company"headerAlign="center" allowSort="true">卖家</div>
					<div field="quantity"headerAlign="center" allowSort="true">数量</div>
					<div field="minUnit"headerAlign="center" allowSort="true">单位</div>
					<div field="priceAcount"headerAlign="center" allowSort="true">小计</div>
			</div>
	</div>
	
	<h3>操作日志</h3>
	<div id="datagrid_orderLog" class="mini-datagrid"
			height="30%" borderStyle="border:0;"
			url="${ctx}/orderLog/dataList.action" idField="id"
			allowAlternating="true" sortField="id" sortOrder="asc">
			<div property="columns">
					<div field="operationPerson"headerAlign="center" allowSort="true">操作人</div>
					<div field="orderState"headerAlign="center" allowSort="true" type="comboboxcolumn">订单状态
						<input property="editor" class="mini-combobox" data="orderState" />
					</div>
					<div field="operationDate" dateFormat="yyyy-MM-dd H:mm:ss" headerAlign="center" allowSort="true">操作时间</div>
					<div field="operationRemark"headerAlign="center" allowSort="true">操作备注</div>
			</div>
	</div>
	
</div>
	<div style="text-align: center;"><a class="mini-button" onclick="goBack()">返回</a></div>
</div>
	
</body>
<script type="text/javascript">

mini.parse();
var grid_item = mini.get("orderInfo1");

var params = {"id":"${orderData.orderEntity.id}"};
grid_item.load(params);


var grid_Log = mini.get("datagrid_orderLog");

var paramsLog = {"orderSn":"${orderData.orderEntity.orderSn}"};
grid_Log.load(paramsLog);

function goBack() {
	parent.removeTab();
}

</script>
<script type="text/javascript" src="<%=ctx%>/page/msds/km/order/order_edit.js"></script>
</html>