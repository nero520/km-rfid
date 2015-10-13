<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<head>
<%@include file="/page/msds/common/commonjs.jsp" %>
</head>
<body>

	<div class="mini-fit" style="background: url('${ctx}/js/miniui/themes/blue/images/toolbar/toolbar.gif') repeat-x scroll 0 0 #f0f0f0;border: 1px solid #99bce8">
	<div class="contentView" >
	<div id="editform" class="form">
			<input class="mini-hidden" name="id" id="cancelId"/>
			<input class="mini-hidden" name="orderSn" id="orderSn" value=""/>
			<h3 style="padding-left: 20px;">客户已付款，<!-- <span id="hiddenPanStr" style="display: none">已生成配件订单,</span> -->确认取消订单？</h3>
			<table  >
				<!-- <tr style="display: none ;padding-left: 20px;" id="hiddenComfOrder">
					<td colspan="2"><input id="comfOrder" class="mini-checkboxlist"   valueField="id"   data="[{'id':'1','text':'生成康众平台配件退货单'}]"/></td>
				</tr> -->
				<tr>
					<td style="padding-left: 20px;">取消原因：</td>
					<td style="white-space:nowrap;"><input  class="mini-textarea" id="otherCancelInfo" name="otherCancelInfo" style="width: 200px;height: 100px;" emptyText="可以输入1-200个汉字" maxlength="200"></td> 
				</tr>  
				<tr>
					<td style="white-space:nowrap;vertical-align:middle; text-align:center;" colspan="2" >
					<a class="mini-button" onclick="cancelService()" style=" margin-top: 10px;margin-left: 30px;">保存</a> <a class="mini-button" onclick="cancelRow()" style=" margin-top: 7px;">取消</a></td>
				</tr>
			</table>
</div>
	
</body>
<script type="text/javascript" src="<%=ctx%>/page/msds/km/order/order_edit.js"></script>
</html>