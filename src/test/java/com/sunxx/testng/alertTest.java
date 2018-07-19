package com.sunxx.testng;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by sxx on 2018/7/16.
 */
public class alertTest {
    WebDriver driver;
    @BeforeMethod
    public void test0(){
        System.setProperty("webdriver.chrome.driver","F:\\workspace\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test
    public void test1() throws InterruptedException {
        driver.get("file:///F:/%E6%B5%8B%E8%AF%95/%E6%B5%8B%E8%AF%95%E8%BF%9B%E9%98%B6/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
        WebElement input=driver.findElement(By.xpath(".//*[@id='alert']/input"));
        input.click();
        Thread.sleep(3000);
        Alert alert=driver.switchTo().alert();
        Thread.sleep(3000);
        System.out.println(alert.getText());
        alert.accept();

    }
    @Test
    public void test2() throws InterruptedException {
        driver.get("file:///F:/%E6%B5%8B%E8%AF%95/%E6%B5%8B%E8%AF%95%E8%BF%9B%E9%98%B6/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
        WebElement input=driver.findElement(By.xpath(".//*[@id='confirm']/input"));
        input.click();
        Thread.sleep(3000);
        Alert alert=driver.switchTo().alert();
        Thread.sleep(3000);
        //alert.accept();
        alert.dismiss();
    }
    @Test
    public void test3() throws InterruptedException {
        driver.get("file:///F:/%E6%B5%8B%E8%AF%95/%E6%B5%8B%E8%AF%95%E8%BF%9B%E9%98%B6/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
        WebElement input=driver.findElement(By.xpath(".//*[@id='prompt']/input"));
        input.click();
        Thread.sleep(3000);
        Alert alert=driver.switchTo().alert();
        Thread.sleep(3000);
        alert.sendKeys("11111");
        Thread.sleep(7000);
        alert.accept();
        Thread.sleep(3000);
    }
    @Test
    public void test4() throws InterruptedException {
        driver.get("file:///F:/%E6%B5%8B%E8%AF%95/%E6%B5%8B%E8%AF%95%E8%BF%9B%E9%98%B6/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
        WebElement iframe=driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.linkText("baidu")).click();
        Thread.sleep(3000);
        driver.switchTo().defaultContent();
        Thread.sleep(3000);
        driver.findElement(By.linkText("登陆界面")).click();
        Thread.sleep(3000);
    }
    @Test
    public void test5() throws InterruptedException {
        driver.get("file:///F:/%E6%B5%8B%E8%AF%95/%E6%B5%8B%E8%AF%95%E8%BF%9B%E9%98%B6/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
        WebElement element=driver.findElement(By.tagName("select"));
        Select select=new Select(element);
        select.selectByIndex(0);
        Thread.sleep(3000);
        select.selectByValue("huawei");
        Thread.sleep(3000);
        select.selectByVisibleText("xiaomi");
        Thread.sleep(3000);
    }
    @Test
    public void test6() throws InterruptedException {
        driver.get("file:///F:/%E6%B5%8B%E8%AF%95/%E6%B5%8B%E8%AF%95%E8%BF%9B%E9%98%B6/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
        driver.findElement(By.linkText("Open new window")).click();
        String handle=driver.getWindowHandle();
        for(String hle : driver.getWindowHandles()){
            if(hle.equals(handle))
                continue;
            else
                driver.switchTo().window(hle);
        }
        Thread.sleep(3000);
        driver.findElement(By.linkText("baidu")).click();
        Thread.sleep(3000);
    }
    @Test
    public void test7() throws InterruptedException {
        driver.get("file:///F:/%E6%B5%8B%E8%AF%95/%E6%B5%8B%E8%AF%95%E8%BF%9B%E9%98%B6/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
        driver.findElement(By.xpath(".//*[@id='wait']/input")).click();
        Thread.sleep(3000);
    }
    @AfterMethod
    public void close(){
        driver.quit();
    }
}
