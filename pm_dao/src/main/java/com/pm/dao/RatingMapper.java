package com.pm.dao;

import com.pm.entity.Rating;
import com.pm.entity.RatingExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RatingMapper {
    int countByExample(RatingExample example);

    int deleteByExample(RatingExample example);

    int deleteByPrimaryKey(Long ratingid);



    int insert(Rating record);

    int insertSelective(Rating record);



    List<Rating> selectByExample(RatingExample example);

    Rating selectByPrimaryKey(Long ratingid);
    Rating selectById(@Param("userid") Long userid, @Param("pictureid") Long pictureid);



    int updateByExampleSelective(@Param("record") Rating record, @Param("example") RatingExample example);

    int updateByExample(@Param("record") Rating record, @Param("example") RatingExample example);

    int updateByPrimaryKeySelective(Rating record);

    int updateByPrimaryKey(Rating record);

}