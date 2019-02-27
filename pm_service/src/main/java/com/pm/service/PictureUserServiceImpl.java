package com.pm.service;


import com.pm.dao.PictureUserMapper;
import com.pm.entity.PictureUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dell on 2017/8/24.
 */
@Service
public class PictureUserServiceImpl implements PictureUserService {

    @Autowired
    PictureUserMapper pictureUserMapper;


    //插入更新收藏
    @Override
    public int insertMark(List<PictureUser> pictureUserList) {
        return pictureUserMapper.insertMark(pictureUserList);
    }

    //用户多图片查询
    @Override
    public List<PictureUser> selectPicUser() {
        return pictureUserMapper.selectPicUser();
    }

    //批量更新购物车
    @Override
    public int updateShop(List<PictureUser> pictureUserList) {
        return pictureUserMapper.updateShop(pictureUserList);
    }

    @Override
    public int updateCompare(List<PictureUser> pictureUserList) {
        return pictureUserMapper.updateCompare(pictureUserList);
    }

    @Override
    public PictureUser selectPicUserById(Long id) {
        return pictureUserMapper.selectPicUserById(id);
    }

    @Override
    public int DeleteMarkBatch(List<PictureUser> fileUpList) {
        return pictureUserMapper.DeleteMarkBatch(fileUpList);
    }

    @Override
    public List<PictureUser> selectClientMark(Long userid) {
        return pictureUserMapper.selectClientMark(userid);
    }

    @Override
    public List<PictureUser> selectClientShop(Long userid, Long shopid) {
        return pictureUserMapper.selectClientShop(userid,shopid);
    }

    @Override
    public List<PictureUser> selectClientCompare(Long userid, Long compareid) {
        return pictureUserMapper.selectClientCompare(userid,compareid);
    }


}
