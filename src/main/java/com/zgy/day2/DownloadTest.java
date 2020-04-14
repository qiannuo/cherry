package com.zgy.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class DownloadTest {

    WebDriver driver;
    FirefoxProfile profile;
    String url3;

    @BeforeTest
    public void beforeTest(){

        System.setProperty("webdriver.gecko.driver","D:\\driver\\geckodriver.exe");
        System.setProperty("webdriver.firefox.bin","D:\\Program Files\\Mozilla Firefox\\firefox.exe");

        //System.setProperty("webdriver.chrome.driver","D:\\driver\\chromedriver.exe");
        //System.setProperty("webdriver.chrome.bin","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        //driver = new ChromeDriver();
        String url = "https://www.baidu.com/";
        String url1 = "file:///D:/慕课-接口自动化资料/index.html";
        String url2 = "file:///D:/慕课-接口自动化资料/dragAndDrop.html";
        url3 = "http://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=%E5%B0%8F%E5%9B%BE%E7%89%87&step_word=&hs=0&pn=8&spn=0&di=2530&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&istype=0&ie=utf-8&oe=utf-8&in=&cl=2&lm=-1&st=undefined&cs=1904888260%2C4249439948&os=2418120026%2C343472461&simid=4217547141%2C546431136&adpicid=0&lpn=0&ln=1977&fr=&fmq=1476798824771_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=&height=&face=undefined&ist=&jit=&cg=&bdtype=0&oriquery=&objurl=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01b37157f8bdd7a84a0d304feeb9b2.gif&fromurl=ippr_z2C%24qAzdH3FAzdH3Fooo_z%26e3Bzv55s_z%26e3Bv54_z%26e3BvgAzdH3Fo56hAzdH3FZMT2aNzUxNzY%3D_z%26e3Bip4s&gsm=9&rpstart=0&rpnum=0&islist=&querylist=";

    }

    @Test
    public void downloadTest()throws Exception{
        profile = new FirefoxProfile();
        profile.setPreference("browser.download.dir","D:\\testing");
        //0表示桌面，1表示我的下载，2表示保存到指定路径
        profile.setPreference("browser.foldList",2);
        profile.setPreference("browser.download.userDownloadDir",true);
        //在开始下载时是否显示下载管理器
        profile.setPreference("browser.download.manager.showWhenStarting",false);
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/zip,text/plain,"+"application/vnd.ms-excel,text/csv,text/comma-separated-values,application/octet-stream," +
                "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,application/vnd." +
                "openxmlformats-officedocument.wordprocessingml.document");

        //driver = new FirefoxDriver(profile);
        driver.get(url3);

        driver.findElement(By.xpath("//*[@id=\"toolbar\"]/span[7]")).click();
        //
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_S);
        Thread.sleep(3000);
    }
    @AfterTest
    public void close(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
