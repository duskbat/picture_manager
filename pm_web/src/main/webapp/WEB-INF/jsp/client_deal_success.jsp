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
            <li ><a href="client_mark">我的收藏</a></li>
            <li><a href="client_shoping">购物车</a></li>
            <li><a href="client_upload">用户上传</a></li>
            <li ><a href="client_auditing">审核结果</a></li>
            <li class="active"><a href="client_deal">交易记录</a></li>
            <li><a href="client_setting">个人信息</a></li>
        </ul>
    </div>

    <div class="midCont">

        <ul class="nav nav-pills">
            <li role="presentation" ><a href="client_deal" >待公司确认</a></li>
            <li role="presentation" class="active" ><a href="client_deal_success" >公司已签字</a></li>
            <li role="presentation"  ><a href="client_success_company" >用户未收款</a></li>
            <li role="presentation" ><a href="client_end_company" >用户已收款</a></li>
        </ul>

        <table class="table table-striped table-hover table-bordered" style="margin-left: 70px;margin-top: 30px">
            <thead>
            <tr>
                <th>版权使用人</th>
                <th>图片名</th>
                <%--<th>图片用途或尺寸</th>--%>
                <th>付款账号</th>
                <th>付款金额</th>
                <th>付款状态</th>
                <th>合同状态</th>
                <th>付款时间</th>
                <th>开始时间</th>
                <th>截止时间</th>
                <th>操作</th>
            </tr>

            <c:forEach items="${pageInfo.list}" var="deal">
                <%--<c:if test="${deal.contractState==2 && deal.orderUserid==user.id}">--%>
                    <tr>
                        <th>${deal.copyrightName}</th>
                        <th>${deal.ofileUpEntity.pictureName}</th>
                        <%--<th><c:if test="${deal.application =='1'}">小尺寸&nbsp;&nbsp;&nbsp;&nbsp;${imgsmallwidth} × ${imgsmallheight} px</c:if>--%>
                            <%--<c:if test="${deal.application =='2'}">中尺寸&nbsp;&nbsp;&nbsp;&nbsp;${imgmidwidth} × ${imgmidheight} px</c:if>--%>
                            <%--<c:if test="${deal.application =='3'}">大尺寸&nbsp;&nbsp;&nbsp;&nbsp;${imgbigwidth} × ${imgbigheight} px</c:if>--%>
                            <%--<c:if test="${deal.application =='4'}">原图&nbsp;&nbsp;&nbsp;&nbsp;${imgwidth} × ${imgheight}px</c:if>--%>
                            <%--<c:if test="${deal.application =='5'}">网络用途&nbsp;&nbsp;手机应用(小尺寸)&nbsp;&nbsp;${imgsmallwidth} × ${imgsmallheight} px</c:if>--%>
                            <%--<c:if test="${deal.application =='6'}">网络用途&nbsp;&nbsp;网站(中尺寸)&nbsp;&nbsp;${imgmidwidth} × ${imgmidheight} px</c:if>--%>
                            <%--<c:if test="${deal.application =='7'}">出版用途&nbsp;&nbsp;小尺寸&nbsp;&nbsp;${imgsmallwidth} × ${imgsmallheight} px</c:if>--%>
                            <%--<c:if test="${deal.application =='8'}">出版用途&nbsp;&nbsp;中尺寸&nbsp;&nbsp;${imgmidwidth} × ${imgmidheight} px</c:if>--%>
                            <%--<c:if test="${deal.application =='9'}">广告用途&nbsp;&nbsp;大尺寸&nbsp;&nbsp;${imgbigwidth} × ${imgbigheight} px</c:if>--%>
                            <%--<c:if test="${deal.application =='10'}">广告用途&nbsp;&nbsp;原图&nbsp;&nbsp;${imgwidth} × ${imgheight}px</c:if>--%>
                            <%--<c:if test="${deal.application =='11'}">线下物料&nbsp;&nbsp;小尺寸&nbsp;&nbsp;${imgsmallwidth} × ${imgsmallheight} px</c:if>--%>
                            <%--<c:if test="${deal.application =='12'}">线下物料&nbsp;&nbsp;中尺寸&nbsp;&nbsp;${imgmidwidth} × ${imgmidheight} px</c:if>--%>
                        <%--</th>--%>
                        <th>${deal.payAccount}</th>
                        <th>${deal.price}</th>
                        <th>
                            <c:if test="${deal.payState =='1'}">公司未确认</c:if>
                            <c:if test="${deal.payState =='2'}">公司已确认</c:if>
                        </th>
                        <th>
                            <c:if test="${deal.contractState =='1'}">公司未签字</c:if>
                            <c:if test="${deal.contractState =='2'}">公司已签字</c:if>
                        </th>

                        <th><fmt:formatDate value="${deal.payTime}" type="both" dateStyle="long" /></th>
                        <th><fmt:formatDate value="${deal.startTime}" pattern="yyyy-MM-dd" /></th>
                        <th><fmt:formatDate value="${deal.endTime}" pattern="yyyy-MM-dd" /></th>

                        <th>
                            <span class="scriptionLeftSpan" style="margin-left: 12px" id="${deal.id}">
                                 <button class='btn btn-primary edit_button' type='submit' style="width: 50px;height: 36px;padding: 1px;font-size: 14px">详情</button>
                            </span>
                        </th>
                    </tr>
                <%--</c:if>--%>
            </c:forEach>
            </thead>
        </table>


        <%--分页--%>
        <div class="row">

            <div class="col-xs-6 col-md-4" style="color: #5e5e5e; font-size: 16px;margin-left: 100px">
                当前是第&nbsp;${pageInfo.pageNum}&nbsp;页,&nbsp;&nbsp;共&nbsp;${pageInfo.pages }&nbsp;页,&nbsp;&nbsp;总&nbsp;${pageInfo.total }&nbsp;个订单
            </div>

            <div class="col-xs-6 col-md-4" style="color: #5e5e5e; font-size: 16px;margin-left: 250px">

                <%--<nav aria-label="Page navigation">--%>
                <ul class="nav navbar-nav navbar-right">
                    <!--
        1.pageContext.request.contextPath表示当前项目路径，采用的是绝对路径表达方式。一般为http:localhost:8080/项目名 。
        2.首页，末页的逻辑：pn=1访问第一次，pn=${pageInfo.pages}访问最后一页
        -->
                    <li>
                        <a href="${pageContext.request.contextPath}/client_deal_success?pn=1">首页</a>
                    </li>
                    <!-- 如果还有前页就访问当前页码-1的页面， -->
                    <c:if test="${pageInfo.hasPreviousPage}">
                        <li>
                            <a href="${pageContext.request.contextPath}/client_deal_success?pn=${pageInfo.pageNum-1}" aria-label="Previous">
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
                        <li ><a href="${pageContext.request.contextPath}/client_deal_success?pn=${page_Nums}">${page_Nums}</a></li>
                    </c:if>
                    </c:forEach>
                    </li>
                    <!-- 如果还有后页就访问当前页码+1的页面， -->
                    <c:if test="${pageInfo.hasNextPage}">
                        <li>
                            <a href="${pageContext.request.contextPath}/client_deal_success?pn=${pageInfo.pageNum+1}" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:if>
                    <li><a href="${pageContext.request.contextPath}/client_deal_success?pn=${pageInfo.pages}">末页</a></li>
                </ul>
                <%--</nav>--%>
            </div>
        </div>



    </div><!--midCont-->


</div><!--userCenterWrap-->

<%--提交详情表单--%>
<form id="client_deal_edit" method="post">
    <input type="hidden" id="userid" name="id" />
</form>

<script type="text/javascript">

    $(document).ready(function(){


        $(".edit_button").click(
            function ()
            {
                $("#client_deal_edit").attr("action","<%=basePath%>client_deal_edit");
                $("#userid").attr("value",$(this).parent().attr("id"));
                $("#client_deal_edit").submit();
            }
        );


    })
</script>



</body>
</html>