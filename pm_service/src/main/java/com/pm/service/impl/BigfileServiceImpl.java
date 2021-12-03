package com.pm.service.impl;


import com.pm.dao.FileUpMapper;
import com.pm.entity.FileUp;
import com.pm.entity.Plupload;
import com.pm.entity.PluploadService;
import com.pm.entity.User;
import com.pm.service.BigfileService;
import com.pm.utils.FFMPEG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.HashMap;
import java.util.UUID;

/**
 * Created by Dell on 2017/8/24.
 */

@Service
public class BigfileServiceImpl implements BigfileService {

    @Autowired
    FileUpMapper fileUpMapper;

    private String filePath;
    private String pluploadname;

    private String filePathshow;
    private String FileDir;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void uploadvideo(Plupload plupload, HttpServletRequest request, HttpServletResponse response) {
//        String FileDir = "pluploadDir";//文件保存的文件夹
        FileDir = "/software/apache-tomcat-8.0.47/webapps/ROOT/picture_bed/";

        //手动传入Plupload对象HttpServletRequest属性
        plupload.setRequest(request);

//        Long userId = ((User)request.getSession().getAttribute("user")).getId();

        //文件存储绝对路径,会是一个文件夹，项目相应Servlet容器下的"pluploadDir"文件夹，还会以用户唯一id作划分
        File dir = new File(FileDir);

        if (!dir.exists()) {
            dir.mkdirs();//可创建多级目录，而mkdir()只能创建一级目录
        }

        //在服务器内生成唯一文件名
        filePath = UUID.randomUUID() + "." + plupload.getName().substring(plupload.getName().lastIndexOf(".") + 1);
        //加水印视频
        filePathshow = UUID.randomUUID() + "." + plupload.getName().substring(plupload.getName().lastIndexOf(".") + 1);


        pluploadname = plupload.getName();

        //开始上传文件
        PluploadService.upload(plupload, dir, filePath);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void uploadvideoRecord(HttpServletRequest request) {


        FileUp fileUp = new FileUp();
        User usr = (User) request.getSession().getAttribute("user");
        fileUp.setUserId(usr.getId());
        fileUp.setFileName(pluploadname);
        fileUp.setStateId(1);
        fileUp.setIndexSlide(1);
        fileUp.setIndexAnimal(1);
        fileUp.setIndexPlant(1);
        fileUp.setIndexScape(1);
        fileUp.setIndexVideo(1);

        fileUp.setFilePath(filePath);
        fileUp.setFilePathshow(filePathshow);

        fileUpMapper.insert(fileUp);

        String pathVideo = FileDir + filePath;
        String pathShowVideo = FileDir + filePathshow;


        HashMap<String, String> dto = new HashMap<>();
        dto.put("ffmpeg_path", "D:\\software\\tool\\ffmpeg\\bin\\ffmpeg.exe");//必填
        dto.put("input_path", pathVideo);//必填
        dto.put("video_converted_path", pathShowVideo);//必填
        dto.put("logo", "D\\\\:/software/tool/ffmpeg/input/logo.png");//可选(注意windows下面的logo地址前面要写4个反斜杠,如果用浏览器里面调用servlet并传参只用两个,如 d:\\:/ffmpeg/input/logo.png)
        String secondsString = new FFMPEG().videoTransfer(dto);
//        System.out.println("转换共用:"+secondsString+"秒");
//

    }

}
