package com.zgy.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectTest {
    WebDriver driver;

    @BeforeMethod
    public void beforeTest(){
        System.setProperty("webdriver.gecko.driver","D:\\driver\\geckodriver.exe");
        System.setProperty("webdriver.firefox.bin","D:\\Program Files\\Mozilla Firefox\\firefox.exe");
        driver = new FirefoxDriver();
        String url="file:///D:/慕课-接口自动化资料/index.html";
        driver.get(url);
    }
    //下拉框处理，！！！以select开头
    @Test
    public void selTest()throws InterruptedException{
        //找到下拉框元素
        WebElement element = driver.findElement(By.id("moreSelect"));
        //操作元素
        Select select = new Select(element);

        select.selectByIndex(2);//从0开始
        Thread.sleep(3000);

        select.selectByValue("meizu");
        Thread.sleep(3000);

        select.selectByVisibleText("huawei");
        Thread.sleep(3000);


    }
    @Test
    public void testWindow()throws InterruptedException{
        driver.findElement(By.className("open")).click();
        Thread.sleep(3000);

        String handle1 = driver.getWindowHandle();
        //传入的是句柄值 handler,句柄值不固定

        //Set<String>
        for(String handle:driver.getWindowHandles()){
            if(handle1.equals(handle))
                continue;
            driver.switchTo().window(handle);
        }
        driver.findElement(By.className("open")).click();
    }
    @AfterMethod
    public void close()throws InterruptedException{
        Thread.sleep(3000);
        driver.quit();
    }
}
