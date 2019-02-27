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

    <!-- 图片垂直滚动 -->
    <script src="${pageContext.request.contextPath}/resources/js/Marquee.js"></script>
    <link href="${pageContext.request.contextPath}/resources/css/Marquee.css" rel="stylesheet"/>


    <link href="${pageContext.request.contextPath}/resources/css/font-awesome.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/awesome-bootstrap-checkbox.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/font.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/css/cont.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/css/layout.css" rel="stylesheet"/>
    <link rel="icon" href="${pageContext.request.contextPath}/resources/images/auction1.ico">
    <title>活动公告页</title>
</head>
<body>
<%@include file="top.jsp"%>

<div style="width: 10%;height: 30px;margin:50px auto">
    <span style="font-size: 20px;color: #4b9933">活动公告</span>
</div>
<div style="height: 42%;margin-top: 2px"></div>
<hr>


<div style="margin-top: 42px;margin-left: 160px">

    <div style="width:260px;float:left;height: 1200px;top: 380px">

        <br>
        <div id="marquee2">
            <ul style="height: 5000px;">
                <c:forEach items="${pageInfo.list}" var="news">
                    <li>
                        <a href="javascript:void(0);" onclick="newsDetail(this);" title="${news.newTitle}">
                            <img src="http://${webip}:8084/picture_bed/${news.newAttachment}" id="${news.id}" width="210px" height="150px">
                        </a>
                        <br>
                    </li>
                </c:forEach>
            </ul>
        </div>

        <div class="control" style="margin-top: 30px">
            <a href="javascript:void(0);" id="goU">上一张</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="javascript:void(0);" id="goD">下一张</a>
        </div>

    </div>

</div>

<div style='width:1px;border: 1px solid #bfbfbf;float:left;height:800px;'>
    <div style='margin-left: 6px;width:1042px;border: 1px solid #bfbfbf;height:1px;'></div>
</div>


<div style="height: 2%;margin-top: 2%"></div>

<div class="row detailPhotoRow" style="margin-top: 5px;margin-left: 420px;width:1060px;padding: 30px;font-size: 16px;
height:800px;
/*background-color:#ff9900;*/
-moz-box-shadow: 10px 10px 5px #888888; /* 老的 Firefox */
box-shadow: 5px 5px 2px #888888;">

    <c:forEach items="${pageInfo.list}" var="news">
        <%--<div class="col-md-1 detailPhoto"></div>--%>
        <div class="col-md-5 detailPhoto">标题：
            <a href="javascript:void(0);" onclick="newsDetail(this);">
                <span id="${news.id}">${news.newTitle}</span>
            </a>
        </div>
        <div class="col-md-5 detailPhotoDesc">发布时间：
            <fmt:formatDate value="${news.newTime}" type="both" dateStyle="long" />
        </div>
        <br>
    </c:forEach>

    <%--分页--%>
    <div class="row" style="margin-top: 300px" >

        <%--<div class="col-md-3">--%>

        <%--</div>--%>

        <div class="col-md-5" style="color: #5e5e5e; font-size: 16px;margin-left: 10px">
            当前是第&nbsp;${pageInfo.pageNum}&nbsp;页,&nbsp;&nbsp;共&nbsp;${pageInfo.pages }&nbsp;页,&nbsp;&nbsp;总&nbsp;${pageInfo.total }&nbsp;条信息
        </div>

        <div class="col-md-4" style="color: #5e5e5e; font-size: 16px;margin-left: 200px">

            <%--<nav aria-label="Page navigation">--%>
            <ul class="nav navbar-nav navbar-right">
                <!--
        1.pageContext.request.contextPath表示当前项目路径，采用的是绝对路径表达方式。一般为http:localhost:8080/项目名 。
        2.首页，末页的逻辑：pn=1访问第一次，pn=${pageInfo.pages}访问最后一页
        -->
                <li>
                    <a href="${pageContext.request.contextPath}/index_notice_more?pn=1">首页</a>
                </li>
                <!-- 如果还有前页就访问当前页码-1的页面， -->
                <c:if test="${pageInfo.hasPreviousPage}">
                    <li>
                        <a href="${pageContext.request.contextPath}/index_notice_more?pn=${pageInfo.pageNum-1}" aria-label="Previous">
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
                    <li ><a href="${pageContext.request.contextPath}/index_notice_more?pn=${page_Nums}">${page_Nums}</a></li>
                </c:if>
                </c:forEach>
                </li>
                <!-- 如果还有后页就访问当前页码+1的页面， -->
                <c:if test="${pageInfo.hasNextPage}">
                    <li>
                        <a href="${pageContext.request.contextPath}/index_notice_more?pn=${pageInfo.pageNum+1}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:if>
                <li><a href="${pageContext.request.contextPath}/index_notice_more?pn=${pageInfo.pages}">末页</a></li>
            </ul>
            <%--</nav>--%>
        </div>
    </div>

</div>

<%--<div style="height: 10%;margin-top: 8%"></div>--%>




<%--提交详情表单--%>
<form id="newsForm" method="post">
    <input type="hidden" id="newsid" name="id" />
</form>

<script type="text/javascript">

    function newsDetail(w){
        var newsId = $(w).children().attr("id");
        $("#newsForm").attr("action","<%=basePath%>index_notice_detail");
        $("#newsid").attr("value",newsId);
        $("#newsForm").submit();
    }

    $(document).ready(function () {

        //一次纵向滚动一个
        $('#marquee2').kxbdSuperMarquee({
            distance:162,
            time:3,
            btnGo:{up:'#goU',down:'#goD'},
            direction:'down'
        });

    });

</script>
</body>
</html>
