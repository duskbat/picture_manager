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
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap-editable.js"></script>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap-editable.css" rel="stylesheet" />



    <link href="${pageContext.request.contextPath}/resources/css/font-awesome.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/awesome-bootstrap-checkbox.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/font.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/css/cont.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/css/layout.css" rel="stylesheet" />
    <link rel="icon" href="${pageContext.request.contextPath}/resources/images/auction1.ico">
    <title>公司后台</title>
</head>
<body>
<%@include file="top.jsp"%>


<div class="userCenterWrap">
    <div class="leftNav hidden-xs hidden-sm">
        <ul>
            <li><a href="company_auditing">待审核</a></li>
            <li class="active"><a href="company_posted">已发布</a></li>
            <li><a href="company_upload" >公司上传</a></li>
            <li ><a href="company_deal" >交易记录</a></li>
            <li><a href="company_data" >控制台</a></li>
            <li><a href="company_news" >信息公告</a></li>
        </ul>
    </div>

    <div class="midCont">

            <div class="favouriteBar">

                <ul class="nav nav-pills">

                    <li><a href="company_video">首页视频展示</a></li>
                    <li><a id="video_check">添加首页视频</a></li>

                </ul>

                <a href="company_posted" class="edit_selection" style="display: block;font-size: 16px;right: 450px;background-color: #515151">进入图片发布页</a>

                <a id="company_video_all_check" class="edit_selection" style="display: block;font-size: 16px;right: 300px;background-color: #66afe9">全&nbsp;选&nbsp;/&nbsp;取&nbsp;消</a>
                <a id="edit_back_upload" class="edit_selection" style="display: block;font-size: 16px;right: 180px;background-color: #ec971f">退回上传页</a>
                <a id="edit_back_audit" class="edit_selection" style="display: block;font-size: 16px;right: 60px;">退回审核中</a>

            </div><!--favouriteBar-->

    <div class="favouriteGalleryWrap">
        <div class="favouriteGallery layout3 globalDetail" style="position: relative; height: 0px;">
            <c:forEach items="${pageInfo.list}" var="picture">

                <a href="javascript:void(0);" onclick="videoDetail(this);" >
                    <video width="320" height="240" id="${picture.id}" controls>
                        <source src="http://${webip}:8084/picture_bed/${picture.filePathshow}" id="${picture.id}" type="video/mp4">
                    </video>
                </a>


                <input type="checkbox" id="${picture.id}" data-shape="circled" data-color="orange" class="checkbix">


                <span style="margin-right: 26px;">
                            <c:if test="${picture.userId =='1'}">公司上传</c:if>
                            <c:if test="${picture.userId !='1'}">用户上传</c:if>
                </span>

            </c:forEach>

        </div>
    </div>


    </div><!--midCont-->

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
                    <a href="${pageContext.request.contextPath}/company_video_posted?pn=1">首页</a>
                </li>
                <!-- 如果还有前页就访问当前页码-1的页面， -->
                <c:if test="${pageInfo.hasPreviousPage}">
                    <li>
                        <a href="${pageContext.request.contextPath}/company_video_posted?pn=${pageInfo.pageNum-1}" aria-label="Previous">
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
                    <li ><a href="${pageContext.request.contextPath}/company_video_posted?pn=${page_Nums}">${page_Nums}</a></li>
                </c:if>
                </c:forEach>
                </li>
                <!-- 如果还有后页就访问当前页码+1的页面， -->
                <c:if test="${pageInfo.hasNextPage}">
                    <li>
                        <a href="${pageContext.request.contextPath}/company_video_posted?pn=${pageInfo.pageNum+1}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:if>
                <li><a href="${pageContext.request.contextPath}/company_video_posted?pn=${pageInfo.pages}">末页</a></li>
            </ul>
            <%--</nav>--%>
        </div>
    </div>

</div><!--userCenterWrap-->


<form id="compostForm" method="post">
    <input type="hidden" id="userid" name="id" />
</form>

<form id="indexForm" method="post">
    <input type="hidden" id="indexid" name="id" />
</form>

<script type="text/javascript">

    function videoDetail(w){
        var imageId = $(w).children().attr("id");
        $("#indexForm").attr("action","<%=basePath%>index_video_detail");
        $("#indexid").attr("value",imageId);
        $("#indexForm").submit();
    }

    $(document).ready(function(){

        $("#video_check").click(function() {

            var fileUpList = [];
            <c:forEach items="${pageInfo.list}" var="picture">

            if ($("input[id=${picture.id}]").is(":checked")){ //如果选中
                <%--alert("${picture.id}");--%>
                var fileUp={
                    "id" : ${picture.id},
                    "indexVideo" : "2"
                };
                fileUpList.push(fileUp);
            }

            </c:forEach>

//            alert(fileUpList);

            $.ajax({
                type : 'post',
                url : '<%=basePath%>updateVideo',
                contentType : 'application/json;charset=utf-8',//指定为json类型
                //数据格式是json串,多个对象用[]包装
                data : JSON.stringify(fileUpList),
                success : function(data) {
                    console.log(data.toString());
                        alert("已添加到视频展示");
                    <%--location.href = "<%=basePath%>company_slide";--%>

                },
                error : function() {
//                        alert("失败");
                }
            });

        });


//退回公司上传页
        $("#edit_back_upload").click(function() {

            var fileUpList = [];
            <c:forEach items="${pageInfo.list}" var="picture">

            if ($("input[id=${picture.id}]").is(":checked")){ //如果选中
                <%--alert("${picture.id}");--%>
                var fileUp={
                    "id" : ${picture.id},
                    "stateId" : "1"
                };
                fileUpList.push(fileUp);
            }

            </c:forEach>

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
                    location.href = "<%=basePath%>company_video_upload";
                },
                error : function() {
//                        alert("失败");
                }
            });

        });

        //退回公司审核中页
        $("#edit_back_audit").click(function() {

            var fileUpList = [];
            <c:forEach items="${pageInfo.list}" var="picture">

            if ($("input[id=${picture.id}]").is(":checked")){ //如果选中
                <%--alert("${picture.id}");--%>
                var fileUp={
                    "id" : ${picture.id},
                    "stateId" : "6"
                };
                fileUpList.push(fileUp);
            }

            </c:forEach>

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
                    location.href = "<%=basePath%>company_video_auditing";
                },
                error : function() {
//                        alert("失败");
                }
            });

        });



        // 全选/取消全部
        $("#company_video_all_check").click(function() {
            if ($("input[type='checkbox']").is(":checked")) {
                $("input[type='checkbox']").each(function() {
                    this.checked = false;
                });
            } else {
                $("input[type='checkbox']").each(function() {
                    this.checked = true;
                });
            }
        });

    })
</script>
</body>
</html>