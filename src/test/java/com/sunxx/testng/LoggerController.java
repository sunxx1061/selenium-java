package com.sunxx.testng;

import net.bytebuddy.implementation.FieldAccessor;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;


/**
 * Created by sxx on 2018/7/20.
 */
public class LoggerController {
    private  static Logger logger=null;
    private  static LoggerController logg=null;
    public static LoggerController getLogger(Class<?> T){
        if (logger==null){
            Properties properties=new Properties();
            try {
                String path=System.getProperty("user.dir");
                String filePath=path+"/config/log4j.properties";
                InputStream inputStream=new FileInputStream(filePath);
                properties.load(inputStream);
            }catch (Exception e){
                System.out.println("读取配置文件错误");
            }
            PropertyConfigurator.configure(properties);
            logger=Logger.getLogger(T);
            logg=new LoggerController();
        }
        return  logg;
    }
    public static void info(String msg){
        logger.info(msg);
    }
    public static void warn(String msg){
        logger.warn(msg);
    }
    public static void error(String msg){
        logger.error(msg);
    }
   //调用  final static LoggerController log=LoggerController.getLogger(Actions.class);
}
