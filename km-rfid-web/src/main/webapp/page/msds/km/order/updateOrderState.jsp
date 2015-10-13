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
			<table style="padding-left: 100px; padding-top: 20px;" >
				<tr >
					<td >状态：<input id="orderState" class="mini-combobox"   valueField="id" style="width: 90px;" 
					 value=""  data="[{'id':'1','text':'代付款'},
				{'id':'2','text':'待确认'},{'id':'3','text':'待服务'},
				{'id':'4','text':'已完成'},{'id':'5','text':'已取消'},{'id':'6','text':'异常'},
				{'id':'7','text':'退款中'},{'id':'8','text':'退款已完成'}]"/>
					 </td> 
					</tr>  
				<tr>
					<td style="white-space:nowrap; padding-top: 60px;padding-left: 25px;">
					<a class="mini-button" onclick="updateOrderState()">保存</a> <a class="mini-button" onclick="cancelRow()">取消</a></td>
				</tr>
			</table>
</div>
	
</body>
<script type="text/javascript" src="<%=ctx%>/page/msds/km/order/order_edit.js"></script>
</html>