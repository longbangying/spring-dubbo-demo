package com.xbang.consumer.controller;

import com.xbang.commons.dubbo.api.ISayHelloService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Slf4j
@RestController
@RequestMapping("dubbo")
public class DubboController {
    @Reference(loadbalance="roundrobin",check = false,async = true)
    ISayHelloService iSayHelloService;
    @RequestMapping("test")
    public String test() throws InterruptedException, ExecutionException {
        log.info("time:{}",System.currentTimeMillis());
        String result = iSayHelloService.sayHello("xbang");
        log.info("value:{}",result);
        Future<String> stringFuture =  RpcContext.getContext().getFuture();
        return stringFuture.get();
    }
}
