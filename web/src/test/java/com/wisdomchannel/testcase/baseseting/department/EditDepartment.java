package com.wisdomchannel.testcase.baseseting.department;


import com.wisdomchannel.page.BasicSettingPage;
import com.wisdomchannel.page.LoginPage;
import com.wisdomchannel.page.ChannelmanagerPage;
import com.wisdomchannel.page.WharfPage;
import com.wisdomchannel.util.DriverBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.util.List;


public class EditDepartment extends DriverBase {
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
    public void editDepartment() throws InterruptedException {
        Reporter.log("用例标题：基础设置-组织-部门，编辑部门");
        bspg.todepartment();
        bspg.editdepartment("部门",lgPage.getRandom(100,1),"崔晔","备注1");
    }




    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
