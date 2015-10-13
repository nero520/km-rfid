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
					<td>会员id：</td>
					<td><input name="memberId" 
						required="true" allowLimitValue="false" style="width: 160px;"  class="mini-spinner" emptyText="请填写会员id" /></td>
				</tr>
				<tr>
					<td>车型ID：</td>
					<td><input name="modelId" 
						 allowLimitValue="false" style="width: 160px;"  class="mini-spinner" emptyText="请填写车型ID" /></td>
				</tr>
				<tr>
					<td>车型组合名称(品牌车系排量年份)：</td>
					<td><input name="modelGroupName" 
						required="true" vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写车型组合名称(品牌车系排量年份)" /></td>
				</tr>
				<tr>
					<td>是否默认：</td>
					<td><input name="defaultFlag" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写是否默认" /></td>
				</tr>
				<tr>
					<td>所属区域：</td>
					<td><input name="region" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写所属区域" /></td>
				</tr>
				<tr>
					<td>车牌号：</td>
					<td><input name="license" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写车牌号" /></td>
				</tr>
				<tr>
					<td>里程数：</td>
					<td><input name="mileage" 
						 allowLimitValue="false" style="width: 160px;"  class="mini-spinner" emptyText="请填写里程数" /></td>
				</tr>
				<tr>
					<td>创建日期：</td>
					<td><input name="buyDate" 
						 format="yyyy-MM-dd H:mm:ss" style="width: 160px;"  class="mini-datepicker" emptyText="请填写创建日期" /></td>
				</tr>
				<tr>
					<td>车架号：</td>
					<td><input name="vin" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写车架号" /></td>
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
<script type="text/javascript" src="<%=ctx%>/page/msds/km/memberModel/memberModel_edit.js"></script>
</html>