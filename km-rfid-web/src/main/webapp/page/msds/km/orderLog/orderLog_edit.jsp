<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<head>
<%@include file="/page/msds/common/commonjs.jsp" %>
</head>
<body>
	<div class="mini-fit" style="background: url('<%=ctx%>/js/miniui/themes/blue/images/toolbar/toolbar.gif') repeat-x scroll 0 0 #f0f0f0;border: 1px solid #99bce8">
		<div id="editform" class="form">
			<input class="mini-hidden" name="id" />
			<table style="width:100%;">
				<tr>
					<td>订单编号：</td>
					<td><input name="orderSn" 
						required="true" vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写订单编号" /></td>
				</tr>
				<tr>
					<td>下单客户：</td>
					<td><input name="memberId" 
						 allowLimitValue="false" style="width: 160px;"  class="mini-spinner" emptyText="请填写下单客户" /></td>
				</tr>
				<tr>
					<td>总金额：</td>
					<td><input name="price" 
						 allowLimitValue="false" style="width: 160px;"  class="mini-spinner" emptyText="请填写总金额" /></td>
				</tr>
				<tr>
					<td>折扣：</td>
					<td><input name="discount" 
						 allowLimitValue="false" style="width: 160px;"  class="mini-spinner" emptyText="请填写折扣" /></td>
				</tr>
				<tr>
					<td>实际价格：</td>
					<td><input name="amount" 
						 allowLimitValue="false" style="width: 160px;"  class="mini-spinner" emptyText="请填写实际价格" /></td>
				</tr>
				<tr>
					<td>订单类型：</td>
					<td><input name="orderType" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写订单类型" /></td>
				</tr>
				<tr>
					<td>订单状态：</td>
					<td><input name="orderState" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写订单状态" /></td>
				</tr>
				<tr>
					<td>支付状态：</td>
					<td><input name="paymentState" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写支付状态" /></td>
				</tr>
				<tr>
					<td>支付类型：</td>
					<td><input name="paymentType" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写支付类型" /></td>
				</tr>
				<tr>
					<td>联系人：</td>
					<td><input name="contact" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写联系人" /></td>
				</tr>
				<tr>
					<td>联系电话：</td>
					<td><input name="phone" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写联系电话" /></td>
				</tr>
				<tr>
					<td>服务code：</td>
					<td><input name="serviceCode" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写服务code" /></td>
				</tr>
				<tr>
					<td>服务名称：</td>
					<td><input name="serviceName" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写服务名称" /></td>
				</tr>
				<tr>
					<td>车型ID：</td>
					<td><input name="modeId" 
						 allowLimitValue="false" style="width: 160px;"  class="mini-spinner" emptyText="请填写车型ID" /></td>
				</tr>
				<tr>
					<td>车型名称：</td>
					<td><input name="modeName" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写车型名称" /></td>
				</tr>
				<tr>
					<td>车牌号：</td>
					<td><input name="license" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写车牌号" /></td>
				</tr>
				<tr>
					<td>里程数：</td>
					<td><input name="mileage" 
						 allowLimitValue="false" style="width: 160px;"  class="mini-spinner" emptyText="请填写里程数" /></td>
				</tr>
				<tr>
					<td>商品集合JSON(id\数量\名称\价格)：</td>
					<td><input name="productsJson" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写商品集合JSON(id\数量\名称\价格)" /></td>
				</tr>
				<tr>
					<td>商品总价格(冗余)：</td>
					<td><input name="productPrice" 
						 allowLimitValue="false" style="width: 160px;"  class="mini-spinner" emptyText="请填写商品总价格(冗余)" /></td>
				</tr>
				<tr>
					<td>工时费集合：</td>
					<td><input name="laborcostJson" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写工时费集合" /></td>
				</tr>
				<tr>
					<td>服务时间：</td>
					<td><input name="serviceTime" 
						 format="yyyy-MM-dd H:mm:ss" timeFormat="H:mm:ss" showTime="true" style="width: 160px;"  class="mini-datepicker" emptyText="请填写服务时间" /></td>
				</tr>
				<tr>
					<td>修理厂ID：</td>
					<td><input name="companyId" 
						 allowLimitValue="false" style="width: 160px;"  class="mini-spinner" emptyText="请填写修理厂ID" /></td>
				</tr>
				<tr>
					<td>修理厂名称：</td>
					<td><input name="companyName" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写修理厂名称" /></td>
				</tr>
				<tr>
					<td>修理厂地址：</td>
					<td><input name="companyAddress" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写修理厂地址" /></td>
				</tr>
				<tr>
					<td>备注：</td>
					<td><input name="remark" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写备注" /></td>
				</tr>
				<tr>
					<td>失效时间：</td>
					<td><input name="invalidDate" 
						 format="yyyy-MM-dd H:mm:ss" timeFormat="H:mm:ss" showTime="true" style="width: 160px;"  class="mini-datepicker" emptyText="请填写失效时间" /></td>
				</tr>
				<tr>
					<td>来源：</td>
					<td><input name="source" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写来源" /></td>
				</tr>
				<tr>
					<td>配件单号：</td>
					<td><input name="partsSn" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写配件单号" /></td>
				</tr>
				<tr>
					<td>配件单状态：</td>
					<td><input name="partsState" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写配件单状态" /></td>
				</tr>
				<tr>
					<td>直营店编号：</td>
					<td><input name="directShopId" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写直营店编号" /></td>
				</tr>
				<tr>
					<td>创建时间：</td>
					<td><input name="createDate" 
						 format="yyyy-MM-dd H:mm:ss" timeFormat="H:mm:ss" showTime="true" style="width: 160px;"  class="mini-datepicker" emptyText="请填写创建时间" /></td>
				</tr>
				<tr>
					<td>修改时间：</td>
					<td><input name="modifyDate" 
						 format="yyyy-MM-dd H:mm:ss" timeFormat="H:mm:ss" showTime="true" style="width: 160px;"  class="mini-datepicker" emptyText="请填写修改时间" /></td>
				</tr>
				<tr>
					<td>操作人：</td>
					<td><input name="operationPerson" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写操作人" /></td>
				</tr>
				<tr>
					<td>操作时间：</td>
					<td><input name="operationDate" 
						 format="yyyy-MM-dd H:mm:ss" timeFormat="H:mm:ss" showTime="true" style="width: 160px;"  class="mini-datepicker" emptyText="请填写操作时间" /></td>
				</tr>
				<tr>
					<td>操作备注：</td>
					<td><input name="operationRemark" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写操作备注" /></td>
				</tr>
				<tr>
					<td style="text-align:right;padding-top:5px;padding-right:20px;"
						colspan="3"><a class="mini-button"
						onclick="updateRow()">保存</a> <a class="mini-button"
						onclick="cancelRow()">取消</a></td>
				</tr>
			</table>
		</div>
	</div>
</body>
<script type="text/javascript" src="<%=ctx%>/page/msds/km/orderLog/orderLog_edit.js"></script>
</html>