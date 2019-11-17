package selenium.testcase;

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
    public static String url = "https://work.weixin.qq.com/";
    @Test
    public void testStart(){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //隐式等待5s
        driver.get(url);
        driver.manage().window().maximize();
        driver.findElement(By.linkText("企业登录")).click();

        System.out.println(driver.manage().getCookies());

        driver.manage().addCookie(new Cookie("wwrtx.refid", "29052993011722381"));
        driver.manage().addCookie(new Cookie("wwrtx.sid", "AtSYchEUXUH08H_B6V_5V0TPEItKst8yRBg5gLzo2aN5DUGBOlOdxaaHxVjx9wJ1"));

        driver.navigate().refresh();
        App.driver=driver;

        App app = new App();
        String phone = "15050000001";
        app.toMemberAdd().add(phone, phone, phone); //跳转添加成员页面
//        assertThat();

    }


}
