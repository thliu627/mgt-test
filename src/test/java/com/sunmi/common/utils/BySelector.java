package com.sunmi.common.utils;

import com.sunmi.common.properties.PropertiesCache;
import org.openqa.selenium.By;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * @author thliu@credit2go.cn
 * @date 2019/3/28 0:02
 */
public class BySelector {

    public static By getElement(String elementKey, String ... args) {
        Properties selectorProperties = PropertiesCache.getProperties("selector.properties");
        String locator = selectorProperties.getProperty(elementKey);
        String locatorType = locator.split(">")[0];
        String locatorValue = locator.split(">")[1];
        try {
            locatorValue = new String(locatorValue.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (locatorType.equals("id")) {
            return By.id(locatorValue);
        } else if (locatorType.equals("name")) {
            return By.name(locatorValue);
        } else if (locatorType.equals("className")) {
            return By.className(locatorValue);
        } else if (locatorType.equals("linkText")) {
            return By.linkText(locatorValue);
        } else if (locatorType.equals("tagName")) {
            return By.tagName(locatorValue);
        } else {
            if (args.length > 0 && locatorValue.contains("{}")) {
                for (String argument : args) {
                    locatorValue = locatorValue.substring(0, locatorValue.indexOf("{}")) + argument + locatorValue.substring(locatorValue.indexOf("{}")+2);
                }
            }
            return By.xpath(locatorValue);
        }
    }


    public static void main(String[] args) {
        String locatorValue = "xpath>//div[text()='{}']/parent::div/parent::div//span[text()='{}']/parent::button";
        String[] argus = new String[]{"1","2"};
        for (String arg : argus) {
        }
        System.out.println(locatorValue.substring(0, locatorValue.indexOf("{}")) + locatorValue.substring(locatorValue.indexOf("{}")+2));
    }
}
