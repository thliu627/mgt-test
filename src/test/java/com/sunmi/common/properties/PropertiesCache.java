package com.sunmi.common.properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;

public class PropertiesCache {

    private static final Logger logger = LoggerFactory.getLogger(PropertiesCache.class);

    public static Map<String, Properties> cacheMap = new Hashtable<String, Properties>();


    static {
        try {
            PropertiesCache.setProperties("/META-INF/config/action.properties");
            PropertiesCache.setProperties("/META-INF/config/config.properties");
            PropertiesCache.setProperties("/META-INF/config/selector.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setProperties(String pName) throws IOException {
        Properties properties = new Properties();
        InputStream is = null;

        try {
            is = PropertiesCache.class.getResourceAsStream(pName);
            properties.load(is);
        } finally {
            if (is != null) {
                is.close();
            }

        }
        logger.info("Load to properties cache : " + pName);
        pName = pName.substring(pName.lastIndexOf("/")+1);
        cacheMap.put(pName, properties);
    }

    public static Properties getProperties(String pName) {
        return cacheMap.get(pName);
    }

    public static String getPropertiesValue(String pName, String key) {
        if (cacheMap.get(pName) == null) {
            return "";
        }

        return cacheMap.get(pName).getProperty(key);
    }
}
