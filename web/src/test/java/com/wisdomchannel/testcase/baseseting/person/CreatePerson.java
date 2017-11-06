package com.wisdomchannel.testcase.baseseting.person;
import com.wisdomchannel.page.LoginPage;
import com.wisdomchannel.page.PersonPage;
import com.wisdomchannel.page.PositionPage;
import com.wisdomchannel.util.AssertionListener;
import com.wisdomchannel.util.DriverBase;
import org.testng.Reporter;
import org.testng.annotations.*;
import static org.testng.Assert.assertEquals;
/**
 * Created by xhm on 2017/6/30.
 */
@Listeners({AssertionListener.class})
public class CreatePerson extends DriverBase {
    private LoginPage loginPage;
    private PersonPage personPage;
    @BeforeClass
    public void setUp() throws Exception {
        driverBase();
        loginPage=new LoginPage(driver);
        personPage=new PersonPage(driver);
        loginPage.login("admin","admin");
        personPage.gotoPerson("新建");
    }
    @DataProvider(name = "create")
    public Object[][] Users(){
        return new Object[][]{
                {"","","","",PersonPage.getElement.NOINPUT_USERNAME,"不能为空"},
                {"username","","","",PersonPage.getElement.NOINPUT_NAM,"不能为空"},
                {"username","name","","",PersonPage.getElement.NOINPUT_PWD,"不能为空"},
                {"username","name","111111","",PersonPage.getElement.NOSELECT_DEPARTMENT,"部门"}
        };
    }
    @Test(dataProvider = "create")
    public void averifyCreate(String userName,String name,String pwd,String department,String xpath,String assertStr) throws InterruptedException {
        personPage.create(userName,name,pwd,"",false,false);
        String str=driver.getText(xpath);
        assertEquals(str, assertStr);
    }
    @Test
    public void createPerson() throws Exception {
        Reporter.log("用例标题：基础设置-组织-人员，新建人员");
        personPage.create("user","name","111111","1",true,false);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
