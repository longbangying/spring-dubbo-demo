package com.xbang.provider.service;

import com.xbang.commons.dubbo.api.TestService;
import com.xbang.commons.dubbo.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Component
@Service(async = true,timeout = 10 * 1000)
@Slf4j
public class TestServiceImpl implements TestService {
    @Override
    public String test(String s) {
        String result = String.format("yes %s",s);
        return result;
    }

    @Override
    public CompletableFuture<UserInfo> getUserInfo() {
        return CompletableFuture.supplyAsync(this::getUserInfo1);
    }

    @Override
    public UserInfo getUserInfo1() {
        try {
            Thread.sleep(1* 1000);
        } catch (InterruptedException e) {
            log.error(e.getMessage(),e);
        }
        return UserInfo.getRandomUserInfo();
    }
}
