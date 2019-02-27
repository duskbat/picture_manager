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
    <title>图片编辑页</title>
</head>
<body>
<%@include file="top.jsp"%>


<div id="sectionCont">

    <div class="leftNav hidden-xs hidden-sm" style="margin-top: 112px">
        <ul>
            <li><a href="company_auditing" >待审核</a></li>
            <li><a href="company_posted" >已发布</a></li>
            <li class="active"><a href="company_upload" >公司上传</a></li>
            <li ><a href="company_deal" >交易记录</a></li>
            <li><a href="company_data" >控制台</a></li>
            <li><a href="company_news" >信息公告</a></li>
        </ul>
    </div>

</div>
<!--sectionCont-->

<div style="margin-left: 160px">

    <form class="form-horizontal" action="saveCompanyVideoDetail" name="formEdit" method = "post" enctype='multipart/form-data'>
        <input type="hidden" id="userid" name="id" value="${fileUps.id}"/>
        <input type="hidden" name="reason" value="${fileUps.reason}"/>

        <div class="row detailPhotoRow">

            <div id="big_pany_detail">
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

                <div class="scriptionLine">
                    <span class="scriptionLeftSpan"><h5>视频信息</h5></span>
                </div>
                <hr>

                <div class="scriptionLine">
                    <span class="scriptionLeftSpan" style="font-size: 14px">视频名</span>
                    <span>
                        <input type="text" value="${fileUps.pictureName}" name="pictureName" class="form-control" placeholder="视频名" style="width: 260px;height: 36px;border: 1px solid #204d74;">
                    </span>
                </div>
                <hr>

                <div class="scriptionLine">
                    <span class="scriptionLeftSpan" style="font-size: 14px">视频描述</span>
                    <span>
                        <input type="textarea" height="60px" value="${fileUps.instruction}" name="instruction" class="form-control" placeholder="视频描述" style="width: 260px;height: 36px;border: 1px solid #204d74;">
                    </span>
                </div>
                <hr>


                <div class="scriptionLine">
                    <span class="scriptionLeftSpan" style="font-size: 14px">摄影师</span>
                    <span>
                     <input type="text" value="${fileUps.cameraman}" name="cameraman" class="form-control" placeholder="摄影师" style="width: 260px;height: 36px;border: 1px solid #204d74;">
                </span>
                </div>
                <hr>

                <div class="scriptionLine">
                    <span class="scriptionLeftSpan" style="font-size: 14px">版权所有人&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;姓名/公司名称</span>
                    <span>
                        <input type="text" value="${fileUps.owner}" name="owner" class="form-control" placeholder="姓名/公司名称" style="width: 260px;height: 36px;border: 1px solid #204d74;">
                    </span>
                </div>
                <hr>


                <div class="scriptionLine">
                    <span class="scriptionLeftSpan" style="font-size: 14px">版权所有人&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;身份证号/公司注册号</span>
                    <span>
                     <input type="text" value="${fileUps.ownerNumber}" name="ownerNumber" class="form-control" placeholder="身份证号/公司注册号" style="width: 260px;height: 36px;border: 1px solid #204d74;">
                </span>
                </div>

                <hr>

                <span class="scriptionLeftSpan">视频方向&nbsp;&nbsp;&nbsp;&nbsp;</span>
                <div class="scriptionLine">
                    <span class="scriptionLeftSpan">
                              <label class="radio-inline">
                                <input type="radio" name="direction" id="inlineRadio3" value="1" <c:if test="${fileUps.direction == 1}">checked="checked"</c:if>> 水平&nbsp;&nbsp;&nbsp;&nbsp;
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="direction" id="inlineRadio4" value="2" <c:if test="${fileUps.direction == 2}">checked="checked"</c:if>> 竖直&nbsp;&nbsp;&nbsp;&nbsp;
                            </label>
                        </span>
                </div>
                <br>


                <span class="scriptionLeftSpan">视频分辨率&nbsp;&nbsp;&nbsp;&nbsp;</span>
                <div class="scriptionLine">
                    <span class="scriptionLeftSpan">
                              <label class="radio-inline">
                                <input type="radio" name="species" id="inlineRadio5" value="1" <c:if test="${fileUps.species == 1}">checked="checked"</c:if>> 标清720P&nbsp;&nbsp;&nbsp;&nbsp;
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="species" id="inlineRadio6" value="2" <c:if test="${fileUps.species == 2}">checked="checked"</c:if>> 高清1080P&nbsp;&nbsp;&nbsp;&nbsp;
                            </label>
                        <label class="radio-inline">
                                <input type="radio" name="species" id="inlineRadio7" value="3" <c:if test="${fileUps.species == 3}">checked="checked"</c:if>>4K&nbsp;&nbsp;&nbsp;&nbsp;
                            </label>
                        </span>
                </div>
                <br>

                <hr>
                <div>关键词</div>
                <br>

                <span style="color: #0074D9">请从词库中选择关键词</span>
                <br>

                <select id="keyone_select" class="form-control" value="${fileUps.keyone}" data-style="btn-primary" name="keyone" style="width: 260px;height: 36px;border: 1px solid #204d74;" >
                    <c:forEach items="${myKeywords}" var="myKeyword" varStatus="i">
                        <option value="${myKeyword.id}" >${myKeyword.keyname}</option>
                    </c:forEach>
                </select>

                <br>

                <span style="color: #0074D9">请从词库中选择关键词</span>
                <br>


                <select id="keytwo_select" class="form-control" value="${fileUps.keytwo}" data-style="btn-primary" name="keytwo" style="width: 260px;height: 36px;border: 1px solid #204d74;">
                    <c:forEach items="${myKeywords}" var="myKeyword" varStatus="i">
                        <option value="${myKeyword.id}" >${myKeyword.keyname}</option>
                    </c:forEach>
                </select>

                <br>

                <span>用户自定关键词</span>
                <br>

                <input type="text" value="${fileUps.keythree}" name="keythree" class="form-control" placeholder="用户自定关键词" style="width: 260px;height: 36px;border: 1px solid #204d74;">

                <hr>

                <div class="scriptionLine">
                    <span class="scriptionLeftSpan"><h5>用户自定视频价格(RMB)</h5></span>
                </div>
                <hr>

                <div class="scriptionLine">
                    <span class="scriptionLeftSpan" style="font-size: 14px">视频价格</span>
                    <span>
                        <input type="text" value="${fileUps.pathPrice}" name="pathPrice" class="form-control" placeholder="原图价格" style="width: 260px;height: 36px;border: 1px solid #204d74;">
                    </span>
                </div>



                <hr>
                <button type="submit" class="btn btn-primary">保&nbsp;&nbsp;&nbsp;&nbsp;存</button>

                <hr>

            </div>

        </div>


    </form>

</div>
<!-- container -->



<script type="text/javascript">

    $(document).ready(function(){

        $("#big_pany_detail").viewer();

        $("#hideShow_pany_detail").click(function(){
            $("#hideShow_pany_detail_content").toggle();
        });

        $("#keyone_select  option[value='${fileUps.keyone}'] ").attr("selected",true)
        $("#keytwo_select  option[value='${fileUps.keytwo}'] ").attr("selected",true)

    })
</script>

</body>
</html>
