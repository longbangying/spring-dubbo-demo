package com.xbang.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableDubbo
@Slf4j
public class DubboConsumerApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(DubboConsumerApplication.class,args);
    }
}
