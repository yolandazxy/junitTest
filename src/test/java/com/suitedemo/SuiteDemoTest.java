package com.suitedemo;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.testcase.junitTest;
import com.testcase.LoginTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        junitTest.class,
        LoginTest.class
})
public class SuiteDemoTest {
}
