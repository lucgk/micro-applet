package com.micro.applet.qywechat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 企业微信API
 *
 * @author liuhui
 * @version 1.0, 2021/2/18 09:53
 */
@SpringBootApplication
@EnableCaching
public class QyWeChatApplication {

    public static void main(String[] args) {
        SpringApplication.run(QyWeChatApplication.class, args);
    }
}
