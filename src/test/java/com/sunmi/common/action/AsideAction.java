package com.sunmi.common.action;

import com.sunmi.common.selector.AsideSelector;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author thliu@credit2go.cn
 * @date 2019/3/28 20:06
 */
@Component
public class AsideAction extends AbstractAction {

    @Autowired
    private AsideSelector asideSelector;

    public WebElement clickFirstLevelMenu (String menuName) {
        WebElement webElement = asideSelector.getFirstLevelMenu(menuName);
        webElement.click();
        return webElement;
    }

    public void clickSecondLevelMenu ( WebElement currentElement, String menuName) {
        asideSelector.getSecondLevelMenu(currentElement, menuName).click();
    }

}
