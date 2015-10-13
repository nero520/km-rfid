<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
	<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
	
<head>
<jsp:include page="/page/msds/common/commonjs.jsp"></jsp:include>
</head>
<body>
    <div style="width:100%;">
        <div class="mini-toolbar" style="border-bottom:0;padding:0px;">
            <table style="width:100%;">
                <tr>
                    <td style="width:100%;">
                        <a class="mini-button" iconCls="icon-add" onclick="add()">增加</a>
                        <a class="mini-button" iconCls="icon-edit" onclick="edit()">编辑</a>
                        <a class="mini-button" iconCls="icon-remove" onclick="remove()">删除</a>

                    </td>
                    <td style="white-space:nowrap;">
                        <input id="key" class="mini-textbox" emptyText="请输入姓名" style="width:150px;" onenter="onKeyEnter"/>   
                        <a class="mini-button" onclick="search()">查询</a>
                    </td>
                </tr>
            </table>           
        </div>
    </div>
    
	<div id="datagrid1" class="mini-datagrid" style="width:70%;"  allowResize="true"
        url="${ctx}/authGroup/groupList.action" onrowclick="onRowClick"   idField="id" multiSelect="true">
	    <div  region="center" property="columns">
	        <div field="id"  headerAlign="center">角色编号</div>      
            <div field="name" width="120" headerAlign="center"  allowSort="true">角色名称</div>
	    </div>
	</div>
	<div class="mini-tabs" style="width:30%;height:100%;position: absolute;top: 30px;right:-30px;" plain="false" >
		<div title="功能权限" >
			<!-- <h2>权限配置</h2> -->
	 	 	<input type="button" value="保存" onclick="saveAuthList()"/>  
	    	<ul id="authTree" class="mini-tree" url="${ctx}/authGroup/getPersssionList.action" style=" width:300px;height:350px;padding:5px;" 
		        showTreeIcon="true" textField="text" idField="id" parentField="pid" resultAsTree="false"  
		        allowSelect="false" enableHotTrack="false" expandOnLoad="true"
		        showCheckBox="true" checkRecursive="false" autoCheckParent="true">
	    	</ul>
		</div>
		<div title="数据权限" >
			<!-- <h2>权限配置</h2> -->
	 	 	<input type="button" value="保存" onclick="saveDsList()"/>  
	    	<ul id="dataTree" class="mini-tree" url="${ctx}/authGroup/getDirectShopList.action" style=" width:300px;height:350px;padding:5px;" 
		        showTreeIcon="true" textField="text" idField="sId" parentField="pid" resultAsTree="false"  
		        allowSelect="false" enableHotTrack="false" expandOnLoad="true"
		        showCheckBox="true" checkRecursive="false" autoCheckParent="true">
	    	</ul>
		</div>
	</div>
	
	
    <script type="text/javascript">
        mini.parse();

        var grid = mini.get("datagrid1");
        grid.load();
        grid.sortBy("createtime", "desc");

        var tree = mini.get("authTree");
        tree.load();
        
        function add() {
            
            mini.open({
                url: bootPATH + "../page/msds/usergroup/usergroup_edit.jsp",
                title: "新增角色", width: 600, height: 360,
                onload: function () {
                    var iframe = this.getIFrameEl();
                    var data = { action: "new"};
                    iframe.contentWindow.SetData(data);
                },
                ondestroy: function (action) {

                    grid.reload();
                }
            });
        }
        function edit() {
         
            var row = grid.getSelected();
            if (row) {
                mini.open({
                    url: bootPATH + "../page/msds/usergroup/usergroup_edit.jsp",
                    title: "编辑角色", width: 600, height: 360,
                    onload: function () {
                        var iframe = this.getIFrameEl();
                        var data = { action: "edit", id: row.id };
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
        function remove() {
            
            var rows = grid.getSelecteds();
            if (rows.length > 0) {
                if (confirm("确定删除选中记录？")) {
                    var ids = [];
                    for (var i = 0, l = rows.length; i < l; i++) {
                        var r = rows[i];
                        ids.push(r.id);
                    }
                    var id = ids.join(',');
                    grid.loading("操作中，请稍后......");
                    $.ajax({
                        url: "${ctx}/authGroup/deleteAuthGroup.action?id=" +id,
                        success: function (text) {
                            grid.reload();
                            var tree = mini.get("authTree");
                            tree.load("${ctx}/authGroup/getPersssionList.action");
                        },
                        error: function () {
                        }
                    });
                }
            } else {
                alert("请选中一条记录");
            }
        }
        function search() {
            var key = mini.get("key").getValue();
            grid.load({ name: key });
        }
        function onKeyEnter(e) {
            search();
        }
        //切换角色事件
        function onRowClick(e) {
            var row = e.row;
            var tree = mini.get("authTree");
            tree.load("${ctx}/authGroup/getPersssionList.action?id="+row.id);
            var tree1 = mini.get("dataTree");
            tree1.load("${ctx}/authGroup/getDirectShopList.action?id="+row.id);
        }
        
        //根据角色id保存权限信息
        function saveAuthList(){
        	
        	var row = grid.getSelected();
        	if (row) {
        		var s = '';
        		var tree = mini.get("authTree");
                var nodes = tree.getValue();
        		
        		$.ajax({
        			type : "post",
        			url : "${ctx}/authGroup/savePermission.action",
        			dataType : 'json',
        			data : {
        				groupId : row.id,
        				ids : nodes
        			},
        			success : function(data) {
        				var result = eval(data);
        				if (result.success == 0) {
        					alert(data.errorMsg);
        				} 
        				else 
        				{
        					alert(data.errorMsg);
        				}
        			}
        		});
        	}
        	else{
        		alert('请选择要修改权限的角色!');
    			return;
        	}
        
        }
        
      //根据角色id保存权限信息
        function saveDsList(){
        	
        	var row = grid.getSelected();
        	if (row) {
        		var s = '';
        		var tree = mini.get("dataTree");
                var nodes = tree.getValue();
        		
        		$.ajax({
        			type : "post",
        			url : "${ctx}/authGroup/saveDs.action",
        			dataType : 'json',
        			data : {
        				groupId : row.id,
        				ids : nodes
        			},
        			success : function(data) {
        				var result = eval(data);
        				if (result.success == 0) {
        					alert(data.errorMsg);
        				} 
        				else 
        				{
        					alert(data.errorMsg);
        				}
        			}
        		});
        	}
        	else{
        		alert('请选择要修改权限的角色!');
    			return;
        	}
        
        }
    </script>

    <div class="description">
        <h3>Description</h3>
        
    </div>
</body>
</html>