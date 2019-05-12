package com.sunmi.common.webdriver;

import org.openqa.selenium.*;

/**
 * @author thliu@credit2go.cn
 * @date 2019/3/26 23:29
 */
public class DriverManager {

    private WebDriver driver;

    public DriverManager(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public WebDriver loadDriver () {
        return this.driver;
    }

}
