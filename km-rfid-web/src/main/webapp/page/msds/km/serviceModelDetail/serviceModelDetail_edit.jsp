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
					<td>服务车型ID：</td>
					<td><input name="serviceModelId" 
						 allowLimitValue="false" style="width: 160px;"  class="mini-spinner" emptyText="请填写服务车型ID" /></td>
				</tr>
				<tr>
					<td>商品ID：</td>
					<td><input name="productId" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写商品ID" /></td>
				</tr>
				<tr>
					<td>商品名称冗余：</td>
					<td><input name="productName" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写商品名称冗余" /></td>
				</tr>
				<tr>
					<td>车型ID冗余：</td>
					<td><input name="modelId" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写车型ID冗余" /></td>
				</tr>
				<tr>
					<td>厂商：</td>
					<td><input name="factory" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写厂商" /></td>
				</tr>
				<tr>
					<td>品牌名称：</td>
					<td><input name="brandName" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写品牌名称" /></td>
				</tr>
				<tr>
					<td>车系名称：</td>
					<td><input name="seriesName" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写车系名称" /></td>
				</tr>
				<tr>
					<td>型车名称：</td>
					<td><input name="cartypeName" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写型车名称" /></td>
				</tr>
				<tr>
					<td>服务名称：</td>
					<td><input name="serviceName" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写服务名称" /></td>
				</tr>
				<tr>
					<td>服务编码：</td>
					<td><input name="serviceCode" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写服务编码" /></td>
				</tr>
				<tr>
					<td>里程数：</td>
					<td><input name="mileage" 
						 allowLimitValue="false" style="width: 160px;"  class="mini-spinner" emptyText="请填写里程数" /></td>
				</tr>
				<tr>
					<td>保养间隔时间（月）：</td>
					<td><input name="intervalMonth" 
						 allowLimitValue="false" style="width: 160px;"  class="mini-spinner" emptyText="请填写保养间隔时间（月）" /></td>
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
<script type="text/javascript" src="<%=ctx%>/page/msds/km/serviceModelDetail/serviceModelDetail_edit.js"></script>
</html>