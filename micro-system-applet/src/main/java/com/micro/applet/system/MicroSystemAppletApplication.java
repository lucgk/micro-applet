package com.micro.applet.system;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.micro.applet.system.dao")
@EnableDubbo
@SpringBootApplication
public class MicroSystemAppletApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroSystemAppletApplication.class, args);
    }
/*
    @Bean
    MeterRegistryCustomizer<MeterRegistry> configurer(
            @Value("${spring.application.name}") String applicationName) {
        return (registry) -> registry.config().commonTags("application", applicationName);
    }*/

}
