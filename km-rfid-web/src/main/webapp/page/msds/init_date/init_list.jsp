<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
	<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
	
<head>
<title>促销管理系统</title>
<link rel="shortcut icon" type="image/ico" href="/favicon.ico">

    <script src="${ctx}/js/boot.js" type="text/javascript"></script> 

    <style type="text/css">
    body{
        margin:0;padding:0;border:0;width:100%;height:100%;overflow:hidden;
    }    
    </style>  
    
    
    <!--引入皮肤样式-->
    <link href="${ctx}/js/miniui/themes/blue/skin.css" rel="stylesheet" type="text/css" />

</head>
<body>
    <div style="width:40%;">
        <div class="mini-toolbar" style="border-bottom:0;padding:0px;">
            <table style="width:100%;">
                <tr>
                    <td style="width:100%;">
                        <a class="mini-button" iconCls="icon-add" onclick="add()">增加</a>
                        <a class="mini-button" iconCls="icon-add" onclick="edit()">编辑</a>
                        <a class="mini-button" iconCls="icon-remove" onclick="remove()">删除</a>
                        <input id="key" class="mini-textbox" emptyText="请输入姓名" style="width:150px;" onenter="onKeyEnter"/>   
                        <a class="mini-button" onclick="search()">查询</a>

                    </td>
                  
                </tr>
            </table>           
        </div>
    </div>
    
	<div id="product_grid" class="mini-datagrid" style="width:40%;height:45%"  allowResize="true"
        url="${ctx}/initData/getProductList.action" onrowclick="onRowClick"   onselectionchanged="onSelectionChanged"  idField="id" multiSelect="true" showPager="false">
	    <div  region="center" property="columns">
	    	<div field="id"  headerAlign="center" hidden="true">id</div>    
	        <div field="productCode"  headerAlign="center">产品编号</div>      
            <div field="productName" width="120" headerAlign="center"  allowSort="true">产品名称</div>
            <div field="productInfo" width="120" headerAlign="center"  allowSort="true">适用车型</div>
            <div field="parameter" width="120" headerAlign="center"  allowSort="true">产品尺寸</div>
	    </div>
	</div>
	
	<div id="product_detail_grid" class="mini-datagrid" style="width:40%;height:45%" 
        url="${ctx}/initData/getProductDetailList.action" 
    >
        <div property="columns">            
            <div field="id"  headerAlign="center">id</div>    
	        <div field="productCode"  headerAlign="center">产品编号</div>      
            <div field="productName" width="120" headerAlign="center"  allowSort="true">产品名称</div>
            <div field="productInfo" width="120" headerAlign="center"  allowSort="true">适用车型</div>
            <div field="parameter" width="120" headerAlign="center"  allowSort="true">产品尺寸</div>       
        </div>
    </div>      
	
	<div style="width:15%; height:95%; position: absolute;top: 30px;right:500px;" allowResize="true">
 	 	<input type="button" value="保存" onclick="saveAuthList()"/>  
 	 	<input type="button" value="刷新节点" onclick="refreshNode()"/>

    	<ul id="category_tree" class="mini-tree" url="${ctx}/initData/getCategoryList.action" style="width:200px;height:350px;padding:5px;" 
		    showTreeIcon="true" textField="name" 
		    idField="id" parentField="pid" resultAsTree="false"
		    
        allowSelect="false" enableHotTrack="false" expandOnLoad="true"
        showCheckBox="true" checkRecursive="false" autoCheckParent="true"
		    
		        >        
		</ul>
    </div> 
 
  <div style="width:39%; height:100%; position: absolute;top: 1px;right:1px;" allowResize="true">
 	 	
		<div id="join_grid" class="mini-datagrid" style="width:100%;height:97%"  allowResize="true"
	        url="${ctx}/initData/getProductJoinList.action" onrowclick="onRowClick"   idField="id" multiSelect="true">
		    <div  region="center" property="columns">
		        <div field="productId"  headerAlign="center">产品编号</div>      
	            <div field="categoryId" width="120" headerAlign="center"  allowSort="true">分类编号</div>
		    </div>
		</div>
    </div> 
	
    <script type="text/javascript">
        mini.parse();
        
        var tree = mini.get("category_tree");
        var productGrid = mini.get("product_grid");
        var product_detail_grid = mini.get("product_detail_grid");
        var join_grid = mini.get("join_grid");
        
        
        tree.load();
        productGrid.load();

        function onBeforeTreeLoad(e) {
            var tree = e.sender;    //树控件
            var node = e.node;      //当前节点
            var params = e.params;  //参数对象
            //可以传递自定义的属性
            params.myField = "-1"; //后台：request对象获取"myField"
            
        }

        function refreshNode() {
            var tree = mini.get("category_tree");
            var node = tree.getSelectedNode();
            if (node) {
                tree.loadNode(node);
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
            var tree = mini.get("category_tree");
            tree.load("${ctx}/initData/getCategoryList.action?productId="+row.id);
        }
        
        
        //联动查询
        function onSelectionChanged(e) {
            
            var grid = e.sender;
            var record = grid.getSelected();
            if (record) {
            	product_detail_grid.load({id: record.id });
            	
            	join_grid.load({productId:record.id});
            }
        }
        
        
        //根据角色id保存权限信息
        function saveAuthList(){
        	
        	var row = productGrid.getSelected();
        	if (row) {
        		var s = '';
        		var tree = mini.get("category_tree");
                var nodes = tree.getValue();
        		
        		$.ajax({
        			type : "post",
        			url : "${ctx}/initData/saveProductCategory.action",
        			dataType : 'json',
        			data : {
        				productIds : row.id,
        				ids : nodes
        			},
        			success : function(data) {
        				alert('操作成功');
        			}
        		});
        	}
        	else{
        		alert('请先选择配件!');
    			return;
        	}
        
        }
        
        
        
        
        
    </script>

</body>
</html>