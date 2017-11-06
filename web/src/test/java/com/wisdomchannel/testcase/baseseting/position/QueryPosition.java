package com.wisdomchannel.testcase.baseseting.position;

import com.wisdomchannel.page.LoginPage;
import com.wisdomchannel.page.PositionPage;
import com.wisdomchannel.util.AssertionListener;
import com.wisdomchannel.util.DriverBase;
import org.testng.Reporter;
import org.testng.annotations.*;

/**
 * Created by xhm on 2017/6/30.
 */
@Listeners({AssertionListener.class})
public class QueryPosition extends DriverBase {
    private static LoginPage loginPage;
    private static PositionPage positionPage;
    @BeforeClass
    public void setUp() throws Exception {
        driverBase();
        loginPage=new LoginPage(driver);
        positionPage=new PositionPage(driver);
        loginPage.login("admin","admin");
        positionPage.gotoPosition("查询");
    }

    @Test
    public void queryPosition() throws Exception {
        Reporter.log("用例标题：基础设置-组织-岗位，查询岗位");
        positionPage.query();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
