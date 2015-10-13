<style>
.topWrap {
	height: 100%;
	padding: 15px 5px;
	font-size: 1.4em;
	background: url(${ctx}/images/login_bg_rept.jpg) repeat-x left 43%;
}

.left {
	float: left;
	margin-top: -5px;
	margin-left: 10px;
}

.left i {
	display: block;
	width: 160px;
	height: 39px;
	background: url(${ctx}/images/logo.png) no-repeat left center;
}

.proname {
	font-size: 5em;
	position: absolute;
	left: 238px;
	top: 342px;
	-webkit-transform: rotate(18deg);
	-ms-transform: rotate(18deg);
	-moz-transform: rotate(18deg);
	-o-transform: rotate(18deg);
	transform: rotate(18deg);
	font-weight: bold;
	font-family: STxingkai, STkaiti;
	color: #a0cfd7;
}

.proname.x {
	-webkit-transform: rotate(-18deg);
	-ms-transform: rotate(-18deg);
	-moz-transform: rotate(-18deg);
	-o-transform: rotate(-18deg);
	transform: rotate(-18deg);
	left: 537px;
	top: 342px;
}

.right {
	font-family: STxingkai, STkaiti;
}

.right a {
	color: #333;
	font-family: FangSong;
	text-decoration: none;
}

.uname {
	border-bottom: 1px dashed;
}

.right a:hover {
	cursor: pointer;
	border-bottom: 1px none;
}

.logout {
	margin-left: 30px;
	margin-right: 30px;
}
</style>
<div class="topWrap">
	<div class="left">
		<span class="copname"><i></i>
		</span>
	</div>
	<div class="right">
		 您好!
			${user.userName}&nbsp;<a href="#"
			onclick="javascript:top_changePassword();">修改密码</a> <!-- <span id="nowtime"></span>
    <a href="#">站内消息<span class="msgcount">2</span></a> --> <a
			href="javascript:logout();" class="logout">[退出]</a>
	</div>
</div>

<div id="top_change_password" class="easyui-dialog"
	style="width:400px;height:190px"
	data-options="iconCls:'icon-save',modal:true" closed="true"
	buttons="#top_change_password_bar">

	<form id="top_change_password_form" method="post" novalidate>
		<table>
			<tr>
				<td width="40%">原密码：</td>
				<td width="60%"><input type="password" name="passwordOld"
					class="easyui-validatebox" required="true"></td>
			</tr>
			<tr>
				<td width="40%">新密码：</td>
				<td width="60%"><input name="passwordNew"  type="password"
					class="easyui-validatebox" required="true"></td>
			</tr>
			<tr>
				<td width="40%">确认密码：</td>
				<td width="60%"><input name="passwordConfig"  type="password"
					class="easyui-validatebox" required="true"></td>
			</tr>
		</table>
	</form>
</div>
<div id="top_change_password_bar">
	<a href="javascript:void(0)" id="top_change_password_id"
		class="easyui-linkbutton" iconCls="icon-ok"
		onclick="top_change_password_save()">保存</a> <a
		href="javascript:void(0)" class="easyui-linkbutton"
		iconCls="icon-cancel"
		onclick="javascript:$('#top_change_password').dialog('close')">取消</a>
</div>
<script type="text/javascript">
	function top_changePassword() {
		$('#top_change_password').dialog('open').dialog('setTitle', '修改密码');
	}

	function top_change_password_save() {
		$('#top_change_password_form')
				.form(
						'submit',
						{
							url : "${ctx}/authUser/changeOwnPassword.action",
							onSubmit : function() {
								var goNext = $(this).form('validate');
								if (goNext) {
									$('#top_change_password_id')
											.linkbutton('disable');
								}
								return goNext;
							},
							success : function(result) {
								$('#top_change_password_id')
										.linkbutton('enable');
								var result = eval("(" + result + ")");
								if (result.success == 0) {
									$('#top_change_password').dialog(
											'close'); // close the dialog

								} else {
									$.messager.show({
										title : 'Error',
										msg : result.errorMsg
									});
								}
							}
						});
	}
</script>

<!-- 
<script>
    var nowtime = document.getElementById("nowtime");
    (function showNow() {
        var time = new Date(),
            m = time.getMinutes(),
            s = time.getSeconds();
        nowtime.innerHTML = time.getHours() + ":" + (m < 10 ? "0" + m : m) + ":" + (s < 10 ? "0" + s : s);
        setTimeout(showNow, 1000);
    })();
</script> -->
