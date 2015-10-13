var form = new mini.Form("#editform");

function SetData(data) {
	if (data.action == "edit") {
		data = mini.clone(data);
		mini.get("settleSn").setValue(data.settleSn);
	}
}

function updateRow() {
	form.validate();
	if (form.isValid() == false)
		return;
	mini.confirm("确定打款完毕了吗？", "提示", function callback(msg) {
		if (msg == 'ok') {
			var o = form.getData();
			var json = mini.encode(o);
			$.ajax({
				url : ctx+"/settleAccount/saveBill.action",
				type : "post",
				dataType : "json",
				contentType : "application/json",
				data : json,
				success : function(text) {
					CloseWindow("success");
				},
				error : function(text, textStatus, errorThrown) {
					CloseWindow(text.responseText);
				}
			});
		}
	});
}
function cancelRow() {
	CloseWindow("close");
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



