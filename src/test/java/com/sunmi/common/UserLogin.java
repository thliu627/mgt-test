package com.sunmi.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class UserLogin {
    public static WebDriver driver;
    //封装driver

    public static void open() throws InterruptedException {
        String url = "https://test.mgt.sunmi.com";
        System.setProperty("webdriver.chrome.driver",
                "D:\\Tools\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
        //driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    public static void refresh() {
        driver.navigate().refresh();
    }

    public static void quit() {
        driver.quit();
    }


}


