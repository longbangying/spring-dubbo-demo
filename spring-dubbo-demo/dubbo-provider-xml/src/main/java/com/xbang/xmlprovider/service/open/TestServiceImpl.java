package com.xbang.xmlprovider.service.open;

import com.xbang.commons.dubbo.api.TestService;
import com.xbang.commons.dubbo.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class TestServiceImpl implements TestService {

    @Override
    public String test(String s) {
        return "xbang";
    }

    @Override
    public CompletableFuture<UserInfo> getUserInfo() {
        log.info("xml");
        return CompletableFuture.supplyAsync(this::getUserInfo1);
    }

    @Override
    public UserInfo getUserInfo1() {
        log.info("xml");
        return UserInfo.getRandomUserInfo("xml");
    }
}
