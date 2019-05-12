package com.sunmi.common.action;

import com.sunmi.common.selector.LoginSelector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author thliu@credit2go.cn
 * @date 2019/3/25 21:59
 */
@Component
public class LoginAction {

    @Autowired
    private LoginSelector loginSelector;

    public void sendKeyUsername (String username) {
        loginSelector.getUsernameInputText().sendKeys(username);
    }

    public void sendKeyPassword (String password) {
        loginSelector.getPasswordInputText().sendKeys(password);
    }

    public void clickLoginButton () {
        loginSelector.getLoginButton().click();
    }

    public boolean assertLoginPage() {
        return loginSelector.assertElementIs(loginSelector.getUsernameInputText())
            && loginSelector.assertElementIs(loginSelector.getPasswordInputText())
            && loginSelector.assertElementIs(loginSelector.getLoginButton());
    }

}
