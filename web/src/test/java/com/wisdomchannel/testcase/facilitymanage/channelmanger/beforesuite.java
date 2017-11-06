package com.wisdomchannel.testcase.facilitymanage.channelmanger;

import com.wisdomchannel.page.LoginPage;
import com.wisdomchannel.page.ChannelmanagerPage;
import com.wisdomchannel.util.DriverBase;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


/**
 * Created by huangyp on 2017/8/1.
 */
public class beforesuite extends DriverBase {
    private LoginPage lgPage;
    @BeforeSuite
    public void beforesuite() throws Exception {
        driverBase();
//        setDriver(driver);
        lgPage=new LoginPage(driver);
        lgPage.login("admin","admin");
        Assert.assertEquals(lgPage.user(),"admin");

    }

    @AfterSuite

    public void aftersuite(){
        System.out.println("退出driver");
        driver.quit();
    }
}
