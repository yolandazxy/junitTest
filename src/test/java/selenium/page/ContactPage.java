package selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * @author xiaoyun
 * @description
 * @date 2019/11/17
 */
public class ContactPage extends BasePage{

    public ContactPage add(String username, String id, String phone){
        findElement(By.name("username")).sendKeys(username);
        findElement(By.name("acctid")).sendKeys(id);
        findElement(By.name("mobile")).sendKeys(phone);
        findElement(By.linkText("保存")).click();
        return this;

    }

    public ContactPage delete(String keyword){
        findElement(By.id("memberSearchInput")).clear();
        findElement(By.id("memberSearchInput")).sendKeys(keyword);
        try{
            waitClickable(By.linkText("编辑"), 2);
        }catch (Exception e){
            System.out.println(e);
            System.out.println("not found");
            return this;
        }
        //new WebDriverWait(driver,5).until(ExpectedConditions.elementToBeClickable(By.linkText("删除")));
        //waitClickable(By.cssSelector(".js_del_member"), 5);
        //findElement(By.cssSelector(".js_del_member")).click();
        findElement(By.linkText("删除")).click();
        findElement(By.linkText("确认")).click();
        //findElement(By.id("memberSearchInput")).clear();
        return this;
    }

    public void list(){
    }
}
