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


    <script src="${pageContext.request.contextPath}/resources/js/viewer.js"></script>
    <link href="${pageContext.request.contextPath}/resources/css/viewer.css" rel="stylesheet"/>
    <script src="${pageContext.request.contextPath}/resources/js/checkbix.min.js"></script>
    <link href="${pageContext.request.contextPath}/resources/css/checkbix.css" rel="stylesheet"/>


    <!-- 搜索页筛选条件 -->
    <link href="${pageContext.request.contextPath}/resources/css/tab.css" rel="stylesheet"/>

    <!-- 搜索页瀑布流 -->
    <script src="${pageContext.request.contextPath}/resources/js/pinterest_grid.js"></script>
    <link href="${pageContext.request.contextPath}/resources/css/water.css" rel="stylesheet"/>



    <link href="${pageContext.request.contextPath}/resources/css/font-awesome.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/awesome-bootstrap-checkbox.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/font.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/css/cont.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/css/layout.css" rel="stylesheet"/>
    <link rel="icon" href="${pageContext.request.contextPath}/resources/images/auction1.ico">
    <title>视频搜索页</title>
</head>
<body>

<%@include file="video_top.jsp"%>

<div class='tabbed round' id='skinable' style="margin-top: 100px">
    <ul>
        <a id="verticalvideo" href="javascript:void(0)"><li>竖直</li></a>
        <a id="horizentalvideo" href="javascript:void(0)"><li>水平</li></a>
        <a id="4kvideo" href="javascript:void(0)"><li>4K</li></a>
        <a id="1080video" href="javascript:void(0)"><li>高清1080P</li></a>
        <a id="720video" href="javascript:void(0)"><li>标清720P</li></a>
        <a id="allvideo" href="javascript:void(0)"><li>全部视频</li></a>
    </ul>
</div>

<div style="width: 1000px;height: auto;margin: 20px 280px">
    <c:forEach items="${pageInfo.list}" var="picture">

        <a href="javascript:void(0);" onclick="videoDetail(this);" >
            <video width="320" height="240" id="${picture.id}" controls>
                <source src="http://${webip}:8084/picture_bed/${picture.filePathshow}"  type="video/mp4">
            </video>
        </a>

    </c:forEach>
</div>



<%--站位--%>
<div style="width: 100%;height: 260px"></div>

<%--分页--%>
<div class="row">

    <div class="col-xs-6 col-md-4" style="color: #5e5e5e; font-size: 16px;margin-left: 150px">
        当前是第&nbsp;${pageInfo.pageNum}&nbsp;页,共&nbsp;${pageInfo.pages }&nbsp;页,总&nbsp;${pageInfo.total }&nbsp;个视频
    </div>


    <div class="col-xs-6 col-md-4">

        <%--<nav aria-label="Page navigation">--%>
        <ul class="nav navbar-nav navbar-right">
            <!--
1.pageContext.request.contextPath表示当前项目路径，采用的是绝对路径表达方式。一般为http:localhost:8080/项目名 。
2.首页，末页的逻辑：pn=1访问第一次，pn=${pageInfo.pages}访问最后一页
-->
            <li>
                <a href="${pageContext.request.contextPath}/index_video_search?pn=1&keyword=${keyword1}">首页</a>
            </li>
            <!-- 如果还有前页就访问当前页码-1的页面， -->
            <c:if test="${pageInfo.hasPreviousPage}">
                <li>
                    <a href="${pageContext.request.contextPath}/index_video_search?pn=${pageInfo.pageNum-1}&keyword=${keyword1}" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
            </c:if>
            <li>
                <!--遍历所有导航页码，如果遍历的页码页当前页码相等就高亮显示，如果相等就普通显示  -->
                <c:forEach items="${pageInfo.navigatepageNums }" var="page_Nums">
                <c:if test="${page_Nums==pageInfo.pageNum }">
            <li class="active"><a href="#">${page_Nums}</a></li>
            </c:if>
            <c:if test="${page_Nums!=pageInfo.pageNum }">
                <li ><a href="${pageContext.request.contextPath}/index_video_search?pn=${page_Nums}&keyword=${keyword1}">${page_Nums}</a></li>
            </c:if>
            </c:forEach>
            </li>
            <!-- 如果还有后页就访问当前页码+1的页面， -->
            <c:if test="${pageInfo.hasNextPage}">
                <li>
                    <a href="${pageContext.request.contextPath}/index_video_search?pn=${pageInfo.pageNum+1}&keyword=${keyword1}" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </c:if>
            <li><a href="${pageContext.request.contextPath}/index_video_search?pn=${pageInfo.pages}&keyword=${keyword1}">末页</a></li>
        </ul>
        <%--</nav>--%>
    </div>
