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
					<td>类型(首页轮播图、更多期待)：</td>
					<td><input name="type" 
						required="true" vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写类型(首页轮播图、更多期待)" /></td>
				</tr>
				<tr>
					<td>描述：</td>
					<td><input name="display" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写描述" /></td>
				</tr>
				<tr>
					<td>跳转地址：</td>
					<td><input name="link" 
						required="true" vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写跳转地址" /></td>
				</tr>
				<tr>
					<td>图片地址：</td>
					<td><input name="img" 
						required="true" vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写图片地址" /></td>
				</tr>
				<tr>
					<td>平台：</td>
					<td><input name="os" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写平台" /></td>
				</tr>
				<tr>
					<td>排序：</td>
					<td><input name="sort" 
						required="true" allowLimitValue="false" style="width: 160px;"  class="mini-spinner" emptyText="请填写排序" /></td>
				</tr>
				<tr>
					<td>是否启用（1启用0禁用）：</td>
					<td><input name="enabled" 
						required="true" vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写是否启用（1启用0禁用）" /></td>
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
<script type="text/javascript" src="<%=ctx%>/page/msds/km/publish/publish_edit.js"></script>
</html>