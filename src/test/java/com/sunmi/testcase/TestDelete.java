package com.sunmi.testcase;

import com.sunmi.common.UserLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author thliu@credit2go.cn
 * @date 2019/3/31 21:04
 */
public class TestDelete {

    @BeforeSuite
    public void beforeMethod() throws InterruptedException {
        UserLogin.open();
    }

    @Test
    public void delete() throws InterruptedException {
       /*Read.driver.findElement(By.className(".ivu-input.ivu-input-default.ivu-input-with-prefix")).sendKeys("liuanqi@sunmi.com");
        Read.driver.findElement(By.className("ivu-input ivu-input-default ivu-input-with-prefix ivu-input-with-suffix")).sendKeys("sunmi388");
        Thread.sleep(2000);
        Read.driver.findElement(By.className("ivu-btn ivu-btn-primary sunmi-button sunmi-button-active")).click();
*/


        UserLogin.driver.findElement(By.xpath("//input[@type='text']")).sendKeys("liuanqi@sunmi.com");
        UserLogin.driver.findElement(By.xpath("//input[@type='password']")).sendKeys("sunmi388");
        Thread.sleep(500);
        UserLogin.driver.findElement(By.xpath("//button[@type='button']")).click();
        Thread.sleep(2000);
        /**
         * 这里xpath规则为什么写//li[contains(@class,'ant-menu-submenu-inline')]
         * 而不是//li[@class=ant-menu-submenu-inline]呢？
         * 因为实际上这个li标签有三个class，而且其中一个还是动态的(根据是否展开一级树，class不同)
         * 因为需要模糊匹配class，而//li[@class=ant-menu-submenu-inline]这样的写法是不能模糊匹配三个class的
         * 他会按照精确匹配去查找相应class=ant-menu-submenu-inline的li标签
         * 因为需要使用xpath函数 contains
         * 意思是比如class=ant-menu-submenu-inline ant-menu ant-menu-open
         * //li[contains(@class,'ant-menu-submenu-inline')] 这样写会模糊匹配到上面的class
         */
        Actions actions = new Actions(UserLogin.driver);
        List<WebElement> webElementList = UserLogin.driver.findElements(By.xpath("//li[contains(@class,'ant-menu-submenu-inline')]"));
        for (WebElement webElement : webElementList) {
            if (webElement.getText().equals("其它管理")) {
                actions.moveToElement(webElement).perform();
                Thread.sleep(1000);
                webElement.click();
                Thread.sleep(1000);
                /**
                 * By.xpath("./ul/li")
                 * 注意xpath规则以<./>开头代表通过当前的某一DOM节点去寻找其下的子节点内容
                 * 这样就可以做到分步定位
                 */
                List<WebElement> childWebElementList = webElement.findElements(By.xpath("./ul/li"));
                for (WebElement childWebElement : childWebElementList) {
                    if (childWebElement.getText().equals("内部数据订阅管理")) {
                        Thread.sleep(1000);
                        actions.moveToElement(childWebElement).perform();
                        Thread.sleep(1000);
                        childWebElement.click();
                    }
                }
                Thread.sleep(1000);
                WebElement webElement1 = UserLogin.driver.findElement(By.xpath("/html/body/div/div/main/div"));
                webElement1.findElement(By.xpath("//div/div/div/div/button")).click();
                Thread.sleep(1000);
                WebElement webElement2 = UserLogin.driver.findElement(By.xpath("//div[@class='ant-modal-content']"));

                Thread.sleep(1000);
                webElement2.findElement(By.xpath("//span[text()='合作伙伴数据']/parent::label/span[contains(@class, 'ant-checkbox')]")).click();
                Thread.sleep(1000);
                webElement2.findElement(By.xpath("//span[text()='应用数据']/parent::label/span[contains(@class, 'ant-checkbox')]")).click();
                Thread.sleep(1000);
                webElement2.findElement(By.xpath("//input[@placeholder='部门']")).sendKeys("研发部");
                Thread.sleep(1000);
                webElement2.findElement(By.xpath("//input[@placeholder='姓名']")).sendKeys("刘天航");

                Thread.sleep(1000);
                actions.moveToElement(webElement2.findElement(By.xpath("//input[@placeholder='手机']"))).perform();
                Thread.sleep(1000);
                webElement2.findElement(By.xpath("//input[@placeholder='手机']")).sendKeys("18645040875");
                Thread.sleep(1000);
                actions.moveToElement(webElement2.findElement(By.xpath("//input[@placeholder='邮箱']"))).perform();
                Thread.sleep(1000);
                webElement2.findElement(By.xpath("//input[@placeholder='邮箱']")).sendKeys("thliu528@gmail.com");
                Thread.sleep(2000);
                webElement2.findElement(By.xpath("//span[text()='取 消']/parent::button")).click();
                Thread.sleep(3000);

            }
        }



    }

    @AfterMethod
    public void afterMethod() {
        UserLogin.quit();

    }

    public static void main(String[] args) {

    }
}
