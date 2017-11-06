package com.wisdomchannel.testcase.informationpublishing;


import com.wisdomchannel.page.ChannelmanagerPage;
import com.wisdomchannel.page.InfoTemplatePage;
import com.wisdomchannel.page.LoginPage;
import com.wisdomchannel.util.DriverBase;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;


public class CRUDInfoTemplate extends DriverBase {
    private LoginPage lgPage;
    private String tempname;
    private String str="2017年7月26日至27日，习近平在省部级主要领导干部“学习习近平总书记重要讲话精神，迎接党的十九大”专题研讨班上发表重要讲话";
    private InfoTemplatePage infotempPg;
    private ChannelmanagerPage cmpage;

    @BeforeClass
    public void setUp() {
        driverBase();
        lgPage = new LoginPage(driver);
        infotempPg=new InfoTemplatePage(driver);
        cmpage=new ChannelmanagerPage(driver);
        lgPage.login("admin", "admin");
//        Assert.assertEquals(lgPage.user(), "admin");
    }

    @Test
    public void createInfoTemplate() throws InterruptedException {
        Reporter.log("用例标题：信息发布-信息模板，新增模板");
        infotempPg.toinfotemplate();
        infotempPg.toadd();
        tempname=cmpage.datetime()+str;
        infotempPg.newtemplate(tempname);
        infotempPg.messagebox("新增模板成功");
        Thread.sleep(2000);
        Assert.assertEquals(infotempPg.firsttemptext(),tempname);
    }

    @Test
    public void edittemp() throws InterruptedException {
        Reporter.log("用例标题：信息发布-信息模板，编辑模板");
        infotempPg.toinfotemplate();
        infotempPg.clickfirsttemp();
        tempname=cmpage.datetime()+str;
        infotempPg.newtemplate(tempname);
        Thread.sleep(1000);
        infotempPg.messagebox("编辑模板成功");
        Thread.sleep(2000);
        Assert.assertEquals(infotempPg.firsttemptext(),tempname);

    }

    @Test
    public void deletetemp() throws InterruptedException {
        Reporter.log("用例标题：信息发布-信息模板，删除");
        infotempPg.toinfotemplate();
        String beforestr=infotempPg.firsttemptext();
        infotempPg.clickfirsttemp();
        driver.click(InfoTemplatePage.getElement.DELETEBUTTON);
        Thread.sleep(1000);
        String str=driver.getText(ChannelmanagerPage.getElement.DELETEMASSAGE);
        Assert.assertEquals(str,"你确定要删除这条数据么？删除是不可恢复的");
        driver.click(ChannelmanagerPage.getElement.DELETEENSURE);
        Thread.sleep(2000);
        Assert.assertNotEquals(infotempPg.firsttemptext(),beforestr);
    }



    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
