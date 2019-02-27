package com.pm.service;

import com.pm.dao.RatingMapper;
import com.pm.entity.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RatingServiceImpl implements RatingService{
    @Autowired
    RatingMapper ratingMapper;


    @Override
    public int rating(Long userid, Long pictureid, Byte rating) {
        Rating rat = ratingMapper.selectById(userid,pictureid);
        if(rat==null) {
            return ratingMapper.insert(new Rating(userid, pictureid, rating));
        }
        else {
            Long ratingid = rat.getRatingid();
            return ratingMapper.updateByPrimaryKey(new Rating(ratingid, userid, pictureid, rating));
        }
    }

    @Override
    public Rating showRatingById(Long userid,Long pictureid) {

        Rating rat = ratingMapper.selectById(userid,pictureid);
        Long ratingid = rat.getRatingid();
        return ratingMapper.selectByPrimaryKey(ratingid);
    }
}
