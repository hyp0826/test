package com.wisdomchannel.page;
import com.wisdomchannel.util.Assertion;
import com.wisdomchannel.util.BrowserEmulator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import java.util.List;
import java.util.Random;

/**
 * Created by xhm on 2017/9/6.
 */
public class PositionPage {
    private BrowserEmulator driver;
    private LoginPage loginPage;
    private String[] reslut;
    public static class getElement{
        public static final String BASESETING_XPATH="xpath=>//*[@id='app']/div/div[3]/div/label[8]/span";
        public static final String ORG_XPATH="xpath=>//*[@id='app']/div/div[4]/div[1]/ul/li[2]/div";
        public static final String POSITION_XPATH="xpath=>//*[@id='app']/div/div[4]/div[1]/ul/li[2]/ul/li[3]";
        public static final String NEWPOSITION_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div/div[1]/div/div[2]/form/div[4]/div/button";
        public static final String POSITION_NAME_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[2]/div/div[2]/form/div[1]/div[1]/div/div/div[1]/input";
        public static final String POSITION_NUM_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[2]/div/div[2]/form/div[1]/div[2]/div/div/div/input";
        public static final String POSITION_LEVEL_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[2]/div/div[2]/form/div[2]/div[1]/div/div/div[1]/input";
        public static final String POSITION_TYPE_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[2]/div/div[2]/form/div[2]/div[2]/div/div/div[1]/div[1]/input";
        public static final String POSITION_TYPE_LIST="xpath=>html/body/*/div/div[1]/ul/li";
        public static final String CREATE_POSITION_TYPE_LIST="xpath=>html/body/*/div/div[1]/ul/li";
        public static final String POSITION_SELECT_TYPE="xpath=>html/body/*/div/div[1]/ul/li[%s]";
        public static final String POSITION_DEPARTMENT_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[2]/div/div[2]/form/div[3]/div[1]/div/div/div/div[1]/input";
        public static final String POSITION_DEPARTMENT_LIST_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[2]/div/div[2]/form/div[3]/descendant::node()[@class='el-tree-node__content']";
        public static final String SAVE_BTN_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[2]/div/div[3]/div/button[1]";
        public static final String ALTER_TEXT_XPATH="xpath=>html/body/div[5]/div";
        public static final String NOTINPUT_NAME="xpath=>//*[@id='app']/div/div[4]/div[2]/div[2]/div/div[2]/form/div[1]/div[1]/div/div/div[2]";
        public static final String NOTINPUT_LEVEL="xpath=>//*[@id='app']/div/div[4]/div[2]/div[2]/div/div[2]/form/div[2]/div[1]/div/div/div[2]";
        public static final String NOTINPUT_TYPE="xpath=>//*[@id='app']/div/div[4]/div[2]/div[2]/div/div[2]/form/div[2]/div[2]/div/div/div[2]";
        public static final String NOTSELECT_DEPARTMENT="xpath=>//*[@id='app']/div/div[4]/div[2]/div[2]/div/div[2]/form/div[3]/div[1]/div/div/div[2]";
        public static final String SEARCH_NAME_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div/div[1]/div/div[2]/form/div[1]/div/div/input";
        public static final String SEARCH_BTN_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div/div[1]/div/div[2]/form/div[3]/div/button/span";
        //*[@id="app"]/div/div[4]/div[2]/div[1]/div/div[1]/div/div[2]/form/div[3]/div/button/span
        public static final String RESULT_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div/div[2]/div[1]/div/div[3]/table/tbody/tr/td[%s]/div";
        public static final String TABLE_LIST_XPATH="xpath=>.//*[@id='app']/div/div[4]/div[2]/div[1]/div/div[2]/div[1]/div/div[3]/table/tbody/tr";
        public static final String SELECT_UPDATA_BTN="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div/div[2]/div[1]/div/div[3]/table/tbody/tr[%s]/td[6]/div/button[1]";
        public static final String SELECT_DELETE_BTN="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div/div[2]/div[1]/div/div[3]/table/tbody/tr[%s]/td[6]/div/button[2]";
        public static final String SELECT_NAME_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div/div[2]/div[1]/div/div[3]/table/tbody/tr[%s]/td[2]/div";
        public static final String NODATA_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div/div[2]/div[1]/div/div[3]/div/span";
        public static final String DELETE_COMIT_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[3]/div/div[3]/div/button[1]";
        public static final String DELETE_ALTER_XPATH="xpath=>html/body/*/div/p";
        public static final String DELETE_CANCEL_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[2]/div/div[3]/div/button[2]";
        public static final String DELETE_CLOSE_XPATH="xpath=>html/body/*/div/div[3]/div/button[2]";

