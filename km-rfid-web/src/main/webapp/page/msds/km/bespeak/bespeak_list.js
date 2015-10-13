mini.parse();
var grid = mini.get("datagrid_bespeak");
grid.load();
function showEdit(action,id){
	mini.open({
		url : ctx+"/page/msds/km/bespeak/bespeak_edit.jsp",
		title : "预约单",
		width : 600,
		height : 350,
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
function rowdblclick(e) {
	showEdit("edit",e.row.id);
}
function remove() {
	var rows = grid.getSelecteds();
	if (rows.length > 0) {
		mini.confirm("确定删除选中记录？", "提示", function callback(msg) {
			if (msg == 'ok') {
				var ids = [];
				for ( var i = 0, l = rows.length; i < l; i++) {
					var r = rows[i];
					ids.push(r.id);
				}
				var id = ids.join(',');
				grid.loading("操作中，请稍后......");
				$.ajax({
					url : ctx+"/bespeak/delete.action?id=" + id,
					success : function(text) {
						showMsg("操作成功", 'success');
						grid.reload();
					},
					error : function(text) {
						showMsg("操作失败：" + text.responseText, 'danger');
						grid.unmask();
					}
				});
			}
		});
	} else {
		showMsg("请选中一条记录", 'danger');
	}
}
function search() {
	var bespeakSn = mini.get("bespeakSn").getValue();
	var phone = mini.get("phone").getValue();
	var afterDate = mini.get("afterDate").getValue();
	var beforeDate = mini.get("beforeDate").getValue();
	afterDate = mini.formatDate(afterDate, "yyyy-MM-dd");
	beforeDate = mini.formatDate(beforeDate, "yyyy-MM-dd");
	grid.load({
		bespeakSn:bespeakSn,phone:phone,afterDate:afterDate,beforeDate:beforeDate
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
 * 跳转预约单明细
 */
function details(id){
	var params = "";
	params += "id="+id;
	parent.addTabUrl(ctx+"/bespeak/getDetail.action?"+params,"预约单详情");
}

grid.on("drawcell", function (e) {
	var record = e.record,
		column = e.column,
		field  = e.field,
		value  = e.value;
	 
	//设置列属性
	column.headerAlign="center";
	column.align="center";
	
	//settleSn列，超链接操作按钮
	if (field == "bespeakSn") {
		e.cellHtml = "<a href=javascript:details('"+record.id+"')>"+record.bespeakSn+"</a>";
	};
});