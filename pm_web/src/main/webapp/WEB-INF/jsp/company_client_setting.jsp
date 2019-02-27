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

    <!-- 进度条 -->
    <script src="${pageContext.request.contextPath}/resources/js/jquery.lineProgressbar.js"></script>
    <link href="${pageContext.request.contextPath}/resources/css/jquery.lineProgressbar.css" rel="stylesheet" />


    <link href="${pageContext.request.contextPath}/resources/css/font-awesome.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/awesome-bootstrap-checkbox.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/font.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/css/cont.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/css/layout.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/css/nav.css" rel="stylesheet" />
    <link rel="icon" href="${pageContext.request.contextPath}/resources/images/auction1.ico">
    <title>用户详情页</title>
</head>
<%@include file="top.jsp"%>


<div class="userCenterWrap" items="${users}" var="users">
    <div class="leftNav hidden-xs hidden-sm">
        <ul>
            <li ><a href="client_mark">我的收藏</a></li>
            <li><a href="client_shoping">购物车</a></li>
            <li><a href="client_upload">用户上传</a></li>
            <li><a href="client_auditing">审核结果</a></li>
            <li><a href="client_deal">交易记录</a></li>
            <li class="active"><a href="client_setting">个人信息</a></li>
        </ul>
    </div>

    <form class="form-horizontal" action="saveCompanyClientSet" name="formEdit" method = "post" enctype='multipart/form-data'>
        <input type="hidden" id="userid" name="id" value="${users.id}"/>

    <div style="width: 1000px;height: 1000px;margin:10px auto;" >

        <span>当前页面:</span>
        <span style="color: #0074D9">用户详情页</span>

        <div style="width: 300px;height: 50px;margin:0px auto;">
            <button id="saveset" type="submit" class="btn btn-primary">保&nbsp;&nbsp;&nbsp;&nbsp;存</button>
        </div>

        <div>
            <a href="javascript:history.go(-1);"><span style="color: #0074D9">返回上一页</span></a>
        </div>

        <hr>

        <div class="scriptionLine">
            <span class="scriptionLeftSpan" style="font-size: 14px">昵称</span>
            <span>
            <input type="text" value="${users.nickname}" name="nickname" class="form-control"  disabled style="width: 260px;height: 36px;border: 1px solid #204d74;">
            </span>
        </div>

        <div class="scriptionLine">
            <span class="scriptionLeftSpan" style="font-size: 14px">用户名</span>
            <span>
            <input type="text" value="${users.username}" name="username"  class="form-control" disabled style="width: 260px;height: 36px;border: 1px solid #204d74;">
            </span>
        </div>

        <div class="scriptionLine">
            <span class="scriptionLeftSpan" style="font-size: 14px">密码</span>
            <span>
            <input type="text" value="${users.password}" name="password" class="form-control" disabled style="width: 260px;height: 36px;border: 1px solid #204d74;">
            </span>
        </div>

        <hr>
        <div class="scriptionLine">
            <span class="scriptionLeftSpan"><h5>联系方式</h5></span>
        </div>

        <hr>

        <div class="scriptionLine">
            <span class="scriptionLeftSpan" style="font-size: 14px">邮箱</span>
            <span>
            <input type="text" value="${users.email}" name="email" class="form-control" disabled style="width: 260px;height: 36px;border: 1px solid #204d74;">
            </span>
        </div>

        <div class="scriptionLine">
            <span class="scriptionLeftSpan" style="font-size: 14px;color: #0074D9">支付宝账号</span>
            <span>
            <input type="text" value="${users.paycode}" name="paycode" class="form-control" disabled style="width: 260px;height: 36px;border: 1px solid #204d74;">
            </span>
        </div>

        <div class="scriptionLine">
            <span class="scriptionLeftSpan" style="font-size: 14px">QQ</span>
            <span>
            <input type="text" value="${users.qq}" name="qq" class="form-control" disabled style="width: 260px;height: 36px;border: 1px solid #204d74;">
            </span>
        </div>

        <div class="scriptionLine">
            <span class="scriptionLeftSpan" style="font-size: 14px">微信</span>
            <span>
            <input type="text" value="${users.wechat}" name="wechat" class="form-control" disabled style="width: 260px;height: 36px;border: 1px solid #204d74;">
            </span>
        </div>

        <div class="scriptionLine">
            <span class="scriptionLeftSpan" style="font-size: 14px">手机号</span>
            <span>
            <input type="text" value="${users.telephone}" name="telephone" class="form-control" disabled style="width: 260px;height: 36px;border: 1px solid #204d74;">
            </span>
        </div>

        <div class="scriptionLine">
            <span class="scriptionLeftSpan" style="font-size: 14px">邮寄地址</span>
            <span>
            <input type="text" value="${users.adress}" name="adress" class="form-control" disabled style="width: 260px;height: 36px;border: 1px solid #204d74;">
            </span>
        </div>

        <hr>

        <div class="scriptionLine">
            <span class="scriptionLeftSpan"><h5>实名认证</h5></span>
        </div>

        <hr>

        <div class="scriptionLine">
            <span class="scriptionLeftSpan" style="font-size: 14px">真实姓名</span>
            <span>
            <input type="text" value="${users.realname}" name="realname" class="form-control" style="width: 260px;height: 36px;border: 1px solid #204d74;">
            </span>
        </div>

        <div class="scriptionLine">
            <span class="scriptionLeftSpan" style="font-size: 14px">身份证号</span>
            <span>
            <input type="text" value="${users.idcard}" name="idcard" class="form-control" placeholder="" style="width: 260px;height: 36px;border: 1px solid #204d74;">
            </span>
        </div>

        <div style="width: 300px;height: 120px;margin:10px auto;">
                <c:forEach items="${pageInfo.list}" var="picture">
                    <img src="http://${webip}:8084/picture_bed/${picture.filePath}" id="${picture.id}" class="pictures">
                </c:forEach>
        </div>
        <br>
        <br>
        <br>
        <br>

        <hr>

        <div class="scriptionLine">
            <span class="scriptionLeftSpan"><h5>公司信息</h5></span>
        </div>

        <hr>

        <div class="scriptionLine">
            <span class="scriptionLeftSpan" style="font-size: 14px">公司名称</span>
            <span>
            <input type="text" value="${users.company}" name="company" class="form-control" disabled style="width: 260px;height: 36px;border: 1px solid #204d74;">
            </span>
        </div>

        <div class="scriptionLine">
            <span class="scriptionLeftSpan" style="font-size: 14px">办公电话</span>
            <span>
            <input type="text" value="${users.workphone}" name="workphone" class="form-control" disabled placeholder="" style="width: 260px;height: 36px;border: 1px solid #204d74;">
            </span>
        </div>

        <hr>

        <br>
        <br>
        <br>

    </div>

    </form>


</div><!--userCenterWrap-->

<script type="text/javascript">

    $(document).ready(function(){

        $("#saveset").click(function() {
            alert("保存成功");
        });


        // 创建一个上传参数变量
        var uploadOption =
            {
                action: "fileIdcard",    // 提交目标

                name: "idcards",            // 服务端接收的名称

                dataType: "json",

                autoSubmit: true,        // 是否自动提交


                // 开始上传文件
                onSubmit: function (file, extension)
                {
                    $('#progressbar10').LineProgressbar({
                        percentage : 100,
                        duration : 20000
                    });
                },

                // 上传完成之后
                onComplete: function (file, response)
                {
                    window.location.reload();
                }
            };

        // 实例化上传对象
        new AjaxUpload("#client_idcard_upload", uploadOption);



    })
</script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/ajax_upload.js"></script>
</body>
</html>