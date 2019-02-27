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
    <title>交易记录</title>
</head>
<body>
<%@include file="top.jsp"%>

<div id="sectionCont" >

    <div class="leftNav hidden-xs hidden-sm" style="margin-top: 112px">
        <ul>
            <li ><a href="client_mark">我的收藏</a></li>
            <li><a href="client_shoping">购物车</a></li>
            <li><a href="client_upload">用户上传</a></li>
            <li><a href="client_auditing">审核结果</a></li>
            <li class="active"><a href="client_deal">交易记录</a></li>
            <li ><a href="client_setting">个人信息</a></li>
        </ul>
    </div>

</div>
<!--sectionCont-->

<div style="margin-left: 120px">

    <div class="container">

        <div class="detailWrap">

            <div class="row detailPhotoRow">

                <div class="col-md-3 detailPhoto">
                    <img src="http://localhost:8084/picture_bed/${fileshowori}" alt="">
                </div>

                <div class="col-md-9 detailPhoto">

                    <div class="scriptionLine">
                        <span class="scriptionLeftSpan"><h5>订单详情</h5></span>
                    </div>
                    <hr>

                    <form class="form-horizontal" action="saveClientPay" name="formEdit" method = "post" enctype='multipart/form-data'>
                        <input type="hidden" name="id" value="${fileUps.id}"/>

                        <div class="scriptionLine">
                        <span style="margin-left: 80px;margin-top: 20px">公司付款状态</span>
                        <span style="margin-left: 30px">
                             <label class="radio-inline">
                                <input type="radio" name="companyState" id="dealRadio1" value="1" <c:if test="${fileUps.companyState == 1}">checked="checked"</c:if>> 未付款&nbsp;&nbsp;&nbsp;&nbsp;
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="companyState" id="dealRadio2" value="2" <c:if test="${fileUps.companyState == 2}">checked="checked"</c:if>> 已付款&nbsp;&nbsp;&nbsp;&nbsp;
                            </label>
                        </span>
                        <span style="margin-left: 30px;margin-top: 20px">用户确认状态</span>
                            <span style="margin-left: 30px">
                             <label class="radio-inline">
                                <input type="radio" name="clientState" id="dealRadio3" value="1" <c:if test="${fileUps.clientState == 1}">checked="checked"</c:if>> 未确认&nbsp;&nbsp;&nbsp;&nbsp;
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="clientState" id="dealRadio4" value="2" <c:if test="${fileUps.clientState == 2}">checked="checked"</c:if>> 已确认&nbsp;&nbsp;&nbsp;&nbsp;
                            </label>
                        </span>
                    </div>
                    <br>




                    <div class="scriptionLine">
                        <span style="margin-left: 80px">图片版权模式</span>
                        <span style="margin-left: 60px">
                        <c:if test="${fileUps.ofileUpEntity.mode == 1}">免版税模式RF</c:if>
                        <c:if test="${fileUps.ofileUpEntity.mode ==2}">版权管理模式RM</c:if>
                        </span>
                        <span style="margin-left: 80px">图片用途</span>
                        <span style="margin-left: 20px">
                             <c:if test="${fileUps.application =='1'}">小尺寸&nbsp;&nbsp;&nbsp;&nbsp;${imgsmallwidth} × ${imgsmallheight} px</c:if>
                             <c:if test="${fileUps.application =='2'}">中尺寸&nbsp;&nbsp;&nbsp;&nbsp;${imgmidwidth} × ${imgmidheight} px</c:if>
                             <c:if test="${fileUps.application =='3'}">大尺寸&nbsp;&nbsp;&nbsp;&nbsp;${imgbigwidth} × ${imgbigheight} px</c:if>
                             <c:if test="${fileUps.application =='4'}">原图&nbsp;&nbsp;&nbsp;&nbsp;${imgwidth} × ${imgheight}px</c:if>
                            <c:if test="${fileUps.application =='5'}">网络用途&nbsp;&nbsp;微博/微信/App</c:if>
                            <c:if test="${fileUps.application =='6'}">网络用途&nbsp;&nbsp;网站</c:if>
                            <c:if test="${fileUps.application =='7'}">出版用途&nbsp;&nbsp;小尺寸</c:if>
                            <c:if test="${fileUps.application =='8'}">出版用途&nbsp;&nbsp;中尺寸</c:if>
                            <c:if test="${fileUps.application =='9'}">广告用途&nbsp;&nbsp;单一媒体发布</c:if>
                            <c:if test="${fileUps.application =='10'}">广告用途&nbsp;&nbsp;三种媒体发布</c:if>
                             <c:if test="${fileUps.application =='11'}">线下物料&nbsp;&nbsp;中尺寸</c:if>
                            <c:if test="${fileUps.application =='12'}">线下物料&nbsp;&nbsp;大尺寸</c:if>
                        </span>
                    </div>

                        <br>
                        <div class="scriptionLine">
                            <span style="margin-left: 80px">版权使用开始时间</span>
                            <span style="margin-left: 60px">
                             <fmt:formatDate value="${fileUps.startTime}" type="both" dateStyle="long" />
                        </span>
                            <span style="margin-left: 100px">版权使用结束时间</span>
                            <span style="margin-left: 50px">
                             <fmt:formatDate value="${fileUps.endTime}" type="both" dateStyle="long" />
                        </span>
                        </div>
                        <br>

                    <hr>

                        <div class="scriptionLine">
                            <span class="scriptionLeftSpan"><h5>付款信息</h5></span>
                        </div>

                        <hr>

                        <br>

                        <div class="scriptionLine">
                            <span>用户电话</span>
                            <span style="margin-left: 60px">${fileUps.upuserEntity.telephone}</span>
                            <span style="margin-left: 100px">用户邮箱</span>
                            <span style="margin-left: 50px">${fileUps.upuserEntity.email}</span>
                        </div>

                        <br>
                        <div class="scriptionLine">
                            <span class="scriptionLeftSpan" style="font-size: 14px">用户账号</span>
                            <span>
                                <input type="text" name="clientAccount" value="${fileUps.clientAccount}" class="form-control" placeholder="用户账号" style="width: 260px;height: 36px;border: 1px solid #204d74;">
                            </span>
                        </div>
                        <br>

                        <div class="scriptionLine">
                            <span>版权使用者付款金额</span>
                            <span style="margin-left: 50px">${fileUps.price}</span>
                        </div>

                        <br>

                        <div class="scriptionLine">
                            <span>公司电话</span>
                            <span style="margin-left: 60px">15546508963</span>
                            <span style="margin-left: 100px">公司邮箱</span>
                            <span style="margin-left: 50px">2943489668@qq.com</span>
                        </div>

                        <br>
                        <div class="scriptionLine">
                            <span class="scriptionLeftSpan" style="font-size: 14px">公司账号</span>
                            <span style="margin-left: 50px">${fileUps.companyAccount}</span>
                        </div>
                        <br>

                        <hr>

                        <div style="width: 300px;height: 50px;margin:0px auto;">
                            <button type="submit" class="btn btn-primary">保&nbsp;&nbsp;&nbsp;&nbsp;存</button>
                        </div>

                        <hr>
                        <br>

                    </form>

                </div>
                <!-- row col-md-9 -->
            </div>
            <!-- row detail -->

        </div>
        <!-- detailWrap -->

    </div>
    <!-- container -->

</div>
<!--sectionCont-->



<script type="text/javascript">

    $(document).ready(function(){

        $(".container").viewer();



    })

</script>

</body>
</html>