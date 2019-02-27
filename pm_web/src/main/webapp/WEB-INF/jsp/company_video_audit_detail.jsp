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
    <title>公司审核详情页</title>
</head>
<body>
<%@include file="top.jsp"%>

<div id="sectionCont">

    <div class="leftNav hidden-xs hidden-sm" style="margin-top: 112px">
        <ul>
            <li class="active"><a href="company_auditing" >待审核</a></li>
            <li><a href="company_posted" >已发布</a></li>
            <li><a href="company_upload" >公司上传</a></li>
            <li ><a href="company_deal" >交易记录</a></li>
            <li><a href="company_data" >控制台</a></li>
            <li><a href="company_news" >信息公告</a></li>
        </ul>
    </div>

</div>
<!--sectionCont-->

<%--<div class="container">--%>

    <div style="margin-left: 160px">


        <div class="row detailPhotoRow">

            <div id="big_pany_audit">
                <div class="col-md-6 detailPhoto">
                    <video width="640" height="480" controls>
                        <source src="http://${webip}:8084/picture_bed/${fileUps.filePath}" type="video/mp4">
                    </video>
                    <hr>
                    <div>
                        <span>视频编号:</span>
                        <span style="margin-left: 10px">${fileUps.id}</span>
                        <span style="margin-left: 380px"><a href="javascript:history.go(-1);">返回上一页</a></span>
                    </div>

                </div>
            </div>

            <div class="col-md-4 detailPhotoDesc">

        <form class="form-horizontal" action="saveCompanyVideoAudit" name="formEdit" method = "post" enctype='multipart/form-data'>
            <input type="hidden" id="userid" name="id" value="${fileUps.id}"/>


                    <div class="scriptionLine">
                        <span class="scriptionLeftSpan"><h5>视频信息</h5></span>
                    </div>
                    <hr>

                    <div class="scriptionLine">
                        <span class="scriptionLeftSpan">视频名</span>
                        <span style="margin-left: 100px">${fileUps.pictureName}</span>
                    </div>

                    <div class="scriptionLine">
                        <span class="scriptionLeftSpan">视频描述</span>
                        <span style="margin-left: 85px">${fileUps.instruction}</span>
                    </div>


                    <div class="scriptionLine">
                        <span class="scriptionLeftSpan" style="font-size: 14px">摄影师</span>
                        <span style="margin-left: 100px">${fileUps.cameraman}</span>
                    </div>

                    <div class="scriptionLine">
                        <span class="scriptionLeftSpan" style="font-size: 14px">版权所有人</span>
                        <span style="margin-left: 75px">${fileUps.owner}</span>
                    </div>

            <div class="scriptionLine">
                <span class="scriptionLeftSpan" style="font-size: 14px">视频分辨率</span>
                <span style="margin-left: 90px">
                             <c:if test="${fileUps.species ==1}">标清720P</c:if>
                            <c:if test="${fileUps.species ==2}">高清1080P</c:if>
                            <c:if test="${fileUps.species ==3}">4K</c:if>
                        </span>

            </div>


            <div class="scriptionLine">
                <span class="scriptionLeftSpan" style="font-size: 14px">关键词</span>
                <span style="margin-left: 100px">${fileUps.myKeywordEntity.keyname}</span>
                <span style="margin-left: 20px">${fileUps.myKeywordEntityc.keyname}</span>
                <span style="margin-left: 20px">${fileUps.keythree}</span>
            </div>

                <hr>

                <div class="scriptionLine">
                    <span class="scriptionLeftSpan" style="font-size: 14px;">退回原因</span>
                    <span>
                     <input type="text" id="reasoniput" value="${fileUps.reason}" name="reason" class="form-control" placeholder="退回原因" style="width: 260px;height: 36px;border: 1px solid #204d74;">
                </span>
                </div>

                <hr>

                <button type="submit" class="btn btn-primary" style="margin-left: 100px">保&nbsp;&nbsp;&nbsp;&nbsp;存</button>

                <hr>

        </form>

                <div class="scriptionLine">
                        <span class="scriptionLeftSpan" style="margin-left: 50px">
                            <button id="editaudit_check" class="btn btn-success" style="width: 150px;padding: 10px;font-size: 16px">审核通过</button>
                        </span>
                        <span class="scriptionLeftSpan" style="margin-left: 50px">
                            <button id="editaudit_uncheck" class="btn btn-danger" style="width: 150px;padding: 10px;font-size: 16px">审核不通过</button>
                        </span>
                </div>

                <hr>



            </div>

        </div>


    </div>


<%--</div>--%>
<!-- container -->


<script type="text/javascript">

    $(document).ready(function(){

        $("#big_pany_audit").viewer();


        $("#editaudit_check").click(function() {

            var fileUpList = [];
            var fileUp={
            "id" : ${fileUps.id},
            "stateId" : "7"
            };
            fileUpList.push(fileUp);

//            alert(fileUpList);

            $.ajax({
                type : 'post',
                url : '<%=basePath%>updateBatch',
                contentType : 'application/json;charset=utf-8',//指定为json类型
                //数据格式是json串,多个对象用[]包装
                data : JSON.stringify(fileUpList),
                success : function(data) {
                    console.log(data.toString());
//                        alert("批量修改成功");
                    location.href = "<%=basePath%>company_video_audited";
                },
                error : function() {
//                        alert("失败");
                }
            });

        });

        $("#editaudit_uncheck").click(function() {

            var reasoniput = $("#reasoniput").val();

            if(reasoniput==""){
                alert("请输入退回原因");
            }else{


                var fileUpList = [];
                var fileUp={
                    "id" : ${fileUps.id},
                    "stateId" : "8"
                };
                fileUpList.push(fileUp);

//            alert(fileUpList);

                $.ajax({
                    type : 'post',
                    url : '<%=basePath%>updateBatch',
                    contentType : 'application/json;charset=utf-8',//指定为json类型
                    //数据格式是json串,多个对象用[]包装
                    data : JSON.stringify(fileUpList),
                    success : function(data) {
                        console.log(data.toString());
//                        alert("批量修改成功");
                        location.href = "<%=basePath%>company_video_unaudited";

                    },
                    error : function() {
//                        alert("失败");
                    }
                });

            }

        });




    })
</script>

</body>
</html>
