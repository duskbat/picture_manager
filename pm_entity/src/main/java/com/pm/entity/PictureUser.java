package com.pm.entity;

public class PictureUser {

    private FileUp fileUpEntity;

    private User userEntity;

    public FileUp getFileUpEntity() {
        return fileUpEntity;
    }

    public void setFileUpEntity(FileUp fileUpEntity) {
        this.fileUpEntity = fileUpEntity;
    }

    public User getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(User userEntity) {
        this.userEntity = userEntity;
    }

    private Long id;

    private Long picid;

    private Long userid;

    private Long shopid;

    private Long compareid;

    public PictureUser(Long id, Long picid, Long userid, Long shopid, Long compareid) {
        this.id = id;
        this.picid = picid;
        this.userid = userid;
        this.shopid = shopid;
        this.compareid = compareid;
    }

    public PictureUser() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPicid() {
        return picid;
    }

    public void setPicid(Long picid) {
        this.picid = picid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getShopid() {
        return shopid;
    }

    public void setShopid(Long shopid) {
        this.shopid = shopid;
    }

    public Long getCompareid() {
        return compareid;
    }

    public void setCompareid(Long compareid) {
        this.compareid = compareid;
    }



}