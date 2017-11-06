package com.wisdomchannel.page;

import com.wisdomchannel.util.Assertion;
import com.wisdomchannel.util.BrowserEmulator;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.List;

/**
 * Created by xhm on 2017/9/11.
 */
public class UnitsPage {
    private BrowserEmulator driver;
    private LoginPage loginPage;
    public static class getElement{
        public static final String BASESETING_XPATH="xpath=>//*[@id='app']/div/div[3]/div/label[8]/span";
        public static final String ORG_XPATH="xpath=>//*[@id='app']/div/div[4]/div[1]/ul/li[2]/div";
        public static final String UNITS_SIDE_XPATH="xpath=>//*[@id='app']/div/div[4]/div[1]/ul/li[2]/ul/li[1]";
        public static final String CREATE_UNITS_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div[1]/div/div[2]/form/div[4]/div/button";
        public static final String UNITIS_NAME_XPATH="xpath=>(//input[@type='text'])[4]";
        public static final String SUPER_UNITIS_XPATH="xpath=>(//input[@type='text'])[5]";
        public static final String SUPER_UNITISLIST_XPATH="xpath=>html/body/*/div/div[1]/ul/li";
        public static final String SUPER_SELECE_XPATH="xpath=>html/body/*/div/div[1]/ul/li[%s]";
        public static final String UNITIS_ADDRESS_XPATH="xpath=>(//input[@type='text'])[6]";
        public static final String UNITIS_PHONENUM_XPATH="xpath=>(//input[@type='text'])[7]";
        public static final String UNITIS_HOMEPAGE_XPATH="xpath=>(//input[@type='text'])[8]";
        public static final String UNITIS_CONTACT_XPATH="xpath=>(//input[@type='text'])[9]";
        public static final String UNITIS_REMARK_XPATH="css=>textarea.el-textarea__inner";
        public static final String SAVE_BTN_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[2]/div/div[3]/div/button[1]";
        public static final String SEARCH_NAME_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div[1]/div/div[2]/form/div[1]/div/div/input";
        public static final String SEARCH_ADDRESS_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div[1]/div/div[2]/form/div[2]/div/div/input";
        public static final String SEARCH_BTN_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div[1]/div/div[2]/form/div[3]/div/button";
        public static final String RESULT_TEXT_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div[2]/div[1]/div/div[3]/table/tbody/tr/td[%s]/div";
        public static final String TABLE_TR_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div[2]/div[1]/div/div[3]/table/tbody/tr";
        public static final String TABLE_NAME_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div[2]/div[1]/div/div[3]/table/tbody/tr[%s]/td[2]/div";
        public static final String TABLE_ADDRESS_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div[2]/div[1]/div/div[3]/table/tbody/tr[%s]/td[4]/div";
        public static final String TABLE_UPDATA_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div[2]/div[1]/div/div[3]/table/tbody/tr[1]/td[7]/div/button[1]";
        public static final String TABLE_DELETE_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div[2]/div[1]/div/div[3]/table/tbody/tr[%s]/td[7]/div/button[2]";
        public static final String DELETE_COMIT_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[3]/div/div[3]/div/button[1]";
        public static final String NODATA_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div[2]/div[1]/div/div[3]/div/span";
        public static final String PAGE_COUNT_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div[2]/div[2]/div/span[2]/div/div[1]/input";
        public static final String PAGE_LIST_XPATH="xpath=>html/body/*/div/div[1]/ul/li";
        public static final String SELECT_PAGE_COUNT="xpath=>html/body/*/div/div[1]/ul/li[%s]";
        public static final String PAGE_TOTAL_COUNT="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div[2]/div[2]/div/span[1]";
    }
    public UnitsPage(BrowserEmulator driver){
        this.driver=driver;
        loginPage=new LoginPage(driver);
    }
    public String gotoUnits(String type) throws InterruptedException {
        driver.click(getElement.BASESETING_XPATH);
        driver.click(getElement.ORG_XPATH);
        driver.click(getElement.UNITS_SIDE_XPATH);
        String Name="";
        if (type.equals("新建")){
            driver.click(getElement.CREATE_UNITS_XPATH);
        }else if (type.equals("编辑")||type.equals("删除")){
            driver.click(String.format("xpath=>//*[@id='app']/div/div[4]/div[2]/div/div[2]/div[2]/div/ul/li[%d]",driver.getElements("xpath=>//*[@id='app']/div/div[4]/div[2]/div/div[2]/div[2]/div/ul/li").size()));
            Thread.sleep(3000);
            List rows=driver.getElements(getElement.TABLE_TR_XPATH);
           Name=driver.getText(String.format(getElement.TABLE_NAME_XPATH,rows.size()));
            if (type.equals("编辑")){
                driver.click(String.format(getElement.TABLE_UPDATA_XPATH,rows.size()));
            }else {
                driver.click(String.format(getElement.TABLE_DELETE_XPATH,rows.size()));
                driver.click(getElement.DELETE_COMIT_XPATH);
                driver.type(getElement.SEARCH_NAME_XPATH,Name);
                driver.click(getElement.SEARCH_BTN_XPATH);
                Thread.sleep(3000);
                if (loginPage.isElementPresent(driver, getElement.NODATA_XPATH)){
                    Assert.assertEquals(driver.getText(getElement.NODATA_XPATH),"暂无数据");
                    Reporter.log("删除成功！");
                }else {
                    Assertion.isTrue(false);
                    System.out.println("删除失败！");
                    Reporter.log("删除失败");
                }
            }

        }
        return Name;
    }
    public void create(String unitsName,String superUnits,String unitsAddress,String unitsPhone,String unitsHomepage,String unitsContact,String unitsRemark) throws InterruptedException {
        String newName=String.format("%s%s",unitsName,loginPage.getCurrentData());
        driver.type(getElement.UNITIS_NAME_XPATH,newName);
//        driver.type(getElement.SUPER_UNITIS_XPATH,superUnits);
       String supername= loginPage.selectListData(getElement.SUPER_UNITIS_XPATH,getElement.SUPER_UNITISLIST_XPATH,getElement.SUPER_SELECE_XPATH);
        driver.type(getElement.UNITIS_ADDRESS_XPATH,unitsAddress);
        driver.type(getElement.UNITIS_PHONENUM_XPATH,unitsPhone);
        driver.type(getElement.UNITIS_HOMEPAGE_XPATH,unitsHomepage);
        driver.type(getElement.UNITIS_CONTACT_XPATH,unitsContact);
        driver.type(getElement.UNITIS_REMARK_XPATH,unitsRemark);
        driver.click(getElement.SAVE_BTN_XPATH);
        String[] reslut=new String[]{newName,supername,unitsAddress,unitsContact,unitsPhone};
        checkResult(reslut);

    }
    public void checkResult(String[] result) throws InterruptedException {
        driver.type(getElement.SEARCH_NAME_XPATH,result[0]);
        driver.click(getElement.SEARCH_BTN_XPATH);
        Thread.sleep(3000);
        for (int i=0;i<result.length;i++){
            Assertion.verifyEquals(driver.getText(String.format(getElement.RESULT_TEXT_XPATH,i+2)),result[i]);
        }
    }
    public void query(String queryXpath,String checkXpath) throws InterruptedException {
        gotoUnits("");
        List rows=driver.getElements(getElement.TABLE_TR_XPATH);
        String searchName=driver.getText(String.format(checkXpath,loginPage.getRandom(rows.size(),1)));
        driver.type(queryXpath,searchName);
        driver.click(getElement.SEARCH_BTN_XPATH);
        Thread.sleep(3000);
        rows=driver.getElements(getElement.TABLE_TR_XPATH);
        boolean isTrue=false;
        for (int i=0;i<rows.size();i++){
            if (driver.getText(String.format(checkXpath,i+1)).contains(searchName)){
                isTrue=true;
            }
        }
        Assertion.isTrue(isTrue);
        driver.clear(getElement.SEARCH_NAME_XPATH);
        driver.click(getElement.SEARCH_BTN_XPATH);
    }
    public void queryData() throws InterruptedException {
        query(getElement.SEARCH_NAME_XPATH,getElement.TABLE_NAME_XPATH);
        driver.refresh();
        query(getElement.SEARCH_ADDRESS_XPATH,getElement.TABLE_ADDRESS_XPATH);
        driver.refresh();
        gotoUnits("");
        String selectPageCout=loginPage.selectListData(getElement.PAGE_COUNT_XPATH, getElement.PAGE_LIST_XPATH, getElement.SELECT_PAGE_COUNT);
        Thread.sleep(3000);
        boolean isTrue=false;
        String dataNum=driver.getText(getElement.PAGE_TOTAL_COUNT);
        Integer count=loginPage.getInt(dataNum);
        List trs=driver.getElements(getElement.TABLE_TR_XPATH);
        System.out.println(String.format("%s,%s,%s",selectPageCout,count,trs.size()));
        if (selectPageCout.contains("10")&&trs.size()>0&&trs.size()<=10){
            isTrue=true;
        }else if (selectPageCout.contains("20")&&trs.size()>=0&&trs.size()<=20){
            isTrue=true;
        }else if (selectPageCout.contains("30")&&trs.size()>=0&&trs.size()<=30){
            isTrue=true;
        }
        Assertion.isTrue(isTrue);

    }
}
