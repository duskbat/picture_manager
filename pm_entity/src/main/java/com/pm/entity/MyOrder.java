package com.pm.entity;

import java.util.Date;

public class MyOrder {


    private FileUp ofileUpEntity;

    private User ouserEntity;

    public User getUpuserEntity() {
        return upuserEntity;
    }

    public void setUpuserEntity(User upuserEntity) {
        this.upuserEntity = upuserEntity;
    }

    private User upuserEntity;

    public FileUp getOfileUpEntity() {
        return ofileUpEntity;
    }

    public void setOfileUpEntity(FileUp ofileUpEntity) {
        this.ofileUpEntity = ofileUpEntity;
    }

    public User getOuserEntity() {
        return ouserEntity;
    }

    public void setOuserEntity(User ouserEntity) {
        this.ouserEntity = ouserEntity;
    }


    private Long id;

    private Long orderPicid;

    private Long orderUserid;

    private Long orderUpload;

    private String copyrightName;

    private String copyrightNumber;

    private Long copyrightTelephone;

    private Integer application;

    private Integer countryRange;

    private Date startTime;

    private Date endTime;

    private Double price;

    private String payAccount;

    private String emailBox;

    private String emailAdress;

    private Integer payState;

    private Integer contractState;

    private String copyrightOwner;

    private String ownerNumber;

    private Double companyPrice;

    private Integer companyState;

    private Integer clientState;

    private String companyAccount;

    private String clientAccount;

    private Date payTime;

    public MyOrder(Long id, Long orderPicid, Long orderUserid, Long orderUpload, String copyrightName, String copyrightNumber, Long copyrightTelephone, Integer application, Integer countryRange, Date startTime, Date endTime, Double price, String payAccount, String emailBox, String emailAdress, Integer payState, Integer contractState, String copyrightOwner, String ownerNumber, Double companyPrice, Integer companyState, Integer clientState, String companyAccount, String clientAccount, Date payTime) {
        this.id = id;
        this.orderPicid = orderPicid;
        this.orderUserid = orderUserid;
        this.orderUpload = orderUpload;
        this.copyrightName = copyrightName;
        this.copyrightNumber = copyrightNumber;
        this.copyrightTelephone = copyrightTelephone;
        this.application = application;
        this.countryRange = countryRange;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
        this.payAccount = payAccount;
        this.emailBox = emailBox;
        this.emailAdress = emailAdress;
        this.payState = payState;
        this.contractState = contractState;
        this.copyrightOwner = copyrightOwner;
        this.ownerNumber = ownerNumber;
        this.companyPrice = companyPrice;
        this.companyState = companyState;
        this.clientState = clientState;
        this.companyAccount = companyAccount;
        this.clientAccount = clientAccount;
        this.payTime = payTime;
    }



    public MyOrder(Long orderPicid, Long orderUserid, Long orderUpload, String copyrightName, String copyrightNumber, Long copyrightTelephone, Integer application, Integer countryRange, Date startTime, Date endTime, Double price, String payAccount, String emailBox, String emailAdress,Integer payState, Integer contractState,Double companyPrice, Integer companyState, Integer clientState) {
        this.orderUpload = orderUpload;
        this.orderPicid = orderPicid;
        this.orderUserid = orderUserid;
        this.copyrightName = copyrightName;
        this.copyrightNumber = copyrightNumber;
        this.copyrightTelephone = copyrightTelephone;
        this.application = application;
        this.countryRange = countryRange;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
        this.payAccount = payAccount;
        this.emailBox = emailBox;
        this.emailAdress = emailAdress;
        this.payState = payState;
        this.contractState = contractState;
        this.companyPrice = companyPrice;
        this.companyState = companyState;
        this.clientState = clientState;
    }


    public MyOrder(Long id,Integer payState, Integer contractState) {
        this.id = id;
        this.payState = payState;
        this.contractState = contractState;

    }

