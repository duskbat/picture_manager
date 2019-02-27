package com.pm.dao;

import com.pm.entity.MyKeyword;
import com.pm.entity.MyKeywordExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MyKeywordMapper {
    int countByExample(MyKeywordExample example);

    int deleteByExample(MyKeywordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MyKeyword record);

    int insertSelective(MyKeyword record);

    List<MyKeyword> selectByExample(MyKeywordExample example);

    MyKeyword selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MyKeyword record, @Param("example") MyKeywordExample example);

    int updateByExample(@Param("record") MyKeyword record, @Param("example") MyKeywordExample example);

    int updateByPrimaryKeySelective(MyKeyword record);

    int updateByPrimaryKey(MyKeyword record);
}