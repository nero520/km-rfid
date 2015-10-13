<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<head>
<%@include file="/page/msds/common/commonjs.jsp" %>
</head>
<body>
	<div class="mini-fit" style="background: url('${ctx}/js/miniui/themes/blue/images/toolbar/toolbar.gif') repeat-x scroll 0 0 #f0f0f0;border: 1px solid #99bce8">
		<div class="contentView" >
			确认已打款！
			<form id="editform">
				<input type="text" id="settleSn" name="settleSn" class="mini-hidden">
				<table>
					<tr>
						<td>实际结算金额：</td>
							<td><input type="text" id="actualAmount" name="actualAmount" class="mini-textbox" 
							vtype="float" required="true" emptyText="必填项，请输入">
						</td>
					</tr>
					<tr>
						<td>备注：</td>
						<td>
							<textarea id="remark" name="remark" rows="1" cols="15" 
							vtype="maxLength:20" class="mini-textbox" emptyText="非必填，限20个字"></textarea>
						</td>
					</tr>
					<tr height="50">
						<td style="text-align:center;"><a class="mini-button" onclick="updateRow()">确定</a></td>
						<td style="text-align:center;"><a class="mini-button" onclick="cancelRow()">取消</a></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
<script type="text/javascript" src="<%=ctx%>/page/msds/km/settleAccount/settleAccount_edit.js"></script>
</html>