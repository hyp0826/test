package com.wisdomchannel.page;

import com.wisdomchannel.util.Assertion;
import com.wisdomchannel.util.BrowserEmulator;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.List;

/**
 * Created by xhm on 2017/9/8.
 */
public class PersonPage { private BrowserEmulator driver;
    private LoginPage loginPage;
    private String[] reslut;
    public static class getElement{
        public static final String BASESETING_XPATH="xpath=>//*[@id='app']/div/div[3]/div/label[8]/span";
        public static final String ORG_XPATH="xpath=>//*[@id='app']/div/div[4]/div[1]/ul/li[2]/div";
        public static final String PERSON_XPATH="xpath=>//*[@id='app']/div/div[4]/div[1]/ul/li[2]/ul/li[4]";
        public static final String CREATE_PERSON_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div[1]/div/div[2]/form/div[5]/div/button";
        public static final String USERNAME_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[2]/div/div[2]/div/div[1]/div[1]/form/div[1]/div/div/input";

        public static final String NAME_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[2]/div/div[2]/div/div[1]/div[1]/form/div[2]/div/div/input";
        public static final String PWD_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[2]/div/div[2]/div/div[1]/div[2]/form/div[1]/div/div/input";
        public static final String DEPARTMENT_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[2]/div/div[2]/div/div[1]/div[2]/form/div[2]/div/div/div[1]/input";
        public static final String DEPARTMENT_LIST_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[2]/div/div[2]/div/div[1]/div[2]/form/div[2]/descendant::node()[@class='el-tree-node__content']";
        public static final String POSITION_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[2]/div/div[2]/div/div[1]/div[4]/form/div/div/div/div[1]/input";
        public static final String POSITION_LIST_XPATH="xpath=>html/body/*/div/div[1]/ul/li";
        public static final String POSITION_SELECT_XPATH="xpath=>html/body/*/div/div[1]/ul/li[%s]";
        public static final String ROLE_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[2]/div/div[2]/div/div[1]/div[3]/form/div[1]/div/div/div[2]/input";
        public static final String ROLE_LIST_XPATH="xpath=>html/body/*[@class='el-select-dropdown is-multiple']/div/div[1]/ul/li";
        public static final String ROLE_SELECT_XPATH="xpath=>html/body/*[@class='el-select-dropdown is-multiple']/div/div[1]/ul/li[%s]";
        public static final String SAVE_BTN_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[2]/div/div[2]/div/div[2]/button[1]";
        public static final String NOINPUT_USERNAME="xpath=>//*[@id='app']/div/div[4]/div[2]/div[2]/div/div[2]/div/div[1]/div[1]/form/div[1]/div/div[2]";

