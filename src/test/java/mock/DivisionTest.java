package mock;

import mock.Division;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

/**
 * @author xiaoyun
 * @description
 * @date 2019/10/27 2:18 PM
 */
public class DivisionTest {

    Division division = new Division();

    @Before
    public void setUp() throws Exception {
        Division division = new Division();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void divid(){
        assertThat(division.divid(10,5), equalTo(2));
    }

    @Test
    public void dividReturnWithZero(){
        assertThat(division.divid(1,2), equalTo(0));

    }

    @Test
    public void dividByZero(){
        assertThat(division.divid(100,0), equalTo(null));

    }
}
