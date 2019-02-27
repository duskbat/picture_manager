package com.pm.dao;

import com.pm.entity.MyNews;
import com.pm.entity.MyNewsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MyNewsMapper {
    int countByExample(MyNewsExample example);

    int deleteByExample(MyNewsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MyNews record);

    int insertSelective(MyNews record);

    List<MyNews> selectByExampleWithBLOBs(MyNewsExample example);

    List<MyNews> selectByExample(MyNewsExample example);

    MyNews selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MyNews record, @Param("example") MyNewsExample example);

    int updateByExampleWithBLOBs(@Param("record") MyNews record, @Param("example") MyNewsExample example);

    int updateByExample(@Param("record") MyNews record, @Param("example") MyNewsExample example);

    int updateByPrimaryKeySelective(MyNews record);

    int updateByPrimaryKeyWithBLOBs(MyNews record);

    int updateByPrimaryKey(MyNews record);
}