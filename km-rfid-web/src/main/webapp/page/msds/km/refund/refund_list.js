mini.parse();
var grid = mini.get("datagrid_refund");
grid.load();
function showEdit(action,id){
	mini.open({
		url : ctx+"/page/msds/km/refund/refund_edit.jsp",
		title : "退款单主表",
		width : 600,
		height : 325,
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
function details(rowid) {
    
	 var row = rowid;
	    if (row) {
	        mini.open({
	        	url: ctx+"/page/msds/km/refund/refund_details.jsp",
	            title: "退款确认", width: 900,height:600,
	            onload: function () {
	                var iframe = this.getIFrameEl();
	                var data = { id: row };
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

function edit(rowid){
	 var row = rowid;
	    if (row) {
	        mini.open({
	        	url: ctx+"/page/msds/km/refund/refund_edit.jsp",
	            title: "退款确认", width: 300,height:200,
	            onload: function () {
	                var iframe = this.getIFrameEl();
	                var data = { action: "edit", id: row };
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
function rowdblclick(e) {
	alert(e.id);
	showEdit("edit",e.id);
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
					url : ctx+"/refund/delete.action?id=" + id,
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
	var orderSn = mini.get("orderSn").getValue();
	var phone = mini.get("phone").getValue();
	var license = mini.get("license").getValue();
	var afterDate = mini.get("afterDate").getValue();
	var nowDate = mini.get("nowDate").getValue();
		afterDate = mini.formatDate ( afterDate, "yyyy-MM-dd HH:mm:ss" );
		nowDate = mini.formatDate ( nowDate, "yyyy-MM-dd HH:mm:ss" );
		var o={afterDate:afterDate,nowDate:nowDate,license:license,orderSn:orderSn,phone:phone};
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

//	 action列，超连接操作按钮
	 if (column.name == "action") {
	     e.cellStyle = "text-align:center";
	     if (0 === record.state) {
	        e.cellHtml ='<a href="javascript:edit(\'' + record.id + '\')">退款确认</a>&nbsp; '+
	        '<a href="javascript:details(\'' + record.id + '\')">查看</a>&nbsp; ';
	     }
	     if(1 == record.state){
	     	e.cellHtml = '<a href="javascript:details(\'' + record.id + '\')">查看</a>&nbsp; ';
	     }
	    
	     
	 };
	 

    if (field == "price") {
    	if(value==undefined){
    		e.cellHtml = 0;
    	}
    }
});
/**
 * 跳转详情页
 */
function details(recordId)   {          
	parent.addTabUrl(ctx+"/refund/refundInfo.action?id="+recordId,"退款详情");
}
grid.on("drawcell", function (e) {
	var record = e.record,
		column = e.column,
		field  = e.field,
		value  = e.value;
	 
	//设置列属性
	column.headerAlign="center";
	column.align="center";
		 
})
