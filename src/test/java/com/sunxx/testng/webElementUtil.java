package com.sunxx.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

/**
 * Created by sxx on 2018/7/20.
 */
public class webElementUtil extends  SelenlumDriver {
    public static WebElement findElement(By by){
        try {
            WebDriverWait webDriverWait=new WebDriverWait(webDriver,10);
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
        }catch (Exception e){
            System.out.println("查找元素"+by+"超时");
        }
        return webDriver.findElement(by);
    }
    public static List<WebElement> findElements(By by){
        try {
            WebDriverWait webDriverWait=new WebDriverWait(webDriver,10);
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
        }catch (Exception e){
            System.out.println("查找元素"+by+"超时");
        }
        return webDriver.findElements(by);
    }
    public static void click(By by){
        findElement(by).click();
    }
    public static void sendKeys(By by,String text){
        WebElement webElement= findElement(by);
        webElement.clear();
        webElement.sendKeys(text);
    }
    public static String getText(By by){
        return findElement(by).getText();
    }
    public static void getTexts(By by){
        List<WebElement> list=findElements(by);
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i).getText());
        }
    }
}
