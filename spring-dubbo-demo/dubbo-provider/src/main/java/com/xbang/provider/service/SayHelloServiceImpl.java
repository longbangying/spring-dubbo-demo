package com.xbang.provider.service;

import com.xbang.commons.dubbo.api.ISayHelloService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@Service
@Slf4j
public class SayHelloServiceImpl implements ISayHelloService {

    @Override
    public String sayHello(String s) {
        log.info("Hello {}",s);
        return String.format(Locale.CHINA,"Hello %s",s);
    }


}
