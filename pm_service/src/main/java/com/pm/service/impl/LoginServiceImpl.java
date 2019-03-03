package com.pm.service.impl;

import com.pm.dao.KeyWordMapper;
import com.pm.dao.MyKeywordMapper;
import com.pm.dao.UserMapper;
import com.pm.entity.MyKeyword;
import com.pm.entity.MyKeywordExample;
import com.pm.entity.User;
import com.pm.entity.UserExample;
import com.pm.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dell on 2017/8/1.
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    MyKeywordMapper myKeywordMapper;

    @Autowired
    KeyWordMapper keyWordMapper;

    @Override
    public User getUser(String username, String password) {
        return userMapper.selectByUsernameAndPassword(username, password);
    }

    @Override
    public User checkName(String username) {
        return userMapper.selectByUsername(username);
    }

    @Override
    public List<User> selectUser() {
        return userMapper.selectByExample(new UserExample());
    }

    @Override
    public int addUser(String username, String password, String nickname,String email,String admin) {
        return userMapper.insert(new User(username,password,nickname,email,admin));
    }

    @Override
    public int editUser(Long id, String username, String password, String nickname, String adress, String email, Long telephone, String wechat, String qq, String company, String workphone, String realname, String idcard,String paycode) {
        return userMapper.updateByPrimaryKeySelective(new User(id,username,password,nickname,adress,email,telephone,wechat,qq,company,workphone,realname,idcard,paycode));
    }

    @Override
    public User selectByPrimaryKey(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User queryUserByEmail(String email) {
        return userMapper.queryUserByEmail(email);
    }

    @Override
    public int updateUserCaptcha(String email, String captcha) {
        return userMapper.updateUserCaptcha(email,captcha);
    }

    @Override
    public int updateUserPwd(Long id, String password) {
        return userMapper.updateUserPwd(password,id);
    }

    @Override
    public int getUserCount() {
        return userMapper.countByExample(new UserExample());
    }

    @Override
    public List<MyKeyword> selectKeyword() {
        //return myKeywordMapper.selectByExample(new MyKeywordExample());
        return keyWordMapper.selectByExample(new MyKeyword());
    }

    @Override
    public int addKeyword(String newkeyword) {
        return myKeywordMapper.insertSelective(new MyKeyword(newkeyword));
    }

    @Override
    public int editKeyword(Long id, String editkeyword) {
        return myKeywordMapper.updateByPrimaryKey(new MyKeyword(id,editkeyword));
    }

    @Override
    public void deleteKeyword(Long id) {
        myKeywordMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<User> selectRealname(String realname) {
        return userMapper.selectRealname(realname);
    }


}
