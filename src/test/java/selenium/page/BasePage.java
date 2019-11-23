package selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author xiaoyun
 * @description
 * @date 2019/11/17
 */
public class BasePage {
    public static WebDriver driver;

    public WebElement findElement(By by){
        return driver.findElement(by);
    }

    public void waitClickable(By by, int timeout){
        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(by));
    }
    public void waitClickable(By by){
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(by));
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(by));

    }


    public void quit() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }
}
