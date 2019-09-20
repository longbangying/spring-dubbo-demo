package com.xbang.consumer.controller;

import com.xbang.commons.dubbo.api.ISayHelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
