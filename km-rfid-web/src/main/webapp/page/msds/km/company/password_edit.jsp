<html xmlns="http://www.w3.org/1999/xhtml">
<%@page import="java.util.Random"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<head>
<%@include file="/page/msds/common/commonjs.jsp" %>
<link rel="stylesheet" type="text/css" href="${ctx}/js/uploadify3.1/uploadify.css">
<script type="text/javascript" src="${ctx}/js/uploadify3.1/jquery.uploadify.min.js?ver=<%=new Random().nextDouble() %>>"></script>
<style>
	td{
	padding-top: 10px;padding-left: 5px;
	}
	
</style>

</head>
<body style="height:100%;">
	<div class="mini-fit" style="background: url('<%=ctx%>/js/miniui/themes/blue/images/toolbar/toolbar.gif') repeat-x scroll 0 0 #f0f0f0;border: 1px solid #99bce8;">
		<div id="editform" class="form">
			
			<table style="width:100%;text-align: right;top: 20px;">
				
				<tr >
					<td style="text-align: right;">请输入新密码：</td>
					<td style="text-align: left;">
						<input class="mini-hidden" name="id" id="idHidden"/>
						<input name="password" 
						 vtype="rangeLength:8,20" style="width: 160px;"  class="mini-password" emptyText="请输入新密码" id="password"/ required="true" onvalidation="passwordValid"></td>
				</tr>
				<tr >
					<td style="text-align: right;">请再次输入密码：</td>
					<td style="text-align:left;"><input name="password1" 
						 vtype="rangeLength:8,20" style="width: 160px;"  class="mini-password" emptyText="请再次输入密码" id="password1" required="true" onvalidation ="passwordValid1"/></td>
				</tr>
				
				<tr>
					<td style="text-align:center ;"
						colspan="3"><a class="mini-button"
						onclick="updatePassword()">保存</a> <a class="mini-button"
						onclick="cancelRow()">取消</a></td>
				</tr>
				
			</table>
		</div>
	</div>
</body>

<script type="text/javascript" src="<%=ctx%>/page/msds/km/company/company_edit.js"></script>
</html>