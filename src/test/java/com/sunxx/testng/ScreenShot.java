package com.sunxx.testng;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Augmenter;

import java.io.File;
import java.io.IOException;

/**
 * Created by sxx on 2018/7/20.
 */
public class ScreenShot extends SelenlumDriver{
    final static LoggerController logger=LoggerController.getLogger(ScreenShot.class);
    final  static String path=System.getProperty("user.dir")+"/error/";
    /**
     * 错误截图，通过日期命名的截图
     **/
    public static void screenShots() {
        WebDriver augmentedDriver = new Augmenter().augment(webDriver);
        File file = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
        //根据日期创建文件夹，CHECK_LOG_FORMAT = "yyyyMMdd";REPORT_CSV_FORMAT = "yyyyMMdd_HHmmss";
        MyFile myFile=new MyFile();
        String myPath=path+String.valueOf(System.currentTimeMillis());
        System.out.print(myPath);
        myFile.createFile1(myPath);
        try {
            //FileUtils.copyFile(file,new File("D:\\testing\\webdriver_demo\\aa.jpg"));
            //FileUtils.copyFile(file,new File("D:\\testing\\webdriver_demo\\"+DateFormat.format(DateFormat.CHECK_LOG_FORMAT)+".jpg"));
            String times= String.valueOf(System.currentTimeMillis());
            FileUtils.copyFile(file,new File(myPath + "/" +times+".jpg"));
            // FileUtils.copyFile(file,new File(myPath + "/" + DateFormat.format(DateFormat.REPORT_CSV_FORMAT) + ".png"));
        } catch (IOException e) {
            logger.error("截图失败！！");
            e.printStackTrace();
        }
    }
}
