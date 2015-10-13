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
        <fieldset style="border:solid 1px #aaa;padding:3px;">
            <legend >角色信息</legend>
            <div style="padding:5px;">
        		<table style="table-layout:fixed;">
	                <tr>
	                    <td style="width:70px;">角色名称：</td>
	                    <td style="width:250px;">    
	                        <input name="name" class="mini-textbox" required="true"  emptyText="请输入名称"/>
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
            	url = "${ctx}/authGroup/saveAuthGroup.action";
            }else{
            	url = "${ctx}/authGroup/updateAuthGroup.action";
            }
            var json = mini.encode([o]);
            $.ajax({
                url: url,
				type: 'post',
				data: {
					id:        mini.getbyName("id").getValue(),
					name:  mini.getbyName("name").getValue()
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
                    url: "${ctx}/authGroup/loadAuthGroup.action?id="+data.id, 
                    cache: false,
                    success: function (text) {
                        var o = mini.decode(text);
                        form.setData(text);
                        form.setChanged(false);

                    }
                });
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



    </script>
</body>
</html>