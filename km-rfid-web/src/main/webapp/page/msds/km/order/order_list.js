mini.parse();
var grid = mini.get("datagrid_order");
grid.load();

function showEdit(action,id){
	mini.open({
		url : ctx+"/page/msds/km/order/order_edit.jsp",
		title : "订单主表",
		width : 600,
		height : 675,
		onload : function() {
			var iframe = this.getIFrameEl();
			var data = {action : action, id : id};
			iframe.contentWindow.SetData(data);
		},
		ondestroy : function(action) {
			ondestroy(action);
		}
	});
}
function add() {
	showEdit("new");
}

/**
 * 跳转详情页
 */
function details(recordId)   {          
	parent.addTabUrl(ctx+"/order/findOrderInfo.action?id="+recordId,"订单详情");
}


function rowdblclick(e) {
	showEdit("edit",e.row.id);
}

function search() {
	var orderSn = mini.get("orderSn").getValue();
	var afterDate = mini.get("afterDate").getValue();
	var nowDate = mini.get("nowDate").getValue();
	var phone = mini.get("phone").getValue();
	var license = mini.get("license").getValue();
	var searchState = mini.get("searchState").getValue();
	afterDate = mini.formatDate ( afterDate, "yyyy-MM-dd HH:mm:ss" );
	nowDate = mini.formatDate ( nowDate, "yyyy-MM-dd HH:mm:ss" );
	grid.load({
		orderSn:orderSn,afterDate:afterDate,nowDate:nowDate,phone:phone,license:license,orderState:searchState,
	});
}



function onKeyEnter(e) {
	search();
}
function ondestroy(action) {
	if (action == "success") {
		grid.reload();
		showMsg("操作成功", 'success');
	} else if (action != "close") {
		showMsg("操作失败：" + action, 'danger');
	}
}


grid.on("drawcell", function (e) {
	
	 var record = e.record,
	 	 column = e.column;
	     field  = e.field;
	     value  = e.value;
	 
	 column.align="center";
	     
	 if(field == "orderSn"){
		 e.cellHtml = "<a href=javascript:details('"+record.id+"')>"+record.orderSn+"</a>"
	 }
	     
//	 action列，超连接操作按钮
	 if (column.name == "action") {
	     e.cellStyle = "text-align:center";
	     if (99 === record.orderState) {
	        e.cellHtml = '<a href="javascript:addPartsSn(\'' + record.id +'\')">添加配件单号</a>&nbsp; '+
	        '<a href="javascript:editOrderState(\'' + record.id + '\')">指定订单状态</a>&nbsp; '+
	        '<a href="javascript:edit(\'' + record.id+ '\')">修改</a>&nbsp; <br/>';
	     }
	     if(1 == record.orderState){
	     	e.cellHtml = '<a href="javascript:edit(\'' + record.id + '\')">修改</a>&nbsp; '+
	     	'<a href="javascript:updateOrder(\'' + record.id + '\')">取消</a>&nbsp; ';
	     }
	     if(2 ==  record.orderState){
	     	e.cellHtml = '<a href="javascript:confirmOrder(\'' + record.orderSn + '\')">确认订单</a>&nbsp; '+
	     	'<a href="javascript:edit(\'' + record.id + '\')">修改</a>&nbsp; '+
	     	'<a href="javascript:payLaterCancelOrder(\'' + record.id + '\')">取消</a>&nbsp; ';
	     }
	     if(3 == record.orderState || 5 == record.orderState){
	     	e.cellHtml = '<a href="javascript:servicesOrder(\'' + record.id + '\')">确认服务</a>&nbsp; '+
	     	'<a href="javascript:cancelService(\'' + record.id +'\',\''+record.partsSn+'\')">取消</a>&nbsp; ';
	     }
	 };
	 

     if (field == "serviceTime") {
         if (mini.isDate(value)) e.cellHtml = mini.formatDate(value, "yyyy-MM-dd H:mm:ss");

     }
     
    

});


