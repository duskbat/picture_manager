package com.pm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pm.entity.FileUp;
import com.pm.entity.PictureUser;
import com.pm.service.FileService;
import com.pm.service.PictureUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.util.List;


/**
 * Created by Dell on 2017/8/24.
 */
@Controller
@RequestMapping("/")
public class PictureUserController {

    @Autowired
    PictureUserService pictureUserService;

    /**
     * 插入收藏  jdbc.properties文件添加----allowMultiQueries=true
     */
    @RequestMapping("insertMark")
    @ResponseBody
    public Integer insertMark(@RequestBody List<PictureUser> pictureUserList){
        return pictureUserService.insertMark(pictureUserList);
    }


    /**
     * 批量购物车  jdbc.properties文件添加----allowMultiQueries=true
     */
    @RequestMapping("updateShop")
    @ResponseBody
    public Integer updateShop(@RequestBody List<PictureUser> pictureUserList){
        return pictureUserService.updateShop(pictureUserList);
    }

    /**
     * 批量多图比较  jdbc.properties文件添加----allowMultiQueries=true
     */
    @RequestMapping("updateCompare")
    @ResponseBody
    public Integer updateCompare(@RequestBody List<PictureUser> pictureUserList){
        return pictureUserService.updateCompare(pictureUserList);
    }




}
