package com.pm.service;


import com.pm.entity.MyKeyword;
import com.pm.entity.User;

import java.util.List;

/**
 * Created by Dell on 2017/8/1.
 */
public interface LoginService {
    //用户相关方法
    User getUser(String username, String password);

    User checkName(String username);

    List<User> selectUser();


    int addUser(String username, String password, String nickname, String email, String admin);
    int editUser(Long id, String username, String password, String nickname, String adress, String email, Long telephone, String wechat, String qq, String company, String workphone, String realname, String idcard, String paycode);
    User selectByPrimaryKey(Long id);

    User queryUserByEmail(String email);
    int updateUserCaptcha(String email, String captcha);
    int updateUserPwd(Long id, String password);

    int getUserCount();

    //控制台相关方法
    List<MyKeyword> selectKeyword();
    int addKeyword(String newkeyword);
    int editKeyword(Long id, String editkeyword);
    void deleteKeyword(Long id);
    List<User> selectRealname(String realname);


}
