package com.wisdomchannel.page;

import com.wisdomchannel.util.BrowserEmulator;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;

import static com.wisdomchannel.page.ChannelmanagerPage.datetime;

/**
 * Created by xhm on 2017/7/31.
 */
public class WharfPage {
    private BrowserEmulator driver;
    private LoginPage lgpage;
    private ChannelmanagerPage cmpage;
    private String[] element;
    public static class getElement{
        public static final String FACILITIES="xpath=>//*[@id='app']/div/div[3]/div/label[6]/span";
        public static final String WHARF_XPATH="xpath=>//*[@id='app']/div/div[4]/div[1]/ul/li[3]";
        public static final String ADD_WHARF_XPATH="xpath=>//*[@id='overallWF']/div[2]/button[2]";
        public static final String WHARFNAME_XPATH="xpath=>(//input[@type='text'])[4]";
        public static final String LON_XPATH="xpath=>(//input[@type='text'])[5]";
        public static final String LAT_XPATH="xpath=>(//input[@type='text'])[6]";
        public static final String AREA_XPATH="xpath=>(//input[@type='text'])[7]";
        public static final String AREALIST_XPATH="xpath=>html/body/div[%d]/div/div[1]/ul/li";
        public static final String AREAVALUE="xpath=>html/body/div[%d]/div/div[1]/ul/li[%s]";

        public static final String TYPE_XPATH="xpath=>(//input[@type='text'])[8]";
        public static final String TYPELIST_XPATH="xpath=>html/body/div[%d]/div/div[1]/ul/li";
        public static final String TYPEVALUE="xpath=>html/body/div[%d]/div/div[1]/ul/li[%s]";

        public static final String ADDRESS="xpath=>(//input[@type='text'])[9]";
        public static final String JIXIEQINGKUANG="xpath=>(//input[@type='text'])[10]";
        public static final String BENDIHUJISHU="xpath=>(//input[@type='text'])[11]";
        public static final String WAIDIHUJISHU="xpath=>(//input[@type='text'])[12]";
        public static final String NIANTUNTULIANG="xpath=>(//input[@type='text'])[13]";
        public static final String CANGCHUMIANJI="xpath=>(//input[@type='text'])[14]";

        public static final String TUDIXINGZHI="xpath=>(//input[@type='text'])[15]";
        public static final String TUDIXINZHILIST_XPATH="xpath=>html/body/div[%d]/div/div[1]/ul/li";
        public static final String TUDIXINGZHIVALUE="xpath=>html/body/div[%d]/div/div[1]/ul/li[%s]";
        //土地使用性质
        public static final String SHIYONGXINGZHI_XPATH="xpath=>(//input[@type='text'])[16]";
        public static final String SHIYONGXINGZHILIST_XPATH="xpath=>html/body/div[%d]/div/div[1]/ul/li";
        public static final String SHIYONGXINGZHIVALUE="xpath=>html/body/div[%d]/div/div[1]/ul/li[%s]";

        public static final String HANGDAO_XPATH="xpath=>(//input[@type='text'])[17]";
        public static final String HANGDAOLIST_XPATH="xpath=>html/body/div[%d]/div/div[1]/ul/li";
        public static final String HANGDAOVALUE="xpath=>html/body/div[%d]/div/div[1]/ul/li[%s]";

        public static final String JIGOU_XPATH="xpath=>(//input[@type='text'])[18]";
        public static final String JIGOULIST_XPATH="xpath=>html/body/div[%d]/div/div[1]/ul/li";
        public static final String JIGOUVALUE="xpath=>html/body/div[%d]/div/div[1]/ul/li[%s]";

        public static final String LIANXIREN="xpath=>(//input[@type='text'])[19]";
        public static final String HUOWUXINXI="xpath=>(//input[@type='text'])[20]";
        public static final String MIAOSHU="xpath=>(//input[@type='text'])[21]";
        public static final String FAREN="xpath=>(//input[@type='text'])[22]";
        public static final String MATOUCHANGDU="xpath=>(//input[@type='text'])[23]";
        public static final String BOWEISHU="xpath=>(//input[@type='text'])[24]";

        public static final String ANXIANZHENG="xpath=>(//input[@type='text'])[25]";
        public static final String ANXIANZHENGLIST_XPATH="xpath=>html/body/div[%d]/div/div[1]/ul/li";
        public static final String ANXIANZHENGVALUE="xpath=>html/body/div[%d]/div/div[1]/ul/li[%s]";

        public static final String XUKEZHENG_XPATH="xpath=>(//input[@type='text'])[26]";
        public static final String XUKEZHENGLIST_XPATH="xpath=>html/body/div[%d]/div/div[1]/ul/li";
        public static final String XUKEZHENGVALUE="xpath=>html/body/div[%d]/div/div[1]/ul/li[%s]";

        public static final String SAVEBUTTON="xpath=>(//button[@type='button'])[16]";

        //码头列表
        public static final String WHARFLISTBUTTON="xpath=>(//button[@type='button'])[11]";
        public static final String WHARFLIST="xpath=>//*[@id='list-wharf']/div/div";
        public static final String WHARFVALUE="xpath=>//*[@id='list-wharf']/div/div[%d]/div/div[2]/button/span/div[1]";
        public static final String WHARFLINE="xpath=>//*[@id='list-wharf']/div/div[%s]";



    }
    public WharfPage(BrowserEmulator driver){
        this.driver=driver;
        lgpage=new LoginPage(driver);
        cmpage=new ChannelmanagerPage(driver);
    }
    public void wharfmanege() throws InterruptedException {
        Thread.sleep(4000);
        driver.click(getElement.FACILITIES);
        Thread.sleep(2000);
        driver.click(getElement.WHARF_XPATH);
        Thread.sleep(3000);
    }

