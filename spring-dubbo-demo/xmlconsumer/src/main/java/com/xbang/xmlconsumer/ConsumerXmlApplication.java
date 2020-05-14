package com.xbang.xmlconsumer;

import com.xbang.commons.dubbo.api.ISayHelloService;
import com.xbang.commons.dubbo.api.TestService;
import com.xbang.commons.dubbo.api.XmlTestService;
import com.xbang.dubbo.commons.api.TestEchoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@Slf4j
public class ConsumerXmlApplication {

    public static void main(String[] args) {
        try {
            ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("consumer.xml");
            classPathXmlApplicationContext.start();

            XmlTestService testService = (XmlTestService) classPathXmlApplicationContext.getBean("xmlTestService");
            TestService testService1 = (TestService) classPathXmlApplicationContext.getBean("testService");
            ISayHelloService iSayHelloService = classPathXmlApplicationContext.getBean(ISayHelloService.class);
            TestEchoService testEchoService = classPathXmlApplicationContext.getBean(TestEchoService.class);
            System.out.println(testEchoService.$echo("OK"));
            log.info("xml-consumer 启动成功 按任意键退出.");
        } catch (BeansException e) {
           log.info(e.getMessage(),e);
        }


    }
}
