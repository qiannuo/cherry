package com.zgy.day2;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ActionsTest {

    WebDriver driver;

    @BeforeMethod
    public void beforeTest(){
        System.setProperty("webdriver.gecko.driver","D:\\driver\\geckodriver.exe");
        System.setProperty("webdriver.firefox.bin","D:\\Program Files\\Mozilla Firefox\\firefox.exe");
        driver = new FirefoxDriver();
        String url="http://www.baidu.com";
        driver.get(url);

    }
    @Test
    public void newsTest(){
        WebElement newsLink = driver.findElement(By.name("tj_trnews"));
        newsLink.click();
        String curUrl = driver.getCurrentUrl();
        Assert.assertEquals(curUrl,"http://news.baidu.com/");
    }
    //selenium__软件测试培训_免费领取试听课程
    @Test
    public void baiduTest()throws InterruptedException{
        //
        WebElement keys = driver.findElement(By.id("kw"));
        //
        keys.sendKeys("selenium");
        //
        WebElement baiduButton = driver.findElement(By.id("su"));
        baiduButton.click();
        Thread.sleep(3000);
        //
        String title = driver.getTitle();
        Assert.assertEquals(title,"selenium_百度搜索");

    }

    @Test
    public void clear()throws InterruptedException{
        WebElement keys = driver.findElement(By.id("kw"));
        //
        keys.sendKeys("selenium");

        Thread.sleep(3000);
        keys.clear();
    }
    /*
    获取搜索框文本,校验，清除，校验
     */
    @Test
    public void getText()throws InterruptedException{
        WebElement keys = driver.findElement(By.name("tj_trnews"));

        //getText获取标签中间的值，比如新闻
        Assert.assertEquals(keys.getText(),"新闻");

    }
    /*
    获取标签名
     */
    @Test
    public void getTagName(){
        WebElement id = driver.findElement(By.id("kw"));
        String tagName = id.getTagName();
        Assert.assertEquals(tagName,"input");
    }
    /*
    获取属性值
     */
    @Test
    public void getAttrName(){
        WebElement id = driver.findElement(By.id("su"));
        String attrValue = id.getAttribute("value");
        Assert.assertEquals(attrValue,"百度一下");
    }
    @Test
    public void loginTest(){
        driver.findElement(By.name("tj_login")).click();
        //driver.switchTo().;
    }
    /*
    截图百度首页
     */
    @Test
    public void shotTest(){

        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //导入jar包
        try{
            FileUtils.copyFile(file,new File("D:\\test1.png"));
        }catch(IOException e){
            e.printStackTrace();
        }

    }
    @AfterMethod
    public void close()throws InterruptedException{
        Thread.sleep(3000);
        driver.quit();
    }
}
