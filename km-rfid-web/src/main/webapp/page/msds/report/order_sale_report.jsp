<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
	<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
	
<head>
<jsp:include page="/page/msds/common/commonjs.jsp"></jsp:include>

<style type="text/css">  
        .autoScroll  
        {  
            width:100%;  
            height:100%;  
            overflow:auto;             
        }  
        #rblClasses  
        {  
            margin-left: 20px;  
        }  
</style>  

</head>

<script type="text/javascript">	

	$(document).ready(function(){  
		 $.ajax({  
	        type : 'GET',  
	        contentType : 'application/json',  
	        url : '${ctx}/highcharts/getOrderAMT.action',  
	        dataType : 'json',  
	        //同步  
	        async : false,  
	        success : function(data) {
	        	showChartByOrderAMT(data);
	        },  
	        error : function() {  
	            alert("出现错误！");  
	        }
	    }); 
	});


	function showChartByOrderAMT(data,type) {
		var bxData = new Array();
		var byData = new Array();
		if(type=="")
		{
			type='line';
		}
		for(var i = 0; i < data.orderAMT.length; i++){
			bxData[i] = data.orderAMT[i].reportDate;
			
			byData[i] = data.orderAMT[i].payOrderAmt;
		}
		
		$('#container').highcharts({
	        chart: {
	            type: type
	        },
	        title: {
	            text: '有效收订金额环比统计'
	        },
	       
	        xAxis: {
	            categories: bxData
	        },
	        yAxis: {
	            min: 0,
	            title: {
	                text: '金额'
	            },
	        	labels: {
	            	formatter: function() {
	                	return this.value ;
	            	}
	        	}
	        },
	        plotOptions: {
	        	line: {
	                dataLabels: {
	                    enabled: true
	                },
	                enableMouseTracking: false
	            }
	        },
	        series: [    
		        {
		            name: '有效收订金额',
		            data: byData
		        }
	        ]
	    });
	}

	
	
	$(document).ready(function(){  
		 $.ajax({  
	        type : 'GET',  
	        contentType : 'application/json',  
	        url : '${ctx}/highcharts/getOrderAMT.action',  
	        dataType : 'json',  
	        //同步  
	        async : false,  
	        success : function(data) {
	        	showChartByOrderAMT1(data);
	        },  
	        error : function() {  
	            alert("出现错误！");  
	        }
	    }); 
	});


	function showChartByOrderAMT1(data,type) {
		var bxData = new Array();
		var byData = new Array();
		if(type=="")
		{
			type='line';
		}
		for(var i = 0; i < data.orderAMT.length; i++){
			bxData[i] = data.orderAMT[i].reportDate;
			
			byData[i] = data.orderAMT[i].payOrderAmt;
		}
		
		$('#container1').highcharts({
	        chart: {
	            type: type
	        },
	        title: {
	            text: '有效收订金额环比统计'
	        },
	       
	        xAxis: {
	            categories: bxData
	        },
	        yAxis: {
	            min: 0,
	            title: {
	                text: '金额'
	            },
	        	labels: {
	            	formatter: function() {
	                	return this.value ;
	            	}
	        	}
	        },
	        plotOptions: {
	        	line: {
	                dataLabels: {
	                    enabled: true
	                },
	                enableMouseTracking: false
	            }
	        },
	        series: [    
		        {
		            name: '有效收订金额',
		            data: byData
		        }
	        ]
	    });
	}
</script>


<body>
   <div class="autoScroll">
   <input type="button" value="导出Excel" onclick="exportExcel()" style="margin-left:50px;"/>

   <div id="container" style="min-width: 50px; height: 200px;"></div>

    <div id="order_sale_list_grid" class="mini-datagrid" style="width:100%;height:50%;" 
	    url="${ctx}/orderSale/getOrderSaleList.action" 
        autoScroll="true"
	>
  <div property="columns">  
                	<div type="indexcolumn"></div>     
                	<div field="reportDate" width="120" headerAlign="center" allowSort="true">日期</div> 
                    <div field="newRegisterUserNum" width="120" headerAlign="center" allowSort="true">新注册用户数</div> 
                    <div field="registerUserNum" width="120" headerAlign="center" allowSort="true">累计用户数</div>
                    <div field="newOrderUserNum" width="120" headerAlign="center" allowSort="true">新用户订单量</div>
                    <div field="newOrderUserAmt" width="120" headerAlign="center" allowSort="true">新用户订单金额</div>
                    <div field="newOrderUserAvg" width="120" headerAlign="center" allowSort="true">新用户订单单均（元）</div>
                    <div field="newOrderUserRatio" width="120" headerAlign="center" allowSort="true">新用订单量占比</div>
                    <div field="oldOrderUserNum" width="120" headerAlign="center" allowSort="true">老用户订单量</div>
                    <div field="oldOrderUserAmt" width="120" headerAlign="center" allowSort="true">老用户订单金额</div>
                    <div field="oldOrderUserAvg" width="120" headerAlign="center" allowSort="true">老用户订单单均（元）</div>
                    <div field="oldOrderUserRatio" width="120" headerAlign="center" allowSort="true">老用户订单占比</div>
                    <div field="payOrderNum" width="120" headerAlign="center" allowSort="true">有效订单数</div>
                    <div field="payOrderAmt" width="120" headerAlign="center" allowSort="true">有效订单金额(元)</div>
                    <div field="payorderAvg" width="120" headerAlign="center" allowSort="true">有效单均(元)</div>
                    <div field="payProductNum" width="120" headerAlign="center" allowSort="true">有效件数</div>
                    <div field="payProductAvg" width="120" headerAlign="center" allowSort="true">有效件均(元)</div>
                    <div field="couponOrderNum" width="120" headerAlign="center" allowSort="true">优惠券使用订单数</div>
                    <div field="couponOrderAmt" width="120" headerAlign="center" allowSort="true">优惠券使用金额（元）</div>
                    <div field="addressNum" width="120" headerAlign="center" allowSort="true">独立收货地址数</div>
                    <div field="addressRate" width="120" headerAlign="center" allowSort="true">独立收货地址率</div>
                </div>
</div>
</div>

    <script type="text/javascript">
        mini.parse();

        var grid = mini.get("order_sale_list_grid");

        grid.load();
        
 
        function search() {
            var key = mini.get("key").getValue();
            grid.load({userName: key});
        }
        
        function exportExcel() {
        	window.open('${ctx}/orderSale/exportOrderSaleList.action','导出');
        }
    </script>

</body>
</html>