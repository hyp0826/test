package com.wisdomchannel.page;

import com.wisdomchannel.util.BrowserEmulator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

/**
 * Created by huangyp on 2017/8/22.
 */
public class BasicSettingPage {
    private BrowserEmulator driver;
    private ChannelmanagerPage cmpg;
    private LoginPage lgpg;

    public static class getElement {
        public static final String BASICSETTING="xpath=>//*[@id='app']/div/div[3]/div/label[8]/span";
        public static final String ORGANIZATION="xpath=>//*[@id='app']/div/div[4]/div/ul/li[2]/div";


        //组织-部门
        public static final String TREELIST="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div[2]/div/div/div[1]/div/div[2]/div/descendant::node()[@class='el-tree-node__label']";
        public static final String TREELISTVALUE="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div/div/div/div[2]/div[%s]/div[1]/span[2]";
        public static final String DEPARTMENT="xpath=>//*[@id='app']/div/div[4]/div/ul/li[2]/ul/li[2]";
//        public static final String ADDBTN="xpath=>//*[@id='app']/div/div[4]/div[2]/div[2]/button[1]";
        public static final String DELETEBTN="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div[2]/div/div/div[2]/div/form/div[7]/div/button[1]";
        public static final String DELETEENSUREBTN="xpath=>//*[@id='app']/div/div[4]/div[2]/div[2]/div/div[3]/div/button[1]";
        public static final String DEPARTMENTNAME="css=>input.el-input__inner";
        public static final String DEPARTMENTNUMBER="xpath=>(//input[@type='text'])[2]";
        public static final String DEPARTMENTCHARGE="xpath=>(//input[@type='text'])[3]";
        public static final String UNIT="xpath=>(//input[@type='text'])[4]";
        public static final String PARENTDEPARTMENT="xpath=>(//input[@type='text'])[5]";
        public static final String PARENTDEPARTMENTLIST="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div[2]/div/div/div[2]/div/form/div[5]/div/div/div[2]/div/descendant::node()[@class='el-tree-node__label']";
        public static final String REMARKS="css=>textarea.el-textarea__inner";
        public static final String SAVEBTN="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div[2]/div/div/div[2]/div/form/div[7]/div/button[2]";



    }

    public BasicSettingPage(BrowserEmulator driver){
        this.driver= driver;
        cmpg=new ChannelmanagerPage(driver);
        lgpg=new LoginPage(driver);
    }

    public void todepartment() throws InterruptedException {
        driver.click(getElement.BASICSETTING);
        Thread.sleep(2000);
        driver.click(getElement.ORGANIZATION);
        driver.click(getElement.DEPARTMENT);
        Thread.sleep(1000);
    }

    public String newdepartment(String name, String number, String charge, String remarks) throws InterruptedException {
//        driver.click(getElement.ADDBTN);
        String name1=name+cmpg.datetime();
        driver.type(getElement.DEPARTMENTNAME,name1);
        driver.type(getElement.DEPARTMENTNUMBER,number);
        driver.type(getElement.DEPARTMENTCHARGE,charge);
        cmpg.optionsBox2(getElement.UNIT);

        Thread.sleep(1000);
        //随机选择一个上级部门
        driver.click(getElement.PARENTDEPARTMENT);
        List<WebElement> search_result = driver.getElements(getElement.PARENTDEPARTMENTLIST);
        System.out.println("上级部门数"+search_result.size());
        int j=Integer.parseInt(lgpg.getRandom(search_result.size(),1));
        System.out.println("J："+j);
        int i=1;
        for(WebElement result : search_result){
            if(i==j){
                result.click();
                break;
            }
            i++;
        }
//        do {
//            for (WebElement result : search_result) {
//                boolean aa[]={false,true,false,true};
//                Random rand = new Random();
//                int num = rand.nextInt(aa.length);
//                boolean xx=aa[num];
//                System.out.println(num);
//                System.out.println(xx);
//                if(xx){result.click();
//                System.out.println("quzhi"+result.getText());
//                    break;
//                }
//            }
//        }while (driver.getElement("xpath=>//div[@class='el-tree deptTree el-tree--highlight-current']").isDisplayed());

        driver.type(getElement.REMARKS,remarks);
        driver.click(getElement.SAVEBTN);
        return name1;
    }

    public void deletedepartment() throws InterruptedException {
        List<WebElement> search_result = driver.getElements(getElement.TREELIST);
        System.out.println(search_result.size());
        String name=null;
        for(int i=1;i<=search_result.size();i++){
            name=search_result.get(search_result.size()-i).getText();
            System.out.println("部门名称："+name);
            if(name.contains("部门"+cmpg.datetimeformat("MMdd"))){
                search_result.get(search_result.size()-i).click();
                break;
            }
        }
//        for(WebElement result : search_result){
//                name=result.getText();
//                if(name.contains("部门")){
//                    result.click();
//                    break;
//                }
//        }
        driver.click(getElement.DELETEBTN);
        Thread.sleep(1000);
//        try {
//            driver.click("css=>div.v-modal");
//        }finally{
            driver.click(getElement.DELETEENSUREBTN);
            Assert.assertEquals(driver.getText("class=>el-message__group"),"删除部门成功！");
            Thread.sleep(1000);
//        }


//        String num=lgpg.getRandom(search_result.size(),1);
//        String xpath=String.format(getElement.TREELISTVALUE,num);
//        String name=driver.getText(xpath);
//        driver.click(xpath);
//        driver.click(getElement.DELETEBTN);
//        Thread.sleep(2000);
        String aa[]=cmpg.elements(getElement.TREELIST);
        Thread.sleep(1000);
        Assert.assertEquals(cmpg.useLoop(aa,name),false);
    }

    public void editdepartment(String name, String number, String charge, String remarks) throws InterruptedException {
        List<WebElement> search_result = driver.getElements(getElement.TREELIST);
        System.out.println(search_result.size());
        String name1=null;
        for(WebElement result : search_result){
            name1=result.getText();
            if(name1.contains("部门")){
                result.click();
                break;
            }
        }
        String name2=newdepartment(name,number,charge,remarks);
        Assert.assertEquals(driver.getText("class=>el-message__group"),"编辑部门成功");
        Thread.sleep(2000);
        String aa[]=cmpg.elements(getElement.TREELIST);
        Assert.assertEquals(cmpg.useLoop(aa,name2),true);

    }
}
