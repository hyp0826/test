package com.wisdomchannel.testcase.baseseting.position;

import com.wisdomchannel.page.LoginPage;
import com.wisdomchannel.page.PositionPage;
import com.wisdomchannel.util.AssertionListener;
import com.wisdomchannel.util.DriverBase;
import org.testng.Reporter;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

/**
 * Created by xhm on 2017/6/30.
 */
@Listeners({AssertionListener.class})
public class CreatePosition extends DriverBase {
    private static LoginPage loginPage;
    private static PositionPage positionPage;
    @BeforeClass
    public void setUp() throws Exception {
        driverBase();
        loginPage=new LoginPage(driver);
        positionPage=new PositionPage(driver);
        loginPage.login("admin","admin");
        positionPage.gotoPosition("新建");
    }
    @DataProvider(name = "createp")
    public Object[][] Users(){
        return new Object[][]{
                {"","","","",PositionPage.getElement.NOTINPUT_NAME,"不能为空"},
                {"岗位","","","",PositionPage.getElement.NOTINPUT_LEVEL,"不能为空"},
                {"岗位","1","","",PositionPage.getElement.NOTINPUT_TYPE,"请选择岗位类型"},
                {"岗位","1","部门岗位","",PositionPage.getElement.NOTSELECT_DEPARTMENT,"请选择部门"}
        };
    }
    @Test(dataProvider = "createp")
    public void averifyCreate(String positionName,String positionLevel,String positionType,String positionDepartment,String xpath,String assertStr) throws InterruptedException {
        positionPage.create(positionName,"",positionLevel,positionType,positionDepartment,false);
        String str=driver.getText(xpath);
        assertEquals(str, assertStr);
    }
    @Test
    public void createPosition() throws Exception {
        Reporter.log("用例标题：基础设置-组织-岗位，新增岗位");
        positionPage.create("岗位",loginPage.getRandom(100,1),loginPage.getRandom(10,1),"123","部门",true);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
