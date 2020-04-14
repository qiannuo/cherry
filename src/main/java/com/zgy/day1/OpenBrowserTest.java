package com.zgy.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class OpenBrowserTest {

    WebDriver webDriver;

    @BeforeMethod
    public void openFF(){
        //默认安装才可以直接
        //webDriver = new FirefoxDriver();
        System.setProperty("webdriver.gecko.driver","D:\\driver\\geckodriver.exe");
        System.setProperty("webdriver.firefox.bin","D:\\Program Files\\Mozilla Firefox\\firefox.exe");
        webDriver = new FirefoxDriver();
        String url = "http://www.baidu.com";

        webDriver.get(url); // 打开指定的网站
    }
    @Test
    //不在默认安装目录
    public void openFF2(){
        List<WebElement> list = webDriver.findElements(By.xpath("//*[@id=\"u1\"]/a"));
        for(int i=0;i<list.size();i++){
            String text = list.get(i).getText();
            System.out.println(text);
        }


    }
    @Test
    public void openChrome()throws InterruptedException{

        System.setProperty("webdriver.chrome.driver","D:\\driver\\chromedriver.exe");
        System.setProperty("webdriver.chrome.bin","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        webDriver = new ChromeDriver();


        webDriver.get("http://www.baidu.com"); // 打开指定的网站

        String url = webDriver.getCurrentUrl();

        Assert.assertEquals(url,"https://www.baidu.com/");
        /*
        Dimension dimension = new Dimension(300,300);
        webDriver.manage().window().setSize(dimension);

        Thread.sleep(3000);

        //浏览器最大化
        webDriver.manage().window().maximize();
        //完全退出浏览器
        //webDriver.quit();

        //浏览器后退
        //webDriver.navigate().back();
        Thread.sleep(3000);
        //webDriver.navigate().forward();

        */
    }
    @AfterMethod
    public void closeBrowser(){
        webDriver.quit();
    }
}
