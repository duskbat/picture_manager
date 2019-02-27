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
    <title>订单页</title>
</head>
<body>
<%@include file="top.jsp"%>

<div id="sectionCont">

    <div class="container">
        <div style="font-size: 16px; "><span style="color: #0074D9"><a href="client_shoping">购物车</a></span>&nbsp;&nbsp;/&nbsp;&nbsp;<span>订单页</span></div>
<br>
        <div class="detailWrap">

            <div class="row detailPhotoRow">

                <div class="col-md-5 detailPhoto">
                    <img src="http://${webip}:8084/picture_bed/${fileUps.fileUpEntity.filePathshow}" alt="">
                    <div>
                        <span>图片编号:</span>
                        <span style="margin-left: 10px">${fileUps.fileUpEntity.id}</span>
                        <span style="margin-left: 220px"><a href="javascript:history.go(-1);">返回上一页</a></span>
                    </div>
                </div>


                <div class="col-md-6 detailPhoto">

        <form class="form-horizontal" action="saveClientBuy" name="saveClientBuy" method = "post" enctype='multipart/form-data'>
            <input type="hidden" name="orderPicid" value="${fileUps.picid}"/>
            <input type="hidden" name="orderUserid" value="${fileUps.userid}"/>
            <input type="hidden" name="orderUpload" value="${fileUps.fileUpEntity.userId}"/>
            <input type="hidden" name="price" />
            <input type="hidden" name="payState" value="1"/>
            <input type="hidden" name="contractState" value="1"/>
            <input type="hidden" name="companyState" value="1"/>
            <input type="hidden" name="clientState" value="1"/>


                    <div>
                        <span><h5>图片信息</h5></span>
                    </div>
                    <hr>

                        <div class="scriptionLine">
                        <span class="scriptionLeftSpan">图片名</span>
                        <span style="margin-left: 100px">${fileUps.fileUpEntity.pictureName}</span>
                    </div>

                    <div class="scriptionLine">
                        <span class="scriptionLeftSpan">图片描述</span>
                        <span style="margin-left: 85px">${fileUps.fileUpEntity.instruction}</span>
                    </div>


                    <div class="scriptionLine">
                        <span class="scriptionLeftSpan" style="font-size: 14px">摄影师</span>
                        <span style="margin-left: 100px">${fileUps.fileUpEntity.cameraman}</span>
                    </div>

                    <div class="scriptionLine">
                        <span class="scriptionLeftSpan" style="font-size: 14px">版权所有人</span>
                        <span style="margin-left: 75px">${fileUps.fileUpEntity.owner}</span>
                    </div>

                    <div class="scriptionLine">
                        <span class="scriptionLeftSpan" style="font-size: 14px">版权模式</span>
                        <span style="margin-left: 90px">
                <c:if test="${fileUps.fileUpEntity.mode == 1}">免版税模式RF</c:if>
            <c:if test="${fileUps.fileUpEntity.mode ==2}">版权管理模式RM</c:if></span>

                    </div>

                    <div class="scriptionLine">
                        <span class="scriptionLeftSpan" style="font-size: 14px">图片方向</span>
                        <span style="margin-left: 90px">
                 <c:if test="${fileUps.fileUpEntity.direction ==1}">横图</c:if>
            <c:if test="${fileUps.fileUpEntity.direction ==2}">竖图</c:if></span>

                    </div>

                    <%--<div class="scriptionLine">--%>
                        <%--<span class="scriptionLeftSpan" style="font-size: 14px">分类</span>--%>
                        <%--<span style="margin-left: 120px">--%>
                <%--<c:if test="${fileUps.fileUpEntity.species =='1'}">动物</c:if>--%>
            <%--<c:if test="${fileUps.fileUpEntity.species =='2'}">植物</c:if>--%>
            <%--<c:if test="${fileUps.fileUpEntity.species =='3'}">风景</c:if></span>--%>
                    <%--</div>--%>

                    <hr>

            <div class="scriptionLine">
                <span class="scriptionLeftSpan" style="color: #0074D9">购买需知</span>
                <span style="margin-left: 360px">
                        <a id="hideShow_client_buy" href="javascript:void(0);">收起/展开</a>
                    </span>
            </div>

                    <hr>

                    <div id="hideShow_client_buy_content">

                    <div class="scriptionLine">
                        <span class="scriptionLeftSpan">图片授权类型</span>
                    </div>

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

                    <div>
                        <span><h5><span style="color: #0074D9">*</span>&nbsp;&nbsp;选择用途</h5></span>
                    </div>
                    <hr>

                    <c:if test="${fileUps.fileUpEntity.mode == 1}">
                        <div class="scriptionLine">
                            <span>免版税使用模式RF</span>
                            <span style="margin-left: 100px">请选择图片尺寸</span>
                            <span style="margin-left: 60px"><span style="color: #0074D9">需付金额</span></span>
                            <span class="need_price" style="margin-left: 30px" ></span>
                        </div>
                        <br>


                        <div class="scriptionLine">
                            <span class="scriptionLeftSpan">小尺寸&nbsp;&nbsp;&nbsp;&nbsp;</span>
                            <span class="scriptionLeftSpan">
                              <label class="radio-inline">
                                <input type="radio" class="radioItem" name="application" id="inlineRadio9" value="1">
                                  <span style="margin-left: 30px" class="filepathsamllspan"></span>px
                                <span style="margin-left: 80px">${fileUps.fileUpEntity.smallpathPrice}</span>RMB
                            </label>
                        </span>
                        </div>
                        <br>

                        <div class="scriptionLine">
                            <span class="scriptionLeftSpan">中尺寸&nbsp;&nbsp;&nbsp;&nbsp;</span>
                            <span class="scriptionLeftSpan">
                              <label class="radio-inline">
                                <input type="radio" class="radioItem"  name="application" id="inlineRadio10" value="2">
                                   <span style="margin-left: 30px" class="filepathmidspan"></span>px
                                <span style="margin-left: 80px">${fileUps.fileUpEntity.midpathPrice}</span>RMB
                            </label>
                        </span>
                        </div>
                        <br>

                        <div class="scriptionLine">
                            <span class="scriptionLeftSpan">大尺寸&nbsp;&nbsp;&nbsp;&nbsp;</span>
                            <span class="scriptionLeftSpan">
                              <label class="radio-inline">
                                <input type="radio" class="radioItem"  name="application" id="inlineRadio11" value="3">
                                   <span style="margin-left: 30px" class="filepathbigspan"></span>px
                                <span style="margin-left: 80px">${fileUps.fileUpEntity.bigpathPrice}</span>RMB
                            </label>
                        </span>
                        </div>
                        <br>

                        <div class="scriptionLine">
                            <span class="scriptionLeftSpan" style="color: #0074D9">原图&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
                            <span class="scriptionLeftSpan" style="color: #0074D9">
                              <label class="radio-inline">
                                  <input type="radio" class="radioItem"  name="application" id="inlineRadio12" value="4">
                                  <span style="margin-left: 30px" class="filepathspan"></span ><span style="color: #0074D9">px</span>
                                <span style="margin-left: 80px;color: #0074D9">${fileUps.fileUpEntity.pathPrice}</span><span style="color: #0074D9" >RMB</span>
                            </label>
                        </span>
                        </div>

                        <br>
                        <div class="scriptionLine">
                            <span class="scriptionLeftSpan">图片版权买断和其他用途请联系我们。</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <span class="scriptionLeftSpan">办公电话</span>&nbsp;&nbsp;&nbsp;&nbsp;
                            <span class="scriptionLeftSpan">15546508963</span>
                        </div>


                    </c:if>


                    <c:if test="${fileUps.fileUpEntity.mode ==2}">
                        <div >
                            <span>版权管理模式RM</span>
                            <span style="margin-left: 80px">常用用途如下</span>
                            <span style="margin-left: 50px">需付金额</span>
                            <span class="need_price" style="margin-left: 30px" ></span>
                        </div>
                        <br>

                        <div><h6>网络用途</h6></div>

                        <div >
                            <label class="radio-inline">
                            <input type="radio" class="radioItem" name="application" id="inlineRadio1" value="5">手机应用&nbsp;&nbsp;(小尺寸)
                            </label>
                            <span style="margin-left: 30px" class="filepathsamllspan"></span>px
                            <span style="margin-left: 30px">${fileUps.fileUpEntity.smallpathPrice}</span>RMB
                        </div>

                        <div >
                            <span>
                            <label class="radio-inline">
                            <input type="radio" class="radioItem" name="application" id="inlineRadio2" value="6">网站&nbsp;&nbsp;(中尺寸)
                            </label>
                            <span style="margin-left: 36px" class="filepathmidspan"></span>px
                            <span style="margin-left: 30px">${fileUps.fileUpEntity.midpathPrice}</span>RMB
                        </span>
                        </div>

                        <br>

                        <div><h6>出版用途</h6></div>

                        <div >
                            <span>
                            <label class="radio-inline">
                            <input type="radio" class="radioItem" name="application" id="inlineRadio3" value="7">小尺寸
                            </label>
                            <span style="margin-left: 30px" class="filepathsamllspan"></span>px
                            <span style="margin-left: 30px">${fileUps.fileUpEntity.smallpathPrice}</span>RMB
                        </span>
                        </div>

                        <div >
                            <span>
                            <label class="radio-inline">
                            <input type="radio" class="radioItem" name="application" id="inlineRadio4" value="8">中尺寸
                            </label>
                            <span style="margin-left: 36px" class="filepathmidspan"></span>px
                            <span style="margin-left: 30px">${fileUps.fileUpEntity.midpathPrice}</span>RMB
                        </span>
                        </div>

                        <br>

                        <div><h6>广告用途</h6></div>

                        <div >
                            <span>
                            <label class="radio-inline">
                            <input type="radio" class="radioItem" name="application" id="inlineRadio5" value="9">大尺寸
                            </label>
                            <span style="margin-left: 30px" class="filepathbigspan"></span>px
                            <span style="margin-left: 30px">${fileUps.fileUpEntity.bigpathPrice}</span>RMB
                        </span>
                        </div>

                        <div >
                            <span>
                            <label class="radio-inline">
                            <input type="radio" class="radioItem" name="application" id="inlineRadio6" value="10">原图
                            </label>
                             <span style="margin-left: 30px;color: #0074D9" class="filepathspan"></span><span style="color: #0074D9">px</span>
                            <span style="margin-left: 30px;color: #0074D9">${fileUps.fileUpEntity.pathPrice}</span><span style="color: #0074D9">RMB</span>
                        </span>
                        </div>
                        <br>

                        <div><h6>线下物料</h6></div>

                        <div >
                            <span>
                            <label class="radio-inline">
                            <input type="radio" class="radioItem" name="application" id="inlineRadio7" value="11">小尺寸
                            </label>
                            <span style="margin-left: 30px" class="filepathsamllspan"></span>px
                            <span style="margin-left: 30px">${fileUps.fileUpEntity.smallpathPrice}</span>RMB
                        </span>
                        </div>

                        <div >
                            <span>
                            <label class="radio-inline">
                            <input type="radio" class="radioItem" name="application" id="inlineRadio8" value="12">中尺寸
                            </label>
                             <span style="margin-left: 30px" class="filepathmidspan"></span>px
                            <span style="margin-left: 30px">${fileUps.fileUpEntity.midpathPrice}</span>RMB
                        </span>
                        </div>
                        <br>

                        <div class="scriptionLine">
                            <span class="scriptionLeftSpan">图片版权买断,价格商议和其他用途请联系我们。</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <span class="scriptionLeftSpan">办公电话</span>&nbsp;&nbsp;&nbsp;&nbsp;
                            <span class="scriptionLeftSpan">15546508963</span>
                        </div>


                    </c:if>


                    <hr>

            <div>
                <span><h5><span style="color: #0074D9">*</span>&nbsp;&nbsp;选择使用地区范围</h5></span>
            </div>
            <hr>

            <div>
            <span>
              <label class="radio-inline">
                <input type="radio" class="countryRange" name="countryRange" id="inlineRadio13" value="1" checked="checked" > 中国&nbsp;&nbsp;&nbsp;&nbsp;
            </label>
            <label class="radio-inline">
                <input type="radio" class="countryRange" name="countryRange" id="inlineRadio14" value="2" > 国外&nbsp;&nbsp;&nbsp;&nbsp;
            </label>
            </span>
            </div>


            <hr>

            <div>
                <span><h5><span style="color: #0074D9">*</span>&nbsp;&nbsp;选择使用期限</h5></span>
            </div>
            <hr>

                <div class="scriptionLine">
                    <span class="scriptionLeftSpan" style="font-size: 14px">开始时间</span>
                     <span>
                        <input type="date" name="startTim" class="form-control input-medium usetime " id="datetimepicker1" style="width: 200px;border: 1px solid #204d74;">
                    </span>
                 </div>

            <br>

            <div class="scriptionLine">
                <span class="scriptionLeftSpan" style="font-size: 14px">截止时间</span>
                <span>
                    <input type="date" name="endTim" class="form-control input-medium usetime" id="datetimepicker2" style="width: 200px;border: 1px solid #204d74;">
                </span>
            </div>

            <hr>
                    <div>
                        <span><h5>订单信息</h5></span>
                    </div>
                    <hr>
            <br>

                    <div class="scriptionLine">
                    <span class="scriptionLeftSpan" style="font-size: 14px">图片版权使用者</span>
                    <span style="margin-left: 300px"><a href="client_setting">到<span style="color: #0074D9">个人设置页</span></a></span>
                    <span>
                    <input type="text" value="${fileUps.userEntity.realname}" name="copyrightName" class="form-control"  style="width: 260px;height: 36px;border: 1px solid #204d74;">
                    </span>
                    </div>

                    <div class="scriptionLine">
                    <span class="scriptionLeftSpan" style="font-size: 14px">图片版权使用者身份证号</span>
                    <span>
                        <input type="text" value="${fileUps.userEntity.idcard}" name="copyrightNumber" class="form-control"  style="width: 260px;height: 36px;border: 1px solid #204d74;">
                    </span>
                    </div>


                    <div class="scriptionLine">
                    <span class="scriptionLeftSpan" style="font-size: 14px">手机号</span>
                    <span>
                    <input type="text" value="${fileUps.userEntity.telephone}" name="copyrightTelephone" class="form-control"  style="width: 260px;height: 36px;border: 1px solid #204d74;">
                    </span>
                    </div>

                    <div class="scriptionLine">
                        <span class="scriptionLeftSpan" style="font-size: 14px">邮箱</span>
                        <span>
                            <input type="text" value="${fileUps.userEntity.email}" name="emailBox" class="form-control" style="width: 260px;height: 36px;border: 1px solid #204d74;">
                            </span>
                    </div>

                    <div class="scriptionLine">
                        <span class="scriptionLeftSpan" style="font-size: 14px">邮寄地址</span>
                        <span>
                    <input type="text" value="${fileUps.userEntity.adress}" name="emailAdress" class="form-control" style="width: 260px;height: 36px;border: 1px solid #204d74;">
                    </span>
                    </div>

                    <br>
                    <hr>
            <br>
                <div class="scriptionLine">
                    <span class="scriptionLeftSpan" style="font-size: 14px"><span style="color: #0074D9">*</span>&nbsp;&nbsp;付款账号(请仔细核对)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="color: #0074D9">真实姓名 手机号</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;目前只支持<span style="color: #0074D9">支付宝账号</span></span>
                    <span>
                        <input type="text" name="payAccount" value="${fileUps.userEntity.paycode}" class="form-control" placeholder="真实姓名 手机号" style="width: 260px;height: 36px;border: 1px solid #204d74;">
                    </span>
                </div>
            <br>
            <hr>


            <span style="margin-left: 260px">完善订单信息之前，提交按钮为禁用状态</span>

            <span style="margin-top: 20px">
                 <button id="submit_button" disabled="disabled" type="submit" class="btn btn-primary">提交订单</button>
            </span>

            <br>
                    <hr>

        </form>

                </div>
                <!-- row col-md-6 -->
            </div>
            <!-- row detail -->

        </div>
        <!-- detailWrap -->

    </div>
    <!-- container -->

