package com.zgy.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    WebDriver driver;

    @BeforeMethod
    public void beforeTest()throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","D:\\driver\\chromedriver.exe");
        System.setProperty("webdriver.chrome.bin","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        driver = new ChromeDriver();
        //System.setProperty("webdriver.gecko.driver","D:\\driver\\geckodriver.exe");
        //System.setProperty("webdriver.firefox.bin","D:\\Program Files\\Mozilla Firefox\\firefox.exe");
        //driver = new FirefoxDriver();
        //driver.manage().window().setPosition(new Point(100,50));
        driver.manage().deleteAllCookies();
        //与浏览器同步非常重要，必须等待浏览器加载完毕
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void loginTest()throws InterruptedException{
        /*
        1、百度首页
        2、登陆链接，点击
         */
        String url="https://www.baidu.com/";
        driver.get(url);

        String time = String.valueOf(System.currentTimeMillis()/100);
        //获取当前页面句柄
        String handle = driver.getWindowHandle();

        driver.findElement(By.linkText("登录")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"TANGRAM__PSP_10__footerULoginBtn\"]")).click();
        driver.findElement(By.id("TANGRAM__PSP_10__userName")).sendKeys(time);
        Thread.sleep(2000);
        driver.findElement(By.id("TANGRAM__PSP_10__password")).sendKeys("123456");
        Thread.sleep(2000);
        driver.findElement(By.id("TANGRAM__PSP_10__submit")).click();


    }
    @Test
    public void testLoginPan()throws InterruptedException{

        String url="http://pan.baidu.com/";
        driver.get(url);


        driver.findElement(By.id("TANGRAM__PSP_4__footerULoginBtn")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"TANGRAM__PSP_4__userName\"]")).sendKeys("18305155991");
        Thread.sleep(2000);
        driver.findElement(By.id("TANGRAM__PSP_4__password")).sendKeys("asdf1234");
        Thread.sleep(2000);
        driver.findElement(By.id("TANGRAM__PSP_4__submit")).click();
    }
    @Test
    public void close()throws InterruptedException{
        Thread.sleep(3000);
        driver.quit();
    }
}
