package com.sunmi.testcase.mgt;


import com.sunmi.function.AsideHandle;
import com.sunmi.function.InternalDataDescriptionHandle;
import com.sunmi.function.LoginHandle;
import com.sunmi.function.PageHandle;
import com.sunmi.testng.AbstractMgtTests;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author thliu@credit2go.cn
 * @date 2019/3/25 22:26
 */
public class MgtLoginTest extends AbstractMgtTests {

    @Autowired
    private LoginHandle loginHandle;

    @Autowired
    private AsideHandle asideHandle;

    @Autowired
    private InternalDataDescriptionHandle internalDataDescriptionHandle;

    @Autowired
    private PageHandle pageHandle;

    protected void execute() throws InterruptedException {
        pageHandle.open();
        loginHandle.login("", "");
        pageHandle.sleep(3);
        asideHandle.getMenu("其它管理", "内部数据订阅管理");
        pageHandle.sleep(2);
        internalDataDescriptionHandle.createInternalDescription(
                true, false, true, false,
                "研发部", "刘天航", "18645040875", "thliu528@gmail.com");
        pageHandle.quit();
    }

}
