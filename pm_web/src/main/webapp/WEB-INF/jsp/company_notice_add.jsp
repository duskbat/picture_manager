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


    <!-- include summernote -->
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/summernote/summernote.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/summernote.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/summernote-zh-CN.js"></script>

    <!-- 进度条 -->
    <script src="${pageContext.request.contextPath}/resources/js/jquery.lineProgressbar.js"></script>
    <link href="${pageContext.request.contextPath}/resources/css/jquery.lineProgressbar.css" rel="stylesheet" />


    <link href="${pageContext.request.contextPath}/resources/css/font-awesome.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/awesome-bootstrap-checkbox.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/font.css" rel="stylesheet" />
    <%--<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" />--%>
    <link href="${pageContext.request.contextPath}/resources/css/cont.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/css/layout.css" rel="stylesheet" />
    <link rel="icon" href="${pageContext.request.contextPath}/resources/images/auction1.ico">
    <title>信息公告</title>
</head>
<body>
<%@include file="top.jsp"%>

<div class="userCenterWrap">

    <div class="leftNav hidden-xs hidden-sm">
        <ul>
            <li><a href="company_auditing">待审核</a></li>
            <li ><a href="company_posted">已发布</a></li>
            <li><a href="company_upload" >公司上传</a></li>
            <li ><a href="company_deal" >交易记录</a></li>
            <li ><a href="company_data" >控制台</a></li>
            <li class="active"><a href="company_news" >信息公告</a></li>
        </ul>
    </div>

    <div class="midCont" style="margin-left: 10%">

        <ul class="nav nav-pills">

            <li ><a href="company_news">信息传递</a></li>
            <li class="active" ><a href="company_notice">活动公告</a></li>

        </ul>

        <form class="form-horizontal" action="addCompanyNoticeDetail" name="formEdit" method = "post" enctype='multipart/form-data'>
            <input type="hidden" id="myNewshtmml" name="newHtml"/>
            <input type="hidden" id="myNewsrecord" name="newRecord" value="0"/>



            <div class="scriptionLine" style="width: 300px;height: 50px;margin:30px auto;">
                <h4>活动编辑</h4>
            </div>
            <hr>

            <br>

            <div class="scriptionLine">
                <span class="scriptionLeftSpan" style="font-size: 14px">活动标题</span>
                <span>
                <input type="text"  name="newTitle" class="form-control" placeholder="活动标题" style="width: 260px;height: 36px;border: 1px solid #204d74;">
            </span>
            </div>
            <br>

            <div class="scriptionLine">
                <span class="scriptionLeftSpan" style="font-size: 14px">活动来源</span>
                <span>
                <input type="text" height="60px"  name="newSource" class="form-control" placeholder="活动来源" style="width: 260px;height: 36px;border: 1px solid #204d74;">
            </span>
            </div>
            <br>

            <div class="scriptionLine">
                <span class="scriptionLeftSpan" style="font-size: 14px">作者</span>
                <span>
                <input type="text" height="60px"  name="newAuthor" class="form-control" placeholder="作者" style="width: 260px;height: 36px;border: 1px solid #204d74;">
            </span>
            </div>
            <br>

            <div class="scriptionLine">
                <span class="scriptionLeftSpan" style="font-size: 14px">发布时间</span>
                <span>
                <!-- 格式化日期 -->
                <fmt:formatDate value="${noticeTime}" type="both" dateStyle="long" var="noticeTime"/>
                <input type="text" name="newTime" class="form-control input-medium" value="${noticeTime}" id="noticeTime" disabled>
            </span>
            </div>
            <br>
            <br>

            <div class="scriptionLine">
                <span class="scriptionLeftSpan" style="font-size: 14px">编辑发布内容</span>
                <span style="margin-left: 300px;margin-top: 30px">
                    <div class="summernote" name="description" placeholder="请编辑发布内容 " action="file"></div>

                </span>
            </div>

            <br>

            <hr>

            <div style="width: 300px;height: 50px;margin:0px auto;">
                <a id="get" class="btn btn-primary" style="width: 70px;height: 30px">保&nbsp;存</a>
                <button type="submit" class="btn btn-primary" id="submit_button" style="margin-left: 100px;width: 70px;height: 30px" disabled="disabled">提&nbsp;交</button>
            </div>

            <hr>

        </form>

        <br>
        <br>
        <br>
        <br>


    </div><!--midCont-->


</div><!--userCenterWrap-->



<form id="company_news_edit" method="post">
    <input type="hidden" id="userid" name="id" />
</form>

