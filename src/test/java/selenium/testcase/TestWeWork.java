package selenium.testcase;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import selenium.page.App;

import java.util.concurrent.TimeUnit;

/**
 * Created by xiaoyun on 2019/11/17.
 */
public class TestWeWork {
    public static App app;
    @BeforeClass
    public static void beforeAll(){
        app = new App();
        app.loginWithCookie();
    }
    @Test
    public void testStart(){
        String phone = "15050000001";
        app.toMemberAdd().add(phone, phone, phone); //跳转添加成员页面
//        assertThat();

    }


}
