package com.zgy.day3;

import org.openqa.selenium.ImmutableCapabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class GridTest {

    private WebDriver driver;
    String nodeUrl = "http://localhost:4445/wd/hub";

    @BeforeTest(enabled = true)
    public void openChrome() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("browser.name","chrome");

        //RemoteWebDriver声明方式,将string类型的地址转换成URL类型的地址
        driver = new RemoteWebDriver(new URL(nodeUrl),options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("hello");
    }

    @BeforeTest(enabled = false)
    public void openFirefox() throws MalformedURLException {

        FirefoxOptions options = new FirefoxOptions();
        options.setCapability("browser.name","firefox");

        //RemoteWebDriver声明方式,将string类型的地址转换成URL类型的地址
        driver = new RemoteWebDriver(new URL(nodeUrl),options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



    }

    @DataProvider(name = "data4")
    public Object[][] test1(){
        return new Object[][]{
                {"firefox","http://192.168.0.106:6666"},
                {"chrome","http://192.168.0.106:8888"}
        };
    }
    @Test(dataProvider = "data4")
    public void testGrid3(String browser,String url) throws MalformedURLException{

        driver.get("http://www.baidu.com");
        System.out.println(driver.getTitle());

        if(browser.equals("firefox")){
            FirefoxOptions options = new FirefoxOptions();
            driver = new RemoteWebDriver(new URL(url+"/wd/hub"),options);
        }else if(browser.equals("chrome")){
            ChromeOptions options = new ChromeOptions();
            driver = new RemoteWebDriver(new URL(url+"/wd/hub"),options);
        }else{
            System.out.println("error");
        }

        driver.get("http://www.baidu.com");
        System.out.println(driver.getTitle());

    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("bye");
    }
    @AfterTest
    public void close() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

}
