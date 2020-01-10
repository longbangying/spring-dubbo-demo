package com.xbang.java.consumer;

import com.xbang.commons.dubbo.api.ISayHelloService;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;

public class ConsumerMain {

    public static void main(String[] args) {
        ReferenceConfig<ISayHelloService> iSayHelloServiceReferenceConfig = new ReferenceConfig<>();
        iSayHelloServiceReferenceConfig.setApplication(new ApplicationConfig("java-comsumer"));
        iSayHelloServiceReferenceConfig.setRegistry(new RegistryConfig("zookeeper://47.104.171.254:2181"));
        iSayHelloServiceReferenceConfig.setInterface(ISayHelloService.class);
        iSayHelloServiceReferenceConfig.setLoadbalance("roundrobin");
        ISayHelloService iSayHelloService = iSayHelloServiceReferenceConfig.get();
        for (int i =0 ;i< 100;i++){
            System.out.println(iSayHelloService.sayHello("dubbo-java"));
        }
    }
}
