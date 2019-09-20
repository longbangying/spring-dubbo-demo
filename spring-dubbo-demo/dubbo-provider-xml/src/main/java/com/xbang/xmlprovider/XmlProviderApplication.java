package com.xbang.xmlprovider;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

@Slf4j
public class XmlProviderApplication {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("provider.xml");
        classPathXmlApplicationContext.start();
        String [] beans = classPathXmlApplicationContext.getBeanFactory().getSingletonNames();
        log.info("**********************************************************************************************");
        for(String bean : beans){
            log.info("beanName:{} beanType:{}",bean,classPathXmlApplicationContext.getBeanFactory().getType(bean));
        }
        log.info("**********************************************************************************************");
        log.info("xml-Provider 启动成功 按任意键退出.");
        System.in.read();
    }
}
