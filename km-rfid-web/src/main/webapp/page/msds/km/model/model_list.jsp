<%@page import="java.util.Random"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<head>
<%@include file="/page/msds/common/commonjs.jsp" %>
<link rel="stylesheet" type="text/css" href="${ctx}/js/uploadify3.1/uploadify.css">
<script type="text/javascript" src="${ctx}/js/uploadify3.1/jquery.uploadify-3.1.min.js?ver=<%=new Random().nextDouble() %>>"></script>
<script type="text/javascript">
$(document).ready(function() {  
	var ctx = '${ctx}';
	setTimeout(function(){
		$("#upload_file").uploadify({
		    'buttonText' : '添加图片',
		    'multi': false,//是否能选择多个文件
		    'height' : 30,//上传按钮的高
		    'width' : 120,//上传按钮的宽
		    'swf' : '${ctx}/js/uploadify3.1/uploadify.swf',//[必须设置]swf的路径
		    'uploader' : '${ctx}/uploads/common.action',//[必须设置]上传文件触发的url
		    'auto':true,//文件选择完成后，是否自动上传
		    'fileObjName'   : 'file',
		    'method'   : 'get',
		    'fileTypeExts'  : '*.bmp;*.gif;*.jpg;*.png',//可选图片格式
		    'formData'      : {'dirName':'model'},  
		    'onUploadSuccess' : function(file, data, response) {
		    	if(response==true){//如果服务器返回200表示成功
		    		$("#iconimage").attr("src",ctx+data+"?"+Math.random());//重新生成缩略图
	    			$("#iconimage").show();
	    			
	    			mini.get("icon_path").setValue(data);
	    		}else{
	    			showMsg("上传失败","danger");
	    		}
		    }
		});
    },10);
	
}); 
</script>
</head>
<body>

<div class="mini-splitter" style="width:100%;height:100%;">
	<div size="30%" showCollapseButton="true">
	<!-- <a class="mini-button" iconCls="icon-add" onclick="onAddBefore()">新增分类(前)</a>
	<a class="mini-button" iconCls="icon-add" onclick="onAddAfter()">新增分类(后)</a>
	<a class="mini-button" iconCls="icon-add" onclick="onAddNode()">新增子分类(子节点)</a>
	<a class="mini-button" iconCls="icon-edit" onclick="onEditNode()">编辑分类</a>
	<a class="mini-button" iconCls="icon-remove" onclick="onRemoveNode()">删除分类</a>
	<a class="mini-button" iconCls="icon-save" onclick="saveData()" style="float:right;font-weight:bold;">保存</a> -->
		<div class="mini-fit">
			<!-- <ul id="model_tree" class="mini-tree" url="${ctx}/model/treeList.action" style="width:100%;" expandOnLoad="0"
				showTreeIcon="true" textField="name" idField="id" parentField="pid" resultAsTree="false" 
				allowDrag="true" allowDrop="true" allowLeafDropIn="true" onnodeselect="nodeselect" onnodedblclick="onEditNode">
	        </ul>
	         -->
	        <ul id="model_tree" class="mini-tree" url="${ctx}/model/lazyTreeList.action" style="width:100%;" 
			    showTreeIcon="true" textField="name" onbeforeload="onBeforeTreeLoad" 
			    idField="id" parentField="pid" resultAsTree="false" 
			    allowDrag="true" allowDrop="true" allowLeafDropIn="true" onnodeselect="nodeselect" onnodedblclick="onEditNode">        
		</ul>
		</div>
	</div>
	<div size="70%" showCollapseButton="true">
		<div class="mini-toolbar" style="background: url('${ctx}/js/miniui/themes/blue/images/toolbar/toolbar.gif') repeat-x scroll 0 0 #f0f0f0;border: 1px solid #99bce8">
			<div id="editform" class="form">
				<input class="mini-hidden" name="id" />
				<table style="width:100%;">
					<tr>
						<td>品牌名称：</td>
						<td><input name="name" 
							 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写分类名称" /></td>
					</tr>
					<tr>
						<td>上级ID：</td>
						<td><input name="pid" 
							 allowLimitValue="false" style="width: 160px;"  class="mini-spinner" emptyText="请填写上级ID"  readonly="readonly"/></td>
					</tr>
					<tr>
						<td>等级：</td>
						<td><input name="level" 
							 allowLimitValue="false" style="width: 160px;"  class="mini-spinner" emptyText="请填写等级" readonly="readonly" /></td>
					</tr>
					<!-- <tr>
						<td>图标：</td>
						<td>
							<img id="iconimage" style="display: none" width="120px" height="80px"></img>
							<input name="upload_file" id="upload_file" type="file" />
							<input name="logo" id="icon_path" class="mini-hidden"  />
						</td>
					</tr> -->
					<tr>
						<td>上下架：</td>
						<td>
<!-- 							上架：<input type="radio"  name="is_show" value="1" id="shang">
							下架：<input type="radio"  name="is_show" value="0" id="xia"> -->
							
							<input name="is_show" class="mini-radiobuttonlist" repeatItems="2" repeatLayout="table" 
							    textField="text" valueField="id" 
							    data="[{'id' : '0','text' : '下架'},{'id' : '1','text' : '上架'}]" />
						</td>
					</tr>
				<!-- 	<tr>
						<td>is_leaf：</td>
						<td><input name="is_leaf" 
							 allowLimitValue="false" style="width: 160px;"  class="mini-spinner" emptyText="请填写is_leaf" /></td>
					</tr>
					<tr>
						<td>分类树：</td>
						<td><input name="tree_path" 
							 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写分类树" /></td>
					</tr>
					-->
					<tr>
						<td style="text-align:right;padding-top:5px;padding-right:20px;"
							colspan="6"><a class="mini-button"
							onclick="updateRow()">保存</a></td>
					</tr> 
				</table>
			</div>
		</div>
	</div>
</div>
</body>
<script type="text/javascript" src="${ctx}/page/msds/km/model/model_list.js"></script>
</html>