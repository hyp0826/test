package com.wisdomchannel.page;
import com.wisdomchannel.util.Assertion;
import com.wisdomchannel.util.BrowserEmulator;
import org.apache.bcel.generic.DREM;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;

/**
 * Created by xhm on 2017/8/8.
 */
public class ContactPage {
    private BrowserEmulator driver;
    private LoginPage loginPage;
    public static class getElement{
        public static final String INFORPUB_XPATH="xpath=>//*[@id='app']/div/div[3]/div/label[7]";
        public static final String CONTACT_XPATH="xpath=>//*[@id='app']/div/div[4]/div[1]/ul/li[3]";
        public static final String NEWCONTACT_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/button[3]";
        public static final String NAME_XPATH="xpath=>(//input[@type='text'])[3]";
        public static final String TELEPHONE_XPATH="xpath=>(//input[@type='text'])[4]";
        public static final String SHIPNAME_XPATH="xpath=>(//input[@type='text'])[5]";
        public static final String SHIPNUM_XPATH="xpath=>(//input[@type='text'])[6]";
        public static final String MMSI_XPATH="xpath=>(//input[@type='text'])[7]";
        public static final String SHIPTYPE_XPATH="xpath=>(//input[@type='text'])[8]";
        public static final String CONTACT_GROUP_XPATH="xpath=>(//input[@type='text'])[9]";
        public static final String CONTACT_GROUP_LIST_XPATH="xpath=>html/body/*/div/div[1]/ul/li";
        public static final String CONTACT_GROUP_SELECT_XPATH="xpath=>html/body/*/div/div[1]/ul/li[%s]";
        public static final String SAVEBTN_XPATH="xpath=>(//button[@type='button'])[20]";
        public static final String SEARCH_INPUT_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div[2]/input";
        public static final String SEARCH_BTN_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/button[1]";
        public static final String RESULT_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[2]/div/div/div/div/div[3]/table/tbody/tr[1]/td[%s]/div";

