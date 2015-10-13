mini.parse();
var grid = mini.get("datagrid_company");
grid.load();
function showEdit(action,id){
	mini.open({
		url : ctx+"/page/msds/km/company/company_edit.jsp",
		title : "修改修理厂信息",
		width : 700,
		height : 700,
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
		url : ctx+"/page/msds/km/company/company_new.jsp",
		title : "添加修理厂信息",
		width : 700,
		height : 700,
		onload : function() {
			var iframe = this.getIFrameEl();
			var data = {action : "new", id : id};
			iframe.contentWindow.SetData(data);
		},
		ondestroy : function(action) {
			ondestroy(action);
		}
	});
	
}

//跳转到修改密码页
function passwordEdit(id){
	mini.open({
		url : ctx+"/page/msds/km/company/password_edit.jsp",
		title : "重置修理厂账户密码",
		width : 400,
		height : 200,
		onload : function() {
			var iframe = this.getIFrameEl();
			var data = {action : "passwordEdit", id : id};
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
function edit() {
	var row = grid.getSelected();
	if (row) {
		showEdit("edit",row.id);
	}else{
		mini.alert("请选择一条记录");
	}
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
					url : ctx+"/company/delete.action?id=" + id,
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
/*	var field = mini.get("searchField").getValue();
	var key = mini.get("key").getValue();
	var o={};
	o[field]=key;
	grid.load(o);*/
	
	var nameC = mini.get("nameC").getValue();
	var usernameC = mini.get("usernameC").getValue();
	var telephoneC = mini.get("telephoneC").getValue();
	var afterDate = mini.get("afterDateC").getValue();
	var nowDate = mini.get("nowDateC").getValue();
	
	afterDate = mini.formatDate ( afterDate, "yyyy-MM-dd HH:mm:ss" );
	nowDate = mini.formatDate ( nowDate, "yyyy-MM-dd HH:mm:ss" );
	
	grid.load({
		name:nameC,username:usernameC,afterDate:afterDate,nowDate:nowDate,telephone:telephoneC,
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
//	 action列，超连接操作按钮
	 if (column.name == "action") {
	     e.cellStyle = "text-align:center";
	     if(record.lockState==1){
	    	 e.cellHtml = '<a href="javascript:passwordEdit(\'' + record.id +'\')">修改密码</a>&nbsp; '+
	    	 '<a href="javascript:clearLock(\'' + record.id + '\')">解锁</a>&nbsp; ';
	     }else if(record.lockState==2){
	    	 e.cellHtml = '<a href="javascript:passwordEdit(\'' + record.id +'\')">修改密码</a>&nbsp; '+
	    	 '<a href="javascript:lockout(\'' + record.id + '\')">锁定</a>&nbsp; '; 
	     }
	  }
});

function lockout(id){
	if(id==''){
		mini.alert("请选中一条记录");
		return false;
	}else{
		mini.confirm("确定要锁定修理厂吗？", "提示", function callback(msg) {
			if (msg == 'ok') {
			var o={"id":id,"lockState":1};
			var json = mini.encode(o);
			$.ajax({
				url : ctx+"/company/lockCompanyService.action",
				type : "post",
				dataType : "json",
				contentType : "application/json",
				data : json,
				success : function(text) {
					if(text=='success'){
						showMsg("操作成功", 'success');
						grid.reload();
					}else{
						showMsg(text.content, 'danger');
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
}
function clearLock(id){
	if(id==''){
		mini.alert("请选中一条记录");
		return false;
	}else{
		mini.confirm("确定为修理厂解锁吗？", "提示", function callback(msg) {
			if (msg == 'ok') {
			var o={"id":id,"lockState":2};
			var json = mini.encode(o);
			$.ajax({
				url : ctx+"/company/lockCompanyService.action",
				type : "post",
				dataType : "json",
				contentType : "application/json",
				data : json,
				success : function(text) {
					if(text=='success'){
						showMsg("操作成功", 'success');
						grid.reload();
					}else{
						showMsg(text.content, 'danger');
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
}