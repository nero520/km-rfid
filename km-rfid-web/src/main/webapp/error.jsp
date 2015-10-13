<%@ page language="java" isErrorPage="true"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发生了什么</title>
</head>
<body bgcolor="#d9e8fb">
	<div align="center">
		<br>
		<h2>抱歉，系统功能不断完善中。。。请联系管理员反馈，谢谢！</h2>
		<hr>
		<p>
			<%
				org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger("");
				log.error("页面出错:{}", exception.toString());
			%>
		</p>
		<br> <img alt="" src="${ctx}/images/weixiao.png"> <br>
		<br> <a href="javascript: window.CloseOwnerWindow();">关闭</a>
	</div>
</body>
</html>
