package com.wisdomchannel.testcase.facilitymanage.bridgemanager;
import com.wisdomchannel.page.BridgePage;
import com.wisdomchannel.page.LoginPage;
import com.wisdomchannel.util.AssertionListener;
import com.wisdomchannel.util.DriverBase;
import org.testng.Reporter;
import org.testng.annotations.*;

import javax.swing.*;

/**
 * Created by xhm on 2017/6/30.
 */
@Listeners({AssertionListener.class})
public class CreateBridge extends DriverBase {
    private LoginPage loginPage;
    private BridgePage bridgePage;
    @BeforeClass
    public void setUp() throws Exception {
        driverBase();
        loginPage=new LoginPage(driver);
        bridgePage=new BridgePage(driver);
        loginPage.login("admin","admin");
        System.out.println("登录成功");
        Reporter.log("登录成功！");
    }
    @Test
    public void createBridge() throws Exception {
        Reporter.log("设施管理：桥梁管理-新建桥梁");
        bridgePage.gotoCreateFrame();
        bridgePage.createBridge("测试桥梁",loginPage.getRandom(100,1),loginPage.getRandom(100,1),loginPage.getRandom(800,100),loginPage.getRandom(800,100),loginPage.getRandom(600,100),loginPage.getRandom(700,100),loginPage.getRandom(200,100),loginPage.getRandom(300,100),loginPage.getRandom(800,100),loginPage.getRandom(200,10),loginPage.randomDate("1980-01-01","1998-12-31"),"管理单位",true);
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
