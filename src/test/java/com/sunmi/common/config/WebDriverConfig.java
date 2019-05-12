package com.sunmi.common.config;

import com.sunmi.common.webdriver.DriverManager;
import com.sunmi.common.webdriver.conditions.ChromeDriverCondition;
import com.sunmi.common.webdriver.conditions.FireFoxDriverCondition;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @author thliu@credit2go.cn
 * @date 2019/3/26 23:33
 */
@Configuration
public class WebDriverConfig {

    @Value("#{configProp['web.chrome.driver']}")
    private String chromeDriverProperty;

    @Value("#{configProp['web.firefox.driver']}")
    private String chromeFireFoxProperty;

    @Value("#{configProp['web.chrome.driver.path']}")
    private String chromeDriverPath;

    @Value("#{configProp['web.firefox.driver.path']}")
    private String chromeFirefoxPath;

    @Bean
    @Conditional(ChromeDriverCondition.class)
    public DriverManager chromeDriverComponent () {
        System.setProperty(chromeDriverProperty, concludePath(chromeDriverPath));
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        return new DriverManager(webDriver);
    }

    @Bean
    @Conditional(FireFoxDriverCondition.class)
    public DriverManager fireFoxDriverComponent () {
        return new DriverManager(null);
    }

//    @Bean
//    @Conditional(FireFoxDriverCondition.class)
//    public DriverManager<FireFoxDriverLoader> fireFoxDriverComponent () {
//        Supplier<FireFoxDriverLoader> driverLoader = () -> {
//            FireFoxDriverLoader driver = null;
//            return new FireFoxDriverLoader();
//        };
//        return new DriverManager(driverLoader);
//    }

    private String concludePath (String path) {
        if (path.contains("classpath://")) {
            return this.getClass().getResource("../../../../" + path.replaceAll("classpath://","")).getPath();
        }
        return path;
    }
}
