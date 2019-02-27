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


    <link href="${pageContext.request.contextPath}/resources/css/font-awesome.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/awesome-bootstrap-checkbox.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/font.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/css/cont.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/css/layout.css" rel="stylesheet" />


    <!-- 模态框 -->
    <script src="${pageContext.request.contextPath}/resources/js/MODALit.min.js"></script>
    <link href="${pageContext.request.contextPath}/resources/css/MODALit.min.css" rel="stylesheet" />


    <script src="${pageContext.request.contextPath}/resources/js/jquery.cookie.js"></script>
    <link href="${pageContext.request.contextPath}/resources/css/font-awesome.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/awesome-bootstrap-checkbox.css" rel="stylesheet">
    <link rel="icon" href="${pageContext.request.contextPath}/resources/images/auction1.ico">
    <title>注册页</title>
</head>
<body>
<%@include file="WEB-INF/jsp/top.jsp"%>

<div style="width: 420px;height: 300px;margin:60px auto;">
    <div style="margin-left: 180px;margin-bottom: 20px;"><h4>注册帐号</h4></div>
    <form action="registerForm" method="post">
        <input type="hidden" name="admin" value="1"/>

        <div class="form-group">
            <%--<label for="login_username" style="margin-left: 180px;margin-bottom: 10px;font-size: 15px">用&nbsp;户&nbsp;名</label>--%>



                <div class="col-sm-9">
                    <input type="text" class="form-control" id="nickname" placeholder="昵称 (不为空)" name="nickname" style="border: 1px solid #bfbfbf;margin-bottom: 20px">
                </div>
                <div class="col-sm-3">
                    <img id="nickimg" src="${pageContext.request.contextPath}/resources/images/right.png" style="display: none;margin-left: 36px;margin-top: 16px;width: 24px;height: 24px">
                </div>

        </div>
        <div class="form-group">
            <%--<label for="login_username" style="margin-left: 180px;margin-bottom: 10px;font-size: 15px">用&nbsp;户&nbsp;名</label>--%>

                <div class="col-sm-9">
                    <input type="text" class="form-control" id="email" placeholder="邮箱 (用于找回密码)" name="email" style="border: 1px solid #bfbfbf;margin-bottom: 20px">
                </div>
                <div class="col-sm-3">
                    <img id="emailimg" src="${pageContext.request.contextPath}/resources/images/right.png" style="display: none;margin-left: 36px;margin-top: 16px;width: 24px;height: 24px">
                </div>

        </div>
        <div class="form-group">
            <%--<label for="login_username" style="margin-left: 180px;margin-bottom: 10px;font-size: 15px">用&nbsp;户&nbsp;名</label>--%>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="login_username" placeholder="用户名 (用于登陆)" name="username" style="border: 1px solid #bfbfbf;margin-bottom: 20px">
                </div>
                <div class="col-sm-3">
                    <img id="usernameimg" src="${pageContext.request.contextPath}/resources/images/right.png" style="display: none;margin-left: 36px;margin-top: 16px;width: 24px;height: 24px">
                    <div id="usertext" style="display: none;margin-top: 16px;">用户已存在</div>
                </div>

        </div>
        <div class="form-group">
            <%--<label for="login_password" style="margin-left: 180px;margin-bottom: 10px;font-size: 15px">密&nbsp;&nbsp;码</label>--%>
                <div class="col-sm-7">
                    <input type="password" class="form-control" id="login_password" placeholder="密码 (至少六位)" name="password" style="border: 1px solid #bfbfbf;">
                </div>
                <div class="col-sm-2">
                    <img id="eye" src="${pageContext.request.contextPath}/resources/images/eye.png" style="margin-top: 16px;width: 30px;height: 30px">
                </div>
                <div class="col-sm-2">
                    <img id="passimg" src="${pageContext.request.contextPath}/resources/images/right.png" style="display: none;margin-left: 36px;margin-top: 16px;width: 24px;height: 24px">
                </div>

        </div>
        <div class="form-group">
            <button id="submit_button" type="submit" disabled="disabled" data-target="#modal" class="btn btn-warning btn-block"
                    style="margin-top: 20px;margin-left: 100px ;font-size: 16px;width: 500px">注&nbsp;&nbsp;&nbsp;&nbsp;册</button>
        </div>
    </form>
