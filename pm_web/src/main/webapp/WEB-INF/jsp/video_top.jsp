<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Fixed navbar -->

<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header" style="margin-left: -80px;margin-right: 10px">
            <!-- The mobile navbar-toggle button can be safely removed since you do not need it in a non-responsive implementation -->
            <a class="navbar-brand" href="indexs">
                <img src="${pageContext.request.contextPath}/resources/images/indexs_logo.png" width="380px" height="60px" >
            </a>
        </div>
        <!-- Note that the .navbar-collapse and .collapse classes have been removed from the #navbar -->
        <div id="navbar" style="margin-top: 16px;margin-left: 100px" >

            <ul class="nav navbar-nav">

                <ul class="nav navbar-nav">
                    <li class="dropdown">
                        <a href="index_news_more"><h4>信息传递</h4></a>
                    </li>
                </ul>

                <ul class="nav navbar-nav">
                    <li class="dropdown">
                        <a href="index_notice_more"> <h4>活动公告</h4></a>
                    </li>
                </ul>


                <ul class="nav navbar-nav">
                    <li class="dropdown">
                        <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span id="sort" style="font-size: 15px"><h4>分类搜索</h4></span></a>
                    </li>
                </ul>


                <form id="searchVideoSearch" action="<%=basePath%>index_video_search" method="get" class="navbar-form navbar-left" enctype="multipart/form-data" style="margin-left: 10px;margin-top: 4%">

                    <input  id="serchvideoinput" type="text" name="keyword" value="${keyword1}" class="form-control" placeholder="视频搜索&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;关键词/摄影师" style="width: 260px;height: 36px;border: 1px solid #bfbfbf;">

                </form>

                <ul class="nav navbar-nav navbar-right" style="margin-left: 20px;margin-top: 5px">
                    <li id="loginafter"><a href="login"><h5>登录</h5></a></li>
                    <li id="registafer"><a href="register"><h5>注册</h5></a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                            <img src="${pageContext.request.contextPath}/resources/images/headPic.png" width="20px" height="20px" style="border-radius: 50%;">
                            <span style="margin-left: 16px;margin-top: -6px">${user.nickname}</span></a>
                        <%--<span class="caret">${user.nickname}</span></a>--%>

                        <c:if test="${user.admin=='1'}">
                            <ul class="dropdown-menu">
                                <li><a href="client_mark">收藏夹</a></li>
                                <li><a href="client_shoping">购物车</a></li>
                                <li><a href="client_upload">用户上传</a></li>
                                <li><a href="client_auditing">审核结果</a></li>
                                <li><a href="client_deal">交易记录</a></li>
                                <li><a href="client_setting">个人信息</a></li>
                                <li><a href="login_out">退出</a></li>
                                <li role="separator" class="divider"></li>
                            </ul>
                        </c:if>

                        <c:if test="${user.admin=='管理员'}">
                            <ul class="dropdown-menu">
                                <li><a href="company_auditing">待审核</a></li>
                                <li ><a href="company_posted">已发布</a></li>
                                <li ><a href="company_upload" >公司上传</a></li>
                                <li ><a href="company_deal" >交易记录</a></li>
                                <li><a href="company_data" >控制台</a></li>
                                <li><a href="company_news" >信息公告</a></li>
                                <li><a href="login_out">退出</a></li>
                                <li role="separator" class="divider"></li>
                            </ul>
                        </c:if>

                    </li>
                </ul>


            </ul>

        </div><!--/.nav-collapse -->

    </div>

</nav>

<img src="${pageContext.request.contextPath}/resources/images/index_qrcode.jpg" width="100px" height="100px" style="position: absolute;right: 2%;top: 2%">
<a style="position: absolute;right: 3%;top: 115px" href="indexs"><h5><span style="color: #0074D9;">网站首页</span></h5></a>


<div id="keywordshow" style="display: none;width: 1000px;height: auto;margin:-36px 300px;z-index: 100;background-color: #f9f9f9;color: #777;position: absolute;z-index: 100">
    <br>
    <c:forEach items="${keywords}" var="keyword">
        <a href="javascript:void(0)" onclick="keywordvDetail(this);" >
            <span style="margin-left: 20px">${keyword.keyname}</span>
        </a>
    </c:forEach>
    <br>
    <br>

</div>



<script type="text/javascript">

    function keywordvDetail(w){
        var keywordvDetail = $(w).children().text();
        $("#serchvideoinput").attr("value",keywordvDetail);
        $("#searchVideoSearch").submit();
    }

    $(document).ready(function(){

        $("#sort").click(function(){

            $("#keywordshow").show();

        })

        $(document).click(function() {
            $("#keywordshow").hide();
        })


        <c:if test="${user.admin=='1'|| user.admin=='管理员'}">
        $("#loginafter").hide();
        $("#registafer").hide();
        </c:if>



    })
</script>