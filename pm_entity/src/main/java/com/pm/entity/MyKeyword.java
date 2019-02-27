package com.pm.entity;

public class MyKeyword {
    private Long id;

    private String keyname;

    public MyKeyword(Long id, String keyname) {
        this.id = id;
        this.keyname = keyname;
    }

    public MyKeyword(String keyname) {
        this.keyname = keyname;
    }

    public MyKeyword() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKeyname() {
        return keyname;
    }

    public void setKeyname(String keyname) {
        this.keyname = keyname == null ? null : keyname.trim();
    }
}