</div>

<%--站位--%>
<div style="width: 100%;height: 180px"></div>

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
<form id="indexSearForm" method="post">
    <input type="hidden" id="indexsid" name="id" />
</form>

<form id="selectVerticalForm" method="post">
    <input type="hidden" id="direction" name="direction"/>
    <input type="hidden" id="keyword" name="keyword"/>
</form>

<form id="selectspiceForm" method="post">
    <input type="hidden" id="spice" name="spice"/>
    <input type="hidden" id="keywordspice" name="keyword"/>
</form>

<script type="text/javascript">

    function videoDetail(w){
        var imageId = $(w).children().attr("id");
        $("#indexSearForm").attr("action","<%=basePath%>index_video_detail");
        $("#indexsid").attr("value",imageId);
        $("#indexSearForm").submit();
    }


    $(document).ready(function () {

        $("#gallery-wrapper").pinterest_grid();

        $("#verticalvideo").click(function() {

            $("#selectVerticalForm").attr("action","<%=basePath%>selectVideoVertical");
            $("#direction").attr("value",2);
            $("#keyword").attr("value",$("#serchvideoinput").val());
            $("#selectVerticalForm").submit();

        });

        $("#horizentalvideo").click(function() {

            $("#selectVerticalForm").attr("action","<%=basePath%>selectVideoVertical");
            $("#direction").attr("value",1);
            $("#keyword").attr("value",$("#serchvideoinput").val());
            $("#selectVerticalForm").submit();

        });

        $("#720video").click(function() {

            $("#selectspiceForm").attr("action","<%=basePath%>selectVideoSpice");
            $("#spice").attr("value",1);
            $("#keywordspice").attr("value",$("#serchvideoinput").val());
            $("#selectspiceForm").submit();

        });

        $("#1080video").click(function() {

            $("#selectspiceForm").attr("action","<%=basePath%>selectVideoSpice");
            $("#spice").attr("value",2);
            $("#keywordspice").attr("value",$("#serchvideoinput").val());
            $("#selectspiceForm").submit();

        });

        $("#4kvideo").click(function() {

            $("#selectspiceForm").attr("action","<%=basePath%>selectVideoSpice");
            $("#spice").attr("value",3);
            $("#keywordspice").attr("value",$("#serchvideoinput").val());
            $("#selectspiceForm").submit();

        });


        $("#allvideo").click(function() {
            $("#searchVideoSearch").submit();
        });


        var direct = "${direction}";

        switch (direct) {
            case ("0"):
                $("#allvideo").children().attr("class","active");
                break;
            case ("1"):
                $("#horizentalvideo").children().attr("class","active");
                break;
            case ("2"):
                $("#verticalvideo").children().attr("class","active");
                break;

        }

        var species = "${species}";

        switch (species) {
            case ("0"):
                $("#allvideo").children().attr("class","active");
                break;
            case ("1"):
                $("#720video").children().attr("class","active");
                break;
            case ("2"):
                $("#1080video").children().attr("class","active");
                break;
            case ("2"):
                $("#4kvideo").children().attr("class","active");
                break;

        }



    })
</script>
</body>
</html>
