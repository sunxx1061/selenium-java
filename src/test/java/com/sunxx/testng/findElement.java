package com.sunxx.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by sxx on 2018/7/13.
 */
public class findElement {
    WebDriver driver;
    @BeforeMethod
    public void test0(){
        System.setProperty("webdriver.chrome.driver","F:\\workspace\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();
    }
    @Test
    public void test1(){
        driver.get("http://jf.10086.cn");
        WebElement elid=driver.findElement(By.id("wareName"));
        System.out.println("id"+elid);
        WebElement elname=driver.findElement(By.name("wareName"));
        System.out.println("name"+elname);
        WebElement elclassname=driver.findElement(By.className("ac_input"));
        System.out.println("className"+elclassname);
        WebElement ellinktext=driver.findElement(By.linkText("我能兑换"));
        System.out.println("a--linktext"+ellinktext);
        WebElement elpartialinktext=driver.findElement(By.partialLinkText("兑换"));
        System.out.println("a--artialinktext"+elpartialinktext);
        List<WebElement> list=driver.findElements(By.tagName("span"));
        System.out.println("tagName"+list.size());
        List<WebElement> list1=driver.findElements(By.xpath("html/body/div[2]/div/ul[2]/li"));
        for(WebElement el:list1){
            System.out.println(el.getText());
        }
        WebElement elcss=driver.findElement(By.cssSelector("#wareName"));
        System.out.println("xcss"+elcss);
    }
    @AfterMethod
    public void close(){
        driver.quit();
    }
}
