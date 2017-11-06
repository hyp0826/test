package com.wisdomchannel.page;

import com.wisdomchannel.util.BrowserEmulator;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import java.util.List;

/**
 * Created by huangyp on 2017/8/14.
 */
public class InfoTemplatePage {
    private BrowserEmulator driver;
    private LoginPage lgpg;

    public static class getElement {
        //信息模板
        public static final String INFODIFFUSION="xpath=>//*[@id='app']/div/div[3]/div/label[7]/span";
        public static final String INFOTEMPLATE="xpath=>//*[@id='app']/div/div[4]/div/ul/li[2]";
        public static final String ADDBUTTON="css=>div.el-card.module-item > div.el-card__body";
        public static final String TEXTBOX="css=>textarea.el-textarea__inner";
        public static final String SAVEBUTTON="xpath=>(//button[@type='button'])[9]";
        public static final String DELETEBUTTON="xpath=>(//button[@type='button'])[10]";
        public static final String MESSAGEBOX="class=>el-message__group";
        public static final String TEMPLIST="xpath=>//*[@id='app']/div/div[4]/div[2]/div[3]/div/div";

        public static final String TEMP="xpath=>//*[@id='app']/div/div[4]/div[2]/div[3]/div/div[%d]/div/div/div/div[1]";


        //信息发布
        public static final String XINXIFABU="xpath=>//*[@id='app']/div/div[4]/div/ul/li[1]";
        public static final String WRITEMASSAGEBTN="css=>div.el-card__body";
        public static final String NUMBERINPUTBOX="xpath=>(//input[@type='text'])[2]";
        public static final String ADDNUMBERBTN="xpath=>(//button[@type='button'])[9]";
        public static final String SELECTCONTACTBTN="xpath=>(//button[@type='button'])[10]";
        public static final String SELECTINTOTMEPBTN="xpath=>(//button[@type='button'])[11]";
        public static final String CONTENTINPUTBOX="css=>textarea.el-textarea__inner";
        public static final String SENDBTN="xpath=>(//button[@type='button'])[12]";
        public static final String FIRSTNUMBER="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div[1]/div/div[1]/div[2]/div[1]/div/div[3]/span/span[1]/span/span";

        public static final String FIRSTCONTENT="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div[1]/div/div[1]/div[2]/div[1]/div/div[3]/div[1]";

        public static final String CONTACTLIST1="xpath=>//*[@id='app']/div/div[4]/div[2]/div/div[2]/div[3]/div/ul/li[*]/div";
        public static final String CONTACTLIST1VALUE="xpath=>//*[@id='app']/div/div[4]/div[2]/div/div[2]/div[3]/div/ul/li[%s]/div";
        public static final String CONTACTLIST2="xpath=>//*[@id='app']/div/div[4]/div[2]/div/div[2]/div[3]/div/ul/li[%s]/ul/li";
        public static final String CONTACTLIST2VALUE="xpath=>//*[@id='app']/div/div[4]/div[2]/div/div[2]/div[3]/div/ul/li[%s]/ul/li[%s]";
        public static final String TEMPLIST2="xpath=>//*[@id='app']/div/div[4]/div[2]/div[2]/div/div[2]/div[1]/div[*]/div/div/div";
        public static final String TEMPLIST2VALUE="xpath=>//*[@id='app']/div/div[4]/div[2]/div[2]/div/div[2]/div[1]/div[%s]/div/div/div";
        public static final String BLANKPLACE="xpath=>//*[@id='app']/div/div[4]/div[2]/div/div[2]/div[2]/div[1]/div[1]/div/div[1]";
        public static final String SEARCHINPUTBOX="css=>input.el-input__inner";
        public static final String SEARCHBTN="xpath=>(//button[@type='button'])[7]";
        public static final String SEARCHLIST="xpath=>//*[@id='app']/div/div[4]/div[2]/div/div[1]/div/div[1]/div[2]/div[1]/div/div[*]";

        public static final String TIME="xpath=>//*[@id='app']/div/div[4]/div[2]/div/div[1]/div/div[1]/div[2]/div[1]/div/div[%s]/span";
//        public static final String
    }

    public InfoTemplatePage(BrowserEmulator driver){
        this.driver=driver;
        lgpg=new LoginPage(driver);

    }

    /*信息模板*/
    public void toinfotemplate() throws InterruptedException {
        Thread.sleep(2000);
        driver.click(getElement.INFODIFFUSION);
        Thread.sleep(2000);
        driver.click(getElement.INFOTEMPLATE);
    }

    /*信息模板*/
    public void toxinxifabu() throws InterruptedException {

        driver.click(getElement.XINXIFABU);
        Thread.sleep(2000);
    }



    public void toadd() throws InterruptedException {
        Thread.sleep(1000);
        driver.click(getElement.ADDBUTTON);
    }


