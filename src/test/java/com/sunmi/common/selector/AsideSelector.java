package com.sunmi.common.selector;

import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author thliu@credit2go.cn
 * @date 2019/3/28 19:59
 */
@Component
public class AsideSelector extends AbstractSelector {
    @Override
    protected String getPage() {
        return "asidePage";
    }

    public WebElement getFirstLevelMenu (String menuName) {
        List<WebElement> webElementList = getElements("asidePage.firstLevelMenu");
        for (WebElement webElement : webElementList) {
            if (webElement.getText().equals(menuName)) {
                return webElement;
            }
        }
        //TODO 封装全局自定义异常
        return null;
    }

    public WebElement getSecondLevelMenu (WebElement currentElement, String menuName) {
        List<WebElement> webElementList = getElements(currentElement,"asidePage.secondLevelMenu");
        for (WebElement webElement : webElementList) {
            if (webElement.getText().equals(menuName)) {
                return webElement;
            }
        }
        //TODO 封装全局自定义异常
        return null;
    }
}
