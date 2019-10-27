package com.testcase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author xiaoyun
 * @description
 * @date 2019/10/16 9:19 PM
 */
@RunWith(Parameterized.class)
public class ParamTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {3, 3},
                {1, 2}
        });
    }

    @Parameterized.Parameter(0)
    public int actual;
    @Parameterized.Parameter(1)
    public int expection;

    @Test
    public void testDemo1(){
//        int actual = 9;
//        int expect = 10;
        assertThat("demo", actual, equalTo(expection));
    }


}
