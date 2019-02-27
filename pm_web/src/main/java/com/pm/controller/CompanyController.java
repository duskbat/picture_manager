package com.pm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pm.entity.*;
import com.pm.service.FileService;
import com.pm.service.LoginService;
import com.pm.service.NewsService;
import com.pm.service.OrderService;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;




/**
 * Created by Dell on 2017/8/24.
 */
@Controller
@RequestMapping("/")
public class CompanyController {

    @Autowired
    FileService fileService;

    @Autowired
    LoginService loginService;

    @Autowired
    OrderService orderService;

    @Autowired
    NewsService newsService;


    /**
     * 公司待审核页面
     */
    @RequestMapping("/company_auditing")
    public String audited(Model model, @RequestParam(value="pn",defaultValue="1") Integer pn){
        PageHelper.startPage(pn, 10);
        Integer stateId = 6;
        List<FileUp> fileUp= fileService.selectCompanyPost(stateId);
//        for(FileUp f:fileUp ){
//            System.out.println(f.getId());
//        }
        PageInfo page = new PageInfo(fileUp,5);
        model.addAttribute("pageInfo", page);
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);

        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);

        return "company_auditing";
    }

    @RequestMapping("/company_video_auditing")
    public String company_video_auditing(Model model, @RequestParam(value="pn",defaultValue="1") Integer pn){
        PageHelper.startPage(pn, 10);
        Integer stateId = 6;
        List<FileUp> fileUp= fileService.selectCompanyPostVideo(stateId);
        PageInfo page = new PageInfo(fileUp,5);
        model.addAttribute("pageInfo", page);
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);

        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);

        return "company_video_auditing";
    }


    /**
     * 公司审核详情页面
     */
    @RequestMapping("company_audit_detail")
    public String company_audit_detail(Model model,Long id){
        FileUp fileUps= fileService.selectFileById(id);
        model.addAttribute("fileUps", fileUps);

        String file_path = "D:/software/apache-tomcat-8.0.47/webapps/ROOT/picture_bed/";
        String path = file_path + fileUps.getFilePath();
        String pathBig = file_path + fileUps.getFillePathbig();
        String pathMid = file_path + fileUps.getFilePathmid();
        String pathSmall = file_path + fileUps.getFilePathsmall();
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

        return "company_audit_detail";
    }

    @RequestMapping("company_video_audit_detail")
    public String company_video_audit_detail(Model model,Long id){
        FileUp fileUps= fileService.selectFileById(id);
        model.addAttribute("fileUps", fileUps);
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);

        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);

        return "company_video_audit_detail";
    }

    @RequestMapping("saveCompanyAudit")
    public String saveCompanyAudit(Long id, Integer mode, String cameraman, String pictureName,String instruction, String owner, String ownerNumber, String reason, Integer direction, Integer species, Long keyone, Long keytwo, String keythree, Double pathPrice, Double bigpathPrice, Double midpathPrice, Double smallpathPrice){
        fileService.saveCompanyDetail(id,mode,cameraman,pictureName,instruction,owner,ownerNumber,reason,direction,species,keyone,keytwo,keythree,  pathPrice, bigpathPrice, midpathPrice, smallpathPrice);
        return "forward:/company_audit_detail";
    }

    @RequestMapping("saveCompanyVideoAudit")
    public String saveCompanyVideoAudit(Long id, Integer mode, String cameraman, String pictureName,String instruction, String owner, String ownerNumber, String reason, Integer direction, Integer species, Long keyone, Long keytwo, String keythree, Double pathPrice){
        fileService.saveCompanyVideoDetail(id,mode,cameraman,pictureName,instruction,owner,ownerNumber,reason,direction,species,keyone,keytwo,keythree,pathPrice);
        return "forward:/company_video_audit_detail";
    }


    /**
     * 公司审核通过页面
     */
    @RequestMapping("/company_audited")
    public String company_audited(Model model, @RequestParam(value="pn",defaultValue="1") Integer pn){
        PageHelper.startPage(pn, 10);
        Integer stateId = 7;
        List<FileUp> fileUp= fileService.selectCompanyPost(stateId);
        PageInfo page = new PageInfo(fileUp,5);
        model.addAttribute("pageInfo", page);
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);

        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);
        return "company_audited";
    }

    @RequestMapping("/company_video_audited")
    public String company_video_audited(Model model, @RequestParam(value="pn",defaultValue="1") Integer pn){
        PageHelper.startPage(pn, 10);
        Integer stateId = 7;
        List<FileUp> fileUp= fileService.selectCompanyPostVideo(stateId);
        PageInfo page = new PageInfo(fileUp,5);
        model.addAttribute("pageInfo", page);
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);

        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);
        return "company_video_audited";
    }

    /**
     * 公司审核未通过页面
     */
    @RequestMapping("/company_unaudited")
    public String company_unaudited(Model model, @RequestParam(value="pn",defaultValue="1") Integer pn){
        PageHelper.startPage(pn, 10);
        Integer stateId = 8;
        List<FileUp> fileUp= fileService.selectCompanyPost(stateId);
        PageInfo page = new PageInfo(fileUp,5);
        model.addAttribute("pageInfo", page);
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);

        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);
        return "company_unaudited";
    }

    @RequestMapping("/company_video_unaudited")
    public String company_video_unaudited(Model model, @RequestParam(value="pn",defaultValue="1") Integer pn){
        PageHelper.startPage(pn, 10);
        Integer stateId = 8;
        List<FileUp> fileUp= fileService.selectCompanyPostVideo(stateId);
        PageInfo page = new PageInfo(fileUp,5);
        model.addAttribute("pageInfo", page);
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);

        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);
        return "company_video_unaudited";
    }


    /**
     * 公司上传页
     */

    /**
     * 公司上传页
     */
    @RequestMapping("/company_upload")
    public String company_upload(Model model,HttpSession session, @RequestParam(value="pn",defaultValue="1") Integer pn){
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


        return "company_upload";
    }


    @RequestMapping("/company_video_upload")
    public String company_video_upload(Model model,HttpSession session, @RequestParam(value="pn",defaultValue="1") Integer pn){
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
        return "company_video_upload";
    }


    /**
     * 公司已发布页
     */
    /**
     * 公司已发布页
     */
    @RequestMapping("/company_posted")
    public String company_posted(Model model,HttpSession session, @RequestParam(value="pn",defaultValue="1") Integer pn){
        Integer stateId = 3;
        PageHelper.startPage(pn,10);
        List<FileUp> fileUp= fileService.selectCompanyPost(stateId);
        PageInfo page = new PageInfo(fileUp,5);
        model.addAttribute("pageInfo", page);
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);

        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);
        return "company_posted";
    }

    @RequestMapping("/company_video_posted")
    public String company_video_posted(Model model,HttpSession session, @RequestParam(value="pn",defaultValue="1") Integer pn){
        Integer stateId = 3;
        PageHelper.startPage(pn,4);
        List<FileUp> fileUp= fileService.selectCompanyPostVideo(stateId);
        PageInfo page = new PageInfo(fileUp,5);
        model.addAttribute("pageInfo", page);
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);

        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);
        return "company_video_posted";
    }


    /**
     *  公司首页展示
     */
    /**
     *  公司首页展示
     */
    @RequestMapping("/company_slide")
    public String company_slide(Model model, @RequestParam(value="pn",defaultValue="1") Integer pn){
        PageHelper.startPage(pn, 10);
        Integer indexSlide = 2;
        List<FileUp> fileUp= fileService.selectCompanySlide(indexSlide);
        PageInfo page = new PageInfo(fileUp,1);
        model.addAttribute("pageInfo", page);
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);

        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);
        return "company_slide";
    }

    @RequestMapping("/company_animal")
    public String company_animal(Model model, @RequestParam(value="pn",defaultValue="1") Integer pn){
        //升级为分页查询
        PageHelper.startPage(pn, 12);
        Integer indexAnimal = 2;
        List<FileUp> fileUp= fileService.selectCompanyAnimal(indexAnimal);
        PageInfo page = new PageInfo(fileUp,1);
        model.addAttribute("pageInfo", page);
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);

        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);
        return "company_animal";
    }

    @RequestMapping("/company_plant")
    public String company_plant(Model model, @RequestParam(value="pn",defaultValue="1") Integer pn){
        PageHelper.startPage(pn, 12);
        Integer indexPlant = 2;
        List<FileUp> fileUp= fileService.selectCompanyPlant(indexPlant);
        PageInfo page = new PageInfo(fileUp,1);
        model.addAttribute("pageInfo", page);
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);

        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);
        return "company_plant";
    }

    @RequestMapping("/company_scape")
    public String company_scape(Model model, @RequestParam(value="pn",defaultValue="1") Integer pn){
        PageHelper.startPage(pn, 12);
        Integer indexScape = 2;
        List<FileUp> fileUp= fileService.selectCompanyScape(indexScape);
        for(FileUp f:fileUp ){
            System.out.println(f.getId());
        }
        PageInfo page = new PageInfo(fileUp,1);
        model.addAttribute("pageInfo", page);
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);

        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);
        return "company_scape";
    }

    @RequestMapping("/company_video")
    public String company_video(Model model, @RequestParam(value="pn",defaultValue="1") Integer pn){
        PageHelper.startPage(pn, 12);
        Integer indexVideo = 2;
        List<FileUp> fileUp= fileService.selectCompanyVideo(indexVideo);
        for(FileUp f:fileUp ){
            System.out.println(f.getId());
        }
        PageInfo page = new PageInfo(fileUp,1);
        model.addAttribute("pageInfo", page);
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);

        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);
        return "company_video";
    }


    /**
     * 公司编辑页
     */
    /**
     * 公司编辑页
     */
    @RequestMapping("company_detail")
    public String company_detail(Model model,Long id){
        FileUp fileUps= fileService.selectFileById(id);
        model.addAttribute("fileUps", fileUps);
        List<MyKeyword> myKeywords = loginService.selectKeyword();
        model.addAttribute("myKeywords", myKeywords);
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);

        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);
        return "company_detail";
    }

    @RequestMapping("company_video_detail")
    public String company_video_detail(Model model,Long id){
        System.out.println(id);
        FileUp fileUps= fileService.selectFileById(id);
        model.addAttribute("fileUps", fileUps);
        List<MyKeyword> myKeywords = loginService.selectKeyword();
        model.addAttribute("myKeywords", myKeywords);
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);

        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);
        return "company_video_detail";
    }


    @RequestMapping("saveCompanyDetail")
    public String saveCompanyDetail(Long id, Integer mode, String cameraman, String pictureName,String instruction, String owner, String ownerNumber, String reason, Integer direction, Integer species, Long keyone, Long keytwo, String keythree, Double pathPrice, Double bigpathPrice, Double midpathPrice, Double smallpathPrice){
        fileService.saveCompanyDetail(id,mode,cameraman,pictureName,instruction,owner,ownerNumber,reason,direction,species,keyone,keytwo,keythree, pathPrice, bigpathPrice,midpathPrice, smallpathPrice);
        return "redirect:/company_upload";
    }

    @RequestMapping("saveCompanyVideoDetail")
    public String saveCompanyVideoDetail(Long id, Integer mode, String cameraman, String pictureName,String instruction, String owner, String ownerNumber, String reason, Integer direction, Integer species, Long keyone, Long keytwo, String keythree, Double pathPrice){
        fileService.saveCompanyVideoDetail(id,mode,cameraman,pictureName,instruction,owner,ownerNumber,reason,direction,species,keyone,keytwo,keythree,pathPrice);
        return "redirect:/company_video_upload";
    }


    /**
     * 交易记录
     */
    /**
     * 交易记录
     */

    @RequestMapping("/company_deal")
    public String company_deal(Model model, @RequestParam(value="pn",defaultValue="1") Integer pn){
        PageHelper.startPage(pn, 10);
        Integer contractState = 1;
        Integer payState = 2;
        List<MyOrder> myOrders= orderService.selectCompanyPaystate(contractState,payState);
        PageInfo page = new PageInfo(myOrders,5);
        model.addAttribute("pageInfo", page);
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);


        return "company_deal";
    }

    @RequestMapping("searchCompanyDeal")
    public String searchCompanyDeal(String copyrightName,Model model, @RequestParam(value="pn",defaultValue="1") Integer pn){
        PageHelper.startPage(pn, 10);
        Integer contractState = 1;
        Integer payState = 2;
        if(copyrightName==""){
            List<MyOrder> myOrders= orderService.selectCompanyPaystate(contractState,payState);
            PageInfo page = new PageInfo(myOrders,5);
            model.addAttribute("pageInfo", page);
            List<MyKeyword> keywords = loginService.selectKeyword();
            model.addAttribute("keywords", keywords);

            return "redirect:/company_deal";
        }
        List<MyOrder> myOrders= orderService.searchCompanyDeal(contractState,payState,copyrightName);

        PageInfo page = new PageInfo(myOrders,5);
        model.addAttribute("pageInfo", page);
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);
        return "company_deal";
    }


    @RequestMapping("/company_deal_edit")
    public String company_deal_edit(Model model,Long id){
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
//        System.out.println(img.getWidth(null));
//        System.out.println(img.getHeight(null));
//        System.out.println(imgbig.getWidth(null));
//        System.out.println(imgbig.getHeight(null));
//        System.out.println(imgmid.getWidth(null));
//        System.out.println(imgmid.getHeight(null));
//        System.out.println(imgsmall.getWidth(null));
//        System.out.println(imgsmall.getHeight(null));
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
        return "company_deal_edit";
    }


    @RequestMapping("/company_pay_edit")
    public String company_pay_edit(Model model,Long id){
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
        return "company_pay_edit";
    }


    @RequestMapping("saveCompanyDeal")
    public String saveCompanyDeal(Long id,Integer payState, Integer contractState){
        orderService.saveCompanyDeal(id,payState,contractState);
        return "redirect:/company_deal";
    }

    @RequestMapping("saveCompanyPay")
    public String saveCompanyPay(Long id,Integer companyState, Integer clientState, String companyAccount, String clientAccount){
        orderService.saveCompanyPay(id,companyState,clientState,companyAccount,clientAccount);
        return "redirect:/company_success_client";
    }


    @RequestMapping("/company_deal_success")
    public String company_deal_success(Model model, @RequestParam(value="pn",defaultValue="1") Integer pn){
        PageHelper.startPage(pn, 10);
        Integer contractState = 2;
        List<MyOrder> myOrders= orderService.selectCompanyOrder(contractState);
        PageInfo page = new PageInfo(myOrders,5);
        model.addAttribute("pageInfo", page);
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);
        return "company_deal_success";
    }

    @RequestMapping("searchCompanyDealSuccess")
    public String searchCompanyDealSuccess(String copyrightName,Model model, @RequestParam(value="pn",defaultValue="1") Integer pn){
        PageHelper.startPage(pn, 10);
        Integer contractState = 2;
        if(copyrightName==""){
            List<MyOrder> myOrders= orderService.selectCompanyOrder(contractState);
            PageInfo page = new PageInfo(myOrders,5);
            model.addAttribute("pageInfo", page);
            List<MyKeyword> keywords = loginService.selectKeyword();
            model.addAttribute("keywords", keywords);
            return "redirect:/company_deal_success";
        }
        List<MyOrder> myOrders= orderService.searchCompanyDealSuccess(contractState,copyrightName);

        PageInfo page = new PageInfo(myOrders,5);
        model.addAttribute("pageInfo", page);
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);
        return "company_deal_success";
    }



    @RequestMapping("/company_success_client")
    public String company_success_client(Model model,HttpSession session, @RequestParam(value="pn",defaultValue="1") Integer pn){
        PageHelper.startPage(pn, 10);
        User user = (User) session.getAttribute("user");
        Long userid = user.getId();
        Integer contractState = 2;
        Integer companyState = 1;
        Long orderUpload = userid;
        List<MyOrder> myOrders= orderService.selectCompanyPay(contractState,orderUpload,companyState);
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
        return "company_success_client";
    }


    @RequestMapping("/company_over_client")
    public String company_over_client(Model model,HttpSession session, @RequestParam(value="pn",defaultValue="1") Integer pn){
        PageHelper.startPage(pn, 10);
        User user = (User) session.getAttribute("user");
        Long userid = user.getId();
        Integer contractState = 2;
        Integer companyState = 2;
        Long orderUpload = userid;
        List<MyOrder> myOrders= orderService.selectCompanyPay(contractState,orderUpload,companyState);
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
        return "company_over_client";
    }


    /**
     * 控制台
     */
    @RequestMapping("/company_data")
    public String company_data(Model model,HttpSession session){
      Integer userCount = loginService.getUserCount();
      Integer userCountreal = userCount-1;
      Integer pictureCount = fileService.getPicCount();
      Integer orderCount = orderService.getOrderCount();
      Integer contractState = 2;
      List<MyOrder> myOrderList = orderService.selectCompanyOrder(contractState);
      Double priceSum = 0.0;
        for(MyOrder m:myOrderList ){
            Double mprice = m.getPrice();
            priceSum =  priceSum + mprice;
        }
        Integer companyState = 2;
        User user = (User) session.getAttribute("user");
        Long userid = user.getId();
        Long orderUpload = userid;
        List<MyOrder> myOrderback= orderService.selectCompanyPay(contractState,orderUpload,companyState);
        Double pricebackSum = 0.0;
        for(MyOrder mb:myOrderback ){
            Double mbackprice = mb.getPrice();
            pricebackSum =  pricebackSum + mbackprice;
        }
        Double proteSum = 0.0;
        proteSum = priceSum - pricebackSum;
        model.addAttribute("pictureCount", pictureCount);
        model.addAttribute("userCount", userCountreal);
        model.addAttribute("orderCount", orderCount);
        model.addAttribute("priceSum", priceSum);
        model.addAttribute("pricebackSum", pricebackSum);
        model.addAttribute("proteSum", proteSum);
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);
        return "company_data";
    }

    @RequestMapping("/company_keyword")
    public String company_keyword(Model model, @RequestParam(value="pn",defaultValue="1") Integer pn){
        PageHelper.startPage(pn, 10);
        List<MyKeyword> myKeywords = loginService.selectKeyword();
        PageInfo page = new PageInfo(myKeywords,5);
        model.addAttribute("pageInfo", page);
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);
        return "company_keyword";
    }

    @RequestMapping("company_add_keyword")
    @ResponseBody
    public String company_add_keyword(Model model,String newkeyword, @RequestParam(value="pn",defaultValue="1") Integer pn){
       loginService.addKeyword(newkeyword);
        PageHelper.startPage(pn, 10);
        List<MyKeyword> myKeywords = loginService.selectKeyword();
        PageInfo page = new PageInfo(myKeywords,5);
        model.addAttribute("pageInfo", page);
        return "add_success";
    }

    @RequestMapping("company_edit_keyword")
    @ResponseBody
    public String company_edit_keyword(Model model,String editkeyword,Long id, @RequestParam(value="pn",defaultValue="1") Integer pn){
        loginService.editKeyword(id,editkeyword);
        System.out.println(id+"0000000000000");
        PageHelper.startPage(pn, 10);
        List<MyKeyword> myKeywords = loginService.selectKeyword();
        PageInfo page = new PageInfo(myKeywords,5);
        model.addAttribute("pageInfo", page);
        return "edit_success";
    }


    @RequestMapping("deleteKeyword")
    @ResponseBody
    public String deleteKeyword(Long id){
        loginService.deleteKeyword(id);
        return "delete_success";
    }

    @RequestMapping("/company_users")
    public String company_users(Model model, @RequestParam(value="pn",defaultValue="1") Integer pn){
        PageHelper.startPage(pn, 10);
        List<User> users = loginService.selectUser();
        PageInfo page = new PageInfo(users,5);
        Long total = page.getTotal()-1;
        model.addAttribute("total", total);
        model.addAttribute("pageInfo", page);
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);
        return "company_users";
    }

    @RequestMapping("/company_client_set")
    public String company_client_set(Model model,Long id, @RequestParam(value="pn",defaultValue="1") Integer pn){
        User users= loginService.selectByPrimaryKey(id);
        model.addAttribute("users", users);
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);

        //查询身份证
        PageHelper.startPage(pn, 1);
        Integer stateId = 10;
        List<FileUp> fileUp= fileService.selectClientUploadVideo(stateId,id);
        PageInfo page = new PageInfo(fileUp,1);
        model.addAttribute("pageInfo", page);
        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);

        return "company_client_setting";
    }

    @RequestMapping("saveCompanyClientSet")
    public String saveCompanyClientSet(Long id,String username, String password, String nickname, String adress, String email, Long telephone, String wechat, String qq, String company, String workphone,String realname, String idcard,String paycode){
        loginService.editUser(id,username,password,nickname,adress,email,telephone,wechat,qq,company,workphone,realname,idcard,paycode);
        return "redirect:/company_client_set";
    }

    @RequestMapping("/company_pictures")
    public String company_pictures(Model model){
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);

        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);
        return "company_pictures";
    }

    @RequestMapping("/searchPic")
    public String searchPic(Model model,Long id){
        System.out.println(id+"uuuuuuuuuuuuuuuuuuuuuuuuuu");
        FileUp fileUps= fileService.selectFileById(id);
        model.addAttribute("fileUps", fileUps);
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);
        model.addAttribute("id", id);

        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);
        return "redirect:/company_pictures";
    }

    @RequestMapping("searchUser")
    public String searchUser(String realname,Model model, @RequestParam(value="pn",defaultValue="1") Integer pn){
        PageHelper.startPage(pn, 10);
        if(realname==""){
            List<User> users = loginService.selectUser();
            PageInfo page = new PageInfo(users,5);
            Long total = page.getTotal()-1;
            model.addAttribute("total", total);
            model.addAttribute("pageInfo", page);
            List<MyKeyword> keywords = loginService.selectKeyword();
            model.addAttribute("keywords", keywords);
            return "redirect:/company_users";
        }
        List<User> users = loginService.selectRealname(realname);
        for(User f:users ){
            System.out.println(f.getId());
        }

        PageInfo page = new PageInfo(users,5);
        Long total = page.getTotal()-1;
        model.addAttribute("total", total);
        model.addAttribute("pageInfo", page);
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);
        return "company_users";
    }


    @RequestMapping("searchPostPic")
    public String searchPostPic(Long id,Model model, @RequestParam(value="pn",defaultValue="1") Integer pn){
        PageHelper.startPage(pn, 10);
        Integer stateId = 3;
        List<FileUp> fileUp= fileService.selectCompanyPostSearch(stateId,id);
        PageInfo page = new PageInfo(fileUp,5);
        model.addAttribute("pageInfo", page);
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);

        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);
        return "company_posted";
        }

    @RequestMapping("/company_news")
    public String company_news(Model model, @RequestParam(value="pn",defaultValue="1") Integer pn){
        PageHelper.startPage(pn, 10);
        List<MyNews> myNews = newsService.selectNews();
        PageInfo page = new PageInfo(myNews,5);
        model.addAttribute("pageInfo", page);

        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);
        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);
        return "company_news";
    }

    @RequestMapping("/company_notice")
    public String company_notice(Model model, @RequestParam(value="pn",defaultValue="1") Integer pn){
        PageHelper.startPage(pn, 10);
        List<MyNotice> myNotices = newsService.selectNotice();
        PageInfo page = new PageInfo(myNotices,5);
        model.addAttribute("pageInfo", page);

        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);
        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);
        return "company_notice";
    }


    @RequestMapping("/company_news_edit")
    public String company_news_edit(Model model,Long id){
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);
        MyNews myNews = newsService.selectNewsById(id);
        model.addAttribute("myNews", myNews);
        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);
        return "company_news_detail";
    }

    @RequestMapping("/company_notice_edit")
    public String company_notice_edit(Model model,Long id){
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);
        MyNotice myNotice = newsService.selectNoticeById(id);
        model.addAttribute("myNews", myNotice);
        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);
        return "company_notice_detail";
    }

    @RequestMapping("deleteNews")
    @ResponseBody
    public String deleteNews(Long id){
        newsService.deleteNews(id);
        return "delete_success";
    }

    @RequestMapping("deleteNotice")
    @ResponseBody
    public String deleteNotice(Long id){
        newsService.deleteNotice(id);
        return "delete_success";
    }

    @RequestMapping("saveCompanyNewsDetail")
    public String saveCompanyNewsDetail(Long id, String newTitle, String newSource, String newAuthor, String newHtml){
        newsService.saveCompanyNewsDetail(id,newTitle, newSource,newAuthor,newHtml);
        return "redirect:/company_news";
    }

    @RequestMapping("saveCompanyNoticeDetail")
    public String saveCompanyNoticeDetail(Long id, String noticeTitle, String noticeSource, String noticeAuthor, String noticeHtml){
        newsService.saveCompanyNoticeDetail(id,noticeTitle, noticeSource,noticeAuthor,noticeHtml);
        return "redirect:/company_notice";
    }



    @RequestMapping("addNews")
    public String addNews(Model model){
        return "company_news_add";
    }

    @RequestMapping("addNotice")
    public String addNotice(Model model){
        return "company_notice_add";
    }


    @RequestMapping("addCompanyNewsDetail")
    public String addCompanyNewsDetail(String newTitle, String newSource, String newAuthor, Date newTime, Integer newRecord, String newHtml){
        System.out.println(newTime);
        newsService.addCompanyNewsDetail(newTitle, newSource, newAuthor, newTime,  newRecord, newHtml);
        return "redirect:/company_news";
    }

    @RequestMapping("addCompanyNoticeDetail")
    public String addCompanyNoticeDetail(String newTitle, String newSource, String newAuthor, Date newTime, Integer newRecord, String newHtml){
        System.out.println(newTime);
        newsService.addCompanyNoticeDetail(newTitle, newSource, newAuthor, newTime,  newRecord, newHtml);
        return "redirect:/company_notice";
    }


}
