<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<head>
<%@include file="/page/msds/common/commonjs.jsp" %>
</head>
<body>
	<div class="mini-toolbar"
		style="padding:2px;border-top:0;border-left:0;border-right:0;">
		<form id="form" class="divClass">
		<table style="width:100%;">
			<tr>		
    			<td style="text-align:right;">预约单号：</td>
				<td><input id="bespeakSn" name="bespeakSn" class="mini-textbox"></td>
				<td style="text-align:right;">预约时间：</td>
				<td>
					<input id="beforeDate" name="beforeDate" class="mini-datepicker" maxDate="mini.get('afterDate').getValue()">－
					<input id="afterDate" name="afterDate" class="mini-datepicker" minDate="mini.get('beforeDate').getValue()">
				</td>
			</tr>
			<tr>		
    			<td style="text-align:right;">车主手机号：</td>
				<td><input id="phone" name="phone" class="mini-textbox"></td>
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
		<div id="datagrid_bespeak" class="mini-datagrid"
			style="width:100%;height:100%;" borderStyle="border:0;"
			url="${ctx}/bespeak/dataList.action" idField="id"
			allowAlternating="true" sortField="id" sortOrder="desc"
			allowCellWrap="false" allowHeaderWrap="false" onrowdblclick="rowdblclick" multiSelect="true">
			<div property="columns">
				<div field="bespeakSn" headerAlign="center" allowSort="true" width="55">预约单号</div>
				<div field="bespeakDate" dateFormat="yyyy-MM-dd HH:mm:ss" headerAlign="center" width="60">预约时间</div>
				<div field="state" headerAlign="center" type="comboboxcolumn" width="30">状态
					<input property="editor" class="mini-combobox" data="bespeakState" /></div>
				<div field="laborcost" headerAlign="center" dataType="currency" width="30">工时费</div>
				<div field="totalPrice" headerAlign="center" dataType="currency" width="40">总价</div>
				<div field="mileage" headerAlign="center" width="40">行驶里程(KM)</div>
				<div field="phone" headerAlign="center" width="40">车主手机号</div>
				<div field="modelGroupName" headerAlign="center">车型</div>
				
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="<%=ctx%>/page/msds/km/bespeak/bespeak_list.js"></script>
</html>