package selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by xiaoyun on 2019/11/17.
 */
public class App {
    public static WebDriver driver;

    public ContactPage toContact(){
        return new ContactPage();
    }

    public ContactPage toMemberAdd(){
        //find click
        driver.findElement(By.linkText("添加成员")).click();
        return new ContactPage();
    }
}
