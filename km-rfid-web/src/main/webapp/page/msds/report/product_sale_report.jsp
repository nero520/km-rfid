<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
	<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
	
<head>
<jsp:include page="/page/msds/common/commonjs.jsp"></jsp:include>
</head>
<body>
	<div style="padding:2px;border-top:0;border-left:0;border-right:0;">
 		时间：
 		<input id="startDate" class="mini-datepicker" vtype="date:yyyy-MM-dd" />
 		&nbsp;
 		至
 		&nbsp;
 		<input id="endDate" class="mini-datepicker" vtype="date:yyyy-MM-dd" />&nbsp;&nbsp;
 		商家：
 		<input id="supplierId" class="mini-combobox" style="width:150px;" textField="text" valueField="id" emptyText="请选择..."
    	url="${ctx}/productSale/getSupplier.action" />&nbsp;&nbsp;
    	品牌：
    	<input id="brandId" class="mini-combobox" style="width:180px;" valueField="id" emptyText="请选择..."
	    url="${ctx}/productSale/getBrand.action"  allowInput="true" textField="text"  pinyinField="text" />
	   	<a class="mini-button" onclick="search()">查询</a>
	    <br>
	        显示维度:
	   	<select id="showOption" class="mini-combobox"  style="width: 100px" onvaluechanged="search">
	   		<option value="1">商品</option>
	   		<option value="2">汇总</option>
	   	</select>
	   	<div id="collectHide">
	   	分类：
	   	<input class="mini-checkbox" type="checkbox" name="category" value="productFirstLevel" />一级分类
	   	<input class="mini-checkbox" type="checkbox" name="category" value="productSecondLevel" />二级分类
	   	<input class="mini-checkbox" type="checkbox" name="category" value="productThirdLevel" />三级分类
	   	<input class="mini-checkbox" type="checkbox" name="category" value="productFourLevel" />四级分类
	   	<br>
	   	其它：
	   	<input class="mini-checkbox" type="checkbox" name="other" value="productBrandId" />品牌
	   	<input class="mini-checkbox" type="checkbox" name="other" value="productSupplierId" />商家
	   	<input class="mini-checkbox" type="checkbox" name="other" value="orderSource" />下单渠道
	   	<input class="mini-checkbox" type="checkbox" name="other" value="productAreaId" />收获省市
	   	</div>
    </div>
	
    <div id="product_sale_list_grid" class="mini-datagrid" style="width:100%;height:95%;" 
	    url="${ctx}/productSale/getProductSaleList.action" 
        autoScroll="true">
    		<div property="columns">  
               	<div type="indexcolumn">序号</div>     
               	<div field="reportDate" width="80" headerAlign="center" allowSort="true">日期</div> 
                <div field="productSn" width="100" headerAlign="center" allowSort="true">商品编码</div> 
                <div field="productFullName" width="120" headerAlign="center" allowSort="true">商品全称</div>
                <div field="productPrice" width="80" headerAlign="center" allowSort="true">售价</div>
                <div field="productBrandName" width="120" headerAlign="center" allowSort="true">品牌</div>
                <div field="productSupplierName" width="100" headerAlign="center" allowSort="true">商家</div>
                <div field="orderSourceName" width="60" headerAlign="center" allowSort="true">下单渠道</div>
                <div field="productAreaName" width="120" headerAlign="center" allowSort="true">省市</div>
                <div field="productFirstLevelName" width="100" headerAlign="center" allowSort="true">一级分类</div>
                <div field="productSecondLevelName" width="100" headerAlign="center" allowSort="true">二级分类</div>
                <div field="productThirdLevelName" width="100" headerAlign="center" allowSort="true">三级分类</div>
                <div field="productFourLevelName" width="100" headerAlign="center" allowSort="true">四级分类</div>
                <div field="payProductNum" width="60" headerAlign="center" allowSort="true">有效商品件数</div>
                <div field="payProductAmt" width="80" headerAlign="center" allowSort="true">有效商品金额(元)</div>
                <div field="payProductAvg" width="80" headerAlign="center" allowSort="true">件均(元)</div>
                <div field="payOrderNum" width="60" headerAlign="center" allowSort="true">有效订单数</div>
                <div field="payOrderAmt" width="80" headerAlign="center" allowSort="true">有效订单金额(元)</div>
                <div field="payOrderAvg" width="80" headerAlign="center" allowSort="true">单均(元)</div>
                <div field="couponProductAmt" width="80" headerAlign="center" allowSort="true">优惠券使用金额</div>
            </div>
	 </div>

	 <iframe id="exportIFrame" style="display:none;"></iframe>
    
    <!--导出Excel相关HTML-->
     <form id="excelForm"  action="${ctx}/orderSale/exportProductSaleList.action" method="post" target="excelIFrame">
        <input type="hidden" name="columns" id="excelData" />
    </form>
    <iframe id="excelIFrame" name="excelIFrame" style="display:none;"></iframe>

    <script type="text/javascript">
        mini.parse();

        var grid = mini.get("product_sale_list_grid");

        grid.load();
        
        function search() {
        	var startDate=mini.get("startDate").getValue();
        	var endDate=mini.get("endDate").getValue();
        	var productSupplierId=mini.get("supplierId").getValue();
        	var productBrandId=mini.get("brandId").getValue();
        	var showOption=mini.get("showOption").getValue();
			
        	if(showOption=="1")
        	{
        		$("#collectHide").show();
        		grid.load({
                	startDate:startDate,
                	endDate:endDate,
                	productSupplierId: productSupplierId,
                	productBrandId: productBrandId,
                	showOption: showOption });
        	}
        	else
        	{
        		$("#collectHide").hide();
        	}
        	
            
        }
        
    </script>

</body>
</html>