<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<head>
<%@include file="/page/msds/common/commonjs.jsp"%>
</head>
<body>
	<div class="mini-fit"
		style="background: url('<%=ctx%>/js/miniui/themes/blue/images/toolbar/toolbar.gif') repeat-x scroll 0 0 #f0f0f0;border: 1px solid #99bce8">
		<div id="editform" class="form">
			<input class="mini-hidden" name="id" />
			<table style="width: 100%;">
				<tr>
					<td>活动sn：</td>
					<td><input name="sn" required="true" vtype="rangeLength:1,50"
						style="width: 160px;" class="mini-textbox" emptyText="请填写活动sn" /></td>
				</tr>
				<tr>
					<td>活动名称：</td>
					<td><input name="title" required="true"
						vtype="rangeLength:1,50" style="width: 160px;"
						class="mini-textbox" emptyText="请填写活动名称" /></td>
				</tr>
				<tr>
					<td>活动描述：</td>
					<td><input name="description" vtype="rangeLength:1,50"
						style="width: 160px;" class="mini-textbox" emptyText="请填写活动描述" /></td>
				</tr>
				<tr>
					<td>奖品：</td>
					<td><input name="prize" required="true"
						vtype="rangeLength:1,50" style="width: 160px;"
						class="mini-textbox" emptyText="请填写奖品" /></td>
				</tr>
				<tr>
					<td>总数：</td>
					<td><input name="count" required="true"
						allowLimitValue="false" style="width: 160px;" class="mini-spinner"
						emptyText="请填写总数" /></td>
				</tr>
				<tr>
					<td>数量：</td>
					<td><input name="quantity" required="true"
						allowLimitValue="false" style="width: 160px;" class="mini-spinner"
						emptyText="请填写数量" /></td>
				</tr>
				<tr>
					<td>状态：</td>
					<td><input name="state" required="true"
						vtype="rangeLength:1,50" style="width: 160px;"
						class="mini-combobox" data="activityState" emptyText="请填写状态" /></td>
				</tr>
				<tr>
					<td>开始时间：</td>
					<td><input name="startTime" required="true"
						format="yyyy-MM-dd H:mm:ss" timeFormat="H:mm:ss" showTime="true"
						style="width: 160px;" class="mini-datepicker" emptyText="请填写开始时间" /></td>
				</tr>
				<tr>
					<td>结束时间：</td>
					<td><input name="endTime" required="true"
						format="yyyy-MM-dd H:mm:ss" timeFormat="H:mm:ss" showTime="true"
						style="width: 160px;" class="mini-datepicker" emptyText="请填写结束时间" /></td>
				</tr>
				<tr>
					<td>操作人：</td>
					<td><input name="operator" allowLimitValue="false"
						style="width: 160px;" class="mini-spinner" emptyText="请填写操作人" /></td>
				</tr>
				<tr>
					<td>创建时间：</td>
					<td><input name="createDate" format="yyyy-MM-dd H:mm:ss"
						timeFormat="H:mm:ss" showTime="true" style="width: 160px;"
						class="mini-datepicker" emptyText="请填写创建时间" /></td>
				</tr>
				<tr>
					<td>修改时间：</td>
					<td><input name="modifyDate" format="yyyy-MM-dd H:mm:ss"
						timeFormat="H:mm:ss" showTime="true" style="width: 160px;"
						class="mini-datepicker" emptyText="请填写修改时间" /></td>
				</tr>
				<tr>
					<td
						style="text-align: right; padding-top: 5px; padding-right: 20px;"
						colspan="3"><a class="mini-button" onclick="updateRow()">保存</a>
						<a class="mini-button" onclick="cancelRow()">取消</a></td>
				</tr>
			</table>
		</div>
	</div>
</body>
<script type="text/javascript"
	src="<%=ctx%>/page/msds/km/activity/activity_edit.js"></script>
</html>