<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<head>
<%@include file="/page/msds/common/commonjs.jsp"%>
</head>
<body >
	<div  style="width:100%;height:80px;" class="mini-fit">
	<div id="editform" class="divClass" >
		<h3>基础信息</h3>
        <div class="fieldset-body">
            <table class="form-table" style="width:100%;" border="0" cellpadding="1" cellspacing="2">
                <tr>
                    <td class="form-label" style="width:120px;text-align:right;font-size:12px; " >手机号码：</td>
                    <td  >${member.phone }
                    </td>  
                </tr>
                <tr>
                	<td class="form-label" style="width:120px;text-align:right;font-size:12px; ">姓名(称呼)：</td>
                    <td  >
                       ${member.name }
                       <c:choose>  
	                        <c:when test="${member.sex == 2 }">  
	                          	女士
	                         </c:when>  
	                        <c:when test="${member.sex == 1 }">  
	                          	先生
	                        </c:when>  
	                    </c:choose> 
                    </td>  
                </tr>
                <tr>
                	<td class="form-label" style="width:120px;text-align:right;font-size:12px; ">车牌号码：</td>
                    <td colspan="2" >
                        ${member.license }
                    </td>  
                </tr>
                <tr>
                	<td class="td1" style="width:120px;text-align:right;font-size:12px; ">用户地址：</td>
                    <td >
                         ${member.fullAddress}
                    </td>  
                </tr>
            </table>
        </div>
    
        <h3 class="dotBorderTop">车辆信息</h3>
        <div class="fieldset-body">
            <table class="form-table" border="0" cellpadding="0" cellspacing="2">
               
                <tr>
                    <td class="form-label" style="width:120px;text-align:right;">车型：</td>
                    <td >
                      ${member.modelGroupName }
                    </td>
                </tr>
                <tr>
                    <td class="form-label" style="text-align:right;font-size:12px; " >购车日期：</td>
                    <td class="form-label">
                     <fmt:formatDate value="${member.buyDate }" pattern="yyyy-MM-dd"/>
                    </td>
                </tr>
                <tr>
                    <td class="form-label" style="text-align:right;font-size:12px; ">当前里程数：</td>
                    <td >
						${member.mileage }
                    </td>
                </tr>
                <tr>
                    <td class="form-label" style="text-align:right;font-size:12px; ">上次保养时间：</td>
                    <td >
                     <fmt:formatDate value="${member.lastServiceDate }" pattern="yyyy-MM-dd"/>
                    </td>
                </tr>
                <tr>
                    <td class="form-label" style="text-align:right;font-size:12px; ">VIN码：</td>
                    <td >
                      ${member.vin }
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
						
						<div field="bespeakSn" headerAlign="center" allowSort="true">订单编号</div>
						<div field="bespeakDate" dateFormat="yyyy-MM-dd H:mm:ss"  headerAlign="center" allowSort="true">预约时间</div>
						<div field="state" headerAlign="center" renderer="onGenderRenderer" allowSort="true">状态</div>
						<div field="totalPrice" headerAlign="center" allowSort="true">总价</div>
						<div field="phone" headerAlign="center" allowSort="true">车主手机</div>
						<div field="modelGroupName" headerAlign="center" allowSort="true">车型</div>
				</div>
			</div>
		
	</div>
</div>

<style>
.dotBorderTop{
border-top:1px dotted #000;
}
</style>

	<script type="text/javascript">
        mini.parse();
        var grid = mini.get("datagrid_member");
        grid.load();
        
        var Genders = [{ id: 1, text: '已确认' }, { id: 2, text: '已完成'}];
        function onGenderRenderer(e) {
            for (var i = 0, l = Genders.length; i < l; i++) {
                var g = Genders[i];
                if (g.id == e.value) return g.text;
            }
            return "";
        }
    </script>
</body>
</html>