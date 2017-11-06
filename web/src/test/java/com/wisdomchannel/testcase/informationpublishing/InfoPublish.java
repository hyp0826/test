package com.wisdomchannel.testcase.informationpublishing;


import com.wisdomchannel.page.ChannelmanagerPage;
import com.wisdomchannel.page.InfoTemplatePage;
import com.wisdomchannel.page.LoginPage;
import com.wisdomchannel.util.DriverBase;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;


public class InfoPublish extends DriverBase {
    private LoginPage lgPage;
    private InfoTemplatePage infotempPg;
    private ChannelmanagerPage cmpg;

    @BeforeClass
    public void setUp() {
        driverBase();
        lgPage = new LoginPage(driver);
        infotempPg=new InfoTemplatePage(driver);
        cmpg=new ChannelmanagerPage(driver);
        lgPage.login("admin", "admin");
//        Assert.assertEquals(lgPage.user(), "admin");
    }

    @Test
    public void writemsginput() throws InterruptedException {
        Reporter.log("用例标题：信息发布-信息发布，写信息(输入)");
        driver.click(InfoTemplatePage.getElement.INFODIFFUSION);
        Thread.sleep(2000);
        infotempPg.toxinxifabu();
        infotempPg.towritemsg();
        String numb="13012345678";
        String content=ChannelmanagerPage.datetime()+"a numeral or string of numerals that is used for identification";
        infotempPg.writemsginput(numb,content);
        infotempPg.messagebox("信息发送中");
        Thread.sleep(1000);
        infotempPg.firstnumber(numb);
        infotempPg.firstcontent(content);

    }

    @Test
    public void writemsgtemp() throws InterruptedException {
        Reporter.log("用例标题：信息发布-信息发布，写信息(模板)");
        driver.click(InfoTemplatePage.getElement.INFODIFFUSION);
        Thread.sleep(2000);
        infotempPg.toxinxifabu();
        infotempPg.towritemsg();
        infotempPg.writemsgtemp();
        Thread.sleep(1000);
        infotempPg.messagebox("信息发送中");
        Thread.sleep(1000);

    }

    @Test(dependsOnMethods = "writemsginput")
    public void searchmsg() throws InterruptedException {
        Reporter.log("用例标题：信息发布-信息发布，搜索信息");
        driver.click(InfoTemplatePage.getElement.INFODIFFUSION);
        Thread.sleep(2000);
        infotempPg.toxinxifabu();
        infotempPg.search(cmpg.datetimeformat("yyyy-MM-dd"));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
