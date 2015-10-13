<%@page import="com.msds.km.util.EnumUtil"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %> 
<% 
	String jsStr = EnumUtil.getJsVariableString();
	String resourcePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
	String ctx = request.getContextPath();
	String webRootPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
	String imageDomain = "http://image.carzone.cn";
	int intervalTime= 600;//10分钟
%>
<c:set var="ctx" value="<%=request.getContextPath()%>" scope="application"/>
<script src="${ctx}/js/boot.js" type="text/javascript"></script> 
<%-- <script src="${ctx}/js/highcharts/js/highcharts.js"></script> --%>
<%-- <script src="${ctx}/js/highcharts/js/modules/exporting.js"></script> --%>
<style type="text/css">
body{
    margin:0;padding:0;border:0;width:100%;height:100%;overflow:hidden;
}
</style>
<script type="text/javascript">
function showMsg(msg,state){
	mini.showTips({
	    content: '<b>'+msg+'<b>',
	    state: state,
	    x: 'center',
	    y: 'center',
	    timeout: 2000
	});
}

<%=jsStr%>
var ctx = '${ctx}';
var resourcePath = '<%=resourcePath%>';
var webRootPath = '<%=webRootPath%>';
var imageDomain = '<%=imageDomain%>';

(function($) {
    $(document).ajaxComplete(function(event, request, settings) {
        var loginStatus = request.getResponseHeader("loginStatus");
        if (loginStatus == "accessDenied") {
        	location.reload();
        }
    });
})(jQuery);
</script>
<script type="text/javascript" src="<%=ctx%>/js/common.js"></script>
<!--引入皮肤样式-->
<link href="${ctx}/js/miniui/themes/blue/skin.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/common.css" rel="stylesheet" type="text/css" />
