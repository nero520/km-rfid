<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <link rel="shortcut icon" type="image/ico" href="${ctx }/favicon.ico">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>车民生运营后台</title>
	<jsp:include page="/page/msds/common/commonjs.jsp"></jsp:include>
    <link rel="stylesheet" type="text/css" href="${ctx }/css/base.css" media="all">
    <link rel="stylesheet" type="text/css" href="${ctx }/css/dataCockpit.css" media="all">

    <style type="text/css">
        html, body {
            width: 100%;
            height: 100%;
        }
    </style>
</head>

<body>
    <div class="loginPage">
        <div class="loginMain">
            <div class="loginBox">
                <div class="loginTabl">
                    <form action="/km-rfid-web/login.action" id="lgform" method="POST">
                        <table border="0" cellspacing="0" cellpadding="0">
                            <tbody>
                                <tr class="tr1">
                                    <td class="ar">
                                        <div class="justify" style="width: 65px;"></div>
                                    </td>
                                    <td>
                                        <input type="text" id="userName" name="userName" value=""></td>
                                </tr>

                                <tr class="tr2">
                                    <td class="ar">
                                        <div class="justify" style="width: 65px;"></div>
                                    </td>
                                    <td>
                                        <input type="password" id="password" name="password" value=""></td>
                                </tr>
                                <tr class="tr3">
                                    <td class="ar">
                                        <div class="justify" style="width: 65px;"></div>
                                    </td>
                                    <td>
                                        <table>
                                            <tbody>
                                                <tr>
                                                    <td>
                                                        <input type="text" id="checkCode" name="checkCode" value=""></td>
                                                    <td>
                                                        <img title="验证码" alt="" class="ctchimg" id="ctchimg" src="${ctx}/captcha.jpg"></td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </td>
                                </tr>
                                <tr class="tr4">
                                    <td class="ar">&nbsp;</td>
                                    <td>
                                        <input type="submit" id="lgsubmit" class="submit" value="">
                                    </td>
                                </tr>
                                <tr class="tr5">
                                    <td class="ar"></td>
                                    <td>
                                        <label id="lbErrtips" style="color: red;">${error}</label></td>
                                </tr>
                            </tbody>
                        </table>
                    </form>
                </div>
            </div>
        </div>
    </div>



    <div id="cboxOverlay" style="display: none;"></div>
    <div id="colorbox" class="" role="dialog" tabindex="-1" style="display: none;">
        <div id="cboxWrapper">
            <div>
                <div id="cboxTopLeft" style="float: left;"></div>
                <div id="cboxTopCenter" style="float: left;"></div>
                <div id="cboxTopRight" style="float: left;"></div>
            </div>
            <div style="clear: left;">
                <div id="cboxMiddleLeft" style="float: left;"></div>
                <div id="cboxContent" style="float: left;">
                    <div id="cboxTitle" style="float: left;"></div>
                    <div id="cboxCurrent" style="float: left;"></div>
                    <button type="button" id="cboxPrevious"></button>
                    <button type="button" id="cboxNext"></button>
                    <button id="cboxSlideshow"></button>
                    <div id="cboxLoadingOverlay" style="float: left;"></div>
                    <div id="cboxLoadingGraphic" style="float: left;"></div>
                </div>
                <div id="cboxMiddleRight" style="float: left;"></div>
            </div>
            <div style="clear: left;">
                <div id="cboxBottomLeft" style="float: left;"></div>
                <div id="cboxBottomCenter" style="float: left;"></div>
                <div id="cboxBottomRight" style="float: left;"></div>
            </div>
        </div>
        <div style="position: absolute; width: 9999px; visibility: hidden; display: none; max-width: none;"></div>
    </div>

</body>
</html>