    public void messagebox(String exp_text){
        Assert.assertEquals(driver.getText(getElement.MESSAGEBOX),exp_text);
    }


    public void newtemplate(String text) throws InterruptedException {
        driver.getElement(getElement.TEXTBOX).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        driver.type(getElement.TEXTBOX,text);
        driver.click(getElement.SAVEBUTTON);
    }

    //获取第一个模板
    public String firsttemptext(){
//        List rows= driver.getElements(getElement.TEMPLIST);
//        System.out.println("模板数："+rows.size());
        String str=driver.getText(String.format(getElement.TEMP,1));
        System.out.println("内容："+str);
        return str;
//        if(equals){Assert.assertEquals(str,name);}
//        else{Assert.assertNotEquals(str,name);}
    }

    //点击第一个模板
    public void clickfirsttemp(){
//        List rows= driver.getElements(getElement.TEMPLIST);
        driver.click(String.format(getElement.TEMP,1));
    }

    /*信息发布*/

    public void towritemsg() throws InterruptedException {
        Thread.sleep(1000);
        driver.click(getElement.WRITEMASSAGEBTN);
        Thread.sleep(1000);
    }

    public void writemsginput(String numb,String content){
        driver.type(getElement.NUMBERINPUTBOX,numb);
        driver.click(getElement.ADDNUMBERBTN);
        driver.type(getElement.CONTENTINPUTBOX,content);
        driver.click(getElement.SENDBTN);
    }

    //随机
    public void getrandomcontact(){
        List rows=driver.getElements(getElement.CONTACTLIST1);
        System.out.println(rows.size());
        for(int i=0;i<10;i++) {
            String x = lgpg.getRandom(rows.size(), 1);
            driver.click(String.format(getElement.CONTACTLIST1VALUE, x));
            List rows1 = driver.getElements(String.format(getElement.CONTACTLIST2, x));
            System.out.println(String.format(getElement.CONTACTLIST2, x));
            System.out.println(rows1.size());
            if (rows1.size() == 1) {
            } else {
                String y = lgpg.getRandom(rows1.size(), 1);
                driver.click(String.format(getElement.CONTACTLIST2VALUE, x, y));
                System.out.println(String.format(getElement.CONTACTLIST2VALUE, x, y));
                break;
            }
        }
    }

    //顺序
    public void getcontact(){
        List rows=driver.getElements(getElement.CONTACTLIST1);
        System.out.println(rows.size());
        for(int i=1;i<=rows.size();i++) {
            driver.click(String.format(getElement.CONTACTLIST1VALUE, i));
            List rows1 = driver.getElements(String.format(getElement.CONTACTLIST2, i));
            System.out.println(String.format(getElement.CONTACTLIST2, i));
            System.out.println(rows1.size());
            if (rows1.size() == 1) {
            } else {
                String y = lgpg.getRandom(rows1.size(), 1);
                driver.click(String.format(getElement.CONTACTLIST2VALUE, i, y));
                System.out.println(String.format(getElement.CONTACTLIST2VALUE, i, y));
                break;
            }
        }
    }

    public void getrandomtemp(){
        List rows=driver.getElements(getElement.TEMPLIST2);
        System.out.println(rows.size());
        driver.click(String.format(getElement.TEMPLIST2VALUE,lgpg.getRandom(rows.size(),1)));
    }

    public void writemsgtemp() throws InterruptedException {
        driver.click(getElement.SELECTCONTACTBTN);
        getcontact();
        Thread.sleep(2000);
        driver.click(getElement.SELECTINTOTMEPBTN);
        Thread.sleep(3000);
        getrandomtemp();
        driver.click(getElement.BLANKPLACE);
        driver.click(getElement.SENDBTN);

    }

    public void firstnumber(String numb){
        String str=driver.getText(getElement.FIRSTNUMBER);
        System.out.println("号码为："+str);
        Assert.assertEquals(str,numb);
    }

    public void firstcontent(String content){
        String str=driver.getText(getElement.FIRSTCONTENT);
        System.out.println("内容为："+str);
        Assert.assertEquals(str,content);
    }
    //时间搜索
    public void search(String time) throws InterruptedException {
        driver.click(getElement.SEARCHINPUTBOX);
        driver.type(getElement.SEARCHINPUTBOX,time);
        driver.click(getElement.SEARCHBTN);
        Thread.sleep(1000);
        List rows=driver.getElements(getElement.SEARCHLIST);
        System.out.println(rows.size());
        for(int i=1;i<rows.size();i=i+3){
            System.out.println(String.format(getElement.TIME,i));
            String str=driver.getText(String.format(getElement.TIME,i));
            String str1=str.substring(0,10);
            System.out.println(str1);
            Assert.assertEquals(str1,time);
        }

    }
}
