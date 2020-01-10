package com.xbang.java.provider;

import com.xbang.commons.dubbo.api.ISayHelloService;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;

import java.io.IOException;

public class ProviderMain {

    public static void main(String[] args) {
        ServiceConfig<ISayHelloService> iSayHelloServiceServiceConfig = new ServiceConfig<>();
        iSayHelloServiceServiceConfig.setApplication(new ApplicationConfig("java-provider"));
        iSayHelloServiceServiceConfig.setRegistry(new RegistryConfig("zookeeper://47.104.171.254:2181"));
        iSayHelloServiceServiceConfig.setInterface(ISayHelloService.class);
        iSayHelloServiceServiceConfig.setRef(new ISayHelloService() {
            @Override
            public String sayHello(String s) {
                System.out.println(s + " 进来了");
                return "java: hello " + s + "!";
            }
        });

        iSayHelloServiceServiceConfig.export();

        try {
            System.out.println("按任意键退出");
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
