package com.testcase;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
/**
 * @author xiaoyun
 * @description
 * @date 2019/10/21 11:20 PM
 */
@RunWith(JUnitParamsRunner.class)
public class TestDDRunner {
    @Test
    @Parameters({
            "17, false",
            "20, true"
    })
    public void testDemo(int age, boolean valid){
        assertThat(age>17,equalTo(valid));

    }
}