function cancelUnusualOrder(){
}
function skipUrl(rowid,url,title){
	    if (rowid) {
	        mini.open({
	        	url: ctx+url,
	            title: title, width: 350,height:250,
	            onload: function () {
	                var iframe = this.getIFrameEl();
	                var data = { action: "edit", id: rowid};
	                iframe.contentWindow.SetData(data);
	            },
	            ondestroy: function (action) {
	            	grid.reload();
	                
	            }
	        });
	        
	    } else {
	        alert("请选中一条记录");
	    }
}
function addPartsSn(rowid){
	skipUrl(rowid,"/page/msds/km/order/editPartsSn.jsp","修改配件单号");
}
function edit(rowid) {
	parent.addTabUrl(ctx+"/order/editOrderInfo.action?id="+rowid,"订单修改");
}
function updateOrder(rowid){
	skipUrl(rowid, "/page/msds/km/order/cancelOrder.jsp", "取消订单");
}
function editOrderState(rowid){
	skipUrl(rowid, "/page/msds/km/order/updateOrderState.jsp", "修改订单状态");
}
function payLaterCancelOrder(rowid){
	skipUrl(rowid, "/page/msds/km/order/payLaterCancelOrder.jsp", "取消订单");
}
/*function confirmOrder(rowid){
	skipUrl(rowid, "/page/msds/km/order/confirmOrder.jsp", "确认订单");
}*/
/**
 * 取消服务订单
 * @param rowid
 */
function cancelService(rowid,partsSn){
	if (rowid) {
        mini.open({
        	url: ctx+"/page/msds/km/order/cancelService.jsp",
            title: "取消订单", width: 350,height:250,
            onload: function () {
                var iframe = this.getIFrameEl();
                var data = { action: "edit", id: rowid,partsSn:partsSn};
                iframe.contentWindow.SetData(data);
            },
            ondestroy: function (action) {
            	grid.reload();
                
            }
        });
        
    } else {
        alert("请选中一条记录");
    }
}
function cancelOrder(rowid) {
	var json;
	mini.confirm("确定要取消吗？", "提示", function callback(msg) {
		if (msg == 'ok') {
			var o={"id":+rowid,"orderState":+11};
			json = mini.encode(o);
				$.ajax({
					url : ctx+"/order/updateOrder.action",
					type : "post",
					dataType : "json",
					contentType : "application/json",
					data : json,
					success : function(text) {
						showMsg("操作成功", 'success');
						grid.reload();
					},
					error : function(text, textStatus, errorThrown) {
						showMsg("操作失败", 'danger');
						grid.reload();
					}
				});
		}
	});
}
//确认服务
function servicesOrder(rowid) {
	var o,json;
	mini.confirm("确认车主已经接受服务？", "提示", function callback(msg) {
		if (msg == 'ok') {
			o={"id":+rowid,"orderState":"4"};
			json = mini.encode(o);
		
	$.ajax({
		url : ctx+"/order/affirmService.action",
		type : "post",
		dataType : "json",
		contentType : "application/json",
		data : json,
		success : function(text) {
			showMsg("操作成功", 'success');
			grid.reload();
		},
		error : function(text, textStatus, errorThrown) {
			showMsg("操作失败", 'danger');
			grid.reload();
			}
		});
		}
	});
}


//确认订单
function confirmOrder(orderSn) {
	var o,json;
	mini.confirm("确认订单？", "提示", function callback(msg) {
		if (msg == 'ok') {
			o={"orderSn":orderSn,"flag":"","orderState":3};
			
	$.ajax({
		url : ctx+"/order/confirmOrder.action",
		type : "post",
		data : o,
		success : function(text) {
			showMsg("操作成功", 'success');
			grid.reload();
		},
		error : function(text, textStatus, errorThrown) {
			showMsg("操作失败", 'danger');
			grid.reload();
			}
		});
		}
	});
}

window.top.refreshG2=function(){
	$(".mini-pager-reload").trigger("click");
	
};
