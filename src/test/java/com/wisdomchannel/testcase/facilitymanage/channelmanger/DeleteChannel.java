package com.wisdomchannel.testcase.facilitymanage.channelmanger;




import com.wisdomchannel.page.ChannelmanagerPage;
import com.wisdomchannel.page.LoginPage;
import com.wisdomchannel.util.DriverBase;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;



public class DeleteChannel extends DriverBase {
    private ChannelmanagerPage cmPage;
    private LoginPage lgPage;

    @BeforeClass
    public void setUp() {

//        cmPage = (ChannelmanagerPage)getPage(ChannelmanagerPage.class);
        driverBase();
//        setDriver(driver);
        lgPage = new LoginPage(driver);
        cmPage=new ChannelmanagerPage(driver);
        lgPage.login("admin","admin");
//        Assert.assertEquals(lgPage.user(),"admin");
    }


    @Test
    public void deleteChannel() throws InterruptedException {
        Reporter.log("用例标题：设施管理-航道管理，删除航道");
        cmPage.channelManagement();
        cmPage.searchinput("航道");
        cmPage.searchbutton();
        Thread.sleep(1000);
        String name=driver.getText(ChannelmanagerPage.getElement.FIRSTLINENAME);
        driver.click(ChannelmanagerPage.getElement.FIRSTLINEDELETE);
        String str=driver.getText(ChannelmanagerPage.getElement.DELETEMASSAGE);
        Assert.assertEquals(str,"你确定要删除这条数据么？删除是不可恢复的");
        driver.click(ChannelmanagerPage.getElement.DELETEENSURE);
        cmPage.searchinput(name);
        cmPage.searchbutton();
        Thread.sleep(1000);
        String text=driver.getText(ChannelmanagerPage.getElement.NODATA);
        System.out.println(text);
        Assert.assertEquals(text,"暂无数据");

    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
