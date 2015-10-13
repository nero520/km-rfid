<html xmlns="http://www.w3.org/1999/xhtml">
<%@page import="java.util.Random"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<head>
<%@include file="/page/msds/common/commonjs.jsp" %>
<link rel="stylesheet" type="text/css" href="${ctx}/js/uploadify3.1/uploadify.css">
<script type="text/javascript" src="${ctx}/js/uploadify3.1/jquery.uploadify.min.js?ver=<%=new Random().nextDouble() %>>"></script>
<style>
	td{
	padding-top: 10px;padding-left: 5px;
	}
	
</style>

</head>
<body style="height:100%;">
	<div class="mini-fit" style="background: url('<%=ctx%>/js/miniui/themes/blue/images/toolbar/toolbar.gif') repeat-x scroll 0 0 #f0f0f0;border: 1px solid #99bce8;">
		<div id="editform" class="form">
			<input class="mini-hidden" name="id" />
			<table style="width:100%">
				<tr>
					<td>修理厂用户名：</td>
					<td><input name="username" 
						 vtype="rangeLength:2,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写修理厂用户名" required="true" /></td>
				</tr>
				<!-- <tr >
					<td>修理厂密码：</td>
					<td ><input name="password" required="true" 
						 vtype="rangeLength:8,20" style="width: 160px;"   class="mini-password" emptyText="" /></td>
				</tr> -->
				<tr>
					<td>修理厂名称：</td>
					<td><input name="name" 
						 vtype="rangeLength:2,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写修理厂名称" required="true"/></td>
				</tr>
				<tr style="padding-top: 20px;">
					<td>修理厂电话：</td>
					<td><input name="telephone" 
						  style="width: 160px;"  class="mini-textbox" emptyText="010-1111111" required="true" onvalidation="telephoneV"/></td>
				</tr>
				<tr>
					<td >修理厂地址：</td>
					<td><input name="province" 
							 allowLimitValue="false" style="width: 160px;"  class="mini-combobox" emptyText="省"  
							 url="${ctx}/area/getProvinceComboboxList.action" id="provinceComp" onvaluechanged="onProvinceChanged" onvalidation="aercV"/>
						 <input name="city" 
							 allowLimitValue="false" style="width: 160px;"  class="mini-combobox" emptyText="市" 
						  id = 'cityComp' onvaluechanged="onCityChanged" />
						  <input name="area" 
						 	allowLimitValue="false" style="width: 160px;"  class="mini-combobox" emptyText="区"  
						   id="areaComp" /><br/>
						   <input name="address" 
						 vtype="rangeLength:1,50" style="width: 240px;"  class="mini-textbox" emptyText="请填写具体地址" required="true"/>
						 </td>
				</tr>
				<tr>
					<td>联系人：</td>
					<td><input name="contacts" 
						 vtype="rangeLength:2,10" style="width: 160px;"  class="mini-textbox" emptyText="请填写联系人" required="true" id="contactsV" onvalidation="contactsV"/></td>
				</tr>
				<tr>
					<td>联系电话：</td>
					<td><input name="contactsPhone" 
						 vtype="int" style="width: 160px;"  class="mini-textbox" emptyText="请填写联系电话" vtype="maxLength:15" required="true" 
						 	onvalidation="contactsPhoneV"
						 /></td>
				</tr>
				
				<tr>
					<td>营业时间：</td>
					<td>
						 <input name="startDate" class="mini-combobox" style="width:90px;"   valueField="id" value="8:00" data="[{'id':'8:00','text':'8:00'},{'id':'8:30','text':'8:30'},{'id':'9:00','text':'9:00'}]" />
						 <input  name="overDate" class="mini-combobox" style="width:90px;" valueField="id" value="18:00" data="[{'id':'18:00','text':'18:00'},{'id':'18:30','text':'18:30'},{'id':'19:00','text':'19:00'},{'id':'19:30','text':'19:30'},{'id':'20:00','text':'20:00'}]"  />
						 </td>
				</tr>
				
				<tr>
					<td>服务范围描述：</td>
					<td><!-- <input name="describe" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写描述" /> -->
						 <textarea  name="describe" class="mini-textarea" emptyText="请填写描述" vtype="rangeLength:1,150" style="width: 240px;height: 90px;"></textarea>
						 </td>
				</tr>
				
				<tr>
						<td >门头照片：</td>
						<td style="white-space:nowrap;" id="doorPicTd"><img id="iconimage" name="doorPic" width="120px" height="80px" ></img>
							<input name="doorPic" id="icon_path" class="mini-hidden"  required="true"/>
							<input name="upload_file" id="upload_file" type="file" style="white-space:nowrap;"  required="true" onchange="iamgeV"/>
						</td>
						 
				</tr>
				<tr>
					<td style="padding-top:20px;padding-left:230px;"
						colspan="3"><a class="mini-button"
						onclick="updateRow()">保存</a> <a class="mini-button"
						onclick="cancelRow()">取消</a></td>
				</tr>
			</table>
		</div>
	</div>
</body>

<script type="text/javascript" src="<%=ctx%>/page/msds/km/company/company_edit.js"></script>
</html>