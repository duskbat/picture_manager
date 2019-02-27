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
    <title>信息详情页</title>
</head>
<body>
<%@include file="top.jsp"%>

<%--<%--%>
    <%--Object obj = application.getAttribute("count");--%>
    <%--if(obj==null){--%>
        <%--Integer count = 1;--%>
        <%--application.setAttribute("count",count);--%>

    <%--}else{--%>
        <%--Integer count = (Integer)obj;--%>
        <%--count++;--%>
        <%--application.setAttribute("count",count);--%>
    <%--}--%>
<%--%>--%>

<%--<%=obj.toString()%>--%>

<div style="height: 12%"></div>

<div style="font-size: 16px;width: 70%;height: 16px;margin:6px auto"><a href="index_news_more"><span style="color: #0074D9">信息传递</span></a>&nbsp;&nbsp;/&nbsp;&nbsp;<span>信息详情页</span></div>

<div style="width: 90%;height: 80px;margin:10px auto;">
    <div style="width: 30%;height: 30px;margin:10px auto">
        <span style="font-size: 20px;color: #4b9933">${myNews.newTitle}</span>
    </div>

    <div style="height: 10px"></div>

    <div style="width: 70%;height: 30px;margin:6px auto">
        <span >来源:${myNews.newSource}</span>
        <span style="margin-left: 100px">作者:${myNews.newAuthor}</span>
        <span style="margin-left: 100px">发布时间:<fmt:formatDate value="${myNews.newTime}" type="both" dateStyle="long" /></span>
        <span style="margin-left: 100px">浏览次数:  <span id="record" style="margin-left: 10px">${newRecord}</span></span>
    </div>
</div>

<hr>

<div style="height: 10px"></div>

<div style="width: 80%;height: auto;margin:10px auto;">
    ${myNews.newHtml}
</div>

<div style="height: 80px"></div>

<div style="margin-left:  150px">
    <a href="javascript:void(0);" onclick="blogPre(this);">
    <span style="color: #0074D9">上一篇:&nbsp;&nbsp;&nbsp;&nbsp;${blogPre.newTitle}</span>
    </a>
</div>

<div style="margin-left:  150px">
    <a href="javascript:void(0);" onclick="blogAfter(this);">
        <span style="color: #0074D9">下一篇:&nbsp;&nbsp;&nbsp;&nbsp;${blogAfter.newTitle}</span>
    </a>
</div>

<div style="height: 30px"></div>

<hr>
<div style="height: 80px"></div>

<form id="newsForm" method="post">
    <input type="hidden" id="newsid" name="id" />
</form>

<script type="text/javascript">

    function blogPre(w){
        $("#newsForm").attr("action","<%=basePath%>index_news_detail");
        $("#newsid").attr("value",${blogPre.id});
        $("#newsForm").submit();
    }


    function blogAfter(w){
        $("#newsForm").attr("action","<%=basePath%>index_news_detail");
        $("#newsid").attr("value",${blogAfter.id});
        $("#newsForm").submit();
    }

    $(document).ready(function () {

    })

</script>
</body>
</html>
