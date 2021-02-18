package com.micro.applet.system.controller.login;

import com.alibaba.fastjson.JSONObject;
import com.micro.applet.system.common.constants.CommonConstans;
import com.micro.applet.system.common.results.AppletResult;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

/**
 * applet 登录
 *
 *
 * @author liuhui
 * @version 1.0, 2021/1/29 14:34
 */
@Slf4j
@Api("登录服务")
@Controller
@RequestMapping("/api/login/")
public class LoginController {

    @Autowired
    private RestTemplate restTemplate ;

    /**
     * 小程序用户登录
     *
     * @param code : wx.login()  临时登录凭证code
     * @return java.lang.String
     * @Author liuhui
     * @Date 2021/1/29 - 14:46
    **/
    public AppletResult appletLogin(String code){
        JSONObject js = restTemplate.getForObject(CommonConstans.Login.WECHAT_API_LOGIN_PREFIX + code, JSONObject.class);
        if(0==js.getInteger(CommonConstans.Login.WECHAT_RESULT_KEY_ERRCODE)){
            String openId = js.getString(CommonConstans.Login.WECHAT_RESULT_KEY_OPENID);
            String sessionKey = js.getString(CommonConstans.Login.WECHAT_RESULT_KEY_SESSIONKEY);
            return AppletResult.successWithDatas("");
        }else {
            return AppletResult.failWithMsg(js.getString(CommonConstans.Login.WECHAT_RESULT_KEY_ERRMSG));
        }
    }
}
