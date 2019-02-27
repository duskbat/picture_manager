<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
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


    <!-- 邮箱找回密码 -->
    <script src="${pageContext.request.contextPath}/resources/js/jquery.validate.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-confirm.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/common.js"></script>


    <link href="${pageContext.request.contextPath}/resources/css/font-awesome.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/awesome-bootstrap-checkbox.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/font.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/css/cont.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/css/layout.css" rel="stylesheet" />


    <script src="resources/js/jquery.cookie.js"></script>
    <link href="resources/css/font-awesome.css" rel="stylesheet">
    <link href="resources/css/awesome-bootstrap-checkbox.css" rel="stylesheet">

    <link rel="icon" href="resources/images/auction1.ico">
    <title>登录页</title>
</head>
<body>
<%@include file="WEB-INF/jsp/top.jsp"%>

<div style="width: 420px;height: 300px;margin:80px auto;">
    <div style="margin-left: 180px;margin-bottom: 20px;"><h4>重置密码</h4></div>
    <form action="resetPass" method="post">
        <input type="hidden" name="email" value="${email}"/>
        <input type="hidden" name="captcha" value="${captcha}"/>

        <div class="form-group">
            <%--<label for="login_username" style="margin-left: 180px;margin-bottom: 10px;font-size: 15px">用&nbsp;户&nbsp;名</label>--%>
            <input type="password" class="form-control"  placeholder="请输入新密码" name="password" style="border: 1px solid #bfbfbf;margin-bottom: 20px">
        </div>
        <div class="form-group">
            <%--<label for="login_password" style="margin-left: 180px;margin-bottom: 10px;font-size: 15px">密&nbsp;&nbsp;码</label>--%>
            <input type="password" class="form-control"  placeholder="再次输入新密码" name="passwordAgain" style="border: 1px solid #bfbfbf;">
        </div>
        <div class="form-group">
            <button id="submit_button" type="submit" class="btn btn-info btn-block"
                    style="margin-top: 10px;margin-left: 100px ;font-size: 16px;width: 500px">提&nbsp;&nbsp;&nbsp;&nbsp;交</button>
        </div>
    </form>
</div>

<script type="text/javascript">
    $(document).ready(function(){

//        $("#submit_button").click(function(){
//            $("form").submit();
//        });

    })
</script>
</body>
</html>