        public static final String NOINPUT_NAM="xpath=>//*[@id='app']/div/div[4]/div[2]/div[2]/div/div[2]/div/div[1]/div[1]/form/div[2]/div/div[2]";
        public static final String NOINPUT_PWD="xpath=>//*[@id='app']/div/div[4]/div[2]/div[2]/div/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]";
        public static final String NOSELECT_DEPARTMENT="xpath=>//*[@id='app']/div/div[4]/div[2]/div[2]/div/div[2]/div/div[1]/div[2]/form/div[2]/div/div[2]";
        public static final String SEARCH_USEEERNAME_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div[1]/div/div[2]/form/div[2]/div/div/input";
        public static final String SEARCH_NAME_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div[1]/div/div[2]/form/div[1]/div/div/input";
        public static final String SEARCH_BTN_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div[1]/div/div[2]/form/div[4]/div/button";
        public static final String TABLE_TR_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div[2]/div/div[2]/div/div[1]/div/div[3]/table/tbody/tr";
        public static final String TABLE_SELECT_UPDATA_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div/div[2]/div/div[2]/div/div[1]/div/div[3]/table/tbody/tr[%s]/td[6]/div/button[3]";
        public static final String TABLE_RESULT_SELECT_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div[2]/div/div[2]/div/div[1]/div/div[3]/table/tbody/tr[1]/td[%s]";
        public static final String TABLE_SELECT_NAME_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div[2]/div/div[2]/div/div[1]/div/div[3]/table/tbody/tr[%s]/td[1]";
        public static final String TABLE_SELECT_USERNAME_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div[2]/div/div[2]/div/div[1]/div/div[3]/table/tbody/tr[%s]/td[5]";
        public static final String TABLE_SELECT_POSITION_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div[2]/div/div[2]/div/div[1]/div/div[3]/table/tbody/tr[%s]/td[3]";
        public static final String DELETE_GROUPS_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[2]/div/div[2]/div/div[1]/div[3]/form/div[1]/div/div/div[1]/span/span[1]/i";
        public static final String GROUP_SPAN_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[2]/div/div[2]/div/div[1]/div[3]/form/div[1]/div/div/div[1]/span/span[1]";
        public static final String GROUPS_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[2]/div/div[2]/div/div[1]/div[3]/form/div[1]/div/div/div[1]/span/span";
        public static final String TABLE_SELECT_DELETE_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div/div[2]/div/div[2]/div/div[1]/div/div[3]/table/tbody/tr[%s]/td[6]/div/button[4]";
        public static final String COMIT_DELETE_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[3]/div/div[3]/div/button[1]";
        public static final String NODATA_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div[2]/div/div[2]/div/div[1]/div/div[3]/div/span";
        public static final String SEARCH_POSITION_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div[1]/div/div[2]/form/div[3]/div/div/input";
        public static final String PAGE_COUNT_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div[2]/div/div[2]/div/div[2]/div/span[2]/div/div[1]/input";
        public static final String PAGE_LIST_XPATH="xpath=>html/body/*/div/div[1]/ul/li";
        public static final String SELECT_PAGE_COUNT="xpath=>html/body/*/div/div[1]/ul/li[%s]";
        public static final String PAGE_TOTAL_COUNT="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div[2]/div/div[2]/div/div[2]/div/span[1]";
        public static final String RESULT_DATA_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div[2]/div/div[2]/div/div[1]/div/div[3]/table/tbody/tr[1]/td[%s]/div";




    }
    public PersonPage(BrowserEmulator driver){
        this.driver=driver;
        loginPage=new LoginPage(driver);
    }
    public String gotoPerson(String type) throws InterruptedException {
        driver.click(getElement.BASESETING_XPATH);
        driver.click(getElement.ORG_XPATH);
        Thread.sleep(3000);
        driver.click(getElement.PERSON_XPATH);
        List rows=driver.getElements(getElement.TABLE_TR_XPATH);
        String selectName="";
        if (type.equals("新建")){
            driver.click(getElement.CREATE_PERSON_XPATH);
        }else if (type.equals("编辑")){
            driver.click(String.format("xpath=>//*[@id='app']/div/div[4]/div[2]/div/div[2]/div/div[2]/div/div[2]/div/ul/li[%d]",driver.getElements("xpath=>//*[@id='app']/div/div[4]/div[2]/div/div[2]/div/div[2]/div/div[2]/div/ul/li").size()));
            Thread.sleep(3000);
            rows=driver.getElements(getElement.TABLE_TR_XPATH);
            driver.click(String.format(getElement.TABLE_SELECT_UPDATA_XPATH,rows.size()));

        }
        else if (type.equals("删除")){
            for (int i=0;i<rows.size();i++){
                if (driver.getText(String.format(getElement.TABLE_SELECT_NAME_XPATH,i+1)).contains("name")){
                    selectName=driver.getText(String.format(getElement.TABLE_SELECT_NAME_XPATH,i+1));
                    driver.click(String.format(getElement.TABLE_SELECT_DELETE_XPATH,i+1));
                    driver.click(getElement.COMIT_DELETE_XPATH);
                    break;
                }
            }
        }
        return selectName;
    }
    public void create(String userName,String name,String pwd,String department,boolean isCreate,boolean isUpdata) throws InterruptedException {
        String newUserName="";
        String newName="";
        if (userName.length()!=0){
            newUserName=String.format("%s%s",userName,loginPage.getCurrentData());
        }
        if (name.length()!=0){
            newName=String.format("%s%s",name,loginPage.getCurrentData());
        }
        driver.type(getElement.USERNAME_XPATH,newUserName);
        driver.type(getElement.NAME_XPATH,newName);
        driver.type(getElement.PWD_XPATH,pwd);
        String selectPosition="";
        String selectRole="";
        if (isCreate){
//            driver.click(getElement.POSITION_XPATH);
//            Thread.sleep(3000);
            selectPosition=loginPage.selectListData(getElement.POSITION_XPATH,getElement.POSITION_LIST_XPATH,getElement.POSITION_SELECT_XPATH);
//            String[] Str2Array = selectPosition.split("(");//结果Str2Array：[, a, a, |, c, c, |, d, d]
//            System.out.println(Str2Array[0]);
//                    selectFromName("",getElement.POSITION_LIST_XPATH,true);
            Thread.sleep(3000);
            if (isUpdata&&loginPage.isElementPresent(driver, getElement.GROUP_SPAN_XPATH)){
                List groups=driver.getElements(getElement.GROUPS_XPATH);
                for (int i=1;i<=groups.size();i++){
                    Thread.sleep(2000);
                    driver.click(getElement.DELETE_GROUPS_XPATH);
                }
            }
           selectRole= loginPage.selectListData(getElement.ROLE_XPATH,getElement.ROLE_LIST_XPATH,getElement.ROLE_SELECT_XPATH);
        }
        String selectDepartment="";
        if (department.length()!=0){
            driver.click(getElement.DEPARTMENT_XPATH);
            Thread.sleep(3000);
            selectDepartment=loginPage.selectFromClass("",getElement.DEPARTMENT_LIST_XPATH,true);
        }
        reslut=new String[]{newName,selectDepartment,selectPosition,selectRole,newUserName};
        driver.click(getElement.SAVE_BTN_XPATH);
        if (isCreate){
            compareResult(reslut,isUpdata);
        }
        System.out.println(reslut[0]);
    }
    public void delete() throws InterruptedException {
        String selectName=gotoPerson("删除");
       driver.type(getElement.SEARCH_NAME_XPATH,selectName);
       driver.click(getElement.SEARCH_BTN_XPATH);
       Thread.sleep(3000);
       if (loginPage.isElementPresent(driver,getElement.NODATA_XPATH)){
           Assertion.verifyEquals(driver.getText(getElement.NODATA_XPATH),"暂无数据");
       }else {
           Assertion.isTrue(false);
           System.out.println("删除失败！");
           Reporter.log("删除失败");
       }
    }
    public void compareResult(String[] reslut,boolean isUpdata) throws InterruptedException {
        driver.type(getElement.SEARCH_NAME_XPATH,reslut[0]);
        driver.click(getElement.SEARCH_BTN_XPATH);
        Thread.sleep(3000);
        for (int i=0;i<reslut.length;i++){
            if (i==2){
                continue;
            }
            Assertion.verifyEquals(driver.getText(String.format(getElement.TABLE_RESULT_SELECT_XPATH,i+1)),reslut[i]);
        }
    }
    //对于下拉选择框部分数据可以选择，部分数据不可选的随机选择数据的方法
    public String selectFromName(String Name,String xpath,boolean isCreate) throws InterruptedException {
        String text1="";
        List rows = driver.getElements("xpath=>html/body/*");
        System.out.println(rows.size());
        for (int k=0;k<=rows.size();k++) {
            List<WebElement> search_result = driver.getElements(String.format(xpath,k+4));
            int i=1;

            int j= Integer.parseInt(loginPage.getRandom(search_result.size(),1));
            if (driver.getElement(String.format("xpath=>html/body/div[%d]", k + 4)).isDisplayed()) {
                for (WebElement result:search_result) {
                    if (i==j&&isCreate){
                     text1=result.getAttribute("innerText");
                        driver.js(String.format("document.querySelectorAll('div.el-select-dropdown[x-placement=\"bottom-start\"]>div>div>ul>li.el-select-dropdown__item[class=\"el-select-dropdown__item\"]')[%d].click();",i-1));
                        System.out.println(i);
                        System.out.println(text1);
                        break;
                    } else if (text1.equals(Name)&&!isCreate){
                        driver.js(String.format("document.querySelectorAll('div.el-select-dropdown[x-placement=\"bottom-start\"]>div>div>ul>li.el-select-dropdown__item[class=\"el-select-dropdown__item\"]')[%d].click();",i-1));
                        break;
                    }
                    i++;
                }
                break;
            }
        }
        return text1;
    }
public void query(String selectXpath,String searchXpath,String td) throws InterruptedException {
    gotoPerson("");
    List rows=driver.getElements(getElement.TABLE_TR_XPATH);
    String selectName=driver.getText(String.format(selectXpath,loginPage.getRandom(rows.size(),1)));
    while (selectName.length()==0){
        selectName=driver.getText(String.format(selectXpath,loginPage.getRandom(rows.size(),1)));
    }
    driver.type(searchXpath,selectName);
    driver.click(getElement.SEARCH_BTN_XPATH);
    Thread.sleep(3000);
    Assert.assertEquals(driver.getText(String.format(getElement.RESULT_DATA_XPATH,td)),selectName);
    driver.refresh();
}
public void queryData() throws InterruptedException {
    query(getElement.TABLE_SELECT_NAME_XPATH,getElement.SEARCH_NAME_XPATH,"1");
    query(getElement.TABLE_SELECT_USERNAME_XPATH,getElement.SEARCH_USEEERNAME_XPATH,"5");
    query(getElement.TABLE_SELECT_POSITION_XPATH,getElement.SEARCH_POSITION_XPATH,"3");
    Thread.sleep(3000);
    gotoPerson("");
    String selectPageCout=loginPage.selectListData(getElement.PAGE_COUNT_XPATH, getElement.PAGE_LIST_XPATH, getElement.SELECT_PAGE_COUNT);
    Thread.sleep(3000);
    boolean isTrue=false;
    List trs=driver.getElements(getElement.TABLE_TR_XPATH);
    if (selectPageCout.contains("10")&&trs.size()>=0&&trs.size()<=10){
        isTrue=true;
    }else if (selectPageCout.contains("20")&&trs.size()>=0&&trs.size()<=20){
        isTrue=true;
    }else if (selectPageCout.contains("30")&&trs.size()>=0&&trs.size()<=30){
        isTrue=true;
    }
    Assertion.isTrue(isTrue);
}
}
