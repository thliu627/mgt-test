package com.sunmi.common.action;

import com.sunmi.common.webdriver.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author thliu@credit2go.cn
 * @date 2019/3/26 22:41
 */
@Service
public abstract class AbstractAction {

    @Autowired
    protected DriverManager driverManager;

    public DriverManager getDriverManager() {
        return driverManager;
    }

    public void setDriverManager(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    public WebDriver getDriver() {
        return this.driverManager.loadDriver();
    }

    /**
     * 封装click（点击）方法
     * 需要传入一个WebElement类型的元素
     **/
    public void click(WebElement element) {
        if (element != null) {
            element.click();
        } else {
            System.out.println("元素未定位到,定位失败");
        }
    }

    /**
     * 封装输入方法
     **/
    public void sendKeys(WebElement element, String value) {
        if (element != null) {
            element.sendKeys(value);
        } else {
            System.out.println(element + "元素没有定位到,输入失败" + value);
        }
    }

    public void perform (WebElement element) {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).perform();
    }
    /*
     * 休眠
     * */
    public void sleep(int num) {
        try {
            Thread.sleep(num * 1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
