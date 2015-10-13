<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>

<head>
<title>车民生运营后台</title>

<jsp:include page="/page/msds/common/commonjs.jsp"></jsp:include>
<link rel="shortcut icon" type="image/ico" href="${ctx }/favicon.ico">

<style type="text/css">
body {
	margin: 0;
	padding: 0;
	border: 0;
	width: 100%;
	height: 100%;
	overflow: hidden;
}

.header {
	background: url(${ctx}/images/header.gif) repeat-x 0 -1px;
}
</style>
</head>
<body>
	<!--Layout-->
	<div id="layout1" class="mini-layout" style="width:100%;height:100%;">
		<div class="header" region="north" height="70" showSplit="false"
			showHeader="false">
			
			<div class="header-top">
		    	<div class="wrap"><img src="${ctx}/images/logo.png" /></div>
			</div> 
			<div style="position:absolute;top:25px;right:180px;font-size: 14px;">您好，${user.userName}</div>
			<div style="position:absolute;top:14px;right:10px;">
				<!--<a class="mini-button mini-button-iconTop" iconCls="icon-node"
					onclick="onQuickClick(3)" plain="true">临时</a> <a
					class="mini-button mini-button-iconTop" iconCls="icon-node"
					onclick="onQuickClick(1)" plain="true">系统</a>  <a
					class="mini-button mini-button-iconTop" iconCls="icon-date"
					onclick="onClick" plain="true">消息</a>  -->
					  <a
					class="mini-button mini-button-iconTop" iconCls="icon-user"
					onclick="changePassword()" plain="true">修改密码</a>
					<!-- <a
					class="mini-button mini-button-iconTop" iconCls="icon-edit"
					onclick="onClick" plain="true">首页</a> -->
					<a
					class="mini-button mini-button-iconTop" iconCls="icon-close"
					onclick="logout()" plain="true">退出</a>
			</div>
		</div>
		<div title="south" region="south" showSplit="false" showHeader="false"
			height="30">
			<div style="line-height:28px;text-align:center;cursor:default">Copyright
				© 康民电商有限公司版权所有</div>
		</div>
		<div title="center" region="center" style="border:0;"
			bodyStyle="overflow:hidden;">
			<!--Splitter-->
			<div class="mini-splitter" style="width:100%;height:100%;"
				borderStyle="border:0;">
				<div size="180" maxSize="250" minSize="100"
					showCollapseButton="true" style="border:0;">
					<!--OutlookTree-->
					<div id="leftTree" class="mini-outlooktree"
						url="${ctx}/permission/MenuList.action" onnodeclick="onNodeSelect"
						textField="name" idField="id" parentField="parentIds"
						urlField="codename"></div>
				</div>
				<div showCollapseButton="true" style="border:0;">
					<!--Tabs-->
					<div id="mainTabs" class="mini-tabs" activeIndex="0"
						style="width:100%;height:100%;" plain="false"
						onactivechanged="onTabsActiveChanged">
						      <!--  <div title="首页" url="${ctx}/member/list.action" >          
						                     </div> -->
						<div title="首页" style="padding:1px; ">
				<div style=" vertical-align:middle;position:relative;width:1077px;height:688px;background-color:#F8F8F8;">
				<br/><br/>
				

