package com.wisdomchannel.testcase.facilitymanage.wharfmanager;



import com.wisdomchannel.page.ChannelmanagerPage;
import com.wisdomchannel.page.LoginPage;
import com.wisdomchannel.page.WharfPage;
import com.wisdomchannel.util.DriverBase;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;


public class NewWharf extends DriverBase {
    private ChannelmanagerPage cmPage;
    private String wharfname;
    private LoginPage lgPage;
    private WharfPage wfpg;

    @BeforeClass
    public void setUp() {
        driverBase();
        lgPage = new LoginPage(driver);
        cmPage=new ChannelmanagerPage(driver);
        wfpg=new WharfPage(driver);
        lgPage.login("admin","admin");
//        Assert.assertEquals(lgPage.user(),"admin");
    }
    @Test
    public void newWharf() throws InterruptedException {
        Reporter.log("用例标题：设施管理-码头管理，新增码头");
        wfpg.wharfmanege();
        wfpg.toaddwharf();
        wharfname=wfpg.newWharf("码头","古美路111号","很好",lgPage.getRandom(100,0),lgPage.getRandom(100,0),
                lgPage.getRandom(100,0),lgPage.getRandom(100,0),"张三","hwxx",
                "ms","lisi",
                lgPage.getRandom(100,0),lgPage.getRandom(100,0));
        Assert.assertEquals(driver.getText("class=>el-message__group"),"添加码头成功");
        Thread.sleep(2000);
        wfpg.wharflist();
        wfpg.checklast( wharfname);
        Reporter.log("新建码头 "+wharfname+" 成功");
        System.out.println("新建码头 "+wharfname+" 成功");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
