package com.sunxx.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Created by sxx on 2018/7/20.
 */
public class SelenlumDriver {
    public static WebDriver webDriver;
    public static WebDriver initDriver(String brower){
        //获取当前项目路径
        String path=System.getProperty("user.dir");
        if(brower.equals("chrome")){
            System.setProperty("webdriver.chrome.driver",path+"/drivers/chromedriver.exe");
            webDriver=new ChromeDriver();
        }else if(brower.equals("ie")){
            System.setProperty("webdriver.ie.driver",path+"/drivers/IEDriverServer.exe");
            webDriver=new InternetExplorerDriver();
        }else if(brower.equals("firefox")){
            webDriver=new FirefoxDriver();
        }else{
            System.out.println("找不到浏览器");
        }
        return webDriver;
    }
}
