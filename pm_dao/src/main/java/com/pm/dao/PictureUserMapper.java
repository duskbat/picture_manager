package com.pm.dao;

import com.pm.entity.PictureUser;
import com.pm.entity.PictureUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PictureUserMapper {

    //联合用户表和图片表查询

    //所有
    List<PictureUser> selectPicUser();

    //一个
    PictureUser selectPicUserById(Long id);


    //批量插入收藏位
    int insertMark(List<PictureUser> pictureUserList);

       //批量更新加入购物车
    int updateShop(List<PictureUser> pictureUserList);

    //批量更新加入购物车
    int updateCompare(List<PictureUser> pictureUserList);



    int DeleteMarkBatch(List<PictureUser> fileUpList);

    List<PictureUser> selectClientMark(@Param("userid") Long userid);

    List<PictureUser> selectClientShop(@Param("userid") Long userid, @Param("shopid") Long shopid);

    List<PictureUser> selectClientCompare(@Param("userid") Long userid, @Param("compareid") Long compareid);



    int countByExample(PictureUserExample example);

    int deleteByExample(PictureUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PictureUser record);

    int insertSelective(PictureUser record);

    List<PictureUser> selectByExample(PictureUserExample example);

    PictureUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PictureUser record, @Param("example") PictureUserExample example);

    int updateByExample(@Param("record") PictureUser record, @Param("example") PictureUserExample example);

    int updateByPrimaryKeySelective(PictureUser record);

    int updateByPrimaryKey(PictureUser record);
}