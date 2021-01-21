package com.micro.applet.system.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试
 *
 * @author liuhui
 * @version 1.0, 2021/1/19 17:37
 */

@Slf4j
@Api("Home Test")
@Controller
@RequestMapping("/api/home/")
public class HomeController {


    public void index(){

    }

}
