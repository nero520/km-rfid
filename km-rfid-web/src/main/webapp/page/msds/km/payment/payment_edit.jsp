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
					<td>支付编号：</td>
					<td><input name="sn" 
						required="true" vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写支付编号" /></td>
				</tr>
				<tr>
					<td>订单编号：</td>
					<td><input name="orderSn" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写订单编号" /></td>
				</tr>
				<tr>
					<td>付款金额：</td>
					<td><input name="amount" 
						required="true" allowLimitValue="false" style="width: 160px;"  class="mini-spinner" emptyText="请填写付款金额" /></td>
				</tr>
				<tr>
					<td>支付手续费：</td>
					<td><input name="fee" 
						required="true" allowLimitValue="false" style="width: 160px;"  class="mini-spinner" emptyText="请填写支付手续费" /></td>
				</tr>
				<tr>
					<td>状态：</td>
					<td><input name="status" 
						required="true" allowLimitValue="false" style="width: 160px;"  class="mini-spinner" emptyText="请填写状态" /></td>
				</tr>
				<tr>
					<td>付款日期：</td>
					<td><input name="paymentDate" 
						 format="yyyy-MM-dd H:mm:ss" timeFormat="H:mm:ss" showTime="true" style="width: 160px;"  class="mini-datepicker" emptyText="请填写付款日期" /></td>
				</tr>
				<tr>
					<td>支付流水号：</td>
					<td><input name="paymentSerialNumber" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写支付流水号" /></td>
				</tr>
				<tr>
					<td>支付方式：</td>
					<td><input name="paymentMethod" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写支付方式" /></td>
				</tr>
				<tr>
					<td>支付插件id：</td>
					<td><input name="paymentPluginId" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写支付插件id" /></td>
				</tr>
				<tr>
					<td>到期时间：</td>
					<td><input name="expire" 
						 format="yyyy-MM-dd H:mm:ss" timeFormat="H:mm:ss" showTime="true" style="width: 160px;"  class="mini-datepicker" emptyText="请填写到期时间" /></td>
				</tr>
				<tr>
					<td>方式：</td>
					<td><input name="method" 
						required="true" allowLimitValue="false" style="width: 160px;"  class="mini-spinner" emptyText="请填写方式" /></td>
				</tr>
				<tr>
					<td>收款账号：</td>
					<td><input name="account" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写收款账号" /></td>
				</tr>
				<tr>
					<td>收款银行：</td>
					<td><input name="bank" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写收款银行" /></td>
				</tr>
				<tr>
					<td>付款人：</td>
					<td><input name="payer" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写付款人" /></td>
				</tr>
				<tr>
					<td>备注：</td>
					<td><input name="memo" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写备注" /></td>
				</tr>
				<tr>
					<td>支付来源：</td>
					<td><input name="payType" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写支付来源" /></td>
				</tr>
				<tr>
					<td>创建时间：</td>
					<td><input name="createDate" 
						required="true" format="yyyy-MM-dd H:mm:ss" timeFormat="H:mm:ss" showTime="true" style="width: 160px;"  class="mini-datepicker" emptyText="请填写创建时间" /></td>
				</tr>
				<tr>
					<td>修改时间：</td>
					<td><input name="modifyDate" 
						required="true" format="yyyy-MM-dd H:mm:ss" timeFormat="H:mm:ss" showTime="true" style="width: 160px;"  class="mini-datepicker" emptyText="请填写修改时间" /></td>
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
<script type="text/javascript" src="<%=ctx%>/page/msds/km/payment/payment_edit.js"></script>
</html>