package com.wisdomchannel.testcase.facilitymanage.bridgemanager;

import com.wisdomchannel.page.BridgePage;
import com.wisdomchannel.page.LoginPage;
import com.wisdomchannel.util.AssertionListener;
import com.wisdomchannel.util.DriverBase;
import org.testng.Reporter;
import org.testng.annotations.*;

/**
 * Created by xhm on 2017/6/30.
 */
@Listeners({AssertionListener.class})
public class UpdataBridge extends DriverBase {
    private LoginPage loginPage;
    private BridgePage bridgePage;
    @BeforeClass
    public void setUp() throws Exception {
        driverBase();
        loginPage=new LoginPage(driver);
        bridgePage=new BridgePage(driver);
        loginPage.login("admin","admin");
    }

    @Test
    public void updataBridge() throws Exception {
        Reporter.log("设施管理：桥梁管理-编辑桥梁");
        bridgePage.gotoUpdata();
        bridgePage.createBridge("测试桥梁",loginPage.getRandom(100,1),loginPage.getRandom(100,1),loginPage.getRandom(800,100),loginPage.getRandom(800,100),loginPage.getRandom(600,100),loginPage.getRandom(700,100),loginPage.getRandom(200,100),loginPage.getRandom(300,100),loginPage.getRandom(800,100),loginPage.getRandom(200,10),loginPage.randomDate("1960-01-01","1988-12-31"),"管理单位123",false);

    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        driver.quit();
    }
}
