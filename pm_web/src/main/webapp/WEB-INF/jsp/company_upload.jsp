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
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap-editable.js"></script>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap-editable.css" rel="stylesheet"/>

    <!-- 进度条 -->
    <script src="${pageContext.request.contextPath}/resources/js/jquery.lineProgressbar.js"></script>
    <link href="${pageContext.request.contextPath}/resources/css/jquery.lineProgressbar.css" rel="stylesheet"/>

    <link href="${pageContext.request.contextPath}/resources/css/font-awesome.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/awesome-bootstrap-checkbox.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/font.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/css/cont.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/css/layout.css" rel="stylesheet"/>
    <link rel="icon" href="${pageContext.request.contextPath}/resources/images/auction1.ico">
    <title>公司上传页</title>
</head>
<body>
<%@include file="top.jsp" %>


<div class="userCenterWrap">

    <div class="leftNav hidden-xs hidden-sm">
        <ul>
            <li><a href="company_auditing">待审核</a></li>
            <li><a href="company_posted">已发布</a></li>
            <li class="active"><a href="company_upload">公司上传</a></li>
            <li><a href="company_deal">交易记录</a></li>
            <li><a href="company_data">控制台</a></li>
            <li><a href="company_news">信息公告</a></li>
        </ul>
    </div>

    <div class="midCont">

        <div class="favouriteBar">

            <a href="company_video_upload" class="edit_selection"
               style="display: block;font-size: 16px;right: 80%;background-color: #515151">进入视频上传</a>

            <button id="upload_button">图片上传<span style="margin-left: 15px;font-size: 12px">(第1步)</span></button>

            <div id="progressbar1" style="width: 16%;position: absolute;right:48%"></div>

            <%--<a id="wait" class="edit_selection" style="display: block;font-size: 16px;right: 36%;background-color: #00ad7d;display: none">图片上传中，请稍后</a>--%>

            <a href="javascript:void(0)" id="company_upload_all_check" class="edit_selection"
               style="display: block;font-size: 16px;right: 15%;background-color: #66afe9">全&nbsp;选&nbsp;/&nbsp;取&nbsp;消</a>
            <a href="javascript:void(0)" id="company_upload_push_check" class="edit_selection"
               style="display: block;font-size: 16px;right: 8%;">批量发布</a>
            <a href="javascript:void(0)" id="company_upload_delete" class="edit_selection"
               style="display: block;font-size: 16px;right: 2%;background-color: #c9302c ">删&nbsp;&nbsp;&nbsp;除</a>

        </div><!--favouriteBar-->

        <span>当前页面:</span>
        <span style="color: #0074D9">图片上传页</span>
        <%--<div id="progressbar1" style="width: 24%;position: absolute;right:2%"></div>--%>

        <div class="favouriteGalleryWrap">
            <div class="favouriteGallery layout3 globalDetail" style="position: relative; height: 0px;">
                <c:forEach items="${pageInfo.list}" var="picture">
                    <%--<c:if test="${picture.stateId==1 && picture.userId==user.id}">--%>
                    <div class="galleryThumb">
                        <div class="imgWrap">
                            <a href="javascript:void(0);" onclick="company_editid(this);">
                                <img src="http://${webip}:8084/picture_bed/${picture.filePathshow}" id="${picture.id}"
                                     class="pictures">
                            </a>
                        </div>
                        <div class="btnWrap">
                            <input type="checkbox" style="width: 15px;height: 15px" id="${picture.id}"
                                   data-shape="circled" data-color="orange" class="checkbix">
                            <span id="${picture.id}${picture.id}" style="margin-left: 15px;color: #0074D9">
                                点击图片编辑<span style="margin-left: 10px;font-size: 10px">(第2步)</span>
                            </span>
                            <br>
                            <button id="${picture.id}${picture.id}${picture.id}" class="company_audit_small"
                                    style="width: 180px;height: 30px;padding: 3px;font-size: 15px;">发&nbsp;&nbsp;&nbsp;&nbsp;布
                            </button>
                        </div>

                        <div class="thumbDetail" style="color: black">
                            <span>图片编号</span><span style="margin-left: 50px">${picture.id}</span>
                            <br>
                            <span>图片名</span><span style="margin-left: 50px">${picture.pictureName}</span>
                            <br>
                            <span>摄影师</span><span style="margin-left: 50px"><a
                                href="javascript:void(0)">${picture.cameraman}</a></span>
                            <br>
                            <span>版权所有人</span><span style="margin-left: 26px">${picture.owner}</span>
                            <br>
                            <span>版权模式</span>
                            <span style="margin-left: 36px">
                                    <c:if test="${picture.mode == 1}">免版税模式RF</c:if>
                                    <c:if test="${picture.mode ==2}">版权管理模式RM</c:if>
                                </span>

                            <br>
                            <span>图片方向</span>
                            <span style="margin-left: 36px">
                                     <c:if test="${picture.direction ==1}">横图</c:if>
                                    <c:if test="${picture.direction ==2}">竖图</c:if>
                                </span>

                            <br>

                        </div>

                    </div>
                    <%--</c:if>--%>
                </c:forEach>
            </div>
        </div>

    </div>

    <%--分页--%>
    <div class="row">

        <div class="col-xs-6 col-md-4" style="color: #5e5e5e; font-size: 16px;margin-left: 150px">
            当前是第&nbsp;${pageInfo.pageNum}&nbsp;页,共&nbsp;${pageInfo.pages }&nbsp;页,总&nbsp;${pageInfo.total }&nbsp;张图片
        </div>


        <div class="col-xs-6 col-md-4">

            <%--<nav aria-label="Page navigation">--%>
            <ul class="nav navbar-nav navbar-right">
                <!--
