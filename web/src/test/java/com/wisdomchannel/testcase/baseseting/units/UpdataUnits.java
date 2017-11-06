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
public class UpdataUnits extends DriverBase {
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
    public void updataUnits() throws Exception {
        Reporter.log("用例标题：基础设置-组织-单位，编辑单位");
        unitsPage.gotoUnits("编辑");
        unitsPage.create("单位1","中国银行1","徐汇区虹梅路888号1","1596845896311","www.baidu.com1","0071","备注备注1");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
