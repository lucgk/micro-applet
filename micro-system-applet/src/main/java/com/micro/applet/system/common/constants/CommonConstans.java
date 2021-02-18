package com.micro.applet.system.common.constants;

/**
 * applet 常用常量
 *
 * @author liuhui
 * @version 1.0, 2021/1/29 14:55
 */
public interface CommonConstans {

    /**
     * 请求成功标识
     **/
    String FLAG_SUCCESS = "success";

    /**
     * 小程序 appid
     **/
    String APPLET_APPID = "wx0e8c5dd206f7fb91";

    /**
     * 小程序 appsecret
     **/
    String APPLET_APPSECRET = "02ca7ba77a7b8cbf6ea5554880b8e83b";


    /**
     * 微信登录相关
     **/
    interface  Login{

        
        String WECHAT_API_LOGIN_PREFIX = "https://api.weixin.qq.com/sns/jscode2session?appid="+APPLET_APPID+"&secret="+APPLET_APPSECRET+"&grant_type=authorization_code&js_code=";

        String WECHAT_RESULT_KEY_OPENID = "openid";
        String WECHAT_RESULT_KEY_SESSIONKEY = "session_key";
        String WECHAT_RESULT_KEY_ERRCODE = "errcode";
        String WECHAT_RESULT_KEY_ERRMSG = "errmsg";
    }


}
