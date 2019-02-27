<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->

       <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet">
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.1.1.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>


    <script src="${pageContext.request.contextPath}/resources/js/viewer.js"></script>
    <link href="${pageContext.request.contextPath}/resources/css/viewer.css" rel="stylesheet" />
    <script src="${pageContext.request.contextPath}/resources/js/checkbix.min.js"></script>
    <link href="${pageContext.request.contextPath}/resources/css/checkbix.css" rel="stylesheet" />

    <!-- 进度条 -->
    <script src="${pageContext.request.contextPath}/resources/js/jquery.lineProgressbar.js"></script>
    <link href="${pageContext.request.contextPath}/resources/css/jquery.lineProgressbar.css" rel="stylesheet" />

    <link href="${pageContext.request.contextPath}/resources/css/font-awesome.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/awesome-bootstrap-checkbox.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/font.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/css/cont.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/css/layout.css" rel="stylesheet" />
    <link rel="icon" href="${pageContext.request.contextPath}/resources/images/auction1.ico">
    <title>控制台</title>
</head>
<body>
<%@include file="top.jsp"%>

<div class="userCenterWrap">

    <div class="leftNav hidden-xs hidden-sm">
        <ul>
            <li><a href="company_auditing">待审核</a></li>
            <li ><a href="company_posted">已发布</a></li>
            <li><a href="company_upload" >公司上传</a></li>
            <li ><a href="company_deal" >交易记录</a></li>
            <li class="active"><a href="company_data" >控制台</a></li>
            <li><a href="company_news" >信息公告</a></li>
        </ul>
    </div>

    <div class="midCont">

        <ul class="nav nav-pills">

            <li class="active"><a href="company_data">数据统计</a></li>
            <li ><a href="company_keyword">关键词管理</a></li>

        </ul>

        <hr>

        <div class="downpic" style="width: 300px;height: 50px;margin:0px auto;">
            <button id="company_download" type="submit" class="btn btn-warning">下载</button>
        </div>

        <hr>

        <form action="<%=basePath%>searchPic" method="get" enctype="multipart/form-data" >

        <br>
        <div class="scriptionLine">
            <span class="scriptionLeftSpan" style="font-size: 14px">请输入图片编号</span>
            <span>
            <input id="picid" type="text" value="${id}" name="id" class="form-control" placeholder="图片编号" style="width: 260px;height: 36px;border: 1px solid #204d74;">
            </span>
        </div>
        <br>

        </form>

        <c:if test="${fileUps.myUser.admin=='1'}">
        图片上传者<br>
        真实姓名：${fileUps.myUser.realname}<br>
        手机号：${fileUps.myUser.telephone}<br>
        邮箱：${fileUps.myUser.email}<br>
        qq：${fileUps.myUser.qq}<br>
        邮寄地址：${fileUps.myUser.adress}
        </c:if>

        <c:if test="${fileUps.myUser.admin=='管理员'}">
            图片上传者：公司<br>
        </c:if>


        <br>

        <hr>

        <div class="row detailPhotoRow" >

            <div id="big_pany_detail">
                <div class="col-md-6 detailPhoto">
                    <img src="http://${webip}:8084/picture_bed/${fileUps.filePath}" alt="">


                </div>
            </div>


        </div>




    </div><!--midCont-->


</div><!--userCenterWrap-->


<script type="text/javascript">

    $(document).ready(function(){

        $("#big_pany_detail").viewer();

        $("#company_download").click(function () {
                download("companydownload", {
                    file_id: $("#picid").val()

                });
            }
        );

        function download(action, datas)
        {
            var form=$("<form>");

            form.css("display", "none");

            form.attr("target", "");

            form.attr("method", "post");

            form.attr("action", action);

            $.each
            (
                datas,

                function (key)
                {
                    var input = $("<input>");

                    input.attr("type", "hidden");

                    input.attr("name", key);

                    input.attr("value", datas[key]);

                    form.append(input);
                }
            );

            $("body").append(form);//将表单放置在web中

            form.submit();//表单提交

            form.remove();
        }

    })
</script>



</body>
</html>