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
			<input class="mini-hidden" name="orderSn" id="orderSn" />
			<h2>确认订单？</h2>
			<table style="text-decoration: none;text-align:center" >
				<!-- <tr >
					<td ><input id="comfOrder" class="mini-checkboxlist" style="margin-top: 20px;margin-left: 30px;"   valueField="id"   data="[{'id':'1','text':'是否同时生成康众平台配件订单'}]"/></td> 
				</tr>  --> 
				<tr>
					<td style="white-space:nowrap;">
					<a class="mini-button" onclick="confirmOrder()" style="margin-top: 50px;margin-left: 50px;" >保存</a> <a class="mini-button" onclick="cancelRow()" style="margin-top: 50px;">取消</a></td>
				</tr>
			</table>
</div>
	
</body>
<script type="text/javascript" src="<%=ctx%>/page/msds/km/order/order_edit.js"></script>
</html>