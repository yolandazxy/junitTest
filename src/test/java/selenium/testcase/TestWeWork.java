package selenium.testcase;

import org.junit.AfterClass;
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

        String phone = "15050000001";
        app.toContact().delete(phone);
    }

    @Test
    public void add() {
        String phone = "15050000001";
        app.toMemberAdd().add(phone, phone, phone); //跳转添加成员页面并添加
//        assertThat();
    }

    @Test
    public void delete() {
        String phone = "12345678901";
        app.toMemberAdd().add(phone, phone, phone).delete(phone); //跳转添加成员页面

    }

    @Test
    public void deleteCurrentPage(){
        app.toContact().deleteCurrentPage();
    }

    @AfterClass
    public static void afterAll() throws InterruptedException {
        app.quit();
    }


}
