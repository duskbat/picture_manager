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
    <div style="margin-left: 160px;margin-bottom: 20px;"><h4>找回密码</h4></div>
    <form action="submitCaptcha" method="post">
        <div class="form-group">
            <%--<label for="login_username" style="margin-left: 180px;margin-bottom: 10px;font-size: 15px">用&nbsp;户&nbsp;名</label>--%>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="email" placeholder="邮箱" name="email" style="border: 1px solid #bfbfbf;margin-bottom: 20px">
                </div>
                <div class="col-sm-3">
                    <input type="button" disabled="disabled" class="btn btn-warning btn-block bt" style="font-size: 13px;padding: 2px" value="获取验证码" onclick="submitEmail();">
                </div>
        </div>
        <div class="form-group">
            <%--<label for="login_password" style="margin-left: 180px;margin-bottom: 10px;font-size: 15px">密&nbsp;&nbsp;码</label>--%>
                <div class="col-sm-9">
            <input type="password"  class="form-control" id="captcha" placeholder="请输入验证码" name="captcha" style="border: 1px solid #bfbfbf;">
                </div>
        </div>
        <div class="form-group">
            <button id="submit_button" disabled="disabled" type="submit" class="btn btn-info btn-block"
                    style="margin-top: 20px;margin-left: 90px ;font-size: 16px;width: 500px">验&nbsp;&nbsp;&nbsp;&nbsp;证</button>
        </div>
    </form>
</div>

<script type="text/javascript">

    function submitEmail(){
        var email = $('#email').val();

        //改为ajax提交邮箱
        if(email!=null&&email!=''){

            $.ajax({
                type : 'post',
                url : '<%=basePath%>sendEmail',
                contentType : 'application/json;charset=utf-8',//指定为json类型
                //数据格式是json串,多个对象用[]包装
                data : JSON.stringify(email),
                success : function(data) {
                    console.log(data.toString());
//                    alert('验证码已发送到邮箱，请注意查收');
                },
                error : function() {
                    alert('验证码发送失败：'+data.message);
                }

            });

        }
    }

    $(document).ready(function(){

//        $("#email").keyup(function() {
//
//            var email = $("#email").val();
//            var isEmail = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
//            if (!(isEmail.test(email))) {
//
//            }else{
//                $(".bt").removeAttr("disabled");
//            }
//
//        })


//        $("#captcha").keyup(function() {
//            var captcha = $("#captcha").val();
//            if (captcha.length==4) {
//                $("#submit_button").removeAttr("disabled");
//            }else{
//
//            }
//
//        })



    })
</script>
</body>
</html>