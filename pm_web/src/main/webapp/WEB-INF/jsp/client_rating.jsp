<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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


    <!-- 首页轮播图 -->
    <script src="${pageContext.request.contextPath}/resources/js/jquery.bxslider.min.js"></script>
    <link href="${pageContext.request.contextPath}/resources/css/jquery.bxslider.css" rel="stylesheet"/>
    <!-- 图片放大 -->
    <script src="${pageContext.request.contextPath}/resources/js/viewer.js"></script>
    <link href="${pageContext.request.contextPath}/resources/css/viewer.css" rel="stylesheet"/>
    <script src="${pageContext.request.contextPath}/resources/js/checkbix.min.js"></script>
    <link href="${pageContext.request.contextPath}/resources/css/checkbix.css" rel="stylesheet"/>

    <!-- 首页展示图等高 -->
    <script src="${pageContext.request.contextPath}/resources/js/baguetteBox.min.js"></script>
    <link href="${pageContext.request.contextPath}/resources/css/baguetteBox.min.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/css/fluid-gallery.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/css/gallery-clean.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/css/gallery-grid.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/css/thumbnail-gallery.css" rel="stylesheet"/>

    <!-- 左右滚动 -->
    <script src="${pageContext.request.contextPath}/resources/js/jquery.skidder.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/imagesloaded.js"></script>
    <link href="${pageContext.request.contextPath}/resources/css/jquery.skidder.css" rel="stylesheet"/>


    <link href="${pageContext.request.contextPath}/resources/css/font-awesome.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/awesome-bootstrap-checkbox.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/font.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/css/cont.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/css/layout.css" rel="stylesheet"/>
    <link rel="icon" href="${pageContext.request.contextPath}/resources/images/auction1.ico">
    <title>中国野生动植物影像数据库</title>
</head>
<body>
<%@include file="top.jsp" %>

<div style="height: 250px"></div>

<div class="container gallery-container" style="margin-top: -230px;z-index: 700">
    <h1 class="more_scape">为您推荐</h1>
    <%--<p class="page-description text-center">Clean Layout With Minimal Styles</p>--%>
    <div class="tz-gallery">
        <div class="row">
            <c:forEach items="${fileUpScape}" var="fileUpScape">
                <%--<c:if test="${fileUpScape.indexScape==2}">--%>
                <div class="col-sm-6 col-md-4">
                    <div class="thumbnail">
                        <a href="javascript:void(0);" onclick="imageDetail(this);">
                            <img src="http://${webip}:8084/picture_bed/${fileUpScape.filePathshow}"
                                 id="${fileUpScape.id}" alt="Park">
                        </a>
                        <div class="caption">
                            <h3>${fileUpScape.pictureName}</h3>
                            <p> ${fileUpScape.instruction}</p>
                        </div>
                    </div>
                    <div align="center">
                        <form action="rating" method="post">
                            <div>
                                <input type="hidden" name="userid" value="${user.id}">
                                <input type="hidden" name="pictureid" value="${fileUpScape.id}">
                                <label class="radio-inline">

                                    <input type="radio" name="rating" id="radio1" value="1"
                                           <c:if test="${rate.rating == 1}">checked="checked"</c:if>>1分
                                </label>
                                <label>
                                    <input type="radio" name="rating" id="radio2" value="2"
                                           <c:if test="${rate.rating == 2}">checked="checked"</c:if>>2分
                                </label>
                                <label>
                                    <input type="radio" name="rating" id="radio3" value="3"
                                           <c:if test="${rate.rating == 3}">checked="checked"</c:if>>3分
                                </label>
                                <label>
                                    <input type="radio" name="rating" id="radio4" value="4"
                                           <c:if test="${rate.rating == 4}">checked="checked"</c:if>>4分
                                </label>
                                <label>
                                    <input type="radio" name="rating" id="radio5" value="5"
                                           <c:if test="${rate.rating == 5}">checked="checked"</c:if>>5分
                                </label>
                            </div>
                            <button id="submit_btn" type="submit" class="btn btn-info btn-block">评分</button>
                        </form>
                    </div>
                </div>
                <%--</c:if>--%>
            </c:forEach>

        </div>
    </div>
</div>

<div style="height: 70px"></div>


