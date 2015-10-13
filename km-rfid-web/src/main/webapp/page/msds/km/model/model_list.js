mini.parse();
var tree = mini.get("model_tree");
var form = new mini.Form("#editform");
function add() {
	var node = tree.getSelectedNode();
	if (node) {
		form.clear();
	} else {
		showMsg("请选中一条记录", 'danger');
	}
}

function onBeforeTreeLoad(e) {
    var tree = e.sender;    //树控件
    var node = e.node;      //当前节点
    var params = e.params;  //参数对象
    
    //可以传递自定义的属性
    params.myField = "123"; //后台：request对象获取"myField"
}

function remove() {
	var node = tree.getSelectedNode();
	if (node) {
		mini.confirm("确定删除选中记录？", "提示", function callback(msg) {
			if (msg == 'ok') {
				tree.loading("操作中，请稍后......");
				$.ajax({
					url : ctx+"/model/delete.action?id=" + node.id,
					success : function(text) {
						showMsg("操作成功", 'success');
						tree.removeNode(node);
					},
					error : function(text) {
						showMsg("操作失败：" + text.responseText, 'danger');
					}
				});
			}
		});
	} else {
		showMsg("请选中一条记录", 'danger');
	}
}
function nodeselect(e) {
	$.ajax({
		url : ctx+"/model/getId.action?id=" + e.node.id,
		cache : false,
		success : function(text) {
			form.setData(text);
			var logo = text.logo;
			if(logo !=null && logo !=''){
				$("#iconimage").attr("src",logo);//重新生成缩略图
				$("#iconimage").show();
			} else {
				$("#iconimage").attr("src","");//重新生成缩略图
				$("#iconimage").css('display','none');
			}
		}
	});
//	if (e.isLeaf) {
//		mini.get("add_button").setEnabled(false);
//	}else{
//		mini.get("add_button").setEnabled(true);
//	}
}
function updateRow() {
	mini.confirm("确定要取消吗？", "提示", function callback(msg) {
		if (msg == 'ok') {
	form.validate();
	if (form.isValid() == false)
		return;
	var o = form.getData();
	var json = mini.encode(o);
	$.ajax({
		url : ctx+"/model/save.action",
		type : "post",
		dataType : "json",
		contentType : "application/json",
		data : json,
		success : function(text) {
			showMsg("操作成功", 'success');
			
		},
		error : function(text, textStatus, errorThrown) {
			showMsg("操作失败：" + text.responseText, 'danger');
		}
	});
		}
	});
}
function onEditNode(e) {
    var node = tree.getSelectedNode();
    if(node == null || node == undefined){
    	showMsg("请先选择要编辑的分类", 'danger');
    	return;
    }
    tree.beginEdit(node);
}
function onAddBefore(e) {
    var node = tree.getSelectedNode();
    if(node == null || node == undefined){
    	showMsg("请先选择分类", 'danger');
    	return;
    }
    var newNode = {};
    tree.addNode(newNode, "before", node);
}

function onAddAfter(e) {
    var node = tree.getSelectedNode();
    if(node == null || node == undefined){
    	showMsg("请先选择分类", 'danger');
    	return;
    }
    var newNode = {};
    tree.addNode(newNode, "after", node);
}

function onAddNode(e) {
    var node = tree.getSelectedNode();
//    alert("node.pid:"+node.pid+":::node._pid:"+node._pid);
    if(node == null || node == undefined){
    	showMsg("请先选择父分类", 'danger');
    	return;
    }
    if (!node.id) {
		showMsg("请先保存父分类", 'danger');
		return;
	}
    var newNode = {};
    tree.addNode(newNode, "add", node);
}
function onRemoveNode(e) {
    var node = tree.getSelectedNode();
    if(node == null || node == undefined){
    	showMsg("请先选择分类", 'danger');
    	return;
    }
    if (node) {
        if (confirm("确定删除选中节点?")) {
            tree.removeNode(node);
        }
    }
}
