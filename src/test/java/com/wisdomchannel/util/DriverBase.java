package com.wisdomchannel.util;

import java.lang.reflect.Constructor;

/**
 * @author
 * */
public class DriverBase {
    protected static BrowserEmulator driver;
//    protected BrowserEmulator driver;
    public void driverBase(){
        driver=new BrowserEmulator();
    }
    /**
	 * 获取driver
	 * */
	public static BrowserEmulator getDriver() {
        return driver;
    }

//    public static void setDriver(BrowserEmulator driver) {
//        DriverBase.driver = driver;
//    }
    /**
     * 自动截图
     * */
    public void takeScreenShot() {
        driver.takeScreenShot();
    }

    /**
     * 生成新页面
     * */
//    public synchronized static Object getPage(Class<?> key) {
//        Object obj = null;
//        try {
//            String pageClassName = key.getCanonicalName();
//
//            Class<?> clazz = Class.forName(pageClassName);
//            try {
//                Constructor<?> constructor = clazz.getConstructor(BrowserEmulator.class);
//                obj = constructor.newInstance(getDriver());
//
//            } catch (InstantiationException e) {
//                e.printStackTrace();
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }
//        } catch (Exception e) {
//        }
//        return obj;
//    }
}