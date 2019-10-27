import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

/**
 * @author xiaoyun
 * @description
 * @date 2019/10/27 3:20 PM
 */
public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void divid(){
        assertThat(calculator.divid(10,5), equalTo(2));
    }

    @Test
    public void dividReturnWithZero(){
        assertThat(calculator.divid(1,2), equalTo(0));
    }

    @Test
    public void add(){
        assertThat(calculator.add(10,2), equalTo(12));
    }
}