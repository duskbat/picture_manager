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
    <title>购物车页</title>
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

                <ul class="nav nav-pills">

                    <li><a href="client_compare">多图比较页</a></li>
                    <li><a id="compare_check">添加多图比较</a></li>

                </ul>


                <a href="javascript:void(0)" id="client_shop_check" class="edit_selection" style="display: block;font-size: 16px;right: 230px;background-color: #66afe9">全&nbsp;选&nbsp;/&nbsp;取&nbsp;消</a>

                <a href="javascript:void(0)" class="edit_selection" data-toggle="modal" data-target="#buytake" style="display: block;font-size: 16px;right: 124px;background-color: #515151">购买说明</a>

                <a href="javascript:void(0)" id="delet_shop_check" class="edit_selection" style="display: block;font-size: 16px;right: 24px;background-color: #c9302c ">移&nbsp;&nbsp;&nbsp;除</a>


            </div><!--favouriteBar-->

        <span >当前页面:</span>
        <span style="color: #0074D9">购物车页</span>

    <div class="favouriteGalleryWrap">
                <div class="favouriteGallery layout3 globalDetail" style="position: relative; height: 0px;">

                        <c:forEach items="${pageInfo.list}" var="picture">
                            <%--<c:if test="${ picture.userid==user.id && picture.shopid==2  }">--%>
                            <div class="galleryThumb">
                                <div class="imgWrap">
                                    <a href="javascript:void(0);" onclick="client_buy(this);" title="购买请点击">
                                    <img src="http://${webip}:8084/picture_bed/${picture.fileUpEntity.filePathshow}" id="${picture.id}" class="pictures">
                                    </a>
                                </div>

                                <div class="btnWrap">
                                    <input type="checkbox" id="${picture.id}" data-shape="circled" data-color="orange" class="checkbix" style="width: 15px;height: 15px">
                                    <span style="margin-left: 20px;color: #0074D9">点击图片购买</span>
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
                    <a href="${pageContext.request.contextPath}/client_shoping?pn=1">首页</a>
                </li>
                <!-- 如果还有前页就访问当前页码-1的页面， -->
                <c:if test="${pageInfo.hasPreviousPage}">
                    <li>
                        <a href="${pageContext.request.contextPath}/client_shoping?pn=${pageInfo.pageNum-1}" aria-label="Previous">
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
                    <li ><a href="${pageContext.request.contextPath}/client_shoping?pn=${page_Nums}">${page_Nums}</a></li>
                </c:if>
                </c:forEach>
                </li>
                <!-- 如果还有后页就访问当前页码+1的页面， -->
                <c:if test="${pageInfo.hasNextPage}">
                    <li>
                        <a href="${pageContext.request.contextPath}/client_shoping?pn=${pageInfo.pageNum+1}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:if>
                <li><a href="${pageContext.request.contextPath}/client_shoping?pn=${pageInfo.pages}">末页</a></li>
            </ul>
            <%--</nav>--%>
        </div>
    </div>


</div><!--userCenterWrap-->


<!-- Modal -->
<div class="modal fade" id="buytake" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-body">
                <div style="width: 120px;height: 50px;margin:5px auto;"><h3>购买说明</h3></div>

               <hr>
                <div><h4>1、用户点击图片即可下单</h4></div>


                <div><h4>2、请用户根据自己需求填写完整信息，之后才可提交订单，请将付款账号务必填写正确的支付宝账号</h4></div>


                <div><h4>3、提交订单后到交易记录中核对合同后请扫码付款，付款后用户请选择已付款，方便公司及时查看签字。</h4></div>

                <div><h4>4、允许用户在付款前取消订单</h4></div>

                <div><h4>5、公司在签字后，用户再查看订单详情即可获得您需要的精度和尺寸的图片</h4></div>

                <br>
                <div><h4>&nbsp;&nbsp;&nbsp;&nbsp;友情提示:在个人设置页中填写完整并且真实的信息，每次下单可以自动读入</h4></div>


            </div>
            <div class="modal-footer">
                <%--<span style="margin-right: 120px">用户已阅读</span>--%>
                <button type="button" class="btn btn-danger" data-dismiss="modal" style="width: 80px;padding: 8px;font-size: 16px">关&nbsp;&nbsp;闭</button>
            </div>
        </div>
    </div>
</div>


<%--提交详情表单--%>
<form id="client_buy" method="post">
    <input type="hidden" id="userid" name="id" />
</form>

<script type="text/javascript">

    function client_buy(w){
        var imageId = $(w).children().attr("id");
        $("#client_buy").attr("action","<%=basePath%>client_buy");
        $("#userid").attr("value",imageId);
        $("#client_buy").submit();
    }


    $(document).ready(function(){

        $("#delet_shop_check").click(function() {

            var fileUpList = [];
            <c:forEach items="${pageInfo.list}" var="picture">

            if ($("input[id=${picture.id}]").is(":checked")){ //如果选中
                <%--alert("${picture.id}");--%>
                var fileUp={
                    "id" : ${picture.id},
                    "shopid" : "1"
                };
                fileUpList.push(fileUp);
            }

            </c:forEach>

//            alert(fileUpList);

            $.ajax({
                type : 'post',
                url : '<%=basePath%>updateShop',
                contentType : 'application/json;charset=utf-8',//指定为json类型
                //数据格式是json串,多个对象用[]包装
                data : JSON.stringify(fileUpList),
                success : function(data) {
                    console.log(data.toString());
//                        alert("批量修改成功");
                    location.href = "<%=basePath%>client_shoping";

                },
                error : function() {
//                        alert("失败");
                }
            });



        });

        $("#compare_check").click(function() {

            var fileUpList = [];
            <c:forEach items="${pageInfo.list}" var="picture">

            if ($("input[id=${picture.id}]").is(":checked")){ //如果选中
                <%--alert("${picture.id}");--%>
                var fileUp={
                    "id" : ${picture.id},
                    "compareid" : "2"
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
        $("#client_shop_check").click(function() {
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