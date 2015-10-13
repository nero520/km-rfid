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
          <div style="padding:5px;">
        
            <table style="table-layout:fixed;">
                <tr>  
                	<td style="width:100px;">帐号名称：</td>
                    <td style="width:250px;">    
                        <input name="userName" class="mini-textbox" required="true" readonly="readonly" emptyText="请输入帐号"/>
                    </td>
                </tr>
                <tr>
                 <td style="width:100px;">帐号密码：</td>
                    <td >    
                        <input name="password" class="mini-password" required="true"/>
                    </td>
                </tr>
            </table>
        </div>
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
            
            url = "${ctx}/authUser/changePassword.action";
            var json = mini.encode([o]);
            $.ajax({
                url: url,
				type: 'post',
				data: {
					id:        mini.getbyName("id").getValue(),
					password:  mini.getbyName("password").getValue(),
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
                        mini.getbyName("password").setValue("");
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