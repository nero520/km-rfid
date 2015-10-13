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
			<input class="mini-hidden" name="id" id="cancelId"/>
			<table  >
				<tr>
					<td >
					 <input type="radio" style="height: 16px;margin: 0;overflow: hidden;padding: 0;vertical-align: middle;width: 16px;" value="0" name="remark" class="remarkClass">
					 <span style="  font-family: Tahoma,Verdana,宋体;font-size: 9pt; line-height: 16px; padding-left: 2px; vertical-align: middle;" >车主不想预约了</span><br>
					 <input type="radio" style="height: 16px;margin: 0;overflow: hidden;padding: 0;vertical-align: middle;width: 16px;" value="1" name="remark" class="remarkClass">
					 <span style="  font-family: Tahoma,Verdana,宋体;font-size: 9pt; line-height: 16px; padding-left: 2px; vertical-align: middle;">车主信息填写错误，重新下订单</span><br>
					 <input type="radio" style="height: 16px;margin: 0;overflow: hidden;padding: 0;vertical-align: middle;width: 16px;" value="2" name="remark" class="remarkClass">
					 <span style="  font-family: Tahoma,Verdana,宋体;font-size: 9pt; line-height: 16px; padding-left: 2px; vertical-align: middle;">车主预约时间不合适</span><br>
					 <input type="radio" style="height: 16px;margin: 0;overflow: hidden;padding: 0;vertical-align: middle;width: 16px;" value="3" name="remark" class="remarkClass" >
					 <span style="  font-family: Tahoma,Verdana,宋体;font-size: 9pt; line-height: 16px; padding-left: 2px; vertical-align: middle;">车主预约地址不合适</span><br>
					 <input type="radio" style="height: 16px;margin: 0;overflow: hidden;padding: 0;vertical-align: middle;width: 16px;" value="4" name="remark" id="elseRemark">
					 <span style="  font-family: Tahoma,Verdana,宋体;font-size: 9pt; line-height: 16px; padding-left: 2px; vertical-align: middle;">其它原因</span>
				 </td> 
				</tr>  
				<tr>
					<td >
						<div id="otherCancelInfo" style="display: none;"><input  class="mini-textarea"  emptyText="可以输入1-200个汉字" style="width: 250px;height: 70px;" id="otherInfo" maxlength="200" ></div>
					</td>
				</tr>				
				
				<tr >
					<td style="white-space:nowrap; vertical-align:middle; text-align:center;">
					<a class="mini-button" onclick="cancel()">保存</a> <a class="mini-button" onclick="cancelRow()">取消</a></td>
				</tr>
			</table>
</div>
	
</body>
<script type="text/javascript" src="<%=ctx%>/page/msds/km/order/order_edit.js"></script>
</html>