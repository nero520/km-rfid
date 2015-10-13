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
			<input class="mini-hidden" name="state" value="${state}"/>
			<h3>填写退款流水号</h3>
			<table style="width:100%;">
				<tr>
					<td>退款流水号：</td>
					<td>
						<input name="payCode" vtype="rangeLength:1,50" style="width: 160px;" onvalidation="onEnglishAndNumberValidation"
							class="mini-textbox" emptyText="请填写退款流水号" maxlength="50" required="true"/>
						 <input class="mini-hidden" name="orderSn" vlaue=${orderSn }/>
					</td>
				</tr>
				<tr >
					<td colspan="2" style="white-space:nowrap; vertical-align:middle; text-align:center;">
						<a class="mini-button" style="margin-top: 20px;"onclick="updateRow()">保存</a> 
						<a class="mini-button" style="margin-top: 20px;"onclick="cancelRow()">取消</a>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
<script type="text/javascript" src="<%=ctx%>/page/msds/km/refund/refund_edit.js"></script>
</html>