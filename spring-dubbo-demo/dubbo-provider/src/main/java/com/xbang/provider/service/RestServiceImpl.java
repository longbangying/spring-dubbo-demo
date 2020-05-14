package com.xbang.provider.service;

import com.xbang.dubbo.commons.api.RestService;


public class RestServiceImpl implements RestService {

    @Override
    public String sayHello(String name) {
        return "hello" + name + "!";
    }
}
