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
public class CreateUnits extends DriverBase {
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
    public void createUnits() throws Exception {
        Reporter.log("用例标题：基础设置-组织-单位，新增单位");
        unitsPage.gotoUnits("新建");
        unitsPage.create("单位","中国银行","徐汇区虹梅路888号","159684589631","www.baidu.com","007","备注备注");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
