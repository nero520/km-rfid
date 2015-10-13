<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<head>
<%@include file="/page/msds/common/commonjs.jsp"%>
</head>
<body >
	<div  style="width:100%;height:80px;" class="mini-fit">
	<div id="editform" class="form" >
		<input name="id" class="mini-hidden" value="${member.id }"/>
        <input name="memberModelId" class="mini-hidden" value="${member.memberModelId }"/>
        <input name="license_check" class="mini-hidden" value="${member.license }"/>
        
		<h3>基础信息</h3>
        <div class="fieldset-body">
            <table class="form-table" border="0" cellpadding="1" cellspacing="2">
                <tr>
                    <td class="form-label" style="width:120px;text-align:right;font-size:12px; " ><font style="color:Red;">*</font>手机号码：</td>
                    <td  >
                    
                    	<c:choose>  
	                        <c:when test="${member.isEdit == true }">  
	                          <input name="phone" class="mini-textbox" value="${member.phone }" vtype="rangeLength:11,11" required="true" enabled="false" emptyText="11位手机号(必填项)"/>
	                        </c:when>  
	                        <c:when test="${member.isEdit == false }">  
	                          <input name="phone" class="mini-textbox" value="${member.phone }" vtype="rangeLength:11,11" required="true"  emptyText="11位手机号(必填项)"/>
	                        </c:when>  
	                    </c:choose> 
                        
                    </td>  
                    <td style="text-align:left;padding-top:5px;padding-right:20px;"
						><a class="mini-button"
						onclick="searchByPhone()">查询</a> </td> 
						
						
                    
                </tr>
                <tr>
                	<td class="form-label" style="width:120px;text-align:right;font-size:12px; ">姓名(称呼)：</td>
                    <td  >
                        <input name="name" class="mini-textbox"  value="${member.name }" vtype="maxLength:32" />
                    </td>  
                    <td  >
                        <input name="sex" class="mini-radiobuttonlist" repeatItems="1" repeatLayout="table" value="${empty member.sex ? 1 : member.sex}"
                        repeatDirection="vertical" data="[{id: 1, text: '男'}, {id: 2, text: '女'}]"/>
                    </td>  
                </tr>
                 <tr>
                	<td class="form-label" style="width:120px;text-align:right;font-size:12px; "><font style="color:Red;">*</font>车牌号码：</td>
                    <td colspan="2" >
                        <input name="license" class="mini-textbox"  value="${member.license }" vtype="rangeLength:7,7" required="true" />
                    </td>  
                    
                </tr>
                
                <tr>
                	<td class="td1" style="width:120px;text-align:right;font-size:12px; ">用户地址：</td>
                    <td >
                        <input id="province" class="mini-combobox" style="width:150px;" textField="name" valueField="id" 
				        onvaluechanged="provinceChange" url="${ctx}/bespeak/getArea.action?level=1"
				        showNullItem="true" value="${member.province }"
				         />   
				         
                    </td>  
                    <td >
                        <input id="city" class="mini-combobox" style="width:150px;" textField="name" valueField="id" 
				        onvaluechanged="cityChange" url="${ctx}/bespeak/getArea.action?level=2&parent=${empty member.province ? -1 : member.province}" 
				        showNullItem="true" value="${member.city }"
				         />   
				         <input id="area" class="mini-combobox" style="width:150px;" textField="name" valueField="id" 
				       url="${ctx}/bespeak/getArea.action?level=3&parent=${empty member.city ? -1 : member.city}" 
				        showNullItem="true" value="${member.area }"
				         />   
                    </td>  
                </tr>
                
                <tr>
                	<td class="form-label" style="width:120px;"></td>
                    <td colspan="2">
                        <input name="address" class="mini-textbox"  emptyText="详细地址" style="width:460px;"  vtype="maxLength:64" value="${member.address }"/>
                    </td>  
                    
                </tr>
            </table>
        </div>
    
        <h3 class="dotBorderTop">车辆信息</h3>
        <div class="fieldset-body">
            <table class="form-table" border="0" cellpadding="0" cellspacing="2">
               
                <tr>
                    <td class="form-label" style="width:120px;text-align:right;font-size:12px; "><font style="color:Red;">*</font>车型：</td>
                    <td >
                       <input id="brand" class="mini-combobox" style="width:150px;" textField="name" valueField="id"  pinyinField="firstLetter"
				        onvaluechanged="onBrand" url="${ctx}/bespeak/getModelList.action?level=1" allowInput="true"  emptyText="输入首字母快速检索"
				        showNullItem="true" value="${member.shopId }" vtype="maxLength:32" required="true"
				         />   
				         
				         <input id="series" class="mini-combobox" style="width:150px;" textField="name" valueField="id" emptyText="车系"
				        onvaluechanged="onSeries" url="${ctx}/bespeak/getModelList.action?level=2&pid=${empty member.shopId ? -1 : member.shopId}"
				        showNullItem="true" value="${member.seriesId }" vtype="maxLength:32" required="true"
				         />   
				         <input id="year" class="mini-combobox" style="width:250px;" textField="name" valueField="id" emptyText="年款"
				         url="${ctx}/bespeak/getModelList.action?level=3&pid=${empty member.seriesId ? -1 : member.seriesId}"
				        showNullItem="true" value="${member.modelId}" vtype="maxLength:32" required="true"
				         />   
                    </td>
                  
                </tr>
                
                <tr>
                    <td class="form-label" style="text-align:right;font-size:12px; " >购车日期：</td>
                    <td class="form-label" style="width:150px;">
                      <input id="buyDate"  name="buyDate" class="mini-datepicker" format="yyyy-MM-dd"  maxDate="${now }" value= "${member.buyDate }"/>
                    </td>
                </tr>
                
                <tr>
                    <td class="form-label" style="text-align:right;font-size:12px; ">当前里程数：</td>
                    <td >
                      <input name="mileage" class="mini-textbox "  emptyText="单位(KM)" style="width:150px;" value= "${member.mileage }"  vtype="range:0,999999" />
                    </td>
                </tr>
                
                <tr>
                    <td class="form-label" style="text-align:right;font-size:12px; ">上次保养时间：</td>
                    <td >
                      <input id="lastServiceDate"  name="lastServiceDate" class="mini-datepicker" format="yyyy-MM-dd" maxDate="${now }" value= "${member.lastServiceDate }"/>
                    </td>
                </tr>
                <tr>
                    <td class="form-label" style="text-align:right;font-size:12px; ">VIN码：</td>
                    <td >
                      <input name="vin" class="mini-textbox"  emptyText="17位" style="width:150px;"value= "${member.vin }" vtype="rangeLength:17,17"  />
                    </td>
                </tr>
            </table>
        </div>
    
    	<h3 class="dotBorderTop">预约单</h3>
			<div id="datagrid_member" class="mini-datagrid"
				style="width:100%;height:110px;" borderStyle="border:0;"
				url="${ctx}/bespeak/getBespeakList.action?memberId=${member.id}" idField="id"
				allowAlternating="true" sortField="id" sortOrder="desc"
				onrowdblclick="rowdblclick" multiSelect="true" showPager="false">
				<div property="columns">
						
						<div field="bespeakSn" headerAlign="center" allowSort="true">预约单号</div>
						<div field="bespeakDate" dateFormat="yyyy-MM-dd H:mm:ss"  headerAlign="center" allowSort="true">预约时间</div>
						<div field="state" headerAlign="center" renderer="onGenderRenderer" allowSort="true">状态</div>
						<div field="totalPrice" allowSort="true">总价</div>
						<div field="phone" headerAlign="center" allowSort="true">车主手机</div>
						<div field="modelGroupName" headerAlign="center" allowSort="true">车型</div>
						<div field="mileage" headerAlign="center" allowSort="true">行驶里程</div>
						<div field="action"  headerAlign="center">操作</div>
						
				</div>
			</div>
						
                       
	                        	 <div style="text-align:center;">
									<a class="mini-button"
									onclick="saveOrUpdate()" style="display: inline-block;maring:0 20px;">保存车主信息</a>
									<a class="mini-button"
									onclick="addBespeak()" style="display: inline-block;maring:0 20px;">创建预约订单</a>
						         </div>
	                      
		
	</div>
</div>

<style>
.dotBorderTop{
border-top:1px dotted #000;
}
</style>


</body>
<script type="text/javascript"
	src="<%=ctx%>/page/msds/km/member/member_edit.js"></script>
</html>