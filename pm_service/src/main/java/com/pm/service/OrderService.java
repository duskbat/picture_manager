package com.pm.service;


import com.pm.entity.MyOrder;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by Dell on 2017/8/24.
 */
public interface OrderService {

    int addOrder(Long orderPicid, Long orderUserid, Long orderUpload, String copyrightName, String copyrightNumber, Long copyrightTelephone, Integer application, Integer countryRange, Date startTime, Date endTime, Double price, String payAccount, String emailBox, String emailAdress, Integer payState, Integer contractState, Double companyPrice, Integer companyState, Integer clientState);

    List<MyOrder> selectAllOrder();

    List<MyOrder> selectOneClientOrder(Long orderUserid);

    MyOrder selectMyOrderById(Long id);

    int saveCompanyDeal(Long id, Integer payState, Integer contractState);

    int saveCompanyPay(Long id, Integer companyState, Integer clientState, String companyAccount, String clientAccount);


    int saveClientPay(Long id, Integer companyState, Integer clientState, String clientAccount);


    int saveClientDeal(Long id, Integer payState, Date payTime);



    List<MyOrder> selectCompanyOrder(Integer contractState);

    List<MyOrder> selectCompanyPaystate(Integer contractState, Integer payState);

    List<MyOrder> selectClientOrder(@Param("contractState") Integer contractState, @Param("orderUserid") Long orderUserid);


    List<MyOrder> selectCompanyPay(Integer contractState, Long orderUpload, Integer companyState);

    List<MyOrder> selectClientPay(Integer contractState, Long orderUpload, Integer clientState);


    int getOrderCount();

    void deleteOrder(Long id);

    List<MyOrder> searchCompanyDeal(Integer contractState, Integer payState, String copyrightName);
    List<MyOrder> searchCompanyDealSuccess(Integer contractState, String copyrightName);



}
