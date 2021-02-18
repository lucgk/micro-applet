package com.micro.applet.qywechat.common.constants;

/**
 * 常量 API URL
 *
 * @author liuhui
 * @version 1.0, 2021/2/18 15:22
 */
public interface QYWECHATAPI {

    /**
     * 获取企业 access_token
     **/
    String API_ACCESSTOKEN = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid={0}&corpsecret={1}";

    /**
     * 发送应用消息
     **/
    String API_NES_PUSH = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token={0}";
}
