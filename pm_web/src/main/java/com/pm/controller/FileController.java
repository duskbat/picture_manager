package com.pm.controller;

import com.pm.dao.FileUpMapper;
import com.pm.entity.*;
import com.pm.service.BigfileService;
import com.pm.service.FileService;
import com.pm.service.OrderService;
import com.pm.service.PictureUserService;
import com.pm.entity.PluploadService;
import com.pm.utils.ResponseJson;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

/**
 * Created by Dell on 2017/8/24.
 */
@Controller
@RequestMapping("/")
public class FileController {

    //没用
    @Value("${FilePosition}")
    String filePosition;

    @Autowired
    FileService fileService;

    @Autowired
    PictureUserService pictureUserService;

    @Autowired
    OrderService orderService;

    @Autowired
    BigfileService bigfileService;

    @RequestMapping(value="/pluploadUpload")
    public void uploadvideo(Plupload plupload, HttpServletRequest request, HttpServletResponse response) {

        bigfileService.uploadvideo(plupload,request,response);

    }

    @RequestMapping(value="/company_insert")
    public String company_insert(Long id, HttpServletRequest request) {
        bigfileService.uploadvideoRecord(request);
       return "redirect:/company_video_upload";
    }

    @RequestMapping(value="/client_insert")
    public String client_insert(Long id, HttpServletRequest request) {
        bigfileService.uploadvideoRecord(request);
        return "redirect:/client_video_upload";
    }





    /**
     * 公司上传多张图片
     * @param request
     * @return
     */
    @RequestMapping("/fileUpload")
    @ResponseBody
    public ResponseJson upload(HttpServletRequest request) {
        fileService.upload(request,filePosition);
        System.out.println("0sd0fsdfsdf0sd0f0sd0fsd0f0sd");
        ResponseJson json = new ResponseJson();
        json.setCode(1l);
        return json;
    }

    /**
     * 公司上传身份证
     * @param request
     * @return
     */
    @RequestMapping("/fileIdcard")
    @ResponseBody
    public ResponseJson fileIdcard(HttpServletRequest request) {
        fileService.uploadIdcard(request,filePosition);
        ResponseJson json = new ResponseJson();
        json.setCode(1l);
        return json;
    }

