package com.wisdomchannel.page;
import com.wisdomchannel.util.BrowserEmulator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
/**
 * Created by xhm on 2017/7/28.
 */
public class LoginPage {
    private BrowserEmulator driver;
    public static class getElement{
        public static final String USERNAME_NAME = "xpath=>//*[@id='app']/div/div[1]/div/div/form/div[1]/div/div[2]/input";
        public static final String PASSWORD_NAME = "xpath=>//*[@id='app']/div/div[1]/div/div/form/div[2]/div/div/input";
        public static final String LOGIN_BUTTON = "xpath=>//*[@id='app']/div/div[1]/div/div/form/div[3]/div/button";
        public static final String LOGIN_SUCCESS = "xpath=>//*[@id='app']/div/div[1]/button";
        public static final String LOGIN_OUT="xpath=>html/body/*/button[2]";
        public static final String COMIT_BTN="xpath=>html/body/*/div/div[3]/button[2]";
    }
    public LoginPage(BrowserEmulator driver){
        this.driver=driver;
    }
    //登录
    public void login(String username,String password){
        driver.type(getElement.USERNAME_NAME,username);
        driver.type(getElement.PASSWORD_NAME,password);
        driver.click(getElement.LOGIN_BUTTON);
    }
    //返回成功之后的用户名
    public String user(){
        String text=driver.getText(getElement.LOGIN_SUCCESS);
        return text;
    }
    public void loginOut()throws InterruptedException{
        driver.click(getElement.LOGIN_SUCCESS);
        Thread.sleep(2000);
        driver.click(getElement.LOGIN_OUT);
        driver.click(getElement.COMIT_BTN);
    }
    //获取指定区域的随机值
    public String getRandom(int max,int min){
        Random random = new Random();
        String s =String.format("%d",random.nextInt(max)%(max-min+1) + min);
        return s;
    }
    public String randomDate(String beginDate, String endDate) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date start = format.parse(beginDate);// 构造开始日期
            Date end = format.parse(endDate);// 构造结束日期
            // getTime()表示返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
            if (start.getTime() >= end.getTime()) {
                return null;
            }
            long date = random(start.getTime(), end.getTime()) ;
            return format.format(new Date(date)) ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //获取两个时间段之间的随机值
    private static long random(long begin, long end) {
        long rtn = begin + (long) (Math.random() * (end - begin));
        // 如果返回的是开始时间和结束时间，则递归调用本函数查找随机值
        if (rtn == begin || rtn == end) {
            return random(begin, end);
        }
        return rtn;
    }
    //随机获取经纬度
    public String randomLonLat(double MinLon, double MaxLon, double MinLat, double MaxLat, String type) {
        Random random = new Random();
        BigDecimal db = new BigDecimal(Math.random() * (MaxLon - MinLon) + MinLon);
        String lon = db.setScale(6, BigDecimal.ROUND_HALF_UP).toString();// 小数后6位
        db = new BigDecimal(Math.random() * (MaxLat - MinLat) + MinLat);
        String lat = db.setScale(6, BigDecimal.ROUND_HALF_UP).toString();
        if (type.equals("Lon")) {
            return lon;
        } else {
            return lat;
        }
    }
    //获取当前时间
    public String getCurrentData(){
        SimpleDateFormat df = new SimpleDateFormat("MMddHHmmss");//设置日期格式
        //获取当前时间
        String dataStr=df.format(new Date());
        return dataStr;
    }
    //判断页面该元素是否存在，NoSuchElementException不管用
    public   boolean isElementPresent(BrowserEmulator driver,String el) {
        try {
//            System.out.println("存在");
            driver.getElement(el);
            return true;
        }
        catch (Exception e) {
//            System.out.println("不存在");
            return false;
        }
    }
    //从字符串中提取数字
    public int getInt(String str) {
        str = str.trim();
        String str2 = "";
        if (str != null && !"".equals(str)) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
                    str2 += str.charAt(i);
                }
            }
        }
        return Integer.parseInt(str2);
    }
    /**
     * 字符串转换成日期
     * @param str
     * @return date
     */
    public  Date StrToDate(String str) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    public  String DateToStr(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String str = format.format(date);
        return str;
    }
//    正常下拉框随机选择下拉列表里面的某一个元素
    public String selectListData(String inputXpath,String listXpath,String selectXpath) throws InterruptedException {
        driver.click(inputXpath);
        Thread.sleep(3000);
        List rows=driver.getElements(listXpath);
        String str=String.format(selectXpath,getRandom(rows.size(),1));
        String cliclStr=driver.getText(str);
        System.out.println(rows.size());
        driver.click(str);
        return cliclStr;
    }

  //对于不同层次的下拉数据的选择
    public String selectFromClass(String Name,String xpath,boolean isCreate){
        String text1="";
        List<WebElement> search_result = driver.getElements(xpath);
        int i=0;
        int j= Integer.parseInt(getRandom(search_result.size(),0));
        for (WebElement result:search_result) {
            text1=result.getAttribute("innerText");
            if (i==j&&isCreate){
                result.click();
                break;
            }
            else if (text1.equals(Name)&&!isCreate){
                result.click();
                break;
            }
            i++;
        }
        return text1;
    }
    //有多个下拉选择框时的随机选择
    public String randomCliclkList (String cliclXpath,String listXpath,String selectXpath) throws InterruptedException {
        driver.click(cliclXpath);
        driver.sendKeys(cliclXpath, Keys.ENTER);
        Thread.sleep(3000);
        List rows = driver.getElements("xpath=>html/body/*");
        String selectValue="";
        for (int i=0;i<=rows.size();i++){
            if (driver.getElement(String.format("xpath=>html/body/div[%d]",i+4)).isDisplayed()){
                rows = driver.getElements(String.format(listXpath,i+4));
                System.out.println(String.format(listXpath,i+4));
                String str=String.format(selectXpath,i+4,getRandom(rows.size(),1));
                System.out.println(str);
                selectValue=driver.getText(str);
                driver.click(str);
                break;
            }
        }
        return selectValue;
    }
}
