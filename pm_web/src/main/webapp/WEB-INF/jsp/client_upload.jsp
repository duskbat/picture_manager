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


    <!-- 进度条 -->
    <script src="${pageContext.request.contextPath}/resources/js/jquery.lineProgressbar.js"></script>
    <link href="${pageContext.request.contextPath}/resources/css/jquery.lineProgressbar.css" rel="stylesheet" />


    <link href="${pageContext.request.contextPath}/resources/css/font-awesome.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/awesome-bootstrap-checkbox.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/font.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/css/cont.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/css/layout.css" rel="stylesheet" />
    <link rel="icon" href="${pageContext.request.contextPath}/resources/images/auction1.ico">
    <title>图片上传页</title>
</head>
<body>
<%@include file="top.jsp"%>

<div class="userCenterWrap">

    <div class="leftNav hidden-xs hidden-sm">
        <ul>
            <li ><a href="client_mark">我的收藏</a></li>
            <li><a href="client_shoping">购物车</a></li>
            <li class="active"><a href="client_upload">用户上传</a></li>
            <li ><a href="client_auditing">审核结果</a></li>
            <li><a href="client_deal">交易记录</a></li>
            <li><a href="client_setting">个人信息</a></li>
        </ul>
    </div>

    <div class="midCont">

        <div class="favouriteBar">

            <a href="client_video_upload" class="edit_selection" style="display: block;font-size: 16px;right: 80%;background-color: #4a86e8">进入视频上传页</a>
            <a href="javascript:void(0)" class="edit_selection" data-toggle="modal" data-target="#myModal" style="display: block;font-size: 16px;right: 72%;background-color: #515151">上传协议</a>
            <a href="javascript:void(0)" class="edit_selection" data-toggle="modal" data-target="#show" style="display: block;font-size: 16px;right: 65%;background-color: #FF851B">上传说明</a>

            <button id="client_upload_button" >图片上传<span style="margin-left: 15px;font-size: 12px">(第1步)</span></button>

            <div id="progressbar2" style="width: 16%;position: absolute;right:48%"></div>

            <%--<a id="wait" class="edit_selection" style="display: block;font-size: 16px;right: 364px;background-color: #00ad7d;display: none">图片上传中，请稍后</a>--%>

            <a href="javascript:void(0)" id="client_upload_all_check" class="edit_selection" style="display: block;font-size: 16px;right: 15%;background-color: #66afe9">全&nbsp;选&nbsp;/&nbsp;取&nbsp;消</a>
            <a href="javascript:void(0)" id="client_audit" class="edit_selection" style="display: block;font-size: 16px;right: 8%;">批量提交</a>
            <a href="javascript:void(0)" id="client_upload_delete" class="edit_selection" style="display: block;font-size: 16px;right: 2%;background-color: #c9302c ">删&nbsp;&nbsp;&nbsp;除</a>

        </div><!--favouriteBar-->

        <span >当前页面:</span>
        <span style="color: #0074D9">图片上传页</span>

        <div class="favouriteGalleryWrap">
            <div class="favouriteGallery layout3 globalDetail" style="position: relative; height: 0px;">
                <c:forEach items="${pageInfo.list}" var="picture">
                    <%--<c:if test="${picture.stateId==1 && picture.userId==user.id}">--%>
                        <div class="galleryThumb">
                            <div class="imgWrap">
                                <a href="javascript:void(0);" onclick="clientDetail(this);">
                                    <img src="http://${webip}:8084/picture_bed/${picture.filePathshow}" id="${picture.id}" class="pictures">
                                </a>
                            </div>

                            <div class="btnWrap">
                                <input type="checkbox" id="${picture.id}" data-shape="circled" data-color="orange" class="checkbix" style="width: 15px;height: 15px">
                                <span id="${picture.id}${picture.id}" style="margin-left: 15px;color: #0074D9">点击图片编辑<span style="margin-left: 10px;font-size: 10px">(第2步)</span></span>
                                <br>
                                <button id="${picture.id}${picture.id}${picture.id}" class="client_audit_small" style="display: none;width: 180px;height: 30px;padding: 3px;font-size: 15px;">提&nbsp;交&nbsp;审&nbsp;核</button>

                            </div>

                            <div class="thumbDetail" style="color: black">
                                <span>图片编号</span><span style="margin-left: 50px">${picture.id}</span>
                                <br>
                                <span>图片名</span><span style="margin-left: 50px">${picture.pictureName}</span>
                                <br>
                                <span>摄影师</span><span style="margin-left: 50px"><a href="javascript:void(0)">${picture.cameraman}</a></span>
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
                                <%--<span>分类</span>--%>
                                <%--<span style="margin-left: 60px">--%>
                                     <%--<c:if test="${picture.species =='1'}">动物</c:if>--%>
                                    <%--<c:if test="${picture.species =='2'}">植物</c:if>--%>
                                    <%--<c:if test="${picture.species =='3'}">风景</c:if>--%>
                                <%--</span>--%>
                                <%--<br>--%>
                            </div>

                        </div>
                    <%--</c:if>--%>
                </c:forEach>
            </div>
        </div>



        <%--分页--%>
        <div class="row">

            <div class="col-xs-6 col-md-4" style="color: #5e5e5e; font-size: 16px;margin-left: 100px">
                当前是第&nbsp;${pageInfo.pageNum}&nbsp;页,&nbsp;&nbsp;共&nbsp;${pageInfo.pages }&nbsp;页,&nbsp;&nbsp;总&nbsp;${pageInfo.total }&nbsp;张图片
            </div>

            <div class="col-xs-6 col-md-4" style="color: #5e5e5e; font-size: 16px;margin-left: 250px">

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
                            <a href="${pageContext.request.contextPath}/company_upload?pn=${pageInfo.pageNum-1}" aria-label="Previous">
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
                        <li ><a href="${pageContext.request.contextPath}/company_upload?pn=${page_Nums}">${page_Nums}</a></li>
                    </c:if>
                    </c:forEach>
                    </li>
                    <!-- 如果还有后页就访问当前页码+1的页面， -->
                    <c:if test="${pageInfo.hasNextPage}">
                        <li>
                            <a href="${pageContext.request.contextPath}/company_upload?pn=${pageInfo.pageNum+1}" aria-label="Next">
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

