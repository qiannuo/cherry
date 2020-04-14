package com.zgy.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class ActionsTest2 {

    WebDriver driver;

    @BeforeTest
    public void beforeTest(){

        //System.setProperty("webdriver.gecko.driver","D:\\driver\\geckodriver.exe");
        //System.setProperty("webdriver.firefox.bin","D:\\Program Files\\Mozilla Firefox\\firefox.exe");
        //driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver","D:\\driver\\chromedriver.exe");
        System.setProperty("webdriver.chrome.bin","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        driver = new ChromeDriver();
        String url = "https://www.baidu.com/";
        String url1 = "file:///D:/慕课-接口自动化资料/index.html";
        String url2 = "file:///D:/慕课-接口自动化资料/dragAndDrop.html";
        driver.get(url1);
    }

    @Test
    public void rightClickTest(){
        WebElement btnBaidu = driver.findElement(By.id("su"));
        Actions actions = new Actions(driver);
        //右键
        //actions.contextClick(btnBaidu).perform();
        //双击
        actions.doubleClick(btnBaidu).perform();
    }
    @Test
    public void moveTest()throws InterruptedException{
        WebElement element = driver.findElement(By.xpath("//*[@id=\"action\"]/input"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();

        Thread.sleep(3000);
        String hello = driver.findElement(By.xpath(".//*[text()='Hello World!']")).getText();
        Assert.assertEquals(hello,"Hello World!");
    }
    @Test
    public void dragTest()throws InterruptedException{
        WebElement element = driver.findElement(By.id("drag"));
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(element,500,500).perform();

        Thread.sleep(5000);
    }
    @Test
    public void dragTest2()throws InterruptedException{
        WebElement element = driver.findElement(By.id("drag"));
        WebElement element1 = driver.findElement(By.xpath("/html/body/h1"));
        Actions actions = new Actions(driver);
        //按住 拖过去 释放
        actions.clickAndHold(element).moveToElement(element1).release(element).perform();

        Thread.sleep(5000);
    }

    @Test
    public void moreSelTest()throws Exception{
        WebElement element = driver.findElement(By.id("selectWithMultipleEqualsMultiple"));
        List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"selectWithMultipleEqualsMultiple\"]/option"));

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL)
                //CONTROL 0默认选中
                //.click(list.get(0))
                .click(list.get(2))
                .keyUp(Keys.CONTROL)
                .perform();
        Thread.sleep(5000);
    }

    @Test
    public void robotTest()throws Exception{
        //robot使用，按住CTRL+S然后释放
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        int keyS = (int)new Character('S');
        System.out.println(keyS);
        //robot.keyPress(KeyEvent.VK_S);
        robot.keyPress(keyS);

        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_ENTER);

        //robot.keyRelease(KeyEvent.VK_CONTROL);
        //robot.keyRelease(KeyEvent.VK_S);
    }

    @Test
    public void uploadTest(){
        driver.findElement(By.id("load"))
                .sendKeys("C:\\Users\\karry\\Desktop\\1586246024(1).png");//图片详细地址
    }
    @AfterTest
    public void close()throws InterruptedException{
        Thread.sleep(3000);
        driver.close();
    }

}
