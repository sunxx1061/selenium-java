package com.sunxx.testng;


//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

/**
 * Created by sxx on 2018/7/13.
 */
public class eventAction {
    WebDriver driver;
    @BeforeMethod
    public void test0(){
        System.setProperty("webdriver.chrome.driver","F:\\workspace\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();
    }
    @Test
    public void test1(){
        driver.get("http://www.baidu.com");
        WebElement el=driver.findElement(By.name("tj_trnews"));
        el.click();
        Assert.assertEquals("http://news.baidu.com/",driver.getCurrentUrl());
    }
    @Test
    public void test2() throws InterruptedException {
        driver.get("http://www.baidu.com");
        WebElement input=driver.findElement(By.id("kw"));
        input.sendKeys("00000");
        Thread.sleep(3000);
        input.clear();
        input.sendKeys("selenium");
        WebElement el=driver.findElement(By.id("su"));
        el.click();
        Thread.sleep(7000);
        String  title=driver.getTitle();
        Assert.assertEquals("selenium_百度搜索",title);
        System.out.println(el.getTagName()+"-------------");

    }
    @Test
    public void test3() throws InterruptedException {
        driver.get("http://www.baidu.com");
        WebElement input=driver.findElement(By.id("kw"));
        input.sendKeys("孙希希");
        System.out.println(input.getAttribute("value")+"-------------");
    }
    @Test
    public void test4() throws InterruptedException {
        driver.get("http://www.baidu.com");
        WebElement input=driver.findElement(By.id("su"));
        input.isDisplayed();
        System.out.println(input.isDisplayed()+"-------------");
    }
    @Test
    public void test5() throws InterruptedException {
        driver.get("http://www.baidu.com");
        WebElement input=driver.findElement(By.id("kw"));
        input.isEnabled();
        System.out.println(input.isEnabled()+"-------------");
    }
    @Test
    public void test6() throws Exception {
        driver.get("http://www.baidu.com");
        File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
       //FileUtils.copyFile(file,new File("F:\\测试\\测试进阶"));
    }
    @AfterMethod
    public void close(){
        driver.quit();
    }
}
