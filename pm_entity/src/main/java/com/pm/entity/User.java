package com.pm.entity;

public class User {
    private Long id;

    private String username;

    private String password;

    private String nickname;

    private String adress;

    private String email;

    private Long telephone;

    private String wechat;

    private String qq;

    private String company;

    private String workphone;

    private String admin;

    private String realname;

    private String idcard;

    private Long companyNumber;

    private String captcha;

    private String paycode;

    public User(Long id, String username, String password, String nickname, String adress, String email, Long telephone, String wechat, String qq, String company, String workphone, String admin, String realname, String idcard, Long companyNumber, String captcha, String paycode) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.adress = adress;
        this.email = email;
        this.telephone = telephone;
        this.wechat = wechat;
        this.qq = qq;
        this.company = company;
        this.workphone = workphone;
        this.admin = admin;
        this.realname = realname;
        this.idcard = idcard;
        this.companyNumber = companyNumber;
        this.captcha = captcha;
        this.paycode = paycode;
    }



    //注册
    public User(String username, String password, String nickname,String email,String admin) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
        this.admin = admin;
    }

    //保存个人信息
    public User(Long id, String username, String password, String nickname, String adress, String email, Long telephone, String wechat, String qq, String company, String workphone, String realname, String idcard, String paycode) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.adress = adress;
        this.email = email;
        this.telephone = telephone;
        this.wechat = wechat;
        this.qq = qq;
        this.company = company;
        this.workphone = workphone;
        this.realname = realname;
        this.idcard = idcard;
        this.paycode = paycode;
    }





    public User() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress == null ? null : adress.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Long getTelephone() {
        return telephone;
    }

    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getWorkphone() {
        return workphone;
    }

    public void setWorkphone(String workphone) {
        this.workphone = workphone == null ? null : workphone.trim();
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin == null ? null : admin.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public Long getCompanyNumber() {
        return companyNumber;
    }

    public void setCompanyNumber(Long companyNumber) {
        this.companyNumber = companyNumber;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha == null ? null : captcha.trim();
    }

    public String getPaycode() {
        return paycode;
    }

    public void setPaycode(String paycode) {
        this.paycode = paycode == null ? null : paycode.trim();
    }
}