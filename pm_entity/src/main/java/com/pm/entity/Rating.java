package com.pm.entity;

import java.util.Date;

public class Rating {
    private Long ratingid;

    private Long userid;

    private Long pictureid;

    private Byte rating;

    private Date createtime;



    public Rating(Long userid, Long pictureid, Byte rating) {
        this.userid = userid;
        this.pictureid = pictureid;
        this.rating = rating;
    }

    public Rating(Long ratingid, Long userid, Long pictureid, Byte rating) {
        this.ratingid = ratingid;
        this.userid = userid;
        this.pictureid = pictureid;
        this.rating = rating;
    }

    public Rating(Long ratingid, Long userid, Long pictureid, Byte rating, Date createtime) {
        this.ratingid = ratingid;
        this.userid = userid;
        this.pictureid = pictureid;
        this.rating = rating;
        this.createtime = createtime;
    }

    public Rating() {
        super();
    }

    public Long getRatingid() {
        return ratingid;
    }

    public void setRatingid(Long ratingid) {
        this.ratingid = ratingid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getPictureid() {
        return pictureid;
    }

    public void setPictureid(Long pictureid) {
        this.pictureid = pictureid;
    }

    public Byte getRating() {
        return rating;
    }

    public void setRating(Byte rating) {
        this.rating = rating;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}