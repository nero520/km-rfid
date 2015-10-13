<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<head>
<%@include file="/page/msds/common/commonjs.jsp" %>
</head>
<body>
	<div class="mini-fit" style="background: url('<%=ctx%>/js/miniui/themes/blue/images/toolbar/toolbar.gif') repeat-x scroll 0 0 #f0f0f0;border: 1px solid #99bce8">
		<div id="editform" class="form">
			<input class="mini-hidden" name="id" />
			<table style="width:100%;">
				<tr>
					<td>省：</td>
					<td><input name="province" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写省" /></td>
				</tr>
				<tr>
					<td>市：</td>
					<td><input name="city" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写市" /></td>
				</tr>
				<tr>
					<td>区：</td>
					<td><input name="area" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写区" /></td>
				</tr>
				<tr>
					<td>直营店名称：</td>
					<td><input name="name" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写直营店名称" /></td>
				</tr>
				<tr>
					<td>排序：</td>
					<td><input name="sort" 
						 allowLimitValue="false" style="width: 160px;"  class="mini-spinner" emptyText="请填写排序" /></td>
				</tr>
				<tr>
					<td>创建时间：</td>
					<td><input name="createDate" 
						 format="yyyy-MM-dd H:mm:ss" timeFormat="H:mm:ss" showTime="true" style="width: 160px;"  class="mini-datepicker" emptyText="请填写创建时间" /></td>
				</tr>
				<tr>
					<td>修改时间：</td>
					<td><input name="modifyDate" 
						 format="yyyy-MM-dd H:mm:ss" timeFormat="H:mm:ss" showTime="true" style="width: 160px;"  class="mini-datepicker" emptyText="请填写修改时间" /></td>
				</tr>
				<tr>
					<td>关联direct_shop_id：</td>
					<td><input name="parentId" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写关联direct_shop_id" /></td>
				</tr>
				<tr>
					<td>康众提供的字符串Id：</td>
					<td><input name="directShopId" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写康众提供的字符串Id" /></td>
				</tr>
				<tr>
					<td>1总公司、4：分公司、7：门店、10：普通部门、20：仓库：</td>
					<td><input name="type" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写1总公司、4：分公司、7：门店、10：普通部门、20：仓库" /></td>
				</tr>
				<tr>
					<td>负责人：</td>
					<td><input name="employeeId" 
						 allowLimitValue="false" style="width: 160px;"  class="mini-spinner" emptyText="请填写负责人" /></td>
				</tr>
				<tr>
					<td>成立时间：</td>
					<td><input name="buildDate" 
						 format="yyyy-MM-dd H:mm:ss" timeFormat="H:mm:ss" showTime="true" style="width: 160px;"  class="mini-datepicker" emptyText="请填写成立时间" /></td>
				</tr>
				<tr>
					<td>部门地点：</td>
					<td><input name="address" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写部门地点" /></td>
				</tr>
				<tr>
					<td>联系电话：</td>
					<td><input name="phone" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写联系电话" /></td>
				</tr>
				<tr>
					<td>传真号码：</td>
					<td><input name="fax" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写传真号码" /></td>
				</tr>
				<tr>
					<td>内部调拨系数：</td>
					<td><input name="innerCoefficient" 
						 allowLimitValue="false" style="width: 160px;"  class="mini-spinner" emptyText="请填写内部调拨系数" /></td>
				</tr>
				<tr>
					<td>内部调拨加急系数：</td>
					<td><input name="allocateCoefficient" 
						 allowLimitValue="false" style="width: 160px;"  class="mini-spinner" emptyText="请填写内部调拨加急系数" /></td>
				</tr>
				<tr>
					<td>内部调拨核算系数：</td>
					<td><input name="realCoefficient" 
						 allowLimitValue="false" style="width: 160px;"  class="mini-spinner" emptyText="请填写内部调拨核算系数" /></td>
				</tr>
				<tr>
					<td>数据字典：</td>
					<td><input name="storeLevel" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写数据字典" /></td>
				</tr>
				<tr>
					<td>仅门店有，值为数字：</td>
					<td><input name="storeSn" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写仅门店有，值为数字" /></td>
				</tr>
				<tr>
					<td>上级仓库，仅部门类型为4(分公司)和7(门店)有，无上级仓库为NULL：</td>
					<td><input name="parentStorageId" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写上级仓库，仅部门类型为4(分公司)和7(门店)有，无上级仓库为NULL" /></td>
				</tr>
				<tr>
					<td>银行名称只有：</td>
					<td><input name="bank" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写银行名称只有" /></td>
				</tr>
				<tr>
					<td>银行账号只有：</td>
					<td><input name="bankAccount" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写银行账号只有" /></td>
				</tr>
				<tr>
					<td>remark：</td>
					<td><input name="remark" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写remark" /></td>
				</tr>
				<tr>
					<td>出库单打印抬头：</td>
					<td><input name="departmentPrintname" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写出库单打印抬头" /></td>
				</tr>
				<tr>
					<td>门店类型：</td>
					<td><input name="storeType" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写门店类型" /></td>
				</tr>
				<tr>
					<td>0：</td>
					<td><input name="isShow" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写0" /></td>
				</tr>
				<tr>
					<td>店长名称：</td>
					<td><input name="managerName" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写店长名称" /></td>
				</tr>
				<tr>
					<td>店长手机：</td>
					<td><input name="managerPhone" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写店长手机" /></td>
				</tr>
				<tr>
					<td style="text-align:right;padding-top:5px;padding-right:20px;"
						colspan="3"><a class="mini-button"
						onclick="updateRow()">保存</a> <a class="mini-button"
						onclick="cancelRow()">取消</a></td>
				</tr>
			</table>
		</div>
	</div>
</body>
<script type="text/javascript" src="<%=ctx%>/page/msds/km/directShop/directShop_edit.js"></script>
</html>