package com.xbang.consumer;

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
public class DubboConsumerApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(DubboConsumerApplication.class,args);

        String [] beans = ((ConfigurableApplicationContext) applicationContext).getBeanFactory().getSingletonNames();
        log.info("bean info begin**********************************************************************************");
        for(String bean : beans ){
            String  beanType = ((ConfigurableApplicationContext) applicationContext).getBeanFactory().getType(bean).getName();
            if(!beanType.startsWith("org.springframework"))
                log.info("beanName:{} beanType:{}",bean, beanType);
        }
        log.info("bean info end**********************************************************************************");
    }
}
