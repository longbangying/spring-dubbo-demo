package com.xbang.consumer.controller;

import com.xbang.commons.dubbo.api.ISayHelloService;
import com.xbang.commons.dubbo.api.TestService;
import com.xbang.commons.vo.result.BaseResult;
import com.xbang.commons.vo.result.Result;
import com.xbang.commons.vo.result.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Slf4j
@RestController
@RequestMapping("dubbo")
public class DubboController {
    @Reference(loadbalance="roundrobin",check = false,async = false)
    ISayHelloService iSayHelloService;

    @Reference
    TestService testService;
    @RequestMapping("test")
    public String test() throws InterruptedException, ExecutionException {
        log.info("time:{}",System.currentTimeMillis());
        String result = iSayHelloService.sayHello("xbang");
        log.info("value:{}",result);
        Future<String> stringFuture =  RpcContext.getContext().getFuture();
        return stringFuture.get();
    }

    @PostMapping
    public Result test(@RequestParam("fileId") String fileId,
                       @RequestParam("type") String type){

        return BaseResult.getResult(ResultEnum.RESULT_SUCCESS,fileId + type);
    }

    @PostMapping("userInfo")
    public Result test111(){

        return BaseResult.getResult(ResultEnum.RESULT_SUCCESS,testService.getUserInfo1());
    }
}
