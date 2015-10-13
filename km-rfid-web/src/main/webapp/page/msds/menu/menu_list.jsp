<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
	<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
	
<head>
<jsp:include page="/page/msds/common/commonjs.jsp"></jsp:include>
<script src="${ctx}/js/miniui/pagertree.js" type="text/javascript"></script>
</head>
<body>
<div class="mini-fit">
	<div style="width:100%;">
        <div class="mini-toolbar" style="border-bottom:0;padding:0px;">
            <table style="width:100%;">
                <tr>
                    <td style="width:100%;">
                        <a class="mini-button" iconCls="icon-add" onclick="add()">增加</a>
                        <a class="mini-button" iconCls="icon-edit" onclick="edit()">编辑</a>
                        <a class="mini-button" iconCls="icon-remove" onclick="remove()">删除</a>            
                    </td>
                </tr>
            </table>           
        </div>
    </div>
    
	<div id="menu_list_treegrid" class="mini-treegrid" style="width:100%;"     
	    url="${ctx}/permission/MenuList.action" showTreeIcon="true" 
	    treeColumn="taskname" idField="id" parentField="parentIds" resultAsTree="false"  
	    allowResize="true" expandOnLoad="true"
	    allowResize="true" 
        editNextOnEnterKey="true"  editNextRowCell="true" onrowdblclick="edit"
        allowAlternating="true"
	>
	    <div property="columns">
	    	<div field="id" width="35">节点ID</div>
	        <div name="taskname" field="name" width="160" >权限名称</div>
	        <div field="codename" width="160" >权限路径</div>
	        <div field="permission" width="160" >权限过滤</div>
	        <div field="parentIds" width="160" >上级节点</div>
	        <div field="sequence" width="160" >排序</div>  
	    </div>
	</div>
</div>
<script>
    mini.parse();
    var tree = mini.get("menu_list_treegrid");
    var treeid = '1';
    tree.load({
        id: treeid
    });

    function search() {
        var key = document.getElementById('key').value;
        tree.load({
            id: treeid,
            name: key
        });
    }
    
    function onKeyEnter(e) {
        search();
    }

    function add() {
    	var row = tree.getSelected();
        if (!row) {
        	alert("请选中父菜单");
        	return;
        }
        mini.open({
            url: bootPATH + "../page/msds/menu/menu_edit.jsp",
            title: "新增权限", width: 700, height: 250,
            onload: function () {
                var iframe = this.getIFrameEl();
                var data = { action: "new",parentId:row.id};
                iframe.contentWindow.SetData(data);
            },
            ondestroy: function (action) {

            	tree.reload();
            }
        });
    }

    function edit() {
        
        var row = tree.getSelected();
        if (row) {
            mini.open({
            	url: bootPATH + "../page/msds/menu/menu_edit.jsp",
                title: "编辑权限", width: 700, height: 250,
                onload: function () {
                    var iframe = this.getIFrameEl();
                    var data = { action: "edit", id: row.id };
                    iframe.contentWindow.SetData(data);
                    
                },
                ondestroy: function (action) {
                	tree.reload();
                    
                }
            });
            
        } else {
            alert("请选中一条记录");
        }
        
    }

    function remove() {
        
        var rows = tree.getSelecteds();
        if (rows.length > 0) {
            if (confirm("确定删除选中记录？")) {
                var ids = [];
                for (var i = 0, l = rows.length; i < l; i++) {
                    var r = rows[i];
                    ids.push(r.id);
                }
                var id = ids.join(',');
                tree.loading("操作中，请稍后......");
                $.ajax({
                    url: "${ctx}/authPermission/deleteAuthPermission.action?id=" +id,
                   	type:'post',
                    success: function (text) {
                    	alert(text.errorMsg);
                    	tree.reload();
                    },
                    error: function () {
                    }
                });
            }
        } else {
            alert("请选中一条记录");
        }
    }
 

</script>

</body>
</html>