        public static final String RESULTLIST_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div/div[2]/div[2]/div/div/div[3]/table/tbody/tr[1]/td";
        public static final String TABLE_TR_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[2]/div/div/div/div/div[3]/table/tbody/tr";
        //*[@id='app']/div/div[4]/div[2]/div[2]/div/div/div/div/div[3]/table/tbody/tr[1]/td[3]/div
        public static final String UPDATA_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[2]/div/div/div/div/div[3]/table/tbody/tr[%s]/td[9]/div/button[1]";
        public static final String GROUP_SPAN_XPATH="css=>span.el-select__tags-text";
        public static final String GROUPS_XPATH="css=>span.el-select__tags-text";
        public static final String DELETE_GROUPS_XPATH="css=>i.el-tag__close.el-icon-close";
        public static final String DELETE_BTN_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[2]/div/div/div/div/div[3]/table/tbody/tr[%s]/td[9]/div/button[2]";
        //*[@id='app']/div/div[4]/div[2]/div[2]/div/div/div/div/div[3]/table/tbody/tr[3]/td[9]/div/button[2]
        //*[@id='app']/div/div[4]/div[2]/div[2]/div/div/div/div/div[3]/table/tbody/tr[4]/td[9]/div/button[2]
        public static final String DELETE_NAME_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[2]/div/div/div/div/div[3]/table/tbody/tr[%s]/td[3]/div";
        public static final String COMIT_DELETE_XPATH="xpath=>html/body/*/div/div[3]/button[2]";
        public static final String ALTER_XPATH="css=>.el-message__group";
        public static final String NODATA_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[2]/div/div/div/div/div[3]/div/span";
        //搜索
        public static final String SELECT_INPUT_XPATH="xpath=>//*/div[1]/input";
        //*[@id='app']/div/div[4]/div[2]/div[1]/div/div/div/div[1]/div[1]/input
        public static final String SELECT_LIST_XPATH="xpath=>html/body/*/div/div[1]/ul/ul[2]/li[2]/ul/li";
        public static final String SELECT_RESULT_XPATH="xpath=>/html/body/*/div/div[1]/ul/ul[2]/li[2]/ul/li[%s]/span";
        public static final String GROUP_SPANS_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[2]/div/div[1]/div/div[2]/form/div[7]/div/div/div[1]/span/span[%s]";
        public static final String CANCEL_BTN_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[2]/div/div[1]/div/div[3]/div/button[1]";
        public static final String RANDOM_RESLUT_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[2]/div/div/div/div/div[3]/table/tbody/tr[%s]/td[3]/div";

    }
    public ContactPage(BrowserEmulator driver){
        this.driver=driver;
        loginPage=new LoginPage(driver);
    }
    public void gotoContanct(boolean isCreate){
        driver.click(getElement.INFORPUB_XPATH);
        driver.click(getElement.CONTACT_XPATH);
        if (isCreate){
            driver.click(getElement.NEWCONTACT_XPATH);
        }else {
            List rows=driver.getElements(getElement.TABLE_TR_XPATH);
            driver.click(String.format(getElement.UPDATA_XPATH,loginPage.getRandom(rows.size(),1)));
        }
    }
    public void createContanct(String name,String telephone,String shipName,String shipNum,String mmsi,String shipType,boolean isCreate) throws InterruptedException {
        driver.click(getElement.INFORPUB_XPATH);
        Thread.sleep(3000);
        driver.click(getElement.CONTACT_XPATH);
        if (isCreate){
            driver.click(getElement.NEWCONTACT_XPATH);
        }
        else {
//            driver.refresh();
            List rows=driver.getElements(getElement.TABLE_TR_XPATH);
            driver.click(String.format(getElement.UPDATA_XPATH,loginPage.getRandom(rows.size(),1)));
        }
        String contanctName=String.format("%s%s",name,loginPage.getCurrentData());
        String shipNameInfo=String.format("%s%s",shipName,loginPage.getCurrentData());
        String shipTypeInfo=String.format("%s%s",shipType,loginPage.getCurrentData());
        Thread.sleep(5000);
        driver.type(getElement.NAME_XPATH,contanctName);
        driver.type(getElement.TELEPHONE_XPATH,telephone);
        driver.type(getElement.SHIPNAME_XPATH,shipNameInfo);
        driver.type(getElement.SHIPNUM_XPATH,shipNum);
        driver.type(getElement.MMSI_XPATH,mmsi);
        driver.type(getElement.SHIPTYPE_XPATH,shipTypeInfo);
        if (!isCreate&&loginPage.isElementPresent(driver,getElement.GROUP_SPAN_XPATH)){
//            System.out.println("LALALALAALAL");
            List groups=driver.getElements(getElement.GROUPS_XPATH);
            System.out.println(groups.size());
            for (int i=1;i<=groups.size();i++){
                Thread.sleep(2000);
                driver.click(getElement.DELETE_GROUPS_XPATH);
//                System.out.println("llllll");
            }
        }
        driver.click(getElement.CONTACT_GROUP_XPATH);
        Thread.sleep(3000);
        List rows = driver.getElements(getElement.CONTACT_GROUP_LIST_XPATH);
        String str=String.format(getElement.CONTACT_GROUP_SELECT_XPATH,loginPage.getRandom(rows.size(),1));
        Thread.sleep(3000);
        driver.click(str);
        driver.click(getElement.SAVEBTN_XPATH);
        if (isCreate){
            Assertion.verifyEquals(driver.getText(getElement.ALTER_XPATH),"添加联系人成功");
        }else {
            Assertion.verifyEquals(driver.getText(getElement.ALTER_XPATH),"编辑联系人成功");
        }

        String[] contancts=new String[]{contanctName,telephone,shipNameInfo,shipNum,mmsi,shipTypeInfo};
        searchCompare(contancts);
    }
    public void searchCompare(String[] contancts) throws InterruptedException {
        driver.type(getElement.SEARCH_INPUT_XPATH,contancts[0]);
        driver.click(getElement.SEARCH_BTN_XPATH);
        Thread.sleep(3000);
        List rows = driver.getElements(getElement.RESULTLIST_XPATH);
        for (int i=3;i<rows.size()-1;i++){
            String resultName=driver.getText(String.format(getElement.RESULT_XPATH,i));
            Assertion.verifyEquals(resultName,contancts[i-3]);
        }
    }
    public void delete() throws InterruptedException {
        driver.click(getElement.INFORPUB_XPATH);
        driver.click(getElement.CONTACT_XPATH);
        Thread.sleep(3000);
        List rows=driver.getElements(getElement.TABLE_TR_XPATH);
        String deletetr=loginPage.getRandom(rows.size(),1);
        String deleteName=driver.getText(String.format(getElement.DELETE_NAME_XPATH,deletetr));
        driver.click(String.format(getElement.DELETE_BTN_XPATH,deletetr));
        driver.click(getElement.COMIT_DELETE_XPATH);
        Assertion.verifyEquals(driver.getText(getElement.ALTER_XPATH),"联系人已删除");
        driver.type(getElement.SEARCH_INPUT_XPATH,deleteName);
        driver.click(getElement.SEARCH_BTN_XPATH);
        Assertion.verifyEquals(driver.getText(getElement.NODATA_XPATH),"暂无数据");
    }
    public void search() throws InterruptedException {
        driver.click(getElement.INFORPUB_XPATH);
        Thread.sleep(3000);
        driver.click(getElement.CONTACT_XPATH);
        driver.click(getElement.SELECT_INPUT_XPATH);
//        List rows=driver.getElements(getElement.SELECT_LIST_XPATH);
        String result=String.format(getElement.SELECT_RESULT_XPATH,1);
        Thread.sleep(1000);
        String resultTesxt=driver.getText("xpath=>html/body/*/div/div[1]/ul/ul[2]/li[2]/ul/li[1]");
        Thread.sleep(1000);
        driver.click(result);
        List trs=driver.getElements(getElement.TABLE_TR_XPATH);
        if (!loginPage.isElementPresent(driver,getElement.NODATA_XPATH)){
            System.out.println(!loginPage.isElementPresent(driver,getElement.NODATA_XPATH));
            for (int i=1;i<=trs.size();i++){
                Thread.sleep(1000);
                driver.click(String.format(getElement.UPDATA_XPATH,i));
                List groups=driver.getElements(getElement.GROUPS_XPATH);
                boolean isFind = false;
                for (int j=1;j<=groups.size();j++){
                    String group=driver.getText(String.format(getElement.GROUP_SPANS_XPATH,j));
                    if (group.equals(resultTesxt)){
                        isFind=true;
                        driver.click(getElement.CANCEL_BTN_XPATH);
                        break;
                    }
                }
            Assert.assertTrue(isFind);
            }
        }
        driver.refresh();
        driver.click(getElement.INFORPUB_XPATH);
        driver.click(getElement.CONTACT_XPATH);
        driver.click(getElement.SELECT_INPUT_XPATH);
        trs=driver.getElements(getElement.TABLE_TR_XPATH);
        String name= driver.getText(String.format(getElement.RANDOM_RESLUT_XPATH,loginPage.getRandom(trs.size(),1)));
        driver.type(getElement.SEARCH_INPUT_XPATH,name);
        driver.click(getElement.SEARCH_BTN_XPATH);
        Thread.sleep(3000);
        Assertion.verifyEquals(driver.getText(String.format(getElement.RESULT_XPATH,3)),name);

    }


}
