<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<head>
<%@include file="/page/msds/common/commonjs.jsp" %>
</head>
<body>
	<div class="mini-fit" style="height:800px;background: url('<%=ctx%>/js/miniui/themes/blue/images/toolbar/toolbar.gif') repeat-x scroll 0 0 #f0f0f0;border: 1px solid #99bce8">
		<div id="editform" class="form"  >
			<input class="mini-hidden" name="id" />
			<table style="width:100%;">
				<tr>
					<td>服务：</td>
					<td>
					 <input id="serviceCode" class="mini-combobox" name="serviceCode" style="width:150px;" textField="serviceName" valueField="serviceCode" 
				        url="${ctx}/service/dataSCodeList.action"
				        showNullItem="false"   emptyText="请选择服务" />   
					</td>
				</tr>
				<tr>
					<td>车型：</td>
					<td>
						<div id="modelId" name="modelId"  class="mini-combobox" style="width:160px;"  popupWidth="160" textField="name" valueField="id" 
					    url="<%=ctx%>/model/getModelInfos.action" value="-1" multiSelect="true"  showClose="true" oncloseclick="onCloseClick" emptyText="全部" >     
					    <div property="columns">
					        <div header="车型" field="name"></div>
					    </div>
					</div>
					</td>
				</tr>
				<tr>
					<td>里程数：</td>
					<td><input name="mileage" 
						 allowLimitValue="false" style="width: 160px;" required="true" vtype="range:0,600000" class="mini-textbox" emptyText="里程范围为0~600000km" /></td>
				</tr>
				<tr>
					<td>工时费：</td>
					<td>
					
					<div id="laborcostJson" name="laborcostJson" class="mini-combobox" style="width:160px;"  popupWidth="160" textField="itemName" valueField="id" 
					    url="<%=ctx%>/laborcost/getAlldatalist.action" value="1" multiSelect="true"  showClose="true" oncloseclick="onLaborcostCloseClick" emptyText="请填写工时费集合" >     
					    <div property="columns">
					      <!--   <div header="ID" field="id">-1</div> -->
					        <div header="工时费" field="itemName"></div>
					    </div>
					</div>
					</td>
				</tr>
				<tr>
					<td>总价：</td>
					<td><input name="price" 
						 allowLimitValue="false" style="width: 160px;"  required="true" class="mini-textbox" vtype="range:0,99999999" emptyText="总价范围为0~99999999元" /></td>
				</tr>
				
				<tr>
					<td style="text-align:center;padding-top:5px;padding-right:20px;"
						colspan="3"><a class="mini-button"
						onclick="updateRow()">保存</a> <a class="mini-button"
						onclick="cancelRow()">取消</a></td>
				</tr>
			</table>
		</div>
		
	</div>
</body>
<script type="text/javascript" src="<%=ctx%>/page/msds/km/serviceModel/serviceModel_edit.js"></script>
</html>