package com.wisdomchannel.testcase.transportregular;
import com.wisdomchannel.page.TransportRegularPage;
import com.wisdomchannel.page.LoginPage;
import com.wisdomchannel.util.AssertionListener;
import com.wisdomchannel.util.DriverBase;
import org.testng.annotations.*;
/**
 * Created by xhm on 2017/6/30.
 */
@Listeners({AssertionListener.class})
public class QueryEntryNotice extends DriverBase {
    private LoginPage loginPage;
    private TransportRegularPage entryNoticePage;
    @BeforeClass
    public void setUp() throws Exception {
        driverBase();
        loginPage=new LoginPage(driver);
        entryNoticePage=new TransportRegularPage(driver);
        loginPage.login("admin","admin");
    }
    @Test
    public void queryEntry() throws Exception {
        entryNoticePage.searchData(true);
        entryNoticePage.searchData(false);
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
