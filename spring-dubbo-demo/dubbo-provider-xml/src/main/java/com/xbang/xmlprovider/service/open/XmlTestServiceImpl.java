package com.xbang.xmlprovider.service.open;

import com.xbang.commons.dubbo.api.XmlTestService;

public class XmlTestServiceImpl implements XmlTestService {

    @Override
    public String getXml() {
        return "xml";
    }
}
