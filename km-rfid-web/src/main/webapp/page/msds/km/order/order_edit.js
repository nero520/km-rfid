var form = new mini.Form("#editform");

var partsSn;
function SetData(data) {
	if (data.action == "edit") {
		data = mini.clone(data);
		partsSn=data.partsSn;
		if(partsSn!=undefined && partsSn!="undefined"){
			/*document.getElementById("hiddenComfOrder").style.display="";*/
			/*document.getElementById("hiddenPanStr").style.display="";*/
		}
		$.ajax({
			url : ctx+"/order/getId.action?id=" + data.id,
			cache : false,
			success : function(text) {
				form.setData(text);
				form.setChanged(false);
			}
		});
	}
}
function cancelRow() {
	CloseWindow("close");
}
//修改服务时间和工厂名
function updateRow() {

	form.validate();
	if (form.isValid() == false)
		return;
	var o = form.getData();
	var companyId = mini.get("companyId").getValue();
		o.companyId=companyId;
	ajx(o,"/order/updateOrder.action");
}

//修改配件单编号
function updatePartsSn() {
	form.validate();
	if (form.isValid() == false)
		return;
	var o = form.getData();
	ajx(o,"/order/updateOrder.action");
}

function CloseWindow(action) {
	if (action == "close" && form.isChanged()) {
		if (confirm("数据被修改了，是否先保存？")) {
			return false;
		}
	}
	if (window.CloseOwnerWindow) {
		return window.CloseOwnerWindow(action);
	} else {
		window.close();
	}
}



var remarkList = [
		            { id: 0, name: "车主不想预约了" },
		            { id: 1, name: "车主信息填写错误，重新下订单" },
		            { id: 2, name: "车主预约时间不合适" },
		            { id: 3, name: "车主预约地址不合适" },
		            { id: 4, name: "已经完成" },
		            ];
/**
 * 没有付款前取消订单
 */
function cancel() {
	var remark=10;
	
	var zt = document.getElementsByName("remark");
	for(var i=0;i<zt.length;i++){
		if(zt[i].checked){
			remark=zt[i].value;
		} 
		
	}
	for ( var i = 0; i < remarkList.length; i++) {
		var edu = remarkList[i];
		if(edu.id==remark){
			if(edu.id==4){
				remark=mini.get("#otherInfo").getValue();
				remark=$.trim(remark);
				if(remark==''){
					showMsg("不能输入空格", 'success');
					return false;
				}
				
			}else{
				remark=edu.name;
			}
		}
	}
	var cancelId = mini.get("#cancelId").getValue();
	if(remark==10){
		return false;
	}
	var o = {"id":cancelId,"remarkLog":remark,"orderState":11};
	ajx(o,"/order/cancelOrderOfNoPay.action");
}

//修改订单状态
function updateOrderState() {
	var orderState = mini.get("#orderState").getValue();
	var cancelId = mini.get("#cancelId").getValue();
	if(cancelId=='' && orderState==''){
		return false;
	}
	var o={"id":+cancelId,"orderState":+orderState};
	ajx(o,"/order/updateOrder.action");
}
/**
 * 确认订单
 */
function confirmOrder(){
	
		var comfOrder = mini.get("#comfOrder").getValue();
		var orderSn = mini.get("#orderSn").getValue();
		if(orderSn==''){
			return false;
		}
		var o={"orderSn":orderSn,"flag":comfOrder,"orderState":3};
		$.ajax({
			url : ctx+"/order/confirmOrder.action",
			type : "post",
			data : o,
			success : function(text) {
				if(text.type==true){
					showMsg("操作成功", 'success');
					setTimeout("CloseWindow('success')",500);
				}else{
					showMsg(text.content, 'danger');
					setTimeout("CloseWindow('success')",500);
				}
			},
			error : function(text, textStatus, errorThrown) {
				showMsg("操作失败", 'danger');
			}
		});
		
}


function cancelService(){
	var cancelId = mini.get("#cancelId").getValue();
	var otherCancelInfo = mini.get("#otherCancelInfo").getValue();
		otherCancelInfo=$.trim(otherCancelInfo);
	if(otherCancelInfo==''){
		showMsg("不能输入空格", 'success');;
		return false;
	}
	var o={"id":cancelId,"remark":otherCancelInfo};
	$.ajax({
		url : ctx+"/order/cancelOrderService.action",
		type : "post",
		data : o,
		success : function(text) {
//			CloseWindow("success");
			showMsg("服务取消成功,系统已生成退款单，请及时处理！", 'success');
			setTimeout("CloseWindow('success')",2000);
		},
		error : function(text, textStatus, errorThrown) {
			showMsg("操作失败", 'danger');
			setTimeout("CloseWindow('success')",500);
		}
	});
 }

function payLaterCancelOrder() {
	var otherCancelInfo = mini.get("#otherCancelInfo").getValue();
	var cancelId = mini.get("#cancelId").getValue();
	otherCancelInfo=$.trim(otherCancelInfo);
	
	if(otherCancelInfo==''){
		showMsg("不能输入空格", 'success');;
		return false;
	}
	$.ajax({
		url : ctx+"/order/cancelOrder.action?id=" + cancelId+"&remark="+otherCancelInfo+"&orderState=12",
		success : function(text) {
			showMsg("订单取消成功系统已生成退款单，请及时处理！", 'success');
			setTimeout("CloseWindow('success')",2000);
			
		},
		error : function(text, textStatus, errorThrown) {
			showMsg("操作失败", 'danger');
			setTimeout("CloseWindow('success')",500);
		}
	});
}
function ajx(o,method){
	var json = mini.encode(o);
	$.ajax({
		url : ctx+method,
		type : "post",
		dataType : "json",
		contentType : "application/json",
		data : json,
		success : function(text) {
			CloseWindow("success");
			window.top.refreshG2 && window.top.refreshG2();
		},
		error : function(text, textStatus, errorThrown) {
			CloseWindow(text.responseText);
		}
	});
}
$("#elseRemark").click(
	 function(){
	    	document.getElementById("otherCancelInfo").style.display="";
      }
);
$(".remarkClass").click(
	function(){
		document.getElementById("otherCancelInfo").style.display="none";
});



