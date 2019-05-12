package com.sunmi.testng;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 * @author thliu@credit2go.cn
 * @date 2019/3/25 22:11
 */
@ContextConfiguration(locations = {"classpath*:META-INF/applicationContext.xml"})
public class AbstractMgtTests extends AbstractTestNGSpringContextTests {

    @BeforeSuite
    protected void beforeMethod () {
    }

    @Test
    protected void execute () throws InterruptedException {

    }

    @AfterMethod
    protected void afterMethod() {
    }

}