    /**
     * 上传新闻封面
     * @param request
     * @return
     */
    @RequestMapping("/newsFace")
    @ResponseBody
    public ResponseJson newsFace(HttpServletRequest request,Long id) {
        System.out.println(id+"uuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
        fileService.uploadnewsFace(request,filePosition,id);
        ResponseJson json = new ResponseJson();
        json.setCode(1l);
        return json;
    }

    @RequestMapping("/noticeFace")
    @ResponseBody
    public ResponseJson noticeFace(HttpServletRequest request,Long id) {
        fileService.uploadnoticeFace(request,filePosition,id);
        ResponseJson json = new ResponseJson();
        json.setCode(1l);
        return json;
    }

    /**
     * 批量更新  jdbc.properties文件添加----allowMultiQueries=true
     */
    @RequestMapping("updateBatch")
    @ResponseBody
    public Integer updateBatch(@RequestBody List<FileUp> fileUpList){
        return fileService.updateBatch(fileUpList);
    }

    /**
     * 全退回到公司上传
     */
    @RequestMapping("backBatch")
    @ResponseBody
    public Integer backBatch(@RequestBody List<FileUp> fileUpList){
        return fileService.backBatch(fileUpList);
    }


    /**
     * 首页展示批量更新
     */
    @RequestMapping("updateSlide")
    @ResponseBody
    public Integer updateSlide(@RequestBody List<FileUp> fileUpList){
        return fileService.updateSlide(fileUpList);
    }

    @RequestMapping("updateAnimal")
    @ResponseBody
    public Integer updateAnimal(@RequestBody List<FileUp> fileUpList){
        return fileService.updateAnimal(fileUpList);
    }

    @RequestMapping("updatePlant")
    @ResponseBody
    public Integer updatePlant(@RequestBody List<FileUp> fileUpList){
        return fileService.updatePlant(fileUpList);
    }

    @RequestMapping("updateScape")
    @ResponseBody
    public Integer updateScape(@RequestBody List<FileUp> fileUpList){
        return fileService.updateScape(fileUpList);
    }


    @RequestMapping("updateVideo")
    @ResponseBody
    public Integer updateVideo(@RequestBody List<FileUp> fileUpList){
        return fileService.updateVideo(fileUpList);
    }



    /**
     * 批量删除图片记录
     */
    @RequestMapping("DeleteBatch")
    @ResponseBody
    public Integer DeleteBatch(@RequestBody List<FileUp> fileUpList){
        //可增加实际删除java版
        String file_path = "D:/software/apache-tomcat-8.0.47/webapps/ROOT/picture_bed/";

        for(FileUp fileUplist:fileUpList ){
            System.out.println(fileUplist.getId());

            FileUp fileUp= fileService.selectFileById(fileUplist.getId());


            String filepath = fileUp.getFilePath();
            String filepathbig = fileUp.getFillePathbig();
            String filepathmid = fileUp.getFilePathmid();
            String filepathsmall = fileUp.getFilePathsmall();
            String filepathshow = fileUp.getFilePathshow();

            System.out.println(filepath);
            System.out.println(filepathbig);
            System.out.println(filepathmid);
            System.out.println(filepathsmall);
            System.out.println(filepathshow);

            String path = file_path + filepath;
            String pathBig = file_path + filepathbig;
            String pathMid = file_path + filepathmid;
            String pathSmall = file_path + filepathsmall;
            String pathShow = file_path + filepathshow;

            File deletpath = new File(path);
            File deletbigpath = new File(pathBig);
            File deletmidpath = new File(pathMid);
            File deletsmallpath = new File(pathSmall);
            File deletshowpath = new File(pathShow);


            deletpath.delete();
            deletbigpath.delete();
            deletmidpath.delete();
            deletsmallpath.delete();
            deletshowpath.delete();


        }



        return fileService.DeleteBatch(fileUpList);
    }

    /**
     * 批量删除收藏表记录
     */
    @RequestMapping("DeleteMarkBatch")
    @ResponseBody
    public Integer DeleteMarkBatch(@RequestBody List<PictureUser> fileUpList){
        //可增加实际删除java版
        return pictureUserService.DeleteMarkBatch(fileUpList);
    }


    /**
     * 首页展示图下载
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/filedownload")
    public ResponseEntity<byte[]> download(@RequestParam("file_id") Long id) throws Exception{

        FileUp fileUp = fileService.selectFileById(id);
        String filePath1 = fileUp.getFilePathshow();
        String filePath = "D:/software/apache-tomcat-8.0.47/webapps/ROOT/picture_bed/"+filePath1;
        File file = new File(filePath);
        HttpHeaders headers = new HttpHeaders();
        String filename = new String(fileUp.getFileName().getBytes("UTF-8"),"iso-8859-1");
        headers.setContentDispositionFormData("attachment", filename);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.CREATED);

    }

    /**
     * 购买后下载
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/buydownload")
    public ResponseEntity<byte[]> buydownload(@RequestParam("file_id") Long id,@RequestParam("fi_id") Long idorder) throws Exception{

        FileUp fileUp = fileService.selectFileById(id);
        MyOrder order = orderService.selectMyOrderById(idorder);
        String filePath2 = fileUp.getFilePathshow();
        switch (order.getApplication()) {
            case (4):
               filePath2 = fileUp.getFilePath();
                break;
            case (3):
                filePath2 = fileUp.getFillePathbig();
                break;
            case (2):
                filePath2 = fileUp.getFilePathmid();
                break;
            case (1):
                filePath2 = fileUp.getFilePathsmall();
                break;
            case (5):
                filePath2 = fileUp.getFilePathsmall();
                break;
            case (6):
                filePath2 = fileUp.getFilePathsmall();
                break;
            case (7):
                filePath2 = fileUp.getFilePathsmall();
                break;
            case (8):
                filePath2 = fileUp.getFilePathmid();
                break;
            case (9):
                filePath2 = fileUp.getFillePathbig();
                break;
            case (10):
                filePath2 = fileUp.getFillePathbig();
                break;
            case (11):
                filePath2 = fileUp.getFilePathmid();
                break;
            case (12):
                filePath2 = fileUp.getFillePathbig();
                break;


        }


        String filePath = "D:/software/apache-tomcat-8.0.47/webapps/ROOT/picture_bed/"+filePath2;
        File file = new File(filePath);
        HttpHeaders headers = new HttpHeaders();
        String filename = new String(fileUp.getFileName().getBytes("UTF-8"),"iso-8859-1");
        headers.setContentDispositionFormData("attachment", filename);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.CREATED);

    }


    /**
     * 首页展示图下载
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/companydownload")
    public ResponseEntity<byte[]> companydownload(@RequestParam("file_id") Long id) throws Exception{

        FileUp fileUp = fileService.selectFileById(id);
        String filePath1 = fileUp.getFilePath();
        String filePath = "D:/software/apache-tomcat-8.0.47/webapps/ROOT/picture_bed/"+filePath1;
        File file = new File(filePath);
        HttpHeaders headers = new HttpHeaders();
        String filename = new String(fileUp.getFileName().getBytes("UTF-8"),"iso-8859-1");
        headers.setContentDispositionFormData("attachment", filename);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.CREATED);

    }




}
