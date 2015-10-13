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
				<td style="text-align:right;">对账单号：</td>
				<td><input id="settleSn" name="settleSn" class="mini-textbox"></td>
				<td style="text-align:right;">状态：</td>
				<td>
					<input id="settleState" class="mini-combobox" data="settleStateSelect" style="width:125px;" valueField="id" value="0"/>
				</td>
			</tr>
			<tr>		
				<td style="text-align:right;">修理厂名称：</td>
				<td>
					<input id="companyId" class="mini-combobox" style="width:190px;" textField="name" valueField="id" 
    				url="${ctx}/company/dataList.action" showNullItem="true" vlaue="" />
				<td style="text-align:right;">起止时间：</td>
				<td>
					<input id="beforeDate" name="beforeDate" class="mini-datepicker" maxDate="mini.get('afterDate').getValue()">－
					<input id="afterDate" name="afterDate" class="mini-datepicker" minDate="mini.get('beforeDate').getValue()">
				</td>
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
		<div id="datagrid_settleAccount" class="mini-datagrid" display="block"
			 borderStyle="border:0;" style="width: 100%;height:100%"
			url="${ctx}/settleAccount/findSettleAccountList.action" idField="id"
			allowAlternating="true" sortField="id" sortOrder="desc" multiSelect="true" 
			allowHeaderWrap="false" fitColumns="true">
			<div property="columns">
				<div field="settleSn"			headerAlign="center" width="150px">对账单号</div>
				<div field="startDate"			headerAlign="center">账单起始日期</div>
				<div field="endDate"			headerAlign="center">账单截止日期</div>
				<div field="companyName"		headerAlign="center" width="190px">修理厂名称</div>
<!-- 				<div field="companyAddress"		headerAlign="center" >修理厂地址</div> -->
				<div field="settleState"		headerAlign="center" type="comboboxcolumn">对账状态
					<input property="editor" class="mini-combobox" data="settleState" /></div>
				<div field="settleAllAmount"	headerAlign="center" dataType="currency">应结算金额</div>
				<div field="actualAmount"		headerAlign="center" dataType="currency">实际结算金额</div>
				<div field="remark"				headerAlign="center">备注</div>
				<div name="action"				headerAlign="center">操作</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="<%=ctx%>/page/msds/km/settleAccount/settleAccount_list.js"></script>
</html>