    public void toaddwharf() throws InterruptedException {
        driver.click(getElement.ADD_WHARF_XPATH);
        Thread.sleep(3000);
    }

    public void wharflist() throws InterruptedException {
        driver.click(getElement.WHARFLISTBUTTON);
        Thread.sleep(1000);
    }


    public String newWharf(String wharfname, String address, String jixieqingkuang, String bendihujishu,
                           String waidihujishu, String niantuntuliang, String cangchumianji, String lianxiren,
                           String huowuxinxi, String miaoshu, String faren, String matouchangdu,
                           String boweishu) throws InterruptedException {

        String name=wharfname+datetime();
        driver.type(getElement.WHARFNAME_XPATH,name);
//        String lon=lgpage.randomLonLat(4,53,73,135,"Lon");
//        String lat=lgpage.randomLonLat(4,53,73,135,"Lat");
//        driver.type(getElement.LON_XPATH,lon);
//        driver.type(getElement.LAT_XPATH,lat);
        driver.click("xpath=>(//button[@type='button'])[15]");
        drawWharf();
        cmpage.optionsBox1(getElement.AREA_XPATH,getElement.AREALIST_XPATH,getElement.AREAVALUE);
//        cmpage.optionsBox2(getElement.AREA_XPATH);

        cmpage.optionsBox1(getElement.TYPE_XPATH,getElement.TYPELIST_XPATH,getElement.TYPEVALUE);
//        cmpage.optionsBox2(getElement.TYPE_XPATH);

        driver.type(getElement.ADDRESS,address);
        driver.type(getElement.JIXIEQINGKUANG,jixieqingkuang);
        driver.type(getElement.BENDIHUJISHU,bendihujishu);
        driver.type(getElement.WAIDIHUJISHU,waidihujishu);
        driver.type(getElement.NIANTUNTULIANG,niantuntuliang);
        driver.type(getElement.CANGCHUMIANJI,cangchumianji);
        cmpage.optionsBox1(getElement.TUDIXINGZHI,getElement.TUDIXINZHILIST_XPATH,getElement.TUDIXINGZHIVALUE);

        cmpage.optionsBox1(getElement.SHIYONGXINGZHI_XPATH,getElement.SHIYONGXINGZHILIST_XPATH,getElement.SHIYONGXINGZHIVALUE);

        cmpage.optionsBox1(getElement.HANGDAO_XPATH,getElement.HANGDAOLIST_XPATH,getElement.HANGDAOVALUE);

        cmpage.optionsBox1(getElement.JIGOU_XPATH,getElement.JIGOULIST_XPATH,getElement.JIGOUVALUE);


//        cmpage.optionsBox2(getElement.TUDIXINGZHI);
//        cmpage.optionsBox2(getElement.SHIYONGXINGZHI_XPATH);
//        cmpage.optionsBox2(getElement.HANGDAO_XPATH);
//        cmpage.optionsBox2(getElement.JIGOU_XPATH);
        driver.type(getElement.LIANXIREN,lianxiren);
        driver.type(getElement.HUOWUXINXI,huowuxinxi);
        driver.type(getElement.MIAOSHU,miaoshu);
        driver.type(getElement.FAREN,faren);
        driver.type(getElement.MATOUCHANGDU,matouchangdu);
        driver.type(getElement.BOWEISHU,boweishu);
        cmpage.optionsBox1(getElement.ANXIANZHENG,getElement.ANXIANZHENGLIST_XPATH,getElement.ANXIANZHENGVALUE);

        cmpage.optionsBox1(getElement.XUKEZHENG_XPATH,getElement.XUKEZHENGLIST_XPATH,getElement.XUKEZHENGVALUE);
//        cmpage.optionsBox2(getElement.ANXIANZHENG);
//        cmpage.optionsBox2(getElement.XUKEZHENG_XPATH);
        driver.click(getElement.SAVEBUTTON);

        return name;


    }
    //检查最后一个码头
    public void checklast(String name){
        List rows= driver.getElements(getElement.WHARFLIST);
        String str=driver.getText(String.format(getElement.WHARFVALUE,rows.size()));
        Assert.assertEquals(str,name);

    }



    //绘制码头
    public void drawWharf() throws InterruptedException {
        int x=driver.getElement("id=>map_gc").getSize().getWidth();
        int y=driver.getElement("id=>map_gc").getSize().getHeight();
        System.out.println("宽度"+x);
        System.out.println("高度"+y);
//        Actions action=new Actions(driver);
        int a= Integer.parseInt((lgpage.getRandom(x-300,0)));
        int b= Integer.parseInt((lgpage.getRandom(y,0)));
        System.out.println(a);
        System.out.println(b);

        Actions action=driver.movetoelement("id=>map_gc",a,b);
//        action.moveToElement(browser.findElement(By.id("map_gc")),a,b);
        action.click().perform();
        Thread.sleep(1000);
        action=driver.movetoelement("id=>map_gc",a,b+50);
//        action.moveToElement(browser.findElement(By.id("map_gc")),a,b+50);
        action.click().perform();
        Thread.sleep(1000);
        action=driver.movetoelement("id=>map_gc",a+50,b+50);
//        action.moveToElement(browser.findElement(By.id("map_gc")),a+50,b+50);
        action.click().perform();
        Thread.sleep(1000);
        action=driver.movetoelement("id=>map_gc",a,b);
//        action.moveToElement(browser.findElement(By.id("map_gc")),a,b);
        action.doubleClick().perform();

    }
}
