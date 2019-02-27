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


    <!-- 首页轮播图 -->
    <script src="${pageContext.request.contextPath}/resources/js/jquery.bxslider.min.js"></script>
    <link href="${pageContext.request.contextPath}/resources/css/jquery.bxslider.css" rel="stylesheet" />
    <!-- 图片放大 -->
    <script src="${pageContext.request.contextPath}/resources/js/viewer.js"></script>
    <link href="${pageContext.request.contextPath}/resources/css/viewer.css" rel="stylesheet" />
    <script src="${pageContext.request.contextPath}/resources/js/checkbix.min.js"></script>
    <link href="${pageContext.request.contextPath}/resources/css/checkbix.css" rel="stylesheet" />

    <!-- 首页展示图等高 -->
    <script src="${pageContext.request.contextPath}/resources/js/baguetteBox.min.js"></script>
    <link href="${pageContext.request.contextPath}/resources/css/baguetteBox.min.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/css/fluid-gallery.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/css/gallery-clean.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/css/gallery-grid.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/css/thumbnail-gallery.css" rel="stylesheet" />

    <!-- 左右滚动 -->
    <script src="${pageContext.request.contextPath}/resources/js/jquery.skidder.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/imagesloaded.js"></script>
    <link href="${pageContext.request.contextPath}/resources/css/jquery.skidder.css" rel="stylesheet" />


    <link href="${pageContext.request.contextPath}/resources/css/font-awesome.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/awesome-bootstrap-checkbox.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/font.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/css/cont.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/css/layout.css" rel="stylesheet" />
    <link rel="icon" href="${pageContext.request.contextPath}/resources/images/auction1.ico">
    <title>中国野生动植物影像数据库</title>
</head>
<body>
<%@include file="WEB-INF/jsp/top.jsp"%>

<%--轮播图--%>
<%--<ul class="bxslider">--%>
    <%--<c:forEach items="${fileUpSlide}" var="fileUpSlide">--%>
            <%--<li>--%>
                <%--<a href="javascript:void(0);" onclick="imageDetail(this);">--%>
                <%--<img src="http://${webip}:8084/picture_bed/${fileUpSlide.filePathshow}" id="${fileUpSlide.id}" style="width: 1970px;height: 500px" />--%>
                <%--</a>--%>
                <%--<span style="z-index: 999;position: absolute;right: 6%;bottom: 16%;color: #ffffff;font-size: 16px">摄影师：&nbsp;&nbsp;&nbsp;&nbsp;${fileUpSlide.cameraman}</span>--%>
                <%--<span style="z-index: 999;position: absolute;right: 6%;bottom: 10%;color: #ffffff;font-size: 16px">图片名：&nbsp;&nbsp;&nbsp;&nbsp;${fileUpSlide.pictureName}</span>--%>
            <%--</li>--%>
    <%--</c:forEach>--%>
<%--</ul>--%>
<div style="width: 1580px;height: 350px;margin:16px auto;">

    <div class="slideshow" id="slideshow1" style="width: 1560px;height: 120px;margin:16px auto;">
        <c:forEach items="${fileUpSlide}" var="fileUpSlide">
            <div class="slide">
                <a href="javascript:void(0);" onclick="imageDetail(this);">
                    <img src="http://${webip}:8084/picture_bed/${fileUpSlide.filePathshow}"  id="${fileUpSlide.id}" style="width: 120px;height: 80px" alt="Park">
                </a>
                <span style="z-index: 999;position: absolute;right: 6%;bottom: 16%;color: #ffffff;font-size: 16px">摄影师：&nbsp;&nbsp;&nbsp;&nbsp;${fileUpSlide.cameraman}</span>
                <span style="z-index: 999;position: absolute;right: 6%;bottom: 10%;color: #ffffff;font-size: 16px">图片名：&nbsp;&nbsp;&nbsp;&nbsp;${fileUpSlide.pictureName}</span>
            </div>
        </c:forEach>
    </div>

</div>

<div style="height: 210px"></div>

<div style="width: 1360px;height: 350px;margin:16px auto;">

    <div style="width: 160px;height: 30px;margin:16px auto;">
        <h1 class="more_animal"><a href="javascript:void(0)">野生动物</a></h1>
    </div>

<div style="height: 30px"></div>

<div class="slideshow" id="slideshow2" style="width: 1300px;height: 120px;margin:16px auto;">
<c:forEach items="${fileUpAnimal}" var="fileUpAnimal">
    <div class="slide">
        <a href="javascript:void(0);" onclick="imageDetail(this);">
            <img src="http://${webip}:8084/picture_bed/${fileUpAnimal.filePathshow}"  id="${fileUpAnimal.id}" style="width: 120px;height: 80px" alt="Park">
        </a>
        <span style="z-index: 999;position: absolute;right: 6%;bottom: 16%;color: #ffffff;font-size: 16px">摄影师：&nbsp;&nbsp;&nbsp;&nbsp;${fileUpAnimal.cameraman}</span>
        <span style="z-index: 999;position: absolute;right: 6%;bottom: 10%;color: #ffffff;font-size: 16px">图片名：&nbsp;&nbsp;&nbsp;&nbsp;${fileUpAnimal.pictureName}</span>
    </div>
