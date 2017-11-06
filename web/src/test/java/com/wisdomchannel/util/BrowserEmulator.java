package com.wisdomchannel.util;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.File;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
/**
 * Created by xhm on 2017/7/13.
 */
public class BrowserEmulator  {
    protected WebDriver browser;
    ChromeDriverService chromeServer;
    JavascriptExecutor javaScriptExecutor;
    int timeout = 10;

    public BrowserEmulator() {
        ChromeOptions options=new  ChromeOptions();
        options.addArguments("--headless","--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        browser=new ChromeDriver(options);
//        browser.manage().window().setSize(new Dimension(1920,1080));
        browser.get(String.format("%s/#/login",GlobalSettings.Host));
        browser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    /**
     * Analyzing targeting elements, and positioning elements
     *
     * @param xpath
     *            the element's
     */
    public WebElement getElement(String xpath) {

        if (xpath.contains("=>") == false) {
            Assert.fail("Positioning syntax errors, lack of '=>'.");
        }

        String by = xpath.split("=>")[0];
        String value = xpath.split("=>")[1];

        if (by.equals("id")) {
            WebElement element = browser.findElement(By.id(value));
            return element;
        } else if (by.equals("name")) {
            WebElement element = browser.findElement(By.name(value));
            return element;
        } else if (by.equals("class")) {
            WebElement element = browser.findElement(By.className(value));
            return element;
        } else if (by.equals("linkText")) {
            WebElement element = browser.findElement(By.linkText(value));
            return element;
        } else if (by.equals("xpath")) {
            WebElement element = browser.findElement(By.xpath(value));
            return element;
        } else if (by.equals("css")) {
            WebElement element = browser.findElement(By.cssSelector(value));
            return element;
        } else {
            Assert.fail("Please enter the correct targeting elements,'id','name','class','xpaht','css'.");
        }
        return null;

    }

    /**
     * Wait for an element within a certain amount of time
     *
     * @param xpath
     *            the element's xpath the second
     */
    public void waitElement(String xpath, int second) {

        if (xpath.contains("=>") == false) {
            Assert.fail("Positioning syntax errors, lack of '=>'.");
        }

        String by = xpath.split("=>")[0];
        String value = xpath.split("=>")[1];
        By findelement = null;

        if (by.equals("id")) {
            findelement = By.id(value);
        } else if (by.equals("name")) {
            findelement = By.name(value);
        } else if (by.equals("class")) {
            findelement = By.className(value);
        } else if (by.equals("linkText")) {
            findelement = By.linkText(value);
        } else if (by.equals("xpath")) {
            findelement = By.xpath(value);
        } else if (by.equals("css")) {
            findelement = By.cssSelector(value);
        } else {
            Assert.fail("Please enter the correct targeting elements,'id','name','class','xpaht','css'.");

        }
        new WebDriverWait(browser, second).until(ExpectedConditions
                .presenceOfElementLocated(findelement));

    }

    /**
     * Open the URL
     *
     * @param url
     */
    public void open(String url) {
        // pause(stepInterval);
        try {
            browser.get(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Set browser window wide and high.
     *
     * @param wide
     * @param high
     */
    public void setWindow(int wide, int high) {

        browser.manage().window().setSize(new Dimension(wide, high));
    }

    /**
     * Setting browser window is maximized
     *
     */
    public void maxWindow() {

        browser.manage().window().maximize();
    }

    /**
     * close the browser Simulates the user clicking the "close" button in the
     * title bar of a pop up
     */
    public void close() {
        browser.close();
    }

    /**
     * Quit the browser
     */
    public void quit() {
        browser.quit();
    }

    /**
     * Click the page element
     *
     * @param xpath
     *            the element's xpath
     */
    public void click(String xpath) {

        waitElement(xpath, timeout);
        WebElement element = getElement(xpath);
        try {
            element.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Type text at the page element<br>
     * Before typing, try to clear existed text
     *
     * @param xpath
     *            , the element's xpath
     * @param text
     *            , the input text
     */
    public void type(String xpath, String text) {


        if (!text.equals("")){
            waitElement(xpath, timeout);
            WebElement element = getElement(xpath);
            try {
                element.clear();
            } catch (Exception e) {
            e.printStackTrace();
            }
            try {
                element.sendKeys(text);
            } catch (Exception e) {
            e.printStackTrace();
            }
        }


    }
    public void typeSend(String xpath, String text) {

        waitElement(xpath, timeout);
        WebElement element = getElement(xpath);
        try {
            element.sendKeys(text);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    /**
     * Right click element.
     *
     * @param xpath
     *            the element's xpath
     */
    public void rightClick(String xpath) {
        waitElement(xpath, timeout);

        Actions action = new Actions(browser);
        WebElement element = getElement(xpath);

        action.contextClick(element).perform();
    }

    /**
     * click and hold element.
     *
     * @param xpath
     *            the element's xpath
     */
    public void clickAndHold(String xpath) {
        waitElement(xpath, timeout);

        Actions action = new Actions(browser);
        WebElement element = getElement(xpath);

        action.clickAndHold(element).perform();
    }

    /**
     * Drags an element a certain distance and then drops it.
     *
     * @param el_xpath
     *            , the element's xpath
     * @param ta_xpath
     *            , the element's xpath
     */
    public void dragAndDrop(String el_xpath, String ta_xpath) {
        waitElement(el_xpath, timeout);
        waitElement(ta_xpath, timeout);

        Actions action = new Actions(browser);
        WebElement el = getElement(el_xpath);
        WebElement ta = getElement(ta_xpath);

        action.dragAndDrop(el, ta).perform();
    }

    /**
     * Click the element by the link text.
     *
     * @param text
     *            , the element's link text
     */
    public void clickText(String text) {

        WebElement element = browser.findElement(By.partialLinkText(text));
        try {
            element.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //下拉选择框
    public void selectValue(String xpath, String value) {
        if (!value.equals("")){
            waitElement(xpath, timeout);

            WebElement element = getElement(xpath);
            Select sel = new Select(element);
            sel.selectByVisibleText(value);
        }
    }

    /**
     * Refresh the browser
     */
    public void refresh() {
        browser.navigate().refresh();
    }

    /**
     * Execute JavaScript scripts.
     */
    public void js(String js) {
        ((JavascriptExecutor) browser).executeScript(js);
    }

    //找到frame
    public void enterFrame(String xpath) {
        waitElement(xpath, timeout);
        WebElement element = getElement(xpath);
        browser.switchTo().frame(element);
    }

    //返回到顶层frame
    public void leaveFrame() {
        browser.switchTo().defaultContent();
    }
    /**
     * Open the new window and switch the handle to the newly opened window.
     *
     * @param xpath
     *            , the open windows element xpath
     */
    public void openOneWindow(String xpath) {
        waitElement(xpath, timeout);
        String sreach_handle = browser.getWindowHandle();
        WebElement element = getElement(xpath);
        try {
            element.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Set<String> handles = browser.getWindowHandles();
        for (String handle : handles) {
            if (handle.equals(sreach_handle) == false) {
                browser.switchTo().window(handle);
            }
        }
    }

    //获取元素的text
    public String getText(String xpath) {
        waitElement(xpath, timeout);
        WebElement element = getElement(xpath);
        return element.getText();
    }
    //获取当前页面的title
    public String getTitle() {
        return browser.getTitle();
    }
    //获取当前页面的URL
    public String getUrl() {
        return browser.getCurrentUrl();
    }
    //获取某个元素的值
    public String getAttribute(String xpath, String attribute) {
        WebElement element = getElement(xpath);
        String value = element.getAttribute(attribute);
        return value;
    }
    //点击输入框的确认按钮
    public void acceptAlert() {
        browser.switchTo().alert().accept();
    }
    //获取提示框的文本
    public String getAlertText(){
        return browser.switchTo().alert().getText();
    }
    //隐藏提示框
    public void dismissAlert() {
        browser.switchTo().alert().dismiss();
    }

    /**
     * 自动截图
     * */
    public void takeScreenShot() {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        String dateStr = sf.format(date);
        //上面几行代码的意思都是获取时间，并且格式化，用来作为图片的名称　　　　
        // 下面这个是获取当前运行的类名称和时间的组合一起命名图片
        String path = this.getClass().getSimpleName() + "_" + dateStr + ".png";//因为我们截图是需要用到driver的，所以这里需要获取driver，这个driver是获取的当前对象的driver
        takeScreenShot((TakesScreenshot) browser, path);
    }
    /**
     * 传入参数截图
     * */
    public void takeScreenShot(TakesScreenshot drivername, String path) {
        String currentPath ="/Users/xhm/Desktop/截图/"; // get current work
        File scrFile = drivername.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(currentPath + "\\" + path));
            System.out.println("截图成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }
    public void getActionsValue(String formXpath,String inputXpath,String valueXpath){
        click(formXpath);
        WebElement from_inpox =  getElement(inputXpath);
        Actions actions = new Actions( this.browser);
        actions.moveToElement(from_inpox).click().perform();
        click(valueXpath);
    }
    public List<WebElement> getElements(String xpath){
        if (xpath.contains("=>") == false) {
            Assert.fail("Positioning syntax errors, lack of '=>'.");
        }

        String by = xpath.split("=>")[0];
        String value = xpath.split("=>")[1];

        if (by.equals("id")) {
            List<WebElement> element = browser.findElements(By.id(value));
//            browser.findElements(By.id("123"));
            return  element;
        } else if (by.equals("name")) {
            List<WebElement> element = browser.findElements(By.name(value));
            return element;
        } else if (by.equals("class")) {
            List<WebElement> element = browser.findElements(By.className(value));
            return element;
        } else if (by.equals("linkText")) {
            List<WebElement> element = browser.findElements(By.linkText(value));
            return element;
        } else if (by.equals("xpath")) {
            List<WebElement> element = browser.findElements(By.xpath(value));
            return element;
        } else if (by.equals("css")) {
            List<WebElement> element = browser.findElements(By.cssSelector(value));
            return element;
        } else {
            Assert.fail("Please enter the correct targeting elements,'id','name','class','xpaht','css'.");
        }
        return null;
    }
    public void back(){
        browser.navigate().back();
    }
    public void scrollToElement(String xpath) {
        WebElement e = getElement(xpath);
//        log.info("scroll view element");
        JavascriptExecutor js = (JavascriptExecutor) browser;
        // roll down and keep the element to the center of browser
        js.executeScript("arguments[0].scrollIntoView(true);", e);
    }
    public void sendKeys(String xpath, Keys keys) {
            waitElement(xpath, timeout);
            WebElement element = getElement(xpath);
            try {
                element.sendKeys(keys);
            } catch (Exception e) {
            e.printStackTrace();
            }
    }
    public void clear(String xpath){
        waitElement(xpath, timeout);
        WebElement element = getElement(xpath);
        try {
            element.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void context_click(String xpath) {
        waitElement(xpath, timeout);

        Actions action = new Actions(browser);
        WebElement element = getElement(xpath);

        action.contextClick(element).perform();
    }
//    //刷新浏览器
//    public void refresh(){
//
//    }
    
    //移动鼠标到元素对应的坐标（a,b）
    public Actions movetoelement(String xpath,int a,int b){
        Actions action = new Actions(browser);
        action.moveToElement(getElement(xpath),a,b);
        return action;
    }
//    //方法1
//    public void setElementValue(WebElement element,String value){
//        element.sendKeys(Keys.chord(Keys.CONTROL, "a"), value);//method1
//    }
//
//    //方法2
//    public  void setElementValue(WebElement element,String value){
//        element.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),value);//method2
//    }
//
//    //方法3
//    public  void setElementValue(WebElement element,String value){
//        element.sendKeys(Keys.CONTROL + "a");//method3
//        element.sendKeys(value);//method3
//    }
//
//    //方法4
//    public  void setElementValue(WebElement element,String value){
//        element.click();
//        element.clear();
//        element.sendKeys(Keys.BACK_SPACE );
//        element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
//        element.sendKeys(Keys.DELETE);
//        element.sendKeys(value);
//        element.click();
//    }
}
