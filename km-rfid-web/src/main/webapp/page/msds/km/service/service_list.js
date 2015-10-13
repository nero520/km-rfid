mini.parse();
var grid = mini.get("datagrid_service");
grid.load();
function showEdit(action,id){
	mini.open({
		url : ctx+"/page/msds/km/service/service_edit.jsp",
		title : "编辑服务信息",
		width : 350,
		height : 200,
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
	mini.open({
		url : ctx+"/page/msds/km/service/service_new.jsp",
		title : "添加服务信息",
		width : 350,
		height : 200,
		onload : function() {
			var iframe = this.getIFrameEl();
			var data = {action :"new", id : id};
			iframe.contentWindow.SetData(data);
		},
		ondestroy : function(action) {
			ondestroy(action);
		}
	});
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
					url : ctx+"/service/delete.action?id=" + id,
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
	var serviceCode = mini.get("serviceCode").getValue();
	var serviceName = mini.get("serviceName").getValue();
	grid.load({
		serviceCode:serviceCode,serviceName:serviceName});
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