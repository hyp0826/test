package com.wisdomchannel.testcase.login;
import com.wisdomchannel.page.LoginPage;
import com.wisdomchannel.util.DriverBase;
import org.testng.annotations.*;
import static org.testng.Assert.assertEquals;
/**
 * Created by xhm on 2017/6/30.
 */
public class Login extends DriverBase {
    private LoginPage loginPage;
    @BeforeClass
    public void setUp() throws Exception {
        driverBase();
        loginPage=new LoginPage(driver);
    }
    @DataProvider(name = "login")
    public Object[][] Users(){
        return new Object[][]{
                {"","","xpath=>//*[@id='app']/div/div[1]/div/div/form/div[1]/div/div[3]","请输入用户名"},
                {"test","","xpath=>//*[@id='app']/div/div[1]/div/div/form/div[2]/div/div[3]","请输入密码"},
                {"error","error","xpath=>html/body/*/div/p","该数据不存在。"}
        };
    }
    @Test(dataProvider = "login")
    public void averifyLogin(String username,String password,String xpath,String assertStr) throws InterruptedException {
        loginPage.login(username, password);
        Thread.sleep(1000);
        String str=driver.getText(xpath);
        assertEquals(str, assertStr);
    }
    @Test
    public void login() throws Exception {
        loginPage.login("admin","admin");
        Thread.sleep(3000);
        loginPage.loginOut();
//        String userName=loginPage.user();
//        assertEquals(userName,"admin");
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
