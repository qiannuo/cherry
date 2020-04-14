package com.zgy.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;

public class DownloadTest2 {
    WebDriver driver;

    @BeforeTest
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver","D:\\driver\\chromedriver.exe");
        System.setProperty("webdriver.chrome.bin","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");

    }

    @Test
    public void test(){
        String downloadFilePath = "D:\\";

        HashMap<String,Object> chromePrefs = new HashMap<String,Object>();

        chromePrefs.put("profile.default_content_settings.popups",0);
        chromePrefs.put("download.default_directory",downloadFilePath);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs",chromePrefs);


        driver = new ChromeDriver(options);
        driver.get("https://www.baidu.com/s?ie=utf-8&f=3&rsv_bp=1&rsv_idx=1&tn=baidu&wd=notepad%2B%2B&rsv_t=eddbZI8%2BL4Ed1oFXeUn0GvTQryYUmRPwqZ0RHaHA0t%2FCrCynmdG4X0rGPAY&rsv_enter=1&rsv_dl=ih_0&rsv_sug3=1&rsv_sug1=1&rsv_sug7=001&rsv_sug2=1&rsp=0&rsv_sug9=es_2_1&inputT=1475&rsv_sug4=2232&rsv_sug=9");
        driver.findElement(By.xpath("//*[@id=\"2\"]/div[1]/div[2]/p[5]/a")).click();

    }
    @Test
    public void testJs(){
        driver = new ChromeDriver();
        driver.get("http://www.baidu.com");
        //把Java转换成JavaScriptExecutor类型
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //执行js
        js.executeScript("document.getElementById(\"kw\").setAttributes(\"value\")");


    }

    @AfterTest
    public void close(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
