<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<head>
<%@include file="/page/msds/common/commonjs.jsp" %>
</head>
<body>
	<div class="mini-toolbar"
		style="padding:2px;border-top:0;border-left:0;border-right:0;">
		<table style="width:100%;">
			<tr>
				<td style="width:100%;"><a class="mini-button"
					iconCls="icon-add" onclick="add()">增加</a><a class="mini-button"
					iconCls="icon-remove" onclick="remove()">删除</a></td>
				<td style="white-space:nowrap;">
				<input id="searchField" class="mini-combobox" style="width:75px;" value="id"
				data="[{'id':'id','text':'ID'},{'id':'refundSn','text':'退款单编号'},{'id':'orderSn','text':'订单编号'},{'id':'memberId','text':'客户编号'},{'id':'price','text':'退款金额'},{'id':'state','text':'退款状态'},{'id':'payCode','text':'退款支付流水'},{'id':'oldPayMode','text':'原支付方式保存字符串'},{'id':'batchNo','text':'退款批次'},{'id':'oldPayCode','text':'原支付流水'},{'id':'operator','text':'操作人'},{'id':'createDate','text':'创建时间'},{'id':'modifyDate','text':'修改时间'}]" />
				<input id="key"	class="mini-textbox" emptyText="请输入" style="width:150px;"
					onenter="onKeyEnter" /> <a class="mini-button" onclick="search()">查询</a>
				</td>
			</tr>
		</table>
	</div>
	<div class="mini-fit">
		<div id="datagrid_refundLog" class="mini-datagrid"
			style="width:100%;height:100%;" borderStyle="border:0;"
			url="${ctx}/refundLog/dataList.action" idField="id"
			allowAlternating="true" sortField="id" sortOrder="desc"
			onrowdblclick="rowdblclick" multiSelect="true">
			<div property="columns">
				<div type="checkcolumn"></div>
					<div field="refundSn"headerAlign="center" allowSort="true">退款单编号</div>
					<div field="orderSn"headerAlign="center" allowSort="true">订单编号</div>
					<div field="memberId"headerAlign="center" allowSort="true">客户编号</div>
					<div field="price"headerAlign="center" allowSort="true">退款金额</div>
					<div field="state"headerAlign="center" allowSort="true">退款状态</div>
					<div field="payCode"headerAlign="center" allowSort="true">退款支付流水</div>
					<div field="oldPayMode"headerAlign="center" allowSort="true">原支付方式保存字符串</div>
					<div field="batchNo"headerAlign="center" allowSort="true">退款批次</div>
					<div field="oldPayCode"headerAlign="center" allowSort="true">原支付流水</div>
					<div field="operator"headerAlign="center" allowSort="true">操作人</div>
					<div field="createDate" dateFormat="yyyy-MM-dd H:mm:ss" headerAlign="center" allowSort="true">创建时间</div>
					<div field="modifyDate" dateFormat="yyyy-MM-dd H:mm:ss" headerAlign="center" allowSort="true">修改时间</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="<%=ctx%>/page/msds/km/refundLog/refundLog_list.js"></script>
</html>