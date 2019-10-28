package mock;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.*;

/**
 * @author xiaoyun
 * @description
 * @date 2019/10/27 4:06 PM
 * refer to: site.mockito.org
 */
public class MockTest {
    @Test
    public void testMockDemo(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(4);
        list.add(5);

        assertThat(list.size(), equalTo(5));
    }

    @Test
    public void testMockDemo2(){
        ArrayList<Integer> list = mock(ArrayList.class);
        list.add(4);
        list.add(5);
        when(list.size()).thenReturn(500);
        assertThat(list.size(), equalTo(500));
    }

    @Test
    public void testSpy(){
        ArrayList<Integer> list = mock(ArrayList.class);
        list.add(1);
        list.add(2);
        verify(list).add(2);
    }
}