        public static final String SEARCH_POSITION_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div/div[1]/div/div[2]/form/div[2]/div/div/div[1]/input";
        public static final String SEARCH_POSITION_LIST_XPATH="xpath=>html/body/*/div/div[1]/ul/li";
        public static final String SEARCH_POSITION_SELECT_XPATH="xpath=>html/body/*/div/div[1]/ul/li[%s]";
        public static final String SEARCH_RESULT_NAME_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div/div[2]/div[1]/div/div[3]/table/tbody/tr/td[3]";
        public static final String PAGE_COUNT_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div/div[2]/div[2]/div/span[2]/div/div[1]/input";
        public static final String PAGE_LIST_XPATH="xpath=>html/body/*/div/div[1]/ul/li";
        public static final String SELECT_PAGE_COUNT="xpath=>html/body/*/div/div[1]/ul/li[%s]";
        public static final String PAGE_TOTAL_COUNT="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div/div[2]/div[2]/div/span[1]";

    }
    public PositionPage(BrowserEmulator driver){
        this.driver=driver;
        loginPage=new LoginPage(driver);
    }
    public void gotoPosition(String type) throws InterruptedException {
        driver.click(getElement.BASESETING_XPATH);
        driver.click(getElement.ORG_XPATH);
        Thread.sleep(3000);
        driver.click(getElement.POSITION_XPATH);
        List rows=driver.getElements(getElement.TABLE_LIST_XPATH);
        if (type.equals("新建")){
            driver.click(getElement.NEWPOSITION_XPATH);
        }else if(type.equals("编辑")) {
            driver.click(String.format(getElement.SELECT_UPDATA_BTN,loginPage.getRandom(rows.size(),1)));
        }
    }

