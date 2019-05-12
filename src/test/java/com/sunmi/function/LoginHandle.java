package com.sunmi.function;

import com.sunmi.common.action.LoginAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author thliu@credit2go.cn
 * @date 2019/3/28 0:24
 */
@Service
public class LoginHandle extends AbstractHandle{

    @Autowired
    private LoginAction loginAction;

    public void login (String username, String password) throws InterruptedException {
        if (loginAction.assertLoginPage()) {
            loginAction.sendKeyUsername(username);
            loginAction.sendKeyPassword(password);
            loginAction.clickLoginButton();
        }
    }

}
