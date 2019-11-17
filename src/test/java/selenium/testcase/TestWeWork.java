package selenium.testcase;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import selenium.page.App;

/**
 * Created by xiaoyun on 2019/11/17.
 */
public class TestWeWork {
    public static String url = "https://work.weixin.qq.com/";
    @Test
    public void testStart(){
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.findElement(By.linkText("企业登录")).click();

        System.out.println(driver.manage().getCookies());

        driver.manage().addCookie(new Cookie("wwrtx.refid", "29052993011722381"));
        driver.manage().addCookie(new Cookie("wwrtx.sid", "AtSYchEUXUH08H_B6V_5V4SiWqbFjRzhexgoo2fu1l3TZP3SvE0TWlI_3S-6iy4V"));

        driver.navigate().refresh();
        App.driver=driver;

        App app = new App();
        app.toMemberAdd().add(); //跳转添加成员页面
//        assertThat();

    }


}
