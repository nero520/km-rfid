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
					<td>创建时间：</td>
					<td><input name="createDate" 
						required="true" format="yyyy-MM-dd H:mm:ss" timeFormat="H:mm:ss" showTime="true" style="width: 160px;"  class="mini-datepicker" emptyText="请填写创建时间" /></td>
				</tr>
				<tr>
					<td>修改时间：</td>
					<td><input name="modifyDate" 
						required="true" format="yyyy-MM-dd H:mm:ss" timeFormat="H:mm:ss" showTime="true" style="width: 160px;"  class="mini-datepicker" emptyText="请填写修改时间" /></td>
				</tr>
				<tr>
					<td>区域排序：</td>
					<td><input name="orders" 
						 allowLimitValue="false" style="width: 160px;"  class="mini-spinner" emptyText="请填写区域排序" /></td>
				</tr>
				<tr>
					<td>区域全称：</td>
					<td><input name="fullName" 
						required="true" vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写区域全称" /></td>
				</tr>
				<tr>
					<td>名称：</td>
					<td><input name="name" 
						required="true" vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写名称" /></td>
				</tr>
				<tr>
					<td>树：</td>
					<td><input name="treePath" 
						required="true" vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写树" /></td>
				</tr>
				<tr>
					<td>父ID：</td>
					<td><input name="parent" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写父ID" /></td>
				</tr>
				<tr>
					<td>父区域代码：</td>
					<td><input name="parentAreaCode" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写父区域代码" /></td>
				</tr>
				<tr>
					<td>区域代码：</td>
					<td><input name="areaCode" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写区域代码" /></td>
				</tr>
				<tr>
					<td>等级：</td>
					<td><input name="level" 
						required="true" allowLimitValue="false" style="width: 160px;"  class="mini-spinner" emptyText="请填写等级" /></td>
				</tr>
				<tr>
					<td>1（省直辖市）2（地级市）3（区县）4（乡镇）：</td>
					<td><input name="regionType" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写1（省直辖市）2（地级市）3（区县）4（乡镇）" /></td>
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
<script type="text/javascript" src="<%=ctx%>/page/msds/km/area/area_edit.js"></script>
</html>