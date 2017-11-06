package com.wisdomchannel.testcase.baseseting.units;
import com.wisdomchannel.page.LoginPage;
import com.wisdomchannel.page.UnitsPage;
import com.wisdomchannel.util.AssertionListener;
import com.wisdomchannel.util.DriverBase;
import org.testng.Reporter;
import org.testng.annotations.*;

/**
 * Created by xhm on 2017/6/30.
 */
@Listeners({AssertionListener.class})
public class QueryUnits extends DriverBase {
    private LoginPage loginPage;
    private UnitsPage unitsPage;
    @BeforeClass
    public void setUp() throws Exception {
        driverBase();
        loginPage=new LoginPage(driver);
        unitsPage=new UnitsPage(driver);
        loginPage.login("admin","admin");
    }

    @Test
    public void queryUnits() throws Exception {
        Reporter.log("用例标题：基础设置-组织-单位，删除单位");
        unitsPage.queryData();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
