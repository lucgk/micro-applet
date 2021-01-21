package com.micro.applet.gateway.controller;

import com.micro.applet.system.dubbo.IUserService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Home test
 *
 * @author liuhui
 * @version 1.0, 2021/1/20 09:31
 */
@Slf4j
@Api("Home Test")
@Controller
@RequestMapping("/api/home/")
public class HomeController {

    @Reference(version = "1.0.1")
    private IUserService userService;

    @GetMapping("index")
    public String index(){
        log.info(" HomeController index "+ userService.queryAll());
        return "SUCCESS";
    }

}
