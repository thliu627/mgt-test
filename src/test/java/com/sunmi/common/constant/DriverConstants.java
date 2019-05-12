package com.sunmi.common.constant;

import com.sunmi.common.properties.PropertiesCache;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * @author thliu@credit2go.cn
 * @date 2019/3/25 21:59
 */
@Component
public class DriverConstants {

    private static Properties configProperties = PropertiesCache.getProperties("config.properties");
    public final static String driverCondition = configProperties.getProperty("web.driver");

}
