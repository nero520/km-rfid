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
					<td>结算单号：</td>
					<td><input name="billSn" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写结算单号" /></td>
				</tr>
				<tr>
					<td>对账单号：</td>
					<td><input name="settleSn" 
						required="true" vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写对账单号" /></td>
				</tr>
				<tr>
					<td>服务完成时间：</td>
					<td><input name="serivceFinishDate" 
						 format="yyyy-MM-dd H:mm:ss" timeFormat="H:mm:ss" showTime="true" style="width: 160px;"  class="mini-datepicker" emptyText="请填写服务完成时间" /></td>
				</tr>
				<tr>
					<td>收款方式：BillingTypeEnum：</td>
					<td><input name="billingType" 
						 allowLimitValue="false" style="width: 160px;"  class="mini-spinner" emptyText="请填写收款方式：BillingTypeEnum" /></td>
				</tr>
				<tr>
					<td>银行户名：</td>
					<td><input name="accountName" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写银行户名" /></td>
				</tr>
				<tr>
					<td>开户行：</td>
					<td><input name="accountBankName" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写开户行" /></td>
				</tr>
				<tr>
					<td>卡号：</td>
					<td><input name="accountNumber" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写卡号" /></td>
				</tr>
				<tr>
					<td>结算总金额：</td>
					<td><input name="settleAllAmount" 
						 allowLimitValue="false" style="width: 160px;"  class="mini-spinner" emptyText="请填写结算总金额" /></td>
				</tr>
				<tr>
					<td>实际结算金额：</td>
					<td><input name="actualAmount" 
						 allowLimitValue="false" style="width: 160px;"  class="mini-spinner" emptyText="请填写实际结算金额" /></td>
				</tr>
				<tr>
					<td>结算状态：</td>
					<td><input name="billState" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写结算状态" /></td>
				</tr>
				<tr>
					<td>备注：</td>
					<td><input name="remark" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写备注" /></td>
				</tr>
				<tr>
					<td>创建时间：</td>
					<td><input name="createDate" 
						 format="yyyy-MM-dd H:mm:ss" timeFormat="H:mm:ss" showTime="true" style="width: 160px;"  class="mini-datepicker" emptyText="请填写创建时间" /></td>
				</tr>
				<tr>
					<td>修改时间：</td>
					<td><input name="modifyDate" 
						 format="yyyy-MM-dd H:mm:ss" timeFormat="H:mm:ss" showTime="true" style="width: 160px;"  class="mini-datepicker" emptyText="请填写修改时间" /></td>
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
<script type="text/javascript" src="<%=ctx%>/page/msds/km/bill/bill_edit.js"></script>
</html>