package com.xbang.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xbang.commons.dubbo.api.ISayHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("dubbo")
public class DubboController {
    @Reference
    ISayHelloService iSayHelloService;
    @RequestMapping("test")
    public String test(){

        return iSayHelloService.sayHello("xbang");
    }
}
