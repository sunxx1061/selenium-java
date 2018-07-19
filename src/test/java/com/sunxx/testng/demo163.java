package com.sunxx.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by sxx on 2018/7/17.
 */
public class demo163 {
    WebDriver driver;
    @BeforeMethod
    public void test0(){
        System.setProperty("webdriver.chrome.driver","F:\\workspace\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://mail.163.com/");
    }
    @Test
    public  void register163(){
        //点击去注册按钮
        driver.switchTo().frame("x-URS-iframe");//iframe的id或name的值
        WebElement grb=driver.findElement(By.id("changepage"));
        grb.click();
        //切换到新窗口
        String handle=driver.getWindowHandle();
        for(String handlenew:driver.getWindowHandles()){
            if(handlenew.equals(handle)){
                continue;
            }
            driver.switchTo().window(handlenew);
        }
        //开始填写注册信息
        String randnum=String.valueOf(System.currentTimeMillis());
        driver.findElement(By.id("nameIpt")).sendKeys(randnum);
        driver.findElement(By.id("mainPwdIpt")).sendKeys("123123");
        driver.findElement(By.id("mainCfmPwdIpt")).sendKeys("123123");
        driver.findElement(By.id("mainMobileIpt")).sendKeys(randnum.substring(0,11));
        driver.findElement(By.id("vcodeIpt")).sendKeys("abcd");
        //driver.findElement(By.id("sendMainAcodeStg")).click();
        driver.findElement(By.id("mainAcodeIpt")).sendKeys("4567");
        driver.findElement(By.id("mainRegA")).click();
        WebDriverWait webDriverWait=new WebDriverWait(driver,10);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("conflictTitle")));
        String name=driver.findElement(By.id("conflictTitle")).getText();
        Assert.assertEquals(name,"邮件地址必需以英文字母开头");
        WebDriverWait webDriver=new WebDriverWait(driver,10);
        webDriver.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"m_mainPwd\"]/span")));
        String pwd=driver.findElement(By.xpath("//*[@id=\"m_mainPwd\"]/span")).getText();
        Assert.assertEquals(pwd,"  密码过于简单，请尝试“字母+数字”的组合");
    }
    @Test
    public  void login163(){
        //点击登录按钮
        driver.switchTo().frame("x-URS-iframe");//iframe的id或name的值
        WebElement grb=driver.findElement(By.id("dologin"));
        grb.click();

        //开始填写登录信息
        String randnum=String.valueOf(System.currentTimeMillis()) ;
        driver.findElement(By.name("email")).sendKeys(randnum);
        driver.findElement(By.name("password")).sendKeys("123123");
        driver.findElement(By.id("dologin")).click();
        WebDriverWait webDriver=new WebDriverWait(driver,30);
        webDriver.until(ExpectedConditions.presenceOfElementLocated(By.className("ferrorhead")));
        String msg=driver.findElement(By.className("ferrorhead")).getText();
        Assert.assertEquals(msg,"帐号或密码错误");
    }
    @Test
    public void time(){
        System.out.println(System.currentTimeMillis());//1531797692564
    }
    @AfterMethod
    public void close()throws InterruptedException{
        driver.quit();
    }
}
