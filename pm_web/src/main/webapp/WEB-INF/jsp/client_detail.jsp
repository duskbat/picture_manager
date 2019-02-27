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
    <title>图片编辑页</title>
</head>
<body>
<%@include file="top.jsp"%>


<div id="sectionCont">

    <div class="leftNav hidden-xs hidden-sm" style="margin-top: 112px">
        <ul>
            <li ><a href="client_mark">我的收藏</a></li>
            <li><a href="client_shoping">购物车</a></li>
            <li class="active"><a href="client_upload">用户上传</a></li>
            <li ><a href="client_auditing">审核结果</a></li>
            <li><a href="client_deal">交易记录</a></li>
            <li><a href="client_setting">个人信息</a></li>
        </ul>
    </div>


</div>
<!--sectionCont-->


<div style="margin-left: 160px">

    <form class="form-horizontal" action="saveClientDetail" name="formEdit" method = "post" enctype='multipart/form-data'>
        <input type="hidden" id="userid" name="id" value="${fileUps.id}"/>
        <input type="hidden" name="reason" value="${fileUps.reason}"/>

        <div class="row detailPhotoRow">

            <div id="big_client_detail">
            <div class="col-md-6 detailPhoto">
                <img src="http://${webip}:8084/picture_bed/${fileUps.filePath}" alt="">
                <div>
                    <span>图片编号:</span>
                    <span style="margin-left: 10px">${fileUps.id}</span>
                    <span style="margin-left: 380px"><a href="javascript:history.go(-1);">返回上一页</a></span>
                </div>
                <br>
                <br>
            </div>
            </div>

            <div class="col-md-4 detailPhotoDesc">

                <div class="scriptionLine">
                    <span class="scriptionLeftSpan"><h5>图片信息</h5></span>
                </div>
                <hr>

                <div class="scriptionLine">
                    <span class="scriptionLeftSpan" style="font-size: 14px">图片名</span>
                    <span>
                        <input type="text" value="${fileUps.pictureName}" name="pictureName" class="form-control" placeholder="图片名" style="width: 260px;height: 36px;border: 1px solid #204d74;">
                    </span>
                </div>
                <hr>

                <div class="scriptionLine">
                    <span class="scriptionLeftSpan" style="font-size: 14px">图片描述</span>
                    <span>
                        <input type="text" height="60px" value="${fileUps.instruction}" name="instruction" class="form-control" placeholder="图片描述" style="width: 260px;height: 36px;border: 1px solid #204d74;">
                    </span>
                </div>
                <hr>


                <div class="scriptionLine">
                    <span class="scriptionLeftSpan" style="font-size: 14px;color: #0074D9">摄影师</span>
                    <span>
                     <input type="text" value="${fileUps.cameraman}" name="cameraman" class="form-control" placeholder="摄影师" style="width: 260px;height: 36px;border: 1px solid #204d74;">
                </span>
                </div>
                <hr>

                <div class="scriptionLine">
                    <span class="scriptionLeftSpan" style="font-size: 14px;color: #0074D9">版权所有人&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;姓名/公司名称</span>
                    <span>
                        <input type="text" value="${fileUps.owner}" name="owner" class="form-control" placeholder="姓名/公司名称" style="width: 260px;height: 36px;border: 1px solid #204d74;">
                    </span>
                </div>
                <hr>


                <div class="scriptionLine">
                    <span class="scriptionLeftSpan" style="font-size: 14px;color: #0074D9">版权所有人&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;身份证号/公司注册号</span>
                    <span>
                     <input type="text" value="${fileUps.ownerNumber}" name="ownerNumber" class="form-control" placeholder="身份证号/公司注册号" style="width: 260px;height: 36px;border: 1px solid #204d74;">
                </span>
                </div>

                <hr>


                <div class="scriptionLine">
                    <span class="scriptionLeftSpan" style="color: #0074D9">购买需知</span>
                    <span style="margin-left: 200px">
                        <a id="hideShow_client_detail" href="javascript:void(0);">收起/展开</a>
                    </span>
                </div>

                <hr>

                <div id="hideShow_client_detail_content">

                <div class="scriptionLine">
                    <span class="scriptionLeftSpan">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;图片授权类型是由图片卖家设定，图片买家根据自己的需要来进行选择。摄影师可以根据自己的销售意愿，在编辑图片的时候，对自己的图片进行相应授权模式的设定。</span>
                </div>

                <div class="scriptionLine">
                    <span class="scriptionLeftSpan">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;版权管理模式RM，客户每次使用该类图片，都必须获取使用授权，授权价格是根据最终客户使用的次数、用途、地域、使用期限、使用周期、图片大小等因素来计算的。最终用户也有机会买断图片的使用权。</span>
                </div>

                <div class="scriptionLine">
                    <span class="scriptionLeftSpan">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;免版税使用模式RF，用户购买使用授权后，其使用图片不受使用次数、时间、空间、用途限制。授权价格主要取决于图片的尺寸。一次购买可以在多重时间内用于多个用途，而不需付任何附加费用。但是只供购买者自己使用，不可以转让或再次出售，也不能被买断独家使用权。</span>
                </div>
                <hr>

                </div>

                <span class="scriptionLeftSpan" style="color: #0074D9">版权模式&nbsp;&nbsp;&nbsp;&nbsp;<span style="color: #0074D9">**必选**</span></span>
                <div class="scriptionLine">
                    <span class="scriptionLeftSpan">
                              <label class="radio-inline">
                                <input type="radio" name="mode" id="inlineRadio1" value="1" <c:if test="${fileUps.mode == 1}">checked="checked"</c:if>>免版税模式RF&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="mode" id="inlineRadio2" value="2" <c:if test="${fileUps.mode == 2}">checked="checked"</c:if>>版权管理模式RM&nbsp;&nbsp;
                            </label>
                        </span>
                </div>
                <br>


                <span class="scriptionLeftSpan" style="color: #0074D9">图片方向&nbsp;&nbsp;&nbsp;&nbsp;</span>
                <div class="scriptionLine">
                    <span class="scriptionLeftSpan">
                              <label class="radio-inline">
                                <input type="radio" name="direction" id="inlineRadio3" value="1" <c:if test="${fileUps.direction == 1}">checked="checked"</c:if>> 横图&nbsp;&nbsp;&nbsp;&nbsp;
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="direction" id="inlineRadio4" value="2" <c:if test="${fileUps.direction == 2}">checked="checked"</c:if>> 竖图&nbsp;&nbsp;&nbsp;&nbsp;
                            </label>
                        </span>
                </div>
                <br>


                <%--<span class="scriptionLeftSpan">分类&nbsp;&nbsp;&nbsp;&nbsp;</span>--%>
                <%--<div class="scriptionLine">--%>
                    <%--<span class="scriptionLeftSpan">--%>
                              <%--<label class="radio-inline">--%>
                                <%--<input type="radio" name="species" id="inlineRadio5" value="1" <c:if test="${fileUps.species == 1}">checked="checked"</c:if>> 动物&nbsp;&nbsp;&nbsp;&nbsp;--%>
                            <%--</label>--%>
                            <%--<label class="radio-inline">--%>
                                <%--<input type="radio" name="species" id="inlineRadio6" value="2" <c:if test="${fileUps.species == 2}">checked="checked"</c:if>> 植物&nbsp;&nbsp;&nbsp;&nbsp;--%>
                            <%--</label>--%>
                        <%--<label class="radio-inline">--%>
                                <%--<input type="radio" name="species" id="inlineRadio7" value="3" <c:if test="${fileUps.species == 3}">checked="checked"</c:if>>风景&nbsp;&nbsp;&nbsp;&nbsp;--%>
                            <%--</label>--%>
                        <%--</span>--%>
                <%--</div>--%>
                <%--<br>--%>


                <hr>
                <div><span style="color: #0074D9">关键词</span></div>
                <br>

                <span style="color: #0074D9">请选择关键词<span style="margin-left: 15px">点击选框弹出词库</span></span>
                <br>

                <select id="keyone_select" class="form-control" value="${fileUps.keyone}" data-style="btn-primary" name="keyone" style="width: 260px;height: 36px;border: 1px solid #204d74;" >
                    <c:forEach items="${myKeywords}" var="myKeyword" varStatus="i">
                        <option value="${myKeyword.id}" >${myKeyword.keyname}</option>
                    </c:forEach>
                </select>

                <br>

                <span style="color: #0074D9">请选择关键词<span style="margin-left: 15px">点击选框弹出词库</span></span>
                <br>


                <select id="keytwo_select" class="form-control" value="${fileUps.keytwo}" data-style="btn-primary" name="keytwo" style="width: 260px;height: 36px;border: 1px solid #204d74;">
                    <c:forEach items="${myKeywords}" var="myKeyword" varStatus="i">
                        <option value="${myKeyword.id}" >${myKeyword.keyname}</option>
                    </c:forEach>
                </select>

                <br>

                <span>用户自定关键词</span>
                <br>

                <input type="text" value="${fileUps.keythree}" name="keythree" class="form-control" placeholder="用户自定关键词" style="width: 260px;height: 36px;border: 1px solid #204d74;">

                <hr>

                <div class="scriptionLine">
                    <span class="scriptionLeftSpan"><h5>用户自定图片价格(RMB)</h5></span>
                </div>
                <hr>

                <div class="scriptionLine">
                    <span class="scriptionLeftSpan" style="font-size: 14px;color: #0074D9">原图价格</span>
                    <span>
                        <input type="text" value="${fileUps.pathPrice}" name="pathPrice" class="form-control" placeholder="原图价格" style="width: 260px;height: 36px;border: 1px solid #204d74;">
                    </span>
                </div>

                <br>
                <div>在用户上传图片时，图片会自动被压缩成大、中、小尺寸,便于销售。</div>
                <div><span style="color: #0074D9">请用户自定义大、中、小尺寸图片的价格</span></div>
                <br>


                <div class="scriptionLine">
                    <span class="scriptionLeftSpan" style="font-size: 14px;color: #0074D9">大尺寸图片价格</span>
                    <span>
                        <input type="text" value="${fileUps.bigpathPrice}" name="bigpathPrice" class="form-control" placeholder="大尺寸图片价格" style="width: 260px;height: 36px;border: 1px solid #204d74;">
                    </span>
                </div>

                <br>


                <div class="scriptionLine">
                    <span class="scriptionLeftSpan" style="font-size: 14px;color: #0074D9">中尺寸图片价格</span>
                    <span>
                        <input type="text" value="${fileUps.midpathPrice}" name="midpathPrice" class="form-control" placeholder="中尺寸图片价格" style="width: 260px;height: 36px;border: 1px solid #204d74;">
                    </span>
                </div>
                <br>

                <div class="scriptionLine">
                    <span class="scriptionLeftSpan" style="font-size: 14px;color: #0074D9">小尺寸图片价格</span>
                    <span>
                        <input type="text" value="${fileUps.smallpathPrice}" name="smallpathPrice" class="form-control" placeholder="小尺寸图片价格" style="width: 260px;height: 36px;border: 1px solid #204d74;">
                    </span>
                </div>
                <br>

                <hr>


                <button type="submit" class="btn btn-primary">保&nbsp;&nbsp;&nbsp;&nbsp;存</button>

                <hr>

            </div>

        </div>


    </form>

</div>
<!-- container -->


<script type="text/javascript">

    $(document).ready(function(){

        $("#big_client_detail").viewer();

        $("#hideShow_client_detail").click(function(){
            $("#hideShow_client_detail_content").toggle();
        });


        $("#keyone_select  option[value='${fileUps.keyone}'] ").attr("selected",true)
        $("#keytwo_select  option[value='${fileUps.keytwo}'] ").attr("selected",true)


    })
</script>

</body>
</html>
