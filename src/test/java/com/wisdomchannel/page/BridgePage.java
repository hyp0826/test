package com.wisdomchannel.page;
import com.wisdomchannel.util.Assertion;
import com.wisdomchannel.util.BrowserEmulator;
import org.apache.poi.hssf.util.HSSFColor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by xhm on 2017/7/31.
 */
public class BridgePage {
    private BrowserEmulator driver;
    private String[] element;
    private LoginPage loginPage;
    public static class getElement{
        public static final String FACILITIES="xpath=>//*[@id='app']/div/div[3]/div/label[6]/descendant::node()[@class='el-radio-button__inner']";
        public static final String BRIDGE_XPATH="xpath=>//*[@id='app']/div/div[4]/div[1]/ul/li[2]";

        public static final String ADD_BRIDGE_XPATH="xpath=>//*[@id='overallBG']/div[2]/button[2]";
        public static final String SAVEBTN_XPATH="xpath=>(//button[@type='button'])[16]";
        public static final String BRIDGENAME_XPATH="xpath=>(//input[@type='text'])[2]";
        public static final String LON_XPATH="xpath=>(//input[@type='text'])[3]";
        public static final String LAT_XPATH="xpath=>(//input[@type='text'])[4]";
        public static final String CHANNEL_XPATH="xpath=>(//input[@type='text'])[5]";
        public static final String CHANNELSELECT_XPATH="xpath=>//*[@id='10c505fd-4d9c-4f99-8c4c-9e3d6c695388']/span";
        public static final String LICHENG_XPATH="xpath=>(//input[@type='text'])[6]";
        public static final String TONGHANG_NUM_XPATH="xpath=>(//input[@type='text'])[7]";
        public static final String HEGHT_XPATH="xpath=>(//input[@type='text'])[8]";
        public static final String WEIGHT_XPATH="xpath=>(//input[@type='text'])[9]";
        public static final String CEGAO_XPATH="xpath=>(//input[@type='text'])[10]";
        public static final String KUAJING_XPATH="xpath=>(//input[@type='text'])[11]";
        public static final String LEFT_XPATH="xpath=>(//input[@type='text'])[12]";
        public static final String RIGHT_XPATH="xpath=>(//input[@type='text'])[13]";
        public static final String HIGHT_XPATH="xpath=>(//input[@type='text'])[14]";
        public static final String LOW_XPATH="xpath=>(//input[@type='text'])[15]";
        public static final String DATA_XPATH="xpath=>(//input[@type='text'])[16]";
        public static final String UNIT_XPATH="xpath=>(//input[@type='text'])[17]";
        public static final String LIST_XPATH="xpath=>//*[@id='overallBG']/div[2]/button[1]";
        public static final String ALTER_XPATH="xpath=>html/body/div/div/p";
        public static final String RESLUTLIST_XPATH="xpath=>//*[@id='overallBG']/div[3]/div/div";
        public static final String RESLUT_XPATH="xpath=>//*/div[%s]/div/div[2]/button";
        public static final String RESLUTNAME_XPATH="xpath=>//*[@id='overallBG']/div[3]/div/div[%s]/div/div[2]/button/span/div[1]";
        public static final String CHANNEL_LIST_XPATH="xpath=>html/body/*/div/div[1]/ul/li";
        public static final String CHANNEL_SELECT_XPATH="xpath=>html/body/*/div/div[1]/ul/li[%s]";
        public static final String DELETEBTN_XPATH="xpath=>(//button[@type='button'])[17]";
        public static final String DELETEBtn_COMIT_XPATH="xpath=>html/body/*/div/div[3]/button[2]";
        public static final String DELETALERT_XPATH="xpath=>html/body/div[3]/div";
        public static final String LOCATE_XPATH="xpath=>(//button[@type='button'])[15]";
    }
    public BridgePage(BrowserEmulator driver){
        this.driver=driver;
        loginPage=new LoginPage(driver);
    }
    public void gotoCreateFrame() throws InterruptedException {
//        driver.js("window.scrollTo(0,document.body.scrollHeight)");
        driver.click(getElement.FACILITIES);
        driver.click(getElement.BRIDGE_XPATH);
        driver.click(getElement.ADD_BRIDGE_XPATH);

    }
    public void createBridge(String bridgeName,String mileage,String tonghangnum,String height,String width,String cegao,String kuajing,String left,String right,String high,String low,String data,String unit,boolean isCreate) throws InterruptedException {

        SimpleDateFormat df = new SimpleDateFormat("MMddHHmmss");//设置日期格式
        //获取当前时间
        String dataStr=df.format(new Date());
        String Name=String.format("%s%s",bridgeName,dataStr);
        Thread.sleep(3000);
        driver.clear(getElement.BRIDGENAME_XPATH);
        driver.type(getElement.BRIDGENAME_XPATH,Name);
//        System.out.println(Name);
        driver.click(getElement.LOCATE_XPATH);
        clickLocate();
        driver.click(getElement.CHANNEL_XPATH);
        Thread.sleep(3000);
        List rows = driver.getElements(getElement.CHANNEL_LIST_XPATH);
        String str=String.format(getElement.CHANNEL_SELECT_XPATH,loginPage.getRandom(rows.size(),1));
//        String channelName=driver.getText(str);
//        System.out.println(channelName);
        Thread.sleep(3000);
        driver.click(str);
        driver.type(getElement.LICHENG_XPATH,mileage);
        driver.type(getElement.TONGHANG_NUM_XPATH,tonghangnum);
        driver.type(getElement.HEGHT_XPATH,height);
        driver.type(getElement.WEIGHT_XPATH,width);
        driver.type(getElement.CEGAO_XPATH,cegao);
        driver.type(getElement.KUAJING_XPATH,kuajing);
        driver.type(getElement.LEFT_XPATH,left);
        driver.type(getElement.RIGHT_XPATH,right);
        driver.type(getElement.HIGHT_XPATH,high);
        driver.type(getElement.LOW_XPATH,low);
        driver.type(getElement.DATA_XPATH,data);
        driver.type(getElement.UNIT_XPATH,unit);
//        element=new String[]{Name,lon,lat,channelName,mileage,tonghangnum,height,width,cegao,kuajing,left,right,high,low,data,unit};
        driver.click(getElement.SAVEBTN_XPATH);
        if (isCreate){
            Assertion.verifyEquals(driver.getText(getElement.ALTER_XPATH),"添加桥梁成功");
//            Thread.sleep(3000);
            compare(Name);
        }
        else {
            Assertion.verifyEquals(driver.getText(getElement.ALTER_XPATH),"更新桥梁信息成功");
            Thread.sleep(3000);
            compare(Name);
        }

    }
    public void compare(String name) throws InterruptedException {
//        driver.refresh();
        Thread.sleep(5000);
        driver.click(getElement.LIST_XPATH);
        List rows = driver.getElements(getElement.RESLUTLIST_XPATH);
        driver.sendKeys(String.format(getElement.RESLUT_XPATH,rows.size()), Keys.DOWN);
        Assertion.verifyEquals(driver.getText(String.format(getElement.RESLUTNAME_XPATH,rows.size())),name);
    }
    public void gotoUpdata() throws InterruptedException {
        driver.click(getElement.FACILITIES);
        driver.click(getElement.BRIDGE_XPATH);
        driver.click(getElement.LIST_XPATH);
        List rows = driver.getElements(getElement.RESLUTLIST_XPATH);
        driver.sendKeys(String.format(getElement.RESLUT_XPATH,rows.size()), Keys.DOWN);
        Thread.sleep(3000);
        driver.click(String.format(getElement.RESLUT_XPATH,rows.size()));
        Thread.sleep(3000);
    }
    public void delete() throws InterruptedException {
        LoginPage loginPage=new LoginPage(driver);
        driver.click(getElement.FACILITIES);
        driver.click(getElement.BRIDGE_XPATH);
        driver.click(getElement.LIST_XPATH);
        List rows = driver.getElements(getElement.RESLUTLIST_XPATH);
        String resultData=String.format(getElement.RESLUT_XPATH,loginPage.getRandom(rows.size(),1));
        String resultRandom=loginPage.getRandom(rows.size(),1);
        String resultName=String.format(getElement.RESLUTNAME_XPATH,resultRandom);
        driver.sendKeys(resultData,Keys.DOWN);
//        System.out.println(resultData);
        driver.click(resultData);
        Thread.sleep(3000);
        driver.sendKeys(getElement.DELETEBTN_XPATH, Keys.DOWN);
        Thread.sleep(3000);
        driver.click(getElement.DELETEBTN_XPATH);
        driver.click(getElement.DELETEBtn_COMIT_XPATH);
        Assert.assertEquals(driver.getText(getElement.DELETALERT_XPATH),"删除桥梁成功");
        Reporter.log("删除桥梁成功");
        Assert.assertNotEquals(driver.getText(String.format(getElement.RESLUTNAME_XPATH,resultRandom)),resultName);
    }
    public void clickLocate(){
        int x=driver.getElement("id=>map_gc").getSize().getWidth();
        int y=driver.getElement("id=>map_gc").getSize().getHeight();
        System.out.println("宽度"+x);
        System.out.println("高度"+y);
        int a= Integer.parseInt((loginPage.getRandom(x-300,0)));
        int b= Integer.parseInt((loginPage.getRandom(y,0)));
        System.out.println(a);
        System.out.println(b);
        Actions action=driver.movetoelement("id=>map_gc",a,b);
        action.click().perform();
    }
}
