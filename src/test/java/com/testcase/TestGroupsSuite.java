package com.testcase;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author xiaoyun
 * @description
 * @date 2019/10/16 8:21 PM
 */

@RunWith(Categories.class)
@Categories.IncludeCategory(FastGroup.class)
@Categories.ExcludeCategory(SlowGroup.class)
@Suite.SuiteClasses({
        TestGroup.class
})
public class TestGroupsSuite {
}
