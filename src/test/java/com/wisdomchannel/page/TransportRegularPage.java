package com.wisdomchannel.page;
import com.wisdomchannel.util.Assertion;
import com.wisdomchannel.util.BrowserEmulator;
import org.testng.Assert;

import java.util.List;
/**
 * Created by xhm on 2017/8/14.
 */
public class TransportRegularPage {
    private BrowserEmulator driver;
    private LoginPage loginPage;
    public static class getElement{
        public static final String TRANSPORT_XPATH="xpath=>//*[@id='app']/div/div[3]/div/label[4]/span";
        public static final String ENTRYNOTICE_XPATH="xpath=>//*[@id='app']/div/div[4]/div[1]/ul/li[2]";
        public static final String SEARCH_BTN_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div[2]/button";
        public static final String DATALIST_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[2]/div/div/div";
        public static final String SELECTDATA_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[2]/div/div[%s]/div/div/div/div[2]/span[4]";
        public static final String SEARCH_INPUT_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div[2]/span[2]/div/input";
        public static final String SEARCH_INPUT2_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div[2]/span[3]/div/input";
        public static final String PAGE_COUNT_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[3]/div/span[2]/div/div[1]/input";
        public static final String PAGE_NUMLIST_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[3]/div/ul/li";
        public static final String PAGE_SELECTNUM_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[3]/div/ul/li[%s]";
        public static final String PAGE_SELECT_XPAHT="xpath=>html/body/*/div/div[1]/ul/li[%s]";
        public static final String PAGE_LIST_XPAHT="xpath=>html/body/*/div/div[1]/ul/li";
        public static final String TRANSIT_BTN_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[1]/div[1]/div/label[2]/span";
        public static final String DATANUM_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div[3]/div/span[1]";
        //电子申报查询
        public static final String EFILING_XPATH="xpath=>//*[@id='app']/div/div[4]/div[1]/ul/li[1]";
        public static final String SEARCH_NAME_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div/div[1]/div/div/form/div[1]/div/div/input";
        public static final String SEATCH_TYPE_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div/div[1]/div/div/form/div[2]/div/div/div[1]/input";
        public static final String TYPE_LIST_XPATH="xpath=>html/body/*/div/div[1]/ul/li";
        public static final String TYPE_SELECT_XPATH="xpath=>html/body/*/div/div[1]/ul/li[%s]";
        public static final String SEARCH_DATE_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div/div[1]/div/div/form/div[3]/div/div[1]/input";
        public static final String SEARCH_ENDDATE_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div/div[1]/div/div/form/div[3]/div/div[2]/input";
        public static final String SEARCH_BTN2_XPATH="xpath=>//*[@id=\"app\"]/div/div[4]/div[2]/div/div[1]/div/div/form/div[4]/div/button";


