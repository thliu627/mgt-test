package com.sunmi.common.selector;

import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

/**
 * @author thliu@credit2go.cn
 * @date 2019/3/26 23:22
 */
@Component
public class LoginSelector extends AbstractSelector {

    @Override
    protected String getPage () {
        return "loginPage";
    }

    public WebElement getUsernameInputText () {
        return getElement("loginPage.username");
    }

    public WebElement getPasswordInputText () {
        return getElement("loginPage.password");
    }

    public WebElement getLoginButton () {
        return getElement("loginPage.login");
    }

}