<div class="container gallery-container" style="margin-top: -100px;">
    <h1 class="more_video">视频推荐</h1>
    <%--<p class="page-description text-center">Clean Layout With Minimal Styles</p>--%>
    <div class="tz-gallery">
        <div class="row">
            <%-- 直接放的视频，要用div包一下--%>
            <c:forEach items="${fileUpVideo}" var="fileUpVideo">
                <a href="javascript:void(0);" onclick="videoDetail(this);">
                    <video width="320" height="240" id="${fileUpVideo.id}" controls>
                        <source src="http://${webip}:8084/picture_bed/${fileUpVideo.filePathshow}" type="video/mp4">
                    </video>
                </a>

            </c:forEach>

            <div style="width: 90px;height: 40px;margin:30px auto;">
                <button class="more_video" class="btn btn-success"
                        style="width:87px;height: 38px;padding: 3px;border-radius: 10%;font-size: 14px">更多视频
                </button>
            </div>

        </div>
    </div>
</div>


<%--&lt;%&ndash;底部div&ndash;%&gt;--%>
<div style="margin-top:30px;width: 100%;height: 120px;background-color: #122b40;">

    <div style="height: 32px"></div>

    <div style="margin:0px auto;width: 1200px;height: 20px;color: #707070;font-size: 16px">

        <a href="logged_index" target="_blank"><span style="color: #707070;font-size: 16px">网站首页</span></a>
        <span style="margin-left: 50px">企业文化</span>
        <span style="margin-left: 50px">联系我们</span>
        <a href="http://www.nrchina.org/" target="_blank"><span
                style="margin-left: 50px;color: #707070;font-size: 16px">友情链接</span></a>
        <span style="margin-left: 280px">公司办公电话:</span>
        <span style="margin-left: 20px">15546508963</span>
        <span style="margin-left: 60px">QQ在线咨询:</span>
        <a href="tencent://message/?uin=2943489668">
            <span style="margin-left: 20px"><img width="24px" height="24px"
                                                 src="${pageContext.request.contextPath}/resources/images/qqchat.png"/></span>
        </a>

    </div>

    <div style="height: 20px"></div>

    <div style="margin:0px auto;width: 1200px;height: 20px;color: #707070;font-size: 16px">

        <span style="margin-left: 706px">公司办公邮箱:</span>
        <span style="margin-left: 30px">2943489668@qq.com</span>

    </div>


</div>


<%--提交详情表单--%>
<form id="indexForm" method="post">
    <input type="hidden" id="indexid" name="id"/>
</form>

<script type="text/javascript">

    function imageDetail(w) {
        var imageId = $(w).children().attr("id");
        $("#indexForm").attr("action", "<%=basePath%>index_detail");
        $("#indexid").attr("value", imageId);
        $("#indexForm").submit();
    }

    function videoDetail(w) {
        var imageId = $(w).children().attr("id");
        $("#indexForm").attr("action", "<%=basePath%>index_video_detail");
        $("#indexid").attr("value", imageId);
        $("#indexForm").submit();
    }

    $(document).ready(function () {

//        $('.slideshow').skidder();

//        //左右滚动
        $('#slideshow1').each(function () {
            var $slideshow = $(this);
            $slideshow.imagesLoaded(function () {

                $slideshow.skidder({

                    autoplay: true,
                    cycle: true,
                    autoplayResume: true,
                    interval: 2000

                });
            });
        });

        $('#slideshow2').each(function () {
            var $slideshow = $(this);
            $slideshow.imagesLoaded(function () {

                $slideshow.skidder({

                    autoplay: true,
                    cycle: true,
                    autoplayResume: true,
                    interval: 1000

                });
            });
        });

        $('#slideshow3').each(function () {
            var $slideshow = $(this);
            $slideshow.imagesLoaded(function () {

                $slideshow.skidder({

                    autoplay: true,
                    cycle: true,
                    autoplayResume: true,
                    interval: 600

                });
            });
        });


        $('.bxslider').bxSlider({
            mode: 'fade', //褪色模式
            auto: "true",
        });

        baguetteBox.run('.tz-gallery');


        $(".more_animal").click(function () {
            $("#serchinput").attr("value", "动物");
            $("#searchTopSearch").submit();
        });

        $(".more_plant").click(function () {
            $("#serchinput").attr("value", "植物");
            $("#searchTopSearch").submit();
        });

        $(".more_scape").click(function () {
            $("#serchinput").attr("value", "风景");
            $("#searchTopSearch").submit();
        });

        $(".more_video").click(function () {
            $("#serchvideoinput").attr("value", "动物");
            $("#searchVideoSearch").submit();
        });


    })

    $(document).ready(function () {

        $("#submit_btn").click(function () {
            $("form").submit();
        });

    })

</script>
</body>
</html>
