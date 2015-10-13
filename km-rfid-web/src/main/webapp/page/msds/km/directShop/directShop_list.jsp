<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<head>
<%@include file="/page/msds/common/commonjs.jsp" %>
</head>
<body>
	<div class="mini-toolbar"
		style="padding:2px;border-top:0;border-left:0;border-right:0;">
		<table style="width:100%;">
			<tr>
				<td style="width:100%;"><a class="mini-button"
					iconCls="icon-add" onclick="add()">增加</a><a class="mini-button"
					iconCls="icon-remove" onclick="remove()">删除</a></td>
				<td style="white-space:nowrap;">
				<input id="searchField" class="mini-combobox" style="width:75px;" value="id"
				data="[{'id':'id','text':'ID'},{'id':'province','text':'省'},{'id':'city','text':'市'},{'id':'area','text':'区'},{'id':'name','text':'直营店名称'},{'id':'sort','text':'排序'},{'id':'createDate','text':'创建时间'},{'id':'modifyDate','text':'修改时间'},{'id':'parentId','text':'关联direct_shop_id'},{'id':'directShopId','text':'康众提供的字符串Id'},{'id':'type','text':'1总公司、4：分公司、7：门店、10：普通部门、20：仓库'},{'id':'employeeId','text':'负责人'},{'id':'buildDate','text':'成立时间'},{'id':'address','text':'部门地点'},{'id':'phone','text':'联系电话'},{'id':'fax','text':'传真号码'},{'id':'innerCoefficient','text':'内部调拨系数'},{'id':'allocateCoefficient','text':'内部调拨加急系数'},{'id':'realCoefficient','text':'内部调拨核算系数'},{'id':'storeLevel','text':'数据字典'},{'id':'storeSn','text':'仅门店有，值为数字'},{'id':'parentStorageId','text':'上级仓库，仅部门类型为4(分公司)和7(门店)有，无上级仓库为NULL'},{'id':'bank','text':'银行名称只有'},{'id':'bankAccount','text':'银行账号只有'},{'id':'remark','text':'remark'},{'id':'departmentPrintname','text':'出库单打印抬头'},{'id':'storeType','text':'门店类型'},{'id':'isShow','text':'0'},{'id':'managerName','text':'店长名称'},{'id':'managerPhone','text':'店长手机'}]" />
				<input id="key"	class="mini-textbox" emptyText="请输入" style="width:150px;"
					onenter="onKeyEnter" /> <a class="mini-button" onclick="search()">查询</a>
				</td>
			</tr>
		</table>
	</div>
	<div class="mini-fit">
		<div id="datagrid_directShop" class="mini-datagrid"
			style="width:100%;height:100%;" borderStyle="border:0;"
			url="${ctx}/directShop/dataList.action" idField="id"
			allowAlternating="true" sortField="id" sortOrder="desc"
			onrowdblclick="rowdblclick" multiSelect="true">
			<div property="columns">
				<div type="checkcolumn"></div>
					<div field="province"headerAlign="center" allowSort="true">省</div>
					<div field="city"headerAlign="center" allowSort="true">市</div>
					<div field="area"headerAlign="center" allowSort="true">区</div>
					<div field="name"headerAlign="center" allowSort="true">直营店名称</div>
					<div field="sort"headerAlign="center" allowSort="true">排序</div>
					<div field="createDate" dateFormat="yyyy-MM-dd H:mm:ss" headerAlign="center" allowSort="true">创建时间</div>
					<div field="modifyDate" dateFormat="yyyy-MM-dd H:mm:ss" headerAlign="center" allowSort="true">修改时间</div>
					<div field="parentId"headerAlign="center" allowSort="true">关联direct_shop_id</div>
					<div field="directShopId"headerAlign="center" allowSort="true">康众提供的字符串Id</div>
					<div field="type"headerAlign="center" allowSort="true">1总公司、4：分公司、7：门店、10：普通部门、20：仓库</div>
					<div field="employeeId"headerAlign="center" allowSort="true">负责人</div>
					<div field="buildDate" dateFormat="yyyy-MM-dd H:mm:ss" headerAlign="center" allowSort="true">成立时间</div>
					<div field="address"headerAlign="center" allowSort="true">部门地点</div>
					<div field="phone"headerAlign="center" allowSort="true">联系电话</div>
					<div field="fax"headerAlign="center" allowSort="true">传真号码</div>
					<div field="innerCoefficient"headerAlign="center" allowSort="true">内部调拨系数</div>
					<div field="allocateCoefficient"headerAlign="center" allowSort="true">内部调拨加急系数</div>
					<div field="realCoefficient"headerAlign="center" allowSort="true">内部调拨核算系数</div>
					<div field="storeLevel"headerAlign="center" allowSort="true">数据字典</div>
					<div field="storeSn"headerAlign="center" allowSort="true">仅门店有，值为数字</div>
					<div field="parentStorageId"headerAlign="center" allowSort="true">上级仓库，仅部门类型为4(分公司)和7(门店)有，无上级仓库为NULL</div>
					<div field="bank"headerAlign="center" allowSort="true">银行名称只有</div>
					<div field="bankAccount"headerAlign="center" allowSort="true">银行账号只有</div>
					<div field="remark"headerAlign="center" allowSort="true">remark</div>
					<div field="departmentPrintname"headerAlign="center" allowSort="true">出库单打印抬头</div>
					<div field="storeType"headerAlign="center" allowSort="true">门店类型</div>
					<div field="isShow"headerAlign="center" allowSort="true">0</div>
					<div field="managerName"headerAlign="center" allowSort="true">店长名称</div>
					<div field="managerPhone"headerAlign="center" allowSort="true">店长手机</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="<%=ctx%>/page/msds/km/directShop/directShop_list.js"></script>
</html>