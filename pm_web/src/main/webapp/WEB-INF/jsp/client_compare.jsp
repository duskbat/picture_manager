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
    <title>多图比较页</title>
</head>
<body>
<%@include file="top.jsp"%>


<div class="userCenterWrap">
    <div class="leftNav hidden-xs hidden-sm">
        <ul>
            <li ><a href="client_mark">我的收藏</a></li>
            <li class="active"><a href="client_shoping">购物车</a></li>
            <li ><a href="client_upload">用户上传</a></li>
            <li ><a href="client_auditing">审核结果</a></li>
            <li><a href="client_deal">交易记录</a></li>
            <li><a href="client_setting">个人信息</a></li>
        </ul>
    </div>

    <div class="midCont">

            <div class="favouriteBar">

                <button id="delet_com_pic" >移除多图</button>
                <a href="javascript:void(0)" id="com_del_check" class="edit_selection" style="display: block;font-size: 16px;right: 200px;background-color: #66afe9">全&nbsp;选&nbsp;/&nbsp;取&nbsp;消</a>


            </div><!--favouriteBar-->

    <div class="favouriteGalleryWrap">
                <div class="favouriteGallery layout3 globalDetail" style="position: relative; height: 0px;">

                        <c:forEach items="${pageInfo.list}" var="picture">
                            <%--<c:if test="${picture.compareId==2}">--%>
                            <div class="galleryThumb">
                                <div class="imgWrap">
                                    <img src="http://${webip}:8084/picture_bed/${picture.fileUpEntity.filePathshow}" id="${picture.id}" class="pictures">
                                </div>

                                <div class="btnWrap">
                                    <input type="checkbox" id="${picture.id}" data-shape="circled" data-color="orange" class="checkbix" style="width: 15px;height: 15px">
                                </div>

                                <div class="thumbDetail" style="color: black">
                                    <span>图片名</span><span style="margin-left: 50px">${picture.fileUpEntity.pictureName}</span>
                                    <br>
                                    <span>摄影师</span><span style="margin-left: 50px"><a href="javascript:void(0)">${picture.fileUpEntity.cameraman}</a></span>
                                    <br>
                                    <span>版权所有人</span><span style="margin-left: 26px">${picture.fileUpEntity.owner}</span>
                                    <br>
                                    <span>版权模式</span>
                                    <span style="margin-left: 36px">
                                    <c:if test="${picture.fileUpEntity.mode == 1}">免版税模式RF</c:if>
                                    <c:if test="${picture.fileUpEntity.mode ==2}">版权管理模式RM</c:if>
                                </span>

                                    <br>
                                    <span>图片方向</span>
                                    <span style="margin-left: 36px">
                                     <c:if test="${picture.fileUpEntity.direction ==1}">横图</c:if>
                                    <c:if test="${picture.fileUpEntity.direction ==2}">竖图</c:if>
                                </span>

                                    <br>

                                </div>

                            </div>
                            <%--</c:if>--%>
                        </c:forEach>

                </div>
            </div>

    </div><!--midCont-->

</div><!--userCenterWrap-->

<script type="text/javascript">

    $(document).ready(function(){

        $(".imgWrap").viewer();

        $("#delet_com_pic").click(function() {

            var fileUpList = [];
            <c:forEach items="${pageInfo.list}" var="picture">

            if ($("input[id=${picture.id}]").is(":checked")){ //如果选中
                <%--alert("${picture.id}");--%>
                var fileUp={
                    "id" : ${picture.id},
                    "compareId" : "1"
                };
                fileUpList.push(fileUp);
            }

            </c:forEach>

//            alert(fileUpList);

            $.ajax({
                type : 'post',
                url : '<%=basePath%>updateCompare',
                contentType : 'application/json;charset=utf-8',//指定为json类型
                //数据格式是json串,多个对象用[]包装
                data : JSON.stringify(fileUpList),
                success : function(data) {
                    console.log(data.toString());
//                        alert("批量修改成功");
                    location.href = "<%=basePath%>client_compare";

                },
                error : function() {
//                        alert("失败");
                }
            });



        });



        // 全选/取消全部
        $("#com_del_check").click(function() {
            if ($(".btnWrap input[type='checkbox']").is(":checked")) {
                $(".btnWrap input[type='checkbox']").each(function() {
                    this.checked = false;
                });
            } else {
                $(".btnWrap input[type='checkbox']").each(function() {
                    this.checked = true;
                });
            }
        });




    })
</script>
</body>
</html>