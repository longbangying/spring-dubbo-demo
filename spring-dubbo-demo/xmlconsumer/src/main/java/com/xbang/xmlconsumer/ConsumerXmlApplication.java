package com.xbang.xmlconsumer;

import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.fastjson.JSON;
import com.xbang.commons.dubbo.api.ISayHelloService;
import com.xbang.commons.dubbo.api.TestService;
import com.xbang.commons.dubbo.api.XmlTestService;
import com.xbang.commons.dubbo.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Slf4j
public class ConsumerXmlApplication {

    public static void main(String[] args) {
        try {
            ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("consumer.xml");
            classPathXmlApplicationContext.start();

            XmlTestService testService = (XmlTestService) classPathXmlApplicationContext.getBean("xmlTestService");
            TestService testService1 = (TestService) classPathXmlApplicationContext.getBean("testService");
            ISayHelloService iSayHelloService = classPathXmlApplicationContext.getBean(ISayHelloService.class);
            for(int i=0;i<10;i++){
                /*UserInfo userInfo = testService1.getUserInfo1();
                if(null == userInfo){
                    Future<UserInfo> userInfoFuture = RpcContext.getContext().getFuture();
                    userInfo = userInfoFuture.get();
                }
                log.info("userInfo:{} xml:{}",  testService1.getUserInfo1(),testService.getXml());*/
                System.out.println(iSayHelloService.sayHello("xml:" + i));
            }
            log.info("xml-consumer 启动成功 按任意键退出.");
            System.in.read();
        } catch (BeansException e) {
           log.info(e.getMessage(),e);
        } /*catch (InterruptedException e) {
            log.info(e.getMessage(),e);
        } catch (ExecutionException e) {
            log.info(e.getMessage(),e);
        }*/catch (IOException e){
            log.error(e.getMessage(),e);
        }


    }
}