    public void create(String positionName,String positionNum,String positionLevel,String positionType,String positionDepartment,boolean isCreate) throws InterruptedException {
        String name=String.format("%s%s",positionName,loginPage.getCurrentData());
        if (positionName.length()!=0){
            driver.clear(getElement.POSITION_NAME_XPATH);
            driver.type(getElement.POSITION_NAME_XPATH,name);
        }
        driver.type(getElement.POSITION_NUM_XPATH,positionNum);
        driver.type(getElement.POSITION_LEVEL_XPATH,positionLevel);
        String selectData="";
        String department="";
        if (positionType.length()>0){
            if (isCreate){
                selectData=loginPage.selectListData(getElement.POSITION_TYPE_XPATH,getElement.POSITION_TYPE_LIST,getElement.POSITION_SELECT_TYPE);
                Thread.sleep(3000);
                if (selectData.equals("部门岗位")){
                    driver.click(getElement.POSITION_DEPARTMENT_XPATH);
                    department= selectFromName("",getElement.POSITION_DEPARTMENT_LIST_XPATH,isCreate);
                }
            }else {
                driver.click(getElement.POSITION_TYPE_XPATH);
                Thread.sleep(3000);
                selectFromName(positionType,getElement.CREATE_POSITION_TYPE_LIST,isCreate);
            }
        }
        Thread.sleep(2000);
        driver.click(getElement.SAVE_BTN_XPATH);
        if (isCreate){
            reslut=new String[]{name,selectData,department,positionLevel};
            checkResult(reslut);
        }
        Thread.sleep(3000);
    }
    public String selectFromName(String departmentName,String xpath,boolean isCreate){
        List<WebElement> search_result = driver.getElements(xpath);
        int i=0;
        int j= Integer.parseInt(loginPage.getRandom(search_result.size(),0));
        String text1="";
        for (WebElement result:search_result) {
             text1=result.getAttribute("innerText");
            if (i==j&&isCreate){
                result.click();
                break;
            }
            else if (text1.equals(departmentName)&&!isCreate){
                result.click();
                break;
            }
            i++;
        }
        return text1;
    }
    public void checkResult(String[] name) throws InterruptedException {
        driver.type(getElement.SEARCH_NAME_XPATH,name[0]);
        driver.click(getElement.SEARCH_BTN_XPATH);
        Thread.sleep(3000);
        for (int i=0;i<name.length;i++){
            Assertion.verifyEquals(driver.getText(String.format(getElement.RESULT_XPATH,i+2)),name[i]);
        }
    }
    public void delete() throws InterruptedException {
        gotoPosition("删除");
        driver.click(String.format("xpath=>//*[@id='app']/div/div[4]/div[2]/div/div/div[2]/div[2]/div/ul/li[%d]",driver.getElements("xpath=>//*[@id='app']/div/div[4]/div[2]/div/div/div[2]/div[2]/div/ul/li").size()));
        Thread.sleep(3000);
//        List rows=driver.getElements(getElement.TABLE_LIST_XPATH);
//        int i=0;
//        driver.click(getElement.PAGE_COUNT_XPATH);
//        Thread.sleep(3000);
//        driver.click(String.format(getElement.SELECT_PAGE_COUNT,3));

        List rows=driver.getElements(getElement.TABLE_LIST_XPATH);
//        String str=String.format("%s",loginPage.getRandom(rows.size(),1));
        String deleteName=driver.getText(String.format(getElement.SELECT_NAME_XPATH,rows.size()));
//        driver.sendKeys(String.format(getElement.SELECT_DELETE_BTN,rows.size()),Keys.DOWN);
//        Thread.sleep(3000);
        driver.click(String.format(getElement.SELECT_DELETE_BTN,rows.size()));

        driver.click(getElement.DELETE_COMIT_XPATH);
//        driver.click(getElement.DELETE_CLOSE_XPATH);
//        while (driver.getText(getElement.DELETE_ALTER_XPATH).contains("该岗位下存在人员，请先删除人员。")){
//            Thread.sleep(3000);
//            deleteName=selecteDelete();
//            if (driver.getText(getElement.DELETE_ALTER_XPATH).contains("该岗位下存在人员，请先删除人员。")){
//                driver.click(getElement.DELETE_CLOSE_XPATH);
//                System.out.println("1111111");
//            }
//        }
        driver.type(getElement.SEARCH_NAME_XPATH,deleteName);
        driver.click(getElement.SEARCH_BTN_XPATH);
        Assert.assertTrue(loginPage.isElementPresent(driver,getElement.NODATA_XPATH));
    }
//    public String selecteDelete() throws InterruptedException {
//        List rows=driver.getElements(getElement.TABLE_LIST_XPATH);
//        String str=String.format("%s",loginPage.getRandom(rows.size(),1));
//        String deleteName=driver.getText(String.format(getElement.SELECT_NAME_XPATH,str));
//        driver.sendKeys(String.format(getElement.SELECT_DELETE_BTN,str),Keys.DOWN);
//        Thread.sleep(3000);
//        driver.click(String.format(getElement.SELECT_DELETE_BTN,str));
//
//        driver.click(getElement.DELETE_COMIT_XPATH);
//        return deleteName;
//    }
    public void query() throws InterruptedException {
        List rows=driver.getElements(getElement.TABLE_LIST_XPATH);
        String name=driver.getText(String.format(getElement.SELECT_NAME_XPATH,loginPage.getRandom(rows.size(),1)));
        driver.type(getElement.SEARCH_NAME_XPATH,name);
        driver.click(getElement.SEARCH_BTN_XPATH);
        Thread.sleep(3000);
        Assert.assertEquals(driver.getText(String.format(getElement.SELECT_NAME_XPATH,1)),name);

        driver.refresh();
        gotoPosition("搜索");

       String selectType= loginPage.selectListData(getElement.SEARCH_POSITION_XPATH,getElement.SEARCH_POSITION_LIST_XPATH,getElement.SEARCH_POSITION_SELECT_XPATH);
        driver.click(getElement.SEARCH_BTN_XPATH);
        Thread.sleep(3000);
        List<WebElement> search_result = driver.getElements(getElement.SEARCH_RESULT_NAME_XPATH);
//        System.out.println(search_result.size());
        for (WebElement result:search_result) {
            String text1=result.getAttribute("innerText");
            boolean isTrue=false;
            if (text1.contains(selectType)){
                isTrue=true;
            }
            Assertion.isTrue(isTrue);
        }

        driver.refresh();
        gotoPosition("搜索");
        String selectPageCout=loginPage.selectListData(getElement.PAGE_COUNT_XPATH,getElement.PAGE_LIST_XPATH,getElement.SELECT_PAGE_COUNT);
        Thread.sleep(3000);
        boolean isTrue=false;
        String dataNum=driver.getText(getElement.PAGE_TOTAL_COUNT);
        Integer count=loginPage.getInt(dataNum);
        List trs=driver.getElements(getElement.TABLE_LIST_XPATH);
//        System.out.println(String.format("%s,%s,%s",selectPageCout,count,trs.size()));
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
