mini.parse();
var grid = mini.get("datagrid_rfid");
grid.load();
function showEdit(action,id){
	mini.open({
		url : ctx+"/page/msds/km/rfid/rfid_edit.jsp",
		title : "rfid用户关系表",
		width : 600,
		height : 150,
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
					url : ctx+"/rfid/delete.action?id=" + id,
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
	var field = mini.get("searchField").getValue();
	var key = mini.get("key").getValue();
	var o={};
	o[field]=key;
	grid.load(o);
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
//	 action列，超连接操作按钮
	 if (column.name == "action") {
	     e.cellStyle = "text-align:center";
	     if (0 === record.state) {
	        e.cellHtml = '<a href="javascript:mkrfid(\'' + record.id +'\',\''+record.epcNo+'\')">生成卡</a>&nbsp; ';
	     }
	    
	 };
	 
    
   

});

function mkrfid(rowid,epcNo) {
	var o,json;
	mini.confirm("确认进行生成？", "提示", function callback(msg) {
		if (msg == 'ok') {
			o={"id":+rowid,"epcNo":epcNo};
			json = mini.encode(o);
		
	$.ajax({
		url : ctx+"/rfid/mkrfid.action",
		type : "post",
		dataType : "json",
		contentType : "application/json",
		data : json,
		success : function(text) {
			if(text.type == true){
			showMsg("操作成功", 'success');
			grid.reload();
			}else{
				showMsg("操作失败", 'danger');
				grid.reload();
			}
		},
		error : function(text, textStatus, errorThrown) {
			showMsg("操作失败", 'danger');
			grid.reload();
			}
		});
		}
	});
}
