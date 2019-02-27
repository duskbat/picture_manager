package com.pm.entity;

import java.util.Date;

public class MyNotice {
    private Long id;

    private String newTitle;

    private String newSource;

    private String newAuthor;

    private Date newTime;

    private Integer newRecord;

    private String newAttachment;

    private String newHtml;

    public MyNotice(Long id, String newTitle, String newSource, String newAuthor, Date newTime, Integer newRecord, String newAttachment, String newHtml) {
        this.id = id;
        this.newTitle = newTitle;
        this.newSource = newSource;
        this.newAuthor = newAuthor;
        this.newTime = newTime;
        this.newRecord = newRecord;
        this.newAttachment = newAttachment;
        this.newHtml = newHtml;
    }

    public MyNotice(String newTitle, String newSource, String newAuthor, Date newTime, Integer newRecord, String newHtml) {
        this.newTitle = newTitle;
        this.newSource = newSource;
        this.newAuthor = newAuthor;
        this.newTime = newTime;
        this.newRecord = newRecord;
        this.newHtml = newHtml;
    }

    public MyNotice(Long id, String newTitle, String newSource, String newAuthor, String newHtml) {
        this.id = id;
        this.newTitle = newTitle;
        this.newSource = newSource;
        this.newAuthor = newAuthor;
        this.newHtml = newHtml;
    }


    public MyNotice(Long id,String newAttachment) {
        this.id = id;
        this.newAttachment = newAttachment;
    }

    public MyNotice(Long id,Integer newRecord) {
        this.id = id;
        this.newRecord = newRecord;
    }



    public MyNotice() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNewTitle() {
        return newTitle;
    }

    public void setNewTitle(String newTitle) {
        this.newTitle = newTitle == null ? null : newTitle.trim();
    }

    public String getNewSource() {
        return newSource;
    }

    public void setNewSource(String newSource) {
        this.newSource = newSource == null ? null : newSource.trim();
    }

    public String getNewAuthor() {
        return newAuthor;
    }

    public void setNewAuthor(String newAuthor) {
        this.newAuthor = newAuthor == null ? null : newAuthor.trim();
    }

    public Date getNewTime() {
        return newTime;
    }

    public void setNewTime(Date newTime) {
        this.newTime = newTime;
    }

    public Integer getNewRecord() {
        return newRecord;
    }

    public void setNewRecord(Integer newRecord) {
        this.newRecord = newRecord;
    }

    public String getNewAttachment() {
        return newAttachment;
    }

    public void setNewAttachment(String newAttachment) {
        this.newAttachment = newAttachment == null ? null : newAttachment.trim();
    }

    public String getNewHtml() {
        return newHtml;
    }

    public void setNewHtml(String newHtml) {
        this.newHtml = newHtml == null ? null : newHtml.trim();
    }
}