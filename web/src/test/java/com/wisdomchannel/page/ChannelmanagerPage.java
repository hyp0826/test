package com.wisdomchannel.page;

import com.wisdomchannel.util.BrowserEmulator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * Created by huangyp on 2017/7/28.
 */
public class ChannelmanagerPage {
    private BrowserEmulator driver;
    private LoginPage lgpage;
    public static class getElement {
        public static final String SEARCHINPUT = "xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div[1]/div[1]/div/div/input";
        public static final String SEARCHBUTTON = "xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div[1]/div[2]/button[1]";
        public static final String ADDBUTTON = "xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div[1]/div[2]/button[2]";
        public static final String SAVEBUTTON = "xpath=>//*[@id='app']/div/div[4]/div[2]/div[2]/div/div[3]/div/button[1]";

        public static final String CANCELBUTTON="xpath=>//*[@id='app']/div/div[4]/div[2]/div[2]/div/div[1]/div/div[3]/div/button[2]";
        public static final String SHESHIGUANLI="xpath=>//*[@id='app']/div/div[3]/div/label[6]/span";
        public static final String HANGDAOGUANLI="xpath=>//*[@id='app']/div/div[4]/div[1]/ul/li[4]";
        //新增页面
        public static final String CHANNELNAME="xpath=>//*[@id='app']/div/div[4]/div[2]/div[2]/div/div[2]/form/div[1]/div/div/input";
        public static final String UNIT="xpath=>//*[@id='app']/div/div[4]/div[2]/div[2]/div/div[2]/form/div[2]/div/div/div[1]/input";
        public static final String UNITLIST="xpath=>html/body/div[%d]/div/div[1]/ul/li";
        public static final String UNITVALUE="xpath=>html/body/div[%d]/div/div[1]/ul/li[%s]";

        public static final String LEVEL="xpath=>//*[@id='app']/div/div[4]/div[2]/div[2]/div/div[2]/form/div[3]/div/div/div[1]/input";
        public static final String LEVELLIST="xpath=>html/body/div[%d]/div/div[1]/ul/li";
        public static final String LEVELVALUE="xpath=>html/body/div[%d]/div/div[1]/ul/li[%s]";
        //channelLevel方法里面  public static final String levelContent="xpath=>html/body/div[2]/div/div[1]/ul/*/span[text()='二级']";
        public static final String GRAPHTYPE="xpath=>//*[@id='app']/div/div[4]/div[2]/div[2]/div/div[2]/form/div[4]/div/div/div[1]/input";
        public static final String GRAPHTYPELIST="xpath=>html/body/div[%d]/div/div[1]/ul/li";
        public static final String GRAPHTYPEVALUE="xpath=>html/body/div[%d]/div/div[1]/ul/li[%s]";

        public static final String geometricFigure="xpath=>(//input[@type='text'])[5]";
        public static final String CHANNELWIDTH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[2]/div/div[2]/form/div[6]/div/div/input";
        public static final String COLOUR= "css=>div.el-color-picker__trigger";
        public static final String COLOURENSURE="class=>el-color-dropdown__btn";
        //列表页
        public static final String FIRSTLINEEDIT="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div[2]/div[3]/table/tbody/tr/td[8]/div/button[1]";
        public static final String FIRSTLINENAME="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div[2]/div[3]/table/tbody/tr/td[2]/div";

        public static final String FIRSTLINEDELETE="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div[2]/div[3]/table/tbody/tr/td[8]/div/button[2]";
        //暂无数据
        public static final String NODATA="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div[2]/div[3]/div/span";

        //删除提示框
        public static final String DELETEENSURE="xpath=>html/body/div[2]/div/div[3]/button[2]";
        public static final String DELETEMASSAGE="class=>el-message-box__message";
    }

    public ChannelmanagerPage(BrowserEmulator driver){
        this.driver= driver;
        lgpage=new LoginPage(driver);
    }

    //进入航道管理页面
    public void channelManagement() throws InterruptedException {
        Thread.sleep(4000);
        driver.click(getElement.SHESHIGUANLI);
        Thread.sleep(1000);
        driver.click(getElement.HANGDAOGUANLI);
    }

    //输入关键字
    public void searchinput(String text){
        driver.type(getElement.SEARCHINPUT,text);
    }

    //点击查询按钮
    public void searchbutton(){
        driver.click(getElement.SEARCHBUTTON);
    }

    //点击新增按钮
    public void addbutton() throws InterruptedException {
        driver.click(getElement.ADDBUTTON);
        Thread.sleep(1000);
    }

    //点击保存按钮
    public void savebutton(){
        driver.click(getElement.SAVEBUTTON);
    }

    //点击取消按钮
    public void cancelbutton(){
        driver.click(getElement.CANCELBUTTON);
    }

    //航道级别
    public void channelLevel(String level) throws InterruptedException {
        Thread.sleep(1000);
//        driver.locatetimeout(5);
        driver.click("xpath=>html/body/*/div/div[1]/ul/*/span[text()='"+level+"']");
    }

    //新增航道
    public String newChannel(String channelname,String geometricFigure,String channelWidth) throws InterruptedException {

        String name=channelname+datetime();
        System.out.println("name: "+name);
        driver.type(getElement.CHANNELNAME,name);
        //gai
        System.out.println("选择单位");
        optionsBox(getElement.UNIT,getElement.UNITLIST,getElement.UNITVALUE);

        optionsBox(getElement.LEVEL,getElement.LEVELLIST,getElement.LEVELVALUE);
        optionsBox(getElement.GRAPHTYPE,getElement.GRAPHTYPELIST,getElement.GRAPHTYPEVALUE);


//        driver.type(ChannelmanagerPage.getElement.geometricFigure,geometricFigure);
        driver.type(getElement.CHANNELWIDTH,channelWidth);
        driver.click(getElement.COLOUR);
        Thread.sleep(1000);
        channelcolour();
        Thread.sleep(1000);
        driver.click(getElement.COLOURENSURE);
        Thread.sleep(1000);
        savebutton();
        Thread.sleep(500);
        return name;

    }



