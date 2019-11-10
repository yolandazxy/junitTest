package mock;

import mock.Division;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author xiaoyun
 * @description
 * @date 2019/10/27 2:18 PM
 */
public class DivisionTest {

    Division division = new Division();

    Division2 division2 = new Division2();

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

    @Test
    public void divid2(){
        assertThat(division2.divid2(100,10,5, division), equalTo(2));
        Division mockDivision = mock(Division.class);

        //when(mockDivision.divid(0,0)).thenReturn(11);
        when(mockDivision.divid(anyInt(),anyInt())).thenReturn(11);  //改为任意值

        //when(mockDivision.divid(2,1)).thenReturn(1);
        System.out.println(mockDivision.divid(2,1));//若不指定，所有mock的方法都会把返回设为0
        //mockDivision.divid(2,1);

        assertThat(division2.divid2(0,0,5, mockDivision),equalTo(0));
    }

    @Test
    public void divid3(){
        assertThat(division2.divid3(100,10,5),equalTo(2));
        Division2 mockDivision2 = mock(Division2.class);


        when(mockDivision2.divid3(anyInt(),anyInt(),anyInt())).thenCallRealMethod(); //divid3调用原来方法

        when(mockDivision2.divid(anyInt(),anyInt())).thenReturn(10);  //divid3内部调用的divid改为任意值
        assertThat(mockDivision2.divid3(0,0,5),equalTo(2));

        when(mockDivision2.divid(anyInt(),anyInt())).thenReturn(100);  //改为任意值
        assertThat(mockDivision2.divid3(0,0,5),equalTo(0));
    }
}
