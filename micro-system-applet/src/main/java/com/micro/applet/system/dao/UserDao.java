package com.micro.applet.system.dao;

import com.micro.applet.system.entity.UserInfo;

import java.util.List;

/**
 * TODO 添加类的描述
 *
 * @author liuhui
 * @version 1.0, 2021/1/19 19:35
 */
public interface UserDao {
    int saveUserInfo(UserInfo userInfo);

    int deleteUser(Long id);

    List<UserInfo> queryAll();
}
