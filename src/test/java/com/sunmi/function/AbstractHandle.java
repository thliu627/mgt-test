package com.sunmi.function;

import com.sunmi.common.webdriver.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author thliu@credit2go.cn
 * @date 2019/3/28 0:32
 */
@Service
public abstract class AbstractHandle {

    @Autowired
    protected DriverManager driverManager;

    public DriverManager getDriverManager() {
        return driverManager;
    }

    public void setDriverManager(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    public WebDriver getDriver() {
        return this.driverManager.loadDriver();
    }

    //关闭浏览器驱动方法
    public void stopDriver() {
        System.out.println("Stop Driver!");
        getDriver().close();
    }


    /*
     * 封装Element方法
     *
     * */
    public WebElement findElement(By by) {
        WebElement element=getDriver().findElement(by);
        return element;
    }

    /*
     * get封装
     * */
    public void get(String url) {
        getDriver().get(url);
    }

    /*
     * 封装click（点击）方法
     * 需要传入一个WebElement类型的元素
     *
     * */
    public void click(WebElement element) {
        if(element!=null) {
            element.click();
        }else {
            System.out.println("元素未定位到,定位失败");
        }
    }

    /*
     * 返回
     *
     * */
    public void back() {
        getDriver().navigate().back();
    }

    /*
     * 刷新
     *
     * */
    public void refresh() {
        getDriver().navigate().refresh();;
    }

    /**
     * 屏幕最大化
     *
     * */
    public void getWindowMax() {
        getDriver().manage().window().maximize();
    }
    /*
     * 休眠
     * */
    public void sleep(int num) {
        try {
            Thread.sleep(num * 1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    /**
     * 切换alert窗口
     *
     * */
    public void switchAlert() {
        getDriver().switchTo().alert();
    }

    /**
     *
     * 模态框切换
     * */
    public void switchToMode() {
        getDriver().switchTo().activeElement();
    }
    /**
     * actionMoveElement
     * */
    public void action(WebElement element){
        Actions action =new Actions(getDriver());
        action.moveToElement(element).perform();
    }

    /**
     * 获取cookcie
     * @return
     * */
    public Set<Cookie> getCookie(){
        Set<Cookie> cookies = getDriver().manage().getCookies();
        return cookies;
    }

    /**
     * 删除cookie
     * */
    public void deleteCookie(){
        getDriver().manage().deleteAllCookies();
    }
    /**
     * 设置cookie
     * */
    public void setCookie(Cookie cookie){
        getDriver().manage().addCookie(cookie);
    }
    /**
     * 获取当前系统窗口list
     * */
    public List<String> getWindowsHandles(){
        Set<String> winHandels = getDriver().getWindowHandles();
        List<String> handles = new ArrayList<String>(winHandels);
        return handles;
    }

    /*
     * 获取当前窗口
     * **/
    public String getWindowHandle(){
        return getDriver().getWindowHandle();
    }

    /**
     * 切换windows窗口
     * */
    public void switchWindows(String name){
        getDriver().switchTo().window(name);
    }
    /**
     * 获取当前url
     * */
    public String getUrl(){
        return getDriver().getCurrentUrl();
    }

    /**
     * 获取title
     * */
    public String getTitle(){
        return getDriver().getTitle();
    }
    /**
     * 传入参数截图
     * */
    public void takeScreenShot(TakesScreenshot drivername, String path) {
        String currentPath = System.getProperty("user.dir"); // get current work
        File scrFile = drivername.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(currentPath + "\\" + path));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("截图成功");
        }
    }

    /**
     * 封装定位一组elements的方法
     * */
    public List<WebElement> findElements(By by){
        return getDriver().findElements(by);
    }

    /**
     * 自动截图
     * */
    public void takeScreenShot() {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        String dateStr = sf.format(date);
        String path = this.getClass().getSimpleName() + "_" + dateStr + ".png";
        takeScreenShot((TakesScreenshot) getDriver(), path);
    }
}
