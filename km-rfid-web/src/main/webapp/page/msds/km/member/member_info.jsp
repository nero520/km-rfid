<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<head>
<%@include file="/page/msds/common/commonjs.jsp"%>
</head>
<body style="background-color: #FCFCFC">
	<div  style="width:100%;height:80px;" class="mini-fit">
	<div id="editform" class="form" >
		<input name="id" class="mini-hidden" value="${member.id }"/>
        <input name="memberModelId" class="mini-hidden" value="${member.memberModelId }"/>
		<h3>基础信息</h3>
        <div class="divClass">
            <table class="form-table" border="0" cellpadding="1" cellspacing="2">
                <tr>
                    <td class="form-label" style="width:120px;text-align:right;" >手机号码：</td>
                    <td colspan="3" >
                        ${member.phone }
                    </td>  
                </tr>
                <tr>
                	<td class="form-label" style="width:120px;text-align:right;">姓名(称呼)：</td>
                    <td colspan="3" >
                    ${member.name }${empty member.sex ? '先生' : '女士'}
                    </td>  
                </tr>
                
                <tr>
                	<td class="form-label" style="width:120px;text-align:right;">用户地址：</td>
                    <td colspan="3" >
                      ${member.fullAddress}
                    </td>  
                </tr>
                
            </table>
        </div>
    
        <h3 class="dotBorderTop">车辆信息</h3>
        <div class="divClass">
            <table class="form-table" border="0" cellpadding="0" cellspacing="2">
               
                <tr>
                    <td class="form-label" style="text-align:right;">车型：</td>
                    <td >
                      ${member.modelGroupName }
                    </td>
                      <td class="form-label" style="text-align:right;" >保险到期时间：</td>
                    <td >
                      <fmt:formatDate value="${member.safeDate }" pattern="yyyy-MM-dd"/>
                    </td>
                </tr>
                <tr>
                    <td class="form-label" style="text-align:right;">购车日期:</td>
                    <td >
                      <fmt:formatDate value="${member.buyDate}" pattern="yyyy-MM-dd"/>
                    </td>
                    <td class="form-label" style="text-align:right;padding-left: 260px;">当前公里数(km)：</td>
                    <td >
                     <fmt:parseNumber pattern="##" >${member.mileage }</fmt:parseNumber>
                    </td>
                </tr>
                
                <tr>
                    <td class="form-label" style="text-align:right;">车牌号码：</td>
                    <td >
                      ${member.license }
                    </td>
                     <td class="form-label" style="text-align:right;padding-left: 260px;">底盘号：</td>
                    <td >
                      ${member.chassis}
                    </td>
                </tr>
                
                <tr>
                    <td class="form-label" style="text-align:right;">VIN码：</td>
                    <td >
                      ${member.vin }
                    </td>
                     <td class="form-label" style="text-align:right;padding-left: 260px;">发动机型号：</td>
                    <td >
                      ${member.engineType }
                    </td>
                </tr>
                
                 <tr>
                    <td class="form-label" style="text-align:right;">发动机号：</td>
                    <td >
                      ${member.engineNo }
                    </td>
                     <td class="form-label" style="text-align:right;padding-left: 260px;">变速箱型号：</td>
                    <td >
                      ${member.gearBoxType }
                    </td>
                </tr>
                
                 <tr>
                    <td class="form-label" style="text-align:right;">变速箱号：</td>
                    <td >
                      ${member.gearBoxNo }
                    </td>
                     <td class="form-label" style="text-align:right;padding-left: 260px;">年检到期时间：</td>
                    <td >
                      <fmt:formatDate value="${member.checkDate }" pattern="yyyy-MM-dd"/>
                    </td>
                </tr>
                
                
                
                
            </table>
        </div>
    
    	<h3 class="dotBorderTop" >历史保养记录</h3>
			<div id="datagrid_member" class="mini-datagrid"
				width="100%" height="40%" borderStyle="border:0;"
				url="${ctx}/bespeak/getHistoryInfoList.action?memberId=${member.id}" idField="id"
				allowAlternating="true" sortField="id" sortOrder="desc"
				onrowdblclick="rowdblclick" multiSelect="true" >
				<div property="columns">
						<div field="serivceFinishDate" dateFormat="yyyy-MM-dd"  headerAlign="center" allowSort="true">日期</div>
						<div field="mileage" headerAlign="center" allowSort="true">公里数(km)</div>
						<!-- <div field="state" headerAlign="center" allowSort="true">类型</div> -->
						<div field="content" allowSort="true">内容</div>
				</div>
			</div>
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
<script type="text/javascript">
	mini.parse();
	var grid_item = mini.get("datagrid_member");
	var params = {"id":"${member.id}"};
	grid_item.load(params);
	
	
	
</script>
</html>