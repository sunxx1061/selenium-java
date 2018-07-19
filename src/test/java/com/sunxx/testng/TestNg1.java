package com.sunxx.testng;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by sxx on 2018/7/11.
 */
public class TestNg1 {
    @BeforeTest
    public  void testinit(){
        System.out.println("这是testinit");
    }

    @Test
    public  void test1(){
        System.out.println("这是test1");
    }
    @BeforeMethod
    public  void testBeforeMethod(){
        System.out.println("这是testBeforeMethod");
    }
    @Test
    public  void test2(){
        System.out.println("这是test2");
    }
    @Test
    public  void test3(){
        Assert.assertEquals(1,2,"1!=2");
    }
}
