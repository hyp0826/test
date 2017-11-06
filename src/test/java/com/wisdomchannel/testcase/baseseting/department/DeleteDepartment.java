package com.wisdomchannel.testcase.baseseting.department;


import com.wisdomchannel.page.BasicSettingPage;
import com.wisdomchannel.page.LoginPage;
import com.wisdomchannel.page.ChannelmanagerPage;
import com.wisdomchannel.page.WharfPage;
import com.wisdomchannel.util.DriverBase;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;


public class DeleteDepartment extends DriverBase {
    private ChannelmanagerPage cmpg;
    private LoginPage lgPage;
    private WharfPage wfpg;
    private BasicSettingPage bspg;

    @BeforeClass
    public void setUp() {
        driverBase();
        lgPage = new LoginPage(driver);
        cmpg = new ChannelmanagerPage(driver);
        wfpg = new WharfPage(driver);
        bspg=new BasicSettingPage(driver);
        lgPage.login("admin", "admin");
//        Assert.assertEquals(lgPage.user(), "admin");
    }

    @Test
    public void deleteDepartment() throws InterruptedException {
        Reporter.log("用例标题：基础设置-组织-部门，删除部门");
        bspg.todepartment();
        bspg.deletedepartment();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