<script type="text/javascript">

    $(document).ready(function(){

        // 对Date的扩展，将 Date 转化为指定格式的String
// 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
// 例子：
// (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
// (new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18
        Date.prototype.Format = function(fmt)
        { //author: meizz
            var o = {
                "M+" : this.getMonth()+1,                 //月份
                "d+" : this.getDate(),                    //日
                "h+" : this.getHours(),                   //小时
                "m+" : this.getMinutes(),                 //分
                "s+" : this.getSeconds(),                 //秒
                "q+" : Math.floor((this.getMonth()+3)/3), //季度
                "S"  : this.getMilliseconds()             //毫秒
            };
            if(/(y+)/.test(fmt))
                fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
            for(var k in o)
                if(new RegExp("("+ k +")").test(fmt))
                    fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
            return fmt;
        }


        $("#noticeTime").val(new Date().Format("yyyy/MM/dd hh:mm:ss"));


        $(".edit_button").click(
            function ()
            {
                $("#company_news_edit").attr("action","<%=basePath%>company_notice_edit");
                $("#userid").attr("value",$(this).parent().attr("id"));
                $("#company_news_edit").submit();
            }
        );


        $('div.summernote').each(function() {
            var $this = $(this);
            var placeholder = $this.attr("placeholder") || '';
            var url = $this.attr("action") || '';
            $this.summernote({
                lang : 'zh-CN',
                placeholder : placeholder,
                minHeight : 300,
                dialogsFade : true,// Add fade effect on dialogs
                dialogsInBody : true,// Dialogs can be placed in body, not in
                // summernote.
                disableDragAndDrop : false,// default false You can disable drag
                // and drop
            });
        });

        $('.summernote').summernote({
            callbacks : {
                // onImageUpload的参数为files，summernote支持选择多张图片
                onImageUpload : function(files) {
                    var $files = $(files);

                    // 通过each方法遍历每一个file
                    $files.each(function() {
                        var file = this;
                        // FormData，新的form表单封装，具体可百度，但其实用法很简单，如下
                        var data = new FormData();

                        // 将文件加入到file中，后端可获得到参数名为“file”
                        data.append("file", file);

                        // ajax上传
                        $.ajax({
                            data : data,
                            type : "POST",
                            url : url,// div上的action
                            cache : false,
                            contentType : false,
                            processData : false,

                            // 成功时调用方法，后端返回json数据
                            success : function(response) {
                                // 封装的eval方法，可百度
                                var json = YUNM.jsonEval(response);

                                // 控制台输出返回数据
                                YUNM.debug(json);

                                // 封装方法，主要是显示错误提示信息
                                YUNM.ajaxDone(json);

                                // 状态ok时
                                if (json[YUNM.keys.statusCode] == YUNM.statusCode.ok) {
                                    // 文件不为空
                                    if (json[YUNM.keys.result]) {

                                        // 获取后台数据保存的图片完整路径
                                        var imageUrl = json[YUNM.keys.result].completeSavePath;

                                        // 插入到summernote
                                        $this.summernote('insertImage', imageUrl, function($image) {
                                            // todo，后续可以对image对象增加新的css式样等等，这里默认
                                        });
                                    }
                                }

                            },

                            debug : function(msg) {
                                if (this._set.debug) {
                                    if (typeof (console) != "undefined")
                                        console.log(msg);
                                    else
                                        alert(msg);
                                }
                            },
                            jsonEval : function(data) {
                                try {
                                    if ($.type(data) == 'string')
                                        return eval('(' + data + ')');
                                    else
                                        return data;
                                } catch (e) {
                                    return {};
                                }
                            },
                            ajaxError : function(xhr, ajaxOptions, thrownError) {
                                if (xhr.responseText) {
                                    $.showErr("<div>" + xhr.responseText + "</div>");
                                } else {
                                    $.showErr("<div>Http status: " + xhr.status + " " + xhr.statusText + "</div>" + "<div>ajaxOptions: " + ajaxOptions + "</div>"
                                        + "<div>thrownError: " + thrownError + "</div>");
                                }

                            },
                            ajaxDone : function(json) {
                                if (json[YUNM.keys.statusCode] == YUNM.statusCode.error) {
                                    if (json[YUNM.keys.message]) {
                                        YUNM.debug(json[YUNM.keys.message]);
                                        $.showErr(json[YUNM.keys.message]);
                                    }

                                } else if (json[YUNM.keys.statusCode] == YUNM.statusCode.timeout) {
                                    YUNM.debug(json[YUNM.keys.message]);
                                    $.showErr(json[YUNM.keys.message] || YUNM.msg("sessionTimout"), YUNM.loadLogin);
                                }
                            },

                            // ajax请求失败时处理
                            error : YUNM.ajaxError
                        });
                    });
                }
            }
        });

// summernote.image.upload
        $('.summernote').on('summernote.image.upload', function(we, files) {
            // upload image to server and create imgNode...
            $summernote.summernote('insertNode', imgNode);
        });

        <%--$('.summernote').summernote('code','${myNews.newHtml}');--%>

        $("#get").click(function () {
            var sHTML = $(".summernote").summernote("code");
//            alert(sHTML);
//            $("#showw").html(sHTML);
//            $("#showw").text(sHTML);
            $('input:hidden[name=newHtml]').val(sHTML);
            alert("编辑器内容已保存");
            $("#submit_button").removeAttr("disabled");

        });




        //删除
        $(".delete_button").click(function ()
            {
                if (confirm("确定要删除这个关键词吗？"))
                {
                    $.ajax({
                        type: "POST",
                        url: "<%=basePath%>deleteNotice",
                        data: {id: $(this).parent().attr("id")},
                        async : false,
                        dataType: "json",
                        success: function (data){
//                            alert("操作成功");
                            if(data=="delete_success")
                                window.location.reload(true);
                        }
                    });
                }
            }
        );


    })
</script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/ajax_upload.js"></script>
</body>
</html>