<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
	<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<head>
<jsp:include page="/page/msds/common/commonjs.jsp"></jsp:include>
</head>
<body>    
     
    <form id="menu_edis_form" method="post">
        <input name="id" class="mini-hidden" />
        <div style="padding-left:11px;padding-bottom:5px;">
        	 <fieldset style="border:solid 1px #aaa;padding:3px;">
            <legend >基础信息</legend>
            <div style="padding:5px;">
        
            <table style="table-layout:fixed;">
                <tr>
                    <td style="width:70px;">权限名称：</td>
                    <td style="width:250px;">    
                        <input name="name" class="mini-textbox" required="true"  />
                    </td>
                    <td style="width:70px;">权限路径：</td>
                    <td >    
                        <input name="codename" class="mini-textbox" required="true" />
                    </td>
                </tr>
                <tr>
                    <td >上级节点：</td>
                   <td style="width:150px;">    
                       <input name="parentIds" class="mini-textbox" required="true"  />
                    </td>
                   <td >权限过滤：</td>
                    <td >    
                        <input name="permission" class="mini-textbox"   />
                    </td>
                </tr>
               
                <tr>
                    <td >排序：</td>
                    <td >    
                        <input name="sequence" class="mini-textbox"  required="true"/>
                    </td>
                </tr>      
            </table>
        </div>
        </fieldset>
        <div style="text-align:center;padding:10px;">               
            <a class="mini-button" onclick="onOk" style="width:60px;margin-right:20px;">确定</a>       
            <a class="mini-button" onclick="onCancel" style="width:60px;">取消</a>       
        </div>        
    </form>
    <script type="text/javascript">
        mini.parse();

        var form = new mini.Form("menu_edis_form");

        var url = "";      
          
        function SaveData() {
            var o = form.getData();            
            form.validate();
            if (form.isValid() == false) return;
            var json = mini.encode([o]);
            
            if(mini.getbyName("id").getValue() == ""){
            	url = "${ctx}/authPermission/saveAuthPermission.action";
            }else{
            	url = "${ctx}/authPermission/updateAuthPermission.action";
            }
            
            $.ajax({
                url: url,
				type: 'post',
				data: {
					id:    mini.getbyName("id").getValue(),
					name:  mini.getbyName("name").getValue(),
					codename: mini.getbyName("codename").getValue(),
					parentIds:  mini.getbyName("parentIds").getValue(),
					permission:     mini.getbyName("permission").getValue(),
					sequence:  mini.getbyName("sequence").getValue()
				},
                cache: false,
                success: function (text) {
                    CloseWindow("save");
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert(jqXHR.responseText);
                    CloseWindow();
                }
            });
        }

        ////////////////////
        //标准方法接口定义
        function SetData(data) {
            if (data.action == "edit") {
                //跨页面传递的数据对象，克隆后才可以安全使用
                data = mini.clone(data);

                $.ajax({
                    url: "${ctx}/authPermission/loadAuthPermission.action?id="+data.id, 
                    cache: false,
                    success: function (text) {
                        var o = mini.decode(text);
                        form.setData(text);
                        form.setChanged(false);

                    }
                });
            } else if(data.action == "new"){
            	mini.getbyName("parentIds").setValue(data.parentId);
            }
        }

        function GetData() {
            var o = form.getData();
            return o;
        }
        function CloseWindow(action) {            
            if (window.CloseOwnerWindow) return window.CloseOwnerWindow(action);
            else window.close();            
        }
        function onOk(e) {
            SaveData();
        }
        function onCancel(e) {
            CloseWindow("cancel");
        }

    </script>
</body>
</html>