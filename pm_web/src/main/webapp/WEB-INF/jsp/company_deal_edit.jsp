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
    <title>交易记录</title>
</head>
<body>
<%@include file="top.jsp"%>

<div id="sectionCont" >

    <div class="leftNav hidden-xs hidden-sm" style="margin-top: 112px">
        <ul>
            <li><a href="company_auditing">待审核</a></li>
            <li ><a href="company_posted">已发布</a></li>
            <li><a href="company_upload" >公司上传</a></li>
            <li class="active"><a href="company_deal" >交易记录</a></li>
            <li><a href="company_data" >控制台</a></li>
        </ul>
    </div>

</div>
<!--sectionCont-->

<div style="margin-left: 120px">

    <div class="container">

        <div class="detailWrap">

            <div class="row detailPhotoRow">

                <div class="col-md-3 detailPhoto">
                    <img src="http://${webip}:8084/picture_bed/${fileshowori}" alt="">
                </div>

                <div class="col-md-9 detailPhoto">

                    <div class="scriptionLine">
                        <span class="scriptionLeftSpan"><h5>订单详情</h5></span>
                    </div>
                    <hr>

                    <form class="form-horizontal" action="saveCompanyDeal" name="formEdit" method = "post" enctype='multipart/form-data'>
                        <input type="hidden" name="id" value="${fileUps.id}"/>

                        <div class="scriptionLine">
                        <span style="margin-left: 80px;margin-top: 20px;color: #0074D9">用户付款状态</span>
                        <span style="margin-left: 30px">
                             <label class="radio-inline">
                                <input type="radio" name="payState" id="dealRadio1" value="1" <c:if test="${fileUps.payState == 1}">checked="checked"</c:if>> 未付款&nbsp;&nbsp;&nbsp;&nbsp;
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="payState" id="dealRadio2" value="2" <c:if test="${fileUps.payState == 2}">checked="checked"</c:if>> 已付款&nbsp;&nbsp;&nbsp;&nbsp;
                            </label>
                        </span>
                        <span style="margin-left: 30px;margin-top: 20px;color: #0074D9">合同签订状态</span>
                            <span style="margin-left: 30px">
                             <label class="radio-inline">
                                <input type="radio" name="contractState" id="dealRadio3" value="1" <c:if test="${fileUps.contractState == 1}">checked="checked"</c:if>> 公司未签字&nbsp;&nbsp;&nbsp;&nbsp;
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="contractState" id="dealRadio4" value="2" <c:if test="${fileUps.contractState == 2}">checked="checked"</c:if>> 公司已签字&nbsp;&nbsp;&nbsp;&nbsp;
                            </label>
                        </span>
                    </div>
                    <br>


                    <div class="scriptionLine">
                        <span style="margin-left: 80px;color: #0074D9">版权使用者付款账号</span>
                        <span style="margin-left: 60px">${fileUps.payAccount}</span>
                        <span style="margin-left: 100px;color: #0074D9">版权使用者付款金额</span>
                        <span style="margin-left: 50px">${fileUps.price}</span>
                    </div>
                    <br>

                    <div class="scriptionLine">
                        <span style="margin-left: 80px;color: #0074D9">图片版权模式</span>
                        <span style="margin-left: 60px">
                        <c:if test="${fileUps.ofileUpEntity.mode == 1}">免版税模式RF</c:if>
                        <c:if test="${fileUps.ofileUpEntity.mode ==2}">版权管理模式RM</c:if>
                        </span>
                        <span style="margin-left: 80px;color: #0074D9">图片用途</span>
                        <span style="margin-left: 20px">
                             <c:if test="${fileUps.application =='1'}">小尺寸&nbsp;&nbsp;&nbsp;&nbsp;${imgsmallwidth} × ${imgsmallheight} px</c:if>
                             <c:if test="${fileUps.application =='2'}">中尺寸&nbsp;&nbsp;&nbsp;&nbsp;${imgmidwidth} × ${imgmidheight} px</c:if>
                             <c:if test="${fileUps.application =='3'}">大尺寸&nbsp;&nbsp;&nbsp;&nbsp;${imgbigwidth} × ${imgbigheight} px</c:if>
                             <c:if test="${fileUps.application =='4'}">原图&nbsp;&nbsp;&nbsp;&nbsp;${imgwidth} × ${imgheight}px</c:if>
                            <c:if test="${fileUps.application =='5'}">网络用途&nbsp;&nbsp;微博/微信/App</c:if>
                            <c:if test="${fileUps.application =='6'}">网络用途&nbsp;&nbsp;网站</c:if>
                            <c:if test="${fileUps.application =='7'}">出版用途&nbsp;&nbsp;小尺寸</c:if>
                            <c:if test="${fileUps.application =='8'}">出版用途&nbsp;&nbsp;中尺寸</c:if>
                            <c:if test="${fileUps.application =='9'}">广告用途&nbsp;&nbsp;单一媒体发布</c:if>
                            <c:if test="${fileUps.application =='10'}">广告用途&nbsp;&nbsp;三种媒体发布</c:if>
                             <c:if test="${fileUps.application =='11'}">线下物料&nbsp;&nbsp;中尺寸</c:if>
                            <c:if test="${fileUps.application =='12'}">线下物料&nbsp;&nbsp;大尺寸</c:if>
                        </span>
                    </div>

                        <br>
                        <div class="scriptionLine">
                            <span style="margin-left: 80px;color: #0074D9">版权使用开始时间</span>
                            <span style="margin-left: 60px">
                             <fmt:formatDate value="${fileUps.startTime}" type="both" dateStyle="long" />
                        </span>
                            <span style="margin-left: 100px;color: #0074D9">版权使用结束时间</span>
                            <span style="margin-left: 50px">
                             <fmt:formatDate value="${fileUps.endTime}" type="both" dateStyle="long" />
                        </span>
                        </div>
                        <br>

                    <hr>
                    <br>

                    <div style="width: 300px;height: 50px;margin:0px auto;"><h3>图片使用权转让协议书</h3></div>
                    <br>
                    <div style="margin-left: 20px"><h4>甲方信息(图片版权所有者)</h4></div>
                    <hr>

                    <div class="scriptionLine">
                        <span style="margin-left: 80px;color: #0074D9">公司名称</span>
                        <span style="margin-left: 100px">自然影像网</span>
                        <span style="margin-left: 120px;color: #0074D9">公司注册号</span>
                        <span style="margin-left: 50px">1321645256</span>
                    </div>
                    <br>

                    <div class="scriptionLine">
                        <span style="margin-left: 80px;color: #0074D9">公司办公电话</span>
                        <span style="margin-left: 60px">0451-86959685</span>
                        <span style="margin-left: 80px;color: #0074D9">公司邮寄地址</span>
                        <span style="margin-left: 50px">哈尔滨市南岗区办公写字楼606</span>
                    </div>
                    <br>

                    <hr>
                    <div style="margin-left: 20px"><h4>乙方信息(图片版权使用者)</h4></div>
                    <hr>

                    <div class="scriptionLine">
                        <span style="margin-left: 80px;color: #0074D9">版权使用者</span>
                        <span style="margin-left: 100px">${fileUps.copyrightName}</span>
                        <span style="margin-left: 120px;color: #0074D9">版权使用者身份证号</span>
                        <span style="margin-left: 50px">${fileUps.copyrightNumber}</span>
                    </div>
                    <br>

                    <div class="scriptionLine">
                        <span style="margin-left: 80px;color: #0074D9">版权使用者电话号</span>
                        <span style="margin-left: 60px">${fileUps.copyrightTelephone}</span>
                        <span style="margin-left: 80px;color: #0074D9">版权使用者邮寄地址</span>
                        <span style="margin-left: 50px">${fileUps.emailAdress}</span>
                    </div>
                    <br>

                    <hr>

                    <div class="scriptionLine">
                        <span class="scriptionLeftSpan"><h5>合同详情</h5></span>
                    </div>

                    <hr>

                    <div>为了有效地维护著作权人依法享有的著作权益，使著作权人的作品得到充分、合理、有效的使用，甲方经著作权人的授权与乙方达成如下协议。
                    __自然影像网__（以下称甲方）与__${fileUps.copyrightName}__（以下称乙方），就甲方向乙方提供图片的合作事宜达成以下协议。</div>
                    <br>
                    <div> 第一条、 合作内容：</div>
                    <br>
                    <div>1.1甲方授权乙方从自然影像网上购买著作权人__${fileUps.ofileUpEntity.owner}__，即主要关键词(内容)为：_${fileUps.ofileUpEntity.pictureName}_的图片，
                        限于乙方在_
                        <c:if test="${fileUps.application =='1'}">小尺寸&nbsp;&nbsp;&nbsp;&nbsp;${imgsmallwidth} × ${imgsmallheight} px</c:if>
                        <c:if test="${fileUps.application =='2'}">中尺寸&nbsp;&nbsp;&nbsp;&nbsp;${imgmidwidth} × ${imgmidheight} px</c:if>
                        <c:if test="${fileUps.application =='3'}">大尺寸&nbsp;&nbsp;&nbsp;&nbsp;${imgbigwidth} × ${imgbigheight} px</c:if>
                        <c:if test="${fileUps.application =='4'}">原图&nbsp;&nbsp;&nbsp;&nbsp;${imgwidth} × ${imgheight}px</c:if>
                        <c:if test="${fileUps.application =='5'}">网络用途&nbsp;&nbsp;微博/微信/App</c:if>
                        <c:if test="${fileUps.application =='6'}">网络用途&nbsp;&nbsp;网站</c:if>
                        <c:if test="${fileUps.application =='7'}">出版用途&nbsp;&nbsp;小尺寸</c:if>
                        <c:if test="${fileUps.application =='8'}">出版用途&nbsp;&nbsp;中尺寸</c:if>
                        <c:if test="${fileUps.application =='9'}">广告用途&nbsp;&nbsp;单一媒体发布</c:if>
                        <c:if test="${fileUps.application =='10'}">广告用途&nbsp;&nbsp;三种媒体发布</c:if>
                        <c:if test="${fileUps.application =='11'}">线下物料&nbsp;&nbsp;中尺寸</c:if>
                        <c:if test="${fileUps.application =='12'}">线下物料&nbsp;&nbsp;大尺寸</c:if>
                        _上使用该图片。</div>
                    <div>1.2乙方向甲方支付1.1条所述图片的使用费，其金额为（大写）__${fileUps.price}__</div>
                    <br>
                    <div>第二条、 双方的责任和义务</div>
                    <br>
                    <div>2.1 乙方从自然影像网上购买的上述图片只限于用在乙方向甲方承诺的商业用途上</div>
                    <div>2.2 甲方向乙方提供著作权人图片的一次性使用权；</div>
                    <div>2.3乙方不得任意改变图片的内容，因改变图片的内容所引起的一切后果由乙方承担，甲方将不承担任何责任和后果并保留更正的权利。</div>
                    <div>2.4甲方负责支付著作权人稿费，乙方不与著作权人发生稿费支付关系。</div>
                    <div>2.5乙方对甲方提供的图片仅拥有在该协议中所述的商业用途上的使用权限，不得向第三方转供图片</div>
                    <div>2.6乙方在使用甲方提供图片时须在该图片下方醒目位置清晰注明“***供稿”（“***”指著作权人）或“自然影像供稿”</div>
                    <div>2.7乙方将图片用于其他商业用途须经过甲方另行授权，并支付相应的费用，否则视为侵权行为</div>
                    <div>2.8甲方在收到乙方支付的著作权使用费后有义务按照乙方提供的图片的传输方式传送图片</div>
                    <div>2.9乙方如在图片传输手段方面有任何变更，须及时通知甲方</div>
                    <br>
                    <div>第三条 协议的生效变更与解除</div>
                    <br>
                    <div>3.1 协议生效日为乙方向甲方付清图片著作权使用费之日</div>
                    <div>3.2 协议双方中任何一方欲变更、解除本协议，必须采取书面形式，口头无效；解除协议需提前十日向对方提出变更或解除本协议的原因</div>
                    <div>3.3 甲乙双方中任何一方未履行本协议条款，导致协议不能履行或不能完全履行，对方有权变更、解除本协议，违约方要承担违约责任</div>
                    <div>3.4 由于不可抗拒因素导致本协议不能履行，双方均不承担违约责任，双方应共同协商变更或者解除本协议</div>
                    <div>3.5 本协议与国家法律相抵触时，应依照国家法律法规，变更本协议</div>
                    <div>3.6 本合同未尽事宜，双方应本着互惠互利、友好协商的原则另行约定，并以备忘录或附件的形式体现</div>
                    <div>3.7 本协议的备忘录或者附件与本协议拥有同等的法律效力</div>
                    <br>
                    <div>第四条 其他</div>
                    <br>
                    <div>4.1 本协议一式两份，甲方持一份，乙方持一份，各份合同均具有同等的法律效力</div>
                    <div>4.2 未经对方许可，甲乙双方都不得将本协议内容透露给第三者</div>
                    <br>
                    <br>

                    <div class="scriptionLine">
                        <span style="margin-left: 80px">甲方签字</span>
                        <span id="name_company_deal" style="margin-left: 100px"></span>
                        <span style="margin-left: 180px">乙方签字</span>
                        <span style="margin-left: 100px">${fileUps.copyrightName}</span>
                    </div>
                    <br>

                        <hr>

                        <div style="width: 300px;height: 50px;margin:0px auto;">
                            <button type="submit" class="btn btn-primary">保&nbsp;&nbsp;&nbsp;&nbsp;存</button>
                        </div>

                        <hr>
                        <br>

                    </form>

                </div>
                <!-- row col-md-9 -->
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

        <c:if test="${fileUps.contractState==2}">
        $("#name_company_deal").text("自然影像");




        </c:if>

    })

</script>

</body>
</html>