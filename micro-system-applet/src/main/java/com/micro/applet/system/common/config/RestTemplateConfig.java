package com.micro.applet.system.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;


/**
 *  配置 restful
 * @Author liuhui
 * @Date 2021/1/29 - 15:22
**/
@Configuration
public class RestTemplateConfig {


    @Bean
    public RestTemplate restTemplate(){
        SimpleClientHttpRequestFactory requestFactory = new  SimpleClientHttpRequestFactory();
        //单位为ms 建立连接超时
        requestFactory.setConnectTimeout(1000);
        //单位为ms 建立连接成功后 从服务器读取超时
        requestFactory.setReadTimeout(1000);

        RestTemplate restTemplate = new RestTemplate(requestFactory);
        return restTemplate;
    }
}
