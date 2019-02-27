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

        <table class="table table-striped table-hover table-bordered" style="margin-left: 70px;margin-top: 30px">
            <thead>
            <tr>
                <th><a href="company_pictures" title="点击进入获取原图页">图片数<span style="margin-left: 10px;color: #0074D9;font-size: 10px">详情</span></a></th>
                <th><a href="company_users" title="点击查看详情">用户数<span style="margin-left: 10px;color: #0074D9;font-size: 10px">详情</span></a></th>
                <th><a href="company_deal_success" title="点击查看详情">订单数<span style="margin-left: 10px;color: #0074D9;font-size: 10px">详情</span></a></th>
                <th>收益金额</th>
                <th>返还金额</th>
                <th>净利润</th>
            </tr>

            <tr>
                <th>${pictureCount}</th>
                <th>${userCount}</th>
                <th>${orderCount}</th>
                <th>${priceSum}</th>
                <th>${pricebackSum}</th>
                <th>${proteSum}</th>


            </tr>

            </thead>
        </table>



    </div><!--midCont-->


</div><!--userCenterWrap-->

<%--提交详情表单--%>
<form id="company_deal_edit" method="post">
    <input type="hidden" id="userid" name="id" />
</form>

<script type="text/javascript">

    $(document).ready(function(){

    })
</script>



</body>
</html>