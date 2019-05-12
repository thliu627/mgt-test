package com.sunmi.testcase;

import com.sunmi.function.AsideHandle;
import com.sunmi.function.InternalDataDescriptionHandle;
import com.sunmi.function.LoginHandle;
import com.sunmi.function.PageHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author thliu@credit2go.cn
 * @date 2019/3/31 22:49
 */
@Service
public class InternalDataTestCase {

    @Autowired
    private LoginHandle loginHandle;

    @Autowired
    private AsideHandle asideHandle;

    @Autowired
    private InternalDataDescriptionHandle internalDataDescriptionHandle;

    @Autowired
    private PageHandle pageHandle;

    @Value("#{configProp['test.mgt.login.username']}")
    private String username;

    @Value("#{configProp['test.mgt.login.password']}")
    private String password;

    public void testCreateInternalData () throws InterruptedException {
        pageHandle.open();
        loginHandle.login(username, password);
        asideHandle.getMenu("其它管理", "内部数据订阅管理");
        internalDataDescriptionHandle.createInternalDescription(
                true, false, true, false,
                "BBB", "呵呵", "13199992222", "thl238@gmail.com");
        pageHandle.sleep(10);
        pageHandle.quit();
    }

    public void testDeleteLastInternalDataRow () throws InterruptedException {
        pageHandle.open();
        loginHandle.login(username, password);
        asideHandle.getMenu("其它管理", "内部数据订阅管理");
        internalDataDescriptionHandle.deleteLastDescriptionRow();
        pageHandle.sleep(10);
        pageHandle.quit();
    }

    public void testEditLastInternalDataRow () throws InterruptedException {
        pageHandle.open();
        loginHandle.login(username, password);
        asideHandle.getMenu("其它管理", "内部数据订阅管理");
        internalDataDescriptionHandle.editLastDescriptionRow(
                true, false, true, false,
                "CCCC", "哦哦", "18833234444", "t123u523@gmail.com");
        pageHandle.sleep(10);
        pageHandle.quit();
    }

    public void testCreateEditAndDeleteInternalDataRow () throws InterruptedException {
        pageHandle.open();
        loginHandle.login(username, password);
        asideHandle.getMenu("其它管理", "内部数据订阅管理");
        internalDataDescriptionHandle.createInternalDescription(
                true, false, true, false,
                "BBB", "呵呵", "13199992222", "thl238@gmail.com");
        pageHandle.sleep(1);
        internalDataDescriptionHandle.editLastDescriptionRow(
                false, false, true, false,
                "CCCC", "哦哦", "18833234444", "t123u523@gmail.com");
        internalDataDescriptionHandle.deleteLastDescriptionRow();
        pageHandle.sleep(1);
        pageHandle.quit();
    }

}
