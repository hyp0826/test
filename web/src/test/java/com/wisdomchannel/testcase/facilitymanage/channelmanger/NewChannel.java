package com.wisdomchannel.testcase.facilitymanage.channelmanger;


import com.wisdomchannel.page.BasicSettingPage;
import com.wisdomchannel.page.ChannelmanagerPage;
import com.wisdomchannel.page.LoginPage;
import com.wisdomchannel.util.DriverBase;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.util.List;

import static com.wisdomchannel.page.ChannelmanagerPage.datetime;


public class NewChannel extends DriverBase {
    private ChannelmanagerPage cmPage;
    private String channelname;
    private LoginPage lgPage;

    @BeforeClass
    public void setUp() {
//        cmPage = (ChannelmanagerPage)getPage(ChannelmanagerPage.class);
//        lgPage=(LoginPage)getPage(LoginPage.class);
        driverBase();
//        setDriver(driver);
        lgPage = new LoginPage(driver);
        cmPage=new ChannelmanagerPage(driver);
        lgPage.login("admin","admin");
//        Assert.assertEquals(lgPage.user(),"admin");
    }

    @Test
    public void newChannel() throws InterruptedException {
        Reporter.log("用例标题：设施管理-航道管理，新增航道");
        cmPage.channelManagement();
        cmPage.addbutton();
        channelname=cmPage.newChannel("航道","四边形",lgPage.getRandom(100,0));
        Assert.assertEquals(driver.getText("class=>el-message__group"),"添加航道管理成功");
        Thread.sleep(2000);
        cmPage.searchChannel(channelname, ChannelmanagerPage.getElement.FIRSTLINENAME);
        Reporter.log("新增航道"+channelname+"成功！");
    }

    @Test(dependsOnMethods = { "newChannel" })
    public void editChannel() throws InterruptedException {
        Reporter.log("用例标题：设施管理-航道管理，编辑航道");
        driver.click(ChannelmanagerPage.getElement.FIRSTLINEEDIT);
        Thread.sleep(1000);
        channelname=cmPage.newChannel("航道",
            "三角形",
                lgPage.getRandom(100,0));
        Assert.assertEquals(driver.getText("class=>el-message__group"),"编辑航道管理成功");
        cmPage.searchChannel(channelname, ChannelmanagerPage.getElement.FIRSTLINENAME);
        Reporter.log("编辑航道"+channelname+"成功！");
    }






    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
