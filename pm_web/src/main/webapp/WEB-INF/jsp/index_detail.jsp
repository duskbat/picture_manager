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

    <%--收藏小提示之前用的--%>
    <script src="${pageContext.request.contextPath}/resources/js/tinytip.js"></script>

    <script src="${pageContext.request.contextPath}/resources/js/viewer.js"></script>
    <link href="${pageContext.request.contextPath}/resources/css/viewer.css" rel="stylesheet" />
    <script src="${pageContext.request.contextPath}/resources/js/checkbix.min.js"></script>
    <link href="${pageContext.request.contextPath}/resources/css/checkbix.css" rel="stylesheet" />

    <!-- 模态框 -->
    <script src="${pageContext.request.contextPath}/resources/js/MODALit.min.js"></script>
    <link href="${pageContext.request.contextPath}/resources/css/MODALit.min.css" rel="stylesheet" />


    <link href="${pageContext.request.contextPath}/resources/css/font-awesome.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/awesome-bootstrap-checkbox.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/font.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/css/cont.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/css/layout.css" rel="stylesheet" />
    <link rel="icon" href="${pageContext.request.contextPath}/resources/images/auction1.ico">
    <title>图片详情页</title>
</head>
<body>
<%@include file="top.jsp"%>

<div id="sectionCont">

    <div class="container">

        <div style="font-size: 16px; "><span style="color: #0074D9">图片详情页</span></div>
        <br>

        <div class="detailWrap">

            <div class="row detailPhotoRow">


                <div class="col-md-7 detailPhoto">
                    <img src="http://${webip}:8084/picture_bed/${fileUps.filePathshow}" oncontextmenu="return false" ondragstart="return false" alt="">
                    <div>
                        <span>图片编号:</span>
                        <span style="margin-left: 10px">${fileUps.id}</span>
                        <span style="margin-left: 30px;color: #0074D9">(购买时告知客服图片编号)</span>
                        <span style="margin-left: 130px;color: #0074D9"><a type="button" style="color: #0074D9" data-toggle="tooltip" data-placement="bottom" title="购买后将获得无水印高清图片">友情提示&nbsp;&nbsp;|</a></span>
                        <span style="margin-left: 30px"><a href="javascript:history.go(-1);">返回上一页</a></span>
                    </div>
                </div>




                <div class="col-md-4 detailPhotoDesc">

                    <div class="scriptionLine">
                        <span class="scriptionLeftSpan"><h5>图片信息</h5></span>
                    </div>
                    <hr>

                    <div class="scriptionLine">
                        <span class="scriptionLeftSpan">图片名</span>
                        <span style="margin-left: 100px">${fileUps.pictureName}</span>
                    </div>

                    <div class="scriptionLine">
                        <span class="scriptionLeftSpan">图片描述</span>
                        <span style="margin-left: 85px">${fileUps.instruction}</span>
                    </div>


                    <div class="scriptionLine">
                        <span class="scriptionLeftSpan" style="font-size: 14px">摄影师</span>
                        <span style="margin-left: 100px">${fileUps.cameraman}</span>
                    </div>

                    <div class="scriptionLine">
                        <span class="scriptionLeftSpan" style="font-size: 14px">版权所有人</span>
                        <span style="margin-left: 75px">${fileUps.owner}</span>
                    </div>

                    <div class="scriptionLine">
                        <span class="scriptionLeftSpan" style="font-size: 14px;color: #0074D9">版权模式</span>
                        <span style="margin-left: 90px;color: #0074D9">
                            <c:if test="${fileUps.mode == 1}">免版税模式RF</c:if>
                        <c:if test="${fileUps.mode ==2}">版权管理模式RM</c:if></span>

                    </div>

                    <div class="scriptionLine">
                        <span class="scriptionLeftSpan" style="font-size: 14px;color: #0074D9">图片方向</span>
                        <span style="margin-left: 90px;color: #0074D9">
                             <c:if test="${fileUps.direction ==1}">横图</c:if>
                        <c:if test="${fileUps.direction ==2}">竖图</c:if></span>

                    </div>


                    <div class="scriptionLine">
                        <span class="scriptionLeftSpan" style="font-size: 14px">关键词</span>
                        <span style="margin-left: 100px">${fileUps.myKeywordEntity.keyname}</span>
                        <span style="margin-left: 20px">${fileUps.myKeywordEntityc.keyname}</span>
                        <span style="margin-left: 20px">${fileUps.keythree}</span>
                    </div>

                    <hr>


                    <c:if test="${fileUps.mode == 1}">
                        <div class="scriptionLine">
                            <span style="color: #0074D9">图片的尺寸和匹配的价格</span>
                        </div>
                        <br>

                        <div class="scriptionLine">
                            <span class="scriptionLeftSpan">小尺寸&nbsp;&nbsp;&nbsp;&nbsp;</span>
                            <span style="margin-left: 30px" class="filepathsamllspan"></span>px
                            <span style="margin-left: 80px">${fileUps.smallpathPrice}</span>RMB
                        </div>
                        <br>

                        <div class="scriptionLine">
                            <span class="scriptionLeftSpan">中尺寸&nbsp;&nbsp;&nbsp;&nbsp;</span>
                            <span style="margin-left: 30px" class="filepathmidspan"></span>px
                            <span style="margin-left: 80px" >${fileUps.midpathPrice}</span>RMB
                        </div>
                        <br>

                        <div class="scriptionLine">
                            <span class="scriptionLeftSpan">大尺寸&nbsp;&nbsp;&nbsp;&nbsp;</span>
                            <span style="margin-left: 30px" class="filepathbigspan"></span>px
                            <span style="margin-left: 80px" >${fileUps.bigpathPrice}</span>RMB
                        </div>
                        <br>

                        <div class="scriptionLine">
                            <span class="scriptionLeftSpan" style="color: #0074D9">原图&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
                            <span style="margin-left: 30px;color: #0074D9" class="filepathspan"></span><span style="color: #0074D9">px</span>
                            <span style="margin-left: 80px;color: #0074D9">${fileUps.pathPrice}</span><span style="color: #0074D9">RMB</span>
                        </div>

                        <br>
                        <div class="scriptionLine">
                            <span class="scriptionLeftSpan">图片版权买断和其他用途请联系我们。</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        </div>


                    </c:if>


                    <c:if test="${fileUps.mode ==2}">
                        <div class="scriptionLine">
                            <span style="color: #0074D9">图片的常用用途，以及图片的尺寸和匹配的价格</span>
                        </div>
                        <br>

                        <div><h6>网络用途</h6></div>

                        <div class="scriptionLine">
                            <span class="scriptionLeftSpan">手机应用&nbsp;&nbsp;(小尺寸)</span>
                            <span style="margin-left: 30px" class="filepathsamllspan"></span>px
                            <span style="margin-left: 30px">${fileUps.smallpathPrice}</span>RMB
                        </div>


                        <div class="scriptionLine">
                            <span class="scriptionLeftSpan">网站&nbsp;&nbsp;(中尺寸)</span>
                            <span style="margin-left: 36px" class="filepathmidspan"></span>px
                            <span style="margin-left: 30px">${fileUps.midpathPrice}</span>RMB
                        </div>
                        <br>


                        <div><h6>出版用途</h6></div>

                        <div class="scriptionLine">
                            <span class="scriptionLeftSpan">小尺寸</span>
                            <span style="margin-left: 30px" class="filepathsamllspan"></span>px
                            <span style="margin-left: 30px">${fileUps.smallpathPrice}</span>RMB
                        </div>

                        <div class="scriptionLine">
                            <span class="scriptionLeftSpan">中尺寸</span>
                            <span style="margin-left: 30px" class="filepathmidspan"></span>px
                            <span style="margin-left: 30px">${fileUps.midpathPrice}</span>RMB
                        </div>
                        <br>


                        <div><h6>广告用途</h6></div>

                        <div class="scriptionLine">
                            <span class="scriptionLeftSpan">大尺寸</span>
                            <span style="margin-left: 30px" class="filepathbigspan"></span>px
                            <span style="margin-left: 30px">${fileUps.bigpathPrice}</span>RMB
                        </div>

                        <div class="scriptionLine">
                            <span class="scriptionLeftSpan"><span style="color: #0074D9">原图</span></span>
                            <span style="margin-left: 30px;color: #0074D9" class="filepathspan"></span><span style="color: #0074D9">px</span>
                            <span style="margin-left: 30px;color: #0074D9">${fileUps.pathPrice}</span><span style="color: #0074D9">RMB</span>
                        </div>
                        <br>


                        <div><h6>线下物料</h6></div>

                        <div class="scriptionLine">
                            <span class="scriptionLeftSpan">小尺寸</span>
                            <span style="margin-left: 30px" class="filepathsamllspan"></span>px
                            <span style="margin-left: 30px">${fileUps.smallpathPrice}</span>RMB
                        </div>

                        <div class="scriptionLine">
                            <span class="scriptionLeftSpan">中尺寸</span>
                            <span style="margin-left: 30px" class="filepathmidspan"></span>px
                            <span style="margin-left: 30px">${fileUps.midpathPrice}</span>RMB
                        </div>
                        <br>

                        <div class="scriptionLine">
                            <span class="scriptionLeftSpan">图片版权买断,价格商议和其他用途请联系我们。</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        </div>


                    </c:if>


                    <hr>

                    <div class="scriptionLine">
                        <span class="scriptionLeftSpan" style="color: #0074D9"><h6>线上购买：先收藏，再加购物车&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="client_mark">到&nbsp;&nbsp;<span style="color: #0074D9">我的收藏夹</span></a></h6></span>
                    </div>
                    <br>

                    <div class="scriptionLine">
                        <span class="scriptionLeftSpan" style="margin-left: 12px">
                            <button id="client_mark" data-target="#modal" class="btn btn-primary" style="width: 150px">收&nbsp;&nbsp;&nbsp;&nbsp;藏</button>
                        </span>
                        <span id="${fileUps.id}">
                            <button id="detail_download_check" class="btn btn-warning" style="width: 150px;margin-left: 20px">下&nbsp;&nbsp;&nbsp;&nbsp;载</button>
                        </span>
                        <%--<span id="${fileUps.id}">--%>
                        <%--<button id="index_detail_buy" class="btn btn-warning" style="width: 150px;margin-left: 20px">立即购买</button>--%>
                        <%--</span>--%>
                    </div>
                    <hr>

                    <div class="scriptionLine">
                        <span class="scriptionLeftSpan"><h5>公司联系方式</h5></span>
                    </div>
                    <hr>

                    <div class="scriptionLine">
                        <span>QQ在线咨询</span>
                        <span style="margin-left: 70px">2943489668</span>
                        <span style="margin-left: 15px">
                        <a href="tencent://message/?uin=2943489668">
                            <span style="margin-left: 20px"><img width="24px" height="24px" src="${pageContext.request.contextPath}/resources/images/qqchat.png"/></span>
                        </a>
                        </span>

                    </div>
                    <br>

                    <div class="scriptionLine">
                        <span class="scriptionLeftSpan">公司邮箱</span>
                        <span style="margin-left: 85px">2943489668@qq.com</span>
                    </div>
                    <br>

                    <div class="scriptionLine">
                        <span class="scriptionLeftSpan">公司电话</span>
                        <span style="margin-left: 85px">15546508963</span>
                    </div>

                    <hr>







                </div>


                </div>


        </div>
        <!-- detailWrap -->

    </div>
    <!-- container -->

