
package com.wisdomchannel.util;
import java.io.FileInputStream;
import java.util.Properties;
public class GlobalSettings {

    public static Properties prop = getProperties();

    public static String Host = prop.getProperty("Host", "http://192.168.64.104:8080");
    public static String timeout = prop.getProperty("Timeout", "5");

    public static String getProperty(String property) {
        return prop.getProperty(property);
    }

    public static Properties getProperties() {
        Properties prop = new Properties();
        try {
            FileInputStream file = new FileInputStream("prop.properties");
            prop.load(file);
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop;
    }
}

