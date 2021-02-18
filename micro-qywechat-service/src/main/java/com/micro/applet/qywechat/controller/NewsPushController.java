package com.micro.applet.qywechat.controller;

import com.micro.applet.qywechat.response.NewPushResp;
import com.micro.applet.qywechat.service.NewsPushService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *  消息推送
 *
 * @author liuhui
 * @version 1.0, 2021/2/18 10:10
 */
@Api(value = "/api/qywechat/newspush",tags = {"NewsPushController"})
@RequestMapping("/api/qywechat/newspush")
@RestController
public class NewsPushController {

    @Autowired
    private NewsPushService newsPushService;

    /**
     * 图文消息
     * @param
     * @return
     * @Author liuhui
     * @Date 2021/2/18 - 10:25
    **/
    @RequestMapping(value = "/pushNews",method = RequestMethod.POST)
    @ApiOperation(value = "推送图文消息",notes = "pushNews notes",
            response = String.class)
    public NewPushResp pushNews(@RequestParam(value = "agentid", required = true)String agentid){
        return newsPushService.pushNews(agentid);
    }

}
