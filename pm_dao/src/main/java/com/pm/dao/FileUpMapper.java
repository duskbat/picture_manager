package com.pm.dao;

import com.pm.entity.FileUp;
import com.pm.entity.FileUpExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FileUpMapper {


    //批量更新审核状态方法名updateBatch
    int updateBatch(List<FileUp> fileUpList);

    //批量更新审核状态方法名updateBatch
    int backBatch(List<FileUp> fileUpList);

    //批量更新首页四个展示id
    int updateSlide(List<FileUp> fileUpList);

    int updateAnimal(List<FileUp> fileUpList);

    int updatePlant(List<FileUp> fileUpList);

    int updateScape(List<FileUp> fileUpList);

    int updateVideo(List<FileUp> fileUpList);

    //批量删除数据库记录
    int DeleteBatch(List<FileUp> fileUpList);


    List<FileUp> selectVertical(@Param("direction") Integer direction, @Param("keyword") String keyword, @Param("stateId") Integer stateId);

    List<FileUp> selectMode(@Param("mode") Integer mode, @Param("keyword") String keyword, @Param("stateId") Integer stateId);

    List<FileUp> selectSpice(@Param("spice") Integer spice, @Param("keyword") String keyword, @Param("stateId") Integer stateId);


    List<FileUp> selectCompanySlide(@Param("indexSlide") Integer indexSlide);

    List<FileUp> selectCompanyAnimal(@Param("indexAnimal") Integer indexAnimal);

    List<FileUp> selectCompanyPlant(@Param("indexPlant") Integer indexPlant);

    List<FileUp> selectCompanyScape(@Param("indexScape") Integer indexScape);

    List<FileUp> selectCompanyVideo(@Param("indexVideo") Integer indexVideo);

    //简单的图片名 关键词搜索
    List<FileUp> searchByKeyWord(@Param("keyword") String keyword, @Param("stateId") Integer stateId);

    //连表查询
    FileUp selectFileById(@Param("id") Long id);




    //固定
    List<FileUp> selectCompanyPost(@Param("stateId") Integer stateId);
    List<FileUp> selectCompanyPostVideo(@Param("stateId") Integer stateId);

    List<FileUp> selectCompanyPostSearch(@Param("stateId") Integer stateId, @Param("id") Long id);


    List<FileUp> selectClientUpload(@Param("stateId") Integer stateId, @Param("userId") Long userId);
    List<FileUp> selectClientUploadVideo(@Param("stateId") Integer stateId, @Param("userId") Long userId);







    //////////////////////


    int countByExample(FileUpExample example);

    int deleteByExample(FileUpExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FileUp record);

    int insertSelective(FileUp record);

    List<FileUp> selectByExample(FileUpExample example);

    FileUp selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FileUp record, @Param("example") FileUpExample example);

    int updateByExample(@Param("record") FileUp record, @Param("example") FileUpExample example);

    int updateByPrimaryKeySelective(FileUp record);

    int updateByPrimaryKey(FileUp record);
}