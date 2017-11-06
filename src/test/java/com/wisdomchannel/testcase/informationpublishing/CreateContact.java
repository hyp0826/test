package com.wisdomchannel.testcase.informationpublishing;
import com.wisdomchannel.page.ContactPage;
import com.wisdomchannel.page.LoginPage;
import com.wisdomchannel.util.AssertionListener;
import com.wisdomchannel.util.DriverBase;
import org.testng.Reporter;
import org.testng.annotations.*;
/**
 * Created by xhm on 2017/6/30.
 */
@Listeners({AssertionListener.class})
public class CreateContact extends DriverBase {
    private LoginPage loginPage;
    private ContactPage contactPage;
    @BeforeClass
    public void setUp() throws Exception {
        driverBase();
        loginPage=new LoginPage(driver);
        contactPage=new ContactPage(driver);
        loginPage.login("admin","admin");
    }

    @Test
    public void createContact() throws Exception {
        Reporter.log("信息发布：通讯录管理-添加联系人");
        contactPage.createContanct("联系人","18698768988","船舶",loginPage.getRandom(100000,999999),loginPage.getRandom(100000,999999),"类型",true);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
