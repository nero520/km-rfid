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
				data="[{'id':'id','text':'ID'},{'id':'serviceModelId','text':'服务车型ID'},{'id':'productId','text':'商品ID'},{'id':'productName','text':'商品名称冗余'},{'id':'modelId','text':'车型ID冗余'},{'id':'factory','text':'厂商'},{'id':'brandName','text':'品牌名称'},{'id':'seriesName','text':'车系名称'},{'id':'cartypeName','text':'型车名称'},{'id':'serviceName','text':'服务名称'},{'id':'serviceCode','text':'服务编码'},{'id':'mileage','text':'里程数'},{'id':'intervalMonth','text':'保养间隔时间（月）'}]" />
				<input id="key"	class="mini-textbox" emptyText="请输入" style="width:150px;"
					onenter="onKeyEnter" /> <a class="mini-button" onclick="search()">查询</a>
				</td>
			</tr>
		</table>
	</div>
	<div class="mini-fit">
		<div id="datagrid_serviceModelDetail" class="mini-datagrid"
			style="width:100%;height:100%;" borderStyle="border:0;"
			url="${ctx}/serviceModelDetail/dataList.action" idField="id"
			allowAlternating="true" sortField="id" sortOrder="desc"
			onrowdblclick="rowdblclick" multiSelect="true">
			<div property="columns">
				<div type="checkcolumn"></div>
					<div field="serviceModelId"headerAlign="center" allowSort="true">服务车型ID</div>
					<div field="productId"headerAlign="center" allowSort="true">商品ID</div>
					<div field="productName"headerAlign="center" allowSort="true">商品名称冗余</div>
					<div field="modelId"headerAlign="center" allowSort="true">车型ID冗余</div>
					<div field="factory"headerAlign="center" allowSort="true">厂商</div>
					<div field="brandName"headerAlign="center" allowSort="true">品牌名称</div>
					<div field="seriesName"headerAlign="center" allowSort="true">车系名称</div>
					<div field="cartypeName"headerAlign="center" allowSort="true">型车名称</div>
					<div field="serviceName"headerAlign="center" allowSort="true">服务名称</div>
					<div field="serviceCode"headerAlign="center" allowSort="true">服务编码</div>
					<div field="mileage"headerAlign="center" allowSort="true">里程数</div>
					<div field="intervalMonth"headerAlign="center" allowSort="true">保养间隔时间（月）</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="<%=ctx%>/page/msds/km/serviceModelDetail/serviceModelDetail_list.js"></script>
</html>