</div><!--userCenterWrap-->



<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <%--<div class="modal-header">--%>
                <%--<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>--%>
                <%--<h4 class="modal-title" id="myModalLabel">上传协议</h4>--%>
            <%--</div>--%>
            <div class="modal-body">
                <div style="width: 240px;height: 50px;margin:6px auto;"><h3>用户上传图片协议书</h3></div>

                <div><h4>第一条、 本协议当事人双方及协议成立</h4></div>
                <div>1、 一方为自然影像网，同意按照本协议的规定及其不时发布的操作规则提供基于互联网以及移动网相关服务。
                    另一方是为获得网络服务的服务使用人（以下称用户）。</div>
                <div>2、 用户在本网站上上传图片即表示用户完全接受本协议项下的全部条款。</div>
                <div>3、 用户应当对以其用户帐号进行的所有活动和事件负法律责任。</div>
                <div>4、 自然影像网针对某些特定的自然影像网网络服务的使用通过各种方式
                    （包括但不限于网页公告、电子邮件、短信提醒等）作出的任何声明、通
                    知、警示等内容视为本协议的一部分，用户如使用该等自然影像网网络
                    服务，视为用户同意该等声明、通知、警示的内容。</div>
                <br>

                <div><h4>第二条、 自然影像网的权利与义务</h4></div>
                <div>1、自然影像网有权将作品缩略图等展示于高品摄影社区、第三方网站、
                    网络搜索结果、可嵌入代码中，用于展示、推广的目的。</div>
                <div>2、自然影像网将采用行业内认可的软件和措施，用以限制其他用户或浏
                    览者未经许可任意复制高清晰度的作品。但自然影像网无法保证未经
                    用户许可，其上传的作品不会被他人非法复制。自然影像网不会限制
                    其他用户或浏览者复制网站中的低清晰度作品或缩略图，对此用户应同
                    意并给予自然影像网相应授权。</div>
                <div>3、鉴于网络服务的特殊性，用户同意自然影像网有权随时变更、中断或
                    终止部分或全部的网络服务（包括收费网络服务）。如变更、中断或终止
                    的网络服务属于免费网络 服务，自然影像网无需通知用户，也无需对
                    任何用户或任何第三方承担任何责任；如变更、中断或终止的网络服务
                    属于收费网络服务，自然影像网应当在变更、中断或终止之前事先通
                    知用户，并应向受影响的用户提供等值的替代性的收费网络服务，如用
                    户不愿意接受替代性的收费网络服务，就该用户已经向自然影像网支
                    付的服务费，自然影像网应当按照该用户实际使用相应收费网络服务
                    的情况扣除相应服务费之后将剩余的服务费退还给该用户。</div>
                <br>

                <div><h4>第三条、 用户的权利与义务</h4></div>
                <div>1、用户在申请使用自然影像网网络服务时，必须向自然影像网提供
                    准确的个人资料，如个人资料有任何变动，必须及时更新。</div>
                <div>2、  用户不应将其帐号、密码转让或出借予他人使用。如用户发现其帐
                    号遭他人非法使用，应立即通知自然影像网。因黑客行为或用户的
                    保管疏忽导致帐号、密码遭他人非法使用，自然影像网不承担任何
                    责任。</div>
                <div>3、  用户必须同意接受自然影像网通过电子邮件或其他方式向用户发
                    送商品促销或其他相关商业信息。</div>
                <div>4、  用户有权随时将上传的作品删除，自然影像网也可删除任何违反本
                    协议规定的作品。在收到用户提交的删除申请后，自然影像网将在
                    合 理期限内删除展示在任何第三方网站上的该用户作品。</div>
                <br>

                <div ><h4>第四条、 免责条款</h4></div>
                <div> 1、用户明确同意其使用自然影像网网络服务所存在的风险将完全由其自
                    己承担；因其使用自然影像网网络服务而产生的一切后果也由其自己
                    承担，自然影像网对用户不承担任何责任。</div>
                <div>2、自然影像网不担保网络服务一定能满足用户的要求，也不担保网络服
                    务不会中断，对网络服务的及时性、安全性、准确性也都不作担保。</div>
                <div>3、自然影像网不保证为向用户提供便利而设置的外部链接的准确性和完
                    整性，同时，对于该等外部链接指向的不由自然影像网实际控制的任
                    何网页上的内容，自然影像网不承担任何责任。</div>
                <div>4、对于因不可抗力或自然影像网不能控制的原因造成的网络服务中断或
                    其它缺陷，自然影像网不承担任何责任，但将尽力减少因此而给用户
                    造成的损失和影响。</div>
                <br>

                <div><h4>第四条、 诉讼管辖及适用法律</h4></div>
                <div>1、如双方就本协议内容或其执行发生任何争议，双方应尽量友好协商解决；协
                    商不成时，任何一方均可向高品摄影社区所在地的人民法院提起诉讼。</div>
                <div> 2、本协议的订立、执行和解释及争议的解决均应适用中国法律并受中国法院管
                    辖。</div>
                <br>

            </div>
            <div class="modal-footer">
                <span style="margin-right: 420px">用户上传代表已同意</span>
                <button type="button" class="btn btn-danger" data-dismiss="modal" style="width: 80px;padding: 8px;font-size: 16px">关&nbsp;&nbsp;闭</button>
            </div>
        </div>
    </div>
