package com.wisdomchannel.testcase.baseseting.department;


import com.wisdomchannel.page.BasicSettingPage;
import com.wisdomchannel.page.LoginPage;
import com.wisdomchannel.page.ChannelmanagerPage;
import com.wisdomchannel.page.WharfPage;
import com.wisdomchannel.util.DriverBase;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;


public class NewDepartment extends DriverBase {
    private ChannelmanagerPage cmpg;
    private LoginPage lgPage;
    private WharfPage wfpg;
    private BasicSettingPage bspg;

    @BeforeClass
    public void setUp() {
        driverBase();
        lgPage = new LoginPage(driver);
        cmpg = new ChannelmanagerPage(driver);
        wfpg = new WharfPage(driver);
        bspg=new BasicSettingPage(driver);
        lgPage.login("admin", "admin");
//        Assert.assertEquals(lgPage.user(), "admin");
    }

    @Test
    public void NewDepartment() throws InterruptedException {
        Reporter.log("用例标题：基础设置-组织-部门，新增部门");
        bspg.todepartment();
        String name=bspg.newdepartment("部门",lgPage.getRandom(100,1),"胡轩","备注");
        Assert.assertEquals(driver.getText("class=>el-message__group"),"新增部门成功");
        String aa[]=cmpg.elements(BasicSettingPage.getElement.TREELIST);
        Assert.assertEquals(cmpg.useLoop(aa,name),true);

    }



    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
