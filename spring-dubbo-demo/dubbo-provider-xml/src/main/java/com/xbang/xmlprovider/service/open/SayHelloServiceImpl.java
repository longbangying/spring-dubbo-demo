package com.xbang.xmlprovider.service.open;

import com.xbang.commons.dubbo.api.ISayHelloService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Component
@Service
public class SayHelloServiceImpl implements ISayHelloService {

    @Override
    public String sayHello(String s) {
        return "xml: hello " + s +"!";
    }
}
