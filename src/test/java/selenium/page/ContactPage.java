package selenium.page;

import org.openqa.selenium.By;

/**
 * @author xiaoyun
 * @description
 * @date 2019/11/17
 */
public class ContactPage {
    public ContactPage add(String username, String id, String phone){
        App.driver.findElement(By.name("username")).sendKeys(username);
        App.driver.findElement(By.name("acctid")).sendKeys(id);
        App.driver.findElement(By.name("mobile")).sendKeys(phone);
        return this;

    }

    public ContactPage list(){
        return new ContactPage();

    }
}
