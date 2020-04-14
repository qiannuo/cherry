package com.zgy.day3;

import com.po.page.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    WebDriver driver;

    @BeforeMethod
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver","D:\\driver\\bin\\chromedriver.exe");
        System.setProperty("webdriver.chrome.bin","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");

        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        //与浏览器同步非常重要，必须等待浏览器加载完毕
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static void loginPo(WebDriver driver,String email,String pwd){

        driver.findElement(LoginPage.emailInput).sendKeys(email);
        driver.findElement(LoginPage.pwdInput).sendKeys(pwd);
        driver.findElement(LoginPage.loginButton).click();

    }

    @Test
    public void login163Test()throws InterruptedException{

        String url = "http://mail.163.com/";
        driver.get(url);


        driver.findElement(By.id("switchAccountLogin")).click();
        Thread.sleep(2000);
        //????????
        driver.switchTo().frame(driver.findElement(By.xpath("//div[@id=\"loginDiv\"]/iframe")));

        LoginTest.loginPo(driver,"zgy940627","asdf1234");
        //写信
        driver.findElement(By.xpath("//*[@id=\"_mail_component_19_19\"]/span[2]")).click();

        driver.findElement(By.className("nui-editableAddr-ipt")).sendKeys("zgy940627@163.com");
        //主题
        driver.findElement(By.xpath("//*[@aria-label=\"邮件主题输入框，请输入邮件主题\"]/input")).sendKeys("hi");
        //添加附件
        driver.findElement(By.xpath("//*[@title=\"一次可发送2000张照片，600首MP3，一部高清电影\"]/input")).sendKeys("C:\\Users\\karry\\Desktop\\1586246024(1).png");
        Thread.sleep(3000);
        //添加正文(输入文本）
        //先定位
        WebElement frame = driver.findElement(By.className("APP-editor-iframe"));
        driver.switchTo().frame(frame);
        driver.findElement(By.xpath("/html/body")).sendKeys("hello byekkkkkkkk" +
                "kkkkkkkkkkkkkkkkkkkkkkkkkkk");
        //发送
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//*[text()='发送']")).click();
        Boolean b = driver.findElement(By.xpath("//*[text()='发送成功']")).isDisplayed();
        Assert.assertTrue(b);

    }

    public void sendEmail(){
        LoginTest.loginPo();
    }
    @AfterMethod
    public void close(){
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
