package com.micro.applet.qywechat.service;

import com.micro.applet.qywechat.common.constants.QYWECHATAPI;
import com.micro.applet.qywechat.controller.CommonController;
import com.micro.applet.qywechat.response.AccessToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;

/**
 * TODO 添加类的描述
 *
 * @author liuhui
 * @version 1.0, 2021/2/18 14:16
 */
@Service
public class CommonService {

    private static  final Logger logger = LoggerFactory.getLogger(CommonService.class);

    @Autowired
    private RestTemplate restTemplate;

    @Cacheable(value = "access_token")
    public AccessToken getToken(String corpid, String corpsecret) {
        String url = MessageFormat.format(QYWECHATAPI.API_ACCESSTOKEN, corpid, corpsecret);
        logger.info(url);
        return restTemplate.getForObject(url, AccessToken.class);
    }
}