<h1 style="text-align:center;"><strong><span style="font-size:24px;">功能介绍</span></strong></h1>
<p style="text-align:center;"><span style="line-height:2;font-size:14px;"><strong>运营管理平台为运营人员、修理厂顾问、财务人员分别提供权限进行相关操作。</strong></span></p>
<p><span style="line-height:2;font-size:14px;"><strong><br />
</strong></span></p>
<p style="text-align:center;"><span style="line-height:2;"><span style="font-size:14px;">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </span><strong><span style="font-size:14px;">运营人员</span></strong><span style="font-size:14px;">： 管理修理厂及车主信息，查看并管理订单和预约单，代车主取消订单等。</span></span></p>
<p style="text-align:center;"><span style="line-height:2;"><span style="font-size:14px;">&nbsp; &nbsp; &nbsp;&nbsp;</span><strong><span style="font-size:14px;">财务人员</span></strong><span style="font-size:14px;">：&nbsp;查看、核对对账单，为合作方进行结算，为用户进行退款等操作。</span></span></p>
<p style="text-align:center;"><span style="line-height:2;"><span style="font-size:14px;"><span style="font-weight:700;line-height:28px;"><span style="font-size:14px;">&nbsp; &nbsp;修理厂顾问</span></span><span style="font-size:14px;">： 记录并维护车主和车辆信息，为车主提供服务方案并创建预约单。</span></span></span></p>
<div style="text-align:center;"><span style="line-height:2;font-size:14px;font-weight:700;">&nbsp; &nbsp; 系统管理人员</span><span style="line-height:2;font-size:14px;">： 拥有平台全部功能操作的权限，为不同角色的用户分配操作权限等。</span></div>
<span style="line-height:2;"><span style="font-size:14px;"> <br />
</span></span><p><br />
</p>
<div><span style="line-height:2;"><span style="font-size:14px;"><br />
</span></span></div>




				</div>
			</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

	<script type="text/javascript">
		mini.parse();
		var tree = mini.get("leftTree");
		function showTab(node) {
			var tabs = mini.get("mainTabs");
			var id = "tab$" + node.id;
			var tab = tabs.getTab(id);
			if (!tab) {
				tab = {};
				tab._nodeid = node.id;
				tab.name = id;
				tab.title = node.text;
				tab.showCloseButton = true;
				//这里拼接了url，实际项目，应该从后台直接获得完整的url地址
				tab.url = "${ctx}/" + node.url;
				tabs.addTab(tab);
			}
			tabs.activeTab(tab);
		}
		function onNodeSelect(e) {
			var node = e.node;
			var isLeaf = e.isLeaf;
			if (isLeaf) {
				showTab(node);
			}
		}
		function onClick(e) {
			var text = this.getText();
		}
		function onQuickClick(e) {
			tree.expandPath(e);
			//tree.selectNode(3);
		}
		function onTabsActiveChanged(e) {
/* 			var tabs = mini.get("mainTabs");
			var active_tab = tabs.getActiveTab();
			tabs.reloadTab(active_tab); */
		}
		function logout() {
			if (confirm("你确实想要退出系统吗？")) {
				window.location.href = "${ctx}/logout.action";
			}
		}
		function changePassword() {
			mini.open({
				url : bootPATH + "../page/msds/user/user_change_password.jsp",
				title : "修改密码",
				width : 400,
				height : 210,
			 	ondestroy: function (action) {
			 		if(action == 'save'){
			 			showMsg("密码修改成功", 'success');
			 		}
                	
                }
			});
		}
		//默认收缩菜单树
		//如需要打开某个菜单把XXX替换为序号，从0开始
		tree.setActiveIndex("XXX");
		//mini.get("tree_test").collapsePane(1)
// 		tree.expandPath(3);
		//切换选项卡URL
		function changedTabUrl(url,title) {
			
			var tabs = mini.get("mainTabs");
			var active_tab = tabs.getActiveTab();
			var options = {"url":url};
 			if(title != undefined && title != ""){
 				options.title = title;
			} 
			tabs.updateTab(active_tab,options);
			active_tab.url = url;
			tabs.reloadTab(active_tab);
		}
		//切换选项卡URL
		function updateActiveTab(options) {
			var tabs = mini.get("mainTabs");
			var active_tab = tabs.getActiveTab();
			tabs.updateTab(active_tab,options);
			tabs.reloadTab(active_tab);
		}
		
		//打开新选项卡
		function addTabUrl(url,title){
			var tabs = mini.get("mainTabs");
			var tab = {};
			tab.title= title;
			tab.url= url;
			tab.showCloseButton=true;
			tabs.addTab(tab);
			tabs.activeTab(tab);
		}
		function removeTab() {
		    var tabs = mini.get("mainTabs");
		    var tab = tabs.getActiveTab();
		    if (tab) {
		        tabs.removeTab(tab);
		    }
		}
		function reloadTab(e) {
			var tabs = mini.get("mainTabs");
			var active_tab = tabs.getActiveTab();
			tabs.reloadTab(active_tab);
		}
	</script>
</body>
</html>