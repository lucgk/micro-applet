package com.micro.applet.callback.controller.thirdplatform;

import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 第三方平台授权
 *
 * @author liuhui
 * @version 1.0, 2021/3/19 11:17
 */
@Api(value = "/api/callback/authCallback")
@RequestMapping("/api/callback/authCallback")
@RestController
public class AuthCallbackController {

    private static  final Logger logger = LoggerFactory.getLogger(AuthCallbackController.class);

    @PostMapping()
    public String getComponetVerifyTicket(){

        return "";
    }
}
