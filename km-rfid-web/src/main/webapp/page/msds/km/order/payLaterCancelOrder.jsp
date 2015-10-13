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
			<h3 style="padding-left: 20px;">客户已付款，确认取消订单？</h3>
			<table >
				<tr>
					<td  style="vertical-align:middle; text-align:center;padding-left: 20px;">取消原因：</td>
					<td>
						<input  class="mini-textarea" id="otherCancelInfo" emptyText="可以输入1-200个汉字" style="width: 200px;height: 100px;" maxlength="200">
					</td>
				</tr>				
				
				<tr >
				<td  style="vertical-align:middle; text-align:center;"></td>
					<td style="white-space:nowrap; padding-top: 20px; padding-left: 30px;">
					<a class="mini-button" onclick="payLaterCancelOrder()">保存</a> <a class="mini-button" onclick="cancelRow()">取消</a></td>
				</tr>
			</table>
</div>
	
</body>
<script type="text/javascript" src="<%=ctx%>/page/msds/km/order/order_edit.js"></script>
</html>