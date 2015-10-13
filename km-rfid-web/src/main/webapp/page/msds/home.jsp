<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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

<script type="text/javascript">	
	var dataObj;
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
	        	dataObj=data;
	        },  
	        error : function() {  
	            alert("出现错误！");  
	        }
	    }); 
	});

	function changeChart(type){
		showChartByOrderAMT(dataObj,type);
	}

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
	            categories: bxData,
	        },
	        yAxis: {
	            min: 0,
	            title: {
	                text: '金额（元）'
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
</head>
<body>
	<div class="autoScroll">
		<button class="change" onclick="changeChart('line')">折线图</button>
		<button class="change" onclick="changeChart('column')">柱状图</button>
		
		<div id="container" style="min-width: 310px; height: 400px;"></div>
	</div>
</body>
</html>
