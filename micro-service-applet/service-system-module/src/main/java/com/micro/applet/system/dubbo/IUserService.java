package com.micro.applet.system.dubbo;

import com.micro.applet.system.entity.UserInfo;

import java.util.List;

/**
 * 用户管理
 *
 * @author liuhui
 * @version 1.0, 2021/1/8 16:58
 */
public interface IUserService {

    List<UserInfo>  queryAll();
}
