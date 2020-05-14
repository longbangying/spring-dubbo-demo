package com.xbang.dubbo.commons.api;

import org.apache.dubbo.rpc.service.EchoService;

public interface TestEchoService extends EchoService {
    String test(String test);
}
