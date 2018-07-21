package com.sunxx.testng;

import org.testng.annotations.Test;

/**
 * Created by sxx on 2018/7/20.
 */
public class TestUtil {
    final static LoggerController log=LoggerController.getLogger(TestUtil.class);
    @Test
    public void randNum(){
        String num=String.valueOf(ToolUtil.getNumRandom(2));
        ToolUtil.getNumRandom1(10,100);
        ToolUtil.getStringRandom(5);
    }
}
