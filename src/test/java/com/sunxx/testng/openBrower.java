package com.sunxx.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * Created by sxx on 2018/7/12.
 */
public class openBrower {
    @Test
    public  void openBrower1(){
        System.setProperty("webdriver.chrome.driver","F:\\workspace\\drivers\\chromedriver.exe");
        WebDriver webDriver=new ChromeDriver();
    }
    @Test
    public  void closeBrower1(){
        System.setProperty("webdriver.chrome.driver","F:\\workspace\\drivers\\chromedriver.exe");
        WebDriver webDriver=new ChromeDriver();
        //webDriver.close();
        webDriver.quit();
    }

}
