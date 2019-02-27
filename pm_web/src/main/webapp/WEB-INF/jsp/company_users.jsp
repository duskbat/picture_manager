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

<div class="userCenterWrap">

    <div class="leftNav hidden-xs hidden-sm">
        <ul>
            <li><a href="company_auditing">待审核</a></li>
            <li ><a href="company_posted">已发布</a></li>
            <li><a href="company_upload" >公司上传</a></li>
            <li ><a href="company_deal" >交易记录</a></li>
            <li class="active"><a href="company_data" >控制台</a></li>
            <li><a href="company_news" >信息公告</a></li>
        </ul>
    </div>

    <div class="midCont">

        <ul class="nav nav-pills">

            <li class="active"><a href="company_data">数据统计</a></li>
            <li ><a href="company_keyword">关键词管理</a></li>

        </ul>

        <form id="searchUser" action="<%=basePath%>searchUser" method="get" class="navbar-form navbar-left" enctype="multipart/form-data" style="margin-left: 800px">

            <input type="text" name="realname" class="form-control" placeholder="搜索真实姓名" style="width: 260px;height: 36px;border: 1px solid #bfbfbf;">

        </form>

        <table class="table table-striped table-hover table-bordered" style="margin-left: 70px;margin-top: 30px">
            <thead>
            <tr>
                <th>昵称</th>
                <th>QQ</th>
                <th>真实姓名</th>
                <th>手机号</th>
                <th>邮箱</th>
                <th>邮寄地址</th>
                <th>操作</th>
            </tr>

            <c:forEach items="${pageInfo.list}" var="users">
                <c:if test="${users.admin!='管理员'}">
            <tr>

                <th>${users.nickname}</th>
                <th>${users.qq}</th>
                <th>${users.realname}</th>
                <th>${users.telephone}</th>
                <th>${users.email}</th>
                <th>${users.adress}</th>
                <th>
                    <span class="scriptionLeftSpan" style="margin-left: 12px" id="${users.id}">
                         <button class='btn btn-primary edit_button' type='submit' style="width: 50px;height: 36px;padding: 1px;font-size: 14px">详情</button>
                    </span>
                </th>

            </tr>
                </c:if>
            </c:forEach>

            </thead>
        </table>

        <%--分页--%>
        <div class="row">

            <div class="col-xs-6 col-md-4" style="color: #5e5e5e; font-size: 16px;margin-left: 100px">
                当前是第&nbsp;${pageInfo.pageNum}&nbsp;页,&nbsp;&nbsp;共&nbsp;${pageInfo.pages }&nbsp;页,&nbsp;&nbsp;总&nbsp;${total}&nbsp;个用户
            </div>

            <div class="col-xs-6 col-md-4" style="color: #5e5e5e; font-size: 16px;margin-left: 250px">

                <%--<nav aria-label="Page navigation">--%>
                <ul class="nav navbar-nav navbar-right">
                    <!--
        1.pageContext.request.contextPath表示当前项目路径，采用的是绝对路径表达方式。一般为http:localhost:8080/项目名 。
        2.首页，末页的逻辑：pn=1访问第一次，pn=${pageInfo.pages}访问最后一页
        -->
                    <li>
                        <a href="${pageContext.request.contextPath}/company_users?pn=1">首页</a>
                    </li>
                    <!-- 如果还有前页就访问当前页码-1的页面， -->
                    <c:if test="${pageInfo.hasPreviousPage}">
                        <li>
                            <a href="${pageContext.request.contextPath}/company_users?pn=${pageInfo.pageNum-1}" aria-label="Previous">
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
                        <li ><a href="${pageContext.request.contextPath}/company_users?pn=${page_Nums}">${page_Nums}</a></li>
                    </c:if>
                    </c:forEach>
                    </li>
                    <!-- 如果还有后页就访问当前页码+1的页面， -->
                    <c:if test="${pageInfo.hasNextPage}">
                        <li>
                            <a href="${pageContext.request.contextPath}/company_users?pn=${pageInfo.pageNum+1}" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:if>
                    <li><a href="${pageContext.request.contextPath}/company_users?pn=${pageInfo.pages}">末页</a></li>
                </ul>
                <%--</nav>--%>
            </div>
        </div>


    </div><!--midCont-->


</div><!--userCenterWrap-->

<form id="client_deal_edit" method="post">
    <input type="hidden" id="userid" name="id" />
</form>

<%--提交详情表单--%>
<form id="company_client_set" method="post">
    <input type="hidden" id="clientid" name="id" />
</form>

<script type="text/javascript">

    $(document).ready(function(){

        $(".edit_button").click(
            function ()
            {
                $("#company_client_set").attr("action","<%=basePath%>company_client_set");
                $("#clientid").attr("value",$(this).parent().attr("id"));
                $("#company_client_set").submit();
            }
        );

    })
</script>



</body>
</html>