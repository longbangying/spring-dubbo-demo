package com.xbang.consumer;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xbang.commons.dubbo.api.ISayHelloService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.junit.Assert.*;

@SpringBootTest
@Slf4j
@RunWith(SpringRunner.class)
public class DubboConsumerApplicationTest {

    @Reference
    ISayHelloService iSayHelloService;

    @Test
    public void test(){
        String result = iSayHelloService.sayHello(UUID.randomUUID().toString());
        log.info("result:{}",result);
    }

}