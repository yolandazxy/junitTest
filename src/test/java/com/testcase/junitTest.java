package com.testcase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class junitTest {

    @BeforeClass
    public static void beforeclass(){
        System.out.println("beforeclass");
    }

    @Test
    public void func1(){
        System.out.println("hello");
        assertTrue(true);
    }

    @Test
    public void func2(){
        System.out.println("hello");
        assertTrue(false);
    }

    @AfterClass
    public static void afterclass(){
        System.out.println("afterclass");
    }
}
