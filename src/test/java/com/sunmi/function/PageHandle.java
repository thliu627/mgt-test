package com.sunmi.function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author thliu@credit2go.cn
 * @date 2019/3/28 0:40
 */
@Service
public class PageHandle extends AbstractHandle{

    @Value("#{configProp['test.mgt.protocol']}")
    private String protocol;

    @Value("#{configProp['test.mgt.host']}")
    private String host;

    @Value("#{configProp['test.mgt.port']}")
    private String port;

    public void open () {
        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append(protocol);
        urlBuilder.append("://");
        urlBuilder.append(host);
        urlBuilder.append(":");
        urlBuilder.append(port);
        getDriver().get(urlBuilder.toString());
    }

    public void quit () {
        getDriver().quit();
    }
}
