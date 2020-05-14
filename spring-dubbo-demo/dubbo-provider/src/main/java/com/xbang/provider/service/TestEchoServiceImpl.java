package com.xbang.provider.service;

import com.xbang.dubbo.commons.api.TestEchoService;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.rpc.RpcContext;

@Service
public class TestEchoServiceImpl implements TestEchoService {

    @Override
    public String test(String test) {
        System.out.println(test);
        return test;
    }

    @Override
    public Object $echo(Object o) {
        System.out.println(RpcContext.getContext().getAttachment("xbang"));
        return o + "1";
    }
}