</div>





<%--<!-- Sets modal target -->--%>
<%--<button type="button" id="button" data-target="#modal">Modal Open</button>--%>

<div id="modal" class="modalit" aria-hidden="true">
    <div class="dialog">
        <header>
            <h3>注册成功</h3>
        </header>
        <div class="content">
            <p>即将跳转登陆页</p>
        </div>
        <%--<footer>--%>
            <%--<button type="button" data-modal-btn="dismiss" class="btn primary"><a href="login">确认</a>></button>--%>
        <%--</footer>--%>
    </div>
</div>



<script type="text/javascript">

    var modal = new MODALit({
        el: '#submit_button',
        position: 'bottom right'
    });

    $(document).ready(function(){


        $("#nickname").keyup(function() {

            var nick = $("#nickname").val();
            if (nick.length!=0) {
                $("#nickimg").show();
            }else{
                $("#nickimg").hide();
            }

            var nickdisplay = $("#nickimg").css("display");
            var emaildisplay = $("#emailimg").css("display");
            var usernamedisplay = $("#usernameimg").css("display");
            var passdisplay = $("#passimg").css("display");

            if (nickdisplay!="none" && emaildisplay!="none" && usernamedisplay!="none" && passdisplay!="none") {
                $("#submit_button").removeAttr("disabled");
            }

        })

        $("#email").keyup(function() {
            var email = $("#email").val();
            var isEmail = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
            if (!(isEmail.test(email))) {
                $("#emailimg").hide();
            }else{
                $("#emailimg").show();
            }

            var nickdisplay = $("#nickimg").css("display");
            var emaildisplay = $("#emailimg").css("display");
            var usernamedisplay = $("#usernameimg").css("display");
            var passdisplay = $("#passimg").css("display");

            if (nickdisplay!="none" && emaildisplay!="none" && usernamedisplay!="none" && passdisplay!="none") {
                $("#submit_button").removeAttr("disabled");
            }

        })


        $("#login_username").keyup(function() {
            var username = $("#login_username").val();

            $.ajax({
                type : 'post',
                url : '<%=basePath%>checkName',
                contentType : 'application/json;charset=utf-8',//指定为json类型
                //数据格式是json串,多个对象用[]包装
                data : JSON.stringify(username),
                success : function(data) {
                    console.log(data.toString());

                    if(username.length>0){
                        if(data=="notuser"){
                            $("#usernameimg").show();
                            $("#usertext").hide();
                        }else if(data=="isuser"){
                            $("#usernameimg").hide();
                            $("#usertext").show();
                        }
                    }else{
                        $("#usernameimg").hide();
                    }

                },

            });

            var nickdisplay = $("#nickimg").css("display");
            var emaildisplay = $("#emailimg").css("display");
            var usernamedisplay = $("#usernameimg").css("display");
            var passdisplay = $("#passimg").css("display");

            if (nickdisplay!="none" && emaildisplay!="none" && usernamedisplay!="none" && passdisplay!="none") {
                $("#submit_button").removeAttr("disabled");
            }


        })


        $("#login_password").keyup(function() {
            var password = $("#login_password").val();
            if (password.length>=6) {
                $("#passimg").show();
            }else{
                $("#passimg").hide();
            }


            var nickdisplay = $("#nickimg").css("display");
            var emaildisplay = $("#emailimg").css("display");
            var usernamedisplay = $("#usernameimg").css("display");
            var passdisplay = $("#passimg").css("display");

            if (nickdisplay!="none" && emaildisplay!="none" && usernamedisplay!="none" && passdisplay!="none") {
                $("#submit_button").removeAttr("disabled");
            }


        })

        $("#eye").click(function() {
            var istype = $("#login_password").attr("type");
            if(istype == "password"){
                $("#login_password").attr("type","text");
            }else{
                $("#login_password").attr("type","password");
            }

        })


    })
</script>
</body>
</html>