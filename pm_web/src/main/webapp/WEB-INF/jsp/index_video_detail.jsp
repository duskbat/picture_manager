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
    <title>视频详情页</title>
</head>
<body>
<%@include file="video_top.jsp"%>

<div id="sectionCont">

    <div class="container">

        <div class="detailWrap">

            <div class="row detailPhotoRow">

                <div class="col-md-6 detailPhoto">
                    <video id="myVideo" width="480" height="360" controls>
                        <source src="http://${webip}:8084/picture_bed/${fileUps.filePathshow}" type="video/mp4">
                    </video>
                    <hr>
                    <div>
                        <span>视频编号:</span>
                        <span style="margin-left: 10px">${fileUps.id}</span>
                        <span style="margin-left: 380px"><a href="javascript:history.go(-1);">返回上一页</a></span>
                    </div>


                </div>


                <div class="col-md-4 detailPhotoDesc">

                    <div class="scriptionLine">
                        <span class="scriptionLeftSpan"><h5>视频信息</h5></span>
                    </div>
                    <hr>

                    <div class="scriptionLine">
                        <span class="scriptionLeftSpan">视频名</span>
                        <span style="margin-left: 100px">${fileUps.pictureName}</span>
                    </div>

                    <div class="scriptionLine">
                        <span class="scriptionLeftSpan">视频描述</span>
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
                        <span class="scriptionLeftSpan" style="font-size: 14px">视频分辨率</span>
                        <span style="margin-left: 90px">
                             <c:if test="${fileUps.species ==1}">标清720P</c:if>
                            <c:if test="${fileUps.species ==2}">高清1080P</c:if>
                            <c:if test="${fileUps.species ==3}">4K</c:if>
                        </span>

                    </div>


                    <div class="scriptionLine">
                        <span class="scriptionLeftSpan" style="font-size: 14px">关键词</span>
                        <span style="margin-left: 100px">${fileUps.myKeywordEntity.keyname}</span>
                        <span style="margin-left: 20px">${fileUps.myKeywordEntityc.keyname}</span>
                        <span style="margin-left: 20px">${fileUps.keythree}</span>
                    </div>

                    <div class="scriptionLine">
                        <span class="scriptionLeftSpan">用户定价</span>
                        <span style="margin-left: 85px">${fileUps.pathPrice}</span>
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
                    <br>

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

    $('#myVideo').bind('contextmenu',function() { return false; });

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




//        $('#client_mark').tinytip({
//            //position [top|bottom|left|right]
//            position : 'bottom',
//
//            //tooltip position fix [+-][yx]
//            fix : {
//                top : -80,
//                left: +8
//            },
//
//            //animation effect start position [+,-][top,left]
//            //example +10 => animate up 10 pixels
//            animation : {
//                top : +10,
//                left: -5,
//            },
//
//            //animation speed in milliseconds
//            speed : 100,
//
//            //tooltip text, or can be a jQuery object of
//            //selected element
//            tooltip : "已收藏" || $('.some-selector'),
//
//            //when to show tooltip event (default: mouseenter)
//            on : 'click',
//
//            //when to hide tooltip event (default: mouseleave)
//
//
//            //prevent tooltip close when hover over it
//            preventClose : true,
//
//            //callback function fired once the tooltip completely loaded
//            //passes tooltip element jQuery object (e)
//            onLoad : function(e){
//                e.text('lool');
//            },
//
//            //add custom class to this tooltip
//            addClass : 'unique'
//        });


    })


</script>


</body>
</html>
