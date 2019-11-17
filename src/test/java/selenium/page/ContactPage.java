package selenium.page;

import org.openqa.selenium.By;

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
        return this;

    }

    public ContactPage list(){
        return new ContactPage();

    }
}
