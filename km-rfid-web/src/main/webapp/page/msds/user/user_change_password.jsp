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
	            <legend >修改密码</legend>
	            <div style="padding:5px;">
	        		<table style="table-layout:fixed;">
		                <tr>
		                    <td style="width:70px;">原密码：</td>
		                    <td >    
		                        <input name="passwordOld" class="mini-password" required="true"/>
		                    </td>
		                </tr>
		                <tr>
		                    <td style="width:70px;">新密码：</td>
		                    <td >    
		                        <input name="passwordNew" class="mini-password" vtype="rangeLength:6,20" required="true"/>
		                    </td>
		                </tr>
		                 <tr>
		                    <td style="width:70px;">确认新密码：</td>
		                    <td >    
		                        <input name="passwordConfig" class="mini-password" vtype="maxLength:6,20" required="true"/>
		                    </td>
		                </tr>
	            	</table>
	        	</div>
        	</fieldset>
        	<div style="text-align:center;padding:10px;">               
	            <a class="mini-button" onclick="onOk" style="width:60px;margin-right:20px;">确定</a>       
	            <a class="mini-button" onclick="onCancel" style="width:60px;">取消</a>       
        	</div>
        </div>      
    </form>
    <script type="text/javascript">
        mini.parse();

        var form = new mini.Form("form1");

        function SaveData() {
            var o = form.getData();            
            form.validate();
            if (form.isValid() == false) return;
            var url = "${ctx}/authUser/changeOwnPassword.action";
            var json = mini.encode([o]);
            $.ajax({
                url: url,
				type: 'post',
				data: {
					passwordOld:  	 mini.getbyName("passwordOld").getValue(),
					passwordNew:  	 mini.getbyName("passwordNew").getValue(),
					passwordConfig:  mini.getbyName("passwordConfig").getValue()
				},
                cache: false,
                success: function (result) {
                	if (result.success == 0) {
                		CloseWindow("save");
                	}else{
                		alert(result.errorMsg);
                	}
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    CloseWindow();
                }
            });
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