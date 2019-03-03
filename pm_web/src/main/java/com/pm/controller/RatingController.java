package com.pm.controller;

import com.pm.entity.Constant;
import com.pm.entity.FileUp;
import com.pm.entity.MyKeyword;
import com.pm.entity.Rating;
import com.pm.service.FileService;
import com.pm.service.LoginService;
import com.pm.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @description: rating
 * @author: muweiye
 * @createTime: 2019-03-04 01:25
 **/
@Controller
@RequestMapping("/")
public class RatingController {
    @Autowired
    RatingService ratingService;

    @Autowired
    FileService fileService;

    @Autowired
    LoginService loginService;

    @RequestMapping("rating")
    public String rating(Long userid, Long pictureid, Byte rating) {
        ratingService.rating(userid, pictureid, rating);
        return "redirect:/client_rating";
    }

    @RequestMapping("rate")
    public String showRatingById(Model model, Long userid, Long pictureid) {

        Rating rate = ratingService.showRatingById(userid, pictureid);
        model.addAttribute("rate", rate);
        Constant constant = new Constant();
        model.addAttribute("webip", constant.webip);
        return "client_rating";
    }


    @RequestMapping("client_rating")
    public String clientRating(Model model, @RequestParam(value = "pn", defaultValue = "1") Integer pn) {

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

        return "client_rating";
    }

}
