package com.micro.applet.system.dubbo;

import com.micro.applet.system.entity.UserInfo;
import com.micro.applet.system.service.UserService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * TODO 添加类的描述
 *
 * @author liuhui
 * @version 1.0, 2021/1/19 19:59
 */

@Service(version = "1.0.1",timeout = 3000)
public class UserDubboService implements IUserService{

    @Autowired
    private UserService userService;

    @Override
    public List<UserInfo> queryAll() {
        return userService.queryAll();
    }
}
