package com.micro.applet.system.service;

import com.micro.applet.system.dao.UserDao;
import com.micro.applet.system.entity.UserInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * UserService
 *
 * @author liuhui
 * @version 1.0, 2021/1/19 19:32
 */

@Service
public class UserService {

    @Resource
    private UserDao userDao;

    public int saveUser(UserInfo userInfo) {
        return userDao.saveUserInfo(userInfo);
    }

    public int deleteUser(Long id) {
        return userDao.deleteUser(id);
    }

    public List<UserInfo> queryAll(){
        return userDao.queryAll();
    }
}
