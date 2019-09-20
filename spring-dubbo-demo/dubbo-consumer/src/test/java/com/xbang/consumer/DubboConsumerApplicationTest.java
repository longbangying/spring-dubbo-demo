package com.xbang.consumer;

import com.alibaba.fastjson.JSON;
import com.xbang.commons.dubbo.api.ISayHelloService;
import com.xbang.commons.dubbo.api.TestService;
import com.xbang.commons.dubbo.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.monitor.MonitorService;
import org.apache.dubbo.rpc.RpcContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


@SpringBootTest
@Slf4j
@RunWith(SpringRunner.class)
public class DubboConsumerApplicationTest {

   /*@Reference
    ISayHelloService iSayHelloService;*/

    @Reference(async = true,timeout = 10 * 1000,loadbalance = "roundrobin")
    TestService testService;




    /*@Test
    public void test(){
        long start0 = System.currentTimeMillis();
        for(int i=0;i<10000;i++){
            iSayHelloService.sayHello(UUID.randomUUID().toString());
        }
        log.info("耗时:{}",System.currentTimeMillis() - start0);
    }*/

    @Test
    public void asyncTest(){
        try {
            UserInfo userInfo  = testService.getUserInfo1();
            log.info("userInfo:{}",null == userInfo ? "none": JSON.toJSONString(userInfo));
            if(null == userInfo){
                Future<UserInfo> future = RpcContext.getContext().getFuture();
                userInfo = future.get();
                log.info("userInfo:{}",null == userInfo ? "none": JSON.toJSONString(userInfo));
            }
        } catch (InterruptedException e) {
           log.error(e.getMessage(),e);
        } catch (ExecutionException e) {
            log.error(e.getMessage(),e);
        }

    }

    @Test
    public void test1(){

        try {
            long start0 = System.currentTimeMillis();
            int count1 = 0;
            int count2 = 0;
            int count3 = 0;
            for(int i =0;i<100;i++){
                CompletableFuture<UserInfo> userInfoCompletableFuture = testService.getUserInfo();
                UserInfo userInfo = userInfoCompletableFuture.get();
                log.info("userInfo:{}",null == userInfo ? "none":JSON.toJSONString(userInfo));
                if("provider-1".equalsIgnoreCase(userInfo.getProvider())){
                    count1 ++;
                }else if("provider-2".equalsIgnoreCase(userInfo.getProvider())){
                    count2 ++;
                }else {
                    count3 ++;
                }
            }

            log.info("provider1:{} provider2:{} xml:{} time:{}",count1,count2,count3,System.currentTimeMillis() -start0);

        } catch (InterruptedException e) {
            log.error(e.getMessage(),e);
        } catch (ExecutionException e) {
            log.error(e.getMessage(),e);
        }
    }



}