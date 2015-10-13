mini.parse();

var grid = mini.get("datagrid_member");
grid.load();
function showEdit(action,id){
	mini.open({
		url : ctx+"/page/msds/km/member/member_edit.jsp",
		title : "个人会员信息表",
		width : 600,
		height : 225,
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
function add(url,title) {
	parent.addTabUrl(url,title);
}

function edit() {
	var row = grid.getSelected();
	
    if (row) {
    	var url = ctx+'/bespeak/editMember.action?phone='+row.phone;
    	var title = '编辑车主信息';
    	parent.addTabUrl(url,title);
    } else {
        mini.alert("请选择一条记录");
    }
	
}




function details(phone) {
	
//	alert(e.row.phone);
//	details(e.row.id);
	var url = ctx+'/bespeak/editMember.action?isView=true&phone='+phone;
	var title = '查询车主信息';
	parent.addTabUrl(url,title);
	
	
}


function search() {
	var phone = mini.getbyName("phoneid").getValue();
	var license = mini.getbyName("license").getValue();
    grid.load({license: license, phone: phone});
}

function onKeyEnter(e) {
	search();
}

grid.on("drawcell", function (e) {
	
	 var record = e.record,
	 	 column = e.column;
	     field  = e.field;
	     value  = e.value;
//		 action列，超连接操作按钮
		 if (column.name == "vin" && e.value!=undefined &&  e.value!="") {
		     e.cellStyle = "text-align:center";
		     e.cellHtml = '<a href="javascript:findMemberByvin(\'' + e.value +'\')">'+e.value+'</a>&nbsp';
		   
		 };
	 

    if (field == "serviceTime") {
        if (mini.isDate(value)) e.cellHtml = mini.formatDate(value, "yyyy-MM-dd H:mm:ss");

    }

});

function viewMember() {
	
	var row = grid.getSelected();
	
    if (row) {
    	var url = ctx+'/bespeak/viewMember.action?id='+row.id;
    	var title = '查看车主信息';
    	parent.addTabUrl(url,title);
    } else {
        mini.alert("请选择一条记录");
    }
	
}


function findMemberByvin(memberId) {
	var row = grid.getSelected();
    if (row) {
    	var url = ctx+'/bespeak/findMemberInfo.action?vin='+memberId;
    	var title = '车主汽车历史维护信息';
    	parent.addTabUrl(url,title);
    } else {
        mini.alert("请选择一条记录");
    }
	
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
		     	e.cellHtml ='<a href="javascript:details(\'' + record.id + '\')">用户车型信息</a>&nbsp; ';
	 };
});