1.pageContext.request.contextPath表示当前项目路径，采用的是绝对路径表达方式。一般为http:localhost:8080/项目名 。
2.首页，末页的逻辑：pn=1访问第一次，pn=${pageInfo.pages}访问最后一页
-->
                <li>
                    <a href="${pageContext.request.contextPath}/company_upload?pn=1">首页</a>
                </li>
                <!-- 如果还有前页就访问当前页码-1的页面， -->
                <c:if test="${pageInfo.hasPreviousPage}">
                    <li>
                        <a href="${pageContext.request.contextPath}/company_upload?pn=${pageInfo.pageNum-1}"
                           aria-label="Previous">
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
                    <li><a href="${pageContext.request.contextPath}/company_upload?pn=${page_Nums}">${page_Nums}</a>
                    </li>
                </c:if>
                </c:forEach>
                </li>
                <!-- 如果还有后页就访问当前页码+1的页面， -->
                <c:if test="${pageInfo.hasNextPage}">
                    <li>
                        <a href="${pageContext.request.contextPath}/company_upload?pn=${pageInfo.pageNum+1}"
                           aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:if>
                <li><a href="${pageContext.request.contextPath}/company_upload?pn=${pageInfo.pages}">末页</a></li>
            </ul>
            <%--</nav>--%>
        </div>
    </div>


</div>


<%--提交详情表单--%>
<form id="company_editid" method="post">
    <input type="hidden" id="userid" name="id"/>
</form>

<script type="text/javascript">

    function company_editid(w) {
        var imageId = $(w).children().attr("id");
        $("#company_editid").attr("action", "<%=basePath%>company_detail");
        $("#userid").attr("value", imageId);
        $("#company_editid").submit();
    }

    $(document).ready(function () {

        <c:forEach items="${pageInfo.list}" var="picture">
        <c:if test="${picture.pictureName != ''}">
        var pic = "${picture.pictureName}";
        if (!(pic == "")) {
            <%--var idv =  "${picture.id}";--%>
            $("#${picture.id}${picture.id}").html("选中发布 (第3步)");
            $("#${picture.id}${picture.id}${picture.id}").show();
        }
        </c:if>
        </c:forEach>


        $("#company_upload_push_check").click(function () {

            var fileUpList = [];
            <c:forEach items="${pageInfo.list}" var="picture">

            if ($("input[id=${picture.id}]").is(":checked")) { //如果选中
                <%--alert("${picture.id}");--%>
                var fileUp = {
                    "id": ${picture.id},
                    "stateId": "3"
                };
                fileUpList.push(fileUp);
            }

            </c:forEach>

//            alert(fileUpList);

            $.ajax({
                type: 'post',
                url: '<%=basePath%>updateBatch',
                contentType: 'application/json;charset=utf-8',//指定为json类型
                //数据格式是json串,多个对象用[]包装
                data: JSON.stringify(fileUpList),
                success: function (data) {
                    console.log(data.toString());
//                        alert("批量修改成功");
                    location.href = "<%=basePath%>company_posted";

                },
                error: function () {
//                        alert("失败");
                }
            });

        });

        $("#company_upload_delete").click(function () {

            var fileUpList = [];
            <c:forEach items="${pageInfo.list}" var="picture">

            if ($("input[id=${picture.id}]").is(":checked")) { //如果选中
                <%--alert("${picture.id}");--%>
                var fileUp = {
                    "id": ${picture.id}
                };
                fileUpList.push(fileUp);
            }

            </c:forEach>

//            alert(fileUpList);

            $.ajax({
                type: 'post',
                url: '<%=basePath%>DeleteBatch',
                contentType: 'application/json;charset=utf-8',//指定为json类型
                //数据格式是json串,多个对象用[]包装
                data: JSON.stringify(fileUpList),
                success: function (data) {
                    console.log(data.toString());
//                        alert("批量修改成功");
                    location.href = "<%=basePath%>company_upload";

                },
                error: function () {
//                        alert("失败");
                }
            });

        });


        $(".company_audit_small").click(function () {

            var fileUpList = [];
            <c:forEach items="${pageInfo.list}" var="picture">

            if ($("input[id=${picture.id}]").is(":checked")) { //如果选中
                <%--alert("${picture.id}");--%>
                var fileUp = {
                    "id": ${picture.id},
                    "stateId": "3"
                };
                fileUpList.push(fileUp);
            }

            </c:forEach>

//            alert(fileUpList);

            $.ajax({
                type: 'post',
                url: '<%=basePath%>updateBatch',
                contentType: 'application/json;charset=utf-8',//指定为json类型
                //数据格式是json串,多个对象用[]包装
                data: JSON.stringify(fileUpList),
                success: function (data) {
                    console.log(data.toString());
//                        alert("批量修改成功");
                    location.href = "<%=basePath%>company_posted";

                },
                error: function () {
//                        alert("失败");
                }
            });


        });


        // 全选/取消全部
        $("#company_upload_all_check").click(function () {


            if ($(".btnWrap input[type='checkbox']").is(":checked")) {
                $(".btnWrap input[type='checkbox']").each(function () {
                    this.checked = false;
                });
            } else {
                $(".btnWrap input[type='checkbox']").each(function () {
                    this.checked = true;
                });
            }
        });


    })
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/ajax_upload.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/file_upload.js"></script>

</body>
</html>