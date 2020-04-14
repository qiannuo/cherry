package com.zgy.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FindElementTest {

    WebDriver driver;
    /*
    打开百度，定位搜索文本框
     */
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","D:\\driver\\bin\\chromedriver.exe");
        System.setProperty("webdriver.chrome.bin","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        driver = new ChromeDriver();
        String url = "https://www.baidu.com/";
        driver.get(url); // 打开指定的网站
    }
    @Test
    public void findEle(){

        System.out.println(driver.getTitle());
        //输入12306
        //driver.findElement(By.id("kw")).sendKeys("12306");

        //driver.findElement(By.xpath("//input[@type='submit']"));
         driver.findElement(By.xpath("//*[@id=\"kw\"]")).sendKeys("12306");

        //driver.findElement(By.name("wd")).sendKeys("12306");
        //driver.findElement(By.className("s_ipt")).sendKeys("12306");

        //List<WebElement> buttons = driver.findElements(By.tagName("百度一下"));
        //System.out.println(buttons.size());


       //Boolean res = driver.findElement(By.tagName("body")).getText().contains("Welcome");


    }
    @Test
    public void findEle1(){

        //driver.findElement(By.linkText("新闻")).click();//点击“新闻"链接
        driver.findElement(By.cssSelector("#lg > map > area"));//引用到复合样式的元素
    }

    @AfterMethod
    public void closeBrowser()throws Exception{
        //driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        Thread.sleep(8000);
        driver.quit();
    }

}
