<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
	<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
	
<head>
<jsp:include page="/page/msds/common/commonjs.jsp"></jsp:include>
</head>
<body>
   <input class="mini-hidden" name="roleId" id="roleId"/>
    
<div class="mini-splitter" style="width:100%;height:100%;">
	
    <div size="240" showCollapseButton="true">
        <div class="mini-toolbar" style="padding:2px;border-top:0;border-left:0;border-right:0;">                
            <span style="padding-left:5px;">角色列表</span>
        </div>
        <div class="mini-fit">
            <ul id="tree1" class="mini-tree" url="${ctx}/authGroup/groupList.action" style="width:100%;"
                showTreeIcon="true" textField="name" idField="id" parentField="pid" resultAsTree="false"
                
            >        
            </ul>
        </div>
    </div>
    
    
    
    
    <div showCollapseButton="false">
        <div class="mini-toolbar" style="padding:2px;border-top:0;border-left:0;border-right:0;">          
            <table style="width:100%;">
                <tr>
                    <td style="width:100%;">
                        <a class="mini-button" iconCls="icon-add" onclick="add()">增加</a>
                        <a class="mini-button" iconCls="icon-edit" onclick="edit()">编辑</a>
                        <a class="mini-button" iconCls="icon-edit" onclick="resetPwd()">重置密码</a>
                        <a class="mini-button" iconCls="icon-remove" onclick="remove()">删除</a>       
                    </td>
                    <td style="white-space:nowrap;">
                        <input id="key" class="mini-textbox" emptyText="请输入账号名称" style="width:150px;" onenter="onKeyEnter"/>   
                        <a class="mini-button" onclick="search()">查询</a>
                    </td>
                </tr>
            </table>           
                    
        </div>
        <div class="mini-fit" >
            <div id="grid1" class="mini-datagrid" style="width:100%;height:100%;" 
                borderStyle="border:0;"
                url="${ctx}/authUser/getUserList.action"
                idField="id"   allowAlternating="true"      
            >
                <div property="columns">  
                	<div type="indexcolumn"></div>     
                    <div field="userName" width="120" headerAlign="center" allowSort="true">帐号名称</div> 
                    <div field="firstName" width="120" headerAlign="center" allowSort="true">用户名称</div>
                    <div field="roleName" width="120" headerAlign="center" allowSort="true">角色名称</div>
                    <div field="directShopName" width="120" headerAlign="center" allowSort="true">直营店</div>
                    <div field="email" width="120" headerAlign="center" allowSort="true">邮箱</div>
                    <div field="isActive" width="100" renderer="onGenderRenderer">是否激活</div>  
                    
                </div>
            </div>  
        </div>
    </div>        
</div>
    
    <script type="text/javascript">
        mini.parse();

        var tree = mini.get("tree1");
        var grid = mini.get("grid1");
        grid.load();
        
        tree.on("nodeselect", function (e) {
        	
        	 var role_id = e.node.id;
        	
            if (e.isLeaf) {
            	mini.get("roleId").setValue(role_id);
                grid.load({roleId: e.node.id });
            } else {
            	mini.get("roleId").setValue("");
                grid.setData([]);
                grid.setTotalCount(0);
            }
        });
        //////////////////////////////////////////////
        var Genders = [{ id: 1, text: '<h style="color:red;">已激活</h>' }, { id: 2, text: '<h style="color:green;">未激活</h>'}];
        function onGenderRenderer(e) {
            for (var i = 0, l = Genders.length; i < l; i++) {
                var g = Genders[i];
                if (g.id == e.value) return g.text;
            }
            return "";
        }
        function onNameFilterChanged(e) {
            var textbox = e.sender;
            var key = textbox.getValue();
            
            var node = tree.getSelectedNode();
            if (node) {
                grid.load({ roleId: node.id, key: key });
            }
        }
		function add() {
			var roleId = mini.get("roleId").getValue();
            mini.open({
                url:  ctx+"/page/msds/user/user_edit.jsp",
                title: "新增员工", width: 700, height: 350,
                onload: function () {
                    var iframe = this.getIFrameEl();
                    var data = { action: "new",roleId:roleId};
                    iframe.contentWindow.SetData(data);
                },
                ondestroy: function (action) {
                	grid.load({ roleId: roleId});
                    //grid.reload();
                }
            });
        }
        function edit() {
         
            var row = grid.getSelected();
            if (row) {
                mini.open({
                    url: ctx+"/page/msds/user/user_edit.jsp", 
                    title: "编辑员工", width: 700, height: 350,
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
        
        function resetPwd() {
            
            var row = grid.getSelected();
            if (row) {
                mini.open({
                    url: ctx+"/page/msds/user/user_reset_pwd.jsp", 
                    title: "重置密码", width: 400, height: 150,
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
                        url: "${ctx}/authUser/deleteUser.action?id=" +id,
                        success: function (text) {
                            grid.reload();
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
            grid.load({userName: key});
        }
        
    </script>

</body>
</html>