</div>


<!-- Modal -->
<div class="modal fade" id="show" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-body">
                <div style="width: 120px;height: 50px;margin:5px auto;"><h3>上传说明</h3></div>

                <hr>
                <div><h4>1、支持用户批量上传图片，并且用户可以批量清理图片</h4></div>


                <div><h4>2、用户点击图片可以对图片进行编辑，编辑后需要提交审核到公司。公司审核通过后，会将图片发布到平台上展示。
                如果审核未通过，公司会指明退回的原因，用户可以根据要求退回编辑修改，再次提交给公司审核。</h4></div>

                <div><h4>3、用户可以在审核结果页实时关注自己上传的图片的审核结果</h4></div>


                <div><h4>4、如果有其他用户购买了您上传的图片，在您的交易记录页的用户未收款项中将会出现这条记录，公司将会把金额全额返还给您。
               公司将会通过打电话或发邮件的方式告知您，如果您上传了图片但是在设置页没有补全自己的真实信息，造成的后果公司将不会承担</h4></div>


                <br>
                <div><h4>友情提示:在个人设置页中填写完整并且真实的信息，公司才能联系到您</h4></div>


            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-dismiss="modal" style="width: 80px;padding: 8px;font-size: 16px">关&nbsp;&nbsp;闭</button>
            </div>
        </div>
    </div>
