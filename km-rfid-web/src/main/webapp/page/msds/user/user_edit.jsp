<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
	<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<head>
<jsp:include page="/page/msds/common/commonjs.jsp"></jsp:include>
</head>
<body>    
     
    <form id="form1" method="post">
        <input name="id" class="mini-hidden" />
        <div style="padding-left:11px;padding-bottom:5px;">
        
        
        	 <fieldset style="border:solid 1px #aaa;padding:3px;">
            <legend >用户信息</legend>
            <div style="padding:5px;">
        
            <table style="table-layout:fixed;">
                <tr>
                    <td style="width:70px;">帐号名称：</td>
                    <td style="width:250px;">    
                        <input name="userName" class="mini-textbox" required="true"  emptyText="请输入帐号"/>
                    </td>
                    <td style="width:70px;">帐号密码：</td>
                    <td >    
                        <input name="password" class="mini-password" required="true"/>
                    </td> 
                </tr>
                <tr>
                    <td >用户名称：</td>
                   <td style="width:150px;">    
                       <input name="firstName" class="mini-textbox" required="true"  />
                    </td>
                   <td >所属直营店：</td>
                    <td >    
                         <!-- <input name="directShopId" class="mini-combobox" valueField="directShopId" textField="name" valueFromSelect="true"
                            url="${ctx}/directShop/shopList.action"  required="true"  allowInput="true"   emptyText="可模糊查询" showNullItem="false"
                            />
                             -->
                            <input id="directShopId"  required="true"  class="mini-buttonedit" name="directShopId" textName="directShopName" 
						onbuttonclick="onButtonEdit"/>  
                            
                    </td>
                </tr>
               
                <tr>
                	
                    <td >邮箱地址：</td>
                    <td >    
                        <input name="email" class="mini-textbox"  required="true"/>
                    </td>
                    <td >所属角色：</td>
                    <td >    
                         <input name="roleId" id="roleId" class="mini-combobox" valueField="id" textField="name" 
                            url="${ctx}/authGroup/groupList.action"  required="true"    emptyText="请选择角色"
                            />
                    </td>
                   
                </tr>  
                <tr>
                 <td >是否激活：</td>
                     <td >    
                        <select name="isActive" class="mini-radiobuttonlist">
	                        <option value="1">已激活</option>
	                        <option value="0">未激活</option>
	                    </select>
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

        var form = new mini.Form("form1");

        function SaveData() {
            var o = form.getData();            
            form.validate();
            if (form.isValid() == false) return;
            var url = "";
            
            if(mini.getbyName("id").getValue() == ""){
            	url = "${ctx}/authUser/saveAuthUser.action";
            }else{
            	url = "${ctx}/authUser/updateAuthUser.action";
            }
            var json = mini.encode([o]);
            $.ajax({
                url: url,
				type: 'post',
				data: {
					id:        mini.getbyName("id").getValue(),
					userName:  mini.getbyName("userName").getValue(),
					firstName: mini.getbyName("firstName").getValue(),
					password: mini.getbyName("password").getValue(),
					email:     mini.getbyName("email").getValue(),
					isActive:  mini.getbyName("isActive").getValue(),
					roleId:    mini.getbyName("roleId").getValue(),
					directShopId : mini.getbyName("directShopId").getValue(),
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
                    url: "${ctx}/authUser/loadAuthUser.action?id="+data.id, 
                    cache: false,
                    success: function (text) {
                        var o = mini.decode(text);
                        form.setData(text);
                        form.setChanged(false);

                    }
                });
            } else if(data.action=="new"){
            	var roleId = data.roleId;
            	mini.get("roleId").setValue(roleId);
            }
        }

        function GetData() {
            var o = form.getData();
            return o;
        }
        function CloseWindow(action) {            
            if (action == "close" && form.isChanged()) {
                if (confirm("数据被修改了，是否先保存？")) {
                    return false;
                }
            }
            if (window.CloseOwnerWindow) return window.CloseOwnerWindow(action);
            else window.close();            
        }
        function onOk(e) {
            SaveData();
        }
        function onCancel(e) {
            CloseWindow("cancel");
        }
        //////////////////////////////////
        function onDeptChanged(e) {
            var deptCombo = mini.getbyName("dept_id");
            var positionCombo = mini.getbyName("position");
            var dept_id = deptCombo.getValue();

            positionCombo.load("../data/AjaxService.jsp?method=GetPositionsByDepartmenId&id=" + dept_id);
            positionCombo.setValue("");
        }

        function onButtonEdit(e) {
		    var btnEdit = this;
		    mini.open({
		        url: ctx+"/page/msds/car/directShop/directShop_ref_all.jsp",
		        showMaxButton: false,
		        title: "选择树",
		        width: 300,
		        height: 450,
		        ondestroy: function (action) {                    
		            if (action == "ok") {
		                var iframe = this.getIFrameEl();
		                var data = iframe.contentWindow.GetData();
		                data = mini.clone(data);
		                if (data) {
		                    btnEdit.setValue(data.directShopId);
		                    btnEdit.setText(data.name);
		                }
		            }
		        }
		    });            
		     
		}  

    </script>
</body>
</html>