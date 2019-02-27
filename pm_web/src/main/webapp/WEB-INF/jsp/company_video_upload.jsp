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

    <!-- 分段上传大视频 -->
    <link href="${pageContext.request.contextPath}/resources/js/jquery.plupload.queue/css/jquery.plupload.queue.css" rel="stylesheet" />
    <script src="${pageContext.request.contextPath}/resources/js/jquery.plupload.queue/jquery.plupload.queue.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/plupload.full.min.js"></script>


    <link href="${pageContext.request.contextPath}/resources/css/font-awesome.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/awesome-bootstrap-checkbox.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/font.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/css/cont.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/css/layout.css" rel="stylesheet" />
    <link rel="icon" href="${pageContext.request.contextPath}/resources/images/auction1.ico">
    <title>公司上传页</title>
</head>
<body>
<%@include file="top.jsp"%>

<div class="userCenterWrap">

    <div class="leftNav hidden-xs hidden-sm">
        <ul>
            <li><a href="company_auditing">待审核</a></li>
            <li ><a href="company_posted">已发布</a></li>
            <li class="active"><a href="company_upload" >公司上传</a></li>
            <li ><a href="company_deal" >交易记录</a></li>
            <li><a href="company_data" >控制台</a></li>
            <li><a href="company_news" >信息公告</a></li>
        </ul>
    </div>

    <div class="midCont">

        <div class="favouriteBar">

            <a href="company_upload" class="edit_selection" style="display: block;font-size: 16px;right: 80%;background-color: #515151">进入图片上传页</a>

                <button id="btn" >视频上传<span style="margin-left: 15px;font-size: 12px">(第1步)</span></button>
            <div id="progressbar3" style="width: 16%;position: absolute;right:42%"></div>
            <%--<a id="waitVideo" class="edit_selection" style="display: block;font-size: 16px;right: 364px;background-color: #00ad7d;display: none">视频上传中，请稍后</a>--%>

                <a href="javascript:void(0)" id="company_upload_all_check" class="edit_selection" style="display: block;font-size: 16px;right: 18%;background-color: #66afe9">全&nbsp;选&nbsp;/&nbsp;取&nbsp;消</a>
                <a href="javascript:void(0)" id="company_upload_push_check" class="edit_selection" style="display: block;font-size: 16px;right: 8%;">发布<span style="margin-left: 5px;font-size: 12px">(第3步)</span></a>
                <a href="javascript:void(0)" id="company_video_delete" class="edit_selection" style="display: block;font-size: 16px;right: 1%;background-color: #c9302c ">删&nbsp;&nbsp;&nbsp;除</a>

            </div><!--favouriteBar-->

        <span >当前页面:</span>
        <span style="color: #0074D9">视频上传页</span>

        <div class="favouriteGalleryWrap">
            <div class="favouriteGallery layout3 globalDetail" style="position: relative; height: 0px;">
                <c:forEach items="${pageInfo.list}" var="picture">

                    <a href="javascript:void(0);" onclick="company_video(this);" >
                        <video width="320" height="240" id="${picture.id}" name="media"  controls>
                            <source src="http://${webip}:8084/picture_bed/${picture.filePathshow}"  type="video/mp4">
                        </video>
                    </a>

                    <input type="checkbox" style="width: 15px;height: 15px" id="${picture.id}" data-shape="circled" data-color="orange" class="checkbix">
                    <span style="margin-left: 15px;color: #0074D9">点击视频编辑<span style="margin-left: 10px;font-size: 10px">(第2步)</span></span>

                </c:forEach>
            </div>
        </div>

</div>

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
                    <a href="${pageContext.request.contextPath}/company_video_upload?pn=1">首页</a>
                </li>
                <!-- 如果还有前页就访问当前页码-1的页面， -->
                <c:if test="${pageInfo.hasPreviousPage}">
                    <li>
                        <a href="${pageContext.request.contextPath}/company_video_upload?pn=${pageInfo.pageNum-1}" aria-label="Previous">
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
                    <li ><a href="${pageContext.request.contextPath}/company_video_upload?pn=${page_Nums}">${page_Nums}</a></li>
                </c:if>
                </c:forEach>
                </li>
                <!-- 如果还有后页就访问当前页码+1的页面， -->
                <c:if test="${pageInfo.hasNextPage}">
                    <li>
                        <a href="${pageContext.request.contextPath}/company_video_upload?pn=${pageInfo.pageNum+1}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:if>
                <li><a href="${pageContext.request.contextPath}/company_video_upload?pn=${pageInfo.pages}">末页</a></li>
            </ul>
            <%--</nav>--%>
        </div>
    </div>




</div>



<form id="recod" method="post">
    <input type="hidden" id="recoid" name="id" />
</form>