    public MyOrder(Long id,Integer payState,Date payTime) {
        this.id = id;
        this.payState = payState;
        this.payTime = payTime;
    }


    public MyOrder(Long id,Integer companyState, Integer clientState, String companyAccount, String clientAccount) {
        this.id = id;
        this.companyState = companyState;
        this.clientState = clientState;
        this.companyAccount = companyAccount;
        this.clientAccount = clientAccount;
    }

    public MyOrder(Long id,Integer companyState, Integer clientState, String clientAccount) {
        this.id = id;
        this.companyState = companyState;
        this.clientState = clientState;
        this.clientAccount = clientAccount;

    }




    public MyOrder() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderPicid() {
        return orderPicid;
    }

    public void setOrderPicid(Long orderPicid) {
        this.orderPicid = orderPicid;
    }

    public Long getOrderUserid() {
        return orderUserid;
    }

    public void setOrderUserid(Long orderUserid) {
        this.orderUserid = orderUserid;
    }

    public Long getOrderUpload() {
        return orderUpload;
    }

    public void setOrderUpload(Long orderUpload) {
        this.orderUpload = orderUpload;
    }

    public String getCopyrightName() {
        return copyrightName;
    }

    public void setCopyrightName(String copyrightName) {
        this.copyrightName = copyrightName == null ? null : copyrightName.trim();
    }

    public String getCopyrightNumber() {
        return copyrightNumber;
    }

    public void setCopyrightNumber(String copyrightNumber) {
        this.copyrightNumber = copyrightNumber == null ? null : copyrightNumber.trim();
    }

    public Long getCopyrightTelephone() {
        return copyrightTelephone;
    }

    public void setCopyrightTelephone(Long copyrightTelephone) {
        this.copyrightTelephone = copyrightTelephone;
    }

    public Integer getApplication() {
        return application;
    }

    public void setApplication(Integer application) {
        this.application = application;
    }

    public Integer getCountryRange() {
        return countryRange;
    }

    public void setCountryRange(Integer countryRange) {
        this.countryRange = countryRange;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPayAccount() {
        return payAccount;
    }

    public void setPayAccount(String payAccount) {
        this.payAccount = payAccount == null ? null : payAccount.trim();
    }

    public String getEmailBox() {
        return emailBox;
    }

    public void setEmailBox(String emailBox) {
        this.emailBox = emailBox == null ? null : emailBox.trim();
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress == null ? null : emailAdress.trim();
    }

    public Integer getPayState() {
        return payState;
    }

    public void setPayState(Integer payState) {
        this.payState = payState;
    }

    public Integer getContractState() {
        return contractState;
    }

    public void setContractState(Integer contractState) {
        this.contractState = contractState;
    }

    public String getCopyrightOwner() {
        return copyrightOwner;
    }

    public void setCopyrightOwner(String copyrightOwner) {
        this.copyrightOwner = copyrightOwner == null ? null : copyrightOwner.trim();
    }

    public String getOwnerNumber() {
        return ownerNumber;
    }

    public void setOwnerNumber(String ownerNumber) {
        this.ownerNumber = ownerNumber == null ? null : ownerNumber.trim();
    }

    public Double getCompanyPrice() {
        return companyPrice;
    }

    public void setCompanyPrice(Double companyPrice) {
        this.companyPrice = companyPrice;
    }

    public Integer getCompanyState() {
        return companyState;
    }

    public void setCompanyState(Integer companyState) {
        this.companyState = companyState;
    }

    public Integer getClientState() {
        return clientState;
    }

    public void setClientState(Integer clientState) {
        this.clientState = clientState;
    }

    public String getCompanyAccount() {
        return companyAccount;
    }

    public void setCompanyAccount(String companyAccount) {
        this.companyAccount = companyAccount == null ? null : companyAccount.trim();
    }

    public String getClientAccount() {
        return clientAccount;
    }

    public void setClientAccount(String clientAccount) {
        this.clientAccount = clientAccount == null ? null : clientAccount.trim();
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }
}