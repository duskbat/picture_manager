package com.pm.dao;

import com.pm.entity.MyNotice;
import com.pm.entity.MyNoticeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MyNoticeMapper {
    int countByExample(MyNoticeExample example);

    int deleteByExample(MyNoticeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MyNotice record);

    int insertSelective(MyNotice record);

    List<MyNotice> selectByExampleWithBLOBs(MyNoticeExample example);

    List<MyNotice> selectByExample(MyNoticeExample example);

    MyNotice selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MyNotice record, @Param("example") MyNoticeExample example);

    int updateByExampleWithBLOBs(@Param("record") MyNotice record, @Param("example") MyNoticeExample example);

    int updateByExample(@Param("record") MyNotice record, @Param("example") MyNoticeExample example);

    int updateByPrimaryKeySelective(MyNotice record);

    int updateByPrimaryKeyWithBLOBs(MyNotice record);

    int updateByPrimaryKey(MyNotice record);
}