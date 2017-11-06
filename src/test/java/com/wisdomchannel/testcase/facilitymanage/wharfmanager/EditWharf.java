package com.wisdomchannel.testcase.facilitymanage.wharfmanager;



import com.wisdomchannel.page.ChannelmanagerPage;
import com.wisdomchannel.page.LoginPage;
import com.wisdomchannel.page.WharfPage;
import com.wisdomchannel.util.DriverBase;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.util.List;


public class EditWharf extends DriverBase {
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
    public void editWharf() throws InterruptedException {
        Reporter.log("用例标题：设施管理-码头管理，编辑码头");
        wfpg.wharfmanege();
        wfpg.wharflist();
        List rows= driver.getElements(WharfPage.getElement.WHARFLIST);
        driver.click(String.format(WharfPage.getElement.WHARFLINE,rows.size()));
        Thread.sleep(2000);
        wharfname=wfpg.newWharf("编辑码头","古美路111号aaa","很好aaa",lgPage.getRandom(100,0),lgPage.getRandom(100,0),
                lgPage.getRandom(100,0),lgPage.getRandom(100,0),"张三aaa","hwxx1",
                "描述aaa","李四aaa",
                lgPage.getRandom(100,0),lgPage.getRandom(100,0));
        Assert.assertEquals(driver.getText("class=>el-message__group"),"更新码头信息成功");
        Thread.sleep(2000);
        cmPage.channelManagement();
        wfpg.wharfmanege();
        wfpg.wharflist();
        wfpg.checklast( wharfname);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
