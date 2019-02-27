package com.pm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pm.entity.*;
import com.pm.service.FileService;
import com.pm.service.LoginService;
import com.pm.service.OrderService;
import com.pm.service.PictureUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by Dell on 2017/8/24.
 */
@Controller
@RequestMapping("/")
public class ClientController {

    @Autowired
    FileService fileService;

    @Autowired
    PictureUserService pictureUserService;

    @Autowired
    LoginService loginService;

    @Autowired
    OrderService orderService;


    @RequestMapping("/client_mark")
    public String client_mark(Model model,HttpSession session, @RequestParam(value="pn",defaultValue="1") Integer pn){
        PageHelper.startPage(pn, 20);
        User user = (User) session.getAttribute("user");
        Long userid = user.getId();
        List<PictureUser> pictureUsers = pictureUserService.selectClientMark(userid);
//        for(PictureUser f:pictureUsers ){
//            System.out.println(f.getId());
//        }
        PageInfo page = new PageInfo(pictureUsers,5);
        model.addAttribute("pageInfo", page);
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);

        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);
        return "client_mark";
    }


    @RequestMapping("/client_shoping")
    public String client_shoping(Model model,HttpSession session, @RequestParam(value="pn",defaultValue="1") Integer pn){
        PageHelper.startPage(pn, 20);
        Long shopid = Long.valueOf(2);
        User user = (User) session.getAttribute("user");
        Long userid = user.getId();
        List<PictureUser> pictureUsers = pictureUserService.selectClientShop(userid,shopid);
        PageInfo page = new PageInfo(pictureUsers,5);
        model.addAttribute("pageInfo", page);
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);

        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);
        return "client_shoping";
    }


    @RequestMapping("/client_compare")
    public String client_compare(Model model, HttpSession session,@RequestParam(value="pn",defaultValue="1") Integer pn){
        PageHelper.startPage(pn, 20);
        Long compareid = Long.valueOf(2);
        User user = (User) session.getAttribute("user");
        Long userid = user.getId();
        List<PictureUser> pictureUsers = pictureUserService.selectClientCompare(userid,compareid);
        PageInfo page = new PageInfo(pictureUsers,1);
        model.addAttribute("pageInfo", page);
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);

        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);
        return "client_compare";
    }


    /**
     * 用户下单页
     */
    @RequestMapping("client_buy")
    public String client_buy(Model model,Long id,HttpSession session){
        PictureUser pictureUser = pictureUserService.selectPicUserById(id);
        model.addAttribute("fileUps", pictureUser);
        String file_path = "D:/software/apache-tomcat-8.0.47/webapps/ROOT/picture_bed/";
        String path = file_path + pictureUser.getFileUpEntity().getFilePath();
        String pathBig = file_path + pictureUser.getFileUpEntity().getFillePathbig();
        String pathMid = file_path + pictureUser.getFileUpEntity().getFilePathmid();
        String pathSmall = file_path + pictureUser.getFileUpEntity().getFilePathsmall();
        File filepath = new File(path);
        File filepathbig = new File(pathBig);
        File filepathmid = new File(pathMid);
        File filepathsmall = new File(pathSmall);
        Image img = null;
        Image imgbig = null;
        Image imgmid = null;
        Image imgsmall = null;
        try {
            img = ImageIO.read(filepath);
            imgbig = ImageIO.read(filepathbig);
            imgmid = ImageIO.read(filepathmid);
            imgsmall = ImageIO.read(filepathsmall);
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("fileUps", pictureUser);
        model.addAttribute("imgwidth", img.getWidth(null));
        model.addAttribute("imgheight", img.getHeight(null));
        model.addAttribute("imgbigwidth", imgbig.getWidth(null));
        model.addAttribute("imgbigheight", imgbig.getHeight(null));
        model.addAttribute("imgmidwidth", imgmid.getWidth(null));
        model.addAttribute("imgmidheight", imgmid.getHeight(null));
        model.addAttribute("imgsmallwidth", imgsmall.getWidth(null));
        model.addAttribute("imgsmallheight", imgsmall.getHeight(null));
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);

        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);


        User user = (User) session.getAttribute("user");
        Long orderUserid = user.getId();
        List<MyOrder> orders= orderService.selectOneClientOrder(orderUserid);
        for(MyOrder f:orders ){
            System.out.println(f.getCopyrightName()+"sdafadsfadfdsfadsfds");
        }
        model.addAttribute("orders", orders);


        return "client_buy";
    }

    @RequestMapping("saveClientBuy")
    public String saveClientBuy(Long orderPicid, Long orderUserid, Long orderUpload,String copyrightName, String copyrightNumber, Long copyrightTelephone, Integer application, Integer countryRange, String startTim, String endTim, Double price, String payAccount, String emailBox, String emailAdress,Integer payState, Integer contractState,Integer companyState, Integer clientState){
        DateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" );
        Date startTime = null;
        Date endTime = null;
        try {
            startTime = sdf.parse(startTim);
            endTime = sdf.parse(endTim);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Double companyPrice = price*0.85;
        orderService.addOrder(orderPicid,orderUserid,orderUpload,copyrightName,copyrightNumber, copyrightTelephone, application, countryRange,startTime, endTime,price, payAccount,emailBox, emailAdress,payState, contractState,companyPrice,companyState, clientState);
        return "redirect:/client_deal";
    }



    @RequestMapping("saveClientPay")
    public String saveClientPay(Long id,Integer companyState, Integer clientState,String clientAccount){
        orderService.saveClientPay(id,companyState,clientState,clientAccount);
        return "redirect:/client_success_company";
    }


    @RequestMapping("/client_deal")
    public String client_deal(Model model,HttpSession session, @RequestParam(value="pn",defaultValue="1") Integer pn){

        PageHelper.startPage(pn, 10);
        Integer contractState = 1;
        User user = (User) session.getAttribute("user");
        Long orderUserid = user.getId();
        List<MyOrder> orders= orderService.selectClientOrder(contractState,orderUserid);

        for(MyOrder f:orders ){
            System.out.println(f.getId());
        }

        PageInfo page = new PageInfo(orders,5);
        model.addAttribute("pageInfo", page);

        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);


        return "client_deal";

    }


    @RequestMapping("deleteOrder")
    @ResponseBody
    public String deleteOrder(Long id){
        orderService.deleteOrder(id);
        return "delete_order";
    }


    @RequestMapping("/client_deal_success")
    public String client_deal_success(Model model,HttpSession session, @RequestParam(value="pn",defaultValue="1") Integer pn){
        PageHelper.startPage(pn, 10);
        Integer contractState = 2;
        User user = (User) session.getAttribute("user");
        Long orderUserid = user.getId();
        List<MyOrder> orders= orderService.selectClientOrder(contractState,orderUserid);
        for(MyOrder f:orders ){
            System.out.println(f.getId());
        }
        PageInfo page = new PageInfo(orders,5);
        model.addAttribute("pageInfo", page);
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);
        return "client_deal_success";
    }


    @RequestMapping("/client_success_company")
    public String client_success_company(Model model,HttpSession session, @RequestParam(value="pn",defaultValue="1") Integer pn){
        PageHelper.startPage(pn, 10);
        User user = (User) session.getAttribute("user");
        Long userid = user.getId();
        Integer contractState = 2;
        Integer clientState = 1;
        Long orderUpload = userid;
        List<MyOrder> myOrders= orderService.selectClientPay(contractState,orderUpload,clientState);
        ArrayList<Double> pricelist =new ArrayList();
        for(MyOrder m:myOrders ){
            Double myPrice = m.getPrice();
            Double myPrices = myPrice*0.85;
            pricelist.add(myPrices);
        }
        PageInfo page = new PageInfo(myOrders,5);
        model.addAttribute("pageInfo", page);
        model.addAttribute("price", pricelist);
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);
        return "client_success_company";
    }

    @RequestMapping("/client_pay_edit")
    public String client_pay_edit(Model model,Long id){
        MyOrder order = orderService.selectMyOrderById(id);
        model.addAttribute("fileUps", order);
        String file_path = "D:/software/apache-tomcat-8.0.47/webapps/ROOT/picture_bed/";
        String path = file_path +  order.getOfileUpEntity().getFilePath();
        String pathBig = file_path + order.getOfileUpEntity().getFillePathbig();
        String pathMid = file_path + order.getOfileUpEntity().getFilePathmid();
        String pathSmall = file_path + order.getOfileUpEntity().getFilePathsmall();
        File filepath = new File(path);
        File filepathbig = new File(pathBig);
        File filepathmid = new File(pathMid);
        File filepathsmall = new File(pathSmall);
        Image img = null;
        Image imgbig = null;
        Image imgmid = null;
        Image imgsmall = null;
        try {
            img = ImageIO.read(filepath);
            imgbig = ImageIO.read(filepathbig);
            imgmid = ImageIO.read(filepathmid);
            imgsmall = ImageIO.read(filepathsmall);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String filePath4 = order.getOfileUpEntity().getFilePathshow();
        model.addAttribute("fileshowori", filePath4);
        model.addAttribute("imgwidth", img.getWidth(null));
        model.addAttribute("imgheight", img.getHeight(null));
        model.addAttribute("imgbigwidth", imgbig.getWidth(null));
        model.addAttribute("imgbigheight", imgbig.getHeight(null));
        model.addAttribute("imgmidwidth", imgmid.getWidth(null));
        model.addAttribute("imgmidheight", imgmid.getHeight(null));
        model.addAttribute("imgsmallwidth", imgsmall.getWidth(null));
        model.addAttribute("imgsmallheight", imgsmall.getHeight(null));
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);

        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);
        return "client_pay_edit";
    }


    @RequestMapping("/client_end_company")
    public String client_end_company(Model model,HttpSession session, @RequestParam(value="pn",defaultValue="1") Integer pn){
        PageHelper.startPage(pn, 10);
        User user = (User) session.getAttribute("user");
        Long userid = user.getId();
        Integer contractState = 2;
        Integer clientState = 2;
        Long orderUpload = userid;
        List<MyOrder> myOrders= orderService.selectClientPay(contractState,orderUpload,clientState);
        ArrayList<Double> pricelist =new ArrayList();
        for(MyOrder m:myOrders ){
            Double myPrice = m.getPrice();
            Double myPrices = myPrice*0.85;
            pricelist.add(myPrices);
        }
        PageInfo page = new PageInfo(myOrders,5);
        model.addAttribute("pageInfo", page);
        model.addAttribute("price", pricelist);
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);
        return "client_end_company";
    }


    @RequestMapping("/client_deal_edit")
    public String client_deal_edit(Model model,Long id){
        MyOrder order = orderService.selectMyOrderById(id);
        model.addAttribute("fileUps", order);
        String file_path = "D:/software/apache-tomcat-8.0.47/webapps/ROOT/picture_bed/";
        String path = file_path +  order.getOfileUpEntity().getFilePath();
        String pathBig = file_path + order.getOfileUpEntity().getFillePathbig();
        String pathMid = file_path + order.getOfileUpEntity().getFilePathmid();
        String pathSmall = file_path + order.getOfileUpEntity().getFilePathsmall();
        File filepath = new File(path);
        File filepathbig = new File(pathBig);
        File filepathmid = new File(pathMid);
        File filepathsmall = new File(pathSmall);
        Image img = null;
        Image imgbig = null;
        Image imgmid = null;
        Image imgsmall = null;
        try {
            img = ImageIO.read(filepath);
            imgbig = ImageIO.read(filepathbig);
            imgmid = ImageIO.read(filepathmid);
            imgsmall = ImageIO.read(filepathsmall);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String filePath3 = order.getOfileUpEntity().getFilePathshow();
        String filePath4 = order.getOfileUpEntity().getFilePathshow();
        switch (order.getApplication()) {
            case (4):
                filePath3 = order.getOfileUpEntity().getFilePath();
                break;
            case (3):
                filePath3 = order.getOfileUpEntity().getFillePathbig();
                break;
            case (2):
                filePath3 = order.getOfileUpEntity().getFilePathmid();
                break;
            case (1):
                filePath3 = order.getOfileUpEntity().getFilePathsmall();
                break;
            case (5):
                filePath3 = order.getOfileUpEntity().getFilePathsmall();
                break;
            case (6):
                filePath3 = order.getOfileUpEntity().getFilePathsmall();
                break;
            case (7):
                filePath3 = order.getOfileUpEntity().getFilePathsmall();
                break;
            case (8):
                filePath3 = order.getOfileUpEntity().getFilePathmid();
                break;
            case (9):
                filePath3 = order.getOfileUpEntity().getFillePathbig();
                break;
            case (10):
                filePath3 = order.getOfileUpEntity().getFillePathbig();
                break;
            case (11):
                filePath3 = order.getOfileUpEntity().getFilePathmid();
                break;
            case (12):
                filePath3 = order.getOfileUpEntity().getFillePathbig();
                break;

        }

        model.addAttribute("fileshowori", filePath4);
        model.addAttribute("fileshow", filePath3);
        model.addAttribute("imgwidth", img.getWidth(null));
        model.addAttribute("imgheight", img.getHeight(null));
        model.addAttribute("imgbigwidth", imgbig.getWidth(null));
        model.addAttribute("imgbigheight", imgbig.getHeight(null));
        model.addAttribute("imgmidwidth", imgmid.getWidth(null));
        model.addAttribute("imgmidheight", imgmid.getHeight(null));
        model.addAttribute("imgsmallwidth", imgsmall.getWidth(null));
        model.addAttribute("imgsmallheight", imgsmall.getHeight(null));
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);

        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);
        return "client_deal_edit";
    }

    @RequestMapping("saveClientDeal")
    public String saveClientDeal(Long id,Integer payState){
        Date payTime = new Date();
        System.out.println(payTime+"8979564759789fads789f7a89sd7f");
        orderService.saveClientDeal(id,payState,payTime);
        return "redirect:/client_deal";
    }


    /**
     * 用户上传页
     */
    /**
     * 用户上传页
     */

    @RequestMapping("/client_upload")
    public String client_upload(Model model, HttpSession session,@RequestParam(value="pn",defaultValue="1") Integer pn){
        PageHelper.startPage(pn, 10);
        Integer stateId = 1;
        User user = (User) session.getAttribute("user");
        Long userId = user.getId();
        List<FileUp> fileUp= fileService.selectClientUpload(stateId,userId);
        PageInfo page = new PageInfo(fileUp,5);
        model.addAttribute("pageInfo", page);
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);

        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);
        return "client_upload";
    }


    @RequestMapping("/client_video_upload")
    public String client_video_upload(Model model, HttpSession session,@RequestParam(value="pn",defaultValue="1") Integer pn){
        PageHelper.startPage(pn, 4);
        Integer stateId = 1;
        User user = (User) session.getAttribute("user");
        Long userId = user.getId();
        List<FileUp> fileUp= fileService.selectClientUploadVideo(stateId,userId);
        PageInfo page = new PageInfo(fileUp,5);
        model.addAttribute("pageInfo", page);
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);

        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);
        return "client_video_upload";
    }


    /**
     * 用户详情页
     */
    @RequestMapping("client_detail")
    public String client_detail(Model model,Long id){
        FileUp fileUps= fileService.selectFileById(id);
        model.addAttribute("fileUps", fileUps);
        List<MyKeyword> myKeywords = loginService.selectKeyword();
        model.addAttribute("myKeywords", myKeywords);
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);

        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);
        return "client_detail";
    }


    @RequestMapping("client_video_detail")
    public String client_video_detail(Model model,Long id){
        System.out.println(id);
        FileUp fileUps= fileService.selectFileById(id);
        model.addAttribute("fileUps", fileUps);
        List<MyKeyword> myKeywords = loginService.selectKeyword();
        model.addAttribute("myKeywords", myKeywords);
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);

        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);
        return "client_video_detail";
    }


    @RequestMapping("saveClientDetail")
    public String saveClientDetail(Long id, Integer mode, String cameraman, String pictureName,String instruction, String owner, String ownerNumber, String reason, Integer direction, Integer species, Long keyone, Long keytwo, String keythree, Double pathPrice, Double bigpathPrice, Double midpathPrice, Double smallpathPrice){
        fileService.saveCompanyDetail(id,mode,cameraman,pictureName,instruction,owner,ownerNumber,reason,direction,species,keyone,keytwo,keythree, pathPrice, bigpathPrice,  midpathPrice, smallpathPrice);
        return "redirect:/client_upload";
    }

    @RequestMapping("saveClientVideoDetail")
    public String saveClientVideoDetail(Long id, Integer mode, String cameraman, String pictureName,String instruction, String owner, String ownerNumber, String reason, Integer direction, Integer species, Long keyone, Long keytwo, String keythree, Double pathPrice){
        fileService.saveCompanyVideoDetail(id,mode,cameraman,pictureName,instruction,owner,ownerNumber,reason,direction,species,keyone,keytwo,keythree,pathPrice);
        return "redirect:/client_video_upload";
    }

    /**
     * 用户审核结果页
     */
    /**
     * 用户审核结果页
     */
    @RequestMapping("/client_auditing")
    public String client_auditing(Model model, HttpSession session, @RequestParam(value="pn",defaultValue="1") Integer pn){
        PageHelper.startPage(pn, 10);
        Integer stateId = 6;
        User user = (User) session.getAttribute("user");
        Long userId = user.getId();
        List<FileUp> fileUp= fileService.selectClientUpload(stateId,userId);
        PageInfo page = new PageInfo(fileUp,5);
        model.addAttribute("pageInfo", page);
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);

        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);
        return "client_auditing";
    }

    @RequestMapping("/client_video_auditing")
    public String client_video_auditing(Model model, HttpSession session, @RequestParam(value="pn",defaultValue="1") Integer pn){
        PageHelper.startPage(pn, 10);
        Integer stateId = 6;
        User user = (User) session.getAttribute("user");
        Long userId = user.getId();
        List<FileUp> fileUp= fileService.selectClientUploadVideo(stateId,userId);
        PageInfo page = new PageInfo(fileUp,5);
        model.addAttribute("pageInfo", page);
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);

        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);
        return "client_video_auditing";
    }



    @RequestMapping("/client_audited")
    public String client_audited(Model model, HttpSession session, @RequestParam(value="pn",defaultValue="1") Integer pn){
        PageHelper.startPage(pn, 10);
        Integer stateId = 7;
        User user = (User) session.getAttribute("user");
        Long userId = user.getId();
        List<FileUp> fileUp= fileService.selectClientUpload(stateId,userId);
        PageInfo page = new PageInfo(fileUp,5);
        model.addAttribute("pageInfo", page);
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);

        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);
        return "client_audited";
    }

    @RequestMapping("/client_video_audited")
    public String client_video_audited(Model model, HttpSession session, @RequestParam(value="pn",defaultValue="1") Integer pn){
        PageHelper.startPage(pn, 10);
        Integer stateId = 7;
        User user = (User) session.getAttribute("user");
        Long userId = user.getId();
        List<FileUp> fileUp= fileService.selectClientUploadVideo(stateId,userId);
        PageInfo page = new PageInfo(fileUp,5);
        model.addAttribute("pageInfo", page);
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);

        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);
        return "client_video_audited";
    }



    @RequestMapping("/client_audited_post")
    public String client_audited_post(Model model,HttpSession session, @RequestParam(value="pn",defaultValue="1") Integer pn){
        PageHelper.startPage(pn, 10);
        Integer stateId = 3;
        User user = (User) session.getAttribute("user");
        Long userId = user.getId();
        List<FileUp> fileUp= fileService.selectClientUpload(stateId,userId);
        PageInfo page = new PageInfo(fileUp,5);
        model.addAttribute("pageInfo", page);
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);

        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);
        return "client_audited_post";
    }

    @RequestMapping("/client_video_audited_post")
    public String client_video_audited_post(Model model,HttpSession session, @RequestParam(value="pn",defaultValue="1") Integer pn){
        PageHelper.startPage(pn, 10);
        Integer stateId = 3;
        User user = (User) session.getAttribute("user");
        Long userId = user.getId();
        List<FileUp> fileUp= fileService.selectClientUploadVideo(stateId,userId);
        PageInfo page = new PageInfo(fileUp,5);
        model.addAttribute("pageInfo", page);
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);

        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);
        return "client_video_audited_post";
    }



    @RequestMapping("/client_unaudited")
    public String client_unaudited(Model model,HttpSession session, @RequestParam(value="pn",defaultValue="1") Integer pn){
        PageHelper.startPage(pn, 10);
        Integer stateId = 8;
        User user = (User) session.getAttribute("user");
        Long userId = user.getId();
        List<FileUp> fileUp= fileService.selectClientUpload(stateId,userId);
        PageInfo page = new PageInfo(fileUp,5);
        model.addAttribute("pageInfo", page);
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);

        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);
        return "client_unaudited";
    }

    @RequestMapping("/client_video_unaudited")
    public String client_video_unaudited(Model model,HttpSession session, @RequestParam(value="pn",defaultValue="1") Integer pn){
        PageHelper.startPage(pn, 10);
        Integer stateId = 8;
        User user = (User) session.getAttribute("user");
        Long userId = user.getId();
        List<FileUp> fileUp= fileService.selectClientUploadVideo(stateId,userId);
        PageInfo page = new PageInfo(fileUp,5);
        model.addAttribute("pageInfo", page);
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);

        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);
        return "client_video_unaudited";
    }


    /**
     * 用户个人设置页
     */
    @RequestMapping("client_setting")
    public String client_setting(Model model,HttpSession session, @RequestParam(value="pn",defaultValue="1") Integer pn){
        User userid = (User) session.getAttribute("user");
//        System.out.println(userid.getId()+"000000000000000");
        User users= loginService.selectByPrimaryKey(userid.getId());
        model.addAttribute("users", users);
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);

        //查询身份证
        PageHelper.startPage(pn, 1);
        Integer stateId = 10;
        User user = (User) session.getAttribute("user");
        Long userId = user.getId();
        List<FileUp> fileUp= fileService.selectClientUploadVideo(stateId,userId);
        PageInfo page = new PageInfo(fileUp,1);
        model.addAttribute("pageInfo", page);
        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);

        return "client_setting";
    }

    @RequestMapping("saveUserEdit")
    public String saveUserEdit(Long id,String username, String password, String nickname, String adress, String email, Long telephone, String wechat, String qq, String company, String workphone,String realname, String idcard,String paycode){
        loginService.editUser(id,username,password,nickname,adress,email,telephone,wechat,qq,company,workphone,realname,idcard,paycode);
        return "redirect:/client_setting";
    }


}
