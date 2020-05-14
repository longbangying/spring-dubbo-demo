package com.xbang.provider;

import com.xbang.commons.dubbo.api.ISayHelloService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableDubbo
@Slf4j
public class DubboProviderApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(DubboProviderApplication.class,args);

        String [] beans = ((ConfigurableApplicationContext) applicationContext).getBeanFactory().getSingletonNames();
        ISayHelloService iSayHelloService = (ISayHelloService) applicationContext.getBean("sayHelloServiceImpl");
        iSayHelloService.sayHello("xbang");
    }
}
