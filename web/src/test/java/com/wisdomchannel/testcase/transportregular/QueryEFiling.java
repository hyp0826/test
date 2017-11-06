package com.wisdomchannel.testcase.transportregular;
import com.wisdomchannel.page.LoginPage;
import com.wisdomchannel.page.TransportRegularPage;
import com.wisdomchannel.util.AssertionListener;
import com.wisdomchannel.util.DriverBase;
import org.testng.annotations.*;
import java.util.Random;
/**
 * Created by xhm on 2017/6/30.
 */
@Listeners({AssertionListener.class})
public class QueryEFiling extends DriverBase {
    private LoginPage loginPage;
    private TransportRegularPage transportRegularPage;
    @BeforeClass
    public void setUp() throws Exception {
        driverBase();
        loginPage=new LoginPage(driver);
        transportRegularPage=new TransportRegularPage(driver);
        loginPage.login("admin","admin");
    }
    @Test
    public void queryFiling() throws Exception {
        transportRegularPage.queryFiling();
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