</div>
<!--sectionCont-->


<script type="text/javascript">

    $(document).ready(function(){


        $(".container").viewer();

        $("#hideShow_client_buy").click(function(){
            $("#hideShow_client_buy_content").toggle();
        });

        $(".radioItem").change(function() {
                var app=$('input:radio[name=application]');
                var start=$("#datetimepicker1").val();
                var end=$("#datetimepicker2").val();

                if(app==true && start!="" && end!=""){
//                    $("#submit_button").show();
                    $("#submit_button").removeAttr("disabled");
                }

            var appvar = $('input:radio[name=application]:checked').val();
            var starttime = new Date(start.replace("-", "/").replace("-", "/"));
            var endtime = new Date(end.replace("-", "/").replace("-", "/"));

            <c:forEach items="${orders}" var="orders">
            var applist = "${orders.application}";
            var startTimelist = "${orders.startTime}";
            var endTimelist = "${orders.endTime}";
                if( applist ==  appvar){
                    if( startTimelist ==  starttime){
                        $("#submit_button").html("重复订单");
                        $("#submit_button").attr("disabled","disabled");
                    }
            }else{
                $("#submit_button").html("提交订单");
                }

            </c:forEach>


        })

        $(".usetime").change(function() {

            var app=$('input:radio[name=application]').is(":checked");
            var start=$("#datetimepicker1").val();
            var end=$("#datetimepicker2").val();

            if(app==true && start!="" && end!=""){$("#submit_button").removeAttr("disabled");}

            var starttime = new Date(start.replace("-", "/").replace("-", "/"));
            var endtime = new Date(end.replace("-", "/").replace("-", "/"));
            if (endtime < starttime) {
                alert('截止时间不能小于开始时间！');
                $("#datetimepicker2").val("");
            }

            var myDate = new Date();
            var nowtimestring = myDate.toLocaleDateString();     //获取当前日期
            var nowtime = new Date(nowtimestring.replace("-", "/").replace("-", "/"));

            if (starttime < nowtime) {
                alert('开始时间不能小于当前时间！');
                $("#datetimepicker1").val("");
            }



            var appvar = $('input:radio[name=application]:checked').val();
            var idvar = "${fileUps.fileUpEntity.id}";

            <c:forEach items="${orders}" var="orders">

                var orderPicidlist = "${orders.orderPicid}";
                var applist = "${orders.application}";
                var startTimelist = "${orders.startTime}";
                var endTimelist = "${orders.endTime}";
                var startTimelistDate = new Date(startTimelist.replace("-", "/").replace("-", "/")).toLocaleDateString();
                 var starttimeDate = new Date(start.replace("-", "/").replace("-", "/")).toLocaleDateString();
//                alert(startTimelistDate +"qqq" +  starttimeDate);

            if( applist ==  appvar && orderPicidlist == idvar){
                if( startTimelistDate ==  starttimeDate){
                    $("#submit_button").html("重复订单");
                    $("#submit_button").attr("disabled","disabled");
                }
            }else{
                $("#submit_button").html("提交订单");
            }

            </c:forEach>


        })



        //尺寸
        $(".filepathspan").html(${imgwidth} + "&nbsp;&nbsp;"+"x"+"&nbsp;&nbsp;" + ${imgheight} );
        $(".filepathbigspan").html(${imgbigwidth} + "&nbsp;&nbsp;"+"x"+"&nbsp;&nbsp;" + ${imgbigheight} );
        $(".filepathmidspan").html(${imgmidwidth} + "&nbsp;&nbsp;"+"x"+"&nbsp;&nbsp;" + ${imgmidheight} );
        $(".filepathsamllspan").html(${imgsmallwidth} + "&nbsp;&nbsp;"+"x"+"&nbsp;&nbsp;" + ${imgsmallheight} );



//        金额变化
        $(".radioItem").change(function() {
            var ps1 = $('input:radio[name=application]:checked').val();

            switch (ps1) {
                case ("1"):
                    $(".need_price").text("${fileUps.fileUpEntity.smallpathPrice}RMB");
                    $('input:hidden[name=price]').val("${fileUps.fileUpEntity.smallpathPrice}");
                    break;
                case ("2"):
                    $(".need_price").text("${fileUps.fileUpEntity.midpathPrice}RMB");
                    $('input:hidden[name=price]').val("${fileUps.fileUpEntity.midpathPrice}");
                    break;
                case ("3"):
                    $(".need_price").text("${fileUps.fileUpEntity.bigpathPrice}RMB");
                    $('input:hidden[name=price]').val("${fileUps.fileUpEntity.bigpathPrice}");
                    break;
                case ("4"):
                    $(".need_price").text("${fileUps.fileUpEntity.pathPrice}RMB");
                    $('input:hidden[name=price]').val("${fileUps.fileUpEntity.pathPrice}");
                    break;
                case ("5"):
                    $(".need_price").text("${fileUps.fileUpEntity.smallpathPrice}RMB");
                    $('input:hidden[name=price]').val("${fileUps.fileUpEntity.smallpathPrice}");
                    break;
                case ("6"):
                    $(".need_price").text("${fileUps.fileUpEntity.midpathPrice}RMB");
                    $('input:hidden[name=price]').val("${fileUps.fileUpEntity.midpathPrice}");
                    break;
                case ("7"):
                    $(".need_price").text("${fileUps.fileUpEntity.smallpathPrice}RMB");
                    $('input:hidden[name=price]').val("${fileUps.fileUpEntity.smallpathPrice}");
                    break;
                case ("8"):
                    $(".need_price").text("${fileUps.fileUpEntity.midpathPrice}RMB");
                    $('input:hidden[name=price]').val("${fileUps.fileUpEntity.midpathPrice}");
                    break;
                case ("9"):
                    $(".need_price").text("${fileUps.fileUpEntity.bigpathPrice}RMB");
                    $('input:hidden[name=price]').val("${fileUps.fileUpEntity.bigpathPrice}");
                    break;
                case ("10"):
                    $(".need_price").text("${fileUps.fileUpEntity.pathPrice}RMB");
                    $('input:hidden[name=price]').val("${fileUps.fileUpEntity.pathPrice}");
                    break;
                case ("11"):
                    $(".need_price").text("${fileUps.fileUpEntity.smallpathPrice}RMB");
                    $('input:hidden[name=price]').val("${fileUps.fileUpEntity.smallpathPrice}");
                    break;
                case ("12"):
                    $(".need_price").text("${fileUps.fileUpEntity.midpathPrice}RMB");
                    $('input:hidden[name=price]').val("${fileUps.fileUpEntity.midpathPrice}");
                    break;

            }




        })



    })

</script>

</body>
</html>
