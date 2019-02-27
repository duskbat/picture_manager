package com.pm.service;

import com.pm.dao.MyOrderMapper;
import com.pm.entity.MyOrder;
import com.pm.entity.MyOrderExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Dell on 2017/8/24.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    MyOrderMapper myOrderMapper;

    @Override
    public int addOrder(Long orderPicid, Long orderUserid,  Long orderUpload, String copyrightName, String copyrightNumber, Long copyrightTelephone, Integer application, Integer countryRange, Date startTime, Date endTime, Double price, String payAccount, String emailBox, String emailAdress,Integer payState, Integer contractState,Double companyPrice, Integer companyState, Integer clientState) {
        return myOrderMapper.insertSelective(new MyOrder(orderPicid,orderUserid, orderUpload,copyrightName,copyrightNumber, copyrightTelephone, application, countryRange,startTime, endTime,price, payAccount,emailBox, emailAdress,payState,contractState,companyPrice,companyState,clientState));
    }


    @Override
    public List<MyOrder> selectAllOrder() {
        return myOrderMapper.selectByExample(new MyOrderExample());
    }

    @Override
    public List<MyOrder> selectOneClientOrder(Long orderUserid) {
        return myOrderMapper.selectOneClientOrder(orderUserid);
    }

    @Override
    public MyOrder selectMyOrderById(Long id) {
        return myOrderMapper.selectOrderById(id);
    }

    @Override
    public int saveCompanyDeal(Long id,Integer payState, Integer contractState) {
        return myOrderMapper.updateByPrimaryKeySelective(new MyOrder(id,payState,contractState));
    }

    @Override
    public int saveCompanyPay(Long id,Integer companyState, Integer clientState, String companyAccount, String clientAccount) {
        return myOrderMapper.updateByPrimaryKeySelective(new MyOrder(id,companyState,clientState,companyAccount,clientAccount));
    }

    @Override
    public int saveClientPay(Long id,Integer companyState, Integer clientState, String clientAccount) {
        return myOrderMapper.updateByPrimaryKeySelective(new MyOrder(id,companyState,clientState,clientAccount));
    }

    @Override
    public int saveClientDeal(Long id, Integer payState,Date payTime) {
        return myOrderMapper.updateByPrimaryKeySelective(new MyOrder(id,payState,payTime));
    }

    @Override
    public List<MyOrder> selectCompanyOrder(Integer contractState) {
        return myOrderMapper.selectCompanyOrder(contractState);
    }

    @Override
    public List<MyOrder> selectCompanyPaystate(Integer contractState, Integer payState) {
        return myOrderMapper.selectCompanyPaystate(contractState, payState);
    }

    @Override
    public List<MyOrder> selectClientOrder(Integer contractState, Long orderUserid) {
        return myOrderMapper.selectClientOrder(contractState,orderUserid);
    }

    @Override
    public List<MyOrder> selectCompanyPay(Integer contractState, Long orderUpload,Integer companyState) {
        return myOrderMapper.selectCompanyPay(contractState,orderUpload,companyState);
    }

    @Override
    public List<MyOrder> selectClientPay(Integer contractState, Long orderUpload,Integer clientState) {
        return myOrderMapper.selectClientPay(contractState,orderUpload,clientState);
    }

    @Override
    public int getOrderCount() {
        return myOrderMapper.countByExample(new MyOrderExample());
    }

    @Override
    public void deleteOrder(Long id) {
        myOrderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<MyOrder> searchCompanyDeal(Integer contractState, Integer payState, String copyrightName) {
        return myOrderMapper.searchCompanyDeal(contractState,payState,copyrightName);
    }

    @Override
    public List<MyOrder> searchCompanyDealSuccess(Integer contractState, String copyrightName) {
        return myOrderMapper.searchCompanyDealSuccess(contractState,copyrightName);
    }

}
