package com.testcase;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest{
    @BeforeClass
    public static void beforeclasschlid(){
        System.out.println("beforeclass Child");
    }

    @Test
    public void func1(){
        System.out.println("hello Child1");
        assertTrue(true);
    }

    @Test
    public void func2(){
        System.out.println("hello Child2");
        assertTrue(false);
    }

    @AfterClass
    public static void afterclasschild() {
        System.out.println("afterclass Child2");
    }

    }
