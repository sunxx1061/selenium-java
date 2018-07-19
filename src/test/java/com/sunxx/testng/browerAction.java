package com.sunxx.testng;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

/**
 * Created by sxx on 2018/7/12.
 */
public class browerAction {
    WebDriver driver;
    @BeforeMethod
    public  void browerAction0() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","F:\\workspace\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();
    }
    @Test
    public  void browerAction1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","F:\\workspace\\drivers\\chromedriver.exe");
        WebDriver webDriver=new ChromeDriver();
        //打开一个页面,get方法会把页面整体出来后在往下走
        webDriver.get("http://jf.10086.cn");
        Thread.sleep(5000);
        //浏览器后退
        webDriver.navigate().back();
        Thread.sleep(5000);
        //浏览器前进
        webDriver.navigate().forward();
        Thread.sleep(5000);
        //浏览器刷新
        webDriver.navigate().refresh();
        Thread.sleep(5000);
        webDriver.quit();
    }
    @Test
    public  void browerAction2() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","F:\\workspace\\drivers\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        //实例化Dimension 设置窗口大小
        driver.manage().window().setSize(new Dimension(100, 100));
        Thread.sleep(5000);
        //窗口最大化
        driver.manage().window().maximize();
        Thread.sleep(5000);
        driver.quit();
    }
    @Test
    public  void browerAction3() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","F:\\workspace\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("http://jf.10086.cn");
        //获取当前网页的url
        String url=driver.getCurrentUrl();
        System.out.println(url);
        //获取网页的标题
        String title=driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(url,"http://jf.10086.cn/");
        Thread.sleep(5000);

    }
    @AfterMethod
    public  void close(){
        driver.quit();
    }
}