        public static final String ALLDATA_LIST_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div/div[2]/div/div[3]/table/tbody/tr";
        public static final String SELECT_DATA_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div/div[2]/div/div[3]/table/tbody/tr[%s]/td[%d]";
        public static final String DATA_INFO_XPATH="xpath=>//*[@id='app']/div/div[4]/div[2]/div/div[4]/div[1]/div/div[2]/div/div[1]/div/div[1]/div/div[%s]";
    }
    public TransportRegularPage(BrowserEmulator driver){
        this.driver=driver;
        loginPage=new LoginPage(driver);
    }
    //入境通知查询
    public void searchData(boolean isEnter)throws Exception{
        driver.click(getElement.TRANSPORT_XPATH);
        driver.click(getElement.ENTRYNOTICE_XPATH);
        driver.clear(getElement.SEARCH_INPUT_XPATH);
        driver.clear(getElement.SEARCH_INPUT2_XPATH);
        driver.click(getElement. SEARCH_BTN_XPATH);
        if (!isEnter){
            driver.click(getElement.TRANSIT_BTN_XPATH);
            Thread.sleep(3000);
            driver.click(getElement.SEARCH_BTN_XPATH);
        }
        Thread.sleep(3000);
        List rows=driver.getElements(getElement.DATALIST_XPATH);
        String selectXpath=String.format(getElement.SELECTDATA_XPATH,loginPage.getRandom(rows.size(),1));
        String searchStr=driver.getText(selectXpath);
        driver.type(getElement.SEARCH_INPUT_XPATH,searchStr);
        driver.click(getElement.SEARCH_BTN_XPATH);
        Thread.sleep(3000);
        rows=driver.getElements(getElement.DATALIST_XPATH);
        boolean isFind=false;
        for (int i=1;i<=rows.size();i++){
            String resultStr=driver.getText(String.format(getElement.SELECTDATA_XPATH,i));
            if (resultStr.equals(searchStr)){
                isFind=true;
                break;
            }
        }
        System.out.println("断言验证入境开始时间搜索结果");
        Assertion.isTrue(isFind);
        Assert.assertTrue(isFind);
        driver.clear(getElement.SEARCH_INPUT_XPATH);
        driver.click(getElement.SEARCH_BTN_XPATH);
        //选择一页展示多少数据
        driver.click(getElement.PAGE_COUNT_XPATH);
        Thread.sleep(3000);
        List pageList=driver.getElements(getElement.PAGE_LIST_XPAHT);
        String pageXpath=String.format(getElement.PAGE_SELECT_XPAHT,loginPage.getRandom(pageList.size(),1));
        String pageNumStr=driver.getText(pageXpath);
        driver.click(pageXpath);
        Thread.sleep(3000);
        String dataNum=driver.getText(getElement.DATANUM_XPATH);
        Integer count=loginPage.getInt(dataNum);
        if (pageNumStr.contains("10")&&count>=0&&count<=10){
            Assertion.verifyEquals(driver.getElements(getElement.DATALIST_XPATH).size(),10);
        }else if (pageNumStr.contains("20")&&count>=0&&count<=20){
            Assertion.verifyEquals(driver.getElements(getElement.DATALIST_XPATH).size(),20);
        }else if (pageNumStr.contains("30")&&count>=0&&count<=30){
            Assertion.verifyEquals(driver.getElements(getElement.DATALIST_XPATH).size(),30);
        }
        //点击一个页面
        driver.click(getElement.PAGE_COUNT_XPATH);
        Thread.sleep(2000);
        driver.click(String.format(getElement.PAGE_SELECT_XPAHT,1));
        List numList=driver.getElements(getElement.PAGE_NUMLIST_XPATH);
        driver.click(String.format(getElement.PAGE_SELECTNUM_XPATH,loginPage.getRandom(numList.size(),1)));
        Thread.sleep(3000);
        driver.refresh();
    }
    //电子申报查询
    public void queryFiling() throws InterruptedException {
        driver.click(getElement.TRANSPORT_XPATH);
        driver.click(getElement.EFILING_XPATH);
        //搜索名称
        List dataList=driver.getElements(getElement.ALLDATA_LIST_XPATH);
        String searchName=driver.getText(String.format(getElement.SELECT_DATA_XPATH,loginPage.getRandom(dataList.size(),1),3));
        driver.type(getElement.SEARCH_NAME_XPATH,searchName);
        driver.click(getElement.SEARCH_BTN2_XPATH);
        Thread.sleep(3000);
        String resultName=driver.getText(String.format(getElement.SELECT_DATA_XPATH,1,3));
        Assertion.verifyEquals(resultName,searchName);
        driver.refresh();
        driver.click(getElement.TRANSPORT_XPATH);
        driver.click(getElement.EFILING_XPATH);
        //搜索类型
        driver.click(getElement.SEATCH_TYPE_XPATH);
        Thread.sleep(3000);
        List typeList=driver.getElements(getElement.TYPE_LIST_XPATH);
        String selectTypeXpath=String.format(getElement.TYPE_SELECT_XPATH,loginPage.getRandom(typeList.size(),1));
        String selectType=driver.getText(selectTypeXpath);
        driver.click(selectTypeXpath);
        Thread.sleep(3000);
        if (selectType.equals("进港")||selectType.equals("出港")){
            dataList=driver.getElements(getElement.ALLDATA_LIST_XPATH);
            for (int i=1;i<=dataList.size();i++){
                Assertion.verifyEquals(driver.getText(String.format(getElement.SELECT_DATA_XPATH,i,5)),selectType);
            }
        }
        driver.click(getElement.SEATCH_TYPE_XPATH);
        Thread.sleep(3000);
        driver.click(String.format(getElement.TYPE_SELECT_XPATH,1));

        dataList=driver.getElements(getElement.ALLDATA_LIST_XPATH);
        String searchTime=driver.getText(String.format(getElement.SELECT_DATA_XPATH,loginPage.getRandom(dataList.size(),1),8));
        driver.type(getElement.SEARCH_DATE_XPATH,searchTime);
        driver.click(getElement.SEARCH_BTN2_XPATH);
        Thread.sleep(3000);
        dataList=driver.getElements(getElement.ALLDATA_LIST_XPATH);

        for (int i=1;i<=dataList.size();i++){
            boolean isTrue=false;
            String reslutTime=driver.getText(String.format(getElement.SELECT_DATA_XPATH,i,8));
            int result=loginPage.StrToDate(reslutTime).compareTo(loginPage.StrToDate(searchTime));
            if (result==0||result==1){
                isTrue=true;
            }
            Assertion.isTrue(isTrue);
            Assert.assertTrue(isTrue);
//            System.out.println("断言验证电子申报开始时间搜索结果");
        }
        driver.type(getElement.SEARCH_DATE_XPATH,"");
        driver.clear(getElement.SEARCH_DATE_XPATH);
        driver.click(getElement.SEARCH_BTN2_XPATH);
        dataList=driver.getElements(getElement.ALLDATA_LIST_XPATH);
        String searchTime1=driver.getText(String.format(getElement.SELECT_DATA_XPATH,loginPage.getRandom(dataList.size(),1),8));
        driver.type(getElement.SEARCH_ENDDATE_XPATH,searchTime1);
        driver.click(getElement.SEARCH_BTN2_XPATH);
        Thread.sleep(3000);
        if (loginPage.isElementPresent(driver,getElement.ALLDATA_LIST_XPATH)){
            dataList=driver.getElements(getElement.ALLDATA_LIST_XPATH);
            for (int i=1;i<=dataList.size();i++){
                boolean isTrue=false;
                String reslutTime=driver.getText(String.format(getElement.SELECT_DATA_XPATH,i,8));
                int result=loginPage.StrToDate(reslutTime).compareTo(loginPage.StrToDate(searchTime1));
                if (result==0||result==-1){
                    isTrue=true;
                }
                Assertion.isTrue(isTrue);
                Assert.assertTrue(isTrue);
//                System.out.println("断言验证电子申报截止时间搜索结果");
            }
        }
        driver.refresh();
        driver.click(getElement.TRANSPORT_XPATH);
        driver.click(getElement.EFILING_XPATH);
        dataList=driver.getElements(getElement.ALLDATA_LIST_XPATH);
        driver.click(String.format(getElement.SELECT_DATA_XPATH,loginPage.getRandom(dataList.size(),1),2));
        driver.click(String.format(getElement.DATA_INFO_XPATH,3));
        driver.click(String.format(getElement.DATA_INFO_XPATH,4));
        driver.click(String.format(getElement.DATA_INFO_XPATH,5));
    }
}
