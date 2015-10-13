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
				<td style="width:120px;text-align:right;">手机号码：</td>
	            <td>
	            	<input name="phoneid" class="mini-textbox" style="width:150px;" />
	            </td>  
				<td style="width:120px;text-align:right;">车牌号码：</td>
				<td><input name = "license" class="mini-textbox" style="width:150px;" /></td>
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
	<div class="mini-toolbar"
		style="padding:2px;border-top:0;border-left:0;border-right:0;">
		<table style="width:100%;">
			<tr>
				<td style="width:100%;">
					<a class="mini-button" iconCls="icon-add" onclick="add('${ctx}/bespeak/addMember.action','新增车主信息')">增加</a>
					<a class="mini-button" iconCls="icon-edit" onclick="edit()">修改</a>
					<a class="mini-button"
                    iconCls="icon-search" onclick="viewMember()">查看</a>
				</td>
			</tr>
		</table>
	</div>
	
	<div class="mini-fit">
		<div id="datagrid_member" class="mini-datagrid"
			style="width:100%;height:100%;" borderStyle="border:0;"
			url="${ctx}/bespeak/getMemberList.action" idField="id"
			allowAlternating="true" sortField="id" sortOrder="desc"
			 multiSelect="true">
			<div property="columns">
				<div type="checkcolumn"></div>
					<div field="phone" headerAlign="center" allowSort="true">车主手机</div>
					<div field="name" headerAlign="center" allowSort="true">车主姓名</div>
					<div field="modelGroupName" headerAlign="center" allowSort="true">车型</div>
					<div field="license" headerAlign="center" allowSort="true">车牌号码</div>
					<div name ="vin" field="vin"  headerAlign="center" allowSort="true">VIN</div>
					<div field="mileage" headerAlign="center" allowSort="true">行驶里程(KM)</div>
					<div field="createDate" dateFormat="yyyy-MM-dd H:mm:ss" headerAlign="center" allowSort="true">注册时间</div>
					
			</div>
		</div>
	</div>
</body>
	<script type="text/javascript">
        mini.parse();
    
    </script>
<script type="text/javascript" src="<%=ctx%>/page/msds/km/member/member_list.js"></script>
</html>