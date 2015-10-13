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
				data="[{'id':'id','text':'ID'},{'id':'orderSn','text':'订单编号'},{'id':'memberId','text':'下单客户'},{'id':'price','text':'总金额'},{'id':'discount','text':'折扣'},{'id':'amount','text':'实际价格'},{'id':'orderType','text':'订单类型'},{'id':'orderState','text':'订单状态'},{'id':'paymentState','text':'支付状态'},{'id':'paymentType','text':'支付类型'},{'id':'contact','text':'联系人'},{'id':'phone','text':'联系电话'},{'id':'serviceCode','text':'服务code'},{'id':'serviceName','text':'服务名称'},{'id':'modeId','text':'车型ID'},{'id':'modeName','text':'车型名称'},{'id':'license','text':'车牌号'},{'id':'mileage','text':'里程数'},{'id':'productsJson','text':'商品集合JSON(id\数量\名称\价格)'},{'id':'productPrice','text':'商品总价格(冗余)'},{'id':'laborcostJson','text':'工时费集合'},{'id':'serviceTime','text':'服务时间'},{'id':'companyId','text':'修理厂ID'},{'id':'companyName','text':'修理厂名称'},{'id':'companyAddress','text':'修理厂地址'},{'id':'remark','text':'备注'},{'id':'invalidDate','text':'失效时间'},{'id':'source','text':'来源'},{'id':'partsSn','text':'配件单号'},{'id':'partsState','text':'配件单状态'},{'id':'directShopId','text':'直营店编号'},{'id':'createDate','text':'创建时间'},{'id':'modifyDate','text':'修改时间'},{'id':'operationPerson','text':'操作人'},{'id':'operationDate','text':'操作时间'},{'id':'operationRemark','text':'操作备注'}]" />
				<input id="key"	class="mini-textbox" emptyText="请输入" style="width:150px;"
					onenter="onKeyEnter" /> <a class="mini-button" onclick="search()">查询</a>
				</td>
			</tr>
		</table>
	</div>
	<div class="mini-fit">
		<div id="datagrid_orderLog" class="mini-datagrid"
			style="width:100%;height:100%;" borderStyle="border:0;"
			url="${ctx}/orderLog/dataList.action" idField="id"
			allowAlternating="true" sortField="id" sortOrder="desc"
			onrowdblclick="rowdblclick" multiSelect="true">
			<div property="columns">
				<div type="checkcolumn"></div>
					<div field="orderSn"headerAlign="center" allowSort="true">订单编号</div>
					<div field="memberId"headerAlign="center" allowSort="true">下单客户</div>
					<div field="price"headerAlign="center" allowSort="true">总金额</div>
					<div field="discount"headerAlign="center" allowSort="true">折扣</div>
					<div field="amount"headerAlign="center" allowSort="true">实际价格</div>
					<div field="orderType"headerAlign="center" allowSort="true">订单类型</div>
					<div field="orderState"headerAlign="center" allowSort="true">订单状态</div>
					<div field="paymentState"headerAlign="center" allowSort="true">支付状态</div>
					<div field="paymentType"headerAlign="center" allowSort="true">支付类型</div>
					<div field="contact"headerAlign="center" allowSort="true">联系人</div>
					<div field="phone"headerAlign="center" allowSort="true">联系电话</div>
					<div field="serviceCode"headerAlign="center" allowSort="true">服务code</div>
					<div field="serviceName"headerAlign="center" allowSort="true">服务名称</div>
					<div field="modeId"headerAlign="center" allowSort="true">车型ID</div>
					<div field="modeName"headerAlign="center" allowSort="true">车型名称</div>
					<div field="license"headerAlign="center" allowSort="true">车牌号</div>
					<div field="mileage"headerAlign="center" allowSort="true">里程数</div>
					<div field="productsJson"headerAlign="center" allowSort="true">商品集合JSON(id\数量\名称\价格)</div>
					<div field="productPrice"headerAlign="center" allowSort="true">商品总价格(冗余)</div>
					<div field="laborcostJson"headerAlign="center" allowSort="true">工时费集合</div>
					<div field="serviceTime" dateFormat="yyyy-MM-dd H:mm:ss" headerAlign="center" allowSort="true">服务时间</div>
					<div field="companyId"headerAlign="center" allowSort="true">修理厂ID</div>
					<div field="companyName"headerAlign="center" allowSort="true">修理厂名称</div>
					<div field="companyAddress"headerAlign="center" allowSort="true">修理厂地址</div>
					<div field="remark"headerAlign="center" allowSort="true">备注</div>
					<div field="invalidDate" dateFormat="yyyy-MM-dd H:mm:ss" headerAlign="center" allowSort="true">失效时间</div>
					<div field="source"headerAlign="center" allowSort="true">来源</div>
					<div field="partsSn"headerAlign="center" allowSort="true">配件单号</div>
					<div field="partsState"headerAlign="center" allowSort="true">配件单状态</div>
					<div field="directShopId"headerAlign="center" allowSort="true">直营店编号</div>
					<div field="createDate" dateFormat="yyyy-MM-dd H:mm:ss" headerAlign="center" allowSort="true">创建时间</div>
					<div field="modifyDate" dateFormat="yyyy-MM-dd H:mm:ss" headerAlign="center" allowSort="true">修改时间</div>
					<div field="operationPerson"headerAlign="center" allowSort="true">操作人</div>
					<div field="operationDate" dateFormat="yyyy-MM-dd H:mm:ss" headerAlign="center" allowSort="true">操作时间</div>
					<div field="operationRemark"headerAlign="center" allowSort="true">操作备注</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="<%=ctx%>/page/msds/km/orderLog/orderLog_list.js"></script>
</html>