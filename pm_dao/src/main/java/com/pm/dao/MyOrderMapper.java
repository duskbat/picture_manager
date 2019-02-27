package com.pm.dao;

import com.pm.entity.MyOrder;
import com.pm.entity.MyOrderExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MyOrderMapper {


    //一个
    MyOrder selectOrderById(Long id);

    List<MyOrder> selectCompanyOrder(@Param("contractState") Integer contractState);

    List<MyOrder> selectCompanyPaystate(@Param("contractState") Integer contractState, @Param("payState") Integer payState);

    List<MyOrder> selectClientOrder(@Param("contractState") Integer contractState, @Param("orderUserid") Long orderUserid);


    List<MyOrder> selectCompanyPay(@Param("contractState") Integer contractState, @Param("orderUpload") Long orderUpload, @Param("companyState") Integer companyState);
    List<MyOrder> selectClientPay(@Param("contractState") Integer contractState, @Param("orderUpload") Long orderUpload, @Param("clientState") Integer clientState);


    List<MyOrder> searchCompanyDeal(@Param("contractState") Integer contractState, @Param("payState") Integer payState, @Param("copyrightName") String copyrightName);


    List<MyOrder> searchCompanyDealSuccess(@Param("contractState") Integer contractState, @Param("copyrightName") String copyrightName);


    List<MyOrder> selectOneClientOrder(@Param("orderUserid") Long orderUserid);



    int countByExample(MyOrderExample example);

    int deleteByExample(MyOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MyOrder record);

    int insertSelective(MyOrder record);

    List<MyOrder> selectByExample(MyOrderExample example);

    MyOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MyOrder record, @Param("example") MyOrderExample example);

    int updateByExample(@Param("record") MyOrder record, @Param("example") MyOrderExample example);

    int updateByPrimaryKeySelective(MyOrder record);

    int updateByPrimaryKey(MyOrder record);
}