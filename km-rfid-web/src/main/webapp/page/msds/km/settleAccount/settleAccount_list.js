mini.parse();
var grid = mini.get("datagrid_settleAccount");
grid.load();

function showEdit(action,settleSn){
	mini.open({
		url : ctx+"/page/msds/km/settleAccount/settleAccount_edit.jsp",
		title : "提示信息",
		width : 300,
		height : 150,
		onload : function() {
			var iframe = this.getIFrameEl();
			var data = {action : action, settleSn : settleSn};
			iframe.contentWindow.SetData(data);
		},
		ondestroy : function(action) {
			ondestroy(action);
		}
	});
}

/**
 * 跳转对账单明细
 */
function details(settleSn){
	var params = "";
	var row = grid.findRow(function(row){
	    if(row.settleSn == settleSn) return true;
	});
	params += "settleSn="+settleSn;
	params += "&startDate="+row.startDate+"至"+row.endDate;
	params += "&settleState="+row.settleState;
	params += "&settleAllAmount="+row.settleAllAmount;
	parent.addTabUrl(ctx+"/settleAccount/dataList.action?"+params,"对账单详情");
}


function search() {
	var settleSn = mini.get("settleSn").getValue();
	var settleState = mini.get("settleState").getValue();
	var companyId = mini.get("companyId").getValue();
	var afterDate = mini.get("afterDate").getValue();
	var beforeDate = mini.get("beforeDate").getValue();
	afterDate = mini.formatDate(afterDate, "yyyy-MM-dd");
	beforeDate = mini.formatDate(beforeDate, "yyyy-MM-dd");
	grid.load({
		settleSn:settleSn,companyId:companyId,settleState:settleState,afterDate:afterDate,beforeDate:beforeDate
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
		column = e.column,
		field  = e.field,
		value  = e.value;
	 
	//设置列属性
	column.headerAlign="center";
	column.align="center";
	if(field!="companyName" && field!="companyAddress"){
		column.allowSort="true";
	}
		 
	//settleSn列，超链接操作按钮
	if (field == "settleSn") {
		e.cellHtml = "<a href=javascript:details('"+record.settleSn+"')>"+record.settleSn+"</a>";
	};
	//action列，超连接操作按钮
	if (column.name == "action") {
//		e.cellStyle = "text-align:center";
		if (2 === record.settleState) {
			e.cellHtml = "<a href=javascript:showEdit('edit','"+record.settleSn+"')>完成结算</a>";
		}
	};

	//日期格式化
	if (field=="startDate" || field=="endDate") {
		if (mini.isDate(value)) e.cellHtml = mini.formatDate(value, "yyyy-MM-dd HH:mm:ss");
	}
});

window.top.refreshG2=function(){
	$(".mini-pager-reload").trigger("click");
};


/**
 * 完成结算
 * @param settleSn
 */
function completeBill(settleSn,actualAmount,remark){
//	parent.addTabUrl(ctx+"/bill/dataList.action?"+params,"结算单列表");
	var json;
	mini.confirm("确定要取消吗？", "提示", function callback(msg) {
		if (msg == 'ok') {
			var o={
				"settleSn":+settleSn,
				"actualAmount":+actualAmount,
				"remark":+remark
			};
			json = mini.encode(o);
			$.ajax({
				url : ctx+"/settleAccount/saveBill.action",
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

function saveBill(){
	var row = grid.findRow(function(row){
	    if(row.settleSn == settleSn) return true;
	});
	var o={
		"serivceFinishDate":+row.serivceFinishDate,
		"billingType":+row.billingType,
		"accountName":+row.accountName,
		"accountBankName":+row.accountBankName,
		"accountNumber":+row.accountNumber,
		"settleAllAmount":+row.settleAllAmount,
		"actualAmount":+row.actualAmount
	};
	json = mini.encode(o);
	$.ajax({
		url : ctx+"/bill/save.action",
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
