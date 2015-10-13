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
						 format="yyyy-MM-dd H:mm:ss" timeFormat="H:mm:ss" showTime="true" style="width: 160px;"  class="mini-datepicker" emptyText="请填写创建时间" /></td>
				</tr>
				<tr>
					<td>修改时间：</td>
					<td><input name="modifyDate" 
						 format="yyyy-MM-dd H:mm:ss" timeFormat="H:mm:ss" showTime="true" style="width: 160px;"  class="mini-datepicker" emptyText="请填写修改时间" /></td>
				</tr>
				<tr>
					<td>epc号：</td>
					<td><input name="epcNo" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写epc号" /></td>
				</tr>
				<tr>
					<td>省ID：</td>
					<td><input name="proviceId" 
						 allowLimitValue="false" style="width: 160px;"  class="mini-spinner" emptyText="请填写省ID" /></td>
				</tr>
				<tr>
					<td>市ID：</td>
					<td><input name="cityId" 
						 allowLimitValue="false" style="width: 160px;"  class="mini-spinner" emptyText="请填写市ID" /></td>
				</tr>
				<tr>
					<td>街道ID：</td>
					<td><input name="streetId" 
						 allowLimitValue="false" style="width: 160px;"  class="mini-spinner" emptyText="请填写街道ID" /></td>
				</tr>
				<tr>
					<td>地址全称：</td>
					<td><input name="fullArea" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写地址全称" /></td>
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
<script type="text/javascript" src="<%=ctx%>/page/msds/km/rfidLog/rfidLog_edit.js"></script>
</html>