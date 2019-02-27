package com.pm.service.impl;

import com.pm.dao.FileUpMapper;
import com.pm.dao.MyNewsMapper;
import com.pm.dao.MyNoticeMapper;
import com.pm.entity.*;
import com.pm.service.FileService;
import com.pm.utils.FFMPEG;
import com.pm.utils.ImageMarkLogoByIcon;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import java.util.List;

import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


import java.util.Iterator;


/**
 * Created by Dell on 2017/8/24.
 */
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    FileUpMapper fileUpMapper;

    @Autowired
    MyNewsMapper myNewsMapper;

    @Autowired
    MyNoticeMapper myNoticeMapper;

    private String path;
    private String pathBig;
    private String pathMid;
    private String pathSmall;
    private String pathShow;

    private  String pathDatabase;
    private  String pathDatabaseBig;
    private  String pathDatabaseMid;
    private  String pathDatabaseSmall;
    private  String pathDatabaseShow;

    private  String pathShowWater;
    private  String pathDatabaseShowWater;

    private  String pathDatabaseShowVideo;
    private  String pathShowVideo;


    @Transactional
    public void upload(HttpServletRequest request, String filePosition) {

        List<MultipartFile> files = null;
//得到多部分解析器
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
//判断request是否有文件上传，即多部分
        if(multipartResolver.isMultipart(request)){
            //转换为多部分request
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            //取得multipartRequest中的所有文件
            files = multipartRequest.getFiles("images");//file为页面file类型input的name
        }
        if(files != null && files.size() >0 ) {
            //图片服务器路径
            String file_path = "D:/software/apache-tomcat-8.0.47/webapps/ROOT/picture_bed/";

            for (MultipartFile file : files) {
                if (file != null && file.getOriginalFilename() != null && file.getOriginalFilename().length() > 0) {
                    try {
                        // 得到上传的文件名
                        String fileName = file.getOriginalFilename();

                        // 得到服务器项目发布运行所在地址
                        //我的方法 构造传入数据的文件路径

                        if(fileName.endsWith("jpg")){

                            //原图
                             pathDatabase = UUID.randomUUID().toString()+".jpg";
                             pathDatabaseBig = UUID.randomUUID().toString()+".jpg";
                             pathDatabaseMid = UUID.randomUUID().toString()+".jpg";
                             pathDatabaseSmall = UUID.randomUUID().toString()+".jpg";
                            pathDatabaseShow = UUID.randomUUID().toString()+".jpg";

                            pathDatabaseShowWater = UUID.randomUUID().toString()+".jpg";


                        }else if(fileName.endsWith("tif")){

                            pathDatabase = UUID.randomUUID().toString()+".tif";
                            pathDatabaseBig = UUID.randomUUID().toString()+".tif";
                            pathDatabaseMid = UUID.randomUUID().toString()+".tif";
                            pathDatabaseSmall = UUID.randomUUID().toString()+".tif";
                            pathDatabaseShow = UUID.randomUUID().toString()+".tif";

                            pathDatabaseShowWater = UUID.randomUUID().toString()+".tif";

                        }else if(fileName.endsWith("mp4")){
                            pathDatabase = UUID.randomUUID().toString()+".mp4";

                            pathDatabaseShowVideo = UUID.randomUUID().toString()+".mp4";

                        }



                        // 此处未使用UUID来生成唯一标识,用日期做为标识
                        path = file_path + pathDatabase;
                        pathBig = file_path + pathDatabaseBig;
                        pathMid = file_path + pathDatabaseMid;
                        pathSmall = file_path + pathDatabaseSmall;
                        pathShow = file_path + pathDatabaseShow;

                        pathShowWater = file_path + pathDatabaseShowWater;

                        pathShowVideo = file_path + pathDatabaseShowVideo;





                        // 赋值
                        FileUp fileUp = new FileUp();
                        User usr = (User) request.getSession().getAttribute("user");
                        fileUp.setUserId(usr.getId());
                        fileUp.setFileName(fileName);
                        fileUp.setStateId(1);
                        fileUp.setIndexSlide(1);
                        fileUp.setIndexAnimal(1);
                        fileUp.setIndexPlant(1);
                        fileUp.setIndexScape(1);
                        fileUp.setIndexVideo(1);

                        fileUp.setFilePath(pathDatabase);


                        if(fileName.endsWith("jpg")){
//                            fileUp.setFilePathshow(pathDatabaseShow);
                            fileUp.setFillePathbig(pathDatabaseBig);
                            fileUp.setFilePathmid(pathDatabaseMid);
                            fileUp.setFilePathsmall(pathDatabaseSmall);

                            fileUp.setFilePathshow(pathDatabaseShowWater);

                        }else if(fileName.endsWith("tif")){

                            fileUp.setFillePathbig(pathDatabaseBig);
                            fileUp.setFilePathmid(pathDatabaseMid);
                            fileUp.setFilePathsmall(pathDatabaseSmall);
                            fileUp.setFilePathshow(pathDatabaseShowWater);

                        }else if(fileName.endsWith("mp4")){

                            fileUp.setFilePathshow(pathDatabaseShowVideo);

                        }

                        fileUpMapper.insert(fileUp);

                        File localFile = new File(path);
                        file.transferTo(localFile);


                        HashMap<String, String> dto=new HashMap<String, String>();
                        dto.put("ffmpeg_path", "D:\\software\\tool\\ffmpeg\\bin\\ffmpeg.exe");//必填
                        dto.put("input_path", path);//必填
                        dto.put("video_converted_path", pathShowVideo );//必填
                        dto.put("logo", "D:\\\\:/software/tool/ffmpeg/input/logo.png");//可选(注意windows下面的logo地址前面要写4个反斜杠,如果用浏览器里面调用servlet并传参只用两个,如 d:\\:/ffmpeg/input/logo.png)
                        String secondsString=  new FFMPEG().videoTransfer(dto);
                        System.out.println("转换共用:"+secondsString+"秒");


                        //压缩后较大尺寸
                        try {
// 获得源文件
                            File fileo = new File(path);
                            if (!fileo.exists()) {
//return "";
                            }
                            Image img = ImageIO.read(fileo);
// 判断图片格式是否正确
                            System.out.println(img.getWidth(null));
                            System.out.println(img.getHeight(null));



                            if (img.getWidth(null) == -1) {
                                System.out.println(" can't read,retry!" + "<BR>");
//return "no";
                            } else {
                                int newWidth;
                                int newHeight;
                                int newWidth1;
                                int newHeight1;
                                int newWidth2;
                                int newHeight2;
                                int newWidth3;
                                int newHeight3;
// 判断是否是等比缩放
// 为等比缩放计算输出的图片宽度及高度
                                double rate1 = ((double) img.getWidth(null)) / (double) 2000
                                        + 0.1;
                                double rate2 = ((double) img.getHeight(null)) / (double) 2000
                                        + 0.1;
                                double rate3 = ((double) img.getWidth(null)) / (double) 1500
                                        + 0.1;
                                double rate4 = ((double) img.getHeight(null)) / (double) 1500
                                        + 0.1;
                                double rate5 = ((double) img.getWidth(null)) / (double) 1000
                                        + 0.1;
                                double rate6 = ((double) img.getHeight(null)) / (double) 1000
                                        + 0.1;
                                double rate7 = ((double) img.getWidth(null)) / (double) 800
                                        + 0.1;
                                double rate8 = ((double) img.getHeight(null)) / (double) 800
                                        + 0.1;
// 根据缩放比率大的进行缩放控制
                                double rate = rate1 > rate2 ? rate1 : rate2;
                                newWidth = (int) (((double) img.getWidth(null)) / rate);
                                newHeight = (int) (((double) img.getHeight(null)) / rate);
                                BufferedImage tag = new BufferedImage((int) newWidth,
                                        (int) newHeight, BufferedImage.TYPE_INT_RGB);

                                double ratemid = rate3 > rate4 ? rate3 : rate4;
                                newWidth1 = (int) (((double) img.getWidth(null)) / ratemid);
                                newHeight1 = (int) (((double) img.getHeight(null)) / ratemid);
                                BufferedImage tagmid = new BufferedImage((int) newWidth1,
                                        (int) newHeight1, BufferedImage.TYPE_INT_RGB);

                                double ratesmall = rate5 > rate6 ? rate5 : rate6;
                                newWidth2 = (int) (((double) img.getWidth(null)) / ratesmall);
                                newHeight2 = (int) (((double) img.getHeight(null)) / ratesmall);
                                BufferedImage tagsmall = new BufferedImage((int) newWidth2,
                                        (int) newHeight2, BufferedImage.TYPE_INT_RGB);

                                double rateshow = rate7 > rate8 ? rate7 : rate8;
                                newWidth3 = (int) (((double) img.getWidth(null)) / rateshow);
                                newHeight3 = (int) (((double) img.getHeight(null)) / rateshow);
                                BufferedImage tagshow = new BufferedImage((int) newWidth3,
                                        (int) newHeight3, BufferedImage.TYPE_INT_RGB);
/*
* Image.SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的 优先级比速度高 生成的图片质量比较好 但速度慢
*/
                                tag.getGraphics().drawImage(
                                        img.getScaledInstance(newWidth, newHeight,
                                                Image.SCALE_SMOOTH), 0, 0, null);
                                FileOutputStream out = new FileOutputStream(pathBig);
// JPEGImageEncoder可适用于其他图片类型的转换
                                JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
                                encoder.encode(tag);

                                tagmid.getGraphics().drawImage(
                                        img.getScaledInstance(newWidth1, newHeight1,
                                                Image.SCALE_SMOOTH), 0, 0, null);
                                FileOutputStream outmid = new FileOutputStream(pathMid);
// JPEGImageEncoder可适用于其他图片类型的转换
                                JPEGImageEncoder encodermid = JPEGCodec.createJPEGEncoder(outmid);
                                encodermid.encode(tagmid);



                                tagsmall.getGraphics().drawImage(
                                        img.getScaledInstance(newWidth2, newHeight2,
                                                Image.SCALE_SMOOTH), 0, 0, null);
                                FileOutputStream outsmall = new FileOutputStream(pathSmall);
// JPEGImageEncoder可适用于其他图片类型的转换
                                JPEGImageEncoder encodersmall = JPEGCodec.createJPEGEncoder(outsmall);
                                encodersmall.encode(tagsmall);

                                tagshow.getGraphics().drawImage(
                                        img.getScaledInstance(newWidth3, newHeight3,
                                                Image.SCALE_SMOOTH), 0, 0, null);
                                FileOutputStream outshow = new FileOutputStream(pathShow);
// JPEGImageEncoder可适用于其他图片类型的转换
                                JPEGImageEncoder encodershow = JPEGCodec.createJPEGEncoder(outshow);
                                encodershow.encode(tagshow);


                                out.close();
                                outmid.close();
                                outsmall.close();
                                outshow.close();


                                String iconPath = "D:/software/tool/ffmpeg/input/logo.png";
                                String srcImgPath = pathShow;
                                String targerPath = pathShowWater;
                                //视频加水印
                                ImageMarkLogoByIcon imageMark = new ImageMarkLogoByIcon();
                                imageMark.markImageByIcon(iconPath,srcImgPath,
                                       targerPath,0);



                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }



                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


                }
            }
        }

    @Transactional
    public void uploadIdcard(HttpServletRequest request, String filePosition) {

        List<MultipartFile> files = null;
//得到多部分解析器
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
//判断request是否有文件上传，即多部分
        if(multipartResolver.isMultipart(request)){
            //转换为多部分request
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            //取得multipartRequest中的所有文件
            files = multipartRequest.getFiles("idcards");//file为页面file类型input的name
        }
        if(files != null && files.size() >0 ) {
            //图片服务器路径
            String file_path = "D:/software/apache-tomcat-8.0.47/webapps/ROOT/picture_bed/";

            for (MultipartFile file : files) {
                if (file != null && file.getOriginalFilename() != null && file.getOriginalFilename().length() > 0) {
                    try {
                        // 得到上传的文件名
                        String fileName = file.getOriginalFilename();

                            //原图
                        pathDatabase = UUID.randomUUID().toString()+".jpg";

                        // 此处未使用UUID来生成唯一标识,用日期做为标识
                        path = file_path + pathDatabase;

                        // 赋值
                        FileUp fileUp = new FileUp();
                        User usr = (User) request.getSession().getAttribute("user");
                        fileUp.setUserId(usr.getId());
                        fileUp.setFileName(fileName);
                        fileUp.setStateId(10);

                        fileUp.setFilePath(pathDatabase);
                        fileUpMapper.insert(fileUp);

                        File localFile = new File(path);
                        file.transferTo(localFile);


                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


            }
        }
    }

    @Transactional
    public void uploadnewsFace(HttpServletRequest request, String filePosition,Long id) {

        List<MultipartFile> files = null;
//得到多部分解析器
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
//判断request是否有文件上传，即多部分
        if(multipartResolver.isMultipart(request)){
            //转换为多部分request
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            //取得multipartRequest中的所有文件
            files = multipartRequest.getFiles("newsFace");//file为页面file类型input的name
        }
        if(files != null && files.size() >0 ) {
            //图片服务器路径
            String file_path = "D:/software/apache-tomcat-8.0.47/webapps/ROOT/picture_bed/";

            for (MultipartFile file : files) {
                if (file != null && file.getOriginalFilename() != null && file.getOriginalFilename().length() > 0) {
                    try {
                        // 得到上传的文件名
                        String fileName = file.getOriginalFilename();

                        //原图
                        pathDatabase = UUID.randomUUID().toString()+".jpg";

                        // 此处未使用UUID来生成唯一标识,用日期做为标识
                        path = file_path + pathDatabase;

                        myNewsMapper.updateByPrimaryKeySelective(new MyNews(id,pathDatabase));

                        File localFile = new File(path);
                        file.transferTo(localFile);


                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


            }
        }
    }


    @Transactional
    public void uploadnoticeFace(HttpServletRequest request, String filePosition,Long id) {

        List<MultipartFile> files = null;
//得到多部分解析器
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
//判断request是否有文件上传，即多部分
        if(multipartResolver.isMultipart(request)){
            //转换为多部分request
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            //取得multipartRequest中的所有文件
            files = multipartRequest.getFiles("noticeFace");//file为页面file类型input的name
        }
        if(files != null && files.size() >0 ) {
            //图片服务器路径
            String file_path = "D:/software/apache-tomcat-8.0.47/webapps/ROOT/picture_bed/";

            for (MultipartFile file : files) {
                if (file != null && file.getOriginalFilename() != null && file.getOriginalFilename().length() > 0) {
                    try {
                        // 得到上传的文件名
                        String fileName = file.getOriginalFilename();

                        //原图
                        pathDatabase = UUID.randomUUID().toString()+".jpg";

                        // 此处未使用UUID来生成唯一标识,用日期做为标识
                        path = file_path + pathDatabase;

                        myNoticeMapper.updateByPrimaryKeySelective(new MyNotice(id,pathDatabase));

                        File localFile = new File(path);
                        file.transferTo(localFile);


                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


            }
        }
    }




    @Override
    public int getPicCount() {
        return fileUpMapper.countByExample(new FileUpExample());
    }


    //批量更新审核
    @Override
    public int updateBatch(List<FileUp> fileUpList) {
        return fileUpMapper.updateBatch(fileUpList);
    }

    @Override
    public int backBatch(List<FileUp> fileUpList) {
        return fileUpMapper.backBatch(fileUpList);
    }

    //批量更新首页
    @Override
    public int updateSlide(List<FileUp> fileUpList) {
        return fileUpMapper.updateSlide(fileUpList);
    }

    @Override
    public int updateAnimal(List<FileUp> fileUpList) {
        return fileUpMapper.updateAnimal(fileUpList);
    }

    @Override
    public int updatePlant(List<FileUp> fileUpList) {
        return fileUpMapper.updatePlant(fileUpList);
    }

    @Override
    public int updateScape(List<FileUp> fileUpList) {
        return fileUpMapper.updateScape(fileUpList);
    }

    @Override
    public int updateVideo(List<FileUp> fileUpList) {
        return fileUpMapper.updateVideo(fileUpList);
    }

    //批量删除
    @Override
    public int DeleteBatch(List<FileUp> fileUpList) {
        return fileUpMapper.DeleteBatch(fileUpList);
    }

    @Override
    public List<FileUp> selectVertical(Integer direction,String keyword,Integer stateId) {
        return fileUpMapper.selectVertical(direction,keyword,stateId);
    }

    @Override
    public List<FileUp> selectMode(Integer mode, String keyword,Integer stateId) {
        return fileUpMapper.selectMode(mode,keyword,stateId);
    }

    @Override
    public List<FileUp> selectSpice(Integer spice, String keyword, Integer stateId) {
        return fileUpMapper.selectSpice(spice,keyword,stateId);
    }

    @Override
    public List<FileUp> selectCompanySlide(Integer indexSlide) {
        return fileUpMapper.selectCompanySlide(indexSlide);
    }

    @Override
    public List<FileUp> selectCompanyAnimal(Integer indexAnimal) {
        return fileUpMapper.selectCompanyAnimal(indexAnimal);
    }

    @Override
    public List<FileUp> selectCompanyPlant(Integer indexPlant) {
        return fileUpMapper.selectCompanyPlant(indexPlant);
    }

    @Override
    public List<FileUp> selectCompanyScape(Integer indexScape) {
        return fileUpMapper.selectCompanyScape(indexScape);
    }

    @Override
    public List<FileUp> selectCompanyVideo(Integer indexVideo) {
        return fileUpMapper.selectCompanyVideo(indexVideo);
    }

    @Override
    public List<FileUp> selectCompanyPost(Integer stateId) {
        return fileUpMapper.selectCompanyPost(stateId);
    }

    @Override
    public List<FileUp> selectCompanyPostVideo(Integer stateId) {
        return fileUpMapper.selectCompanyPostVideo(stateId);
    }

    @Override
    public List<FileUp> selectCompanyPostSearch(Integer stateId, Long id) {
        return fileUpMapper.selectCompanyPostSearch(stateId,id);
    }

    @Override
    public List<FileUp> selectClientUpload(Integer stateId, Long userId) {
        return fileUpMapper.selectClientUpload(stateId,userId);
    }

    @Override
    public List<FileUp> selectClientUploadVideo(Integer stateId, Long userId) {
        return fileUpMapper.selectClientUploadVideo(stateId,userId);
    }


    //图片详情
    @Override
    public FileUp selectFileById(Long id) {
        return fileUpMapper.selectFileById(id);
    }


    //保存公司上传图片详情页
    @Override
    public int saveCompanyDetail(Long id, Integer mode, String cameraman, String pictureName,String instruction, String owner, String ownerNumber, String reason, Integer direction, Integer species, Long keyone, Long keytwo, String keythree, Double pathPrice, Double bigpathPrice, Double midpathPrice, Double smallpathPrice) {
        return fileUpMapper.updateByPrimaryKeySelective(new FileUp(id,mode,cameraman,pictureName,instruction,owner,ownerNumber,reason,direction,species,keyone,keytwo,keythree, pathPrice, bigpathPrice, midpathPrice, smallpathPrice));
    }

    @Override
    public int saveCompanyVideoDetail(Long id, Integer mode, String cameraman, String pictureName, String instruction, String owner, String ownerNumber, String reason, Integer direction, Integer species, Long keyone, Long keytwo, String keythree, Double pathPrice) {
        return fileUpMapper.updateByPrimaryKeySelective(new FileUp(id,mode,cameraman,pictureName,instruction,owner,ownerNumber,reason,direction,species,keyone,keytwo,keythree, pathPrice));
    }

    //关键词搜索
    @Override
    public List<FileUp> searchByKeyWord(String keyword,Integer stateId) {
        return fileUpMapper.searchByKeyWord(keyword,stateId);
    }


}
