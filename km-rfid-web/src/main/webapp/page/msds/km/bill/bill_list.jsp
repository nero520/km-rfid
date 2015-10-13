<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<head>
<%@include file="/page/msds/common/commonjs.jsp" %>
</head>
<body>
	<div class="mini-toolbar"
		style="padding:2px;border-top:0;border-left:0;border-right:0;">
		<form id="form" method="post" class="divClass">
		<table style="width:100%;">
			<tr style="white-space:nowrap;">
				<td style="text-align:right;">结算单号：</td>
				<td><input id="billSn" name="billSn" class="mini-textbox"></td>
				<td style="text-align:right;">状态：</td>
				<td>
					<input name="billState" id="billState" class="mini-combobox" data="billStateSelect" style="width:125px;" valueField="id" value=""/>
				</td>
				<td style="text-align:right;">收款方式：</td>
				<td>
					<input name="billingType" id="billingType" class="mini-combobox" data="billingTypeSelect" style="width:125px;" valueField="id" value=""/>
				</td>
			</tr>
			<tr>		
				<td style="text-align:right;">收款账户：</td>
				<td><input id="accountNumber" name="accountNumber" class="mini-textbox"></td>
				<td style="text-align:right;">起止时间：</td>
				<td>
					<input id="beforeDate" name="beforeDate" class="mini-datepicker" maxDate="mini.get('afterDate').getValue()">－
					<input id="afterDate" name="afterDate" class="mini-datepicker" minDate="mini.get('beforeDate').getValue()">
				</td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td colspan="4" style="text-align:center;padding-top: 15px;">
				<a class="mini-button" onclick="resetSearch('#form')" style="width:60px">重 置</a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a class="mini-button" onclick="search()" style="width:60px">查 询</a>
				</td>
			</tr>
		</table>
		</form>
	</div>
	<div class="mini-fit">
		<div id="datagrid_bill" class="mini-datagrid"
			style="width:100%;height:100%;" borderStyle="border:0;"
			url="${ctx}/bill/dataList.action" idField="id"
			allowAlternating="true" sortField="billSn" sortOrder="asc" multiSelect="true" 
			allowCellWrap="false" allowHeaderWrap="false" fitColumns="true">
			<div property="columns">
				<div field="billSn" headerAlign="center">结算单号</div>
				<div field="createDate" dateFormat="yyyy-MM-dd HH:mm:ss" headerAlign="center" width="120">付款时间</div>
				<div field="billingType" headerAlign="center" type="comboboxcolumn">收款方式
					<input property="editor" class="mini-combobox" data="billingType" />
				</div>
				<div field="accountNumber" headerAlign="center" width="140">收款账号</div>
				<div field="settleAllAmount" headerAlign="center" dataType="currency">应结算金额</div>
				<div field="actualAmount" headerAlign="center" dataType="currency">收款金额</div>
				<div field="billState" headerAlign="center" type="comboboxcolumn" width="60">结算状态
					<input property="editor" class="mini-combobox" data="billState" />
				</div>
				<div field="remark" headerAlign="center">备注</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="<%=ctx%>/page/msds/km/bill/bill_list.js"></script>
</html>