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
public class DeletePerson extends DriverBase {
    private LoginPage loginPage;
    private PersonPage personPage;
    @BeforeClass
    public void setUp() throws Exception {
        driverBase();
        loginPage=new LoginPage(driver);
        personPage=new PersonPage(driver);
        loginPage.login("admin","admin");
    }
    @Test
    public void deletePerson() throws Exception {
        Reporter.log("用例标题：基础设置-组织-人员，删除人员");
        personPage.delete();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
