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
					<td style="text-align: center;">服务编码：</td>
					<td style="text-align: left;"><input name="serviceCode" required="true" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写服务编码" /></td>
				</tr>
				<tr>
					<td style="text-align: center;">服务名称：</td>
					<td><input name="serviceName" 
						required="true" vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写服务名称" /></td>
				</tr>
				<tr>
					<td style="text-align: center;">描述：</td>
					<td><input name="describe" required="true" 
						 vtype="rangeLength:1,5000" style="width:160px;height: 80px;"  class="mini-textarea" emptyText="1-5000字" /></td>
				</tr>
				<tr>
					<td style="text-align:center;padding-top:5px;"
						colspan="2"><a class="mini-button"
						onclick="updateRow()">保存</a> <a class="mini-button"
						onclick="cancelRow()">取消</a></td>
				</tr>
			</table>
		</div>
	</div>
</body>
<script type="text/javascript" src="<%=ctx%>/page/msds/km/service/service_edit.js"></script>
</html>