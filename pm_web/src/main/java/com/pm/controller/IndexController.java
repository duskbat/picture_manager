package com.pm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pm.entity.*;
import com.pm.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Dell on 2017/8/24.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    FileService fileService;

    @Autowired
    LoginService loginService;

    @Autowired
    NewsService newsService;

    @Autowired
    PictureUserService pictureUserService;

    @Autowired
    RatingService ratingService;

    @RequestMapping("indexs")
    public String indexs(Model model, @RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        Integer indexSlide = 2;
        List<FileUp> fileUpSlide = fileService.selectCompanySlide(indexSlide);
        model.addAttribute("fileUpSlide", fileUpSlide);

        Integer indexAnimal = 2;
        List<FileUp> fileUpAnimal = fileService.selectCompanyAnimal(indexAnimal);
        model.addAttribute("fileUpAnimal", fileUpAnimal);

        Integer indexPlant = 2;
        List<FileUp> fileUpPlant = fileService.selectCompanyPlant(indexPlant);
        model.addAttribute("fileUpPlant", fileUpPlant);

        Integer indexScape = 2;
        List<FileUp> fileUpScape = fileService.selectCompanyScape(indexScape);
        model.addAttribute("fileUpScape", fileUpScape);

        Integer indexVideo = 2;
        List<FileUp> fileUpVideo = fileService.selectCompanyVideo(indexVideo);
        model.addAttribute("fileUpVideo", fileUpVideo);

        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);

        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);
        return "forward:/indexs.jsp";
    }

    @RequestMapping("rating")
    public String rating(Long userid, Long pictureid, Byte rating) {
//        System.out.println(userId);
//        System.out.println(pictureId);
//        System.out.println(rating);
        ratingService.rating(userid, pictureid, rating);
        return "redirect:/logged_index";
    }

    @RequestMapping("rate")
    public String showRatingById(Model model, Long userid, Long pictureid) {

        Rating rate = ratingService.showRatingById(userid, pictureid);
        model.addAttribute("rate", rate);
        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);
        return "logged_index";
    }


    @RequestMapping("logged_index")
    public String logged_index(Model model, @RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        Integer indexSlide = 2;
        List<FileUp> fileUpSlide = fileService.selectCompanySlide(indexSlide);
        model.addAttribute("fileUpSlide", fileUpSlide);

        Integer indexAnimal = 2;
        List<FileUp> fileUpAnimal = fileService.selectCompanyAnimal(indexAnimal);
        model.addAttribute("fileUpAnimal", fileUpAnimal);

        Integer indexPlant = 2;
        List<FileUp> fileUpPlant = fileService.selectCompanyPlant(indexPlant);
        model.addAttribute("fileUpPlant", fileUpPlant);

        Integer indexScape = 2;
        List<FileUp> fileUpScape = fileService.selectCompanyScape(indexScape);
        model.addAttribute("fileUpScape", fileUpScape);

        Integer indexVideo = 2;
        List<FileUp> fileUpVideo = fileService.selectCompanyVideo(indexVideo);
        model.addAttribute("fileUpVideo", fileUpVideo);

        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);

        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);

        return "forward:/logged_index.jsp";
    }


    @RequestMapping("index_detail")
    public String index_detail(Model model, Long id, HttpSession session) {
        if (session.getAttribute("user") == null) {
            List<MyKeyword> keywords = loginService.selectKeyword();
            model.addAttribute("keywords", keywords);
            return "redirect:/login.jsp";
        } else {
            FileUp fileUp = fileService.selectFileById(id);
            String file_path = "D:/software/apache-tomcat-8.0.47/webapps/ROOT/picture_bed/";
            String path = file_path + fileUp.getFilePath();
            String pathBig = file_path + fileUp.getFillePathbig();
            String pathMid = file_path + fileUp.getFilePathmid();
            String pathSmall = file_path + fileUp.getFilePathsmall();
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
            model.addAttribute("fileUps", fileUp);
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
            Long userid = user.getId();
            List<PictureUser> pictureUsers = pictureUserService.selectClientMark(userid);
            model.addAttribute("pictureUsers", pictureUsers);

            return "index_detail";
        }

    }


    @RequestMapping("index_video_detail")
    public String index_video_detail(Model model, Long id, HttpSession session) {
        if (session.getAttribute("user") == null) {
            List<MyKeyword> keywords = loginService.selectKeyword();
            model.addAttribute("keywords", keywords);
            return "redirect:/login.jsp";
        } else {
            FileUp fileUp = fileService.selectFileById(id);
            model.addAttribute("fileUps", fileUp);
            List<MyKeyword> keywords = loginService.selectKeyword();
            model.addAttribute("keywords", keywords);

            Constant constant = new Constant();
            model.addAttribute("webip", constant.webip);

            return "index_video_detail";
        }

    }


    @RequestMapping("index_search")
    public String index_search(Model model, String keyword, @RequestParam(value = "pn", defaultValue = "1") Integer pn) throws UnsupportedEncodingException {
        PageHelper.startPage(pn, 60);
        String keyword1 = new String(keyword.getBytes("UTF-8"), "UTF-8");
        System.out.println(keyword1 + "000000000000000");
        Integer stateId = 3;
        List<FileUp> fileUp = fileService.searchByKeyWord(keyword1, stateId);
        ArrayList<FileUp> fileUpjpg = new ArrayList<FileUp>();
        for (FileUp f : fileUp) {
            if (f.getFileName().endsWith("jpg")) {
                fileUpjpg.add(f);
            }
        }
        PageInfo page = new PageInfo(fileUpjpg, 5);
        model.addAttribute("pageInfo", page);
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);
        model.addAttribute("keyword1", keyword1);
        model.addAttribute("direction", "0");
        model.addAttribute("mode", "0");

        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);

        return "index_search";
    }


    @RequestMapping("index_video_search")
    public String index_video_search(Model model, String keyword, @RequestParam(value = "pn", defaultValue = "1") Integer pn) throws UnsupportedEncodingException {
        PageHelper.startPage(pn, 30);
        String keyword1 = new String(keyword.getBytes("UTF-8"), "UTF-8");
        System.out.println(keyword1 + "000000000000000");
        Integer stateId = 3;
        List<FileUp> fileUp = fileService.searchByKeyWord(keyword1, stateId);
        ArrayList<FileUp> fileUpmp4 = new ArrayList<FileUp>();
        for (FileUp f : fileUp) {
            if (f.getFileName().endsWith("mp4")) {
                fileUpmp4.add(f);
            }
        }
        PageInfo page = new PageInfo(fileUpmp4, 5);
        model.addAttribute("pageInfo", page);
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);
        model.addAttribute("keyword1", keyword1);
        model.addAttribute("direction", "0");
        model.addAttribute("species", "0");

        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);

        return "index_video_search";
    }


    @RequestMapping("selectVertical")
    public String selectVertical(Model model, Integer direction, String keyword, @RequestParam(value = "pn", defaultValue = "1") Integer pn) throws UnsupportedEncodingException {
        PageHelper.startPage(pn, 100);
        System.out.println(direction + "fangxiang");
        System.out.println(keyword + "guanjianci");
        Integer stateId = 3;
        List<FileUp> fileUp = fileService.selectVertical(direction, keyword, stateId);
        ArrayList<FileUp> fileUpjpg = new ArrayList<FileUp>();
        for (FileUp f : fileUp) {
            if (f.getFileName().endsWith("jpg")) {
                fileUpjpg.add(f);
            }
        }
        PageInfo page = new PageInfo(fileUpjpg, 2);
        model.addAttribute("pageInfo", page);
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("direction", direction);
        model.addAttribute("keyword1", keyword);
        model.addAttribute("keywords", keywords);

        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);

        return "index_search";
    }

    @RequestMapping("selectVideoVertical")
    public String selectVideoVertical(Model model, Integer direction, String keyword, @RequestParam(value = "pn", defaultValue = "1") Integer pn) throws UnsupportedEncodingException {
        PageHelper.startPage(pn, 100);
        System.out.println(direction + "fangxiang");
        System.out.println(keyword + "guanjianci");
        Integer stateId = 3;
        List<FileUp> fileUp = fileService.selectVertical(direction, keyword, stateId);
        ArrayList<FileUp> fileUpmp4 = new ArrayList<FileUp>();
        for (FileUp f : fileUp) {
            if (f.getFileName().endsWith("mp4")) {
                fileUpmp4.add(f);
            }
        }
        PageInfo page = new PageInfo(fileUpmp4, 2);
        model.addAttribute("pageInfo", page);
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("direction", direction);
        model.addAttribute("keyword1", keyword);
        model.addAttribute("keywords", keywords);

        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);


        return "index_video_search";
    }


    @RequestMapping("selectVideoSpice")
    public String selectVideoSpice(Model model, Integer spice, String keyword, @RequestParam(value = "pn", defaultValue = "1") Integer pn) throws UnsupportedEncodingException {
        PageHelper.startPage(pn, 100);
        System.out.println(spice + "fangxiang");
        System.out.println(keyword + "guanjianci");
        Integer stateId = 3;
        List<FileUp> fileUp = fileService.selectSpice(spice, keyword, stateId);
        ArrayList<FileUp> fileUpmp4 = new ArrayList<FileUp>();
        for (FileUp f : fileUp) {
            if (f.getFileName().endsWith("mp4")) {
                fileUpmp4.add(f);
            }
        }
        PageInfo page = new PageInfo(fileUpmp4, 2);
        model.addAttribute("pageInfo", page);
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("spice", spice);
        model.addAttribute("keyword1", keyword);
        model.addAttribute("keywords", keywords);

        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);

        return "index_video_search";
    }


    @RequestMapping("selectMode")
    public String selectMode(Model model, Integer mode, String keyword, @RequestParam(value = "pn", defaultValue = "1") Integer pn) throws UnsupportedEncodingException {
        PageHelper.startPage(pn, 100);
        Integer stateId = 3;
        List<FileUp> fileUp = fileService.selectMode(mode, keyword, stateId);
        ArrayList<FileUp> fileUpjpg = new ArrayList<FileUp>();
        for (FileUp f : fileUp) {
            if (f.getFileName().endsWith("jpg")) {
                fileUpjpg.add(f);
            }
        }
        PageInfo page = new PageInfo(fileUpjpg, 2);
        model.addAttribute("pageInfo", page);
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("mode", mode);
        model.addAttribute("keyword1", keyword);
        model.addAttribute("keywords", keywords);

        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);

        return "index_search";
    }


    @RequestMapping("index_news_more")
    public String indexNewsMore(Model model, @RequestParam(value = "pn", defaultValue = "1") Integer pn) throws UnsupportedEncodingException {
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);

        PageHelper.startPage(pn, 20);
        List<MyNews> myNews = newsService.selectNews();
        PageInfo page = new PageInfo(myNews, 5);
        model.addAttribute("pageInfo", page);

        PageHelper.startPage(pn, 1);
        Integer indexAnimal = 2;
        List<FileUp> fileUpAnimal = fileService.selectCompanyAnimal(indexAnimal);
        PageInfo pageAnimal = new PageInfo(fileUpAnimal, 1);
        model.addAttribute("pageAnimal", pageAnimal);

        PageHelper.startPage(pn, 1);
        Integer indexPlant = 2;
        List<FileUp> fileUpPlant = fileService.selectCompanyPlant(indexPlant);
        PageInfo pagePlant = new PageInfo(fileUpPlant, 1);
        model.addAttribute("pagePlant", pagePlant);

        PageHelper.startPage(pn, 1);
        Integer indexScape = 2;
        List<FileUp> fileUpScape = fileService.selectCompanyScape(indexScape);
        PageInfo pageScape = new PageInfo(fileUpScape, 1);
        model.addAttribute("pageScape", pageScape);


        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);

        return "index_news_more";
    }

    @RequestMapping("index_notice_more")
    public String index_notice_more(Model model, @RequestParam(value = "pn", defaultValue = "1") Integer pn) throws UnsupportedEncodingException {
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);

        PageHelper.startPage(pn, 20);
        List<MyNotice> myNotices = newsService.selectNotice();
        PageInfo page = new PageInfo(myNotices, 5);
        model.addAttribute("pageInfo", page);

        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);
        return "index_notice_more";
    }

    @RequestMapping("index_news_detail")
    public String index_news_detail(Model model, Long id, @RequestParam(value = "pn", defaultValue = "1") Integer pn) throws UnsupportedEncodingException {
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);

        MyNews myNews = newsService.selectNewsById(id);

        Integer newRecord = myNews.getNewRecord() + 1;
        newsService.saveNewRecord(id, newRecord);
        model.addAttribute("myNews", myNews);
        model.addAttribute("newRecord", newRecord);

        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);

//加载上一篇，下一篇的标题
        MyNews blogPre = newsService.getPreBlog(id);
        MyNews blogAfter = newsService.getAfterBlog(id);
        model.addAttribute("blogPre", blogPre);
        model.addAttribute("blogAfter", blogAfter);


        return "index_news_detail";
    }


    @RequestMapping("index_notice_detail")
    public String index_notice_detail(Model model, Long id, @RequestParam(value = "pn", defaultValue = "1") Integer pn) throws UnsupportedEncodingException {
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);

        MyNotice myNews = newsService.selectNoticeById(id);
        model.addAttribute("myNews", myNews);

        Integer newRecord = myNews.getNewRecord() + 1;
        newsService.saveNoticeRecord(id, newRecord);
        model.addAttribute("newRecord", newRecord);

//加载上一篇，下一篇的标题
        MyNotice blogPre = newsService.getPreBlogNotice(id);
        MyNotice blogAfter = newsService.getAfterBlogNotice(id);
        model.addAttribute("blogPre", blogPre);
        model.addAttribute("blogAfter", blogAfter);


        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);
        return "index_notice_detail";
    }

}