</c:forEach>
</div>

<div style="height: 20px"></div>

<div style="width: 90px;height: 40px;margin:16px auto;">
    <button class="more_animal" class="btn btn-success" style="width:87px;height: 38px;padding: 3px;border-radius: 10%;font-size: 14px">更多动物</button>
</div>

</div>

<div style="height: 320px"></div>

<div style="width: 1360px;height: 350px;margin:16px auto;">

    <div style="width: 160px;height: 30px;margin:16px auto;">
        <h1 class="more_plant"><a href="javascript:void(0)">珍稀植物</a></h1>
    </div>

    <div style="height: 30px"></div>

    <div class="slideshow" id="slideshow3" style="width: 1300px;height: 120px;margin:16px auto;">
        <c:forEach items="${fileUpPlant}" var="fileUpPlant">
            <div class="slide">
                <a href="javascript:void(0);" onclick="imageDetail(this);">
                    <img src="http://${webip}:8084/picture_bed/${fileUpPlant.filePathshow}"  id="${fileUpPlant.id}" style="width: 120px;height: 80px" alt="Park">
                </a>
                <span style="z-index: 999;position: absolute;right: 6%;bottom: 16%;color: #ffffff;font-size: 16px">摄影师：&nbsp;&nbsp;&nbsp;&nbsp;${fileUpPlant.cameraman}</span>
                <span style="z-index: 999;position: absolute;right: 6%;bottom: 10%;color: #ffffff;font-size: 16px">图片名：&nbsp;&nbsp;&nbsp;&nbsp;${fileUpPlant.pictureName}</span>
            </div>
        </c:forEach>
    </div>

    <div style="height: 20px"></div>

    <div style="width: 90px;height: 40px;margin:16px auto;">
        <button class="more_plant" class="btn btn-success" style="width:87px;height: 38px;padding: 3px;border-radius: 10%;font-size: 14px;z-index: 999">更多植物</button>
    </div>

</div>

<%--<div class="container gallery-container" style="z-index: 750">--%>
    <%--<h1 class="more_plant">珍稀植物</h1>--%>
    <%--&lt;%&ndash;<p class="page-description text-center">Clean Layout With Minimal Styles</p>&ndash;%&gt;--%>
    <%--<div class="tz-gallery">--%>
        <%--<div class="row">--%>
            <%--<c:forEach items="${fileUpPlant}" var="fileUpPlant">--%>
                <%--&lt;%&ndash;<c:if test="${fileUpPlant.indexPlant==2}">&ndash;%&gt;--%>
                    <%--<div class="col-sm-6 col-md-4">--%>
                        <%--<div class="thumbnail">--%>
                            <%--<a href="javascript:void(0);" onclick="imageDetail(this);">--%>
                                <%--<img src="http://${webip}:8084/picture_bed/${fileUpPlant.filePathshow}" id="${fileUpPlant.id}" alt="Park">--%>
                            <%--</a>--%>
                            <%--<div class="caption">--%>
                                <%--<h3>${fileUpPlant.pictureName}</h3>--%>
                                <%--<p>${fileUpPlant.instruction}</p>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--&lt;%&ndash;</c:if>&ndash;%&gt;--%>
            <%--</c:forEach>--%>

            <%--<div style="width: 90px;height: 40px;margin:6px auto;z-index: 999">--%>
                <%--<button class="more_plant" class="btn btn-success" style="width:87px;height: 38px;padding: 3px;border-radius: 10%;font-size: 14px">更多植物</button>--%>
            <%--</div>--%>

        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>

<div style="height: 550px"></div>

<div class="container gallery-container" style="margin-top: -230px;z-index: 700">
   <h1 class="more_scape"><a href="javascript:void(0)">自然景观</a></h1>
    <%--<p class="page-description text-center">Clean Layout With Minimal Styles</p>--%>
    <div class="tz-gallery">
        <div class="row">
            <c:forEach items="${fileUpScape}" var="fileUpScape">
                <%--<c:if test="${fileUpScape.indexScape==2}">--%>
                    <div class="col-sm-6 col-md-4">
                        <div class="thumbnail">
                            <a href="javascript:void(0);" onclick="imageDetail(this);">
                                <img src="http://${webip}:8084/picture_bed/${fileUpScape.filePathshow}" id="${fileUpScape.id}" alt="Park">
                            </a>
                            <div class="caption">
                                <h3>${fileUpScape.pictureName}</h3>
                                <p> ${fileUpScape.instruction}</p>
                            </div>
                        </div>
                    </div>
                <%--</c:if>--%>
            </c:forEach>

            <div style="width: 90px;height: 40px;margin:6px auto;">
                <button class="more_scape" class="btn btn-success" style="width:87px;height: 38px;padding: 3px;border-radius: 10%;font-size: 14px;z-index: 700">更多风景</button>
            </div>

        </div>
    </div>
