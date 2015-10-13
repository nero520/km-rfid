mini.parse();
var grid = mini.get("datagrid_settleAccountItem");
search();

/**
 * 跳转详情页
 */
function details(settleSn){
	parent.addTabUrl(ctx+"/settleAccount/dataList.action?settleSn="+settleSn,"对账单详情");
}

function search() {
	var settleSn = $("#settleSn").val();
	grid.load({
		settleSn:settleSn
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
/**
 * 跳转详情页
 */
function details(orderSn)   {          
	parent.addTabUrl(ctx+"/order/getOrderInfo.action?orderSn="+orderSn,"订单详情");
}

grid.on("drawcell", function (e) {
	var record = e.record,
		column = e.column,
		field  = e.field,
		value  = e.value;
	 
	//设置列属性
	column.headerAlign="center";
	column.align="center";
	if(field!="companyName" && field!="companyAddress"){
		column.allowSort="true";
	}
		 
	//action列，超连接操作按钮
	if (column.name == "action") {
//		e.cellStyle = "text-align:center";
		if (2 === record.settleState) {
			e.cellHtml = "<a href=javascript:details('"+record.settleSn+"')>完成结算</a>";
		}
	};
	
	if (field == "orderSn") {
 		e.cellHtml = "<a href=javascript:details('"+record.orderSn+"')>"+record.orderSn+"</a>";
 	};

	//日期格式化
	if (field=="orderCreateDate" || field=="serviceTime" || field=="serivceFinishDate") {
		if (mini.isDate(value)) e.cellHtml = mini.formatDate(value, "yyyy-MM-dd H:mm:ss");
	}

});

window.top.refreshG2=function(){
	$(".mini-pager-reload").trigger("click");
	
};
