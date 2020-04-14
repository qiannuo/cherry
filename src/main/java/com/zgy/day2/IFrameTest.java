package com.zgy.day2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class IFrameTest {

    WebDriver driver;

    @BeforeMethod
    public void beforeTest(){
        System.setProperty("webdriver.gecko.driver","D:\\driver\\geckodriver.exe");
        System.setProperty("webdriver.firefox.bin","D:\\Program Files\\Mozilla Firefox\\firefox.exe");
        driver = new FirefoxDriver();
    }

    @Test
    public void testIndex()throws InterruptedException{
        String url="file:///D:/慕课-接口自动化资料/index.html";
        driver.get(url);
        /*
        1.input
        String tagName = driver.findElement(By.id("user")).getTagName();
        Assert.assertEquals(tagName,"input");
         */


        /*
        2.链接
        String attValue = driver.findElement(By.id("su")).getAttribute("value");
        Assert.assertEquals(attValue,"百度一下");
         */
        // driver.findElement(By.linkText("登陆界面")).click();


        /*
        //3.单选框,从1开始
        Boolean b = driver.findElement(By.xpath("//*[@id=\"radio\"]/input[1]")).isSelected();
        Assert.assertTrue(b);
         */


        /*
        4.复选框
        List<WebElement> webElementList =  driver.findElements(By.xpath("//*[@id=\"checkbox\"]"));
        for(WebElement element:webElementList){

        }
         */
        /*
        警告框
         driver.findElement(By.className("alert")).click();
        Thread.sleep(2000);
        //控制器转交给alert弹窗
        Alert alert = driver.switchTo().alert();
        //相当于点击确定按钮
        alert.accept();
         */

        /*
        confirm提示
        driver.findElement(By.className("confirm")).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        //点击取消
        alert.dismiss();
        Thread.sleep(3000);
        alert.accept();
         */
        /*
        driver.findElement(By.className("prompt")).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        String textInfo = alert.getText();
        Assert.assertEquals(textInfo,"我是提示信息");
        alert.sendKeys("aaaaa");
        Thread.sleep(2000);
        alert.accept();
        Thread.sleep(2000);
        alert.accept();
        */




    }
    @Test
    public void testBadidu(){
        String url="http://www.baidu.com";
        driver.get(url);

        String attValue = driver.findElement(By.id("su")).getAttribute("type");
        Assert.assertEquals(attValue,"submit");
    }
    @Test
    public void testIFrame(){
        //
        String url="file:///D:/慕课-接口自动化资料/index.html";
        driver.get(url);

        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.linkText("baidu")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.switchTo().defaultContent();
        driver.findElement(By.linkText("登陆界面")).click();
    }
    @AfterMethod
    public void close()throws InterruptedException{
        Thread.sleep(3000);
        driver.quit();
    }

}