</div>
<!--sectionCont-->


<div id="modal" class="modalit" aria-hidden="true">
    <div class="dialog">
        <header>
            <h3>已收藏</h3>
        </header>
        <div class="content">
            <p>可以到收藏夹查看</p>
        </div>
        <footer>
            <a href="client_mark"> <button type="button" data-modal-btn="dismiss" class="btn primary">收藏夹></button></a>
        </footer>
    </div>
</div>

<%--&lt;%&ndash;提交详情表单&ndash;%&gt;--%>
<%--<form id="index_buy" method="post">--%>
    <%--<input type="hidden" id="userid" name="id" />--%>
<%--</form>--%>

<script type="text/javascript">

    var modal = new MODALit({
        el: '#client_mark',
        position: 'bottom right'
    });


    $(document).ready(function(){


        $(".container").viewer();

        $("#client_mark").click(function() {
            var pictureUserList = [];
            var pictureUser={
                "picid" : ${fileUps.id},
                "userid" : ${user.id}
            }
            pictureUserList.push(pictureUser);

//            alert(fileUpList);

            $.ajax({
                type : 'post',
                url : '<%=basePath%>insertMark',
                contentType : 'application/json;charset=utf-8',//指定为json类型
                //数据格式是json串,多个对象用[]包装
                data : JSON.stringify(pictureUserList),
                success : function(data) {
                    console.log(data.toString());
//                        alert("批量修改成功");
                },
                error : function() {
//                        alert("失败");
                }
            });



        });

        <%--$("#index_detail_buy").click(--%>
            <%--function ()--%>
            <%--{--%>
                <%--$("#index_buy").attr("action","<%=basePath%>client_buy");--%>
                <%--$("#userid").attr("value",$(this).parent().attr("id"));--%>
                <%--$("#index_buy").submit();--%>
            <%--}--%>
        <%--);--%>




        $("#detail_download_check").click(function () {
//alert($(this).parent().attr("id"));

                download("filedownload", {file_id: $(this).parent().attr("id")});

            }
        );

        function download(action, datas)
        {
            var form=$("<form>");

            form.css("display", "none");

            form.attr("target", "");

            form.attr("method", "post");

            form.attr("action", action);

            $.each
            (
                datas,

                function (key)
                {
                    var input = $("<input>");

                    input.attr("type", "hidden");

                    input.attr("name", key);

                    input.attr("value", datas[key]);

                    form.append(input);
                }
            );

            $("body").append(form);//将表单放置在web中

            form.submit();//表单提交

            form.remove();
        }


        //尺寸
        $(".filepathspan").html(${imgwidth} + "&nbsp;&nbsp;"+"x"+"&nbsp;&nbsp;" + ${imgheight} );
        $(".filepathbigspan").html(${imgbigwidth} + "&nbsp;&nbsp;"+"x"+"&nbsp;&nbsp;" + ${imgbigheight} );
        $(".filepathmidspan").html(${imgmidwidth} + "&nbsp;&nbsp;"+"x"+"&nbsp;&nbsp;" + ${imgmidheight} );
        $(".filepathsamllspan").html(${imgsmallwidth} + "&nbsp;&nbsp;"+"x"+"&nbsp;&nbsp;" + ${imgsmallheight} );



<c:forEach items="${pictureUsers}" var="pictureUsers">
        if(${pictureUsers.fileUpEntity.id}==${fileUps.id}){
            $("#client_mark").html("已收藏");
            $("#client_mark").attr("disabled","disabled");
        }
</c:forEach>


    })


</script>

</body>
</html>
