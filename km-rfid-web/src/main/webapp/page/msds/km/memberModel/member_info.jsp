<%@page import="com.msds.km.vo.Order"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<head>
<%@include file="/page/msds/common/commonjs.jsp" %>
</head>
<body>

	<div class="mini-fit" style="background: url('${ctx}/js/miniui/themes/blue/images/toolbar/toolbar.gif') repeat-x scroll 0 0 #f0f0f0;border: 1px solid #99bce8">
	<div class="contentView" >
	<div id="editform" class="form">
	<h3>用户车型信息</h3>
	<div id="datagrid_orderLog" class="mini-datagrid"
			height="100%" borderStyle="border:0;"
			url="${ctx}/memberModel/dataList.action" idField="id"
			allowAlternating="true" sortField="id" sortOrder="asc" >
			<div property="columns">
					<div field="modelGroupName"headerAlign="center" allowSort="true">车型组合名称(品牌车系排量年份)</div>
					<div field="region"headerAlign="center" allowSort="true">所属区域</div>
					<div field="license"headerAlign="center" allowSort="true">车牌号</div>
					<div field="mileage"headerAlign="center" allowSort="true">里程数</div>
					<div field="buyDate" dateFormat="yyyy-MM-dd" headerAlign="center" allowSort="true">购买日期</div>
					<div field="vin"headerAlign="center" allowSort="true">车架号</div>
			</div>
	</div>
	
</div>
	<div style="text-align: center;"><a class="mini-button" onclick="goBack()">返回</a></div>
</div>
	
</body>
<script type="text/javascript">

mini.parse();

var grid_Log = mini.get("datagrid_orderLog");

var paramsLog = {"memberId":"${directShopEntity.id}"};
grid_Log.load(paramsLog);

function goBack() {
	parent.removeTab();
}

</script>
</html>