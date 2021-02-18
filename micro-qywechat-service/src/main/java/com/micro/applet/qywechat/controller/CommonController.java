package com.micro.applet.qywechat.controller;

import com.micro.applet.qywechat.response.AccessToken;
import com.micro.applet.qywechat.service.CommonService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * token
 *
 * @author liuhui
 * @version 1.0, 2021/2/18 10:35
 */
@Api(value = "/api/qywechat/common")
@RequestMapping("/api/qywechat/common")
@RestController
public class CommonController {

    private static  final  Logger logger = LoggerFactory.getLogger(CommonController.class);

    @Autowired
    private CommonService commonService;

    /**
     * 获取企业access_token
     * @param corpid : 企业id （通过企业微信管理后台获取）
     * @param corpsecret : 企业秘钥（通过企业微信管理后台获取）
     * @return AccessToken
     * @Author liuhui
     * @Date 2021/2/18 - 14:15
    **/
    @RequestMapping(value = "/getToken",method = RequestMethod.POST)
    @ApiOperation(value = "getToken ... ",notes = "getToken notes",response = String.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "corpid",value = "企业ID",defaultValue = "ww619bb7a5b89a85d8",required = true),
            @ApiImplicitParam(name = "corpsecret",value = "秘钥",defaultValue = "87LteJZZ5BNYeWN-HSdSv9YFsBcPkz1XbB5cSGLxV7g",required = true)
    })
    public AccessToken getToken(@RequestParam(value = "corpid", required = true)String corpid,
                                @RequestParam(value = "corpsecret",required = true)String corpsecret){
        return commonService.getToken(corpid,corpsecret);
    }

}
