package com.sunxx.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * Created by sxx on 2018/7/20.
 */
public class ToolUtil {
    final static LoggerController log= LoggerController.getLogger(ToolUtil.class);
    public static long getNumRandom(int length){
        //随机数乘以10^n次方
        //Math.random()随机生成[0.0,0.1]之间的随机数
        //Math.pow(double a, double b) a的b次方
        long num=0;
        num=(long)(Math.random()*Math.pow(10,length));
        log.info(String.valueOf(num));
        return num;
    }

    public static long getNumRandom1(int min,int max){
        //如输出一个10~100之间的随机数
        long num=0;
        Random random=new Random();
        //new Random().nextInt(2) 生成一个[0,2)之间的随机数
        num=random.nextInt(max-min+1)+min;
        log.info(String.valueOf(num));
        return num;
    }
    public static String getStringRandom(int length){
        String val="";
        Random random=new Random();
        for(int i = 0; i<length; i++){
            String charOrNum=random.nextInt(10)%2==0?"char":"num";
            if ("char".equals(charOrNum)){
                int temp=random.nextInt(10)%2==0?65:97;
                val+=(char)(random.nextInt(26)+temp);
            }else if ("num".equals(charOrNum)){
                val+=String.valueOf(random.nextInt(10));
            }
        }
        log.info(val);
        return val;
    }
    @Test
    public void test(){
        WebDriver webDriver=SelenlumDriver.initDriver("chrome");
        webDriver.get("http://www.baidu.com");
        MyAssert.assertEquals("1111","2222");
        webDriver.quit();

    }
    @Test
    public void testFindElement(){
        WebDriver webDriver=SelenlumDriver.initDriver("chrome");
        webDriver.get("http://www.baidu.com");
        webElementUtil.findElement(By.id("456"));
        webDriver.quit();

    }
}
