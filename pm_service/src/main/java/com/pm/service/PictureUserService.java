package com.pm.service;


import com.pm.entity.PictureUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * Created by Dell on 2017/8/24.
 */
public interface PictureUserService {

    //插入更新收藏位
    int insertMark(List<PictureUser> pictureUserList);

    //用户全部图片查询
    List<PictureUser> selectPicUser();

    //批量更新购物车
    int updateShop(List<PictureUser> pictureUserList);

    //批量更新多图比较
    int updateCompare(List<PictureUser> pictureUserList);



    PictureUser selectPicUserById(Long id);

    int DeleteMarkBatch(List<PictureUser> fileUpList);



    List<PictureUser> selectClientMark(Long userid);

    List<PictureUser> selectClientShop(@Param("userid") Long userid, @Param("shopid") Long shopid);

    List<PictureUser> selectClientCompare(@Param("userid") Long userid, @Param("compareid") Long compareid);


}
