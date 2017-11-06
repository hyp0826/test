package com.wisdomchannel.testcase.baseseting.position;

import com.wisdomchannel.page.LoginPage;
import com.wisdomchannel.page.PositionPage;
import com.wisdomchannel.util.DriverBase;
import org.testng.Reporter;
import org.testng.annotations.*;

/**
 * Created by xhm on 2017/6/30.
 */
public class UpdataPosition extends DriverBase {
    private static LoginPage loginPage;
    private static PositionPage positionPage;
    @BeforeClass
    public void setUp() throws Exception {
        driverBase();
        loginPage=new LoginPage(driver);
        positionPage=new PositionPage(driver);
        loginPage.login("admin","admin");
        positionPage.gotoPosition("编辑");
    }

    @Test
    public void updataPosition() throws Exception {
        Reporter.log("用例标题：基础设置-组织-岗位，编辑岗位");
        positionPage.create("岗位",loginPage.getRandom(100,1),loginPage.getRandom(10,1),"123","部门",true);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
