<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<head>
<%@include file="/page/msds/common/commonjs.jsp" %>
</head>
<body>
    <div class="mini-toolbar" style="text-align:center;line-height:30px;" borderStyle="border:0;">
          <span >品牌：</span><input id="brandName" class="mini-textbox" style="width:150px;" onenter="onKeyEnter"/>
          <span >厂商：</span><input id="shopName" class="mini-textbox" style="width:150px;" onenter="onKeyEnter"/>
          <span >车型：</span><input id="name" class="mini-textbox" style="width:150px;" onenter="onKeyEnter"/>
          <a class="mini-button" style="width:60px;" onclick="search()">查询</a>
    </div>
    <div class="mini-fit">

        <div id="grid1" class="mini-datagrid" style="width:100%;height:100%;" 
            idField="id" allowResize="true"
            borderStyle="border-left:0;border-right:0;" onrowdblclick="onRowDblClick"
        >
            <div property="columns">
                <div type="indexcolumn" ></div>
                <div field="brandName"headerAlign="center" allowSort="true">品牌名称</div>
				<div field="shopName"headerAlign="center" allowSort="true">厂商名称</div>
				<div field="name"headerAlign="center" allowSort="true">车系名称</div>               
            </div>
        </div>
    
    </div>                
    <div class="mini-toolbar" style="text-align:center;padding-top:8px;padding-bottom:8px;" borderStyle="border:0;">
        <a class="mini-button" style="width:60px;" onclick="onOk()">确定</a>
        <span style="display:inline-block;width:25px;"></span>
        <a class="mini-button" style="width:60px;" onclick="onCancel()">取消</a>
    </div>

</body>
<script type="text/javascript" src="${ctx}/page/msds/km/model/model_ref_list.js"></script>
</html>