<%--提交详情表单--%>
<form id="company_videoedit" method="post">
    <input type="hidden" id="userid" name="id" />
</form>

<script type="text/javascript">

    function company_video(w){
        var imageId = $(w).children().attr("id");
        $("#company_videoedit").attr("action","<%=basePath%>company_video_detail");
        $("#userid").attr("value",imageId);
        $("#company_videoedit").submit();
    }


    $(document).ready(function(){


        //实例化一个plupload上传对象
        var uploader = new plupload.Uploader({
            browse_button: 'btn', //触发文件选择对话框的按钮，为那个元素id
            url: '<%=basePath%>pluploadUpload', //服务器端的上传页面地址
            filters: {
                //设置允许上传的类型
                max_file_size: '2000mb', //设置允许上传的最大文件的大小
                mime_types: [
                    //用来限定上传文件的类型,一个类型一个对象，放入当前数组
                    {title: "Image files", extensions: "jpg,gif,png,tif,bmp"},
                    {title: "Vedio files", extensions: "mp4,mkv"},
                    {title: "Zip files", extensions: "zip,avi"}
                ]
            },

            chunk_size: '1mb',

            // Resize images on clientside if we can
            resize: {
                width: 200,
                height: 200,
                quality: 90,
                crop: true // crop to exact dimensions
            },

            // Rename files by clicking on their titles
            rename: true,

            // Sort files
            sortable: true,

            // Enable ability to drag'n'drop files onto the widget (currently only HTML5 supports that)
            dragdrop: true,

            // Views to activate
            views: {
                list: true,
                thumbs: true, // Show thumbs
                active: 'thumbs'
            },


        });

        //在实例对象上调用init()方法进行初始化
        uploader.init();

        //当文件添加到上传队列后触发监听函数参数
        uploader.bind('FilesAdded', function (uploader, files) {
            //uploader为当前的plupload实例对象，files为一个数组，里面的元素为本次添加到上传队列里的文件对象
            console.log(uploader,files);
            //队列添加文件后，直接调用文件上传，也可以单独拿出
            uploader.start();
        });

        //当队列中的某一个文件正要开始上传前触发监听函数参数
        uploader.bind("BeforeUpload",function (uploader,file) {
            //uploader为当前的plupload实例对象，file为触发此事件的文件对象

            $('#progressbar3').LineProgressbar({
                percentage : 100,
                duration : 500000
            });

            console.log("开始上传",uploader,file);
        });

        //会在文件上传过程中不断触发，可以用此事件来显示上传进度监听函数参数
        uploader.bind('UploadProgress', function (uploader, file) {
            //uploader为当前的plupload实例对象，file为触发此事件的文件对象
            console.log(file.id,file.name,file.percent);
        });

        //当队列中的某一个文件上传完成后触发监听函数参数
        uploader.bind("FileUploaded",function (uploader,file,responseObject) {
            //uploader为当前的plupload实例对象，file为触发此事件的文件对象，responseObject为服务器返回的信息对象，它有以下3个属性：
            //response：服务器返回的文本
            //responseHeaders：服务器返回的头信息
            //status：服务器返回的http状态码，比如200
            $("#recod").attr("action","<%=basePath%>company_insert");
            $("#recoid").attr("value","1");
            $("#recod").submit();

//            window.location.reload();
            console.log("上传完成",uploader,file,responseObject);
        });






        $("#company_upload_push_check").click(function() {

            var fileUpList = [];
            <c:forEach items="${pageInfo.list}" var="picture">

            if ($("input[id=${picture.id}]").is(":checked")){ //如果选中
                <%--alert("${picture.id}");--%>
                var fileUp={
                    "id" : ${picture.id},
                    "stateId" : "3"
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
                    location.href = "<%=basePath%>company_video_posted";

                },
                error : function() {
//                        alert("失败");
                }
            });

        });

        $("#company_video_delete").click(function() {

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
                    location.href = "<%=basePath%>company_video_upload";

                },
                error : function() {
//                        alert("失败");
                }
            });

        });


        // 全选/取消全部
        $("#company_upload_all_check").click(function() {
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



        // 创建一个上传参数变量
//        var uploadOption =
//            {
//                action: "fileUpload",    // 提交目标
//
//                name: "images",            // 服务端接收的名称
//
//                dataType: "json",
//
//                autoSubmit: true,        // 是否自动提交
//
//
//                // 开始上传文件
//                onSubmit: function (file, extension)
//                {
//
////                    $("#waitVideo").show();
//
//                },
//
//                // 上传完成之后
//                onComplete: function (file, response)
//                {
//                    window.location.reload();
//
//                }
//            };
//
//        // 实例化上传对象
//        new AjaxUpload("#video_upload_button", uploadOption);






    })
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/ajax_upload.js"></script>
<%--<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/file_upload.js"></script>--%>

</body>
</html>