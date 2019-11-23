package selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by xiaoyun on 2019/11/17.
 */
public class App extends BasePage{
    //public static WebDriver driver;
    //public static String url = "https://work.weixin.qq.com/";

    public App loginWithCookie(){
        String url = "https://work.weixin.qq.com/";
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); //隐式等待3s
        driver.get(url);
        driver.manage().window().maximize();
        driver.findElement(By.linkText("企业登录")).click();

        System.out.println(driver.manage().getCookies());

        driver.manage().addCookie(new Cookie("wwrtx.refid", "29052993011722381"));
        driver.manage().addCookie(new Cookie("wwrtx.sid", "AtSYchEUXUH08H_B6V_5VxRsgONopd8jb0B2H3AaI0H1EzleejkvxdAf0gQlWyZv"));

        driver.navigate().refresh();
        App.driver=driver;
        return this;

    }
    public ContactPage toContact(){
        findElement(By.linkText("通讯录")).click();
        return new ContactPage();
    }

    public ContactPage toMemberAdd(){
        //find click
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        findElement(By.linkText("添加成员")).click();
        return new ContactPage();
    }
}
