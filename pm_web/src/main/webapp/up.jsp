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
    <%--<link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet">--%>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.1.1.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <%--<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>--%>


    <!-- 上传大视频分段 -->
    <link href="${pageContext.request.contextPath}/resources/js/jquery.plupload.queue/css/jquery.plupload.queue.css" rel="stylesheet" />
    <script src="${pageContext.request.contextPath}/resources/js/jquery.plupload.queue/jquery.plupload.queue.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/plupload.full.min.js"></script>
    <%--<link href="${pageContext.request.contextPath}/resources/js/jquery.ui.plupload/css/jquery.ui.plupload.css" rel="stylesheet" />--%>
    <%--<script src="${pageContext.request.contextPath}/resources/js/jquery.ui.plupload/jquery.ui.plupload.js"></script>--%>



    <%--<link href="${pageContext.request.contextPath}/resources/css/font-awesome.css" rel="stylesheet">--%>
    <%--<link href="${pageContext.request.contextPath}/resources/css/awesome-bootstrap-checkbox.css" rel="stylesheet">--%>
    <%--<link href="${pageContext.request.contextPath}/resources/css/font.css" rel="stylesheet" />--%>
    <%--<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" />--%>
    <%--<link href="${pageContext.request.contextPath}/resources/css/cont.css" rel="stylesheet" />--%>
    <%--<link href="${pageContext.request.contextPath}/resources/css/layout.css" rel="stylesheet" />--%>
    <link rel="icon" href="${pageContext.request.contextPath}/resources/images/auction1.ico">
    <title>中国野生动植物影像数据库</title>
</head>
<body>
<p>
    <button id="btn">选择文件</button>
</p>
<script type="text/javascript">

    $(document).ready(function(){

    //实例化一个plupload上传对象
    var uploader = new plupload.Uploader({
        browse_button: 'btn', //触发文件选择对话框的按钮，为那个元素id
        url: '<%=basePath%>pluploadUpload', //服务器端的上传页面地址
        filters: {
            //设置允许上传的类型
            max_file_size: '1000mb', //设置允许上传的最大文件的大小
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
        console.log("上传完成",uploader,file,responseObject);
    });


})
</script>
</body>
</html>