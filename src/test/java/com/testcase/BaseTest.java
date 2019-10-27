package com.testcase;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertTrue;

public class BaseTest {

    protected HashMap<String, Object> dataMap = new HashMap<String, Object>();
    @BeforeClass
    public static void beforeclassbase(){
        System.out.println("beforeclass Base");
    }

    @Test
    public void func1(){
        System.out.println("hello Base1");
        assertTrue(true);
    }

    @Test
    public void func2(){
        System.out.println("hello Base2");
        assertTrue(false);
    }

    @AfterClass
    public static void afterclassbase(){
        System.out.println("afterclass Base2");
    }
}
