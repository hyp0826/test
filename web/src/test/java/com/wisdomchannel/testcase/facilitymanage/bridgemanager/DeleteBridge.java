package com.wisdomchannel.testcase.facilitymanage.bridgemanager;
import com.wisdomchannel.page.BridgePage;
import com.wisdomchannel.page.LoginPage;
import com.wisdomchannel.util.DriverBase;
import org.testng.Reporter;
import org.testng.annotations.*;
/**
 * Created by xhm on 2017/6/30.
 */
public class DeleteBridge extends DriverBase {
    private static LoginPage loginPage;
    private static BridgePage bridgePage;
    @BeforeClass
    public void setUp() throws Exception {
        driverBase();
        loginPage=new LoginPage(driver);
        bridgePage=new BridgePage(driver);
        loginPage.login("admin","admin");
    }

    @Test
    public void deleteBridge() throws Exception {
        Reporter.log("设施管理：桥梁管理-删除桥梁");
        bridgePage.delete();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
