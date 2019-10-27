package com.testcase;

import org.hamcrest.Matcher;
import org.junit.Test;
import org.junit.experimental.categories.Category;


import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.*;

/**
 * @author xiaoyun
 * @description
 * @date 2019/10/16 8:13 PM
 */
public class TestGroup {

    @Category({FastGroup.class,SlowGroup.class})
    @Test
    public void testDemo1(){
        assertTrue(true);
//        assertThat("xxixi",
//                10,
//               equalTo(2));
    }



    @Category(SlowGroup.class)
    @Test
    public void testDemo2(){
        assertEquals("diff two value",10,10);
        //assertTrue(false);
    }

    @Category(FastGroup.class)
    @Test
    public void testDemo3(){
        assertThat("actual val close to 10",
                9.88,
                 anyOf(closeTo(10,0.1), equalTo(9.88)));
    }

    @Test
    public void testDemo4(){
        assertTrue(true);
    }


}
