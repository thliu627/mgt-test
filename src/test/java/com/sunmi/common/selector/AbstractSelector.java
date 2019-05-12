package com.sunmi.common.selector;


import com.sunmi.common.utils.BySelector;
import com.sunmi.common.webdriver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * @author thliu@credit2go.cn
 * @date 2019/3/26 23:22
 */
@Component
public abstract class AbstractSelector {

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

    protected WebElement getElement (String elementKey) {
        return getDriver().findElement(BySelector.getElement(elementKey));
    }

    protected WebElement getElement (WebElement webElement, String elementKey) {
        return webElement.findElement(BySelector.getElement(elementKey));
    }

    protected List<WebElement> getElements (String elementKey) {
        return getDriver().findElements(BySelector.getElement(elementKey));
    }

    protected List<WebElement> getElements (WebElement webElement, String elementKey) {
        return webElement.findElements(BySelector.getElement(elementKey));
    }

    protected WebElement getElementByDynamicArgs (String elementKey, String ... argument) {
        return getDriver().findElement(BySelector.getElement(elementKey, argument));
    }

    protected WebElement getElementByDynamicArgs (WebElement webElement, String elementKey, String ... argument) {
        return webElement.findElement(BySelector.getElement(elementKey, argument));
    }


    abstract protected String getPage ();

    /**
     * 判断元素是否显示方法
     **/
    public boolean assertElementIs(WebElement element) {
        return element.isDisplayed();
    }
}
