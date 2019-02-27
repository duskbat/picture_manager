package com.pm.dao;

import com.pm.entity.User;
import com.pm.entity.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    //登录验证
    User selectByUsernameAndPassword(String username, String password);

    User selectByUsername(String username);

    List<User> selectRealname(@Param("realname") String realname);


    User queryUserByEmail(@Param("email") String email);

    int updateUserCaptcha(@Param("email") String email, @Param("captcha") String captcha);

    int updateUserPwd(@Param("password") String password, @Param("id") Long id);




    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}