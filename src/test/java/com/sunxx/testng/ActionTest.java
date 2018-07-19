package com.sunxx.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by sxx on 2018/7/17.
 */
public class ActionTest {
    WebDriver driver;
    @BeforeMethod
    public void test0(){
        System.setProperty("webdriver.chrome.driver","F:\\workspace\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test
    public void test1()  {
        driver.get("http://www.baidu.com");
        WebElement element=driver.findElement(By.xpath("//*[@id=\"su\"]"));
        Actions action=new Actions(driver);
        //action.contextClick(element).perform();
        action.moveToElement(element).perform();

    }
    @AfterMethod
    public void close()throws InterruptedException{
        Thread.sleep(3000);
        driver.quit();
    }
}
