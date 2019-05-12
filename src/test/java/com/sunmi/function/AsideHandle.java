package com.sunmi.function;

import com.sunmi.common.action.AsideAction;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author thliu@credit2go.cn
 * @date 2019/3/28 20:10
 */
@Service
public class AsideHandle extends AbstractHandle {

    @Autowired
    private AsideAction asideAction;

    public void getMenu (String firstLevelMenuName, String secondLevelMenuName) {
        sleep(4);
        WebElement webElement = asideAction.clickFirstLevelMenu(firstLevelMenuName);
        sleep(2);
        asideAction.clickSecondLevelMenu(webElement, secondLevelMenuName);
        sleep(2);
    }
}
