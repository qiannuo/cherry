package com.zgy.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class RegTest {

    WebDriver driver;

    @BeforeMethod
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver","D:\\driver\\chromedriver.exe");
        System.setProperty("webdriver.chrome.bin","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");

        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        //与浏览器同步非常重要，必须等待浏览器加载完毕
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void reg163Test()throws InterruptedException{
        String url = "https://mail.163.com/register/index.htm?from=163mail";
        driver.get(url);

        driver.findElement(By.className("username")).sendKeys("qianh921211");
        Thread.sleep(2000);
        driver.findElement(By.className("password")).sendKeys("940627love");
        Thread.sleep(2000);
        driver.findElement(By.className("phone")).sendKeys("15102130291");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[4]/span")).isEnabled();
        driver.findElement(By.className("j-register")).click();
    }
    @Test
    public void regTest2(){
        String url = "https://reg.mail.163.com/unireg/call.do?cmd=register.entrance";
        driver.get(url);
        //13位，手机号/100
        String time = (String.valueOf(System.currentTimeMillis()/100));

        driver.findElement(By.id("nameIpt")).sendKeys("qh"+time);
        driver.findElement(By.id("mainPwdIpt")).sendKeys("940627love");
        driver.findElement(By.id("mainCfmPwdIpt")).sendKeys("940627love");
        //验证码 验证码不正确
        driver.findElement(By.id("vcodeIpt")).sendKeys("123123");
        //手机号
        driver.findElement(By.id("mainMobileIpt")).sendKeys(time);
        //
        driver.findElement(By.id("mainAcceptIpt")).click();
        if(driver.findElement(By.id("mainAcceptIpt")).isSelected()){
            driver.findElement(By.className("btnReg")).click();

            String error = driver.findElement(By.xpath("//*[@id=\"m_vcode\"]/span")).getText();
            Assert.assertEquals(error,"  验证码不正确，请重新填写");
        }

    }
    public static void regPo(WebDriver driver,String name,String pwd,String conPwd,String vcode,String mobile){

    }
    @Test
    public void login163Test()throws InterruptedException{

        String url = "http://mail.163.com/";
        driver.get(url);


        driver.findElement(By.id("switchAccountLogin")).click();
        Thread.sleep(2000);
        driver.switchTo().frame(driver.findElement(By.name("email")));

        driver.findElement(By.name("email")).sendKeys("zgy940627");
        Thread.sleep(2000);
        driver.findElement(By.name("password")).sendKeys("asdf1234");
        Thread.sleep(2000);
        driver.findElement(By.id("dologin")).click();


    }
    @AfterMethod
    public void close(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }


}