</div>

<div style="height: 70px"></div>


<div class="container gallery-container" style="margin-top: -100px;">
    <h1 class="more_video"><a href="javascript:void(0)">视频展播</a></h1>
    <%--<p class="page-description text-center">Clean Layout With Minimal Styles</p>--%>
    <div class="tz-gallery">
        <div class="row">
            <c:forEach items="${fileUpVideo}" var="fileUpVideo">

            <a href="javascript:void(0);" onclick="videoDetail(this);" >
                <video width="320" height="240" id="${fileUpVideo.id}" controls>
                    <source src="http://${webip}:8084/picture_bed/${fileUpVideo.filePathshow}"  type="video/mp4">
                </video>
            </a>

        </c:forEach>

            <div style="width: 90px;height: 40px;margin:30px auto;">
                <button class="more_video" class="btn btn-success" style="width:87px;height: 38px;padding: 3px;border-radius: 10%;font-size: 14px">更多视频</button>
            </div>

        </div>
    </div>
</div>



<%--&lt;%&ndash;底部div&ndash;%&gt;--%>
<div style="margin-top:30px;width: 100%;height: 120px;background-color: #122b40;">

    <div style="height: 32px"></div>

    <div style="margin:0px auto;width: 1200px;height: 20px;color: #707070;font-size: 16px">

        <a href="indexs" target="_blank"><span style="color: #707070;font-size: 16px">网站首页</span></a>
        <span style="margin-left: 50px">企业文化</span>
        <span style="margin-left: 50px">联系我们</span>
        <a href="http://www.nrchina.org/" target="_blank" ><span style="margin-left: 50px;color: #707070;font-size: 16px">友情链接</span></a>
        <span style="margin-left: 280px">公司办公电话:</span>
        <span style="margin-left: 20px">15546508963</span>
        <span style="margin-left: 60px">QQ在线咨询:</span>
        <a href="tencent://message/?uin=2943489668">
            <span style="margin-left: 20px"><img width="24px" height="24px" src="${pageContext.request.contextPath}/resources/images/qqchat.png"/></span>
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
    <input type="hidden" id="indexid" name="id" />
</form>

<script type="text/javascript">

    function imageDetail(w){
        var imageId = $(w).children().attr("id");
    $("#indexForm").attr("action","<%=basePath%>index_detail");
    $("#indexid").attr("value",imageId);
    $("#indexForm").submit();
}

    function videoDetail(w){
        var imageId = $(w).children().attr("id");
        $("#indexForm").attr("action","<%=basePath%>index_video_detail");
        $("#indexid").attr("value",imageId);
        $("#indexForm").submit();
    }

    $(document).ready(function(){

//        $('.slideshow').skidder();

//        //左右滚动
        $('#slideshow1').each( function() {
            var $slideshow = $(this);
            $slideshow.imagesLoaded( function() {

                $slideshow.skidder({

                    autoplay: true,
                    cycle: true,
                    autoplayResume:true,
                    interval: 2000

                });
            });
        });

        $('#slideshow2').each( function() {
            var $slideshow = $(this);
            $slideshow.imagesLoaded( function() {

                $slideshow.skidder({

                    autoplay: true,
                    cycle: true,
                    autoplayResume:true,
                    interval: 1000

                });
            });
        });

        $('#slideshow3').each( function() {
            var $slideshow = $(this);
            $slideshow.imagesLoaded( function() {

                $slideshow.skidder({

                    autoplay: true,
                    cycle: true,
                    autoplayResume:true,
                    interval: 600

                });
            });
        });



        $('.bxslider').bxSlider({
            mode:'fade', //褪色模式
            auto:"true",
        });

        baguetteBox.run('.tz-gallery');


        $(".more_animal").click(function(){
            $("#serchinput").attr("value","动物");
            $("#searchTopSearch").submit();
        });

        $(".more_plant").click(function(){
            $("#serchinput").attr("value","植物");
            $("#searchTopSearch").submit();
        });

        $(".more_scape").click(function(){
            $("#serchinput").attr("value","风景");
            $("#searchTopSearch").submit();
        });

        $(".more_video").click(function(){
            $("#serchvideoinput").attr("value","动物");
            $("#searchVideoSearch").submit();
        });




})
</script>
</body>
</html>
