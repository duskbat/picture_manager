package com.pm.service;

import com.pm.entity.FileUp;
import com.pm.entity.Plupload;
import org.apache.ibatis.annotations.Param;


import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;


/**
 * Created by Dell on 2017/8/24.
 */
public interface FileService {

    //批量上传图片带压缩
    void upload(HttpServletRequest request, String filePosition);

    //上传身份证不带压缩
    void uploadIdcard(HttpServletRequest request, String filePosition);

    //上传新闻封面不带压缩
    void uploadnewsFace(HttpServletRequest request, String filePosition, Long id);
    void uploadnoticeFace(HttpServletRequest request, String filePosition, Long id);


    //图片数
    int getPicCount();

    //图片详情
    FileUp selectFileById(Long id);


    //关键词搜索
    List<FileUp> searchByKeyWord(String keyword, Integer stateId);


    //批量更新
    int updateBatch(List<FileUp> fileUpList);

    int backBatch(List<FileUp> fileUpList);

    int updateSlide(List<FileUp> fileUpList);

    int updateAnimal(List<FileUp> fileUpList);

    int updatePlant(List<FileUp> fileUpList);

    int updateScape(List<FileUp> fileUpList);

    int updateVideo(List<FileUp> fileUpList);

    //批量删除
    int DeleteBatch(List<FileUp> fileUpList);


    List<FileUp> selectVertical(Integer direction, String keyword, Integer stateId);

    List<FileUp> selectMode(Integer mode, String keyword, Integer stateId);

    List<FileUp> selectSpice(Integer direction, String keyword, Integer stateId);


    List<FileUp> selectCompanySlide(Integer indexSlide);

    List<FileUp> selectCompanyAnimal(Integer indexAnimal);

    List<FileUp> selectCompanyPlant(Integer indexPlant);

    List<FileUp> selectCompanyScape(Integer indexScape);

    List<FileUp> selectCompanyVideo(Integer indexVideo);


//********************//

    int saveCompanyDetail(Long id, Integer mode, String cameraman, String pictureName, String instruction, String owner, String ownerNumber, String reason, Integer direction, Integer species, Long keyone, Long keytwo, String keythree, Double pathPrice, Double bigpathPrice, Double midpathPrice, Double smallpathPrice);
    int saveCompanyVideoDetail(Long id, Integer mode, String cameraman, String pictureName, String instruction, String owner, String ownerNumber, String reason, Integer direction, Integer species, Long keyone, Long keytwo, String keythree, Double pathPrice);


    List<FileUp> selectCompanyPost(Integer stateId);
    List<FileUp> selectCompanyPostVideo(Integer stateId);

    List<FileUp> selectCompanyPostSearch(Integer stateId, Long id);

    List<FileUp> selectClientUpload(@Param("stateId") Integer stateId, @Param("userId") Long userId);
    List<FileUp> selectClientUploadVideo(@Param("stateId") Integer stateId, @Param("userId") Long userId);


}