    //搜索航道
    public void searchChannel(String name,String xpath) throws InterruptedException {
        searchinput(name);
        searchbutton();
        Thread.sleep(1000);
        String text=driver.getText(xpath);
        System.out.println(text);
        Assert.assertEquals(text,name);

    }

    //获取当前时间
    public static String datetime()
    {
        SimpleDateFormat format = new SimpleDateFormat("MMddHHmmss");
        Date date = new Date();
        return(format.format(date));
    }

    //获取当前时间
    public static String datetimeformat(String geshi)
    {
        //yyyy年MM月dd日 HH时mm分ss秒
        SimpleDateFormat format = new SimpleDateFormat(geshi);
        Date date = new Date();
        return(format.format(date));
    }

    //选项框，随机选取选项
    public  void optionsBox(String XPATH,String LISTXPATH,String VALUEXPATH) throws InterruptedException {
        driver.click(XPATH);
        Thread.sleep(1000);
//        html/body/*
//        System.out.println(driver.getElement("xpath=>html/body/*").isDisplayed());
        List rows = driver.getElements("xpath=>html/body/*");
        for (int i=0;i<=rows.size();i++){
            System.out.println(driver.getElement(String.format("xpath=>html/body/div[%d]",i+2)).isDisplayed());
            if (driver.getElement(String.format("xpath=>html/body/div[%d]",i+2)).isDisplayed()){
                rows = driver.getElements(String.format(LISTXPATH,i+2));
                System.out.println(rows.size());
                String str=String.format(VALUEXPATH,i+2,lgpage.getRandom(rows.size(),1));
                String channelName=driver.getText(str);
                System.out.println(channelName);
                driver.click(str);
                break;
            }
        }
    }

    //选项框，随机选取选项(选项中有不能选择的选项)
    public  void optionsBox1(String XPATH,String LISTXPATH,String VALUEXPATH) throws InterruptedException {
        driver.click(XPATH);
        System.out.println("已经点击选项框");
        Thread.sleep(1000);
//        html/body/*
//        System.out.println(driver.getElement("xpath=>html/body/*").isDisplayed());
        List rows = driver.getElements("xpath=>html/body/*[@class='el-select-dropdown']");
        for (int i=1;i<=rows.size();i++){
            System.out.println(driver.getElement(String.format("xpath=>html/body/*[@class='el-select-dropdown'][%d]",i)).isDisplayed());
            if (driver.getElement(String.format("xpath=>html/body/*[@class='el-select-dropdown'][%d]",i)).isDisplayed()){
//                rows = driver.getElements(String.format(LISTXPATH,i+2));
                rows = driver.getElements(String.format("xpath=>html/body/*[@class='el-select-dropdown'][%d]/div/div[1]/ul/li[@class='el-select-dropdown__item']",i));
                System.out.println(rows.size());
                String str=String.format("xpath=>html/body/*[@class='el-select-dropdown'][%d]/div/div[1]/ul/li[@class='el-select-dropdown__item'][%s]",i,lgpage.getRandom(rows.size(),1));
                System.out.println(str);
                String channelName=driver.getText(str);
                System.out.println(channelName);
                driver.click(str);
                break;
            }
        }
    }

    //选项框，随机选取选项(选项中有不能选择的选项)
    public  void optionsBox2(String XPATH) throws InterruptedException {
        driver.click(XPATH);
        Thread.sleep(1000);
//        html/body/*
//        System.out.println(driver.getElement("xpath=>html/body/*").isDisplayed());
        List rows = driver.getElements("css=>div.el-select-dropdown[x-placement=\"bottom-start\"]>div>div>ul>li.el-select-dropdown__item[class=\"el-select-dropdown__item\"]");
        int size=rows.size();
        System.out.println(size);
        String str = String.format("document.querySelectorAll('div.el-select-dropdown[x-placement=\"bottom-start\"]>div>div>ul>li[class=\"el-select-dropdown__item\"]')[%s].click();",lgpage.getRandom(size-1, 0));
        driver.js(str);
    }



    //航道颜色
    public String channelcolour() throws InterruptedException {
        int x=driver.getElement("class=>el-color-svpanel__black").getSize().getWidth();
        int y=driver.getElement("class=>el-color-svpanel__black").getSize().getHeight();
        System.out.println("宽度"+x);
        System.out.println("高度"+y);
//        Actions action=new Actions(driver);
        int a= Integer.parseInt((lgpage.getRandom(x,0)));
        int b= Integer.parseInt((lgpage.getRandom(y,0)));
        System.out.println(a);
        System.out.println(b);

        Actions action=driver.movetoelement("class=>el-color-svpanel__black",a,b);
        action.click().perform();
        String channelvalue=driver.getText("class=>el-color-dropdown__value");
        System.out.println("航道颜色"+channelvalue);
        return channelvalue;


    }

    //定位一组元素，取值并存入数组中
    public  String[] elements(String xpath){
        List<WebElement> search_result = driver.getElements(xpath);
        System.out.println(search_result.size());
        String text[] = new String[search_result.size()];
        int i=0;
        for (WebElement result : search_result) {
            String text1=result.getText();
            System.out.println(text1);
            text[i]=text1;
            i++;
        }
        return text;
    }

    //在数组中查找某个值
    public  boolean useLoop(String[] arr, String targetValue) {
        for (String s : arr) {
            if (s.equals(targetValue))
                return true;
        }
        return false;
    }
}