</div>


<%--提交详情表单--%>
<form id="client_detail_form" method="post">
    <input type="hidden" id="userid" name="id" />
</form>

<script type="text/javascript">

    function clientDetail(w){
        var imageId = $(w).children().attr("id");
        $("#client_detail_form").attr("action","<%=basePath%>client_detail");
        $("#userid").attr("value",imageId);
        $("#client_detail_form").submit();
    }

    $(document).ready(function(){

        <c:forEach items="${pageInfo.list}" var="picture">
            <c:if test="${picture.pictureName != ''}">
        var pic = "${picture.pictureName}";
        if(!(pic=="")){
            <%--var idv =  "${picture.id}";--%>
            $("#${picture.id}${picture.id}").html("选中提交审核 (第3步)");
            $("#${picture.id}${picture.id}${picture.id}").show();
        }
            </c:if>
        </c:forEach>

        $("#client_audit").click(function() {

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
                    location.href = "<%=basePath%>client_auditing";
                },
                error : function() {
//                        alert("失败");
                }
            });


        });

        $(".client_audit_small").click(function() {

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
                    location.href = "<%=basePath%>client_auditing";
                },
                error : function() {
//                        alert("失败");
                }
            });


        });


        $("#client_upload_delete").click(function() {

            var fileUpList = [];
            <c:forEach items="${pageInfo.list}" var="picture">

            if ($("input[id=${picture.id}]").is(":checked")){ //如果选中
                <%--alert("${picture.id}");--%>
                var fileUp={
                    "id" : ${picture.id}
                };
                fileUpList.push(fileUp);
            }

            </c:forEach>

//            alert(fileUpList);

            $.ajax({
                type : 'post',
                url : '<%=basePath%>DeleteBatch',
                contentType : 'application/json;charset=utf-8',//指定为json类型
                //数据格式是json串,多个对象用[]包装
                data : JSON.stringify(fileUpList),
                success : function(data) {
                    console.log(data.toString());
//                        alert("批量修改成功");
                    location.href = "<%=basePath%>client_upload";

                },
                error : function() {
//                        alert("失败");
                }
            });

        });


        // 全选/取消全部
        $("#client_upload_all_check").click(function() {
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


                // 创建一个上传参数变量
                var uploadOption =
                    {
                        action: "fileUpload",    // 提交目标

                        name: "images",            // 服务端接收的名称

                        dataType: "json",

                        autoSubmit: true,        // 是否自动提交


                        // 开始上传文件
                        onSubmit: function (file, extension)
                        {
//                            $("#wait").show();
                            $('#progressbar2').LineProgressbar({
                                percentage : 100,
                                duration : 30000
                            });
                        },

                        // 上传完成之后
                        onComplete: function (file, response)
                        {
                            window.location.reload();
                        }
                    };

                // 实例化上传对象
                new AjaxUpload("#client_upload_button", uploadOption);



    })
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/ajax_upload.js"></script>
<%--<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/file_upload.js"></script>--%>

</body>
</html>