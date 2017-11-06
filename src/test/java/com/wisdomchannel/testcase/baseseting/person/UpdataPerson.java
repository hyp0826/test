package com.wisdomchannel.testcase.baseseting.person;
import com.wisdomchannel.page.LoginPage;
import com.wisdomchannel.page.PersonPage;
import com.wisdomchannel.util.AssertionListener;
import com.wisdomchannel.util.DriverBase;
import org.testng.Reporter;
import org.testng.annotations.*;
/**
 * Created by xhm on 2017/6/30.
 */
@Listeners({AssertionListener.class})
public class UpdataPerson extends DriverBase {
    private LoginPage loginPage;
    private PersonPage personPage;
    @BeforeClass
    public void setUp() throws Exception {
        driverBase();
        loginPage=new LoginPage(driver);
        personPage=new PersonPage(driver);
        loginPage.login("admin","admin");
        personPage.gotoPerson("编辑");
    }

    @Test
    public void updataPerson() throws Exception {
        Reporter.log("用例标题：基础设置-组织-人员，编辑人员");
        personPage.create("user","name","","1",true,true);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
