package com.sunxx.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.URL;

/**
 * Created by sxx on 2018/7/18.
 */
public class gridTest {
    @DataProvider(name="data1")
    public Object[][] dataInfo(){
        return new Object[][]{
                {"http://192.168.43.245:4444/wd/hub","chrome"},
                {"http://192.168.43.245:4444/wd/hub","firefox"}
        };
    }
    @Test(dataProvider = "data1")
    public  void test0(String url,String brower) throws Exception {
        DesiredCapabilities desiredCapabilities;
        if(brower.equals("chrome")){
            desiredCapabilities=DesiredCapabilities.chrome();
            desiredCapabilities.setCapability("chrome_binary","F:\\workspace\\drivers\\chromedriver.exe");
        }else if(brower.equals("firefox")){
            desiredCapabilities=DesiredCapabilities.firefox();
            desiredCapabilities.setCapability("firefox_binary","C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        }else{
            desiredCapabilities=DesiredCapabilities.internetExplorer();
        }
        WebDriver webDriver=new RemoteWebDriver(new URL(url),desiredCapabilities);
        webDriver.get("http://www.baidu.com");
        Thread.sleep(5000);
        webDriver.quit();
    }
    @Test
    public void test1() throws Exception {
        DesiredCapabilities desiredCapabilities=DesiredCapabilities.chrome();
        desiredCapabilities.setCapability("chrome_binary","F:\\workspace\\drivers\\chromedriver.exe");
        //DesiredCapabilities desiredCapabilities=DesiredCapabilities.firefox();
        //desiredCapabilities.setCapability("firefox_binary","C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        WebDriver webDriver=new RemoteWebDriver(new URL("http://192.168.43.245:4444/wd/hub"),desiredCapabilities);
        webDriver.get("http://www.baidu.com");
        Thread.sleep(5000);
        webDriver.quit();
    }

}
