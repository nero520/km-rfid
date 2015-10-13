mini.parse();
var grid = mini.get("datagrid_bill");
var form = new mini.Form("#form");
grid.load();
function showEdit(action,id){
	mini.open({
		url : ctx+"/page/msds/km/bill/bill_edit.jsp",
		title : "结算表",
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

function search() {
	//获取form中的mini控件对象集合,true时将日期格式化为字符串
	var json = form.getData(true);
	grid.load(json);
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
	column.allowSort="true";
		 
});